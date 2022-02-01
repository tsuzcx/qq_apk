package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfq
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzfq> CREATOR;
  public final int statusCode;
  public final zzay zzck;
  
  static
  {
    AppMethodBeat.i(101318);
    CREATOR = new zzfr();
    AppMethodBeat.o(101318);
  }
  
  public zzfq(int paramInt, zzay paramzzay)
  {
    this.statusCode = paramInt;
    this.zzck = paramzzay;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101317);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzck, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(101317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfq
 * JD-Core Version:    0.7.0.1
 */