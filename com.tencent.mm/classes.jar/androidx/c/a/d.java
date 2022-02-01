package androidx.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"await", "T", "Lcom/google/common/util/concurrent/ListenableFuture;", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nonNullCause", "", "Ljava/util/concurrent/ExecutionException;", "concurrent-futures-ktx"}, k=2, mv={1, 1, 16})
public final class d
{
  public static final <T> Object a(com.google.b.b.a.f<T> paramf, kotlin.d.d<? super T> paramd)
  {
    AppMethodBeat.i(195287);
    try
    {
      if (paramf.isDone())
      {
        paramf = a.b((Future)paramf);
        AppMethodBeat.o(195287);
        return paramf;
      }
    }
    catch (ExecutionException paramf)
    {
      paramf = a(paramf);
      AppMethodBeat.o(195287);
      throw paramf;
    }
    q localq = new q(kotlin.d.a.b.au(paramd), 1);
    p localp = (p)localq;
    paramf.a((Runnable)new f(paramf, localp), (Executor)c.bgb);
    localp.bg((kotlin.g.a.b)new a(paramf));
    paramf = localq.getResult();
    if (paramf == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(195287);
    return paramf;
  }
  
  static final Throwable a(ExecutionException paramExecutionException)
  {
    AppMethodBeat.i(195293);
    paramExecutionException = paramExecutionException.getCause();
    if (paramExecutionException == null) {
      s.klw();
    }
    AppMethodBeat.o(195293);
    return paramExecutionException;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "", "invoke", "androidx/concurrent/futures/ListenableFutureKt$await$2$1"}, k=3, mv={1, 1, 16})
  static final class a
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    a(com.google.b.b.a.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.c.a.d
 * JD-Core Version:    0.7.0.1
 */