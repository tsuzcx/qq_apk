package androidx.compose.foundation.c;

import androidx.compose.ui.f;
import androidx.compose.ui.n.n;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"PaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "all", "Landroidx/compose/ui/unit/Dp;", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "horizontal", "vertical", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "start", "top", "end", "bottom", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "Landroidx/compose/ui/Modifier;", "left", "right", "absolutePadding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "calculateEndPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateStartPadding", "padding", "paddingValues", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "padding-qDBjuR0", "foundation-layout_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final t C(float paramFloat)
  {
    AppMethodBeat.i(203965);
    t localt = (t)new u(paramFloat, paramFloat, paramFloat, paramFloat, (byte)0);
    AppMethodBeat.o(203965);
    return localt;
  }
  
  public static final float a(t paramt, n paramn)
  {
    AppMethodBeat.i(203960);
    kotlin.g.b.s.u(paramt, "<this>");
    kotlin.g.b.s.u(paramn, "layoutDirection");
    if (paramn == n.beP)
    {
      f = paramt.b(paramn);
      AppMethodBeat.o(203960);
      return f;
    }
    float f = paramt.a(paramn);
    AppMethodBeat.o(203960);
    return f;
  }
  
  public static final f a(f paramf, float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(203939);
    kotlin.g.b.s.u(paramf, "$this$padding");
    if (ab.zi()) {}
    for (b localb = (b)new c(paramFloat1, paramFloat2);; localb = ab.zh())
    {
      paramf = paramf.a((f)new s(paramFloat1, paramFloat2, paramFloat1, paramFloat2, localb, (byte)0));
      AppMethodBeat.o(203939);
      return paramf;
    }
  }
  
  public static final f a(f paramf, t paramt)
  {
    AppMethodBeat.i(203953);
    kotlin.g.b.s.u(paramf, "<this>");
    kotlin.g.b.s.u(paramt, "paddingValues");
    if (ab.zi()) {}
    for (b localb = (b)new a(paramt);; localb = ab.zh())
    {
      paramf = paramf.a((f)new v(paramt, localb));
      AppMethodBeat.o(203953);
      return paramf;
    }
  }
  
  public static final f c(f paramf, float paramFloat)
  {
    AppMethodBeat.i(203948);
    kotlin.g.b.s.u(paramf, "$this$padding");
    if (ab.zi()) {}
    for (b localb = (b)new b(paramFloat);; localb = ab.zh())
    {
      paramf = paramf.a((f)new s(paramFloat, paramFloat, paramFloat, paramFloat, localb, (byte)0));
      AppMethodBeat.o(203948);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends kotlin.g.b.u
    implements b<ad, ah>
  {
    public a(t paramt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends kotlin.g.b.u
    implements b<ad, ah>
  {
    public b(float paramFloat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends kotlin.g.b.u
    implements b<ad, ah>
  {
    public c(float paramFloat1, float paramFloat2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends kotlin.g.b.u
    implements b<ad, ah>
  {
    public d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.r
 * JD-Core Version:    0.7.0.1
 */