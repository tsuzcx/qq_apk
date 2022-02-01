package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class g
{
  static int DEFAULT_CORE_POOL_SIZE;
  HandlerThread BUM;
  HandlerThread BUN;
  MMHandler BUO;
  MMHandler BUP;
  ExecutorService BUQ;
  ExecutorService BUR;
  ExecutorService BUS;
  HandlerThread BUT;
  MMHandler BUU;
  MMHandler knk;
  
  g()
  {
    AppMethodBeat.i(111298);
    Log.d("MicroMsg.GalleryHandlerThread", "GalleryHandlerThread init.");
    this.BUM = new HandlerThread("smartGalleryQueryHandlerThread", 10);
    this.BUO = null;
    this.BUM.start();
    this.BUN = new HandlerThread("galleryAssistHandlerThread", 10);
    this.BUP = null;
    this.BUN.start();
    this.knk = null;
    int j = Runtime.getRuntime().availableProcessors() / 2;
    if (j < 2) {}
    for (;;)
    {
      DEFAULT_CORE_POOL_SIZE = i;
      i locali = com.tencent.e.h.ZvG;
      i = DEFAULT_CORE_POOL_SIZE;
      this.BUQ = locali.a("gly-tp_q", i, i, new LinkedBlockingQueue());
      locali = com.tencent.e.h.ZvG;
      i = DEFAULT_CORE_POOL_SIZE;
      this.BUR = locali.a("gly-tp", i, i, new LinkedBlockingQueue());
      this.BUS = com.tencent.e.h.ZvG.a("gly-tp-p", DEFAULT_CORE_POOL_SIZE / 2, DEFAULT_CORE_POOL_SIZE / 2, new LinkedBlockingQueue());
      this.BUT = new HandlerThread("galleryQuerySubHandlerThread", 10);
      this.BUU = null;
      this.BUT.start();
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
    if ((paramh1 != null) && (paramh2 != null) && (this.BUS != null)) {
      while ((e.etk().etc()) && (!paramh1.isEmpty()))
      {
        final c.b localb = (c.b)paramh1.etN();
        if ((localb != null) && (!localb.mCancel))
        {
          paramh2.add(localb);
          e.etk().etd();
          this.BUS.execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111297);
              final boolean bool = localb.doInBackground();
              g.this.etE().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111296);
                  c.b localb = g.2.this.BVa;
                  boolean bool = bool;
                  localb.BUh.BUg.remove(localb);
                  c localc = localb.BUh;
                  localc.BUe += 1;
                  localb.BUh.ete();
                  if (bool) {
                    localb.BUh.BUa.a(localb.mFilePath, localb.bitmap, localb.BUk, null, true, -1, localb.BUl);
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
    if ((paramh != null) && (paramHashMap != null) && (this.BUR != null)) {
      while ((e.etk().eta()) && (!paramh.isEmpty()))
      {
        final String str = (String)paramh.etN();
        if (paramHashMap.containsKey(str))
        {
          final c.c localc = (c.c)paramHashMap.get(str);
          if ((localc != null) && (!localc.mCancel))
          {
            e.etk().etb();
            this.BUR.execute(new Runnable()
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
                g.this.etE().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(111294);
                    c.c localc = g.1.this.BUV;
                    boolean bool = bool;
                    Log.d("MicroMsg.CacheService", "do on post execute, filePath[%s], mDecodeTaskKey[%s], success[%s], cancel[%s].", new Object[] { localc.mFilePath, localc.BUn, Boolean.valueOf(bool), Boolean.valueOf(localc.mCancel) });
                    if (!localc.mCancel) {
                      localc.BUh.BUd.remove(localc.BUn);
                    }
                    Log.d("MicroMsg.CacheService", "remove job from waitingDecodeTask, after size:[%d].", new Object[] { Integer.valueOf(localc.BUh.BUd.size()) });
                    c localc1 = localc.BUh;
                    localc1.BUb += 1;
                    localc.BUh.esZ();
                    if (bool)
                    {
                      localc.BUh.BUa.a(localc.mFilePath, localc.bitmap, localc.BUk, localc.BUm, localc.mCancel, localc.mPosition, localc.BUl);
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
  
  public final void av(Runnable paramRunnable)
  {
    AppMethodBeat.i(241052);
    MMHandler localMMHandler = etD();
    if (localMMHandler != null)
    {
      localMMHandler.post(paramRunnable);
      AppMethodBeat.o(241052);
      return;
    }
    Log.w("MicroMsg.GalleryHandlerThread", "assistHandler is null.");
    AppMethodBeat.o(241052);
  }
  
  public final void aw(Runnable paramRunnable)
  {
    AppMethodBeat.i(173731);
    if (this.BUQ != null) {
      this.BUQ.execute(paramRunnable);
    }
    AppMethodBeat.o(173731);
  }
  
  public final void ax(Runnable paramRunnable)
  {
    AppMethodBeat.i(173733);
    MMHandler localMMHandler = etF();
    if (localMMHandler != null)
    {
      localMMHandler.post(paramRunnable);
      AppMethodBeat.o(173733);
      return;
    }
    Log.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
    AppMethodBeat.o(173733);
  }
  
  final MMHandler etD()
  {
    AppMethodBeat.i(111301);
    if ((this.BUP == null) && (this.BUN != null)) {
      this.BUP = new MMHandler(this.BUN.getLooper());
    }
    MMHandler localMMHandler = this.BUP;
    AppMethodBeat.o(111301);
    return localMMHandler;
  }
  
  public final MMHandler etE()
  {
    AppMethodBeat.i(111302);
    if (this.knk == null) {
      this.knk = new MMHandler(Looper.getMainLooper());
    }
    MMHandler localMMHandler = this.knk;
    AppMethodBeat.o(111302);
    return localMMHandler;
  }
  
  final MMHandler etF()
  {
    AppMethodBeat.i(173732);
    if ((this.BUU == null) && (this.BUT != null)) {
      this.BUU = new MMHandler(this.BUT.getLooper());
    }
    MMHandler localMMHandler = this.BUU;
    AppMethodBeat.o(173732);
    return localMMHandler;
  }
  
  public final MMHandler etG()
  {
    AppMethodBeat.i(111300);
    if ((this.BUO == null) && (this.BUM != null)) {
      this.BUO = new MMHandler(this.BUM.getLooper());
    }
    MMHandler localMMHandler = this.BUO;
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
    etE().post(paramRunnable);
    AppMethodBeat.o(111306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.g
 * JD-Core Version:    0.7.0.1
 */