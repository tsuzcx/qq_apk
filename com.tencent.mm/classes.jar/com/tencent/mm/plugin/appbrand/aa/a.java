package com.tencent.mm.plugin.appbrand.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.a;

public final class a
  implements by.a
{
  public final void a(bb parambb, by paramby)
  {
    AppMethodBeat.i(48310);
    if ((parambb != null) && (!Util.isNullOrNil(parambb.field_username)))
    {
      paramby = parambb.field_username;
      au localau = ((n)h.ax(n.class)).bzA().JE(paramby);
      if ((localau == null) || ((int)localau.maN == 0))
      {
        Log.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[] { paramby });
        AppMethodBeat.o(48310);
        return;
      }
      if ((au.Hh(paramby)) && (!au.bwc(paramby)))
      {
        Log.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
        parambb.BH("appbrandcustomerservicemsg");
        ((f)h.ax(f.class)).e(parambb);
        AppMethodBeat.o(48310);
        return;
      }
      if (au.bwy(paramby))
      {
        Log.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
        parambb.BH(null);
      }
    }
    AppMethodBeat.o(48310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.a
 * JD-Core Version:    0.7.0.1
 */