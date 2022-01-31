package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.h;

final class IPCallUserProfileUI$2
  implements View.OnClickListener
{
  IPCallUserProfileUI$2(IPCallUserProfileUI paramIPCallUserProfileUI) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(12766, new Object[] { Integer.valueOf(4) });
    c.c(this.lzF, IPCallUserProfileUI.f(this.lzF));
    Toast.makeText(this.lzF, R.l.ip_call_phonenumber_pasted, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.2
 * JD-Core Version:    0.7.0.1
 */