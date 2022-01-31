package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.LinkedList;

final class JsApiLogin$LoginTask$1
  implements JsApiLogin.LoginTask.a
{
  JsApiLogin$LoginTask$1(JsApiLogin.LoginTask paramLoginTask) {}
  
  public final void G(int paramInt, String paramString)
  {
    y.i("MicroMsg.JsApiLogin", "onFailure !");
    this.gjU.gjM = "fail";
    this.gjU.errCode = paramInt;
    this.gjU.aox = paramString;
    JsApiLogin.LoginTask.b(this.gjU);
  }
  
  public final void a(LinkedList<bna> paramLinkedList, String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.JsApiLogin", "onConfirm !");
    this.gjU.gjO = paramLinkedList.size();
    int i = 0;
    while (i < this.gjU.gjO)
    {
      bna localbna = (bna)paramLinkedList.get(i);
      try
      {
        this.gjU.gjP.putByteArray(String.valueOf(i), localbna.toByteArray());
        i += 1;
      }
      catch (IOException paramLinkedList)
      {
        y.e("MicroMsg.JsApiLogin", "IOException %s", new Object[] { paramLinkedList.getMessage() });
        y.printErrStackTrace("MicroMsg.JsApiLogin", paramLinkedList, "", new Object[0]);
        this.gjU.gjM = "fail";
        JsApiLogin.LoginTask.c(this.gjU);
        return;
      }
    }
    this.gjU.gif = paramString3;
    this.gjU.mAppName = paramString1;
    this.gjU.fXS = paramString2;
    this.gjU.gjM = "needConfirm";
    JsApiLogin.LoginTask.d(this.gjU);
  }
  
  public final void onSuccess(String paramString)
  {
    y.i("MicroMsg.JsApiLogin", "onSuccess !");
    this.gjU.code = paramString;
    this.gjU.gjM = "ok";
    JsApiLogin.LoginTask.a(this.gjU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.1
 * JD-Core Version:    0.7.0.1
 */