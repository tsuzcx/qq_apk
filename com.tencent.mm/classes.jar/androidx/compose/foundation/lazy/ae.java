package androidx.compose.foundation.lazy;

import androidx.compose.foundation.a.o;
import androidx.compose.runtime.bm;
import androidx.compose.ui.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"lazyListSemantics", "Landroidx/compose/ui/Modifier;", "stateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ae
{
  public static final f a(f paramf, final bm<? extends n> parambm, final aa paramaa, final aq paramaq, boolean paramBoolean)
  {
    AppMethodBeat.i(204259);
    kotlin.g.b.s.u(paramf, "<this>");
    kotlin.g.b.s.u(parambm, "stateOfItemsProvider");
    kotlin.g.b.s.u(paramaa, "state");
    kotlin.g.b.s.u(paramaq, "coroutineScope");
    paramf = androidx.compose.ui.k.n.a(paramf, false, (b)new a(paramBoolean, parambm, paramaa, paramaq));
    AppMethodBeat.o(204259);
    return paramf;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements b<androidx.compose.ui.k.u, ah>
  {
    a(boolean paramBoolean, bm<? extends n> parambm, aa paramaa, aq paramaq)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<Float>
    {
      a(aa paramaa)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.ae
 * JD-Core Version:    0.7.0.1
 */