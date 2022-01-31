package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class i$1
  implements Runnable
{
  i$1(LinkedList paramLinkedList) {}
  
  public final void run()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.kOF.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = h.q(((i)localIterator.next()).optJSONArray("items")).iterator();
      while (((Iterator)localObject).hasNext())
      {
        d locald = (d)((Iterator)localObject).next();
        if (!bk.bl(locald.field_appId)) {
          localLinkedList.add(locald.field_appId);
        }
      }
    }
    localIterator = c.bav().iterator();
    while (localIterator.hasNext())
    {
      localObject = (f)localIterator.next();
      if (!localLinkedList.contains(((f)localObject).field_appId))
      {
        a.brn().b((f)localObject, new String[0]);
        y.i("MicroMsg.GameDataSearchGameList", "delete appid : " + ((f)localObject).field_appId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.i.1
 * JD-Core Version:    0.7.0.1
 */