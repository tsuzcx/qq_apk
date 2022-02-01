package com.tencent.midas.comm.log.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.processor.APLogCompressor;
import com.tencent.midas.comm.log.processor.APLogEncryptor;
import com.tencent.midas.comm.log.processor.APLogWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Locale;

public class APLogAppender
{
  private static final int AUTO_FLUSH_INTERVAL = 15000;
  private static final int BUFFER_BLOCK_SIZE = 153600;
  private static final int POSITION_INIT = 12;
  private static boolean stopAutoFlush = false;
  private byte[] EMPTY_BUFFER;
  private String FLAG_BEGIN;
  private String FLAG_END;
  private final String SPACE;
  private final byte[] _bytes;
  private Thread autoFlushThread;
  private FileChannel fileChannel;
  private APLogCompressor mCompressor;
  private APLogEncryptor mEncryptor;
  private APLogWriter mWriter;
  private MappedByteBuffer mappedByteBuffer;
  private RandomAccessFile randomAccessFile;
  private volatile long seq;
  
  private APLogAppender()
  {
    AppMethodBeat.i(193410);
    this.mCompressor = null;
    this.mEncryptor = null;
    this.mWriter = null;
    this.randomAccessFile = null;
    this.fileChannel = null;
    this.mappedByteBuffer = null;
    this.autoFlushThread = null;
    this.seq = 12L;
    this._bytes = new byte[0];
    this.SPACE = " ";
    this.EMPTY_BUFFER = new byte[153600];
    this.FLAG_BEGIN = "============mmap cache begin===========\r\n";
    this.FLAG_END = "============mmap cache end=============\r\n";
    AppMethodBeat.o(193410);
  }
  
  private void checkAndFlushBuffer()
  {
    for (;;)
    {
      MappedByteBuffer localMappedByteBuffer;
      try
      {
        AppMethodBeat.i(193419);
      }
      finally {}
      try
      {
        localMappedByteBuffer = this.mappedByteBuffer;
        if (localMappedByteBuffer != null) {
          continue;
        }
        AppMethodBeat.o(193419);
      }
      catch (Throwable localThrowable)
      {
        String.format(Locale.CHINA, "check and flush buffer error: <%s>%s", new Object[] { localThrowable.getClass().getName(), localThrowable.getMessage() });
        AppMethodBeat.o(193419);
        continue;
      }
      return;
      int i = (int)this.mappedByteBuffer.getLong(0);
      if (i <= 12)
      {
        this.seq = 12L;
        AppMethodBeat.o(193419);
      }
      else
      {
        flushBuffer(i - 12);
        AppMethodBeat.o(193419);
      }
    }
  }
  
  private void createBufferProcessor()
  {
    AppMethodBeat.i(193414);
    if ((APLog.getLogInfo() != null) && (APLog.getLogInfo().isCompressLog())) {
      this.mCompressor = APLogCompressor.create();
    }
    if ((APLog.getLogInfo() != null) && (APLog.getLogInfo().isEncryptLog())) {
      this.mEncryptor = APLogEncryptor.create();
    }
    this.mWriter = APLogWriter.create();
    AppMethodBeat.o(193414);
  }
  
  private void flushBuffer(int paramInt)
  {
    AppMethodBeat.i(193420);
    if (this.mappedByteBuffer == null)
    {
      AppMethodBeat.o(193420);
      return;
    }
    int i = paramInt;
    if (paramInt > 153600) {
      i = 153600;
    }
    byte[] arrayOfByte1 = new byte[i];
    this.mappedByteBuffer.position(12);
    this.mappedByteBuffer.get(arrayOfByte1);
    byte[] arrayOfByte2 = process(this.FLAG_BEGIN);
    byte[] arrayOfByte3 = process(this.FLAG_END);
    this.mWriter.write(arrayOfByte1, arrayOfByte2, arrayOfByte3);
    this.mappedByteBuffer.position(12);
    this.mappedByteBuffer.put(this.EMPTY_BUFFER, 12, i);
    this.mappedByteBuffer.putLong(0, 0L);
    resetPosAndSeq();
    AppMethodBeat.o(193420);
  }
  
  private void initMmap()
  {
    AppMethodBeat.i(193413);
    if (this.mappedByteBuffer == null)
    {
      AppMethodBeat.o(193413);
      return;
    }
    checkAndFlushBuffer();
    this.mappedByteBuffer.putLong(0, 12L);
    this.mappedByteBuffer.putInt(8, 39);
    resetPosAndSeq();
    AppMethodBeat.o(193413);
  }
  
  public static APLogAppender open()
  {
    AppMethodBeat.i(193411);
    APLogAppender localAPLogAppender = new APLogAppender();
    localAPLogAppender.createBufferProcessor();
    localAPLogAppender.openMmapFile();
    localAPLogAppender.initMmap();
    localAPLogAppender.startAutoFlush();
    AppMethodBeat.o(193411);
    return localAPLogAppender;
  }
  
