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
import android.support.v4.view.m;
import android.support.v4.view.o;
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
  implements m, t
{
  static final int[] GC = { 2130772143, 16842841 };
  private final o KU;
  private u PY;
  private boolean QP;
  private int XO;
  private int XP = 0;
  private ContentFrameLayout XQ;
  ActionBarContainer XR;
  private Drawable XS;
  private boolean XT;
  public boolean XU;
  private boolean XV;
  boolean XW;
  private int XX;
  private int XY;
  private final Rect XZ = new Rect();
  private final Rect Ya = new Rect();
  private final Rect Yb = new Rect();
  private final Rect Yc = new Rect();
  private final Rect Yd = new Rect();
  private final Rect Ye = new Rect();
  private final Rect Yf = new Rect();
  private a Yg;
  private OverScroller Yh;
  ViewPropertyAnimator Yi;
  final AnimatorListenerAdapter Yj = new AnimatorListenerAdapter()
  {
    public final void onAnimationCancel(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.Yi = null;
      ActionBarOverlayLayout.this.XW = false;
    }
    
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.Yi = null;
      ActionBarOverlayLayout.this.XW = false;
    }
  };
  private final Runnable Yk = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.gw();
      ActionBarOverlayLayout.this.Yi = ActionBarOverlayLayout.this.XR.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.Yj);
    }
  };
  private final Runnable Yl = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.gw();
      ActionBarOverlayLayout.this.Yi = ActionBarOverlayLayout.this.XR.animate().translationY(-ActionBarOverlayLayout.this.XR.getHeight()).setListener(ActionBarOverlayLayout.this.Yj);
    }
  };
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    this.KU = new o(this);
  }
  
  private static u aU(View paramView)
  {
    if ((paramView instanceof u)) {
      return (u)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + paramView.getClass().getSimpleName());
  }
  
  private static boolean c(View paramView, Rect paramRect, boolean paramBoolean)
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
  
  private void gv()
  {
    if (this.XQ == null)
    {
      this.XQ = ((ContentFrameLayout)findViewById(2131820544));
      this.XR = ((ActionBarContainer)findViewById(2131820956));
      this.PY = aU(findViewById(2131820957));
    }
  }
  
  private void init(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(GC);
    this.XO = localTypedArray.getDimensionPixelSize(0, 0);
    this.XS = localTypedArray.getDrawable(1);
    if (this.XS == null)
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
      this.XT = bool1;
      this.Yh = new OverScroller(paramContext);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    gv();
    this.PY.a(paramMenu, parama);
  }
  
  public final void bc(int paramInt)
  {
    gv();
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
    if ((this.XS != null) && (!this.XT)) {
      if (this.XR.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i = (int)(this.XR.getBottom() + this.XR.getTranslationY() + 0.5F);; i = 0)
    {
      this.XS.setBounds(0, i, getWidth(), this.XS.getIntrinsicHeight() + i);
      this.XS.draw(paramCanvas);
      return;
    }
  }
  
  public final void eN()
  {
    gv();
    this.PY.dismissPopupMenus();
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    gv();
    android.support.v4.view.t.aj(this);
    boolean bool = c(this.XR, paramRect, false);
    this.Yc.set(paramRect);
    bh.a(this, this.Yc, this.XZ);
    if (!this.Yd.equals(this.Yc))
    {
      this.Yd.set(this.Yc);
      bool = true;
    }
    if (!this.Ya.equals(this.XZ))
    {
      this.Ya.set(this.XZ);
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
    if (this.XR != null) {
      return -(int)this.XR.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.KU.Gd;
  }
  
  public CharSequence getTitle()
  {
    gv();
    return this.PY.getTitle();
  }
  
  final void gw()
  {
    removeCallbacks(this.Yk);
    removeCallbacks(this.Yl);
    if (this.Yi != null) {
      this.Yi.cancel();
    }
  }
  
  public final boolean gx()
  {
    gv();
    return this.PY.gx();
  }
  
  public final boolean gy()
  {
    gv();
    return this.PY.gy();
  }
  
  public final void gz()
  {
    gv();
    this.PY.gz();
  }
  
  public final boolean hideOverflowMenu()
  {
    gv();
    return this.PY.hideOverflowMenu();
  }
  
  public final boolean isOverflowMenuShowing()
  {
    gv();
    return this.PY.isOverflowMenuShowing();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    init(getContext());
    android.support.v4.view.t.ak(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    gw();
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
    gv();
    measureChildWithMargins(this.XR, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.XR.getLayoutParams();
    int i1 = Math.max(0, this.XR.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i = this.XR.getMeasuredHeight();
    int j = ((LayoutParams)localObject).topMargin;
    int n = Math.max(0, ((LayoutParams)localObject).bottomMargin + (i + j));
    int m = View.combineMeasuredStates(0, this.XR.getMeasuredState());
    int k;
    if ((android.support.v4.view.t.aj(this) & 0x100) != 0)
    {
      j = 1;
      if (j == 0) {
        break label444;
      }
      k = this.XO;
      i = k;
      if (this.XV)
      {
        i = k;
        if (this.XR.getTabContainer() != null) {
          i = k + this.XO;
        }
      }
    }
    for (;;)
    {
      label153:
      this.Yb.set(this.XZ);
      this.Ye.set(this.Yc);
      if ((!this.XU) && (j == 0))
      {
        localObject = this.Yb;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.Yb;
      }
      for (((Rect)localObject).bottom += 0;; ((Rect)localObject).bottom += 0)
      {
        c(this.XQ, this.Yb, true);
        if (!this.Yf.equals(this.Ye))
        {
          this.Yf.set(this.Ye);
          this.XQ.g(this.Ye);
        }
        measureChildWithMargins(this.XQ, paramInt1, 0, paramInt2, 0);
        localObject = (LayoutParams)this.XQ.getLayoutParams();
        i = Math.max(i1, this.XQ.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
        j = this.XQ.getMeasuredHeight();
        k = ((LayoutParams)localObject).topMargin;
        j = Math.max(n, ((LayoutParams)localObject).bottomMargin + (j + k));
        k = View.combineMeasuredStates(m, this.XQ.getMeasuredState());
        m = getPaddingLeft();
        n = getPaddingRight();
        j = Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
        return;
        j = 0;
        break;
        label444:
        if (this.XR.getVisibility() == 8) {
          break label506;
        }
        i = this.XR.getMeasuredHeight();
        break label153;
        localObject = this.Ye;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.Ye;
      }
      label506:
      i = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = 0;
    if ((!this.QP) || (!paramBoolean)) {
      return false;
    }
    this.Yh.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    if (this.Yh.getFinalY() > this.XR.getHeight()) {
      i = 1;
    }
    if (i != 0)
    {
      gw();
      this.Yl.run();
    }
    for (;;)
    {
      this.XW = true;
      return true;
      gw();
      this.Yk.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.XX += paramInt2;
    setActionBarHideOffset(this.XX);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.KU.Gd = paramInt;
    this.XX = getActionBarHideOffset();
    gw();
    if (this.Yg != null) {
      this.Yg.fb();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (this.XR.getVisibility() != 0)) {
      return false;
    }
    return this.QP;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.QP) && (!this.XW))
    {
      if (this.XX <= this.XR.getHeight())
      {
        gw();
        postDelayed(this.Yk, 600L);
      }
    }
    else {
      return;
    }
    gw();
    postDelayed(this.Yl, 600L);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    gv();
    int k = this.XY;
    this.XY = paramInt;
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
      if (this.Yg != null)
      {
        a locala = this.Yg;
        if (j != 0) {
          break label125;
        }
        label66:
        locala.O(bool);
        if ((i == 0) && (j != 0)) {
          break label131;
        }
        this.Yg.eY();
      }
    }
    for (;;)
    {
      if ((((k ^ paramInt) & 0x100) != 0) && (this.Yg != null)) {
        android.support.v4.view.t.ak(this);
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
      this.Yg.fa();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.XP = paramInt;
    if (this.Yg != null) {
      this.Yg.onWindowVisibilityChanged(paramInt);
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    gw();
    paramInt = Math.max(0, Math.min(paramInt, this.XR.getHeight()));
    this.XR.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(a parama)
  {
    this.Yg = parama;
    if (getWindowToken() != null)
    {
      this.Yg.onWindowVisibilityChanged(this.XP);
      if (this.XY != 0)
      {
        onWindowSystemUiVisibilityChanged(this.XY);
        android.support.v4.view.t.ak(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.XV = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.QP)
    {
      this.QP = paramBoolean;
      if (!paramBoolean)
      {
        gw();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    gv();
    this.PY.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    gv();
    this.PY.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    gv();
    this.PY.setLogo(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.XU = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.XT = paramBoolean;
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    gv();
    this.PY.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    gv();
    this.PY.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    gv();
    return this.PY.showOverflowMenu();
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
    public abstract void O(boolean paramBoolean);
    
    public abstract void eY();
    
    public abstract void fa();
    
    public abstract void fb();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */