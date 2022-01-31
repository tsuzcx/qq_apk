package com.tencent.mm.plugin.appbrand.dynamic.h;

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
  private static volatile a fWV;
  public Map<String, List<IPCDynamicPageView>> fWW = new ConcurrentHashMap();
  public Map<String, a.a> fWX = new ConcurrentHashMap();
  
  public static a afw()
  {
    if (fWV == null) {}
    try
    {
      if (fWV == null) {
        fWV = new a();
      }
      return fWV;
    }
    finally {}
  }
  
  private static IPCDynamicPageView au(List<IPCDynamicPageView> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (((IPCDynamicPageView)paramList.get(i)).isPaused()) {
        return (IPCDynamicPageView)paramList.remove(i);
      }
      i += 1;
    }
    return null;
  }
  
  public final boolean b(String paramString, IPCDynamicPageView paramIPCDynamicPageView)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramIPCDynamicPageView == null)) {
      return false;
    }
    List localList = (List)this.fWW.get(paramString);
    if (localList == null) {
      return false;
    }
    try
    {
      boolean bool = localList.remove(paramIPCDynamicPageView);
      if (localList.isEmpty()) {
        this.fWW.remove(paramString);
      }
      return bool;
    }
    finally {}
  }
  
  public final boolean c(String paramString, IPCDynamicPageView paramIPCDynamicPageView)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramIPCDynamicPageView == null)) {
      return false;
    }
    Object localObject = (List)this.fWW.get(paramString);
    if (localObject == null)
    {
      localObject = new LinkedList();
      this.fWW.put(paramString, localObject);
    }
    boolean bool;
    for (;;)
    {
      if (((List)localObject).contains(paramIPCDynamicPageView)) {
        try
        {
          ((List)localObject).remove(paramIPCDynamicPageView);
          ((List)localObject).add(paramIPCDynamicPageView);
          return true;
        }
        finally {}
      }
      bool = ((List)localObject).add(paramIPCDynamicPageView);
      if (((List)localObject).size() <= 4) {
        break;
      }
      try
      {
        if (((List)localObject).size() > 4)
        {
          paramIPCDynamicPageView = au((List)localObject);
          if (paramIPCDynamicPageView != null)
          {
            a.a locala = (a.a)this.fWX.get(paramString);
            if (locala != null) {
              locala.a(paramString, paramIPCDynamicPageView);
            }
          }
        }
      }
      finally {}
    }
    return bool;
  }
  
  public final IPCDynamicPageView tj(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    IPCDynamicPageView localIPCDynamicPageView;
    do
    {
      Iterator localIterator = this.fWW.entrySet().iterator();
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
    return localIPCDynamicPageView;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.a
 * JD-Core Version:    0.7.0.1
 */