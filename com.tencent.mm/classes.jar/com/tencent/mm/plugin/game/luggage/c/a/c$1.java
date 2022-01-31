package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.ui.base.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class c$1
  implements b.b
{
  c$1(c paramc) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(135894);
    Object localObject = this.njY;
    b localb = ((c)localObject).njW;
    localObject = ((c)localObject).njV;
    Iterator localIterator = localb.njS.iterator();
    while (localIterator.hasNext())
    {
      bcz localbcz = (bcz)localIterator.next();
      if (localbcz == null)
      {
        paraml.e(-1, "");
      }
      else
      {
        a locala = (a)localb.njT.get(Integer.valueOf(localbcz.wzE));
        if (locala != null) {
          locala.a((e)localObject, paraml, localbcz);
        }
      }
    }
    AppMethodBeat.o(135894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.c.1
 * JD-Core Version:    0.7.0.1
 */