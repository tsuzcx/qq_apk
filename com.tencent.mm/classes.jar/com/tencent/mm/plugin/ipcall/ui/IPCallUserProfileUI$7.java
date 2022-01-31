package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.n.d;

final class IPCallUserProfileUI$7
  implements n.d
{
  IPCallUserProfileUI$7(IPCallUserProfileUI paramIPCallUserProfileUI, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (paramInt == 0)
    {
      h.nFQ.f(12766, new Object[] { Integer.valueOf(4) });
      c.c(this.lzF, this.lzH.getText().toString());
      Toast.makeText(this.lzF, R.l.ip_call_phonenumber_pasted, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.7
 * JD-Core Version:    0.7.0.1
 */