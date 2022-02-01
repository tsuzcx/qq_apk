package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;

class JsApiLuggageStartSoterAuthentication$1
  extends ResultReceiver
{
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(159050);
    if (paramInt == -1)
    {
      Log.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth ok");
      localb = this.rJM;
      localf = this.erj;
      paramInt = this.elZ;
      if (paramBundle != null) {}
      for (;;)
      {
        b.a(localb, localf, paramInt, paramBundle, "ok");
        AppMethodBeat.o(159050);
        return;
        paramBundle = null;
      }
    }
    if (paramInt == 1)
    {
      Log.w("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth failed");
      localb = this.rJM;
      localf = this.erj;
      paramInt = this.elZ;
      if (paramBundle != null) {}
      for (;;)
      {
        b.a(localb, localf, paramInt, paramBundle, "fail");
        AppMethodBeat.o(159050);
        return;
        paramBundle = null;
      }
    }
    Log.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter user cancelled");
    b localb = this.rJM;
    f localf = this.erj;
    paramInt = this.elZ;
    if (paramBundle != null) {}
    for (;;)
    {
      b.a(localb, localf, paramInt, paramBundle, "cancel");
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