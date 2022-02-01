package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.u.i;

final class IPCallUserProfileUI$7
  implements u.i
{
  IPCallUserProfileUI$7(IPCallUserProfileUI paramIPCallUserProfileUI, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26000);
    if (paramInt == 0)
    {
      h.OAn.b(12766, new Object[] { Integer.valueOf(4) });
      c.aJF(this.JQs.getText().toString());
      Toast.makeText(this.JQq, R.l.gKB, 0).show();
    }
    AppMethodBeat.o(26000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.7
 * JD-Core Version:    0.7.0.1
 */