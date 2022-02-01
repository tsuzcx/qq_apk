package com.tencent.tmdownloader.internal.a;

import com.tencent.tmassistantbase.a.k;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.network.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a
  implements b
{
  protected static a a = null;
  final ConcurrentHashMap b = new ConcurrentHashMap();
  
  public static a b()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  public int a(String paramString1, int paramInt, String paramString2, String paramString3, Map paramMap)
  {
    k.c("ApkDownloadManager", "call startDownload, url: " + paramString1 + "priority: " + paramInt);
    if (!c.c())
    {
      k.c("ApkDownloadManager", "call startDownload, return errCode: 1");
      return 1;
    }
    if ((!c.b().equalsIgnoreCase("wifi")) && (f.a().b()))
    {
      k.c("ApkDownloadManager", "call startDownload, return errCode: 2");
      return 2;
    }
    if (!c.f(paramString1))
    {
      k.c("ApkDownloadManager", "call startDownload, return errCode: 3");
      return 3;
    }
    if (c.b(paramString1, paramString2))
    {
      k.c("ApkDownloadManager", "call startDownload, return errCode: 4");
      return 4;
    }
    Object localObject1 = (d)this.b.get(paramString1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = com.tencent.tmdownloader.internal.b.a.a().b(paramString1);
      if (localObject1 == null)
      {
        localObject2 = new d(paramString1, paramInt, paramString2);
        localObject1 = localObject2;
        if (((d)localObject2).a.equals("resource/tm.android.unknown"))
        {
          ((d)localObject2).l = paramString3;
          localObject1 = localObject2;
        }
        this.b.put(paramString1, localObject1);
      }
    }
    for (;;)
    {
      ((d)localObject1).a((HashMap)paramMap);
      if (((d)localObject1).a.equals("application/tm.android.apkdiff")) {}
      for (boolean bool = c.b(paramString1, ((d)localObject1).a);; bool = c.g(((d)localObject1).l))
      {
        localObject2 = localObject1;
        if (((d)localObject1).a())
        {
          localObject2 = localObject1;
          if (!bool)
          {
            this.b.remove(paramString1);
            com.tencent.tmdownloader.internal.b.a.a().a(paramString1);
            localObject2 = new d(paramString1, paramInt, paramString2);
            if (((d)localObject2).a.equals("resource/tm.android.unknown")) {
              ((d)localObject2).l = paramString3;
            }
            ((d)localObject2).a((HashMap)paramMap);
            this.b.put(paramString1, localObject2);
          }
        }
        paramInt = ((d)localObject2).d();
        k.c("ApkDownloadManager", "call startDownload, return errCode: " + paramInt);
        return paramInt;
        if (((d)localObject1).a.equals("application/tm.android.apkdiff")) {}
        for (bool = c.b(paramString1, ((d)localObject1).a); bool; bool = c.g(((d)localObject1).l))
        {
          k.c("ApkDownloadManager", "call startDownload, return errCode: 4");
          return 4;
        }
        break;
      }
    }
  }
  
  public void a()
  {
    k.c("ApkDownloadManager", "onNetworkChanged");
    if ((c.c()) && (f.a().d()))
    {
      String str = c.b();
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)this.b.get(localIterator.next());
        if ((f.a().a(locald.p, str)) && ((locald.o == 601) || (locald.o == 602) || (locald.o == 605)) && (System.currentTimeMillis() - locald.q < 120000L)) {
          locald.d();
        }
      }
    }
  }
  
  public void a(l paraml)
  {
    k.c("ApkDownloadManager", "call AddDownloadListener, dl: " + paraml);
    e.a().a(paraml);
  }
  
  public void a(String paramString)
  {
    k.c("ApkDownloadManager", "call pauseDownload, url: " + paramString);
    paramString = (d)this.b.get(paramString);
    if (paramString != null) {
      paramString.e();
    }
  }
  
  public void b(l paraml)
  {
    k.c("ApkDownloadManager", "call RemoveDownloadListener, dl: " + paraml);
    e.a().b(paraml);
  }
  
  public void b(String paramString)
  {
    k.c("ApkDownloadManager", "call cancelDownload, url: " + paramString);
    paramString = (d)this.b.remove(paramString);
    if (paramString != null) {
      paramString.f();
    }
  }
  
  public d c(String paramString)
  {
    k.c("ApkDownloadManager", "call queryDownloadInfo, url: " + paramString);
    Object localObject2 = (d)this.b.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = com.tencent.tmdownloader.internal.b.a.a().b(paramString);
    }
    boolean bool = false;
    if (localObject1 != null) {
      if (!((d)localObject1).a.equals("application/tm.android.apkdiff")) {
        break label126;
      }
    }
    label126:
    for (bool = c.b(paramString, ((d)localObject1).a);; bool = c.g(((d)localObject1).l))
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((d)localObject1).a())
        {
          localObject2 = localObject1;
          if (!bool)
          {
            this.b.remove(paramString);
            com.tencent.tmdownloader.internal.b.a.a().a(paramString);
            localObject2 = null;
          }
        }
      }
      return localObject2;
    }
  }
  
  public void c()
  {
    k.c("ApkDownloadManager", "Start to load DownloadInfo list.");
    this.b.clear();
    Object localObject = com.tencent.tmdownloader.internal.b.a.a().b();
    if (localObject != null)
    {
      k.c("ApkDownloadManager", "The size of downloadinfo_list: " + ((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        d locald = (d)((Iterator)localObject).next();
        k.c("ApkDownloadManager", "---------------load download info---------------");
        locald.a("ApkDownloadManager");
        this.b.put(locald.b, locald);
        if (!locald.c()) {
          locald.a(3);
        }
      }
    }
    k.c("ApkDownloadManager", "Add NetworkChangedObserver to NetworkMonitorReceiver");
    NetworkMonitorReceiver.a().a(this);
  }
  
  public void d()
  {
    NetworkMonitorReceiver.a().b(this);
    ArrayList localArrayList = new ArrayList();
    if (!this.b.isEmpty())
    {
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)this.b.get(localIterator.next());
        if (locald.i == 2) {
          a(locald.b);
        }
        localArrayList.add(locald);
      }
    }
    k.c("ApkDownloadManager", "Start to save DownloadInfo list.");
    com.tencent.tmdownloader.internal.b.a.a().a(localArrayList);
  }
  
  public Boolean e()
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!((d)this.b.get(localIterator.next())).c()) {
        return Boolean.valueOf(false);
      }
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.a
 * JD-Core Version:    0.7.0.1
 */