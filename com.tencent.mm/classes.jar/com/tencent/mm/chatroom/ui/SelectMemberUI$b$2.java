package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.ListView;
import java.util.List;

final class SelectMemberUI$b$2
  implements Runnable
{
  SelectMemberUI$b$2(SelectMemberUI.b paramb) {}
  
  public final void run()
  {
    this.dsg.notifyDataSetChanged();
    if ((SelectMemberUI.b.b(this.dsg) != null) && (SelectMemberUI.b.b(this.dsg).size() == 0))
    {
      SelectMemberUI.a(this.dsg.dsb).setVisibility(8);
      SelectMemberUI.d(this.dsg.dsb).setVisibility(0);
      return;
    }
    SelectMemberUI.a(this.dsg.dsb).setVisibility(0);
    SelectMemberUI.d(this.dsg.dsb).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.b.2
 * JD-Core Version:    0.7.0.1
 */