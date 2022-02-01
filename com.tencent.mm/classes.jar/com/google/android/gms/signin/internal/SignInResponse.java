package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignInResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SignInResponse> CREATOR;
  private final ResolveAccountResponse zzadu;
  private final int zzal;
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
  
  SignInResponse(int paramInt, ConnectionResult paramConnectionResult, ResolveAccountResponse paramResolveAccountResponse)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.signin.internal.SignInResponse
 * JD-Core Version:    0.7.0.1
 */