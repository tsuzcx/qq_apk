package com.tencent.maas.analytics;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MJAnalyticsEventType
{
  private final int value;
  
  static
  {
    AppMethodBeat.i(216980);
    General = new MJAnalyticsEventType("General", 0, 0);
    Error = new MJAnalyticsEventType("Error", 1, 1);
    Preproc = new MJAnalyticsEventType("Preproc", 2, 2);
    Export = new MJAnalyticsEventType("Export", 3, 3);
    Playback = new MJAnalyticsEventType("Playback", 4, 4);
    Capture = new MJAnalyticsEventType("Capture", 5, 5);
    $VALUES = new MJAnalyticsEventType[] { General, Error, Preproc, Export, Playback, Capture };
    AppMethodBeat.o(216980);
  }
  
  private MJAnalyticsEventType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static MJAnalyticsEventType fromInt(int paramInt)
  {
    AppMethodBeat.i(216974);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      MJAnalyticsEventType localMJAnalyticsEventType = localObject[i];
      if (localMJAnalyticsEventType.getValue() == paramInt)
      {
        AppMethodBeat.o(216974);
        return localMJAnalyticsEventType;
      }
      i += 1;
    }
    localObject = General;
    AppMethodBeat.o(216974);
    return localObject;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.maas.analytics.MJAnalyticsEventType
 * JD-Core Version:    0.7.0.1
 */