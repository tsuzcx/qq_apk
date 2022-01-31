package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class e$2
  implements View.OnKeyListener
{
  e$2(e parame) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.hpa.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.e.2
 * JD-Core Version:    0.7.0.1
 */