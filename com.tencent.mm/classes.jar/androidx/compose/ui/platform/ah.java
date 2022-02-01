package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.u;
import androidx.compose.ui.e.u.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/RenderNodeApi23;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "bottom", "", "getBottom", "()I", "setBottom", "(I)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clipToBounds", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "clipToOutline", "getClipToOutline", "setClipToOutline", "elevation", "getElevation", "setElevation", "hasDisplayList", "getHasDisplayList", "height", "getHeight", "left", "getLeft", "setLeft", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "renderNode", "Landroid/view/RenderNode;", "right", "getRight", "setRight", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "top", "getTop", "setTop", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "uniqueId", "", "getUniqueId", "()J", "width", "getWidth", "drawInto", "", "canvas", "Landroid/graphics/Canvas;", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "getInverseMatrix", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "setHasOverlappingRendering", "hasOverlappingRendering", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  implements v
{
  public static final ah.a aUG;
  private static boolean aUK;
  private static boolean aUL;
  private final AndroidComposeView aUH;
  private final RenderNode aUI;
  private boolean aUJ;
  private int bottom;
  private int left;
  private int right;
  private int top;
  
  static
  {
    AppMethodBeat.i(206753);
    aUG = new ah.a((byte)0);
    aUL = true;
    AppMethodBeat.o(206753);
  }
  
  public ah(AndroidComposeView paramAndroidComposeView)
  {
    AppMethodBeat.i(206748);
    this.aUH = paramAndroidComposeView;
    paramAndroidComposeView = RenderNode.create("Compose", (View)this.aUH);
    s.s(paramAndroidComposeView, "create(\"Compose\", ownerView)");
    this.aUI = paramAndroidComposeView;
    if (aUL)
    {
      this.aUI.setScaleX(this.aUI.getScaleX());
      this.aUI.setScaleY(this.aUI.getScaleY());
      this.aUI.setTranslationX(this.aUI.getTranslationX());
      this.aUI.setTranslationY(this.aUI.getTranslationY());
      this.aUI.setElevation(this.aUI.getElevation());
      this.aUI.setRotation(this.aUI.getRotation());
      this.aUI.setRotationX(this.aUI.getRotationX());
      this.aUI.setRotationY(this.aUI.getRotationY());
      this.aUI.setCameraDistance(this.aUI.getCameraDistance());
      this.aUI.setPivotX(this.aUI.getPivotX());
      this.aUI.setPivotY(this.aUI.getPivotY());
      this.aUI.setClipToOutline(this.aUI.getClipToOutline());
      this.aUI.setClipToBounds(false);
      this.aUI.setAlpha(this.aUI.getAlpha());
      this.aUI.isValid();
      this.aUI.setLeftTopRightBottom(0, 0, 0, 0);
      this.aUI.offsetLeftAndRight(0);
      this.aUI.offsetTopAndBottom(0);
      aUL = false;
    }
    if (aUK)
    {
      paramAndroidComposeView = new NoClassDefFoundError();
      AppMethodBeat.o(206748);
      throw paramAndroidComposeView;
    }
    AppMethodBeat.o(206748);
  }
  
  public final void M(float paramFloat)
  {
    AppMethodBeat.i(206783);
    this.aUI.setTranslationX(paramFloat);
    AppMethodBeat.o(206783);
  }
  
  public final void O(float paramFloat)
  {
    AppMethodBeat.i(206822);
    this.aUI.setRotationX(paramFloat);
    AppMethodBeat.o(206822);
  }
  
  public final void P(float paramFloat)
  {
    AppMethodBeat.i(206830);
    this.aUI.setRotationY(paramFloat);
    AppMethodBeat.o(206830);
  }
  
  public final void Q(float paramFloat)
  {
    AppMethodBeat.i(206815);
    this.aUI.setRotation(paramFloat);
    AppMethodBeat.o(206815);
  }
  
  public final void R(float paramFloat)
  {
    AppMethodBeat.i(206836);
    this.aUI.setCameraDistance(-paramFloat);
    AppMethodBeat.o(206836);
  }
  
  public final void a(Matrix paramMatrix)
  {
    AppMethodBeat.i(206918);
    s.u(paramMatrix, "matrix");
    this.aUI.getMatrix(paramMatrix);
    AppMethodBeat.o(206918);
  }
  
  public final void a(Outline paramOutline)
  {
    AppMethodBeat.i(206889);
    this.aUI.setOutline(paramOutline);
    AppMethodBeat.o(206889);
  }
  
  public final void a(androidx.compose.ui.e.v paramv, ao paramao, kotlin.g.a.b<? super u, kotlin.ah> paramb)
  {
    AppMethodBeat.i(206912);
    s.u(paramv, "canvasHolder");
    s.u(paramb, "drawBlock");
    DisplayListCanvas localDisplayListCanvas = this.aUI.start(getWidth(), getHeight());
    s.s(localDisplayListCanvas, "renderNode.start(width, height)");
    Canvas localCanvas = paramv.awC.avB;
    paramv.awC.b((Canvas)localDisplayListCanvas);
    u localu = (u)paramv.awC;
    if (paramao != null)
    {
      localu.sz();
      u.a.a(localu, paramao);
    }
    paramb.invoke(localu);
    if (paramao != null) {
      localu.restore();
    }
    paramv.awC.b(localCanvas);
    this.aUI.end(localDisplayListCanvas);
    AppMethodBeat.o(206912);
  }
  
  public final void ax(boolean paramBoolean)
  {
    AppMethodBeat.i(206858);
    this.aUI.setClipToOutline(paramBoolean);
    AppMethodBeat.o(206858);
  }
  
  public final void ay(boolean paramBoolean)
  {
    AppMethodBeat.i(206867);
    this.aUJ = paramBoolean;
    this.aUI.setClipToBounds(paramBoolean);
    AppMethodBeat.o(206867);
  }
  
  public final void b(Matrix paramMatrix)
  {
    AppMethodBeat.i(206921);
    s.u(paramMatrix, "matrix");
    this.aUI.getInverseMatrix(paramMatrix);
    AppMethodBeat.o(206921);
  }
  
  public final void c(Canvas paramCanvas)
  {
    AppMethodBeat.i(206924);
    s.u(paramCanvas, "canvas");
    ((DisplayListCanvas)paramCanvas).drawRenderNode(this.aUI);
    AppMethodBeat.o(206924);
  }
  
  public final void dd(int paramInt)
  {
    AppMethodBeat.i(206901);
    this.left += paramInt;
    this.right += paramInt;
    this.aUI.offsetLeftAndRight(paramInt);
    AppMethodBeat.o(206901);
  }
  
  public final void de(int paramInt)
  {
    AppMethodBeat.i(206905);
    this.top += paramInt;
    this.bottom += paramInt;
    this.aUI.offsetTopAndBottom(paramInt);
    AppMethodBeat.o(206905);
  }
  
  public final void g(float paramFloat)
  {
    AppMethodBeat.i(206808);
    this.aUI.setElevation(paramFloat);
    AppMethodBeat.o(206808);
  }
  
  public final boolean g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(206894);
    this.left = paramInt1;
    this.top = paramInt2;
    this.right = paramInt3;
    this.bottom = paramInt4;
    boolean bool = this.aUI.setLeftTopRightBottom(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(206894);
    return bool;
  }
  
  public final float getAlpha()
  {
    AppMethodBeat.i(206875);
    float f = this.aUI.getAlpha();
    AppMethodBeat.o(206875);
    return f;
  }
  
  public final int getHeight()
  {
    return this.bottom - this.top;
  }
  
  public final int getWidth()
  {
    return this.right - this.left;
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(206879);
    this.aUI.setAlpha(paramFloat);
    AppMethodBeat.o(206879);
  }
  
  public final void setPivotX(float paramFloat)
  {
    AppMethodBeat.i(206844);
    this.aUI.setPivotX(paramFloat);
    AppMethodBeat.o(206844);
  }
  
  public final void setPivotY(float paramFloat)
  {
    AppMethodBeat.i(206849);
    this.aUI.setPivotY(paramFloat);
    AppMethodBeat.o(206849);
  }
  
  public final void setScaleX(float paramFloat)
  {
    AppMethodBeat.i(206775);
    this.aUI.setScaleX(paramFloat);
    AppMethodBeat.o(206775);
  }
  
  public final void setScaleY(float paramFloat)
  {
    AppMethodBeat.i(206779);
    this.aUI.setScaleY(paramFloat);
    AppMethodBeat.o(206779);
  }
  
  public final void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(206790);
    this.aUI.setTranslationY(paramFloat);
    AppMethodBeat.o(206790);
  }
  
  public final int yY()
  {
    return this.left;
  }
  
  public final int yZ()
  {
    return this.top;
  }
  
  public final float za()
  {
    AppMethodBeat.i(206799);
    float f = this.aUI.getElevation();
    AppMethodBeat.o(206799);
    return f;
  }
  
  public final boolean zb()
  {
    AppMethodBeat.i(206853);
    boolean bool = this.aUI.getClipToOutline();
    AppMethodBeat.o(206853);
    return bool;
  }
  
  public final boolean zc()
  {
    return this.aUJ;
  }
  
  public final boolean zd()
  {
    AppMethodBeat.i(206883);
    boolean bool = this.aUI.isValid();
    AppMethodBeat.o(206883);
    return bool;
  }
  
  public final boolean ze()
  {
    AppMethodBeat.i(206927);
    boolean bool = this.aUI.setHasOverlappingRendering(true);
    AppMethodBeat.o(206927);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.ah
 * JD-Core Version:    0.7.0.1
 */