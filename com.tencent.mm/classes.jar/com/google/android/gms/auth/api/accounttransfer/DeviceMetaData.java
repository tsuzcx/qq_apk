package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceMetaData
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DeviceMetaData> CREATOR;
  private boolean zzcc;
  private long zzcd;
  private final boolean zzce;
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(10650);
    CREATOR = new zzy();
    AppMethodBeat.o(10650);
  }
  
  DeviceMetaData(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.DeviceMetaData
 * JD-Core Version:    0.7.0.1
 */