package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzea
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzea> CREATOR;
  public final int statusCode;
  public final List<zzfo> zzdx;
  
  static
  {
    AppMethodBeat.i(101220);
    CREATOR = new zzeb();
    AppMethodBeat.o(101220);
  }
  
  public zzea(int paramInt, List<zzfo> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzea
 * JD-Core Version:    0.7.0.1
 */