package androidx.compose.foundation.c;

import androidx.compose.ui.a.b;
import androidx.compose.ui.f;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/ColumnScopeInstance;", "Landroidx/compose/foundation/layout/ColumnScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "weight", "", "fill", "", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements g
{
  public static final h acw;
  
  static
  {
    AppMethodBeat.i(203949);
    acw = new h();
    AppMethodBeat.o(203949);
  }
  
  public final f a(f paramf, float paramFloat)
  {
    AppMethodBeat.i(203955);
    s.u(paramf, "<this>");
    if (paramFloat > 0.0D) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalArgumentException(("invalid weight " + paramFloat + "; must be greater than zero").toString());
      AppMethodBeat.o(203955);
      throw paramf;
    }
    if (ab.zi()) {}
    for (b localb = (b)new b(paramFloat, true);; localb = ab.zh())
    {
      paramf = paramf.a((f)new n(paramFloat, true, localb));
      AppMethodBeat.o(203955);
      return paramf;
    }
  }
  
  public final f a(f paramf, a.b paramb)
  {
    AppMethodBeat.i(203962);
    s.u(paramf, "<this>");
    s.u(paramb, "alignment");
    if (ab.zi()) {}
    for (b localb = (b)new a(paramb);; localb = ab.zh())
    {
      paramf = paramf.a((f)new l(paramb, localb));
      AppMethodBeat.o(203962);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements b<ad, ah>
  {
    public a(a.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements b<ad, ah>
  {
    public b(float paramFloat, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.h
 * JD-Core Version:    0.7.0.1
 */