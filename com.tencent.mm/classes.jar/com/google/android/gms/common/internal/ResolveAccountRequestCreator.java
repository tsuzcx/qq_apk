package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResolveAccountRequestCreator
  implements Parcelable.Creator<ResolveAccountRequest>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public ResolveAccountRequest createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(11853);
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    GoogleSignInAccount localGoogleSignInAccount = null;
    int j = 0;
    Account localAccount = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(m))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, m);
        break;
      case 1: 
        i = SafeParcelReader.readInt(paramParcel, m);
        break;
      case 2: 
        localAccount = (Account)SafeParcelReader.createParcelable(paramParcel, m, Account.CREATOR);
        break;
      case 3: 
        j = SafeParcelReader.readInt(paramParcel, m);
        break;
      case 4: 
        localGoogleSignInAccount = (GoogleSignInAccount)SafeParcelReader.createParcelable(paramParcel, m, GoogleSignInAccount.CREATOR);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    paramParcel = new ResolveAccountRequest(i, localAccount, j, localGoogleSignInAccount);
    AppMethodBeat.o(11853);
    return paramParcel;
  }
  
  public ResolveAccountRequest[] newArray(int paramInt)
  {
    return new ResolveAccountRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountRequestCreator
 * JD-Core Version:    0.7.0.1
 */