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

@SafeParcelable.Class(creator="GetCloudSyncOptInOutDoneCreator")
@SafeParcelable.Reserved({1})
public final class zzdr
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdr> CREATOR;
  @SafeParcelable.Field(id=2)
  private final int statusCode;
  @SafeParcelable.Field(id=3)
  private final boolean zzds;
  
  static
  {
    AppMethodBeat.i(101205);
    CREATOR = new zzdq();
    AppMethodBeat.o(101205);
  }
  
  @SafeParcelable.Constructor
  public zzdr(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) boolean paramBoolean)
  {
    this.statusCode = paramInt;
    this.zzds = paramBoolean;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101204);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzds);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdr
 * JD-Core Version:    0.7.0.1
 */