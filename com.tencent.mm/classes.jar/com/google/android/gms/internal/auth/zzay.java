package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="DeleteRequestCreator")
@SafeParcelable.Reserved({1000})
public final class zzay
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzay> CREATOR;
  @SafeParcelable.Field(getter="getCredential", id=1)
  private final Credential zzdq;
  
  static
  {
    AppMethodBeat.i(88384);
    CREATOR = new zzaz();
    AppMethodBeat.o(88384);
  }
  
  @SafeParcelable.Constructor
  public zzay(@SafeParcelable.Param(id=1) Credential paramCredential)
  {
    this.zzdq = paramCredential;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88383);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzdq, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(88383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzay
 * JD-Core Version:    0.7.0.1
 */