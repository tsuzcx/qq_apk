package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzed
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzed> CREATOR;
  public boolean active;
  public long creationTimestamp;
  public String origin;
  public String packageName;
  public long timeToLive;
  public String triggerEventName;
  public long triggerTimeout;
  public zzjx zzaep;
  public zzeu zzaeq;
  public zzeu zzaer;
  public zzeu zzaes;
  
  static
  {
    AppMethodBeat.i(1117);
    CREATOR = new zzee();
    AppMethodBeat.o(1117);
  }
  
  zzed(zzed paramzzed)
  {
    AppMethodBeat.i(1115);
    Preconditions.checkNotNull(paramzzed);
    this.packageName = paramzzed.packageName;
    this.origin = paramzzed.origin;
    this.zzaep = paramzzed.zzaep;
    this.creationTimestamp = paramzzed.creationTimestamp;
    this.active = paramzzed.active;
    this.triggerEventName = paramzzed.triggerEventName;
    this.zzaeq = paramzzed.zzaeq;
    this.triggerTimeout = paramzzed.triggerTimeout;
    this.zzaer = paramzzed.zzaer;
    this.timeToLive = paramzzed.timeToLive;
    this.zzaes = paramzzed.zzaes;
    AppMethodBeat.o(1115);
  }
  
  zzed(String paramString1, String paramString2, zzjx paramzzjx, long paramLong1, boolean paramBoolean, String paramString3, zzeu paramzzeu1, long paramLong2, zzeu paramzzeu2, long paramLong3, zzeu paramzzeu3)
  {
    this.packageName = paramString1;
    this.origin = paramString2;
    this.zzaep = paramzzjx;
    this.creationTimestamp = paramLong1;
    this.active = paramBoolean;
    this.triggerEventName = paramString3;
    this.zzaeq = paramzzeu1;
    this.triggerTimeout = paramLong2;
    this.zzaer = paramzzeu2;
    this.timeToLive = paramLong3;
    this.zzaes = paramzzeu3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(1116);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.origin, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzaep, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 5, this.creationTimestamp);
    SafeParcelWriter.writeBoolean(paramParcel, 6, this.active);
    SafeParcelWriter.writeString(paramParcel, 7, this.triggerEventName, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, this.zzaeq, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 9, this.triggerTimeout);
    SafeParcelWriter.writeParcelable(paramParcel, 10, this.zzaer, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 11, this.timeToLive);
    SafeParcelWriter.writeParcelable(paramParcel, 12, this.zzaes, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(1116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzed
 * JD-Core Version:    0.7.0.1
 */