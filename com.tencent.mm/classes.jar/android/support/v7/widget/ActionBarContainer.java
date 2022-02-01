package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
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
  Drawable afZ;
  private boolean ahA;
  private View ahB;
  private View ahC;
  private View ahD;
  Drawable ahE;
  Drawable ahF;
  boolean ahG;
  boolean ahH;
  private int mHeight;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    u.a(this, new b(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActionBar);
    this.afZ = paramContext.getDrawable(0);
    this.ahE = paramContext.getDrawable(2);
    this.mHeight = paramContext.getDimensionPixelSize(13, -1);
    if (getId() == 2131308337)
    {
      this.ahG = true;
      this.ahF = paramContext.getDrawable(1);
    }
    paramContext.recycle();
    if (this.ahG) {
      if (this.ahF != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      bool = false;
      continue;
      if ((this.afZ != null) || (this.ahE != null)) {
        bool = false;
      }
    }
  }
  
  private static boolean bd(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
  }
  
  private static int be(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.afZ != null) && (this.afZ.isStateful())) {
      this.afZ.setState(getDrawableState());
    }
    if ((this.ahE != null) && (this.ahE.isStateful())) {
      this.ahE.setState(getDrawableState());
    }
    if ((this.ahF != null) && (this.ahF.isStateful())) {
      this.ahF.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.ahB;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.afZ != null) {
      this.afZ.jumpToCurrentState();
    }
    if (this.ahE != null) {
      this.ahE.jumpToCurrentState();
    }
    if (this.ahF != null) {
      this.ahF.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.ahC = findViewById(2131296363);
    this.ahD = findViewById(2131296380);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.ahA) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.ahB;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      paramBoolean = true;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        paramInt2 = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, paramInt2 - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, paramInt2 - localLayoutParams.bottomMargin);
      }
      if (!this.ahG) {
        break label143;
      }
      if (this.ahF == null) {
        break label323;
      }
      this.ahF.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
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
      if (this.afZ != null) {
        if (this.ahC.getVisibility() == 0) {
          this.afZ.setBounds(this.ahC.getLeft(), this.ahC.getTop(), this.ahC.getRight(), this.ahC.getBottom());
        }
      }
      label195:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        this.ahH = paramBoolean;
        if ((paramBoolean) && (this.ahE != null))
        {
          this.ahE.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = i;
          break;
          if ((this.ahD != null) && (this.ahD.getVisibility() == 0))
          {
            this.afZ.setBounds(this.ahD.getLeft(), this.ahD.getTop(), this.ahD.getRight(), this.ahD.getBottom());
            break label195;
          }
          this.afZ.setBounds(0, 0, 0, 0);
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
    if (this.ahC == null)
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
    if (this.ahC == null) {}
    do
    {
      return;
      paramInt2 = View.MeasureSpec.getMode(i);
    } while ((this.ahB == null) || (this.ahB.getVisibility() == 8) || (paramInt2 == 1073741824));
    if (!bd(this.ahC))
    {
      paramInt1 = be(this.ahC);
      if (paramInt2 != -2147483648) {
        break label167;
      }
    }
    label167:
    for (paramInt2 = View.MeasureSpec.getSize(i);; paramInt2 = 2147483647)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + be(this.ahB), paramInt2));
      return;
      if (!bd(this.ahD))
      {
        paramInt1 = be(this.ahD);
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
    if (this.afZ != null)
    {
      this.afZ.setCallback(null);
      unscheduleDrawable(this.afZ);
    }
    this.afZ = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.ahC != null) {
        this.afZ.setBounds(this.ahC.getLeft(), this.ahC.getTop(), this.ahC.getRight(), this.ahC.getBottom());
      }
    }
    if (this.ahG) {
      if (this.ahF != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.afZ != null) || (this.ahE != null)) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.ahF != null)
    {
      this.ahF.setCallback(null);
      unscheduleDrawable(this.ahF);
    }
    this.ahF = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.ahG) && (this.ahF != null)) {
        this.ahF.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
    }
    if (this.ahG) {
      if (this.ahF != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.afZ != null) || (this.ahE != null)) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.ahE != null)
    {
      this.ahE.setCallback(null);
      unscheduleDrawable(this.ahE);
    }
    this.ahE = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.ahH) && (this.ahE != null)) {
        this.ahE.setBounds(this.ahB.getLeft(), this.ahB.getTop(), this.ahB.getRight(), this.ahB.getBottom());
      }
    }
    if (this.ahG) {
      if (this.ahF != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.afZ != null) || (this.ahE != null)) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(ar paramar)
  {
    if (this.ahB != null) {
      removeView(this.ahB);
    }
    this.ahB = paramar;
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
    this.ahA = paramBoolean;
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
      if (this.afZ != null) {
        this.afZ.setVisible(bool, false);
      }
      if (this.ahE != null) {
        this.ahE.setVisible(bool, false);
      }
      if (this.ahF != null) {
        this.ahF.setVisible(bool, false);
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
    return ((paramDrawable == this.afZ) && (!this.ahG)) || ((paramDrawable == this.ahE) && (this.ahH)) || ((paramDrawable == this.ahF) && (this.ahG)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */