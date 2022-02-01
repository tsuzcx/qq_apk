package com.tencent.map.lib.models;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum DownloadPriority
{
  private final int mValue;
  
  static
  {
    AppMethodBeat.i(180738);
    NONE = new DownloadPriority("NONE", 0, -1);
    HIGH = new DownloadPriority("HIGH", 1, 0);
    MIDDLE = new DownloadPriority("MIDDLE", 2, 1);
    LOW = new DownloadPriority("LOW", 3, 2);
    $VALUES = new DownloadPriority[] { NONE, HIGH, MIDDLE, LOW };
    AppMethodBeat.o(180738);
  }
  
  private DownloadPriority(int paramInt)
  {
    this.mValue = paramInt;
  }
  
  public static DownloadPriority get(int paramInt)
  {
    AppMethodBeat.i(180736);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      DownloadPriority localDownloadPriority = localObject[i];
      if (localDownloadPriority.mValue == paramInt)
      {
        AppMethodBeat.o(180736);
        return localDownloadPriority;
      }
      i += 1;
    }
    localObject = NONE;
    AppMethodBeat.o(180736);
    return localObject;
  }
  
  public static int getThreadPriority(int paramInt)
  {
    AppMethodBeat.i(180737);
    switch (1.a[get(paramInt).ordinal()])
    {
    default: 
      AppMethodBeat.o(180737);
      return 5;
    case 1: 
      AppMethodBeat.o(180737);
      return 10;
    case 2: 
      AppMethodBeat.o(180737);
      return 1;
    }
    AppMethodBeat.o(180737);
    return 5;
  }
  
  public final int getValue()
  {
    return this.mValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.lib.models.DownloadPriority
 * JD-Core Version:    0.7.0.1
 */