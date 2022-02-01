package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.u;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/DeviceRenderNode;", "", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "bottom", "", "getBottom", "()I", "cameraDistance", "getCameraDistance", "setCameraDistance", "clipToBounds", "", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "clipToOutline", "getClipToOutline", "setClipToOutline", "elevation", "getElevation", "setElevation", "hasDisplayList", "getHasDisplayList", "height", "getHeight", "left", "getLeft", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "right", "getRight", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "top", "getTop", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "uniqueId", "", "getUniqueId", "()J", "width", "getWidth", "drawInto", "", "canvas", "Landroid/graphics/Canvas;", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "getInverseMatrix", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "setHasOverlappingRendering", "hasOverlappingRendering", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface v
{
  public abstract void M(float paramFloat);
  
  public abstract void O(float paramFloat);
  
  public abstract void P(float paramFloat);
  
  public abstract void Q(float paramFloat);
  
  public abstract void R(float paramFloat);
  
  public abstract void a(Matrix paramMatrix);
  
  public abstract void a(Outline paramOutline);
  
  public abstract void a(androidx.compose.ui.e.v paramv, ao paramao, b<? super u, ah> paramb);
  
  public abstract void ax(boolean paramBoolean);
  
  public abstract void ay(boolean paramBoolean);
  
  public abstract void b(Matrix paramMatrix);
  
  public abstract void c(Canvas paramCanvas);
  
  public abstract void dd(int paramInt);
  
  public abstract void de(int paramInt);
  
  public abstract void g(float paramFloat);
  
  public abstract boolean g(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract float getAlpha();
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setPivotX(float paramFloat);
  
  public abstract void setPivotY(float paramFloat);
  
  public abstract void setScaleX(float paramFloat);
  
  public abstract void setScaleY(float paramFloat);
  
  public abstract void setTranslationY(float paramFloat);
  
  public abstract int yY();
  
  public abstract int yZ();
  
  public abstract float za();
  
  public abstract boolean zb();
  
  public abstract boolean zc();
  
  public abstract boolean zd();
  
  public abstract boolean ze();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.v
 * JD-Core Version:    0.7.0.1
 */