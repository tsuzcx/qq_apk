package com.samsung.android.sdk.look.airbutton;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.airbutton.AirButtonImpl;
import com.samsung.android.airbutton.AirButtonImpl.OnItemSelectedListener;
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
  private ItemSelectListener mItemSelectListener;
  private Slook mSlook;
  private int mUIType;
  
  public SlookAirButton(View paramView, SlookAirButtonAdapter paramSlookAirButtonAdapter, int paramInt)
  {
    AppMethodBeat.i(76293);
    this.mAirButtonImpl = null;
    this.mUIType = 2;
    this.mSlook = new Slook();
    if (!isSupport(1))
    {
      AppMethodBeat.o(76293);
      return;
    }
    if (paramSlookAirButtonAdapter == null)
    {
      paramView = new IllegalArgumentException("adapter is null");
      AppMethodBeat.o(76293);
      throw paramView;
    }
    this.mUIType = paramInt;
    this.mAirButtonImpl = new AirButtonImpl(paramView, paramSlookAirButtonAdapter, paramInt);
    AppMethodBeat.o(76293);
  }
  
  private boolean isSupport(int paramInt)
  {
    AppMethodBeat.i(76302);
    if (this.mSlook.isFeatureEnabled(1))
    {
      AppMethodBeat.o(76302);
      return true;
    }
    AppMethodBeat.o(76302);
    return false;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(76306);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76306);
      return;
    }
    this.mAirButtonImpl.dismiss();
    AppMethodBeat.o(76306);
  }
  
  public int getDirection()
  {
    AppMethodBeat.i(76298);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76298);
      return 0;
    }
    int i = this.mAirButtonImpl.getDirection();
    AppMethodBeat.o(76298);
    return i;
  }
  
  public int getGravity()
  {
    AppMethodBeat.i(76296);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76296);
      return 0;
    }
    int i = this.mAirButtonImpl.getGravity();
    AppMethodBeat.o(76296);
    return i;
  }
  
  public void hide()
  {
    AppMethodBeat.i(76305);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76305);
      return;
    }
    this.mAirButtonImpl.hide();
    AppMethodBeat.o(76305);
  }
  
  public boolean isAutoControlEnabled()
  {
    AppMethodBeat.i(76308);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76308);
      return false;
    }
    boolean bool = this.mAirButtonImpl.isEnabled();
    AppMethodBeat.o(76308);
    return bool;
  }
  
  public boolean isBounceEffectEnabled()
  {
    AppMethodBeat.i(76304);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76304);
      return false;
    }
    boolean bool = this.mAirButtonImpl.isBounceEffectEnabled();
    AppMethodBeat.o(76304);
    return bool;
  }
  
  public boolean isScrollEnabled()
  {
    AppMethodBeat.i(76301);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76301);
      return false;
    }
    boolean bool = this.mAirButtonImpl.isScrollEnabled();
    AppMethodBeat.o(76301);
    return bool;
  }
  
  public void moveAnimationIcon(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76310);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76310);
      return;
    }
    if (this.mAirButtonImpl.isEnabled())
    {
      paramMotionEvent = new IllegalStateException("The mode is auto control. Please disable auto control.");
      AppMethodBeat.o(76310);
      throw paramMotionEvent;
    }
    if (paramMotionEvent.getAction() != 7)
    {
      paramMotionEvent = new IllegalArgumentException("The event isn't ACTION_HOVER_MOVE.");
      AppMethodBeat.o(76310);
      throw paramMotionEvent;
    }
    this.mAirButtonImpl.onHoverMove(paramMotionEvent);
    AppMethodBeat.o(76310);
  }
  
  public void setAutoControlEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(76307);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76307);
      return;
    }
    this.mAirButtonImpl.setEnabled(paramBoolean);
    AppMethodBeat.o(76307);
  }
  
  public void setBounceEffectEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(76303);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76303);
      return;
    }
    this.mAirButtonImpl.setBounceEffectEnabled(paramBoolean);
    AppMethodBeat.o(76303);
  }
  
  public void setDirection(int paramInt)
  {
    AppMethodBeat.i(76297);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76297);
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
      AppMethodBeat.o(76297);
      throw localIllegalStateException;
    }
    if ((this.mUIType == 2) && ((paramInt == 3) || (paramInt == 4)))
    {
      localIllegalStateException = new IllegalStateException("The Direction is wrong.you cann't use LEFT/RIGHT direction with UI_TYPE_LIST.");
      AppMethodBeat.o(76297);
      throw localIllegalStateException;
    }
    this.mAirButtonImpl.setDirection(paramInt);
    AppMethodBeat.o(76297);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(76295);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76295);
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
      AppMethodBeat.o(76295);
      throw localIllegalStateException;
    }
    this.mAirButtonImpl.setGravity(paramInt);
    AppMethodBeat.o(76295);
  }
  
  public void setItemSelectListener(ItemSelectListener paramItemSelectListener)
  {
    AppMethodBeat.i(76294);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76294);
      return;
    }
    this.mItemSelectListener = paramItemSelectListener;
    if (this.mItemSelectListener != null) {
      this.mAirButtonImpl.setOnItemSelectedListener(new AirButtonImpl.OnItemSelectedListener()
      {
        public void onItemSelected(View paramAnonymousView, int paramAnonymousInt, Object paramAnonymousObject)
        {
          AppMethodBeat.i(76313);
          SlookAirButton.this.mItemSelectListener.onItemSelected(paramAnonymousView, paramAnonymousInt, paramAnonymousObject);
          AppMethodBeat.o(76313);
        }
      });
    }
    AppMethodBeat.o(76294);
  }
  
  public void setPosition(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76299);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76299);
      return;
    }
    this.mAirButtonImpl.setPosition(paramInt1, paramInt2);
    AppMethodBeat.o(76299);
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(76300);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76300);
      return;
    }
    this.mAirButtonImpl.setScrollEnabled(paramBoolean);
    AppMethodBeat.o(76300);
  }
  
  public void show(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76312);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76312);
      return;
    }
    if (this.mAirButtonImpl.isEnabled())
    {
      paramMotionEvent = new IllegalStateException("The mode is auto control. Please disable auto control.");
      AppMethodBeat.o(76312);
      throw paramMotionEvent;
    }
    if (paramMotionEvent.getToolType(0) != 2)
    {
      paramMotionEvent = new IllegalArgumentException("The event isn't TOOL_TYPE_STYLUS.");
      AppMethodBeat.o(76312);
      throw paramMotionEvent;
    }
    this.mAirButtonImpl.onHoverButtonSecondary(paramMotionEvent);
    AppMethodBeat.o(76312);
  }
  
  public void startAnimationIcon(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76309);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76309);
      return;
    }
    if (this.mAirButtonImpl.isEnabled())
    {
      paramMotionEvent = new IllegalStateException("The mode is auto control. Please disable auto control.");
      AppMethodBeat.o(76309);
      throw paramMotionEvent;
    }
    if (paramMotionEvent.getAction() != 9)
    {
      paramMotionEvent = new IllegalArgumentException("The event isn't ACTION_HOVER_ENTER");
      AppMethodBeat.o(76309);
      throw paramMotionEvent;
    }
    this.mAirButtonImpl.onHoverEnter(paramMotionEvent);
    AppMethodBeat.o(76309);
  }
  
  public void stopAnimationIcon(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76311);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76311);
      return;
    }
    if (this.mAirButtonImpl.isEnabled())
    {
      paramMotionEvent = new IllegalStateException("The mode is auto control. Please disable auto control.");
      AppMethodBeat.o(76311);
      throw paramMotionEvent;
    }
    if (paramMotionEvent.getAction() != 10)
    {
      paramMotionEvent = new IllegalArgumentException("The event isn't ACTION_HOVER_EXIT.");
      AppMethodBeat.o(76311);
      throw paramMotionEvent;
    }
    this.mAirButtonImpl.onHoverExit(paramMotionEvent);
    AppMethodBeat.o(76311);
  }
  
  public static abstract interface ItemSelectListener
  {
    public abstract void onItemSelected(View paramView, int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButton
 * JD-Core Version:    0.7.0.1
 */