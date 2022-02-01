package androidx.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public enum c
  implements Executor
{
  static
  {
    AppMethodBeat.i(195292);
    bgb = new c("INSTANCE");
    bgc = new c[] { bgb };
    AppMethodBeat.o(195292);
  }
  
  private c() {}
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(195298);
    paramRunnable.run();
    AppMethodBeat.o(195298);
  }
  
  public final String toString()
  {
    return "DirectExecutor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.c.a.c
 * JD-Core Version:    0.7.0.1
 */