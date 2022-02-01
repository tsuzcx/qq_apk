package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class c<T>
{
  public final LiveData<T> ZE;
  final AtomicBoolean ZF = new AtomicBoolean(true);
  final AtomicBoolean ZG = new AtomicBoolean(false);
  final Runnable ZH = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(247949);
      Object localObject1;
      if (c.this.ZG.compareAndSet(false, true)) {
        localObject1 = null;
      }
      for (int i = 0;; i = 0) {
        try
        {
          while (c.this.ZF.compareAndSet(true, false))
          {
            localObject1 = c.this.ja();
            i = 1;
          }
          if (i != 0) {
            c.this.ZE.L(localObject1);
          }
          c.this.ZG.set(false);
          if ((i != 0) && (c.this.ZF.get())) {
            break;
          }
          AppMethodBeat.o(247949);
          return;
        }
        finally
        {
          c.this.ZG.set(false);
          AppMethodBeat.o(247949);
        }
      }
    }
  };
  final Runnable ZI = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(247952);
      boolean bool = c.this.ZE.ji();
      if ((c.this.ZF.compareAndSet(false, true)) && (bool)) {
        c.this.mExecutor.execute(c.this.ZH);
      }
      AppMethodBeat.o(247952);
    }
  };
  final Executor mExecutor;
  
  public c(Executor paramExecutor)
  {
    this.mExecutor = paramExecutor;
    this.ZE = new LiveData()
    {
      protected final void jb()
      {
        AppMethodBeat.i(247947);
        c.this.mExecutor.execute(c.this.ZH);
        AppMethodBeat.o(247947);
      }
    };
  }
  
  protected abstract T ja();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.lifecycle.c
 * JD-Core Version:    0.7.0.1
 */