package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class q
{
  static final j Gc = new j();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      Gc = new i();
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      Gc = new h();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      Gc = new g();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Gc = new f();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      Gc = new e();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      Gc = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      Gc = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      Gc = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      Gc = new a();
      return;
    }
  }
  
  @Deprecated
  public static int L(View paramView)
  {
    return paramView.getOverScrollMode();
  }
  
  public static boolean M(View paramView)
  {
    return j.M(paramView);
  }
  
  public static boolean N(View paramView)
  {
    return Gc.N(paramView);
  }
  
  public static void O(View paramView)
  {
    Gc.O(paramView);
  }
  
  public static int P(View paramView)
  {
    return Gc.P(paramView);
  }
  
  public static int Q(View paramView)
  {
    return Gc.Q(paramView);
  }
  
  public static ViewParent R(View paramView)
  {
    return Gc.R(paramView);
  }
  
  public static void S(View paramView)
  {
    Gc.S(paramView);
  }
  
  public static int T(View paramView)
  {
    return Gc.T(paramView);
  }
  
  public static int U(View paramView)
  {
    return Gc.U(paramView);
  }
  
  @Deprecated
  public static float V(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public static int W(View paramView)
  {
    return Gc.W(paramView);
  }
  
  public static int X(View paramView)
  {
    return Gc.X(paramView);
  }
  
  public static u Y(View paramView)
  {
    j localj = Gc;
    if (localj.Gm == null) {
      localj.Gm = new WeakHashMap();
    }
    u localu2 = (u)localj.Gm.get(paramView);
    u localu1 = localu2;
    if (localu2 == null)
    {
      localu1 = new u(paramView);
      localj.Gm.put(paramView, localu1);
    }
    return localu1;
  }
  
  public static float Z(View paramView)
  {
    return Gc.Z(paramView);
  }
  
  public static y a(View paramView, y paramy)
  {
    return Gc.a(paramView, paramy);
  }
  
  public static void a(View paramView, ColorStateList paramColorStateList)
  {
    Gc.a(paramView, paramColorStateList);
  }
  
  public static void a(View paramView, Paint paramPaint)
  {
    Gc.a(paramView, paramPaint);
  }
  
  public static void a(View paramView, PorterDuff.Mode paramMode)
  {
    Gc.a(paramView, paramMode);
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    Gc.a(paramView, paramDrawable);
  }
  
  public static void a(View paramView, a parama)
  {
    j.a(paramView, parama);
  }
  
  public static void a(View paramView, m paramm)
  {
    Gc.a(paramView, paramm);
  }
  
  public static void a(View paramView, o paramo)
  {
    Gc.a(paramView, paramo);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    Gc.a(paramView, paramRunnable, paramLong);
  }
  
  public static void a(View paramView, String paramString)
  {
    Gc.a(paramView, paramString);
  }
  
  public static float aa(View paramView)
  {
    return Gc.aa(paramView);
  }
  
  public static String ab(View paramView)
  {
    return Gc.ab(paramView);
  }
  
  public static int ac(View paramView)
  {
    return Gc.ac(paramView);
  }
  
  public static void ad(View paramView)
  {
    Gc.ad(paramView);
  }
  
  public static boolean ae(View paramView)
  {
    return Gc.ae(paramView);
  }
  
  public static boolean af(View paramView)
  {
    return Gc.af(paramView);
  }
  
  public static boolean ag(View paramView)
  {
    return Gc.ag(paramView);
  }
  
  public static ColorStateList ah(View paramView)
  {
    return Gc.ah(paramView);
  }
  
  public static PorterDuff.Mode ai(View paramView)
  {
    return Gc.ai(paramView);
  }
  
  public static boolean aj(View paramView)
  {
    return Gc.aj(paramView);
  }
  
  public static void ak(View paramView)
  {
    Gc.ak(paramView);
  }
  
  public static boolean al(View paramView)
  {
    return Gc.al(paramView);
  }
  
  public static float am(View paramView)
  {
    return Gc.am(paramView);
  }
  
  public static Rect an(View paramView)
  {
    return Gc.an(paramView);
  }
  
  public static boolean ao(View paramView)
  {
    return Gc.ao(paramView);
  }
  
  public static boolean ap(View paramView)
  {
    return Gc.ap(paramView);
  }
  
  public static Display aq(View paramView)
  {
    return Gc.aq(paramView);
  }
  
  public static y b(View paramView, y paramy)
  {
    return Gc.b(paramView, paramy);
  }
  
  public static void b(View paramView, Runnable paramRunnable)
  {
    Gc.b(paramView, paramRunnable);
  }
  
  public static void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Gc.c(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void c(View paramView, Rect paramRect)
  {
    Gc.c(paramView, paramRect);
  }
  
  @Deprecated
  public static void d(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }
  
  public static void d(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Gc.d(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void d(View paramView, boolean paramBoolean)
  {
    Gc.d(paramView, paramBoolean);
  }
  
  @Deprecated
  public static void e(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  @Deprecated
  public static void e(View paramView, boolean paramBoolean)
  {
    paramView.setFitsSystemWindows(paramBoolean);
  }
  
  @Deprecated
  public static void f(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }
  
  @Deprecated
  public static void g(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
  
  public static void h(View paramView, float paramFloat)
  {
    Gc.h(paramView, paramFloat);
  }
  
  public static void i(View paramView, float paramFloat)
  {
    Gc.i(paramView, paramFloat);
  }
  
  @Deprecated
  public static boolean l(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
  
  @Deprecated
  public static boolean m(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }
  
  public static void n(View paramView, int paramInt)
  {
    Gc.n(paramView, paramInt);
  }
  
  @Deprecated
  public static void o(View paramView, int paramInt)
  {
    paramView.setLayerType(paramInt, null);
  }
  
  public static void p(View paramView, int paramInt)
  {
    Gc.p(paramView, paramInt);
  }
  
  public static void q(View paramView, int paramInt)
  {
    Gc.q(paramView, paramInt);
  }
  
  public static void r(View paramView, int paramInt)
  {
    Gc.r(paramView, paramInt);
  }
  
  static class a
    extends q.j
  {
    public final boolean ap(View paramView)
    {
      return paramView.hasOnClickListeners();
    }
  }
  
  static class b
    extends q.a
  {
    public final boolean N(View paramView)
    {
      return paramView.hasTransientState();
    }
    
    public final void O(View paramView)
    {
      paramView.postInvalidateOnAnimation();
    }
    
    public final int P(View paramView)
    {
      return paramView.getImportantForAccessibility();
    }
    
    public final ViewParent R(View paramView)
    {
      return paramView.getParentForAccessibility();
    }
    
    public final int W(View paramView)
    {
      return paramView.getMinimumWidth();
    }
    
    public final int X(View paramView)
    {
      return paramView.getMinimumHeight();
    }
    
    public final void a(View paramView, Drawable paramDrawable)
    {
      paramView.setBackground(paramDrawable);
    }
    
    public final void a(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postOnAnimationDelayed(paramRunnable, paramLong);
    }
    
    public void ad(View paramView)
    {
      paramView.requestFitSystemWindows();
    }
    
    public final boolean ae(View paramView)
    {
      return paramView.getFitsSystemWindows();
    }
    
    public final boolean af(View paramView)
    {
      return paramView.hasOverlappingRendering();
    }
    
    public final void b(View paramView, Runnable paramRunnable)
    {
      paramView.postOnAnimation(paramRunnable);
    }
    
    public final void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.postInvalidateOnAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public final void d(View paramView, boolean paramBoolean)
    {
      paramView.setHasTransientState(paramBoolean);
    }
    
    public void n(View paramView, int paramInt)
    {
      int i = paramInt;
      if (paramInt == 4) {
        i = 2;
      }
      paramView.setImportantForAccessibility(i);
    }
  }
  
  static class c
    extends q.b
  {
    public final int Q(View paramView)
    {
      return paramView.getLayoutDirection();
    }
    
    public final int T(View paramView)
    {
      return paramView.getPaddingStart();
    }
    
    public final int U(View paramView)
    {
      return paramView.getPaddingEnd();
    }
    
    public final void a(View paramView, Paint paramPaint)
    {
      paramView.setLayerPaint(paramPaint);
    }
    
    public final int ac(View paramView)
    {
      return paramView.getWindowSystemUiVisibility();
    }
    
    public final boolean ag(View paramView)
    {
      return paramView.isPaddingRelative();
    }
    
    public final Display aq(View paramView)
    {
      return paramView.getDisplay();
    }
    
    public final void d(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  static class d
    extends q.c
  {
    public final Rect an(View paramView)
    {
      return paramView.getClipBounds();
    }
    
    public final void c(View paramView, Rect paramRect)
    {
      paramView.setClipBounds(paramRect);
    }
  }
  
  static class e
    extends q.d
  {
    public final void S(View paramView)
    {
      paramView.setAccessibilityLiveRegion(1);
    }
    
    public final boolean al(View paramView)
    {
      return paramView.isLaidOut();
    }
    
    public final boolean ao(View paramView)
    {
      return paramView.isAttachedToWindow();
    }
    
    public final void n(View paramView, int paramInt)
    {
      paramView.setImportantForAccessibility(paramInt);
    }
  }
  
  static class f
    extends q.e
  {
    private static ThreadLocal<Rect> Gd;
    
    private static Rect dk()
    {
      if (Gd == null) {
        Gd = new ThreadLocal();
      }
      Rect localRect2 = (Rect)Gd.get();
      Rect localRect1 = localRect2;
      if (localRect2 == null)
      {
        localRect1 = new Rect();
        Gd.set(localRect1);
      }
      localRect1.setEmpty();
      return localRect1;
    }
    
    public final float Z(View paramView)
    {
      return paramView.getElevation();
    }
    
    public final y a(View paramView, y paramy)
    {
      paramy = (WindowInsets)y.c(paramy);
      WindowInsets localWindowInsets = paramView.onApplyWindowInsets(paramy);
      paramView = paramy;
      if (localWindowInsets != paramy) {
        paramView = new WindowInsets(localWindowInsets);
      }
      return y.G(paramView);
    }
    
    public final void a(View paramView, ColorStateList paramColorStateList)
    {
      paramView.setBackgroundTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramView.getBackground();
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          break label64;
        }
      }
      label64:
      for (int i = 1;; i = 0)
      {
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramColorStateList);
        }
        return;
      }
    }
    
    public final void a(View paramView, PorterDuff.Mode paramMode)
    {
      paramView.setBackgroundTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramView.getBackground();
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          break label64;
        }
      }
      label64:
      for (int i = 1;; i = 0)
      {
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramMode);
        }
        return;
      }
    }
    
    public final void a(View paramView, final m paramm)
    {
      if (paramm == null)
      {
        paramView.setOnApplyWindowInsetsListener(null);
        return;
      }
      paramView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          paramAnonymousWindowInsets = y.G(paramAnonymousWindowInsets);
          return (WindowInsets)y.c(paramm.a(paramAnonymousView, paramAnonymousWindowInsets));
        }
      });
    }
    
    public final void a(View paramView, String paramString)
    {
      paramView.setTransitionName(paramString);
    }
    
    public final float aa(View paramView)
    {
      return paramView.getTranslationZ();
    }
    
    public final String ab(View paramView)
    {
      return paramView.getTransitionName();
    }
    
    public final void ad(View paramView)
    {
      paramView.requestApplyInsets();
    }
    
    public final ColorStateList ah(View paramView)
    {
      return paramView.getBackgroundTintList();
    }
    
    public final PorterDuff.Mode ai(View paramView)
    {
      return paramView.getBackgroundTintMode();
    }
    
    public final boolean aj(View paramView)
    {
      return paramView.isNestedScrollingEnabled();
    }
    
    public final void ak(View paramView)
    {
      paramView.stopNestedScroll();
    }
    
    public final float am(View paramView)
    {
      return paramView.getZ();
    }
    
    public final y b(View paramView, y paramy)
    {
      paramy = (WindowInsets)y.c(paramy);
      WindowInsets localWindowInsets = paramView.dispatchApplyWindowInsets(paramy);
      paramView = paramy;
      if (localWindowInsets != paramy) {
        paramView = new WindowInsets(localWindowInsets);
      }
      return y.G(paramView);
    }
    
    public final void h(View paramView, float paramFloat)
    {
      paramView.setElevation(paramFloat);
    }
    
    public final void i(View paramView, float paramFloat)
    {
      paramView.setTranslationZ(paramFloat);
    }
    
    public void p(View paramView, int paramInt)
    {
      Rect localRect = dk();
      ViewParent localViewParent = paramView.getParent();
      int i;
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
          i = 1;
        }
      }
      for (;;)
      {
        super.p(paramView, paramInt);
        if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
          ((View)localViewParent).invalidate(localRect);
        }
        return;
        i = 0;
        continue;
        i = 0;
      }
    }
    
    public void q(View paramView, int paramInt)
    {
      Rect localRect = dk();
      ViewParent localViewParent = paramView.getParent();
      int i;
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
          i = 1;
        }
      }
      for (;;)
      {
        super.q(paramView, paramInt);
        if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
          ((View)localViewParent).invalidate(localRect);
        }
        return;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  static class g
    extends q.f
  {
    public final void p(View paramView, int paramInt)
    {
      paramView.offsetTopAndBottom(paramInt);
    }
    
    public final void q(View paramView, int paramInt)
    {
      paramView.offsetLeftAndRight(paramInt);
    }
    
    public final void r(View paramView, int paramInt)
    {
      paramView.setScrollIndicators(paramInt, 3);
    }
  }
  
  static class h
    extends q.g
  {
    public final void a(View paramView, o paramo)
    {
      if (paramo != null) {}
      for (paramo = paramo.Gb;; paramo = null)
      {
        paramView.setPointerIcon((PointerIcon)paramo);
        return;
      }
    }
  }
  
  static final class i
    extends q.h
  {}
  
  static class j
  {
    private static Field Gg;
    private static boolean Gh;
    private static Field Gi;
    private static boolean Gj;
    private static WeakHashMap<View, String> Gk;
    private static final AtomicInteger Gl = new AtomicInteger(1);
    static Field Gn;
    static boolean Go = false;
    WeakHashMap<View, u> Gm = null;
    
    public static boolean M(View paramView)
    {
      if (Go) {}
      for (;;)
      {
        return false;
        if (Gn == null) {}
        try
        {
          Field localField = View.class.getDeclaredField("mAccessibilityDelegate");
          Gn = localField;
          localField.setAccessible(true);
        }
        catch (Throwable paramView)
        {
          try
          {
            paramView = Gn.get(paramView);
            if (paramView == null) {
              continue;
            }
            return true;
          }
          catch (Throwable paramView)
          {
            Go = true;
          }
          paramView = paramView;
          Go = true;
          return false;
        }
      }
      return false;
    }
    
    public static void a(View paramView, a parama)
    {
      if (parama == null) {}
      for (parama = null;; parama = parama.ED)
      {
        paramView.setAccessibilityDelegate(parama);
        return;
      }
    }
    
    private static void ar(View paramView)
    {
      float f = paramView.getTranslationY();
      paramView.setTranslationY(1.0F + f);
      paramView.setTranslationY(f);
    }
    
    public boolean N(View paramView)
    {
      return false;
    }
    
    public void O(View paramView)
    {
      paramView.postInvalidate();
    }
    
    public int P(View paramView)
    {
      return 0;
    }
    
    public int Q(View paramView)
    {
      return 0;
    }
    
    public ViewParent R(View paramView)
    {
      return paramView.getParent();
    }
    
    public void S(View paramView) {}
    
    public int T(View paramView)
    {
      return paramView.getPaddingLeft();
    }
    
    public int U(View paramView)
    {
      return paramView.getPaddingRight();
    }
    
    public int W(View paramView)
    {
      if (!Gh) {}
      try
      {
        Field localField = View.class.getDeclaredField("mMinWidth");
        Gg = localField;
        localField.setAccessible(true);
        label23:
        Gh = true;
        if (Gg != null) {
          try
          {
            int i = ((Integer)Gg.get(paramView)).intValue();
            return i;
          }
          catch (Exception paramView) {}
        }
        return 0;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label23;
      }
    }
    
    public int X(View paramView)
    {
      if (!Gj) {}
      try
      {
        Field localField = View.class.getDeclaredField("mMinHeight");
        Gi = localField;
        localField.setAccessible(true);
        label23:
        Gj = true;
        if (Gi != null) {
          try
          {
            int i = ((Integer)Gi.get(paramView)).intValue();
            return i;
          }
          catch (Exception paramView) {}
        }
        return 0;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label23;
      }
    }
    
    public float Z(View paramView)
    {
      return 0.0F;
    }
    
    public y a(View paramView, y paramy)
    {
      return paramy;
    }
    
    public void a(View paramView, ColorStateList paramColorStateList)
    {
      if ((paramView instanceof p)) {
        ((p)paramView).setSupportBackgroundTintList(paramColorStateList);
      }
    }
    
    public void a(View paramView, Paint paramPaint)
    {
      paramView.setLayerType(paramView.getLayerType(), paramPaint);
      paramView.invalidate();
    }
    
    public void a(View paramView, PorterDuff.Mode paramMode)
    {
      if ((paramView instanceof p)) {
        ((p)paramView).setSupportBackgroundTintMode(paramMode);
      }
    }
    
    public void a(View paramView, Drawable paramDrawable)
    {
      paramView.setBackgroundDrawable(paramDrawable);
    }
    
    public void a(View paramView, m paramm) {}
    
    public void a(View paramView, o paramo) {}
    
    public void a(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay() + paramLong);
    }
    
    public void a(View paramView, String paramString)
    {
      if (Gk == null) {
        Gk = new WeakHashMap();
      }
      Gk.put(paramView, paramString);
    }
    
    public float aa(View paramView)
    {
      return 0.0F;
    }
    
    public String ab(View paramView)
    {
      if (Gk == null) {
        return null;
      }
      return (String)Gk.get(paramView);
    }
    
    public int ac(View paramView)
    {
      return 0;
    }
    
    public void ad(View paramView) {}
    
    public boolean ae(View paramView)
    {
      return false;
    }
    
    public boolean af(View paramView)
    {
      return true;
    }
    
    public boolean ag(View paramView)
    {
      return false;
    }
    
    public ColorStateList ah(View paramView)
    {
      if ((paramView instanceof p)) {
        return ((p)paramView).getSupportBackgroundTintList();
      }
      return null;
    }
    
    public PorterDuff.Mode ai(View paramView)
    {
      if ((paramView instanceof p)) {
        return ((p)paramView).getSupportBackgroundTintMode();
      }
      return null;
    }
    
    public boolean aj(View paramView)
    {
      if ((paramView instanceof g)) {
        return ((g)paramView).isNestedScrollingEnabled();
      }
      return false;
    }
    
    public void ak(View paramView)
    {
      if ((paramView instanceof g)) {
        ((g)paramView).stopNestedScroll();
      }
    }
    
    public boolean al(View paramView)
    {
      return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
    }
    
    public float am(View paramView)
    {
      return aa(paramView) + Z(paramView);
    }
    
    public Rect an(View paramView)
    {
      return null;
    }
    
    public boolean ao(View paramView)
    {
      return paramView.getWindowToken() != null;
    }
    
    public boolean ap(View paramView)
    {
      return false;
    }
    
    public Display aq(View paramView)
    {
      if (ao(paramView)) {
        return ((WindowManager)paramView.getContext().getSystemService("window")).getDefaultDisplay();
      }
      return null;
    }
    
    public y b(View paramView, y paramy)
    {
      return paramy;
    }
    
    public void b(View paramView, Runnable paramRunnable)
    {
      paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay());
    }
    
    public void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void c(View paramView, Rect paramRect) {}
    
    public void d(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void d(View paramView, boolean paramBoolean) {}
    
    public void h(View paramView, float paramFloat) {}
    
    public void i(View paramView, float paramFloat) {}
    
    public void n(View paramView, int paramInt) {}
    
    public void p(View paramView, int paramInt)
    {
      paramView.offsetTopAndBottom(paramInt);
      if (paramView.getVisibility() == 0)
      {
        ar(paramView);
        paramView = paramView.getParent();
        if ((paramView instanceof View)) {
          ar((View)paramView);
        }
      }
    }
    
    public void q(View paramView, int paramInt)
    {
      paramView.offsetLeftAndRight(paramInt);
      if (paramView.getVisibility() == 0)
      {
        ar(paramView);
        paramView = paramView.getParent();
        if ((paramView instanceof View)) {
          ar((View)paramView);
        }
      }
    }
    
    public void r(View paramView, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.q
 * JD-Core Version:    0.7.0.1
 */