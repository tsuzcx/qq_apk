package androidx.compose.ui.platform;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.d.e;
import androidx.compose.ui.e.aj;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.au;
import androidx.compose.ui.e.be;
import androidx.compose.ui.e.u;
import androidx.compose.ui.e.u.a;
import androidx.compose.ui.e.v;
import androidx.compose.ui.i.x;
import androidx.compose.ui.n.j;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Landroidx/compose/ui/node/OwnedLayer;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "container", "Landroidx/compose/ui/platform/DrawChildContainer;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "value", "", "cameraDistancePx", "getCameraDistancePx", "()F", "setCameraDistancePx", "(F)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipBoundsCache", "Landroid/graphics/Rect;", "clipToBounds", "", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "getDrawBlock", "()Lkotlin/jvm/functions/Function1;", "drawnWithZ", "getInvalidateParentLayer", "()Lkotlin/jvm/functions/Function0;", "isInvalidated", "()Z", "setInvalidated", "(Z)V", "layerId", "", "getLayerId", "()J", "mTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "manualClipPath", "Landroidx/compose/ui/graphics/Path;", "getManualClipPath", "()Landroidx/compose/ui/graphics/Path;", "matrixCache", "Landroidx/compose/ui/platform/ViewLayerMatrixCache;", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId$annotations", "()V", "getOwnerViewId", "destroy", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawLayer", "forceLayout", "invalidate", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "onLayout", "changed", "l", "", "t", "r", "b", "resetClipBounds", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "updateDisplayList", "updateLayerProperties", "scaleX", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "updateLayerProperties-dRfWZ4U", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)V", "updateOutlineResolver", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  extends View
  implements x
{
  private static boolean aVA;
  public static final a aVq;
  private static final ViewOutlineProvider aVw;
  private static Method aVx;
  private static Field aVy;
  private static boolean aVz;
  private final a<ah> aPs;
  private final v aQY;
  private final AndroidComposeView aUH;
  private boolean aUJ;
  private final kotlin.g.a.b<u, ah> aUN;
  private final ag aUO;
  private boolean aUQ;
  private final y aVr;
  private Rect aVs;
  boolean aVt;
  private final ay aVu;
  private long aVv;
  
  static
  {
    AppMethodBeat.i(207039);
    aVq = new a((byte)0);
    aVw = (ViewOutlineProvider)new b();
    AppMethodBeat.o(207039);
  }
  
  public aw(AndroidComposeView paramAndroidComposeView, y paramy, kotlin.g.a.b<? super u, ah> paramb, a<ah> parama)
  {
    super(paramAndroidComposeView.getContext());
    AppMethodBeat.i(206955);
    this.aUH = paramAndroidComposeView;
    this.aVr = paramy;
    this.aUN = paramb;
    this.aPs = parama;
    this.aUO = new ag(this.aUH.getDensity());
    this.aQY = new v();
    this.aVu = new ay();
    paramAndroidComposeView = be.ayC;
    this.aVv = be.tW();
    setWillNotDraw(false);
    setId(View.generateViewId());
    this.aVr.addView((View)this);
    AppMethodBeat.o(206955);
  }
  
  private final ao getManualClipPath()
  {
    AppMethodBeat.i(206962);
    if (!getClipToOutline())
    {
      AppMethodBeat.o(206962);
      return null;
    }
    ao localao = this.aUO.zl();
    AppMethodBeat.o(206962);
    return localao;
  }
  
  private final void setInvalidated(boolean paramBoolean)
  {
    AppMethodBeat.i(206967);
    if (paramBoolean != this.aVt)
    {
      this.aVt = paramBoolean;
      this.aUH.a((x)this, paramBoolean);
    }
    AppMethodBeat.o(206967);
  }
  
  private final void zo()
  {
    AppMethodBeat.i(206977);
    if (this.aUO.zk() != null) {}
    for (ViewOutlineProvider localViewOutlineProvider = aVw;; localViewOutlineProvider = null)
    {
      setOutlineProvider(localViewOutlineProvider);
      AppMethodBeat.o(206977);
      return;
    }
  }
  
  private final void zp()
  {
    AppMethodBeat.i(206989);
    if (this.aUJ) {
      if (this.aVs == null) {
        this.aVs = new Rect(0, 0, getWidth(), getHeight());
      }
    }
    for (Rect localRect = this.aVs;; localRect = null)
    {
      setClipBounds(localRect);
      AppMethodBeat.o(206989);
      return;
      localRect = this.aVs;
      s.checkNotNull(localRect);
      localRect.set(0, 0, getWidth(), getHeight());
      break;
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, long paramLong, androidx.compose.ui.e.ay paramay, boolean paramBoolean, n paramn, androidx.compose.ui.n.d paramd)
  {
    AppMethodBeat.i(207145);
    s.u(paramay, "shape");
    s.u(paramn, "layoutDirection");
    s.u(paramd, "density");
    this.aVv = paramLong;
    setScaleX(paramFloat1);
    setScaleY(paramFloat2);
    setAlpha(paramFloat3);
    setTranslationX(paramFloat4);
    setTranslationY(paramFloat5);
    setElevation(paramFloat6);
    setRotation(paramFloat9);
    setRotationX(paramFloat7);
    setRotationY(paramFloat8);
    setPivotX(be.ak(this.aVv) * getWidth());
    setPivotY(be.al(this.aVv) * getHeight());
    setCameraDistancePx(paramFloat10);
    boolean bool;
    int i;
    if ((paramBoolean) && (paramay == au.tM()))
    {
      bool = true;
      this.aUJ = bool;
      zp();
      if (getManualClipPath() == null) {
        break label293;
      }
      i = 1;
      label163:
      if ((!paramBoolean) || (paramay == au.tM())) {
        break label299;
      }
      paramBoolean = true;
      label179:
      setClipToOutline(paramBoolean);
      paramBoolean = this.aUO.a(paramay, getAlpha(), getClipToOutline(), getElevation(), paramn, paramd);
      zo();
      if (getManualClipPath() == null) {
        break label305;
      }
    }
    label293:
    label299:
    label305:
    for (int j = 1;; j = 0)
    {
      if ((i != j) || ((j != 0) && (paramBoolean))) {
        invalidate();
      }
      if ((!this.aUQ) && (getElevation() > 0.0F)) {
        this.aPs.invoke();
      }
      this.aVu.invalidate();
      AppMethodBeat.o(207145);
      return;
      bool = false;
      break;
      i = 0;
      break label163;
      paramBoolean = false;
      break label179;
    }
  }
  
  public final boolean aG(long paramLong)
  {
    AppMethodBeat.i(207154);
    float f1 = e.F(paramLong);
    float f2 = e.G(paramLong);
    if (this.aUJ)
    {
      if ((0.0F <= f1) && (f1 < getWidth()) && (0.0F <= f2) && (f2 < getHeight()))
      {
        AppMethodBeat.o(207154);
        return true;
      }
      AppMethodBeat.o(207154);
      return false;
    }
    if (getClipToOutline())
    {
      boolean bool = this.aUO.aK(paramLong);
      AppMethodBeat.o(207154);
      return bool;
    }
    AppMethodBeat.o(207154);
    return true;
  }
  
  public final void aH(long paramLong)
  {
    AppMethodBeat.i(207184);
    int i = j.bf(paramLong);
    if (i != getLeft())
    {
      offsetLeftAndRight(i - getLeft());
      this.aVu.invalidate();
    }
    i = j.bg(paramLong);
    if (i != getTop())
    {
      offsetTopAndBottom(i - getTop());
      this.aVu.invalidate();
    }
    AppMethodBeat.o(207184);
  }
  
  public final void aI(long paramLong)
  {
    AppMethodBeat.i(207169);
    int i = androidx.compose.ui.n.l.bi(paramLong);
    int j = androidx.compose.ui.n.l.bj(paramLong);
    if ((i != getWidth()) || (j != getHeight()))
    {
      setPivotX(be.ak(this.aVv) * i);
      setPivotY(be.al(this.aVv) * j);
      this.aUO.aL(androidx.compose.ui.d.l.z(i, j));
      zo();
      layout(getLeft(), getTop(), i + getLeft(), j + getTop());
      zp();
      this.aVu.invalidate();
    }
    AppMethodBeat.o(207169);
  }
  
  public final void b(androidx.compose.ui.d.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(207251);
    s.u(paramd, "rect");
    if (paramBoolean)
    {
      aj.a(this.aVu.w((View)this), paramd);
      AppMethodBeat.o(207251);
      return;
    }
    aj.a(this.aVu.v((View)this), paramd);
    AppMethodBeat.o(207251);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(207229);
    this.aVr.postOnAnimation((Runnable)new d(this));
    setInvalidated(false);
    this.aUH.aRj = true;
    AppMethodBeat.o(207229);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(207206);
    s.u(paramCanvas, "canvas");
    setInvalidated(false);
    v localv = this.aQY;
    Canvas localCanvas = localv.awC.avB;
    localv.awC.b(paramCanvas);
    paramCanvas = (u)localv.awC;
    ao localao = getManualClipPath();
    if (localao != null)
    {
      paramCanvas.sz();
      u.a.a(paramCanvas, localao);
    }
    getDrawBlock().invoke(paramCanvas);
    if (localao != null) {
      paramCanvas.restore();
    }
    localv.awC.b(localCanvas);
    AppMethodBeat.o(207206);
  }
  
  public final long e(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(207244);
    if (paramBoolean)
    {
      paramLong = aj.a(this.aVu.w((View)this), paramLong);
      AppMethodBeat.o(207244);
      return paramLong;
    }
    paramLong = aj.a(this.aVu.v((View)this), paramLong);
    AppMethodBeat.o(207244);
    return paramLong;
  }
  
  public final void f(u paramu)
  {
    AppMethodBeat.i(207195);
    s.u(paramu, "canvas");
    if (getElevation() > 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.aUQ = bool;
      if (this.aUQ) {
        paramu.sA();
      }
      this.aVr.a(paramu, (View)this, getDrawingTime());
      if (this.aUQ) {
        paramu.sB();
      }
      AppMethodBeat.o(207195);
      return;
    }
  }
  
  public final void forceLayout() {}
  
  public final float getCameraDistancePx()
  {
    AppMethodBeat.i(207114);
    float f = getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    AppMethodBeat.o(207114);
    return f;
  }
  
  public final y getContainer()
  {
    return this.aVr;
  }
  
  public final kotlin.g.a.b<u, ah> getDrawBlock()
  {
    return this.aUN;
  }
  
  public final a<ah> getInvalidateParentLayer()
  {
    return this.aPs;
  }
  
  public final long getLayerId()
  {
    AppMethodBeat.i(207086);
    long l = getId();
    AppMethodBeat.o(207086);
    return l;
  }
  
  public final AndroidComposeView getOwnerView()
  {
    return this.aUH;
  }
  
  public final long getOwnerViewId()
  {
    AppMethodBeat.i(207101);
    if (Build.VERSION.SDK_INT >= 29)
    {
      Object localObject = aw.c.aVB;
      localObject = (View)this.aUH;
      s.u(localObject, "view");
      long l = ((View)localObject).getUniqueDrawingId();
      AppMethodBeat.o(207101);
      return l;
    }
    AppMethodBeat.o(207101);
    return -1L;
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(207217);
    if (!this.aVt)
    {
      setInvalidated(true);
      super.invalidate();
      this.aUH.invalidate();
    }
    AppMethodBeat.o(207217);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void setCameraDistancePx(float paramFloat)
  {
    AppMethodBeat.i(207126);
    setCameraDistance(getResources().getDisplayMetrics().densityDpi * paramFloat);
    AppMethodBeat.o(207126);
  }
  
  public final void yk()
  {
    AppMethodBeat.i(207235);
    if ((this.aVt) && (!aVA))
    {
      setInvalidated(false);
      a.u((View)this);
    }
    AppMethodBeat.o(207235);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ViewLayer$Companion;", "", "()V", "OutlineProvider", "Landroid/view/ViewOutlineProvider;", "getOutlineProvider", "()Landroid/view/ViewOutlineProvider;", "<set-?>", "", "hasRetrievedMethod", "getHasRetrievedMethod", "()Z", "recreateDisplayList", "Ljava/lang/reflect/Field;", "shouldUseDispatchDraw", "getShouldUseDispatchDraw", "setShouldUseDispatchDraw$ui_release", "(Z)V", "updateDisplayListIfDirtyMethod", "Ljava/lang/reflect/Method;", "updateDisplayList", "", "view", "Landroid/view/View;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void u(View paramView)
    {
      AppMethodBeat.i(206713);
      s.u(paramView, "view");
      try
      {
        if (!aw.zq())
        {
          aw.zt();
          if (Build.VERSION.SDK_INT >= 28) {
            break label116;
          }
          aw.c(View.class.getDeclaredMethod("updateDisplayListIfDirty", new Class[0]));
          aw.a(View.class.getDeclaredField("mRecreateDisplayList"));
        }
        for (;;)
        {
          Object localObject = aw.zu();
          if (localObject != null) {
            ((Method)localObject).setAccessible(true);
          }
          localObject = aw.zv();
          if (localObject != null) {
            ((Field)localObject).setAccessible(true);
          }
          localObject = aw.zv();
          if (localObject != null) {
            ((Field)localObject).setBoolean(paramView, true);
          }
          localObject = aw.zu();
          if (localObject == null) {
            break;
          }
          ((Method)localObject).invoke(paramView, new Object[0]);
          AppMethodBeat.o(206713);
          return;
          label116:
          aw.c((Method)Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, new Class[0].getClass() }).invoke(View.class, new Object[] { "updateDisplayListIfDirty", (Object[])new Class[0] }));
          aw.a((Field)Class.class.getDeclaredMethod("getDeclaredField", new Class[] { String.class }).invoke(View.class, new Object[] { "mRecreateDisplayList" }));
        }
        return;
      }
      finally
      {
        aw.zs();
        AppMethodBeat.o(206713);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/platform/ViewLayer$Companion$OutlineProvider$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ViewOutlineProvider
  {
    public final void getOutline(View paramView, Outline paramOutline)
    {
      AppMethodBeat.i(206717);
      s.u(paramView, "view");
      s.u(paramOutline, "outline");
      paramView = aw.a((aw)paramView).zk();
      s.checkNotNull(paramView);
      paramOutline.set(paramView);
      AppMethodBeat.o(206717);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    implements Runnable
  {
    d(aw paramaw) {}
    
    public final void run()
    {
      AppMethodBeat.i(206671);
      this.aVC.getContainer().removeView((View)this.aVC);
      AppMethodBeat.o(206671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.aw
 * JD-Core Version:    0.7.0.1
 */