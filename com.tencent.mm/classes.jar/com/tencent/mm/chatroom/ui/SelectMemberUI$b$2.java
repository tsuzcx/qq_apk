package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class SelectMemberUI$b$2
  implements Runnable
{
  SelectMemberUI$b$2(SelectMemberUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(104414);
    this.ejO.notifyDataSetChanged();
    if ((SelectMemberUI.b.b(this.ejO) != null) && (SelectMemberUI.b.b(this.ejO).size() == 0))
    {
      SelectMemberUI.a(this.ejO.ejJ).setVisibility(8);
      SelectMemberUI.d(this.ejO.ejJ).setVisibility(0);
      AppMethodBeat.o(104414);
      return;
    }
    SelectMemberUI.a(this.ejO.ejJ).setVisibility(0);
    SelectMemberUI.d(this.ejO.ejJ).setVisibility(8);
    AppMethodBeat.o(104414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.b.2
 * JD-Core Version:    0.7.0.1
 */