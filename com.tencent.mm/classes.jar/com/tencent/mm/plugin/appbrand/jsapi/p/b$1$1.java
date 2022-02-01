package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Map;

final class b$1$1
  implements n.c
{
  b$1$1(b.1 param1, e parame, Map paramMap, int paramInt) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(138254);
    this.idS.setFooterView(null);
    paraml.clear();
    int i = 0;
    if (i < this.khv.val$list.size())
    {
      if (this.kht.containsKey(Integer.valueOf(i))) {
        paraml.a(i, (CharSequence)this.khv.val$list.get(i), true);
      }
      for (;;)
      {
        i += 1;
        break;
        paraml.a(i, this.khu, (CharSequence)this.khv.val$list.get(i));
      }
    }
    AppMethodBeat.o(138254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.b.1.1
 * JD-Core Version:    0.7.0.1
 */