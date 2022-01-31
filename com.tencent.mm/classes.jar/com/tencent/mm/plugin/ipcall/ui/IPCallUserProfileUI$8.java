package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a;
import java.util.LinkedList;

final class IPCallUserProfileUI$8
  implements View.OnClickListener
{
  IPCallUserProfileUI$8(IPCallUserProfileUI paramIPCallUserProfileUI) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(12766, new Object[] { Integer.valueOf(3) });
    paramView = new a(this.lzF, new IPCallUserProfileUI.8.1(this));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(86));
    paramView.sbG = new IPCallUserProfileUI.8.2(this);
    paramView.b(IPCallUserProfileUI.c(this.lzF), localLinkedList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.8
 * JD-Core Version:    0.7.0.1
 */