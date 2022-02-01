package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class KatanaProxyLoginMethodHandler$1
  implements Parcelable.Creator<KatanaProxyLoginMethodHandler>
{
  public final KatanaProxyLoginMethodHandler createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(7804);
    paramParcel = new KatanaProxyLoginMethodHandler(paramParcel);
    AppMethodBeat.o(7804);
    return paramParcel;
  }
  
  public final KatanaProxyLoginMethodHandler[] newArray(int paramInt)
  {
    return new KatanaProxyLoginMethodHandler[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.login.KatanaProxyLoginMethodHandler.1
 * JD-Core Version:    0.7.0.1
 */