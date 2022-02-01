package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.q.g;

final class IPCallUserProfileUI$7
  implements q.g
{
  IPCallUserProfileUI$7(IPCallUserProfileUI paramIPCallUserProfileUI, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26000);
    if (paramInt == 0)
    {
      h.IzE.a(12766, new Object[] { Integer.valueOf(4) });
      c.aML(this.DZk.getText().toString());
      Toast.makeText(this.DZi, R.l.eIU, 0).show();
    }
    AppMethodBeat.o(26000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.7
 * JD-Core Version:    0.7.0.1
 */