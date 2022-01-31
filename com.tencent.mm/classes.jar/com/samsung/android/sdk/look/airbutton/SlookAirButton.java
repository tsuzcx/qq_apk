package com.samsung.android.sdk.look.airbutton;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.airbutton.AirButtonImpl;
import com.samsung.android.sdk.look.Slook;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
  private AirButtonImpl mAirButtonImpl;
  private SlookAirButton.ItemSelectListener mItemSelectListener;
  private Slook mSlook;
  private int mUIType;
  
  public SlookAirButton(View paramView, SlookAirButtonAdapter paramSlookAirButtonAdapter, int paramInt)
  {
    AppMethodBeat.i(117251);
    this.mAirButtonImpl = null;
    this.mUIType = 2;
    this.mSlook = new Slook();
    if (!isSupport(1))
    {
      AppMethodBeat.o(117251);
      return;
    }
    if (paramSlookAirButtonAdapter == null)
    {
      paramView = new IllegalArgumentException("adapter is null");
      AppMethodBeat.o(117251);
      throw paramView;
    }
    this.mUIType = paramInt;
    this.mAirButtonImpl = new AirButtonImpl(paramView, paramSlookAirButtonAdapter, paramInt);
    AppMethodBeat.o(117251);
  }
  
  private boolean isSupport(int paramInt)
  {
    AppMethodBeat.i(117260);
    if (this.mSlook.isFeatureEnabled(1))
    {
      AppMethodBeat.o(117260);
      return true;
    }
    AppMethodBeat.o(117260);
    return false;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(117264);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117264);
      return;
    }
    this.mAirButtonImpl.dismiss();
    AppMethodBeat.o(117264);
  }
  
  public int getDirection()
  {
    AppMethodBeat.i(117256);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117256);
      return 0;
    }
    int i = this.mAirButtonImpl.getDirection();
    AppMethodBeat.o(117256);
    return i;
  }
  
  public int getGravity()
  {
    AppMethodBeat.i(117254);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117254);
      return 0;
    }
    int i = this.mAirButtonImpl.getGravity();
    AppMethodBeat.o(117254);
    return i;
  }
  
  public void hide()
  {
    AppMethodBeat.i(117263);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117263);
      return;
    }
    this.mAirButtonImpl.hide();
    AppMethodBeat.o(117263);
  }
  
  public boolean isAutoControlEnabled()
  {
    AppMethodBeat.i(117266);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117266);
      return false;
    }
    boolean bool = this.mAirButtonImpl.isEnabled();
    AppMethodBeat.o(117266);
    return bool;
  }
  
  public boolean isBounceEffectEnabled()
  {
    AppMethodBeat.i(117262);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117262);
      return false;
    }
    boolean bool = this.mAirButtonImpl.isBounceEffectEnabled();
    AppMethodBeat.o(117262);
    return bool;
  }
  
  public boolean isScrollEnabled()
  {
    AppMethodBeat.i(117259);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117259);
      return false;
    }
    boolean bool = this.mAirButtonImpl.isScrollEnabled();
    AppMethodBeat.o(117259);
    return bool;
  }
  
  public void moveAnimationIcon(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(117268);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117268);
      return;
    }
    if (this.mAirButtonImpl.isEnabled())
    {
      paramMotionEvent = new IllegalStateException("The mode is auto control. Please disable auto control.");
      AppMethodBeat.o(117268);
      throw paramMotionEvent;
    }
    if (paramMotionEvent.getAction() != 7)
    {
      paramMotionEvent = new IllegalArgumentException("The event isn't ACTION_HOVER_MOVE.");
      AppMethodBeat.o(117268);
      throw paramMotionEvent;
    }
    this.mAirButtonImpl.onHoverMove(paramMotionEvent);
    AppMethodBeat.o(117268);
  }
  
  public void setAutoControlEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(117265);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117265);
      return;
    }
    this.mAirButtonImpl.setEnabled(paramBoolean);
    AppMethodBeat.o(117265);
  }
  
  public void setBounceEffectEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(117261);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117261);
      return;
    }
    this.mAirButtonImpl.setBounceEffectEnabled(paramBoolean);
    AppMethodBeat.o(117261);
  }
  
  public void setDirection(int paramInt)
  {
    AppMethodBeat.i(117255);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117255);
      return;
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      new StringBuilder("The direction(").append(paramInt).append(") was wrong.");
    }
    IllegalStateException localIllegalStateException;
    if ((this.mUIType == 1) && ((paramInt == 1) || (paramInt == 2)))
    {
      localIllegalStateException = new IllegalStateException("The Direction is wrong.you cann't use UPPER/LOWER direction with UI_TYPE_MENU.");
      AppMethodBeat.o(117255);
      throw localIllegalStateException;
    }
    if ((this.mUIType == 2) && ((paramInt == 3) || (paramInt == 4)))
    {
      localIllegalStateException = new IllegalStateException("The Direction is wrong.you cann't use LEFT/RIGHT direction with UI_TYPE_LIST.");
      AppMethodBeat.o(117255);
      throw localIllegalStateException;
    }
    this.mAirButtonImpl.setDirection(paramInt);
    AppMethodBeat.o(117255);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(117253);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117253);
      return;
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      new StringBuilder("The gravity(").append(paramInt).append(") was wrong.");
    }
    if ((this.mUIType == 1) && ((paramInt == 3) || (paramInt == 4)))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("The Gravity is wrong. You cann't use GRAVITY_LEFT/GRAVITY_RIGHT with UI_TYPE_MENU.");
      AppMethodBeat.o(117253);
      throw localIllegalStateException;
    }
    this.mAirButtonImpl.setGravity(paramInt);
    AppMethodBeat.o(117253);
  }
  
  public void setItemSelectListener(SlookAirButton.ItemSelectListener paramItemSelectListener)
  {
    AppMethodBeat.i(117252);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117252);
      return;
    }
    this.mItemSelectListener = paramItemSelectListener;
    if (this.mItemSelectListener != null) {
      this.mAirButtonImpl.setOnItemSelectedListener(new SlookAirButton.1(this));
    }
    AppMethodBeat.o(117252);
  }
  
  public void setPosition(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117257);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117257);
      return;
    }
    this.mAirButtonImpl.setPosition(paramInt1, paramInt2);
    AppMethodBeat.o(117257);
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(117258);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117258);
      return;
    }
    this.mAirButtonImpl.setScrollEnabled(paramBoolean);
    AppMethodBeat.o(117258);
  }
  
  public void show(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(117270);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117270);
      return;
    }
    if (this.mAirButtonImpl.isEnabled())
    {
      paramMotionEvent = new IllegalStateException("The mode is auto control. Please disable auto control.");
      AppMethodBeat.o(117270);
      throw paramMotionEvent;
    }
    if (paramMotionEvent.getToolType(0) != 2)
    {
      paramMotionEvent = new IllegalArgumentException("The event isn't TOOL_TYPE_STYLUS.");
      AppMethodBeat.o(117270);
      throw paramMotionEvent;
    }
    this.mAirButtonImpl.onHoverButtonSecondary(paramMotionEvent);
    AppMethodBeat.o(117270);
  }
  
  public void startAnimationIcon(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(117267);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117267);
      return;
    }
    if (this.mAirButtonImpl.isEnabled())
    {
      paramMotionEvent = new IllegalStateException("The mode is auto control. Please disable auto control.");
      AppMethodBeat.o(117267);
      throw paramMotionEvent;
    }
    if (paramMotionEvent.getAction() != 9)
    {
      paramMotionEvent = new IllegalArgumentException("The event isn't ACTION_HOVER_ENTER");
      AppMethodBeat.o(117267);
      throw paramMotionEvent;
    }
    this.mAirButtonImpl.onHoverEnter(paramMotionEvent);
    AppMethodBeat.o(117267);
  }
  
  public void stopAnimationIcon(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(117269);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117269);
      return;
    }
    if (this.mAirButtonImpl.isEnabled())
    {
      paramMotionEvent = new IllegalStateException("The mode is auto control. Please disable auto control.");
      AppMethodBeat.o(117269);
      throw paramMotionEvent;
    }
    if (paramMotionEvent.getAction() != 10)
    {
      paramMotionEvent = new IllegalArgumentException("The event isn't ACTION_HOVER_EXIT.");
      AppMethodBeat.o(117269);
      throw paramMotionEvent;
    }
    this.mAirButtonImpl.onHoverExit(paramMotionEvent);
    AppMethodBeat.o(117269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButton
 * JD-Core Version:    0.7.0.1
 */