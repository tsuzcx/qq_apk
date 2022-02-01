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
  ap gIf;
  ExecutorService tGA;
  HandlerThread tGB;
  ap tGC;
  HandlerThread tGu;
  HandlerThread tGv;
  ap tGw;
  ap tGx;
  ExecutorService tGy;
  ExecutorService tGz;
  
  g()
  {
    AppMethodBeat.i(111298);
    ad.d("MicroMsg.GalleryHandlerThread", "GalleryHandlerThread init.");
    this.tGu = new HandlerThread("smartGalleryQueryHandlerThread", 10);
    this.tGw = null;
    this.tGu.start();
    this.tGv = new HandlerThread("galleryAssistHandlerThread", 10);
    this.tGx = null;
    this.tGv.start();
    this.gIf = null;
    int j = Runtime.getRuntime().availableProcessors() / 2;
    if (j < 2) {}
    for (;;)
    {
      DEFAULT_CORE_POOL_SIZE = i;
      i locali = com.tencent.e.h.LTJ;
      i = DEFAULT_CORE_POOL_SIZE;
      this.tGy = locali.a("gly-tp_q", i, i, new LinkedBlockingQueue());
      locali = com.tencent.e.h.LTJ;
      i = DEFAULT_CORE_POOL_SIZE;
      this.tGz = locali.a("gly-tp", i, i, new LinkedBlockingQueue());
      this.tGA = com.tencent.e.h.LTJ.a("gly-tp-p", DEFAULT_CORE_POOL_SIZE / 2, DEFAULT_CORE_POOL_SIZE / 2, new LinkedBlockingQueue());
      this.tGB = new HandlerThread("galleryQuerySubHandlerThread", 10);
      this.tGC = null;
      this.tGB.start();
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
    if ((paramh1 != null) && (paramh2 != null) && (this.tGA != null)) {
      while ((e.cUL().cUD()) && (!paramh1.isEmpty()))
      {
        final c.b localb = (c.b)paramh1.cVn();
        if ((localb != null) && (!localb.mCancel))
        {
          paramh2.add(localb);
          e.cUL().cUE();
          this.tGA.execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111297);
              final boolean bool = localb.aEm();
              g.this.cVf().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111296);
                  c.b localb = g.2.this.tGI;
                  boolean bool = bool;
                  localb.tFQ.tFP.remove(localb);
                  c localc = localb.tFQ;
                  localc.tFN += 1;
                  localb.tFQ.cUF();
                  if (bool) {
                    localb.tFQ.tFJ.a(localb.mFilePath, localb.bitmap, localb.tFT, null, true, -1, localb.tFU);
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
    if ((paramh != null) && (paramHashMap != null) && (this.tGz != null)) {
      while ((e.cUL().cUB()) && (!paramh.isEmpty()))
      {
        final String str = (String)paramh.cVn();
        if (paramHashMap.containsKey(str))
        {
          final c.c localc = (c.c)paramHashMap.get(str);
          if ((localc != null) && (!localc.mCancel))
          {
            e.cUL().cUC();
            this.tGz.execute(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111295);
                long l2 = SystemClock.currentThreadTimeMillis();
                long l1 = SystemClock.uptimeMillis();
                final boolean bool = localc.aEm();
                l2 = SystemClock.currentThreadTimeMillis() - l2;
                l1 = SystemClock.uptimeMillis() - l1;
                ad.d("MicroMsg.GalleryHandlerThread", "background time: %s, %s, %s, %s.", new Object[] { str, Long.valueOf(l2), Long.valueOf(l1), Float.valueOf((float)l2 * 1.0F / (float)l1) });
                g.this.cVf().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(111294);
                    c.c localc = g.1.this.tGD;
                    boolean bool = bool;
                    ad.d("MicroMsg.CacheService", "do on post execute, filePath[%s], mDecodeTaskKey[%s], success[%s], cancel[%s].", new Object[] { localc.mFilePath, localc.tFW, Boolean.valueOf(bool), Boolean.valueOf(localc.mCancel) });
                    if (!localc.mCancel) {
                      localc.tFQ.tFM.remove(localc.tFW);
                    }
                    ad.d("MicroMsg.CacheService", "remove job from waitingDecodeTask, after size:[%d].", new Object[] { Integer.valueOf(localc.tFQ.tFM.size()) });
                    c localc1 = localc.tFQ;
                    localc1.tFK += 1;
                    localc.tFQ.cUA();
                    if (bool)
                    {
                      localc.tFQ.tFJ.a(localc.mFilePath, localc.bitmap, localc.tFT, localc.tFV, localc.mCancel, localc.mPosition, localc.tFU);
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
  
  public final void al(Runnable paramRunnable)
  {
    AppMethodBeat.i(173731);
    if (this.tGy != null) {
      this.tGy.execute(paramRunnable);
    }
    AppMethodBeat.o(173731);
  }
  
  public final void am(Runnable paramRunnable)
  {
    AppMethodBeat.i(173733);
    if (paramRunnable == null)
    {
      ad.e("MicroMsg.GalleryHandlerThread", "postToQuerySubWorker runnable is null");
      AppMethodBeat.o(173733);
      return;
    }
    ap localap = cVg();
    if (localap != null)
    {
      localap.post(paramRunnable);
      AppMethodBeat.o(173733);
      return;
    }
    ad.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
    AppMethodBeat.o(173733);
  }
  
  public final ap cVe()
  {
    AppMethodBeat.i(111301);
    if ((this.tGx == null) && (this.tGv != null)) {
      this.tGx = new ap(this.tGv.getLooper());
    }
    ap localap = this.tGx;
    AppMethodBeat.o(111301);
    return localap;
  }
  
  public final ap cVf()
  {
    AppMethodBeat.i(111302);
    if (this.gIf == null) {
      this.gIf = new ap(Looper.getMainLooper());
    }
    ap localap = this.gIf;
    AppMethodBeat.o(111302);
    return localap;
  }
  
  final ap cVg()
  {
    AppMethodBeat.i(173732);
    if ((this.tGC == null) && (this.tGB != null)) {
      this.tGC = new ap(this.tGB.getLooper());
    }
    ap localap = this.tGC;
    AppMethodBeat.o(173732);
    return localap;
  }
  
  public final ap cVh()
  {
    AppMethodBeat.i(111300);
    if ((this.tGw == null) && (this.tGu != null)) {
      this.tGw = new ap(this.tGu.getLooper());
    }
    ap localap = this.tGw;
    AppMethodBeat.o(111300);
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
    cVf().post(paramRunnable);
    AppMethodBeat.o(111306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.g
 * JD-Core Version:    0.7.0.1
 */