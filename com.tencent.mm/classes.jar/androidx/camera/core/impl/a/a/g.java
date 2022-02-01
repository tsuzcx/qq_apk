package androidx.camera.core.impl.a.a;

import androidx.camera.core.al;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class g
  implements Executor
{
  final Deque<Runnable> Pp;
  private final a Pq;
  b Pr;
  long Ps;
  private final Executor mExecutor;
  
  g(Executor paramExecutor)
  {
    AppMethodBeat.i(199084);
    this.Pp = new ArrayDeque();
    this.Pq = new a();
    this.Pr = b.Pv;
    this.Ps = 0L;
    this.mExecutor = ((Executor)f.checkNotNull(paramExecutor));
    AppMethodBeat.o(199084);
  }
  
  public final void execute(Runnable arg1)
  {
    j = 0;
    AppMethodBeat.i(199103);
    f.checkNotNull(???);
    synchronized (this.Pp)
    {
      if ((this.Pr == b.Py) || (this.Pr == b.Px))
      {
        this.Pp.add(???);
        AppMethodBeat.o(199103);
        return;
      }
      l = this.Ps;
      local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199070);
          paramRunnable.run();
          AppMethodBeat.o(199070);
        }
      };
      this.Pp.add(local1);
      this.Pr = b.Pw;
      try
      {
        this.mExecutor.execute(this.Pq);
        if (this.Pr == b.Pw) {
          break label234;
        }
        i = 1;
      }
      catch (RuntimeException ???)
      {
        for (;;)
        {
          synchronized (this.Pp)
          {
            if (this.Pr != b.Pv)
            {
              i = j;
              if (this.Pr != b.Pw) {}
            }
            else
            {
              i = j;
              if (this.Pp.removeLastOccurrence(local1)) {
                i = 1;
              }
            }
            if ((!(??? instanceof RejectedExecutionException)) || (i != 0))
            {
              AppMethodBeat.o(199103);
              throw ???;
            }
          }
          AppMethodBeat.o(199103);
          return;
          int i = 0;
        }
        synchronized (this.Pp)
        {
          if ((this.Ps != l) || (this.Pr != b.Pw)) {
            break label273;
          }
          this.Pr = b.Px;
          AppMethodBeat.o(199103);
          return;
        }
      }
      catch (Error ???)
      {
        break label147;
      }
      if (i != 0)
      {
        AppMethodBeat.o(199103);
        return;
      }
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    private void kS()
    {
      AppMethodBeat.i(199112);
      int i = 0;
      boolean bool1 = false;
      int j = bool1;
      for (;;)
      {
        try
        {
          Deque localDeque = g.this.Pp;
          j = bool1;
          if (i == 0)
          {
            try
            {
              if (g.this.Pr == g.b.Py) {
                return;
              }
              localObject2 = g.this;
              ((g)localObject2).Ps += 1L;
              g.this.Pr = g.b.Py;
              i = 1;
              localObject2 = (Runnable)g.this.Pp.poll();
              if (localObject2 == null)
              {
                g.this.Pr = g.b.Pv;
                return;
              }
              j = bool1;
              j = bool1;
              boolean bool2 = Thread.interrupted();
              bool1 |= bool2;
              j = bool1;
            }
            finally
            {
              try
              {
                Object localObject2;
                ((Runnable)localObject2).run();
              }
              catch (RuntimeException localRuntimeException)
              {
                j = bool1;
                "Exception while executing runnable ".concat(String.valueOf(localObject3));
                j = bool1;
                al.U("SequentialExecutor");
              }
              localObject3 = finally;
              j = bool1;
              j = bool1;
              AppMethodBeat.o(199112);
              j = bool1;
            }
            break;
          }
        }
        finally
        {
          if (j != 0) {
            Thread.currentThread().interrupt();
          }
          AppMethodBeat.o(199112);
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(199120);
      try
      {
        kS();
        AppMethodBeat.o(199120);
        return;
      }
      catch (Error localError)
      {
        synchronized (g.this.Pp)
        {
          g.this.Pr = g.b.Pv;
          AppMethodBeat.o(199120);
          throw localError;
        }
      }
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(199119);
      Pv = new b("IDLE", 0);
      Pw = new b("QUEUING", 1);
      Px = new b("QUEUED", 2);
      Py = new b("RUNNING", 3);
      Pz = new b[] { Pv, Pw, Px, Py };
      AppMethodBeat.o(199119);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.a.a.g
 * JD-Core Version:    0.7.0.1
 */