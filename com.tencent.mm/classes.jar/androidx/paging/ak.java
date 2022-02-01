package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.e.c;
import kotlinx.coroutines.e.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageFetcherSnapshotState;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "(Landroidx/paging/PagingConfig;)V", "_pages", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "_placeholdersAfter", "", "_placeholdersBefore", "appendGenerationId", "appendGenerationIdCh", "Lkotlinx/coroutines/channels/Channel;", "failedHintsByLoadType", "", "Landroidx/paging/LoadType;", "Landroidx/paging/ViewportHint;", "getFailedHintsByLoadType$paging_common", "()Ljava/util/Map;", "<set-?>", "initialPageIndex", "getInitialPageIndex$paging_common", "()I", "pages", "", "getPages$paging_common", "()Ljava/util/List;", "value", "placeholdersAfter", "getPlaceholdersAfter$paging_common", "setPlaceholdersAfter$paging_common", "(I)V", "placeholdersBefore", "getPlaceholdersBefore$paging_common", "setPlaceholdersBefore$paging_common", "prependGenerationId", "prependGenerationIdCh", "Landroidx/paging/LoadStates;", "sourceLoadStates", "getSourceLoadStates$paging_common", "()Landroidx/paging/LoadStates;", "storageCount", "getStorageCount$paging_common", "consumeAppendGenerationIdAsFlow", "Lkotlinx/coroutines/flow/Flow;", "consumePrependGenerationIdAsFlow", "currentPagingState", "Landroidx/paging/PagingState;", "viewportHint", "Landroidx/paging/ViewportHint$Access;", "currentPagingState$paging_common", "drop", "", "event", "Landroidx/paging/PageEvent$Drop;", "dropEventOrNull", "loadType", "hint", "generationId", "generationId$paging_common", "insert", "", "loadId", "page", "setSourceLoadState", "type", "newState", "Landroidx/paging/LoadState;", "toPageEvent", "Landroidx/paging/PageEvent;", "toPageEvent$paging_common", "Holder", "paging-common"}, k=1, mv={1, 4, 2})
public final class ak<Key, Value>
{
  final List<ay.b.b<Key, Value>> bNN;
  private final au bOe;
  private final List<ay.b.b<Key, Value>> bPe;
  int bPf;
  private int bPg;
  private int bPh;
  int bPi;
  int bPj;
  final kotlinx.coroutines.a.h<Integer> bPk;
  final kotlinx.coroutines.a.h<Integer> bPl;
  final Map<ad, bp> bPm;
  ab bPn;
  
  private ak(au paramau)
  {
    AppMethodBeat.i(196763);
    this.bOe = paramau;
    this.bPe = ((List)new ArrayList());
    this.bNN = this.bPe;
    this.bPk = kotlinx.coroutines.a.k.a(-1, null, 6);
    this.bPl = kotlinx.coroutines.a.k.a(-1, null, 6);
    this.bPm = ((Map)new LinkedHashMap());
    paramau = ab.bNB;
    this.bPn = ab.HN();
    AppMethodBeat.o(196763);
  }
  
