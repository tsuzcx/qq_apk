package com.tencent.mm.plugin.appbrand.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
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
      as localas = ((l)g.af(l.class)).aSN().Kn(parambw);
      if ((localas == null) || ((int)localas.gMZ == 0))
      {
        Log.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[] { parambw });
        AppMethodBeat.o(48310);
        return;
      }
      if ((as.HF(parambw)) && (!ab.Jf(parambw)))
      {
        Log.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
        paramaz.Co("appbrandcustomerservicemsg");
        ((e)g.af(e.class)).c(paramaz);
        AppMethodBeat.o(48310);
        return;
      }
      if (ab.JB(parambw))
      {
        Log.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
        paramaz.Co(null);
      }
    }
    AppMethodBeat.o(48310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.a
 * JD-Core Version:    0.7.0.1
 */