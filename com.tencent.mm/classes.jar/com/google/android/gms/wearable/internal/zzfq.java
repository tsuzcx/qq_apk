package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="OpenChannelResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfq
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzfq> CREATOR;
  @SafeParcelable.Field(id=2)
  public final int statusCode;
  @SafeParcelable.Field(id=3)
  public final zzay zzck;
  
  static
  {
    AppMethodBeat.i(101318);
    CREATOR = new zzfr();
    AppMethodBeat.o(101318);
  }
  
  @SafeParcelable.Constructor
  public zzfq(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) zzay paramzzay)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfq
 * JD-Core Version:    0.7.0.1
 */