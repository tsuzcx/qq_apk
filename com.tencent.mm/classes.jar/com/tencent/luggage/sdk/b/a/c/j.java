package com.tencent.luggage.sdk.b.a.c;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.debugger.s;
import com.tencent.mm.plugin.appbrand.debugger.x;
import com.tencent.mm.protocal.protobuf.ffq;
import com.tencent.mm.sdk.platformtools.Log;

public final class j<SERVICE extends d>
{
  public q cAB;
  
  @JavascriptInterface
  public final void sendCustomMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(251509);
    if (this.cAB != null)
    {
      s locals = this.cAB.odd;
      Log.d("MicroMsg.RemoteDebugMsgMrg", "sendCustomMsg payload:%s", new Object[] { paramString2 });
      ffq localffq = new ffq();
      localffq.method = paramString1;
      localffq.Tsy = paramString2;
      locals.a(x.a(localffq, locals.cAD, "customMessage"));
    }
    AppMethodBeat.o(251509);
  }
  
  @JavascriptInterface
  public final void sendMessage(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.j
 * JD-Core Version:    0.7.0.1
 */