package com.danikula.videocache.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TotalSizeLruDiskUsage
  extends LruDiskUsage
{
  private final long maxSize;
  
  public TotalSizeLruDiskUsage(long paramLong)
  {
    AppMethodBeat.i(183628);
    if (paramLong <= 0L)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Max size must be positive number!");
      AppMethodBeat.o(183628);
      throw localIllegalArgumentException;
    }
    this.maxSize = paramLong;
    AppMethodBeat.o(183628);
  }
  
  protected boolean accept(File paramFile, long paramLong, int paramInt)
  {
    return paramLong <= this.maxSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.file.TotalSizeLruDiskUsage
 * JD-Core Version:    0.7.0.1
 */