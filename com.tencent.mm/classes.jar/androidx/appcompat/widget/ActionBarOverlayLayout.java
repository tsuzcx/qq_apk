package androidx.appcompat.widget;

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
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;
import androidx.appcompat.a.a;
import androidx.appcompat.a.f;
import androidx.appcompat.view.menu.o.a;
import androidx.core.g.o;
import androidx.core.g.r;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements m, o
{
  static final int[] oG = { a.a.actionBarSize, 16842841 };
  private n ht;
  private boolean il;
  private int mActionBarHeight;
  private a oA;
  private OverScroller oB;
  ViewPropertyAnimator oC;
  final AnimatorListenerAdapter oD;
  private final Runnable oE;
  private final Runnable oF;
  private final r oH;
  private int og;
  private ContentFrameLayout oh;
  ActionBarContainer oi;
  private Drawable oj;
  private boolean ok;
  public boolean ol;
  private boolean om;
  boolean oo;
  private int oq;
  private int or;
  private final Rect ot;
  private final Rect ou;
  private final Rect ov;
  private final Rect ow;
  private final Rect ox;
  private final Rect oy;
  private final Rect oz;
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(240183);
    this.og = 0;
    this.ot = new Rect();
    this.ou = new Rect();
    this.ov = new Rect();
    this.ow = new Rect();
    this.ox = new Rect();
    this.oy = new Rect();
    this.oz = new Rect();
    this.oD = new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        ActionBarOverlayLayout.this.oC = null;
        ActionBarOverlayLayout.this.oo = false;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ActionBarOverlayLayout.this.oC = null;
        ActionBarOverlayLayout.this.oo = false;
      }
    };
    this.oE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(240141);
        ActionBarOverlayLayout.this.cH();
        ActionBarOverlayLayout.this.oC = ActionBarOverlayLayout.this.oi.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.oD);
        AppMethodBeat.o(240141);
      }
    };
    this.oF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(240150);
        ActionBarOverlayLayout.this.cH();
        ActionBarOverlayLayout.this.oC = ActionBarOverlayLayout.this.oi.animate().translationY(-ActionBarOverlayLayout.this.oi.getHeight()).setListener(ActionBarOverlayLayout.this.oD);
        AppMethodBeat.o(240150);
      }
    };
    init(paramContext);
    this.oH = new r();
    AppMethodBeat.o(240183);
  }
  
  private static boolean a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(240208);
    boolean bool1 = false;
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (paramView.leftMargin != paramRect.left)
    {
      paramView.leftMargin = paramRect.left;
      bool1 = true;
    }
    if (paramView.topMargin != paramRect.top)
    {
      paramView.topMargin = paramRect.top;
      bool1 = true;
    }
    if (paramView.rightMargin != paramRect.right)
    {
      paramView.rightMargin = paramRect.right;
      bool1 = true;
    }
    if ((paramBoolean) && (paramView.bottomMargin != paramRect.bottom)) {
      paramView.bottomMargin = paramRect.bottom;
    }
    for (paramBoolean = bool2;; paramBoolean = bool1)
    {
      AppMethodBeat.o(240208);
      return paramBoolean;
    }
  }
  
  private void cG()
  {
    AppMethodBeat.i(240244);
    if (this.oh == null)
    {
      this.oh = ((ContentFrameLayout)findViewById(a.f.action_bar_activity_content));
      this.oi = ((ActionBarContainer)findViewById(a.f.action_bar_container));
      this.ht = h(findViewById(a.f.action_bar));
    }
    AppMethodBeat.o(240244);
  }
  
  private static n h(View paramView)
  {
    AppMethodBeat.i(240246);
    if ((paramView instanceof n))
    {
      paramView = (n)paramView;
      AppMethodBeat.o(240246);
      return paramView;
    }
    if ((paramView instanceof Toolbar))
    {
      paramView = ((Toolbar)paramView).getWrapper();
      AppMethodBeat.o(240246);
      return paramView;
    }
    paramView = new IllegalStateException("Can't make a decor toolbar out of " + paramView.getClass().getSimpleName());
    AppMethodBeat.o(240246);
    throw paramView;
  }
  
  private void init(Context paramContext)
  {
    boolean bool2 = true;
    AppMethodBeat.i(240187);
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(oG);
    this.mActionBarHeight = localTypedArray.getDimensionPixelSize(0, 0);
    this.oj = localTypedArray.getDrawable(1);
    if (this.oj == null)
    {
      bool1 = true;
      setWillNotDraw(bool1);
      localTypedArray.recycle();
      if (paramContext.getApplicationInfo().targetSdkVersion >= 19) {
        break label104;
      }
    }
    label104:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ok = bool1;
      this.oB = new OverScroller(paramContext);
      AppMethodBeat.o(240187);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    AppMethodBeat.i(240280);
    cG();
    this.ht.a(paramMenu, parama);
    AppMethodBeat.o(240280);
  }
  
  public final void aV()
  {
    AppMethodBeat.i(240282);
    cG();
    this.ht.cU();
    AppMethodBeat.o(240282);
  }
  
  public final void al(int paramInt)
  {
    AppMethodBeat.i(240262);
    cG();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(240262);
      return;
      AppMethodBeat.o(240262);
      return;
      AppMethodBeat.o(240262);
      return;
      setOverlayMode(true);
    }
  }
  
  public final boolean cC()
  {
    AppMethodBeat.i(240276);
    cG();
    boolean bool = this.ht.cC();
    AppMethodBeat.o(240276);
    return bool;
  }
  
  final void cH()
  {
    AppMethodBeat.i(240254);
    removeCallbacks(this.oE);
    removeCallbacks(this.oF);
    if (this.oC != null) {
      this.oC.cancel();
    }
    AppMethodBeat.o(240254);
  }
  
  public final boolean cI()
  {
    AppMethodBeat.i(240271);
    cG();
    boolean bool = this.ht.cI();
    AppMethodBeat.o(240271);
    return bool;
  }
  
  public final boolean cJ()
  {
    AppMethodBeat.i(240273);
    cG();
    boolean bool = this.ht.cJ();
    AppMethodBeat.o(240273);
    return bool;
  }
  
  public final boolean cK()
  {
    AppMethodBeat.i(240274);
    cG();
    boolean bool = this.ht.cK();
    AppMethodBeat.o(240274);
    return bool;
  }
  
  public final boolean cL()
  {
    AppMethodBeat.i(240277);
    cG();
    boolean bool = this.ht.cL();
    AppMethodBeat.o(240277);
    return bool;
  }
  
  public final void cM()
  {
    AppMethodBeat.i(240279);
    cG();
    this.ht.cM();
    AppMethodBeat.o(240279);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(240219);
    super.draw(paramCanvas);
    if ((this.oj != null) && (!this.ok)) {
      if (this.oi.getVisibility() != 0) {
        break label94;
      }
    }
    label94:
    for (int i = (int)(this.oi.getBottom() + this.oi.getTranslationY() + 0.5F);; i = 0)
    {
      this.oj.setBounds(0, i, getWidth(), this.oj.getIntrinsicHeight() + i);
      this.oj.draw(paramCanvas);
      AppMethodBeat.o(240219);
      return;
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(240209);
    cG();
    w.X(this);
    boolean bool = a(this.oi, paramRect, false);
    this.ow.set(paramRect);
    ai.a(this, this.ow, this.ot);
    if (!this.ox.equals(this.ow))
    {
      this.ox.set(this.ow);
      bool = true;
    }
    if (!this.ou.equals(this.ot))
    {
      this.ou.set(this.ot);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    AppMethodBeat.o(240209);
    return true;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(240210);
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(240210);
    return paramLayoutParams;
  }
  
  public int getActionBarHideOffset()
  {
    AppMethodBeat.i(240250);
    if (this.oi != null)
    {
      int i = -(int)this.oi.getTranslationY();
      AppMethodBeat.o(240250);
      return i;
    }
    AppMethodBeat.o(240250);
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    AppMethodBeat.i(240241);
    int i = this.oH.getNestedScrollAxes();
    AppMethodBeat.o(240241);
    return i;
  }
  
  public CharSequence getTitle()
  {
    AppMethodBeat.i(240259);
    cG();
    CharSequence localCharSequence = this.ht.getTitle();
    AppMethodBeat.o(240259);
    return localCharSequence;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(240202);
    super.onConfigurationChanged(paramConfiguration);
    init(getContext());
    w.Y(this);
    AppMethodBeat.o(240202);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(240189);
    super.onDetachedFromWindow();
    cH();
    AppMethodBeat.o(240189);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(240217);
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
    AppMethodBeat.o(240217);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240214);
    cG();
    measureChildWithMargins(this.oi, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.oi.getLayoutParams();
    int i1 = Math.max(0, this.oi.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i = this.oi.getMeasuredHeight();
    int j = ((LayoutParams)localObject).topMargin;
    int n = Math.max(0, ((LayoutParams)localObject).bottomMargin + (i + j));
    int m = View.combineMeasuredStates(0, this.oi.getMeasuredState());
    int k;
    if ((w.X(this) & 0x100) != 0)
    {
      j = 1;
      if (j == 0) {
        break label456;
      }
      k = this.mActionBarHeight;
      i = k;
      if (this.om)
      {
        i = k;
        if (this.oi.getTabContainer() != null) {
          i = k + this.mActionBarHeight;
        }
      }
    }
    for (;;)
    {
      label159:
      this.ov.set(this.ot);
      this.oy.set(this.ow);
      if ((!this.ol) && (j == 0))
      {
        localObject = this.ov;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.ov;
      }
      for (((Rect)localObject).bottom += 0;; ((Rect)localObject).bottom += 0)
      {
        a(this.oh, this.ov, true);
        if (!this.oz.equals(this.oy))
        {
          this.oz.set(this.oy);
          this.oh.b(this.oy);
        }
        measureChildWithMargins(this.oh, paramInt1, 0, paramInt2, 0);
        localObject = (LayoutParams)this.oh.getLayoutParams();
        i = Math.max(i1, this.oh.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
        j = this.oh.getMeasuredHeight();
        k = ((LayoutParams)localObject).topMargin;
        j = Math.max(n, ((LayoutParams)localObject).bottomMargin + (j + k));
        k = View.combineMeasuredStates(m, this.oh.getMeasuredState());
        m = getPaddingLeft();
        n = getPaddingRight();
        j = Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
        AppMethodBeat.o(240214);
        return;
        j = 0;
        break;
        label456:
        if (this.oi.getVisibility() == 8) {
          break label518;
        }
        i = this.oi.getMeasuredHeight();
        break label159;
        localObject = this.oy;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.oy;
      }
      label518:
      i = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(240232);
    if ((!this.il) || (!paramBoolean))
    {
      AppMethodBeat.o(240232);
      return false;
    }
    this.oB.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    if (this.oB.getFinalY() > this.oi.getHeight()) {
      i = 1;
    }
    if (i != 0)
    {
      cH();
      this.oF.run();
    }
    for (;;)
    {
      this.oo = true;
      AppMethodBeat.o(240232);
      return true;
      cH();
      this.oE.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(240226);
    this.oq += paramInt2;
    setActionBarHideOffset(this.oq);
    AppMethodBeat.o(240226);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(240224);
    this.oH.F(paramInt, 0);
    this.oq = getActionBarHideOffset();
    cH();
    if (this.oA != null) {
      this.oA.bl();
    }
    AppMethodBeat.o(240224);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(240221);
    if (((paramInt & 0x2) == 0) || (this.oi.getVisibility() != 0))
    {
      AppMethodBeat.o(240221);
      return false;
    }
    boolean bool = this.il;
    AppMethodBeat.o(240221);
    return bool;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(240228);
    if ((this.il) && (!this.oo))
    {
      if (this.oq <= this.oi.getHeight())
      {
        cH();
        postDelayed(this.oE, 600L);
        AppMethodBeat.o(240228);
        return;
      }
      cH();
      postDelayed(this.oF, 600L);
    }
    AppMethodBeat.o(240228);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(240206);
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    cG();
    int k = this.or;
    this.or = paramInt;
    int i;
    int j;
    if ((paramInt & 0x4) == 0)
    {
      i = 1;
      if ((paramInt & 0x100) == 0) {
        break label132;
      }
      j = 1;
      label55:
      if (this.oA != null)
      {
        a locala = this.oA;
        if (j != 0) {
          break label137;
        }
        label72:
        locala.z(bool);
        if ((i == 0) && (j != 0)) {
          break label143;
        }
        this.oA.bi();
      }
    }
    for (;;)
    {
      if ((((k ^ paramInt) & 0x100) != 0) && (this.oA != null)) {
        w.Y(this);
      }
      AppMethodBeat.o(240206);
      return;
      i = 0;
      break;
      label132:
      j = 0;
      break label55;
      label137:
      bool = false;
      break label72;
      label143:
      this.oA.bk();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(240207);
    super.onWindowVisibilityChanged(paramInt);
    this.og = paramInt;
    if (this.oA != null) {
      this.oA.onWindowVisibilityChanged(paramInt);
    }
    AppMethodBeat.o(240207);
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    AppMethodBeat.i(240251);
    cH();
    paramInt = Math.max(0, Math.min(paramInt, this.oi.getHeight()));
    this.oi.setTranslationY(-paramInt);
    AppMethodBeat.o(240251);
  }
  
  public void setActionBarVisibilityCallback(a parama)
  {
    AppMethodBeat.i(240192);
    this.oA = parama;
    if (getWindowToken() != null)
    {
      this.oA.onWindowVisibilityChanged(this.og);
      if (this.or != 0)
      {
        onWindowSystemUiVisibilityChanged(this.or);
        w.Y(this);
      }
    }
    AppMethodBeat.o(240192);
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.om = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(240247);
    if (paramBoolean != this.il)
    {
      this.il = paramBoolean;
      if (!paramBoolean)
      {
        cH();
        setActionBarHideOffset(0);
      }
    }
    AppMethodBeat.o(240247);
  }
  
  public void setIcon(int paramInt)
  {
    AppMethodBeat.i(240267);
    cG();
    this.ht.setIcon(paramInt);
    AppMethodBeat.o(240267);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(240268);
    cG();
    this.ht.setIcon(paramDrawable);
    AppMethodBeat.o(240268);
  }
  
  public void setLogo(int paramInt)
  {
    AppMethodBeat.i(240270);
    cG();
    this.ht.setLogo(paramInt);
    AppMethodBeat.o(240270);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    AppMethodBeat.i(240196);
    this.ol = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.ok = paramBoolean;
      AppMethodBeat.o(240196);
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    AppMethodBeat.i(240255);
    cG();
    this.ht.setWindowCallback(paramCallback);
    AppMethodBeat.o(240255);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(240257);
    cG();
    this.ht.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(240257);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
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
    public abstract void bi();
    
    public abstract void bk();
    
    public abstract void bl();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
    
    public abstract void z(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */