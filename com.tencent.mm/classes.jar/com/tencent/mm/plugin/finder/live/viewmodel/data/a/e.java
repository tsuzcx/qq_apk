package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.bq;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bfv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lcom.tencent.mm.protocal.protobuf.anc;>;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxContextMemStore;", "", "()V", "TAG", "", "boxContextMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/BoxContext;", "Lkotlin/collections/ArrayList;", "getBoxContextMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "diskStore", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxContextDiskStore;", "getBoxContextList", "liveId", "getOrCreateBoxContext", "tag", "boxId", "(Ljava/lang/String;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadData", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBoxData", "boxContext", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/BoxContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveData", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String TAG;
  public static final e akgh;
  private static final d akgi;
  private static final ConcurrentHashMap<Long, ArrayList<anc>> akgj;
  
  static
  {
    AppMethodBeat.i(371729);
    akgh = new e();
    TAG = "Finder.BoxContextMemStore";
    akgi = new d();
    akgj = new ConcurrentHashMap();
    AppMethodBeat.o(371729);
  }
  
  public static ArrayList<anc> Cu(long paramLong)
  {
    AppMethodBeat.i(371709);
    Object localObject2 = (ConcurrentMap)akgj;
    Long localLong = Long.valueOf(paramLong);
    Object localObject1 = ((ConcurrentMap)localObject2).get(localLong);
    if (localObject1 == null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((ConcurrentMap)localObject2).putIfAbsent(localLong, localArrayList);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localArrayList;
      }
    }
    for (;;)
    {
      s.s(localObject1, "boxContextMap.getOrPut(l…    ArrayList()\n        }");
      localObject1 = (ArrayList)localObject1;
      AppMethodBeat.o(371709);
      return localObject1;
    }
  }
  
  public static Object a(String paramString, final anc paramanc, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(371698);
    paramString = ar.c((m)new c(paramString, paramanc, null), paramd);
    if (paramString == a.aiwj)
    {
      AppMethodBeat.o(371698);
      return paramString;
    }
    paramString = ah.aiuX;
    AppMethodBeat.o(371698);
    return paramString;
  }
  
  public static Object c(String paramString, final long paramLong, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(371681);
    paramString = ar.c((m)new b(paramString, paramLong, null), paramd);
    if (paramString == a.aiwj)
    {
      AppMethodBeat.o(371681);
      return paramString;
    }
    paramString = ah.aiuX;
    AppMethodBeat.o(371681);
    return paramString;
  }
  
  public static Object d(String paramString, final long paramLong, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(371690);
    paramString = ar.c((m)new d(paramString, paramLong, null), paramd);
    if (paramString == a.aiwj)
    {
      AppMethodBeat.o(371690);
      return paramString;
    }
    paramString = ah.aiuX;
    AppMethodBeat.o(371690);
    return paramString;
  }
  
  public static ConcurrentHashMap<Long, ArrayList<anc>> kLb()
  {
    return akgj;
  }
  
  public final Object a(String paramString1, long paramLong, String paramString2, kotlin.d.d<? super anc> paramd)
  {
    AppMethodBeat.i(371744);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    a locala;
    for (paramd = (kotlin.d.d<? super anc>)localObject1;; paramd = new a(this, paramd))
    {
      localObject1 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString1 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(371744);
        throw paramString1;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    ArrayList localArrayList = Cu(paramLong);
    Iterator localIterator = ((Iterable)localArrayList).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break label298;
      }
      localObject2 = localIterator.next();
      localObject1 = ((anc)localObject2).Don;
      if (localObject1 != null) {
        break;
      }
      localObject1 = null;
    } while (!s.p(localObject1, paramString2));
    label298:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject1 = (anc)localObject1;
      if (localObject1 == null) {
        break label304;
      }
      paramd = bq.akii;
      bq.rQ(TAG, paramString1 + " getOrCreateBoxContext liveId:" + com.tencent.mm.ae.d.hF(paramLong) + ", boxId:" + paramString2 + ", exist");
      paramString1 = bq.akii;
      paramString1 = TAG;
      paramString2 = bq.akii;
      bq.rQ(paramString1, bq.c((anc)localObject1));
      AppMethodBeat.o(371744);
      return localObject1;
      localObject1 = ((bfv)localObject1).id;
      break;
    }
    label304:
    localObject1 = new anc();
    Object localObject2 = bq.akii;
    ((anc)localObject1).Don = bq.bLz(paramString2);
    ((anc)localObject1).ZEQ = null;
    ((anc)localObject1).mMJ = paramLong;
    localArrayList.add(localObject1);
    localObject2 = bq.akii;
    localObject2 = TAG;
    paramString1 = new StringBuilder().append(paramString1).append(" getOrCreateBoxContext liveId:").append(com.tencent.mm.ae.d.hF(paramLong)).append(", boxId:").append(paramString2).append(", not exist, create boxContext, logInfo:");
    paramString2 = bq.akii;
    bq.rQ((String)localObject2, bq.c((anc)localObject1));
    paramd.L$0 = localObject1;
    paramd.label = 1;
    paramString1 = (String)localObject1;
    if (a("getOrCreateBoxContext", (anc)localObject1, paramd) == locala)
    {
      AppMethodBeat.o(371744);
      return locala;
      paramString1 = (anc)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    AppMethodBeat.o(371744);
    return paramString1;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(e parame, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(371619);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.akgk.a(null, 0L, null, (kotlin.d.d)this);
      AppMethodBeat.o(371619);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(String paramString, long paramLong, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(371628);
      paramObject = (kotlin.d.d)new b(this.mHK, paramLong, paramd);
      AppMethodBeat.o(371628);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(371623);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(371623);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (f)bg.kCi();
        m localm = (m)new k(this.mHK, paramLong)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(371625);
            paramAnonymousObject = (kotlin.d.d)new 1(this.mHK, this.mIn, paramAnonymousd);
            AppMethodBeat.o(371625);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(371617);
            a locala = a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(371617);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = bq.akii;
            bq.rQ(e.aUw(), this.mHK + ", loadData " + com.tencent.mm.ae.d.hF(this.mIn));
            paramAnonymousObject = e.akgh;
            paramAnonymousObject = e.kLb();
            e.kLc();
            paramAnonymousObject.putAll(d.Cs(this.mIn));
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(371617);
            return paramAnonymousObject;
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (l.a(paramObject, localm, locald) == locala)
        {
          AppMethodBeat.o(371623);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(371623);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(String paramString, anc paramanc, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(371618);
      paramObject = (kotlin.d.d)new c(this.mHK, paramanc, paramd);
      AppMethodBeat.o(371618);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(371615);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(371615);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (f)bg.kCi();
        m localm = (m)new k(this.mHK, paramanc)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(371638);
            paramAnonymousObject = (kotlin.d.d)new 1(this.mHK, this.akgl, paramAnonymousd);
            AppMethodBeat.o(371638);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(371636);
            Object localObject = a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(371636);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = bq.akii;
            paramAnonymousObject = e.aUw();
            localObject = new StringBuilder().append(this.mHK).append(", saveData ");
            bq localbq = bq.akii;
            bq.rQ(paramAnonymousObject, bq.c(this.akgl));
            e.kLc();
            d.a(this.akgl);
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(371636);
            return paramAnonymousObject;
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (l.a(paramObject, localm, locald) == locala)
        {
          AppMethodBeat.o(371615);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(371615);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(String paramString, long paramLong, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(371616);
      paramObject = (kotlin.d.d)new d(this.mHK, paramLong, paramd);
      AppMethodBeat.o(371616);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(371614);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(371614);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (f)bg.kCi();
        m localm = (m)new k(this.mHK, paramLong)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(371737);
            paramAnonymousObject = (kotlin.d.d)new 1(this.mHK, this.mIn, paramAnonymousd);
            AppMethodBeat.o(371737);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(371730);
            a locala = a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(371730);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = bq.akii;
            bq.rQ(e.aUw(), this.mHK + ", saveData " + com.tencent.mm.ae.d.hF(this.mIn));
            e.kLc();
            paramAnonymousObject = e.akgh;
            d.kK((List)e.Cu(this.mIn));
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(371730);
            return paramAnonymousObject;
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (l.a(paramObject, localm, locald) == locala)
        {
          AppMethodBeat.o(371614);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(371614);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.e
 * JD-Core Version:    0.7.0.1
 */