package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="UserChallengeRequestCreator")
public final class zzak
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzak> CREATOR;
  @SafeParcelable.Field(id=2)
  private final String accountType;
  @SafeParcelable.Field(id=3)
  private final PendingIntent zzch;
  @SafeParcelable.VersionField(id=1)
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(77099);
    CREATOR = new zzal();
    AppMethodBeat.o(77099);
  }
  
  @SafeParcelable.Constructor
  zzak(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(77097);
    this.zzy = 1;
    this.accountType = ((String)Preconditions.checkNotNull(paramString));
    this.zzch = ((PendingIntent)Preconditions.checkNotNull(paramPendingIntent));
    AppMethodBeat.o(77097);
  }
  
  public zzak(String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramString, paramPendingIntent);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(77098);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    SafeParcelWriter.writeString(paramParcel, 2, this.accountType, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzch, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(77098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzak
 * JD-Core Version:    0.7.0.1
 */