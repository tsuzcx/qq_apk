package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="SignInResponseCreator")
public class SignInResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SignInResponse> CREATOR;
  @SafeParcelable.Field(getter="getResolveAccountResponse", id=3)
  private final ResolveAccountResponse zzadu;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @SafeParcelable.Field(getter="getConnectionResult", id=2)
  private final ConnectionResult zzeu;
  
  static
  {
    AppMethodBeat.i(12196);
    CREATOR = new SignInResponseCreator();
    AppMethodBeat.o(12196);
  }
  
  public SignInResponse(int paramInt)
  {
    this(new ConnectionResult(paramInt, null), null);
    AppMethodBeat.i(12194);
    AppMethodBeat.o(12194);
  }
  
  @SafeParcelable.Constructor
  SignInResponse(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) ConnectionResult paramConnectionResult, @SafeParcelable.Param(id=3) ResolveAccountResponse paramResolveAccountResponse)
  {
    this.zzal = paramInt;
    this.zzeu = paramConnectionResult;
    this.zzadu = paramResolveAccountResponse;
  }
  
  public SignInResponse(ConnectionResult paramConnectionResult, ResolveAccountResponse paramResolveAccountResponse)
  {
    this(1, paramConnectionResult, paramResolveAccountResponse);
  }
  
  public ConnectionResult getConnectionResult()
  {
    return this.zzeu;
  }
  
  public ResolveAccountResponse getResolveAccountResponse()
  {
    return this.zzadu;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(12195);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getConnectionResult(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getResolveAccountResponse(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(12195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.signin.internal.SignInResponse
 * JD-Core Version:    0.7.0.1
 */