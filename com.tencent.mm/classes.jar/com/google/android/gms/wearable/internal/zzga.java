package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzga
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzga> CREATOR;
  public final int statusCode;
  public final int zzeh;
  
  static
  {
    AppMethodBeat.i(101335);
    CREATOR = new zzgb();
    AppMethodBeat.o(101335);
  }
  
  public zzga(int paramInt1, int paramInt2)
  {
    this.statusCode = paramInt1;
    this.zzeh = paramInt2;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101334);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzeh);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzga
 * JD-Core Version:    0.7.0.1
 */