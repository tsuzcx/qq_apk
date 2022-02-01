package androidx.camera.core.impl.a.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class a
{
  public static Executor b(Executor paramExecutor)
  {
    AppMethodBeat.i(199089);
    paramExecutor = new g(paramExecutor);
    AppMethodBeat.o(199089);
    return paramExecutor;
  }
  
  public static ScheduledExecutorService b(Handler paramHandler)
  {
    AppMethodBeat.i(199098);
    paramHandler = new c(paramHandler);
    AppMethodBeat.o(199098);
    return paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.a.a.a
 * JD-Core Version:    0.7.0.1
 */