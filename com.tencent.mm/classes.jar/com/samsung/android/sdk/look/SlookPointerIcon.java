package com.samsung.android.sdk.look;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.PointerIcon;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SlookPointerIcon
{
  private static final String TAG = "SlookPointerIcon";
  private Drawable mDrawable;
  private Slook mSlook;
  
  public SlookPointerIcon()
  {
    AppMethodBeat.i(117272);
    this.mSlook = new Slook();
    AppMethodBeat.o(117272);
  }
  
  private boolean isSupport(int paramInt)
  {
    AppMethodBeat.i(117274);
    if (this.mSlook.isFeatureEnabled(4))
    {
      AppMethodBeat.o(117274);
      return true;
    }
    AppMethodBeat.o(117274);
    return false;
  }
  
  public void setHoverIcon(View paramView, Drawable paramDrawable)
  {
    AppMethodBeat.i(117273);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117273);
      return;
    }
    if (paramView == null)
    {
      paramView = new IllegalArgumentException("view is null.");
      AppMethodBeat.o(117273);
      throw paramView;
    }
    if (paramDrawable == null)
    {
      paramView.setOnHoverListener(null);
      try
      {
        PointerIcon.setHoveringSpenIcon(1, -1);
        AppMethodBeat.o(117273);
        return;
      }
      catch (RemoteException paramView)
      {
        AppMethodBeat.o(117273);
        return;
      }
    }
    this.mDrawable = paramDrawable;
    paramView.setOnHoverListener(new SlookPointerIcon.1(this));
    AppMethodBeat.o(117273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.samsung.android.sdk.look.SlookPointerIcon
 * JD-Core Version:    0.7.0.1
 */