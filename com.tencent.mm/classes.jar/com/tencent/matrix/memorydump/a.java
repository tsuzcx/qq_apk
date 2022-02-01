package com.tencent.matrix.memorydump;

import android.os.Debug;
import android.os.Process;
import com.tencent.matrix.e.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/matrix/memorydump/MemoryDumpManager;", "", "()V", "DEFAULT_DUMP_TIMEOUT", "", "dumpExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "initialized", "", "dumpAsync", "Ljava/util/concurrent/Future;", "path", "", "", "callback", "Lcom/tencent/matrix/memorydump/MemoryDumpManager$DumpCallback;", "dumpBlock", "timeout", "dumpStream", "Lcom/tencent/matrix/memorydump/DumpHandler;", "bufferSize", "", "dumpSuspend", "DumpCallback", "matrix-memory-dump_release"}, k=1, mv={1, 1, 16})
public final class a
{
  private static final ExecutorService eWI = Executors.newSingleThreadExecutor((ThreadFactory)a.c.eWM);
  public static final a eWJ = new a();
  private static final boolean initialized = MemoryDumpKt.ayI();
  
  public static final void a(final String paramString, a parama)
  {
    s.t(paramString, "path");
    s.t(parama, "callback");
    if (!initialized)
    {
      c.e("Matrix.MemoryDump", "Memory dump manager is not successfully initialized. Skip dump.", new Object[0]);
      parama.dC(false);
    }
    eWI.execute((Runnable)new b(parama, paramString));
  }
  
  private static boolean gN(String paramString)
  {
    s.t(paramString, "path");
    if (!initialized)
    {
      c.e("Matrix.MemoryDump", "Memory dump manager is not successfully initialized. Skip dump.", new Object[0]);
      return false;
    }
    try
    {
      Debug.dumpHprofData(paramString);
      bool = true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        c.printErrStackTrace("Matrix.MemoryDump", (Throwable)paramString, "", new Object[0]);
        boolean bool = false;
      }
    }
    return bool;
  }
  
  private static boolean gO(String paramString)
  {
    s.t(paramString, "path");
    if (!initialized)
    {
      c.e("Matrix.MemoryDump", "Memory dump manager is not successfully initialized. Skip dump.", new Object[0]);
      return false;
    }
    c.i("Matrix.MemoryDump", "[dump block, pid: " + Process.myPid() + "] Fork dump process.", new Object[0]);
    int i = MemoryDumpKt.dK(60L);
    if (i == -1)
    {
      c.e("Matrix.MemoryDump", "Cannot fork child dump process.", new Object[0]);
      return false;
    }
    if (i == 0)
    {
      try
      {
        if (gN(paramString)) {
          MemoryDumpKt.nk(0);
        } else {
          MemoryDumpKt.nk(-1);
        }
      }
      catch (Exception paramString)
      {
        c.printErrStackTrace("Matrix.MemoryDump", (Throwable)paramString, "", new Object[0]);
        MemoryDumpKt.nk(-2);
      }
    }
    else
    {
      c.i("Matrix.MemoryDump", "[dump block, pid: " + Process.myPid() + "] Wait dump complete (dump process pid: " + i + ").", new Object[0]);
      i = MemoryDumpKt.nl(i);
      c.i("Matrix.MemoryDump", "[dump block, pid: " + Process.myPid() + "] Dump complete, status code: " + i + '.', new Object[0]);
      return i == 0;
    }
    return true;
  }
  
  public static final boolean gQ(String paramString)
  {
    return gO(paramString);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/matrix/memorydump/MemoryDumpManager$DumpCallback;", "", "onDumpComplete", "", "result", "", "matrix-memory-dump_release"}, k=1, mv={1, 1, 16})
  public static abstract interface a
  {
    public abstract void dC(boolean paramBoolean);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
  static final class b
    implements Runnable
  {
    b(a.a parama, String paramString) {}
    
    public final void run()
    {
      this.eWK.dC(a.gP(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.memorydump.a
 * JD-Core Version:    0.7.0.1
 */