package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.a.a;
import android.support.v4.content.b;
import android.support.v4.e.i;
import android.support.v4.view.ab;
import android.support.v4.view.p;
import android.support.v4.view.t;
import android.support.v4.widget.u;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  ab fu;
  private boolean hM = true;
  private int hN;
  private Toolbar hO;
  private View hP;
  private View hQ;
  private int hR;
  private int hS;
  private int hT;
  private int hU;
  private final Rect hV = new Rect();
  final f hW;
  private boolean hX;
  private boolean hY;
  private Drawable hZ;
  Drawable ia;
  private int ib;
  private boolean ic;
  private ValueAnimator ie;
  private long jdField_if;
  private int ig = -1;
  private AppBarLayout.a ih;
  int ii;
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    n.F(paramContext);
    this.hW = new f(this);
    this.hW.b(a.fn);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CollapsingToolbarLayout, paramInt, 2131493837);
    this.hW.y(paramContext.getInt(14, 8388691));
    this.hW.z(paramContext.getInt(13, 8388627));
    paramInt = paramContext.getDimensionPixelSize(1, 0);
    this.hU = paramInt;
    this.hT = paramInt;
    this.hS = paramInt;
    this.hR = paramInt;
    if (paramContext.hasValue(2)) {
      this.hR = paramContext.getDimensionPixelSize(2, 0);
    }
    if (paramContext.hasValue(4)) {
      this.hT = paramContext.getDimensionPixelSize(4, 0);
    }
    if (paramContext.hasValue(3)) {
      this.hS = paramContext.getDimensionPixelSize(3, 0);
    }
    if (paramContext.hasValue(5)) {
      this.hU = paramContext.getDimensionPixelSize(5, 0);
    }
    this.hX = paramContext.getBoolean(15, true);
    setTitle(paramContext.getText(0));
    this.hW.B(2131493652);
    this.hW.A(2131493634);
    if (paramContext.hasValue(6)) {
      this.hW.B(paramContext.getResourceId(6, 0));
    }
    if (paramContext.hasValue(7)) {
      this.hW.A(paramContext.getResourceId(7, 0));
    }
    this.ig = paramContext.getDimensionPixelSize(11, -1);
    this.jdField_if = paramContext.getInt(12, 600);
    setContentScrim(paramContext.getDrawable(8));
    setStatusBarScrim(paramContext.getDrawable(9));
    this.hN = paramContext.getResourceId(10, -1);
    paramContext.recycle();
    setWillNotDraw(false);
    t.a(this, new p()
    {
      public final ab a(View paramAnonymousView, ab paramAnonymousab)
      {
        CollapsingToolbarLayout localCollapsingToolbarLayout = CollapsingToolbarLayout.this;
        paramAnonymousView = null;
        if (t.al(localCollapsingToolbarLayout)) {
          paramAnonymousView = paramAnonymousab;
        }
        if (!i.equals(localCollapsingToolbarLayout.fu, paramAnonymousView))
        {
          localCollapsingToolbarLayout.fu = paramAnonymousView;
          localCollapsingToolbarLayout.requestLayout();
        }
        return paramAnonymousab.dK();
      }
    });
  }
  
  private void bj()
  {
    if (!this.hM) {
      return;
    }
    this.hO = null;
    this.hP = null;
    if (this.hN != -1)
    {
      this.hO = ((Toolbar)findViewById(this.hN));
      if (this.hO != null) {
        this.hP = j(this.hO);
      }
    }
    int i;
    if (this.hO == null)
    {
      int j = getChildCount();
      i = 0;
      if (i >= j) {
        break label119;
      }
      localObject = getChildAt(i);
      if (!(localObject instanceof Toolbar)) {
        break label112;
      }
    }
    label112:
    label119:
    for (Object localObject = (Toolbar)localObject;; localObject = null)
    {
      this.hO = ((Toolbar)localObject);
      bk();
      this.hM = false;
      return;
      i += 1;
      break;
    }
  }
  
  private void bk()
  {
    if ((!this.hX) && (this.hQ != null))
    {
      ViewParent localViewParent = this.hQ.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.hQ);
      }
    }
    if ((this.hX) && (this.hO != null))
    {
      if (this.hQ == null) {
        this.hQ = new View(getContext());
      }
      if (this.hQ.getParent() == null) {
        this.hO.addView(this.hQ, -1, -1);
      }
    }
  }
  
  private View j(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != this) && (paramView != null); paramView = paramView.getParent()) {
      if ((paramView instanceof View)) {
        localView = (View)paramView;
      }
    }
    return localView;
  }
  
  private static int k(View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      int i = paramView.getHeight();
      int j = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
      return ((ViewGroup.MarginLayoutParams)localObject).bottomMargin + (i + j);
    }
    return paramView.getHeight();
  }
  
  static o l(View paramView)
  {
    o localo2 = (o)paramView.getTag(2131820688);
    o localo1 = localo2;
    if (localo2 == null)
    {
      localo1 = new o(paramView);
      paramView.setTag(2131820688, localo1);
    }
    return localo1;
  }
  
  final void bl()
  {
    if ((this.hZ != null) || (this.ia != null)) {
      if (getHeight() + this.ii >= getScrimVisibleHeightTrigger()) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      setScrimsShown(bool);
      return;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof CollapsingToolbarLayout.LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    bj();
    if ((this.hO == null) && (this.hZ != null) && (this.ib > 0))
    {
      this.hZ.mutate().setAlpha(this.ib);
      this.hZ.draw(paramCanvas);
    }
    if ((this.hX) && (this.hY)) {
      this.hW.draw(paramCanvas);
    }
    if ((this.ia != null) && (this.ib > 0)) {
      if (this.fu == null) {
        break label153;
      }
    }
    label153:
    for (int i = this.fu.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.ia.setBounds(0, -this.ii, getWidth(), i - this.ii);
        this.ia.mutate().setAlpha(this.ib);
        this.ia.draw(paramCanvas);
      }
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = false;
    if ((this.hZ != null) && (this.ib > 0)) {
      if ((this.hP == null) || (this.hP == this)) {
        if (paramView == this.hO)
        {
          i = 1;
          if (i == 0) {
            break label120;
          }
          this.hZ.mutate().setAlpha(this.ib);
          this.hZ.draw(paramCanvas);
        }
      }
    }
    label120:
    for (int i = 1;; i = 0)
    {
      if ((super.drawChild(paramCanvas, paramView, paramLong)) || (i != 0)) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
      if (paramView == this.hP)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.ia;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.hZ;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    bool1 = bool2;
    if (this.hW != null) {
      bool1 = bool2 | this.hW.setState(arrayOfInt);
    }
    if (bool1) {
      invalidate();
    }
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new CollapsingToolbarLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getCollapsedTitleGravity()
  {
    return this.hW.he;
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    return this.hW.ba();
  }
  
  public Drawable getContentScrim()
  {
    return this.hZ;
  }
  
  public int getExpandedTitleGravity()
  {
    return this.hW.hd;
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return this.hU;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return this.hT;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return this.hR;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return this.hS;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    f localf = this.hW;
    if (localf.hq != null) {
      return localf.hq;
    }
    return Typeface.DEFAULT;
  }
  
  int getScrimAlpha()
  {
    return this.ib;
  }
  
  public long getScrimAnimationDuration()
  {
    return this.jdField_if;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    if (this.ig >= 0) {
      return this.ig;
    }
    if (this.fu != null) {}
    for (int i = this.fu.getSystemWindowInsetTop();; i = 0)
    {
      int j = t.aa(this);
      if (j <= 0) {
        break;
      }
      return Math.min(i + j * 2, getHeight());
    }
    return getHeight() / 3;
  }
  
  public Drawable getStatusBarScrim()
  {
    return this.ia;
  }
  
  public CharSequence getTitle()
  {
    if (this.hX) {
      return this.hW.mText;
    }
    return null;
  }
  
  final int m(View paramView)
  {
    o localo = l(paramView);
    CollapsingToolbarLayout.LayoutParams localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramView.getLayoutParams();
    return getHeight() - localo.nd - paramView.getHeight() - localLayoutParams.bottomMargin;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if ((localObject instanceof AppBarLayout))
    {
      t.e(this, t.al((View)localObject));
      if (this.ih == null) {
        this.ih = new CollapsingToolbarLayout.a(this);
      }
      localObject = (AppBarLayout)localObject;
      AppBarLayout.a locala = this.ih;
      if (((AppBarLayout)localObject).fv == null) {
        ((AppBarLayout)localObject).fv = new ArrayList();
      }
      if ((locala != null) && (!((AppBarLayout)localObject).fv.contains(locala))) {
        ((AppBarLayout)localObject).fv.add(locala);
      }
      t.ak(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = getParent();
    if ((this.ih != null) && ((localObject instanceof AppBarLayout)))
    {
      localObject = (AppBarLayout)localObject;
      AppBarLayout.a locala = this.ih;
      if ((((AppBarLayout)localObject).fv != null) && (locala != null)) {
        ((AppBarLayout)localObject).fv.remove(locala);
      }
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    int m = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int k;
    int n;
    Object localObject;
    if (this.fu != null)
    {
      k = this.fu.getSystemWindowInsetTop();
      n = getChildCount();
      i = 0;
      while (i < n)
      {
        localObject = getChildAt(i);
        if ((!t.al((View)localObject)) && (((View)localObject).getTop() < k)) {
          t.q((View)localObject, k);
        }
        i += 1;
      }
    }
    if ((this.hX) && (this.hQ != null))
    {
      if ((!t.aw(this.hQ)) || (this.hQ.getVisibility() != 0)) {
        break label404;
      }
      paramBoolean = true;
      this.hY = paramBoolean;
      if (this.hY)
      {
        if (t.T(this) != 1) {
          break label409;
        }
        i = j;
        label151:
        if (this.hP == null) {
          break label415;
        }
        localObject = this.hP;
        label164:
        n = m((View)localObject);
        u.a(this, this.hQ, this.hV);
        localObject = this.hW;
        int i1 = this.hV.left;
        if (i == 0) {
          break label424;
        }
        j = this.hO.getTitleMarginEnd();
        label213:
        int i2 = this.hV.top;
        int i3 = this.hO.getTitleMarginTop();
        int i4 = this.hV.right;
        if (i == 0) {
          break label436;
        }
        k = this.hO.getTitleMarginStart();
        label254:
        ((f)localObject).d(i1 + j, i3 + (i2 + n), k + i4, n + this.hV.bottom - this.hO.getTitleMarginBottom());
        localObject = this.hW;
        if (i == 0) {
          break label448;
        }
        j = this.hT;
        label312:
        k = this.hV.top;
        n = this.hS;
        if (i == 0) {
          break label457;
        }
      }
    }
    label404:
    label409:
    label415:
    label424:
    label436:
    label448:
    label457:
    for (int i = this.hR;; i = this.hT)
    {
      ((f)localObject).c(j, k + n, paramInt3 - paramInt1 - i, paramInt4 - paramInt2 - this.hU);
      this.hW.bh();
      paramInt2 = getChildCount();
      paramInt1 = m;
      while (paramInt1 < paramInt2)
      {
        l(getChildAt(paramInt1)).bS();
        paramInt1 += 1;
      }
      paramBoolean = false;
      break;
      i = 0;
      break label151;
      localObject = this.hO;
      break label164;
      j = this.hO.getTitleMarginStart();
      break label213;
      k = this.hO.getTitleMarginEnd();
      break label254;
      j = this.hR;
      break label312;
    }
    if (this.hO != null)
    {
      if ((this.hX) && (TextUtils.isEmpty(this.hW.mText))) {
        this.hW.setText(this.hO.getTitle());
      }
      if ((this.hP != null) && (this.hP != this)) {
        break label538;
      }
      setMinimumHeight(k(this.hO));
    }
    for (;;)
    {
      bl();
      return;
      label538:
      setMinimumHeight(k(this.hP));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    bj();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if (this.fu != null) {}
    for (paramInt2 = this.fu.getSystemWindowInsetTop();; paramInt2 = 0)
    {
      if ((i == 0) && (paramInt2 > 0)) {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2 + getMeasuredHeight(), 1073741824));
      }
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.hZ != null) {
      this.hZ.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    this.hW.z(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    this.hW.A(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.hW.b(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    f localf = this.hW;
    if (f.a(localf.hp, paramTypeface))
    {
      localf.hp = paramTypeface;
      localf.bh();
    }
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.hZ != paramDrawable)
    {
      if (this.hZ != null) {
        this.hZ.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.hZ = localDrawable;
      if (this.hZ != null)
      {
        this.hZ.setBounds(0, 0, getWidth(), getHeight());
        this.hZ.setCallback(this);
        this.hZ.setAlpha(this.ib);
      }
      t.R(this);
    }
  }
  
  public void setContentScrimColor(int paramInt)
  {
    setContentScrim(new ColorDrawable(paramInt));
  }
  
  public void setContentScrimResource(int paramInt)
  {
    setContentScrim(b.k(getContext(), paramInt));
  }
  
  public void setExpandedTitleColor(int paramInt)
  {
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setExpandedTitleGravity(int paramInt)
  {
    this.hW.y(paramInt);
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    this.hU = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    this.hT = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    this.hR = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    this.hS = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    this.hW.B(paramInt);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.hW.c(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    f localf = this.hW;
    if (f.a(localf.hq, paramTypeface))
    {
      localf.hq = paramTypeface;
      localf.bh();
    }
  }
  
  void setScrimAlpha(int paramInt)
  {
    if (paramInt != this.ib)
    {
      if ((this.hZ != null) && (this.hO != null)) {
        t.R(this.hO);
      }
      this.ib = paramInt;
      t.R(this);
    }
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    this.jdField_if = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    if (this.ig != paramInt)
    {
      this.ig = paramInt;
      bl();
    }
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    int j = 255;
    label40:
    Interpolator localInterpolator;
    if ((t.as(this)) && (!isInEditMode()))
    {
      i = 1;
      if (this.ic != paramBoolean)
      {
        if (i == 0) {
          break label187;
        }
        if (!paramBoolean) {
          break label154;
        }
        i = 255;
        bj();
        if (this.ie != null) {
          break label167;
        }
        this.ie = new ValueAnimator();
        this.ie.setDuration(this.jdField_if);
        ValueAnimator localValueAnimator = this.ie;
        if (i <= this.ib) {
          break label159;
        }
        localInterpolator = a.fk;
        label93:
        localValueAnimator.setInterpolator(localInterpolator);
        this.ie.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        });
      }
    }
    for (;;)
    {
      this.ie.setIntValues(new int[] { this.ib, i });
      this.ie.start();
      this.ic = paramBoolean;
      return;
      i = 0;
      break;
      label154:
      i = 0;
      break label40;
      label159:
      localInterpolator = a.fl;
      break label93;
      label167:
      if (this.ie.isRunning()) {
        this.ie.cancel();
      }
    }
    label187:
    if (paramBoolean) {}
    for (int i = j;; i = 0)
    {
      setScrimAlpha(i);
      break;
    }
  }
  
  public void setStatusBarScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.ia != paramDrawable)
    {
      if (this.ia != null) {
        this.ia.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.ia = localDrawable;
      if (this.ia != null)
      {
        if (this.ia.isStateful()) {
          this.ia.setState(getDrawableState());
        }
        android.support.v4.graphics.drawable.a.b(this.ia, t.T(this));
        paramDrawable = this.ia;
        if (getVisibility() != 0) {
          break label125;
        }
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.ia.setCallback(this);
      this.ia.setAlpha(this.ib);
      t.R(this);
      return;
    }
  }
  
  public void setStatusBarScrimColor(int paramInt)
  {
    setStatusBarScrim(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarScrimResource(int paramInt)
  {
    setStatusBarScrim(b.k(getContext(), paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.hW.setText(paramCharSequence);
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.hX)
    {
      this.hX = paramBoolean;
      bk();
      requestLayout();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.ia != null) && (this.ia.isVisible() != bool)) {
        this.ia.setVisible(bool, false);
      }
      if ((this.hZ != null) && (this.hZ.isVisible() != bool)) {
        this.hZ.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.hZ) || (paramDrawable == this.ia);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout
 * JD-Core Version:    0.7.0.1
 */