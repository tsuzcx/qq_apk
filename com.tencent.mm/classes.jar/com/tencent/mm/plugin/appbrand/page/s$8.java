package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k.a.b;
import com.tencent.mm.plugin.appbrand.k.a.d;
import com.tencent.mm.plugin.report.service.h;

final class s$8
  implements a.b
{
  s$8(s params, boolean paramBoolean, r.b paramb, String paramString, bf parambf) {}
  
  public final void a(a.d paramd)
  {
    AppMethodBeat.i(155939);
    switch (s.2.hTG[paramd.ordinal()])
    {
    default: 
      AppMethodBeat.o(155939);
      return;
    case 1: 
      paramd = h.qsU;
      if (this.iwY) {}
      for (i = 6;; i = 2)
      {
        paramd.cT(937, i);
        this.iwT.runOnUiThread(new s.8.1(this));
        AppMethodBeat.o(155939);
        return;
      }
    case 2: 
      paramd = h.qsU;
      if (this.iwY) {}
      for (i = 8;; i = 4)
      {
        paramd.cT(937, i);
        this.iwT.runOnUiThread(new s.8.2(this));
        AppMethodBeat.o(155939);
        return;
      }
    }
    paramd = h.qsU;
    if (this.iwY) {}
    for (int i = 7;; i = 3)
    {
      paramd.cT(937, i);
      this.iwT.runOnUiThread(new s.8.3(this));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s.8
 * JD-Core Version:    0.7.0.1
 */