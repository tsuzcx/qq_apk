package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.u.f;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;

final class l
  extends ArrayList<AppBrandRecentTaskInfo>
{
  private final ArrayList<AppBrandRecentTaskInfo> hjq = new ArrayList(50);
  private final ArrayList<AppBrandRecentTaskInfo> hjr = new ArrayList(200);
  
  static l i(ArrayList<AppBrandRecentTaskInfo> paramArrayList1, ArrayList<AppBrandRecentTaskInfo> paramArrayList2)
  {
    l locall = new l();
    f.c(locall.hjq, paramArrayList1);
    f.c(locall.hjr, paramArrayList2);
    return locall;
  }
  
  /* Error */
  private AppBrandRecentTaskInfo mr(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 17	com/tencent/mm/plugin/appbrand/ui/recents/l:hjq	Ljava/util/ArrayList;
    //   7: invokevirtual 37	java/util/ArrayList:size	()I
    //   10: if_icmpge +19 -> 29
    //   13: aload_0
    //   14: getfield 17	com/tencent/mm/plugin/appbrand/ui/recents/l:hjq	Ljava/util/ArrayList;
    //   17: iload_1
    //   18: invokevirtual 41	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   21: checkcast 43	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: aload_0
    //   30: getfield 19	com/tencent/mm/plugin/appbrand/ui/recents/l:hjr	Ljava/util/ArrayList;
    //   33: iload_1
    //   34: aload_0
    //   35: getfield 17	com/tencent/mm/plugin/appbrand/ui/recents/l:hjq	Ljava/util/ArrayList;
    //   38: invokevirtual 37	java/util/ArrayList:size	()I
    //   41: isub
    //   42: invokevirtual 41	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   45: checkcast 43	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   48: astore_2
    //   49: goto -24 -> 25
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	l
    //   0	57	1	paramInt	int
    //   24	25	2	localAppBrandRecentTaskInfo	AppBrandRecentTaskInfo
    //   52	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	52	finally
    //   29	49	52	finally
  }
  
  final l a(l paraml)
  {
    try
    {
      paraml = j(paraml.hjq, paraml.hjr);
      return paraml;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
  
  public final boolean addAll(Collection<? extends AppBrandRecentTaskInfo> paramCollection)
  {
    if (l.class.isInstance(paramCollection)) {
      try
      {
        paramCollection = (l)paramCollection;
        this.hjq.addAll(paramCollection.hjq);
        this.hjr.addAll(paramCollection.hjr);
        return true;
      }
      finally {}
    }
    Assert.assertTrue("collection type mismatch!!", false);
    return false;
  }
  
  final ArrayList<AppBrandRecentTaskInfo> apW()
  {
    try
    {
      ArrayList localArrayList = this.hjq;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final ArrayList<AppBrandRecentTaskInfo> apX()
  {
    try
    {
      ArrayList localArrayList = this.hjr;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final l apY()
  {
    try
    {
      l locall = new l();
      locall.hjq.addAll(this.hjq);
      locall.hjr.addAll(this.hjr);
      return locall;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void clear()
  {
    try
    {
      this.hjq.clear();
      this.hjr.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Iterator<AppBrandRecentTaskInfo> iterator()
  {
    Assert.assertTrue("Why you need this?? call @smoothieli fix it", false);
    return new l.1(this);
  }
  
  final l j(ArrayList<AppBrandRecentTaskInfo> paramArrayList1, ArrayList<AppBrandRecentTaskInfo> paramArrayList2)
  {
    try
    {
      this.hjq.clear();
      if (!bk.dk(paramArrayList1)) {
        this.hjq.addAll(paramArrayList1);
      }
      this.hjr.clear();
      if (!bk.dk(paramArrayList2)) {
        this.hjr.addAll(paramArrayList2);
      }
      return this;
    }
    finally {}
  }
  
  /* Error */
  public final AppBrandRecentTaskInfo ms(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 17	com/tencent/mm/plugin/appbrand/ui/recents/l:hjq	Ljava/util/ArrayList;
    //   7: invokevirtual 37	java/util/ArrayList:size	()I
    //   10: if_icmpge +19 -> 29
    //   13: aload_0
    //   14: getfield 17	com/tencent/mm/plugin/appbrand/ui/recents/l:hjq	Ljava/util/ArrayList;
    //   17: iload_1
    //   18: invokevirtual 102	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   21: checkcast 43	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: aload_0
    //   30: getfield 19	com/tencent/mm/plugin/appbrand/ui/recents/l:hjr	Ljava/util/ArrayList;
    //   33: iload_1
    //   34: aload_0
    //   35: getfield 17	com/tencent/mm/plugin/appbrand/ui/recents/l:hjq	Ljava/util/ArrayList;
    //   38: invokevirtual 37	java/util/ArrayList:size	()I
    //   41: isub
    //   42: invokevirtual 102	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   45: checkcast 43	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   48: astore_2
    //   49: goto -24 -> 25
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	l
    //   0	57	1	paramInt	int
    //   24	25	2	localAppBrandRecentTaskInfo	AppBrandRecentTaskInfo
    //   52	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	52	finally
    //   29	49	52	finally
  }
  
  public final int size()
  {
    try
    {
      int i = this.hjq.size();
      int j = this.hjr.size();
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.l
 * JD-Core Version:    0.7.0.1
 */