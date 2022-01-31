package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    if (System.currentTimeMillis() - a.e(this.hoL) < 250L)
    {
      this.val$listener.onClick(paramView);
      a.a(this.hoL, 0L);
    }
    a.a(this.hoL, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.a.4
 * JD-Core Version:    0.7.0.1
 */