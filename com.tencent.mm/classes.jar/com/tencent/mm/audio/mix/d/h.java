package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class h
{
  private static h cfX;
  private ThreadPoolExecutor cfY;
  private PriorityBlockingQueue<Runnable> cfZ;
  private LinkedList<i> cga;
  private int cgb;
  private Object lock;
  
  private h()
  {
    AppMethodBeat.i(137077);
    this.lock = new Object();
    this.cfZ = new PriorityBlockingQueue(33);
    this.cga = new LinkedList();
    int j = Runtime.getRuntime().availableProcessors();
    b.i("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", new Object[] { Integer.valueOf(j) });
    j = j * 2 + 2;
    if (j > 32) {
      i = 32;
    }
    for (;;)
    {
      this.cgb = i;
      this.cfY = new ThreadPoolExecutor(i, 32, 120L, TimeUnit.SECONDS, this.cfZ, new g());
      this.cfY.setMaximumPoolSize(32);
      b.i("MicroMsg.Mix.AudioThreadPool", "new AudioThreadPool poolSize:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(137077);
      return;
      if (j >= 8) {
        i = j;
      }
    }
  }
  
  public static h DI()
  {
    AppMethodBeat.i(137076);
    if (cfX == null) {}
    try
    {
      if (cfX == null) {
        cfX = new h();
      }
      h localh = cfX;
      AppMethodBeat.o(137076);
      return localh;
    }
    finally
    {
      AppMethodBeat.o(137076);
    }
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(137079);
    h localh = DI();
    synchronized (localh.lock)
    {
      parami.reset();
      localh.cga.add(parami);
      int i = localh.cgb;
      if (localh.cga.size() > i) {
        localh.setCorePoolSize(i + 2);
      }
      localh.cfY.execute(parami);
      AppMethodBeat.o(137079);
      return;
    }
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(137080);
    h localh = DI();
    synchronized (localh.lock)
    {
      localh.cga.remove(parami);
      if (localh.cga.size() <= 4)
      {
        localh.cgb = 4;
        localh.setCorePoolSize(localh.cgb);
      }
      localh.cfY.remove(parami);
      AppMethodBeat.o(137080);
      return;
    }
  }
  
  private void setCorePoolSize(int paramInt)
  {
    AppMethodBeat.i(137078);
    if (paramInt > 32) {
      this.cgb = 32;
    }
    for (;;)
    {
      b.i("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", new Object[] { Integer.valueOf(paramInt) });
      this.cfY.setCorePoolSize(paramInt);
      AppMethodBeat.o(137078);
      return;
      if (paramInt < 4) {
        this.cgb = 4;
      } else {
        this.cgb = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.h
 * JD-Core Version:    0.7.0.1
 */