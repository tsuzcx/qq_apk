package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.ui.base.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  i CBJ;
  b CBK;
  public d CBL;
  
  public c(i parami, b paramb)
  {
    AppMethodBeat.i(83101);
    this.CBJ = parami;
    this.CBK = paramb;
    this.CBL = new d(this.CBJ.mContext);
    this.CBL.Qpx = new b.b()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(83099);
        Object localObject = c.this;
        b localb = ((c)localObject).CBK;
        localObject = ((c)localObject).CBJ;
        Iterator localIterator = localb.CBG.iterator();
        while (localIterator.hasNext())
        {
          cxc localcxc = (cxc)localIterator.next();
          if (localcxc == null)
          {
            paramAnonymouso.d(-1, "");
          }
          else
          {
            a locala = (a)localb.CBH.get(Integer.valueOf(localcxc.RXp));
            if (locala != null) {
              locala.a((g)localObject, paramAnonymouso, localcxc);
            }
          }
        }
        AppMethodBeat.o(83099);
      }
    };
    this.CBL.a(new b.c()
    {
      public final void d(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(83100);
        Object localObject2 = c.this;
        Object localObject1 = ((c)localObject2).CBK;
        Context localContext = ((c)localObject2).CBJ.mContext;
        localObject2 = ((c)localObject2).CBJ;
        a locala = (a)((b)localObject1).CBH.get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        Iterator localIterator = ((b)localObject1).CBG.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (cxc)localIterator.next();
        } while ((localObject1 == null) || (((cxc)localObject1).RXp != paramAnonymousMenuItem.getItemId()));
        for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
        {
          if ((locala != null) && (paramAnonymousMenuItem != null)) {
            locala.a(localContext, (g)localObject2, paramAnonymousMenuItem);
          }
          c.this.CBL.bYF();
          AppMethodBeat.o(83100);
          return;
        }
      }
    });
    this.CBL.eik();
    AppMethodBeat.o(83101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.c
 * JD-Core Version:    0.7.0.1
 */