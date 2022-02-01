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

public final class t
{
  private static WeakHashMap<View, x> QA = null;
  private static Field QB;
  private static boolean QC = false;
  private static ThreadLocal<Rect> QD;
  private static final AtomicInteger Qu = new AtomicInteger(1);
  private static Field Qv;
  private static boolean Qw;
  private static Field Qx;
  private static boolean Qy;
  private static WeakHashMap<View, String> Qz;
  
  @Deprecated
  public static int R(View paramView)
  {
    return paramView.getOverScrollMode();
  }
  
  @SuppressLint({"InlinedApi"})
  public static int S(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.getImportantForAutofill();
    }
    return 0;
  }
  
  public static void T(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setImportantForAutofill(8);
    }
  }
  
  public static boolean U(View paramView)
  {
    if (QC) {}
    for (;;)
    {
      return false;
      if (QB == null) {}
      try
      {
        Field localField = View.class.getDeclaredField("mAccessibilityDelegate");
        QB = localField;
        localField.setAccessible(true);
      }
      catch (Throwable paramView)
      {
        try
        {
          paramView = QB.get(paramView);
          if (paramView == null) {
            continue;
          }
          return true;
        }
        catch (Throwable paramView)
        {
          QC = true;
        }
        paramView = paramView;
        QC = true;
        return false;
      }
    }
    return false;
  }
  
  public static boolean V(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.hasTransientState();
    }
    return false;
  }
  
  public static void W(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postInvalidateOnAnimation();
      return;
    }
    paramView.postInvalidate();
  }
  
  public static int X(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getImportantForAccessibility();
    }
    return 0;
  }
  
  public static int Y(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getLayoutDirection();
    }
    return 0;
  }
  
  public static ViewParent Z(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getParentForAccessibility();
    }
    return paramView.getParent();
  }
  
  public static ab a(View paramView, ab paramab)
  {
    Object localObject = paramab;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramab = (WindowInsets)ab.c(paramab);
      localObject = paramView.onApplyWindowInsets(paramab);
      paramView = paramab;
      if (localObject != paramab) {
        paramView = new WindowInsets((WindowInsets)localObject);
      }
      localObject = ab.G(paramView);
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
        paramAnonymousWindowInsets = ab.G(paramAnonymousWindowInsets);
        return (WindowInsets)ab.c(this.QE.a(paramAnonymousView, paramAnonymousWindowInsets));
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
    for (paramr = paramr.Qt;; paramr = null)
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
    if (Qz == null) {
      Qz = new WeakHashMap();
    }
    Qz.put(paramView, paramString);
  }
  
  private static void aA(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }
  
  public static Rect aB(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramView.getClipBounds();
    }
    return null;
  }
  
  public static boolean aC(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.isAttachedToWindow();
    }
    return paramView.getWindowToken() != null;
  }
  
  public static boolean aD(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 15) {
      return paramView.hasOnClickListeners();
    }
    return false;
  }
  
  public static Display aE(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getDisplay();
    }
    if (aC(paramView)) {
      return ((WindowManager)paramView.getContext().getSystemService("window")).getDefaultDisplay();
    }
    return null;
  }
  
  public static int aa(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.getAccessibilityLiveRegion();
    }
    return 0;
  }
  
  public static int ab(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getPaddingStart();
    }
    return paramView.getPaddingLeft();
  }
  
  public static int ac(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getPaddingEnd();
    }
    return paramView.getPaddingRight();
  }
  
  @Deprecated
  public static float ad(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public static int ae(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getMinimumWidth();
    }
    if (!Qw) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinWidth");
      Qv = localField;
      localField.setAccessible(true);
      label37:
      Qw = true;
      if (Qv != null) {
        try
        {
          int i = ((Integer)Qv.get(paramView)).intValue();
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
  
  public static int af(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getMinimumHeight();
    }
    if (!Qy) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinHeight");
      Qx = localField;
      localField.setAccessible(true);
      label37:
      Qy = true;
      if (Qx != null) {
        try
        {
          int i = ((Integer)Qx.get(paramView)).intValue();
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
  
  public static x ag(View paramView)
  {
    if (QA == null) {
      QA = new WeakHashMap();
    }
    x localx2 = (x)QA.get(paramView);
    x localx1 = localx2;
    if (localx2 == null)
    {
      localx1 = new x(paramView);
      QA.put(paramView, localx1);
    }
    return localx1;
  }
  
  @Deprecated
  public static void ah(View paramView)
  {
    paramView.setTranslationX(0.0F);
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
    if (Qz == null) {
      return null;
    }
    return (String)Qz.get(paramView);
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
  
  public static boolean av(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.isNestedScrollingEnabled();
    }
    if ((paramView instanceof j)) {
      return ((j)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  public static void aw(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.stopNestedScroll();
    }
    while (!(paramView instanceof j)) {
      return;
    }
    ((j)paramView).stopNestedScroll();
  }
  
  public static void ax(View paramView)
  {
    if ((paramView instanceof k)) {
      ((k)paramView).aM(1);
    }
  }
  
  public static boolean ay(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.isLaidOut();
    }
    return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }
  
  public static float az(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getZ();
    }
    return 0.0F;
  }
  
  public static ab b(View paramView, ab paramab)
  {
    Object localObject = paramab;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramab = (WindowInsets)ab.c(paramab);
      localObject = paramView.dispatchApplyWindowInsets(paramab);
      paramView = paramab;
      if (localObject != paramab) {
        paramView = new WindowInsets((WindowInsets)localObject);
      }
      localObject = ab.G(paramView);
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
    paramView = b.aF(paramView);
    if ((paramView.QI == null) || (paramView.QI.get() != paramKeyEvent))
    {
      paramView.QI = new WeakReference(paramKeyEvent);
      Object localObject = null;
      SparseArray localSparseArray = paramView.fy();
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
        if ((paramView != null) && (aC(paramView))) {
          b.aG(paramView);
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
    b localb = b.aF(paramView);
    if (paramKeyEvent.getAction() == 0)
    {
      if (localb.QG != null) {
        localb.QG.clear();
      }
      if (b.QF.isEmpty()) {}
    }
    for (;;)
    {
      int i;
      synchronized (b.QF)
      {
        if (localb.QG == null) {
          localb.QG = new WeakHashMap();
        }
        i = b.QF.size() - 1;
        if (i >= 0)
        {
          Object localObject = (View)((WeakReference)b.QF.get(i)).get();
          if (localObject == null)
          {
            b.QF.remove(i);
            break label237;
          }
          localb.QG.put(localObject, Boolean.TRUE);
          localObject = ((View)localObject).getParent();
          if (!(localObject instanceof View)) {
            break label237;
          }
          localb.QG.put((View)localObject, Boolean.TRUE);
          localObject = ((ViewParent)localObject).getParent();
          continue;
        }
        paramView = localb.d(paramView, paramKeyEvent);
        if (paramKeyEvent.getAction() == 0)
        {
          i = paramKeyEvent.getKeyCode();
          if ((paramView != null) && (!KeyEvent.isModifierKey(i))) {
            localb.fy().put(i, new WeakReference(paramView));
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
    paramView.setTranslationY(paramFloat);
  }
  
  @Deprecated
  public static void e(View paramView, boolean paramBoolean)
  {
    paramView.setFitsSystemWindows(paramBoolean);
  }
  
  @Deprecated
  public static void f(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  private static Rect fw()
  {
    if (QD == null) {
      QD = new ThreadLocal();
    }
    Rect localRect2 = (Rect)QD.get();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      localRect1 = new Rect();
      QD.set(localRect1);
    }
    localRect1.setEmpty();
    return localRect1;
  }
  
  @Deprecated
  public static void g(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }
  
  @Deprecated
  public static void h(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
  
  @Deprecated
  public static void i(View paramView, float paramFloat)
  {
    paramView.setPivotX(paramFloat);
  }
  
  @Deprecated
  public static void j(View paramView, float paramFloat)
  {
    paramView.setPivotY(paramFloat);
  }
  
  public static void k(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setElevation(paramFloat);
    }
  }
  
  public static void l(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setTranslationZ(paramFloat);
    }
  }
  
  public static void m(View paramView, float paramFloat)
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
    paramView.onInitializeAccessibilityNodeInfo(paramc.Rb);
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
      localRect = fw();
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
      aA(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        aA((View)paramView);
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
      localRect = fw();
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
      aA(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        aA((View)paramView);
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
    public abstract boolean fx();
  }
  
  static final class b
  {
    static final ArrayList<WeakReference<View>> QF = new ArrayList();
    WeakHashMap<View, Boolean> QG = null;
    private SparseArray<WeakReference<View>> QH = null;
    WeakReference<KeyEvent> QI = null;
    
    static b aF(View paramView)
    {
      b localb2 = (b)paramView.getTag(2131305636);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        paramView.setTag(2131305636, localb1);
      }
      return localb1;
    }
    
    static boolean aG(View paramView)
    {
      paramView = (ArrayList)paramView.getTag(2131305637);
      if (paramView != null)
      {
        int i = paramView.size() - 1;
        while (i >= 0)
        {
          if (((t.a)paramView.get(i)).fx()) {
            return true;
          }
          i -= 1;
        }
      }
      return false;
    }
    
    final View d(View paramView, KeyEvent paramKeyEvent)
    {
      if ((this.QG == null) || (!this.QG.containsKey(paramView))) {
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
      } while (aG(paramView));
      return null;
    }
    
    final SparseArray<WeakReference<View>> fy()
    {
      if (this.QH == null) {
        this.QH = new SparseArray();
      }
      return this.QH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.t
 * JD-Core Version:    0.7.0.1
 */