package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private static volatile a hqv;
  public Map<String, List<IPCDynamicPageView>> hqw;
  public Map<String, a.a> hqx;
  
  private a()
  {
    AppMethodBeat.i(10939);
    this.hqw = new ConcurrentHashMap();
    this.hqx = new ConcurrentHashMap();
    AppMethodBeat.o(10939);
  }
  
  public static a aAa()
  {
    AppMethodBeat.i(10940);
    if (hqv == null) {}
    try
    {
      if (hqv == null) {
        hqv = new a();
      }
      a locala = hqv;
      AppMethodBeat.o(10940);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(10940);
    }
  }
  
  private static IPCDynamicPageView aD(List<IPCDynamicPageView> paramList)
  {
    AppMethodBeat.i(10944);
    int i = 0;
    while (i < paramList.size())
    {
      if (((IPCDynamicPageView)paramList.get(i)).isPaused())
      {
        paramList = (IPCDynamicPageView)paramList.remove(i);
        AppMethodBeat.o(10944);
        return paramList;
      }
      i += 1;
    }
    AppMethodBeat.o(10944);
    return null;
  }
  
  public final IPCDynamicPageView Bn(String paramString)
  {
    AppMethodBeat.i(10941);
    if (paramString == null)
    {
      AppMethodBeat.o(10941);
      return null;
    }
    IPCDynamicPageView localIPCDynamicPageView;
    do
    {
      Iterator localIterator = this.hqw.entrySet().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (Map.Entry)localIterator.next();
        } while (((Map.Entry)localObject).getValue() == null);
        localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      }
      localIPCDynamicPageView = (IPCDynamicPageView)((Iterator)localObject).next();
    } while ((localIPCDynamicPageView.getExtId() == null) || (!localIPCDynamicPageView.getExtId().equals(paramString)));
    AppMethodBeat.o(10941);
    return localIPCDynamicPageView;
    AppMethodBeat.o(10941);
    return null;
  }
  
  public final boolean b(String paramString, IPCDynamicPageView paramIPCDynamicPageView)
  {
    AppMethodBeat.i(10942);
    if ((paramString == null) || (paramString.length() == 0) || (paramIPCDynamicPageView == null))
    {
      AppMethodBeat.o(10942);
      return false;
    }
    List localList = (List)this.hqw.get(paramString);
    if (localList == null)
    {
      AppMethodBeat.o(10942);
      return false;
    }
    try
    {
      boolean bool = localList.remove(paramIPCDynamicPageView);
      if (localList.isEmpty()) {
        this.hqw.remove(paramString);
      }
      AppMethodBeat.o(10942);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(10942);
    }
  }
  
  public final boolean c(String paramString, IPCDynamicPageView paramIPCDynamicPageView)
  {
    AppMethodBeat.i(10943);
    if ((paramString == null) || (paramString.length() == 0) || (paramIPCDynamicPageView == null))
    {
      AppMethodBeat.o(10943);
      return false;
    }
    Object localObject = (List)this.hqw.get(paramString);
    if (localObject == null)
    {
      localObject = new LinkedList();
      this.hqw.put(paramString, localObject);
    }
    for (;;)
    {
      if (((List)localObject).contains(paramIPCDynamicPageView)) {
        try
        {
          ((List)localObject).remove(paramIPCDynamicPageView);
          ((List)localObject).add(paramIPCDynamicPageView);
          return true;
        }
        finally
        {
          AppMethodBeat.o(10943);
        }
      }
      boolean bool = ((List)localObject).add(paramIPCDynamicPageView);
      if (((List)localObject).size() > 4) {}
      try
      {
        if (((List)localObject).size() > 4)
        {
          paramIPCDynamicPageView = aD((List)localObject);
          if (paramIPCDynamicPageView != null)
          {
            a.a locala = (a.a)this.hqx.get(paramString);
            if (locala != null) {
              locala.a(paramString, paramIPCDynamicPageView);
            }
          }
        }
        return bool;
      }
      finally
      {
        AppMethodBeat.o(10943);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.a
 * JD-Core Version:    0.7.0.1
 */