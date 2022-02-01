package com.tencent.mm.audio.mix.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class i
{
  private static i hsE;
  private ThreadPoolExecutor hsF;
  private PriorityBlockingQueue<Runnable> hsG;
  private LinkedList<j> hsH;
  private int hsI;
  private Object lock;
  
  private i()
  {
    AppMethodBeat.i(136825);
    this.lock = new Object();
    this.hsG = new PriorityBlockingQueue(33);
    this.hsH = new LinkedList();
    int j = Runtime.getRuntime().availableProcessors();
    b.i("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", new Object[] { Integer.valueOf(j) });
    j = j * 2 + 2;
    if (j > 32) {
      i = 32;
    }
    for (;;)
    {
      this.hsI = i;
      this.hsF = new ThreadPoolExecutor(i, 32, 120L, TimeUnit.SECONDS, this.hsG, new h());
      this.hsF.setMaximumPoolSize(32);
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
    i locali = aFW();
    synchronized (locali.lock)
    {
      paramj.reset();
      locali.hsH.add(paramj);
      int i = locali.hsI;
      if (locali.hsH.size() > i) {
        locali.od(i + 2);
      }
      locali.hsF.execute(paramj);
      AppMethodBeat.o(136827);
      return;
    }
  }
  
  public static i aFW()
  {
    AppMethodBeat.i(136824);
    if (hsE == null) {}
    try
    {
      if (hsE == null) {
        hsE = new i();
      }
      i locali = hsE;
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
    i locali = aFW();
    synchronized (locali.lock)
    {
      locali.hsH.remove(paramj);
      if (locali.hsH.size() <= 4)
      {
        locali.hsI = 4;
        locali.od(locali.hsI);
      }
      locali.hsF.remove(paramj);
      AppMethodBeat.o(136828);
      return;
    }
  }
  
  private void od(int paramInt)
  {
    AppMethodBeat.i(136826);
    if (paramInt > 32) {
      this.hsI = 32;
    }
    for (;;)
    {
      b.i("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", new Object[] { Integer.valueOf(paramInt) });
      this.hsF.setCorePoolSize(paramInt);
      AppMethodBeat.o(136826);
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
 * Qualified Name:     com.tencent.mm.audio.mix.decode.i
 * JD-Core Version:    0.7.0.1
 */