package com.samsung.android.sdk.look;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SlookPointerIcon
{
  private static final String TAG = "SlookPointerIcon";
  private Drawable mDrawable;
  private Slook mSlook;
  
  public SlookPointerIcon()
  {
    AppMethodBeat.i(76314);
    this.mSlook = new Slook();
    AppMethodBeat.o(76314);
  }
  
  private boolean isSupport(int paramInt)
  {
    AppMethodBeat.i(76316);
    if (this.mSlook.isFeatureEnabled(4))
    {
      AppMethodBeat.o(76316);
      return true;
    }
    AppMethodBeat.o(76316);
    return false;
  }
  
  public void setHoverIcon(View paramView, Drawable paramDrawable)
  {
    AppMethodBeat.i(76315);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76315);
      return;
    }
    if (paramView == null)
    {
      paramView = new IllegalArgumentException("view is null.");
      AppMethodBeat.o(76315);
      throw paramView;
    }
    if (paramDrawable == null)
    {
      paramView.setOnHoverListener(null);
      try
      {
        PointerIcon.setHoveringSpenIcon(1, -1);
        AppMethodBeat.o(76315);
        return;
      }
      catch (RemoteException paramView)
      {
        AppMethodBeat.o(76315);
        return;
      }
    }
    this.mDrawable = paramDrawable;
    paramView.setOnHoverListener(new View.OnHoverListener()
    {
      public boolean onHover(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(76234);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(76234);
          return false;
          try
          {
            PointerIcon.setHoveringSpenIcon(0, SlookPointerIcon.this.mDrawable);
          }
          catch (RemoteException paramAnonymousView) {}
          continue;
          try
          {
            PointerIcon.setHoveringSpenIcon(1, -1);
          }
          catch (RemoteException paramAnonymousView) {}
        }
      }
    });
    AppMethodBeat.o(76315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.samsung.android.sdk.look.SlookPointerIcon
 * JD-Core Version:    0.7.0.1
 */