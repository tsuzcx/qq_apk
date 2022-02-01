package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.au;

@f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController$notifyPageInfo$2", f="MpWebViewController.kt", hxM={432}, m="invokeSuspend")
@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class MpWebViewController$q
  extends j
  implements m<ai, d<? super x>, Object>
{
  Object L$0;
  int label;
  private ai p$;
  
  MpWebViewController$q(MpWebViewController paramMpWebViewController, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(195810);
    p.h(paramd, "completion");
    paramd = new q(this.pGh, paramd);
    paramd.p$ = ((ai)paramObject);
    AppMethodBeat.o(195810);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(195811);
    paramObject1 = ((q)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
    AppMethodBeat.o(195811);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(195809);
    a locala = a.SXO;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(195809);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      this.L$0 = this.p$;
      this.label = 1;
      if (au.a(300L, this) == locala)
      {
        AppMethodBeat.o(195809);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    MpWebViewController.b(this.pGh, MpWebViewController.cpm());
    paramObject = x.SXb;
    AppMethodBeat.o(195809);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController.q
 * JD-Core Version:    0.7.0.1
 */