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

@SafeParcelable.Class(creator="GetCloudSyncSettingCreator")
@SafeParcelable.Reserved({1})
public final class zzdv
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdv> CREATOR;
  @SafeParcelable.Field(id=3)
  private final boolean enabled;
  @SafeParcelable.Field(id=2)
  private final int statusCode;
  
  static
  {
    AppMethodBeat.i(101211);
    CREATOR = new zzdu();
    AppMethodBeat.o(101211);
  }
  
  @SafeParcelable.Constructor
  public zzdv(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) boolean paramBoolean)
  {
    this.statusCode = paramInt;
    this.enabled = paramBoolean;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101210);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.enabled);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdv
 * JD-Core Version:    0.7.0.1
 */