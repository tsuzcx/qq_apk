package android.support.v4.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.c;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class u
{
  private static final AtomicInteger QH = new AtomicInteger(1);
  private static Field QI;
  private static boolean QJ;
  private static Field QK;
  private static boolean QL;
  private static WeakHashMap<View, String> QM;
  private static WeakHashMap<View, y> QN = null;
  private static Field QO;
  private static boolean QP = false;
  private static ThreadLocal<Rect> QQ;
  
  @Deprecated
  public static int S(View paramView)
  {
    return paramView.getOverScrollMode();
  }
  
  @SuppressLint({"InlinedApi"})
  public static int T(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.getImportantForAutofill();
    }
    return 0;
  }
  
  public static void U(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setImportantForAutofill(8);
    }
  }
  
  public static boolean V(View paramView)
  {
    if (QP) {}
    for (;;)
    {
      return false;
      if (QO == null) {}
      try
      {
        Field localField = View.class.getDeclaredField("mAccessibilityDelegate");
        QO = localField;
        localField.setAccessible(true);
      }
      catch (Throwable paramView)
      {
        try
        {
          paramView = QO.get(paramView);
          if (paramView == null) {
            continue;
          }
          return true;
        }
        catch (Throwable paramView)
        {
          QP = true;
        }
        paramView = paramView;
        QP = true;
        return false;
      }
    }
    return false;
  }
  
  public static boolean W(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.hasTransientState();
    }
    return false;
  }
  
  public static void X(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postInvalidateOnAnimation();
      return;
    }
    paramView.postInvalidate();
  }
  
  public static int Y(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getImportantForAccessibility();
    }
    return 0;
  }
  
  public static int Z(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getLayoutDirection();
    }
    return 0;
  }
  
  public static ac a(View paramView, ac paramac)
  {
    Object localObject = paramac;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramac = (WindowInsets)ac.c(paramac);
      localObject = paramView.onApplyWindowInsets(paramac);
      paramView = paramac;
      if (localObject != paramac) {
        paramView = new WindowInsets((WindowInsets)localObject);
      }
      localObject = ac.G(paramView);
    }
    return localObject;
  }
  
  public static void a(View paramView, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setBackgroundTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramView.getBackground();
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          break label72;
        }
        i = 1;
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramColorStateList);
        }
      }
    }
    label72:
    while (!(paramView instanceof s)) {
      for (;;)
      {
        return;
        int i = 0;
      }
    }
    ((s)paramView).setSupportBackgroundTintList(paramColorStateList);
  }
  
  public static void a(View paramView, Paint paramPaint)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView.setLayerPaint(paramPaint);
      return;
    }
    paramView.setLayerType(paramView.getLayerType(), paramPaint);
    paramView.invalidate();
  }
  
  public static void a(View paramView, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setBackgroundTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramView.getBackground();
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          break label72;
        }
        i = 1;
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramMode);
        }
      }
    }
    label72:
    while (!(paramView instanceof s)) {
      for (;;)
      {
        return;
        int i = 0;
      }
    }
    ((s)paramView).setSupportBackgroundTintMode(paramMode);
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public static void a(View paramView, a parama)
  {
    if (parama == null) {}
    for (parama = null;; parama = parama.getBridge())
    {
      paramView.setAccessibilityDelegate(parama);
      return;
    }
  }
  
  public static void a(View paramView, p paramp)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramp == null) {
        paramView.setOnApplyWindowInsetsListener(null);
      }
    }
    else {
      return;
    }
    paramView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
    {
      public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
      {
        paramAnonymousWindowInsets = ac.G(paramAnonymousWindowInsets);
        return (WindowInsets)ac.c(this.QR.a(paramAnonymousView, paramAnonymousWindowInsets));
      }
    });
  }
  
  public static void a(View paramView, r paramr)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      if (paramr == null) {
        break label29;
      }
    }
    label29:
    for (paramr = paramr.QG;; paramr = null)
    {
      paramView.setPointerIcon((PointerIcon)paramr);
      return;
    }
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postOnAnimationDelayed(paramRunnable, paramLong);
      return;
    }
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay() + paramLong);
  }
  
  public static void a(View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setTransitionName(paramString);
      return;
    }
    if (QM == null) {
      QM = new WeakHashMap();
    }
    QM.put(paramView, paramString);
  }
  
  public static float aA(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getZ();
    }
    return 0.0F;
  }
  
  private static void aB(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }
  
  public static Rect aC(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramView.getClipBounds();
    }
    return null;
  }
  
  public static boolean aD(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.isAttachedToWindow();
    }
    return paramView.getWindowToken() != null;
  }
  
  public static boolean aE(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 15) {
      return paramView.hasOnClickListeners();
    }
    return false;
  }
  
  public static Display aF(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getDisplay();
    }
    if (aD(paramView)) {
      return ((WindowManager)paramView.getContext().getSystemService("window")).getDefaultDisplay();
    }
    return null;
  }
  
  public static ViewParent aa(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getParentForAccessibility();
    }
    return paramView.getParent();
  }
  
  public static int ab(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.getAccessibilityLiveRegion();
    }
    return 0;
  }
  
  public static int ac(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getPaddingStart();
    }
    return paramView.getPaddingLeft();
  }
  
  public static int ad(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getPaddingEnd();
    }
    return paramView.getPaddingRight();
  }
  
  @Deprecated
  public static float ae(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public static int af(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getMinimumWidth();
    }
    if (!QJ) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinWidth");
      QI = localField;
      localField.setAccessible(true);
      label37:
      QJ = true;
      if (QI != null) {
        try
        {
          int i = ((Integer)QI.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label37;
    }
  }
  
  public static int ag(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getMinimumHeight();
    }
    if (!QL) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinHeight");
      QK = localField;
      localField.setAccessible(true);
      label37:
      QL = true;
      if (QK != null) {
        try
        {
          int i = ((Integer)QK.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label37;
    }
  }
  
  public static y ah(View paramView)
  {
    if (QN == null) {
      QN = new WeakHashMap();
    }
    y localy2 = (y)QN.get(paramView);
    y localy1 = localy2;
    if (localy2 == null)
    {
      localy1 = new y(paramView);
      QN.put(paramView, localy1);
    }
    return localy1;
  }
  
  @Deprecated
  public static void ai(View paramView)
  {
    paramView.setRotation(0.0F);
  }
  
  @Deprecated
  public static void aj(View paramView)
  {
    paramView.setRotationX(0.0F);
  }
  
  @Deprecated
  public static void ak(View paramView)
  {
    paramView.setRotationY(0.0F);
  }
  
  public static float al(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getElevation();
    }
    return 0.0F;
  }
  
  public static float am(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getTranslationZ();
    }
    return 0.0F;
  }
  
  public static String an(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getTransitionName();
    }
    if (QM == null) {
      return null;
    }
    return (String)QM.get(paramView);
  }
  
  public static int ao(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getWindowSystemUiVisibility();
    }
    return 0;
  }
  
  public static void ap(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      paramView.requestApplyInsets();
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    paramView.requestFitSystemWindows();
  }
  
  public static boolean aq(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getFitsSystemWindows();
    }
    return false;
  }
  
  public static boolean ar(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.hasOverlappingRendering();
    }
    return true;
  }
  
  public static boolean as(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.isPaddingRelative();
    }
    return false;
  }
  
  public static ColorStateList at(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getBackgroundTintList();
    }
    if ((paramView instanceof s)) {
      return ((s)paramView).getSupportBackgroundTintList();
    }
    return null;
  }
  
  public static PorterDuff.Mode au(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getBackgroundTintMode();
    }
    if ((paramView instanceof s)) {
      return ((s)paramView).getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public static void av(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setNestedScrollingEnabled(true);
    }
    while (!(paramView instanceof j)) {
      return;
    }
    ((j)paramView).setNestedScrollingEnabled(true);
  }
  
  public static boolean aw(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.isNestedScrollingEnabled();
    }
    if ((paramView instanceof j)) {
      return ((j)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  public static void ax(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.stopNestedScroll();
    }
    while (!(paramView instanceof j)) {
      return;
    }
    ((j)paramView).stopNestedScroll();
  }
  
  public static void ay(View paramView)
  {
    if ((paramView instanceof k)) {
      ((k)paramView).aM(1);
    }
  }
  
  public static boolean az(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.isLaidOut();
    }
    return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }
  
  public static ac b(View paramView, ac paramac)
  {
    Object localObject = paramac;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramac = (WindowInsets)ac.c(paramac);
      localObject = paramView.dispatchApplyWindowInsets(paramac);
      paramView = paramac;
      if (localObject != paramac) {
        paramView = new WindowInsets((WindowInsets)localObject);
      }
      localObject = ac.G(paramView);
    }
    return localObject;
  }
  
  public static void b(View paramView, Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramView.setClipBounds(paramRect);
    }
  }
  
  public static void b(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postOnAnimation(paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay());
  }
  
  static boolean b(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return false;
    }
    paramView = b.aG(paramView);
    if ((paramView.QV == null) || (paramView.QV.get() != paramKeyEvent))
    {
      paramView.QV = new WeakReference(paramKeyEvent);
      Object localObject = null;
      SparseArray localSparseArray = paramView.fF();
      paramView = (View)localObject;
      if (paramKeyEvent.getAction() == 1)
      {
        int i = localSparseArray.indexOfKey(paramKeyEvent.getKeyCode());
        paramView = (View)localObject;
        if (i >= 0)
        {
          paramView = (WeakReference)localSparseArray.valueAt(i);
          localSparseArray.removeAt(i);
        }
      }
      localObject = paramView;
      if (paramView == null) {
        localObject = (WeakReference)localSparseArray.get(paramKeyEvent.getKeyCode());
      }
      if (localObject != null)
      {
        paramView = (View)((WeakReference)localObject).get();
        if ((paramView != null) && (aD(paramView))) {
          b.aH(paramView);
        }
        return true;
      }
    }
    return false;
  }
  
  public static void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postInvalidateOnAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static boolean c(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return false;
    }
    b localb = b.aG(paramView);
    if (paramKeyEvent.getAction() == 0)
    {
      if (localb.QT != null) {
        localb.QT.clear();
      }
      if (b.QS.isEmpty()) {}
    }
    for (;;)
    {
      int i;
      synchronized (b.QS)
      {
        if (localb.QT == null) {
          localb.QT = new WeakHashMap();
        }
        i = b.QS.size() - 1;
        if (i >= 0)
        {
          Object localObject = (View)((WeakReference)b.QS.get(i)).get();
          if (localObject == null)
          {
            b.QS.remove(i);
            break label237;
          }
          localb.QT.put(localObject, Boolean.TRUE);
          localObject = ((View)localObject).getParent();
          if (!(localObject instanceof View)) {
            break label237;
          }
          localb.QT.put((View)localObject, Boolean.TRUE);
          localObject = ((ViewParent)localObject).getParent();
          continue;
        }
        paramView = localb.d(paramView, paramKeyEvent);
        if (paramKeyEvent.getAction() == 0)
        {
          i = paramKeyEvent.getKeyCode();
          if ((paramView != null) && (!KeyEvent.isModifierKey(i))) {
            localb.fF().put(i, new WeakReference(paramView));
          }
        }
        if (paramView != null) {
          return true;
        }
      }
      return false;
      label237:
      i -= 1;
    }
  }
  
  public static void d(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void d(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.setHasTransientState(paramBoolean);
    }
  }
  
  @Deprecated
  public static void e(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }
  
  @Deprecated
  public static void e(View paramView, boolean paramBoolean)
  {
    paramView.setFitsSystemWindows(paramBoolean);
  }
  
  @Deprecated
  public static void f(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }
  
  private static Rect fD()
  {
    if (QQ == null) {
      QQ = new ThreadLocal();
    }
    Rect localRect2 = (Rect)QQ.get();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      localRect1 = new Rect();
      QQ.set(localRect1);
    }
    localRect1.setEmpty();
    return localRect1;
  }
  
  @Deprecated
  public static void g(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  @Deprecated
  public static void h(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }
  
  @Deprecated
  public static void i(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
  
  @Deprecated
  public static void j(View paramView, float paramFloat)
  {
    paramView.setPivotX(paramFloat);
  }
  
  @Deprecated
  public static void k(View paramView, float paramFloat)
  {
    paramView.setPivotY(paramFloat);
  }
  
  public static void l(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setElevation(paramFloat);
    }
  }
  
  public static void m(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setTranslationZ(paramFloat);
    }
  }
  
  public static void n(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setZ(paramFloat);
    }
  }
  
  @Deprecated
  public static boolean n(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
  
  @Deprecated
  public static boolean o(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }
  
  public static void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
  {
    paramView.onInitializeAccessibilityNodeInfo(paramc.Ro);
  }
  
  public static void p(View paramView, int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 19)
    {
      if (Build.VERSION.SDK_INT < 16) {
        return;
      }
      i = paramInt;
      if (paramInt == 4) {
        i = 2;
      }
    }
    paramView.setImportantForAccessibility(i);
  }
  
  public static boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.performAccessibilityAction(paramInt, paramBundle);
    }
    return false;
  }
  
  @Deprecated
  public static void q(View paramView, int paramInt)
  {
    paramView.setLayerType(paramInt, null);
  }
  
  public static void r(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramView.setAccessibilityLiveRegion(paramInt);
    }
  }
  
  public static void s(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.offsetTopAndBottom(paramInt);
      return;
    }
    Rect localRect;
    ViewParent localViewParent;
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localRect = fD();
      localViewParent = paramView.getParent();
      if (!(localViewParent instanceof View)) {
        break label149;
      }
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      t(paramView, paramInt);
      if ((i == 0) || (!localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        break;
      }
      ((View)localViewParent).invalidate(localRect);
      return;
      i = 0;
      continue;
      t(paramView, paramInt);
      return;
      label149:
      i = 0;
    }
  }
  
  private static void t(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    if (paramView.getVisibility() == 0)
    {
      aB(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        aB((View)paramView);
      }
    }
  }
  
  public static void u(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.offsetLeftAndRight(paramInt);
      return;
    }
    Rect localRect;
    ViewParent localViewParent;
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localRect = fD();
      localViewParent = paramView.getParent();
      if (!(localViewParent instanceof View)) {
        break label149;
      }
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      v(paramView, paramInt);
      if ((i == 0) || (!localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        break;
      }
      ((View)localViewParent).invalidate(localRect);
      return;
      i = 0;
      continue;
      v(paramView, paramInt);
      return;
      label149:
      i = 0;
    }
  }
  
  private static void v(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
    if (paramView.getVisibility() == 0)
    {
      aB(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        aB((View)paramView);
      }
    }
  }
  
  public static void w(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramView.setScrollIndicators(paramInt, 3);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean fE();
  }
  
  static final class b
  {
    static final ArrayList<WeakReference<View>> QS = new ArrayList();
    WeakHashMap<View, Boolean> QT = null;
    private SparseArray<WeakReference<View>> QU = null;
    WeakReference<KeyEvent> QV = null;
    
    static b aG(View paramView)
    {
      b localb2 = (b)paramView.getTag(2131308880);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        paramView.setTag(2131308880, localb1);
      }
      return localb1;
    }
    
    static boolean aH(View paramView)
    {
      paramView = (ArrayList)paramView.getTag(2131308881);
      if (paramView != null)
      {
        int i = paramView.size() - 1;
        while (i >= 0)
        {
          if (((u.a)paramView.get(i)).fE()) {
            return true;
          }
          i -= 1;
        }
      }
      return false;
    }
    
    final View d(View paramView, KeyEvent paramKeyEvent)
    {
      if ((this.QT == null) || (!this.QT.containsKey(paramView))) {
        paramKeyEvent = null;
      }
      do
      {
        return paramKeyEvent;
        if ((paramView instanceof ViewGroup))
        {
          ViewGroup localViewGroup = (ViewGroup)paramView;
          int i = localViewGroup.getChildCount() - 1;
          while (i >= 0)
          {
            View localView = d(localViewGroup.getChildAt(i), paramKeyEvent);
            if (localView != null) {
              return localView;
            }
            i -= 1;
          }
        }
        paramKeyEvent = paramView;
      } while (aH(paramView));
      return null;
    }
    
    final SparseArray<WeakReference<View>> fF()
    {
      if (this.QU == null) {
        this.QU = new SparseArray();
      }
      return this.QU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.u
 * JD-Core Version:    0.7.0.1
 */