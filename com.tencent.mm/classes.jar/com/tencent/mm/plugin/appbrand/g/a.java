package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a
  implements k.a
{
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(129955);
    if (g.auK() == null)
    {
      ab.w("MicroMsg.AppBrandSearchStorageChangeListener", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
      AppMethodBeat.o(129955);
      return;
    }
    switch (paramm.htj)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129955);
      return;
      LinkedList localLinkedList = new LinkedList();
      if ("batch".equals(paramString))
      {
        if ((paramm.obj != null) && ((paramm.obj instanceof List)))
        {
          paramString = ((List)paramm.obj).iterator();
          while (paramString.hasNext())
          {
            paramm = (String)paramString.next();
            localLinkedList.addAll(g.auK().zy(paramm));
          }
        }
      }
      else
      {
        localLinkedList.addAll(g.auK().zy(paramm.obj.toString()));
        if (!localLinkedList.isEmpty())
        {
          g.auK().doNotify("batch", 3, localLinkedList);
          AppMethodBeat.o(129955);
          return;
          localLinkedList = new LinkedList();
          if ("batch".equals(paramString))
          {
            if ((paramm.obj != null) && ((paramm.obj instanceof List)))
            {
              paramString = ((List)paramm.obj).iterator();
              while (paramString.hasNext())
              {
                paramm = (String)paramString.next();
                localLinkedList.addAll(g.auK().zy(paramm));
              }
            }
          }
          else
          {
            localLinkedList.addAll(g.auK().zy(paramm.obj.toString()));
            if (!localLinkedList.isEmpty()) {
              g.auK().doNotify("batch", 5, localLinkedList);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a
 * JD-Core Version:    0.7.0.1
 */