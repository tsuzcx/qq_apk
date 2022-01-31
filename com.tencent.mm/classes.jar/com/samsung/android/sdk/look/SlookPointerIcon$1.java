package com.samsung.android.sdk.look;

import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnHoverListener;

class SlookPointerIcon$1
  implements View.OnHoverListener
{
  SlookPointerIcon$1(SlookPointerIcon paramSlookPointerIcon) {}
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 9: 
      try
      {
        PointerIcon.setHoveringSpenIcon(0, SlookPointerIcon.access$000(this.this$0));
        return false;
      }
      catch (RemoteException paramView)
      {
        return false;
      }
    }
    try
    {
      PointerIcon.setHoveringSpenIcon(1, -1);
      return false;
    }
    catch (RemoteException paramView) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.samsung.android.sdk.look.SlookPointerIcon.1
 * JD-Core Version:    0.7.0.1
 */