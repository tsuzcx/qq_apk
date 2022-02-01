package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="DeviceMetaDataCreator")
public class DeviceMetaData
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DeviceMetaData> CREATOR;
  @SafeParcelable.Field(getter="isLockScreenSolved", id=2)
  private boolean zzcc;
  @SafeParcelable.Field(getter="getMinAgeOfLockScreen", id=3)
  private long zzcd;
  @SafeParcelable.Field(getter="isChallengeAllowed", id=4)
  private final boolean zzce;
  @SafeParcelable.VersionField(id=1)
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(10650);
    CREATOR = new zzy();
    AppMethodBeat.o(10650);
  }
  
  @SafeParcelable.Constructor
  DeviceMetaData(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) boolean paramBoolean1, @SafeParcelable.Param(id=3) long paramLong, @SafeParcelable.Param(id=4) boolean paramBoolean2)
  {
    this.zzy = paramInt;
    this.zzcc = paramBoolean1;
    this.zzcd = paramLong;
    this.zzce = paramBoolean2;
  }
  
  public long getMinAgeOfLockScreen()
  {
    return this.zzcd;
  }
  
  public boolean isChallengeAllowed()
  {
    return this.zzce;
  }
  
  public boolean isLockScreenSolved()
  {
    return this.zzcc;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10649);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    SafeParcelWriter.writeBoolean(paramParcel, 2, isLockScreenSolved());
    SafeParcelWriter.writeLong(paramParcel, 3, getMinAgeOfLockScreen());
    SafeParcelWriter.writeBoolean(paramParcel, 4, isChallengeAllowed());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(10649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.DeviceMetaData
 * JD-Core Version:    0.7.0.1
 */