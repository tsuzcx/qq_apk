package androidx.compose.foundation;

import androidx.compose.foundation.b.c;
import androidx.compose.runtime.as;
import androidx.compose.runtime.h;
import androidx.compose.ui.e;
import androidx.compose.ui.f;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"LocalIndication", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/Indication;", "getLocalIndication", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "indication", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class m
{
  private static final as<k> YU;
  
  static
  {
    AppMethodBeat.i(203587);
    YU = androidx.compose.runtime.q.e((a)a.YV);
    AppMethodBeat.o(203587);
  }
  
  public static final f a(f paramf, final c paramc, k paramk)
  {
    AppMethodBeat.i(203577);
    s.u(paramf, "<this>");
    s.u(paramc, "interactionSource");
    if (ab.zi()) {}
    for (b localb = (b)new b(paramk, paramc);; localb = ab.zh())
    {
      paramf = e.a(paramf, localb, (kotlin.g.a.q)new c(paramk, paramc));
      AppMethodBeat.o(203577);
      return paramf;
    }
  }
  
  public static final as<k> mj()
  {
    return YU;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/foundation/Indication;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<k>
  {
    public static final a YV;
    
    static
    {
      AppMethodBeat.i(203645);
      YV = new a();
      AppMethodBeat.o(203645);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements b<ad, ah>
  {
    public b(k paramk, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.q<f, h, Integer, f>
  {
    c(k paramk, c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.m
 * JD-Core Version:    0.7.0.1
 */