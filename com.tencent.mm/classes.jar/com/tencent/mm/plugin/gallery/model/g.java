package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class g
{
  static int DEFAULT_CORE_POOL_SIZE;
  ao gox;
  HandlerThread sJJ;
  HandlerThread sJK;
  ao sJL;
  ao sJM;
  ExecutorService sJN;
  ExecutorService sJO;
  ExecutorService sJP;
  HandlerThread sJQ;
  ao sJR;
  
  g()
  {
    AppMethodBeat.i(111298);
    ac.d("MicroMsg.GalleryHandlerThread", "GalleryHandlerThread init.");
    this.sJJ = new HandlerThread("smartGalleryQueryHandlerThread", 10);
    this.sJL = null;
    this.sJJ.start();
    this.sJK = new HandlerThread("galleryAssistHandlerThread", 10);
    this.sJM = null;
    this.sJK.start();
    this.gox = null;
    int j = Runtime.getRuntime().availableProcessors() / 2;
    if (j < 2) {}
    for (;;)
    {
      DEFAULT_CORE_POOL_SIZE = i;
      i locali = com.tencent.e.h.JZN;
      i = DEFAULT_CORE_POOL_SIZE;
      this.sJN = locali.a("gly-tp_q", i, i, new LinkedBlockingQueue());
      locali = com.tencent.e.h.JZN;
      i = DEFAULT_CORE_POOL_SIZE;
      this.sJO = locali.a("gly-tp", i, i, new LinkedBlockingQueue());
      this.sJP = com.tencent.e.h.JZN.a("gly-tp-p", DEFAULT_CORE_POOL_SIZE / 2, DEFAULT_CORE_POOL_SIZE / 2, new LinkedBlockingQueue());
      this.sJQ = new HandlerThread("galleryQuerySubHandlerThread", 10);
      this.sJR = null;
      this.sJQ.start();
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
    if ((paramh1 != null) && (paramh2 != null) && (this.sJP != null)) {
      while ((e.cMs().cMk()) && (!paramh1.isEmpty()))
      {
        final c.b localb = (c.b)paramh1.cMV();
        if ((localb != null) && (!localb.mCancel))
        {
          paramh2.add(localb);
          e.cMs().cMl();
          this.sJP.execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111297);
              final boolean bool = localb.aBj();
              g.this.cMM().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111296);
                  c.b localb = g.2.this.sJX;
                  boolean bool = bool;
                  localb.sJf.sJe.remove(localb);
                  c localc = localb.sJf;
                  localc.sJc += 1;
                  localb.sJf.cMm();
                  if (bool) {
                    localb.sJf.sIY.a(localb.mFilePath, localb.bitmap, localb.sJi, null, true, -1, localb.sJj);
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
    if ((paramh != null) && (paramHashMap != null) && (this.sJO != null)) {
      while ((e.cMs().cMi()) && (!paramh.isEmpty()))
      {
        final String str = (String)paramh.cMV();
        if (paramHashMap.containsKey(str))
        {
          final c.c localc = (c.c)paramHashMap.get(str);
          if ((localc != null) && (!localc.mCancel))
          {
            e.cMs().cMj();
            this.sJO.execute(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111295);
                long l2 = SystemClock.currentThreadTimeMillis();
                long l1 = SystemClock.uptimeMillis();
                final boolean bool = localc.aBj();
                l2 = SystemClock.currentThreadTimeMillis() - l2;
                l1 = SystemClock.uptimeMillis() - l1;
                ac.d("MicroMsg.GalleryHandlerThread", "background time: %s, %s, %s, %s.", new Object[] { str, Long.valueOf(l2), Long.valueOf(l1), Float.valueOf((float)l2 * 1.0F / (float)l1) });
                g.this.cMM().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(111294);
                    c.c localc = g.1.this.sJS;
                    boolean bool = bool;
                    ac.d("MicroMsg.CacheService", "do on post execute, filePath[%s], mDecodeTaskKey[%s], success[%s], cancel[%s].", new Object[] { localc.mFilePath, localc.sJl, Boolean.valueOf(bool), Boolean.valueOf(localc.mCancel) });
                    if (!localc.mCancel) {
                      localc.sJf.sJb.remove(localc.sJl);
                    }
                    ac.d("MicroMsg.CacheService", "remove job from waitingDecodeTask, after size:[%d].", new Object[] { Integer.valueOf(localc.sJf.sJb.size()) });
                    c localc1 = localc.sJf;
                    localc1.sIZ += 1;
                    localc.sJf.cMh();
                    if (bool)
                    {
                      localc.sJf.sIY.a(localc.mFilePath, localc.bitmap, localc.sJi, localc.sJk, localc.mCancel, localc.mPosition, localc.sJj);
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
  
  public final void am(Runnable paramRunnable)
  {
    AppMethodBeat.i(173731);
    if (this.sJN != null) {
      this.sJN.execute(paramRunnable);
    }
    AppMethodBeat.o(173731);
  }
  
  public final void an(Runnable paramRunnable)
  {
    AppMethodBeat.i(173733);
    if (paramRunnable == null)
    {
      ac.e("MicroMsg.GalleryHandlerThread", "postToQuerySubWorker runnable is null");
      AppMethodBeat.o(173733);
      return;
    }
    ao localao = cMN();
    if (localao != null)
    {
      localao.post(paramRunnable);
      AppMethodBeat.o(173733);
      return;
    }
    ac.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
    AppMethodBeat.o(173733);
  }
  
  public final ao cML()
  {
    AppMethodBeat.i(111301);
    if ((this.sJM == null) && (this.sJK != null)) {
      this.sJM = new ao(this.sJK.getLooper());
    }
    ao localao = this.sJM;
    AppMethodBeat.o(111301);
    return localao;
  }
  
  public final ao cMM()
  {
    AppMethodBeat.i(111302);
    if (this.gox == null) {
      this.gox = new ao(Looper.getMainLooper());
    }
    ao localao = this.gox;
    AppMethodBeat.o(111302);
    return localao;
  }
  
  final ao cMN()
  {
    AppMethodBeat.i(173732);
    if ((this.sJR == null) && (this.sJQ != null)) {
      this.sJR = new ao(this.sJQ.getLooper());
    }
    ao localao = this.sJR;
    AppMethodBeat.o(173732);
    return localao;
  }
  
  public final ao cMO()
  {
    AppMethodBeat.i(111300);
    if ((this.sJL == null) && (this.sJJ != null)) {
      this.sJL = new ao(this.sJJ.getLooper());
    }
    ao localao = this.sJL;
    AppMethodBeat.o(111300);
    return localao;
  }
  
  public final void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(111306);
    if (paramRunnable == null)
    {
      ac.e("MicroMsg.GalleryHandlerThread", "postToMainThread, runnable is null");
      AppMethodBeat.o(111306);
      return;
    }
    cMM().post(paramRunnable);
    AppMethodBeat.o(111306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.g
 * JD-Core Version:    0.7.0.1
 */