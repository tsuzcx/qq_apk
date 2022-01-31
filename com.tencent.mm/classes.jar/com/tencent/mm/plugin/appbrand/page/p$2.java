package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.d;
import java.util.Iterator;
import java.util.List;

final class p$2
  implements n.d
{
  p$2(p paramp) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(87072);
    Object localObject = this.iwe.iwd;
    paramInt = paramMenuItem.getItemId();
    localObject = ((List)localObject).iterator();
    v localv;
    String str;
    while (((Iterator)localObject).hasNext())
    {
      paramMenuItem = (q)((Iterator)localObject).next();
      if (paramMenuItem.id == paramInt)
      {
        localObject = this.iwe.bBK.getContext();
        localv = this.iwe.bBK;
        str = this.iwe.mAppId;
        if (paramMenuItem != null) {
          break label114;
        }
      }
    }
    for (paramInt = 0;; paramInt = 1)
    {
      if (paramInt != 0) {
        this.iwe.iwc.cre();
      }
      AppMethodBeat.o(87072);
      return;
      paramMenuItem = null;
      break;
      label114:
      paramMenuItem.iqP.a((Context)localObject, localv, str, paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.p.2
 * JD-Core Version:    0.7.0.1
 */