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
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@SafeParcelable.Class(creator="GetAllCapabilitiesResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdi
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdi> CREATOR;
  @SafeParcelable.Field(id=2)
  public final int statusCode;
  @SafeParcelable.Field(id=3)
  @VisibleForTesting
  public final List<zzah> zzdp;
  
  static
  {
    AppMethodBeat.i(71209);
    CREATOR = new zzdj();
    AppMethodBeat.o(71209);
  }
  
  @SafeParcelable.Constructor
  public zzdi(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) List<zzah> paramList)
  {
    this.statusCode = paramInt;
    this.zzdp = paramList;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(71208);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zzdp, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(71208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdi
 * JD-Core Version:    0.7.0.1
 */