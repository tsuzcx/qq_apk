package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.c.b.a.d;
import a.c.c;
import a.f.a.m;
import a.l;
import a.p.b;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.ac;

@d(c="com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$preloadByInfoIdAndBuffer$1", f="PreloadLogic.kt", l={1076}, m="invokeSuspend")
@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class PreloadLogic$q
  extends a.c.b.a.g
  implements m<ac, c<? super y>, Object>
{
  private ac kbW;
  int label;
  
  PreloadLogic$q(int paramInt, List paramList, c paramc)
  {
    super(paramc);
  }
  
  public final c<y> a(Object paramObject, c<?> paramc)
  {
    AppMethodBeat.i(14906);
    a.f.b.j.q(paramc, "completion");
    paramc = new q(this.jSy, this.kcf, paramc);
    paramc.kbW = ((ac)paramObject);
    AppMethodBeat.o(14906);
    return paramc;
  }
  
  public final Object bD(Object paramObject)
  {
    AppMethodBeat.i(14905);
    Object localObject1 = a.c.a.a.BMS;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(14905);
      throw paramObject;
    }
    if ((paramObject instanceof p.b))
    {
      paramObject = ((p.b)paramObject).BLY;
      AppMethodBeat.o(14905);
      throw paramObject;
    }
    int j = b.si(this.jSy);
    paramObject = (Iterable)this.kcf;
    localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramObject.iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      paramObject = (String[])((Iterator)localObject2).next();
      i = Integer.parseInt(paramObject[2]);
      paramObject = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).b(Long.parseLong(paramObject[0]), paramObject[1]).fjy;
      if (i > 0) {
        a.f.b.j.p(paramObject, "it");
      }
      for (paramObject = a.a.j.a((Iterable)paramObject, i);; paramObject = (List)paramObject)
      {
        a.a.j.a((Collection)localObject1, (Iterable)paramObject);
        break;
      }
    }
    localObject1 = (Iterable)localObject1;
    paramObject = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (q)((Iterator)localObject1).next();
      localObject3 = ((q)localObject2).url;
      localObject4 = PreloadLogic.kbJ;
      paramObject.add(new android.support.v4.e.j(localObject3, Integer.valueOf(PreloadLogic.sm(((q)localObject2).type))));
    }
    localObject1 = (Iterable)paramObject;
    paramObject = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label433:
    label436:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (android.support.v4.e.j)localObject2;
      localObject4 = PreloadLogic.kbJ;
      if (p.GI(PreloadLogic.c((android.support.v4.e.j)localObject3)))
      {
        localObject4 = PreloadLogic.kbJ;
        localObject4 = PreloadLogic.aXC();
        Object localObject5 = PreloadLogic.kbJ;
        localObject5 = PreloadLogic.c((android.support.v4.e.j)localObject3);
        PreloadLogic localPreloadLogic = PreloadLogic.kbJ;
        if (!((PreloadLogic.a)localObject4).bM((String)localObject5, PreloadLogic.d((android.support.v4.e.j)localObject3))) {
          break label433;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label436;
        }
        paramObject.add(localObject2);
        break;
      }
    }
    paramObject = (List)paramObject;
    int k = Math.max(paramObject.size() - j, 0);
    localObject2 = a.a.j.a((Iterable)paramObject, j);
    if (!((Collection)localObject2).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      paramObject = PreloadLogic.kbJ;
      PreloadLogic.a((List)localObject2, this.jSy, k, 1);
      if (ab.getLogLevel() == 0)
      {
        paramObject = PreloadLogic.kbJ;
        paramObject = PreloadLogic.aXI();
        localObject1 = new StringBuilder("preloadData preloadByInfoIdAndBuffer strip:").append(j).append(" dispatch:");
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = ((android.support.v4.e.j)((Iterator)localObject3).next()).first;
            if (localObject4 == null) {
              a.f.b.j.ebi();
            }
            a.f.b.j.p(localObject4, "it.first!!");
            ((Collection)localObject2).add(b.GR((String)localObject4));
            continue;
            i = 0;
            break;
          }
        }
        ab.v(paramObject, (List)localObject2);
      }
    }
    paramObject = y.BMg;
    AppMethodBeat.o(14905);
    return paramObject;
  }
  
  public final Object h(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(14907);
    paramObject1 = ((q)a(paramObject1, (c)paramObject2)).bD(y.BMg);
    AppMethodBeat.o(14907);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.q
 * JD-Core Version:    0.7.0.1
 */