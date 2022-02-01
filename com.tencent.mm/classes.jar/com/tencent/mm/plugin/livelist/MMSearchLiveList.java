package com.tencent.mm.plugin.livelist;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.livelist.a.e;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.by;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livelist/MMSearchLiveList;", "T", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Q", "Lcom/tencent/mm/plugin/livelist/MMLiveList;", "dataSource", "Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "searchDataSource", "Lcom/tencent/mm/plugin/livelist/datasource/BaseSearchDataSource;", "config", "Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;Lcom/tencent/mm/plugin/livelist/datasource/BaseSearchDataSource;Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "getSearchDataSource", "()Lcom/tencent/mm/plugin/livelist/datasource/BaseSearchDataSource;", "searchJob", "Lkotlinx/coroutines/Job;", "getSearchJob", "()Lkotlinx/coroutines/Job;", "setSearchJob", "(Lkotlinx/coroutines/Job;)V", "startSearch", "", "query", "(Ljava/lang/Object;)V", "stopSearch", "plugin-livelist_release"})
public class MMSearchLiveList<T extends b, Q>
  extends MMLiveList<T>
{
  public by Eiv;
  public final com.tencent.mm.plugin.livelist.a.b<T, Q> Eiw;
  
  public MMSearchLiveList(e<T, com.tencent.mm.plugin.livelist.a.c<T>, com.tencent.mm.plugin.livelist.a.d<T>> parame, com.tencent.mm.plugin.livelist.a.b<T, Q> paramb, f paramf, androidx.lifecycle.l paraml)
  {
    super(parame, paramf, paraml);
    AppMethodBeat.i(217936);
    this.Eiw = paramb;
    AppMethodBeat.o(217936);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Q", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class a
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    public a(MMSearchLiveList paramMMSearchLiveList, Object paramObject, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(217610);
      p.k(paramd, "completion");
      paramd = new a(this.Eix, this.Eiy, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(217610);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(217612);
      paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(217612);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(217608);
      a locala = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(217608);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        kotlinx.coroutines.b.b localb = this.Eix.Eiw.a((ak)this.Eix.EhL, (com.tencent.mm.plugin.livelist.a.c)new i(this.Eiy, this.Eix.EhQ.pageSize));
        kotlinx.coroutines.b.c localc = (kotlinx.coroutines.b.c)new a(this);
        this.L$0 = paramObject;
        this.oDA = localb;
        this.label = 1;
        if (localb.a(localc, this) == locala)
        {
          AppMethodBeat.o(217608);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(217608);
      return paramObject;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
    public static final class a
      implements kotlinx.coroutines.b.c<com.tencent.mm.plugin.livelist.a.d<T>>
    {
      public a(MMSearchLiveList.a parama) {}
      
      public final Object a(Object paramObject, kotlin.d.d paramd)
      {
        AppMethodBeat.i(217772);
        paramObject = (com.tencent.mm.plugin.livelist.a.d)paramObject;
        this.Eiz.Eix.fK((List)paramObject.mXB);
        this.Eiz.Eix.Eiv = null;
        paramObject = x.aazN;
        AppMethodBeat.o(217772);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.livelist.MMSearchLiveList
 * JD-Core Version:    0.7.0.1
 */