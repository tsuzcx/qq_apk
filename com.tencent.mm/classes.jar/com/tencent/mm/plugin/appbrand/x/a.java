package com.tencent.mm.plugin.appbrand.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.a;

public final class a
  implements bh.a
{
  public final void a(am paramam, bh parambh)
  {
    AppMethodBeat.i(48310);
    if ((paramam != null) && (!bt.isNullOrNil(paramam.field_username)))
    {
      parambh = paramam.field_username;
      af localaf = ((k)g.ab(k.class)).apM().aHY(parambh);
      if ((localaf == null) || ((int)localaf.fId == 0))
      {
        ad.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[] { parambh });
        AppMethodBeat.o(48310);
        return;
      }
      if ((af.rz(parambh)) && (!w.sQ(parambh)))
      {
        ad.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
        paramam.nN("appbrandcustomerservicemsg");
        ((f)g.ab(f.class)).c(paramam);
        AppMethodBeat.o(48310);
        return;
      }
      if (w.tm(parambh))
      {
        ad.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
        paramam.nN(null);
      }
    }
    AppMethodBeat.o(48310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x.a
 * JD-Core Version:    0.7.0.1
 */