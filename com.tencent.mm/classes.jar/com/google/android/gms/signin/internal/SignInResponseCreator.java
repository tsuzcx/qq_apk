package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignInResponseCreator
  implements Parcelable.Creator<SignInResponse>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public SignInResponse createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(12197);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    ResolveAccountResponse localResolveAccountResponse = null;
    ConnectionResult localConnectionResult = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(k))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, k);
        break;
      case 1: 
        i = SafeParcelReader.readInt(paramParcel, k);
        break;
      case 2: 
        localConnectionResult = (ConnectionResult)SafeParcelReader.createParcelable(paramParcel, k, ConnectionResult.CREATOR);
        break;
      case 3: 
        localResolveAccountResponse = (ResolveAccountResponse)SafeParcelReader.createParcelable(paramParcel, k, ResolveAccountResponse.CREATOR);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new SignInResponse(i, localConnectionResult, localResolveAccountResponse);
    AppMethodBeat.o(12197);
    return paramParcel;
  }
  
  public SignInResponse[] newArray(int paramInt)
  {
    return new SignInResponse[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.signin.internal.SignInResponseCreator
 * JD-Core Version:    0.7.0.1
 */