package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mm.h.c.ao;
import java.util.HashSet;

final class SelectMemberUI$b$4
  implements View.OnClickListener
{
  SelectMemberUI$b$4(SelectMemberUI.b paramb, SelectMemberUI.c paramc) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = this.dsg.go(i);
    if (this.dsg.dsb.xT().contains(paramView.dnp.field_username)) {
      return;
    }
    if (this.dsg.dsb.drY.contains(paramView.dnp.field_username))
    {
      this.dsg.dsb.drY.remove(paramView.dnp.field_username);
      this.dsi.dsm.setImageResource(a.h.checkbox_unselected);
      this.dsg.dsb.u(i, false);
      return;
    }
    this.dsg.dsb.drY.add(paramView.dnp.field_username);
    this.dsi.dsm.setImageResource(a.h.checkbox_selected);
    this.dsg.dsb.u(i, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.b.4
 * JD-Core Version:    0.7.0.1
 */