package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Trace;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.ui.g.a.a.a;
import androidx.compose.ui.h.ab;
import androidx.compose.ui.i.aa;
import androidx.compose.ui.i.ae;
import androidx.compose.ui.i.af;
import androidx.compose.ui.i.f.d;
import androidx.compose.ui.i.f.f;
import androidx.compose.ui.k.w;
import androidx.compose.ui.m.b.c.a;
import androidx.compose.ui.m.c.t;
import androidx.compose.ui.m.c.t.b;
import androidx.lifecycle.al;
import androidx.lifecycle.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_focusManager", "Landroidx/compose/ui/focus/FocusManagerImpl;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "checkTimes", "", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "isDrawingContent", "isLifecycleInResumedState", "isRenderNodeCompatible", "isVivo", "keyInputModifier", "Landroidx/compose/ui/input/key/KeyInputModifier;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "()V", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "Landroidx/compose/runtime/MutableState;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/SemanticsModifierCore;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService$annotations", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpCalculationMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "tmpPositionArray", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "viewTreeOwners", "getViewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "setViewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "viewTreeOwners$delegate", "vivoCanvas", "Landroid/graphics/Canvas;", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "Landroidx/compose/ui/geometry/Offset;", "windowToViewMatrix", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "checkIsVivoDraw", "canvas", "clearChildInvalidObservations", "viewGroup", "clearInvalidObservations", "clearInvalidObservations$ui_release", "convertMeasureSpec", "Lkotlin/Pair;", "measureSpec", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "invalidateParentLayer", "Lkotlin/Function0;", "dispatchDraw", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "motionEvent", "drawAndroidView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "keyboardVisibilityEventLoop", "localToScreen", "localToScreen-MK-Hz9U", "measureAndLayout", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDetach", "onDetachedFromWindow", "onDraw", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onProvideAutofillVirtualStructure", "structure", "Landroid/view/ViewStructure;", "flags", "onRequestMeasure", "onRequestRelayout", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onSemanticsChange", "onWindowFocusChanged", "hasWindowFocus", "recalculateWindowPosition", "recalculateWindowViewTransforms", "removeAndroidView", "requestClearInvalidObservations", "requestRectangleOnScreen", "rect", "Landroidx/compose/ui/geometry/Rect;", "scheduleMeasureAndLayout", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "setOnViewTreeOwnersAvailable", "callback", "transformMatrixToWindow", "matrix", "transformMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "updatePositionCacheAndDispatch", "preConcat", "other", "Landroid/graphics/Matrix;", "preConcat-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "preTranslate", "x", "", "y", "preTranslate-3XD1CNM", "([FFF)V", "Companion", "ViewTreeOwners", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AndroidComposeView
  extends ViewGroup
  implements androidx.compose.ui.g.c.z, androidx.compose.ui.i.y, az, androidx.lifecycle.p
{
  public static final a aQS;
  private static Class<?> aRO;
  private static Method aRP;
  private androidx.compose.ui.n.d TD;
  private final androidx.compose.ui.i.f aLw;
  private boolean aQT;
  private final androidx.compose.ui.k.m aQU;
  private final androidx.compose.ui.c.d aQV;
  private final bb aQW;
  private final androidx.compose.ui.g.a.d aQX;
  private final androidx.compose.ui.e.v aQY;
  private final ae aQZ;
  private boolean aQw;
  private boolean aRA;
  private final an aRB;
  private kotlin.g.a.b<? super b, ah> aRC;
  private final ViewTreeObserver.OnGlobalLayoutListener aRD;
  private final ViewTreeObserver.OnScrollChangedListener aRE;
  final t aRF;
  private final androidx.compose.ui.m.c.s aRG;
  private final c.a aRH;
  private final an aRI;
  private final androidx.compose.ui.f.a aRJ;
  private final ao aRK;
  private final boolean aRL;
  private Canvas aRM;
  private int aRN;
  private final androidx.compose.ui.k.q aRa;
  final f aRb;
  private final List<androidx.compose.ui.i.x> aRc;
  private List<androidx.compose.ui.i.x> aRd;
  private boolean aRe;
  private final androidx.compose.ui.g.c.e aRf;
  private final androidx.compose.ui.g.c.q aRg;
  private kotlin.g.a.b<? super Configuration, ah> aRh;
  private final androidx.compose.ui.a.a aRi;
  boolean aRj;
  private final e aRk;
  private final d aRl;
  private final aa aRm;
  private r aRn;
  private y aRo;
  private androidx.compose.ui.n.b aRp;
  private boolean aRq;
  private final androidx.compose.ui.i.l aRr;
  private long aRs;
  private final int[] aRt;
  private final float[] aRu;
  private final float[] aRv;
  private final float[] aRw;
  private long aRx;
  private boolean aRy;
  private long aRz;
  private final av ahE;
  private final androidx.compose.ui.a.g auf;
  
  static
  {
    AppMethodBeat.i(206881);
    aQS = new a((byte)0);
    AppMethodBeat.o(206881);
  }
  
  public AndroidComposeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206691);
    this.aQT = true;
    this.TD = androidx.compose.ui.n.a.W(paramContext);
    Object localObject1 = androidx.compose.ui.k.m.aXg;
    this.aQU = new androidx.compose.ui.k.m(androidx.compose.ui.k.m.zW().addAndGet(1), false, (kotlin.g.a.b)AndroidComposeView.h.aRV);
    this.aQV = new androidx.compose.ui.c.d();
    this.aQW = new bb();
    this.aQX = new androidx.compose.ui.g.a.d((kotlin.g.a.b)new f(this));
    this.aQY = new androidx.compose.ui.e.v();
    localObject1 = new androidx.compose.ui.i.f();
    ((androidx.compose.ui.i.f)localObject1).a((androidx.compose.ui.h.p)ab.aNd);
    Object localObject2 = androidx.compose.ui.f.aud;
    localObject2 = (androidx.compose.ui.f)this.aQU;
    kotlin.g.b.s.u(localObject2, "other");
    ((androidx.compose.ui.i.f)localObject1).setModifier(((androidx.compose.ui.f)localObject2).a((androidx.compose.ui.f)this.aQV.auO).a((androidx.compose.ui.f)this.aQX));
    localObject2 = ah.aiuX;
    this.aLw = ((androidx.compose.ui.i.f)localObject1);
    this.aQZ = ((ae)this);
    this.aRa = new androidx.compose.ui.k.q(getRoot());
    this.aRb = new f(this);
    this.auf = new androidx.compose.ui.a.g();
    this.aRc = ((List)new ArrayList());
    this.aRf = new androidx.compose.ui.g.c.e();
    this.aRg = new androidx.compose.ui.g.c.q(getRoot());
    this.aRh = ((kotlin.g.a.b)AndroidComposeView.d.aRU);
    if (yC()) {}
    for (localObject1 = new androidx.compose.ui.a.a((View)this, getAutofillTree());; localObject1 = null)
    {
      this.aRi = ((androidx.compose.ui.a.a)localObject1);
      this.aRk = new e(paramContext);
      this.aRl = new d(paramContext);
      this.aRm = new aa((kotlin.g.a.b)new AndroidComposeView.i(this));
      this.aRr = new androidx.compose.ui.i.l(getRoot());
      localObject1 = ViewConfiguration.get(paramContext);
      kotlin.g.b.s.s(localObject1, "get(context)");
      this.ahE = ((av)new q((ViewConfiguration)localObject1));
      localObject1 = androidx.compose.ui.n.j.beN;
      this.aRs = androidx.compose.ui.n.j.su();
      this.aRt = new int[] { 0, 0 };
      this.aRu = androidx.compose.ui.e.aj.tF();
      this.aRv = androidx.compose.ui.e.aj.tF();
      this.aRw = androidx.compose.ui.e.aj.tF();
      this.aRx = -1L;
      localObject1 = androidx.compose.ui.d.e.avo;
      this.aRz = androidx.compose.ui.d.e.sv();
      this.aRA = true;
      this.aRB = bj.T(null);
      this.aRD = ((ViewTreeObserver.OnGlobalLayoutListener)new e(this));
      this.aRE = ((ViewTreeObserver.OnScrollChangedListener)new g(this));
      this.aRF = new t((View)this);
      this.aRG = ((androidx.compose.ui.m.c.s)i.yI().invoke(this.aRF));
      this.aRH = ((c.a)new k(paramContext));
      paramContext = paramContext.getResources().getConfiguration();
      kotlin.g.b.s.s(paramContext, "context.resources.configuration");
      this.aRI = bj.T(i.a(paramContext));
      this.aRJ = ((androidx.compose.ui.f.a)new androidx.compose.ui.f.b((View)this));
      this.aRK = ((ao)new l((View)this));
      setWillNotDraw(false);
      setFocusable(true);
      if (Build.VERSION.SDK_INT >= 26) {
        h.aSF.b((View)this, 1, false);
      }
      setFocusableInTouchMode(true);
      setClipChildren(false);
      androidx.core.g.z.a((View)this, (androidx.core.g.a)this.aRb);
      paramContext = az.a.zw();
      if (paramContext != null) {
        paramContext.invoke(this);
      }
      getRoot().a((androidx.compose.ui.i.y)this);
      paramContext = Build.BRAND;
      kotlin.g.b.s.s(paramContext, "BRAND");
      this.aRL = kotlin.n.n.i((CharSequence)paramContext, (CharSequence)"vivo");
      AppMethodBeat.o(206691);
      return;
    }
  }
  
  private final void C(androidx.compose.ui.i.f paramf)
  {
    AppMethodBeat.i(206730);
    if ((!isLayoutRequested()) && (isAttachedToWindow()))
    {
      if ((this.aRq) && (paramf != null))
      {
        while ((paramf != null) && (paramf.aOA == f.f.aOU)) {
          paramf = paramf.xu();
        }
        if (paramf == getRoot())
        {
          requestLayout();
          AppMethodBeat.o(206730);
          return;
        }
      }
      if ((getWidth() == 0) || (getHeight() == 0))
      {
        requestLayout();
        AppMethodBeat.o(206730);
        return;
      }
      invalidate();
    }
    AppMethodBeat.o(206730);
  }
  
  private final void D(androidx.compose.ui.i.f paramf)
  {
    AppMethodBeat.i(206745);
    this.aRr.t(paramf);
    paramf = paramf.xr();
    int j = paramf.size;
    int i;
    if (j > 0)
    {
      paramf = paramf.aqq;
      i = 0;
    }
    for (;;)
    {
      D((androidx.compose.ui.i.f)paramf[i]);
      i += 1;
      if (i >= j)
      {
        AppMethodBeat.o(206745);
        return;
      }
    }
  }
  
  private final void E(androidx.compose.ui.i.f paramf)
  {
    AppMethodBeat.i(206752);
    paramf.xJ();
    paramf = paramf.xr();
    int j = paramf.size;
    int i;
    if (j > 0)
    {
      paramf = paramf.aqq;
      i = 0;
    }
    for (;;)
    {
      E((androidx.compose.ui.i.f)paramf[i]);
      i += 1;
      if (i >= j)
      {
        AppMethodBeat.o(206752);
        return;
      }
    }
  }
  
  private final View a(int paramInt, View paramView)
  {
    int i = 0;
    AppMethodBeat.i(206785);
    Object localObject;
    int k;
    if (Build.VERSION.SDK_INT < 29)
    {
      localObject = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
      ((Method)localObject).setAccessible(true);
      if (kotlin.g.b.s.p(((Method)localObject).invoke(paramView, new Object[0]), Integer.valueOf(paramInt)))
      {
        AppMethodBeat.o(206785);
        return paramView;
      }
      if ((paramView instanceof ViewGroup))
      {
        k = ((ViewGroup)paramView).getChildCount();
        if (k <= 0) {}
      }
    }
    for (;;)
    {
      int j = i + 1;
      localObject = ((ViewGroup)paramView).getChildAt(i);
      kotlin.g.b.s.s(localObject, "currentView.getChildAt(i)");
      localObject = a(paramInt, (View)localObject);
      if (localObject != null)
      {
        AppMethodBeat.o(206785);
        return localObject;
      }
      if (j >= k)
      {
        AppMethodBeat.o(206785);
        return null;
      }
      i = j;
    }
  }
  
  private final void a(View paramView, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206798);
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof View))
    {
      a((View)localViewParent, paramArrayOfFloat);
      c(paramArrayOfFloat, -paramView.getScrollX(), -paramView.getScrollY());
      c(paramArrayOfFloat, paramView.getLeft(), paramView.getTop());
    }
    for (;;)
    {
      paramView = paramView.getMatrix();
      if (!paramView.isIdentity())
      {
        kotlin.g.b.s.s(paramView, "viewMatrix");
        b(paramArrayOfFloat, paramView);
      }
      AppMethodBeat.o(206798);
      return;
      paramView.getLocationInWindow(this.aRt);
      c(paramArrayOfFloat, -paramView.getScrollX(), -paramView.getScrollY());
      c(paramArrayOfFloat, this.aRt[0], this.aRt[1]);
    }
  }
  
  private final void b(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(206724);
    int i = 0;
    int k = paramViewGroup.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof AndroidComposeView)) {
        ((AndroidComposeView)localView).yo();
      }
      while (j >= k)
      {
        AppMethodBeat.o(206724);
        return;
        if ((localView instanceof ViewGroup)) {
          b((ViewGroup)localView);
        }
      }
      i = j;
    }
  }
  
  private final void b(float[] paramArrayOfFloat, Matrix paramMatrix)
  {
    AppMethodBeat.i(206812);
    androidx.compose.ui.e.g.a(this.aRw, paramMatrix);
    i.f(paramArrayOfFloat, this.aRw);
    AppMethodBeat.o(206812);
  }
  
  private final void c(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206824);
    androidx.compose.ui.e.aj.e(this.aRw);
    androidx.compose.ui.e.aj.b(this.aRw, paramFloat1, paramFloat2);
    i.f(paramArrayOfFloat, this.aRw);
    AppMethodBeat.o(206824);
  }
  
  private static kotlin.r<Integer, Integer> cX(int paramInt)
  {
    AppMethodBeat.i(206734);
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    switch (i)
    {
    default: 
      localObject = new IllegalStateException();
      AppMethodBeat.o(206734);
      throw ((Throwable)localObject);
    case 1073741824: 
      localObject = kotlin.v.Y(Integer.valueOf(paramInt), Integer.valueOf(paramInt));
      AppMethodBeat.o(206734);
      return localObject;
    case 0: 
      localObject = kotlin.v.Y(Integer.valueOf(0), Integer.valueOf(2147483647));
      AppMethodBeat.o(206734);
      return localObject;
    }
    Object localObject = kotlin.v.Y(Integer.valueOf(0), Integer.valueOf(paramInt));
    AppMethodBeat.o(206734);
    return localObject;
  }
  
  public static androidx.compose.ui.c.a g(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(206740);
    kotlin.g.b.s.u(paramKeyEvent, "keyEvent");
    kotlin.g.b.s.u(paramKeyEvent, "$this$key");
    long l = androidx.compose.ui.g.a.e.cO(paramKeyEvent.getKeyCode());
    a.a locala = androidx.compose.ui.g.a.a.aFj;
    if (androidx.compose.ui.g.a.a.e(l, androidx.compose.ui.g.a.a.vP()))
    {
      kotlin.g.b.s.u(paramKeyEvent, "$this$isShiftPressed");
      if (paramKeyEvent.isShiftPressed()) {
        paramKeyEvent = androidx.compose.ui.c.a.auH;
      }
      for (int i = androidx.compose.ui.c.a.si();; i = androidx.compose.ui.c.a.sh())
      {
        paramKeyEvent = androidx.compose.ui.c.a.cv(i);
        AppMethodBeat.o(206740);
        return paramKeyEvent;
        paramKeyEvent = androidx.compose.ui.c.a.auH;
      }
    }
    paramKeyEvent = androidx.compose.ui.g.a.a.aFj;
    if (androidx.compose.ui.g.a.a.e(l, androidx.compose.ui.g.a.a.vN()))
    {
      paramKeyEvent = androidx.compose.ui.c.a.auH;
      paramKeyEvent = androidx.compose.ui.c.a.cv(androidx.compose.ui.c.a.sk());
      AppMethodBeat.o(206740);
      return paramKeyEvent;
    }
    paramKeyEvent = androidx.compose.ui.g.a.a.aFj;
    if (androidx.compose.ui.g.a.a.e(l, androidx.compose.ui.g.a.a.vM()))
    {
      paramKeyEvent = androidx.compose.ui.c.a.auH;
      paramKeyEvent = androidx.compose.ui.c.a.cv(androidx.compose.ui.c.a.sj());
      AppMethodBeat.o(206740);
      return paramKeyEvent;
    }
    paramKeyEvent = androidx.compose.ui.g.a.a.aFj;
    if (androidx.compose.ui.g.a.a.e(l, androidx.compose.ui.g.a.a.vK()))
    {
      paramKeyEvent = androidx.compose.ui.c.a.auH;
      paramKeyEvent = androidx.compose.ui.c.a.cv(androidx.compose.ui.c.a.sl());
      AppMethodBeat.o(206740);
      return paramKeyEvent;
    }
    paramKeyEvent = androidx.compose.ui.g.a.a.aFj;
    if (androidx.compose.ui.g.a.a.e(l, androidx.compose.ui.g.a.a.vL()))
    {
      paramKeyEvent = androidx.compose.ui.c.a.auH;
      paramKeyEvent = androidx.compose.ui.c.a.cv(androidx.compose.ui.c.a.sm());
      AppMethodBeat.o(206740);
      return paramKeyEvent;
    }
    paramKeyEvent = androidx.compose.ui.g.a.a.aFj;
    if (androidx.compose.ui.g.a.a.e(l, androidx.compose.ui.g.a.a.vO()))
    {
      paramKeyEvent = androidx.compose.ui.c.a.auH;
      paramKeyEvent = androidx.compose.ui.c.a.cv(androidx.compose.ui.c.a.sn());
      AppMethodBeat.o(206740);
      return paramKeyEvent;
    }
    paramKeyEvent = androidx.compose.ui.g.a.a.aFj;
    if (androidx.compose.ui.g.a.a.e(l, androidx.compose.ui.g.a.a.vJ()))
    {
      paramKeyEvent = androidx.compose.ui.c.a.auH;
      paramKeyEvent = androidx.compose.ui.c.a.cv(androidx.compose.ui.c.a.so());
      AppMethodBeat.o(206740);
      return paramKeyEvent;
    }
    AppMethodBeat.o(206740);
    return null;
  }
  
  private void setLayoutDirection(androidx.compose.ui.n.n paramn)
  {
    AppMethodBeat.i(206718);
    this.aRI.setValue(paramn);
    AppMethodBeat.o(206718);
  }
  
  private final void setViewTreeOwners(b paramb)
  {
    AppMethodBeat.i(206710);
    this.aRB.setValue(paramb);
    AppMethodBeat.o(206710);
  }
  
  private final void yA()
  {
    AppMethodBeat.i(206760);
    if (!this.aRy)
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      if (l != this.aRx)
      {
        this.aRx = l;
        yB();
        ViewParent localViewParent = getParent();
        View localView = (View)this;
        while ((localViewParent instanceof ViewGroup))
        {
          localView = (View)localViewParent;
          localViewParent = ((ViewGroup)localView).getParent();
        }
        localView.getLocationOnScreen(this.aRt);
        float f1 = this.aRt[0];
        float f2 = this.aRt[1];
        localView.getLocationInWindow(this.aRt);
        this.aRz = androidx.compose.ui.d.f.x(f1 - this.aRt[0], f2 - this.aRt[1]);
      }
    }
    AppMethodBeat.o(206760);
  }
  
  private final void yB()
  {
    AppMethodBeat.i(206767);
    androidx.compose.ui.e.aj.e(this.aRu);
    a((View)this, this.aRu);
    i.e(this.aRu, this.aRv);
    AppMethodBeat.o(206767);
  }
  
  private static boolean yC()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  private final void yz()
  {
    boolean bool = false;
    AppMethodBeat.i(206737);
    getLocationOnScreen(this.aRt);
    if ((androidx.compose.ui.n.j.bf(this.aRs) != this.aRt[0]) || (androidx.compose.ui.n.j.bg(this.aRs) != this.aRt[1]))
    {
      this.aRs = androidx.compose.ui.n.k.am(this.aRt[0], this.aRt[1]);
      bool = true;
    }
    this.aRr.aw(bool);
    AppMethodBeat.o(206737);
  }
  
  public final void A(androidx.compose.ui.i.f paramf)
  {
    AppMethodBeat.i(207269);
    kotlin.g.b.s.u(paramf, "node");
    androidx.compose.ui.i.l locall = this.aRr;
    kotlin.g.b.s.u(paramf, "node");
    locall.aPD.e(paramf);
    this.aRj = true;
    AppMethodBeat.o(207269);
  }
  
  public final void B(androidx.compose.ui.i.f paramf)
  {
    AppMethodBeat.i(207378);
    kotlin.g.b.s.u(paramf, "layoutNode");
    f localf = this.aRb;
    kotlin.g.b.s.u(paramf, "layoutNode");
    localf.aSi = true;
    if (localf.isAccessibilityEnabled()) {
      localf.F(paramf);
    }
    AppMethodBeat.o(207378);
  }
  
  public final void a(androidx.compose.ui.i.x paramx, boolean paramBoolean)
  {
    AppMethodBeat.i(207393);
    kotlin.g.b.s.u(paramx, "layer");
    if (!paramBoolean)
    {
      if ((!this.aRe) && (!this.aRc.remove(paramx)))
      {
        paramx = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        AppMethodBeat.o(207393);
        throw paramx;
      }
    }
    else
    {
      if (!this.aRe)
      {
        ((Collection)this.aRc).add(paramx);
        AppMethodBeat.o(207393);
        return;
      }
      List localList2 = this.aRd;
      List localList1 = localList2;
      if (localList2 == null)
      {
        localList1 = (List)new ArrayList();
        this.aRd = localList1;
      }
      ((Collection)localList1).add(paramx);
    }
    AppMethodBeat.o(207393);
  }
  
  public final long aJ(long paramLong)
  {
    AppMethodBeat.i(207451);
    yA();
    paramLong = androidx.compose.ui.e.aj.a(this.aRu, paramLong);
    AppMethodBeat.o(207451);
    return paramLong;
  }
  
  public final long as(long paramLong)
  {
    AppMethodBeat.i(207424);
    yA();
    float f1 = androidx.compose.ui.d.e.F(paramLong);
    float f2 = androidx.compose.ui.d.e.F(this.aRz);
    float f3 = androidx.compose.ui.d.e.G(paramLong);
    float f4 = androidx.compose.ui.d.e.G(this.aRz);
    paramLong = androidx.compose.ui.e.aj.a(this.aRv, androidx.compose.ui.d.f.x(f1 - f2, f3 - f4));
    AppMethodBeat.o(207424);
    return paramLong;
  }
  
  public final long at(long paramLong)
  {
    AppMethodBeat.i(207422);
    yA();
    paramLong = androidx.compose.ui.e.aj.a(this.aRu, paramLong);
    paramLong = androidx.compose.ui.d.f.x(androidx.compose.ui.d.e.F(paramLong) + androidx.compose.ui.d.e.F(this.aRz), androidx.compose.ui.d.e.G(paramLong) + androidx.compose.ui.d.e.G(this.aRz));
    AppMethodBeat.o(207422);
    return paramLong;
  }
  
  public final void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    AppMethodBeat.i(207413);
    kotlin.g.b.s.u(paramSparseArray, "values");
    androidx.compose.ui.a.a locala;
    int i;
    int k;
    if (yC())
    {
      locala = this.aRi;
      if (locala != null)
      {
        kotlin.g.b.s.u(locala, "<this>");
        kotlin.g.b.s.u(paramSparseArray, "values");
        i = 0;
        k = paramSparseArray.size();
        if (k <= 0) {}
      }
    }
    for (;;)
    {
      int j = i + 1;
      i = paramSparseArray.keyAt(i);
      AutofillValue localAutofillValue = (AutofillValue)paramSparseArray.get(i);
      Object localObject = androidx.compose.ui.a.d.aui;
      kotlin.g.b.s.s(localAutofillValue, "value");
      if (((androidx.compose.ui.a.d)localObject).a(localAutofillValue))
      {
        localObject = locala.auf;
        kotlin.g.b.s.u(androidx.compose.ui.a.d.aui.e(localAutofillValue).toString(), "value");
        if ((androidx.compose.ui.a.f)((androidx.compose.ui.a.g)localObject).aul.get(Integer.valueOf(i)) != null)
        {
          AppMethodBeat.o(207413);
          throw null;
        }
      }
      else
      {
        if (androidx.compose.ui.a.d.aui.b(localAutofillValue))
        {
          paramSparseArray = (Throwable)new kotlin.q("An operation is not implemented: ".concat(String.valueOf("b/138604541: Add onFill() callback for date")));
          AppMethodBeat.o(207413);
          throw paramSparseArray;
        }
        if (androidx.compose.ui.a.d.aui.c(localAutofillValue))
        {
          paramSparseArray = (Throwable)new kotlin.q("An operation is not implemented: ".concat(String.valueOf("b/138604541: Add onFill() callback for list")));
          AppMethodBeat.o(207413);
          throw paramSparseArray;
        }
        if (androidx.compose.ui.a.d.aui.d(localAutofillValue))
        {
          paramSparseArray = (Throwable)new kotlin.q("An operation is not implemented: ".concat(String.valueOf("b/138604541:  Add onFill() callback for toggle")));
          AppMethodBeat.o(207413);
          throw paramSparseArray;
        }
      }
      if (j >= k)
      {
        AppMethodBeat.o(207413);
        return;
      }
      i = j;
    }
  }
  
  public final androidx.compose.ui.i.x b(kotlin.g.a.b<? super androidx.compose.ui.e.u, ah> paramb, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(207364);
    kotlin.g.b.s.u(paramb, "drawBlock");
    kotlin.g.b.s.u(parama, "invalidateParentLayer");
    if ((Build.VERSION.SDK_INT >= 23) && (this.aRA)) {
      try
      {
        androidx.compose.ui.i.x localx = (androidx.compose.ui.i.x)new aj(this, paramb, parama);
        AppMethodBeat.o(207364);
        return localx;
      }
      finally
      {
        this.aRA = false;
      }
    }
    if (this.aRo == null)
    {
      localObject2 = aw.aVq;
      if (!aw.zq())
      {
        localObject2 = aw.aVq;
        aw.a.u(new View(getContext()));
      }
      localObject2 = aw.aVq;
      if (!aw.zr()) {
        break label177;
      }
      localObject2 = getContext();
      kotlin.g.b.s.s(localObject2, "context");
    }
    for (Object localObject2 = new y((Context)localObject2);; localObject2 = (y)new ax((Context)localObject2))
    {
      this.aRo = ((y)localObject2);
      addView((View)this.aRo);
      localObject2 = this.aRo;
      kotlin.g.b.s.checkNotNull(localObject2);
      paramb = (androidx.compose.ui.i.x)new aw(this, (y)localObject2, paramb, parama);
      AppMethodBeat.o(207364);
      return paramb;
      label177:
      localObject2 = getContext();
      kotlin.g.b.s.s(localObject2, "context");
    }
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject2 = null;
    AppMethodBeat.i(207391);
    kotlin.g.b.s.u(paramCanvas, "canvas");
    Object localObject1 = ComposeView.aTs;
    int j;
    if ((ComposeView.yT()) && (this.aRL))
    {
      if (kotlin.g.b.s.p(paramCanvas, this.aRM)) {
        i = 1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(207391);
        return;
        if (this.aRN <= 10)
        {
          if (this.aRM == null)
          {
            this.aRN += 1;
            localObject1 = new Throwable().getStackTrace();
            kotlin.g.b.s.s(localObject1, "Throwable().stackTrace");
            localObject2 = (Object[])localObject1;
            j = localObject2.length;
            i = 0;
            label117:
            if (i < j)
            {
              localObject1 = localObject2[i];
              if (!kotlin.g.b.s.p(((StackTraceElement)localObject1).getMethodName(), "drawNoChildren")) {}
            }
            for (;;)
            {
              if ((StackTraceElement)localObject1 == null) {
                break label176;
              }
              this.aRM = paramCanvas;
              i = 1;
              break;
              i += 1;
              break label117;
              localObject1 = null;
            }
            label176:
            i = 0;
            continue;
          }
          if (!paramCanvas.isHardwareAccelerated()) {
            break label198;
          }
          this.aRN = 0;
        }
        label269:
        label308:
        label314:
        for (;;)
        {
          i = 0;
          break;
          label198:
          this.aRN += 1;
          localObject1 = new Throwable().getStackTrace();
          kotlin.g.b.s.s(localObject1, "Throwable().stackTrace");
          localObject3 = (Object[])localObject1;
          j = localObject3.length;
          i = 0;
          label241:
          if (i < j)
          {
            localObject1 = localObject3[i];
            if (kotlin.g.b.s.p(((StackTraceElement)localObject1).getMethodName(), "drawNoChildren"))
            {
              localObject1 = (StackTraceElement)localObject1;
              if (localObject1 != null) {
                break label308;
              }
              localObject1 = localObject2;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label314;
            }
            i = 1;
            break;
            i += 1;
            break label241;
            localObject1 = null;
            break label269;
            this.aRM = paramCanvas;
          }
        }
      }
    }
    if (!isAttachedToWindow()) {
      E(getRoot());
    }
    yl();
    this.aRe = true;
    localObject1 = this.aQY;
    localObject2 = ((androidx.compose.ui.e.v)localObject1).awC.avB;
    ((androidx.compose.ui.e.v)localObject1).awC.b(paramCanvas);
    Object localObject3 = (androidx.compose.ui.e.u)((androidx.compose.ui.e.v)localObject1).awC;
    getRoot().d((androidx.compose.ui.e.u)localObject3);
    ((androidx.compose.ui.e.v)localObject1).awC.b((Canvas)localObject2);
    int k;
    if (!((Collection)this.aRc).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        k = this.aRc.size();
        if (k <= 0) {}
      }
    }
    for (int i = 0;; i = j)
    {
      j = i + 1;
      ((androidx.compose.ui.i.x)this.aRc.get(i)).yk();
      if (j >= k)
      {
        localObject1 = aw.aVq;
        if (aw.zr())
        {
          i = paramCanvas.save();
          paramCanvas.clipRect(0.0F, 0.0F, 0.0F, 0.0F);
          super.dispatchDraw(paramCanvas);
          paramCanvas.restoreToCount(i);
        }
        this.aRc.clear();
        this.aRe = false;
        if (this.aRd != null)
        {
          paramCanvas = this.aRd;
          kotlin.g.b.s.checkNotNull(paramCanvas);
          this.aRc.addAll((Collection)paramCanvas);
          paramCanvas.clear();
        }
        AppMethodBeat.o(207391);
        return;
        i = 0;
        break;
      }
    }
  }
  
  public final boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    w localw = null;
    AppMethodBeat.i(207485);
    kotlin.g.b.s.u(paramMotionEvent, "event");
    f localf = this.aRb;
    kotlin.g.b.s.u(paramMotionEvent, "event");
    if (localf.isAccessibilityEnabled()) {}
    Object localObject;
    switch (paramMotionEvent.getAction())
    {
    case 8: 
    default: 
      AppMethodBeat.o(207485);
      return false;
    case 7: 
    case 9: 
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      localf.aRX.yl();
      localObject = (List)new ArrayList();
      localf.aRX.getRoot().e(androidx.compose.ui.d.f.x(f1, f2), (List)localObject);
      localObject = (w)kotlin.a.p.oN((List)localObject);
      if (localObject == null) {
        if ((localw == null) || ((androidx.compose.ui.p.a)localf.aRX.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(localw.aOb) != null)) {
          break label311;
        }
      }
      break;
    }
    label311:
    for (int i = localf.cZ(((androidx.compose.ui.k.l)localw.wb()).getId());; i = -2147483648)
    {
      boolean bool = localf.aRX.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(paramMotionEvent);
      localf.updateHoveredVirtualView(i);
      if (i == -2147483648)
      {
        AppMethodBeat.o(207485);
        return bool;
        localObject = ((androidx.compose.ui.i.j)localObject).aOb;
        if (localObject == null) {
          break;
        }
        localw = androidx.compose.ui.k.p.G((androidx.compose.ui.i.f)localObject);
        break;
      }
      AppMethodBeat.o(207485);
      return true;
      if (localf.aRY != -2147483648)
      {
        localf.updateHoveredVirtualView(-2147483648);
        AppMethodBeat.o(207485);
        return true;
      }
      bool = localf.aRX.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(paramMotionEvent);
      AppMethodBeat.o(207485);
      return bool;
    }
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(207246);
    kotlin.g.b.s.u(paramKeyEvent, "event");
    if (isFocused())
    {
      kotlin.g.b.s.u(paramKeyEvent, "nativeKeyEvent");
      kotlin.g.b.s.u(paramKeyEvent, "keyEvent");
      Object localObject1 = this.aQX;
      kotlin.g.b.s.u(paramKeyEvent, "keyEvent");
      localObject1 = ((androidx.compose.ui.g.a.d)localObject1).aKr;
      if (localObject1 != null)
      {
        localObject1 = ((androidx.compose.ui.i.r)localObject1).xj();
        if (localObject1 != null) {
          break label110;
        }
        localObject1 = localObject2;
      }
      for (;;)
      {
        if (localObject1 != null) {
          break label133;
        }
        paramKeyEvent = (Throwable)new IllegalStateException("KeyEvent can't be processed because this key input node is not active.".toString());
        AppMethodBeat.o(207246);
        throw paramKeyEvent;
        kotlin.g.b.s.bIx("keyInputNode");
        localObject1 = null;
        break;
        label110:
        androidx.compose.ui.i.o localo = androidx.compose.ui.c.n.c((androidx.compose.ui.i.o)localObject1);
        localObject1 = localObject2;
        if (localo != null) {
          localObject1 = localo.xn();
        }
      }
      label133:
      if (((androidx.compose.ui.i.r)localObject1).e(paramKeyEvent))
      {
        AppMethodBeat.o(207246);
        return true;
      }
      bool = ((androidx.compose.ui.i.r)localObject1).f(paramKeyEvent);
      AppMethodBeat.o(207246);
      return bool;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(207246);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207421);
    kotlin.g.b.s.u(paramMotionEvent, "motionEvent");
    if ((Float.isNaN(paramMotionEvent.getX())) || (Float.isNaN(paramMotionEvent.getY())) || (Float.isNaN(paramMotionEvent.getRawX())) || (Float.isNaN(paramMotionEvent.getRawY())))
    {
      AppMethodBeat.o(207421);
      return false;
    }
    long l1;
    androidx.compose.ui.g.c.e locale;
    androidx.compose.ui.g.c.z localz;
    int i;
    label198:
    int j;
    label209:
    boolean bool;
    label232:
    int m;
    label276:
    label308:
    label331:
    int k;
    List localList;
    Integer localInteger1;
    label357:
    Object localObject;
    Integer localInteger2;
    for (;;)
    {
      try
      {
        this.aRx = AnimationUtils.currentAnimationTimeMillis();
        yB();
        l1 = androidx.compose.ui.e.aj.a(this.aRu, androidx.compose.ui.d.f.x(paramMotionEvent.getX(), paramMotionEvent.getY()));
        this.aRz = androidx.compose.ui.d.f.x(paramMotionEvent.getRawX() - androidx.compose.ui.d.e.F(l1), paramMotionEvent.getRawY() - androidx.compose.ui.d.e.G(l1));
        this.aRy = true;
        yl();
        Trace.beginSection("AndroidOwner:onTouch");
        try
        {
          locale = this.aRf;
          localz = (androidx.compose.ui.g.c.z)this;
          kotlin.g.b.s.u(paramMotionEvent, "motionEvent");
          kotlin.g.b.s.u(localz, "positionCalculator");
          if (paramMotionEvent.getActionMasked() == 3)
          {
            locale.aKZ.clear();
            paramMotionEvent = null;
            if (paramMotionEvent == null) {
              break label849;
            }
            i = this.aRg.a(paramMotionEvent, (androidx.compose.ui.g.c.z)this);
            Trace.endSection();
            if ((i & 0x2) == 0) {
              break label865;
            }
            j = 1;
            if (j != 0) {
              getParent().requestDisallowInterceptTouchEvent(true);
            }
            if ((i & 0x1) == 0) {
              break label870;
            }
            bool = true;
            return bool;
          }
          switch (paramMotionEvent.getActionMasked())
          {
          case 5: 
            switch (paramMotionEvent.getActionMasked())
            {
            case 6: 
              locale.aLa.clear();
              m = paramMotionEvent.getPointerCount();
              if (m <= 0) {
                break label707;
              }
              j = 0;
              k = j + 1;
              localList = locale.aLa;
              i = paramMotionEvent.getPointerId(j);
              if (localInteger1 != null) {
                break label468;
              }
            }
            break;
          }
        }
        finally
        {
          Trace.endSection();
          AppMethodBeat.o(207421);
        }
        localObject = (androidx.compose.ui.g.c.l)locale.aKZ.get(Integer.valueOf(i));
        if (localObject != null) {
          break;
        }
        paramMotionEvent = new IllegalStateException("Compose assumes that all pointer ids in MotionEvents are first provided alongside ACTION_DOWN or ACTION_POINTER_DOWN.  This appears not to have been the case");
        AppMethodBeat.o(207421);
        throw paramMotionEvent;
      }
      finally
      {
        this.aRy = false;
        AppMethodBeat.o(207421);
      }
      localInteger1 = Integer.valueOf(paramMotionEvent.getActionIndex());
      continue;
      localInteger1 = Integer.valueOf(0);
      continue;
      localInteger2 = Integer.valueOf(paramMotionEvent.getActionIndex());
      continue;
      localInteger2 = Integer.valueOf(0);
      continue;
      label468:
      if (j != localInteger1.intValue()) {
        break label894;
      }
      l1 = locale.aKY;
      locale.aKY = (1L + l1);
      localObject = androidx.compose.ui.g.c.l.ar(l1);
      l1 = ((androidx.compose.ui.g.c.l)localObject).value;
      locale.aKZ.put(Integer.valueOf(i), androidx.compose.ui.g.c.l.ar(l1));
      continue;
      label530:
      if (j == localInteger2.intValue()) {
        localObject = (androidx.compose.ui.g.c.l)locale.aKZ.remove(Integer.valueOf(i));
      }
    }
    long l3 = ((androidx.compose.ui.g.c.l)localObject).value;
    long l4 = paramMotionEvent.getEventTime();
    long l2 = androidx.compose.ui.d.f.x(paramMotionEvent.getX(j), paramMotionEvent.getY(j));
    label656:
    label665:
    if (j == 0)
    {
      l1 = androidx.compose.ui.d.f.x(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
      l2 = localz.as(l1);
      label617:
      switch (paramMotionEvent.getToolType(j))
      {
      case 0: 
        localObject = androidx.compose.ui.g.c.y.aLM;
        i = androidx.compose.ui.g.c.y.vQ();
        if (localInteger2 != null) {
          break;
        }
        break;
      }
    }
    for (;;)
    {
      localList.add(new androidx.compose.ui.g.c.p(l3, l4, l1, l2, bool, i, (byte)0));
      if (k >= m)
      {
        label707:
        paramMotionEvent = new androidx.compose.ui.g.c.o(paramMotionEvent.getEventTime(), locale.aLa, paramMotionEvent);
        break;
        if (Build.VERSION.SDK_INT >= 29)
        {
          l1 = androidx.compose.ui.g.c.f.aLb.b(paramMotionEvent, j);
          l2 = localz.as(l1);
          break label617;
        }
        l1 = localz.at(l2);
        break label617;
        localObject = androidx.compose.ui.g.c.y.aLM;
        i = androidx.compose.ui.g.c.y.vQ();
        break label665;
        localObject = androidx.compose.ui.g.c.y.aLM;
        i = androidx.compose.ui.g.c.y.ws();
        break label665;
        localObject = androidx.compose.ui.g.c.y.aLM;
        i = androidx.compose.ui.g.c.y.wu();
        break label665;
        localObject = androidx.compose.ui.g.c.y.aLM;
        i = androidx.compose.ui.g.c.y.wt();
        break label665;
        localObject = androidx.compose.ui.g.c.y.aLM;
        i = androidx.compose.ui.g.c.y.wv();
        break label665;
        if (j != localInteger2.intValue()) {
          break label905;
        }
        bool = false;
        continue;
        label849:
        this.aRg.wo();
        i = androidx.compose.ui.g.c.r.f(false, false);
        break label198;
        label865:
        j = 0;
        break label209;
        label870:
        bool = false;
        break label232;
      }
      j = k;
      break label331;
      localInteger1 = null;
      break label276;
      localInteger2 = null;
      break label308;
      label894:
      if (localInteger2 != null) {
        break label530;
      }
      break label357;
      break label656;
      label905:
      bool = true;
    }
  }
  
  public final View findViewByAccessibilityIdTraversal(int paramInt)
  {
    AppMethodBeat.i(207496);
    try
    {
      if (Build.VERSION.SDK_INT >= 29)
      {
        localObject = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", new Class[] { Integer.TYPE });
        ((Method)localObject).setAccessible(true);
        localObject = ((Method)localObject).invoke(this, new Object[] { Integer.valueOf(paramInt) });
        if ((localObject instanceof View))
        {
          localObject = (View)localObject;
          AppMethodBeat.o(207496);
          return localObject;
        }
        AppMethodBeat.o(207496);
        return null;
      }
      Object localObject = a(paramInt, (View)this);
      AppMethodBeat.o(207496);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AppMethodBeat.o(207496);
    }
    return null;
  }
  
  public final d getAccessibilityManager()
  {
    return this.aRl;
  }
  
  public final r getAndroidViewsHandler$ui_release()
  {
    AppMethodBeat.i(207018);
    if (this.aRn == null)
    {
      localObject = getContext();
      kotlin.g.b.s.s(localObject, "context");
      this.aRn = new r((Context)localObject);
      addView((View)this.aRn);
    }
    Object localObject = this.aRn;
    kotlin.g.b.s.checkNotNull(localObject);
    AppMethodBeat.o(207018);
    return localObject;
  }
  
  public final androidx.compose.ui.a.b getAutofill()
  {
    return (androidx.compose.ui.a.b)this.aRi;
  }
  
  public final androidx.compose.ui.a.g getAutofillTree()
  {
    return this.auf;
  }
  
  public final e getClipboardManager()
  {
    return this.aRk;
  }
  
  public final kotlin.g.a.b<Configuration, ah> getConfigurationChangeObserver()
  {
    return this.aRh;
  }
  
  public final androidx.compose.ui.n.d getDensity()
  {
    return this.TD;
  }
  
  public final androidx.compose.ui.c.c getFocusManager()
  {
    return (androidx.compose.ui.c.c)this.aQV;
  }
  
  public final c.a getFontLoader()
  {
    return this.aRH;
  }
  
  public final androidx.compose.ui.f.a getHapticFeedBack()
  {
    return this.aRJ;
  }
  
  public final boolean getHasPendingMeasureOrLayout()
  {
    AppMethodBeat.i(207048);
    if (!this.aRr.aPD.aNV.isEmpty())
    {
      AppMethodBeat.o(207048);
      return true;
    }
    AppMethodBeat.o(207048);
    return false;
  }
  
  public final long getLastMatrixRecalculationAnimationTime$ui_release()
  {
    return this.aRx;
  }
  
  public final androidx.compose.ui.n.n getLayoutDirection()
  {
    AppMethodBeat.i(207142);
    androidx.compose.ui.n.n localn = (androidx.compose.ui.n.n)((bm)this.aRI).getValue();
    AppMethodBeat.o(207142);
    return localn;
  }
  
  public final long getMeasureIteration()
  {
    AppMethodBeat.i(207026);
    long l = this.aRr.getMeasureIteration();
    AppMethodBeat.o(207026);
    return l;
  }
  
  public final androidx.compose.ui.i.f getRoot()
  {
    return this.aLw;
  }
  
  public final ae getRootForTest()
  {
    return this.aQZ;
  }
  
  public final androidx.compose.ui.k.q getSemanticsOwner()
  {
    return this.aRa;
  }
  
  public final boolean getShowLayoutBounds()
  {
    return this.aQw;
  }
  
  public final aa getSnapshotObserver()
  {
    return this.aRm;
  }
  
  public final androidx.compose.ui.m.c.s getTextInputService()
  {
    return this.aRG;
  }
  
  public final ao getTextToolbar()
  {
    return this.aRK;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final av getViewConfiguration()
  {
    return this.ahE;
  }
  
  public final b getViewTreeOwners()
  {
    AppMethodBeat.i(207093);
    b localb = (b)((bm)this.aRB).getValue();
    AppMethodBeat.o(207093);
    return localb;
  }
  
  public final ba getWindowInfo()
  {
    return (ba)this.aQW;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(207401);
    super.onAttachedToWindow();
    D(getRoot());
    E(getRoot());
    getSnapshotObserver().aQm.start();
    if (yC())
    {
      localObject1 = this.aRi;
      if (localObject1 != null) {
        androidx.compose.ui.a.e.auj.a((androidx.compose.ui.a.a)localObject1);
      }
    }
    Object localObject1 = al.be((View)this);
    Object localObject2 = androidx.savedstate.e.bP((View)this);
    Object localObject3 = getViewTreeOwners();
    int i;
    if ((localObject3 == null) || ((localObject1 != null) && (localObject2 != null) && ((localObject1 != ((b)localObject3).lifecycleOwner) || (localObject2 != ((b)localObject3).lifecycleOwner)))) {
      i = 1;
    }
    while (i != 0) {
      if (localObject1 == null)
      {
        localObject1 = new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
        AppMethodBeat.o(207401);
        throw ((Throwable)localObject1);
        i = 0;
      }
      else
      {
        if (localObject2 == null)
        {
          localObject1 = new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
          AppMethodBeat.o(207401);
          throw ((Throwable)localObject1);
        }
        if (localObject3 != null)
        {
          localObject3 = ((b)localObject3).lifecycleOwner.getLifecycle();
          if (localObject3 != null) {
            ((androidx.lifecycle.j)localObject3).removeObserver((androidx.lifecycle.p)this);
          }
        }
        ((androidx.lifecycle.q)localObject1).getLifecycle().addObserver((androidx.lifecycle.p)this);
        localObject1 = new b((androidx.lifecycle.q)localObject1, (androidx.savedstate.d)localObject2);
        setViewTreeOwners((b)localObject1);
        localObject2 = this.aRC;
        if (localObject2 != null) {
          ((kotlin.g.a.b)localObject2).invoke(localObject1);
        }
        this.aRC = null;
      }
    }
    localObject1 = getViewTreeOwners();
    kotlin.g.b.s.checkNotNull(localObject1);
    ((b)localObject1).lifecycleOwner.getLifecycle().addObserver((androidx.lifecycle.p)this);
    getViewTreeObserver().addOnGlobalLayoutListener(this.aRD);
    getViewTreeObserver().addOnScrollChangedListener(this.aRE);
    AppMethodBeat.o(207401);
  }
  
  public final boolean onCheckIsTextEditor()
  {
    return this.aRF.bdn;
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(207460);
    kotlin.g.b.s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Context localContext = getContext();
    kotlin.g.b.s.s(localContext, "context");
    this.TD = androidx.compose.ui.n.a.W(localContext);
    this.aRh.invoke(paramConfiguration);
    AppMethodBeat.o(207460);
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    int i = 6;
    AppMethodBeat.i(207438);
    kotlin.g.b.s.u(paramEditorInfo, "outAttrs");
    t localt = this.aRF;
    kotlin.g.b.s.u(paramEditorInfo, "outAttrs");
    if (!localt.bdn)
    {
      AppMethodBeat.o(207438);
      return null;
    }
    androidx.compose.ui.m.c.g localg = localt.bdr;
    androidx.compose.ui.m.c.r localr = localt.bdq;
    kotlin.g.b.s.u(paramEditorInfo, "<this>");
    kotlin.g.b.s.u(localg, "imeOptions");
    kotlin.g.b.s.u(localr, "textFieldValue");
    int j = localg.bcJ;
    Object localObject = androidx.compose.ui.m.c.f.bcy;
    if (androidx.compose.ui.m.c.f.C(j, androidx.compose.ui.m.c.f.Bm())) {
      if (localg.bcF)
      {
        paramEditorInfo.imeOptions = i;
        i = localg.bcI;
        localObject = androidx.compose.ui.m.c.l.bcQ;
        if (!androidx.compose.ui.m.c.l.C(i, androidx.compose.ui.m.c.l.Bx())) {
          break label543;
        }
        paramEditorInfo.inputType = 1;
        label142:
        if ((!localg.bcF) && (androidx.compose.ui.m.c.u.dB(paramEditorInfo.inputType)))
        {
          paramEditorInfo.inputType |= 0x20000;
          i = localg.bcJ;
          localObject = androidx.compose.ui.m.c.f.bcy;
          if (androidx.compose.ui.m.c.f.C(i, androidx.compose.ui.m.c.f.Bm())) {
            paramEditorInfo.imeOptions |= 0x40000000;
          }
        }
        if (androidx.compose.ui.m.c.u.dB(paramEditorInfo.inputType))
        {
          i = localg.bcG;
          localObject = androidx.compose.ui.m.c.k.bcM;
          if (!androidx.compose.ui.m.c.k.C(i, androidx.compose.ui.m.c.k.Bu())) {
            break label746;
          }
          paramEditorInfo.inputType |= 0x1000;
        }
      }
    }
    for (;;)
    {
      if (localg.bcH) {
        paramEditorInfo.inputType |= 0x8000;
      }
      paramEditorInfo.initialSelStart = androidx.compose.ui.m.s.aN(localr.bdg);
      paramEditorInfo.initialSelEnd = androidx.compose.ui.m.s.aO(localr.bdg);
      androidx.core.g.c.a.a(paramEditorInfo, (CharSequence)localr.aYS.text);
      paramEditorInfo.imeOptions |= 0x2000000;
      paramEditorInfo = localt.bdq;
      boolean bool = localt.bdr.bcH;
      paramEditorInfo = new androidx.compose.ui.m.c.n(paramEditorInfo, (androidx.compose.ui.m.c.h)new t.b(localt), bool);
      localt.bds = paramEditorInfo;
      paramEditorInfo = (InputConnection)paramEditorInfo;
      AppMethodBeat.o(207438);
      return paramEditorInfo;
      i = 0;
      break;
      localObject = androidx.compose.ui.m.c.f.bcy;
      if (androidx.compose.ui.m.c.f.C(j, androidx.compose.ui.m.c.f.Bn()))
      {
        i = 1;
        break;
      }
      localObject = androidx.compose.ui.m.c.f.bcy;
      if (androidx.compose.ui.m.c.f.C(j, androidx.compose.ui.m.c.f.Bo()))
      {
        i = 2;
        break;
      }
      localObject = androidx.compose.ui.m.c.f.bcy;
      if (androidx.compose.ui.m.c.f.C(j, androidx.compose.ui.m.c.f.sh()))
      {
        i = 5;
        break;
      }
      localObject = androidx.compose.ui.m.c.f.bcy;
      if (androidx.compose.ui.m.c.f.C(j, androidx.compose.ui.m.c.f.si()))
      {
        i = 7;
        break;
      }
      localObject = androidx.compose.ui.m.c.f.bcy;
      if (androidx.compose.ui.m.c.f.C(j, androidx.compose.ui.m.c.f.Bp()))
      {
        i = 3;
        break;
      }
      localObject = androidx.compose.ui.m.c.f.bcy;
      if (androidx.compose.ui.m.c.f.C(j, androidx.compose.ui.m.c.f.Bq()))
      {
        i = 4;
        break;
      }
      localObject = androidx.compose.ui.m.c.f.bcy;
      if (androidx.compose.ui.m.c.f.C(j, androidx.compose.ui.m.c.f.Br())) {
        break;
      }
      paramEditorInfo = (Throwable)new IllegalStateException("invalid ImeAction".toString());
      AppMethodBeat.o(207438);
      throw paramEditorInfo;
      label543:
      localObject = androidx.compose.ui.m.c.l.bcQ;
      if (androidx.compose.ui.m.c.l.C(i, androidx.compose.ui.m.c.l.By()))
      {
        paramEditorInfo.inputType = 1;
        paramEditorInfo.imeOptions |= 0x80000000;
        break label142;
      }
      localObject = androidx.compose.ui.m.c.l.bcQ;
      if (androidx.compose.ui.m.c.l.C(i, androidx.compose.ui.m.c.l.Bz()))
      {
        paramEditorInfo.inputType = 2;
        break label142;
      }
      localObject = androidx.compose.ui.m.c.l.bcQ;
      if (androidx.compose.ui.m.c.l.C(i, androidx.compose.ui.m.c.l.BA()))
      {
        paramEditorInfo.inputType = 3;
        break label142;
      }
      localObject = androidx.compose.ui.m.c.l.bcQ;
      if (androidx.compose.ui.m.c.l.C(i, androidx.compose.ui.m.c.l.BB()))
      {
        paramEditorInfo.inputType = 17;
        break label142;
      }
      localObject = androidx.compose.ui.m.c.l.bcQ;
      if (androidx.compose.ui.m.c.l.C(i, androidx.compose.ui.m.c.l.BC()))
      {
        paramEditorInfo.inputType = 33;
        break label142;
      }
      localObject = androidx.compose.ui.m.c.l.bcQ;
      if (androidx.compose.ui.m.c.l.C(i, androidx.compose.ui.m.c.l.BD()))
      {
        paramEditorInfo.inputType = 129;
        break label142;
      }
      localObject = androidx.compose.ui.m.c.l.bcQ;
      if (androidx.compose.ui.m.c.l.C(i, androidx.compose.ui.m.c.l.BE()))
      {
        paramEditorInfo.inputType = 18;
        break label142;
      }
      paramEditorInfo = (Throwable)new IllegalStateException("Invalid Keyboard Type".toString());
      AppMethodBeat.o(207438);
      throw paramEditorInfo;
      label746:
      localObject = androidx.compose.ui.m.c.k.bcM;
      if (androidx.compose.ui.m.c.k.C(i, androidx.compose.ui.m.c.k.Bv()))
      {
        paramEditorInfo.inputType |= 0x2000;
      }
      else
      {
        localObject = androidx.compose.ui.m.c.k.bcM;
        if (androidx.compose.ui.m.c.k.C(i, androidx.compose.ui.m.c.k.Bw())) {
          paramEditorInfo.inputType |= 0x4000;
        }
      }
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(207404);
    super.onDetachedFromWindow();
    Object localObject = getSnapshotObserver();
    ((aa)localObject).aQm.stop();
    ((aa)localObject).aQm.clear();
    localObject = getViewTreeOwners();
    if (localObject != null)
    {
      localObject = ((b)localObject).lifecycleOwner.getLifecycle();
      if (localObject != null) {
        ((androidx.lifecycle.j)localObject).removeObserver((androidx.lifecycle.p)this);
      }
    }
    if (yC())
    {
      localObject = this.aRi;
      if (localObject != null) {
        androidx.compose.ui.a.e.auj.b((androidx.compose.ui.a.a)localObject);
      }
    }
    getViewTreeObserver().removeOnGlobalLayoutListener(this.aRD);
    getViewTreeObserver().removeOnScrollChangedListener(this.aRE);
    AppMethodBeat.o(207404);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(207353);
    kotlin.g.b.s.u(paramCanvas, "canvas");
    AppMethodBeat.o(207353);
  }
  
  protected final void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(207210);
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    androidx.compose.ui.c.f.sr();
    new StringBuilder("Owner FocusChanged(").append(paramBoolean).append(')');
    paramRect = this.aQV;
    if (paramBoolean)
    {
      if (paramRect.auO.auP == androidx.compose.ui.c.l.avj) {
        paramRect.auO.a(androidx.compose.ui.c.l.ave);
      }
      AppMethodBeat.o(207210);
      return;
    }
    androidx.compose.ui.c.m.a(paramRect.auO.sq(), true);
    AppMethodBeat.o(207210);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(207344);
    this.aRp = null;
    yz();
    if (this.aRn != null) {
      getAndroidViewsHandler$ui_release().layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    AppMethodBeat.o(207344);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207334);
    Trace.beginSection("AndroidOwner:onMeasure");
    for (;;)
    {
      long l;
      androidx.compose.ui.n.b localb;
      try
      {
        if (!isAttachedToWindow()) {
          D(getRoot());
        }
        Object localObject1 = cX(paramInt1);
        paramInt1 = ((Number)((kotlin.r)localObject1).bsC).intValue();
        int i = ((Number)((kotlin.r)localObject1).bsD).intValue();
        localObject1 = cX(paramInt2);
        l = androidx.compose.ui.n.c.k(paramInt1, i, ((Number)((kotlin.r)localObject1).bsC).intValue(), ((Number)((kotlin.r)localObject1).bsD).intValue());
        if (this.aRp == null)
        {
          this.aRp = androidx.compose.ui.n.b.bb(l);
          this.aRq = false;
          localObject1 = this.aRr;
          localb = ((androidx.compose.ui.i.l)localObject1).aPI;
          if (localb != null) {
            break label236;
          }
          bool = false;
          if (bool) {
            break label285;
          }
          if (((androidx.compose.ui.i.l)localObject1).aPF) {
            break label378;
          }
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label251;
          }
          localObject1 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
          AppMethodBeat.o(207334);
          throw ((Throwable)localObject1);
        }
      }
      finally
      {
        Trace.endSection();
        AppMethodBeat.o(207334);
      }
      Object localObject3 = this.aRp;
      if (localObject3 == null) {}
      for (boolean bool = false;; bool = androidx.compose.ui.n.b.e(((androidx.compose.ui.n.b)localObject3).value, l))
      {
        if (bool) {
          break label234;
        }
        this.aRq = true;
        break;
      }
      label234:
      continue;
      label236:
      bool = androidx.compose.ui.n.b.e(localb.value, l);
      continue;
      label251:
      ((androidx.compose.ui.i.l)localObject3).aPI = androidx.compose.ui.n.b.bb(l);
      ((androidx.compose.ui.i.l)localObject3).aLw.a(f.d.aOO);
      ((androidx.compose.ui.i.l)localObject3).aPD.d(((androidx.compose.ui.i.l)localObject3).aLw);
      label285:
      this.aRr.yd();
      setMeasuredDimension(getRoot().aOD.width, getRoot().aOD.height);
      if (this.aRn != null) {
        getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().aOD.width, 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().aOD.height, 1073741824));
      }
      localObject3 = ah.aiuX;
      Trace.endSection();
      AppMethodBeat.o(207334);
      return;
      label378:
      paramInt1 = 0;
    }
  }
  
  public final void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(207409);
    if ((yC()) && (paramViewStructure != null))
    {
      androidx.compose.ui.a.a locala = this.aRi;
      if (locala != null)
      {
        kotlin.g.b.s.u(locala, "<this>");
        kotlin.g.b.s.u(paramViewStructure, "root");
        paramInt = androidx.compose.ui.a.c.auh.b(paramViewStructure, locala.auf.aul.size());
        Object localObject2 = locala.auf.aul.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject1 = (Map.Entry)((Iterator)localObject2).next();
          int i = ((Number)((Map.Entry)localObject1).getKey()).intValue();
          ((Map.Entry)localObject1).getValue();
          localObject1 = androidx.compose.ui.a.c.auh.a(paramViewStructure, paramInt);
          if (localObject1 != null)
          {
            localObject2 = androidx.compose.ui.a.d.aui;
            paramViewStructure = androidx.compose.ui.a.d.aui.a(paramViewStructure);
            kotlin.g.b.s.checkNotNull(paramViewStructure);
            ((androidx.compose.ui.a.d)localObject2).a((ViewStructure)localObject1, paramViewStructure, i);
            androidx.compose.ui.a.c.auh.a((ViewStructure)localObject1, i, locala.view.getContext().getPackageName(), null, null);
            androidx.compose.ui.a.d.aui.c((ViewStructure)localObject1, 1);
            paramViewStructure = androidx.compose.ui.a.d.aui;
            AppMethodBeat.o(207409);
            throw null;
          }
          paramInt += 1;
        }
      }
    }
    AppMethodBeat.o(207409);
  }
  
  @androidx.lifecycle.z(Ho=j.a.ON_RESUME)
  public final void onResume(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(207189);
    kotlin.g.b.s.u(paramq, "owner");
    setShowLayoutBounds(a.yF());
    AppMethodBeat.o(207189);
  }
  
  public final void onRtlPropertiesChanged(int paramInt)
  {
    AppMethodBeat.i(207468);
    if (this.aQT) {
      setLayoutDirection(i.dc(paramInt));
    }
    AppMethodBeat.o(207468);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(207233);
    this.aQW.aVI.setValue(Boolean.valueOf(paramBoolean));
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(207233);
  }
  
  public final void setConfigurationChangeObserver(kotlin.g.a.b<? super Configuration, ah> paramb)
  {
    AppMethodBeat.i(206958);
    kotlin.g.b.s.u(paramb, "<set-?>");
    this.aRh = paramb;
    AppMethodBeat.o(206958);
  }
  
  public final void setLastMatrixRecalculationAnimationTime$ui_release(long paramLong)
  {
    this.aRx = paramLong;
  }
  
  public final void setOnViewTreeOwnersAvailable(kotlin.g.a.b<? super b, ah> paramb)
  {
    AppMethodBeat.i(207396);
    kotlin.g.b.s.u(paramb, "callback");
    b localb = getViewTreeOwners();
    if (localb != null) {
      paramb.invoke(localb);
    }
    if (!isAttachedToWindow()) {
      this.aRC = paramb;
    }
    AppMethodBeat.o(207396);
  }
  
  public final void setShowLayoutBounds(boolean paramBoolean)
  {
    this.aQw = paramBoolean;
  }
  
  public final void x(androidx.compose.ui.i.f paramf)
  {
    AppMethodBeat.i(207300);
    kotlin.g.b.s.u(paramf, "layoutNode");
    if (this.aRr.t(paramf)) {
      C(paramf);
    }
    AppMethodBeat.o(207300);
  }
  
  public final void y(androidx.compose.ui.i.f paramf)
  {
    AppMethodBeat.i(207314);
    kotlin.g.b.s.u(paramf, "layoutNode");
    if (this.aRr.u(paramf)) {
      C(null);
    }
    AppMethodBeat.o(207314);
  }
  
  public final void yl()
  {
    AppMethodBeat.i(207289);
    if (this.aRr.yd()) {
      requestLayout();
    }
    this.aRr.aw(false);
    AppMethodBeat.o(207289);
  }
  
  public final void ym()
  {
    AppMethodBeat.i(207371);
    f localf = this.aRb;
    localf.aSi = true;
    if ((localf.isAccessibilityEnabled()) && (!localf.aSo))
    {
      localf.aSo = true;
      localf.handler.post(localf.aSp);
    }
    AppMethodBeat.o(207371);
  }
  
  public final void yo()
  {
    AppMethodBeat.i(207281);
    if (this.aRj)
    {
      getSnapshotObserver().yo();
      this.aRj = false;
    }
    r localr = this.aRn;
    if (localr != null) {
      b((ViewGroup)localr);
    }
    AppMethodBeat.o(207281);
  }
  
  public final void z(androidx.compose.ui.i.f paramf)
  {
    AppMethodBeat.i(207256);
    kotlin.g.b.s.u(paramf, "node");
    AppMethodBeat.o(207256);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static boolean yF()
    {
      AppMethodBeat.i(206619);
      try
      {
        if (AndroidComposeView.yD() == null)
        {
          AndroidComposeView.h(Class.forName("android.os.SystemProperties"));
          localObject1 = AndroidComposeView.yD();
          if (localObject1 != null) {
            break label68;
          }
          localObject1 = null;
          AndroidComposeView.b((Method)localObject1);
        }
        localObject1 = AndroidComposeView.yE();
        if (localObject1 != null) {
          break label93;
        }
        localObject1 = null;
        label43:
        if (!(localObject1 instanceof Boolean)) {
          break label131;
        }
        localObject1 = (Boolean)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          label68:
          label93:
          boolean bool = false;
          continue;
          Object localObject2 = null;
        }
      }
      if (localObject1 == null) {}
      for (bool = false;; bool = ((Boolean)localObject1).booleanValue())
      {
        AppMethodBeat.o(206619);
        return bool;
        localObject1 = ((Class)localObject1).getDeclaredMethod("getBoolean", new Class[] { String.class, Boolean.TYPE });
        break;
        localObject1 = ((Method)localObject1).invoke(null, new Object[] { "debug.layout", Boolean.FALSE });
        break label43;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final int Ue = 8;
    final androidx.savedstate.d aRQ;
    final androidx.lifecycle.q lifecycleOwner;
    
    public b(androidx.lifecycle.q paramq, androidx.savedstate.d paramd)
    {
      AppMethodBeat.i(206615);
      this.lifecycleOwner = paramq;
      this.aRQ = paramd;
      AppMethodBeat.o(206615);
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/platform/AndroidComposeView$addAndroidView$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends androidx.core.g.a
  {
    public c(androidx.compose.ui.i.f paramf, AndroidComposeView paramAndroidComposeView1, AndroidComposeView paramAndroidComposeView2) {}
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, androidx.core.g.a.d paramd)
    {
      AppMethodBeat.i(206621);
      super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      paramView = androidx.compose.ui.k.p.G(this.aRR);
      kotlin.g.b.s.checkNotNull(paramView);
      paramView = new androidx.compose.ui.k.o(paramView, false).Ac();
      kotlin.g.b.s.checkNotNull(paramView);
      int i = paramView.id;
      if (i == this.aRS.getSemanticsOwner().Ae().id) {
        i = -1;
      }
      for (;;)
      {
        kotlin.g.b.s.checkNotNull(paramd);
        paramd.A((View)this.aRT, i);
        AppMethodBeat.o(206621);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    e(AndroidComposeView paramAndroidComposeView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(206620);
      AndroidComposeView.a(this.aRS);
      AppMethodBeat.o(206620);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/input/key/KeyEvent;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<androidx.compose.ui.g.a.b, Boolean>
  {
    f(AndroidComposeView paramAndroidComposeView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    implements ViewTreeObserver.OnScrollChangedListener
  {
    g(AndroidComposeView paramAndroidComposeView) {}
    
    public final void onScrollChanged()
    {
      AppMethodBeat.i(206562);
      AndroidComposeView.a(this.aRS);
      AppMethodBeat.o(206562);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.AndroidComposeView
 * JD-Core Version:    0.7.0.1
 */