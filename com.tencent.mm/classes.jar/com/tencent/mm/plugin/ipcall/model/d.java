package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.app.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelpackage.o;
import com.tencent.mm.modelpackage.t;
import com.tencent.mm.modelpackage.u;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class d
  implements h
{
  private static d JFR = null;
  IListener JFS;
  private boolean mjj;
  private int retryCount;
  
  private d()
  {
    AppMethodBeat.i(25349);
    this.retryCount = 0;
    this.mjj = false;
    this.JFS = new IPCallCoutryConfigUpdater.1(this, f.hfK);
    AppMethodBeat.o(25349);
  }
  
  public static d fRf()
  {
    AppMethodBeat.i(25350);
    if (JFR == null) {
      JFR = new d();
    }
    d locald = JFR;
    AppMethodBeat.o(25350);
    return locald;
  }
  
  private static void fRg()
  {
    AppMethodBeat.i(25352);
    Object localObject = u.bLH().wK(26);
    if ((localObject != null) && (localObject.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new com.tencent.mm.modelpackage.p(bool);
      bh.aZW().a((com.tencent.mm.am.p)localObject, 0);
      AppMethodBeat.o(25352);
      return;
    }
  }
  
  private void fRh()
  {
    AppMethodBeat.i(25354);
    this.mjj = false;
    this.retryCount = 0;
    long l = System.currentTimeMillis();
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acKw, Long.valueOf(l));
    AppMethodBeat.o(25354);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(25353);
    Log.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.mjj) });
    if (!this.mjj)
    {
      AppMethodBeat.o(25353);
      return;
    }
    if ((paramInt1 != 0) && (paramInt2 != 0)) {}
    for (boolean bool = false;; bool = true)
    {
      Log.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", new Object[] { Boolean.valueOf(bool) });
      if (paramp.getType() == 159)
      {
        if (bool)
        {
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
          paramString = u.bLH().wK(26);
          if ((paramString == null) || (paramString.length == 0))
          {
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
            fRh();
            AppMethodBeat.o(25353);
            return;
          }
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[] { Integer.valueOf(paramString.length) });
          paramString = paramString[0];
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[] { Integer.valueOf(paramString.hJK), Integer.valueOf(paramString.id), Integer.valueOf(paramString.version), Integer.valueOf(paramString.status), paramString.bLC() });
          if (paramString.status == 3)
          {
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
            AppMethodBeat.o(25353);
            return;
          }
          if (paramString.status != 5)
          {
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
            c.fRb().xA(true);
            fRh();
            AppMethodBeat.o(25353);
            return;
          }
          paramString = new o(paramString.id, 26);
          bh.aZW().a(paramString, 0);
          AppMethodBeat.o(25353);
          return;
        }
        if (this.retryCount < 3)
        {
          this.retryCount += 1;
          fRg();
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", new Object[] { Integer.valueOf(this.retryCount) });
          AppMethodBeat.o(25353);
          return;
        }
        Log.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
        AppMethodBeat.o(25353);
        return;
      }
      if ((paramp.getType() == 160) && (bool))
      {
        Log.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
        c.fRb().xA(true);
        fRh();
      }
      AppMethodBeat.o(25353);
      return;
    }
  }
  
  public final void xB(boolean paramBoolean)
  {
    AppMethodBeat.i(25351);
    if (!bh.baz())
    {
      Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
      AppMethodBeat.o(25351);
      return;
    }
    if (this.mjj)
    {
      Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
      AppMethodBeat.o(25351);
      return;
    }
    Log.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      bh.bCz();
      long l1 = ((Long)com.tencent.mm.model.c.ban().get(at.a.acKw, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      if ((l1 != 0L) && (Math.abs(l2 - l1) < 86400000L))
      {
        Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
        AppMethodBeat.o(25351);
        return;
      }
    }
    Log.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
    this.mjj = true;
    bh.aZW().a(159, this);
    bh.aZW().a(160, this);
    fRg();
    AppMethodBeat.o(25351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d
 * JD-Core Version:    0.7.0.1
 */