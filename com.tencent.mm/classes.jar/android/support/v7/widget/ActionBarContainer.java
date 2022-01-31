package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.t;
import android.support.v7.a.a.a;
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
  Drawable VW;
  private View XA;
  Drawable XB;
  Drawable XC;
  boolean XD;
  boolean XE;
  private boolean Xx;
  private View Xy;
  private View Xz;
  private int mHeight;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    t.a(this, new b(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActionBar);
    this.VW = paramContext.getDrawable(10);
    this.XB = paramContext.getDrawable(11);
    this.mHeight = paramContext.getDimensionPixelSize(0, -1);
    if (getId() == 2131820668)
    {
      this.XD = true;
      this.XC = paramContext.getDrawable(12);
    }
    paramContext.recycle();
    if (this.XD) {
      if (this.XC != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      bool = false;
      continue;
      if ((this.VW != null) || (this.XB != null)) {
        bool = false;
      }
    }
  }
  
  private static boolean aW(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
  }
  
  private static int aX(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.VW != null) && (this.VW.isStateful())) {
      this.VW.setState(getDrawableState());
    }
    if ((this.XB != null) && (this.XB.isStateful())) {
      this.XB.setState(getDrawableState());
    }
    if ((this.XC != null) && (this.XC.isStateful())) {
      this.XC.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.Xy;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.VW != null) {
      this.VW.jumpToCurrentState();
    }
    if (this.XB != null) {
      this.XB.jumpToCurrentState();
    }
    if (this.XC != null) {
      this.XC.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.Xz = findViewById(2131820957);
    this.XA = findViewById(2131820958);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.Xx) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.Xy;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      paramBoolean = true;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        paramInt2 = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, paramInt2 - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, paramInt2 - localLayoutParams.bottomMargin);
      }
      if (!this.XD) {
        break label143;
      }
      if (this.XC == null) {
        break label323;
      }
      this.XC.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
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
      if (this.VW != null) {
        if (this.Xz.getVisibility() == 0) {
          this.VW.setBounds(this.Xz.getLeft(), this.Xz.getTop(), this.Xz.getRight(), this.Xz.getBottom());
        }
      }
      label195:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        this.XE = paramBoolean;
        if ((paramBoolean) && (this.XB != null))
        {
          this.XB.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = i;
          break;
          if ((this.XA != null) && (this.XA.getVisibility() == 0))
          {
            this.VW.setBounds(this.XA.getLeft(), this.XA.getTop(), this.XA.getRight(), this.XA.getBottom());
            break label195;
          }
          this.VW.setBounds(0, 0, 0, 0);
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
    if (this.Xz == null)
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
    if (this.Xz == null) {}
    do
    {
      return;
      paramInt2 = View.MeasureSpec.getMode(i);
    } while ((this.Xy == null) || (this.Xy.getVisibility() == 8) || (paramInt2 == 1073741824));
    if (!aW(this.Xz))
    {
      paramInt1 = aX(this.Xz);
      if (paramInt2 != -2147483648) {
        break label167;
      }
    }
    label167:
    for (paramInt2 = View.MeasureSpec.getSize(i);; paramInt2 = 2147483647)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + aX(this.Xy), paramInt2));
      return;
      if (!aW(this.XA))
      {
        paramInt1 = aX(this.XA);
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
    if (this.VW != null)
    {
      this.VW.setCallback(null);
      unscheduleDrawable(this.VW);
    }
    this.VW = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.Xz != null) {
        this.VW.setBounds(this.Xz.getLeft(), this.Xz.getTop(), this.Xz.getRight(), this.Xz.getBottom());
      }
    }
    if (this.XD) {
      if (this.XC != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.VW != null) || (this.XB != null)) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.XC != null)
    {
      this.XC.setCallback(null);
      unscheduleDrawable(this.XC);
    }
    this.XC = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.XD) && (this.XC != null)) {
        this.XC.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
    }
    if (this.XD) {
      if (this.XC != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.VW != null) || (this.XB != null)) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.XB != null)
    {
      this.XB.setCallback(null);
      unscheduleDrawable(this.XB);
    }
    this.XB = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.XE) && (this.XB != null)) {
        this.XB.setBounds(this.Xy.getLeft(), this.Xy.getTop(), this.Xy.getRight(), this.Xy.getBottom());
      }
    }
    if (this.XD) {
      if (this.XC != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.VW != null) || (this.XB != null)) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(ar paramar)
  {
    if (this.Xy != null) {
      removeView(this.Xy);
    }
    this.Xy = paramar;
    if (paramar != null)
    {
      addView(paramar);
      ViewGroup.LayoutParams localLayoutParams = paramar.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramar.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    this.Xx = paramBoolean;
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
      if (this.VW != null) {
        this.VW.setVisible(bool, false);
      }
      if (this.XB != null) {
        this.XB.setVisible(bool, false);
      }
      if (this.XC != null) {
        this.XC.setVisible(bool, false);
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
    return ((paramDrawable == this.VW) && (!this.XD)) || ((paramDrawable == this.XB) && (this.XE)) || ((paramDrawable == this.XC) && (this.XD)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */