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
  static final int[] Ox = { 2130968600, 16842841 };
  private final o SS;
  private u XS;
  private boolean YI;
  private int afO;
  private int afP = 0;
  private ContentFrameLayout afQ;
  ActionBarContainer afR;
  private Drawable afS;
  private boolean afT;
  public boolean afU;
  private boolean afV;
  boolean afW;
  private int afX;
  private int afY;
  private final Rect afZ = new Rect();
  private final Rect aga = new Rect();
  private final Rect agb = new Rect();
  private final Rect agc = new Rect();
  private final Rect agd = new Rect();
  private final Rect age = new Rect();
  private final Rect agf = new Rect();
  private a agg;
  private OverScroller agh;
  ViewPropertyAnimator agi;
  final AnimatorListenerAdapter agj = new AnimatorListenerAdapter()
  {
    public final void onAnimationCancel(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.agi = null;
      ActionBarOverlayLayout.this.afW = false;
    }
    
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.agi = null;
      ActionBarOverlayLayout.this.afW = false;
    }
  };
  private final Runnable agk = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.hZ();
      ActionBarOverlayLayout.this.agi = ActionBarOverlayLayout.this.afR.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.agj);
    }
  };
  private final Runnable agl = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.hZ();
      ActionBarOverlayLayout.this.agi = ActionBarOverlayLayout.this.afR.animate().translationY(-ActionBarOverlayLayout.this.afR.getHeight()).setListener(ActionBarOverlayLayout.this.agj);
    }
  };
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    this.SS = new o(this);
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
  
  private static u ba(View paramView)
  {
    if ((paramView instanceof u)) {
      return (u)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + paramView.getClass().getSimpleName());
  }
  
  private void hY()
  {
    if (this.afQ == null)
    {
      this.afQ = ((ContentFrameLayout)findViewById(2131296344));
      this.afR = ((ActionBarContainer)findViewById(2131296345));
      this.XS = ba(findViewById(2131296343));
    }
  }
  
  private void init(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(Ox);
    this.afO = localTypedArray.getDimensionPixelSize(0, 0);
    this.afS = localTypedArray.getDrawable(1);
    if (this.afS == null)
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
      this.afT = bool1;
      this.agh = new OverScroller(paramContext);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    hY();
    this.XS.a(paramMenu, parama);
  }
  
  public final void bv(int paramInt)
  {
    hY();
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
    if ((this.afS != null) && (!this.afT)) {
      if (this.afR.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i = (int)(this.afR.getBottom() + this.afR.getTranslationY() + 0.5F);; i = 0)
    {
      this.afS.setBounds(0, i, getWidth(), this.afS.getIntrinsicHeight() + i);
      this.afS.draw(paramCanvas);
      return;
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    hY();
    android.support.v4.view.t.ao(this);
    boolean bool = a(this.afR, paramRect, false);
    this.agc.set(paramRect);
    bh.a(this, this.agc, this.afZ);
    if (!this.agd.equals(this.agc))
    {
      this.agd.set(this.agc);
      bool = true;
    }
    if (!this.aga.equals(this.afZ))
    {
      this.aga.set(this.afZ);
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
    if (this.afR != null) {
      return -(int)this.afR.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.SS.NY;
  }
  
  public CharSequence getTitle()
  {
    hY();
    return this.XS.getTitle();
  }
  
  public final void go()
  {
    hY();
    this.XS.dismissPopupMenus();
  }
  
  final void hZ()
  {
    removeCallbacks(this.agk);
    removeCallbacks(this.agl);
    if (this.agi != null) {
      this.agi.cancel();
    }
  }
  
  public final boolean hideOverflowMenu()
  {
    hY();
    return this.XS.hideOverflowMenu();
  }
  
  public final boolean ia()
  {
    hY();
    return this.XS.ia();
  }
  
  public final boolean ib()
  {
    hY();
    return this.XS.ib();
  }
  
  public final void ic()
  {
    hY();
    this.XS.ic();
  }
  
  public final boolean isOverflowMenuShowing()
  {
    hY();
    return this.XS.isOverflowMenuShowing();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    init(getContext());
    android.support.v4.view.t.ap(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    hZ();
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
    hY();
    measureChildWithMargins(this.afR, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.afR.getLayoutParams();
    int i1 = Math.max(0, this.afR.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i = this.afR.getMeasuredHeight();
    int j = ((LayoutParams)localObject).topMargin;
    int n = Math.max(0, ((LayoutParams)localObject).bottomMargin + (i + j));
    int m = View.combineMeasuredStates(0, this.afR.getMeasuredState());
    int k;
    if ((android.support.v4.view.t.ao(this) & 0x100) != 0)
    {
      j = 1;
      if (j == 0) {
        break label444;
      }
      k = this.afO;
      i = k;
      if (this.afV)
      {
        i = k;
        if (this.afR.getTabContainer() != null) {
          i = k + this.afO;
        }
      }
    }
    for (;;)
    {
      label153:
      this.agb.set(this.afZ);
      this.age.set(this.agc);
      if ((!this.afU) && (j == 0))
      {
        localObject = this.agb;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.agb;
      }
      for (((Rect)localObject).bottom += 0;; ((Rect)localObject).bottom += 0)
      {
        a(this.afQ, this.agb, true);
        if (!this.agf.equals(this.age))
        {
          this.agf.set(this.age);
          this.afQ.g(this.age);
        }
        measureChildWithMargins(this.afQ, paramInt1, 0, paramInt2, 0);
        localObject = (LayoutParams)this.afQ.getLayoutParams();
        i = Math.max(i1, this.afQ.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
        j = this.afQ.getMeasuredHeight();
        k = ((LayoutParams)localObject).topMargin;
        j = Math.max(n, ((LayoutParams)localObject).bottomMargin + (j + k));
        k = View.combineMeasuredStates(m, this.afQ.getMeasuredState());
        m = getPaddingLeft();
        n = getPaddingRight();
        j = Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
        return;
        j = 0;
        break;
        label444:
        if (this.afR.getVisibility() == 8) {
          break label506;
        }
        i = this.afR.getMeasuredHeight();
        break label153;
        localObject = this.age;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.age;
      }
      label506:
      i = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = 0;
    if ((!this.YI) || (!paramBoolean)) {
      return false;
    }
    this.agh.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    if (this.agh.getFinalY() > this.afR.getHeight()) {
      i = 1;
    }
    if (i != 0)
    {
      hZ();
      this.agl.run();
    }
    for (;;)
    {
      this.afW = true;
      return true;
      hZ();
      this.agk.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.afX += paramInt2;
    setActionBarHideOffset(this.afX);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.SS.NY = paramInt;
    this.afX = getActionBarHideOffset();
    hZ();
    if (this.agg != null) {
      this.agg.gC();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (this.afR.getVisibility() != 0)) {
      return false;
    }
    return this.YI;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.YI) && (!this.afW))
    {
      if (this.afX <= this.afR.getHeight())
      {
        hZ();
        postDelayed(this.agk, 600L);
      }
    }
    else {
      return;
    }
    hZ();
    postDelayed(this.agl, 600L);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    hY();
    int k = this.afY;
    this.afY = paramInt;
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
      if (this.agg != null)
      {
        a locala = this.agg;
        if (j != 0) {
          break label125;
        }
        label66:
        locala.U(bool);
        if ((i == 0) && (j != 0)) {
          break label131;
        }
        this.agg.gz();
      }
    }
    for (;;)
    {
      if ((((k ^ paramInt) & 0x100) != 0) && (this.agg != null)) {
        android.support.v4.view.t.ap(this);
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
      this.agg.gB();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.afP = paramInt;
    if (this.agg != null) {
      this.agg.onWindowVisibilityChanged(paramInt);
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    hZ();
    paramInt = Math.max(0, Math.min(paramInt, this.afR.getHeight()));
    this.afR.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(a parama)
  {
    this.agg = parama;
    if (getWindowToken() != null)
    {
      this.agg.onWindowVisibilityChanged(this.afP);
      if (this.afY != 0)
      {
        onWindowSystemUiVisibilityChanged(this.afY);
        android.support.v4.view.t.ap(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.afV = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.YI)
    {
      this.YI = paramBoolean;
      if (!paramBoolean)
      {
        hZ();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    hY();
    this.XS.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    hY();
    this.XS.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    hY();
    this.XS.setLogo(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.afU = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.afT = paramBoolean;
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    hY();
    this.XS.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    hY();
    this.XS.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    hY();
    return this.XS.showOverflowMenu();
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
    public abstract void U(boolean paramBoolean);
    
    public abstract void gB();
    
    public abstract void gC();
    
    public abstract void gz();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */