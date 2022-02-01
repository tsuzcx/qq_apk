package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.b.a;
import kotlin.d.f.c;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Key", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface al
  extends f.b
{
  public static final al.b aot = al.b.aou;
  
  public abstract <R> Object b(b<? super Long, ? extends R> paramb, d<? super R> paramd);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <R> R a(al paramal, R paramR, m<? super R, ? super f.b, ? extends R> paramm)
    {
      AppMethodBeat.i(202331);
      s.u(paramal, "this");
      s.u(paramm, "operation");
      paramal = f.b.a.a((f.b)paramal, paramR, paramm);
      AppMethodBeat.o(202331);
      return paramal;
    }
    
    public static <E extends f.b> E a(al paramal, f.c<E> paramc)
    {
      AppMethodBeat.i(202323);
      s.u(paramal, "this");
      s.u(paramc, "key");
      paramal = f.b.a.a((f.b)paramal, paramc);
      AppMethodBeat.o(202323);
      return paramal;
    }
    
    public static f.c<?> a(al paramal)
    {
      AppMethodBeat.i(202312);
      s.u(paramal, "this");
      paramal = (f.c)al.aot;
      AppMethodBeat.o(202312);
      return paramal;
    }
    
    public static f a(al paramal, f paramf)
    {
      AppMethodBeat.i(202344);
      s.u(paramal, "this");
      s.u(paramf, "context");
      paramal = f.b.a.a((f.b)paramal, paramf);
      AppMethodBeat.o(202344);
      return paramal;
    }
    
    public static f b(al paramal, f.c<?> paramc)
    {
      AppMethodBeat.i(202337);
      s.u(paramal, "this");
      s.u(paramc, "key");
      paramal = f.b.a.b((f.b)paramal, paramc);
      AppMethodBeat.o(202337);
      return paramal;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.al
 * JD-Core Version:    0.7.0.1
 */