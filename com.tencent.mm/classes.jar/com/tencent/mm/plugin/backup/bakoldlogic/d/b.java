package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.mm.cf.h;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.o;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import junit.framework.Assert;

public final class b
  extends com.tencent.mm.plugin.backup.b.a
{
  private static b hPl;
  private static int hPo = 0;
  private c hPm;
  private a hPn;
  private c hPp;
  
  private boolean a(PLong paramPLong1, PLong paramPLong2, PLong paramPLong3, b.a parama, int paramInt)
  {
    com.tencent.mm.model.au.Hx();
    com.tencent.mm.model.c.closeDB();
    y.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
    com.tencent.mm.model.au.Hx();
    long l = e.aeQ(com.tencent.mm.model.c.Dw());
    com.tencent.mm.model.au.Hx();
    paramPLong3.value = (l + e.aeQ(com.tencent.mm.model.c.Dx()));
    l = paramPLong3.value;
    com.tencent.mm.model.au.Hx();
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(l, paramPLong1, paramPLong2, com.tencent.mm.model.c.FU()))
    {
      y.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", new Object[] { Long.valueOf(paramPLong3.value) });
      parama.hPx = false;
      parama.hPy = paramPLong1.value;
      parama.hPz = paramPLong2.value;
      parama.dbSize = paramPLong3.value;
      return false;
    }
    com.tencent.mm.model.au.Hx();
    Object localObject1 = com.tencent.mm.model.c.Dw();
    Object localObject2 = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    e.r((String)localObject1, com.tencent.mm.model.c.Dw() + ".tem");
    com.tencent.mm.model.au.Hx();
    localObject1 = com.tencent.mm.model.c.Dx();
    localObject2 = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    e.r((String)localObject1, com.tencent.mm.model.c.Dx() + ".tem");
    localObject1 = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    localObject1 = com.tencent.mm.model.c.Dx() + "-journal";
    localObject2 = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    e.r((String)localObject1, com.tencent.mm.model.c.Dx() + ".tem-journal");
    localObject1 = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    localObject1 = com.tencent.mm.model.c.Dx() + "-wal";
    localObject2 = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    e.r((String)localObject1, com.tencent.mm.model.c.Dx() + ".tem-wal");
    y.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
    com.tencent.mm.kernel.g.DN().release();
    com.tencent.mm.kernel.g.DN().initialize();
    y.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
    localObject1 = avS();
    com.tencent.mm.model.au.Hx();
    localObject2 = com.tencent.mm.model.c.FU();
    com.tencent.mm.model.au.Hx();
    int i = com.tencent.mm.model.c.CK();
    y.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", new Object[] { localObject2, Integer.valueOf(i) });
    ((c)localObject1).uin = i;
    ((c)localObject1).dKt = ((String)localObject2);
    y.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
    localObject1 = avS();
    localObject2 = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    localObject2 = com.tencent.mm.model.c.Dw() + ".tem";
    com.tencent.mm.model.au.Hx();
    i = com.tencent.mm.model.c.CK();
    Object localObject3 = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    localObject3 = com.tencent.mm.model.c.Dx() + ".tem";
    y.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", new Object[] { ((c)localObject1).hPC, localObject2, Integer.valueOf(i), localObject3, bk.csb() });
    if (((c)localObject1).dKu != null) {
      y.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
    }
    String str;
    if (paramInt > 0)
    {
      if ((((c)localObject1).hPC != null) && (!((c)localObject1).hPC.booleanValue()))
      {
        y.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
        ((c)localObject1).avV();
      }
      str = "bakoldInitDB here  isTempDb should null :" + ((c)localObject1).hPC;
      if (((c)localObject1).hPC != null) {
        break label718;
      }
    }
    label718:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(str, bool);
      ((c)localObject1).hPC = Boolean.valueOf(true);
      ((c)localObject1).dKu = new h(new c.2((c)localObject1));
      if (((c)localObject1).dKu.a((String)localObject2, (String)localObject3, "", i, q.zf(), new HashMap(), false)) {
        break;
      }
      throw new com.tencent.mm.model.b((byte)0);
    }
    ((c)localObject1).hMK = new com.tencent.mm.storage.z(((c)localObject1).dKu);
    localObject2 = (com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    ((c)localObject1).hML = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).d(((c)localObject1).dKu);
    ((c)localObject1).hMN = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).e(((c)localObject1).dKu);
    ((c)localObject1).hMM = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).a(((c)localObject1).dKu, ((c)localObject1).hML, ((c)localObject1).hMN);
    ((c)localObject1).hMM.a(new com.tencent.mm.storage.au(((c)localObject1).hMM));
    ((c)localObject1).hMM.a(new o(((c)localObject1).hMM));
    ((c)localObject1).hMQ = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).f(((c)localObject1).dKu);
    ((c)localObject1).hMO = new com.tencent.mm.as.g(((c)localObject1).dKu);
    if (com.tencent.mm.br.d.SP("emoji")) {
      ((c)localObject1).hMP = new com.tencent.mm.storage.emotion.d(((c)localObject1).dKu);
    }
    ((c)localObject1).hMS = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).c(((c)localObject1).dKu);
    ((c)localObject1).hMR = new t(((c)localObject1).dKu);
    ((c)localObject1).hMT = new com.tencent.mm.pluginsdk.model.app.k(((c)localObject1).dKu);
    ((c)localObject1).hMU = new i(((c)localObject1).dKu);
    ((c)localObject1).hMV = new com.tencent.mm.pluginsdk.model.app.c(((c)localObject1).dKu);
    ((c)localObject1).hPA = new bs(((c)localObject1).hMK);
    ((c)localObject1).hPA.c(new c.1((c)localObject1));
    ((c)localObject1).hPA.cvZ();
    y.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
    avR();
    parama.hPx = true;
    parama.hPy = paramPLong1.value;
    parama.hPz = paramPLong2.value;
    parama.dbSize = paramPLong3.value;
    com.tencent.mm.plugin.backup.bakoldlogic.a.a.xC(com.tencent.mm.plugin.backup.bakoldlogic.a.a.avo());
    return true;
  }
  
  public static b avO()
  {
    if (hPl == null)
    {
      b localb = new b();
      hPl = localb;
      a(localb);
    }
    return hPl;
  }
  
  private static void avR()
  {
    com.tencent.mm.h.a.z localz = new com.tencent.mm.h.a.z();
    com.tencent.mm.sdk.b.a.udP.m(localz);
  }
  
  private c avS()
  {
    if (this.hPp == null) {
      this.hPp = new c();
    }
    return this.hPp;
  }
  
  public static void avT()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    e.deleteFile(com.tencent.mm.model.c.Dw() + ".tem");
    localStringBuilder = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    e.deleteFile(com.tencent.mm.model.c.Dw() + ".ini.tem");
    localStringBuilder = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    e.deleteFile(com.tencent.mm.model.c.Dx() + ".tem");
    localStringBuilder = new StringBuilder();
    com.tencent.mm.model.au.Hx();
    e.deleteFile(com.tencent.mm.model.c.Dx() + ".ini.tem");
  }
  
  public final void a(b.a parama)
  {
    long l = bk.UY();
    y.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", new Object[] { Boolean.valueOf(false), bk.csb() });
    ai.l(new b.1(this, l, parama), 1000L);
  }
  
  public final void a(Runnable paramRunnable, int paramInt)
  {
    if ((paramInt < 0) || (hPo == 0))
    {
      if (paramInt < 0) {
        y.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
      }
      y.i("MicroMsg.BakOldTempDbModel", "closeDB before");
      avS().avV();
      y.i("MicroMsg.BakOldTempDbModel", "closeDB after");
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return;
    }
    new ah(Looper.getMainLooper()).postDelayed(new b.3(this, paramRunnable, paramInt), 500L);
  }
  
  public final void ati()
  {
    hPl = null;
  }
  
  public final c avP()
  {
    if (this.hPm == null) {
      this.hPm = new c();
    }
    return this.hPm;
  }
  
  public final a avQ()
  {
    if (this.hPn == null) {
      this.hPn = new a();
    }
    return this.hPn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b
 * JD-Core Version:    0.7.0.1
 */