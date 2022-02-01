package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BaseTransientBottomBar$Behavior
  extends SwipeDismissBehavior<View>
{
  private final BaseTransientBottomBar.a bEz;
  
  public BaseTransientBottomBar$Behavior()
  {
    AppMethodBeat.i(239143);
    this.bEz = new BaseTransientBottomBar.a(this);
    AppMethodBeat.o(239143);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(239147);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.a(paramCoordinatorLayout, paramView, paramMotionEvent);
      AppMethodBeat.o(239147);
      return bool;
      if (!paramCoordinatorLayout.d(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        continue;
      }
      a locala = a.xx();
      synchronized (locala.lock)
      {
        locala.xy();
      }
      locala = a.xx();
      synchronized (locala.lock)
      {
        locala.xy();
      }
    }
  }
  
  public final boolean cf(View paramView)
  {
    return paramView instanceof BaseTransientBottomBar.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.Behavior
 * JD-Core Version:    0.7.0.1
 */