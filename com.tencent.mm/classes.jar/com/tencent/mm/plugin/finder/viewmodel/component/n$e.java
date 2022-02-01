package com.tencent.mm.plugin.finder.viewmodel.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.preload.b;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.x;
import kotlinx.coroutines.a.i;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC$PreloadCallback;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC;)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Pair;", "", "", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "onCancel", "", "mediaId", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onReject", "onSuccessfully", "isAllCompleted", "percent", "plugin-finder_release"})
public final class n$e
  implements b
{
  final kotlinx.coroutines.a.g<o<Boolean, String>> xeO;
  
  public n$e()
  {
    AppMethodBeat.i(273410);
    this.xeO = i.aFQ(0);
    AppMethodBeat.o(273410);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.plugin.finder.preload.d paramd)
  {
    AppMethodBeat.i(273403);
    p.k(paramString1, "mediaId");
    p.k(paramString2, "fileFormat");
    p.k(paramString3, "codingFormat");
    p.k(paramd, "task");
    AppMethodBeat.o(273403);
  }
  
  public final void a(final String paramString1, String paramString2, com.tencent.mm.plugin.finder.preload.d paramd)
  {
    AppMethodBeat.i(273406);
    p.k(paramString1, "mediaId");
    p.k(paramString2, "msg");
    p.k(paramd, "task");
    kotlinx.coroutines.g.b(n.a(this.Bjm), null, (m)new a(this, paramString1, null), 3);
    AppMethodBeat.o(273406);
  }
  
  public final void a(final String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.finder.preload.d paramd)
  {
    AppMethodBeat.i(273405);
    p.k(paramString, "mediaId");
    p.k(paramd, "task");
    kotlinx.coroutines.g.b(n.a(this.Bjm), null, (m)new d(this, paramString, null), 3);
    AppMethodBeat.o(273405);
  }
  
  public final void aDB(final String paramString)
  {
    AppMethodBeat.i(273408);
    p.k(paramString, "mediaId");
    kotlinx.coroutines.g.b(n.a(this.Bjm), null, (m)new b(this, paramString, null), 3);
    AppMethodBeat.o(273408);
  }
  
  public final void aDC(final String paramString)
  {
    AppMethodBeat.i(273409);
    p.k(paramString, "mediaId");
    kotlinx.coroutines.g.b(n.a(this.Bjm), null, (m)new c(this, paramString, null), 3);
    AppMethodBeat.o(273409);
  }
  
  public final void dT(String paramString, int paramInt)
  {
    AppMethodBeat.i(273404);
    p.k(paramString, "mediaId");
    AppMethodBeat.o(273404);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    a(n.e parame, String paramString, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(267236);
      p.k(paramd, "completion");
      paramd = new a(this.Bjn, paramString1, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(267236);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(267237);
      paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(267237);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(267235);
      a locala = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(267235);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        kotlinx.coroutines.a.g localg = this.Bjn.xeO;
        o localo = new o(Boolean.FALSE, paramString1);
        this.L$0 = paramObject;
        this.label = 1;
        if (localg.c(localo, this) == locala)
        {
          AppMethodBeat.o(267235);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(267235);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    b(n.e parame, String paramString, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(262842);
      p.k(paramd, "completion");
      paramd = new b(this.Bjn, paramString, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(262842);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(262844);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(262844);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(262839);
      a locala = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(262839);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        kotlinx.coroutines.a.g localg = this.Bjn.xeO;
        o localo = new o(Boolean.FALSE, paramString);
        this.L$0 = paramObject;
        this.label = 1;
        if (localg.c(localo, this) == locala)
        {
          AppMethodBeat.o(262839);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(262839);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    c(n.e parame, String paramString, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(274048);
      p.k(paramd, "completion");
      paramd = new c(this.Bjn, paramString, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(274048);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(274049);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(274049);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(274047);
      a locala = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(274047);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        kotlinx.coroutines.a.g localg = this.Bjn.xeO;
        o localo = new o(Boolean.FALSE, paramString);
        this.L$0 = paramObject;
        this.label = 1;
        if (localg.c(localo, this) == locala)
        {
          AppMethodBeat.o(274047);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(274047);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    d(n.e parame, String paramString, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(282256);
      p.k(paramd, "completion");
      paramd = new d(this.Bjn, paramString, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(282256);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(282257);
      paramObject1 = ((d)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(282257);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(282254);
      a locala = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(282254);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        kotlinx.coroutines.a.g localg = this.Bjn.xeO;
        o localo = new o(Boolean.TRUE, paramString);
        this.L$0 = paramObject;
        this.label = 1;
        if (localg.c(localo, this) == locala)
        {
          AppMethodBeat.o(282254);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(282254);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.n.e
 * JD-Core Version:    0.7.0.1
 */