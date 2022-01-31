package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

final class h$1
  implements Runnable
{
  h$1(LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(111245);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.nmC.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = g.u(((h)localIterator.next()).optJSONArray("items")).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (!bo.isNullOrNil(localc.field_appId)) {
          localLinkedList.add(localc.field_appId);
        }
      }
    }
    localIterator = com.tencent.mm.plugin.game.f.c.bHC().iterator();
    while (localIterator.hasNext())
    {
      localObject = (f)localIterator.next();
      if (!localLinkedList.contains(((f)localObject).field_appId))
      {
        a.cac().b((f)localObject, new String[0]);
        ab.i("MicroMsg.GameDataSearchGameList", "delete appid : " + ((f)localObject).field_appId);
      }
    }
    AppMethodBeat.o(111245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.h.1
 * JD-Core Version:    0.7.0.1
 */