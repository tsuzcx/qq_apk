package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.c.a.a;
import a.c.b.a.d;
import a.c.b.a.g;
import a.c.c;
import a.f.a.m;
import a.l;
import a.p.b;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.ac;

@d(c="com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$preloadByIdAndUrls$1", f="PreloadLogic.kt", l={1106}, m="invokeSuspend")
@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class PreloadLogic$p
  extends g
  implements m<ac, c<? super y>, Object>
{
  private ac kbW;
  int label;
  
  PreloadLogic$p(List paramList, int paramInt, c paramc)
  {
    super(paramc);
  }
  
  public final c<y> a(Object paramObject, c<?> paramc)
  {
    AppMethodBeat.i(14903);
    a.f.b.j.q(paramc, "completion");
    paramc = new p(this.kcf, this.jSy, paramc);
    paramc.kbW = ((ac)paramObject);
    AppMethodBeat.o(14903);
    return paramc;
  }
  
  public final Object bD(Object paramObject)
  {
    AppMethodBeat.i(14902);
    Object localObject1 = a.BMS;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(14902);
      throw paramObject;
    }
    if ((paramObject instanceof p.b))
    {
      paramObject = ((p.b)paramObject).BLY;
      AppMethodBeat.o(14902);
      throw paramObject;
    }
    localObject1 = this.kcf;
    int j;
    Object localObject2;
    label126:
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    Object localObject9;
    Object localObject10;
    Object localObject11;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label990;
      }
      paramObject = PreloadLogic.kbJ;
      j = PreloadLogic.sp(this.jSy);
      if (j == 0) {
        break label415;
      }
      localObject2 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label415;
      }
      paramObject = (List)((Iterator)localObject2).next();
      localObject3 = h.qsU;
      localObject4 = paramObject.get(2);
      localObject5 = q.encode((String)paramObject.get(0));
      localObject6 = PreloadLogic.kbJ;
      localObject6 = PreloadLogic.a(paramObject, 3, "");
      localObject7 = PreloadLogic.kbJ;
      localObject7 = PreloadLogic.a(paramObject, 4, "");
      localObject8 = paramObject.get(1);
      localObject9 = PreloadLogic.kbJ;
      localObject9 = PreloadLogic.a(paramObject, 5, "");
      localObject10 = PreloadLogic.kbJ;
      localObject10 = PreloadLogic.a(paramObject, 6, "");
      localObject11 = PreloadLogic.kbJ;
      localObject11 = PreloadLogic.a(paramObject, 7, "");
      if (!a.f.b.j.e((String)paramObject.get(1), "-1")) {
        break label405;
      }
      paramObject = (String)paramObject.get(0);
      if (paramObject == null) {
        break label400;
      }
      paramObject = Boolean.valueOf(p.He(paramObject));
      label298:
      if (!paramObject.booleanValue()) {
        break label405;
      }
      i = 1;
      label307:
      if (i == 0) {
        break label410;
      }
    }
    label400:
    label405:
    label410:
    for (int i = 1;; i = 0)
    {
      ((h)localObject3).e(16468, new Object[] { Integer.valueOf(j), localObject4, localObject5, localObject6, localObject7, Integer.valueOf(1), localObject8, localObject9, localObject10, localObject11, Integer.valueOf(i) });
      break label126;
      i = 0;
      break;
      paramObject = null;
      break label298;
      i = 0;
      break label307;
    }
    label415:
    paramObject = PreloadLogic.kbJ;
    if (PreloadLogic.rU(PreloadLogic.sq(this.jSy)))
    {
      j = b.si(this.jSy);
      localObject1 = (Iterable)localObject1;
      paramObject = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label527:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (!p.He((String)((List)localObject2).get(0))) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label527;
          }
          paramObject.add(localObject2);
          break;
        }
      }
      localObject1 = (Iterable)paramObject;
      paramObject = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        localObject3 = ((List)localObject2).get(0);
        localObject4 = PreloadLogic.kbJ;
        paramObject.add(new android.support.v4.e.j(localObject3, Integer.valueOf(PreloadLogic.sm(Integer.parseInt((String)((List)localObject2).get(1))))));
      }
      localObject1 = (Iterable)paramObject;
      paramObject = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label770:
      label773:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (android.support.v4.e.j)localObject2;
        localObject4 = PreloadLogic.kbJ;
        if (p.GI(PreloadLogic.c((android.support.v4.e.j)localObject3)))
        {
          localObject4 = PreloadLogic.kbJ;
          localObject4 = PreloadLogic.aXC();
          localObject5 = PreloadLogic.kbJ;
          localObject5 = PreloadLogic.c((android.support.v4.e.j)localObject3);
          localObject6 = PreloadLogic.kbJ;
          if (!((PreloadLogic.a)localObject4).bM((String)localObject5, PreloadLogic.d((android.support.v4.e.j)localObject3))) {
            break label770;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label773;
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
          localObject1 = new StringBuilder("preloadData preloadByIdAndUrls strip:").append(j).append(" dispatch:");
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
    }
    label990:
    paramObject = y.BMg;
    AppMethodBeat.o(14902);
    return paramObject;
  }
  
  public final Object h(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(14904);
    paramObject1 = ((p)a(paramObject1, (c)paramObject2)).bD(y.BMg);
    AppMethodBeat.o(14904);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.p
 * JD-Core Version:    0.7.0.1
 */