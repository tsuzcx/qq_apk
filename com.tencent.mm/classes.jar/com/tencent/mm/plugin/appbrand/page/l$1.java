package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class l$1
  implements n.c
{
  l$1(l paraml) {}
  
  public final void a(com.tencent.mm.ui.base.l paraml)
  {
    Iterator localIterator = this.gSR.gSQ.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if ((localn != null) && (!localn.gPg))
      {
        Context localContext = this.gSR.gSP.mContext;
        q localq = this.gSR.gSP;
        String str = this.gSR.mAppId;
        if (localn != null) {
          localn.gPh.a(localContext, localq, paraml, str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.l.1
 * JD-Core Version:    0.7.0.1
 */