package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.r;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import junit.framework.Assert;

public final class b
  extends com.tencent.mm.plugin.backup.b.a
{
  private static b nHW;
  private static int nHZ = 0;
  private c nHX;
  private a nHY;
  private c nIa;
  
  private boolean a(PLong paramPLong1, PLong paramPLong2, PLong paramPLong3, a parama, int paramInt)
  {
    AppMethodBeat.i(22074);
    bc.aCg();
    com.tencent.mm.model.c.closeDB();
    ae.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
    bc.aCg();
    long l = o.aZR(com.tencent.mm.model.c.ajx());
    bc.aCg();
    paramPLong3.value = (l + o.aZR(com.tencent.mm.model.c.ajy()));
    l = paramPLong3.value;
    bc.aCg();
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(l, paramPLong1, paramPLong2, com.tencent.mm.model.c.getAccPath()))
    {
      ae.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", new Object[] { Long.valueOf(paramPLong3.value) });
      parama.nIi = false;
      parama.nIj = paramPLong1.value;
      parama.nIk = paramPLong2.value;
      parama.dbSize = paramPLong3.value;
      AppMethodBeat.o(22074);
      return false;
    }
    bc.aCg();
    Object localObject1 = com.tencent.mm.model.c.ajx();
    Object localObject2 = new StringBuilder();
    bc.aCg();
    o.mF((String)localObject1, com.tencent.mm.model.c.ajx() + ".tem");
    bc.aCg();
    localObject1 = com.tencent.mm.model.c.ajy();
    localObject2 = new StringBuilder();
    bc.aCg();
    o.mF((String)localObject1, com.tencent.mm.model.c.ajy() + ".tem");
    localObject1 = new StringBuilder();
    bc.aCg();
    localObject1 = com.tencent.mm.model.c.ajy() + "-journal";
    localObject2 = new StringBuilder();
    bc.aCg();
    o.mF((String)localObject1, com.tencent.mm.model.c.ajy() + ".tem-journal");
    localObject1 = new StringBuilder();
    bc.aCg();
    localObject1 = com.tencent.mm.model.c.ajy() + "-wal";
    localObject2 = new StringBuilder();
    bc.aCg();
    o.mF((String)localObject1, com.tencent.mm.model.c.ajy() + ".tem-wal");
    ae.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
    g.ajP().release();
    g.ajP().initialize();
    ae.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
    localObject1 = bKH();
    bc.aCg();
    localObject2 = com.tencent.mm.model.c.getAccPath();
    bc.aCg();
    int i = com.tencent.mm.model.c.getUin();
    ae.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", new Object[] { localObject2, Integer.valueOf(i) });
    ((c)localObject1).uin = i;
    ((c)localObject1).gDT = ((String)localObject2);
    ae.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
    localObject1 = bKH();
    localObject2 = new StringBuilder();
    bc.aCg();
    localObject2 = com.tencent.mm.model.c.ajx() + ".tem";
    bc.aCg();
    i = com.tencent.mm.model.c.getUin();
    Object localObject3 = new StringBuilder();
    bc.aCg();
    localObject3 = com.tencent.mm.model.c.ajy() + ".tem";
    ae.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", new Object[] { ((c)localObject1).nIn, localObject2, Integer.valueOf(i), localObject3, bu.fpN() });
    if (((c)localObject1).gDX != null) {
      ae.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
    }
    Object localObject4;
    if (paramInt > 0)
    {
      if ((((c)localObject1).nIn != null) && (!((c)localObject1).nIn.booleanValue()))
      {
        ae.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
        ((c)localObject1).bKL();
      }
      localObject4 = "bakoldInitDB here  isTempDb should null :" + ((c)localObject1).nIn;
      if (((c)localObject1).nIn != null) {
        break label748;
      }
    }
    label748:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue((String)localObject4, bool);
      ((c)localObject1).nIn = Boolean.TRUE;
      ((c)localObject1).gDX = new h(new c.2((c)localObject1));
      localObject4 = ((c)localObject1).gDX;
      l = i;
      q.cH(true);
      if (((h)localObject4).b((String)localObject2, (String)localObject3, "", l, new HashMap(), false)) {
        break;
      }
      paramPLong1 = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(22074);
      throw paramPLong1;
    }
    ((c)localObject1).nFy = new aj(((c)localObject1).gDX);
    localObject2 = (m)g.ab(m.class);
    ((c)localObject1).nFz = ((m)localObject2).c(((c)localObject1).gDX);
    ((c)localObject1).nFB = ((m)localObject2).d(((c)localObject1).gDX);
    ((c)localObject1).nFA = ((m)localObject2).a(((c)localObject1).gDX, ((c)localObject1).nFz, ((c)localObject1).nFB);
    ((c)localObject1).nFA.a(new bf(((c)localObject1).nFA));
    ((c)localObject1).nFA.a(new r(((c)localObject1).nFA));
    ((c)localObject1).nFE = ((m)localObject2).e(((c)localObject1).gDX);
    ((c)localObject1).nFC = new com.tencent.mm.av.i(((c)localObject1).gDX);
    if (com.tencent.mm.br.d.aJN("emoji")) {
      ((c)localObject1).nFD = new f(((c)localObject1).gDX);
    }
    ((c)localObject1).nFG = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).b(((c)localObject1).gDX);
    ((c)localObject1).nFF = new t(((c)localObject1).gDX);
    ((c)localObject1).nFH = new l(((c)localObject1).gDX);
    ((c)localObject1).nFI = new j(((c)localObject1).gDX);
    ((c)localObject1).nFJ = new com.tencent.mm.pluginsdk.model.app.d(((c)localObject1).gDX);
    ((c)localObject1).nIl = new cd(((c)localObject1).nFy);
    ((c)localObject1).nIl.add(new c.1((c)localObject1));
    ((c)localObject1).nIl.fwF();
    ae.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
    bKG();
    parama.nIi = true;
    parama.nIj = paramPLong1.value;
    parama.nIk = paramPLong2.value;
    parama.dbSize = paramPLong3.value;
    com.tencent.mm.plugin.backup.bakoldlogic.a.a.WR(com.tencent.mm.plugin.backup.bakoldlogic.a.a.bKd());
    AppMethodBeat.o(22074);
    return true;
  }
  
  public static b bKD()
  {
    AppMethodBeat.i(22068);
    if (nHW == null)
    {
      localb = new b();
      nHW = localb;
      a(localb);
    }
    b localb = nHW;
    AppMethodBeat.o(22068);
    return localb;
  }
  
  private static void bKG()
  {
    AppMethodBeat.i(22071);
    ac localac = new ac();
    com.tencent.mm.sdk.b.a.IvT.l(localac);
    AppMethodBeat.o(22071);
  }
  
  private c bKH()
  {
    AppMethodBeat.i(22072);
    if (this.nIa == null) {
      this.nIa = new c();
    }
    c localc = this.nIa;
    AppMethodBeat.o(22072);
    return localc;
  }
  
  public static void bKI()
  {
    AppMethodBeat.i(22075);
    StringBuilder localStringBuilder = new StringBuilder();
    bc.aCg();
    o.deleteFile(com.tencent.mm.model.c.ajx() + ".tem");
    localStringBuilder = new StringBuilder();
    bc.aCg();
    o.deleteFile(com.tencent.mm.model.c.ajx() + ".ini.tem");
    localStringBuilder = new StringBuilder();
    bc.aCg();
    o.deleteFile(com.tencent.mm.model.c.ajy() + ".tem");
    localStringBuilder = new StringBuilder();
    bc.aCg();
    o.deleteFile(com.tencent.mm.model.c.ajy() + ".ini.tem");
    AppMethodBeat.o(22075);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(22073);
    final long l = bu.fpO();
    ae.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", new Object[] { Boolean.FALSE, bu.fpN() });
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22061);
        g.ajP().aiU();
        ae.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[] { Integer.valueOf(b.nHZ), Long.valueOf(bu.DD(l)) });
        b.access$008();
        bc.ajU().a(new ar.a()
        {
          public final boolean aEC()
          {
            AppMethodBeat.i(22059);
            b.bKI();
            PLong localPLong1 = new PLong();
            PLong localPLong2 = new PLong();
            PLong localPLong3 = new PLong();
            b.a(b.this, localPLong1, localPLong2, localPLong3, b.1.this.nIb, b.1.this.nEY);
            AppMethodBeat.o(22059);
            return true;
          }
          
          public final boolean aED()
          {
            AppMethodBeat.i(22058);
            ae.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
            b.1.this.nIb.run();
            b.bKJ();
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
    if ((paramInt < 0) || (nHZ == 0))
    {
      if (paramInt < 0) {
        ae.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
      }
      ae.i("MicroMsg.BakOldTempDbModel", "closeDB before");
      bKH().bKL();
      ae.i("MicroMsg.BakOldTempDbModel", "closeDB after");
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(22076);
      }
    }
    else
    {
      new aq(Looper.getMainLooper()).postDelayed(new Runnable()
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
  
  public final void bHQ()
  {
    nHW = null;
  }
  
  public final c bKE()
  {
    AppMethodBeat.i(22069);
    if (this.nHX == null) {
      this.nHX = new c();
    }
    c localc = this.nHX;
    AppMethodBeat.o(22069);
    return localc;
  }
  
  public final a bKF()
  {
    AppMethodBeat.i(22070);
    if (this.nHY == null) {
      this.nHY = new a();
    }
    a locala = this.nHY;
    AppMethodBeat.o(22070);
    return locala;
  }
  
  public static class a
    implements Runnable
  {
    public long dbSize = 0L;
    public boolean nIi = true;
    public long nIj = 0L;
    public long nIk = 0L;
    
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