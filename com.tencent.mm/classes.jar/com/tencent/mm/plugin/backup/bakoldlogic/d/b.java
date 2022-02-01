package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.p;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import junit.framework.Assert;

public final class b
  extends com.tencent.mm.plugin.backup.b.a
{
  private static b mAd;
  private static int mAg = 0;
  private c mAe;
  private a mAf;
  private c mAh;
  
  private boolean a(PLong paramPLong1, PLong paramPLong2, PLong paramPLong3, a parama, int paramInt)
  {
    AppMethodBeat.i(22074);
    az.arV();
    com.tencent.mm.model.c.closeDB();
    ad.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
    az.arV();
    long l = i.aMN(com.tencent.mm.model.c.afh());
    az.arV();
    paramPLong3.value = (l + i.aMN(com.tencent.mm.model.c.afi()));
    l = paramPLong3.value;
    az.arV();
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(l, paramPLong1, paramPLong2, com.tencent.mm.model.c.getAccPath()))
    {
      ad.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", new Object[] { Long.valueOf(paramPLong3.value) });
      parama.mAp = false;
      parama.mAq = paramPLong1.value;
      parama.mAr = paramPLong2.value;
      parama.dbSize = paramPLong3.value;
      AppMethodBeat.o(22074);
      return false;
    }
    az.arV();
    Object localObject1 = com.tencent.mm.model.c.afh();
    Object localObject2 = new StringBuilder();
    az.arV();
    i.lC((String)localObject1, com.tencent.mm.model.c.afh() + ".tem");
    az.arV();
    localObject1 = com.tencent.mm.model.c.afi();
    localObject2 = new StringBuilder();
    az.arV();
    i.lC((String)localObject1, com.tencent.mm.model.c.afi() + ".tem");
    localObject1 = new StringBuilder();
    az.arV();
    localObject1 = com.tencent.mm.model.c.afi() + "-journal";
    localObject2 = new StringBuilder();
    az.arV();
    i.lC((String)localObject1, com.tencent.mm.model.c.afi() + ".tem-journal");
    localObject1 = new StringBuilder();
    az.arV();
    localObject1 = com.tencent.mm.model.c.afi() + "-wal";
    localObject2 = new StringBuilder();
    az.arV();
    i.lC((String)localObject1, com.tencent.mm.model.c.afi() + ".tem-wal");
    ad.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
    com.tencent.mm.kernel.g.afz().release();
    com.tencent.mm.kernel.g.afz().initialize();
    ad.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
    localObject1 = byE();
    az.arV();
    localObject2 = com.tencent.mm.model.c.getAccPath();
    az.arV();
    int i = com.tencent.mm.model.c.getUin();
    ad.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", new Object[] { localObject2, Integer.valueOf(i) });
    ((c)localObject1).uin = i;
    ((c)localObject1).gcW = ((String)localObject2);
    ad.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
    localObject1 = byE();
    localObject2 = new StringBuilder();
    az.arV();
    localObject2 = com.tencent.mm.model.c.afh() + ".tem";
    az.arV();
    i = com.tencent.mm.model.c.getUin();
    Object localObject3 = new StringBuilder();
    az.arV();
    localObject3 = com.tencent.mm.model.c.afi() + ".tem";
    ad.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", new Object[] { ((c)localObject1).mAu, localObject2, Integer.valueOf(i), localObject3, com.tencent.mm.sdk.platformtools.bt.eGN() });
    if (((c)localObject1).gda != null) {
      ad.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
    }
    Object localObject4;
    if (paramInt > 0)
    {
      if ((((c)localObject1).mAu != null) && (!((c)localObject1).mAu.booleanValue()))
      {
        ad.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
        ((c)localObject1).byH();
      }
      localObject4 = "bakoldInitDB here  isTempDb should null :" + ((c)localObject1).mAu;
      if (((c)localObject1).mAu != null) {
        break label748;
      }
    }
    label748:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue((String)localObject4, bool);
      ((c)localObject1).mAu = Boolean.TRUE;
      ((c)localObject1).gda = new com.tencent.mm.storagebase.h(new c.2((c)localObject1));
      localObject4 = ((c)localObject1).gda;
      l = i;
      q.cG(true);
      if (((com.tencent.mm.storagebase.h)localObject4).b((String)localObject2, (String)localObject3, "", l, new HashMap(), false)) {
        break;
      }
      paramPLong1 = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(22074);
      throw paramPLong1;
    }
    ((c)localObject1).mxF = new com.tencent.mm.storage.ab(((c)localObject1).gda);
    localObject2 = (com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    ((c)localObject1).mxG = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).d(((c)localObject1).gda);
    ((c)localObject1).mxI = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).e(((c)localObject1).gda);
    ((c)localObject1).mxH = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).a(((c)localObject1).gda, ((c)localObject1).mxG, ((c)localObject1).mxI);
    ((c)localObject1).mxH.a(new ax(((c)localObject1).mxH));
    ((c)localObject1).mxH.a(new p(((c)localObject1).mxH));
    ((c)localObject1).mxL = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).f(((c)localObject1).gda);
    ((c)localObject1).mxJ = new com.tencent.mm.aw.g(((c)localObject1).gda);
    if (com.tencent.mm.bs.d.axB("emoji")) {
      ((c)localObject1).mxK = new f(((c)localObject1).gda);
    }
    ((c)localObject1).mxN = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).c(((c)localObject1).gda);
    ((c)localObject1).mxM = new t(((c)localObject1).gda);
    ((c)localObject1).mxO = new com.tencent.mm.pluginsdk.model.app.l(((c)localObject1).gda);
    ((c)localObject1).mxP = new j(((c)localObject1).gda);
    ((c)localObject1).mxQ = new com.tencent.mm.pluginsdk.model.app.d(((c)localObject1).gda);
    ((c)localObject1).mAs = new com.tencent.mm.storage.bt(((c)localObject1).mxF);
    ((c)localObject1).mAs.add(new c.1((c)localObject1));
    ((c)localObject1).mAs.eMT();
    ad.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
    byD();
    parama.mAp = true;
    parama.mAq = paramPLong1.value;
    parama.mAr = paramPLong2.value;
    parama.dbSize = paramPLong3.value;
    com.tencent.mm.plugin.backup.bakoldlogic.a.a.Ox(com.tencent.mm.plugin.backup.bakoldlogic.a.a.bya());
    AppMethodBeat.o(22074);
    return true;
  }
  
  public static b byA()
  {
    AppMethodBeat.i(22068);
    if (mAd == null)
    {
      localb = new b();
      mAd = localb;
      a(localb);
    }
    b localb = mAd;
    AppMethodBeat.o(22068);
    return localb;
  }
  
  private static void byD()
  {
    AppMethodBeat.i(22071);
    com.tencent.mm.g.a.ab localab = new com.tencent.mm.g.a.ab();
    com.tencent.mm.sdk.b.a.ESL.l(localab);
    AppMethodBeat.o(22071);
  }
  
  private c byE()
  {
    AppMethodBeat.i(22072);
    if (this.mAh == null) {
      this.mAh = new c();
    }
    c localc = this.mAh;
    AppMethodBeat.o(22072);
    return localc;
  }
  
  public static void byF()
  {
    AppMethodBeat.i(22075);
    StringBuilder localStringBuilder = new StringBuilder();
    az.arV();
    i.deleteFile(com.tencent.mm.model.c.afh() + ".tem");
    localStringBuilder = new StringBuilder();
    az.arV();
    i.deleteFile(com.tencent.mm.model.c.afh() + ".ini.tem");
    localStringBuilder = new StringBuilder();
    az.arV();
    i.deleteFile(com.tencent.mm.model.c.afi() + ".tem");
    localStringBuilder = new StringBuilder();
    az.arV();
    i.deleteFile(com.tencent.mm.model.c.afi() + ".ini.tem");
    AppMethodBeat.o(22075);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(22073);
    final long l = com.tencent.mm.sdk.platformtools.bt.eGO();
    ad.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", new Object[] { Boolean.FALSE, com.tencent.mm.sdk.platformtools.bt.eGN() });
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22061);
        com.tencent.mm.kernel.g.afz().aeD();
        ad.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[] { Integer.valueOf(b.mAg), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.vM(l)) });
        b.access$008();
        az.afE().a(new aq.a()
        {
          public final boolean aus()
          {
            AppMethodBeat.i(22059);
            b.byF();
            PLong localPLong1 = new PLong();
            PLong localPLong2 = new PLong();
            PLong localPLong3 = new PLong();
            b.a(b.this, localPLong1, localPLong2, localPLong3, b.1.this.mAi, b.1.this.mxf);
            AppMethodBeat.o(22059);
            return true;
          }
          
          public final boolean aut()
          {
            AppMethodBeat.i(22058);
            ad.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
            b.1.this.mAi.run();
            b.Oz();
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
    if ((paramInt < 0) || (mAg == 0))
    {
      if (paramInt < 0) {
        ad.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
      }
      ad.i("MicroMsg.BakOldTempDbModel", "closeDB before");
      byE().byH();
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
  
  public final void bvO()
  {
    mAd = null;
  }
  
  public final c byB()
  {
    AppMethodBeat.i(22069);
    if (this.mAe == null) {
      this.mAe = new c();
    }
    c localc = this.mAe;
    AppMethodBeat.o(22069);
    return localc;
  }
  
  public final a byC()
  {
    AppMethodBeat.i(22070);
    if (this.mAf == null) {
      this.mAf = new a();
    }
    a locala = this.mAf;
    AppMethodBeat.o(22070);
    return locala;
  }
  
  public static class a
    implements Runnable
  {
    public long dbSize = 0L;
    public boolean mAp = true;
    public long mAq = 0L;
    public long mAr = 0L;
    
    public void run()
    {
      AppMethodBeat.i(22067);
      AppMethodBeat.o(22067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b
 * JD-Core Version:    0.7.0.1
 */