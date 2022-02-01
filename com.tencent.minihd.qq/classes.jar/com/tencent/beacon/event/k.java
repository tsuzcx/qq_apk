package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k
  extends com.tencent.beacon.upload.a
{
  private com.tencent.beacon.c.a.b e;
  private List<i> f;
  
  public static com.tencent.beacon.c.a.b a(Context paramContext, int paramInt, List<i> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return null;
      try
      {
        com.tencent.beacon.d.a.b(" current size:}" + paramList.size(), new Object[0]);
        paramList = b(paramList);
        if (paramList != null)
        {
          paramList = paramList.a();
          if (paramList != null)
          {
            paramContext = a(paramContext, paramInt, paramList);
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        com.tencent.beacon.d.a.d(" RealTimeRecordUploadDatas.encode2EventRecordPackage error}", new Object[0]);
      }
    }
    return null;
  }
  
  private void a(com.tencent.beacon.c.a.b paramb)
  {
    try
    {
      this.e = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  private void a(List<i> paramList)
  {
    try
    {
      this.f = paramList;
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  private static com.tencent.beacon.c.b.b b(List<i> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    com.tencent.beacon.c.b.b localb;
    try
    {
      localb = new com.tencent.beacon.c.b.b();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.tencent.beacon.c.b.a locala = a.e((i)paramList.next());
        if (locala != null) {
          localArrayList.add(locala);
        }
      }
      localb.a = localArrayList;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    com.tencent.beacon.d.a.b(" RealTimeRecordUploadDatas.encode2EventRecordPackage() end}", new Object[0]);
    return localb;
  }
  
  private List<i> f()
  {
    try
    {
      List localList = this.f;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.beacon.c.a.b a()
  {
    return null;
  }
  
  public final void b(boolean paramBoolean)
  {
    a(null);
    List localList = f();
    a(null);
    if (localList != null)
    {
      if (!paramBoolean)
      {
        com.tencent.beacon.d.a.b(" isHandled false , record to db}", new Object[0]);
        g.a(null, localList);
      }
      localList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.k
 * JD-Core Version:    0.7.0.1
 */