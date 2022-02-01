package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.decode.h;
import com.tencent.mm.audio.mix.decode.j;
import com.tencent.mm.audio.mix.h.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class d
{
  private static d hsS;
  private ThreadPoolExecutor hsF;
  private PriorityBlockingQueue<Runnable> hsG;
  private LinkedList<j> hsH;
  private int hsI;
  private Object lock;
  
  private d()
  {
    AppMethodBeat.i(236210);
    this.lock = new Object();
    this.hsG = new PriorityBlockingQueue(9);
    this.hsH = new LinkedList();
    int j = Runtime.getRuntime().availableProcessors();
    b.i("MicroMsg.Mix.AudioDownloadThreadPool", "getNormalCorePoolSize cpuCount:%d", new Object[] { Integer.valueOf(j) });
    j = j * 2 + 2;
    if (j > 8) {
      i = 8;
    }
    for (;;)
    {
      this.hsI = i;
      this.hsF = new ThreadPoolExecutor(i, 8, 120L, TimeUnit.SECONDS, this.hsG, new h("AUDIO_DOWNLOAD_THREAD_POOL_GROUP", "audio_download_thread#"));
      this.hsF.setMaximumPoolSize(8);
      b.i("MicroMsg.Mix.AudioDownloadThreadPool", "new AudioThreadPool poolSize:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(236210);
      return;
      if (j >= 4) {
        i = j;
      }
    }
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(236214);
    d locald = aFX();
    synchronized (locald.lock)
    {
      paramj.reset();
      locald.hsH.add(paramj);
      int i = locald.hsI;
      if (locald.hsH.size() > i) {
        locald.od(i + 2);
      }
      locald.hsF.execute(paramj);
      AppMethodBeat.o(236214);
      return;
    }
  }
  
  private static d aFX()
  {
    AppMethodBeat.i(236203);
    if (hsS == null) {}
    try
    {
      if (hsS == null) {
        hsS = new d();
      }
      d locald = hsS;
      AppMethodBeat.o(236203);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(236203);
    }
  }
  
  public static void b(j paramj)
  {
    AppMethodBeat.i(236218);
    d locald = aFX();
    synchronized (locald.lock)
    {
      locald.hsH.remove(paramj);
      if (locald.hsH.size() <= 4)
      {
        locald.hsI = 4;
        locald.od(locald.hsI);
      }
      locald.hsF.remove(paramj);
      AppMethodBeat.o(236218);
      return;
    }
  }
  
  private void od(int paramInt)
  {
    AppMethodBeat.i(236212);
    if (paramInt > 8) {
      this.hsI = 8;
    }
    for (;;)
    {
      b.i("MicroMsg.Mix.AudioDownloadThreadPool", "setCorePoolSize poolSize:%d", new Object[] { Integer.valueOf(paramInt) });
      this.hsF.setCorePoolSize(paramInt);
      AppMethodBeat.o(236212);
      return;
      if (paramInt < 4) {
        this.hsI = 4;
      } else {
        this.hsI = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.d
 * JD-Core Version:    0.7.0.1
 */