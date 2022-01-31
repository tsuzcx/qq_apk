package android.arch.a.a;

import java.util.concurrent.Executor;

public class a
  extends c
{
  private static volatile a bG;
  private static final Executor bJ = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      a.aa().d(paramAnonymousRunnable);
    }
  };
  private static final Executor bK = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      a.aa().c(paramAnonymousRunnable);
    }
  };
  public c bH = this.bI;
  private c bI = new b();
  
  public static a aa()
  {
    if (bG != null) {
      return bG;
    }
    try
    {
      if (bG == null) {
        bG = new a();
      }
      return bG;
    }
    finally {}
  }
  
  public static Executor ad()
  {
    return bK;
  }
  
  public final void c(Runnable paramRunnable)
  {
    this.bH.c(paramRunnable);
  }
  
  public final void d(Runnable paramRunnable)
  {
    this.bH.d(paramRunnable);
  }
  
  public final boolean isMainThread()
  {
    return this.bH.isMainThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.arch.a.a.a
 * JD-Core Version:    0.7.0.1
 */