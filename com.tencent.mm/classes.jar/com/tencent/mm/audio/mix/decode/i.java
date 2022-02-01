package com.tencent.mm.audio.mix.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class i
{
  private static i fou;
  private ThreadPoolExecutor fov;
  private PriorityBlockingQueue<Runnable> fow;
  private LinkedList<j> fox;
  private int foy;
  private Object lock;
  
  private i()
  {
    AppMethodBeat.i(136825);
    this.lock = new Object();
    this.fow = new PriorityBlockingQueue(33);
    this.fox = new LinkedList();
    int j = Runtime.getRuntime().availableProcessors();
    b.i("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", new Object[] { Integer.valueOf(j) });
    j = j * 2 + 2;
    if (j > 32) {
      i = 32;
    }
    for (;;)
    {
      this.foy = i;
      this.fov = new ThreadPoolExecutor(i, 32, 120L, TimeUnit.SECONDS, this.fow, new h());
      this.fov.setMaximumPoolSize(32);
      b.i("MicroMsg.Mix.AudioThreadPool", "new AudioThreadPool poolSize:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(136825);
      return;
      if (j >= 8) {
        i = j;
      }
    }
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(136827);
    i locali = adY();
    synchronized (locali.lock)
    {
      paramj.reset();
      locali.fox.add(paramj);
      int i = locali.foy;
      if (locali.fox.size() > i) {
        locali.kw(i + 2);
      }
      locali.fov.execute(paramj);
      AppMethodBeat.o(136827);
      return;
    }
  }
  
  public static i adY()
  {
    AppMethodBeat.i(136824);
    if (fou == null) {}
    try
    {
      if (fou == null) {
        fou = new i();
      }
      i locali = fou;
      AppMethodBeat.o(136824);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(136824);
    }
  }
  
  public static void b(j paramj)
  {
    AppMethodBeat.i(136828);
    i locali = adY();
    synchronized (locali.lock)
    {
      locali.fox.remove(paramj);
      if (locali.fox.size() <= 4)
      {
        locali.foy = 4;
        locali.kw(locali.foy);
      }
      locali.fov.remove(paramj);
      AppMethodBeat.o(136828);
      return;
    }
  }
  
  private void kw(int paramInt)
  {
    AppMethodBeat.i(136826);
    if (paramInt > 32) {
      this.foy = 32;
    }
    for (;;)
    {
      b.i("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", new Object[] { Integer.valueOf(paramInt) });
      this.fov.setCorePoolSize(paramInt);
      AppMethodBeat.o(136826);
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
 * Qualified Name:     com.tencent.mm.audio.mix.decode.i
 * JD-Core Version:    0.7.0.1
 */