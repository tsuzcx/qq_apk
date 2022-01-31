package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.os.Looper;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.ipcall.a;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.sdk.platformtools.ah;

final class IPCallContactUI$2
  extends ah
{
  IPCallContactUI$2(IPCallContactUI paramIPCallContactUI, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (IPCallContactUI.k(this.luU) != null) {
        IPCallContactUI.k(this.luU).dismiss();
      }
      IPCallContactUI.l(this.luU).setVisibility(0);
      IPCallContactUI.d(this.luU);
      c.lsH = b.bcL();
      IPCallContactUI.d(this.luU).yc();
      IPCallContactUI.d(this.luU).notifyDataSetChanged();
      IPCallContactUI.b(this.luU).invalidateViews();
      IPCallContactUI.c(this.luU).setAddressCount(IPCallContactUI.d(this.luU).getCount());
      a.bbv().bbw();
    }
    for (;;)
    {
      return;
      if (paramMessage.what == 2)
      {
        if (IPCallContactUI.d(this.luU).getCount() == 0) {
          IPCallContactUI.m(this.luU).setVisibility(0);
        }
        while ((IPCallContactUI.d(this.luU).getCount() != 0) && (IPCallContactUI.e(this.luU)))
        {
          IPCallContactUI.d(this.luU).notifyDataSetChanged();
          return;
          IPCallContactUI.m(this.luU).setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.2
 * JD-Core Version:    0.7.0.1
 */