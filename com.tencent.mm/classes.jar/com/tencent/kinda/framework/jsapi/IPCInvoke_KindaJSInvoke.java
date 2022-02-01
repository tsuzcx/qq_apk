package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.ku.b;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.b.a;

public class IPCInvoke_KindaJSInvoke
  implements b<Bundle, Bundle>
{
  public void invoke(Bundle paramBundle, final d<Bundle> paramd)
  {
    AppMethodBeat.i(217041);
    final ku localku = new ku();
    localku.dxR.dxU = paramBundle.getString("jsapiName", "");
    localku.dxR.type = paramBundle.getInt("jsapi_type", 0);
    localku.dxR.dxT = paramBundle;
    localku.dxR.cDO = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(217040);
        paramd.be(localku.dxS.dxV);
        AppMethodBeat.o(217040);
      }
    };
    a.IbL.l(localku);
    AppMethodBeat.o(217041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke
 * JD-Core Version:    0.7.0.1
 */