package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzag
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzag> CREATOR;
  private final String accountType;
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(10750);
    CREATOR = new zzah();
    AppMethodBeat.o(10750);
  }
  
  zzag(int paramInt, String paramString)
  {
    AppMethodBeat.i(10748);
    this.zzy = 1;
    this.accountType = ((String)Preconditions.checkNotNull(paramString));
    AppMethodBeat.o(10748);
  }
  
  public zzag(String paramString)
  {
    this(1, paramString);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10749);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    SafeParcelWriter.writeString(paramParcel, 2, this.accountType, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(10749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzag
 * JD-Core Version:    0.7.0.1
 */