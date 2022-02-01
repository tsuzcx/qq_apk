package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.b.i;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public byte[] oiq;
  public long oir;
  
  public a()
  {
    AppMethodBeat.i(132228);
    this.oir = -1L;
    if (bzt()) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132227);
          try
          {
            if (a.bzt()) {
              com.tencent.mm.plugin.report.f.Ozc.idkeyStat(226L, 1L, 1L, false);
            }
            AppMethodBeat.o(132227);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", new Object[] { Util.stackTraceToString(localException) });
            AppMethodBeat.o(132227);
          }
        }
      }, 5000L);
    }
    AppMethodBeat.o(132228);
  }
  
  private void a(e parame)
  {
    AppMethodBeat.i(241921);
    if (bzs() <= 0)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(226L, 11L, 1L, false);
      Log.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", new Object[] { toString() });
      AppMethodBeat.o(241921);
      return;
    }
    int i = parame.aw(this.oiq);
    if (i != 0)
    {
      Log.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", new Object[] { Integer.valueOf(i) });
      this.oiq = null;
      AppMethodBeat.o(241921);
      return;
    }
    this.oir = 0L;
    AppMethodBeat.o(241921);
  }
  
  public static boolean bzt()
  {
    AppMethodBeat.i(132229);
    if ((b.aZG()) || (!h.baz()))
    {
      AppMethodBeat.o(132229);
      return false;
    }
    int i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("AndroidUseWorkerAuthCache"), 0);
    h.baF();
    h.baC();
    int j = i.jdMethod_do(b.getUin(), 100);
    boolean bool = CrashReportFactory.hasDebuger();
    h.baF();
    h.baC();
    Log.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(b.getUin()), Integer.valueOf(j), Boolean.valueOf(h.baC().aZN()) });
    if (bool)
    {
      AppMethodBeat.o(132229);
      return true;
    }
    if (i > j)
    {
      AppMethodBeat.o(132229);
      return true;
    }
    AppMethodBeat.o(132229);
    return false;
  }
  
  public static void bzu()
  {
    AppMethodBeat.i(241917);
    try
    {
      h.baF();
      if (h.baC().mBN != null)
      {
        h.baF();
        if (h.baD().mCm.oun != null)
        {
          h.baF();
          locala = h.baC().mBN;
          h.baF();
          locala.a(h.baD().mCm.oun.bGg());
          AppMethodBeat.o(241917);
          return;
        }
      }
      h.baF();
      a locala = h.baC().mBN;
      h.baF();
      Log.i("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush but object is null [%s, %s]", new Object[] { locala, h.baD().mCm.oun });
      AppMethodBeat.o(241917);
      return;
    }
    finally
    {
      Log.e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", new Object[] { Util.stackTraceToString(localThrowable) });
      AppMethodBeat.o(241917);
    }
  }
  
  public final int bzs()
  {
    if (this.oiq == null) {
      return -1;
    }
    return this.oiq.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.a
 * JD-Core Version:    0.7.0.1
 */