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

@SafeParcelable.Class(creator="PutDataResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfu
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzfu> CREATOR;
  @SafeParcelable.Field(id=2)
  public final int statusCode;
  @SafeParcelable.Field(id=3)
  public final zzdd zzdy;
  
  static
  {
    AppMethodBeat.i(101324);
    CREATOR = new zzfv();
    AppMethodBeat.o(101324);
  }
  
  @SafeParcelable.Constructor
  public zzfu(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) zzdd paramzzdd)
  {
    this.statusCode = paramInt;
    this.zzdy = paramzzdd;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101323);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzdy, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(101323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfu
 * JD-Core Version:    0.7.0.1
 */