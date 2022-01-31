package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17318);
    if (a.a(this.jCt).contains(Integer.valueOf(this.lU))) {
      a.a(this.jCt).remove(Integer.valueOf(this.lU));
    }
    for (;;)
    {
      this.jCt.notifyDataSetChanged();
      a.b(this.jCt).a(a.a(this.jCt));
      AppMethodBeat.o(17318);
      return;
      a.a(this.jCt).add(Integer.valueOf(this.lU));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.a.1
 * JD-Core Version:    0.7.0.1
 */