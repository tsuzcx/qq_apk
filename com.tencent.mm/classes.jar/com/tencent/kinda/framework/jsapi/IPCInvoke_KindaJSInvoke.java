package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.ll.b;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.event.EventCenter;

public class IPCInvoke_KindaJSInvoke
  implements b<Bundle, Bundle>
{
  public void invoke(Bundle paramBundle, final d<Bundle> paramd)
  {
    AppMethodBeat.i(190308);
    final ll localll = new ll();
    localll.dQJ.dQM = paramBundle.getString("jsapiName", "");
    localll.dQJ.type = paramBundle.getInt("jsapi_type", 0);
    localll.dQJ.dQL = paramBundle;
    localll.dQJ.dQN = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(190307);
        paramd.bn(localll.dQK.result);
        AppMethodBeat.o(190307);
      }
    };
    EventCenter.instance.publish(localll);
    AppMethodBeat.o(190308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke
 * JD-Core Version:    0.7.0.1
 */