package androidx.camera.core.impl.a.b;

import androidx.c.a.b.a;
import androidx.c.a.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

final class g<V>
  implements com.google.b.b.a.f<List<V>>
{
  List<? extends com.google.b.b.a.f<? extends V>> PP;
  List<V> PQ;
  final boolean PR;
  final AtomicInteger PS;
  private final com.google.b.b.a.f<List<V>> PT;
  b.a<List<V>> PU;
  
  g(List<? extends com.google.b.b.a.f<? extends V>> paramList, boolean paramBoolean, Executor paramExecutor)
  {
    AppMethodBeat.i(198996);
    this.PP = ((List)androidx.core.f.f.checkNotNull(paramList));
    this.PQ = new ArrayList(paramList.size());
    this.PR = paramBoolean;
    this.PS = new AtomicInteger(paramList.size());
    this.PT = androidx.c.a.b.a(new b.c()
    {
      public final Object attachCompleter(b.a<List<V>> paramAnonymousa)
      {
        AppMethodBeat.i(199025);
        if (g.this.PU == null) {}
        for (boolean bool = true;; bool = false)
        {
          androidx.core.f.f.b(bool, "The result can only set once!");
          g.this.PU = paramAnonymousa;
          paramAnonymousa = "ListFuture[" + this + "]";
          AppMethodBeat.o(199025);
          return paramAnonymousa;
        }
      }
    });
    c(paramExecutor);
    AppMethodBeat.o(198996);
  }
  
  private void c(Executor paramExecutor)
  {
    int j = 0;
    AppMethodBeat.i(199008);
    a(new Runnable()
    {
      public final void run()
      {
        g.this.PQ = null;
        g.this.PP = null;
      }
    }, androidx.camera.core.impl.a.a.b.kP());
    if (this.PP.isEmpty())
    {
      this.PU.ap(new ArrayList(this.PQ));
      AppMethodBeat.o(199008);
      return;
    }
    final int i = 0;
    while (i < this.PP.size())
    {
      this.PQ.add(null);
      i += 1;
    }
    List localList = this.PP;
    i = j;
    while (i < localList.size())
    {
      final com.google.b.b.a.f localf = (com.google.b.b.a.f)localList.get(i);
      localf.a(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = true;
          boolean bool3 = true;
          boolean bool4 = true;
          boolean bool5 = true;
          boolean bool6 = true;
          boolean bool1 = true;
          AppMethodBeat.i(199037);
          g localg = g.this;
          int i = i;
          Object localObject1 = localf;
          List localList5 = localg.PQ;
          if ((localg.isDone()) || (localList5 == null))
          {
            androidx.core.f.f.b(localg.PR, "Future was done before all dependencies completed");
            AppMethodBeat.o(199037);
            return;
          }
          try
          {
            androidx.core.f.f.b(((Future)localObject1).isDone(), "Tried to set value from future which is not done");
            localList5.set(i, e.b((Future)localObject1));
            i = localg.PS.decrementAndGet();
            if (i >= 0) {}
            for (;;)
            {
              androidx.core.f.f.b(bool1, "Less than 0 remaining futures");
              if (i != 0) {
                break label173;
              }
              localObject1 = localg.PQ;
              if (localObject1 == null) {
                break;
              }
              localg.PU.ap(new ArrayList((Collection)localObject1));
              AppMethodBeat.o(199037);
              return;
              bool1 = false;
            }
            androidx.core.f.f.b(localg.isDone(), null);
            label173:
            AppMethodBeat.o(199037);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            if (localg.PR) {
              localg.cancel(false);
            }
            i = localg.PS.decrementAndGet();
            if (i >= 0) {}
            for (bool1 = bool2;; bool1 = false)
            {
              androidx.core.f.f.b(bool1, "Less than 0 remaining futures");
              if (i != 0) {
                break label271;
              }
              List localList1 = localg.PQ;
              if (localList1 == null) {
                break;
              }
              localg.PU.ap(new ArrayList(localList1));
              AppMethodBeat.o(199037);
              return;
            }
            androidx.core.f.f.b(localg.isDone(), null);
            AppMethodBeat.o(199037);
            return;
          }
          catch (ExecutionException localExecutionException)
          {
            if (localg.PR) {
              localg.PU.h(localExecutionException.getCause());
            }
            i = localg.PS.decrementAndGet();
            if (i >= 0) {}
            for (bool1 = bool3;; bool1 = false)
            {
              androidx.core.f.f.b(bool1, "Less than 0 remaining futures");
              if (i != 0) {
                break label377;
              }
              List localList2 = localg.PQ;
              if (localList2 == null) {
                break;
              }
              localg.PU.ap(new ArrayList(localList2));
              AppMethodBeat.o(199037);
              return;
            }
            androidx.core.f.f.b(localg.isDone(), null);
            AppMethodBeat.o(199037);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            if (localg.PR) {
              localg.PU.h(localRuntimeException);
            }
            i = localg.PS.decrementAndGet();
            if (i >= 0) {}
            for (bool1 = bool4;; bool1 = false)
            {
              androidx.core.f.f.b(bool1, "Less than 0 remaining futures");
              if (i != 0) {
                break label480;
              }
              List localList3 = localg.PQ;
              if (localList3 == null) {
                break;
              }
              localg.PU.ap(new ArrayList(localList3));
              AppMethodBeat.o(199037);
              return;
            }
            androidx.core.f.f.b(localg.isDone(), null);
            AppMethodBeat.o(199037);
            return;
          }
          catch (Error localError)
          {
            label271:
            label377:
            localg.PU.h(localError);
            label480:
            i = localg.PS.decrementAndGet();
            if (i >= 0) {}
            for (bool1 = bool5;; bool1 = false)
            {
              androidx.core.f.f.b(bool1, "Less than 0 remaining futures");
              if (i != 0) {
                break label575;
              }
              List localList4 = localg.PQ;
              if (localList4 == null) {
                break;
              }
              localg.PU.ap(new ArrayList(localList4));
              AppMethodBeat.o(199037);
              return;
            }
            androidx.core.f.f.b(localg.isDone(), null);
            label575:
            AppMethodBeat.o(199037);
            return;
          }
          finally
          {
            i = localg.PS.decrementAndGet();
            if (i < 0) {
              break label647;
            }
          }
          bool1 = bool6;
          androidx.core.f.f.b(bool1, "Less than 0 remaining futures");
          if (i == 0)
          {
            localList5 = localg.PQ;
            if (localList5 == null) {
              break label652;
            }
            localg.PU.ap(new ArrayList(localList5));
          }
          for (;;)
          {
            AppMethodBeat.o(199037);
            throw localObject2;
            label647:
            bool1 = false;
            break;
            label652:
            androidx.core.f.f.b(localg.isDone(), null);
          }
        }
      }, paramExecutor);
      i += 1;
    }
    AppMethodBeat.o(199008);
  }
  
  /* Error */
  private List<V> kU()
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 50	androidx/camera/core/impl/a/b/g:PP	Ljava/util/List;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +79 -> 90
    //   14: aload_0
    //   15: invokevirtual 135	androidx/camera/core/impl/a/b/g:isDone	()Z
    //   18: ifne +72 -> 90
    //   21: aload_1
    //   22: invokeinterface 139 1 0
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 144 1 0
    //   34: ifeq +56 -> 90
    //   37: aload_1
    //   38: invokeinterface 148 1 0
    //   43: checkcast 7	com/google/b/b/a/f
    //   46: astore_2
    //   47: aload_2
    //   48: invokeinterface 149 1 0
    //   53: ifne -25 -> 28
    //   56: aload_2
    //   57: invokeinterface 151 1 0
    //   62: pop
    //   63: goto -16 -> 47
    //   66: astore_1
    //   67: ldc 132
    //   69: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: ldc 132
    //   77: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_1
    //   81: athrow
    //   82: astore_3
    //   83: aload_0
    //   84: getfield 62	androidx/camera/core/impl/a/b/g:PR	Z
    //   87: ifeq -40 -> 47
    //   90: aload_0
    //   91: getfield 78	androidx/camera/core/impl/a/b/g:PT	Lcom/google/b/b/a/f;
    //   94: invokeinterface 151 1 0
    //   99: checkcast 48	java/util/List
    //   102: astore_1
    //   103: ldc 132
    //   105: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_1
    //   109: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	g
    //   9	29	1	localObject1	Object
    //   66	7	1	localError	Error
    //   74	7	1	localInterruptedException	java.lang.InterruptedException
    //   102	7	1	localList	List
    //   46	11	2	localf	com.google.b.b.a.f
    //   82	1	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   56	63	66	java/lang/Error
    //   56	63	74	java/lang/InterruptedException
    //   56	63	82	finally
  }
  
  public final void a(Runnable paramRunnable, Executor paramExecutor)
  {
    AppMethodBeat.i(199024);
    this.PT.a(paramRunnable, paramExecutor);
    AppMethodBeat.o(199024);
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(199033);
    if (this.PP != null)
    {
      Iterator localIterator = this.PP.iterator();
      while (localIterator.hasNext()) {
        ((com.google.b.b.a.f)localIterator.next()).cancel(paramBoolean);
      }
    }
    paramBoolean = this.PT.cancel(paramBoolean);
    AppMethodBeat.o(199033);
    return paramBoolean;
  }
  
  public final boolean isCancelled()
  {
    AppMethodBeat.i(199043);
    boolean bool = this.PT.isCancelled();
    AppMethodBeat.o(199043);
    return bool;
  }
  
  public final boolean isDone()
  {
    AppMethodBeat.i(199050);
    boolean bool = this.PT.isDone();
    AppMethodBeat.o(199050);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.a.b.g
 * JD-Core Version:    0.7.0.1
 */