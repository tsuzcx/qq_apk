package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.ui.base.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  com.tencent.mm.plugin.game.luggage.f.g ufp;
  b ufq;
  public d ufr;
  
  public c(com.tencent.mm.plugin.game.luggage.f.g paramg, b paramb)
  {
    AppMethodBeat.i(83101);
    this.ufp = paramg;
    this.ufq = paramb;
    this.ufr = new d(this.ufp.mContext);
    this.ufr.ECw = new b.b()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(83099);
        Object localObject = c.this;
        b localb = ((c)localObject).ufq;
        localObject = ((c)localObject).ufp;
        Iterator localIterator = localb.ufm.iterator();
        while (localIterator.hasNext())
        {
          bzp localbzp = (bzp)localIterator.next();
          if (localbzp == null)
          {
            paramAnonymousl.d(-1, "");
          }
          else
          {
            a locala = (a)localb.ufn.get(Integer.valueOf(localbzp.GbY));
            if (locala != null) {
              locala.a((com.tencent.mm.plugin.webview.luggage.g)localObject, paramAnonymousl, localbzp);
            }
          }
        }
        AppMethodBeat.o(83099);
      }
    };
    this.ufr.a(new b.c()
    {
      public final void c(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(83100);
        Object localObject2 = c.this;
        Object localObject1 = ((c)localObject2).ufq;
        Context localContext = ((c)localObject2).ufp.mContext;
        localObject2 = ((c)localObject2).ufp;
        a locala = (a)((b)localObject1).ufn.get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        Iterator localIterator = ((b)localObject1).ufm.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (bzp)localIterator.next();
        } while ((localObject1 == null) || (((bzp)localObject1).GbY != paramAnonymousMenuItem.getItemId()));
        for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
        {
          if ((locala != null) && (paramAnonymousMenuItem != null)) {
            locala.a(localContext, (com.tencent.mm.plugin.webview.luggage.g)localObject2, paramAnonymousMenuItem);
          }
          c.this.ufr.bqD();
          AppMethodBeat.o(83100);
          return;
        }
      }
    });
    this.ufr.cPF();
    AppMethodBeat.o(83101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.c
 * JD-Core Version:    0.7.0.1
 */