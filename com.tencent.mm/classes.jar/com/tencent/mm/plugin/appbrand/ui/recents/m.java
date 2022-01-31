package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.luggage.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;

final class m
  extends ArrayList<AppBrandRecentTaskInfo>
{
  private final ArrayList<AppBrandRecentTaskInfo> iUX;
  private final ArrayList<AppBrandRecentTaskInfo> iUY;
  
  m()
  {
    AppMethodBeat.i(133483);
    this.iUX = new ArrayList(50);
    this.iUY = new ArrayList(10000);
    AppMethodBeat.o(133483);
  }
  
  static m d(ArrayList<AppBrandRecentTaskInfo> paramArrayList1, ArrayList<AppBrandRecentTaskInfo> paramArrayList2)
  {
    AppMethodBeat.i(133484);
    m localm = new m();
    c.c(localm.iUX, paramArrayList1);
    c.c(localm.iUY, paramArrayList2);
    AppMethodBeat.o(133484);
    return localm;
  }
  
  /* Error */
  private AppBrandRecentTaskInfo pH(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 46
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: aload_0
    //   9: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/m:iUX	Ljava/util/ArrayList;
    //   12: invokevirtual 50	java/util/ArrayList:size	()I
    //   15: if_icmpge +24 -> 39
    //   18: aload_0
    //   19: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/m:iUX	Ljava/util/ArrayList;
    //   22: iload_1
    //   23: invokevirtual 54	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   26: checkcast 56	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   29: astore_2
    //   30: ldc 46
    //   32: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: aload_0
    //   40: getfield 27	com/tencent/mm/plugin/appbrand/ui/recents/m:iUY	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: aload_0
    //   45: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/m:iUX	Ljava/util/ArrayList;
    //   48: invokevirtual 50	java/util/ArrayList:size	()I
    //   51: isub
    //   52: invokevirtual 54	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   55: checkcast 56	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   58: astore_2
    //   59: ldc 46
    //   61: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -29 -> 35
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	m
    //   0	72	1	paramInt	int
    //   29	30	2	localAppBrandRecentTaskInfo	AppBrandRecentTaskInfo
    //   67	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	67	finally
    //   39	64	67	finally
  }
  
  final m a(m paramm)
  {
    try
    {
      AppMethodBeat.i(133486);
      paramm = e(paramm.iUX, paramm.iUY);
      AppMethodBeat.o(133486);
      return paramm;
    }
    finally
    {
      paramm = finally;
      throw paramm;
    }
  }
  
  final ArrayList<AppBrandRecentTaskInfo> aNs()
  {
    try
    {
      ArrayList localArrayList = this.iUX;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final ArrayList<AppBrandRecentTaskInfo> aNt()
  {
    try
    {
      ArrayList localArrayList = this.iUY;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final m aNu()
  {
    try
    {
      AppMethodBeat.i(133488);
      m localm = new m();
      localm.iUX.addAll(this.iUX);
      localm.iUY.addAll(this.iUY);
      AppMethodBeat.o(133488);
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean addAll(Collection<? extends AppBrandRecentTaskInfo> paramCollection)
  {
    AppMethodBeat.i(133487);
    if (m.class.isInstance(paramCollection)) {
      try
      {
        paramCollection = (m)paramCollection;
        this.iUX.addAll(paramCollection.iUX);
        this.iUY.addAll(paramCollection.iUY);
        return true;
      }
      finally
      {
        AppMethodBeat.o(133487);
      }
    }
    Assert.assertTrue("collection type mismatch!!", false);
    AppMethodBeat.o(133487);
    return false;
  }
  
  public final void clear()
  {
    try
    {
      AppMethodBeat.i(133492);
      this.iUX.clear();
      this.iUY.clear();
      AppMethodBeat.o(133492);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final m e(ArrayList<AppBrandRecentTaskInfo> paramArrayList1, ArrayList<AppBrandRecentTaskInfo> paramArrayList2)
  {
    try
    {
      AppMethodBeat.i(133485);
      this.iUX.clear();
      if (!bo.es(paramArrayList1)) {
        this.iUX.addAll(paramArrayList1);
      }
      this.iUY.clear();
      if (!bo.es(paramArrayList2)) {
        this.iUY.addAll(paramArrayList2);
      }
      AppMethodBeat.o(133485);
      return this;
    }
    finally {}
  }
  
  public final Iterator<AppBrandRecentTaskInfo> iterator()
  {
    AppMethodBeat.i(133493);
    Assert.assertTrue("Why you need this?? call @smoothieli fix it", false);
    Iterator local1 = new Iterator()
    {
      public final boolean hasNext()
      {
        return false;
      }
      
      public final void remove() {}
    };
    AppMethodBeat.o(133493);
    return local1;
  }
  
  /* Error */
  public final AppBrandRecentTaskInfo pI(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 119
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: aload_0
    //   9: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/m:iUX	Ljava/util/ArrayList;
    //   12: invokevirtual 50	java/util/ArrayList:size	()I
    //   15: if_icmpge +24 -> 39
    //   18: aload_0
    //   19: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/m:iUX	Ljava/util/ArrayList;
    //   22: iload_1
    //   23: invokevirtual 122	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   26: checkcast 56	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   29: astore_2
    //   30: ldc 119
    //   32: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: aload_0
    //   40: getfield 27	com/tencent/mm/plugin/appbrand/ui/recents/m:iUY	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: aload_0
    //   45: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/m:iUX	Ljava/util/ArrayList;
    //   48: invokevirtual 50	java/util/ArrayList:size	()I
    //   51: isub
    //   52: invokevirtual 122	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   55: checkcast 56	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   58: astore_2
    //   59: ldc 119
    //   61: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -29 -> 35
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	m
    //   0	72	1	paramInt	int
    //   29	30	2	localAppBrandRecentTaskInfo	AppBrandRecentTaskInfo
    //   67	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	67	finally
    //   39	64	67	finally
  }
  
  public final int size()
  {
    try
    {
      AppMethodBeat.i(133489);
      int i = this.iUX.size();
      int j = this.iUY.size();
      AppMethodBeat.o(133489);
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.m
 * JD-Core Version:    0.7.0.1
 */