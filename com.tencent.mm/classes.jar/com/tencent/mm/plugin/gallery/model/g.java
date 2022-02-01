package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class g
{
  static int DEFAULT_CORE_POOL_SIZE;
  aq gKO;
  HandlerThread tRl;
  HandlerThread tRm;
  aq tRn;
  aq tRo;
  ExecutorService tRp;
  ExecutorService tRq;
  ExecutorService tRr;
  HandlerThread tRs;
  aq tRt;
  
  g()
  {
    AppMethodBeat.i(111298);
    ae.d("MicroMsg.GalleryHandlerThread", "GalleryHandlerThread init.");
    this.tRl = new HandlerThread("smartGalleryQueryHandlerThread", 10);
    this.tRn = null;
    this.tRl.start();
    this.tRm = new HandlerThread("galleryAssistHandlerThread", 10);
    this.tRo = null;
    this.tRm.start();
    this.gKO = null;
    int j = Runtime.getRuntime().availableProcessors() / 2;
    if (j < 2) {}
    for (;;)
    {
      DEFAULT_CORE_POOL_SIZE = i;
      i locali = com.tencent.e.h.MqF;
      i = DEFAULT_CORE_POOL_SIZE;
      this.tRp = locali.a("gly-tp_q", i, i, new LinkedBlockingQueue());
      locali = com.tencent.e.h.MqF;
      i = DEFAULT_CORE_POOL_SIZE;
      this.tRq = locali.a("gly-tp", i, i, new LinkedBlockingQueue());
      this.tRr = com.tencent.e.h.MqF.a("gly-tp-p", DEFAULT_CORE_POOL_SIZE / 2, DEFAULT_CORE_POOL_SIZE / 2, new LinkedBlockingQueue());
      this.tRs = new HandlerThread("galleryQuerySubHandlerThread", 10);
      this.tRt = null;
      this.tRs.start();
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
    if ((paramh1 != null) && (paramh2 != null) && (this.tRr != null)) {
      while ((e.cXq().cXi()) && (!paramh1.isEmpty()))
      {
        final c.b localb = (c.b)paramh1.cXS();
        if ((localb != null) && (!localb.mCancel))
        {
          paramh2.add(localb);
          e.cXq().cXj();
          this.tRr.execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111297);
              final boolean bool = localb.aEC();
              g.this.cXK().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111296);
                  c.b localb = g.2.this.tRz;
                  boolean bool = bool;
                  localb.tQH.tQG.remove(localb);
                  c localc = localb.tQH;
                  localc.tQE += 1;
                  localb.tQH.cXk();
                  if (bool) {
                    localb.tQH.tQA.a(localb.mFilePath, localb.bitmap, localb.tQK, null, true, -1, localb.tQL);
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
    if ((paramh != null) && (paramHashMap != null) && (this.tRq != null)) {
      while ((e.cXq().cXg()) && (!paramh.isEmpty()))
      {
        final String str = (String)paramh.cXS();
        if (paramHashMap.containsKey(str))
        {
          final c.c localc = (c.c)paramHashMap.get(str);
          if ((localc != null) && (!localc.mCancel))
          {
            e.cXq().cXh();
            this.tRq.execute(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111295);
                long l2 = SystemClock.currentThreadTimeMillis();
                long l1 = SystemClock.uptimeMillis();
                final boolean bool = localc.aEC();
                l2 = SystemClock.currentThreadTimeMillis() - l2;
                l1 = SystemClock.uptimeMillis() - l1;
                ae.d("MicroMsg.GalleryHandlerThread", "background time: %s, %s, %s, %s.", new Object[] { str, Long.valueOf(l2), Long.valueOf(l1), Float.valueOf((float)l2 * 1.0F / (float)l1) });
                g.this.cXK().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(111294);
                    c.c localc = g.1.this.tRu;
                    boolean bool = bool;
                    ae.d("MicroMsg.CacheService", "do on post execute, filePath[%s], mDecodeTaskKey[%s], success[%s], cancel[%s].", new Object[] { localc.mFilePath, localc.tQN, Boolean.valueOf(bool), Boolean.valueOf(localc.mCancel) });
                    if (!localc.mCancel) {
                      localc.tQH.tQD.remove(localc.tQN);
                    }
                    ae.d("MicroMsg.CacheService", "remove job from waitingDecodeTask, after size:[%d].", new Object[] { Integer.valueOf(localc.tQH.tQD.size()) });
                    c localc1 = localc.tQH;
                    localc1.tQB += 1;
                    localc.tQH.cXf();
                    if (bool)
                    {
                      localc.tQH.tQA.a(localc.mFilePath, localc.bitmap, localc.tQK, localc.tQM, localc.mCancel, localc.mPosition, localc.tQL);
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
  
  public final void aj(Runnable paramRunnable)
  {
    AppMethodBeat.i(173731);
    if (this.tRp != null) {
      this.tRp.execute(paramRunnable);
    }
    AppMethodBeat.o(173731);
  }
  
  public final void ak(Runnable paramRunnable)
  {
    AppMethodBeat.i(173733);
    if (paramRunnable == null)
    {
      ae.e("MicroMsg.GalleryHandlerThread", "postToQuerySubWorker runnable is null");
      AppMethodBeat.o(173733);
      return;
    }
    aq localaq = cXL();
    if (localaq != null)
    {
      localaq.post(paramRunnable);
      AppMethodBeat.o(173733);
      return;
    }
    ae.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
    AppMethodBeat.o(173733);
  }
  
  public final aq cXJ()
  {
    AppMethodBeat.i(111301);
    if ((this.tRo == null) && (this.tRm != null)) {
      this.tRo = new aq(this.tRm.getLooper());
    }
    aq localaq = this.tRo;
    AppMethodBeat.o(111301);
    return localaq;
  }
  
  public final aq cXK()
  {
    AppMethodBeat.i(111302);
    if (this.gKO == null) {
      this.gKO = new aq(Looper.getMainLooper());
    }
    aq localaq = this.gKO;
    AppMethodBeat.o(111302);
    return localaq;
  }
  
  final aq cXL()
  {
    AppMethodBeat.i(173732);
    if ((this.tRt == null) && (this.tRs != null)) {
      this.tRt = new aq(this.tRs.getLooper());
    }
    aq localaq = this.tRt;
    AppMethodBeat.o(173732);
    return localaq;
  }
  
  public final aq cXM()
  {
    AppMethodBeat.i(111300);
    if ((this.tRn == null) && (this.tRl != null)) {
      this.tRn = new aq(this.tRl.getLooper());
    }
    aq localaq = this.tRn;
    AppMethodBeat.o(111300);
    return localaq;
  }
  
  public final void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(111306);
    if (paramRunnable == null)
    {
      ae.e("MicroMsg.GalleryHandlerThread", "postToMainThread, runnable is null");
      AppMethodBeat.o(111306);
      return;
    }
    cXK().post(paramRunnable);
    AppMethodBeat.o(111306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.g
 * JD-Core Version:    0.7.0.1
 */