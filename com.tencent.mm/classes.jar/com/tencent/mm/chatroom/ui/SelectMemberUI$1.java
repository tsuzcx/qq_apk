package com.tencent.mm.chatroom.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.HashMap;

final class SelectMemberUI$1
  implements VerticalScrollBar.a
{
  SelectMemberUI$1(SelectMemberUI paramSelectMemberUI) {}
  
  public final void lf(String paramString)
  {
    AppMethodBeat.i(104407);
    if ("↑".equals(paramString))
    {
      SelectMemberUI.a(this.ejJ).setSelection(0);
      AppMethodBeat.o(104407);
      return;
    }
    SelectMemberUI.b localb = this.ejJ.ejE;
    if (localb.ejN.containsKey(paramString)) {}
    for (int i = ((Integer)localb.ejN.get(paramString)).intValue();; i = -1)
    {
      if (i != -1) {
        SelectMemberUI.a(this.ejJ).setSelection(i);
      }
      AppMethodBeat.o(104407);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.1
 * JD-Core Version:    0.7.0.1
 */