package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.d.e.a;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.n.a;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1
  implements n.a
{
  d$1(d paramd, String paramString1, String paramString2, long paramLong) {}
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(143111);
    d.b(e.a.bAL, "codeLib " + this.gTT + " inject fail!");
    d.dU(false);
    AppMethodBeat.o(143111);
  }
  
  public final void onSuccess(String paramString)
  {
    int j = -1;
    AppMethodBeat.i(143110);
    String str1;
    if ((((c)this.hsa.bEw).aud()) || (((c)this.hsa.bEw).isRunning()))
    {
      paramString = ((c)this.hsa.bEw).wj();
      str1 = this.gTT;
      if (paramString == null) {
        break label187;
      }
    }
    label187:
    for (int i = paramString.hashCode();; i = -1)
    {
      ab.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] %s runtime.hashCode = [%d]", new Object[] { str1, Integer.valueOf(i) });
      str1 = ((c)this.hsa.bEw).getAppId();
      String str2 = this.gTT;
      String str3 = this.hrY;
      long l = this.hrZ;
      i = j;
      if (paramString != null) {
        i = paramString.hashCode();
      }
      com.tencent.mm.plugin.appbrand.report.quality.a.a(str1, str2, str3, l, i);
      d.b(e.a.bAJ, "codeLib " + this.gTT + " inject success!");
      d.dU(true);
      AppMethodBeat.o(143110);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.1
 * JD-Core Version:    0.7.0.1
 */