package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.address.model.a;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;

final class InvoiceListUI$3$1
  implements h.c
{
  InvoiceListUI$3$1(InvoiceListUI.3 param3, int paramInt) {}
  
  public final void gl(int paramInt)
  {
    for (;;)
    {
      synchronized (InvoiceListUI.b(this.fuM.fuL))
      {
        if (this.kX >= InvoiceListUI.c(this.fuM.fuL).size()) {
          break label154;
        }
        b localb = (b)InvoiceListUI.c(this.fuM.fuL).get(this.kX);
        if (localb == null) {
          return;
        }
      }
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        InvoiceListUI.a(this.fuM.fuL, localObject1.lnP);
        return;
      case 1: 
        locala = new a(localObject1.lnP);
        InvoiceListUI.a(this.fuM.fuL, null);
        au.Dk().a(locala, 0);
        return;
      }
      InvoiceListUI.b(this.fuM.fuL, locala);
      return;
      label154:
      a locala = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI.3.1
 * JD-Core Version:    0.7.0.1
 */