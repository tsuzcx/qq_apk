package com.tencent.midas.comm.log.processor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Locale;

public class APLogWriter
{
  private FileChannel fileChannel = null;
  private MappedByteBuffer mappedByteBuffer = null;
  private RandomAccessFile randomAccessFile = null;
  
  public static APLogWriter create()
  {
    AppMethodBeat.i(254034);
    APLogWriter localAPLogWriter = new APLogWriter();
    localAPLogWriter.openLogFile();
    AppMethodBeat.o(254034);
    return localAPLogWriter;
  }
  
  private void openLogFile()
  {
    AppMethodBeat.i(254037);
    try
    {
      new StringBuilder("open log file: ").append(APLogFileInfo.fileName);
      this.randomAccessFile = new RandomAccessFile(APLogFileInfo.fileName, "rw");
      this.fileChannel = this.randomAccessFile.getChannel();
      AppMethodBeat.o(254037);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      AppMethodBeat.o(254037);
    }
  }
  
  private long refreshFileChannel(long paramLong)
  {
    AppMethodBeat.i(254040);
    try
    {
      l1 = this.fileChannel.size();
      long l3 = APLogFileUtil.maxLogFileSizeMB * 1024 * 1024;
      String.format(Locale.CHINA, "size to write: %d, channel size: %d, limit: %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Long.valueOf(l3) });
      long l2 = l1;
      if (paramLong + l1 - l3 > 0L)
      {
        APLogFileInfo.updateFileName();
        openLogFile();
        l2 = 0L;
      }
      AppMethodBeat.o(254040);
      return l2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        APLogFileInfo.updateFileName();
        openLogFile();
        long l1 = 0L;
      }
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(254043);
    try
    {
      if (this.fileChannel != null) {
        this.fileChannel.close();
      }
      if (this.randomAccessFile != null) {
        this.randomAccessFile.close();
      }
      if (this.mappedByteBuffer != null)
      {
        this.mappedByteBuffer.force();
        this.mappedByteBuffer.clear();
      }
      AppMethodBeat.o(254043);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(254043);
    }
  }
  
  public void flush()
  {
    AppMethodBeat.i(254042);
    if (this.mappedByteBuffer != null) {
      this.mappedByteBuffer.force();
    }
    AppMethodBeat.o(254042);
  }
  
  public void write(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(254039);
    try
    {
      long l2 = refreshFileChannel(paramArrayOfByte1.length);
      long l1 = System.currentTimeMillis();
      this.mappedByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_WRITE, l2, paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length);
      l2 = System.currentTimeMillis();
      long l3 = System.currentTimeMillis();
      this.mappedByteBuffer.put(paramArrayOfByte2);
      this.mappedByteBuffer.put(paramArrayOfByte1);
      this.mappedByteBuffer.put(paramArrayOfByte3);
      this.mappedByteBuffer.force();
      long l4 = System.currentTimeMillis();
      new StringBuilder("write map time: ").append(l2 - l1).append(", sync time: ").append(l4 - l3);
      APLogFileUtil.deleteOldFileToday(APLogFileInfo.dirName);
      AppMethodBeat.o(254039);
      return;
    }
    catch (Throwable paramArrayOfByte1)
    {
      String.format(Locale.CHINA, "cache log to file error: <%s>%s", new Object[] { paramArrayOfByte1.getClass().getName(), paramArrayOfByte1.getMessage() });
      AppMethodBeat.o(254039);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.comm.log.processor.APLogWriter
 * JD-Core Version:    0.7.0.1
 */