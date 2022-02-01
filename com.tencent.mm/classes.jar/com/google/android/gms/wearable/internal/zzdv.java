package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzdv
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdv> CREATOR;
  private final boolean enabled;
  private final int statusCode;
  
  static
  {
    AppMethodBeat.i(101211);
    CREATOR = new zzdu();
    AppMethodBeat.o(101211);
  }
  
  public zzdv(int paramInt, boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdv
 * JD-Core Version:    0.7.0.1
 */