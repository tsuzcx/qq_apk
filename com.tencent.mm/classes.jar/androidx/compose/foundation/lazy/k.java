package androidx.compose.foundation.lazy;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/LazyListItemContentFactory;", "", "saveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "itemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;Landroidx/compose/runtime/State;)V", "itemScope", "Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "lambdasCache", "", "Landroidx/compose/foundation/lazy/LazyListItemContentFactory$CachedItemContent;", "getContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "index", "", "key", "(ILjava/lang/Object;)Lkotlin/jvm/functions/Function2;", "updateItemScope", "density", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "updateItemScope-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)V", "updateKeyIndexMappingForVisibleItems", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "CachedItemContent", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  final androidx.compose.runtime.e.c aeC;
  bm<? extends n> aeD;
  final Map<Object, a> aeE;
  i aeF;
  
  public k(androidx.compose.runtime.e.c paramc, bm<? extends n> parambm)
  {
    AppMethodBeat.i(204232);
    this.aeC = paramc;
    this.aeD = parambm;
    this.aeE = ((Map)new LinkedHashMap());
    this.aeF = l.mH();
    AppMethodBeat.o(204232);
  }
  
  public final m<h, Integer, ah> f(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(204238);
    s.u(paramObject, "key");
    a locala = (a)this.aeE.get(paramObject);
    if ((locala != null) && (locala.getIndex() == paramInt))
    {
      paramObject = locala.SP;
      AppMethodBeat.o(204238);
      return paramObject;
    }
    locala = new a(paramInt, this.aeF, paramObject);
    this.aeE.put(paramObject, locala);
    paramObject = locala.SP;
    AppMethodBeat.o(204238);
    return paramObject;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/LazyListItemContentFactory$CachedItemContent;", "", "initialIndex", "", "scope", "Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "key", "(Landroidx/compose/foundation/lazy/LazyListItemContentFactory;ILandroidx/compose/foundation/lazy/LazyItemScopeImpl;Ljava/lang/Object;)V", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getContent", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableState;", "getKey", "()Ljava/lang/Object;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
  {
    final m<h, Integer, ah> SP;
    final i aeG;
    final an aeH;
    final Object key;
    
    public a(i parami, Object paramObject)
    {
      AppMethodBeat.i(204251);
      this.aeG = paramObject;
      this.key = localObject;
      this.aeH = bj.T(Integer.valueOf(parami));
      this.SP = ((m)androidx.compose.runtime.c.c.a(-985538056, true, new a(k.this, this)));
      AppMethodBeat.o(204251);
    }
    
    public final int getIndex()
    {
      AppMethodBeat.i(204257);
      int i = ((Number)((bm)this.aeH).getValue()).intValue();
      AppMethodBeat.o(204257);
      return i;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<h, Integer, ah>
    {
      a(k paramk, k.a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.k
 * JD-Core Version:    0.7.0.1
 */