package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiAuthorize$AuthorizeTask$1$1
  implements e.b
{
  JsApiAuthorize$AuthorizeTask$1$1(JsApiAuthorize.AuthorizeTask.1 param1) {}
  
  public final void BR(String paramString)
  {
    AppMethodBeat.i(130829);
    this.hDL.hDK.hDF = paramString;
    StringBuilder localStringBuilder = new StringBuilder(" userHeadIconPath=");
    if (this.hDL.hDK.hDF == null) {}
    for (paramString = "";; paramString = this.hDL.hDK.hDF)
    {
      ab.i("MicroMsg.JsApiAuthorize", paramString);
      JsApiAuthorize.AuthorizeTask.d(this.hDL.hDK);
      AppMethodBeat.o(130829);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.1.1
 * JD-Core Version:    0.7.0.1
 */