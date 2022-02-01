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
  Drawable adb;
  private boolean aeC;
  private View aeD;
  private View aeE;
  private View aeF;
  Drawable aeG;
  Drawable aeH;
  boolean aeI;
  boolean aeJ;
  private int mHeight;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    t.a(this, new b(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActionBar);
    this.adb = paramContext.getDrawable(0);
    this.aeG = paramContext.getDrawable(2);
    this.mHeight = paramContext.getDimensionPixelSize(13, -1);
    if (getId() == 2131305154)
    {
      this.aeI = true;
      this.aeH = paramContext.getDrawable(1);
    }
    paramContext.recycle();
    if (this.aeI) {
      if (this.aeH != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      bool = false;
      continue;
      if ((this.adb != null) || (this.aeG != null)) {
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
    if ((this.adb != null) && (this.adb.isStateful())) {
      this.adb.setState(getDrawableState());
    }
    if ((this.aeG != null) && (this.aeG.isStateful())) {
      this.aeG.setState(getDrawableState());
    }
    if ((this.aeH != null) && (this.aeH.isStateful())) {
      this.aeH.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.aeD;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.adb != null) {
      this.adb.jumpToCurrentState();
    }
    if (this.aeG != null) {
      this.aeG.jumpToCurrentState();
    }
    if (this.aeH != null) {
      this.aeH.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.aeE = findViewById(2131296343);
    this.aeF = findViewById(2131296357);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.aeC) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.aeD;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      paramBoolean = true;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        paramInt2 = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, paramInt2 - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, paramInt2 - localLayoutParams.bottomMargin);
      }
      if (!this.aeI) {
        break label143;
      }
      if (this.aeH == null) {
        break label323;
      }
      this.aeH.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
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
      if (this.adb != null) {
        if (this.aeE.getVisibility() == 0) {
          this.adb.setBounds(this.aeE.getLeft(), this.aeE.getTop(), this.aeE.getRight(), this.aeE.getBottom());
        }
      }
      label195:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        this.aeJ = paramBoolean;
        if ((paramBoolean) && (this.aeG != null))
        {
          this.aeG.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = i;
          break;
          if ((this.aeF != null) && (this.aeF.getVisibility() == 0))
          {
            this.adb.setBounds(this.aeF.getLeft(), this.aeF.getTop(), this.aeF.getRight(), this.aeF.getBottom());
            break label195;
          }
          this.adb.setBounds(0, 0, 0, 0);
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
    if (this.aeE == null)
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
    if (this.aeE == null) {}
    do
    {
      return;
      paramInt2 = View.MeasureSpec.getMode(i);
    } while ((this.aeD == null) || (this.aeD.getVisibility() == 8) || (paramInt2 == 1073741824));
    if (!bc(this.aeE))
    {
      paramInt1 = bd(this.aeE);
      if (paramInt2 != -2147483648) {
        break label167;
      }
    }
    label167:
    for (paramInt2 = View.MeasureSpec.getSize(i);; paramInt2 = 2147483647)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + bd(this.aeD), paramInt2));
      return;
      if (!bc(this.aeF))
      {
        paramInt1 = bd(this.aeF);
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
    if (this.adb != null)
    {
      this.adb.setCallback(null);
      unscheduleDrawable(this.adb);
    }
    this.adb = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.aeE != null) {
        this.adb.setBounds(this.aeE.getLeft(), this.aeE.getTop(), this.aeE.getRight(), this.aeE.getBottom());
      }
    }
    if (this.aeI) {
      if (this.aeH != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.adb != null) || (this.aeG != null)) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.aeH != null)
    {
      this.aeH.setCallback(null);
      unscheduleDrawable(this.aeH);
    }
    this.aeH = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.aeI) && (this.aeH != null)) {
        this.aeH.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
    }
    if (this.aeI) {
      if (this.aeH != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.adb != null) || (this.aeG != null)) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.aeG != null)
    {
      this.aeG.setCallback(null);
      unscheduleDrawable(this.aeG);
    }
    this.aeG = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.aeJ) && (this.aeG != null)) {
        this.aeG.setBounds(this.aeD.getLeft(), this.aeD.getTop(), this.aeD.getRight(), this.aeD.getBottom());
      }
    }
    if (this.aeI) {
      if (this.aeH != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.adb != null) || (this.aeG != null)) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(ar paramar)
  {
    if (this.aeD != null) {
      removeView(this.aeD);
    }
    this.aeD = paramar;
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
    this.aeC = paramBoolean;
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
      if (this.adb != null) {
        this.adb.setVisible(bool, false);
      }
      if (this.aeG != null) {
        this.aeG.setVisible(bool, false);
      }
      if (this.aeH != null) {
        this.aeH.setVisible(bool, false);
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
    return ((paramDrawable == this.adb) && (!this.aeI)) || ((paramDrawable == this.aeG) && (this.aeJ)) || ((paramDrawable == this.aeH) && (this.aeI)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */