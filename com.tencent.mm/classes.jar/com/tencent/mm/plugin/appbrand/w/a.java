package com.tencent.mm.plugin.appbrand.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;

public final class a
  implements bq.a
{
  public final void a(at paramat, bq parambq)
  {
    AppMethodBeat.i(48310);
    if ((paramat != null) && (!bt.isNullOrNil(paramat.field_username)))
    {
      parambq = paramat.field_username;
      am localam = ((l)g.ab(l.class)).azp().Bf(parambq);
      if ((localam == null) || ((int)localam.gfj == 0))
      {
        ad.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[] { parambq });
        AppMethodBeat.o(48310);
        return;
      }
      if ((am.yt(parambq)) && (!w.zQ(parambq)))
      {
        ad.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
        paramat.tD("appbrandcustomerservicemsg");
        ((e)g.ab(e.class)).c(paramat);
        AppMethodBeat.o(48310);
        return;
      }
      if (w.Am(parambq))
      {
        ad.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
        paramat.tD(null);
      }
    }
    AppMethodBeat.o(48310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.a
 * JD-Core Version:    0.7.0.1
 */