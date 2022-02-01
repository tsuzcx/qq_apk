package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzdy
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdy> CREATOR;
  private final int statusCode;
  private final ConnectionConfiguration[] zzdw;
  
  static
  {
    AppMethodBeat.i(101216);
    CREATOR = new zzdz();
    AppMethodBeat.o(101216);
  }
  
  public zzdy(int paramInt, ConnectionConfiguration[] paramArrayOfConnectionConfiguration)
  {
    this.statusCode = paramInt;
    this.zzdw = paramArrayOfConnectionConfiguration;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101215);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, this.zzdw, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(101215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdy
 * JD-Core Version:    0.7.0.1
 */