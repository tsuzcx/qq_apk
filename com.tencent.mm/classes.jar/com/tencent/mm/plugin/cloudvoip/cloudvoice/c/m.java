package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.network.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

 enum m
{
  static
  {
    AppMethodBeat.i(135508);
    kKx = new m("INSTANCE");
    kKy = new m[] { kKx };
    AppMethodBeat.o(135508);
  }
  
  private m() {}
  
  final void tK(int paramInt)
  {
    AppMethodBeat.i(135506);
    String str = ah.getProcessName();
    ab.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s operate network change: %d", new Object[] { str, Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putString("from_process", str);
    localBundle.putInt("opcode", paramInt);
    f.a("com.tencent.mm", localBundle, a.class, new m.1(this, str));
    AppMethodBeat.o(135506);
  }
  
  static final class a
    implements a<Bundle, Bundle>
  {
    private static String kKB;
    private static final n kKC;
    
    static
    {
      AppMethodBeat.i(156171);
      kKC = new m.a.1();
      AppMethodBeat.o(156171);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.m
 * JD-Core Version:    0.7.0.1
 */