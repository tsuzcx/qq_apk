package a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class a$a
  implements Executor
{
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(52973);
    new Handler(Looper.getMainLooper()).post(paramRunnable);
    AppMethodBeat.o(52973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.a.a
 * JD-Core Version:    0.7.0.1
 */