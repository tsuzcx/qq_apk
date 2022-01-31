package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Paint;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.cb.a;

final class IPCallCountryCodeScrollbar$1
  implements Runnable
{
  IPCallCountryCodeScrollbar$1(IPCallCountryCodeScrollbar paramIPCallCountryCodeScrollbar, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if (this.lvo.lvg.length <= 0) {}
    int i;
    do
    {
      return;
      i = (int)IPCallCountryCodeScrollbar.a(this.lvo).measureText(this.lvo.lvg[(this.lvo.lvg.length - 1)]) + a.fromDPToPix(this.lvo.getContext(), 8);
    } while (i <= this.lvn);
    ViewGroup.LayoutParams localLayoutParams = this.lvo.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = this.fa;
    this.lvo.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar.1
 * JD-Core Version:    0.7.0.1
 */