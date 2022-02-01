package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.kv.b;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.b.a;

public class IPCInvoke_KindaJSInvoke
  implements b<Bundle, Bundle>
{
  public void invoke(Bundle paramBundle, final d<Bundle> paramd)
  {
    AppMethodBeat.i(208245);
    final kv localkv = new kv();
    localkv.dyW.dyZ = paramBundle.getString("jsapiName", "");
    localkv.dyW.type = paramBundle.getInt("jsapi_type", 0);
    localkv.dyW.dyY = paramBundle;
    localkv.dyW.cEv = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(208244);
        paramd.be(localkv.dyX.dza);
        AppMethodBeat.o(208244);
      }
    };
    a.IvT.l(localkv);
    AppMethodBeat.o(208245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke
 * JD-Core Version:    0.7.0.1
 */