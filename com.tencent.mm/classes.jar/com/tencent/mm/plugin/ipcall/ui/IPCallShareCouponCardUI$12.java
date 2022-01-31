package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.LinkedList;

final class IPCallShareCouponCardUI$12
  implements n.c
{
  IPCallShareCouponCardUI$12(IPCallShareCouponCardUI paramIPCallShareCouponCardUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(22294);
    Iterator localIterator = IPCallShareCouponCardUI.a(this.nVC, IPCallShareCouponCardUI.b(this.nVC).ydK).iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      String str = IPCallShareCouponCardUI.R(this.nVC.getContext(), localInteger.intValue());
      int i = IPCallShareCouponCardUI.xT(localInteger.intValue());
      if ((str != null) && (i != -1)) {
        paraml.a(localInteger.intValue(), str, i);
      }
    }
    AppMethodBeat.o(22294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.12
 * JD-Core Version:    0.7.0.1
 */