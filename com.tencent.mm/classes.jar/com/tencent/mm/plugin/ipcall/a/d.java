package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.ba.j;
import com.tencent.mm.ba.k;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class d
  implements f
{
  private static d nLX = null;
  private boolean fpN;
  com.tencent.mm.sdk.b.c nLY;
  private int retryCount;
  
  private d()
  {
    AppMethodBeat.i(21728);
    this.retryCount = 0;
    this.fpN = false;
    this.nLY = new d.1(this);
    AppMethodBeat.o(21728);
  }
  
  public static d bJd()
  {
    AppMethodBeat.i(21729);
    if (nLX == null) {
      nLX = new d();
    }
    d locald = nLX;
    AppMethodBeat.o(21729);
    return locald;
  }
  
  private static void bJe()
  {
    AppMethodBeat.i(21731);
    Object localObject = r.aiP().lS(26);
    if ((localObject != null) && (localObject.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new k(bool);
      aw.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      AppMethodBeat.o(21731);
      return;
    }
  }
  
  private void bJf()
  {
    AppMethodBeat.i(21733);
    this.fpN = false;
    this.retryCount = 0;
    long l = System.currentTimeMillis();
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yAa, Long.valueOf(l));
    AppMethodBeat.o(21733);
  }
  
  public final void iy(boolean paramBoolean)
  {
    AppMethodBeat.i(21730);
    if (!aw.RG())
    {
      ab.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
      AppMethodBeat.o(21730);
      return;
    }
    if (this.fpN)
    {
      ab.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
      AppMethodBeat.o(21730);
      return;
    }
    ab.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      aw.aaz();
      long l1 = ((Long)com.tencent.mm.model.c.Ru().get(ac.a.yAa, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      if ((l1 != 0L) && (Math.abs(l2 - l1) < 86400000L))
      {
        ab.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
        AppMethodBeat.o(21730);
        return;
      }
    }
    ab.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
    this.fpN = true;
    aw.Rc().a(159, this);
    aw.Rc().a(160, this);
    bJe();
    AppMethodBeat.o(21730);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(21732);
    ab.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.fpN) });
    if (!this.fpN)
    {
      AppMethodBeat.o(21732);
      return;
    }
    if ((paramInt1 != 0) && (paramInt2 != 0)) {}
    for (boolean bool = false;; bool = true)
    {
      ab.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", new Object[] { Boolean.valueOf(bool) });
      if (paramm.getType() == 159)
      {
        if (bool)
        {
          ab.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
          paramString = r.aiP().lS(26);
          if ((paramString == null) || (paramString.length == 0))
          {
            ab.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
            bJf();
            AppMethodBeat.o(21732);
            return;
          }
          ab.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[] { Integer.valueOf(paramString.length) });
          paramString = paramString[0];
          ab.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[] { Integer.valueOf(paramString.cvs), Integer.valueOf(paramString.id), Integer.valueOf(paramString.version), Integer.valueOf(paramString.status), paramString.aiK() });
          if (paramString.status == 3)
          {
            ab.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
            AppMethodBeat.o(21732);
            return;
          }
          if (paramString.status != 5)
          {
            ab.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
            c.bIZ().ix(true);
            bJf();
            AppMethodBeat.o(21732);
            return;
          }
          paramString = new j(paramString.id, 26);
          aw.Rc().a(paramString, 0);
          AppMethodBeat.o(21732);
          return;
        }
        if (this.retryCount < 3)
        {
          this.retryCount += 1;
          bJe();
          ab.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", new Object[] { Integer.valueOf(this.retryCount) });
          AppMethodBeat.o(21732);
          return;
        }
        ab.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
        AppMethodBeat.o(21732);
        return;
      }
      if ((paramm.getType() == 160) && (bool))
      {
        ab.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
        c.bIZ().ix(true);
        bJf();
      }
      AppMethodBeat.o(21732);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d
 * JD-Core Version:    0.7.0.1
 */