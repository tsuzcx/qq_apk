package androidx.compose.ui.e;

import androidx.compose.ui.f;
import androidx.compose.ui.platform.ab;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"graphicsLayer", "Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "graphicsLayer-sKFY_QE", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "toolingGraphicsLayer", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ad
{
  private static f a(f paramf, float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4, final float paramFloat5, final long paramLong, ay paramay, final boolean paramBoolean)
  {
    AppMethodBeat.i(206269);
    s.u(paramf, "$this$graphicsLayer");
    s.u(paramay, "shape");
    if (ab.zi()) {}
    for (b localb = (b)new b(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, paramFloat4, paramFloat5, paramLong, paramay, paramBoolean);; localb = ab.zh())
    {
      paramf = paramf.a((f)new az(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, paramFloat4, paramFloat5, paramLong, paramay, paramBoolean, localb, (byte)0));
      AppMethodBeat.o(206269);
      return paramf;
    }
  }
  
  public static final f b(f paramf, b<? super ae, ah> paramb)
  {
    AppMethodBeat.i(206275);
    s.u(paramf, "<this>");
    s.u(paramb, "block");
    if (ab.zi()) {}
    for (b localb = (b)new a(paramb);; localb = ab.zh())
    {
      paramf = paramf.a((f)new r(paramb, localb));
      AppMethodBeat.o(206275);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements b<androidx.compose.ui.platform.ad, ah>
  {
    public a(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements b<androidx.compose.ui.platform.ad, ah>
  {
    public b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, long paramLong, ay paramay, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.ad
 * JD-Core Version:    0.7.0.1
 */