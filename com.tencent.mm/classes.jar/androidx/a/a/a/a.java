package androidx.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class a
  extends c
{
  private static volatile a yQ;
  private static final Executor yT;
  private static final Executor yU;
  public c yR;
  private c yS;
  
  static
  {
    AppMethodBeat.i(201141);
    yT = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(201127);
        a.fG().postToMainThread(paramAnonymousRunnable);
        AppMethodBeat.o(201127);
      }
    };
    yU = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(201119);
        a.fG().f(paramAnonymousRunnable);
        AppMethodBeat.o(201119);
      }
    };
    AppMethodBeat.o(201141);
  }
  
  private a()
  {
    AppMethodBeat.i(201106);
    this.yS = new b();
    this.yR = this.yS;
    AppMethodBeat.o(201106);
  }
  
  public static a fG()
  {
    AppMethodBeat.i(201114);
    a locala;
    if (yQ != null)
    {
      locala = yQ;
      AppMethodBeat.o(201114);
      return locala;
    }
    try
    {
      if (yQ == null) {
        yQ = new a();
      }
      locala = yQ;
      AppMethodBeat.o(201114);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(201114);
    }
  }
  
  public static Executor fH()
  {
    return yT;
  }
  
  public static Executor fI()
  {
    return yU;
  }
  
  public final void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(201148);
    this.yR.f(paramRunnable);
    AppMethodBeat.o(201148);
  }
  
  public final boolean isMainThread()
  {
    AppMethodBeat.i(201169);
    boolean bool = this.yR.isMainThread();
    AppMethodBeat.o(201169);
    return bool;
  }
  
  public final void postToMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(201158);
    this.yR.postToMainThread(paramRunnable);
    AppMethodBeat.o(201158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */