package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.LinkedList;

final class JsApiAuthorize$AuthorizeTask$1
  implements JsApiAuthorize.AuthorizeTask.a
{
  JsApiAuthorize$AuthorizeTask$1(JsApiAuthorize.AuthorizeTask paramAuthorizeTask) {}
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(130831);
    ab.e("MicroMsg.JsApiAuthorize", "onFailure !");
    this.hDK.hDz = "fail";
    this.hDK.errCode = paramInt;
    this.hDK.errMsg = paramString;
    JsApiAuthorize.AuthorizeTask.b(this.hDK);
    AppMethodBeat.o(130831);
  }
  
  public final void a(axt paramaxt)
  {
    AppMethodBeat.i(130832);
    ab.d("MicroMsg.JsApiAuthorize", "onConfirm !");
    Object localObject = paramaxt.wYt;
    this.hDK.hDH = ((LinkedList)localObject).size();
    int i = 0;
    while (i < this.hDK.hDH)
    {
      bwv localbwv = (bwv)((LinkedList)localObject).get(i);
      try
      {
        this.hDK.hDI.putByteArray(String.valueOf(i), localbwv.toByteArray());
        i += 1;
      }
      catch (IOException paramaxt)
      {
        ab.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { paramaxt.getMessage() });
        ab.printErrStackTrace("MicroMsg.JsApiAuthorize", paramaxt, "", new Object[0]);
        this.hDK.hDz = "fail";
        JsApiAuthorize.AuthorizeTask.c(this.hDK);
        AppMethodBeat.o(130832);
        return;
      }
    }
    this.hDK.mAppName = paramaxt.ntp;
    this.hDK.hDB = paramaxt.wnz;
    this.hDK.hDC = paramaxt.xmW;
    this.hDK.hDE = paramaxt.xmV;
    this.hDK.hDD = paramaxt.xmU;
    this.hDK.hDz = "needConfirm";
    if ((((LinkedList)localObject).size() > 0) && ("scope.userInfo".equals(((bwv)((LinkedList)localObject).get(0)).wAh)))
    {
      this.hDK.hDG = r.Zp();
      localObject = new StringBuilder("userNickName=");
      if (this.hDK.hDG == null) {}
      for (paramaxt = "";; paramaxt = this.hDK.hDG)
      {
        ab.i("MicroMsg.JsApiAuthorize", paramaxt);
        paramaxt = r.Zn();
        localObject = e.hDq;
        e.a.a(paramaxt, new JsApiAuthorize.AuthorizeTask.1.1(this));
        AppMethodBeat.o(130832);
        return;
      }
    }
    JsApiAuthorize.AuthorizeTask.e(this.hDK);
    AppMethodBeat.o(130832);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(130830);
    ab.d("MicroMsg.JsApiAuthorize", "onSuccess !");
    this.hDK.hDz = "ok";
    JsApiAuthorize.AuthorizeTask.a(this.hDK);
    AppMethodBeat.o(130830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.1
 * JD-Core Version:    0.7.0.1
 */