package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.ui.base.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  com.tencent.mm.plugin.game.luggage.f.g tUx;
  b tUy;
  public d tUz;
  
  public c(com.tencent.mm.plugin.game.luggage.f.g paramg, b paramb)
  {
    AppMethodBeat.i(83101);
    this.tUx = paramg;
    this.tUy = paramb;
    this.tUz = new d(this.tUx.mContext);
    this.tUz.Eks = new b.b()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(83099);
        Object localObject = c.this;
        b localb = ((c)localObject).tUy;
        localObject = ((c)localObject).tUx;
        Iterator localIterator = localb.tUu.iterator();
        while (localIterator.hasNext())
        {
          byv localbyv = (byv)localIterator.next();
          if (localbyv == null)
          {
            paramAnonymousl.c(-1, "");
          }
          else
          {
            a locala = (a)localb.tUv.get(Integer.valueOf(localbyv.FJz));
            if (locala != null) {
              locala.a((com.tencent.mm.plugin.webview.luggage.g)localObject, paramAnonymousl, localbyv);
            }
          }
        }
        AppMethodBeat.o(83099);
      }
    };
    this.tUz.a(new b.c()
    {
      public final void c(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(83100);
        Object localObject2 = c.this;
        Object localObject1 = ((c)localObject2).tUy;
        Context localContext = ((c)localObject2).tUx.mContext;
        localObject2 = ((c)localObject2).tUx;
        a locala = (a)((b)localObject1).tUv.get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        Iterator localIterator = ((b)localObject1).tUu.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (byv)localIterator.next();
        } while ((localObject1 == null) || (((byv)localObject1).FJz != paramAnonymousMenuItem.getItemId()));
        for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
        {
          if ((locala != null) && (paramAnonymousMenuItem != null)) {
            locala.a(localContext, (com.tencent.mm.plugin.webview.luggage.g)localObject2, paramAnonymousMenuItem);
          }
          c.this.tUz.bpT();
          AppMethodBeat.o(83100);
          return;
        }
      }
    });
    this.tUz.cMW();
    AppMethodBeat.o(83101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.c
 * JD-Core Version:    0.7.0.1
 */