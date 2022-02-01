package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.be.n;
import com.tencent.mm.be.o;
import com.tencent.mm.be.r;
import com.tencent.mm.be.s;
import com.tencent.mm.be.w;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class d
  implements i
{
  private static d DOC = null;
  IListener DOD;
  private boolean jJQ;
  private int retryCount;
  
  private d()
  {
    AppMethodBeat.i(25349);
    this.retryCount = 0;
    this.jJQ = false;
    this.DOD = new d.1(this);
    AppMethodBeat.o(25349);
  }
  
  public static d eJf()
  {
    AppMethodBeat.i(25350);
    if (DOC == null) {
      DOC = new d();
    }
    d locald = DOC;
    AppMethodBeat.o(25350);
    return locald;
  }
  
  private static void eJg()
  {
    AppMethodBeat.i(25352);
    Object localObject = w.bnU().wJ(26);
    if ((localObject != null) && (localObject.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new o(bool);
      bh.aGY().a((q)localObject, 0);
      AppMethodBeat.o(25352);
      return;
    }
  }
  
  private void eJh()
  {
    AppMethodBeat.i(25354);
    this.jJQ = false;
    this.retryCount = 0;
    long l = System.currentTimeMillis();
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vjc, Long.valueOf(l));
    AppMethodBeat.o(25354);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25353);
    Log.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.jJQ) });
    if (!this.jJQ)
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
          paramString = w.bnU().wJ(26);
          if ((paramString == null) || (paramString.length == 0))
          {
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
            eJh();
            AppMethodBeat.o(25353);
            return;
          }
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[] { Integer.valueOf(paramString.length) });
          paramString = paramString[0];
          Log.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[] { Integer.valueOf(paramString.fES), Integer.valueOf(paramString.id), Integer.valueOf(paramString.version), Integer.valueOf(paramString.status), paramString.bnP() });
          if (paramString.status == 3)
          {
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
            AppMethodBeat.o(25353);
            return;
          }
          if (paramString.status != 5)
          {
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
            c.eJb().tp(true);
            eJh();
            AppMethodBeat.o(25353);
            return;
          }
          paramString = new n(paramString.id, 26);
          bh.aGY().a(paramString, 0);
          AppMethodBeat.o(25353);
          return;
        }
        if (this.retryCount < 3)
        {
          this.retryCount += 1;
          eJg();
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
        c.eJb().tp(true);
        eJh();
      }
      AppMethodBeat.o(25353);
      return;
    }
  }
  
  public final void tq(boolean paramBoolean)
  {
    AppMethodBeat.i(25351);
    if (!bh.aHB())
    {
      Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
      AppMethodBeat.o(25351);
      return;
    }
    if (this.jJQ)
    {
      Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
      AppMethodBeat.o(25351);
      return;
    }
    Log.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      bh.beI();
      long l1 = ((Long)com.tencent.mm.model.c.aHp().get(ar.a.Vjc, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      if ((l1 != 0L) && (Math.abs(l2 - l1) < 86400000L))
      {
        Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
        AppMethodBeat.o(25351);
        return;
      }
    }
    Log.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
    this.jJQ = true;
    bh.aGY().a(159, this);
    bh.aGY().a(160, this);
    eJg();
    AppMethodBeat.o(25351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d
 * JD-Core Version:    0.7.0.1
 */