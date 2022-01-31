package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginClient$1
  implements Parcelable.Creator<LoginClient>
{
  public final LoginClient createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(96789);
    paramParcel = new LoginClient(paramParcel);
    AppMethodBeat.o(96789);
    return paramParcel;
  }
  
  public final LoginClient[] newArray(int paramInt)
  {
    return new LoginClient[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.login.LoginClient.1
 * JD-Core Version:    0.7.0.1
 */