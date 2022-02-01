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
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.ui.base.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  i xxA;
  b xxB;
  public d xxC;
  
  public c(i parami, b paramb)
  {
    AppMethodBeat.i(83101);
    this.xxA = parami;
    this.xxB = paramb;
    this.xxC = new d(this.xxA.mContext);
    this.xxC.Jsa = new b.b()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(83099);
        Object localObject = c.this;
        b localb = ((c)localObject).xxB;
        localObject = ((c)localObject).xxA;
        Iterator localIterator = localb.xxx.iterator();
        while (localIterator.hasNext())
        {
          coq localcoq = (coq)localIterator.next();
          if (localcoq == null)
          {
            paramAnonymousm.d(-1, "");
          }
          else
          {
            a locala = (a)localb.xxy.get(Integer.valueOf(localcoq.KWb));
            if (locala != null) {
              locala.a((g)localObject, paramAnonymousm, localcoq);
            }
          }
        }
        AppMethodBeat.o(83099);
      }
    };
    this.xxC.a(new b.c()
    {
      public final void c(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(83100);
        Object localObject2 = c.this;
        Object localObject1 = ((c)localObject2).xxB;
        Context localContext = ((c)localObject2).xxA.mContext;
        localObject2 = ((c)localObject2).xxA;
        a locala = (a)((b)localObject1).xxy.get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        Iterator localIterator = ((b)localObject1).xxx.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (coq)localIterator.next();
        } while ((localObject1 == null) || (((coq)localObject1).KWb != paramAnonymousMenuItem.getItemId()));
        for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
        {
          if ((locala != null) && (paramAnonymousMenuItem != null)) {
            locala.a(localContext, (g)localObject2, paramAnonymousMenuItem);
          }
          c.this.xxC.bMo();
          AppMethodBeat.o(83100);
          return;
        }
      }
    });
    this.xxC.dGm();
    AppMethodBeat.o(83101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.c
 * JD-Core Version:    0.7.0.1
 */