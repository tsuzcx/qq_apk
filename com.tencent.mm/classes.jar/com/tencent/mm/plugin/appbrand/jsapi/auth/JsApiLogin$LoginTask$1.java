package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.LinkedList;

final class JsApiLogin$LoginTask$1
  implements JsApiLogin.LoginTask.a
{
  JsApiLogin$LoginTask$1(JsApiLogin.LoginTask paramLoginTask) {}
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(130855);
    ab.i("MicroMsg.JsApiLogin", "onFailure !");
    this.hDP.hDz = "fail";
    this.hDP.errCode = paramInt;
    this.hDP.errMsg = paramString;
    JsApiLogin.LoginTask.b(this.hDP);
    AppMethodBeat.o(130855);
  }
  
  public final void a(LinkedList<bwv> paramLinkedList, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(130856);
    ab.i("MicroMsg.JsApiLogin", "onConfirm !");
    this.hDP.hDH = paramLinkedList.size();
    int i = 0;
    while (i < this.hDP.hDH)
    {
      bwv localbwv = (bwv)paramLinkedList.get(i);
      try
      {
        this.hDP.hDI.putByteArray(String.valueOf(i), localbwv.toByteArray());
        i += 1;
      }
      catch (IOException paramLinkedList)
      {
        ab.e("MicroMsg.JsApiLogin", "IOException %s", new Object[] { paramLinkedList.getMessage() });
        ab.printErrStackTrace("MicroMsg.JsApiLogin", paramLinkedList, "", new Object[0]);
        this.hDP.hDz = "fail";
        JsApiLogin.LoginTask.c(this.hDP);
        AppMethodBeat.o(130856);
        return;
      }
    }
    this.hDP.hBt = paramString3;
    this.hDP.mAppName = paramString1;
    this.hDP.hDB = paramString2;
    this.hDP.hDz = "needConfirm";
    JsApiLogin.LoginTask.d(this.hDP);
    AppMethodBeat.o(130856);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(130854);
    ab.i("MicroMsg.JsApiLogin", "onSuccess !");
    this.hDP.code = paramString;
    this.hDP.hDz = "ok";
    JsApiLogin.LoginTask.a(this.hDP);
    AppMethodBeat.o(130854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.1
 * JD-Core Version:    0.7.0.1
 */