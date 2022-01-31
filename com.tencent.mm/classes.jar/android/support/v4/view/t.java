package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.b;
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
  private static final AtomicInteger GJ = new AtomicInteger(1);
  private static Field GK;
  private static boolean GL;
  private static Field GM;
  private static boolean GN;
  private static WeakHashMap<View, String> GO;
  private static WeakHashMap<View, x> GP = null;
  private static Field GQ;
  private static boolean GR = false;
  private static ThreadLocal<Rect> GS;
  
  @Deprecated
  public static int O(View paramView)
  {
    return paramView.getOverScrollMode();
  }
  
  public static boolean P(View paramView)
  {
    if (GR) {}
    for (;;)
    {
      return false;
      if (GQ == null) {}
      try
      {
        Field localField = View.class.getDeclaredField("mAccessibilityDelegate");
        GQ = localField;
        localField.setAccessible(true);
      }
      catch (Throwable paramView)
      {
        try
        {
          paramView = GQ.get(paramView);
          if (paramView == null) {
            continue;
          }
          return true;
        }
        catch (Throwable paramView)
        {
          GR = true;
        }
        paramView = paramView;
        GR = true;
        return false;
      }
    }
    return false;
  }
  
  public static boolean Q(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.hasTransientState();
    }
    return false;
  }
  
  public static void R(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postInvalidateOnAnimation();
      return;
    }
    paramView.postInvalidate();
  }
  
  public static int S(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getImportantForAccessibility();
    }
    return 0;
  }
  
  public static int T(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getLayoutDirection();
    }
    return 0;
  }
  
  public static ViewParent U(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getParentForAccessibility();
    }
    return paramView.getParent();
  }
  
  public static void V(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramView.setAccessibilityLiveRegion(1);
    }
  }
  
  public static int W(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getPaddingStart();
    }
    return paramView.getPaddingLeft();
  }
  
  public static int X(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getPaddingEnd();
    }
    return paramView.getPaddingRight();
  }
  
  @Deprecated
  public static float Y(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public static int Z(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getMinimumWidth();
    }
    if (!GL) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinWidth");
      GK = localField;
      localField.setAccessible(true);
      label36:
      GL = true;
      if (GK != null) {
        try
        {
          int i = ((Integer)GK.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label36;
    }
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
      localObject = ab.E(paramView);
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
        paramAnonymousWindowInsets = ab.E(paramAnonymousWindowInsets);
        return (WindowInsets)ab.c(this.GU.a(paramAnonymousView, paramAnonymousWindowInsets));
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
    for (paramr = paramr.GI;; paramr = null)
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
    if (GO == null) {
      GO = new WeakHashMap();
    }
    GO.put(paramView, paramString);
  }
  
  public static int aa(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getMinimumHeight();
    }
    if (!GN) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinHeight");
      GM = localField;
      localField.setAccessible(true);
      label37:
      GN = true;
      if (GM != null) {
        try
        {
          int i = ((Integer)GM.get(paramView)).intValue();
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
  
  public static x ab(View paramView)
  {
    if (GP == null) {
      GP = new WeakHashMap();
    }
    x localx2 = (x)GP.get(paramView);
    x localx1 = localx2;
    if (localx2 == null)
    {
      localx1 = new x(paramView);
      GP.put(paramView, localx1);
    }
    return localx1;
  }
  
  @Deprecated
  public static void ac(View paramView)
  {
    paramView.setTranslationX(0.0F);
  }
  
  @Deprecated
  public static void ad(View paramView)
  {
    paramView.setRotation(0.0F);
  }
  
  @Deprecated
  public static void ae(View paramView)
  {
    paramView.setRotationX(0.0F);
  }
  
  @Deprecated
  public static void af(View paramView)
  {
    paramView.setRotationY(0.0F);
  }
  
  public static float ag(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getElevation();
    }
    return 0.0F;
  }
  
  public static float ah(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getTranslationZ();
    }
    return 0.0F;
  }
  
  public static String ai(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getTransitionName();
    }
    if (GO == null) {
      return null;
    }
    return (String)GO.get(paramView);
  }
  
  public static int aj(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getWindowSystemUiVisibility();
    }
    return 0;
  }
  
  public static void ak(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      paramView.requestApplyInsets();
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    paramView.requestFitSystemWindows();
  }
  
  public static boolean al(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getFitsSystemWindows();
    }
    return false;
  }
  
  public static boolean am(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.hasOverlappingRendering();
    }
    return true;
  }
  
  public static boolean an(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.isPaddingRelative();
    }
    return false;
  }
  
  public static ColorStateList ao(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getBackgroundTintList();
    }
    if ((paramView instanceof s)) {
      return ((s)paramView).getSupportBackgroundTintList();
    }
    return null;
  }
  
  public static PorterDuff.Mode ap(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getBackgroundTintMode();
    }
    if ((paramView instanceof s)) {
      return ((s)paramView).getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public static boolean aq(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.isNestedScrollingEnabled();
    }
    if ((paramView instanceof j)) {
      return ((j)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  public static void ar(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.stopNestedScroll();
    }
    while (!(paramView instanceof j)) {
      return;
    }
    ((j)paramView).stopNestedScroll();
  }
  
  public static boolean as(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.isLaidOut();
    }
    return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }
  
  public static float at(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getZ();
    }
    return 0.0F;
  }
  
  private static void au(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }
  
  public static Rect av(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramView.getClipBounds();
    }
    return null;
  }
  
  public static boolean aw(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.isAttachedToWindow();
    }
    return paramView.getWindowToken() != null;
  }
  
  public static boolean ax(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 15) {
      return paramView.hasOnClickListeners();
    }
    return false;
  }
  
  public static Display ay(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getDisplay();
    }
    if (aw(paramView)) {
      return ((WindowManager)paramView.getContext().getSystemService("window")).getDefaultDisplay();
    }
    return null;
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
      localObject = ab.E(paramView);
    }
    return localObject;
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
    paramView = b.az(paramView);
    if ((paramView.GY == null) || (paramView.GY.get() != paramKeyEvent))
    {
      paramView.GY = new WeakReference(paramKeyEvent);
      Object localObject = null;
      SparseArray localSparseArray = paramView.dH();
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
        if ((paramView != null) && (aw(paramView))) {
          b.aA(paramView);
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
  
  public static void c(View paramView, Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramView.setClipBounds(paramRect);
    }
  }
  
  static boolean c(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return false;
    }
    b localb = b.az(paramView);
    if (paramKeyEvent.getAction() == 0)
    {
      if (localb.GW != null) {
        localb.GW.clear();
      }
      if (b.GV.isEmpty()) {}
    }
    for (;;)
    {
      int i;
      synchronized (b.GV)
      {
        if (localb.GW == null) {
          localb.GW = new WeakHashMap();
        }
        i = b.GV.size() - 1;
        if (i >= 0)
        {
          Object localObject = (View)((WeakReference)b.GV.get(i)).get();
          if (localObject == null)
          {
            b.GV.remove(i);
            break label237;
          }
          localb.GW.put(localObject, Boolean.TRUE);
          localObject = ((View)localObject).getParent();
          if (!(localObject instanceof View)) {
            break label237;
          }
          localb.GW.put((View)localObject, Boolean.TRUE);
          localObject = ((ViewParent)localObject).getParent();
          continue;
        }
        paramView = localb.d(paramView, paramKeyEvent);
        if (paramKeyEvent.getAction() == 0)
        {
          i = paramKeyEvent.getKeyCode();
          if ((paramView != null) && (!KeyEvent.isModifierKey(i))) {
            localb.dH().put(i, new WeakReference(paramView));
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
  
  private static Rect dF()
  {
    if (GS == null) {
      GS = new ThreadLocal();
    }
    Rect localRect2 = (Rect)GS.get();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      localRect1 = new Rect();
      GS.set(localRect1);
    }
    localRect1.setEmpty();
    return localRect1;
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
  
  public static void i(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setElevation(paramFloat);
    }
  }
  
  public static void j(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setTranslationZ(paramFloat);
    }
  }
  
  @Deprecated
  public static boolean m(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
  
  @Deprecated
  public static boolean n(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }
  
  public static void o(View paramView, int paramInt)
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
  
  public static void onInitializeAccessibilityNodeInfo(View paramView, b paramb)
  {
    paramView.onInitializeAccessibilityNodeInfo(paramb.Hq);
  }
  
  @Deprecated
  public static void p(View paramView, int paramInt)
  {
    paramView.setLayerType(paramInt, null);
  }
  
  public static boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.performAccessibilityAction(paramInt, paramBundle);
    }
    return false;
  }
  
  public static void q(View paramView, int paramInt)
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
      localRect = dF();
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
      r(paramView, paramInt);
      if ((i == 0) || (!localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        break;
      }
      ((View)localViewParent).invalidate(localRect);
      return;
      i = 0;
      continue;
      r(paramView, paramInt);
      return;
      label149:
      i = 0;
    }
  }
  
  private static void r(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    if (paramView.getVisibility() == 0)
    {
      au(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        au((View)paramView);
      }
    }
  }
  
  public static void s(View paramView, int paramInt)
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
      localRect = dF();
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
    paramView.offsetLeftAndRight(paramInt);
    if (paramView.getVisibility() == 0)
    {
      au(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        au((View)paramView);
      }
    }
  }
  
  public static void u(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramView.setScrollIndicators(paramInt, 3);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean dG();
  }
  
  static final class b
  {
    static final ArrayList<WeakReference<View>> GV = new ArrayList();
    WeakHashMap<View, Boolean> GW = null;
    private SparseArray<WeakReference<View>> GX = null;
    WeakReference<KeyEvent> GY = null;
    
    static boolean aA(View paramView)
    {
      paramView = (ArrayList)paramView.getTag(2131820675);
      if (paramView != null)
      {
        int i = paramView.size() - 1;
        while (i >= 0)
        {
          if (((t.a)paramView.get(i)).dG()) {
            return true;
          }
          i -= 1;
        }
      }
      return false;
    }
    
    static b az(View paramView)
    {
      b localb2 = (b)paramView.getTag(2131820674);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        paramView.setTag(2131820674, localb1);
      }
      return localb1;
    }
    
    final View d(View paramView, KeyEvent paramKeyEvent)
    {
      if ((this.GW == null) || (!this.GW.containsKey(paramView))) {
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
      } while (aA(paramView));
      return null;
    }
    
    final SparseArray<WeakReference<View>> dH()
    {
      if (this.GX == null) {
        this.GX = new SparseArray();
      }
      return this.GX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.t
 * JD-Core Version:    0.7.0.1
 */