package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.LinkedList;

final class JsApiAuthorize$AuthorizeTask$1
  implements JsApiAuthorize.AuthorizeTask.a
{
  JsApiAuthorize$AuthorizeTask$1(JsApiAuthorize.AuthorizeTask paramAuthorizeTask) {}
  
  public final void G(int paramInt, String paramString)
  {
    y.e("MicroMsg.JsApiAuthorize", "onFailure !");
    this.gjR.gjM = "fail";
    this.gjR.errCode = paramInt;
    this.gjR.aox = paramString;
    JsApiAuthorize.AuthorizeTask.b(this.gjR);
  }
  
  public final void a(LinkedList<bna> paramLinkedList, String paramString1, String paramString2)
  {
    y.d("MicroMsg.JsApiAuthorize", "onConfirm !");
    this.gjR.gjO = paramLinkedList.size();
    int i = 0;
    while (i < this.gjR.gjO)
    {
      bna localbna = (bna)paramLinkedList.get(i);
      try
      {
        this.gjR.gjP.putByteArray(String.valueOf(i), localbna.toByteArray());
        i += 1;
      }
      catch (IOException paramLinkedList)
      {
        y.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { paramLinkedList.getMessage() });
        y.printErrStackTrace("MicroMsg.JsApiAuthorize", paramLinkedList, "", new Object[0]);
        this.gjR.gjM = "fail";
        JsApiAuthorize.AuthorizeTask.c(this.gjR);
        return;
      }
    }
    this.gjR.mAppName = paramString1;
    this.gjR.fXS = paramString2;
    this.gjR.gjM = "needConfirm";
    JsApiAuthorize.AuthorizeTask.d(this.gjR);
  }
  
  public final void onSuccess()
  {
    y.d("MicroMsg.JsApiAuthorize", "onSuccess !");
    this.gjR.gjM = "ok";
    JsApiAuthorize.AuthorizeTask.a(this.gjR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.1
 * JD-Core Version:    0.7.0.1
 */