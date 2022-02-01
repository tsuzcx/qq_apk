package androidx.compose.foundation.c;

import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.br;
import androidx.compose.runtime.g;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.f;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.h.x;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.n.b.a;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"DefaultBoxMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultBoxMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "EmptyBoxMeasurePolicy", "getEmptyBoxMeasurePolicy", "boxChildData", "Landroidx/compose/foundation/layout/BoxChildData;", "Landroidx/compose/ui/layout/Measurable;", "getBoxChildData", "(Landroidx/compose/ui/layout/Measurable;)Landroidx/compose/foundation/layout/BoxChildData;", "matchesParentSize", "", "getMatchesParentSize", "(Landroidx/compose/ui/layout/Measurable;)Z", "Box", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "boxMeasurePolicy", "alignment", "rememberBoxMeasurePolicy", "(Landroidx/compose/ui/Alignment;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "placeInBox", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "measurable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "boxWidth", "", "boxHeight", "foundation-layout_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final androidx.compose.ui.h.p acd;
  private static final androidx.compose.ui.h.p ace;
  
  static
  {
    AppMethodBeat.i(204028);
    androidx.compose.ui.a.a locala = androidx.compose.ui.a.atD;
    acd = a(androidx.compose.ui.a.a.rU(), false);
    ace = (androidx.compose.ui.h.p)b.acf;
    AppMethodBeat.o(204028);
  }
  
  private static final b a(o paramo)
  {
    AppMethodBeat.i(204012);
    paramo = paramo.wI();
    if ((paramo instanceof b))
    {
      paramo = (b)paramo;
      AppMethodBeat.o(204012);
      return paramo;
    }
    AppMethodBeat.o(204012);
    return null;
  }
  
  private static androidx.compose.ui.h.p a(final androidx.compose.ui.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(203990);
    s.u(parama, "alignment");
    parama = (androidx.compose.ui.h.p)new c(paramBoolean, parama);
    AppMethodBeat.o(203990);
    return parama;
  }
  
  public static final androidx.compose.ui.h.p a(androidx.compose.ui.a parama, boolean paramBoolean, h paramh)
  {
    AppMethodBeat.i(203981);
    s.u(parama, "alignment");
    paramh.bx(2076429144);
    paramh.bx(-3686930);
    boolean bool = paramh.G(parama);
    Object localObject2 = paramh.or();
    Object localObject1;
    if (!bool)
    {
      localObject1 = h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = androidx.compose.ui.a.atD;
      if ((!s.p(parama, androidx.compose.ui.a.a.rU())) || (paramBoolean)) {
        break label122;
      }
    }
    label122:
    for (parama = acd;; parama = a(parama, paramBoolean))
    {
      paramh.F(parama);
      localObject1 = parama;
      paramh.od();
      parama = (androidx.compose.ui.h.p)localObject1;
      paramh.od();
      AppMethodBeat.o(203981);
      return parama;
    }
  }
  
  public static final void a(f paramf, h paramh, final int paramInt)
  {
    AppMethodBeat.i(204004);
    s.u(paramf, "modifier");
    paramh = paramh.by(-1990469439);
    int i;
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramf))
      {
        i = 4;
        i |= paramInt;
      }
    }
    for (;;)
    {
      if (((i & 0xB ^ 0x2) != 0) || (!paramh.nZ()))
      {
        Object localObject3 = ace;
        paramh.bx(1376089335);
        Object localObject1 = (androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
        n localn = (n)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
        Object localObject2 = androidx.compose.ui.i.a.aNC;
        Object localObject4 = androidx.compose.ui.i.a.a.xb();
        localObject2 = androidx.compose.ui.h.m.i(paramf);
        i = (i << 3 & 0x70 | 0x180) << 9 & 0x1C00;
        if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
          g.nW();
        }
        paramh.ol();
        if (paramh.nY())
        {
          paramh.a((kotlin.g.a.a)localObject4);
          label180:
          paramh.op();
          s.u(paramh, "composer");
          localObject4 = androidx.compose.ui.i.a.aNC;
          br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xe());
          localObject3 = androidx.compose.ui.i.a.aNC;
          br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xd());
          localObject1 = androidx.compose.ui.i.a.aNC;
          br.a(paramh, localn, androidx.compose.ui.i.a.a.xf());
          paramh.oq();
          s.u(paramh, "composer");
          ((kotlin.g.a.q)localObject2).invoke(bc.p(paramh), paramh, Integer.valueOf(i >> 3 & 0x70));
          paramh.bx(2058660585);
          paramh.bx(-1253624692);
          if (((i >> 9 & 0xE & 0xB ^ 0x2) == 0) && (paramh.nZ())) {
            paramh.oi();
          }
          paramh.od();
          paramh.od();
          paramh.on();
          paramh.od();
        }
      }
      for (;;)
      {
        paramh = paramh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new a(paramf, paramInt));
        }
        AppMethodBeat.o(204004);
        return;
        i = 2;
        break;
        paramh.om();
        break label180;
        paramh.oi();
      }
      i = paramInt;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    a(f paramf, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "<anonymous parameter 0>", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    implements androidx.compose.ui.h.p
  {
    public static final b acf;
    
    static
    {
      AppMethodBeat.i(203866);
      acf = new b();
      AppMethodBeat.o(203866);
    }
    
    public final androidx.compose.ui.h.q a(r paramr, List<? extends o> paramList, long paramLong)
    {
      AppMethodBeat.i(203874);
      s.u(paramr, "$this$MeasurePolicy");
      s.u(paramList, "$noName_0");
      paramr = r.a.a(paramr, androidx.compose.ui.n.b.aT(paramLong), androidx.compose.ui.n.b.aV(paramLong), (kotlin.g.a.b)c.b.a.acg);
      AppMethodBeat.o(203874);
      return paramr;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    implements androidx.compose.ui.h.p
  {
    c(boolean paramBoolean, androidx.compose.ui.a parama) {}
    
    public final androidx.compose.ui.h.q a(final r paramr, final List<? extends o> paramList, long paramLong)
    {
      AppMethodBeat.i(203853);
      s.u(paramr, "$this$MeasurePolicy");
      s.u(paramList, "measurables");
      if (paramList.isEmpty())
      {
        paramr = r.a.a(paramr, androidx.compose.ui.n.b.aT(paramLong), androidx.compose.ui.n.b.aV(paramLong), (kotlin.g.a.b)c.c.a.aci);
        AppMethodBeat.o(203853);
        return paramr;
      }
      long l;
      if (this.ach)
      {
        l = paramLong;
        if (paramList.size() != 1) {
          break label219;
        }
        localObject1 = (o)paramList.get(0);
        if (c.b((o)localObject1)) {
          break label181;
        }
        paramList = ((o)localObject1).aw(l);
        i = Math.max(androidx.compose.ui.n.b.aT(paramLong), paramList.width);
        j = Math.max(androidx.compose.ui.n.b.aV(paramLong), paramList.height);
      }
      for (;;)
      {
        paramr = r.a.a(paramr, i, j, (kotlin.g.a.b)new b(paramList, (o)localObject1, paramr, i, j, parama));
        AppMethodBeat.o(203853);
        return paramr;
        l = androidx.compose.ui.n.b.a(paramLong, 0, 0, 0, 0, 10);
        break;
        label181:
        i = androidx.compose.ui.n.b.aT(paramLong);
        j = androidx.compose.ui.n.b.aV(paramLong);
        paramList = androidx.compose.ui.n.b.beE;
        paramList = ((o)localObject1).aw(b.a.ak(androidx.compose.ui.n.b.aT(paramLong), androidx.compose.ui.n.b.aV(paramLong)));
      }
      label219:
      Object localObject1 = new x[paramList.size()];
      final int i = 0;
      final ah.d locald1 = new ah.d();
      locald1.aixb = androidx.compose.ui.n.b.aT(paramLong);
      final ah.d locald2 = new ah.d();
      locald2.aixb = androidx.compose.ui.n.b.aV(paramLong);
      final int j = 0;
      int m = paramList.size() - 1;
      if (m >= 0) {
        i = 0;
      }
      for (;;)
      {
        int k = j + 1;
        Object localObject2 = (o)paramList.get(j);
        if (!c.b((o)localObject2))
        {
          localObject2 = ((o)localObject2).aw(l);
          localObject1[j] = localObject2;
          locald1.aixb = Math.max(locald1.aixb, ((x)localObject2).width);
          locald2.aixb = Math.max(locald2.aixb, ((x)localObject2).height);
          if (k <= m) {
            break label569;
          }
          if (i != 0)
          {
            if (locald1.aixb == 2147483647) {
              break label550;
            }
            i = locald1.aixb;
            label400:
            if (locald2.aixb == 2147483647) {
              break label556;
            }
            j = locald2.aixb;
            label417:
            paramLong = androidx.compose.ui.n.c.k(i, locald1.aixb, j, locald2.aixb);
            k = paramList.size() - 1;
            if (k < 0) {}
          }
        }
        for (i = 0;; i = j)
        {
          j = i + 1;
          localObject2 = (o)paramList.get(i);
          if (c.b((o)localObject2)) {
            localObject1[i] = ((o)localObject2).aw(paramLong);
          }
          if (j > k)
          {
            paramr = r.a.a(paramr, locald1.aixb, locald2.aixb, (kotlin.g.a.b)new c((x[])localObject1, paramList, paramr, locald1, locald2, parama));
            AppMethodBeat.o(203853);
            return paramr;
            i = 1;
            break;
            label550:
            i = 0;
            break label400;
            label556:
            j = 0;
            break label417;
          }
        }
        label569:
        j = k;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.b<x.a, ah>
    {
      b(x paramx, o paramo, r paramr, int paramInt1, int paramInt2, androidx.compose.ui.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.g.b.u
      implements kotlin.g.a.b<x.a, ah>
    {
      c(x[] paramArrayOfx, List<? extends o> paramList, r paramr, ah.d paramd1, ah.d paramd2, androidx.compose.ui.a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.c
 * JD-Core Version:    0.7.0.1
 */