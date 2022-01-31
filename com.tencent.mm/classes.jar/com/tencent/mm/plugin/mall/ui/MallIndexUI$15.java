package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.h.a.ti;
import com.tencent.mm.h.a.ti.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.e;

final class MallIndexUI$15
  implements Runnable
{
  MallIndexUI$15(MallIndexUI paramMallIndexUI, ti paramti) {}
  
  public final void run()
  {
    if (!bk.bl(this.iLQ.ccV.ccW))
    {
      e.a(this.mau.lZy, this.iLQ.ccV.ccW, this.iLQ.ccV.content, this.iLQ.ccV.url);
      this.mau.bgH();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.15
 * JD-Core Version:    0.7.0.1
 */