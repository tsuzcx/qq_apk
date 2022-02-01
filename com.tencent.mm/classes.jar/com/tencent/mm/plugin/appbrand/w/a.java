package com.tencent.mm.plugin.appbrand.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bk.a;

public final class a
  implements bk.a
{
  public final void a(ap paramap, bk parambk)
  {
    AppMethodBeat.i(48310);
    if ((paramap != null) && (!bs.isNullOrNil(paramap.field_username)))
    {
      parambk = paramap.field_username;
      ai localai = ((k)g.ab(k.class)).awB().aNt(parambk);
      if ((localai == null) || ((int)localai.fLJ == 0))
      {
        ac.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[] { parambk });
        AppMethodBeat.o(48310);
        return;
      }
      if ((ai.vC(parambk)) && (!w.wT(parambk)))
      {
        ac.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
        paramap.qT("appbrandcustomerservicemsg");
        ((e)g.ab(e.class)).c(paramap);
        AppMethodBeat.o(48310);
        return;
      }
      if (w.xp(parambk))
      {
        ac.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
        paramap.qT(null);
      }
    }
    AppMethodBeat.o(48310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.a
 * JD-Core Version:    0.7.0.1
 */