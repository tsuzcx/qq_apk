package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="ConditionalUserPropertyParcelCreator")
public final class zzed
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzed> CREATOR;
  @SafeParcelable.Field(id=6)
  public boolean active;
  @SafeParcelable.Field(id=5)
  public long creationTimestamp;
  @SafeParcelable.Field(id=3)
  public String origin;
  @SafeParcelable.Field(id=2)
  public String packageName;
  @SafeParcelable.Field(id=11)
  public long timeToLive;
  @SafeParcelable.Field(id=7)
  public String triggerEventName;
  @SafeParcelable.Field(id=9)
  public long triggerTimeout;
  @SafeParcelable.Field(id=4)
  public zzjx zzaep;
  @SafeParcelable.Field(id=8)
  public zzeu zzaeq;
  @SafeParcelable.Field(id=10)
  public zzeu zzaer;
  @SafeParcelable.Field(id=12)
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
  
  @SafeParcelable.Constructor
  zzed(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) zzjx paramzzjx, @SafeParcelable.Param(id=5) long paramLong1, @SafeParcelable.Param(id=6) boolean paramBoolean, @SafeParcelable.Param(id=7) String paramString3, @SafeParcelable.Param(id=8) zzeu paramzzeu1, @SafeParcelable.Param(id=9) long paramLong2, @SafeParcelable.Param(id=10) zzeu paramzzeu2, @SafeParcelable.Param(id=11) long paramLong3, @SafeParcelable.Param(id=12) zzeu paramzzeu3)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzed
 * JD-Core Version:    0.7.0.1
 */