package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bc.k;
import com.tencent.mm.bc.l;
import com.tencent.mm.bc.o;
import com.tencent.mm.bc.p;
import com.tencent.mm.bc.t;
import com.tencent.mm.g.a.db;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;

public final class d
  implements f
{
  private static d uKm = null;
  private boolean glB;
  private int retryCount;
  com.tencent.mm.sdk.b.c uKn;
  
  private d()
  {
    AppMethodBeat.i(25349);
    this.retryCount = 0;
    this.glB = false;
    this.uKn = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(db paramAnonymousdb)
      {
        AppMethodBeat.i(25347);
        Object localObject;
        if ((paramAnonymousdb instanceof db))
        {
          ad.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
          ba.aBQ();
          int i = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.IsC, Integer.valueOf(0))).intValue();
          int j = g.acA().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
          ad.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i != j)
          {
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(al.a.IsC, Integer.valueOf(j));
            t.aJZ().pQ(26);
            paramAnonymousdb = c.ddr();
            localObject = b.arM() + "ipcallCountryCodeConfig.cfg";
            ad.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[] { localObject });
          }
        }
        try
        {
          localObject = new com.tencent.mm.vfs.e((String)localObject);
          if (((com.tencent.mm.vfs.e)localObject).exists()) {
            ((com.tencent.mm.vfs.e)localObject).delete();
          }
          paramAnonymousdb.cAX = false;
          paramAnonymousdb.uKl.clear();
        }
        catch (Exception paramAnonymousdb)
        {
          for (;;)
          {
            ad.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[] { paramAnonymousdb.getMessage() });
          }
        }
        d.this.nB(true);
        AppMethodBeat.o(25347);
        return false;
      }
    };
    AppMethodBeat.o(25349);
  }
  
  public static d ddv()
  {
    AppMethodBeat.i(25350);
    if (uKm == null) {
      uKm = new d();
    }
    d locald = uKm;
    AppMethodBeat.o(25350);
    return locald;
  }
  
  private static void ddw()
  {
    AppMethodBeat.i(25352);
    Object localObject = t.aJZ().pR(26);
    if ((localObject != null) && (localObject.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new l(bool);
      ba.aiU().a((n)localObject, 0);
      AppMethodBeat.o(25352);
      return;
    }
  }
  
  private void ddx()
  {
    AppMethodBeat.i(25354);
    this.glB = false;
    this.retryCount = 0;
    long l = System.currentTimeMillis();
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.IsD, Long.valueOf(l));
    AppMethodBeat.o(25354);
  }
  
  public final void nB(boolean paramBoolean)
  {
    AppMethodBeat.i(25351);
    if (!ba.ajx())
    {
      ad.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
      AppMethodBeat.o(25351);
      return;
    }
    if (this.glB)
    {
      ad.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
      AppMethodBeat.o(25351);
      return;
    }
    ad.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      ba.aBQ();
      long l1 = ((Long)com.tencent.mm.model.c.ajl().get(al.a.IsD, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      if ((l1 != 0L) && (Math.abs(l2 - l1) < 86400000L))
      {
        ad.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
        AppMethodBeat.o(25351);
        return;
      }
    }
    ad.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
    this.glB = true;
    ba.aiU().a(159, this);
    ba.aiU().a(160, this);
    ddw();
    AppMethodBeat.o(25351);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25353);
    ad.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.glB) });
    if (!this.glB)
    {
      AppMethodBeat.o(25353);
      return;
    }
    if ((paramInt1 != 0) && (paramInt2 != 0)) {}
    for (boolean bool = false;; bool = true)
    {
      ad.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", new Object[] { Boolean.valueOf(bool) });
      if (paramn.getType() == 159)
      {
        if (bool)
        {
          ad.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
          paramString = t.aJZ().pR(26);
          if ((paramString == null) || (paramString.length == 0))
          {
            ad.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
            ddx();
            AppMethodBeat.o(25353);
            return;
          }
          ad.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[] { Integer.valueOf(paramString.length) });
          paramString = paramString[0];
          ad.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[] { Integer.valueOf(paramString.dtF), Integer.valueOf(paramString.id), Integer.valueOf(paramString.version), Integer.valueOf(paramString.status), paramString.aJU() });
          if (paramString.status == 3)
          {
            ad.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
            AppMethodBeat.o(25353);
            return;
          }
          if (paramString.status != 5)
          {
            ad.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
            c.ddr().nA(true);
            ddx();
            AppMethodBeat.o(25353);
            return;
          }
          paramString = new k(paramString.id, 26);
          ba.aiU().a(paramString, 0);
          AppMethodBeat.o(25353);
          return;
        }
        if (this.retryCount < 3)
        {
          this.retryCount += 1;
          ddw();
          ad.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", new Object[] { Integer.valueOf(this.retryCount) });
          AppMethodBeat.o(25353);
          return;
        }
        ad.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
        AppMethodBeat.o(25353);
        return;
      }
      if ((paramn.getType() == 160) && (bool))
      {
        ad.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
        c.ddr().nA(true);
        ddx();
      }
      AppMethodBeat.o(25353);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d
 * JD-Core Version:    0.7.0.1
 */