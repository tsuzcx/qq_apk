package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.kd.b;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.b.a;

public class IPCInvoke_KindaJSInvoke
  implements b<Bundle, Bundle>
{
  public void invoke(Bundle paramBundle, final d<Bundle> paramd)
  {
    AppMethodBeat.i(189083);
    final kd localkd = new kd();
    localkd.dou.dox = paramBundle.getString("jsapiName", "");
    localkd.dou.type = paramBundle.getInt("jsapi_type", 0);
    localkd.dou.dow = paramBundle;
    localkd.dou.cvK = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(189082);
        paramd.bf(localkd.dov.doy);
        AppMethodBeat.o(189082);
      }
    };
    a.ESL.l(localkd);
    AppMethodBeat.o(189083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke
 * JD-Core Version:    0.7.0.1
 */