package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;

final class FindMContactAddUI$8
  implements View.OnClickListener
{
  FindMContactAddUI$8(FindMContactAddUI paramFindMContactAddUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108521);
    paramView = new StringBuilder();
    g.RJ();
    paramView = paramView.append(com.tencent.mm.kernel.a.QX()).append(",").append(this.gzd.getClass().getName()).append(",R300_300_AddAllButton,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R300_300_AddAllButton") + ",3");
    if (FindMContactAddUI.e(this.gzd) == 2)
    {
      FindMContactAddUI.c(this.gzd).dw(true);
      FindMContactAddUI.c(this.gzd).notifyDataSetChanged();
      FindMContactAddUI.f(this.gzd).setVisibility(8);
      if (FindMContactAddUI.g(this.gzd) != null)
      {
        FindMContactAddUI.g(this.gzd).setVisibility(0);
        AppMethodBeat.o(108521);
      }
    }
    else
    {
      if (FindMContactAddUI.e(this.gzd) == 1)
      {
        FindMContactAddUI.c(this.gzd).dw(true);
        FindMContactAddUI.c(this.gzd).notifyDataSetChanged();
        FindMContactAddUI.i(this.gzd);
        AppMethodBeat.o(108521);
        return;
      }
      FindMContactAddUI.c(this.gzd).dw(true);
      FindMContactAddUI.c(this.gzd).notifyDataSetChanged();
      FindMContactAddUI.f(this.gzd).setVisibility(8);
      if (FindMContactAddUI.g(this.gzd) != null) {
        FindMContactAddUI.g(this.gzd).setVisibility(0);
      }
    }
    AppMethodBeat.o(108521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.8
 * JD-Core Version:    0.7.0.1
 */