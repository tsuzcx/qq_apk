package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class i$1
  implements j.a
{
  public final void a(String paramString, l paraml)
  {
    if (e.aaZ() == null) {
      y.w("MicroMsg.SearchMiniGameQueryLogic", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
    }
    LinkedList localLinkedList;
    label132:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paraml.gbI)
            {
            case 4: 
            default: 
              return;
            case 2: 
            case 3: 
              localLinkedList = new LinkedList();
              if (!"batch".equals(paramString)) {
                break label132;
              }
            }
          } while ((paraml.obj == null) || (!(paraml.obj instanceof List)));
          paramString = ((List)paraml.obj).iterator();
          while (paramString.hasNext())
          {
            paraml = (String)paramString.next();
            localLinkedList.addAll(e.aaZ().rJ(paraml));
          }
          localLinkedList.addAll(e.aaZ().rJ(paraml.obj.toString()));
        } while (localLinkedList.isEmpty());
        e.aaZ().b("batch", 3, localLinkedList);
        return;
        localLinkedList = new LinkedList();
        if (!"batch".equals(paramString)) {
          break;
        }
      } while ((paraml.obj == null) || (!(paraml.obj instanceof List)));
      paramString = ((List)paraml.obj).iterator();
      while (paramString.hasNext())
      {
        paraml = (String)paramString.next();
        localLinkedList.addAll(e.aaZ().rJ(paraml));
      }
      localLinkedList.addAll(e.aaZ().rJ(paraml.obj.toString()));
    } while (localLinkedList.isEmpty());
    e.aaZ().b("batch", 5, localLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.i.1
 * JD-Core Version:    0.7.0.1
 */