package androidx.compose.a;

import androidx.compose.a.a.aj;
import androidx.compose.a.a.at;
import androidx.compose.a.a.at.b;
import androidx.compose.a.a.au.e;
import androidx.compose.foundation.c.e;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.br;
import androidx.compose.runtime.f.r;
import androidx.compose.ui.e.ae;
import androidx.compose.ui.f;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final <T> void a(T paramT, final f paramf, final androidx.compose.a.a.aa<Float> paramaa, final q<? super T, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq, androidx.compose.runtime.h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(203054);
    s.u(paramq, "content");
    androidx.compose.runtime.h localh = paramh.by(-1621451811);
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label51:
    label58:
    label90:
    label609:
    label1253:
    label1260:
    label1390:
    label1393:
    for (final int i = paramInt1 | i;; i = paramInt1)
    {
      int j;
      if ((paramInt2 & 0x2) != 0)
      {
        j = 48;
        j = i | j;
        i = j;
        if ((paramInt2 & 0x4) != 0) {
          i = j | 0x80;
        }
        if ((paramInt2 & 0x8) == 0) {
          break label609;
        }
        j = 3072;
        i |= j;
      }
      for (;;)
      {
        if ((((paramInt2 ^ 0xFFFFFFFF) & 0x4) != 0) || ((i & 0x16DB ^ 0x492) != 0) || (!localh.nZ()))
        {
          if ((paramInt2 & 0x2) != 0) {
            paramf = (f)f.aud;
          }
          if ((paramInt2 & 0x4) == 0) {
            break label1387;
          }
          paramaa = (androidx.compose.a.a.aa)androidx.compose.a.a.h.a(0, null, 7);
        }
        for (;;)
        {
          localh.bx(-3687241);
          Object localObject1 = localh.or();
          paramh = androidx.compose.runtime.h.alD;
          paramh = (androidx.compose.runtime.h)localObject1;
          if (localObject1 == androidx.compose.runtime.h.a.ox())
          {
            paramh = bj.qk();
            localh.F(paramh);
          }
          localh.od();
          r localr = (r)paramh;
          localh.bx(-3687241);
          localObject1 = localh.or();
          paramh = androidx.compose.runtime.h.alD;
          paramh = (androidx.compose.runtime.h)localObject1;
          if (localObject1 == androidx.compose.runtime.h.a.ox())
          {
            paramh = new aj(paramT);
            localh.F(paramh);
          }
          localh.od();
          final Object localObject2 = (aj)paramh;
          if (!s.p(paramT, ((aj)localObject2).lO())) {}
          for (j = 1;; j = 0)
          {
            ((aj)localObject2).Vu.setValue(paramT);
            s.u(localObject2, "transitionState");
            localh.bx(1641303078);
            localh.bx(-3686930);
            boolean bool = localh.G(localObject2);
            localObject1 = localh.or();
            if (!bool)
            {
              paramh = androidx.compose.runtime.h.alD;
              paramh = (androidx.compose.runtime.h)localObject1;
              if (localObject1 != androidx.compose.runtime.h.a.ox()) {}
            }
            else
            {
              paramh = new at((aj)localObject2, null);
              localh.F(paramh);
            }
            localh.od();
            localObject1 = (at)paramh;
            ((at)localObject1).b(((aj)localObject2).lO(), localh, 0);
            androidx.compose.runtime.aa.a(localObject1, (b)new au.e((at)localObject1), localh);
            localh.od();
            if ((j == 0) && (!localr.isEmpty())) {
              break label779;
            }
            localObject2 = (Iterable)localr;
            paramh = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              paramh.add(((g)((Iterator)localObject2).next()).key);
            }
            if ((paramInt1 & 0xE) != 0) {
              break label1393;
            }
            if (localh.G(paramT))
            {
              i = 4;
              break;
            }
            i = 2;
            break;
            j = i;
            if ((paramInt1 & 0x70) != 0) {
              break label58;
            }
            if (localh.G(paramf))
            {
              j = 32;
              break label51;
            }
            j = 16;
            break label51;
            if ((paramInt1 & 0x1C00) != 0) {
              break label1390;
            }
            if (localh.G(paramq))
            {
              j = 2048;
              break label90;
            }
            j = 1024;
            break label90;
          }
          paramh = (List)paramh;
          if (!paramh.contains(paramT))
          {
            paramh = kotlin.a.p.J((Collection)paramh);
            paramh.add(paramT);
            localObject2 = ah.aiuX;
          }
          for (;;)
          {
            localr.clear();
            paramh = ((Iterable)paramh).iterator();
            while (paramh.hasNext())
            {
              localObject2 = paramh.next();
              ((Collection)localr).add(new g(localObject2, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(-985531785, true, new a((at)localObject1, paramaa, localObject2, paramq, i))));
            }
          }
          if (s.p(((aj)localObject2).lN(), ((aj)localObject2).lO())) {
            kotlin.a.p.e((List)localr, (b)new b((aj)localObject2));
          }
          i = i >> 3 & 0xE;
          localh.bx(-1990474327);
          paramh = androidx.compose.ui.a.atD;
          Object localObject3 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, localh);
          localh.bx(1376089335);
          localObject1 = (androidx.compose.ui.n.d)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
          paramh = (n)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
          localObject2 = androidx.compose.ui.i.a.aNC;
          Object localObject4 = androidx.compose.ui.i.a.a.xb();
          localObject2 = androidx.compose.ui.h.m.i(paramf);
          j = (i << 3 & 0x70) << 9 & 0x1C00;
          if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
            androidx.compose.runtime.g.nW();
          }
          localh.ol();
          int k;
          if (localh.nY())
          {
            localh.a((kotlin.g.a.a)localObject4);
            localh.op();
            s.u(localh, "composer");
            localObject4 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject3, androidx.compose.ui.i.a.a.xe());
            localObject3 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject1, androidx.compose.ui.i.a.a.xd());
            localObject1 = androidx.compose.ui.i.a.aNC;
            br.a(localh, paramh, androidx.compose.ui.i.a.a.xf());
            localh.oq();
            s.u(localh, "composer");
            ((q)localObject2).invoke(bc.p(localh), localh, Integer.valueOf(j >> 3 & 0x70));
            localh.bx(2058660585);
            localh.bx(-1253629305);
            if (((j >> 9 & 0xE & 0xB ^ 0x2) == 0) && (localh.nZ())) {
              break label1360;
            }
            paramh = e.acr;
            localh.bx(2072159585);
            if ((((i >> 6 & 0x70 | 0x6) & 0x51 ^ 0x10) == 0) && (localh.nZ())) {
              break label1350;
            }
            paramh = (List)localr;
            i = 0;
            k = paramh.size() - 1;
            if (k < 0) {}
          }
          for (;;)
          {
            j = i + 1;
            localObject1 = (g)paramh.get(i);
            localh.i(-450543710, ((g)localObject1).key);
            ((g)localObject1).SP.invoke(localh, Integer.valueOf(0));
            localh.oe();
            if (j > k)
            {
              localh.od();
              localh.od();
              localh.od();
              localh.on();
              localh.od();
              localh.od();
              for (;;)
              {
                paramh = localh.oh();
                if (paramh != null) {
                  paramh.b((kotlin.g.a.m)new c(paramT, paramf, paramaa, paramq, paramInt1, paramInt2));
                }
                AppMethodBeat.o(203054);
                return;
                localh.om();
                break;
                localh.oi();
                break label1253;
                localh.oi();
                break label1260;
                localh.oi();
              }
            }
            i = j;
          }
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    a(at<T> paramat, androidx.compose.a.a.aa<Float> paramaa, T paramT, q<? super T, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq, int paramInt)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements b<ae, ah>
    {
      a(bm<Float> parambm)
      {
        super();
      }
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements q<at.b<T>, androidx.compose.runtime.h, Integer, androidx.compose.a.a.aa<Float>>
    {
      b(androidx.compose.a.a.aa<Float> paramaa)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements b<g<T>, Boolean>
  {
    b(aj<T> paramaj)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    c(T paramT, f paramf, androidx.compose.a.a.aa<Float> paramaa, q<? super T, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.h
 * JD-Core Version:    0.7.0.1
 */