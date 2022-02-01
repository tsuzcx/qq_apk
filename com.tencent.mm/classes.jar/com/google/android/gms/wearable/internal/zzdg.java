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

@SafeParcelable.Class(creator="DeleteDataItemsResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdg
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdg> CREATOR;
  @SafeParcelable.Field(id=2)
  public final int statusCode;
  @SafeParcelable.Field(id=3)
  public final int zzdh;
  
  static
  {
    AppMethodBeat.i(101189);
    CREATOR = new zzdh();
    AppMethodBeat.o(101189);
  }
  
  @SafeParcelable.Constructor
  public zzdg(@SafeParcelable.Param(id=2) int paramInt1, @SafeParcelable.Param(id=3) int paramInt2)
  {
    this.statusCode = paramInt1;
    this.zzdh = paramInt2;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101188);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzdh);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdg
 * JD-Core Version:    0.7.0.1
 */