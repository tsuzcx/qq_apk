package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewLoginMethodHandler$2
  implements Parcelable.Creator<WebViewLoginMethodHandler>
{
  public final WebViewLoginMethodHandler createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(96931);
    paramParcel = new WebViewLoginMethodHandler(paramParcel);
    AppMethodBeat.o(96931);
    return paramParcel;
  }
  
  public final WebViewLoginMethodHandler[] newArray(int paramInt)
  {
    return new WebViewLoginMethodHandler[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.login.WebViewLoginMethodHandler.2
 * JD-Core Version:    0.7.0.1
 */