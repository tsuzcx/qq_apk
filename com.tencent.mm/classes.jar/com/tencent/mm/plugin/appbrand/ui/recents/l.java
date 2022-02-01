package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

final class l
  extends ArrayList<AppBrandRecentTaskInfo>
{
  private final ArrayList<AppBrandRecentTaskInfo> lJd;
  private final ArrayList<AppBrandRecentTaskInfo> lJe;
  
  l()
  {
    AppMethodBeat.i(49209);
    this.lJd = new ArrayList(50);
    this.lJe = new ArrayList(10000);
    AppMethodBeat.o(49209);
  }
  
  static l d(ArrayList<AppBrandRecentTaskInfo> paramArrayList1, ArrayList<AppBrandRecentTaskInfo> paramArrayList2)
  {
    AppMethodBeat.i(49210);
    l locall = new l();
    b.c(locall.lJd, paramArrayList1);
    b.c(locall.lJe, paramArrayList2);
    AppMethodBeat.o(49210);
    return locall;
  }
  
  /* Error */
  private AppBrandRecentTaskInfo uf(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 46
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: aload_0
    //   9: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/l:lJd	Ljava/util/ArrayList;
    //   12: invokevirtual 50	java/util/ArrayList:size	()I
    //   15: if_icmpge +24 -> 39
    //   18: aload_0
    //   19: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/l:lJd	Ljava/util/ArrayList;
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
    //   40: getfield 27	com/tencent/mm/plugin/appbrand/ui/recents/l:lJe	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: aload_0
    //   45: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/l:lJd	Ljava/util/ArrayList;
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
    //   0	72	0	this	l
    //   0	72	1	paramInt	int
    //   29	30	2	localAppBrandRecentTaskInfo	AppBrandRecentTaskInfo
    //   67	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	67	finally
    //   39	64	67	finally
  }
  
  final l a(l paraml)
  {
    try
    {
      AppMethodBeat.i(49212);
      paraml = e(paraml.lJd, paraml.lJe);
      AppMethodBeat.o(49212);
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
    AppMethodBeat.i(49213);
    if (l.class.isInstance(paramCollection)) {
      try
      {
        paramCollection = (l)paramCollection;
        this.lJd.addAll(paramCollection.lJd);
        this.lJe.addAll(paramCollection.lJe);
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
  
  final ArrayList<AppBrandRecentTaskInfo> bpM()
  {
    try
    {
      ArrayList localArrayList = this.lJd;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final ArrayList<AppBrandRecentTaskInfo> bpN()
  {
    try
    {
      ArrayList localArrayList = this.lJe;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final l bpO()
  {
    try
    {
      AppMethodBeat.i(49214);
      l locall = new l();
      locall.lJd.addAll(this.lJd);
      locall.lJe.addAll(this.lJe);
      AppMethodBeat.o(49214);
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
      AppMethodBeat.i(49218);
      this.lJd.clear();
      this.lJe.clear();
      AppMethodBeat.o(49218);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final l e(ArrayList<AppBrandRecentTaskInfo> paramArrayList1, ArrayList<AppBrandRecentTaskInfo> paramArrayList2)
  {
    try
    {
      AppMethodBeat.i(49211);
      this.lJd.clear();
      if (!bt.gL(paramArrayList1)) {
        this.lJd.addAll(paramArrayList1);
      }
      this.lJe.clear();
      if (!bt.gL(paramArrayList2)) {
        this.lJe.addAll(paramArrayList2);
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
    //   2: ldc 111
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 112	com/tencent/mm/plugin/appbrand/ui/recents/l:size	()I
    //   11: ifne +14 -> 25
    //   14: iconst_1
    //   15: istore_1
    //   16: ldc 111
    //   18: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: iconst_0
    //   26: istore_1
    //   27: ldc 111
    //   29: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: goto -11 -> 21
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	l
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
      int i = this.lJd.size();
      int j = this.lJe.size();
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
        ((ArrayList)localObject2).add(uf(paramInt1));
        paramInt1 += 1;
      }
      AppMethodBeat.o(49220);
    }
  }
  
  /* Error */
  public final AppBrandRecentTaskInfo ug(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 183
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: aload_0
    //   9: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/l:lJd	Ljava/util/ArrayList;
    //   12: invokevirtual 50	java/util/ArrayList:size	()I
    //   15: if_icmpge +24 -> 39
    //   18: aload_0
    //   19: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/l:lJd	Ljava/util/ArrayList;
    //   22: iload_1
    //   23: invokevirtual 185	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   26: checkcast 56	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   29: astore_2
    //   30: ldc 183
    //   32: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: aload_0
    //   40: getfield 27	com/tencent/mm/plugin/appbrand/ui/recents/l:lJe	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: aload_0
    //   45: getfield 25	com/tencent/mm/plugin/appbrand/ui/recents/l:lJd	Ljava/util/ArrayList;
    //   48: invokevirtual 50	java/util/ArrayList:size	()I
    //   51: isub
    //   52: invokevirtual 185	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   55: checkcast 56	com/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo
    //   58: astore_2
    //   59: ldc 183
    //   61: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -29 -> 35
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	l
    //   0	72	1	paramInt	int
    //   29	30	2	localAppBrandRecentTaskInfo	AppBrandRecentTaskInfo
    //   67	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	67	finally
    //   39	64	67	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.l
 * JD-Core Version:    0.7.0.1
 */