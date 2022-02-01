package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;

 enum m
{
  static
  {
    AppMethodBeat.i(90849);
    otD = new m("INSTANCE");
    otE = new m[] { otD };
    AppMethodBeat.o(90849);
  }
  
  private m() {}
  
  final void Au(int paramInt)
  {
    AppMethodBeat.i(90847);
    final String str = ai.getProcessName();
    ac.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s operate network change: %d", new Object[] { str, Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putString("from_process", str);
    localBundle.putInt("opcode", paramInt);
    h.a("com.tencent.mm", localBundle, a.class, new d() {});
    AppMethodBeat.o(90847);
  }
  
  static final class a
    implements b<Bundle, Bundle>
  {
    private static String otH;
    private static final n otI;
    
    static
    {
      AppMethodBeat.i(90844);
      otI = new n.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(90841);
          Object localObject = ax.iH(ai.getContext());
          final String str = ai.getProcessName();
          ac.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s on network changed: %d, changed to %s, %s", new Object[] { str, Integer.valueOf(paramAnonymousInt), localObject, m.a.otH });
          localObject = new Bundle();
          ((Bundle)localObject).putString("from_process", str);
          ((Bundle)localObject).putInt("newState", paramAnonymousInt);
          h.a(m.a.otH, (Parcelable)localObject, m.a.a.class, new d() {});
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