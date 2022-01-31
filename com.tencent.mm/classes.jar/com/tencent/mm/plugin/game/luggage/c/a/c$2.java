package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.c.awk;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class c$2
  implements b.c
{
  c$2(c paramc) {}
  
  public final void f(MenuItem paramMenuItem)
  {
    Object localObject2 = this.kNs;
    Object localObject1 = ((c)localObject2).kNq;
    Context localContext = ((c)localObject2).kMl.mContext;
    localObject2 = ((c)localObject2).kMl;
    a locala = (a)((b)localObject1).kNo.get(Integer.valueOf(paramMenuItem.getItemId()));
    Iterator localIterator = ((b)localObject1).kNn.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (awk)localIterator.next();
    } while ((localObject1 == null) || (((awk)localObject1).sYX != paramMenuItem.getItemId()));
    for (paramMenuItem = (MenuItem)localObject1;; paramMenuItem = null)
    {
      if ((locala != null) && (paramMenuItem != null)) {
        locala.a(localContext, (com.tencent.mm.plugin.webview.luggage.e)localObject2, paramMenuItem);
      }
      this.kNs.kNr.bFp();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.c.2
 * JD-Core Version:    0.7.0.1
 */