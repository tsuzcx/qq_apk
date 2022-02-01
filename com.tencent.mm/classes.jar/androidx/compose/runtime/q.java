package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"CompositionLocalProvider", "", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "([Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "compositionLocalOf", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "T", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "defaultFactory", "staticCompositionLocalOf", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final <T> as<T> a(bi<T> parambi, a<? extends T> parama)
  {
    AppMethodBeat.i(202244);
    s.u(parambi, "policy");
    s.u(parama, "defaultFactory");
    parambi = (as)new z(parambi, parama);
    AppMethodBeat.o(202244);
    return parambi;
  }
  
  public static final void a(at<?>[] paramArrayOfat, final m<? super h, ? super Integer, ah> paramm, h paramh, final int paramInt)
  {
    AppMethodBeat.i(202255);
    s.u(paramArrayOfat, "values");
    s.u(paramm, "content");
    paramh = paramh.by(-1460640152);
    paramh.a(paramArrayOfat);
    paramm.invoke(paramh, Integer.valueOf(paramInt >> 3 & 0xE));
    paramh.os();
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((m)new a(paramArrayOfat, paramm, paramInt));
    }
    AppMethodBeat.o(202255);
  }
  
  public static final <T> as<T> e(a<? extends T> parama)
  {
    AppMethodBeat.i(202250);
    s.u(parama, "defaultFactory");
    parama = (as)new bn(parama);
    AppMethodBeat.o(202250);
    return parama;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<h, Integer, ah>
  {
    a(at<?>[] paramArrayOfat, m<? super h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.q
 * JD-Core Version:    0.7.0.1
 */