package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.j;
import com.tencent.mm.az.k;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class d
  implements f
{
  private static d loB = null;
  private boolean dZI = false;
  com.tencent.mm.sdk.b.c loC = new d.1(this);
  private int retryCount = 0;
  
  public static d bbW()
  {
    if (loB == null) {
      loB = new d();
    }
    return loB;
  }
  
  private static void bbX()
  {
    Object localObject = r.PK().ja(26);
    if ((localObject != null) && (localObject.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new k(bool);
      au.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      return;
    }
  }
  
  private void bbY()
  {
    this.dZI = false;
    this.retryCount = 0;
    long l = System.currentTimeMillis();
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.uqa, Long.valueOf(l));
  }
  
  public final void gP(boolean paramBoolean)
  {
    if (!au.DK())
    {
      y.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
      return;
    }
    if (this.dZI)
    {
      y.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
      return;
    }
    y.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      au.Hx();
      long l1 = ((Long)com.tencent.mm.model.c.Dz().get(ac.a.uqa, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      if ((l1 != 0L) && (Math.abs(l2 - l1) < 86400000L))
      {
        y.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
        return;
      }
    }
    y.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
    this.dZI = true;
    au.Dk().a(159, this);
    au.Dk().a(160, this);
    bbX();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.dZI) });
    if (!this.dZI) {
      return;
    }
    if ((paramInt1 != 0) && (paramInt2 != 0)) {}
    for (boolean bool = false;; bool = true)
    {
      y.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", new Object[] { Boolean.valueOf(bool) });
      if (paramm.getType() == 159)
      {
        if (bool)
        {
          y.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
          paramString = r.PK().ja(26);
          if ((paramString == null) || (paramString.length == 0))
          {
            y.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
            bbY();
            return;
          }
          y.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[] { Integer.valueOf(paramString.length) });
          paramString = paramString[0];
          y.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[] { Integer.valueOf(paramString.bOa), Integer.valueOf(paramString.id), Integer.valueOf(paramString.version), Integer.valueOf(paramString.status), paramString.PG() });
          if (paramString.status == 3)
          {
            y.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
            return;
          }
          if (paramString.status != 5)
          {
            y.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
            c.bbS().gO(true);
            bbY();
            return;
          }
          paramString = new j(paramString.id, 26);
          au.Dk().a(paramString, 0);
          return;
        }
        if (this.retryCount < 3)
        {
          this.retryCount += 1;
          bbX();
          y.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", new Object[] { Integer.valueOf(this.retryCount) });
          return;
        }
        y.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
        return;
      }
      if ((paramm.getType() != 160) || (!bool)) {
        break;
      }
      y.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
      c.bbS().gO(true);
      bbY();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d
 * JD-Core Version:    0.7.0.1
 */