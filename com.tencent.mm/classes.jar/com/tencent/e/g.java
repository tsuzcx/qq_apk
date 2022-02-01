package com.tencent.e;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.e.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class g
{
  private static Executor ZvF;
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(183142);
    parama.a(new c()
    {
      public final void a(d.a paramAnonymousa)
      {
        d.Zvw = paramAnonymousa;
      }
      
      public final void a(d.e paramAnonymouse)
      {
        d.Zvu = paramAnonymouse;
      }
      
      public final void a(d.f paramAnonymousf)
      {
        d.Zvv = paramAnonymousf;
      }
    });
    a locala = parama.a(new a.a());
    b.Zwh = new com.tencent.e.b.a(paramContext, locala);
    com.tencent.e.g.h.ZwG = com.tencent.e.g.h.b(locala);
    h.a(locala);
    if (locala.Zva) {
      ipF();
    }
    parama.aqU();
    AppMethodBeat.o(183142);
  }
  
  private static void ipF()
  {
    AppMethodBeat.i(183144);
    try
    {
      ZvF = (Executor)com.tencent.e.l.c.k(AsyncTask.class, "THREAD_POOL_EXECUTOR");
      com.tencent.e.l.c.d(AsyncTask.class, "THREAD_POOL_EXECUTOR", new g.2());
      AppMethodBeat.o(183144);
      return;
    }
    catch (Exception localException)
    {
      d.Zvw.e("ThreadModuleBoot", localException.toString(), new Object[0]);
      AppMethodBeat.o(183144);
    }
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(183143);
    h.ZvG.ipG();
    b.Zwh.Xq();
    if (h.ZvG.ipH().Zva) {}
    try
    {
      com.tencent.e.l.c.d(AsyncTask.class, "THREAD_POOL_EXECUTOR", ZvF);
      ZvF = null;
      AppMethodBeat.o(183143);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d.Zvw.e("ThreadModuleBoot", localException.toString(), new Object[0]);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract a a(a.a parama);
    
    public abstract void a(g.c paramc);
    
    public abstract void aqU();
  }
  
  public static abstract interface b
  {
    public abstract void a(Thread paramThread, String paramString);
    
    public abstract boolean fop();
    
    public abstract boolean foq();
  }
  
  public static abstract interface c
  {
    public abstract void a(d.a parama);
    
    public abstract void a(d.e parame);
    
    public abstract void a(d.f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.g
 * JD-Core Version:    0.7.0.1
 */