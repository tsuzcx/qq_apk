package androidx.compose.foundation.c;

import androidx.compose.ui.a;
import androidx.compose.ui.f;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/BoxScopeInstance;", "Landroidx/compose/foundation/layout/BoxScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements d
{
  public static final e acr;
  
  static
  {
    AppMethodBeat.i(203937);
    acr = new e();
    AppMethodBeat.o(203937);
  }
  
  public final f a(f paramf, a parama)
  {
    AppMethodBeat.i(203942);
    s.u(paramf, "<this>");
    s.u(parama, "alignment");
    if (ab.zi()) {}
    for (kotlin.g.a.b localb = (kotlin.g.a.b)new a(parama);; localb = ab.zh())
    {
      paramf = paramf.a((f)new b(parama, localb));
      AppMethodBeat.o(203942);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements kotlin.g.a.b<ad, ah>
  {
    public a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.e
 * JD-Core Version:    0.7.0.1
 */