  private int HR()
  {
    AppMethodBeat.i(196721);
    Object localObject = (Iterable)this.bNN;
    int i = 0;
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      i = ((ay.b.b)((Iterator)localObject).next()).bMf.size() + i;
    }
    AppMethodBeat.o(196721);
    return i;
  }
  
  private int HS()
  {
    if (this.bOe.bPM) {
      return this.bPg;
    }
    return 0;
  }
  
  private int HT()
  {
    if (this.bOe.bPM) {
      return this.bPh;
    }
    return 0;
  }
  
  private void fj(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.bPg = paramInt;
      return;
      paramInt = 0;
    }
  }
  
  private void fk(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.bPh = paramInt;
      return;
      paramInt = 0;
    }
  }
  
  public final ag.a<Value> a(ad paramad, bp parambp)
  {
    int n = 0;
    AppMethodBeat.i(196827);
    s.u(paramad, "loadType");
    s.u(parambp, "hint");
    if (this.bOe.maxSize == 2147483647)
    {
      AppMethodBeat.o(196827);
      return null;
    }
    if (this.bNN.size() <= 2)
    {
      AppMethodBeat.o(196827);
      return null;
    }
    if (HR() <= this.bOe.maxSize)
    {
      AppMethodBeat.o(196827);
      return null;
    }
    if (paramad != ad.bNC) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramad = (Throwable)new IllegalArgumentException("Drop LoadType must be PREPEND or APPEND, but got ".concat(String.valueOf(paramad)).toString());
      AppMethodBeat.o(196827);
      throw paramad;
    }
    i = 0;
    int j = 0;
    int k;
    if ((j < this.bNN.size()) && (HR() - i > this.bOe.maxSize))
    {
      switch (al.bPp[paramad.ordinal()])
      {
      default: 
        k = ((ay.b.b)this.bNN.get(kotlin.a.p.oE(this.bNN) - j)).bMf.size();
        label220:
        switch (al.bPq[paramad.ordinal()])
        {
        }
        break;
      }
      for (int m = parambp.bRI - i - k;; m = parambp.bRH - i - k)
      {
        if (m < this.bOe.bPL) {
          break label326;
        }
        j += 1;
        i = k + i;
        break;
        k = ((ay.b.b)this.bNN.get(j)).bMf.size();
        break label220;
      }
    }
    switch (j)
    {
    default: 
      label326:
      switch (al.bPr[paramad.ordinal()])
      {
      default: 
        k = kotlin.a.p.oE(this.bNN) - this.bPf - (j - 1);
        switch (al.bPs[paramad.ordinal()])
        {
        default: 
          j = kotlin.a.p.oE(this.bNN) - this.bPf;
          if (!this.bOe.bPM) {
            i = n;
          }
          break;
        }
        break;
      }
      label434:
      break;
    }
    for (;;)
    {
      paramad = new ag.a(paramad, k, j, i);
      AppMethodBeat.o(196827);
      return paramad;
      AppMethodBeat.o(196827);
      return null;
      k = -this.bPf;
      break;
      j = j - 1 - this.bPf;
      break label434;
      if (paramad == ad.bND) {
        i = HS() + i;
      } else {
        i = HT() + i;
      }
    }
  }
  
  public final ag<Value> a(ay.b.b<Key, Value> paramb, ad paramad)
  {
    AppMethodBeat.i(196791);
    s.u(paramb, "$this$toPageEvent");
    s.u(paramad, "loadType");
    int i;
    switch (al.avl[paramad.ordinal()])
    {
    default: 
      paramb = new kotlin.p();
      AppMethodBeat.o(196791);
      throw paramb;
    case 1: 
      i = 0;
    }
    for (;;)
    {
      paramb = kotlin.a.p.listOf(new bn(i, paramb.bMf));
      switch (al.avM[paramad.ordinal()])
      {
      default: 
        paramb = new kotlin.p();
        AppMethodBeat.o(196791);
        throw paramb;
        i = 0 - this.bPf;
        continue;
        i = this.bNN.size() - this.bPf - 1;
      }
    }
    paramad = ag.b.bNQ;
    paramb = (ag)ag.b.a.a(paramb, HS(), HT(), new j(this.bPn.bLz, this.bPn.bLA, this.bPn.bLB, this.bPn, null));
    AppMethodBeat.o(196791);
    return paramb;
    paramad = ag.b.bNQ;
    paramb = (ag)ag.b.a.a(paramb, HS(), new j(this.bPn.bLz, this.bPn.bLA, this.bPn.bLB, this.bPn, null));
    AppMethodBeat.o(196791);
    return paramb;
    paramad = ag.b.bNQ;
    paramb = (ag)ag.b.a.b(paramb, HT(), new j(this.bPn.bLz, this.bPn.bLA, this.bPn.bLB, this.bPn, null));
    AppMethodBeat.o(196791);
    return paramb;
  }
  
  public final ba<Key, Value> a(bp.a parama)
  {
    AppMethodBeat.i(196836);
    List localList = kotlin.a.p.p((Iterable)this.bNN);
    int i;
    if (parama != null)
    {
      int j = HS();
      int m = -this.bPf;
      int n = kotlin.a.p.oE(this.bNN);
      int i1 = this.bPf;
      int i2 = parama.bRL;
      i = m;
      if (i < i2)
      {
        if (i > n - i1) {}
        for (int k = this.bOe.pageSize;; k = ((ay.b.b)this.bNN.get(this.bPf + i)).bMf.size())
        {
          j += k;
          i += 1;
          break;
        }
      }
      j = parama.bRM + j;
      i = j;
      if (parama.bRL < m) {
        i = j - this.bOe.pageSize;
      }
    }
    for (parama = Integer.valueOf(i);; parama = null)
    {
      parama = new ba(localList, parama, this.bOe, HS());
      AppMethodBeat.o(196836);
      return parama;
    }
  }
  
  public final void a(ag.a<Value> parama)
  {
    AppMethodBeat.i(196817);
    s.u(parama, "event");
    if (parama.getPageCount() <= this.bNN.size()) {}
    for (int i = 1; i == 0; i = 0)
    {
      parama = (Throwable)new IllegalStateException(("invalid drop count. have " + this.bNN.size() + " but wanted to drop " + parama.getPageCount()).toString());
      AppMethodBeat.o(196817);
      throw parama;
    }
    this.bPm.remove(parama.bKC);
    Object localObject = this.bPn;
    ad localad = parama.bKC;
    aa.c.a locala = aa.c.bNz;
    this.bPn = ((ab)localObject).a(localad, (aa)aa.c.HM());
    localObject = parama.bKC;
    switch (al.bOM[localObject.ordinal()])
    {
    default: 
      parama = (Throwable)new IllegalArgumentException("cannot drop " + parama.bKC);
      AppMethodBeat.o(196817);
      throw parama;
    case 1: 
      j = parama.getPageCount();
      i = 0;
      while (i < j)
      {
        this.bPe.remove(0);
        i += 1;
      }
      this.bPf -= parama.getPageCount();
      fj(parama.bNM);
      this.bPi += 1;
      this.bPk.offer(Integer.valueOf(this.bPi));
      AppMethodBeat.o(196817);
      return;
    }
    int j = parama.getPageCount();
    i = 0;
    while (i < j)
    {
      this.bPe.remove(this.bNN.size() - 1);
      i += 1;
    }
    fk(parama.bNM);
    this.bPj += 1;
    this.bPl.offer(Integer.valueOf(this.bPj));
    AppMethodBeat.o(196817);
  }
  
  public final boolean a(int paramInt, ad paramad, ay.b.b<Key, Value> paramb)
  {
    AppMethodBeat.i(196804);
    s.u(paramad, "loadType");
    s.u(paramb, "page");
    switch (al.bOL[paramad.ordinal()])
    {
    default: 
    case 1: 
      for (;;)
      {
        AppMethodBeat.o(196804);
        return true;
        if (!this.bNN.isEmpty())
        {
          paramad = (Throwable)new IllegalStateException("cannot receive multiple init calls".toString());
          AppMethodBeat.o(196804);
          throw paramad;
        }
        if (paramInt == 0) {}
        for (paramInt = 1; paramInt == 0; paramInt = 0)
        {
          paramad = (Throwable)new IllegalStateException("init loadId must be the initial value, 0".toString());
          AppMethodBeat.o(196804);
          throw paramad;
        }
        this.bPe.add(paramb);
        this.bPf = 0;
        fk(paramb.bMj);
        fj(paramb.bMi);
      }
    case 2: 
      if (!((Collection)this.bNN).isEmpty()) {}
      for (i = 1; i == 0; i = 0)
      {
        paramad = (Throwable)new IllegalStateException("should've received an init before prepend".toString());
        AppMethodBeat.o(196804);
        throw paramad;
      }
      if (paramInt != this.bPi)
      {
        AppMethodBeat.o(196804);
        return false;
      }
      this.bPe.add(0, paramb);
      this.bPf += 1;
      if (paramb.bMi == -2147483648) {}
      for (paramInt = kotlin.k.k.qu(HS() - paramb.bMf.size(), 0);; paramInt = paramb.bMi)
      {
        fj(paramInt);
        this.bPm.remove(ad.bND);
        break;
      }
    }
    if (!((Collection)this.bNN).isEmpty()) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramad = (Throwable)new IllegalStateException("should've received an init before append".toString());
      AppMethodBeat.o(196804);
      throw paramad;
    }
    if (paramInt != this.bPj)
    {
      AppMethodBeat.o(196804);
      return false;
    }
    this.bPe.add(paramb);
    if (paramb.bMj == -2147483648) {}
    for (paramInt = kotlin.k.k.qu(HT() - paramb.bMf.size(), 0);; paramInt = paramb.bMj)
    {
      fk(paramInt);
      this.bPm.remove(ad.bNE);
      break;
    }
  }
  
  public final boolean b(ad paramad, aa paramaa)
  {
    AppMethodBeat.i(196782);
    s.u(paramad, "type");
    s.u(paramaa, "newState");
    if (s.p(this.bPn.d(paramad), paramaa))
    {
      AppMethodBeat.o(196782);
      return false;
    }
    this.bPn = this.bPn.a(paramad, paramaa);
    AppMethodBeat.o(196782);
    return true;
  }
  
  public final int e(ad paramad)
  {
    AppMethodBeat.i(196773);
    s.u(paramad, "loadType");
    switch (al.$EnumSwitchMapping$0[paramad.ordinal()])
    {
    default: 
      paramad = new kotlin.p();
      AppMethodBeat.o(196773);
      throw paramad;
    case 1: 
      paramad = (Throwable)new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
      AppMethodBeat.o(196773);
      throw paramad;
    case 2: 
      i = this.bPi;
      AppMethodBeat.o(196773);
      return i;
    }
    int i = this.bPj;
    AppMethodBeat.o(196773);
    return i;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageFetcherSnapshotState$Holder;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "(Landroidx/paging/PagingConfig;)V", "lock", "Lkotlinx/coroutines/sync/Mutex;", "state", "Landroidx/paging/PageFetcherSnapshotState;", "withLock", "T", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class a<Key, Value>
  {
    final c bMu;
    private final au bOe;
    final ak<Key, Value> bPo;
    
    public a(au paramau)
    {
      AppMethodBeat.i(196942);
      this.bOe = paramau;
      this.bMu = e.kEM();
      this.bPo = new ak(this.bOe, (byte)0);
      AppMethodBeat.o(196942);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class b
    extends kotlin.d.b.a.k
    implements m<kotlinx.coroutines.b.h<? super Integer>, d<? super ah>, Object>
  {
    int label;
    
    b(ak paramak, d paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(196948);
      s.u(paramd, "completion");
      paramObject = new b(this.bPt, paramd);
      AppMethodBeat.o(196948);
      return paramObject;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196953);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(196953);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196943);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196943);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      this.bPt.bPl.offer(Integer.valueOf(this.bPt.bPj));
      paramObject = ah.aiuX;
      AppMethodBeat.o(196943);
      return paramObject;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class c
    extends kotlin.d.b.a.k
    implements m<kotlinx.coroutines.b.h<? super Integer>, d<? super ah>, Object>
  {
    int label;
    
    c(ak paramak, d paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(196955);
      s.u(paramd, "completion");
      paramObject = new c(this.bPt, paramd);
      AppMethodBeat.o(196955);
      return paramObject;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196956);
      paramObject1 = ((c)create(paramObject1, (d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(196956);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196951);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196951);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      this.bPt.bPk.offer(Integer.valueOf(this.bPt.bPi));
      paramObject = ah.aiuX;
      AppMethodBeat.o(196951);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.ak
 * JD-Core Version:    0.7.0.1
 */