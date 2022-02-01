package com.tencent.mm.gpu.h;

import android.os.Handler;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.gpu.e.a.1;
import com.tencent.mm.gpu.e.b;
import com.tencent.mm.gpu.e.b.1;
import com.tencent.mm.gpu.f.e;
import com.tencent.mm.gpu.g.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements Runnable
{
  private static a jVt;
  private volatile String fca;
  public boolean jVu;
  private long jVv;
  private final List<Object> mListeners;
  
  static
  {
    AppMethodBeat.i(211077);
    jVt = new a();
    AppMethodBeat.o(211077);
  }
  
  private a()
  {
    AppMethodBeat.i(211075);
    this.fca = "default";
    this.jVu = false;
    this.mListeners = new ArrayList();
    this.jVv = 0L;
    AppMethodBeat.o(211075);
  }
  
  public static a aEU()
  {
    return jVt;
  }
  
  public final void run()
  {
    AppMethodBeat.i(211076);
    if (PluginGpuRes.isSkipModel())
    {
      Log.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
      AppMethodBeat.o(211076);
      return;
    }
    Log.d("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
    if (System.currentTimeMillis() - this.jVv > 10000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.GpuMemoryWatchDog", "checkCanDump in run false.");
      AppMethodBeat.o(211076);
      return;
    }
    Log.d("MicroMsg.GpuMemoryWatchDog", "GpuResReportTask run.");
    this.jVv = System.currentTimeMillis();
    long l1 = this.jVv;
    ??? = new com.tencent.mm.gpu.g.a();
    long l2 = System.currentTimeMillis();
    Object localObject2 = MMApplicationContext.getProcessName();
    e locale = new e();
    locale.pid = Process.myPid();
    locale.processName = ((String)localObject2);
    locale.jVp = PluginGpuRes.getCurrSpend();
    locale.jVo = (l2 - l1);
    locale.jVn = ((com.tencent.mm.gpu.g.a)???).aEQ();
    locale.jVl = ((com.tencent.mm.gpu.g.a)???).aEP();
    locale.jVm = ((com.tencent.mm.gpu.g.a)???).aER();
    locale.activityName = this.fca;
    Log.e("MicroMsg.GpuMemoryWatchDog", locale.toString());
    Log.e("MicroMsg.GpuMemoryWatchDog.oomScore", c.aET());
    ??? = b.aEL();
    ((b)???).jVc.post(new b.1((b)???));
    ??? = com.tencent.mm.gpu.e.a.aEJ();
    ((com.tencent.mm.gpu.e.a)???).jVc.post(new a.1((com.tencent.mm.gpu.e.a)???));
    synchronized (this.mListeners)
    {
      if (this.mListeners.size() > 0)
      {
        localObject2 = this.mListeners.iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((Iterator)localObject2).next();
        }
      }
    }
    AppMethodBeat.o(211076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.gpu.h.a
 * JD-Core Version:    0.7.0.1
 */