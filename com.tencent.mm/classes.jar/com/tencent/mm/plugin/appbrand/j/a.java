package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a
  implements MStorage.IOnStorageChange
{
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(45009);
    if (n.cfk() == null)
    {
      Log.w("MicroMsg.AppBrandSearchStorageChangeListener", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
      AppMethodBeat.o(45009);
      return;
    }
    switch (paramMStorageEventData.eventId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(45009);
      return;
      LinkedList localLinkedList = new LinkedList();
      if ("batch".equals(paramString))
      {
        if ((paramMStorageEventData.obj != null) && ((paramMStorageEventData.obj instanceof List)))
        {
          paramString = ((List)paramMStorageEventData.obj).iterator();
          while (paramString.hasNext())
          {
            paramMStorageEventData = (String)paramString.next();
            localLinkedList.addAll(n.cfk().WL(paramMStorageEventData));
          }
        }
      }
      else
      {
        localLinkedList.addAll(n.cfk().WL(paramMStorageEventData.obj.toString()));
        if (!localLinkedList.isEmpty())
        {
          n.cfk().doNotify("batch", 3, localLinkedList);
          AppMethodBeat.o(45009);
          return;
          localLinkedList = new LinkedList();
          if ("batch".equals(paramString))
          {
            if ((paramMStorageEventData.obj != null) && ((paramMStorageEventData.obj instanceof List)))
            {
              paramString = ((List)paramMStorageEventData.obj).iterator();
              while (paramString.hasNext())
              {
                paramMStorageEventData = (String)paramString.next();
                localLinkedList.addAll(n.cfk().WL(paramMStorageEventData));
              }
            }
          }
          else
          {
            localLinkedList.addAll(n.cfk().WL(paramMStorageEventData.obj.toString()));
            if (!localLinkedList.isEmpty()) {
              n.cfk().doNotify("batch", 5, localLinkedList);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.a
 * JD-Core Version:    0.7.0.1
 */