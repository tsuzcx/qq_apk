package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class d$a
  implements Executor
{
  final Handler mHandler;
  
  d$a()
  {
    AppMethodBeat.i(260764);
    this.mHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(260764);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(260766);
    this.mHandler.post(paramRunnable);
    AppMethodBeat.o(260766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.d.a
 * JD-Core Version:    0.7.0.1
 */