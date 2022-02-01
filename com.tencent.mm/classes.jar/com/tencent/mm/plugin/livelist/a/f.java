package com.tencent.mm.plugin.livelist.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.a.n;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livelist/datasource/MergeDataSource;", "T", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "dataSource", "", "Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "([Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;)V", "getDataSource", "()[Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "[Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "dataSourceIndex", "", "dataSourceOffsetMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sortDataSource", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "combine", "getData", "Lkotlinx/coroutines/flow/Flow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "getSingleData", "", "dataResponse", "channel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "onCreate", "Companion", "plugin-livelist_release"})
public final class f<T extends com.tencent.mm.plugin.livelist.b>
  extends a<T>
{
  public static final f.b EiG;
  private final ArrayList<e<T, c<T>, d<T>>> EiC;
  private int EiD;
  private final HashMap<Integer, Integer> EiE;
  private final e<T, c<T>, d<T>>[] EiF;
  
  static
  {
    AppMethodBeat.i(218099);
    EiG = new f.b((byte)0);
    AppMethodBeat.o(218099);
  }
  
  public f(e<T, c<T>, d<T>>... paramVarArgs)
  {
    AppMethodBeat.i(218096);
    this.EiF = paramVarArgs;
    this.EiC = new ArrayList();
    kotlin.a.j.a((Collection)this.EiC, this.EiF);
    paramVarArgs = (List)this.EiC;
    if (paramVarArgs.size() > 1) {
      kotlin.a.j.a(paramVarArgs, (Comparator)new a());
    }
    this.EiE = new HashMap();
    AppMethodBeat.o(218096);
  }
  
  private final void a(final ak paramak, final c<T> paramc, final d<T> paramd, final n<d<T>> paramn)
  {
    AppMethodBeat.i(218090);
    e locale = (e)kotlin.a.j.M((List)this.EiC, this.EiD);
    if ((locale == null) || (g.b(paramak, null, (m)new c(locale, null, this, paramak, paramc, paramd, paramn), 3) == null)) {
      paramn.offer(paramd);
    }
    AppMethodBeat.o(218090);
  }
  
  public final e<T, c<T>, d<T>> a(e<T, c<T>, d<T>> parame)
  {
    AppMethodBeat.i(218093);
    p.k(parame, "dataSource");
    ArrayList localArrayList = new ArrayList();
    if ((parame instanceof f))
    {
      localArrayList.addAll((Collection)this.EiC);
      localArrayList.addAll((Collection)((f)parame).EiC);
    }
    for (;;)
    {
      parame = ((Collection)localArrayList).toArray(new e[0]);
      if (parame != null) {
        break;
      }
      parame = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(218093);
      throw parame;
      localArrayList.add(parame);
    }
    parame = (e[])parame;
    parame = (e)new f((e[])Arrays.copyOf(parame, parame.length));
    AppMethodBeat.o(218093);
    return parame;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(218084);
    this.EiD = 0;
    this.EiE.clear();
    ((Map)this.EiE).put(Integer.valueOf(0), Integer.valueOf(0));
    Iterator localIterator = ((Iterable)this.EiC).iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onCreate();
    }
    AppMethodBeat.o(218084);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(217654);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((e)paramT2).getPriority()), (Comparable)Integer.valueOf(((e)paramT1).getPriority()));
      AppMethodBeat.o(217654);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/livelist/datasource/MergeDataSource$getSingleData$1$1"})
  static final class c
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    c(e parame, kotlin.d.d paramd, f paramf, ak paramak, c paramc, d paramd1, n paramn)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(218040);
      p.k(paramd, "completion");
      paramd = new c(this.EiH, paramd, jdField_this, paramak, paramc, paramd, paramn);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(218040);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(218042);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(218042);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(218038);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(218038);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        kotlinx.coroutines.b.b localb = this.EiH.a(paramak, paramc);
        kotlinx.coroutines.b.c localc = (kotlinx.coroutines.b.c)new kotlinx.coroutines.b.c()
        {
          public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
          {
            AppMethodBeat.i(218186);
            paramAnonymousObject = (d)paramAnonymousObject;
            this.EiM.EiL.mXB.addAll((Collection)paramAnonymousObject.mXB);
            this.EiM.EiL.xcp = true;
            if (!paramAnonymousObject.xcp)
            {
              paramAnonymousd = this.EiM.EiI;
              f.a(paramAnonymousd, f.a(paramAnonymousd) + 1);
              if (!f.b(this.EiM.EiI).containsKey(Integer.valueOf(f.a(this.EiM.EiI)))) {
                ((Map)f.b(this.EiM.EiI)).put(Integer.valueOf(f.a(this.EiM.EiI)), Integer.valueOf(this.EiM.EiK.offset + paramAnonymousObject.mXB.size()));
              }
              if (this.EiM.EiL.mXB.size() >= this.EiM.EiK.pageSize) {
                this.EiM.Ehr.offer(this.EiM.EiL);
              }
            }
            for (;;)
            {
              paramAnonymousObject = x.aazN;
              AppMethodBeat.o(218186);
              return paramAnonymousObject;
              Log.i("MicroMsg.Mvvm.MergeDataSource", "continue to request next datasource:" + f.a(this.EiM.EiI));
              paramAnonymousObject = new c(0, this.EiM.EiK.pageSize - this.EiM.EiL.mXB.size());
              f.a(this.EiM.EiI, this.EiM.EiJ, paramAnonymousObject, this.EiM.EiL, this.EiM.Ehr);
              continue;
              this.EiM.Ehr.offer(this.EiM.EiL);
            }
          }
        };
        this.L$0 = paramObject;
        this.oDA = localb;
        this.label = 1;
        if (localb.a(localc, this) == locala)
        {
          AppMethodBeat.o(218038);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(218038);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.livelist.a.f
 * JD-Core Version:    0.7.0.1
 */