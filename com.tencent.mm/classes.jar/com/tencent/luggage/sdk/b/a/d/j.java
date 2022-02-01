package com.tencent.luggage.sdk.b.a.d;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.debugger.s;
import com.tencent.mm.plugin.appbrand.debugger.x;
import com.tencent.mm.protocal.protobuf.gcc;
import com.tencent.mm.sdk.platformtools.Log;

public final class j<SERVICE extends d>
{
  public q esW;
  
  @JavascriptInterface
  public final void sendCustomMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220318);
    if (this.esW != null)
    {
      s locals = this.esW.rdT;
      Log.d("MicroMsg.RemoteDebugMsgMrg", "sendCustomMsg payload:%s", new Object[] { paramString2 });
      gcc localgcc = new gcc();
      localgcc.method = paramString1;
      localgcc.aaGI = paramString2;
      locals.a(x.a(localgcc, locals.esY, "customMessage"));
    }
    AppMethodBeat.o(220318);
  }
  
  @JavascriptInterface
  public final void sendMessage(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.j
 * JD-Core Version:    0.7.0.1
 */