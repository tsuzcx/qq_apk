package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  b IvA;
  public d IvB;
  GameWebPage Ivz;
  
  public c(GameWebPage paramGameWebPage, b paramb)
  {
    AppMethodBeat.i(83101);
    this.Ivz = paramGameWebPage;
    this.IvA = paramb;
    this.IvB = new d(this.Ivz.mContext);
    this.IvB.XhL = new b.b()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(83099);
        Object localObject = c.this;
        b localb = ((c)localObject).IvA;
        localObject = ((c)localObject).Ivz;
        Iterator localIterator = localb.Ivw.iterator();
        while (localIterator.hasNext())
        {
          doh localdoh = (doh)localIterator.next();
          if (localdoh == null)
          {
            paramAnonymouss.c(-1, "");
          }
          else
          {
            a locala = (a)localb.Ivx.get(Integer.valueOf(localdoh.YVh));
            if (locala != null) {
              locala.a((g)localObject, paramAnonymouss, localdoh);
            }
          }
        }
        AppMethodBeat.o(83099);
      }
    };
    this.IvB.a(new b.c()
    {
      public final void f(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(83100);
        Object localObject2 = c.this;
        Object localObject1 = ((c)localObject2).IvA;
        Context localContext = ((c)localObject2).Ivz.mContext;
        localObject2 = ((c)localObject2).Ivz;
        a locala = (a)((b)localObject1).Ivx.get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        Iterator localIterator = ((b)localObject1).Ivw.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (doh)localIterator.next();
        } while ((localObject1 == null) || (((doh)localObject1).YVh != paramAnonymousMenuItem.getItemId()));
        for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
        {
          if ((locala != null) && (paramAnonymousMenuItem != null)) {
            locala.a(localContext, (g)localObject2, paramAnonymousMenuItem);
          }
          c.this.IvB.cyW();
          AppMethodBeat.o(83100);
          return;
        }
      }
    });
    this.IvB.dDn();
    AppMethodBeat.o(83101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.c
 * JD-Core Version:    0.7.0.1
 */