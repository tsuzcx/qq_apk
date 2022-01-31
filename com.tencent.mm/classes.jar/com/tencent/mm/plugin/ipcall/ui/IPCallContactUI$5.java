package com.tencent.mm.plugin.ipcall.ui;

import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.q.b;

final class IPCallContactUI$5
  implements q.b
{
  IPCallContactUI$5(IPCallContactUI paramIPCallContactUI) {}
  
  public final void apN()
  {
    AppMethodBeat.i(22076);
    ab.d("MicroMsg.IPCallContactUI", "onQuitSearch");
    this.nSm.wQ("");
    this.nSm.iK(true);
    IPCallContactUI.a(this.nSm).setVisibility(8);
    IPCallContactUI.b(this.nSm).setVisibility(0);
    IPCallContactUI.c(this.nSm).setVisibility(0);
    AppMethodBeat.o(22076);
  }
  
  public final void apO()
  {
    AppMethodBeat.i(22075);
    ab.d("MicroMsg.IPCallContactUI", "onEnterSearch");
    h.qsU.e(12767, new Object[] { Integer.valueOf(1) });
    IPCallContactUI.a(this.nSm).setVisibility(0);
    IPCallContactUI.b(this.nSm).setVisibility(8);
    IPCallContactUI.c(this.nSm).setVisibility(8);
    this.nSm.iK(false);
    AppMethodBeat.o(22075);
  }
  
  public final void apP()
  {
    AppMethodBeat.i(22079);
    IPCallContactUI.a(this.nSm).setVisibility(0);
    IPCallContactUI.b(this.nSm).setVisibility(8);
    IPCallContactUI.c(this.nSm).setVisibility(8);
    AppMethodBeat.o(22079);
  }
  
  public final void apQ() {}
  
  public final boolean wR(String paramString)
  {
    AppMethodBeat.i(22078);
    ab.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
    AppMethodBeat.o(22078);
    return false;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(22077);
    ab.d("MicroMsg.IPCallContactUI", "onSearchChange");
    this.nSm.wQ(paramString);
    if (!bo.isNullOrNil(paramString))
    {
      IPCallContactUI.a(this.nSm).setVisibility(8);
      IPCallContactUI.b(this.nSm).setVisibility(0);
      IPCallContactUI.c(this.nSm).setVisibility(8);
    }
    AppMethodBeat.o(22077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.5
 * JD-Core Version:    0.7.0.1
 */