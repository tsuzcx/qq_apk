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
  private static d foI;
  private ThreadPoolExecutor fov;
  private PriorityBlockingQueue<Runnable> fow;
  private LinkedList<j> fox;
  private int foy;
  private Object lock;
  
  private d()
  {
    AppMethodBeat.i(256943);
    this.lock = new Object();
    this.fow = new PriorityBlockingQueue(9);
    this.fox = new LinkedList();
    int j = Runtime.getRuntime().availableProcessors();
    b.i("MicroMsg.Mix.AudioDownloadThreadPool", "getNormalCorePoolSize cpuCount:%d", new Object[] { Integer.valueOf(j) });
    j = j * 2 + 2;
    if (j > 8) {
      i = 8;
    }
    for (;;)
    {
      this.foy = i;
      this.fov = new ThreadPoolExecutor(i, 8, 120L, TimeUnit.SECONDS, this.fow, new h("AUDIO_DOWNLOAD_THREAD_POOL_GROUP", "audio_download_thread#"));
      this.fov.setMaximumPoolSize(8);
      b.i("MicroMsg.Mix.AudioDownloadThreadPool", "new AudioThreadPool poolSize:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(256943);
      return;
      if (j >= 4) {
        i = j;
      }
    }
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(256945);
    d locald = adZ();
    synchronized (locald.lock)
    {
      paramj.reset();
      locald.fox.add(paramj);
      int i = locald.foy;
      if (locald.fox.size() > i) {
        locald.kw(i + 2);
      }
      locald.fov.execute(paramj);
      AppMethodBeat.o(256945);
      return;
    }
  }
  
  private static d adZ()
  {
    AppMethodBeat.i(256942);
    if (foI == null) {}
    try
    {
      if (foI == null) {
        foI = new d();
      }
      d locald = foI;
      AppMethodBeat.o(256942);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(256942);
    }
  }
  
  public static void b(j paramj)
  {
    AppMethodBeat.i(256946);
    d locald = adZ();
    synchronized (locald.lock)
    {
      locald.fox.remove(paramj);
      if (locald.fox.size() <= 4)
      {
        locald.foy = 4;
        locald.kw(locald.foy);
      }
      locald.fov.remove(paramj);
      AppMethodBeat.o(256946);
      return;
    }
  }
  
  private void kw(int paramInt)
  {
    AppMethodBeat.i(256944);
    if (paramInt > 8) {
      this.foy = 8;
    }
    for (;;)
    {
      b.i("MicroMsg.Mix.AudioDownloadThreadPool", "setCorePoolSize poolSize:%d", new Object[] { Integer.valueOf(paramInt) });
      this.fov.setCorePoolSize(paramInt);
      AppMethodBeat.o(256944);
      return;
      if (paramInt < 4) {
        this.foy = 4;
      } else {
        this.foy = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.d
 * JD-Core Version:    0.7.0.1
 */