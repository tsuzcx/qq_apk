package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;

final class FindMContactAddUI$8
  implements View.OnClickListener
{
  FindMContactAddUI$8(FindMContactAddUI paramFindMContactAddUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new StringBuilder();
    g.DN();
    paramView = paramView.append(com.tencent.mm.kernel.a.Df()).append(",").append(this.fhv.getClass().getName()).append(",R300_300_AddAllButton,");
    g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R300_300_AddAllButton") + ",3");
    if (FindMContactAddUI.e(this.fhv) == 2)
    {
      FindMContactAddUI.c(this.fhv).cu(true);
      FindMContactAddUI.c(this.fhv).notifyDataSetChanged();
      FindMContactAddUI.f(this.fhv).setVisibility(8);
      if (FindMContactAddUI.g(this.fhv) != null) {
        FindMContactAddUI.g(this.fhv).setVisibility(0);
      }
    }
    do
    {
      return;
      if (FindMContactAddUI.e(this.fhv) == 1)
      {
        FindMContactAddUI.c(this.fhv).cu(true);
        FindMContactAddUI.c(this.fhv).notifyDataSetChanged();
        FindMContactAddUI.i(this.fhv);
        return;
      }
      FindMContactAddUI.c(this.fhv).cu(true);
      FindMContactAddUI.c(this.fhv).notifyDataSetChanged();
      FindMContactAddUI.f(this.fhv).setVisibility(8);
    } while (FindMContactAddUI.g(this.fhv) == null);
    FindMContactAddUI.g(this.fhv).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.8
 * JD-Core Version:    0.7.0.1
 */