package com.tencent.mm.plugin.finder.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$3
  implements View.OnTouchListener
{
  boolean Gxf = false;
  
  d$3(d paramd, ViewParent paramViewParent) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(345296);
    this.uaG.getParent().requestDisallowInterceptTouchEvent(true);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(345296);
      return true;
      this.Gxf = true;
      continue;
      if (this.Gxf) {
        this.Gxe.cyW();
      }
      this.Gxf = false;
      continue;
      this.Gxf = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.d.3
 * JD-Core Version:    0.7.0.1
 */