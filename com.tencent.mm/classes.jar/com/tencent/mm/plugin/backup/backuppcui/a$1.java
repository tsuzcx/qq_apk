package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.HashSet;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (a.a(this.hLd).contains(Integer.valueOf(this.kX))) {
      a.a(this.hLd).remove(Integer.valueOf(this.kX));
    }
    for (;;)
    {
      this.hLd.notifyDataSetChanged();
      a.b(this.hLd).a(a.a(this.hLd));
      return;
      a.a(this.hLd).add(Integer.valueOf(this.kX));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.a.1
 * JD-Core Version:    0.7.0.1
 */