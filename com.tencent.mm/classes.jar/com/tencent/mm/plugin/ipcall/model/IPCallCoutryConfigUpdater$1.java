package com.tencent.mm.plugin.ipcall.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.du;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelpackage.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;

class IPCallCoutryConfigUpdater$1
  extends IListener<du>
{
  IPCallCoutryConfigUpdater$1(d paramd, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(303684);
    this.__eventId = du.class.getName().hashCode();
    AppMethodBeat.o(303684);
  }
  
  private boolean a(du paramdu)
  {
    AppMethodBeat.i(25347);
    Object localObject;
    if ((paramdu instanceof du))
    {
      Log.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
      bh.bCz();
      int i = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acKv, Integer.valueOf(0))).intValue();
      int j = i.aRC().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
      Log.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (i != j)
      {
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acKv, Integer.valueOf(j));
        com.tencent.mm.modelpackage.u.bLH().wJ(26);
        paramdu = c.fRb();
        localObject = b.bmr() + "ipcallCountryCodeConfig.cfg";
        Log.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[] { localObject });
      }
    }
    try
    {
      localObject = new com.tencent.mm.vfs.u((String)localObject);
      if (((com.tencent.mm.vfs.u)localObject).jKS()) {
        ((com.tencent.mm.vfs.u)localObject).diJ();
      }
      paramdu.isInit = false;
      paramdu.JFQ.clear();
    }
    catch (Exception paramdu)
    {
      for (;;)
      {
        Log.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[] { paramdu.getMessage() });
      }
    }
    this.JFT.xB(true);
    AppMethodBeat.o(25347);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.IPCallCoutryConfigUpdater.1
 * JD-Core Version:    0.7.0.1
 */