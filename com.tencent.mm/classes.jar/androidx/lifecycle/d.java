package androidx.lifecycle;

import androidx.a.a.a.a;
import androidx.a.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class d<T>
{
  public final LiveData<T> bGX;
  final AtomicBoolean bGY = new AtomicBoolean(true);
  final AtomicBoolean bGZ = new AtomicBoolean(false);
  final Runnable bHa = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(194336);
      Object localObject1;
      if (d.this.bGZ.compareAndSet(false, true)) {
        localObject1 = null;
      }
      for (int i = 0;; i = 0) {
        try
        {
          while (d.this.bGY.compareAndSet(true, false))
          {
            localObject1 = d.this.He();
            i = 1;
          }
          if (i != 0) {
            d.this.bGX.t(localObject1);
          }
          d.this.bGZ.set(false);
          if ((i != 0) && (d.this.bGY.get())) {
            break;
          }
          AppMethodBeat.o(194336);
          return;
        }
        finally
        {
          d.this.bGZ.set(false);
          AppMethodBeat.o(194336);
        }
      }
    }
  };
  final Runnable bHb = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(194338);
      boolean bool = d.this.bGX.Hl();
      if ((d.this.bGY.compareAndSet(false, true)) && (bool)) {
        d.this.mExecutor.execute(d.this.bHa);
      }
      AppMethodBeat.o(194338);
    }
  };
  final Executor mExecutor;
  
  public d(Executor paramExecutor)
  {
    this.mExecutor = paramExecutor;
    this.bGX = new LiveData()
    {
      protected final void Hf()
      {
        AppMethodBeat.i(194335);
        d.this.mExecutor.execute(d.this.bHa);
        AppMethodBeat.o(194335);
      }
    };
  }
  
  protected abstract T He();
  
  public final void invalidate()
  {
    a locala = a.fG();
    Runnable localRunnable = this.bHb;
    if (locala.isMainThread())
    {
      localRunnable.run();
      return;
    }
    locala.postToMainThread(localRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.d
 * JD-Core Version:    0.7.0.1
 */