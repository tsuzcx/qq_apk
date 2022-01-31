package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.n.d;

final class IPCallUserProfileUI$7
  implements n.d
{
  IPCallUserProfileUI$7(IPCallUserProfileUI paramIPCallUserProfileUI, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(22377);
    if (paramInt == 0)
    {
      h.qsU.e(12766, new Object[] { Integer.valueOf(4) });
      c.RL(this.nWT.getText().toString());
      Toast.makeText(this.nWR, 2131300863, 0).show();
    }
    AppMethodBeat.o(22377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.7
 * JD-Core Version:    0.7.0.1
 */