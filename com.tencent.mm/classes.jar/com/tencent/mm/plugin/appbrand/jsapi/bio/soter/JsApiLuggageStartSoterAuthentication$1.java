package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;

class JsApiLuggageStartSoterAuthentication$1
  extends ResultReceiver
{
  JsApiLuggageStartSoterAuthentication$1(b paramb, Handler paramHandler, c paramc, int paramInt)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(73792);
    if (paramInt == -1)
    {
      ab.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth ok");
      localb = this.hFr;
      localc = this.hxW;
      paramInt = this.bAX;
      if (paramBundle != null) {}
      for (;;)
      {
        b.a(localb, localc, paramInt, paramBundle, "ok");
        AppMethodBeat.o(73792);
        return;
        paramBundle = null;
      }
    }
    if (paramInt == 1)
    {
      ab.w("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth failed");
      localb = this.hFr;
      localc = this.hxW;
      paramInt = this.bAX;
      if (paramBundle != null) {}
      for (;;)
      {
        b.a(localb, localc, paramInt, paramBundle, "fail");
        AppMethodBeat.o(73792);
        return;
        paramBundle = null;
      }
    }
    ab.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter user cancelled");
    b localb = this.hFr;
    c localc = this.hxW;
    paramInt = this.bAX;
    if (paramBundle != null) {}
    for (;;)
    {
      b.a(localb, localc, paramInt, paramBundle, "cancel");
      AppMethodBeat.o(73792);
      return;
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageStartSoterAuthentication.1
 * JD-Core Version:    0.7.0.1
 */