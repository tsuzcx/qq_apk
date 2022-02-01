package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.mc;
import com.tencent.mm.f.a.mc.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.event.EventCenter;

public class IPCInvoke_KindaJSInvoke
  implements d<Bundle, Bundle>
{
  public void invoke(Bundle paramBundle, final f<Bundle> paramf)
  {
    AppMethodBeat.i(210796);
    final mc localmc = new mc();
    localmc.fJZ.fKc = paramBundle.getString("jsapiName", "");
    localmc.fJZ.type = paramBundle.getInt("jsapi_type", 0);
    localmc.fJZ.fKb = paramBundle;
    localmc.fJZ.fKd = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(210787);
        paramf.aH(localmc.fKa.result);
        AppMethodBeat.o(210787);
      }
    };
    EventCenter.instance.publish(localmc);
    AppMethodBeat.o(210796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke
 * JD-Core Version:    0.7.0.1
 */