package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.HashSet;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (a.a(this.iDV).contains(Integer.valueOf(this.kX))) {
      a.a(this.iDV).remove(Integer.valueOf(this.kX));
    }
    for (;;)
    {
      this.iDV.notifyDataSetChanged();
      a.b(this.iDV).a(a.a(this.iDV));
      return;
      a.a(this.iDV).add(Integer.valueOf(this.kX));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.a.1
 * JD-Core Version:    0.7.0.1
 */