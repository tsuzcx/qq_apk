package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;

final class BaseFavDetailReportUI$3
  implements Runnable
{
  BaseFavDetailReportUI$3(BaseFavDetailReportUI paramBaseFavDetailReportUI) {}
  
  public final void run()
  {
    this.kfb.keY.jYT = (((ae)g.t(ae.class)).getFavItemInfoStorage().qZ((int)this.kfb.keY.jYG) + 1);
    h.a(this.kfb.keY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI.3
 * JD-Core Version:    0.7.0.1
 */