package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class h
{
  private static h ddH;
  private ThreadPoolExecutor ddI;
  private PriorityBlockingQueue<Runnable> ddJ;
  private LinkedList<i> ddK;
  private int ddL;
  private Object lock;
  
  private h()
  {
    AppMethodBeat.i(136825);
    this.lock = new Object();
    this.ddJ = new PriorityBlockingQueue(33);
    this.ddK = new LinkedList();
    int j = Runtime.getRuntime().availableProcessors();
    b.i("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", new Object[] { Integer.valueOf(j) });
    j = j * 2 + 2;
    if (j > 32) {
      i = 32;
    }
    for (;;)
    {
      this.ddL = i;
      this.ddI = new ThreadPoolExecutor(i, 32, 120L, TimeUnit.SECONDS, this.ddJ, new g());
      this.ddI.setMaximumPoolSize(32);
      b.i("MicroMsg.Mix.AudioThreadPool", "new AudioThreadPool poolSize:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(136825);
      return;
      if (j >= 8) {
        i = j;
      }
    }
  }
  
  public static h OY()
  {
    AppMethodBeat.i(136824);
    if (ddH == null) {}
    try
    {
      if (ddH == null) {
        ddH = new h();
      }
      h localh = ddH;
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
    h localh = OY();
    synchronized (localh.lock)
    {
      parami.reset();
      localh.ddK.add(parami);
      int i = localh.ddL;
      if (localh.ddK.size() > i) {
        localh.setCorePoolSize(i + 2);
      }
      localh.ddI.execute(parami);
      AppMethodBeat.o(136827);
      return;
    }
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(136828);
    h localh = OY();
    synchronized (localh.lock)
    {
      localh.ddK.remove(parami);
      if (localh.ddK.size() <= 4)
      {
        localh.ddL = 4;
        localh.setCorePoolSize(localh.ddL);
      }
      localh.ddI.remove(parami);
      AppMethodBeat.o(136828);
      return;
    }
  }
  
  private void setCorePoolSize(int paramInt)
  {
    AppMethodBeat.i(136826);
    if (paramInt > 32) {
      this.ddL = 32;
    }
    for (;;)
    {
      b.i("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", new Object[] { Integer.valueOf(paramInt) });
      this.ddI.setCorePoolSize(paramInt);
      AppMethodBeat.o(136826);
      return;
      if (paramInt < 4) {
        this.ddL = 4;
      } else {
        this.ddL = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.h
 * JD-Core Version:    0.7.0.1
 */