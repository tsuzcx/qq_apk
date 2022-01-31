package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$6
  implements View.OnClickListener
{
  g$6(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22156);
    g.a locala = (g.a)paramView.getTag();
    if (!locala.nTG) {}
    for (locala.nTG = true;; locala.nTG = false)
    {
      g.a(this.nTF, (TextView)paramView);
      AppMethodBeat.o(22156);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g.6
 * JD-Core Version:    0.7.0.1
 */