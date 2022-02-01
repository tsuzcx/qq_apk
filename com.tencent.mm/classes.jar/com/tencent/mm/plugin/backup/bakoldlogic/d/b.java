package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ai;
import com.tencent.mm.autogen.a.xk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class b
  extends com.tencent.mm.plugin.backup.b.a
{
  private static b vgg;
  private static int vgj = 0;
  private c vgh;
  private a vgi;
  private c vgk;
  
  public static b cXr()
  {
    AppMethodBeat.i(22068);
    if (vgg == null)
    {
      localb = new b();
      vgg = localb;
      a(localb);
    }
    b localb = vgg;
    AppMethodBeat.o(22068);
    return localb;
  }
  
  private static void cXu()
  {
    AppMethodBeat.i(22071);
    new ai().publish();
    AppMethodBeat.o(22071);
  }
  
  private c cXv()
  {
    AppMethodBeat.i(22072);
    if (this.vgk == null) {
      this.vgk = new c();
    }
    c localc = this.vgk;
    AppMethodBeat.o(22072);
    return localc;
  }
  
  public static void cXw()
  {
    AppMethodBeat.i(22075);
    StringBuilder localStringBuilder = new StringBuilder();
    bh.bCz();
    y.deleteFile(com.tencent.mm.model.c.bak() + ".tem");
    localStringBuilder = new StringBuilder();
    bh.bCz();
    y.deleteFile(com.tencent.mm.model.c.bak() + ".ini.tem");
    localStringBuilder = new StringBuilder();
    bh.bCz();
    y.deleteFile(com.tencent.mm.model.c.bal() + ".tem");
    localStringBuilder = new StringBuilder();
    bh.bCz();
    y.deleteFile(com.tencent.mm.model.c.bal() + ".ini.tem");
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
        h.baC().aZJ();
        Log.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[] { Integer.valueOf(b.vgj), Long.valueOf(Util.milliSecondsToNow(l)) });
        b.access$008();
        bh.baH().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
        {
          public final boolean doInBackground()
          {
            AppMethodBeat.i(22059);
            b.cXw();
            PLong localPLong1 = new PLong();
            PLong localPLong2 = new PLong();
            PLong localPLong3 = new PLong();
            b.a(b.this, localPLong1, localPLong2, localPLong3, b.1.this.vgl, b.1.this.vdi);
            AppMethodBeat.o(22059);
            return true;
          }
          
          public final boolean onPostExecute()
          {
            AppMethodBeat.i(22058);
            Log.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
            b.1.this.vgl.run();
            b.cXx();
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
    if ((paramInt < 0) || (vgj == 0))
    {
      if (paramInt < 0) {
        Log.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
      }
      Log.i("MicroMsg.BakOldTempDbModel", "closeDB before");
      cXv().cXz();
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
  
  public final void cUE()
  {
    vgg = null;
  }
  
  public final c cXs()
  {
    AppMethodBeat.i(22069);
    if (this.vgh == null) {
      this.vgh = new c();
    }
    c localc = this.vgh;
    AppMethodBeat.o(22069);
    return localc;
  }
  
  public final a cXt()
  {
    AppMethodBeat.i(22070);
    if (this.vgi == null) {
      this.vgi = new a();
    }
    a locala = this.vgi;
    AppMethodBeat.o(22070);
    return locala;
  }
  
  public static class a
    implements Runnable
  {
    public long dbSize = 0L;
    public boolean vgr = true;
    public long vgs = 0L;
    public long vgt = 0L;
    
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