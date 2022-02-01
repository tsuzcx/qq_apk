package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.kl.b;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.b.a;

public class IPCInvoke_KindaJSInvoke
  implements b<Bundle, Bundle>
{
  public void invoke(Bundle paramBundle, final d<Bundle> paramd)
  {
    AppMethodBeat.i(205762);
    final kl localkl = new kl();
    localkl.dmd.dmg = paramBundle.getString("jsapiName", "");
    localkl.dmd.type = paramBundle.getInt("jsapi_type", 0);
    localkl.dmd.dmf = paramBundle;
    localkl.dmd.csS = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(205761);
        paramd.bc(localkl.dme.dmh);
        AppMethodBeat.o(205761);
      }
    };
    a.GpY.l(localkl);
    AppMethodBeat.o(205762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke
 * JD-Core Version:    0.7.0.1
 */