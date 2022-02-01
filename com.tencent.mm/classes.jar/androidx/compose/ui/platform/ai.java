package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RenderNode;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.u;
import androidx.compose.ui.e.u.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/RenderNodeApi29;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "bottom", "", "getBottom", "()I", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clipToBounds", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "clipToOutline", "getClipToOutline", "setClipToOutline", "elevation", "getElevation", "setElevation", "hasDisplayList", "getHasDisplayList", "height", "getHeight", "left", "getLeft", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "renderNode", "Landroid/graphics/RenderNode;", "right", "getRight", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "top", "getTop", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "uniqueId", "", "getUniqueId", "()J", "width", "getWidth", "drawInto", "", "canvas", "Landroid/graphics/Canvas;", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "getInverseMatrix", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "setHasOverlappingRendering", "hasOverlappingRendering", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  implements v
{
  private final AndroidComposeView aUH;
  private final RenderNode aUM;
  
  public ai(AndroidComposeView paramAndroidComposeView)
  {
    AppMethodBeat.i(206743);
    this.aUH = paramAndroidComposeView;
    this.aUM = new RenderNode("Compose");
    AppMethodBeat.o(206743);
  }
  
  public final void M(float paramFloat)
  {
    AppMethodBeat.i(206773);
    this.aUM.setTranslationX(paramFloat);
    AppMethodBeat.o(206773);
  }
  
  public final void O(float paramFloat)
  {
    AppMethodBeat.i(206805);
    this.aUM.setRotationX(paramFloat);
    AppMethodBeat.o(206805);
  }
  
  public final void P(float paramFloat)
  {
    AppMethodBeat.i(206814);
    this.aUM.setRotationY(paramFloat);
    AppMethodBeat.o(206814);
  }
  
  public final void Q(float paramFloat)
  {
    AppMethodBeat.i(206797);
    this.aUM.setRotationZ(paramFloat);
    AppMethodBeat.o(206797);
  }
  
  public final void R(float paramFloat)
  {
    AppMethodBeat.i(206821);
    this.aUM.setCameraDistance(paramFloat);
    AppMethodBeat.o(206821);
  }
  
  public final void a(Matrix paramMatrix)
  {
    AppMethodBeat.i(206903);
    s.u(paramMatrix, "matrix");
    this.aUM.getMatrix(paramMatrix);
    AppMethodBeat.o(206903);
  }
  
  public final void a(Outline paramOutline)
  {
    AppMethodBeat.i(206877);
    this.aUM.setOutline(paramOutline);
    AppMethodBeat.o(206877);
  }
  
  public final void a(androidx.compose.ui.e.v paramv, ao paramao, kotlin.g.a.b<? super u, ah> paramb)
  {
    AppMethodBeat.i(206897);
    s.u(paramv, "canvasHolder");
    s.u(paramb, "drawBlock");
    Object localObject1 = this.aUM.beginRecording();
    s.s(localObject1, "renderNode.beginRecording()");
    Object localObject2 = (Canvas)localObject1;
    localObject1 = paramv.awC.avB;
    paramv.awC.b((Canvas)localObject2);
    localObject2 = (u)paramv.awC;
    if (paramao != null)
    {
      ((u)localObject2).sz();
      u.a.a((u)localObject2, paramao);
    }
    paramb.invoke(localObject2);
    if (paramao != null) {
      ((u)localObject2).restore();
    }
    paramv.awC.b((Canvas)localObject1);
    this.aUM.endRecording();
    AppMethodBeat.o(206897);
  }
  
  public final void ax(boolean paramBoolean)
  {
    AppMethodBeat.i(206847);
    this.aUM.setClipToOutline(paramBoolean);
    AppMethodBeat.o(206847);
  }
  
  public final void ay(boolean paramBoolean)
  {
    AppMethodBeat.i(206855);
    this.aUM.setClipToBounds(paramBoolean);
    AppMethodBeat.o(206855);
  }
  
  public final void b(Matrix paramMatrix)
  {
    AppMethodBeat.i(206906);
    s.u(paramMatrix, "matrix");
    this.aUM.getInverseMatrix(paramMatrix);
    AppMethodBeat.o(206906);
  }
  
  public final void c(Canvas paramCanvas)
  {
    AppMethodBeat.i(206911);
    s.u(paramCanvas, "canvas");
    paramCanvas.drawRenderNode(this.aUM);
    AppMethodBeat.o(206911);
  }
  
  public final void dd(int paramInt)
  {
    AppMethodBeat.i(206884);
    this.aUM.offsetLeftAndRight(paramInt);
    AppMethodBeat.o(206884);
  }
  
  public final void de(int paramInt)
  {
    AppMethodBeat.i(206890);
    this.aUM.offsetTopAndBottom(paramInt);
    AppMethodBeat.o(206890);
  }
  
  public final void g(float paramFloat)
  {
    AppMethodBeat.i(206791);
    this.aUM.setElevation(paramFloat);
    AppMethodBeat.o(206791);
  }
  
  public final boolean g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(206882);
    boolean bool = this.aUM.setPosition(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(206882);
    return bool;
  }
  
  public final float getAlpha()
  {
    AppMethodBeat.i(206860);
    float f = this.aUM.getAlpha();
    AppMethodBeat.o(206860);
    return f;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(206759);
    int i = this.aUM.getHeight();
    AppMethodBeat.o(206759);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(206755);
    int i = this.aUM.getWidth();
    AppMethodBeat.o(206755);
    return i;
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(206865);
    this.aUM.setAlpha(paramFloat);
    AppMethodBeat.o(206865);
  }
  
  public final void setPivotX(float paramFloat)
  {
    AppMethodBeat.i(206829);
    this.aUM.setPivotX(paramFloat);
    AppMethodBeat.o(206829);
  }
  
  public final void setPivotY(float paramFloat)
  {
    AppMethodBeat.i(206834);
    this.aUM.setPivotY(paramFloat);
    AppMethodBeat.o(206834);
  }
  
  public final void setScaleX(float paramFloat)
  {
    AppMethodBeat.i(206762);
    this.aUM.setScaleX(paramFloat);
    AppMethodBeat.o(206762);
  }
  
  public final void setScaleY(float paramFloat)
  {
    AppMethodBeat.i(206769);
    this.aUM.setScaleY(paramFloat);
    AppMethodBeat.o(206769);
  }
  
  public final void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(206778);
    this.aUM.setTranslationY(paramFloat);
    AppMethodBeat.o(206778);
  }
  
  public final int yY()
  {
    AppMethodBeat.i(206746);
    int i = this.aUM.getLeft();
    AppMethodBeat.o(206746);
    return i;
  }
  
  public final int yZ()
  {
    AppMethodBeat.i(206751);
    int i = this.aUM.getTop();
    AppMethodBeat.o(206751);
    return i;
  }
  
  public final float za()
  {
    AppMethodBeat.i(206784);
    float f = this.aUM.getElevation();
    AppMethodBeat.o(206784);
    return f;
  }
  
  public final boolean zb()
  {
    AppMethodBeat.i(206840);
    boolean bool = this.aUM.getClipToOutline();
    AppMethodBeat.o(206840);
    return bool;
  }
  
  public final boolean zc()
  {
    AppMethodBeat.i(206852);
    boolean bool = this.aUM.getClipToBounds();
    AppMethodBeat.o(206852);
    return bool;
  }
  
  public final boolean zd()
  {
    AppMethodBeat.i(206870);
    boolean bool = this.aUM.hasDisplayList();
    AppMethodBeat.o(206870);
    return bool;
  }
  
  public final boolean ze()
  {
    AppMethodBeat.i(206916);
    boolean bool = this.aUM.setHasOverlappingRendering(true);
    AppMethodBeat.o(206916);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.ai
 * JD-Core Version:    0.7.0.1
 */