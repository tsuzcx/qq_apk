package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzdt
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdt> CREATOR;
  private final int statusCode;
  private final boolean zzdt;
  private final boolean zzdu;
  
  static
  {
    AppMethodBeat.i(101208);
    CREATOR = new zzds();
    AppMethodBeat.o(101208);
  }
  
  public zzdt(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.statusCode = paramInt;
    this.zzdt = paramBoolean1;
    this.zzdu = paramBoolean2;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101207);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzdt);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzdu);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdt
 * JD-Core Version:    0.7.0.1
 */