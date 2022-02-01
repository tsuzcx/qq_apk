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
    AppMethodBeat.i(217248);
    APLogWriter localAPLogWriter = new APLogWriter();
    localAPLogWriter.openLogFile();
    AppMethodBeat.o(217248);
    return localAPLogWriter;
  }
  
  private void openLogFile()
  {
    AppMethodBeat.i(217256);
    try
    {
      new StringBuilder("open log file: ").append(APLogFileInfo.fileName);
      this.randomAccessFile = new RandomAccessFile(APLogFileInfo.fileName, "rw");
      this.fileChannel = this.randomAccessFile.getChannel();
      AppMethodBeat.o(217256);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      AppMethodBeat.o(217256);
    }
  }
  
  private long refreshFileChannel(long paramLong)
  {
    AppMethodBeat.i(217263);
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
      AppMethodBeat.o(217263);
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
    AppMethodBeat.i(217288);
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
      return;
    }
    finally
    {
      AppMethodBeat.o(217288);
    }
  }
  
  public void flush()
  {
    AppMethodBeat.i(217280);
    if (this.mappedByteBuffer != null) {
      this.mappedByteBuffer.force();
    }
    AppMethodBeat.o(217280);
  }
  
  public void write(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(217272);
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
      AppMethodBeat.o(217272);
      return;
    }
    finally
    {
      String.format(Locale.CHINA, "cache log to file error: <%s>%s", new Object[] { paramArrayOfByte1.getClass().getName(), paramArrayOfByte1.getMessage() });
      AppMethodBeat.o(217272);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.comm.log.processor.APLogWriter
 * JD-Core Version:    0.7.0.1
 */