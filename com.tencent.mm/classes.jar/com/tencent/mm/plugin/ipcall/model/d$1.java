package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.s;
import com.tencent.mm.be.w;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;

final class d$1
  extends IListener<dk>
{
  d$1(d paramd)
  {
    AppMethodBeat.i(161379);
    this.__eventId = dk.class.getName().hashCode();
    AppMethodBeat.o(161379);
  }
  
  private boolean a(dk paramdk)
  {
    AppMethodBeat.i(25347);
    Object localObject;
    if ((paramdk instanceof dk))
    {
      Log.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
      bh.beI();
      int i = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vjb, Integer.valueOf(0))).intValue();
      int j = h.axc().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
      Log.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (i != j)
      {
        bh.beI();
        com.tencent.mm.model.c.aHp().set(ar.a.Vjb, Integer.valueOf(j));
        w.bnU().wI(26);
        paramdk = c.eJb();
        localObject = b.aSD() + "ipcallCountryCodeConfig.cfg";
        Log.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[] { localObject });
      }
    }
    try
    {
      localObject = new q((String)localObject);
      if (((q)localObject).ifE()) {
        ((q)localObject).cFq();
      }
      paramdk.isInit = false;
      paramdk.DOB.clear();
    }
    catch (Exception paramdk)
    {
      for (;;)
      {
        Log.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[] { paramdk.getMessage() });
      }
    }
    this.DOE.tq(true);
    AppMethodBeat.o(25347);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.1
 * JD-Core Version:    0.7.0.1
 */