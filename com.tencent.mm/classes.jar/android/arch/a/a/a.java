package android.arch.a.a;

import java.util.concurrent.Executor;

public class a
  extends c
{
  private static volatile a bC;
  private static final Executor bF = new a.1();
  private static final Executor bG = new a.2();
  public c bD = this.bE;
  private c bE = new b();
  
  public static a M()
  {
    if (bC != null) {
      return bC;
    }
    try
    {
      if (bC == null) {
        bC = new a();
      }
      return bC;
    }
    finally {}
  }
  
  public final void c(Runnable paramRunnable)
  {
    this.bD.c(paramRunnable);
  }
  
  public final void d(Runnable paramRunnable)
  {
    this.bD.d(paramRunnable);
  }
  
  public final boolean isMainThread()
  {
    return this.bD.isMainThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.arch.a.a.a
 * JD-Core Version:    0.7.0.1
 */