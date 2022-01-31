package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.c.b.a.g;
import a.c.c;
import a.c.e;
import a.c.e.c;
import a.f.a.m;
import a.f.b.x;
import a.p.b;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.bc.a;
import kotlinx.coroutines.bl;
import kotlinx.coroutines.bm;
import kotlinx.coroutines.i;

@a.c.b.a.d(c="com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$addToPreload$1", f="PreloadLogic.kt", l={1005, 1014}, m="invokeSuspend")
@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class PreloadLogic$j
  extends g
  implements m<ac, c<? super y>, Object>
{
  private ac kbW;
  int label;
  
  PreloadLogic$j(long paramLong, String paramString, int paramInt1, Object[] paramArrayOfObject, int paramInt2, c paramc)
  {
    super(paramc);
  }
  
  public final c<y> a(Object paramObject, c<?> paramc)
  {
    AppMethodBeat.i(14883);
    a.f.b.j.q(paramc, "completion");
    paramc = new j(this.kbX, this.jSw, this.jSx, this.kbY, this.jSy, paramc);
    paramc.kbW = ((ac)paramObject);
    AppMethodBeat.o(14883);
    return paramc;
  }
  
  public final Object bD(Object arg1)
  {
    AppMethodBeat.i(14882);
    Object localObject4 = a.c.a.a.BMS;
    Object localObject5;
    int i;
    Object localObject6;
    switch (this.label)
    {
    default: 
      ??? = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(14882);
      throw ???;
    case 0: 
      if ((??? instanceof p.b))
      {
        ??? = ((p.b)???).BLY;
        AppMethodBeat.o(14882);
        throw ???;
      }
      ??? = PreloadLogic.kbJ;
      synchronized (PreloadLogic.aXJ())
      {
        Object localObject1 = PreloadLogic.kbJ;
        PreloadLogic.ia(this.kbX);
        localObject1 = PreloadLogic.kbJ;
        localObject1 = PreloadLogic.aXJ();
        localObject5 = new x(3);
        ((x)localObject5).add(this.jSw);
        ((x)localObject5).add(Integer.valueOf(this.jSx));
        ((x)localObject5).dh(this.kbY);
        ((Queue)localObject1).add(a.a.j.V(((x)localObject5).toArray(new Object[((x)localObject5).ceo.size()])));
        this.label = 1;
        if (1000L <= 0L)
        {
          localObject1 = y.BMg;
          if (localObject1 != localObject4) {
            break;
          }
          AppMethodBeat.o(14882);
          return localObject4;
        }
      }
      localObject5 = new kotlinx.coroutines.j(a.c.a.b.c(this));
      ??? = (bc)((kotlinx.coroutines.a)localObject5).BMP.eaV().get((e.c)bc.CIk);
      if (((kotlinx.coroutines.a)localObject5).CHj == null) {}
      for (i = 1; i == 0; i = 0)
      {
        ??? = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(14882);
        throw ???;
      }
      if (??? == null)
      {
        ((kotlinx.coroutines.a)localObject5).CHj = ((ap)bl.CIC);
        localObject6 = (i)localObject5;
        ??? = ((i)localObject6).eaV();
        a.f.b.j.q(???, "receiver$0");
        ??? = ???.get((e.c)a.c.d.BML);
        ??? = ???;
        if (!(??? instanceof aj)) {
          ??? = null;
        }
        ??? = (aj)???;
        ??? = ???;
        if (??? == null) {
          ??? = ah.epF();
        }
        ???.a((i)localObject6);
        if (!((kotlinx.coroutines.a)localObject5).epn()) {
          break label509;
        }
      }
      for (??? = a.c.a.a.BMS;; ??? = ((kotlinx.coroutines.a)localObject5).dX(???))
      {
        ??? = ???;
        if (??? != a.c.a.a.BMS) {
          break;
        }
        a.f.b.j.q(this, "frame");
        ??? = ???;
        break;
        ???.start();
        ??? = bc.a.a(???, true, false, (a.f.a.b)new kotlinx.coroutines.l(???, (kotlinx.coroutines.a)localObject5), 2);
        ((kotlinx.coroutines.a)localObject5).CHj = ???;
        if (!(((kotlinx.coroutines.a)localObject5).CHh instanceof bm)) {}
        for (i = 1; i != 0; i = 0)
        {
          ???.dispose();
          ((kotlinx.coroutines.a)localObject5).CHj = ((ap)bl.CIC);
          break;
        }
        ??? = ((kotlinx.coroutines.a)localObject5).CHh;
        if ((??? instanceof kotlinx.coroutines.q))
        {
          ??? = ((kotlinx.coroutines.q)???).cause;
          AppMethodBeat.o(14882);
          throw ???;
        }
      }
    case 1: 
      label509:
      if ((??? instanceof p.b))
      {
        ??? = ((p.b)???).BLY;
        AppMethodBeat.o(14882);
        throw ???;
      }
      break;
    }
    ??? = PreloadLogic.kbJ;
    for (;;)
    {
      synchronized (PreloadLogic.aXJ())
      {
        ??? = PreloadLogic.kbJ;
        if (PreloadLogic.aXK() == this.kbX)
        {
          ??? = PreloadLogic.kbJ;
          ??? = (Collection)PreloadLogic.aXJ();
          if (??? == null) {
            break label2189;
          }
          if (???.isEmpty()) {
            break label2189;
          }
        }
        else
        {
          ??? = y.BMg;
          AppMethodBeat.o(14882);
          return ???;
        }
        i = 0;
        break label2191;
        ??? = PreloadLogic.kbJ;
        ??? = new ArrayList((Collection)PreloadLogic.aXJ());
        localObject4 = PreloadLogic.kbJ;
        PreloadLogic.aXJ().clear();
        if ((!bp.dud()) || (ab.getLogLevel() != 0)) {
          break label853;
        }
        if (((Collection)???).isEmpty())
        {
          i = 1;
          if (i != 0) {
            break label853;
          }
          ??? = PreloadLogic.kbJ;
          ??? = PreloadLogic.aXI();
          localObject4 = new StringBuilder("preloadData addToPreload batch:#").append(this.kbX).append(',');
          localObject6 = (Iterable)???;
          localObject5 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject6));
          localObject6 = ((Iterable)localObject6).iterator();
          if (!((Iterator)localObject6).hasNext()) {
            break label835;
          }
          ((Collection)localObject5).add(b.GR(((List)((Iterator)localObject6).next()).get(0).toString()));
        }
      }
      i = 0;
      continue;
      label835:
      ab.v((String)???, (List)localObject5);
      label853:
      ??? = y.BMg;
      ??? = (Iterable)a.a.j.l((Iterable)???);
      ??? = (Collection)new ArrayList();
      ??? = ((Iterable)???).iterator();
      label956:
      while (((Iterator)???).hasNext())
      {
        localObject4 = ((Iterator)???).next();
        localObject5 = (List)localObject4;
        if ((localObject5 != null) && ((((List)localObject5).get(0) instanceof String))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label956;
          }
          ???.add(localObject4);
          break;
        }
      }
      localObject4 = (Iterable)???;
      ??? = new HashSet();
      ??? = new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        localObject6 = ((List)localObject5).get(0);
        if (localObject6 == null)
        {
          ??? = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(14882);
          throw ???;
        }
        if (???.add(b.GR((String)localObject6))) {
          ((ArrayList)???).add(localObject5);
        }
      }
      ??? = (List)???;
      if (!((List)???).isEmpty())
      {
        ??? = PreloadLogic.kbJ;
        int j = PreloadLogic.sp(this.jSy);
        Object localObject7;
        Object localObject8;
        if (j != 0)
        {
          localObject4 = ((Iterable)???).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            ??? = (List)((Iterator)localObject4).next();
            localObject5 = h.qsU;
            localObject6 = PreloadLogic.kbJ;
            localObject6 = PreloadLogic.a(???, 2, "");
            localObject7 = ???.get(0);
            if (localObject7 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(14882);
              throw ???;
            }
            localObject7 = com.tencent.mm.compatible.util.q.encode((String)localObject7);
            localObject8 = PreloadLogic.kbJ;
            localObject8 = PreloadLogic.a(???, 3, "");
            Object localObject9 = PreloadLogic.kbJ;
            localObject9 = PreloadLogic.a(???, 4, "");
            Object localObject10 = ???.get(1);
            Object localObject11 = PreloadLogic.kbJ;
            localObject11 = PreloadLogic.a(???, 5, "");
            Object localObject12 = PreloadLogic.kbJ;
            localObject12 = PreloadLogic.a(???, 6, "");
            Object localObject13 = PreloadLogic.kbJ;
            localObject13 = PreloadLogic.a(???, 7, "");
            Object localObject14 = ???.get(1);
            if (localObject14 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(14882);
              throw ???;
            }
            if (((Integer)localObject14).intValue() == -1)
            {
              ??? = ???.get(0);
              if (??? == null)
              {
                ??? = new v("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(14882);
                throw ???;
              }
              ??? = (String)???;
              if (??? != null)
              {
                ??? = Boolean.valueOf(p.He(???));
                label1383:
                if (!???.booleanValue()) {
                  break label1485;
                }
                i = 1;
                label1392:
                if (i == 0) {
                  break label1490;
                }
              }
            }
            label1485:
            label1490:
            for (i = 1;; i = 0)
            {
              ((h)localObject5).e(16468, new Object[] { Integer.valueOf(j), localObject6, localObject7, localObject8, localObject9, Integer.valueOf(2), localObject10, localObject11, localObject12, localObject13, Integer.valueOf(i) });
              break;
              ??? = null;
              break label1383;
              i = 0;
              break label1392;
            }
          }
        }
        ??? = PreloadLogic.kbJ;
        if (PreloadLogic.rU(PreloadLogic.sq(this.jSy)))
        {
          j = b.si(this.jSy);
          ??? = (Iterable)???;
          ??? = (Collection)new ArrayList();
          ??? = ((Iterable)???).iterator();
          label1635:
          while (((Iterator)???).hasNext())
          {
            localObject4 = ((Iterator)???).next();
            localObject5 = ((List)localObject4).get(0);
            if (localObject5 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(14882);
              throw ???;
            }
            if (!p.He((String)localObject5)) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1635;
              }
              ???.add(localObject4);
              break;
            }
          }
          ??? = (Iterable)???;
          ??? = (Collection)new ArrayList(a.a.j.d((Iterable)???));
          ??? = ((Iterable)???).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject4 = (List)((Iterator)???).next();
            localObject5 = ((List)localObject4).get(0);
            if (localObject5 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(14882);
              throw ???;
            }
            localObject5 = (String)localObject5;
            localObject6 = PreloadLogic.kbJ;
            localObject4 = ((List)localObject4).get(1);
            if (localObject4 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(14882);
              throw ???;
            }
            ???.add(new android.support.v4.e.j(localObject5, Integer.valueOf(PreloadLogic.sm(((Integer)localObject4).intValue()))));
          }
          ??? = (Iterable)???;
          ??? = (Collection)new ArrayList();
          ??? = ((Iterable)???).iterator();
          label1937:
          label1940:
          while (((Iterator)???).hasNext())
          {
            localObject4 = ((Iterator)???).next();
            localObject5 = (android.support.v4.e.j)localObject4;
            localObject6 = PreloadLogic.kbJ;
            if (p.GI(PreloadLogic.c((android.support.v4.e.j)localObject5)))
            {
              localObject6 = PreloadLogic.kbJ;
              localObject6 = PreloadLogic.aXC();
              localObject7 = PreloadLogic.kbJ;
              localObject7 = PreloadLogic.c((android.support.v4.e.j)localObject5);
              localObject8 = PreloadLogic.kbJ;
              if (!((PreloadLogic.a)localObject6).bM((String)localObject7, PreloadLogic.d((android.support.v4.e.j)localObject5))) {
                break label1937;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1940;
              }
              ???.add(localObject4);
              break;
            }
          }
          ??? = (List)???;
          int k = Math.max(???.size() - j, 0);
          localObject4 = a.a.j.a((Iterable)???, j);
          if (!((Collection)localObject4).isEmpty()) {
            i = 1;
          }
          while (i != 0)
          {
            ??? = PreloadLogic.kbJ;
            PreloadLogic.a((List)localObject4, this.jSy, k, 2);
            if (ab.getLogLevel() == 0)
            {
              ??? = PreloadLogic.kbJ;
              ??? = PreloadLogic.aXI();
              ??? = new StringBuilder("preloadData addToPreload strip:").append(j).append(" dispatch:#").append(this.kbX).append(',');
              localObject5 = (Iterable)localObject4;
              localObject4 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject5));
              localObject5 = ((Iterable)localObject5).iterator();
              for (;;)
              {
                if (((Iterator)localObject5).hasNext())
                {
                  localObject6 = ((android.support.v4.e.j)((Iterator)localObject5).next()).first;
                  if (localObject6 == null) {
                    a.f.b.j.ebi();
                  }
                  a.f.b.j.p(localObject6, "it.first!!");
                  ((Collection)localObject4).add(b.GR((String)localObject6));
                  continue;
                  i = 0;
                  break;
                }
              }
              ab.v(???, (List)localObject4);
            }
          }
          ??? = y.BMg;
        }
      }
      ??? = y.BMg;
      ??? = y.BMg;
      AppMethodBeat.o(14882);
      return ???;
      label2189:
      i = 1;
      label2191:
      if (i == 0) {}
    }
  }
  
  public final Object h(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(14884);
    paramObject1 = ((j)a(paramObject1, (c)paramObject2)).bD(y.BMg);
    AppMethodBeat.o(14884);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.j
 * JD-Core Version:    0.7.0.1
 */