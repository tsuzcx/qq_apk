package android.arch.a.a;

import java.util.concurrent.Executor;

public class a
  extends c
{
  private static volatile a bJ;
  private static final Executor bM = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      a.P().f(paramAnonymousRunnable);
    }
  };
  private static final Executor bN = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      a.P().e(paramAnonymousRunnable);
    }
  };
  public c bK = this.bL;
  private c bL = new b();
  
  public static a P()
  {
    if (bJ != null) {
      return bJ;
    }
    try
    {
      if (bJ == null) {
        bJ = new a();
      }
      return bJ;
    }
    finally {}
  }
  
  public static Executor Q()
  {
    return bN;
  }
  
  public final void e(Runnable paramRunnable)
  {
    this.bK.e(paramRunnable);
  }
  
  public final void f(Runnable paramRunnable)
  {
    this.bK.f(paramRunnable);
  }
  
  public final boolean isMainThread()
  {
    return this.bK.isMainThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.a.a.a
 * JD-Core Version:    0.7.0.1
 */