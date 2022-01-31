package com.samsung.android.sdk.look.airbutton;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.airbutton.AirButtonImpl;
import com.samsung.android.sdk.look.Slook;

public class SlookAirButton
{
  public static final int DIRECTION_AUTO = -1;
  public static final int DIRECTION_LEFT = 3;
  public static final int DIRECTION_LOWER = 2;
  public static final int DIRECTION_RIGHT = 4;
  public static final int DIRECTION_UPPER = 1;
  public static final int GRAVITY_AUTO = -1;
  public static final int GRAVITY_BOTTOM = 2;
  public static final int GRAVITY_HOVER_POINT = 5;
  public static final int GRAVITY_LEFT = 3;
  public static final int GRAVITY_RIGHT = 4;
  public static final int GRAVITY_TOP = 1;
  private static final String TAG = "AirButtonWidget";
  public static final int UI_TYPE_LIST = 2;
  public static final int UI_TYPE_MENU = 1;
  private AirButtonImpl mAirButtonImpl = null;
  private SlookAirButton.ItemSelectListener mItemSelectListener;
  private Slook mSlook = new Slook();
  private int mUIType = 2;
  
  public SlookAirButton(View paramView, SlookAirButtonAdapter paramSlookAirButtonAdapter, int paramInt)
  {
    if (!isSupport(1)) {
      return;
    }
    if (paramSlookAirButtonAdapter == null) {
      throw new IllegalArgumentException("adapter is null");
    }
    this.mUIType = paramInt;
    this.mAirButtonImpl = new AirButtonImpl(paramView, paramSlookAirButtonAdapter, paramInt);
  }
  
  private boolean isSupport(int paramInt)
  {
    return this.mSlook.isFeatureEnabled(1);
  }
  
  public void dismiss()
  {
    if (!isSupport(1)) {
      return;
    }
    this.mAirButtonImpl.dismiss();
  }
  
  public int getDirection()
  {
    if (!isSupport(1)) {
      return 0;
    }
    return this.mAirButtonImpl.getDirection();
  }
  
  public int getGravity()
  {
    if (!isSupport(1)) {
      return 0;
    }
    return this.mAirButtonImpl.getGravity();
  }
  
  public void hide()
  {
    if (!isSupport(1)) {
      return;
    }
    this.mAirButtonImpl.hide();
  }
  
  public boolean isAutoControlEnabled()
  {
    if (!isSupport(1)) {
      return false;
    }
    return this.mAirButtonImpl.isEnabled();
  }
  
  public boolean isBounceEffectEnabled()
  {
    if (!isSupport(1)) {
      return false;
    }
    return this.mAirButtonImpl.isBounceEffectEnabled();
  }
  
  public boolean isScrollEnabled()
  {
    if (!isSupport(1)) {
      return false;
    }
    return this.mAirButtonImpl.isScrollEnabled();
  }
  
  public void moveAnimationIcon(MotionEvent paramMotionEvent)
  {
    if (!isSupport(1)) {
      return;
    }
    if (this.mAirButtonImpl.isEnabled()) {
      throw new IllegalStateException("The mode is auto control. Please disable auto control.");
    }
    if (paramMotionEvent.getAction() != 7) {
      throw new IllegalArgumentException("The event isn't ACTION_HOVER_MOVE.");
    }
    this.mAirButtonImpl.onHoverMove(paramMotionEvent);
  }
  
  public void setAutoControlEnabled(boolean paramBoolean)
  {
    if (!isSupport(1)) {
      return;
    }
    this.mAirButtonImpl.setEnabled(paramBoolean);
  }
  
  public void setBounceEffectEnabled(boolean paramBoolean)
  {
    if (!isSupport(1)) {
      return;
    }
    this.mAirButtonImpl.setBounceEffectEnabled(paramBoolean);
  }
  
  public void setDirection(int paramInt)
  {
    if (!isSupport(1)) {
      return;
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      new StringBuilder("The direction(").append(paramInt).append(") was wrong.");
    }
    if ((this.mUIType == 1) && ((paramInt == 1) || (paramInt == 2))) {
      throw new IllegalStateException("The Direction is wrong.you cann't use UPPER/LOWER direction with UI_TYPE_MENU.");
    }
    if ((this.mUIType == 2) && ((paramInt == 3) || (paramInt == 4))) {
      throw new IllegalStateException("The Direction is wrong.you cann't use LEFT/RIGHT direction with UI_TYPE_LIST.");
    }
    this.mAirButtonImpl.setDirection(paramInt);
  }
  
  public void setGravity(int paramInt)
  {
    if (!isSupport(1)) {
      return;
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      new StringBuilder("The gravity(").append(paramInt).append(") was wrong.");
    }
    if ((this.mUIType == 1) && ((paramInt == 3) || (paramInt == 4))) {
      throw new IllegalStateException("The Gravity is wrong. You cann't use GRAVITY_LEFT/GRAVITY_RIGHT with UI_TYPE_MENU.");
    }
    this.mAirButtonImpl.setGravity(paramInt);
  }
  
  public void setItemSelectListener(SlookAirButton.ItemSelectListener paramItemSelectListener)
  {
    if (!isSupport(1)) {}
    do
    {
      return;
      this.mItemSelectListener = paramItemSelectListener;
    } while (this.mItemSelectListener == null);
    this.mAirButtonImpl.setOnItemSelectedListener(new SlookAirButton.1(this));
  }
  
  public void setPosition(int paramInt1, int paramInt2)
  {
    if (!isSupport(1)) {
      return;
    }
    this.mAirButtonImpl.setPosition(paramInt1, paramInt2);
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    if (!isSupport(1)) {
      return;
    }
    this.mAirButtonImpl.setScrollEnabled(paramBoolean);
  }
  
  public void show(MotionEvent paramMotionEvent)
  {
    if (!isSupport(1)) {
      return;
    }
    if (this.mAirButtonImpl.isEnabled()) {
      throw new IllegalStateException("The mode is auto control. Please disable auto control.");
    }
    if (paramMotionEvent.getToolType(0) != 2) {
      throw new IllegalArgumentException("The event isn't TOOL_TYPE_STYLUS.");
    }
    this.mAirButtonImpl.onHoverButtonSecondary(paramMotionEvent);
  }
  
  public void startAnimationIcon(MotionEvent paramMotionEvent)
  {
    if (!isSupport(1)) {
      return;
    }
    if (this.mAirButtonImpl.isEnabled()) {
      throw new IllegalStateException("The mode is auto control. Please disable auto control.");
    }
    if (paramMotionEvent.getAction() != 9) {
      throw new IllegalArgumentException("The event isn't ACTION_HOVER_ENTER");
    }
    this.mAirButtonImpl.onHoverEnter(paramMotionEvent);
  }
  
  public void stopAnimationIcon(MotionEvent paramMotionEvent)
  {
    if (!isSupport(1)) {
      return;
    }
    if (this.mAirButtonImpl.isEnabled()) {
      throw new IllegalStateException("The mode is auto control. Please disable auto control.");
    }
    if (paramMotionEvent.getAction() != 10) {
      throw new IllegalArgumentException("The event isn't ACTION_HOVER_EXIT.");
    }
    this.mAirButtonImpl.onHoverExit(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButton
 * JD-Core Version:    0.7.0.1
 */