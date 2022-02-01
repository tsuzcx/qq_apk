package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.k;
import com.tencent.mm.bb.l;
import com.tencent.mm.bb.o;
import com.tencent.mm.bb.p;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;

public final class d
  implements com.tencent.mm.ak.g
{
  private static d tHz = null;
  private boolean fRX;
  private int retryCount;
  com.tencent.mm.sdk.b.c tHA;
  
  private d()
  {
    AppMethodBeat.i(25349);
    this.retryCount = 0;
    this.fRX = false;
    this.tHA = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(cy paramAnonymouscy)
      {
        AppMethodBeat.i(25347);
        Object localObject;
        if ((paramAnonymouscy instanceof cy))
        {
          ac.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
          az.ayM();
          int i = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GGk, Integer.valueOf(0))).intValue();
          int j = com.tencent.mm.m.g.ZY().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
          ac.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i != j)
          {
            az.ayM();
            com.tencent.mm.model.c.agA().set(ah.a.GGk, Integer.valueOf(j));
            t.aGO().pn(26);
            paramAnonymouscy = c.cUg();
            localObject = b.aoZ() + "ipcallCountryCodeConfig.cfg";
            ac.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[] { localObject });
          }
        }
        try
        {
          localObject = new com.tencent.mm.vfs.e((String)localObject);
          if (((com.tencent.mm.vfs.e)localObject).exists()) {
            ((com.tencent.mm.vfs.e)localObject).delete();
          }
          paramAnonymouscy.cqf = false;
          paramAnonymouscy.tHy.clear();
        }
        catch (Exception paramAnonymouscy)
        {
          for (;;)
          {
            ac.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[] { paramAnonymouscy.getMessage() });
          }
        }
        d.this.nh(true);
        AppMethodBeat.o(25347);
        return false;
      }
    };
    AppMethodBeat.o(25349);
  }
  
  public static d cUk()
  {
    AppMethodBeat.i(25350);
    if (tHz == null) {
      tHz = new d();
    }
    d locald = tHz;
    AppMethodBeat.o(25350);
    return locald;
  }
  
  private static void cUl()
  {
    AppMethodBeat.i(25352);
    Object localObject = t.aGO().po(26);
    if ((localObject != null) && (localObject.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new l(bool);
      az.agi().a((n)localObject, 0);
      AppMethodBeat.o(25352);
      return;
    }
  }
  
  private void cUm()
  {
    AppMethodBeat.i(25354);
    this.fRX = false;
    this.retryCount = 0;
    long l = System.currentTimeMillis();
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GGl, Long.valueOf(l));
    AppMethodBeat.o(25354);
  }
  
  public final void nh(boolean paramBoolean)
  {
    AppMethodBeat.i(25351);
    if (!az.agM())
    {
      ac.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
      AppMethodBeat.o(25351);
      return;
    }
    if (this.fRX)
    {
      ac.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
      AppMethodBeat.o(25351);
      return;
    }
    ac.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      az.ayM();
      long l1 = ((Long)com.tencent.mm.model.c.agA().get(ah.a.GGl, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      if ((l1 != 0L) && (Math.abs(l2 - l1) < 86400000L))
      {
        ac.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
        AppMethodBeat.o(25351);
        return;
      }
    }
    ac.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
    this.fRX = true;
    az.agi().a(159, this);
    az.agi().a(160, this);
    cUl();
    AppMethodBeat.o(25351);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25353);
    ac.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.fRX) });
    if (!this.fRX)
    {
      AppMethodBeat.o(25353);
      return;
    }
    if ((paramInt1 != 0) && (paramInt2 != 0)) {}
    for (boolean bool = false;; bool = true)
    {
      ac.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", new Object[] { Boolean.valueOf(bool) });
      if (paramn.getType() == 159)
      {
        if (bool)
        {
          ac.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
          paramString = t.aGO().po(26);
          if ((paramString == null) || (paramString.length == 0))
          {
            ac.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
            cUm();
            AppMethodBeat.o(25353);
            return;
          }
          ac.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[] { Integer.valueOf(paramString.length) });
          paramString = paramString[0];
          ac.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[] { Integer.valueOf(paramString.dib), Integer.valueOf(paramString.id), Integer.valueOf(paramString.version), Integer.valueOf(paramString.status), paramString.aGJ() });
          if (paramString.status == 3)
          {
            ac.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
            AppMethodBeat.o(25353);
            return;
          }
          if (paramString.status != 5)
          {
            ac.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
            c.cUg().ng(true);
            cUm();
            AppMethodBeat.o(25353);
            return;
          }
          paramString = new k(paramString.id, 26);
          az.agi().a(paramString, 0);
          AppMethodBeat.o(25353);
          return;
        }
        if (this.retryCount < 3)
        {
          this.retryCount += 1;
          cUl();
          ac.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", new Object[] { Integer.valueOf(this.retryCount) });
          AppMethodBeat.o(25353);
          return;
        }
        ac.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
        AppMethodBeat.o(25353);
        return;
      }
      if ((paramn.getType() == 160) && (bool))
      {
        ac.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
        c.cUg().ng(true);
        cUm();
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