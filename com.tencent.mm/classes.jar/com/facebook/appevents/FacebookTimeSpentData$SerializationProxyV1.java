package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

class FacebookTimeSpentData$SerializationProxyV1
  implements Serializable
{
  private static final long serialVersionUID = 6L;
  private final int interruptionCount;
  private final long lastResumeTime;
  private final long lastSuspendTime;
  private final long millisecondsSpentInSession;
  
  FacebookTimeSpentData$SerializationProxyV1(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    this.lastResumeTime = paramLong1;
    this.lastSuspendTime = paramLong2;
    this.millisecondsSpentInSession = paramLong3;
    this.interruptionCount = paramInt;
  }
  
  private Object readResolve()
  {
    AppMethodBeat.i(71988);
    FacebookTimeSpentData localFacebookTimeSpentData = new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, null);
    AppMethodBeat.o(71988);
    return localFacebookTimeSpentData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.appevents.FacebookTimeSpentData.SerializationProxyV1
 * JD-Core Version:    0.7.0.1
 */