package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class p$1
  implements n.c
{
  p$1(p paramp) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(87071);
    Iterator localIterator = this.iwe.iwd.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if ((localq != null) && (!localq.iqO))
      {
        Context localContext = this.iwe.bBK.getContext();
        v localv = this.iwe.bBK;
        String str = this.iwe.mAppId;
        if (localq != null) {
          localq.iqP.a(localContext, localv, paraml, str);
        }
      }
    }
    AppMethodBeat.o(87071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.p.1
 * JD-Core Version:    0.7.0.1
 */