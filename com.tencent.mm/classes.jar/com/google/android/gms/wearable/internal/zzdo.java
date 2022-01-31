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
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="GetChannelOutputStreamResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdo
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdo> CREATOR;
  @SafeParcelable.Field(id=2)
  public final int statusCode;
  @Nullable
  @SafeParcelable.Field(id=3)
  public final ParcelFileDescriptor zzdr;
  
  static
  {
    AppMethodBeat.i(71218);
    CREATOR = new zzdp();
    AppMethodBeat.o(71218);
  }
  
  @SafeParcelable.Constructor
  public zzdo(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.statusCode = paramInt;
    this.zzdr = paramParcelFileDescriptor;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(71217);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzdr, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(71217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdo
 * JD-Core Version:    0.7.0.1
 */