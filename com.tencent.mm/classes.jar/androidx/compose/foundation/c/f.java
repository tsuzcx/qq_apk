package androidx.compose.foundation.c;

import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.a.a;
import androidx.compose.ui.a.b;
import androidx.compose.ui.h.p;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"DefaultColumnMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultColumnMeasurePolicy$annotations", "()V", "getDefaultColumnMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "Column", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final p act;
  
  static
  {
    AppMethodBeat.i(203967);
    m localm = m.acQ;
    Object localObject = a.abN;
    float f = a.mw().mA();
    localObject = i.acA;
    localObject = androidx.compose.ui.a.atD;
    localObject = i.b.a(a.a.sd());
    ac localac = ac.adY;
    act = w.a(localm, (kotlin.g.a.s)a.acu, f, localac, (i)localObject);
    AppMethodBeat.o(203967);
  }
  
  public static final p a(a.l paraml, a.b paramb, h paramh)
  {
    AppMethodBeat.i(203957);
    kotlin.g.b.s.u(paraml, "verticalArrangement");
    kotlin.g.b.s.u(paramb, "horizontalAlignment");
    paramh.bx(1466279149);
    paramh.bx(-3686552);
    boolean bool1 = paramh.G(paraml);
    boolean bool2 = paramh.G(paramb);
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
      if (!kotlin.g.b.s.p(paraml, a.mw())) {
        break label153;
      }
      localObject1 = androidx.compose.ui.a.atD;
      if (!kotlin.g.b.s.p(paramb, a.a.sd())) {
        break label153;
      }
    }
    label153:
    float f;
    for (paraml = act;; paraml = w.a((m)localObject1, (kotlin.g.a.s)new b(paraml), f, (ac)localObject2, paramb))
    {
      paramh.F(paraml);
      localObject1 = paraml;
      paramh.od();
      paraml = (p)localObject1;
      paramh.od();
      AppMethodBeat.o(203957);
      return paraml;
      localObject1 = m.acQ;
      f = paraml.mA();
      localObject2 = i.acA;
      paramb = i.b.a(paramb);
      localObject2 = ac.adY;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "totalSize", "", "size", "", "<anonymous parameter 2>", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "outPosition"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.s<Integer, int[], n, d, int[], ah>
  {
    public static final a acu;
    
    static
    {
      AppMethodBeat.i(203783);
      acu = new a();
      AppMethodBeat.o(203783);
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
    b(a.l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.f
 * JD-Core Version:    0.7.0.1
 */