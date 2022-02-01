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
import java.util.List;

@SafeParcelable.Class(creator="GetConnectedNodesResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzea
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzea> CREATOR;
  @SafeParcelable.Field(id=2)
  public final int statusCode;
  @SafeParcelable.Field(id=3)
  public final List<zzfo> zzdx;
  
  static
  {
    AppMethodBeat.i(101220);
    CREATOR = new zzeb();
    AppMethodBeat.o(101220);
  }
  
  @SafeParcelable.Constructor
  public zzea(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) List<zzfo> paramList)
  {
    this.statusCode = paramInt;
    this.zzdx = paramList;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101219);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zzdx, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzea
 * JD-Core Version:    0.7.0.1
 */