package androidx.compose.ui.h;

import androidx.compose.runtime.aa;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.br;
import androidx.compose.runtime.g;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.k;
import androidx.compose.runtime.p;
import androidx.compose.runtime.x;
import androidx.compose.runtime.y;
import androidx.compose.ui.e;
import androidx.compose.ui.i.a.a;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"SubcomposeLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "state", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ae
{
  public static final void a(androidx.compose.ui.f paramf, final m<? super ag, ? super androidx.compose.ui.n.b, ? extends q> paramm, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(205573);
    s.u(paramm, "measurePolicy");
    h localh = paramh.by(-607851786);
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label289:
    label292:
    label295:
    for (int i = paramInt1 | i;; i = paramInt1)
    {
      int j;
      if ((paramInt2 & 0x2) != 0)
      {
        j = 48;
        label49:
        i |= j;
      }
      for (;;)
      {
        if (((i & 0x5B ^ 0x12) != 0) || (!localh.nZ()))
        {
          if ((paramInt2 & 0x1) == 0) {
            break label289;
          }
          paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        }
        for (;;)
        {
          localh.bx(-3687241);
          Object localObject = localh.or();
          paramh = h.alD;
          paramh = localObject;
          if (localObject == h.a.ox())
          {
            paramh = new af();
            localh.F(paramh);
          }
          localh.od();
          a((af)paramh, paramf, paramm, localh, i << 3 & 0x70 | 0x8 | i << 3 & 0x380, 0);
          for (;;)
          {
            paramh = localh.oh();
            if (paramh != null) {
              paramh.b((m)new b(paramf, paramm, paramInt1, paramInt2));
            }
            AppMethodBeat.o(205573);
            return;
            if ((paramInt1 & 0xE) != 0) {
              break label295;
            }
            if (localh.G(paramf))
            {
              i = 4;
              break;
            }
            i = 2;
            break;
            if ((paramInt1 & 0x70) != 0) {
              break label292;
            }
            if (localh.G(paramm))
            {
              j = 32;
              break label49;
            }
            j = 16;
            break label49;
            localh.oi();
          }
        }
      }
    }
  }
  
  public static final void a(af paramaf, final androidx.compose.ui.f paramf, final m<? super ag, ? super androidx.compose.ui.n.b, ? extends q> paramm, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(205581);
    s.u(paramaf, "state");
    s.u(paramm, "measurePolicy");
    paramh = paramh.by(-607850367);
    if ((paramInt2 & 0x2) != 0) {
      paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
    }
    for (;;)
    {
      paramaf.aNk = g.m(paramh);
      aa.a(paramaf, (kotlin.g.a.b)new c(paramaf), paramh);
      Object localObject2 = e.a(paramh, paramf);
      Object localObject1 = (androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU());
      n localn = (n)paramh.a((p)androidx.compose.ui.platform.u.yW());
      Object localObject3 = androidx.compose.ui.i.f.aOe;
      localObject3 = androidx.compose.ui.i.f.xM();
      paramh.bx(-2103251527);
      if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
        g.nW();
      }
      paramh.ok();
      if (paramh.nY()) {
        paramh.a((kotlin.g.a.a)new ae.a((kotlin.g.a.a)localObject3));
      }
      for (;;)
      {
        s.u(paramh, "composer");
        br.a(paramh, paramaf.aNl);
        localObject3 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject2, a.a.xc());
        br.a(paramh, paramm, paramaf.aNm);
        localObject2 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject1, a.a.xd());
        localObject1 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localn, a.a.xf());
        paramh.on();
        paramh.od();
        paramh = paramh.oh();
        if (paramh != null) {
          paramh.b((m)new d(paramaf, paramf, paramm, paramInt1, paramInt2));
        }
        AppMethodBeat.o(205581);
        return;
        paramh.om();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements m<h, Integer, ah>
  {
    b(androidx.compose.ui.f paramf, m<? super ag, ? super androidx.compose.ui.n.b, ? extends q> paramm, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<y, x>
  {
    c(af paramaf)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(af paramaf) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(205673);
        af localaf = this.aNi;
        Iterator localIterator = ((Iterable)localaf.aNo.values()).iterator();
        while (localIterator.hasNext())
        {
          k localk = ((af.a)localIterator.next()).aDs;
          s.checkNotNull(localk);
          localk.dispose();
        }
        localaf.aNo.clear();
        localaf.aNp.clear();
        AppMethodBeat.o(205673);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements m<h, Integer, ah>
  {
    d(af paramaf, androidx.compose.ui.f paramf, m<? super ag, ? super androidx.compose.ui.n.b, ? extends q> paramm, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.ae
 * JD-Core Version:    0.7.0.1
 */