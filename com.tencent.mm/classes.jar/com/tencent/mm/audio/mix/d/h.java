package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class h
{
  private static h cUV;
  private ThreadPoolExecutor cUW;
  private PriorityBlockingQueue<Runnable> cUX;
  private LinkedList<i> cUY;
  private int cUZ;
  private Object lock;
  
  private h()
  {
    AppMethodBeat.i(136825);
    this.lock = new Object();
    this.cUX = new PriorityBlockingQueue(33);
    this.cUY = new LinkedList();
    int j = Runtime.getRuntime().availableProcessors();
    b.i("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", new Object[] { Integer.valueOf(j) });
    j = j * 2 + 2;
    if (j > 32) {
      i = 32;
    }
    for (;;)
    {
      this.cUZ = i;
      this.cUW = new ThreadPoolExecutor(i, 32, 120L, TimeUnit.SECONDS, this.cUX, new g());
      this.cUW.setMaximumPoolSize(32);
      b.i("MicroMsg.Mix.AudioThreadPool", "new AudioThreadPool poolSize:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(136825);
      return;
      if (j >= 8) {
        i = j;
      }
    }
  }
  
  public static h Nr()
  {
    AppMethodBeat.i(136824);
    if (cUV == null) {}
    try
    {
      if (cUV == null) {
        cUV = new h();
      }
      h localh = cUV;
      AppMethodBeat.o(136824);
      return localh;
    }
    finally
    {
      AppMethodBeat.o(136824);
    }
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(136827);
    h localh = Nr();
    synchronized (localh.lock)
    {
      parami.reset();
      localh.cUY.add(parami);
      int i = localh.cUZ;
      if (localh.cUY.size() > i) {
        localh.setCorePoolSize(i + 2);
      }
      localh.cUW.execute(parami);
      AppMethodBeat.o(136827);
      return;
    }
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(136828);
    h localh = Nr();
    synchronized (localh.lock)
    {
      localh.cUY.remove(parami);
      if (localh.cUY.size() <= 4)
      {
        localh.cUZ = 4;
        localh.setCorePoolSize(localh.cUZ);
      }
      localh.cUW.remove(parami);
      AppMethodBeat.o(136828);
      return;
    }
  }
  
  private void setCorePoolSize(int paramInt)
  {
    AppMethodBeat.i(136826);
    if (paramInt > 32) {
      this.cUZ = 32;
    }
    for (;;)
    {
      b.i("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", new Object[] { Integer.valueOf(paramInt) });
      this.cUW.setCorePoolSize(paramInt);
      AppMethodBeat.o(136826);
      return;
      if (paramInt < 4) {
        this.cUZ = 4;
      } else {
        this.cUZ = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.h
 * JD-Core Version:    0.7.0.1
 */