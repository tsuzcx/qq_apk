package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.ad;

final class b$3
  implements q.a
{
  b$3(b paramb, long paramLong, boolean paramBoolean) {}
  
  public final void cT(String paramString)
  {
    AppMethodBeat.i(192191);
    ad.e("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Failed");
    AppMethodBeat.o(192191);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(192190);
    ad.i("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Success");
    long l1 = System.currentTimeMillis();
    long l2 = this.coM;
    if (this.coN) {}
    for (int i = 1;; i = 0)
    {
      x.a(3, l1 - l2, i, ((c)this.coL.El()).getAppId(), -1, 0, ((c)this.coL.El()).aVF().aZp());
      AppMethodBeat.o(192190);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b.3
 * JD-Core Version:    0.7.0.1
 */