package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzeg
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzeg> CREATOR;
  public final int statusCode;
  public final zzfo zzea;
  
  static
  {
    AppMethodBeat.i(101229);
    CREATOR = new zzeh();
    AppMethodBeat.o(101229);
  }
  
  public zzeg(int paramInt, zzfo paramzzfo)
  {
    this.statusCode = paramInt;
    this.zzea = paramzzfo;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101228);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzea, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(101228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzeg
 * JD-Core Version:    0.7.0.1
 */