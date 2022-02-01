package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.r;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import junit.framework.Assert;

public final class b
  extends com.tencent.mm.plugin.backup.b.a
{
  private static b nCB;
  private static int nCE = 0;
  private c nCC;
  private a nCD;
  private c nCF;
  
  private boolean a(PLong paramPLong1, PLong paramPLong2, PLong paramPLong3, a parama, int paramInt)
  {
    AppMethodBeat.i(22074);
    ba.aBQ();
    com.tencent.mm.model.c.closeDB();
    ad.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
    ba.aBQ();
    long l = com.tencent.mm.vfs.i.aYo(com.tencent.mm.model.c.aji());
    ba.aBQ();
    paramPLong3.value = (l + com.tencent.mm.vfs.i.aYo(com.tencent.mm.model.c.ajj()));
    l = paramPLong3.value;
    ba.aBQ();
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(l, paramPLong1, paramPLong2, com.tencent.mm.model.c.getAccPath()))
    {
      ad.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", new Object[] { Long.valueOf(paramPLong3.value) });
      parama.nCN = false;
      parama.nCO = paramPLong1.value;
      parama.nCP = paramPLong2.value;
      parama.dbSize = paramPLong3.value;
      AppMethodBeat.o(22074);
      return false;
    }
    ba.aBQ();
    Object localObject1 = com.tencent.mm.model.c.aji();
    Object localObject2 = new StringBuilder();
    ba.aBQ();
    com.tencent.mm.vfs.i.mz((String)localObject1, com.tencent.mm.model.c.aji() + ".tem");
    ba.aBQ();
    localObject1 = com.tencent.mm.model.c.ajj();
    localObject2 = new StringBuilder();
    ba.aBQ();
    com.tencent.mm.vfs.i.mz((String)localObject1, com.tencent.mm.model.c.ajj() + ".tem");
    localObject1 = new StringBuilder();
    ba.aBQ();
    localObject1 = com.tencent.mm.model.c.ajj() + "-journal";
    localObject2 = new StringBuilder();
    ba.aBQ();
    com.tencent.mm.vfs.i.mz((String)localObject1, com.tencent.mm.model.c.ajj() + ".tem-journal");
    localObject1 = new StringBuilder();
    ba.aBQ();
    localObject1 = com.tencent.mm.model.c.ajj() + "-wal";
    localObject2 = new StringBuilder();
    ba.aBQ();
    com.tencent.mm.vfs.i.mz((String)localObject1, com.tencent.mm.model.c.ajj() + ".tem-wal");
    ad.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
    g.ajA().release();
    g.ajA().initialize();
    ad.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
    localObject1 = bJJ();
    ba.aBQ();
    localObject2 = com.tencent.mm.model.c.getAccPath();
    ba.aBQ();
    int i = com.tencent.mm.model.c.getUin();
    ad.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", new Object[] { localObject2, Integer.valueOf(i) });
    ((c)localObject1).uin = i;
    ((c)localObject1).gBm = ((String)localObject2);
    ad.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
    localObject1 = bJJ();
    localObject2 = new StringBuilder();
    ba.aBQ();
    localObject2 = com.tencent.mm.model.c.aji() + ".tem";
    ba.aBQ();
    i = com.tencent.mm.model.c.getUin();
    Object localObject3 = new StringBuilder();
    ba.aBQ();
    localObject3 = com.tencent.mm.model.c.ajj() + ".tem";
    ad.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", new Object[] { ((c)localObject1).nCS, localObject2, Integer.valueOf(i), localObject3, bt.flS() });
    if (((c)localObject1).gBq != null) {
      ad.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
    }
    Object localObject4;
    if (paramInt > 0)
    {
      if ((((c)localObject1).nCS != null) && (!((c)localObject1).nCS.booleanValue()))
      {
        ad.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
        ((c)localObject1).bJN();
      }
      localObject4 = "bakoldInitDB here  isTempDb should null :" + ((c)localObject1).nCS;
      if (((c)localObject1).nCS != null) {
        break label748;
      }
    }
    label748:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue((String)localObject4, bool);
      ((c)localObject1).nCS = Boolean.TRUE;
      ((c)localObject1).gBq = new h(new c.2((c)localObject1));
      localObject4 = ((c)localObject1).gBq;
      l = i;
      q.cH(true);
      if (((h)localObject4).b((String)localObject2, (String)localObject3, "", l, new HashMap(), false)) {
        break;
      }
      paramPLong1 = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(22074);
      throw paramPLong1;
    }
    ((c)localObject1).nAd = new ai(((c)localObject1).gBq);
    localObject2 = (m)g.ab(m.class);
    ((c)localObject1).nAe = ((m)localObject2).c(((c)localObject1).gBq);
    ((c)localObject1).nAg = ((m)localObject2).d(((c)localObject1).gBq);
    ((c)localObject1).nAf = ((m)localObject2).a(((c)localObject1).gBq, ((c)localObject1).nAe, ((c)localObject1).nAg);
    ((c)localObject1).nAf.a(new be(((c)localObject1).nAf));
    ((c)localObject1).nAf.a(new r(((c)localObject1).nAf));
    ((c)localObject1).nAj = ((m)localObject2).e(((c)localObject1).gBq);
    ((c)localObject1).nAh = new com.tencent.mm.aw.i(((c)localObject1).gBq);
    if (com.tencent.mm.bs.d.aIu("emoji")) {
      ((c)localObject1).nAi = new f(((c)localObject1).gBq);
    }
    ((c)localObject1).nAl = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).b(((c)localObject1).gBq);
    ((c)localObject1).nAk = new t(((c)localObject1).gBq);
    ((c)localObject1).nAm = new l(((c)localObject1).gBq);
    ((c)localObject1).nAn = new j(((c)localObject1).gBq);
    ((c)localObject1).nAo = new com.tencent.mm.pluginsdk.model.app.d(((c)localObject1).gBq);
    ((c)localObject1).nCQ = new cc(((c)localObject1).nAd);
    ((c)localObject1).nCQ.add(new c.1((c)localObject1));
    ((c)localObject1).nCQ.fsE();
    ad.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
    bJI();
    parama.nCN = true;
    parama.nCO = paramPLong1.value;
    parama.nCP = paramPLong2.value;
    parama.dbSize = paramPLong3.value;
    com.tencent.mm.plugin.backup.bakoldlogic.a.a.Wf(com.tencent.mm.plugin.backup.bakoldlogic.a.a.bJf());
    AppMethodBeat.o(22074);
    return true;
  }
  
  public static b bJF()
  {
    AppMethodBeat.i(22068);
    if (nCB == null)
    {
      localb = new b();
      nCB = localb;
      a(localb);
    }
    b localb = nCB;
    AppMethodBeat.o(22068);
    return localb;
  }
  
  private static void bJI()
  {
    AppMethodBeat.i(22071);
    ac localac = new ac();
    com.tencent.mm.sdk.b.a.IbL.l(localac);
    AppMethodBeat.o(22071);
  }
  
  private c bJJ()
  {
    AppMethodBeat.i(22072);
    if (this.nCF == null) {
      this.nCF = new c();
    }
    c localc = this.nCF;
    AppMethodBeat.o(22072);
    return localc;
  }
  
  public static void bJK()
  {
    AppMethodBeat.i(22075);
    StringBuilder localStringBuilder = new StringBuilder();
    ba.aBQ();
    com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.model.c.aji() + ".tem");
    localStringBuilder = new StringBuilder();
    ba.aBQ();
    com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.model.c.aji() + ".ini.tem");
    localStringBuilder = new StringBuilder();
    ba.aBQ();
    com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.model.c.ajj() + ".tem");
    localStringBuilder = new StringBuilder();
    ba.aBQ();
    com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.model.c.ajj() + ".ini.tem");
    AppMethodBeat.o(22075);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(22073);
    final long l = bt.flT();
    ad.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", new Object[] { Boolean.FALSE, bt.flS() });
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22061);
        g.ajA().aiF();
        ad.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[] { Integer.valueOf(b.nCE), Long.valueOf(bt.Df(l)) });
        b.access$008();
        ba.ajF().a(new aq.a()
        {
          public final boolean aEm()
          {
            AppMethodBeat.i(22059);
            b.bJK();
            PLong localPLong1 = new PLong();
            PLong localPLong2 = new PLong();
            PLong localPLong3 = new PLong();
            b.a(b.this, localPLong1, localPLong2, localPLong3, b.1.this.nCG, b.1.this.nzD);
            AppMethodBeat.o(22059);
            return true;
          }
          
          public final boolean aEn()
          {
            AppMethodBeat.i(22058);
            ad.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
            b.1.this.nCG.run();
            b.bJL();
            AppMethodBeat.o(22058);
            return false;
          }
          
          public final String toString()
          {
            AppMethodBeat.i(22060);
            String str = super.toString() + "|initTempDB";
            AppMethodBeat.o(22060);
            return str;
          }
        });
        AppMethodBeat.o(22061);
      }
    }, 1000L);
    AppMethodBeat.o(22073);
  }
  
  public final void a(final Runnable paramRunnable, final int paramInt)
  {
    AppMethodBeat.i(22076);
    if ((paramInt < 0) || (nCE == 0))
    {
      if (paramInt < 0) {
        ad.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
      }
      ad.i("MicroMsg.BakOldTempDbModel", "closeDB before");
      bJJ().bJN();
      ad.i("MicroMsg.BakOldTempDbModel", "closeDB after");
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(22076);
      }
    }
    else
    {
      new ap(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22066);
          b.this.a(paramRunnable, paramInt - 1);
          AppMethodBeat.o(22066);
        }
      }, 500L);
    }
    AppMethodBeat.o(22076);
  }
  
  public final void bGS()
  {
    nCB = null;
  }
  
  public final c bJG()
  {
    AppMethodBeat.i(22069);
    if (this.nCC == null) {
      this.nCC = new c();
    }
    c localc = this.nCC;
    AppMethodBeat.o(22069);
    return localc;
  }
  
  public final a bJH()
  {
    AppMethodBeat.i(22070);
    if (this.nCD == null) {
      this.nCD = new a();
    }
    a locala = this.nCD;
    AppMethodBeat.o(22070);
    return locala;
  }
  
  public static class a
    implements Runnable
  {
    public long dbSize = 0L;
    public boolean nCN = true;
    public long nCO = 0L;
    public long nCP = 0L;
    
    public void run()
    {
      AppMethodBeat.i(22067);
      AppMethodBeat.o(22067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b
 * JD-Core Version:    0.7.0.1
 */