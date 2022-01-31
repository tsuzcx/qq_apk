package com.tencent.mm.plugin.backup.backuppcui;

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
    AppMethodBeat.i(17567);
    if (a.a(this.jEG).contains(Integer.valueOf(this.lU))) {
      a.a(this.jEG).remove(Integer.valueOf(this.lU));
    }
    for (;;)
    {
      this.jEG.notifyDataSetChanged();
      a.b(this.jEG).a(a.a(this.jEG));
      AppMethodBeat.o(17567);
      return;
      a.a(this.jEG).add(Integer.valueOf(this.lU));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.a.1
 * JD-Core Version:    0.7.0.1
 */