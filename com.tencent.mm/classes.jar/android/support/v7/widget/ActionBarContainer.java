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
  Drawable adV;
  Drawable afA;
  Drawable afB;
  boolean afC;
  boolean afD;
  private boolean afw;
  private View afx;
  private View afy;
  private View afz;
  private int mHeight;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    t.a(this, new b(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActionBar);
    this.adV = paramContext.getDrawable(0);
    this.afA = paramContext.getDrawable(2);
    this.mHeight = paramContext.getDimensionPixelSize(13, -1);
    if (getId() == 2131305154)
    {
      this.afC = true;
      this.afB = paramContext.getDrawable(1);
    }
    paramContext.recycle();
    if (this.afC) {
      if (this.afB != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      bool = false;
      continue;
      if ((this.adV != null) || (this.afA != null)) {
        bool = false;
      }
    }
  }
  
  private static boolean bc(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
  }
  
  private static int bd(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.adV != null) && (this.adV.isStateful())) {
      this.adV.setState(getDrawableState());
    }
    if ((this.afA != null) && (this.afA.isStateful())) {
      this.afA.setState(getDrawableState());
    }
    if ((this.afB != null) && (this.afB.isStateful())) {
      this.afB.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.afx;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.adV != null) {
      this.adV.jumpToCurrentState();
    }
    if (this.afA != null) {
      this.afA.jumpToCurrentState();
    }
    if (this.afB != null) {
      this.afB.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.afy = findViewById(2131296343);
    this.afz = findViewById(2131296357);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.afw) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.afx;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      paramBoolean = true;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        paramInt2 = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, paramInt2 - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, paramInt2 - localLayoutParams.bottomMargin);
      }
      if (!this.afC) {
        break label143;
      }
      if (this.afB == null) {
        break label323;
      }
      this.afB.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
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
      if (this.adV != null) {
        if (this.afy.getVisibility() == 0) {
          this.adV.setBounds(this.afy.getLeft(), this.afy.getTop(), this.afy.getRight(), this.afy.getBottom());
        }
      }
      label195:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        this.afD = paramBoolean;
        if ((paramBoolean) && (this.afA != null))
        {
          this.afA.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = i;
          break;
          if ((this.afz != null) && (this.afz.getVisibility() == 0))
          {
            this.adV.setBounds(this.afz.getLeft(), this.afz.getTop(), this.afz.getRight(), this.afz.getBottom());
            break label195;
          }
          this.adV.setBounds(0, 0, 0, 0);
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
    if (this.afy == null)
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
    if (this.afy == null) {}
    do
    {
      return;
      paramInt2 = View.MeasureSpec.getMode(i);
    } while ((this.afx == null) || (this.afx.getVisibility() == 8) || (paramInt2 == 1073741824));
    if (!bc(this.afy))
    {
      paramInt1 = bd(this.afy);
      if (paramInt2 != -2147483648) {
        break label167;
      }
    }
    label167:
    for (paramInt2 = View.MeasureSpec.getSize(i);; paramInt2 = 2147483647)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + bd(this.afx), paramInt2));
      return;
      if (!bc(this.afz))
      {
        paramInt1 = bd(this.afz);
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
    if (this.adV != null)
    {
      this.adV.setCallback(null);
      unscheduleDrawable(this.adV);
    }
    this.adV = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.afy != null) {
        this.adV.setBounds(this.afy.getLeft(), this.afy.getTop(), this.afy.getRight(), this.afy.getBottom());
      }
    }
    if (this.afC) {
      if (this.afB != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.adV != null) || (this.afA != null)) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.afB != null)
    {
      this.afB.setCallback(null);
      unscheduleDrawable(this.afB);
    }
    this.afB = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.afC) && (this.afB != null)) {
        this.afB.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
    }
    if (this.afC) {
      if (this.afB != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.adV != null) || (this.afA != null)) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.afA != null)
    {
      this.afA.setCallback(null);
      unscheduleDrawable(this.afA);
    }
    this.afA = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.afD) && (this.afA != null)) {
        this.afA.setBounds(this.afx.getLeft(), this.afx.getTop(), this.afx.getRight(), this.afx.getBottom());
      }
    }
    if (this.afC) {
      if (this.afB != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.adV != null) || (this.afA != null)) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(ar paramar)
  {
    if (this.afx != null) {
      removeView(this.afx);
    }
    this.afx = paramar;
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
    this.afw = paramBoolean;
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
      if (this.adV != null) {
        this.adV.setVisible(bool, false);
      }
      if (this.afA != null) {
        this.afA.setVisible(bool, false);
      }
      if (this.afB != null) {
        this.afB.setVisible(bool, false);
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
    return ((paramDrawable == this.adV) && (!this.afC)) || ((paramDrawable == this.afA) && (this.afD)) || ((paramDrawable == this.afB) && (this.afC)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */