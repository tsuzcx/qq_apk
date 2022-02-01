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
  static final int[] QA = { 2130968601, 16842841 };
  private final o UV;
  private u ZU;
  private boolean aaK;
  private int ahS = 0;
  private ContentFrameLayout ahT;
  ActionBarContainer ahU;
  private Drawable ahV;
  private boolean ahW;
  public boolean ahX;
  private boolean ahY;
  boolean ahZ;
  private int aia;
  private int aib;
  private final Rect aic = new Rect();
  private final Rect aie = new Rect();
  private final Rect aif = new Rect();
  private final Rect aig = new Rect();
  private final Rect aih = new Rect();
  private final Rect aii = new Rect();
  private final Rect aij = new Rect();
  private a aik;
  private OverScroller ail;
  ViewPropertyAnimator aim;
  final AnimatorListenerAdapter ain = new AnimatorListenerAdapter()
  {
    public final void onAnimationCancel(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.aim = null;
      ActionBarOverlayLayout.this.ahZ = false;
    }
    
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.aim = null;
      ActionBarOverlayLayout.this.ahZ = false;
    }
  };
  private final Runnable aio = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.iA();
      ActionBarOverlayLayout.this.aim = ActionBarOverlayLayout.this.ahU.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.ain);
    }
  };
  private final Runnable aip = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.iA();
      ActionBarOverlayLayout.this.aim = ActionBarOverlayLayout.this.ahU.animate().translationY(-ActionBarOverlayLayout.this.ahU.getHeight()).setListener(ActionBarOverlayLayout.this.ain);
    }
  };
  private int mActionBarHeight;
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    this.UV = new o(this);
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
  
  private static u bb(View paramView)
  {
    if ((paramView instanceof u)) {
      return (u)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + paramView.getClass().getSimpleName());
  }
  
  private void init(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(QA);
    this.mActionBarHeight = localTypedArray.getDimensionPixelSize(0, 0);
    this.ahV = localTypedArray.getDrawable(1);
    if (this.ahV == null)
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
      this.ahW = bool1;
      this.ail = new OverScroller(paramContext);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void iz()
  {
    if (this.ahT == null)
    {
      this.ahT = ((ContentFrameLayout)findViewById(2131296364));
      this.ahU = ((ActionBarContainer)findViewById(2131296366));
      this.ZU = bb(findViewById(2131296363));
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    iz();
    this.ZU.a(paramMenu, parama);
  }
  
  public final void bw(int paramInt)
  {
    iz();
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
    if ((this.ahV != null) && (!this.ahW)) {
      if (this.ahU.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i = (int)(this.ahU.getBottom() + this.ahU.getTranslationY() + 0.5F);; i = 0)
    {
      this.ahV.setBounds(0, i, getWidth(), this.ahV.getIntrinsicHeight() + i);
      this.ahV.draw(paramCanvas);
      return;
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    iz();
    android.support.v4.view.u.ao(this);
    boolean bool = a(this.ahU, paramRect, false);
    this.aig.set(paramRect);
    bh.a(this, this.aig, this.aic);
    if (!this.aih.equals(this.aig))
    {
      this.aih.set(this.aig);
      bool = true;
    }
    if (!this.aie.equals(this.aic))
    {
      this.aie.set(this.aic);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  public final void gM()
  {
    iz();
    this.ZU.dismissPopupMenus();
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    if (this.ahU != null) {
      return -(int)this.ahU.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.UV.Qb;
  }
  
  public CharSequence getTitle()
  {
    iz();
    return this.ZU.getTitle();
  }
  
  public final boolean hideOverflowMenu()
  {
    iz();
    return this.ZU.hideOverflowMenu();
  }
  
  final void iA()
  {
    removeCallbacks(this.aio);
    removeCallbacks(this.aip);
    if (this.aim != null) {
      this.aim.cancel();
    }
  }
  
  public final boolean iB()
  {
    iz();
    return this.ZU.iB();
  }
  
  public final boolean iC()
  {
    iz();
    return this.ZU.iC();
  }
  
  public final void iD()
  {
    iz();
    this.ZU.iD();
  }
  
  public final boolean isOverflowMenuShowing()
  {
    iz();
    return this.ZU.isOverflowMenuShowing();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    init(getContext());
    android.support.v4.view.u.ap(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    iA();
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
    iz();
    measureChildWithMargins(this.ahU, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.ahU.getLayoutParams();
    int i1 = Math.max(0, this.ahU.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i = this.ahU.getMeasuredHeight();
    int j = ((LayoutParams)localObject).topMargin;
    int n = Math.max(0, ((LayoutParams)localObject).bottomMargin + (i + j));
    int m = View.combineMeasuredStates(0, this.ahU.getMeasuredState());
    int k;
    if ((android.support.v4.view.u.ao(this) & 0x100) != 0)
    {
      j = 1;
      if (j == 0) {
        break label444;
      }
      k = this.mActionBarHeight;
      i = k;
      if (this.ahY)
      {
        i = k;
        if (this.ahU.getTabContainer() != null) {
          i = k + this.mActionBarHeight;
        }
      }
    }
    for (;;)
    {
      label153:
      this.aif.set(this.aic);
      this.aii.set(this.aig);
      if ((!this.ahX) && (j == 0))
      {
        localObject = this.aif;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.aif;
      }
      for (((Rect)localObject).bottom += 0;; ((Rect)localObject).bottom += 0)
      {
        a(this.ahT, this.aif, true);
        if (!this.aij.equals(this.aii))
        {
          this.aij.set(this.aii);
          this.ahT.g(this.aii);
        }
        measureChildWithMargins(this.ahT, paramInt1, 0, paramInt2, 0);
        localObject = (LayoutParams)this.ahT.getLayoutParams();
        i = Math.max(i1, this.ahT.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
        j = this.ahT.getMeasuredHeight();
        k = ((LayoutParams)localObject).topMargin;
        j = Math.max(n, ((LayoutParams)localObject).bottomMargin + (j + k));
        k = View.combineMeasuredStates(m, this.ahT.getMeasuredState());
        m = getPaddingLeft();
        n = getPaddingRight();
        j = Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
        return;
        j = 0;
        break;
        label444:
        if (this.ahU.getVisibility() == 8) {
          break label506;
        }
        i = this.ahU.getMeasuredHeight();
        break label153;
        localObject = this.aii;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.aii;
      }
      label506:
      i = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = 0;
    if ((!this.aaK) || (!paramBoolean)) {
      return false;
    }
    this.ail.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    if (this.ail.getFinalY() > this.ahU.getHeight()) {
      i = 1;
    }
    if (i != 0)
    {
      iA();
      this.aip.run();
    }
    for (;;)
    {
      this.ahZ = true;
      return true;
      iA();
      this.aio.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aia += paramInt2;
    setActionBarHideOffset(this.aia);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.UV.Qb = paramInt;
    this.aia = getActionBarHideOffset();
    iA();
    if (this.aik != null) {
      this.aik.ha();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (this.ahU.getVisibility() != 0)) {
      return false;
    }
    return this.aaK;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.aaK) && (!this.ahZ))
    {
      if (this.aia <= this.ahU.getHeight())
      {
        iA();
        postDelayed(this.aio, 600L);
      }
    }
    else {
      return;
    }
    iA();
    postDelayed(this.aip, 600L);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    iz();
    int k = this.aib;
    this.aib = paramInt;
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
      if (this.aik != null)
      {
        a locala = this.aik;
        if (j != 0) {
          break label125;
        }
        label66:
        locala.T(bool);
        if ((i == 0) && (j != 0)) {
          break label131;
        }
        this.aik.gX();
      }
    }
    for (;;)
    {
      if ((((k ^ paramInt) & 0x100) != 0) && (this.aik != null)) {
        android.support.v4.view.u.ap(this);
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
      this.aik.gZ();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.ahS = paramInt;
    if (this.aik != null) {
      this.aik.onWindowVisibilityChanged(paramInt);
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    iA();
    paramInt = Math.max(0, Math.min(paramInt, this.ahU.getHeight()));
    this.ahU.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(a parama)
  {
    this.aik = parama;
    if (getWindowToken() != null)
    {
      this.aik.onWindowVisibilityChanged(this.ahS);
      if (this.aib != 0)
      {
        onWindowSystemUiVisibilityChanged(this.aib);
        android.support.v4.view.u.ap(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.ahY = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.aaK)
    {
      this.aaK = paramBoolean;
      if (!paramBoolean)
      {
        iA();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    iz();
    this.ZU.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    iz();
    this.ZU.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    iz();
    this.ZU.setLogo(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.ahX = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.ahW = paramBoolean;
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    iz();
    this.ZU.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    iz();
    this.ZU.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    iz();
    return this.ZU.showOverflowMenu();
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
    public abstract void T(boolean paramBoolean);
    
    public abstract void gX();
    
    public abstract void gZ();
    
    public abstract void ha();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */