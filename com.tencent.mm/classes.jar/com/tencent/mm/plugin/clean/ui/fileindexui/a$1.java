package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.HashSet;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (a.a(this.iCz).contains(Integer.valueOf(this.kX))) {
      a.a(this.iCz).remove(Integer.valueOf(this.kX));
    }
    for (;;)
    {
      this.iCz.notifyDataSetChanged();
      a.b(this.iCz).a(a.a(this.iCz));
      return;
      a.a(this.iCz).add(Integer.valueOf(this.kX));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.a.1
 * JD-Core Version:    0.7.0.1
 */