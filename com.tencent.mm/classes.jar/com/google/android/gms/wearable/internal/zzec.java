package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzec
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzec> CREATOR;
  public final int statusCode;
  public final zzdd zzdy;
  
  static
  {
    AppMethodBeat.i(101223);
    CREATOR = new zzed();
    AppMethodBeat.o(101223);
  }
  
  public zzec(int paramInt, zzdd paramzzdd)
  {
    this.statusCode = paramInt;
    this.zzdy = paramzzdd;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101222);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzdy, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(101222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzec
 * JD-Core Version:    0.7.0.1
 */