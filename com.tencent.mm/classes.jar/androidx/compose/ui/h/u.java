package androidx.compose.ui.h;

import androidx.compose.ui.f;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"onGloballyPositioned", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class u
{
  public static final f c(f paramf, b<? super j, ah> paramb)
  {
    AppMethodBeat.i(205655);
    s.u(paramf, "<this>");
    s.u(paramb, "onGloballyPositioned");
    if (ab.zi()) {}
    for (b localb = (b)new a(paramb);; localb = ab.zh())
    {
      paramf = paramf.a((f)new t(paramb, localb));
      AppMethodBeat.o(205655);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends kotlin.g.b.u
    implements b<ad, ah>
  {
    public a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.u
 * JD-Core Version:    0.7.0.1
 */