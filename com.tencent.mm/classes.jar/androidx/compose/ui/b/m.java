package androidx.compose.ui.b;

import androidx.compose.ui.a;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.c.c;
import androidx.compose.ui.f;
import androidx.compose.ui.h.d;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"paint", "Landroidx/compose/ui/Modifier;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class m
{
  private static f a(f paramf, c paramc, final boolean paramBoolean, final a parama, final d paramd, final float paramFloat, final aa paramaa)
  {
    AppMethodBeat.i(204830);
    s.u(paramf, "<this>");
    s.u(paramc, "painter");
    s.u(parama, "alignment");
    s.u(paramd, "contentScale");
    if (ab.zi()) {}
    for (b localb = (b)new a(paramc, paramBoolean, parama, paramd, paramFloat, paramaa);; localb = ab.zh())
    {
      paramf = paramf.a((f)new l(paramc, paramBoolean, parama, paramd, paramFloat, paramaa, localb));
      AppMethodBeat.o(204830);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements b<ad, ah>
  {
    public a(c paramc, boolean paramBoolean, a parama, d paramd, float paramFloat, aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.b.m
 * JD-Core Version:    0.7.0.1
 */