package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BaseTransientBottomBar$Behavior
  extends SwipeDismissBehavior<View>
{
  private final BaseTransientBottomBar.a dxA;
  
  public BaseTransientBottomBar$Behavior()
  {
    AppMethodBeat.i(209799);
    this.dxA = new BaseTransientBottomBar.a(this);
    AppMethodBeat.o(209799);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209830);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.a(paramCoordinatorLayout, paramView, paramMotionEvent);
      AppMethodBeat.o(209830);
      return bool;
      if (paramCoordinatorLayout.d(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        a locala = a.WU();
        synchronized (locala.lock)
        {
          if (locala.WV())
          {
            AppMethodBeat.o(209830);
            throw null;
          }
        }
        continue;
        locala = a.WU();
        synchronized (locala.lock)
        {
          if (locala.WV())
          {
            AppMethodBeat.o(209830);
            throw null;
          }
        }
      }
    }
  }
  
  public final boolean cB(View paramView)
  {
    return paramView instanceof BaseTransientBottomBar.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.Behavior
 * JD-Core Version:    0.7.0.1
 */