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
  private static volatile a jNQ;
  public Map<String, List<IPCDynamicPageView>> jNR;
  public Map<String, a> jNS;
  
  private a()
  {
    AppMethodBeat.i(121420);
    this.jNR = new ConcurrentHashMap();
    this.jNS = new ConcurrentHashMap();
    AppMethodBeat.o(121420);
  }
  
  public static a bcF()
  {
    AppMethodBeat.i(121421);
    if (jNQ == null) {}
    try
    {
      if (jNQ == null) {
        jNQ = new a();
      }
      a locala = jNQ;
      AppMethodBeat.o(121421);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(121421);
    }
  }
  
  private static IPCDynamicPageView bd(List<IPCDynamicPageView> paramList)
  {
    AppMethodBeat.i(121425);
    int i = 0;
    while (i < paramList.size())
    {
      if (((IPCDynamicPageView)paramList.get(i)).isPaused())
      {
        paramList = (IPCDynamicPageView)paramList.remove(i);
        AppMethodBeat.o(121425);
        return paramList;
      }
      i += 1;
    }
    AppMethodBeat.o(121425);
    return null;
  }
  
  public final IPCDynamicPageView Lp(String paramString)
  {
    AppMethodBeat.i(121422);
    if (paramString == null)
    {
      AppMethodBeat.o(121422);
      return null;
    }
    IPCDynamicPageView localIPCDynamicPageView;
    do
    {
      Iterator localIterator = this.jNR.entrySet().iterator();
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
    AppMethodBeat.o(121422);
    return localIPCDynamicPageView;
    AppMethodBeat.o(121422);
    return null;
  }
  
  public final boolean b(String paramString, IPCDynamicPageView paramIPCDynamicPageView)
  {
    AppMethodBeat.i(121423);
    if ((paramString == null) || (paramString.length() == 0) || (paramIPCDynamicPageView == null))
    {
      AppMethodBeat.o(121423);
      return false;
    }
    List localList = (List)this.jNR.get(paramString);
    if (localList == null)
    {
      AppMethodBeat.o(121423);
      return false;
    }
    try
    {
      boolean bool = localList.remove(paramIPCDynamicPageView);
      if (localList.isEmpty()) {
        this.jNR.remove(paramString);
      }
      AppMethodBeat.o(121423);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(121423);
    }
  }
  
  public final boolean c(String paramString, IPCDynamicPageView paramIPCDynamicPageView)
  {
    AppMethodBeat.i(121424);
    if ((paramString == null) || (paramString.length() == 0) || (paramIPCDynamicPageView == null))
    {
      AppMethodBeat.o(121424);
      return false;
    }
    Object localObject = (List)this.jNR.get(paramString);
    if (localObject == null)
    {
      localObject = new LinkedList();
      this.jNR.put(paramString, localObject);
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
          AppMethodBeat.o(121424);
        }
      }
      boolean bool = ((List)localObject).add(paramIPCDynamicPageView);
      if (((List)localObject).size() > 4) {}
      try
      {
        if (((List)localObject).size() > 4)
        {
          paramIPCDynamicPageView = bd((List)localObject);
          if (paramIPCDynamicPageView != null)
          {
            a locala = (a)this.jNS.get(paramString);
            if (locala != null) {
              locala.a(paramString, paramIPCDynamicPageView);
            }
          }
        }
        return bool;
      }
      finally
      {
        AppMethodBeat.o(121424);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, IPCDynamicPageView paramIPCDynamicPageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.a
 * JD-Core Version:    0.7.0.1
 */