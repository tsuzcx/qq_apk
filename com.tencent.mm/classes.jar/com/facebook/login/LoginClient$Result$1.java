package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginClient$Result$1
  implements Parcelable.Creator<LoginClient.Result>
{
  public final LoginClient.Result createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(96801);
    paramParcel = new LoginClient.Result(paramParcel, null);
    AppMethodBeat.o(96801);
    return paramParcel;
  }
  
  public final LoginClient.Result[] newArray(int paramInt)
  {
    return new LoginClient.Result[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.LoginClient.Result.1
 * JD-Core Version:    0.7.0.1
 */