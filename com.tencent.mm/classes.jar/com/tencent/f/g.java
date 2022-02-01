package com.tencent.f;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.f.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class g
{
  private static Executor RTb;
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(183142);
    parama.a(new c()
    {
      public final void a(d.a paramAnonymousa)
      {
        d.RSS = paramAnonymousa;
      }
      
      public final void a(d.e paramAnonymouse)
      {
        d.RSQ = paramAnonymouse;
      }
      
      public final void a(d.f paramAnonymousf)
      {
        d.RSR = paramAnonymousf;
      }
    });
    parama = parama.a(new a.a());
    b.RTE = new com.tencent.f.b.a(paramContext, parama);
    com.tencent.f.g.h.RUe = com.tencent.f.g.h.b(parama);
    h.a(parama);
    if (parama.RSw) {
      hmf();
    }
    AppMethodBeat.o(183142);
  }
  
  private static void hmf()
  {
    AppMethodBeat.i(183144);
    try
    {
      RTb = (Executor)com.tencent.f.k.c.l(AsyncTask.class, "THREAD_POOL_EXECUTOR");
      com.tencent.f.k.c.d(AsyncTask.class, "THREAD_POOL_EXECUTOR", new Executor()
      {
        public final void execute(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(183141);
          h.RTc.aX(paramAnonymousRunnable);
          AppMethodBeat.o(183141);
        }
      });
      AppMethodBeat.o(183144);
      return;
    }
    catch (Exception localException)
    {
      d.RSS.e("ThreadModuleBoot", localException.toString(), new Object[0]);
      AppMethodBeat.o(183144);
    }
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(183143);
    h.RTc.hmg();
    b.RTE.onShutdown();
    if (h.RTc.hmh().RSw) {}
    try
    {
      com.tencent.f.k.c.d(AsyncTask.class, "THREAD_POOL_EXECUTOR", RTb);
      RTb = null;
      AppMethodBeat.o(183143);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d.RSS.e("ThreadModuleBoot", localException.toString(), new Object[0]);
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
    
    public abstract boolean eCC();
    
    public abstract boolean eCD();
  }
  
  public static abstract interface c
  {
    public abstract void a(d.a parama);
    
    public abstract void a(d.e parame);
    
    public abstract void a(d.f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.g
 * JD-Core Version:    0.7.0.1
 */