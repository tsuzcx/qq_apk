package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class h
{
  private static h deJ;
  private ThreadPoolExecutor deK;
  private PriorityBlockingQueue<Runnable> deL;
  private LinkedList<i> deM;
  private int deN;
  private Object lock;
  
  private h()
  {
    AppMethodBeat.i(136825);
    this.lock = new Object();
    this.deL = new PriorityBlockingQueue(33);
    this.deM = new LinkedList();
    int j = Runtime.getRuntime().availableProcessors();
    b.i("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", new Object[] { Integer.valueOf(j) });
    j = j * 2 + 2;
    if (j > 32) {
      i = 32;
    }
    for (;;)
    {
      this.deN = i;
      this.deK = new ThreadPoolExecutor(i, 32, 120L, TimeUnit.SECONDS, this.deL, new g());
      this.deK.setMaximumPoolSize(32);
      b.i("MicroMsg.Mix.AudioThreadPool", "new AudioThreadPool poolSize:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(136825);
      return;
      if (j >= 8) {
        i = j;
      }
    }
  }
  
  public static h OW()
  {
    AppMethodBeat.i(136824);
    if (deJ == null) {}
    try
    {
      if (deJ == null) {
        deJ = new h();
      }
      h localh = deJ;
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
    h localh = OW();
    synchronized (localh.lock)
    {
      parami.reset();
      localh.deM.add(parami);
      int i = localh.deN;
      if (localh.deM.size() > i) {
        localh.setCorePoolSize(i + 2);
      }
      localh.deK.execute(parami);
      AppMethodBeat.o(136827);
      return;
    }
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(136828);
    h localh = OW();
    synchronized (localh.lock)
    {
      localh.deM.remove(parami);
      if (localh.deM.size() <= 4)
      {
        localh.deN = 4;
        localh.setCorePoolSize(localh.deN);
      }
      localh.deK.remove(parami);
      AppMethodBeat.o(136828);
      return;
    }
  }
  
  private void setCorePoolSize(int paramInt)
  {
    AppMethodBeat.i(136826);
    if (paramInt > 32) {
      this.deN = 32;
    }
    for (;;)
    {
      b.i("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", new Object[] { Integer.valueOf(paramInt) });
      this.deK.setCorePoolSize(paramInt);
      AppMethodBeat.o(136826);
      return;
      if (paramInt < 4) {
        this.deN = 4;
      } else {
        this.deN = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.h
 * JD-Core Version:    0.7.0.1
 */