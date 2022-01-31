package com.tencent.mm.plugin.ipcall.ui;

import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.n.b;

final class IPCallContactUI$5
  implements n.b
{
  IPCallContactUI$5(IPCallContactUI paramIPCallContactUI) {}
  
  public final void Wl()
  {
    y.d("MicroMsg.IPCallContactUI", "onQuitSearch");
    this.luU.pA("");
    this.luU.ha(true);
    IPCallContactUI.a(this.luU).setVisibility(8);
    IPCallContactUI.b(this.luU).setVisibility(0);
    IPCallContactUI.c(this.luU).setVisibility(0);
  }
  
  public final void Wm()
  {
    y.d("MicroMsg.IPCallContactUI", "onEnterSearch");
    h.nFQ.f(12767, new Object[] { Integer.valueOf(1) });
    IPCallContactUI.a(this.luU).setVisibility(0);
    IPCallContactUI.b(this.luU).setVisibility(8);
    IPCallContactUI.c(this.luU).setVisibility(8);
    this.luU.ha(false);
  }
  
  public final void Wn()
  {
    IPCallContactUI.a(this.luU).setVisibility(0);
    IPCallContactUI.b(this.luU).setVisibility(8);
    IPCallContactUI.c(this.luU).setVisibility(8);
  }
  
  public final void Wo() {}
  
  public final boolean pB(String paramString)
  {
    y.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
    return false;
  }
  
  public final void pC(String paramString)
  {
    y.d("MicroMsg.IPCallContactUI", "onSearchChange");
    this.luU.pA(paramString);
    if (!bk.bl(paramString))
    {
      IPCallContactUI.a(this.luU).setVisibility(8);
      IPCallContactUI.b(this.luU).setVisibility(0);
      IPCallContactUI.c(this.luU).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.5
 * JD-Core Version:    0.7.0.1
 */