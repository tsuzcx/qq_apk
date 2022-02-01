package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.f.a.af;
import com.tencent.mm.f.a.vu;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.t;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import junit.framework.Assert;

public final class b
  extends com.tencent.mm.plugin.backup.b.a
{
  private static b rUR;
  private static int rUU = 0;
  private c rUS;
  private a rUT;
  private c rUV;
  
  private boolean a(PLong paramPLong1, PLong paramPLong2, PLong paramPLong3, a parama, int paramInt)
  {
    AppMethodBeat.i(22074);
    bh.beI();
    com.tencent.mm.model.c.closeDB();
    Log.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
    bh.beI();
    long l = u.bBQ(com.tencent.mm.model.c.aHm());
    bh.beI();
    paramPLong3.value = (l + u.bBQ(com.tencent.mm.model.c.aHn()));
    l = paramPLong3.value;
    bh.beI();
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(l, paramPLong1, paramPLong2, com.tencent.mm.model.c.getAccPath()))
    {
      Log.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", new Object[] { Long.valueOf(paramPLong3.value) });
      parama.rVc = false;
      parama.rVd = paramPLong1.value;
      parama.rVe = paramPLong2.value;
      parama.dbSize = paramPLong3.value;
      AppMethodBeat.o(22074);
      return false;
    }
    bh.beI();
    Object localObject1 = com.tencent.mm.model.c.aHm();
    Object localObject2 = new StringBuilder();
    bh.beI();
    u.on((String)localObject1, com.tencent.mm.model.c.aHm() + ".tem");
    bh.beI();
    localObject1 = com.tencent.mm.model.c.aHn();
    localObject2 = new StringBuilder();
    bh.beI();
    u.on((String)localObject1, com.tencent.mm.model.c.aHn() + ".tem");
    localObject1 = new StringBuilder();
    bh.beI();
    localObject1 = com.tencent.mm.model.c.aHn() + "-journal";
    localObject2 = new StringBuilder();
    bh.beI();
    u.on((String)localObject1, com.tencent.mm.model.c.aHn() + ".tem-journal");
    localObject1 = new StringBuilder();
    bh.beI();
    localObject1 = com.tencent.mm.model.c.aHn() + "-wal";
    localObject2 = new StringBuilder();
    bh.beI();
    u.on((String)localObject1, com.tencent.mm.model.c.aHn() + ".tem-wal");
    Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
    com.tencent.mm.kernel.h.aHE().release();
    com.tencent.mm.kernel.h.aHE().initialize();
    Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
    localObject1 = cuL();
    bh.beI();
    localObject2 = com.tencent.mm.model.c.getAccPath();
    bh.beI();
    int i = com.tencent.mm.model.c.getUin();
    Log.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", new Object[] { localObject2, Integer.valueOf(i) });
    ((c)localObject1).uin = i;
    ((c)localObject1).kcB = ((String)localObject2);
    Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
    localObject1 = cuL();
    localObject2 = new StringBuilder();
    bh.beI();
    localObject2 = com.tencent.mm.model.c.aHm() + ".tem";
    bh.beI();
    i = com.tencent.mm.model.c.getUin();
    Object localObject3 = new StringBuilder();
    bh.beI();
    localObject3 = com.tencent.mm.model.c.aHn() + ".tem";
    Log.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", new Object[] { ((c)localObject1).rVh, localObject2, Integer.valueOf(i), localObject3, Util.getStack() });
    if (((c)localObject1).kcF != null) {
      Log.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
    }
    Object localObject4;
    if (paramInt > 0)
    {
      if ((((c)localObject1).rVh != null) && (!((c)localObject1).rVh.booleanValue()))
      {
        Log.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
        ((c)localObject1).cuP();
      }
      localObject4 = "bakoldInitDB here  isTempDb should null :" + ((c)localObject1).rVh;
      if (((c)localObject1).rVh != null) {
        break label748;
      }
    }
    label748:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue((String)localObject4, bool);
      ((c)localObject1).rVh = Boolean.TRUE;
      ((c)localObject1).kcF = new com.tencent.mm.storagebase.h(new c.2((c)localObject1));
      localObject4 = ((c)localObject1).kcF;
      l = i;
      q.dR(true);
      if (((com.tencent.mm.storagebase.h)localObject4).b((String)localObject2, (String)localObject3, "", l, new HashMap(), false)) {
        break;
      }
      paramPLong1 = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(22074);
      throw paramPLong1;
    }
    ((c)localObject1).rSs = new ao(((c)localObject1).kcF);
    localObject2 = (o)com.tencent.mm.kernel.h.ae(o.class);
    ((c)localObject1).rSt = ((o)localObject2).e(((c)localObject1).kcF);
    ((c)localObject1).rSv = ((o)localObject2).f(((c)localObject1).kcF);
    ((c)localObject1).rSu = ((o)localObject2).a(((c)localObject1).kcF, ((c)localObject1).rSt, ((c)localObject1).rSv);
    ((c)localObject1).rSu.a(new bk(((c)localObject1).rSu));
    ((c)localObject1).rSu.a(new t(((c)localObject1).rSu));
    ((c)localObject1).rSy = ((o)localObject2).g(((c)localObject1).kcF);
    ((c)localObject1).rSw = new com.tencent.mm.ay.i(((c)localObject1).kcF);
    if (com.tencent.mm.by.c.blP("emoji")) {
      ((c)localObject1).rSx = new f(((c)localObject1).kcF);
    }
    ((c)localObject1).rSA = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).c(((c)localObject1).kcF);
    ((c)localObject1).rSz = new x(((c)localObject1).kcF);
    ((c)localObject1).rSB = new l(((c)localObject1).kcF);
    ((c)localObject1).rSC = new j(((c)localObject1).kcF);
    ((c)localObject1).rSD = new d(((c)localObject1).kcF);
    ((c)localObject1).rVf = new cl(((c)localObject1).rSs);
    ((c)localObject1).rVf.add(new c.1((c)localObject1));
    ((c)localObject1).rVf.hAH();
    Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
    cuK();
    parama.rVc = true;
    parama.rVd = paramPLong1.value;
    parama.rVe = paramPLong2.value;
    parama.dbSize = paramPLong3.value;
    com.tencent.mm.plugin.backup.bakoldlogic.a.a.aop(com.tencent.mm.plugin.backup.bakoldlogic.a.a.cuh());
    AppMethodBeat.o(22074);
    return true;
  }
  
  public static b cuH()
  {
    AppMethodBeat.i(22068);
    if (rUR == null)
    {
      localb = new b();
      rUR = localb;
      a(localb);
    }
    b localb = rUR;
    AppMethodBeat.o(22068);
    return localb;
  }
  
  private static void cuK()
  {
    AppMethodBeat.i(22071);
    af localaf = new af();
    EventCenter.instance.publish(localaf);
    AppMethodBeat.o(22071);
  }
  
  private c cuL()
  {
    AppMethodBeat.i(22072);
    if (this.rUV == null) {
      this.rUV = new c();
    }
    c localc = this.rUV;
    AppMethodBeat.o(22072);
    return localc;
  }
  
  public static void cuM()
  {
    AppMethodBeat.i(22075);
    StringBuilder localStringBuilder = new StringBuilder();
    bh.beI();
    u.deleteFile(com.tencent.mm.model.c.aHm() + ".tem");
    localStringBuilder = new StringBuilder();
    bh.beI();
    u.deleteFile(com.tencent.mm.model.c.aHm() + ".ini.tem");
    localStringBuilder = new StringBuilder();
    bh.beI();
    u.deleteFile(com.tencent.mm.model.c.aHn() + ".tem");
    localStringBuilder = new StringBuilder();
    bh.beI();
    u.deleteFile(com.tencent.mm.model.c.aHn() + ".ini.tem");
    AppMethodBeat.o(22075);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(22073);
    final long l = Util.nowMilliSecond();
    Log.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", new Object[] { Boolean.FALSE, Util.getStack() });
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22061);
        com.tencent.mm.kernel.h.aHE().aGH();
        Log.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[] { Integer.valueOf(b.rUU), Long.valueOf(Util.milliSecondsToNow(l)) });
        b.access$008();
        bh.aHJ().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
        {
          public final boolean doInBackground()
          {
            AppMethodBeat.i(22059);
            b.cuM();
            PLong localPLong1 = new PLong();
            PLong localPLong2 = new PLong();
            PLong localPLong3 = new PLong();
            b.a(b.this, localPLong1, localPLong2, localPLong3, b.1.this.rUW, b.1.this.rRS);
            AppMethodBeat.o(22059);
            return true;
          }
          
          public final boolean onPostExecute()
          {
            AppMethodBeat.i(22058);
            Log.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
            b.1.this.rUW.run();
            b.cuN();
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
    if ((paramInt < 0) || (rUU == 0))
    {
      if (paramInt < 0) {
        Log.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
      }
      Log.i("MicroMsg.BakOldTempDbModel", "closeDB before");
      cuL().cuP();
      Log.i("MicroMsg.BakOldTempDbModel", "closeDB after");
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(22076);
      }
    }
    else
    {
      new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
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
  
  public final void crU()
  {
    rUR = null;
  }
  
  public final c cuI()
  {
    AppMethodBeat.i(22069);
    if (this.rUS == null) {
      this.rUS = new c();
    }
    c localc = this.rUS;
    AppMethodBeat.o(22069);
    return localc;
  }
  
  public final a cuJ()
  {
    AppMethodBeat.i(22070);
    if (this.rUT == null) {
      this.rUT = new a();
    }
    a locala = this.rUT;
    AppMethodBeat.o(22070);
    return locala;
  }
  
  public static class a
    implements Runnable
  {
    public long dbSize = 0L;
    public boolean rVc = true;
    public long rVd = 0L;
    public long rVe = 0L;
    
    public void run()
    {
      AppMethodBeat.i(22067);
      AppMethodBeat.o(22067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b
 * JD-Core Version:    0.7.0.1
 */