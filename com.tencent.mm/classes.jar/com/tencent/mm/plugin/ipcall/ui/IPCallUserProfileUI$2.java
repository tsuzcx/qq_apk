package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.h;

final class IPCallUserProfileUI$2
  implements View.OnClickListener
{
  IPCallUserProfileUI$2(IPCallUserProfileUI paramIPCallUserProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22372);
    h.qsU.e(12766, new Object[] { Integer.valueOf(4) });
    c.RL(IPCallUserProfileUI.f(this.nWR));
    Toast.makeText(this.nWR, 2131300863, 0).show();
    AppMethodBeat.o(22372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.2
 * JD-Core Version:    0.7.0.1
 */