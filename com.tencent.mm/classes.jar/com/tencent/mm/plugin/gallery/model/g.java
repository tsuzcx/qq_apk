package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.threadpool.h;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class g
{
  static int HHl;
  HandlerThread HHh;
  HandlerThread HHi;
  MMHandler HHj;
  MMHandler HHk;
  ExecutorService HHm;
  ExecutorService HHn;
  ExecutorService HHo;
  HandlerThread HHp;
  MMHandler HHq;
  MMHandler mRi;
  
  g()
  {
    AppMethodBeat.i(111298);
    Log.d("MicroMsg.GalleryHandlerThread", "GalleryHandlerThread init.");
    this.HHh = new HandlerThread("smartGalleryQueryHandlerThread", 10);
    this.HHj = null;
    this.HHh.start();
    this.HHi = new HandlerThread("galleryAssistHandlerThread", 10);
    this.HHk = null;
    this.HHi.start();
    this.mRi = null;
    int j = Runtime.getRuntime().availableProcessors() / 2;
    if (j < 2) {}
    for (;;)
    {
      HHl = i;
      com.tencent.threadpool.i locali = h.ahAA;
      i = HHl;
      this.HHm = locali.a("gly-tp_q", i, i, new LinkedBlockingQueue());
      locali = h.ahAA;
      i = HHl;
      this.HHn = locali.a("gly-tp", i, i, new LinkedBlockingQueue());
      this.HHo = h.ahAA.a("gly-tp-p", HHl / 2, HHl / 2, new LinkedBlockingQueue());
      this.HHp = new HandlerThread("galleryQuerySubHandlerThread", 10);
      this.HHq = null;
      this.HHp.start();
      AppMethodBeat.o(111298);
      return;
      if (j > 4) {
        i = 4;
      } else {
        i = j;
      }
    }
  }
  
  public final void a(i<c.b> parami1, i<c.b> parami2)
  {
    AppMethodBeat.i(111308);
    if ((parami1 != null) && (parami2 != null) && (this.HHo != null)) {
      while ((e.fAm().fAe()) && (!parami1.isEmpty()))
      {
        final c.b localb = (c.b)parami1.fAN();
        if ((localb != null) && (!localb.mCancel))
        {
          parami2.add(localb);
          e.fAm().fAf();
          this.HHo.execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111297);
              final boolean bool = localb.doInBackground();
              g.this.fAG().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111296);
                  c.b localb = g.2.this.HHw;
                  boolean bool = bool;
                  localb.HGC.HGB.remove(localb);
                  c localc = localb.HGC;
                  localc.HGz += 1;
                  localb.HGC.fAg();
                  if (bool) {
                    localb.HGC.HGv.a(localb.mFilePath, localb.bitmap, localb.HGF, null, true, -1, localb.HGG);
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
  
  public final void a(i<String> parami, HashMap<String, c.c> paramHashMap)
  {
    AppMethodBeat.i(111307);
    if ((parami != null) && (paramHashMap != null) && (this.HHn != null)) {
      while ((e.fAm().fAc()) && (!parami.isEmpty()))
      {
        final String str = (String)parami.fAN();
        if (paramHashMap.containsKey(str))
        {
          final c.c localc = (c.c)paramHashMap.get(str);
          if ((localc != null) && (!localc.mCancel))
          {
            e.fAm().fAd();
            this.HHn.execute(new Runnable()
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
                g.this.fAG().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(111294);
                    c.c localc = g.1.this.HHr;
                    boolean bool = bool;
                    Log.d("MicroMsg.CacheService", "do on post execute, filePath[%s], mDecodeTaskKey[%s], success[%s], cancel[%s].", new Object[] { localc.mFilePath, localc.HGI, Boolean.valueOf(bool), Boolean.valueOf(localc.mCancel) });
                    if (!localc.mCancel) {
                      localc.HGC.HGy.remove(localc.HGI);
                    }
                    Log.d("MicroMsg.CacheService", "remove job from waitingDecodeTask, after size:[%d].", new Object[] { Integer.valueOf(localc.HGC.HGy.size()) });
                    c localc1 = localc.HGC;
                    localc1.HGw += 1;
                    localc.HGC.fAb();
                    if (bool)
                    {
                      localc.HGC.HGv.a(localc.mFilePath, localc.bitmap, localc.HGF, localc.HGH, localc.mCancel, localc.mPosition, localc.HGG);
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
  
  public final void aF(Runnable paramRunnable)
  {
    AppMethodBeat.i(289590);
    MMHandler localMMHandler = fAF();
    if (localMMHandler != null)
    {
      localMMHandler.post(paramRunnable);
      AppMethodBeat.o(289590);
      return;
    }
    Log.w("MicroMsg.GalleryHandlerThread", "assistHandler is null.");
    AppMethodBeat.o(289590);
  }
  
  public final void aG(Runnable paramRunnable)
  {
    AppMethodBeat.i(173731);
    if (this.HHm != null) {
      this.HHm.execute(paramRunnable);
    }
    AppMethodBeat.o(173731);
  }
  
  public final void aH(Runnable paramRunnable)
  {
    AppMethodBeat.i(173733);
    MMHandler localMMHandler = fAH();
    if (localMMHandler != null)
    {
      localMMHandler.post(paramRunnable);
      AppMethodBeat.o(173733);
      return;
    }
    Log.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
    AppMethodBeat.o(173733);
  }
  
  final MMHandler fAF()
  {
    AppMethodBeat.i(111301);
    if ((this.HHk == null) && (this.HHi != null)) {
      this.HHk = new MMHandler(this.HHi.getLooper());
    }
    MMHandler localMMHandler = this.HHk;
    AppMethodBeat.o(111301);
    return localMMHandler;
  }
  
  public final MMHandler fAG()
  {
    AppMethodBeat.i(111302);
    if (this.mRi == null) {
      this.mRi = new MMHandler(Looper.getMainLooper());
    }
    MMHandler localMMHandler = this.mRi;
    AppMethodBeat.o(111302);
    return localMMHandler;
  }
  
  final MMHandler fAH()
  {
    AppMethodBeat.i(173732);
    if ((this.HHq == null) && (this.HHp != null)) {
      this.HHq = new MMHandler(this.HHp.getLooper());
    }
    MMHandler localMMHandler = this.HHq;
    AppMethodBeat.o(173732);
    return localMMHandler;
  }
  
  public final MMHandler fAI()
  {
    AppMethodBeat.i(111300);
    if ((this.HHj == null) && (this.HHh != null)) {
      this.HHj = new MMHandler(this.HHh.getLooper());
    }
    MMHandler localMMHandler = this.HHj;
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
    fAG().post(paramRunnable);
    AppMethodBeat.o(111306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.g
 * JD-Core Version:    0.7.0.1
 */