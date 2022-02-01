package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class g
{
  static int DEFAULT_CORE_POOL_SIZE;
  MMHandler hAk;
  MMHandler xiA;
  MMHandler xiB;
  ExecutorService xiC;
  ExecutorService xiD;
  ExecutorService xiE;
  HandlerThread xiF;
  MMHandler xiG;
  HandlerThread xiy;
  HandlerThread xiz;
  
  g()
  {
    AppMethodBeat.i(111298);
    Log.d("MicroMsg.GalleryHandlerThread", "GalleryHandlerThread init.");
    this.xiy = new HandlerThread("smartGalleryQueryHandlerThread", 10);
    this.xiA = null;
    this.xiy.start();
    this.xiz = new HandlerThread("galleryAssistHandlerThread", 10);
    this.xiB = null;
    this.xiz.start();
    this.hAk = null;
    int j = Runtime.getRuntime().availableProcessors() / 2;
    if (j < 2) {}
    for (;;)
    {
      DEFAULT_CORE_POOL_SIZE = i;
      i locali = com.tencent.f.h.RTc;
      i = DEFAULT_CORE_POOL_SIZE;
      this.xiC = locali.a("gly-tp_q", i, i, new LinkedBlockingQueue());
      locali = com.tencent.f.h.RTc;
      i = DEFAULT_CORE_POOL_SIZE;
      this.xiD = locali.a("gly-tp", i, i, new LinkedBlockingQueue());
      this.xiE = com.tencent.f.h.RTc.a("gly-tp-p", DEFAULT_CORE_POOL_SIZE / 2, DEFAULT_CORE_POOL_SIZE / 2, new LinkedBlockingQueue());
      this.xiF = new HandlerThread("galleryQuerySubHandlerThread", 10);
      this.xiG = null;
      this.xiF.start();
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
    if ((paramh1 != null) && (paramh2 != null) && (this.xiE != null)) {
      while ((e.dQJ().dQB()) && (!paramh1.isEmpty()))
      {
        final c.b localb = (c.b)paramh1.dRl();
        if ((localb != null) && (!localb.mCancel))
        {
          paramh2.add(localb);
          e.dQJ().dQC();
          this.xiE.execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111297);
              final boolean bool = localb.doInBackground();
              g.this.dRd().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111296);
                  c.b localb = g.2.this.xiM;
                  boolean bool = bool;
                  localb.xhU.xhT.remove(localb);
                  c localc = localb.xhU;
                  localc.xhR += 1;
                  localb.xhU.dQD();
                  if (bool) {
                    localb.xhU.xhN.a(localb.mFilePath, localb.bitmap, localb.xhX, null, true, -1, localb.xhY);
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
    if ((paramh != null) && (paramHashMap != null) && (this.xiD != null)) {
      while ((e.dQJ().dQz()) && (!paramh.isEmpty()))
      {
        final String str = (String)paramh.dRl();
        if (paramHashMap.containsKey(str))
        {
          final c.c localc = (c.c)paramHashMap.get(str);
          if ((localc != null) && (!localc.mCancel))
          {
            e.dQJ().dQA();
            this.xiD.execute(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111295);
                long l2 = SystemClock.currentThreadTimeMillis();
                long l1 = SystemClock.uptimeMillis();
                final boolean bool = localc.doInBackground();
                l2 = SystemClock.currentThreadTimeMillis() - l2;
                l1 = SystemClock.uptimeMillis() - l1;
                Log.d("MicroMsg.GalleryHandlerThread", "background time: %s, %s, %s, %s.", new Object[] { str, Long.valueOf(l2), Long.valueOf(l1), Float.valueOf((float)l2 * 1.0F / (float)l1) });
                g.this.dRd().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(111294);
                    c.c localc = g.1.this.xiH;
                    boolean bool = bool;
                    Log.d("MicroMsg.CacheService", "do on post execute, filePath[%s], mDecodeTaskKey[%s], success[%s], cancel[%s].", new Object[] { localc.mFilePath, localc.xia, Boolean.valueOf(bool), Boolean.valueOf(localc.mCancel) });
                    if (!localc.mCancel) {
                      localc.xhU.xhQ.remove(localc.xia);
                    }
                    Log.d("MicroMsg.CacheService", "remove job from waitingDecodeTask, after size:[%d].", new Object[] { Integer.valueOf(localc.xhU.xhQ.size()) });
                    c localc1 = localc.xhU;
                    localc1.xhO += 1;
                    localc.xhU.dQy();
                    if (bool)
                    {
                      localc.xhU.xhN.a(localc.mFilePath, localc.bitmap, localc.xhX, localc.xhZ, localc.mCancel, localc.mPosition, localc.xhY);
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
  
  public final void aq(Runnable paramRunnable)
  {
    AppMethodBeat.i(257727);
    MMHandler localMMHandler = dRc();
    if (localMMHandler != null)
    {
      localMMHandler.post(paramRunnable);
      AppMethodBeat.o(257727);
      return;
    }
    Log.w("MicroMsg.GalleryHandlerThread", "assistHandler is null.");
    AppMethodBeat.o(257727);
  }
  
  public final void ar(Runnable paramRunnable)
  {
    AppMethodBeat.i(173731);
    if (this.xiC != null) {
      this.xiC.execute(paramRunnable);
    }
    AppMethodBeat.o(173731);
  }
  
  public final void as(Runnable paramRunnable)
  {
    AppMethodBeat.i(173733);
    if (paramRunnable == null)
    {
      Log.e("MicroMsg.GalleryHandlerThread", "postToQuerySubWorker runnable is null");
      AppMethodBeat.o(173733);
      return;
    }
    MMHandler localMMHandler = dRe();
    if (localMMHandler != null)
    {
      localMMHandler.post(paramRunnable);
      AppMethodBeat.o(173733);
      return;
    }
    Log.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
    AppMethodBeat.o(173733);
  }
  
  final MMHandler dRc()
  {
    AppMethodBeat.i(111301);
    if ((this.xiB == null) && (this.xiz != null)) {
      this.xiB = new MMHandler(this.xiz.getLooper());
    }
    MMHandler localMMHandler = this.xiB;
    AppMethodBeat.o(111301);
    return localMMHandler;
  }
  
  public final MMHandler dRd()
  {
    AppMethodBeat.i(111302);
    if (this.hAk == null) {
      this.hAk = new MMHandler(Looper.getMainLooper());
    }
    MMHandler localMMHandler = this.hAk;
    AppMethodBeat.o(111302);
    return localMMHandler;
  }
  
  final MMHandler dRe()
  {
    AppMethodBeat.i(173732);
    if ((this.xiG == null) && (this.xiF != null)) {
      this.xiG = new MMHandler(this.xiF.getLooper());
    }
    MMHandler localMMHandler = this.xiG;
    AppMethodBeat.o(173732);
    return localMMHandler;
  }
  
  public final MMHandler dRf()
  {
    AppMethodBeat.i(111300);
    if ((this.xiA == null) && (this.xiy != null)) {
      this.xiA = new MMHandler(this.xiy.getLooper());
    }
    MMHandler localMMHandler = this.xiA;
    AppMethodBeat.o(111300);
    return localMMHandler;
  }
  
  public final void postToMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(111306);
    if (paramRunnable == null)
    {
      Log.e("MicroMsg.GalleryHandlerThread", "postToMainThread, runnable is null");
      AppMethodBeat.o(111306);
      return;
    }
    dRd().post(paramRunnable);
    AppMethodBeat.o(111306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.g
 * JD-Core Version:    0.7.0.1
 */