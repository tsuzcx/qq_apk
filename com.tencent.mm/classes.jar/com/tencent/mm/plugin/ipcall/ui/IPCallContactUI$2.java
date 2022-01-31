package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.os.Looper;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.sdk.platformtools.ak;

final class IPCallContactUI$2
  extends ak
{
  IPCallContactUI$2(IPCallContactUI paramIPCallContactUI, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(22072);
    if (paramMessage.what == 1)
    {
      if (IPCallContactUI.k(this.nSm) != null) {
        IPCallContactUI.k(this.nSm).dismiss();
      }
      IPCallContactUI.l(this.nSm).setVisibility(0);
      IPCallContactUI.d(this.nSm);
      c.nQb = b.bJS();
      IPCallContactUI.d(this.nSm).Ku();
      IPCallContactUI.d(this.nSm).notifyDataSetChanged();
      IPCallContactUI.b(this.nSm).invalidateViews();
      IPCallContactUI.c(this.nSm).setAddressCount(IPCallContactUI.d(this.nSm).getCount());
      a.bID().bIE();
      AppMethodBeat.o(22072);
      return;
    }
    if (paramMessage.what == 2)
    {
      if (IPCallContactUI.d(this.nSm).getCount() != 0) {
        break label194;
      }
      IPCallContactUI.m(this.nSm).setVisibility(0);
    }
    for (;;)
    {
      if ((IPCallContactUI.d(this.nSm).getCount() != 0) && (IPCallContactUI.e(this.nSm))) {
        IPCallContactUI.d(this.nSm).notifyDataSetChanged();
      }
      AppMethodBeat.o(22072);
      return;
      label194:
      IPCallContactUI.m(this.nSm).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.2
 * JD-Core Version:    0.7.0.1
 */