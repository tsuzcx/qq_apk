package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.r.a;

final class IPCallMsgUI$3
  implements r.a
{
  IPCallMsgUI$3(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final void Wp()
  {
    if (IPCallMsgUI.b(this.lwI).getCount() == 0)
    {
      IPCallMsgUI.a(this.lwI).setVisibility(8);
      IPCallMsgUI.c(this.lwI).setVisibility(0);
      return;
    }
    IPCallMsgUI.a(this.lwI).setVisibility(0);
    IPCallMsgUI.c(this.lwI).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.3
 * JD-Core Version:    0.7.0.1
 */