package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.ui.base.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  com.tencent.mm.plugin.game.luggage.d.f rPG;
  b rPH;
  public d rPI;
  
  public c(com.tencent.mm.plugin.game.luggage.d.f paramf, b paramb)
  {
    AppMethodBeat.i(83101);
    this.rPG = paramf;
    this.rPH = paramb;
    this.rPI = new d(this.rPG.mContext);
    this.rPI.Boz = new b.b()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(83099);
        Object localObject = c.this;
        b localb = ((c)localObject).rPH;
        localObject = ((c)localObject).rPG;
        Iterator localIterator = localb.rPD.iterator();
        while (localIterator.hasNext())
        {
          bpp localbpp = (bpp)localIterator.next();
          if (localbpp == null)
          {
            paramAnonymousl.c(-1, "");
          }
          else
          {
            a locala = (a)localb.rPE.get(Integer.valueOf(localbpp.CKO));
            if (locala != null) {
              locala.a((com.tencent.mm.plugin.webview.luggage.f)localObject, paramAnonymousl, localbpp);
            }
          }
        }
        AppMethodBeat.o(83099);
      }
    };
    this.rPI.a(new b.c()
    {
      public final void c(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(83100);
        Object localObject2 = c.this;
        Object localObject1 = ((c)localObject2).rPH;
        Context localContext = ((c)localObject2).rPG.mContext;
        localObject2 = ((c)localObject2).rPG;
        a locala = (a)((b)localObject1).rPE.get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        Iterator localIterator = ((b)localObject1).rPD.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (bpp)localIterator.next();
        } while ((localObject1 == null) || (((bpp)localObject1).CKO != paramAnonymousMenuItem.getItemId()));
        for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
        {
          if ((locala != null) && (paramAnonymousMenuItem != null)) {
            locala.a(localContext, (com.tencent.mm.plugin.webview.luggage.f)localObject2, paramAnonymousMenuItem);
          }
          c.this.rPI.bfo();
          AppMethodBeat.o(83100);
          return;
        }
      }
    });
    this.rPI.csG();
    AppMethodBeat.o(83101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.c
 * JD-Core Version:    0.7.0.1
 */