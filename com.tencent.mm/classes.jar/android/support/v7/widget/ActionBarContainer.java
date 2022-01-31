package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.support.v7.a.a.f;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer
  extends FrameLayout
{
  Drawable Vh;
  private boolean WK;
  private View WL;
  private View WM;
  private View WN;
  Drawable WO;
  Drawable WP;
  boolean WQ;
  boolean WR;
  private int mHeight;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = new c(this);
      q.a(this, (Drawable)localObject);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActionBar);
      this.Vh = paramContext.getDrawable(a.j.ActionBar_background);
      this.WO = paramContext.getDrawable(a.j.ActionBar_backgroundStacked);
      this.mHeight = paramContext.getDimensionPixelSize(a.j.ActionBar_height, -1);
      if (getId() == a.f.split_action_bar)
      {
        this.WQ = true;
        this.WP = paramContext.getDrawable(a.j.ActionBar_backgroundSplit);
      }
      paramContext.recycle();
      if (!this.WQ) {
        break label143;
      }
      if (this.WP != null) {
        break label138;
      }
      bool = true;
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      localObject = new b(this);
      break;
      label138:
      bool = false;
      continue;
      label143:
      if ((this.Vh == null) && (this.WO == null)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private static boolean aO(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
  }
  
  private static int aP(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.Vh != null) && (this.Vh.isStateful())) {
      this.Vh.setState(getDrawableState());
    }
    if ((this.WO != null) && (this.WO.isStateful())) {
      this.WO.setState(getDrawableState());
    }
    if ((this.WP != null) && (this.WP.isStateful())) {
      this.WP.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.WL;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.Vh != null) {
      this.Vh.jumpToCurrentState();
    }
    if (this.WO != null) {
      this.WO.jumpToCurrentState();
    }
    if (this.WP != null) {
      this.WP.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.WM = findViewById(a.f.action_bar);
    this.WN = findViewById(a.f.action_context_bar);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.WK) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.WL;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      paramBoolean = true;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        paramInt2 = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, paramInt2 - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, paramInt2 - localLayoutParams.bottomMargin);
      }
      if (!this.WQ) {
        break label143;
      }
      if (this.WP == null) {
        break label323;
      }
      this.WP.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        invalidate();
      }
      return;
      paramBoolean = false;
      break;
      label143:
      if (this.Vh != null) {
        if (this.WM.getVisibility() == 0) {
          this.Vh.setBounds(this.WM.getLeft(), this.WM.getTop(), this.WM.getRight(), this.WM.getBottom());
        }
      }
      label195:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        this.WR = paramBoolean;
        if ((paramBoolean) && (this.WO != null))
        {
          this.WO.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = i;
          break;
          if ((this.WN != null) && (this.WN.getVisibility() == 0))
          {
            this.Vh.setBounds(this.WN.getLeft(), this.WN.getTop(), this.WN.getRight(), this.WN.getBottom());
            break label195;
          }
          this.Vh.setBounds(0, 0, 0, 0);
          break label195;
        }
        break;
      }
      label323:
      paramInt1 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.WM == null)
    {
      i = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == -2147483648)
      {
        i = paramInt2;
        if (this.mHeight >= 0) {
          i = View.MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, View.MeasureSpec.getSize(paramInt2)), -2147483648);
        }
      }
    }
    super.onMeasure(paramInt1, i);
    if (this.WM == null) {}
    do
    {
      return;
      paramInt2 = View.MeasureSpec.getMode(i);
    } while ((this.WL == null) || (this.WL.getVisibility() == 8) || (paramInt2 == 1073741824));
    if (!aO(this.WM))
    {
      paramInt1 = aP(this.WM);
      if (paramInt2 != -2147483648) {
        break label167;
      }
    }
    label167:
    for (paramInt2 = View.MeasureSpec.getSize(i);; paramInt2 = 2147483647)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + aP(this.WL), paramInt2));
      return;
      if (!aO(this.WN))
      {
        paramInt1 = aP(this.WN);
        break;
      }
      paramInt1 = 0;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.Vh != null)
    {
      this.Vh.setCallback(null);
      unscheduleDrawable(this.Vh);
    }
    this.Vh = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.WM != null) {
        this.Vh.setBounds(this.WM.getLeft(), this.WM.getTop(), this.WM.getRight(), this.WM.getBottom());
      }
    }
    if (this.WQ) {
      if (this.WP != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.Vh != null) || (this.WO != null)) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.WP != null)
    {
      this.WP.setCallback(null);
      unscheduleDrawable(this.WP);
    }
    this.WP = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.WQ) && (this.WP != null)) {
        this.WP.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
    }
    if (this.WQ) {
      if (this.WP != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.Vh != null) || (this.WO != null)) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.WO != null)
    {
      this.WO.setCallback(null);
      unscheduleDrawable(this.WO);
    }
    this.WO = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.WR) && (this.WO != null)) {
        this.WO.setBounds(this.WL.getLeft(), this.WL.getTop(), this.WL.getRight(), this.WL.getBottom());
      }
    }
    if (this.WQ) {
      if (this.WP != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.Vh != null) || (this.WO != null)) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(aq paramaq)
  {
    if (this.WL != null) {
      removeView(this.WL);
    }
    this.WL = paramaq;
    if (paramaq != null)
    {
      addView(paramaq);
      ViewGroup.LayoutParams localLayoutParams = paramaq.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramaq.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    this.WK = paramBoolean;
    if (paramBoolean) {}
    for (int i = 393216;; i = 262144)
    {
      setDescendantFocusability(i);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.Vh != null) {
        this.Vh.setVisible(bool, false);
      }
      if (this.WO != null) {
        this.WO.setVisible(bool, false);
      }
      if (this.WP != null) {
        this.WP.setVisible(bool, false);
      }
      return;
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt)
  {
    if (paramInt != 0) {
      return super.startActionModeForChild(paramView, paramCallback, paramInt);
    }
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable == this.Vh) && (!this.WQ)) || ((paramDrawable == this.WO) && (this.WR)) || ((paramDrawable == this.WP) && (this.WQ)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */