package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzdk
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdk> CREATOR;
  public final int statusCode;
  public final zzah zzdq;
  
  static
  {
    AppMethodBeat.i(101195);
    CREATOR = new zzdl();
    AppMethodBeat.o(101195);
  }
  
  public zzdk(int paramInt, zzah paramzzah)
  {
    this.statusCode = paramInt;
    this.zzdq = paramzzah;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101194);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzdq, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(101194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdk
 * JD-Core Version:    0.7.0.1
 */