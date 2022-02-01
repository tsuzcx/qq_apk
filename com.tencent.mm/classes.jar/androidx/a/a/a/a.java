package androidx.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class a
  extends c
{
  private static volatile a xV;
  private static final Executor xY;
  private static final Executor xZ;
  public c xW;
  private c xX;
  
  static
  {
    AppMethodBeat.i(212369);
    xY = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(212343);
        a.eJ().postToMainThread(paramAnonymousRunnable);
        AppMethodBeat.o(212343);
      }
    };
    xZ = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(212348);
        a.eJ().f(paramAnonymousRunnable);
        AppMethodBeat.o(212348);
      }
    };
    AppMethodBeat.o(212369);
  }
  
  private a()
  {
    AppMethodBeat.i(212353);
    this.xX = new b();
    this.xW = this.xX;
    AppMethodBeat.o(212353);
  }
  
  public static a eJ()
  {
    AppMethodBeat.i(212355);
    a locala;
    if (xV != null)
    {
      locala = xV;
      AppMethodBeat.o(212355);
      return locala;
    }
    try
    {
      if (xV == null) {
        xV = new a();
      }
      locala = xV;
      AppMethodBeat.o(212355);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(212355);
    }
  }
  
  public static Executor eK()
  {
    return xY;
  }
  
  public static Executor eL()
  {
    return xZ;
  }
  
  public final void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(212358);
    this.xW.f(paramRunnable);
    AppMethodBeat.o(212358);
  }
  
  public final boolean isMainThread()
  {
    AppMethodBeat.i(212366);
    boolean bool = this.xW.isMainThread();
    AppMethodBeat.o(212366);
    return bool;
  }
  
  public final void postToMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(212361);
    this.xW.postToMainThread(paramRunnable);
    AppMethodBeat.o(212361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */