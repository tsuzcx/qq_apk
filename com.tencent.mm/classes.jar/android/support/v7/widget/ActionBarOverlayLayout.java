package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.j;
import android.support.v4.view.l;
import android.support.v4.view.q;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.view.menu.o.a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements j, v
{
  static final int[] FV = { a.a.actionBarSize, 16842841 };
  private final l Lj;
  private w Qq;
  private boolean Rh;
  private final Runnable XA = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.fD();
      ActionBarOverlayLayout.this.Xx = ActionBarOverlayLayout.this.Xf.animate().translationY(-ActionBarOverlayLayout.this.Xf.getHeight()).setListener(ActionBarOverlayLayout.this.Xy);
    }
  };
  private int Xc;
  private int Xd = 0;
  private ContentFrameLayout Xe;
  ActionBarContainer Xf;
  private Drawable Xg;
  private boolean Xh;
  public boolean Xi;
  private boolean Xj;
  boolean Xk;
  private int Xl;
  private int Xm;
  private final Rect Xn = new Rect();
  private final Rect Xo = new Rect();
  private final Rect Xp = new Rect();
  private final Rect Xq = new Rect();
  private final Rect Xr = new Rect();
  private final Rect Xs = new Rect();
  private final Rect Xt = new Rect();
  private a Xu;
  private final int Xv = 600;
  private OverScroller Xw;
  ViewPropertyAnimator Xx;
  final AnimatorListenerAdapter Xy = new AnimatorListenerAdapter()
  {
    public final void onAnimationCancel(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.Xx = null;
      ActionBarOverlayLayout.this.Xk = false;
    }
    
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.Xx = null;
      ActionBarOverlayLayout.this.Xk = false;
    }
  };
  private final Runnable Xz = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.fD();
      ActionBarOverlayLayout.this.Xx = ActionBarOverlayLayout.this.Xf.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.Xy);
    }
  };
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    this.Lj = new l(this);
  }
  
  private static boolean a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    boolean bool = false;
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (paramView.leftMargin != paramRect.left)
    {
      paramView.leftMargin = paramRect.left;
      bool = true;
    }
    if (paramView.topMargin != paramRect.top)
    {
      paramView.topMargin = paramRect.top;
      bool = true;
    }
    if (paramView.rightMargin != paramRect.right)
    {
      paramView.rightMargin = paramRect.right;
      bool = true;
    }
    if ((paramBoolean) && (paramView.bottomMargin != paramRect.bottom))
    {
      paramView.bottomMargin = paramRect.bottom;
      return true;
    }
    return bool;
  }
  
  private void fC()
  {
    if (this.Xe == null)
    {
      this.Xe = ((ContentFrameLayout)findViewById(a.f.action_bar_activity_content));
      this.Xf = ((ActionBarContainer)findViewById(a.f.action_bar_container));
      localObject = findViewById(a.f.action_bar);
      if (!(localObject instanceof w)) {
        break label61;
      }
    }
    for (Object localObject = (w)localObject;; localObject = ((Toolbar)localObject).getWrapper())
    {
      this.Qq = ((w)localObject);
      return;
      label61:
      if (!(localObject instanceof Toolbar)) {
        break;
      }
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + localObject.getClass().getSimpleName());
  }
  
  private void init(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(FV);
    this.Xc = localTypedArray.getDimensionPixelSize(0, 0);
    this.Xg = localTypedArray.getDrawable(1);
    if (this.Xg == null)
    {
      bool1 = true;
      setWillNotDraw(bool1);
      localTypedArray.recycle();
      if (paramContext.getApplicationInfo().targetSdkVersion >= 19) {
        break label94;
      }
    }
    label94:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Xh = bool1;
      this.Xw = new OverScroller(paramContext);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    fC();
    this.Qq.a(paramMenu, parama);
  }
  
  public final void be(int paramInt)
  {
    fC();
    switch (paramInt)
    {
    case 2: 
    case 5: 
    default: 
      return;
    }
    setOverlayMode(true);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.Xg != null) && (!this.Xh)) {
      if (this.Xf.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i = (int)(this.Xf.getBottom() + this.Xf.getTranslationY() + 0.5F);; i = 0)
    {
      this.Xg.setBounds(0, i, getWidth(), this.Xg.getIntrinsicHeight() + i);
      this.Xg.draw(paramCanvas);
      return;
    }
  }
  
  public final void es()
  {
    fC();
    this.Qq.dismissPopupMenus();
  }
  
  final void fD()
  {
    removeCallbacks(this.Xz);
    removeCallbacks(this.XA);
    if (this.Xx != null) {
      this.Xx.cancel();
    }
  }
  
  public final boolean fE()
  {
    fC();
    return this.Qq.fE();
  }
  
  public final boolean fF()
  {
    fC();
    return this.Qq.fF();
  }
  
  public final void fG()
  {
    fC();
    this.Qq.fG();
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    fC();
    q.ac(this);
    boolean bool = a(this.Xf, paramRect, false);
    this.Xq.set(paramRect);
    bf.a(this, this.Xq, this.Xn);
    if (!this.Xr.equals(this.Xq))
    {
      this.Xr.set(this.Xq);
      bool = true;
    }
    if (!this.Xo.equals(this.Xn))
    {
      this.Xo.set(this.Xn);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    if (this.Xf != null) {
      return -(int)this.Xf.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.Lj.Fs;
  }
  
  public CharSequence getTitle()
  {
    fC();
    return this.Qq.getTitle();
  }
  
  public final boolean hideOverflowMenu()
  {
    fC();
    return this.Qq.hideOverflowMenu();
  }
  
  public final boolean isOverflowMenuShowing()
  {
    fC();
    return this.Qq.isOverflowMenuShowing();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    init(getContext());
    q.ad(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    fD();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    getPaddingRight();
    paramInt4 = getPaddingTop();
    getPaddingBottom();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i = localView.getMeasuredWidth();
        int j = localView.getMeasuredHeight();
        int k = localLayoutParams.leftMargin + paramInt3;
        int m = localLayoutParams.topMargin + paramInt4;
        localView.layout(k, m, i + k, j + m);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    fC();
    measureChildWithMargins(this.Xf, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.Xf.getLayoutParams();
    int i1 = Math.max(0, this.Xf.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i = this.Xf.getMeasuredHeight();
    int j = ((LayoutParams)localObject).topMargin;
    int n = Math.max(0, ((LayoutParams)localObject).bottomMargin + (i + j));
    int m = View.combineMeasuredStates(0, this.Xf.getMeasuredState());
    int k;
    if ((q.ac(this) & 0x100) != 0)
    {
      j = 1;
      if (j == 0) {
        break label444;
      }
      k = this.Xc;
      i = k;
      if (this.Xj)
      {
        i = k;
        if (this.Xf.getTabContainer() != null) {
          i = k + this.Xc;
        }
      }
    }
    for (;;)
    {
      label153:
      this.Xp.set(this.Xn);
      this.Xs.set(this.Xq);
      if ((!this.Xi) && (j == 0))
      {
        localObject = this.Xp;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.Xp;
      }
      for (((Rect)localObject).bottom += 0;; ((Rect)localObject).bottom += 0)
      {
        a(this.Xe, this.Xp, true);
        if (!this.Xt.equals(this.Xs))
        {
          this.Xt.set(this.Xs);
          this.Xe.g(this.Xs);
        }
        measureChildWithMargins(this.Xe, paramInt1, 0, paramInt2, 0);
        localObject = (LayoutParams)this.Xe.getLayoutParams();
        i = Math.max(i1, this.Xe.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
        j = this.Xe.getMeasuredHeight();
        k = ((LayoutParams)localObject).topMargin;
        j = Math.max(n, ((LayoutParams)localObject).bottomMargin + (j + k));
        k = View.combineMeasuredStates(m, this.Xe.getMeasuredState());
        m = getPaddingLeft();
        n = getPaddingRight();
        j = Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
        return;
        j = 0;
        break;
        label444:
        if (this.Xf.getVisibility() == 8) {
          break label506;
        }
        i = this.Xf.getMeasuredHeight();
        break label153;
        localObject = this.Xs;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.Xs;
      }
      label506:
      i = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = 0;
    if ((!this.Rh) || (!paramBoolean)) {
      return false;
    }
    this.Xw.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    if (this.Xw.getFinalY() > this.Xf.getHeight()) {
      i = 1;
    }
    if (i != 0)
    {
      fD();
      this.XA.run();
    }
    for (;;)
    {
      this.Xk = true;
      return true;
      fD();
      this.Xz.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.Xl += paramInt2;
    setActionBarHideOffset(this.Xl);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.Lj.Fs = paramInt;
    this.Xl = getActionBarHideOffset();
    fD();
    if (this.Xu != null) {
      this.Xu.ex();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (this.Xf.getVisibility() != 0)) {
      return false;
    }
    return this.Rh;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.Rh) && (!this.Xk))
    {
      if (this.Xl <= this.Xf.getHeight())
      {
        fD();
        postDelayed(this.Xz, 600L);
      }
    }
    else {
      return;
    }
    fD();
    postDelayed(this.XA, 600L);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    fC();
    int k = this.Xm;
    this.Xm = paramInt;
    int i;
    int j;
    if ((paramInt & 0x4) == 0)
    {
      i = 1;
      if ((paramInt & 0x100) == 0) {
        break label120;
      }
      j = 1;
      label49:
      if (this.Xu != null)
      {
        a locala = this.Xu;
        if (j != 0) {
          break label125;
        }
        label66:
        locala.P(bool);
        if ((i == 0) && (j != 0)) {
          break label131;
        }
        this.Xu.ev();
      }
    }
    for (;;)
    {
      if ((((k ^ paramInt) & 0x100) != 0) && (this.Xu != null)) {
        q.ad(this);
      }
      return;
      i = 0;
      break;
      label120:
      j = 0;
      break label49;
      label125:
      bool = false;
      break label66;
      label131:
      this.Xu.ew();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.Xd = paramInt;
    if (this.Xu != null) {
      this.Xu.onWindowVisibilityChanged(paramInt);
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    fD();
    paramInt = Math.max(0, Math.min(paramInt, this.Xf.getHeight()));
    this.Xf.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(a parama)
  {
    this.Xu = parama;
    if (getWindowToken() != null)
    {
      this.Xu.onWindowVisibilityChanged(this.Xd);
      if (this.Xm != 0)
      {
        onWindowSystemUiVisibilityChanged(this.Xm);
        q.ad(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.Xj = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.Rh)
    {
      this.Rh = paramBoolean;
      if (!paramBoolean)
      {
        fD();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    fC();
    this.Qq.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    fC();
    this.Qq.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    fC();
    this.Qq.setLogo(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.Xi = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Xh = paramBoolean;
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    fC();
    this.Qq.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    fC();
    this.Qq.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    fC();
    return this.Qq.showOverflowMenu();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface a
  {
    public abstract void P(boolean paramBoolean);
    
    public abstract void ev();
    
    public abstract void ew();
    
    public abstract void ex();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */