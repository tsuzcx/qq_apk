package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.ui.base.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  com.tencent.mm.plugin.game.luggage.d.f sXx;
  b sXy;
  public d sXz;
  
  public c(com.tencent.mm.plugin.game.luggage.d.f paramf, b paramb)
  {
    AppMethodBeat.i(83101);
    this.sXx = paramf;
    this.sXy = paramb;
    this.sXz = new d(this.sXx.mContext);
    this.sXz.CGG = new b.b()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(83099);
        Object localObject = c.this;
        b localb = ((c)localObject).sXy;
        localObject = ((c)localObject).sXx;
        Iterator localIterator = localb.sXu.iterator();
        while (localIterator.hasNext())
        {
          bug localbug = (bug)localIterator.next();
          if (localbug == null)
          {
            paramAnonymousl.c(-1, "");
          }
          else
          {
            a locala = (a)localb.sXv.get(Integer.valueOf(localbug.Edq));
            if (locala != null) {
              locala.a((com.tencent.mm.plugin.webview.luggage.f)localObject, paramAnonymousl, localbug);
            }
          }
        }
        AppMethodBeat.o(83099);
      }
    };
    this.sXz.a(new b.c()
    {
      public final void c(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(83100);
        Object localObject2 = c.this;
        Object localObject1 = ((c)localObject2).sXy;
        Context localContext = ((c)localObject2).sXx.mContext;
        localObject2 = ((c)localObject2).sXx;
        a locala = (a)((b)localObject1).sXv.get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        Iterator localIterator = ((b)localObject1).sXu.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (bug)localIterator.next();
        } while ((localObject1 == null) || (((bug)localObject1).Edq != paramAnonymousMenuItem.getItemId()));
        for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
        {
          if ((locala != null) && (paramAnonymousMenuItem != null)) {
            locala.a(localContext, (com.tencent.mm.plugin.webview.luggage.f)localObject2, paramAnonymousMenuItem);
          }
          c.this.sXz.bmi();
          AppMethodBeat.o(83100);
          return;
        }
      }
    });
    this.sXz.cED();
    AppMethodBeat.o(83101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.c
 * JD-Core Version:    0.7.0.1
 */