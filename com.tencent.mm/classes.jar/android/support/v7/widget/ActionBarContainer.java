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
  Drawable afM;
  private boolean ahn;
  private View aho;
  private View ahp;
  private View ahq;
  Drawable ahr;
  Drawable ahs;
  boolean aht;
  boolean ahu;
  private int mHeight;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    t.a(this, new b(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActionBar);
    this.afM = paramContext.getDrawable(0);
    this.ahr = paramContext.getDrawable(2);
    this.mHeight = paramContext.getDimensionPixelSize(13, -1);
    if (getId() == 2131305154)
    {
      this.aht = true;
      this.ahs = paramContext.getDrawable(1);
    }
    paramContext.recycle();
    if (this.aht) {
      if (this.ahs != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      bool = false;
      continue;
      if ((this.afM != null) || (this.ahr != null)) {
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
    if ((this.afM != null) && (this.afM.isStateful())) {
      this.afM.setState(getDrawableState());
    }
    if ((this.ahr != null) && (this.ahr.isStateful())) {
      this.ahr.setState(getDrawableState());
    }
    if ((this.ahs != null) && (this.ahs.isStateful())) {
      this.ahs.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.aho;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.afM != null) {
      this.afM.jumpToCurrentState();
    }
    if (this.ahr != null) {
      this.ahr.jumpToCurrentState();
    }
    if (this.ahs != null) {
      this.ahs.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.ahp = findViewById(2131296343);
    this.ahq = findViewById(2131296357);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.ahn) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.aho;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      paramBoolean = true;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        paramInt2 = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, paramInt2 - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, paramInt2 - localLayoutParams.bottomMargin);
      }
      if (!this.aht) {
        break label143;
      }
      if (this.ahs == null) {
        break label323;
      }
      this.ahs.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
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
      if (this.afM != null) {
        if (this.ahp.getVisibility() == 0) {
          this.afM.setBounds(this.ahp.getLeft(), this.ahp.getTop(), this.ahp.getRight(), this.ahp.getBottom());
        }
      }
      label195:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        this.ahu = paramBoolean;
        if ((paramBoolean) && (this.ahr != null))
        {
          this.ahr.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = i;
          break;
          if ((this.ahq != null) && (this.ahq.getVisibility() == 0))
          {
            this.afM.setBounds(this.ahq.getLeft(), this.ahq.getTop(), this.ahq.getRight(), this.ahq.getBottom());
            break label195;
          }
          this.afM.setBounds(0, 0, 0, 0);
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
    if (this.ahp == null)
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
    if (this.ahp == null) {}
    do
    {
      return;
      paramInt2 = View.MeasureSpec.getMode(i);
    } while ((this.aho == null) || (this.aho.getVisibility() == 8) || (paramInt2 == 1073741824));
    if (!bc(this.ahp))
    {
      paramInt1 = bd(this.ahp);
      if (paramInt2 != -2147483648) {
        break label167;
      }
    }
    label167:
    for (paramInt2 = View.MeasureSpec.getSize(i);; paramInt2 = 2147483647)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + bd(this.aho), paramInt2));
      return;
      if (!bc(this.ahq))
      {
        paramInt1 = bd(this.ahq);
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
    if (this.afM != null)
    {
      this.afM.setCallback(null);
      unscheduleDrawable(this.afM);
    }
    this.afM = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.ahp != null) {
        this.afM.setBounds(this.ahp.getLeft(), this.ahp.getTop(), this.ahp.getRight(), this.ahp.getBottom());
      }
    }
    if (this.aht) {
      if (this.ahs != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.afM != null) || (this.ahr != null)) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.ahs != null)
    {
      this.ahs.setCallback(null);
      unscheduleDrawable(this.ahs);
    }
    this.ahs = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.aht) && (this.ahs != null)) {
        this.ahs.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
    }
    if (this.aht) {
      if (this.ahs != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.afM != null) || (this.ahr != null)) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.ahr != null)
    {
      this.ahr.setCallback(null);
      unscheduleDrawable(this.ahr);
    }
    this.ahr = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.ahu) && (this.ahr != null)) {
        this.ahr.setBounds(this.aho.getLeft(), this.aho.getTop(), this.aho.getRight(), this.aho.getBottom());
      }
    }
    if (this.aht) {
      if (this.ahs != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.afM != null) || (this.ahr != null)) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(ar paramar)
  {
    if (this.aho != null) {
      removeView(this.aho);
    }
    this.aho = paramar;
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
    this.ahn = paramBoolean;
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
      if (this.afM != null) {
        this.afM.setVisible(bool, false);
      }
      if (this.ahr != null) {
        this.ahr.setVisible(bool, false);
      }
      if (this.ahs != null) {
        this.ahs.setVisible(bool, false);
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
    return ((paramDrawable == this.afM) && (!this.aht)) || ((paramDrawable == this.ahr) && (this.ahu)) || ((paramDrawable == this.ahs) && (this.aht)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */