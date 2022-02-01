package com.tencent.tmdownloader.internal.a.a;

import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmdownloader.internal.a.d;
import com.tencent.tmdownloader.internal.a.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class c
  implements l
{
  protected ArrayList a = new ArrayList();
  protected a b = null;
  
  public c(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.a.addAll(paramArrayList);
    }
  }
  
  public int a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Map paramMap)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return 3;
    }
    k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1);
    if (d(paramString1, paramString2) != null)
    {
      k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is not null");
      return com.tencent.tmdownloader.internal.a.a.b().a(paramString2, paramInt, paramString3, paramString4, paramMap);
    }
    k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is null");
    Object localObject = a(paramString2);
    b localb1 = new b(paramString1, paramString2);
    localb1.c = 1;
    this.a.add(localb1);
    k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",add newTask");
    localObject = ((ArrayList)localObject).iterator();
    int j = 0;
    int i = 0;
    b localb2;
    int k;
    if (((Iterator)localObject).hasNext())
    {
      localb2 = (b)((Iterator)localObject).next();
      if (localb2.c == 2)
      {
        k = 1;
        j = i;
        i = k;
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break;
      if (localb2.c == 1)
      {
        i = j;
        j = 1;
        continue;
        if ((j == 1) || (i == 1))
        {
          if (j == 1) {
            localb1.c = 2;
          }
          for (;;)
          {
            if (this.b != null) {
              this.b.OnDownloadStateChanged(paramString1, paramString2, localb1.c, 0, null);
            }
            k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",newTask is downloading");
            return 0;
            if (i == 1) {
              localb1.c = 1;
            }
          }
        }
        k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",start newTask download");
        return com.tencent.tmdownloader.internal.a.a.b().a(paramString2, paramInt, paramString3, paramString4, paramMap);
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString1, String paramString2)
  {
    paramString1 = com.tencent.tmdownloader.internal.a.a.b().c(paramString2);
    if (paramString1 != null) {
      return new TMAssistantDownloadTaskInfo(paramString1.b, com.tencent.tmdownloader.internal.b.b.b(paramString1.l), paramString1.i, paramString1.j, paramString1.k, paramString1.a);
    }
    Object localObject;
    if (com.tencent.tmdownloader.internal.a.c.b(paramString2, "application/vnd.android.package-archive"))
    {
      localObject = com.tencent.tmdownloader.internal.a.c.a(paramString2, "application/vnd.android.package-archive");
      paramString1 = com.tencent.tmdownloader.internal.b.b.b((String)localObject);
      localObject = new com.tencent.tmdownloader.internal.b.b((String)localObject, (String)localObject);
      return new TMAssistantDownloadTaskInfo(paramString2, paramString1, 4, ((com.tencent.tmdownloader.internal.b.b)localObject).b(), ((com.tencent.tmdownloader.internal.b.b)localObject).b(), "application/vnd.android.package-archive");
    }
    if (com.tencent.tmdownloader.internal.a.c.b(paramString2, "application/tm.android.apkdiff"))
    {
      localObject = com.tencent.tmdownloader.internal.a.c.a(paramString2, "application/tm.android.apkdiff");
      paramString1 = com.tencent.tmdownloader.internal.b.b.b((String)localObject);
      localObject = new com.tencent.tmdownloader.internal.b.b((String)localObject, (String)localObject);
      return new TMAssistantDownloadTaskInfo(paramString2, paramString1, 4, ((com.tencent.tmdownloader.internal.b.b)localObject).b(), ((com.tencent.tmdownloader.internal.b.b)localObject).b(), "application/tm.android.apkdiff");
    }
    b(paramString2);
    return null;
  }
  
  protected ArrayList a(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb.b.equals(paramString)) {
            localArrayList.add(localb);
          }
        }
        paramString = localArrayList;
      }
      finally {}
    }
  }
  
  public void a()
  {
    if (this != null) {
      com.tencent.tmdownloader.internal.a.a.b().a(this);
    }
  }
  
  public void a(a parama)
  {
    this.b = parama;
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      Object localObject = a(paramString1);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          b localb = (b)((Iterator)localObject).next();
          k.c("ServiceDownloadTaskManager", "clientKey:" + localb.a + ",state:" + paramInt1 + ",errorcode:" + paramInt2 + ",url:" + paramString1.hashCode());
          localb.c = paramInt1;
          this.b.OnDownloadStateChanged(localb.a, paramString1, paramInt1, paramInt2, paramString2);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      Object localObject = a(paramString);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        long l = System.currentTimeMillis();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          b localb = (b)((Iterator)localObject).next();
          if (localb.a(paramLong1, paramLong2, l) == true)
          {
            k.c("ServiceDownloadTaskManager", "clientKey:" + localb.a + ",receivedLen:" + paramLong1 + ",url:" + paramString.hashCode());
            this.b.OnDownloadProgressChanged(localb.a, paramString, paramLong1, paramLong2);
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (this != null) {
      com.tencent.tmdownloader.internal.a.a.b().b(this);
    }
  }
  
  protected void b(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb.b.equals(paramString)) {
            localArrayList.add(localb);
          }
        }
        if (localArrayList.size() <= 0) {
          continue;
        }
      }
      finally {}
      this.a.removeAll(localArrayList);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    k.c("ServiceDownloadTaskManager", "enter");
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + "; url: " + paramString2);
    b localb = d(paramString1, paramString2);
    if (localb != null)
    {
      localb.c = 3;
      this.a.remove(localb);
      k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",remove taskItem");
      ArrayList localArrayList = a(paramString2);
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is the only on pauseAll");
        com.tencent.tmdownloader.internal.a.a.b().a(paramString2);
      }
      if (this.b != null) {
        this.b.OnDownloadStateChanged(paramString1, paramString2, localb.c, 0, null);
      }
    }
    for (;;)
    {
      k.c("ServiceDownloadTaskManager", "exit");
      return;
      k.d("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is null");
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1);
    Object localObject = d(paramString1, paramString2);
    if (localObject != null)
    {
      this.a.remove(localObject);
      k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",remove taskItem");
    }
    for (;;)
    {
      localObject = a(paramString2);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
        break;
      }
      k.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is the only on cancelAll");
      com.tencent.tmdownloader.internal.a.a.b().b(paramString2);
      return;
      k.d("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is null");
    }
  }
  
  protected b d(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      try
      {
        Iterator localIterator = this.a.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            b localb = (b)localIterator.next();
            if ((localb.a != null) && (localb.a.equals(paramString1)))
            {
              boolean bool = localb.b.equals(paramString2);
              if (bool)
              {
                paramString1 = localb;
                break;
              }
            }
          }
        }
        paramString1 = null;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.a.c
 * JD-Core Version:    0.7.0.1
 */