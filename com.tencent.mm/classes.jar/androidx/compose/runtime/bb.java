package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/SdkStubsFallbackFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "()V", "DefaultFrameDelay", "", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class bb
  implements al
{
  public static final bb apz;
  
  static
  {
    AppMethodBeat.i(201940);
    apz = new bb();
    AppMethodBeat.o(201940);
  }
  
  public final <R> Object b(b<? super Long, ? extends R> paramb, d<? super R> paramd)
  {
    AppMethodBeat.i(201945);
    paramb = l.a((f)bg.kCh(), (m)new bb.a(paramb, null), paramd);
    AppMethodBeat.o(201945);
    return paramb;
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(201958);
    paramR = al.a.a((al)this, paramR, paramm);
    AppMethodBeat.o(201958);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(201951);
    paramc = al.a.a((al)this, paramc);
    AppMethodBeat.o(201951);
    return paramc;
  }
  
  public final f.c<?> getKey()
  {
    AppMethodBeat.i(201974);
    f.c localc = al.a.a(this);
    AppMethodBeat.o(201974);
    return localc;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(201963);
    paramc = al.a.b((al)this, paramc);
    AppMethodBeat.o(201963);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(201968);
    paramf = al.a.a((al)this, paramf);
    AppMethodBeat.o(201968);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.bb
 * JD-Core Version:    0.7.0.1
 */