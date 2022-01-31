package com.samsung.android.sdk.look;

import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SlookPointerIcon$1
  implements View.OnHoverListener
{
  SlookPointerIcon$1(SlookPointerIcon paramSlookPointerIcon) {}
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(117192);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117192);
      return false;
      try
      {
        PointerIcon.setHoveringSpenIcon(0, SlookPointerIcon.access$000(this.this$0));
      }
      catch (RemoteException paramView) {}
      continue;
      try
      {
        PointerIcon.setHoveringSpenIcon(1, -1);
      }
      catch (RemoteException paramView) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.samsung.android.sdk.look.SlookPointerIcon.1
 * JD-Core Version:    0.7.0.1
 */