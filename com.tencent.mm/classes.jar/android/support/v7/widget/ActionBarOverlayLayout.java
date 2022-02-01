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
  static final int[] NC = { 2130968600, 16842841 };
  private final o RX;
  private u WX;
  private boolean XN;
  private int aeU;
  private int aeV = 0;
  private ContentFrameLayout aeW;
  ActionBarContainer aeX;
  private Drawable aeY;
  private boolean aeZ;
  public boolean afa;
  private boolean afb;
  boolean afc;
  private int afd;
  private int afe;
  private final Rect aff = new Rect();
  private final Rect afg = new Rect();
  private final Rect afh = new Rect();
  private final Rect afi = new Rect();
  private final Rect afj = new Rect();
  private final Rect afk = new Rect();
  private final Rect afl = new Rect();
  private a afm;
  private OverScroller afn;
  ViewPropertyAnimator afo;
  final AnimatorListenerAdapter afp = new AnimatorListenerAdapter()
  {
    public final void onAnimationCancel(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.afo = null;
      ActionBarOverlayLayout.this.afc = false;
    }
    
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.afo = null;
      ActionBarOverlayLayout.this.afc = false;
    }
  };
  private final Runnable afq = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.hR();
      ActionBarOverlayLayout.this.afo = ActionBarOverlayLayout.this.aeX.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.afp);
    }
  };
  private final Runnable afr = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.hR();
      ActionBarOverlayLayout.this.afo = ActionBarOverlayLayout.this.aeX.animate().translationY(-ActionBarOverlayLayout.this.aeX.getHeight()).setListener(ActionBarOverlayLayout.this.afp);
    }
  };
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    this.RX = new o(this);
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
  
  private void hQ()
  {
    if (this.aeW == null)
    {
      this.aeW = ((ContentFrameLayout)findViewById(2131296344));
      this.aeX = ((ActionBarContainer)findViewById(2131296345));
      this.WX = ba(findViewById(2131296343));
    }
  }
  
  private void init(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(NC);
    this.aeU = localTypedArray.getDimensionPixelSize(0, 0);
    this.aeY = localTypedArray.getDrawable(1);
    if (this.aeY == null)
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
      this.aeZ = bool1;
      this.afn = new OverScroller(paramContext);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    hQ();
    this.WX.a(paramMenu, parama);
  }
  
  public final void bv(int paramInt)
  {
    hQ();
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
    if ((this.aeY != null) && (!this.aeZ)) {
      if (this.aeX.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i = (int)(this.aeX.getBottom() + this.aeX.getTranslationY() + 0.5F);; i = 0)
    {
      this.aeY.setBounds(0, i, getWidth(), this.aeY.getIntrinsicHeight() + i);
      this.aeY.draw(paramCanvas);
      return;
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    hQ();
    android.support.v4.view.t.ao(this);
    boolean bool = a(this.aeX, paramRect, false);
    this.afi.set(paramRect);
    bh.a(this, this.afi, this.aff);
    if (!this.afj.equals(this.afi))
    {
      this.afj.set(this.afi);
      bool = true;
    }
    if (!this.afg.equals(this.aff))
    {
      this.afg.set(this.aff);
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
    if (this.aeX != null) {
      return -(int)this.aeX.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.RX.Nd;
  }
  
  public CharSequence getTitle()
  {
    hQ();
    return this.WX.getTitle();
  }
  
  public final void gg()
  {
    hQ();
    this.WX.dismissPopupMenus();
  }
  
  final void hR()
  {
    removeCallbacks(this.afq);
    removeCallbacks(this.afr);
    if (this.afo != null) {
      this.afo.cancel();
    }
  }
  
  public final boolean hS()
  {
    hQ();
    return this.WX.hS();
  }
  
  public final boolean hT()
  {
    hQ();
    return this.WX.hT();
  }
  
  public final void hU()
  {
    hQ();
    this.WX.hU();
  }
  
  public final boolean hideOverflowMenu()
  {
    hQ();
    return this.WX.hideOverflowMenu();
  }
  
  public final boolean isOverflowMenuShowing()
  {
    hQ();
    return this.WX.isOverflowMenuShowing();
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
    hR();
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
    hQ();
    measureChildWithMargins(this.aeX, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.aeX.getLayoutParams();
    int i1 = Math.max(0, this.aeX.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i = this.aeX.getMeasuredHeight();
    int j = ((LayoutParams)localObject).topMargin;
    int n = Math.max(0, ((LayoutParams)localObject).bottomMargin + (i + j));
    int m = View.combineMeasuredStates(0, this.aeX.getMeasuredState());
    int k;
    if ((android.support.v4.view.t.ao(this) & 0x100) != 0)
    {
      j = 1;
      if (j == 0) {
        break label444;
      }
      k = this.aeU;
      i = k;
      if (this.afb)
      {
        i = k;
        if (this.aeX.getTabContainer() != null) {
          i = k + this.aeU;
        }
      }
    }
    for (;;)
    {
      label153:
      this.afh.set(this.aff);
      this.afk.set(this.afi);
      if ((!this.afa) && (j == 0))
      {
        localObject = this.afh;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.afh;
      }
      for (((Rect)localObject).bottom += 0;; ((Rect)localObject).bottom += 0)
      {
        a(this.aeW, this.afh, true);
        if (!this.afl.equals(this.afk))
        {
          this.afl.set(this.afk);
          this.aeW.g(this.afk);
        }
        measureChildWithMargins(this.aeW, paramInt1, 0, paramInt2, 0);
        localObject = (LayoutParams)this.aeW.getLayoutParams();
        i = Math.max(i1, this.aeW.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
        j = this.aeW.getMeasuredHeight();
        k = ((LayoutParams)localObject).topMargin;
        j = Math.max(n, ((LayoutParams)localObject).bottomMargin + (j + k));
        k = View.combineMeasuredStates(m, this.aeW.getMeasuredState());
        m = getPaddingLeft();
        n = getPaddingRight();
        j = Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
        return;
        j = 0;
        break;
        label444:
        if (this.aeX.getVisibility() == 8) {
          break label506;
        }
        i = this.aeX.getMeasuredHeight();
        break label153;
        localObject = this.afk;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.afk;
      }
      label506:
      i = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = 0;
    if ((!this.XN) || (!paramBoolean)) {
      return false;
    }
    this.afn.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    if (this.afn.getFinalY() > this.aeX.getHeight()) {
      i = 1;
    }
    if (i != 0)
    {
      hR();
      this.afr.run();
    }
    for (;;)
    {
      this.afc = true;
      return true;
      hR();
      this.afq.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.afd += paramInt2;
    setActionBarHideOffset(this.afd);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.RX.Nd = paramInt;
    this.afd = getActionBarHideOffset();
    hR();
    if (this.afm != null) {
      this.afm.gu();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (this.aeX.getVisibility() != 0)) {
      return false;
    }
    return this.XN;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.XN) && (!this.afc))
    {
      if (this.afd <= this.aeX.getHeight())
      {
        hR();
        postDelayed(this.afq, 600L);
      }
    }
    else {
      return;
    }
    hR();
    postDelayed(this.afr, 600L);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    hQ();
    int k = this.afe;
    this.afe = paramInt;
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
      if (this.afm != null)
      {
        a locala = this.afm;
        if (j != 0) {
          break label125;
        }
        label66:
        locala.U(bool);
        if ((i == 0) && (j != 0)) {
          break label131;
        }
        this.afm.gr();
      }
    }
    for (;;)
    {
      if ((((k ^ paramInt) & 0x100) != 0) && (this.afm != null)) {
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
      this.afm.gt();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.aeV = paramInt;
    if (this.afm != null) {
      this.afm.onWindowVisibilityChanged(paramInt);
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    hR();
    paramInt = Math.max(0, Math.min(paramInt, this.aeX.getHeight()));
    this.aeX.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(a parama)
  {
    this.afm = parama;
    if (getWindowToken() != null)
    {
      this.afm.onWindowVisibilityChanged(this.aeV);
      if (this.afe != 0)
      {
        onWindowSystemUiVisibilityChanged(this.afe);
        android.support.v4.view.t.ap(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.afb = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.XN)
    {
      this.XN = paramBoolean;
      if (!paramBoolean)
      {
        hR();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    hQ();
    this.WX.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    hQ();
    this.WX.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    hQ();
    this.WX.setLogo(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.afa = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.aeZ = paramBoolean;
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    hQ();
    this.WX.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    hQ();
    this.WX.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    hQ();
    return this.WX.showOverflowMenu();
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
    
    public abstract void gr();
    
    public abstract void gt();
    
    public abstract void gu();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */