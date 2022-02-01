package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class zzdw
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdw> CREATOR;
  private final int statusCode;
  private final ConnectionConfiguration zzdv;
  
  static
  {
    AppMethodBeat.i(101213);
    CREATOR = new zzdx();
    AppMethodBeat.o(101213);
  }
  
  public zzdw(int paramInt, ConnectionConfiguration paramConnectionConfiguration)
  {
    this.statusCode = paramInt;
    this.zzdv = paramConnectionConfiguration;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101212);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzdv, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(101212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdw
 * JD-Core Version:    0.7.0.1
 */