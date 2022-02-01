package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

 enum n
{
  static
  {
    AppMethodBeat.i(90849);
    wUE = new n("INSTANCE");
    wUF = new n[] { wUE };
    AppMethodBeat.o(90849);
  }
  
  private n() {}
  
  final void Ji(int paramInt)
  {
    AppMethodBeat.i(90847);
    final String str = MMApplicationContext.getProcessName();
    Log.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s operate network change: %d", new Object[] { str, Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putString("from_process", str);
    localBundle.putInt("opcode", paramInt);
    j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class, new f() {});
    AppMethodBeat.o(90847);
  }
  
  static final class a
    implements d<Bundle, Bundle>
  {
    private static String wUI;
    private static final p wUJ;
    
    static
    {
      AppMethodBeat.i(90844);
      wUJ = new p.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(90841);
          Object localObject = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
          final String str = MMApplicationContext.getProcessName();
          Log.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s on network changed: %d, changed to %s, %s", new Object[] { str, Integer.valueOf(paramAnonymousInt), localObject, n.a.wUI });
          localObject = new Bundle();
          ((Bundle)localObject).putString("from_process", str);
          ((Bundle)localObject).putInt("newState", paramAnonymousInt);
          j.a(n.a.wUI, (Parcelable)localObject, n.a.a.class, new f() {});
          AppMethodBeat.o(90841);
        }
      };
      AppMethodBeat.o(90844);
    }
    
    static class a
      implements d<Bundle, Bundle>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.n
 * JD-Core Version:    0.7.0.1
 */