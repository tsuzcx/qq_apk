package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginClient$Request$1
  implements Parcelable.Creator<LoginClient.Request>
{
  public final LoginClient.Request createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(96792);
    paramParcel = new LoginClient.Request(paramParcel, null);
    AppMethodBeat.o(96792);
    return paramParcel;
  }
  
  public final LoginClient.Request[] newArray(int paramInt)
  {
    return new LoginClient.Request[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.login.LoginClient.Request.1
 * JD-Core Version:    0.7.0.1
 */