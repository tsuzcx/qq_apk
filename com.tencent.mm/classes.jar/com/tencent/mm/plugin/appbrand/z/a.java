package com.tencent.mm.plugin.appbrand.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.a;

public final class a
  implements bw.a
{
  public final void a(az paramaz, bw parambw)
  {
    AppMethodBeat.i(48310);
    if ((paramaz != null) && (!Util.isNullOrNil(paramaz.field_username)))
    {
      parambw = paramaz.field_username;
      as localas = ((n)h.ae(n.class)).bbL().RG(parambw);
      if ((localas == null) || ((int)localas.jxt == 0))
      {
        Log.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[] { parambw });
        AppMethodBeat.o(48310);
        return;
      }
      if ((as.OS(parambw)) && (!ab.Qy(parambw)))
      {
        Log.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
        paramaz.Jc("appbrandcustomerservicemsg");
        ((e)h.ae(e.class)).c(paramaz);
        AppMethodBeat.o(48310);
        return;
      }
      if (ab.QU(parambw))
      {
        Log.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
        paramaz.Jc(null);
      }
    }
    AppMethodBeat.o(48310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.a
 * JD-Core Version:    0.7.0.1
 */