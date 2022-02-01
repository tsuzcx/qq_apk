package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.l;
import com.tencent.mm.bb.o;
import com.tencent.mm.bb.p;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;

public final class d
  implements f
{
  private static d uVZ = null;
  private boolean gnW;
  private int retryCount;
  com.tencent.mm.sdk.b.c uWa;
  
  private d()
  {
    AppMethodBeat.i(25349);
    this.retryCount = 0;
    this.gnW = false;
    this.uWa = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(dc paramAnonymousdc)
      {
        AppMethodBeat.i(25347);
        Object localObject;
        if ((paramAnonymousdc instanceof dc))
        {
          ae.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
          bc.aCg();
          int i = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.IMY, Integer.valueOf(0))).intValue();
          int j = g.acL().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
          ae.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i != j)
          {
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(am.a.IMY, Integer.valueOf(j));
            t.aKs().pT(26);
            paramAnonymousdc = c.dgj();
            localObject = b.asb() + "ipcallCountryCodeConfig.cfg";
            ae.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[] { localObject });
          }
        }
        try
        {
          localObject = new com.tencent.mm.vfs.k((String)localObject);
          if (((com.tencent.mm.vfs.k)localObject).exists()) {
            ((com.tencent.mm.vfs.k)localObject).delete();
          }
          paramAnonymousdc.cBE = false;
          paramAnonymousdc.uVY.clear();
        }
        catch (Exception paramAnonymousdc)
        {
          for (;;)
          {
            ae.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[] { paramAnonymousdc.getMessage() });
          }
        }
        d.this.nF(true);
        AppMethodBeat.o(25347);
        return false;
      }
    };
    AppMethodBeat.o(25349);
  }
  
  public static d dgn()
  {
    AppMethodBeat.i(25350);
    if (uVZ == null) {
      uVZ = new d();
    }
    d locald = uVZ;
    AppMethodBeat.o(25350);
    return locald;
  }
  
  private static void dgo()
  {
    AppMethodBeat.i(25352);
    Object localObject = t.aKs().pU(26);
    if ((localObject != null) && (localObject.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new l(bool);
      bc.ajj().a((n)localObject, 0);
      AppMethodBeat.o(25352);
      return;
    }
  }
  
  private void dgp()
  {
    AppMethodBeat.i(25354);
    this.gnW = false;
    this.retryCount = 0;
    long l = System.currentTimeMillis();
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IMZ, Long.valueOf(l));
    AppMethodBeat.o(25354);
  }
  
  public final void nF(boolean paramBoolean)
  {
    AppMethodBeat.i(25351);
    if (!bc.ajM())
    {
      ae.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
      AppMethodBeat.o(25351);
      return;
    }
    if (this.gnW)
    {
      ae.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
      AppMethodBeat.o(25351);
      return;
    }
    ae.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      bc.aCg();
      long l1 = ((Long)com.tencent.mm.model.c.ajA().get(am.a.IMZ, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      if ((l1 != 0L) && (Math.abs(l2 - l1) < 86400000L))
      {
        ae.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
        AppMethodBeat.o(25351);
        return;
      }
    }
    ae.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
    this.gnW = true;
    bc.ajj().a(159, this);
    bc.ajj().a(160, this);
    dgo();
    AppMethodBeat.o(25351);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25353);
    ae.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.gnW) });
    if (!this.gnW)
    {
      AppMethodBeat.o(25353);
      return;
    }
    if ((paramInt1 != 0) && (paramInt2 != 0)) {}
    for (boolean bool = false;; bool = true)
    {
      ae.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", new Object[] { Boolean.valueOf(bool) });
      if (paramn.getType() == 159)
      {
        if (bool)
        {
          ae.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
          paramString = t.aKs().pU(26);
          if ((paramString == null) || (paramString.length == 0))
          {
            ae.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
            dgp();
            AppMethodBeat.o(25353);
            return;
          }
          ae.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[] { Integer.valueOf(paramString.length) });
          paramString = paramString[0];
          ae.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[] { Integer.valueOf(paramString.duK), Integer.valueOf(paramString.id), Integer.valueOf(paramString.version), Integer.valueOf(paramString.status), paramString.aKn() });
          if (paramString.status == 3)
          {
            ae.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
            AppMethodBeat.o(25353);
            return;
          }
          if (paramString.status != 5)
          {
            ae.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
            c.dgj().nE(true);
            dgp();
            AppMethodBeat.o(25353);
            return;
          }
          paramString = new com.tencent.mm.bb.k(paramString.id, 26);
          bc.ajj().a(paramString, 0);
          AppMethodBeat.o(25353);
          return;
        }
        if (this.retryCount < 3)
        {
          this.retryCount += 1;
          dgo();
          ae.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", new Object[] { Integer.valueOf(this.retryCount) });
          AppMethodBeat.o(25353);
          return;
        }
        ae.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
        AppMethodBeat.o(25353);
        return;
      }
      if ((paramn.getType() == 160) && (bool))
      {
        ae.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
        c.dgj().nE(true);
        dgp();
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