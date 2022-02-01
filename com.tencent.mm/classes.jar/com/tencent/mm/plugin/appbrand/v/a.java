package com.tencent.mm.plugin.appbrand.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.a;

public final class a
  implements br.a
{
  public final void a(au paramau, br parambr)
  {
    AppMethodBeat.i(48310);
    if ((paramau != null) && (!bu.isNullOrNil(paramau.field_username)))
    {
      parambr = paramau.field_username;
      an localan = ((l)g.ab(l.class)).azF().BH(parambr);
      if ((localan == null) || ((int)localan.ght == 0))
      {
        ae.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[] { parambr });
        AppMethodBeat.o(48310);
        return;
      }
      if ((an.zd(parambr)) && (!x.AA(parambr)))
      {
        ae.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
        paramau.tY("appbrandcustomerservicemsg");
        ((e)g.ab(e.class)).c(paramau);
        AppMethodBeat.o(48310);
        return;
      }
      if (x.AW(parambr))
      {
        ae.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
        paramau.tY(null);
      }
    }
    AppMethodBeat.o(48310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.a
 * JD-Core Version:    0.7.0.1
 */