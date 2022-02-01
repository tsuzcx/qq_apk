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

@SafeParcelable.Class(creator="AddLocalCapabilityResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzf
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzf> CREATOR;
  @SafeParcelable.Field(id=2)
  public final int statusCode;
  
  static
  {
    AppMethodBeat.i(101288);
    CREATOR = new zzg();
    AppMethodBeat.o(101288);
  }
  
  @SafeParcelable.Constructor
  public zzf(@SafeParcelable.Param(id=2) int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101287);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzf
 * JD-Core Version:    0.7.0.1
 */