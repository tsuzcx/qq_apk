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

@SafeParcelable.Class(creator="SaveRequestCreator")
@SafeParcelable.Reserved({1000})
public final class zzbe
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbe> CREATOR;
  @SafeParcelable.Field(getter="getCredential", id=1)
  private final Credential zzdq;
  
  static
  {
    AppMethodBeat.i(50496);
    CREATOR = new zzbf();
    AppMethodBeat.o(50496);
  }
  
  @SafeParcelable.Constructor
  public zzbe(@SafeParcelable.Param(id=1) Credential paramCredential)
  {
    this.zzdq = paramCredential;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50495);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzdq, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(50495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzbe
 * JD-Core Version:    0.7.0.1
 */