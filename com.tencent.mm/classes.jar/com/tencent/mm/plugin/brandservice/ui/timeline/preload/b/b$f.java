package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;

@f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.resdownload.LocalTmplInfoManager$downloadTmpl$1", f="LocalTmplInfoManager.kt", hxM={588}, m="invokeSuspend")
@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class b$f
  extends j
  implements m<ai, d<? super x>, Object>
{
  Object L$0;
  int label;
  private ai p$;
  Object pED;
  Object pEE;
  
  b$f(eib parameib, int paramInt, kotlin.g.a.a parama, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(6836);
    p.h(paramd, "completion");
    paramd = new f(this.pFy, this.pmo, this.kPs, paramd);
    paramd.p$ = ((ai)paramObject);
    AppMethodBeat.o(6836);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(6837);
    paramObject1 = ((f)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
    AppMethodBeat.o(6837);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(6835);
    kotlin.d.a.a locala = kotlin.d.a.a.SXO;
    int i;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(6835);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this.p$;
      paramObject = new HashMap();
      localObject1 = this.pFy.KUA;
      Object localObject3 = this.pFy.Nhn;
      p.g(localObject3, "tmplInfo.HttpHeaderList");
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (eia)((Iterator)localObject3).next();
        Object localObject5 = (CharSequence)((eia)localObject4).xMX;
        if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
        {
          i = 1;
          if (i != 0) {
            continue;
          }
          localObject5 = (CharSequence)((eia)localObject4).Cyk;
          if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
            break label246;
          }
        }
        for (i = 1; i == 0; i = 0)
        {
          localObject5 = (Map)paramObject;
          String str = ((eia)localObject4).xMX;
          p.g(str, "it.Key");
          localObject4 = ((eia)localObject4).Cyk;
          p.g(localObject4, "it.Value");
          ((Map)localObject5).put(str, localObject4);
          break;
          i = 0;
          break label157;
        }
      }
      if (!this.pFy.Nho) {
        break label404;
      }
      localObject3 = b.pFr;
      p.g(localObject1, "downloadUrl");
      this.L$0 = localObject2;
      this.pED = paramObject;
      this.pEE = localObject1;
      this.label = 1;
      localObject2 = b.a((String)localObject1, paramObject, this);
      localObject1 = localObject2;
      if (localObject2 == locala)
      {
        AppMethodBeat.o(6835);
        return locala;
      }
      break;
    case 1: 
      label157:
      label246:
      localObject2 = (HashMap)this.pED;
      ResultKt.throwOnFailure(paramObject);
      localObject1 = paramObject;
      paramObject = localObject2;
    }
    Object localObject1 = (String)localObject1;
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      label366:
      if (i != 0) {
        break label412;
      }
      localObject2 = b.pFr;
      b.a((String)localObject1, this.pFy, paramObject, this.pmo, this.kPs);
    }
    for (;;)
    {
      paramObject = x.SXb;
      AppMethodBeat.o(6835);
      return paramObject;
      label404:
      break;
      i = 0;
      break label366;
      label412:
      paramObject = new StringBuilder("url is null or empty:");
      localObject1 = b.pFr;
      Log.e("MicroMsg.Preload.TmplInfoManager", b.m(this.pFy));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.f
 * JD-Core Version:    0.7.0.1
 */