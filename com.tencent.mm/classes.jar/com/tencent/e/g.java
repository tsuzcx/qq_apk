package com.tencent.e;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.e.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class g
{
  private static Executor MqE;
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(183142);
    parama.a(new c()
    {
      public final void a(d.a paramAnonymousa)
      {
        d.Mqv = paramAnonymousa;
      }
      
      public final void a(d.e paramAnonymouse)
      {
        d.Mqt = paramAnonymouse;
      }
      
      public final void a(d.f paramAnonymousf)
      {
        d.Mqu = paramAnonymousf;
      }
    });
    parama = parama.a(new a.a());
    b.Mrh = new com.tencent.e.b.a(paramContext, parama);
    com.tencent.e.g.h.MrI = com.tencent.e.g.h.b(parama);
    h.a(parama);
    if (parama.MpZ) {
      fZU();
    }
    AppMethodBeat.o(183142);
  }
  
  private static void fZU()
  {
    AppMethodBeat.i(183144);
    try
    {
      MqE = (Executor)com.tencent.e.k.c.f(AsyncTask.class, "THREAD_POOL_EXECUTOR");
      com.tencent.e.k.c.c(AsyncTask.class, "THREAD_POOL_EXECUTOR", new Executor()
      {
        public final void execute(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(183141);
          h.MqF.aO(paramAnonymousRunnable);
          AppMethodBeat.o(183141);
        }
      });
      AppMethodBeat.o(183144);
      return;
    }
    catch (Exception localException)
    {
      d.Mqv.e("ThreadModuleBoot", localException.toString(), new Object[0]);
      AppMethodBeat.o(183144);
    }
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(183143);
    h.MqF.fZV();
    b.Mrh.onShutdown();
    if (h.MqF.fZW().MpZ) {}
    try
    {
      com.tencent.e.k.c.c(AsyncTask.class, "THREAD_POOL_EXECUTOR", MqE);
      MqE = null;
      AppMethodBeat.o(183143);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d.Mqv.e("ThreadModuleBoot", localException.toString(), new Object[0]);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract a a(a.a parama);
    
    public abstract void a(g.c paramc);
  }
  
  public static abstract interface b
  {
    public abstract void a(Thread paramThread, String paramString);
    
    public abstract boolean dCm();
    
    public abstract boolean dCn();
  }
  
  public static abstract interface c
  {
    public abstract void a(d.a parama);
    
    public abstract void a(d.e parame);
    
    public abstract void a(d.f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.g
 * JD-Core Version:    0.7.0.1
 */