package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ae;
import kotlin.a.ae<+Landroidx.paging.ag<TT;>;>;
import kotlin.d.a.a;
import kotlin.d.d<-Landroidx.paging.bm<TT;>;>;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlinx.coroutines.e.c;
import kotlinx.coroutines.e.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/FlattenedPageController;", "T", "", "()V", "list", "Landroidx/paging/FlattenedPageEventStorage;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "snapshots", "", "Landroidx/paging/TemporaryDownstream;", "createTemporaryDownstream", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "record", "", "event", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
final class o<T>
{
  private final p<T> bMs;
  private List<bm<T>> bMt;
  private final c bMu;
  
  public o()
  {
    AppMethodBeat.i(197091);
    this.bMs = new p();
    this.bMt = ((List)kotlin.a.ab.aivy);
    this.bMu = e.kEM();
    AppMethodBeat.o(197091);
  }
  
  public final Object a(ae<? extends ag<T>> paramae, kotlin.d.d<? super kotlin.ah> paramd)
  {
    AppMethodBeat.i(197103);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    Object localObject8;
    a locala;
    for (paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;; paramd = new b(this, paramd))
    {
      localObject8 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramae = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(197103);
        throw paramae;
      }
    }
    ResultKt.throwOnFailure(localObject8);
    Object localObject1 = this.bMu;
    paramd.L$0 = this;
    paramd.Uf = paramae;
    paramd.VC = localObject1;
    paramd.label = 1;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    label320:
    Object localObject7;
    Object localObject9;
    int i;
    if (((c)localObject1).aD(paramd) == locala)
    {
      AppMethodBeat.o(197103);
      return locala;
      localObject1 = (c)paramd.VC;
      localObject3 = (ae)paramd.Uf;
      localObject2 = (o)paramd.L$0;
      ResultKt.throwOnFailure(localObject8);
      paramae = (ae<? extends ag<T>>)localObject1;
      for (;;)
      {
        try
        {
          localObject4 = ((o)localObject2).bMs;
          paramae = (ae<? extends ag<T>>)localObject1;
          localObject5 = (ag)((ae)localObject3).value;
          paramae = (ae<? extends ag<T>>)localObject1;
          s.u(localObject5, "event");
          paramae = (ae<? extends ag<T>>)localObject1;
          if (!(localObject5 instanceof ag.b)) {
            break;
          }
          paramae = (ae<? extends ag<T>>)localObject1;
          localObject5 = (ag.b)localObject5;
          paramae = (ae<? extends ag<T>>)localObject1;
          ((p)localObject4).bMz.a(((ag.b)localObject5).bNO);
          paramae = (ae<? extends ag<T>>)localObject1;
          localObject6 = ((ag.b)localObject5).bKC;
          paramae = (ae<? extends ag<T>>)localObject1;
          switch (q.avl[localObject6.ordinal()])
          {
          case 1: 
            paramae = (ae<? extends ag<T>>)localObject1;
            localObject5 = (Iterable)((o)localObject2).bMt;
            paramae = (ae<? extends ag<T>>)localObject1;
            localObject4 = (Collection)new ArrayList();
            paramae = (ae<? extends ag<T>>)localObject1;
            localObject7 = ((Iterable)localObject5).iterator();
            paramae = (ae<? extends ag<T>>)localObject4;
            localObject4 = localObject3;
            localObject5 = localObject2;
            localObject6 = paramd;
            localObject2 = localObject7;
            paramd = paramae;
            paramae = (ae<? extends ag<T>>)localObject1;
            if (!((Iterator)localObject2).hasNext()) {
              break label1114;
            }
            paramae = (ae<? extends ag<T>>)localObject1;
            localObject7 = ((Iterator)localObject2).next();
            paramae = (ae<? extends ag<T>>)localObject1;
            localObject3 = (bm)localObject7;
            paramae = (ae<? extends ag<T>>)localObject1;
            ((b)localObject6).L$0 = localObject4;
            paramae = (ae<? extends ag<T>>)localObject1;
            ((b)localObject6).Uf = localObject1;
            paramae = (ae<? extends ag<T>>)localObject1;
            ((b)localObject6).VC = localObject5;
            paramae = (ae<? extends ag<T>>)localObject1;
            ((b)localObject6).VD = paramd;
            paramae = (ae<? extends ag<T>>)localObject1;
            ((b)localObject6).Ze = localObject2;
            paramae = (ae<? extends ag<T>>)localObject1;
            ((b)localObject6).aqc = localObject7;
            paramae = (ae<? extends ag<T>>)localObject1;
            ((b)localObject6).label = 2;
            paramae = (ae<? extends ag<T>>)localObject1;
            localObject9 = ((bm)localObject3).b((ae)localObject4, (kotlin.d.d)localObject6);
            if (localObject9 != locala) {
              break label1166;
            }
            AppMethodBeat.o(197103);
            return locala;
          }
        }
        finally
        {
          paramae.jp(null);
          AppMethodBeat.o(197103);
        }
        paramae = (ae<? extends ag<T>>)localObject1;
        ((p)localObject4).bMy.clear();
        paramae = (ae<? extends ag<T>>)localObject1;
        ((p)localObject4).bMx = ((ag.b)localObject5).bMx;
        paramae = (ae<? extends ag<T>>)localObject1;
        ((p)localObject4).bMw = ((ag.b)localObject5).bMw;
        paramae = (ae<? extends ag<T>>)localObject1;
        ((p)localObject4).bMy.addAll((Collection)((ag.b)localObject5).bNN);
        continue;
        paramae = (ae<? extends ag<T>>)localObject1;
        ((p)localObject4).bMw = ((ag.b)localObject5).bMw;
        paramae = (ae<? extends ag<T>>)localObject1;
        localObject6 = ((Iterable)k.qs(((ag.b)localObject5).bNN.size() - 1, 0)).iterator();
        for (;;)
        {
          paramae = (ae<? extends ag<T>>)localObject1;
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          paramae = (ae<? extends ag<T>>)localObject1;
          i = ((kotlin.a.ah)localObject6).Zo();
          paramae = (ae<? extends ag<T>>)localObject1;
          ((p)localObject4).bMy.addFirst(((ag.b)localObject5).bNN.get(i));
        }
        paramae = (ae<? extends ag<T>>)localObject1;
        ((p)localObject4).bMx = ((ag.b)localObject5).bMx;
        paramae = (ae<? extends ag<T>>)localObject1;
        ((p)localObject4).bMy.addAll((Collection)((ag.b)localObject5).bNN);
      }
      paramae = (ae<? extends ag<T>>)localObject1;
      if ((localObject5 instanceof ag.a))
      {
        paramae = (ae<? extends ag<T>>)localObject1;
        localObject5 = (ag.a)localObject5;
        paramae = (ae<? extends ag<T>>)localObject1;
        localObject6 = ((p)localObject4).bMz;
        paramae = (ae<? extends ag<T>>)localObject1;
        localObject7 = ((ag.a)localObject5).bKC;
        paramae = (ae<? extends ag<T>>)localObject1;
        localObject8 = aa.c.bNz;
        paramae = (ae<? extends ag<T>>)localObject1;
        ((af)localObject6).a((ad)localObject7, false, (aa)aa.c.HM());
        paramae = (ae<? extends ag<T>>)localObject1;
        localObject6 = ((ag.a)localObject5).bKC;
        paramae = (ae<? extends ag<T>>)localObject1;
        switch (q.$EnumSwitchMapping$0[localObject6.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      paramae = (ae<? extends ag<T>>)localObject1;
      paramd = (Throwable)new IllegalArgumentException("Page drop type must be prepend or append");
      paramae = (ae<? extends ag<T>>)localObject1;
      AppMethodBeat.o(197103);
      paramae = (ae<? extends ag<T>>)localObject1;
      throw paramd;
      paramae = (ae<? extends ag<T>>)localObject1;
      ((p)localObject4).bMw = ((ag.a)localObject5).bNM;
      paramae = (ae<? extends ag<T>>)localObject1;
      int j = ((ag.a)localObject5).getPageCount();
      i = 0;
      while (i < j)
      {
        paramae = (ae<? extends ag<T>>)localObject1;
        ((p)localObject4).bMy.removeFirst();
        i += 1;
      }
      paramae = (ae<? extends ag<T>>)localObject1;
      ((p)localObject4).bMx = ((ag.a)localObject5).bNM;
      paramae = (ae<? extends ag<T>>)localObject1;
      j = ((ag.a)localObject5).getPageCount();
      i = 0;
      while (i < j)
      {
        paramae = (ae<? extends ag<T>>)localObject1;
        ((p)localObject4).bMy.removeLast();
        i += 1;
      }
      paramae = (ae<? extends ag<T>>)localObject1;
      if (!(localObject5 instanceof ag.c)) {
        break label320;
      }
      paramae = (ae<? extends ag<T>>)localObject1;
      localObject5 = (ag.c)localObject5;
      paramae = (ae<? extends ag<T>>)localObject1;
      ((p)localObject4).bMz.a(((ag.c)localObject5).bKC, ((ag.c)localObject5).bNX, ((ag.c)localObject5).bNY);
      break label320;
      localObject7 = paramd.aqc;
      localObject1 = (Iterator)paramd.Ze;
      localObject2 = (Collection)paramd.VD;
      localObject5 = (o)paramd.VC;
      localObject3 = (c)paramd.Uf;
      localObject4 = (ae)paramd.L$0;
      paramae = (ae<? extends ag<T>>)localObject3;
      ResultKt.throwOnFailure(localObject8);
      localObject6 = paramd;
      paramd = (kotlin.d.d<? super kotlin.ah>)localObject8;
      for (;;)
      {
        paramae = (ae<? extends ag<T>>)localObject3;
        if (((Boolean)paramd).booleanValue())
        {
          paramae = (ae<? extends ag<T>>)localObject3;
          ((Collection)localObject2).add(localObject7);
          paramd = (kotlin.d.d<? super kotlin.ah>)localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break;
          label1114:
          paramae = (ae<? extends ag<T>>)localObject1;
          ((o)localObject5).bMt = ((List)paramd);
          paramae = (ae<? extends ag<T>>)localObject1;
          paramd = kotlin.ah.aiuX;
          ((c)localObject1).jp(null);
          paramae = kotlin.ah.aiuX;
          AppMethodBeat.o(197103);
          return paramae;
        }
        paramd = (kotlin.d.d<? super kotlin.ah>)localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        label1166:
        paramae = paramd;
        localObject8 = localObject2;
        localObject3 = localObject1;
        paramd = localObject9;
        localObject2 = paramae;
        localObject1 = localObject8;
      }
      localObject2 = this;
      localObject3 = paramae;
      break;
      break label320;
    }
  }
  
  public final Object i(kotlin.d.d<? super bm<T>> paramd)
  {
    AppMethodBeat.i(197115);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject5;
    a locala;
    for (paramd = (kotlin.d.d<? super bm<T>>)localObject1;; paramd = new a(this, paramd))
    {
      localObject5 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(197115);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject5);
    Object localObject2 = this.bMu;
    paramd.L$0 = this;
    paramd.Uf = localObject2;
    paramd.label = 1;
    Object localObject1 = localObject2;
    Object localObject4 = this;
    if (((c)localObject2).aD(paramd) == locala)
    {
      AppMethodBeat.o(197115);
      return locala;
      localObject1 = (c)paramd.Uf;
      localObject4 = (o)paramd.L$0;
      ResultKt.throwOnFailure(localObject5);
    }
    localObject2 = localObject1;
    int j;
    try
    {
      localObject3 = new bm();
      localObject2 = localObject1;
      localObject5 = ((o)localObject4).bMs;
      localObject2 = localObject1;
      localObject4 = (List)new ArrayList();
      localObject2 = localObject1;
      Object localObject6;
      if (!((Collection)((p)localObject5).bMy).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label539;
        }
        localObject2 = localObject1;
        localObject6 = ag.b.bNQ;
        localObject2 = localObject1;
        ((List)localObject4).add(ag.b.a.a(kotlin.a.p.p((Iterable)((p)localObject5).bMy), ((p)localObject5).bMw, ((p)localObject5).bMx, ((p)localObject5).bMz.HO()));
      }
      for (;;)
      {
        localObject2 = localObject1;
        localObject4 = (Iterable)localObject4;
        i = 0;
        localObject2 = localObject1;
        localObject6 = ((Iterable)localObject4).iterator();
        localObject2 = localObject3;
        localObject4 = localObject3;
        localObject3 = localObject2;
        localObject5 = paramd;
        paramd = (kotlin.d.d<? super bm<T>>)localObject6;
        localObject2 = localObject1;
        if (!paramd.hasNext()) {
          break label1054;
        }
        localObject2 = localObject1;
        localObject6 = paramd.next();
        j = i + 1;
        if (i < 0)
        {
          localObject2 = localObject1;
          kotlin.a.p.kkW();
        }
        localObject2 = localObject1;
        localObject6 = (ag)localObject6;
        localObject2 = localObject1;
        localObject6 = new ae(((Number)Integer.valueOf(i)).intValue() - -2147483648, localObject6);
        localObject2 = localObject1;
        ((a)localObject5).L$0 = localObject1;
        localObject2 = localObject1;
        ((a)localObject5).Uf = localObject4;
        localObject2 = localObject1;
        ((a)localObject5).VC = localObject3;
        localObject2 = localObject1;
        ((a)localObject5).VD = paramd;
        localObject2 = localObject1;
        ((a)localObject5).aai = j;
        localObject2 = localObject1;
        ((a)localObject5).label = 2;
        localObject2 = localObject1;
        localObject6 = ((bm)localObject3).b((ae)localObject6, (kotlin.d.d)localObject5);
        if (localObject6 != locala) {
          break label1079;
        }
        AppMethodBeat.o(197115);
        return locala;
        i = 0;
        break;
        label539:
        localObject2 = localObject1;
        localObject5 = ((p)localObject5).bMz;
        localObject2 = localObject1;
        localObject6 = ((af)localObject5).bLC;
        localObject2 = localObject1;
        Object localObject7 = ad.bNC;
        localObject2 = localObject1;
        Object localObject8 = ((ab)localObject6).bLz;
        localObject2 = localObject1;
        ag.c.a locala1 = ag.c.bNZ;
        localObject2 = localObject1;
        if (ag.c.a.a((aa)localObject8, false))
        {
          localObject2 = localObject1;
          ((List)localObject4).add(new ag.c((ad)localObject7, false, (aa)localObject8));
        }
        localObject2 = localObject1;
        localObject7 = ad.bND;
        localObject2 = localObject1;
        localObject8 = ((ab)localObject6).bLA;
        localObject2 = localObject1;
        locala1 = ag.c.bNZ;
        localObject2 = localObject1;
        if (ag.c.a.a((aa)localObject8, false))
        {
          localObject2 = localObject1;
          ((List)localObject4).add(new ag.c((ad)localObject7, false, (aa)localObject8));
        }
        localObject2 = localObject1;
        localObject7 = ad.bNE;
        localObject2 = localObject1;
        localObject6 = ((ab)localObject6).bLB;
        localObject2 = localObject1;
        localObject8 = ag.c.bNZ;
        localObject2 = localObject1;
        if (ag.c.a.a((aa)localObject6, false))
        {
          localObject2 = localObject1;
          ((List)localObject4).add(new ag.c((ad)localObject7, false, (aa)localObject6));
        }
        localObject2 = localObject1;
        localObject5 = ((af)localObject5).bLD;
        if (localObject5 != null)
        {
          localObject2 = localObject1;
          localObject6 = ad.bNC;
          localObject2 = localObject1;
          localObject7 = ((ab)localObject5).bLz;
          localObject2 = localObject1;
          localObject8 = ag.c.bNZ;
          localObject2 = localObject1;
          if (ag.c.a.a((aa)localObject7, true))
          {
            localObject2 = localObject1;
            ((List)localObject4).add(new ag.c((ad)localObject6, true, (aa)localObject7));
          }
          localObject2 = localObject1;
          localObject6 = ad.bND;
          localObject2 = localObject1;
          localObject7 = ((ab)localObject5).bLA;
          localObject2 = localObject1;
          localObject8 = ag.c.bNZ;
          localObject2 = localObject1;
          if (ag.c.a.a((aa)localObject7, true))
          {
            localObject2 = localObject1;
            ((List)localObject4).add(new ag.c((ad)localObject6, true, (aa)localObject7));
          }
          localObject2 = localObject1;
          localObject6 = ad.bNE;
          localObject2 = localObject1;
          localObject5 = ((ab)localObject5).bLB;
          localObject2 = localObject1;
          localObject7 = ag.c.bNZ;
          localObject2 = localObject1;
          if (ag.c.a.a((aa)localObject5, true))
          {
            localObject2 = localObject1;
            ((List)localObject4).add(new ag.c((ad)localObject6, true, (aa)localObject5));
          }
        }
      }
      ((c)localObject2).jp(null);
    }
    finally {}
    label977:
    AppMethodBeat.o(197115);
    throw paramd;
    int i = paramd.aai;
    localObject2 = (Iterator)paramd.VD;
    Object localObject3 = (bm)paramd.VC;
    localObject4 = (bm)paramd.Uf;
    localObject1 = (c)paramd.L$0;
    for (;;)
    {
      try
      {
        ResultKt.throwOnFailure(localObject5);
        localObject5 = paramd;
        paramd = (kotlin.d.d<? super bm<T>>)localObject3;
        localObject3 = paramd;
        paramd = (kotlin.d.d<? super bm<T>>)localObject2;
        break;
      }
      finally
      {
        label1054:
        localObject2 = localObject1;
      }
      ((c)localObject1).jp(null);
      AppMethodBeat.o(197115);
      return localObject4;
      break label977;
      label1079:
      i = j;
      localObject2 = paramd;
      paramd = (kotlin.d.d<? super bm<T>>)localObject3;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"createTemporaryDownstream", "", "T", "continuation", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/TemporaryDownstream;"}, k=3, mv={1, 4, 2})
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    int aai;
    int label;
    
    a(o paramo, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196924);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.bMv.i(this);
      AppMethodBeat.o(196924);
      return paramObject;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"record", "", "T", "event", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 4, 2})
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    Object aqc;
    int label;
    
    b(o paramo, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196926);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.bMv.a(null, this);
      AppMethodBeat.o(196926);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.o
 * JD-Core Version:    0.7.0.1
 */