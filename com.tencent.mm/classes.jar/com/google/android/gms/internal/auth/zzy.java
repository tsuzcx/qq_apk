package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzy
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzy> CREATOR;
  private final String accountType;
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(10816);
    CREATOR = new zzz();
    AppMethodBeat.o(10816);
  }
  
  zzy(int paramInt, String paramString)
  {
    AppMethodBeat.i(10814);
    this.zzy = 1;
    this.accountType = ((String)Preconditions.checkNotNull(paramString));
    AppMethodBeat.o(10814);
  }
  
  public zzy(String paramString)
  {
    this(1, paramString);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10815);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    SafeParcelWriter.writeString(paramParcel, 2, this.accountType, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(10815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzy
 * JD-Core Version:    0.7.0.1
 */