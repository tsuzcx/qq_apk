package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.a.a;
import com.tencent.smtt.sdk.a.e;
import com.tencent.smtt.sdk.a.e.a;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d
{
  private static String a = "EmergencyManager";
  private static int b = 0;
  private static int c = 1;
  private static int d = 2;
  private static int e = 3;
  private static int f = 4;
  private static int g = 5;
  private static d h;
  private long i = 60000L;
  private long j = 86400000L;
  private boolean k = false;
  
  public static d a()
  {
    try
    {
      if (h == null) {
        h = new d();
      }
      d locald = h;
      return locald;
    }
    finally {}
  }
  
  private void a(Context paramContext, int paramInt, List<com.tencent.smtt.sdk.a.b> paramList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    com.tencent.smtt.sdk.a.g localg = com.tencent.smtt.sdk.a.g.a();
    Object localObject = localg.a(paramContext, "emergence_ids");
    HashSet localHashSet = new HashSet();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String[] arrayOfString = com.tencent.smtt.sdk.a.g.a((String)((Iterator)localObject).next());
        if ((arrayOfString != null) && (arrayOfString.length == 4)) {
          localHashSet.add(Integer.valueOf(Integer.parseInt(arrayOfString[0])));
        }
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (com.tencent.smtt.sdk.a.b)paramList.next();
      int m = ((com.tencent.smtt.sdk.a.b)localObject).b();
      int n = ((com.tencent.smtt.sdk.a.b)localObject).a();
      if (localHashSet.contains(Integer.valueOf(n)))
      {
        TbsLog.d(a, "Command has been executed: " + ((com.tencent.smtt.sdk.a.b)localObject).toString() + ", ignored");
      }
      else if (((com.tencent.smtt.sdk.a.b)localObject).e())
      {
        TbsLog.d(a, "Command is out of date: " + ((com.tencent.smtt.sdk.a.b)localObject).toString() + ", now: " + a.a(System.currentTimeMillis()));
      }
      else
      {
        localLinkedHashMap.put(Integer.valueOf(m), ((com.tencent.smtt.sdk.a.b)localObject).c());
        localg.a(paramContext, "emergence_ids", com.tencent.smtt.sdk.a.g.a(new String[] { String.valueOf(n), String.valueOf(((com.tencent.smtt.sdk.a.b)localObject).b()), String.valueOf(((com.tencent.smtt.sdk.a.b)localObject).c()), String.valueOf(((com.tencent.smtt.sdk.a.b)localObject).d()) }));
      }
    }
    a(paramContext, Integer.valueOf(paramInt), localLinkedHashMap);
  }
  
  private void b(final Context paramContext)
  {
    com.tencent.smtt.sdk.a.c localc = new com.tencent.smtt.sdk.a.c();
    localc.a(com.tencent.smtt.utils.b.a(paramContext));
    localc.b(com.tencent.smtt.utils.b.d(paramContext));
    localc.a(Integer.valueOf(com.tencent.smtt.utils.b.b(paramContext)));
    localc.c(com.tencent.smtt.utils.b.c(paramContext));
    localc.d("x5webview");
    localc.b(Integer.valueOf(QbSdk.getTbsSdkVersion()));
    localc.c(Integer.valueOf(QbSdk.getTbsVersion(paramContext)));
    Iterator localIterator = com.tencent.smtt.sdk.a.g.a().a(paramContext, "emergence_ids").iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext()) {
      try
      {
        Object localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = com.tencent.smtt.sdk.a.g.a((String)localObject);
          if ((localObject != null) && (localObject.length == 4))
          {
            int m = Integer.parseInt(localObject[0]);
            long l = Long.parseLong(localObject[3]);
            if (System.currentTimeMillis() < l) {
              localArrayList.add(Integer.valueOf(m));
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    localc.a(localArrayList);
    new e(paramContext, n.a(paramContext).j(), localc.a()).a(new e.a()
    {
      public void a(String paramAnonymousString)
      {
        paramAnonymousString = com.tencent.smtt.sdk.a.d.a(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.a() == 0))
        {
          com.tencent.smtt.sdk.a.g.a().a(paramContext, "emergence_req_interval", paramAnonymousString.b());
          paramAnonymousString = paramAnonymousString.c();
          if (paramAnonymousString != null)
          {
            d.a(d.this, paramContext, d.b(), paramAnonymousString);
            return;
          }
          d.a(d.this, paramContext, d.c(), new ArrayList());
          return;
        }
        d.a(d.this, paramContext, d.d(), new ArrayList());
      }
    });
  }
  
  public void a(Context paramContext)
  {
    if (!this.k)
    {
      this.k = true;
      com.tencent.smtt.sdk.a.g localg = com.tencent.smtt.sdk.a.g.a();
      if (!localg.b()) {
        localg.a(paramContext);
      }
    }
    else
    {
      try
      {
        long l3 = com.tencent.smtt.sdk.a.g.a().b(paramContext, "emergence_timestamp");
        long l2 = com.tencent.smtt.sdk.a.g.a().b(paramContext, "emergence_req_interval");
        long l1 = System.currentTimeMillis();
        l3 = l1 - l3;
        l2 = Math.min(Math.max(this.i, l2), this.j);
        if (l3 > l2)
        {
          TbsLog.d(a, "Emergency configuration is out of date, attempt to query again, " + l3 / 1000L + " seconds has past");
          com.tencent.smtt.sdk.a.g.a().a(paramContext, "emergence_timestamp", l1);
          b(paramContext);
        }
        for (;;)
        {
          return;
          a(paramContext, c, new ArrayList());
          TbsLog.d(a, "Emergency configuration is up to date, " + l3 / 1000L + " seconds has past, need " + Math.abs(l3 - l2) / 1000L + " more seconds for an another request");
        }
        a(paramContext, f, new ArrayList());
      }
      catch (Exception localException)
      {
        a(paramContext, g, new ArrayList());
        TbsLog.d(a, "Unexpected exception happened when query emergency configuration: " + localException.getMessage());
        return;
      }
      finally
      {
        com.tencent.smtt.sdk.a.g.a().c();
      }
    }
  }
  
  public void a(Context paramContext, Integer paramInteger, Map<Integer, String> paramMap)
  {
    c.a().b(paramContext);
    TbsLog.e(a, "Dispatch emergency commands on tbs extension");
    QbSdk.a(paramContext, paramInteger, paramMap);
    paramContext = g.a(true);
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = paramContext.a();
    } while (paramContext == null);
    paramContext = paramContext.b();
    if (paramContext != null)
    {
      TbsLog.e(a, "Dispatch emergency commands on tbs shell");
      paramContext.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "dispatchEmergencyCommand", new Class[] { Integer.class, Map.class }, new Object[] { paramInteger, paramMap });
      return;
    }
    TbsLog.e(a, "Dex loader is null, cancel commands dispatching of tbs shell");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.d
 * JD-Core Version:    0.7.0.1
 */