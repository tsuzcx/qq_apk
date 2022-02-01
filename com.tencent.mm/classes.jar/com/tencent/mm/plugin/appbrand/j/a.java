package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a
  implements k.a
{
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(45009);
    if (j.aZs() == null)
    {
      ae.w("MicroMsg.AppBrandSearchStorageChangeListener", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
      AppMethodBeat.o(45009);
      return;
    }
    switch (paramm.duP)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(45009);
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
            localLinkedList.addAll(j.aZs().Np(paramm));
          }
        }
      }
      else
      {
        localLinkedList.addAll(j.aZs().Np(paramm.obj.toString()));
        if (!localLinkedList.isEmpty())
        {
          j.aZs().doNotify("batch", 3, localLinkedList);
          AppMethodBeat.o(45009);
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
                localLinkedList.addAll(j.aZs().Np(paramm));
              }
            }
          }
          else
          {
            localLinkedList.addAll(j.aZs().Np(paramm.obj.toString()));
            if (!localLinkedList.isEmpty()) {
              j.aZs().doNotify("batch", 5, localLinkedList);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.a
 * JD-Core Version:    0.7.0.1
 */