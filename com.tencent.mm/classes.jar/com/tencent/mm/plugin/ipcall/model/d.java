package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bc.k;
import com.tencent.mm.bc.l;
import com.tencent.mm.bc.o;
import com.tencent.mm.bc.p;
import com.tencent.mm.bc.t;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;

public final class d
  implements com.tencent.mm.al.g
{
  private static d szP = null;
  private boolean fOm;
  private int retryCount;
  com.tencent.mm.sdk.b.c szQ;
  
  private d()
  {
    AppMethodBeat.i(25349);
    this.retryCount = 0;
    this.fOm = false;
    this.szQ = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(cx paramAnonymouscx)
      {
        AppMethodBeat.i(25347);
        Object localObject;
        if ((paramAnonymouscx instanceof cx))
        {
          ad.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
          az.arV();
          int i = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.Fiv, Integer.valueOf(0))).intValue();
          int j = com.tencent.mm.m.g.Zd().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
          ad.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i != j)
          {
            az.arV();
            com.tencent.mm.model.c.afk().set(ae.a.Fiv, Integer.valueOf(j));
            t.azY().oz(26);
            paramAnonymouscx = c.cGV();
            localObject = b.ahZ() + "ipcallCountryCodeConfig.cfg";
            ad.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[] { localObject });
          }
        }
        try
        {
          localObject = new com.tencent.mm.vfs.e((String)localObject);
          if (((com.tencent.mm.vfs.e)localObject).exists()) {
            ((com.tencent.mm.vfs.e)localObject).delete();
          }
          paramAnonymouscx.csX = false;
          paramAnonymouscx.szO.clear();
        }
        catch (Exception paramAnonymouscx)
        {
          for (;;)
          {
            ad.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[] { paramAnonymouscx.getMessage() });
          }
        }
        d.this.mo(true);
        AppMethodBeat.o(25347);
        return false;
      }
    };
    AppMethodBeat.o(25349);
  }
  
  public static d cGZ()
  {
    AppMethodBeat.i(25350);
    if (szP == null) {
      szP = new d();
    }
    d locald = szP;
    AppMethodBeat.o(25350);
    return locald;
  }
  
  private static void cHa()
  {
    AppMethodBeat.i(25352);
    Object localObject = t.azY().oA(26);
    if ((localObject != null) && (localObject.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new l(bool);
      az.aeS().a((n)localObject, 0);
      AppMethodBeat.o(25352);
      return;
    }
  }
  
  private void cHb()
  {
    AppMethodBeat.i(25354);
    this.fOm = false;
    this.retryCount = 0;
    long l = System.currentTimeMillis();
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.Fiw, Long.valueOf(l));
    AppMethodBeat.o(25354);
  }
  
  public final void mo(boolean paramBoolean)
  {
    AppMethodBeat.i(25351);
    if (!az.afw())
    {
      ad.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
      AppMethodBeat.o(25351);
      return;
    }
    if (this.fOm)
    {
      ad.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
      AppMethodBeat.o(25351);
      return;
    }
    ad.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      az.arV();
      long l1 = ((Long)com.tencent.mm.model.c.afk().get(ae.a.Fiw, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      if ((l1 != 0L) && (Math.abs(l2 - l1) < 86400000L))
      {
        ad.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
        AppMethodBeat.o(25351);
        return;
      }
    }
    ad.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
    this.fOm = true;
    az.aeS().a(159, this);
    az.aeS().a(160, this);
    cHa();
    AppMethodBeat.o(25351);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25353);
    ad.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.fOm) });
    if (!this.fOm)
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
          paramString = t.azY().oA(26);
          if ((paramString == null) || (paramString.length == 0))
          {
            ad.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
            cHb();
            AppMethodBeat.o(25353);
            return;
          }
          ad.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[] { Integer.valueOf(paramString.length) });
          paramString = paramString[0];
          ad.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[] { Integer.valueOf(paramString.dkC), Integer.valueOf(paramString.id), Integer.valueOf(paramString.version), Integer.valueOf(paramString.status), paramString.azT() });
          if (paramString.status == 3)
          {
            ad.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
            AppMethodBeat.o(25353);
            return;
          }
          if (paramString.status != 5)
          {
            ad.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
            c.cGV().mn(true);
            cHb();
            AppMethodBeat.o(25353);
            return;
          }
          paramString = new k(paramString.id, 26);
          az.aeS().a(paramString, 0);
          AppMethodBeat.o(25353);
          return;
        }
        if (this.retryCount < 3)
        {
          this.retryCount += 1;
          cHa();
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
        c.cGV().mn(true);
        cHb();
      }
      AppMethodBeat.o(25353);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d
 * JD-Core Version:    0.7.0.1
 */