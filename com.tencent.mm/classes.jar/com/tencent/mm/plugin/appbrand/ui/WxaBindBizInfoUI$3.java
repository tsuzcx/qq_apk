package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.protocal.c.anh;
import com.tencent.mm.protocal.c.ani;

final class WxaBindBizInfoUI$3
  implements LoadMoreRecyclerView.a
{
  WxaBindBizInfoUI$3(WxaBindBizInfoUI paramWxaBindBizInfoUI) {}
  
  public final void apj()
  {
    anh localanh = new anh();
    localanh.bOL = WxaBindBizInfoUI.a(this.heJ);
    localanh.tjq = WxaBindBizInfoUI.b(this.heJ);
    b.a locala = new b.a();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getwxabindbizinfo";
    locala.ecG = 1823;
    locala.ecH = localanh;
    locala.ecI = new ani();
    w.a(locala.Kt(), new WxaBindBizInfoUI.3.1(this), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI.3
 * JD-Core Version:    0.7.0.1
 */