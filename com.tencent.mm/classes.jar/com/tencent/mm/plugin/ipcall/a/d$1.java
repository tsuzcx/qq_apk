package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.h.a.co;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.ArrayList;

final class d$1
  extends com.tencent.mm.sdk.b.c<co>
{
  d$1(d paramd)
  {
    this.udX = co.class.getName().hashCode();
  }
  
  private boolean a(co paramco)
  {
    Object localObject;
    if ((paramco instanceof co))
    {
      y.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
      au.Hx();
      int i = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.upZ, Integer.valueOf(0))).intValue();
      int j = g.AA().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
      y.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (i != j)
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.upZ, Integer.valueOf(j));
        r.PK().iZ(26);
        paramco = c.bbS();
        localObject = com.tencent.mm.compatible.util.e.dOP + "ipcallCountryCodeConfig.cfg";
        y.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[] { localObject });
      }
    }
    try
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramco.dBn = false;
      paramco.loA.clear();
    }
    catch (Exception paramco)
    {
      for (;;)
      {
        y.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[] { paramco.getMessage() });
      }
    }
    this.loD.gP(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.1
 * JD-Core Version:    0.7.0.1
 */