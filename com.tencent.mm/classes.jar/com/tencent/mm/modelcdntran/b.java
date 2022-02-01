package com.tencent.mm.modelcdntran;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.t;
import kotlinx.coroutines.b.w;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelcdntran/CdnPLCJavaHelper;", "", "()V", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a ozl;
  
  static
  {
    AppMethodBeat.i(237867);
    ozl = new b.a((byte)0);
    AppMethodBeat.o(237867);
  }
  
  public static final <T> com.tencent.mm.g.g a(com.tencent.mm.g.g paramg, final c<T> paramc, final T paramT)
  {
    AppMethodBeat.i(237858);
    s.u(paramg, "taskInfo");
    s.u(paramc, "listener");
    Log.i("MicroMsg.Cdn.CdnPLCJavaHelper", s.X("startCdnDownload taskInfo field_mediaId:", paramg.field_mediaId));
    Object localObject2 = k.bHY();
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.kernel.h.baC().mBP.mBB;
        if (localObject2 != null)
        {
          LifecycleScope.launchDefault$default((LifecycleScope)localObject2, null, (m)new a.b((ab)localObject1, paramc, paramT, null), 1, null);
          AppMethodBeat.o(237858);
          return paramg;
        }
      }
    }
    else
    {
      s.u(paramg, "task");
      w localw = ad.a(0, 0, null, 7);
      localObject1 = (CharSequence)paramg.field_mediaId;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label176;
        }
        localObject1 = e.ozJ;
        ((a)localObject2).a(localw, e.b.a(e.a.ozT, paramg));
        localObject1 = (ab)localw;
        break;
      }
      label176:
      StringBuilder localStringBuilder = new StringBuilder("startDownloadTask ").append(paramg.field_mediaId).append(' ');
      localObject1 = ((a)localObject2).oza;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = Integer.valueOf(((ConcurrentHashMap)localObject1).size()))
      {
        a.Np(localObject1);
        paramg.ihD = false;
        LifecycleScope.launchDefault$default(((a)localObject2).bHH(), null, (m)new a.g((a)localObject2, paramg, localw, null), 1, null);
        localObject1 = t.a(localw);
        break;
      }
    }
    AppMethodBeat.o(237858);
    return null;
  }
  
  public static final <T> String a(String paramString, final c<T> paramc, final T paramT)
  {
    AppMethodBeat.i(237863);
    s.u(paramString, "mediaId");
    s.u(paramc, "listener");
    Log.i("MicroMsg.Cdn.CdnPLCJavaHelper", s.X("cancelDownloadTask taskInfo field_mediaId:", paramString));
    Object localObject1 = k.bHY();
    if (localObject1 == null) {}
    Object localObject2;
    for (localObject1 = null; localObject1 != null; localObject1 = t.a((w)localObject2))
    {
      localObject2 = com.tencent.mm.kernel.h.baC().mBP.mBB;
      if (localObject2 == null) {
        break;
      }
      LifecycleScope.launchDefault$default((LifecycleScope)localObject2, null, (m)new a.a((ab)localObject1, paramc, paramT, null), 1, null);
      AppMethodBeat.o(237863);
      return paramString;
      s.u(paramString, "mediaId");
      localObject2 = ad.a(0, 0, null, 7);
      LifecycleScope.launchDefault$default(((a)localObject1).bHH(), null, (m)new a.c((a)localObject1, paramString, (w)localObject2, null), 1, null);
    }
    AppMethodBeat.o(237863);
    return null;
  }
  
  public static final <T> com.tencent.mm.g.g b(com.tencent.mm.g.g paramg, final c<T> paramc, final T paramT)
  {
    AppMethodBeat.i(237859);
    s.u(paramg, "taskInfo");
    s.u(paramc, "listener");
    Log.i("MicroMsg.Cdn.CdnPLCJavaHelper", s.X("startCdnUpload taskInfo field_mediaId:", paramg.field_mediaId));
    Object localObject2 = k.bHY();
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.kernel.h.baC().mBP.mBB;
        if (localObject2 != null)
        {
          LifecycleScope.launchDefault$default((LifecycleScope)localObject2, null, (m)new a.c((ab)localObject1, paramc, paramT, null), 1, null);
          AppMethodBeat.o(237859);
          return paramg;
        }
      }
    }
    else
    {
      s.u(paramg, "task");
      w localw = ad.a(0, 0, null, 7);
      localObject1 = (CharSequence)paramg.field_mediaId;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label176;
        }
        localObject1 = e.ozJ;
        ((a)localObject2).a(localw, e.b.a(e.a.ozZ, paramg));
        localObject1 = t.a(localw);
        break;
      }
      label176:
      StringBuilder localStringBuilder = new StringBuilder("startUploadTask ").append(paramg.field_mediaId).append(' ');
      localObject1 = ((a)localObject2).oza;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = Integer.valueOf(((ConcurrentHashMap)localObject1).size()))
      {
        a.Np(localObject1);
        paramg.ihD = true;
        LifecycleScope.launchDefault$default(((a)localObject2).bHH(), null, (m)new a.h((a)localObject2, paramg, localw, null), 1, null);
        localObject1 = t.a(localw);
        break;
      }
    }
    AppMethodBeat.o(237859);
    return null;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a$a
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a$a(ab<e> paramab, c<T> paramc, T paramT, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(237851);
      paramObject = (d)new a(this.ozm, paramc, paramT, paramd);
      AppMethodBeat.o(237851);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237847);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237847);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.b.g)this.ozm;
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(paramc, paramT);
        d locald = (d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(237847);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237847);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<e>
    {
      public a(c paramc, Object paramObject) {}
      
      public final Object a(e parame, d<? super ah> paramd)
      {
        AppMethodBeat.i(237823);
        parame = (e)parame;
        this.ozp.onEnd(parame, this.ozq);
        parame = ah.aiuX;
        AppMethodBeat.o(237823);
        return parame;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a$a$a
    implements kotlinx.coroutines.b.h<e>
  {
    public a$a$a(c paramc, Object paramObject) {}
    
    public final Object a(e parame, d<? super ah> paramd)
    {
      AppMethodBeat.i(237823);
      parame = (e)parame;
      this.ozp.onEnd(parame, this.ozq);
      parame = ah.aiuX;
      AppMethodBeat.o(237823);
      return parame;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a$b
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a$b(ab<e> paramab, c<T> paramc, T paramT, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(237837);
      paramObject = (d)new b(this.ozm, paramc, paramT, paramd);
      AppMethodBeat.o(237837);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237830);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237830);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.b.g)this.ozm;
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(paramc, paramT);
        d locald = (d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(237830);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237830);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<e>
    {
      public a(c paramc, Object paramObject) {}
      
      public final Object a(e parame, d<? super ah> paramd)
      {
        AppMethodBeat.i(237812);
        parame = (e)parame;
        this.ozp.onEnd(parame, this.ozq);
        parame = ah.aiuX;
        AppMethodBeat.o(237812);
        return parame;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a$b$a
    implements kotlinx.coroutines.b.h<e>
  {
    public a$b$a(c paramc, Object paramObject) {}
    
    public final Object a(e parame, d<? super ah> paramd)
    {
      AppMethodBeat.i(237812);
      parame = (e)parame;
      this.ozp.onEnd(parame, this.ozq);
      parame = ah.aiuX;
      AppMethodBeat.o(237812);
      return parame;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a$c
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a$c(ab<e> paramab, c<T> paramc, T paramT, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(237838);
      paramObject = (d)new c(this.ozm, paramc, paramT, paramd);
      AppMethodBeat.o(237838);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237829);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237829);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.b.g)this.ozm;
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(paramc, paramT);
        d locald = (d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(237829);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237829);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<e>
    {
      public a(c paramc, Object paramObject) {}
      
      public final Object a(e parame, d<? super ah> paramd)
      {
        AppMethodBeat.i(237832);
        parame = (e)parame;
        this.ozp.onEnd(parame, this.ozq);
        parame = ah.aiuX;
        AppMethodBeat.o(237832);
        return parame;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a$c$a
    implements kotlinx.coroutines.b.h<e>
  {
    public a$c$a(c paramc, Object paramObject) {}
    
    public final Object a(e parame, d<? super ah> paramd)
    {
      AppMethodBeat.i(237832);
      parame = (e)parame;
      this.ozp.onEnd(parame, this.ozq);
      parame = ah.aiuX;
      AppMethodBeat.o(237832);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.b
 * JD-Core Version:    0.7.0.1
 */