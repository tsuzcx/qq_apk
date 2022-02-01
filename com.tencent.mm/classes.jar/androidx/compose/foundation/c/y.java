package androidx.compose.foundation.c;

import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.a.a;
import androidx.compose.ui.a.c;
import androidx.compose.ui.h.p;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"DefaultRowMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultRowMeasurePolicy$annotations", "()V", "getDefaultRowMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "Row", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rowMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class y
{
  private static final p adB;
  
  static
  {
    AppMethodBeat.i(203928);
    m localm = m.acP;
    Object localObject = a.abN;
    float f = a.mt().mA();
    localObject = i.acA;
    localObject = androidx.compose.ui.a.atD;
    localObject = i.b.a(a.a.sb());
    ac localac = ac.adY;
    adB = w.a(localm, (kotlin.g.a.s)a.adC, f, localac, (i)localObject);
    AppMethodBeat.o(203928);
  }
  
  public static final p a(a.d paramd, a.c paramc, h paramh)
  {
    AppMethodBeat.i(203925);
    kotlin.g.b.s.u(paramd, "horizontalArrangement");
    kotlin.g.b.s.u(paramc, "verticalAlignment");
    paramh.bx(495203611);
    paramh.bx(-3686552);
    boolean bool1 = paramh.G(paramd);
    boolean bool2 = paramh.G(paramc);
    Object localObject2 = paramh.or();
    Object localObject1;
    if (!(bool2 | bool1))
    {
      localObject1 = h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = a.abN;
      if (!kotlin.g.b.s.p(paramd, a.mt())) {
        break label153;
      }
      localObject1 = androidx.compose.ui.a.atD;
      if (!kotlin.g.b.s.p(paramc, a.a.sb())) {
        break label153;
      }
    }
    label153:
    float f;
    for (paramd = adB;; paramd = w.a((m)localObject1, (kotlin.g.a.s)new b(paramd), f, (ac)localObject2, paramc))
    {
      paramh.F(paramd);
      localObject1 = paramd;
      paramh.od();
      paramd = (p)localObject1;
      paramh.od();
      AppMethodBeat.o(203925);
      return paramd;
      localObject1 = m.acP;
      f = paramd.mA();
      localObject2 = i.acA;
      paramc = i.b.a(paramc);
      localObject2 = ac.adY;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "totalSize", "", "size", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "outPosition"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.s<Integer, int[], n, d, int[], ah>
  {
    public static final a adC;
    
    static
    {
      AppMethodBeat.i(203782);
      adC = new a();
      AppMethodBeat.o(203782);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.s<Integer, int[], n, d, int[], ah>
  {
    b(a.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.y
 * JD-Core Version:    0.7.0.1
 */