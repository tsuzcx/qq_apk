package com.tencent.mm.plugin.ipcall.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

final class IPCallFuncButton$1
  implements View.OnTouchListener
{
  IPCallFuncButton$1(IPCallFuncButton paramIPCallFuncButton) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!IPCallFuncButton.a(this.lwD)) {}
    do
    {
      do
      {
        for (;;)
        {
          return false;
          if (paramMotionEvent.getAction() != 0) {
            break;
          }
          if (!IPCallFuncButton.b(this.lwD))
          {
            if (IPCallFuncButton.c(this.lwD) != null)
            {
              IPCallFuncButton.d(this.lwD).setImageDrawable(IPCallFuncButton.c(this.lwD));
              return false;
            }
          }
          else
          {
            if (IPCallFuncButton.e(this.lwD))
            {
              IPCallFuncButton.d(this.lwD).setImageDrawable(IPCallFuncButton.f(this.lwD));
              IPCallFuncButton.a(this.lwD, false);
            }
            while (IPCallFuncButton.g(this.lwD) != null)
            {
              IPCallFuncButton.g(this.lwD).hb(IPCallFuncButton.e(this.lwD));
              return false;
              IPCallFuncButton.d(this.lwD).setImageDrawable(IPCallFuncButton.c(this.lwD));
              IPCallFuncButton.a(this.lwD, true);
            }
          }
        }
      } while (((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1)) || (IPCallFuncButton.b(this.lwD)));
      if (IPCallFuncButton.f(this.lwD) != null) {
        IPCallFuncButton.d(this.lwD).setImageDrawable(IPCallFuncButton.f(this.lwD));
      }
    } while (IPCallFuncButton.g(this.lwD) == null);
    IPCallFuncButton.g(this.lwD).hb(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.1
 * JD-Core Version:    0.7.0.1
 */