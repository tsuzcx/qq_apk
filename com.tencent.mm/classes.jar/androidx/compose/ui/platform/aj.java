package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import androidx.compose.ui.d.e;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.au;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.e.be;
import androidx.compose.ui.e.c;
import androidx.compose.ui.e.u;
import androidx.compose.ui.i.x;
import androidx.compose.ui.n.j;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/RenderNodeLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "getDrawBlock", "()Lkotlin/jvm/functions/Function1;", "drawnWithZ", "", "getInvalidateParentLayer", "()Lkotlin/jvm/functions/Function0;", "isDestroyed", "value", "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "matrixCache", "Landroidx/compose/ui/platform/RenderNodeMatrixCache;", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId$annotations", "()V", "getOwnerViewId", "renderNode", "Landroidx/compose/ui/platform/DeviceRenderNode;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "destroy", "drawLayer", "canvas", "invalidate", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "updateLayerProperties-dRfWZ4U", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)V", "UniqueDrawingIdApi29", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  implements x
{
  private boolean aCf;
  private final a<kotlin.ah> aPs;
  private final androidx.compose.ui.e.v aQY;
  private final AndroidComposeView aUH;
  private final b<u, kotlin.ah> aUN;
  private final ag aUO;
  private boolean aUP;
  private boolean aUQ;
  private final ak aUR;
  private final v aUS;
  private long ayj;
  
  public aj(AndroidComposeView paramAndroidComposeView, b<? super u, kotlin.ah> paramb, a<kotlin.ah> parama)
  {
    AppMethodBeat.i(206765);
    this.aUH = paramAndroidComposeView;
    this.aUN = paramb;
    this.aPs = parama;
    this.aUO = new ag(this.aUH.getDensity());
    this.aUR = new ak();
    this.aQY = new androidx.compose.ui.e.v();
    paramAndroidComposeView = be.ayC;
    this.ayj = be.tW();
    if (Build.VERSION.SDK_INT >= 29) {}
    for (paramAndroidComposeView = (v)new ai(this.aUH);; paramAndroidComposeView = (v)new ah(this.aUH))
    {
      paramAndroidComposeView.ze();
      paramb = kotlin.ah.aiuX;
      this.aUS = paramAndroidComposeView;
      AppMethodBeat.o(206765);
      return;
    }
  }
  
  private final void au(boolean paramBoolean)
  {
    AppMethodBeat.i(206772);
    if (paramBoolean != this.aCf)
    {
      this.aCf = paramBoolean;
      this.aUH.a((x)this, paramBoolean);
    }
    AppMethodBeat.o(206772);
  }
  
  private final void zn()
  {
    AppMethodBeat.i(206780);
    if (Build.VERSION.SDK_INT >= 26)
    {
      bf.aWc.b(this.aUH);
      AppMethodBeat.o(206780);
      return;
    }
    this.aUH.invalidate();
    AppMethodBeat.o(206780);
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, long paramLong, ay paramay, boolean paramBoolean, n paramn, androidx.compose.ui.n.d paramd)
  {
    AppMethodBeat.i(206796);
    s.u(paramay, "shape");
    s.u(paramn, "layoutDirection");
    s.u(paramd, "density");
    this.ayj = paramLong;
    int i;
    boolean bool;
    label236:
    int j;
    if ((this.aUS.zb()) && (this.aUO.zl() != null))
    {
      i = 1;
      this.aUS.setScaleX(paramFloat1);
      this.aUS.setScaleY(paramFloat2);
      this.aUS.setAlpha(paramFloat3);
      this.aUS.M(paramFloat4);
      this.aUS.setTranslationY(paramFloat5);
      this.aUS.g(paramFloat6);
      this.aUS.Q(paramFloat9);
      this.aUS.O(paramFloat7);
      this.aUS.P(paramFloat8);
      this.aUS.R(paramFloat10);
      this.aUS.setPivotX(be.ak(paramLong) * this.aUS.getWidth());
      this.aUS.setPivotY(be.al(paramLong) * this.aUS.getHeight());
      v localv = this.aUS;
      if ((!paramBoolean) || (paramay == au.tM())) {
        break label430;
      }
      bool = true;
      localv.ax(bool);
      localv = this.aUS;
      if ((!paramBoolean) || (paramay != au.tM())) {
        break label436;
      }
      paramBoolean = true;
      label267:
      localv.ay(paramBoolean);
      paramBoolean = this.aUO.a(paramay, this.aUS.getAlpha(), this.aUS.zb(), this.aUS.za(), paramn, paramd);
      this.aUS.a(this.aUO.zk());
      if ((!this.aUS.zb()) || (this.aUO.zl() == null)) {
        break label442;
      }
      j = 1;
      label359:
      if ((i == j) && ((j == 0) || (!paramBoolean))) {
        break label448;
      }
      invalidate();
    }
    for (;;)
    {
      if ((!this.aUQ) && (this.aUS.za() > 0.0F)) {
        this.aPs.invoke();
      }
      this.aUR.invalidate();
      AppMethodBeat.o(206796);
      return;
      i = 0;
      break;
      label430:
      bool = false;
      break label236;
      label436:
      paramBoolean = false;
      break label267;
      label442:
      j = 0;
      break label359;
      label448:
      zn();
    }
  }
  
  public final boolean aG(long paramLong)
  {
    AppMethodBeat.i(206809);
    float f1 = e.F(paramLong);
    float f2 = e.G(paramLong);
    if (this.aUS.zc())
    {
      if ((0.0F <= f1) && (f1 < this.aUS.getWidth()) && (0.0F <= f2) && (f2 < this.aUS.getHeight()))
      {
        AppMethodBeat.o(206809);
        return true;
      }
      AppMethodBeat.o(206809);
      return false;
    }
    if (this.aUS.zb())
    {
      boolean bool = this.aUO.aK(paramLong);
      AppMethodBeat.o(206809);
      return bool;
    }
    AppMethodBeat.o(206809);
    return true;
  }
  
  public final void aH(long paramLong)
  {
    AppMethodBeat.i(206841);
    int i = this.aUS.yY();
    int j = this.aUS.yZ();
    int k = j.bf(paramLong);
    int m = j.bg(paramLong);
    if ((i != k) || (j != m))
    {
      this.aUS.dd(k - i);
      this.aUS.de(m - j);
      zn();
      this.aUR.invalidate();
    }
    AppMethodBeat.o(206841);
  }
  
  public final void aI(long paramLong)
  {
    AppMethodBeat.i(206825);
    int i = androidx.compose.ui.n.l.bi(paramLong);
    int j = androidx.compose.ui.n.l.bj(paramLong);
    this.aUS.setPivotX(be.ak(this.ayj) * i);
    this.aUS.setPivotY(be.al(this.ayj) * j);
    if (this.aUS.g(this.aUS.yY(), this.aUS.yZ(), this.aUS.yY() + i, this.aUS.yZ() + j))
    {
      this.aUO.aL(androidx.compose.ui.d.l.z(i, j));
      this.aUS.a(this.aUO.zk());
      invalidate();
      this.aUR.invalidate();
    }
    AppMethodBeat.o(206825);
  }
  
  public final void b(androidx.compose.ui.d.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(206893);
    s.u(paramd, "rect");
    if (paramBoolean)
    {
      androidx.compose.ui.e.aj.a(this.aUR.b(this.aUS), paramd);
      AppMethodBeat.o(206893);
      return;
    }
    androidx.compose.ui.e.aj.a(this.aUR.a(this.aUS), paramd);
    AppMethodBeat.o(206893);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(206878);
    this.aUP = true;
    au(false);
    this.aUH.aRj = true;
    AppMethodBeat.o(206878);
  }
  
  public final long e(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(206886);
    if (paramBoolean)
    {
      paramLong = androidx.compose.ui.e.aj.a(this.aUR.b(this.aUS), paramLong);
      AppMethodBeat.o(206886);
      return paramLong;
    }
    paramLong = androidx.compose.ui.e.aj.a(this.aUR.a(this.aUS), paramLong);
    AppMethodBeat.o(206886);
    return paramLong;
  }
  
  public final void f(u paramu)
  {
    boolean bool = false;
    AppMethodBeat.i(206859);
    s.u(paramu, "canvas");
    Canvas localCanvas = c.a(paramu);
    if (localCanvas.isHardwareAccelerated())
    {
      yk();
      if (this.aUS.za() > 0.0F) {
        bool = true;
      }
      this.aUQ = bool;
      if (this.aUQ) {
        paramu.sA();
      }
      this.aUS.c(localCanvas);
      if (this.aUQ)
      {
        paramu.sB();
        AppMethodBeat.o(206859);
      }
    }
    else
    {
      this.aUN.invoke(paramu);
      au(false);
    }
    AppMethodBeat.o(206859);
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(206851);
    if ((!this.aCf) && (!this.aUP))
    {
      this.aUH.invalidate();
      au(true);
    }
    AppMethodBeat.o(206851);
  }
  
  public final void yk()
  {
    AppMethodBeat.i(206869);
    if ((this.aCf) || (!this.aUS.zd()))
    {
      au(false);
      if (!this.aUS.zb()) {
        break label75;
      }
    }
    label75:
    for (ao localao = this.aUO.zl();; localao = null)
    {
      this.aUS.a(this.aQY, localao, this.aUN);
      AppMethodBeat.o(206869);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.aj
 * JD-Core Version:    0.7.0.1
 */