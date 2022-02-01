package androidx.paging.compose;

import androidx.compose.foundation.lazy.w;
import androidx.compose.runtime.c.c;
import androidx.compose.runtime.h.a;
import androidx.paging.aa.c;
import androidx.paging.ab;
import androidx.paging.av;
import androidx.paging.aw;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.l;

@Metadata(d1={""}, d2={"IncompleteLoadState", "Landroidx/paging/LoadState$NotLoading;", "InitialLoadStates", "Landroidx/paging/LoadStates;", "collectAsLazyPagingItems", "Landroidx/paging/compose/LazyPagingItems;", "T", "", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "(Lkotlinx/coroutines/flow/Flow;Landroidx/compose/runtime/Composer;I)Landroidx/paging/compose/LazyPagingItems;", "items", "", "Landroidx/compose/foundation/lazy/LazyListScope;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "item", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "value", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/LazyListScope;Landroidx/paging/compose/LazyPagingItems;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;Landroidx/paging/compose/LazyPagingItems;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "paging-compose_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final aa.c bRS;
  private static final ab bRT;
  
  static
  {
    AppMethodBeat.i(197240);
    bRS = new aa.c(false);
    bRT = new ab((androidx.paging.aa)bRS, (androidx.paging.aa)bRS, (androidx.paging.aa)bRS);
    AppMethodBeat.o(197240);
  }
  
  public static final <T> a<T> a(g<av<T>> paramg, androidx.compose.runtime.h paramh)
  {
    AppMethodBeat.i(197208);
    kotlin.g.b.s.u(paramg, "<this>");
    paramh.bx(1046463763);
    paramh.bx(-3686930);
    boolean bool = paramh.G(paramg);
    Object localObject2 = paramh.or();
    Object localObject1;
    if (!bool)
    {
      localObject1 = androidx.compose.runtime.h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new a(paramg);
      paramh.F(localObject1);
    }
    paramh.od();
    paramg = (a)localObject1;
    androidx.compose.runtime.aa.a(paramg, (m)new a(paramg, null), paramh);
    androidx.compose.runtime.aa.a(paramg, (m)new b(paramg, null), paramh);
    paramh.od();
    AppMethodBeat.o(197208);
    return paramg;
  }
  
  public static final <T> void a(w paramw, final a<T> parama, final m<? super Integer, ? super T, ? extends Object> paramm, kotlin.g.a.s<? super androidx.compose.foundation.lazy.h, ? super Integer, ? super T, ? super androidx.compose.runtime.h, ? super Integer, ah> params)
  {
    AppMethodBeat.i(197220);
    kotlin.g.b.s.u(paramw, "<this>");
    kotlin.g.b.s.u(parama, "items");
    kotlin.g.b.s.u(params, "itemContent");
    int i = parama.Il().size();
    if (paramm == null) {}
    for (paramm = null;; paramm = (kotlin.g.a.b)new c(parama, paramm))
    {
      paramw.a(i, paramm, (r)c.a(-985538649, true, new d(params, parama)));
      AppMethodBeat.o(197220);
      return;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(a<T> parama, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(197190);
      paramObject = (d)new a(this.bRU, paramd);
      AppMethodBeat.o(197190);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(197188);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(197188);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.bRU;
        Object localObject = (d)this;
        this.label = 1;
        localObject = l.a(paramObject.bLH, (m)new a.b(paramObject, null), (d)localObject);
        paramObject = localObject;
        if (localObject != kotlin.d.a.a.aiwj) {
          paramObject = ah.aiuX;
        }
        if (paramObject == locala)
        {
          AppMethodBeat.o(197188);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(197188);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(a<T> parama, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(197214);
      paramObject = (d)new b(this.bRU, paramd);
      AppMethodBeat.o(197214);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(197201);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(197201);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.bRU;
        Object localObject = (d)this;
        this.label = 1;
        localObject = ((g)paramObject.bRP.bQv).a((kotlinx.coroutines.b.h)new a.a(paramObject), (d)localObject);
        paramObject = localObject;
        if (localObject != kotlin.d.a.a.aiwj) {
          paramObject = ah.aiuX;
        }
        if (paramObject == locala)
        {
          AppMethodBeat.o(197201);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(197201);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, Object>
  {
    c(a<T> parama, m<? super Integer, ? super T, ? extends Object> paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements r<androidx.compose.foundation.lazy.h, Integer, androidx.compose.runtime.h, Integer, ah>
  {
    d(kotlin.g.a.s<? super androidx.compose.foundation.lazy.h, ? super Integer, ? super T, ? super androidx.compose.runtime.h, ? super Integer, ah> params, a<T> parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.compose.b
 * JD-Core Version:    0.7.0.1
 */