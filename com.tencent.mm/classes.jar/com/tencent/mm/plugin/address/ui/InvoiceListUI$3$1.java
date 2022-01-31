package com.tencent.mm.plugin.address.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.address.model.a;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;

final class InvoiceListUI$3$1
  implements h.c
{
  InvoiceListUI$3$1(InvoiceListUI.3 param3, int paramInt) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(16859);
    for (;;)
    {
      synchronized (InvoiceListUI.b(this.gMo.gMn))
      {
        if (this.lU >= InvoiceListUI.c(this.gMo.gMn).size()) {
          break label194;
        }
        b localb = (b)InvoiceListUI.c(this.gMo.gMn).get(this.lU);
        if (localb == null)
        {
          AppMethodBeat.o(16859);
          return;
        }
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(16859);
        return;
        InvoiceListUI.a(this.gMo.gMn, localObject1.nLm);
        AppMethodBeat.o(16859);
        return;
        locala = new a(localObject1.nLm);
        InvoiceListUI.a(this.gMo.gMn, null);
        aw.Rc().a(locala, 0);
        AppMethodBeat.o(16859);
        return;
        InvoiceListUI.b(this.gMo.gMn, locala);
      }
      label194:
      a locala = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI.3.1
 * JD-Core Version:    0.7.0.1
 */