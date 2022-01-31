package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$2
  implements Runnable
{
  k$2(k paramk, i parami, MiniProgramNavigationBackResult paramMiniProgramNavigationBackResult) {}
  
  public final void run()
  {
    AppMethodBeat.i(86712);
    if (!this.gQD.i(this.gQE))
    {
      d.e("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", new Object[] { this.gQE.mAppId });
      AppMethodBeat.o(86712);
      return;
    }
    i locali = this.gQD.f(this.gQE);
    if (locali != null) {
      locali.a(this.gQE.wZ(), this.gQF);
    }
    String str2 = this.gQE.mAppId;
    if (locali == null) {}
    for (String str1 = "null";; str1 = locali.mAppId)
    {
      d.i("MicroMsg.AppBrandRuntimeContainer", "close before run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(this.gQD.bFa) });
      this.gQD.b(locali, this.gQE, new k.2.1(this, locali));
      AppMethodBeat.o(86712);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.2
 * JD-Core Version:    0.7.0.1
 */