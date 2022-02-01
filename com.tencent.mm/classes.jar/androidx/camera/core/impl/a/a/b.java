package androidx.camera.core.impl.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class b
  implements Executor
{
  private static volatile b OY;
  
  public static Executor kP()
  {
    AppMethodBeat.i(199090);
    b localb;
    if (OY != null)
    {
      localb = OY;
      AppMethodBeat.o(199090);
      return localb;
    }
    try
    {
      if (OY == null) {
        OY = new b();
      }
      localb = OY;
      AppMethodBeat.o(199090);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(199090);
    }
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(199099);
    paramRunnable.run();
    AppMethodBeat.o(199099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.a.a.b
 * JD-Core Version:    0.7.0.1
 */