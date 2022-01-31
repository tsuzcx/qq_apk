package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.HashSet;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (a.a(this.hIT).contains(Integer.valueOf(this.kX))) {
      a.a(this.hIT).remove(Integer.valueOf(this.kX));
    }
    for (;;)
    {
      this.hIT.notifyDataSetChanged();
      a.b(this.hIT).a(a.a(this.hIT));
      return;
      a.a(this.hIT).add(Integer.valueOf(this.kX));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.a.1
 * JD-Core Version:    0.7.0.1
 */