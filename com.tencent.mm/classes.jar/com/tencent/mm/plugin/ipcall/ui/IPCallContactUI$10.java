package com.tencent.mm.plugin.ipcall.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class IPCallContactUI$10
  implements Runnable
{
  IPCallContactUI$10(IPCallContactUI paramIPCallContactUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(22084);
    if ((IPCallContactUI.d(this.nSm) != null) && (IPCallContactUI.b(this.nSm) != null) && (!IPCallContactUI.d(this.nSm).jTS))
    {
      IPCallContactUI.d(this.nSm).wQ(IPCallContactUI.h(this.nSm));
      IPCallContactUI.f(this.nSm).sendEmptyMessage(2);
      IPCallContactUI.b(this.nSm).invalidateViews();
    }
    AppMethodBeat.o(22084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.10
 * JD-Core Version:    0.7.0.1
 */