package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.protobuf.bcz;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class c$2
  implements b.c
{
  c$2(c paramc) {}
  
  public final void c(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(135895);
    Object localObject2 = this.njY;
    Object localObject1 = ((c)localObject2).njW;
    Context localContext = ((c)localObject2).njV.mContext;
    localObject2 = ((c)localObject2).njV;
    a locala = (a)((b)localObject1).njT.get(Integer.valueOf(paramMenuItem.getItemId()));
    Iterator localIterator = ((b)localObject1).njS.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (bcz)localIterator.next();
    } while ((localObject1 == null) || (((bcz)localObject1).wzE != paramMenuItem.getItemId()));
    for (paramMenuItem = (MenuItem)localObject1;; paramMenuItem = null)
    {
      if ((locala != null) && (paramMenuItem != null)) {
        locala.a(localContext, (com.tencent.mm.plugin.webview.luggage.e)localObject2, paramMenuItem);
      }
      this.njY.njX.cre();
      AppMethodBeat.o(135895);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.c.2
 * JD-Core Version:    0.7.0.1
 */