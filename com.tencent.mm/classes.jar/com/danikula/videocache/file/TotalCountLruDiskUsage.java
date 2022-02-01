package com.danikula.videocache.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TotalCountLruDiskUsage
  extends LruDiskUsage
{
  private final int maxCount;
  
  public TotalCountLruDiskUsage(int paramInt)
  {
    AppMethodBeat.i(215903);
    if (paramInt <= 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Max count must be positive number!");
      AppMethodBeat.o(215903);
      throw localIllegalArgumentException;
    }
    this.maxCount = paramInt;
    AppMethodBeat.o(215903);
  }
  
  protected boolean accept(File paramFile, long paramLong, int paramInt)
  {
    return paramInt <= this.maxCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.file.TotalCountLruDiskUsage
 * JD-Core Version:    0.7.0.1
 */