package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import java.util.HashSet;

final class SelectMemberUI$b$4
  implements View.OnClickListener
{
  SelectMemberUI$b$4(SelectMemberUI.b paramb, SelectMemberUI.c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104416);
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = this.ejO.iD(i);
    if (this.ejO.ejJ.Kl().contains(paramView.contact.field_username))
    {
      AppMethodBeat.o(104416);
      return;
    }
    if (this.ejO.ejJ.ejG.contains(paramView.contact.field_username))
    {
      this.ejO.ejJ.ejG.remove(paramView.contact.field_username);
      this.ejQ.ejU.setImageResource(2131231142);
      this.ejO.ejJ.v(i, false);
      AppMethodBeat.o(104416);
      return;
    }
    this.ejO.ejJ.ejG.add(paramView.contact.field_username);
    this.ejQ.ejU.setImageResource(2131231137);
    this.ejO.ejJ.v(i, true);
    AppMethodBeat.o(104416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.b.4
 * JD-Core Version:    0.7.0.1
 */