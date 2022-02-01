package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ni;
import com.tencent.mm.autogen.a.ni.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;

public class IPCInvoke_KindaJSInvoke
  implements d<Bundle, Bundle>
{
  public void invoke(Bundle paramBundle, final f<Bundle> paramf)
  {
    AppMethodBeat.i(226306);
    final ni localni = new ni();
    localni.hPF.hPI = paramBundle.getString("jsapiName", "");
    localni.hPF.type = paramBundle.getInt("jsapi_type", 0);
    localni.hPF.hPH = paramBundle;
    localni.hPF.hPJ = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(226318);
        paramf.onCallback(localni.hPG.result);
        AppMethodBeat.o(226318);
      }
    };
    localni.publish();
    AppMethodBeat.o(226306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke
 * JD-Core Version:    0.7.0.1
 */