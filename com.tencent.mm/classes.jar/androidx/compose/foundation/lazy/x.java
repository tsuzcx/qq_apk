package androidx.compose.foundation.lazy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/LazyListScopeImpl;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "()V", "_headerIndexes", "", "", "headerIndexes", "", "getHeaderIndexes", "()Ljava/util/List;", "intervals", "Landroidx/compose/foundation/lazy/IntervalList;", "Landroidx/compose/foundation/lazy/IntervalContent;", "itemsCount", "getItemsCount", "()I", "getContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "index", "scope", "Landroidx/compose/foundation/lazy/LazyItemScope;", "(ILandroidx/compose/foundation/lazy/LazyItemScope;)Lkotlin/jvm/functions/Function2;", "getKey", "", "item", "key", "content", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "Lkotlin/ParameterName;", "name", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class x
  implements n, w
{
  private final e<c> afw;
  private List<Integer> afx;
  
  public x()
  {
    AppMethodBeat.i(204221);
    this.afw = new e();
    AppMethodBeat.o(204221);
  }
  
  public final m<androidx.compose.runtime.h, Integer, ah> a(int paramInt, h paramh)
  {
    AppMethodBeat.i(204228);
    s.u(paramh, "scope");
    d locald = this.afw.bt(paramInt);
    int i = locald.startIndex;
    paramh = (m)((c)locald.aeq).SP.invoke(paramh, Integer.valueOf(paramInt - i));
    AppMethodBeat.o(204228);
    return paramh;
  }
  
  public final void a(int paramInt, b<? super Integer, ? extends Object> paramb, r<? super h, ? super Integer, ? super androidx.compose.runtime.h, ? super Integer, ah> paramr)
  {
    AppMethodBeat.i(204233);
    s.u(paramr, "itemContent");
    this.afw.add(paramInt, new c(paramb, (m)new b(paramr)));
    AppMethodBeat.o(204233);
  }
  
  public final void a(q<? super h, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq)
  {
    AppMethodBeat.i(204239);
    s.u(paramq, "content");
    this.afw.add(1, new c(null, (m)new a(paramq)));
    AppMethodBeat.o(204239);
  }
  
  public final Object bu(int paramInt)
  {
    AppMethodBeat.i(204224);
    Object localObject = this.afw.bt(paramInt);
    int i = ((d)localObject).startIndex;
    localObject = ((c)((d)localObject).aeq).aep;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((b)localObject).invoke(Integer.valueOf(paramInt - i)))
    {
      localObject = new DefaultLazyKey(paramInt);
      AppMethodBeat.o(204224);
      return localObject;
    }
    AppMethodBeat.o(204224);
    return localObject;
  }
  
  public final int getItemsCount()
  {
    return this.afw.aes;
  }
  
  public final List<Integer> mI()
  {
    List localList2 = this.afx;
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = (List)ab.aivy;
    }
    return localList1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<h, Integer, m<? super androidx.compose.runtime.h, ? super Integer, ? extends ah>>
  {
    a(q<? super h, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<h, Integer, m<? super androidx.compose.runtime.h, ? super Integer, ? extends ah>>
  {
    b(r<? super h, ? super Integer, ? super androidx.compose.runtime.h, ? super Integer, ah> paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.x
 * JD-Core Version:    0.7.0.1
 */