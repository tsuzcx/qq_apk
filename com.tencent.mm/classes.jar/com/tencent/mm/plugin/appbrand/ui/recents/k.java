package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.luggage.l.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

final class k
  extends ArrayList<AppBrandRecentTaskInfo>
{
  private final ArrayList<AppBrandRecentTaskInfo> unv;
  private final ArrayList<AppBrandRecentTaskInfo> unw;
  
  k()
  {
    AppMethodBeat.i(49209);
    this.unv = new ArrayList(50);
    this.unw = new ArrayList(10000);
    AppMethodBeat.o(49209);
  }
  
  /* Error */
  private AppBrandRecentTaskInfo Dv(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 34
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: aload_0
    //   9: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/k:unv	Ljava/util/ArrayList;
    //   12: invokevirtual 38	java/util/ArrayList:size	()I
    //   15: if_icmpge +24 -> 39
    //   18: aload_0
    //   19: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/k:unv	Ljava/util/ArrayList;
    //   22: iload_1
    //   23: invokevirtual 42	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   26: checkcast 44	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   29: astore_2
    //   30: ldc 34
    //   32: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: aload_0
    //   40: getfield 27	com/tencent/mm/plugin/appbrand/ui/recents/k:unw	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: aload_0
    //   45: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/k:unv	Ljava/util/ArrayList;
    //   48: invokevirtual 38	java/util/ArrayList:size	()I
    //   51: isub
    //   52: invokevirtual 42	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   55: checkcast 44	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   58: astore_2
    //   59: ldc 34
    //   61: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -29 -> 35
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	k
    //   0	72	1	paramInt	int
    //   29	30	2	localAppBrandRecentTaskInfo	AppBrandRecentTaskInfo
    //   67	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	67	finally
    //   39	64	67	finally
  }
  
  static k d(ArrayList<AppBrandRecentTaskInfo> paramArrayList1, ArrayList<AppBrandRecentTaskInfo> paramArrayList2)
  {
    AppMethodBeat.i(49210);
    k localk = new k();
    b.h(localk.unv, paramArrayList1);
    b.h(localk.unw, paramArrayList2);
    AppMethodBeat.o(49210);
    return localk;
  }
  
  /* Error */
  public final AppBrandRecentTaskInfo Dw(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 58
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: aload_0
    //   9: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/k:unv	Ljava/util/ArrayList;
    //   12: invokevirtual 38	java/util/ArrayList:size	()I
    //   15: if_icmpge +24 -> 39
    //   18: aload_0
    //   19: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/k:unv	Ljava/util/ArrayList;
    //   22: iload_1
    //   23: invokevirtual 61	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   26: checkcast 44	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   29: astore_2
    //   30: ldc 58
    //   32: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: aload_0
    //   40: getfield 27	com/tencent/mm/plugin/appbrand/ui/recents/k:unw	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: aload_0
    //   45: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/k:unv	Ljava/util/ArrayList;
    //   48: invokevirtual 38	java/util/ArrayList:size	()I
    //   51: isub
    //   52: invokevirtual 61	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   55: checkcast 44	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   58: astore_2
    //   59: ldc 58
    //   61: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -29 -> 35
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	k
    //   0	72	1	paramInt	int
    //   29	30	2	localAppBrandRecentTaskInfo	AppBrandRecentTaskInfo
    //   67	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	67	finally
    //   39	64	67	finally
  }
  
  final k a(k paramk)
  {
    try
    {
      AppMethodBeat.i(49212);
      paramk = e(paramk.unv, paramk.unw);
      AppMethodBeat.o(49212);
      return paramk;
    }
    finally
    {
      paramk = finally;
      throw paramk;
    }
  }
  
  public final boolean addAll(Collection<? extends AppBrandRecentTaskInfo> paramCollection)
  {
    AppMethodBeat.i(49213);
    if (k.class.isInstance(paramCollection)) {
      try
      {
        paramCollection = (k)paramCollection;
        this.unv.addAll(paramCollection.unv);
        this.unw.addAll(paramCollection.unw);
        return true;
      }
      finally
      {
        AppMethodBeat.o(49213);
      }
    }
    Assert.assertTrue("collection type mismatch!!", false);
    AppMethodBeat.o(49213);
    return false;
  }
  
  final ArrayList<AppBrandRecentTaskInfo> cMQ()
  {
    try
    {
      ArrayList localArrayList = this.unv;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final ArrayList<AppBrandRecentTaskInfo> cMR()
  {
    try
    {
      ArrayList localArrayList = this.unw;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final k cMS()
  {
    try
    {
      AppMethodBeat.i(49214);
      k localk = new k();
      localk.unv.addAll(this.unv);
      localk.unw.addAll(this.unw);
      AppMethodBeat.o(49214);
      return localk;
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
      AppMethodBeat.i(49218);
      this.unv.clear();
      this.unw.clear();
      AppMethodBeat.o(49218);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final k e(ArrayList<AppBrandRecentTaskInfo> paramArrayList1, ArrayList<AppBrandRecentTaskInfo> paramArrayList2)
  {
    try
    {
      AppMethodBeat.i(49211);
      this.unv.clear();
      if (!Util.isNullOrNil(paramArrayList1)) {
        this.unv.addAll(paramArrayList1);
      }
      this.unw.clear();
      if (!Util.isNullOrNil(paramArrayList2)) {
        this.unw.addAll(paramArrayList2);
      }
      AppMethodBeat.o(49211);
      return this;
    }
    finally {}
  }
  
  /* Error */
  public final boolean isEmpty()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 116
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 117	com/tencent/mm/plugin/appbrand/ui/recents/k:size	()I
    //   11: ifne +14 -> 25
    //   14: iconst_1
    //   15: istore_1
    //   16: ldc 116
    //   18: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: iconst_0
    //   26: istore_1
    //   27: ldc 116
    //   29: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: goto -11 -> 21
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	k
    //   15	12	1	bool	boolean
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	35	finally
    //   16	21	35	finally
    //   27	32	35	finally
  }
  
  public final Iterator<AppBrandRecentTaskInfo> iterator()
  {
    AppMethodBeat.i(49221);
    Assert.assertTrue("Why you need this?? call @smoothieli fix it", false);
    Iterator local1 = new Iterator()
    {
      public final boolean hasNext()
      {
        return false;
      }
      
      public final void remove() {}
    };
    AppMethodBeat.o(49221);
    return local1;
  }
  
  public final int size()
  {
    try
    {
      AppMethodBeat.i(49215);
      int i = this.unv.size();
      int j = this.unw.size();
      AppMethodBeat.o(49215);
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<AppBrandRecentTaskInfo> subList(int paramInt1, int paramInt2)
  {
    int i;
    try
    {
      AppMethodBeat.i(49220);
      i = size();
      if (paramInt1 < 0)
      {
        IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("fromIndex = ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(49220);
        throw localIndexOutOfBoundsException;
      }
    }
    finally {}
    Object localObject2;
    if (paramInt2 > i)
    {
      localObject2 = new IndexOutOfBoundsException("toIndex = ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(49220);
      throw ((Throwable)localObject2);
    }
    if (paramInt1 > paramInt2)
    {
      localObject2 = new IllegalArgumentException("fromIndex(" + paramInt1 + ") > toIndex(" + paramInt2 + ")");
      AppMethodBeat.o(49220);
      throw ((Throwable)localObject2);
    }
    if (paramInt1 == paramInt2)
    {
      localObject2 = Collections.emptyList();
      AppMethodBeat.o(49220);
    }
    for (;;)
    {
      return localObject2;
      localObject2 = new ArrayList(paramInt2 - paramInt1);
      while (paramInt1 < paramInt2)
      {
        ((ArrayList)localObject2).add(Dv(paramInt1));
        paramInt1 += 1;
      }
      AppMethodBeat.o(49220);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.k
 * JD-Core Version:    0.7.0.1
 */