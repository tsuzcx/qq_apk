package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.protocal.c.chu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;

final class IPCallShareCouponCardUI$12
  implements n.c
{
  IPCallShareCouponCardUI$12(IPCallShareCouponCardUI paramIPCallShareCouponCardUI) {}
  
  public final void a(l paraml)
  {
    Iterator localIterator = IPCallShareCouponCardUI.a(this.lyq, IPCallShareCouponCardUI.b(this.lyq).tWu).iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      String str = IPCallShareCouponCardUI.F(this.lyq.mController.uMN, localInteger.intValue());
      int i = IPCallShareCouponCardUI.sR(localInteger.intValue());
      if ((str != null) && (i != -1)) {
        paraml.a(localInteger.intValue(), str, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.12
 * JD-Core Version:    0.7.0.1
 */