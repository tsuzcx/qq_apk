package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.p;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import junit.framework.Assert;

public final class b
  extends com.tencent.mm.plugin.backup.b.a
{
  private static b nce;
  private static int nch = 0;
  private c ncf;
  private a ncg;
  private c nci;
  
  private boolean a(PLong paramPLong1, PLong paramPLong2, PLong paramPLong3, a parama, int paramInt)
  {
    AppMethodBeat.i(22074);
    az.ayM();
    com.tencent.mm.model.c.closeDB();
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
    az.ayM();
    long l = i.aSp(com.tencent.mm.model.c.agx());
    az.ayM();
    paramPLong3.value = (l + i.aSp(com.tencent.mm.model.c.agy()));
    l = paramPLong3.value;
    az.ayM();
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(l, paramPLong1, paramPLong2, com.tencent.mm.model.c.getAccPath()))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", new Object[] { Long.valueOf(paramPLong3.value) });
      parama.ncq = false;
      parama.ncr = paramPLong1.value;
      parama.ncs = paramPLong2.value;
      parama.dbSize = paramPLong3.value;
      AppMethodBeat.o(22074);
      return false;
    }
    az.ayM();
    Object localObject1 = com.tencent.mm.model.c.agx();
    Object localObject2 = new StringBuilder();
    az.ayM();
    i.lZ((String)localObject1, com.tencent.mm.model.c.agx() + ".tem");
    az.ayM();
    localObject1 = com.tencent.mm.model.c.agy();
    localObject2 = new StringBuilder();
    az.ayM();
    i.lZ((String)localObject1, com.tencent.mm.model.c.agy() + ".tem");
    localObject1 = new StringBuilder();
    az.ayM();
    localObject1 = com.tencent.mm.model.c.agy() + "-journal";
    localObject2 = new StringBuilder();
    az.ayM();
    i.lZ((String)localObject1, com.tencent.mm.model.c.agy() + ".tem-journal");
    localObject1 = new StringBuilder();
    az.ayM();
    localObject1 = com.tencent.mm.model.c.agy() + "-wal";
    localObject2 = new StringBuilder();
    az.ayM();
    i.lZ((String)localObject1, com.tencent.mm.model.c.agy() + ".tem-wal");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
    com.tencent.mm.kernel.g.agP().release();
    com.tencent.mm.kernel.g.agP().initialize();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
    localObject1 = bFA();
    az.ayM();
    localObject2 = com.tencent.mm.model.c.getAccPath();
    az.ayM();
    int i = com.tencent.mm.model.c.getUin();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", new Object[] { localObject2, Integer.valueOf(i) });
    ((c)localObject1).uin = i;
    ((c)localObject1).ghC = ((String)localObject2);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
    localObject1 = bFA();
    localObject2 = new StringBuilder();
    az.ayM();
    localObject2 = com.tencent.mm.model.c.agx() + ".tem";
    az.ayM();
    i = com.tencent.mm.model.c.getUin();
    Object localObject3 = new StringBuilder();
    az.ayM();
    localObject3 = com.tencent.mm.model.c.agy() + ".tem";
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", new Object[] { ((c)localObject1).ncv, localObject2, Integer.valueOf(i), localObject3, bs.eWi() });
    if (((c)localObject1).ghG != null) {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
    }
    Object localObject4;
    if (paramInt > 0)
    {
      if ((((c)localObject1).ncv != null) && (!((c)localObject1).ncv.booleanValue()))
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
        ((c)localObject1).bFD();
      }
      localObject4 = "bakoldInitDB here  isTempDb should null :" + ((c)localObject1).ncv;
      if (((c)localObject1).ncv != null) {
        break label748;
      }
    }
    label748:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue((String)localObject4, bool);
      ((c)localObject1).ncv = Boolean.TRUE;
      ((c)localObject1).ghG = new com.tencent.mm.storagebase.h(new c.2((c)localObject1));
      localObject4 = ((c)localObject1).ghG;
      l = i;
      q.cF(true);
      if (((com.tencent.mm.storagebase.h)localObject4).b((String)localObject2, (String)localObject3, "", l, new HashMap(), false)) {
        break;
      }
      paramPLong1 = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(22074);
      throw paramPLong1;
    }
    ((c)localObject1).mZG = new ae(((c)localObject1).ghG);
    localObject2 = (com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    ((c)localObject1).mZH = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).d(((c)localObject1).ghG);
    ((c)localObject1).mZJ = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).e(((c)localObject1).ghG);
    ((c)localObject1).mZI = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).a(((c)localObject1).ghG, ((c)localObject1).mZH, ((c)localObject1).mZJ);
    ((c)localObject1).mZI.a(new ba(((c)localObject1).mZI));
    ((c)localObject1).mZI.a(new p(((c)localObject1).mZI));
    ((c)localObject1).mZM = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).f(((c)localObject1).ghG);
    ((c)localObject1).mZK = new com.tencent.mm.av.g(((c)localObject1).ghG);
    if (com.tencent.mm.br.d.aCT("emoji")) {
      ((c)localObject1).mZL = new f(((c)localObject1).ghG);
    }
    ((c)localObject1).mZO = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).c(((c)localObject1).ghG);
    ((c)localObject1).mZN = new t(((c)localObject1).ghG);
    ((c)localObject1).mZP = new com.tencent.mm.pluginsdk.model.app.l(((c)localObject1).ghG);
    ((c)localObject1).mZQ = new j(((c)localObject1).ghG);
    ((c)localObject1).mZR = new com.tencent.mm.pluginsdk.model.app.d(((c)localObject1).ghG);
    ((c)localObject1).nct = new bw(((c)localObject1).mZG);
    ((c)localObject1).nct.add(new c.1((c)localObject1));
    ((c)localObject1).nct.fcx();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
    bFz();
    parama.ncq = true;
    parama.ncr = paramPLong1.value;
    parama.ncs = paramPLong2.value;
    parama.dbSize = paramPLong3.value;
    com.tencent.mm.plugin.backup.bakoldlogic.a.a.SH(com.tencent.mm.plugin.backup.bakoldlogic.a.a.bEW());
    AppMethodBeat.o(22074);
    return true;
  }
  
  private c bFA()
  {
    AppMethodBeat.i(22072);
    if (this.nci == null) {
      this.nci = new c();
    }
    c localc = this.nci;
    AppMethodBeat.o(22072);
    return localc;
  }
  
  public static void bFB()
  {
    AppMethodBeat.i(22075);
    StringBuilder localStringBuilder = new StringBuilder();
    az.ayM();
    i.deleteFile(com.tencent.mm.model.c.agx() + ".tem");
    localStringBuilder = new StringBuilder();
    az.ayM();
    i.deleteFile(com.tencent.mm.model.c.agx() + ".ini.tem");
    localStringBuilder = new StringBuilder();
    az.ayM();
    i.deleteFile(com.tencent.mm.model.c.agy() + ".tem");
    localStringBuilder = new StringBuilder();
    az.ayM();
    i.deleteFile(com.tencent.mm.model.c.agy() + ".ini.tem");
    AppMethodBeat.o(22075);
  }
  
  public static b bFw()
  {
    AppMethodBeat.i(22068);
    if (nce == null)
    {
      localb = new b();
      nce = localb;
      a(localb);
    }
    b localb = nce;
    AppMethodBeat.o(22068);
    return localb;
  }
  
  private static void bFz()
  {
    AppMethodBeat.i(22071);
    com.tencent.mm.g.a.ac localac = new com.tencent.mm.g.a.ac();
    com.tencent.mm.sdk.b.a.GpY.l(localac);
    AppMethodBeat.o(22071);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(22073);
    final long l = bs.eWj();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", new Object[] { Boolean.FALSE, bs.eWi() });
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22061);
        com.tencent.mm.kernel.g.agP().afT();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[] { Integer.valueOf(b.nch), Long.valueOf(bs.Ap(l)) });
        b.access$008();
        az.agU().a(new ap.a()
        {
          public final boolean aBj()
          {
            AppMethodBeat.i(22059);
            b.bFB();
            PLong localPLong1 = new PLong();
            PLong localPLong2 = new PLong();
            PLong localPLong3 = new PLong();
            b.a(b.this, localPLong1, localPLong2, localPLong3, b.1.this.ncj, b.1.this.mZg);
            AppMethodBeat.o(22059);
            return true;
          }
          
          public final boolean aBk()
          {
            AppMethodBeat.i(22058);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
            b.1.this.ncj.run();
            b.Ov();
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
    if ((paramInt < 0) || (nch == 0))
    {
      if (paramInt < 0) {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakOldTempDbModel", "closeDB before");
      bFA().bFD();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakOldTempDbModel", "closeDB after");
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(22076);
      }
    }
    else
    {
      new ao(Looper.getMainLooper()).postDelayed(new Runnable()
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
  
  public final void bCK()
  {
    nce = null;
  }
  
  public final c bFx()
  {
    AppMethodBeat.i(22069);
    if (this.ncf == null) {
      this.ncf = new c();
    }
    c localc = this.ncf;
    AppMethodBeat.o(22069);
    return localc;
  }
  
  public final a bFy()
  {
    AppMethodBeat.i(22070);
    if (this.ncg == null) {
      this.ncg = new a();
    }
    a locala = this.ncg;
    AppMethodBeat.o(22070);
    return locala;
  }
  
  public static class a
    implements Runnable
  {
    public long dbSize = 0L;
    public boolean ncq = true;
    public long ncr = 0L;
    public long ncs = 0L;
    
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