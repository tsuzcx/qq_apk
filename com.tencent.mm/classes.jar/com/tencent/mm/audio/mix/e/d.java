package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.h;
import com.tencent.mm.audio.mix.d.j;
import com.tencent.mm.audio.mix.i.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class d
{
  private static d dvZ;
  private ThreadPoolExecutor dvM;
  private PriorityBlockingQueue<Runnable> dvN;
  private LinkedList<j> dvO;
  private int dvP;
  private Object lock;
  
  private d()
  {
    AppMethodBeat.i(198121);
    this.lock = new Object();
    this.dvN = new PriorityBlockingQueue(9);
    this.dvO = new LinkedList();
    int j = Runtime.getRuntime().availableProcessors();
    b.i("MicroMsg.Mix.AudioDownloadThreadPool", "getNormalCorePoolSize cpuCount:%d", new Object[] { Integer.valueOf(j) });
    j = j * 2 + 2;
    if (j > 8) {
      i = 8;
    }
    for (;;)
    {
      this.dvP = i;
      this.dvM = new ThreadPoolExecutor(i, 8, 120L, TimeUnit.SECONDS, this.dvN, new h("AUDIO_DOWNLOAD_THREAD_POOL_GROUP", "audio_download_thread#"));
      this.dvM.setMaximumPoolSize(8);
      b.i("MicroMsg.Mix.AudioDownloadThreadPool", "new AudioThreadPool poolSize:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(198121);
      return;
      if (j >= 4) {
        i = j;
      }
    }
  }
  
  private static d Zq()
  {
    AppMethodBeat.i(198120);
    if (dvZ == null) {}
    try
    {
      if (dvZ == null) {
        dvZ = new d();
      }
      d locald = dvZ;
      AppMethodBeat.o(198120);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(198120);
    }
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(198123);
    d locald = Zq();
    synchronized (locald.lock)
    {
      paramj.reset();
      locald.dvO.add(paramj);
      int i = locald.dvP;
      if (locald.dvO.size() > i) {
        locald.setCorePoolSize(i + 2);
      }
      locald.dvM.execute(paramj);
      AppMethodBeat.o(198123);
      return;
    }
  }
  
  public static void b(j paramj)
  {
    AppMethodBeat.i(198124);
    d locald = Zq();
    synchronized (locald.lock)
    {
      locald.dvO.remove(paramj);
      if (locald.dvO.size() <= 4)
      {
        locald.dvP = 4;
        locald.setCorePoolSize(locald.dvP);
      }
      locald.dvM.remove(paramj);
      AppMethodBeat.o(198124);
      return;
    }
  }
  
  private void setCorePoolSize(int paramInt)
  {
    AppMethodBeat.i(198122);
    if (paramInt > 8) {
      this.dvP = 8;
    }
    for (;;)
    {
      b.i("MicroMsg.Mix.AudioDownloadThreadPool", "setCorePoolSize poolSize:%d", new Object[] { Integer.valueOf(paramInt) });
      this.dvM.setCorePoolSize(paramInt);
      AppMethodBeat.o(198122);
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
 * Qualified Name:     com.tencent.mm.audio.mix.e.d
 * JD-Core Version:    0.7.0.1
 */