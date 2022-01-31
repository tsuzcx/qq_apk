package com.tencent.mm.chatroom.ui;

import android.widget.ListView;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.HashMap;

final class SelectMemberUI$1
  implements VerticalScrollBar.a
{
  SelectMemberUI$1(SelectMemberUI paramSelectMemberUI) {}
  
  public final void eU(String paramString)
  {
    if ("↑".equals(paramString)) {
      SelectMemberUI.a(this.dsb).setSelection(0);
    }
    for (;;)
    {
      return;
      SelectMemberUI.b localb = this.dsb.drW;
      if (localb.dsf.containsKey(paramString)) {}
      for (int i = ((Integer)localb.dsf.get(paramString)).intValue(); i != -1; i = -1)
      {
        SelectMemberUI.a(this.dsb).setSelection(i);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.1
 * JD-Core Version:    0.7.0.1
 */