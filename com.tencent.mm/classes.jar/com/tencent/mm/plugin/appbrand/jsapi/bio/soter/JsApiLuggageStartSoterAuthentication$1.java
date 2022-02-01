package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;

class JsApiLuggageStartSoterAuthentication$1
  extends ResultReceiver
{
  JsApiLuggageStartSoterAuthentication$1(b paramb, Handler paramHandler, c paramc, int paramInt)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(159050);
    if (paramInt == -1)
    {
      ad.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth ok");
      localb = this.kCK;
      localc = this.cnJ;
      paramInt = this.cjQ;
      if (paramBundle != null) {}
      for (;;)
      {
        b.a(localb, localc, paramInt, paramBundle, "ok");
        AppMethodBeat.o(159050);
        return;
        paramBundle = null;
      }
    }
    if (paramInt == 1)
    {
      ad.w("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth failed");
      localb = this.kCK;
      localc = this.cnJ;
      paramInt = this.cjQ;
      if (paramBundle != null) {}
      for (;;)
      {
        b.a(localb, localc, paramInt, paramBundle, "fail");
        AppMethodBeat.o(159050);
        return;
        paramBundle = null;
      }
    }
    ad.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter user cancelled");
    b localb = this.kCK;
    c localc = this.cnJ;
    paramInt = this.cjQ;
    if (paramBundle != null) {}
    for (;;)
    {
      b.a(localb, localc, paramInt, paramBundle, "cancel");
      AppMethodBeat.o(159050);
      return;
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageStartSoterAuthentication.1
 * JD-Core Version:    0.7.0.1
 */