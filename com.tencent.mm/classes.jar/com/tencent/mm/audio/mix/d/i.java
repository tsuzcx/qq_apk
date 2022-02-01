package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class i
{
  private static i dvL;
  private ThreadPoolExecutor dvM;
  private PriorityBlockingQueue<Runnable> dvN;
  private LinkedList<j> dvO;
  private int dvP;
  private Object lock;
  
  private i()
  {
    AppMethodBeat.i(136825);
    this.lock = new Object();
    this.dvN = new PriorityBlockingQueue(33);
    this.dvO = new LinkedList();
    int j = Runtime.getRuntime().availableProcessors();
    b.i("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", new Object[] { Integer.valueOf(j) });
    j = j * 2 + 2;
    if (j > 32) {
      i = 32;
    }
    for (;;)
    {
      this.dvP = i;
      this.dvM = new ThreadPoolExecutor(i, 32, 120L, TimeUnit.SECONDS, this.dvN, new h());
      this.dvM.setMaximumPoolSize(32);
      b.i("MicroMsg.Mix.AudioThreadPool", "new AudioThreadPool poolSize:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(136825);
      return;
      if (j >= 8) {
        i = j;
      }
    }
  }
  
  public static i Zp()
  {
    AppMethodBeat.i(136824);
    if (dvL == null) {}
    try
    {
      if (dvL == null) {
        dvL = new i();
      }
      i locali = dvL;
      AppMethodBeat.o(136824);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(136824);
    }
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(136827);
    i locali = Zp();
    synchronized (locali.lock)
    {
      paramj.reset();
      locali.dvO.add(paramj);
      int i = locali.dvP;
      if (locali.dvO.size() > i) {
        locali.setCorePoolSize(i + 2);
      }
      locali.dvM.execute(paramj);
      AppMethodBeat.o(136827);
      return;
    }
  }
  
  public static void b(j paramj)
  {
    AppMethodBeat.i(136828);
    i locali = Zp();
    synchronized (locali.lock)
    {
      locali.dvO.remove(paramj);
      if (locali.dvO.size() <= 4)
      {
        locali.dvP = 4;
        locali.setCorePoolSize(locali.dvP);
      }
      locali.dvM.remove(paramj);
      AppMethodBeat.o(136828);
      return;
    }
  }
  
  private void setCorePoolSize(int paramInt)
  {
    AppMethodBeat.i(136826);
    if (paramInt > 32) {
      this.dvP = 32;
    }
    for (;;)
    {
      b.i("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", new Object[] { Integer.valueOf(paramInt) });
      this.dvM.setCorePoolSize(paramInt);
      AppMethodBeat.o(136826);
      return;
      if (paramInt < 4) {
        this.dvP = 4;
      } else {
        this.dvP = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.i
 * JD-Core Version:    0.7.0.1
 */