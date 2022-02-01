package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="ConnectionEventCreator")
public final class ConnectionEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<ConnectionEvent> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @SafeParcelable.Field(getter="getTimeMillis", id=2)
  private final long zzxv;
  @SafeParcelable.Field(getter="getEventType", id=12)
  private int zzxw;
  @SafeParcelable.Field(getter="getCallingProcess", id=4)
  private final String zzxx;
  @SafeParcelable.Field(getter="getCallingService", id=5)
  private final String zzxy;
  @SafeParcelable.Field(getter="getTargetProcess", id=6)
  private final String zzxz;
  @SafeParcelable.Field(getter="getTargetService", id=7)
  private final String zzya;
  @SafeParcelable.Field(getter="getStackTrace", id=8)
  private final String zzyb;
  @SafeParcelable.Field(getter="getEventKey", id=13)
  private final String zzyc;
  @SafeParcelable.Field(getter="getElapsedRealtime", id=10)
  private final long zzyd;
  @SafeParcelable.Field(getter="getHeapAlloc", id=11)
  private final long zzye;
  private long zzyf;
  
  static
  {
    AppMethodBeat.i(4971);
    CREATOR = new ConnectionEventCreator();
    AppMethodBeat.o(4971);
  }
  
  @SafeParcelable.Constructor
  ConnectionEvent(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) long paramLong1, @SafeParcelable.Param(id=12) int paramInt2, @SafeParcelable.Param(id=4) String paramString1, @SafeParcelable.Param(id=5) String paramString2, @SafeParcelable.Param(id=6) String paramString3, @SafeParcelable.Param(id=7) String paramString4, @SafeParcelable.Param(id=8) String paramString5, @SafeParcelable.Param(id=13) String paramString6, @SafeParcelable.Param(id=10) long paramLong2, @SafeParcelable.Param(id=11) long paramLong3)
  {
    this.zzal = paramInt1;
    this.zzxv = paramLong1;
    this.zzxw = paramInt2;
    this.zzxx = paramString1;
    this.zzxy = paramString2;
    this.zzxz = paramString3;
    this.zzya = paramString4;
    this.zzyf = -1L;
    this.zzyb = paramString5;
    this.zzyc = paramString6;
    this.zzyd = paramLong2;
    this.zzye = paramLong3;
  }
  
  public ConnectionEvent(long paramLong1, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this(1, paramLong1, paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong2, paramLong3);
  }
  
  public ConnectionEvent(ConnectionEvent paramConnectionEvent)
  {
    this(paramConnectionEvent.zzal, paramConnectionEvent.getTimeMillis(), paramConnectionEvent.getEventType(), paramConnectionEvent.getCallingProcess(), paramConnectionEvent.getCallingService(), paramConnectionEvent.getTargetProcess(), paramConnectionEvent.getTargetService(), paramConnectionEvent.getStackTrace(), paramConnectionEvent.getEventKey(), paramConnectionEvent.getElapsedRealtime(), paramConnectionEvent.getHeapAlloc());
    AppMethodBeat.i(4963);
    AppMethodBeat.o(4963);
  }
  
  public static boolean checkEventType(StatsEvent paramStatsEvent)
  {
    AppMethodBeat.i(4967);
    if ((2 == paramStatsEvent.getEventType()) || (3 == paramStatsEvent.getEventType()) || (4 == paramStatsEvent.getEventType()) || (1 == paramStatsEvent.getEventType()) || (6 == paramStatsEvent.getEventType()) || (13 == paramStatsEvent.getEventType()) || (14 == paramStatsEvent.getEventType()) || (15 == paramStatsEvent.getEventType()))
    {
      AppMethodBeat.o(4967);
      return true;
    }
    AppMethodBeat.o(4967);
    return false;
  }
  
  public final StatsEvent ReconstructCloseEvent(StatsEvent paramStatsEvent)
  {
    AppMethodBeat.i(4964);
    if ((paramStatsEvent instanceof ConnectionEvent))
    {
      paramStatsEvent = (ConnectionEvent)paramStatsEvent;
      paramStatsEvent = (ConnectionEvent)((ConnectionEvent)new ConnectionEvent(paramStatsEvent).setEventType(getEventType())).setDurationMillis(getElapsedRealtime() - paramStatsEvent.getElapsedRealtime());
      AppMethodBeat.o(4964);
      return paramStatsEvent;
    }
    AppMethodBeat.o(4964);
    return paramStatsEvent;
  }
  
  public final String getCallingProcess()
  {
    return this.zzxx;
  }
  
  public final String getCallingService()
  {
    return this.zzxy;
  }
  
  public final long getDurationMillis()
  {
    return this.zzyf;
  }
  
  public final long getElapsedRealtime()
  {
    return this.zzyd;
  }
  
  public final String getEventKey()
  {
    return this.zzyc;
  }
  
  public final int getEventType()
  {
    return this.zzxw;
  }
  
  public final long getHeapAlloc()
  {
    return this.zzye;
  }
  
  public final String getSpecificString()
  {
    AppMethodBeat.i(4966);
    String str2 = getCallingProcess();
    String str3 = getCallingService();
    String str4 = getTargetProcess();
    String str5 = getTargetService();
    if (this.zzyb == null) {}
    for (String str1 = "";; str1 = this.zzyb)
    {
      long l = getHeapAlloc();
      str1 = String.valueOf(str2).length() + 26 + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str1).length() + "\t" + str2 + "/" + str3 + "\t" + str4 + "/" + str5 + "\t" + str1 + "\t" + l;
      AppMethodBeat.o(4966);
      return str1;
    }
  }
  
  @Nullable
  public final String getStackTrace()
  {
    return this.zzyb;
  }
  
  public final String getTargetProcess()
  {
    return this.zzxz;
  }
  
  public final String getTargetService()
  {
    return this.zzya;
  }
  
  public final long getTimeMillis()
  {
    return this.zzxv;
  }
  
  public final long getTimeout()
  {
    return 0L;
  }
  
  public final ConnectionEvent markTimeOut()
  {
    this.zzxw = 6;
    return this;
  }
  
  public final ConnectionEvent setDurationMillis(long paramLong)
  {
    this.zzyf = paramLong;
    return this;
  }
  
  public final ConnectionEvent setEventType(int paramInt)
  {
    this.zzxw = paramInt;
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4965);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeLong(paramParcel, 2, getTimeMillis());
    SafeParcelWriter.writeString(paramParcel, 4, getCallingProcess(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getCallingService(), false);
    SafeParcelWriter.writeString(paramParcel, 6, getTargetProcess(), false);
    SafeParcelWriter.writeString(paramParcel, 7, getTargetService(), false);
    SafeParcelWriter.writeString(paramParcel, 8, getStackTrace(), false);
    SafeParcelWriter.writeLong(paramParcel, 10, getElapsedRealtime());
    SafeParcelWriter.writeLong(paramParcel, 11, getHeapAlloc());
    SafeParcelWriter.writeInt(paramParcel, 12, getEventType());
    SafeParcelWriter.writeString(paramParcel, 13, getEventKey(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(4965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.stats.ConnectionEvent
 * JD-Core Version:    0.7.0.1
 */