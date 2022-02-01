package androidx.compose.foundation.c;

import androidx.compose.ui.a;
import androidx.compose.ui.a.a;
import androidx.compose.ui.a.b;
import androidx.compose.ui.a.c;
import androidx.compose.ui.f;
import androidx.compose.ui.n.l;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"FillWholeMaxHeight", "Landroidx/compose/foundation/layout/FillModifier;", "FillWholeMaxSize", "FillWholeMaxWidth", "WrapContentHeightCenter", "Landroidx/compose/foundation/layout/WrapContentModifier;", "WrapContentHeightTop", "WrapContentSizeCenter", "WrapContentSizeTopStart", "WrapContentWidthCenter", "WrapContentWidthStart", "createFillHeightModifier", "fraction", "", "createFillSizeModifier", "createFillWidthModifier", "createWrapContentHeightModifier", "align", "Landroidx/compose/ui/Alignment$Vertical;", "unbounded", "", "createWrapContentSizeModifier", "Landroidx/compose/ui/Alignment;", "createWrapContentWidthModifier", "Landroidx/compose/ui/Alignment$Horizontal;", "defaultMinSize", "Landroidx/compose/ui/Modifier;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "defaultMinSize-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "fillMaxHeight", "fillMaxSize", "fillMaxWidth", "height", "height-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "heightIn", "min", "max", "heightIn-VpY3zN4", "requiredHeight", "requiredHeight-3ABfNKs", "requiredHeightIn", "requiredHeightIn-VpY3zN4", "requiredSize", "size", "requiredSize-3ABfNKs", "width", "requiredSize-VpY3zN4", "requiredSizeIn", "maxWidth", "maxHeight", "requiredSizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "requiredWidth", "requiredWidth-3ABfNKs", "requiredWidthIn", "requiredWidthIn-VpY3zN4", "size-3ABfNKs", "size-VpY3zN4", "sizeIn", "sizeIn-qDBjuR0", "width-3ABfNKs", "widthIn", "widthIn-VpY3zN4", "wrapContentHeight", "wrapContentSize", "wrapContentWidth", "foundation-layout_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ab
{
  private static final k adG;
  private static final k adH;
  private static final k adI;
  private static final ah adJ;
  private static final ah adK;
  private static final ah adL;
  private static final ah adM;
  private static final ah adN;
  private static final ah adO;
  
  static
  {
    AppMethodBeat.i(203891);
    adG = new k(j.acK, 1.0F, (b)new c(1.0F));
    adH = new k(j.acJ, 1.0F, (b)new a(1.0F));
    adI = new k(j.acL, 1.0F, (b)new b(1.0F));
    a.a locala = a.atD;
    adJ = b(a.a.se());
    locala = a.atD;
    adK = b(a.a.sd());
    locala = a.atD;
    adL = b(a.a.sc());
    locala = a.atD;
    adM = b(a.a.sb());
    locala = a.atD;
    adN = a(a.a.rW());
    locala = a.atD;
    adO = a(a.a.rU());
    AppMethodBeat.o(203891);
  }
  
  private static final ah a(a parama)
  {
    AppMethodBeat.i(203887);
    parama = new ah(j.acL, false, (m)new f(parama), parama, (b)new g(parama, false));
    AppMethodBeat.o(203887);
    return parama;
  }
  
  private static final ah b(a.b paramb)
  {
    AppMethodBeat.i(203877);
    paramb = new ah(j.acK, false, (m)new h(paramb), paramb, (b)new i(paramb));
    AppMethodBeat.o(203877);
    return paramb;
  }
  
  private static final ah b(a.c paramc)
  {
    AppMethodBeat.i(203882);
    paramc = new ah(j.acJ, false, (m)new d(paramc), paramc, (b)new e(paramc));
    AppMethodBeat.o(203882);
    return paramc;
  }
  
  public static final f b(f paramf, float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(203830);
    s.u(paramf, "$this$size");
    if (androidx.compose.ui.platform.ab.zi()) {}
    for (b localb = (b)new m(paramFloat1, paramFloat2);; localb = androidx.compose.ui.platform.ab.zh())
    {
      paramf = paramf.a((f)new ad(paramFloat1, paramFloat2, paramFloat1, paramFloat2, localb));
      AppMethodBeat.o(203830);
      return paramf;
    }
  }
  
  public static final f c(f paramf, float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(203864);
    s.u(paramf, "$this$defaultMinSize");
    if (androidx.compose.ui.platform.ab.zi()) {}
    for (b localb = (b)new j(paramFloat1, paramFloat2);; localb = androidx.compose.ui.platform.ab.zh())
    {
      paramf = paramf.a((f)new af(paramFloat1, paramFloat2, localb, (byte)0));
      AppMethodBeat.o(203864);
      return paramf;
    }
  }
  
  public static final f d(f paramf, float paramFloat)
  {
    AppMethodBeat.i(203810);
    s.u(paramf, "$this$width");
    if (androidx.compose.ui.platform.ab.zi()) {}
    for (b localb = (b)new n(paramFloat);; localb = androidx.compose.ui.platform.ab.zh())
    {
      paramf = paramf.a((f)new ad(paramFloat, 0.0F, paramFloat, 0.0F, localb, 10));
      AppMethodBeat.o(203810);
      return paramf;
    }
  }
  
  public static final f e(f paramf, float paramFloat)
  {
    AppMethodBeat.i(203816);
    s.u(paramf, "$this$height");
    if (androidx.compose.ui.platform.ab.zi()) {}
    for (b localb = (b)new k(paramFloat);; localb = androidx.compose.ui.platform.ab.zh())
    {
      paramf = paramf.a((f)new ad(0.0F, paramFloat, 0.0F, paramFloat, localb, 5));
      AppMethodBeat.o(203816);
      return paramf;
    }
  }
  
  public static final f f(f paramf, float paramFloat)
  {
    AppMethodBeat.i(203820);
    s.u(paramf, "$this$size");
    if (androidx.compose.ui.platform.ab.zi()) {}
    for (b localb = (b)new l(paramFloat);; localb = androidx.compose.ui.platform.ab.zh())
    {
      paramf = paramf.a((f)new ad(paramFloat, paramFloat, paramFloat, paramFloat, localb));
      AppMethodBeat.o(203820);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<androidx.compose.ui.platform.ad, kotlin.ah>
  {
    a(float paramFloat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<androidx.compose.ui.platform.ad, kotlin.ah>
  {
    b(float paramFloat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<androidx.compose.ui.platform.ad, kotlin.ah>
  {
    c(float paramFloat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "<anonymous parameter 1>", "Landroidx/compose/ui/unit/LayoutDirection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<l, n, androidx.compose.ui.n.j>
  {
    d(a.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<androidx.compose.ui.platform.ad, kotlin.ah>
  {
    e(a.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<l, n, androidx.compose.ui.n.j>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements b<androidx.compose.ui.platform.ad, kotlin.ah>
  {
    g(a parama, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements m<l, n, androidx.compose.ui.n.j>
  {
    h(a.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements b<androidx.compose.ui.platform.ad, kotlin.ah>
  {
    i(a.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class j
    extends u
    implements b<androidx.compose.ui.platform.ad, kotlin.ah>
  {
    public j(float paramFloat1, float paramFloat2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class k
    extends u
    implements b<androidx.compose.ui.platform.ad, kotlin.ah>
  {
    public k(float paramFloat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class l
    extends u
    implements b<androidx.compose.ui.platform.ad, kotlin.ah>
  {
    public l(float paramFloat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class m
    extends u
    implements b<androidx.compose.ui.platform.ad, kotlin.ah>
  {
    public m(float paramFloat1, float paramFloat2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class n
    extends u
    implements b<androidx.compose.ui.platform.ad, kotlin.ah>
  {
    public n(float paramFloat)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.ab
 * JD-Core Version:    0.7.0.1
 */