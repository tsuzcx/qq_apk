package androidx.compose.foundation.c;

import androidx.compose.ui.a.c;
import androidx.compose.ui.f;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/RowScopeInstance;", "Landroidx/compose/foundation/layout/RowScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignByBaseline", "weight", "", "fill", "", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  implements z
{
  public static final aa adE;
  
  static
  {
    AppMethodBeat.i(203792);
    adE = new aa();
    AppMethodBeat.o(203792);
  }
  
  public final f a(f paramf, a.c paramc)
  {
    AppMethodBeat.i(203798);
    s.u(paramf, "<this>");
    s.u(paramc, "alignment");
    if (ab.zi()) {}
    for (b localb = (b)new a(paramc);; localb = ab.zh())
    {
      paramf = paramf.a((f)new ag(paramc, localb));
      AppMethodBeat.o(203798);
      return paramf;
    }
  }
  
  public final f b(f paramf)
  {
    AppMethodBeat.i(203795);
    s.u(paramf, "<this>");
    if (ab.zi()) {}
    for (b localb = (b)new b(1.0F, true);; localb = ab.zh())
    {
      paramf = paramf.a((f)new n(1.0F, true, localb));
      AppMethodBeat.o(203795);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements b<ad, ah>
  {
    public a(a.c paramc)
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
 * Qualified Name:     androidx.compose.foundation.c.aa
 * JD-Core Version:    0.7.0.1
 */