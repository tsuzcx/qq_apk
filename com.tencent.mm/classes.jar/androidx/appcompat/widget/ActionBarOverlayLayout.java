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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements m, o
{
  static final int[] pD = { a.a.actionBarSize, 16842841 };
  private n iq;
  private boolean ji;
  private int mActionBarHeight;
  final AnimatorListenerAdapter pA;
  private final Runnable pB;
  private final Runnable pC;
  private final r pE;
  private int pg;
  private ContentFrameLayout ph;
  ActionBarContainer pi;
  private Drawable pj;
  private boolean pk;
  public boolean pl;
  private boolean pm;
  boolean pn;
  private int po;
  private int pp;
  private final Rect pq;
  private final Rect pr;
  private final Rect ps;
  private final Rect pt;
  private final Rect pu;
  private final Rect pv;
  private final Rect pw;
  private a px;
  private OverScroller py;
  ViewPropertyAnimator pz;
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200309);
    this.pg = 0;
    this.pq = new Rect();
    this.pr = new Rect();
    this.ps = new Rect();
    this.pt = new Rect();
    this.pu = new Rect();
    this.pv = new Rect();
    this.pw = new Rect();
    this.pA = new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        ActionBarOverlayLayout.this.pz = null;
        ActionBarOverlayLayout.this.pn = false;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ActionBarOverlayLayout.this.pz = null;
        ActionBarOverlayLayout.this.pn = false;
      }
    };
    this.pB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199359);
        ActionBarOverlayLayout.this.dA();
        ActionBarOverlayLayout.this.pz = ActionBarOverlayLayout.this.pi.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.pA);
        AppMethodBeat.o(199359);
      }
    };
    this.pC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199358);
        ActionBarOverlayLayout.this.dA();
        ActionBarOverlayLayout.this.pz = ActionBarOverlayLayout.this.pi.animate().translationY(-ActionBarOverlayLayout.this.pi.getHeight()).setListener(ActionBarOverlayLayout.this.pA);
        AppMethodBeat.o(199358);
      }
    };
    init(paramContext);
    this.pE = new r();
    AppMethodBeat.o(200309);
  }
  
  private static boolean c(View paramView, Rect paramRect, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(200320);
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
      AppMethodBeat.o(200320);
      return paramBoolean;
    }
  }
  
  private void dz()
  {
    AppMethodBeat.i(200324);
    if (this.ph == null)
    {
      this.ph = ((ContentFrameLayout)findViewById(a.f.action_bar_activity_content));
      this.pi = ((ActionBarContainer)findViewById(a.f.action_bar_container));
      this.iq = h(findViewById(a.f.action_bar));
    }
    AppMethodBeat.o(200324);
  }
  
  private static n h(View paramView)
  {
    AppMethodBeat.i(200331);
    if ((paramView instanceof n))
    {
      paramView = (n)paramView;
      AppMethodBeat.o(200331);
      return paramView;
    }
    if ((paramView instanceof Toolbar))
    {
      paramView = ((Toolbar)paramView).getWrapper();
      AppMethodBeat.o(200331);
      return paramView;
    }
    paramView = new IllegalStateException("Can't make a decor toolbar out of " + paramView.getClass().getSimpleName());
    AppMethodBeat.o(200331);
    throw paramView;
  }
  
  private void init(Context paramContext)
  {
    boolean bool2 = true;
    AppMethodBeat.i(200315);
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(pD);
    this.mActionBarHeight = localTypedArray.getDimensionPixelSize(0, 0);
    this.pj = localTypedArray.getDrawable(1);
    if (this.pj == null)
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
      this.pk = bool1;
      this.py = new OverScroller(paramContext);
      AppMethodBeat.o(200315);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    AppMethodBeat.i(200709);
    dz();
    this.iq.a(paramMenu, parama);
    AppMethodBeat.o(200709);
  }
  
  public final void aj(int paramInt)
  {
    AppMethodBeat.i(200612);
    dz();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200612);
      return;
      AppMethodBeat.o(200612);
      return;
      AppMethodBeat.o(200612);
      return;
      setOverlayMode(true);
    }
  }
  
  public final void bO()
  {
    AppMethodBeat.i(200722);
    dz();
    this.iq.dN();
    AppMethodBeat.o(200722);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  final void dA()
  {
    AppMethodBeat.i(200577);
    removeCallbacks(this.pB);
    removeCallbacks(this.pC);
    if (this.pz != null) {
      this.pz.cancel();
    }
    AppMethodBeat.o(200577);
  }
  
  public final boolean dB()
  {
    AppMethodBeat.i(200650);
    dz();
    boolean bool = this.iq.dB();
    AppMethodBeat.o(200650);
    return bool;
  }
  
  public final boolean dC()
  {
    AppMethodBeat.i(200658);
    dz();
    boolean bool = this.iq.dC();
    AppMethodBeat.o(200658);
    return bool;
  }
  
  public final boolean dD()
  {
    AppMethodBeat.i(200667);
    dz();
    boolean bool = this.iq.dD();
    AppMethodBeat.o(200667);
    return bool;
  }
  
  public final boolean dE()
  {
    AppMethodBeat.i(200687);
    dz();
    boolean bool = this.iq.dE();
    AppMethodBeat.o(200687);
    return bool;
  }
  
  public final void dF()
  {
    AppMethodBeat.i(200698);
    dz();
    this.iq.dF();
    AppMethodBeat.o(200698);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200458);
    super.draw(paramCanvas);
    if ((this.pj != null) && (!this.pk)) {
      if (this.pi.getVisibility() != 0) {
        break label94;
      }
    }
    label94:
    for (int i = (int)(this.pi.getBottom() + this.pi.getTranslationY() + 0.5F);; i = 0)
    {
      this.pj.setBounds(0, i, getWidth(), this.pj.getIntrinsicHeight() + i);
      this.pj.draw(paramCanvas);
      AppMethodBeat.o(200458);
      return;
    }
  }
  
  public final boolean dv()
  {
    AppMethodBeat.i(200676);
    dz();
    boolean bool = this.iq.dv();
    AppMethodBeat.o(200676);
    return bool;
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(200412);
    dz();
    z.aj(this);
    boolean bool = c(this.pi, paramRect, false);
    this.pt.set(paramRect);
    ai.a(this, this.pt, this.pq);
    if (!this.pu.equals(this.pt))
    {
      this.pu.set(this.pt);
      bool = true;
    }
    if (!this.pr.equals(this.pq))
    {
      this.pr.set(this.pq);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    AppMethodBeat.o(200412);
    return true;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200418);
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(200418);
    return paramLayoutParams;
  }
  
  public int getActionBarHideOffset()
  {
    AppMethodBeat.i(200553);
    if (this.pi != null)
    {
      int i = -(int)this.pi.getTranslationY();
      AppMethodBeat.o(200553);
      return i;
    }
    AppMethodBeat.o(200553);
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    AppMethodBeat.i(200538);
    int i = this.pE.getNestedScrollAxes();
    AppMethodBeat.o(200538);
    return i;
  }
  
  public CharSequence getTitle()
  {
    AppMethodBeat.i(200603);
    dz();
    CharSequence localCharSequence = this.iq.getTitle();
    AppMethodBeat.o(200603);
    return localCharSequence;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200384);
    super.onConfigurationChanged(paramConfiguration);
    init(getContext());
    z.ak(this);
    AppMethodBeat.o(200384);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(200346);
    super.onDetachedFromWindow();
    dA();
    AppMethodBeat.o(200346);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200449);
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
    AppMethodBeat.o(200449);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200441);
    dz();
    measureChildWithMargins(this.pi, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.pi.getLayoutParams();
    int i1 = Math.max(0, this.pi.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i = this.pi.getMeasuredHeight();
    int j = ((LayoutParams)localObject).topMargin;
    int n = Math.max(0, ((LayoutParams)localObject).bottomMargin + (i + j));
    int m = View.combineMeasuredStates(0, this.pi.getMeasuredState());
    int k;
    if ((z.aj(this) & 0x100) != 0)
    {
      j = 1;
      if (j == 0) {
        break label456;
      }
      k = this.mActionBarHeight;
      i = k;
      if (this.pm)
      {
        i = k;
        if (this.pi.getTabContainer() != null) {
          i = k + this.mActionBarHeight;
        }
      }
    }
    for (;;)
    {
      label159:
      this.ps.set(this.pq);
      this.pv.set(this.pt);
      if ((!this.pl) && (j == 0))
      {
        localObject = this.ps;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.ps;
      }
      for (((Rect)localObject).bottom += 0;; ((Rect)localObject).bottom += 0)
      {
        c(this.ph, this.ps, true);
        if (!this.pw.equals(this.pv))
        {
          this.pw.set(this.pv);
          this.ph.f(this.pv);
        }
        measureChildWithMargins(this.ph, paramInt1, 0, paramInt2, 0);
        localObject = (LayoutParams)this.ph.getLayoutParams();
        i = Math.max(i1, this.ph.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
        j = this.ph.getMeasuredHeight();
        k = ((LayoutParams)localObject).topMargin;
        j = Math.max(n, ((LayoutParams)localObject).bottomMargin + (j + k));
        k = View.combineMeasuredStates(m, this.ph.getMeasuredState());
        m = getPaddingLeft();
        n = getPaddingRight();
        j = Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
        AppMethodBeat.o(200441);
        return;
        j = 0;
        break;
        label456:
        if (this.pi.getVisibility() == 8) {
          break label518;
        }
        i = this.pi.getMeasuredHeight();
        break label159;
        localObject = this.pv;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.pv;
      }
      label518:
      i = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(200514);
    if ((!this.ji) || (!paramBoolean))
    {
      AppMethodBeat.o(200514);
      return false;
    }
    this.py.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    if (this.py.getFinalY() > this.pi.getHeight()) {
      i = 1;
    }
    if (i != 0)
    {
      dA();
      this.pC.run();
    }
    for (;;)
    {
      this.pn = true;
      AppMethodBeat.o(200514);
      return true;
      dA();
      this.pB.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200491);
    this.po += paramInt2;
    setActionBarHideOffset(this.po);
    AppMethodBeat.o(200491);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(200482);
    this.pE.ep(paramInt);
    this.po = getActionBarHideOffset();
    dA();
    if (this.px != null) {
      this.px.ce();
    }
    AppMethodBeat.o(200482);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(200474);
    if (((paramInt & 0x2) == 0) || (this.pi.getVisibility() != 0))
    {
      AppMethodBeat.o(200474);
      return false;
    }
    boolean bool = this.ji;
    AppMethodBeat.o(200474);
    return bool;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(200502);
    if ((this.ji) && (!this.pn))
    {
      if (this.po <= this.pi.getHeight())
      {
        dA();
        postDelayed(this.pB, 600L);
        AppMethodBeat.o(200502);
        return;
      }
      dA();
      postDelayed(this.pC, 600L);
    }
    AppMethodBeat.o(200502);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(200392);
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    dz();
    int k = this.pp;
    this.pp = paramInt;
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
      if (this.px != null)
      {
        a locala = this.px;
        if (j != 0) {
          break label137;
        }
        label72:
        locala.D(bool);
        if ((i == 0) && (j != 0)) {
          break label143;
        }
        this.px.cb();
      }
    }
    for (;;)
    {
      if ((((k ^ paramInt) & 0x100) != 0) && (this.px != null)) {
        z.ak(this);
      }
      AppMethodBeat.o(200392);
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
      this.px.cd();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(200399);
    super.onWindowVisibilityChanged(paramInt);
    this.pg = paramInt;
    if (this.px != null) {
      this.px.onWindowVisibilityChanged(paramInt);
    }
    AppMethodBeat.o(200399);
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    AppMethodBeat.i(200564);
    dA();
    paramInt = Math.max(0, Math.min(paramInt, this.pi.getHeight()));
    this.pi.setTranslationY(-paramInt);
    AppMethodBeat.o(200564);
  }
  
  public void setActionBarVisibilityCallback(a parama)
  {
    AppMethodBeat.i(200356);
    this.px = parama;
    if (getWindowToken() != null)
    {
      this.px.onWindowVisibilityChanged(this.pg);
      if (this.pp != 0)
      {
        onWindowSystemUiVisibilityChanged(this.pp);
        z.ak(this);
      }
    }
    AppMethodBeat.o(200356);
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.pm = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200547);
    if (paramBoolean != this.ji)
    {
      this.ji = paramBoolean;
      if (!paramBoolean)
      {
        dA();
        setActionBarHideOffset(0);
      }
    }
    AppMethodBeat.o(200547);
  }
  
  public void setIcon(int paramInt)
  {
    AppMethodBeat.i(200629);
    dz();
    this.iq.setIcon(paramInt);
    AppMethodBeat.o(200629);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(200637);
    dz();
    this.iq.setIcon(paramDrawable);
    AppMethodBeat.o(200637);
  }
  
  public void setLogo(int paramInt)
  {
    AppMethodBeat.i(200645);
    dz();
    this.iq.setLogo(paramInt);
    AppMethodBeat.o(200645);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    AppMethodBeat.i(200361);
    this.pl = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.pk = paramBoolean;
      AppMethodBeat.o(200361);
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    AppMethodBeat.i(200587);
    dz();
    this.iq.setWindowCallback(paramCallback);
    AppMethodBeat.o(200587);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200596);
    dz();
    this.iq.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(200596);
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
    public abstract void D(boolean paramBoolean);
    
    public abstract void cb();
    
    public abstract void cd();
    
    public abstract void ce();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */