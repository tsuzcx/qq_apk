package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="WakeLockEventCreator")
public final class WakeLockEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR;
  @SafeParcelable.Field(getter="getTimeout", id=16)
  private final long mTimeout;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @SafeParcelable.Field(getter="getTimeMillis", id=2)
  private final long zzxv;
  @SafeParcelable.Field(getter="getEventType", id=11)
  private int zzxw;
  @SafeParcelable.Field(getter="getElapsedRealtime", id=8)
  private final long zzyd;
  private long zzyf;
  @SafeParcelable.Field(getter="getWakeLockName", id=4)
  private final String zzyq;
  @SafeParcelable.Field(getter="getSecondaryWakeLockName", id=10)
  private final String zzyr;
  @SafeParcelable.Field(getter="getCodePackage", id=17)
  private final String zzys;
  @SafeParcelable.Field(getter="getWakeLockType", id=5)
  private final int zzyt;
  @SafeParcelable.Field(getter="getCallingPackages", id=6)
  private final List<String> zzyu;
  @SafeParcelable.Field(getter="getEventKey", id=12)
  private final String zzyv;
  @SafeParcelable.Field(getter="getDeviceState", id=14)
  private int zzyw;
  @SafeParcelable.Field(getter="getHostPackage", id=13)
  private final String zzyx;
  @SafeParcelable.Field(getter="getBeginPowerPercentage", id=15)
  private final float zzyy;
  
  static
  {
    AppMethodBeat.i(5002);
    CREATOR = new WakeLockEventCreator();
    AppMethodBeat.o(5002);
  }
  
  @SafeParcelable.Constructor
  WakeLockEvent(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) long paramLong1, @SafeParcelable.Param(id=11) int paramInt2, @SafeParcelable.Param(id=4) String paramString1, @SafeParcelable.Param(id=5) int paramInt3, @SafeParcelable.Param(id=6) List<String> paramList, @SafeParcelable.Param(id=12) String paramString2, @SafeParcelable.Param(id=8) long paramLong2, @SafeParcelable.Param(id=14) int paramInt4, @SafeParcelable.Param(id=10) String paramString3, @SafeParcelable.Param(id=13) String paramString4, @SafeParcelable.Param(id=15) float paramFloat, @SafeParcelable.Param(id=16) long paramLong3, @SafeParcelable.Param(id=17) String paramString5)
  {
    this.zzal = paramInt1;
    this.zzxv = paramLong1;
    this.zzxw = paramInt2;
    this.zzyq = paramString1;
    this.zzyr = paramString3;
    this.zzys = paramString5;
    this.zzyt = paramInt3;
    this.zzyf = -1L;
    this.zzyu = paramList;
    this.zzyv = paramString2;
    this.zzyd = paramLong2;
    this.zzyw = paramInt4;
    this.zzyx = paramString4;
    this.zzyy = paramFloat;
    this.mTimeout = paramLong3;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this(2, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3, paramString5);
  }
  
  public WakeLockEvent(WakeLockEvent paramWakeLockEvent)
  {
    this(paramWakeLockEvent.zzal, paramWakeLockEvent.getTimeMillis(), paramWakeLockEvent.getEventType(), paramWakeLockEvent.getWakeLockName(), paramWakeLockEvent.getWakeLockType(), paramWakeLockEvent.getCallingPackages(), paramWakeLockEvent.getEventKey(), paramWakeLockEvent.getElapsedRealtime(), paramWakeLockEvent.getDeviceState(), paramWakeLockEvent.getSecondaryWakeLockName(), paramWakeLockEvent.getHostPackage(), paramWakeLockEvent.getBeginPowerPercentage(), paramWakeLockEvent.getTimeout(), paramWakeLockEvent.getCodePackage());
    AppMethodBeat.i(4996);
    AppMethodBeat.o(4996);
  }
  
  public static boolean checkEventType(StatsEvent paramStatsEvent)
  {
    AppMethodBeat.i(5000);
    if ((7 == paramStatsEvent.getEventType()) || (8 == paramStatsEvent.getEventType()) || (9 == paramStatsEvent.getEventType()) || (10 == paramStatsEvent.getEventType()) || (11 == paramStatsEvent.getEventType()) || (12 == paramStatsEvent.getEventType()))
    {
      AppMethodBeat.o(5000);
      return true;
    }
    AppMethodBeat.o(5000);
    return false;
  }
  
  public final StatsEvent ReconstructCloseEvent(StatsEvent paramStatsEvent)
  {
    AppMethodBeat.i(4997);
    if ((paramStatsEvent instanceof WakeLockEvent))
    {
      paramStatsEvent = (WakeLockEvent)paramStatsEvent;
      paramStatsEvent = new WakeLockEvent(paramStatsEvent).setEventType(getEventType()).setDurationMillis(getElapsedRealtime() - paramStatsEvent.getElapsedRealtime());
      AppMethodBeat.o(4997);
      return paramStatsEvent;
    }
    AppMethodBeat.o(4997);
    return paramStatsEvent;
  }
  
  public final float getBeginPowerPercentage()
  {
    return this.zzyy;
  }
  
  @Nullable
  public final List<String> getCallingPackages()
  {
    return this.zzyu;
  }
  
  public final String getCodePackage()
  {
    return this.zzys;
  }
  
  public final int getDeviceState()
  {
    return this.zzyw;
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
    return this.zzyv;
  }
  
  public final int getEventType()
  {
    return this.zzxw;
  }
  
  public final String getHostPackage()
  {
    return this.zzyx;
  }
  
  public final String getSecondaryWakeLockName()
  {
    return this.zzyr;
  }
  
  public final String getSpecificString()
  {
    AppMethodBeat.i(4999);
    String str5 = getWakeLockName();
    int i = getWakeLockType();
    String str1;
    int j;
    String str2;
    label44:
    String str3;
    label55:
    float f;
    if (getCallingPackages() == null)
    {
      str1 = "";
      j = getDeviceState();
      if (getSecondaryWakeLockName() != null) {
        break label230;
      }
      str2 = "";
      if (getHostPackage() != null) {
        break label239;
      }
      str3 = "";
      f = getBeginPowerPercentage();
      if (getCodePackage() != null) {
        break label248;
      }
    }
    label230:
    label239:
    label248:
    for (String str4 = "";; str4 = getCodePackage())
    {
      str1 = String.valueOf(str5).length() + 45 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + "\t" + str5 + "\t" + i + "\t" + str1 + "\t" + j + "\t" + str2 + "\t" + str3 + "\t" + f + "\t" + str4;
      AppMethodBeat.o(4999);
      return str1;
      str1 = TextUtils.join(",", getCallingPackages());
      break;
      str2 = getSecondaryWakeLockName();
      break label44;
      str3 = getHostPackage();
      break label55;
    }
  }
  
  public final long getTimeMillis()
  {
    return this.zzxv;
  }
  
  public final long getTimeout()
  {
    return this.mTimeout;
  }
  
  public final String getWakeLockName()
  {
    return this.zzyq;
  }
  
  public final int getWakeLockType()
  {
    return this.zzyt;
  }
  
  public final WakeLockEvent markTimeOut()
  {
    if (this.mTimeout != 0L) {
      this.zzyf = this.mTimeout;
    }
    if (7 == this.zzxw) {
      this.zzxw = 9;
    }
    while (10 != this.zzxw) {
      return this;
    }
    this.zzxw = 12;
    return this;
  }
  
  public final StatsEvent setDurationMillis(long paramLong)
  {
    this.zzyf = paramLong;
    return this;
  }
  
  public final StatsEvent setEventType(int paramInt)
  {
    this.zzxw = paramInt;
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4998);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeLong(paramParcel, 2, getTimeMillis());
    SafeParcelWriter.writeString(paramParcel, 4, getWakeLockName(), false);
    SafeParcelWriter.writeInt(paramParcel, 5, getWakeLockType());
    SafeParcelWriter.writeStringList(paramParcel, 6, getCallingPackages(), false);
    SafeParcelWriter.writeLong(paramParcel, 8, getElapsedRealtime());
    SafeParcelWriter.writeString(paramParcel, 10, getSecondaryWakeLockName(), false);
    SafeParcelWriter.writeInt(paramParcel, 11, getEventType());
    SafeParcelWriter.writeString(paramParcel, 12, getEventKey(), false);
    SafeParcelWriter.writeString(paramParcel, 13, getHostPackage(), false);
    SafeParcelWriter.writeInt(paramParcel, 14, getDeviceState());
    SafeParcelWriter.writeFloat(paramParcel, 15, getBeginPowerPercentage());
    SafeParcelWriter.writeLong(paramParcel, 16, getTimeout());
    SafeParcelWriter.writeString(paramParcel, 17, getCodePackage(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(4998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.stats.WakeLockEvent
 * JD-Core Version:    0.7.0.1
 */