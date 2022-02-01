package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.bb.m;
import com.tencent.mm.bb.n;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.g.a.df;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;

public final class d
  implements i
{
  private static d yoA = null;
  private boolean gYQ;
  private int retryCount;
  IListener yoB;
  
  private d()
  {
    AppMethodBeat.i(25349);
    this.retryCount = 0;
    this.gYQ = false;
    this.yoB = new IListener()
    {
      private boolean a(df paramAnonymousdf)
      {
        AppMethodBeat.i(25347);
        Object localObject;
        if ((paramAnonymousdf instanceof df))
        {
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
          bg.aVF();
          int i = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NVb, Integer.valueOf(0))).intValue();
          int j = h.aqJ().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i != j)
          {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.NVb, Integer.valueOf(j));
            v.bev().tI(26);
            paramAnonymousdf = c.ead();
            localObject = b.aKB() + "ipcallCountryCodeConfig.cfg";
            Log.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[] { localObject });
          }
        }
        try
        {
          localObject = new o((String)localObject);
          if (((o)localObject).exists()) {
            ((o)localObject).delete();
          }
          paramAnonymousdf.isInit = false;
          paramAnonymousdf.yoz.clear();
        }
        catch (Exception paramAnonymousdf)
        {
          for (;;)
          {
            Log.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[] { paramAnonymousdf.getMessage() });
          }
        }
        d.this.qo(true);
        AppMethodBeat.o(25347);
        return false;
      }
    };
    AppMethodBeat.o(25349);
  }
  
  public static d eah()
  {
    AppMethodBeat.i(25350);
    if (yoA == null) {
      yoA = new d();
    }
    d locald = yoA;
    AppMethodBeat.o(25350);
    return locald;
  }
  
  private static void eai()
  {
    AppMethodBeat.i(25352);
    Object localObject = v.bev().tJ(26);
    if ((localObject != null) && (localObject.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new n(bool);
      bg.azz().a((com.tencent.mm.ak.q)localObject, 0);
      AppMethodBeat.o(25352);
      return;
    }
  }
  
  private void eaj()
  {
    AppMethodBeat.i(25354);
    this.gYQ = false;
    this.retryCount = 0;
    long l = System.currentTimeMillis();
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NVc, Long.valueOf(l));
    AppMethodBeat.o(25354);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(25353);
    Log.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.gYQ) });
    if (!this.gYQ)
    {
      AppMethodBeat.o(25353);
      return;
    }
    if ((paramInt1 != 0) && (paramInt2 != 0)) {}
    for (boolean bool = false;; bool = true)
    {
      Log.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", new Object[] { Boolean.valueOf(bool) });
      if (paramq.getType() == 159)
      {
        if (bool)
        {
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
          paramString = v.bev().tJ(26);
          if ((paramString == null) || (paramString.length == 0))
          {
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
            eaj();
            AppMethodBeat.o(25353);
            return;
          }
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[] { Integer.valueOf(paramString.length) });
          paramString = paramString[0];
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[] { Integer.valueOf(paramString.dMe), Integer.valueOf(paramString.id), Integer.valueOf(paramString.version), Integer.valueOf(paramString.status), paramString.beq() });
          if (paramString.status == 3)
          {
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
            AppMethodBeat.o(25353);
            return;
          }
          if (paramString.status != 5)
          {
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
            c.ead().qn(true);
            eaj();
            AppMethodBeat.o(25353);
            return;
          }
          paramString = new m(paramString.id, 26);
          bg.azz().a(paramString, 0);
          AppMethodBeat.o(25353);
          return;
        }
        if (this.retryCount < 3)
        {
          this.retryCount += 1;
          eai();
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", new Object[] { Integer.valueOf(this.retryCount) });
          AppMethodBeat.o(25353);
          return;
        }
        Log.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
        AppMethodBeat.o(25353);
        return;
      }
      if ((paramq.getType() == 160) && (bool))
      {
        Log.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
        c.ead().qn(true);
        eaj();
      }
      AppMethodBeat.o(25353);
      return;
    }
  }
  
  public final void qo(boolean paramBoolean)
  {
    AppMethodBeat.i(25351);
    if (!bg.aAc())
    {
      Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
      AppMethodBeat.o(25351);
      return;
    }
    if (this.gYQ)
    {
      Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
      AppMethodBeat.o(25351);
      return;
    }
    Log.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      bg.aVF();
      long l1 = ((Long)com.tencent.mm.model.c.azQ().get(ar.a.NVc, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      if ((l1 != 0L) && (Math.abs(l2 - l1) < 86400000L))
      {
        Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
        AppMethodBeat.o(25351);
        return;
      }
    }
    Log.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
    this.gYQ = true;
    bg.azz().a(159, this);
    bg.azz().a(160, this);
    eai();
    AppMethodBeat.o(25351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d
 * JD-Core Version:    0.7.0.1
 */