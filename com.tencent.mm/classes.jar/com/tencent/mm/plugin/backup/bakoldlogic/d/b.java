package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.m;
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
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import junit.framework.Assert;

public final class b
  extends com.tencent.mm.plugin.backup.b.a
{
  private static b oSS;
  private static int oSV = 0;
  private c oST;
  private a oSU;
  private c oSW;
  
  private boolean a(PLong paramPLong1, PLong paramPLong2, PLong paramPLong3, a parama, int paramInt)
  {
    AppMethodBeat.i(22074);
    bg.aVF();
    com.tencent.mm.model.c.closeDB();
    Log.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
    bg.aVF();
    long l = s.boW(com.tencent.mm.model.c.azN());
    bg.aVF();
    paramPLong3.value = (l + s.boW(com.tencent.mm.model.c.azO()));
    l = paramPLong3.value;
    bg.aVF();
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(l, paramPLong1, paramPLong2, com.tencent.mm.model.c.getAccPath()))
    {
      Log.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", new Object[] { Long.valueOf(paramPLong3.value) });
      parama.oTe = false;
      parama.oTf = paramPLong1.value;
      parama.oTg = paramPLong2.value;
      parama.dbSize = paramPLong3.value;
      AppMethodBeat.o(22074);
      return false;
    }
    bg.aVF();
    Object localObject1 = com.tencent.mm.model.c.azN();
    Object localObject2 = new StringBuilder();
    bg.aVF();
    s.nw((String)localObject1, com.tencent.mm.model.c.azN() + ".tem");
    bg.aVF();
    localObject1 = com.tencent.mm.model.c.azO();
    localObject2 = new StringBuilder();
    bg.aVF();
    s.nw((String)localObject1, com.tencent.mm.model.c.azO() + ".tem");
    localObject1 = new StringBuilder();
    bg.aVF();
    localObject1 = com.tencent.mm.model.c.azO() + "-journal";
    localObject2 = new StringBuilder();
    bg.aVF();
    s.nw((String)localObject1, com.tencent.mm.model.c.azO() + ".tem-journal");
    localObject1 = new StringBuilder();
    bg.aVF();
    localObject1 = com.tencent.mm.model.c.azO() + "-wal";
    localObject2 = new StringBuilder();
    bg.aVF();
    s.nw((String)localObject1, com.tencent.mm.model.c.azO() + ".tem-wal");
    Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
    g.aAf().release();
    g.aAf().initialize();
    Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
    localObject1 = chA();
    bg.aVF();
    localObject2 = com.tencent.mm.model.c.getAccPath();
    bg.aVF();
    int i = com.tencent.mm.model.c.getUin();
    Log.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", new Object[] { localObject2, Integer.valueOf(i) });
    ((c)localObject1).uin = i;
    ((c)localObject1).hqG = ((String)localObject2);
    Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
    localObject1 = chA();
    localObject2 = new StringBuilder();
    bg.aVF();
    localObject2 = com.tencent.mm.model.c.azN() + ".tem";
    bg.aVF();
    i = com.tencent.mm.model.c.getUin();
    Object localObject3 = new StringBuilder();
    bg.aVF();
    localObject3 = com.tencent.mm.model.c.azO() + ".tem";
    Log.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", new Object[] { ((c)localObject1).oTj, localObject2, Integer.valueOf(i), localObject3, Util.getStack() });
    if (((c)localObject1).hqK != null) {
      Log.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
    }
    Object localObject4;
    if (paramInt > 0)
    {
      if ((((c)localObject1).oTj != null) && (!((c)localObject1).oTj.booleanValue()))
      {
        Log.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
        ((c)localObject1).chE();
      }
      localObject4 = "bakoldInitDB here  isTempDb should null :" + ((c)localObject1).oTj;
      if (((c)localObject1).oTj != null) {
        break label748;
      }
    }
    label748:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue((String)localObject4, bool);
      ((c)localObject1).oTj = Boolean.TRUE;
      ((c)localObject1).hqK = new h(new c.2((c)localObject1));
      localObject4 = ((c)localObject1).hqK;
      l = i;
      q.dr(true);
      if (((h)localObject4).b((String)localObject2, (String)localObject3, "", l, new HashMap(), false)) {
        break;
      }
      paramPLong1 = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(22074);
      throw paramPLong1;
    }
    ((c)localObject1).oQv = new ao(((c)localObject1).hqK);
    localObject2 = (m)g.af(m.class);
    ((c)localObject1).oQw = ((m)localObject2).c(((c)localObject1).hqK);
    ((c)localObject1).oQy = ((m)localObject2).d(((c)localObject1).hqK);
    ((c)localObject1).oQx = ((m)localObject2).a(((c)localObject1).hqK, ((c)localObject1).oQw, ((c)localObject1).oQy);
    ((c)localObject1).oQx.a(new bk(((c)localObject1).oQx));
    ((c)localObject1).oQx.a(new com.tencent.mm.storage.t(((c)localObject1).oQx));
    ((c)localObject1).oQB = ((m)localObject2).e(((c)localObject1).hqK);
    ((c)localObject1).oQz = new com.tencent.mm.av.i(((c)localObject1).hqK);
    if (com.tencent.mm.br.c.aZU("emoji")) {
      ((c)localObject1).oQA = new f(((c)localObject1).hqK);
    }
    ((c)localObject1).oQD = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).b(((c)localObject1).hqK);
    ((c)localObject1).oQC = new com.tencent.mm.modelvideo.t(((c)localObject1).hqK);
    ((c)localObject1).oQE = new l(((c)localObject1).hqK);
    ((c)localObject1).oQF = new j(((c)localObject1).hqK);
    ((c)localObject1).oQG = new d(((c)localObject1).hqK);
    ((c)localObject1).oTh = new ck(((c)localObject1).oQv);
    ((c)localObject1).oTh.add(new c.1((c)localObject1));
    ((c)localObject1).oTh.gEr();
    Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
    chz();
    parama.oTe = true;
    parama.oTf = paramPLong1.value;
    parama.oTg = paramPLong2.value;
    parama.dbSize = paramPLong3.value;
    com.tencent.mm.plugin.backup.bakoldlogic.a.a.agL(com.tencent.mm.plugin.backup.bakoldlogic.a.a.cgW());
    AppMethodBeat.o(22074);
    return true;
  }
  
  private c chA()
  {
    AppMethodBeat.i(22072);
    if (this.oSW == null) {
      this.oSW = new c();
    }
    c localc = this.oSW;
    AppMethodBeat.o(22072);
    return localc;
  }
  
  public static void chB()
  {
    AppMethodBeat.i(22075);
    StringBuilder localStringBuilder = new StringBuilder();
    bg.aVF();
    s.deleteFile(com.tencent.mm.model.c.azN() + ".tem");
    localStringBuilder = new StringBuilder();
    bg.aVF();
    s.deleteFile(com.tencent.mm.model.c.azN() + ".ini.tem");
    localStringBuilder = new StringBuilder();
    bg.aVF();
    s.deleteFile(com.tencent.mm.model.c.azO() + ".tem");
    localStringBuilder = new StringBuilder();
    bg.aVF();
    s.deleteFile(com.tencent.mm.model.c.azO() + ".ini.tem");
    AppMethodBeat.o(22075);
  }
  
  public static b chw()
  {
    AppMethodBeat.i(22068);
    if (oSS == null)
    {
      localb = new b();
      oSS = localb;
      a(localb);
    }
    b localb = oSS;
    AppMethodBeat.o(22068);
    return localb;
  }
  
  private static void chz()
  {
    AppMethodBeat.i(22071);
    ae localae = new ae();
    EventCenter.instance.publish(localae);
    AppMethodBeat.o(22071);
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
        g.aAf().azk();
        Log.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[] { Integer.valueOf(b.oSV), Long.valueOf(Util.milliSecondsToNow(l)) });
        b.access$008();
        bg.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
        {
          public final boolean doInBackground()
          {
            AppMethodBeat.i(22059);
            b.chB();
            PLong localPLong1 = new PLong();
            PLong localPLong2 = new PLong();
            PLong localPLong3 = new PLong();
            b.a(b.this, localPLong1, localPLong2, localPLong3, b.1.this.oSX, b.1.this.oPV);
            AppMethodBeat.o(22059);
            return true;
          }
          
          public final boolean onPostExecute()
          {
            AppMethodBeat.i(22058);
            Log.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
            b.1.this.oSX.run();
            b.chC();
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
    if ((paramInt < 0) || (oSV == 0))
    {
      if (paramInt < 0) {
        Log.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
      }
      Log.i("MicroMsg.BakOldTempDbModel", "closeDB before");
      chA().chE();
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
  
  public final void ceH()
  {
    oSS = null;
  }
  
  public final c chx()
  {
    AppMethodBeat.i(22069);
    if (this.oST == null) {
      this.oST = new c();
    }
    c localc = this.oST;
    AppMethodBeat.o(22069);
    return localc;
  }
  
  public final a chy()
  {
    AppMethodBeat.i(22070);
    if (this.oSU == null) {
      this.oSU = new a();
    }
    a locala = this.oSU;
    AppMethodBeat.o(22070);
    return locala;
  }
  
  public static class a
    implements Runnable
  {
    public long dbSize = 0L;
    public boolean oTe = true;
    public long oTf = 0L;
    public long oTg = 0L;
    
    public void run()
    {
      AppMethodBeat.i(22067);
      AppMethodBeat.o(22067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b
 * JD-Core Version:    0.7.0.1
 */