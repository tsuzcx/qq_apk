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
  static final int[] Qo = { 2130968600, 16842841 };
  private final o UH;
  private u ZH;
  private boolean aax;
  private int ahF;
  private int ahG = 0;
  private ContentFrameLayout ahH;
  ActionBarContainer ahI;
  private Drawable ahJ;
  private boolean ahK;
  public boolean ahL;
  private boolean ahM;
  boolean ahN;
  private int ahO;
  private int ahP;
  private final Rect ahQ = new Rect();
  private final Rect ahR = new Rect();
  private final Rect ahS = new Rect();
  private final Rect ahT = new Rect();
  private final Rect ahU = new Rect();
  private final Rect ahV = new Rect();
  private final Rect ahW = new Rect();
  private a ahX;
  private OverScroller ahY;
  ViewPropertyAnimator ahZ;
  final AnimatorListenerAdapter aia = new AnimatorListenerAdapter()
  {
    public final void onAnimationCancel(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.ahZ = null;
      ActionBarOverlayLayout.this.ahN = false;
    }
    
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.ahZ = null;
      ActionBarOverlayLayout.this.ahN = false;
    }
  };
  private final Runnable aib = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.ir();
      ActionBarOverlayLayout.this.ahZ = ActionBarOverlayLayout.this.ahI.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.aia);
    }
  };
  private final Runnable aic = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.ir();
      ActionBarOverlayLayout.this.ahZ = ActionBarOverlayLayout.this.ahI.animate().translationY(-ActionBarOverlayLayout.this.ahI.getHeight()).setListener(ActionBarOverlayLayout.this.aia);
    }
  };
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    this.UH = new o(this);
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
  
  private void init(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(Qo);
    this.ahF = localTypedArray.getDimensionPixelSize(0, 0);
    this.ahJ = localTypedArray.getDrawable(1);
    if (this.ahJ == null)
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
      this.ahK = bool1;
      this.ahY = new OverScroller(paramContext);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void iq()
  {
    if (this.ahH == null)
    {
      this.ahH = ((ContentFrameLayout)findViewById(2131296344));
      this.ahI = ((ActionBarContainer)findViewById(2131296345));
      this.ZH = ba(findViewById(2131296343));
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    iq();
    this.ZH.a(paramMenu, parama);
  }
  
  public final void bv(int paramInt)
  {
    iq();
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
    if ((this.ahJ != null) && (!this.ahK)) {
      if (this.ahI.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i = (int)(this.ahI.getBottom() + this.ahI.getTranslationY() + 0.5F);; i = 0)
    {
      this.ahJ.setBounds(0, i, getWidth(), this.ahJ.getIntrinsicHeight() + i);
      this.ahJ.draw(paramCanvas);
      return;
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    iq();
    android.support.v4.view.t.ao(this);
    boolean bool = a(this.ahI, paramRect, false);
    this.ahT.set(paramRect);
    bh.a(this, this.ahT, this.ahQ);
    if (!this.ahU.equals(this.ahT))
    {
      this.ahU.set(this.ahT);
      bool = true;
    }
    if (!this.ahR.equals(this.ahQ))
    {
      this.ahR.set(this.ahQ);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  public final void gF()
  {
    iq();
    this.ZH.dismissPopupMenus();
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    if (this.ahI != null) {
      return -(int)this.ahI.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.UH.PP;
  }
  
  public CharSequence getTitle()
  {
    iq();
    return this.ZH.getTitle();
  }
  
  public final boolean hideOverflowMenu()
  {
    iq();
    return this.ZH.hideOverflowMenu();
  }
  
  final void ir()
  {
    removeCallbacks(this.aib);
    removeCallbacks(this.aic);
    if (this.ahZ != null) {
      this.ahZ.cancel();
    }
  }
  
  public final boolean is()
  {
    iq();
    return this.ZH.is();
  }
  
  public final boolean isOverflowMenuShowing()
  {
    iq();
    return this.ZH.isOverflowMenuShowing();
  }
  
  public final boolean it()
  {
    iq();
    return this.ZH.it();
  }
  
  public final void iu()
  {
    iq();
    this.ZH.iu();
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
    ir();
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
    iq();
    measureChildWithMargins(this.ahI, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.ahI.getLayoutParams();
    int i1 = Math.max(0, this.ahI.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i = this.ahI.getMeasuredHeight();
    int j = ((LayoutParams)localObject).topMargin;
    int n = Math.max(0, ((LayoutParams)localObject).bottomMargin + (i + j));
    int m = View.combineMeasuredStates(0, this.ahI.getMeasuredState());
    int k;
    if ((android.support.v4.view.t.ao(this) & 0x100) != 0)
    {
      j = 1;
      if (j == 0) {
        break label444;
      }
      k = this.ahF;
      i = k;
      if (this.ahM)
      {
        i = k;
        if (this.ahI.getTabContainer() != null) {
          i = k + this.ahF;
        }
      }
    }
    for (;;)
    {
      label153:
      this.ahS.set(this.ahQ);
      this.ahV.set(this.ahT);
      if ((!this.ahL) && (j == 0))
      {
        localObject = this.ahS;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.ahS;
      }
      for (((Rect)localObject).bottom += 0;; ((Rect)localObject).bottom += 0)
      {
        a(this.ahH, this.ahS, true);
        if (!this.ahW.equals(this.ahV))
        {
          this.ahW.set(this.ahV);
          this.ahH.g(this.ahV);
        }
        measureChildWithMargins(this.ahH, paramInt1, 0, paramInt2, 0);
        localObject = (LayoutParams)this.ahH.getLayoutParams();
        i = Math.max(i1, this.ahH.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
        j = this.ahH.getMeasuredHeight();
        k = ((LayoutParams)localObject).topMargin;
        j = Math.max(n, ((LayoutParams)localObject).bottomMargin + (j + k));
        k = View.combineMeasuredStates(m, this.ahH.getMeasuredState());
        m = getPaddingLeft();
        n = getPaddingRight();
        j = Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
        return;
        j = 0;
        break;
        label444:
        if (this.ahI.getVisibility() == 8) {
          break label506;
        }
        i = this.ahI.getMeasuredHeight();
        break label153;
        localObject = this.ahV;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.ahV;
      }
      label506:
      i = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = 0;
    if ((!this.aax) || (!paramBoolean)) {
      return false;
    }
    this.ahY.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    if (this.ahY.getFinalY() > this.ahI.getHeight()) {
      i = 1;
    }
    if (i != 0)
    {
      ir();
      this.aic.run();
    }
    for (;;)
    {
      this.ahN = true;
      return true;
      ir();
      this.aib.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ahO += paramInt2;
    setActionBarHideOffset(this.ahO);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.UH.PP = paramInt;
    this.ahO = getActionBarHideOffset();
    ir();
    if (this.ahX != null) {
      this.ahX.gT();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (this.ahI.getVisibility() != 0)) {
      return false;
    }
    return this.aax;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.aax) && (!this.ahN))
    {
      if (this.ahO <= this.ahI.getHeight())
      {
        ir();
        postDelayed(this.aib, 600L);
      }
    }
    else {
      return;
    }
    ir();
    postDelayed(this.aic, 600L);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    iq();
    int k = this.ahP;
    this.ahP = paramInt;
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
      if (this.ahX != null)
      {
        a locala = this.ahX;
        if (j != 0) {
          break label125;
        }
        label66:
        locala.U(bool);
        if ((i == 0) && (j != 0)) {
          break label131;
        }
        this.ahX.gQ();
      }
    }
    for (;;)
    {
      if ((((k ^ paramInt) & 0x100) != 0) && (this.ahX != null)) {
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
      this.ahX.gS();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.ahG = paramInt;
    if (this.ahX != null) {
      this.ahX.onWindowVisibilityChanged(paramInt);
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    ir();
    paramInt = Math.max(0, Math.min(paramInt, this.ahI.getHeight()));
    this.ahI.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(a parama)
  {
    this.ahX = parama;
    if (getWindowToken() != null)
    {
      this.ahX.onWindowVisibilityChanged(this.ahG);
      if (this.ahP != 0)
      {
        onWindowSystemUiVisibilityChanged(this.ahP);
        android.support.v4.view.t.ap(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.ahM = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.aax)
    {
      this.aax = paramBoolean;
      if (!paramBoolean)
      {
        ir();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    iq();
    this.ZH.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    iq();
    this.ZH.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    iq();
    this.ZH.setLogo(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.ahL = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.ahK = paramBoolean;
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    iq();
    this.ZH.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    iq();
    this.ZH.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    iq();
    return this.ZH.showOverflowMenu();
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
    
    public abstract void gQ();
    
    public abstract void gS();
    
    public abstract void gT();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */