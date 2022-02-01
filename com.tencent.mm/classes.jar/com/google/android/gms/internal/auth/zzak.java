package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzak
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzak> CREATOR;
  private final String accountType;
  private final PendingIntent zzch;
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(10758);
    CREATOR = new zzal();
    AppMethodBeat.o(10758);
  }
  
  zzak(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(10756);
    this.zzy = 1;
    this.accountType = ((String)Preconditions.checkNotNull(paramString));
    this.zzch = ((PendingIntent)Preconditions.checkNotNull(paramPendingIntent));
    AppMethodBeat.o(10756);
  }
  
  public zzak(String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramString, paramPendingIntent);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10757);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    SafeParcelWriter.writeString(paramParcel, 2, this.accountType, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzch, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(10757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzak
 * JD-Core Version:    0.7.0.1
 */