package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.ArrayList;

final class d$1
  extends com.tencent.mm.sdk.b.c<cr>
{
  d$1(d paramd)
  {
    AppMethodBeat.i(21725);
    this.__eventId = cr.class.getName().hashCode();
    AppMethodBeat.o(21725);
  }
  
  private boolean a(cr paramcr)
  {
    AppMethodBeat.i(21726);
    Object localObject;
    if ((paramcr instanceof cr))
    {
      ab.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
      aw.aaz();
      int i = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yzZ, Integer.valueOf(0))).intValue();
      int j = g.Nq().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
      ab.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (i != j)
      {
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yzZ, Integer.valueOf(j));
        r.aiP().lR(26);
        paramcr = c.bIZ();
        localObject = com.tencent.mm.compatible.util.e.eQv + "ipcallCountryCodeConfig.cfg";
        ab.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[] { localObject });
      }
    }
    try
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramcr.bRB = false;
      paramcr.nLW.clear();
    }
    catch (Exception paramcr)
    {
      for (;;)
      {
        ab.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[] { paramcr.getMessage() });
      }
    }
    this.nLZ.iy(true);
    AppMethodBeat.o(21726);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.1
 * JD-Core Version:    0.7.0.1
 */