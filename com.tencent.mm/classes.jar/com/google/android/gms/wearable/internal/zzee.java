package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="GetFdForAssetResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzee
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzee> CREATOR;
  @SafeParcelable.Field(id=2)
  public final int statusCode;
  @SafeParcelable.Field(id=3)
  public final ParcelFileDescriptor zzdz;
  
  static
  {
    AppMethodBeat.i(101226);
    CREATOR = new zzef();
    AppMethodBeat.o(101226);
  }
  
  @SafeParcelable.Constructor
  public zzee(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.statusCode = paramInt;
    this.zzdz = paramParcelFileDescriptor;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101225);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzdz, paramInt | 0x1, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(101225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzee
 * JD-Core Version:    0.7.0.1
 */