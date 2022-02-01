package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzai
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzai> CREATOR;
  private final String accountType;
  private final byte[] zzbz;
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(10754);
    CREATOR = new zzaj();
    AppMethodBeat.o(10754);
  }
  
  zzai(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(10752);
    this.zzy = 1;
    this.accountType = ((String)Preconditions.checkNotNull(paramString));
    this.zzbz = ((byte[])Preconditions.checkNotNull(paramArrayOfByte));
    AppMethodBeat.o(10752);
  }
  
  public zzai(String paramString, byte[] paramArrayOfByte)
  {
    this(1, paramString, paramArrayOfByte);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10753);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    SafeParcelWriter.writeString(paramParcel, 2, this.accountType, false);
    SafeParcelWriter.writeByteArray(paramParcel, 3, this.zzbz, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(10753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzai
 * JD-Core Version:    0.7.0.1
 */