  private void openMmapFile()
  {
    AppMethodBeat.i(193412);
    try
    {
      this.randomAccessFile = new RandomAccessFile(APLogFileInfo.mmapName, "rw");
      this.fileChannel = this.randomAccessFile.getChannel();
      this.mappedByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, 153600L);
      AppMethodBeat.o(193412);
      return;
    }
    catch (Throwable localThrowable)
    {
      String.format(Locale.CHINA, "open log mmap file error: <%s>%s", new Object[] { localThrowable.getClass().getName(), localThrowable.getMessage() });
      AppMethodBeat.o(193412);
    }
  }
  
  private byte[] process(String paramString)
  {
    try
    {
      AppMethodBeat.i(193418);
      try
      {
        localObject = (System.currentTimeMillis() + " " + paramString).getBytes();
        paramString = (String)localObject;
        if (this.mCompressor != null) {
          paramString = this.mCompressor.compress((byte[])localObject);
        }
        localObject = paramString;
        if (this.mEncryptor != null) {
          localObject = this.mEncryptor.encrypt(paramString);
        }
        AppMethodBeat.o(193418);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          String.format(Locale.CHINA, "process log error: <%s>%s", new Object[] { paramString.getClass().getName(), paramString.getMessage() });
          Object localObject = this._bytes;
          AppMethodBeat.o(193418);
        }
      }
      return localObject;
    }
    finally {}
  }
  
  private void resetPosAndSeq()
  {
    AppMethodBeat.i(193421);
    if (this.mappedByteBuffer == null)
    {
      AppMethodBeat.o(193421);
      return;
    }
    this.seq = 12L;
    this.mappedByteBuffer.position(12);
    AppMethodBeat.o(193421);
  }
  
  private void startAutoFlush()
  {
    AppMethodBeat.i(193415);
    if ((APLog.getLogInfo() != null) && (APLog.getLogInfo().isAutoFlush()) && (this.autoFlushThread == null))
    {
      this.autoFlushThread = new Thread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(193409);
          try
          {
            for (;;)
            {
              Thread.sleep(15000L);
              label11:
              if (APLogAppender.stopAutoFlush) {
                break;
              }
              APLogAppender.this.flushAndWrite();
            }
            AppMethodBeat.o(193409);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            break label11;
          }
        }
      });
      this.autoFlushThread.start();
    }
    AppMethodBeat.o(193415);
  }
  
  private void stopAutoFlush()
  {
    stopAutoFlush = true;
  }
  
  public void append(String paramString)
  {
    AppMethodBeat.i(193416);
    try
    {
      updateMmap(process(paramString));
      AppMethodBeat.o(193416);
      return;
    }
    catch (Throwable paramString)
    {
      String.format(Locale.CHINA, "append log error: <%s> %s", new Object[] { paramString.getClass().getName(), paramString.getMessage() });
      AppMethodBeat.o(193416);
    }
  }
  
  public void flushAndWrite()
  {
    AppMethodBeat.i(193422);
    try
    {
      checkAndFlushBuffer();
      if (this.mWriter != null) {
        this.mWriter.flush();
      }
      AppMethodBeat.o(193422);
      return;
    }
    catch (Throwable localThrowable)
    {
      String.format(Locale.CHINA, "flush buffer and write error: <%s>%s", new Object[] { localThrowable.getClass().getName(), localThrowable.getMessage() });
      AppMethodBeat.o(193422);
    }
  }
  
  /* Error */
  public void updateMmap(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 312
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: arraylength
    //   10: istore_2
    //   11: aload_0
    //   12: getfield 71	com/tencent/midas/comm/log/internal/APLogAppender:seq	J
    //   15: lstore_3
    //   16: iload_2
    //   17: i2l
    //   18: lload_3
    //   19: ladd
    //   20: ldc2_w 313
    //   23: lcmp
    //   24: ifle +7 -> 31
    //   27: aload_0
    //   28: invokespecial 196	com/tencent/midas/comm/log/internal/APLogAppender:checkAndFlushBuffer	()V
    //   31: aload_0
    //   32: getfield 65	com/tencent/midas/comm/log/internal/APLogAppender:mappedByteBuffer	Ljava/nio/MappedByteBuffer;
    //   35: ifnonnull +12 -> 47
    //   38: ldc_w 312
    //   41: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 65	com/tencent/midas/comm/log/internal/APLogAppender:mappedByteBuffer	Ljava/nio/MappedByteBuffer;
    //   51: aload_1
    //   52: invokevirtual 316	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   55: pop
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 71	com/tencent/midas/comm/log/internal/APLogAppender:seq	J
    //   61: aload_1
    //   62: arraylength
    //   63: i2l
    //   64: ladd
    //   65: putfield 71	com/tencent/midas/comm/log/internal/APLogAppender:seq	J
    //   68: aload_0
    //   69: getfield 65	com/tencent/midas/comm/log/internal/APLogAppender:mappedByteBuffer	Ljava/nio/MappedByteBuffer;
    //   72: iconst_0
    //   73: aload_0
    //   74: getfield 71	com/tencent/midas/comm/log/internal/APLogAppender:seq	J
    //   77: invokevirtual 189	java/nio/MappedByteBuffer:putLong	(IJ)Ljava/nio/ByteBuffer;
    //   80: pop
    //   81: ldc_w 312
    //   84: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: goto -43 -> 44
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	APLogAppender
    //   0	95	1	paramArrayOfByte	byte[]
    //   10	7	2	i	int
    //   15	4	3	l	long
    // Exception table:
    //   from	to	target	type
    //   2	16	90	finally
    //   27	31	90	finally
    //   31	44	90	finally
    //   47	87	90	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.comm.log.internal.APLogAppender
 * JD-Core Version:    0.7.0.1
 */