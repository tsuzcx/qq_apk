package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.d;
import java.util.Iterator;
import java.util.List;

final class l$2
  implements n.d
{
  l$2(l paraml) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    Object localObject = this.gSR.gSQ;
    paramInt = paramMenuItem.getItemId();
    localObject = ((List)localObject).iterator();
    q localq;
    String str;
    while (((Iterator)localObject).hasNext())
    {
      paramMenuItem = (n)((Iterator)localObject).next();
      if (paramMenuItem.id == paramInt)
      {
        localObject = this.gSR.gSP.mContext;
        localq = this.gSR.gSP;
        str = this.gSR.mAppId;
        if (paramMenuItem != null) {
          break label104;
        }
      }
    }
    for (paramInt = 0;; paramInt = 1)
    {
      if (paramInt != 0) {
        this.gSR.gSO.bFp();
      }
      return;
      paramMenuItem = null;
      break;
      label104:
      paramMenuItem.gPh.a((Context)localObject, localq, str, paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.l.2
 * JD-Core Version:    0.7.0.1
 */