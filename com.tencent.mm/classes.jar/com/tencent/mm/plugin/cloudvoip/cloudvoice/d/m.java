package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

 enum m
{
  static
  {
    AppMethodBeat.i(90849);
    oWZ = new m("INSTANCE");
    oXa = new m[] { oWZ };
    AppMethodBeat.o(90849);
  }
  
  private m() {}
  
  final void Bd(int paramInt)
  {
    AppMethodBeat.i(90847);
    final String str = aj.getProcessName();
    ad.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s operate network change: %d", new Object[] { str, Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putString("from_process", str);
    localBundle.putInt("opcode", paramInt);
    h.a("com.tencent.mm", localBundle, a.class, new d() {});
    AppMethodBeat.o(90847);
  }
  
  static final class a
    implements b<Bundle, Bundle>
  {
    private static String oXd;
    private static final n oXe;
    
    static
    {
      AppMethodBeat.i(90844);
      oXe = new n.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(90841);
          Object localObject = ay.iR(aj.getContext());
          final String str = aj.getProcessName();
          ad.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s on network changed: %d, changed to %s, %s", new Object[] { str, Integer.valueOf(paramAnonymousInt), localObject, m.a.oXd });
          localObject = new Bundle();
          ((Bundle)localObject).putString("from_process", str);
          ((Bundle)localObject).putInt("newState", paramAnonymousInt);
          h.a(m.a.oXd, (Parcelable)localObject, m.a.a.class, new d() {});
          AppMethodBeat.o(90841);
        }
      };
      AppMethodBeat.o(90844);
    }
    
    static class a
      implements b<Bundle, Bundle>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.m
 * JD-Core Version:    0.7.0.1
 */