package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.ui.base.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class c$1
  implements b.b
{
  c$1(c paramc) {}
  
  public final void a(l paraml)
  {
    Object localObject = this.kNs;
    b localb = ((c)localObject).kNq;
    localObject = ((c)localObject).kMl;
    Iterator localIterator = localb.kNn.iterator();
    while (localIterator.hasNext())
    {
      awk localawk = (awk)localIterator.next();
      if (localawk == null)
      {
        paraml.e(-1, "");
      }
      else
      {
        a locala = (a)localb.kNo.get(Integer.valueOf(localawk.sYX));
        if (locala != null) {
          locala.a((e)localObject, paraml, localawk);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.c.1
 * JD-Core Version:    0.7.0.1
 */