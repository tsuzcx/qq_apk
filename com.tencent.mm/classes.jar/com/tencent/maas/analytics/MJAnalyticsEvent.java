package com.tencent.maas.analytics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class MJAnalyticsEvent
{
  private final MJAnalyticsEventType eventType;
  private final ByteBuffer pbData;
  
  public MJAnalyticsEvent(MJAnalyticsEventType paramMJAnalyticsEventType, ByteBuffer paramByteBuffer)
  {
    this.eventType = paramMJAnalyticsEventType;
    this.pbData = paramByteBuffer;
  }
  
  public static MJAnalyticsEvent createFrom(int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(216960);
    paramByteBuffer = new MJAnalyticsEvent(MJAnalyticsEventType.fromInt(paramInt), paramByteBuffer);
    AppMethodBeat.o(216960);
    return paramByteBuffer;
  }
  
  public MJAnalyticsEventType getEventType()
  {
    return this.eventType;
  }
  
  public ByteBuffer getPBData()
  {
    return this.pbData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.analytics.MJAnalyticsEvent
 * JD-Core Version:    0.7.0.1
 */