package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignInRequestCreator
  implements Parcelable.Creator<SignInRequest>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public SignInRequest createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(61699);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    ResolveAccountRequest localResolveAccountRequest = null;
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
        localResolveAccountRequest = (ResolveAccountRequest)SafeParcelReader.createParcelable(paramParcel, k, ResolveAccountRequest.CREATOR);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new SignInRequest(i, localResolveAccountRequest);
    AppMethodBeat.o(61699);
    return paramParcel;
  }
  
  public SignInRequest[] newArray(int paramInt)
  {
    return new SignInRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.signin.internal.SignInRequestCreator
 * JD-Core Version:    0.7.0.1
 */