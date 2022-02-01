package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class g
{
  static int DEFAULT_CORE_POOL_SIZE;
  ap gAC;
  HandlerThread rAR;
  HandlerThread rAS;
  ap rAT;
  ap rAU;
  ExecutorService rAV;
  ExecutorService rAW;
  ExecutorService rAX;
  HandlerThread rAY;
  ap rAZ;
  
  g()
  {
    AppMethodBeat.i(111298);
    ad.d("MicroMsg.GalleryHandlerThread", "GalleryHandlerThread init.");
    this.rAR = new HandlerThread("smartGalleryQueryHandlerThread", 10);
    this.rAT = null;
    this.rAR.start();
    this.rAS = new HandlerThread("galleryAssistHandlerThread", 10);
    this.rAU = null;
    this.rAS.start();
    this.gAC = null;
    int j = Runtime.getRuntime().availableProcessors() / 2;
    if (j < 2) {}
    for (;;)
    {
      DEFAULT_CORE_POOL_SIZE = i;
      i locali = com.tencent.e.h.Iye;
      i = DEFAULT_CORE_POOL_SIZE;
      this.rAV = locali.a("gly-tp_q", i, i, new LinkedBlockingQueue());
      locali = com.tencent.e.h.Iye;
      i = DEFAULT_CORE_POOL_SIZE;
      this.rAW = locali.a("gly-tp", i, i, new LinkedBlockingQueue());
      this.rAX = com.tencent.e.h.Iye.a("gly-tp-p", DEFAULT_CORE_POOL_SIZE / 2, DEFAULT_CORE_POOL_SIZE / 2, new LinkedBlockingQueue());
      this.rAY = new HandlerThread("galleryQuerySubHandlerThread", 10);
      this.rAZ = null;
      this.rAY.start();
      AppMethodBeat.o(111298);
      return;
      if (j > 4) {
        i = 4;
      } else {
        i = j;
      }
    }
  }
  
  public final void a(h<c.b> paramh1, h<c.b> paramh2)
  {
    AppMethodBeat.i(111308);
    if ((paramh1 != null) && (paramh2 != null) && (this.rAX != null)) {
      while ((e.czg().cyY()) && (!paramh1.isEmpty()))
      {
        final c.b localb = (c.b)paramh1.czJ();
        if ((localb != null) && (!localb.mCancel))
        {
          paramh2.add(localb);
          e.czg().cyZ();
          this.rAX.execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111297);
              final boolean bool = localb.aus();
              g.this.czA().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111296);
                  c.b localb = g.2.this.rBf;
                  boolean bool = bool;
                  localb.rAn.rAm.remove(localb);
                  c localc = localb.rAn;
                  localc.rAk += 1;
                  localb.rAn.cza();
                  if (bool) {
                    localb.rAn.rAg.a(localb.mFilePath, localb.bitmap, localb.rAq, null, true, -1, localb.rAr);
                  }
                  AppMethodBeat.o(111296);
                }
              });
              AppMethodBeat.o(111297);
            }
          });
        }
      }
    }
    AppMethodBeat.o(111308);
  }
  
  public final void a(h<String> paramh, HashMap<String, c.c> paramHashMap)
  {
    AppMethodBeat.i(111307);
    if ((paramh != null) && (paramHashMap != null) && (this.rAW != null)) {
      while ((e.czg().cyW()) && (!paramh.isEmpty()))
      {
        final String str = (String)paramh.czJ();
        if (paramHashMap.containsKey(str))
        {
          final c.c localc = (c.c)paramHashMap.get(str);
          if ((localc != null) && (!localc.mCancel))
          {
            e.czg().cyX();
            this.rAW.execute(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111295);
                long l2 = SystemClock.currentThreadTimeMillis();
                long l1 = SystemClock.uptimeMillis();
                final boolean bool = localc.aus();
                l2 = SystemClock.currentThreadTimeMillis() - l2;
                l1 = SystemClock.uptimeMillis() - l1;
                ad.d("MicroMsg.GalleryHandlerThread", "background time: %s, %s, %s, %s.", new Object[] { str, Long.valueOf(l2), Long.valueOf(l1), Float.valueOf((float)l2 * 1.0F / (float)l1) });
                g.this.czA().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(111294);
                    c.c localc = g.1.this.rBa;
                    boolean bool = bool;
                    ad.d("MicroMsg.CacheService", "do on post execute, filePath[%s], mDecodeTaskKey[%s], success[%s], cancel[%s].", new Object[] { localc.mFilePath, localc.rAt, Boolean.valueOf(bool), Boolean.valueOf(localc.mCancel) });
                    if (!localc.mCancel) {
                      localc.rAn.rAj.remove(localc.rAt);
                    }
                    ad.d("MicroMsg.CacheService", "remove job from waitingDecodeTask, after size:[%d].", new Object[] { Integer.valueOf(localc.rAn.rAj.size()) });
                    c localc1 = localc.rAn;
                    localc1.rAh += 1;
                    localc.rAn.cyV();
                    if (bool)
                    {
                      localc.rAn.rAg.a(localc.mFilePath, localc.bitmap, localc.rAq, localc.rAs, localc.mCancel, localc.mPosition, localc.rAr);
                      localc.bitmap = null;
                    }
                    AppMethodBeat.o(111294);
                  }
                });
                AppMethodBeat.o(111295);
              }
            });
          }
        }
      }
    }
    AppMethodBeat.o(111307);
  }
  
  public final void ak(Runnable paramRunnable)
  {
    AppMethodBeat.i(173731);
    if (this.rAV != null) {
      this.rAV.execute(paramRunnable);
    }
    AppMethodBeat.o(173731);
  }
  
  public final void al(Runnable paramRunnable)
  {
    AppMethodBeat.i(173733);
    if (paramRunnable == null)
    {
      ad.e("MicroMsg.GalleryHandlerThread", "postToQuerySubWorker runnable is null");
      AppMethodBeat.o(173733);
      return;
    }
    ap localap = czB();
    if (localap != null)
    {
      localap.post(paramRunnable);
      AppMethodBeat.o(173733);
      return;
    }
    ad.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
    AppMethodBeat.o(173733);
  }
  
  public final ap czA()
  {
    AppMethodBeat.i(111302);
    if (this.gAC == null) {
      this.gAC = new ap(Looper.getMainLooper());
    }
    ap localap = this.gAC;
    AppMethodBeat.o(111302);
    return localap;
  }
  
  final ap czB()
  {
    AppMethodBeat.i(173732);
    if ((this.rAZ == null) && (this.rAY != null)) {
      this.rAZ = new ap(this.rAY.getLooper());
    }
    ap localap = this.rAZ;
    AppMethodBeat.o(173732);
    return localap;
  }
  
  public final ap czC()
  {
    AppMethodBeat.i(111300);
    if ((this.rAT == null) && (this.rAR != null)) {
      this.rAT = new ap(this.rAR.getLooper());
    }
    ap localap = this.rAT;
    AppMethodBeat.o(111300);
    return localap;
  }
  
  public final ap czz()
  {
    AppMethodBeat.i(111301);
    if ((this.rAU == null) && (this.rAS != null)) {
      this.rAU = new ap(this.rAS.getLooper());
    }
    ap localap = this.rAU;
    AppMethodBeat.o(111301);
    return localap;
  }
  
  public final void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(111306);
    if (paramRunnable == null)
    {
      ad.e("MicroMsg.GalleryHandlerThread", "postToMainThread, runnable is null");
      AppMethodBeat.o(111306);
      return;
    }
    czA().post(paramRunnable);
    AppMethodBeat.o(111306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.g
 * JD-Core Version:    0.7.0.1
 */