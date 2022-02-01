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
      a.S().postToMainThread(paramAnonymousRunnable);
    }
  };
  private static final Executor bN = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      a.S().e(paramAnonymousRunnable);
    }
  };
  public c bK = this.bL;
  private c bL = new b();
  
  public static a S()
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
  
  public static Executor T()
  {
    return bM;
  }
  
  public static Executor U()
  {
    return bN;
  }
  
  public final void e(Runnable paramRunnable)
  {
    this.bK.e(paramRunnable);
  }
  
  public final boolean isMainThread()
  {
    return this.bK.isMainThread();
  }
  
  public final void postToMainThread(Runnable paramRunnable)
  {
    this.bK.postToMainThread(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.a.a.a
 * JD-Core Version:    0.7.0.1
 */