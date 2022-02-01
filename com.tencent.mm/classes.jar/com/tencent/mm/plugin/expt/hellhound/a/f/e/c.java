package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.protocal.protobuf.cwe;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  private static Map<Integer, WeakReference<Activity>> qql;
  
  static
  {
    AppMethodBeat.i(122214);
    qql = new HashMap();
    AppMethodBeat.o(122214);
  }
  
  public static void CA(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(122204);
        Object localObject1 = (WeakReference)qql.get(Integer.valueOf(paramInt));
        if (localObject1 != null)
        {
          localObject1 = (Activity)((WeakReference)localObject1).get();
          if (localObject1 != null) {}
        }
        else
        {
          AppMethodBeat.o(122204);
          return;
        }
        localObject1.getClass().getCanonicalName();
        if (((Activity)localObject1).isDestroyed())
        {
          AppMethodBeat.o(122204);
          continue;
        }
        localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
      }
      finally {}
      ccs localccs;
      if (localccs != null) {
        b(localObject2, localccs, true);
      }
      AppMethodBeat.o(122204);
    }
  }
  
  public static void CB(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(122206);
        Object localObject1 = (WeakReference)qql.get(Integer.valueOf(paramInt));
        if (localObject1 != null)
        {
          localObject1 = (Activity)((WeakReference)localObject1).get();
          if (localObject1 != null) {}
        }
        else
        {
          AppMethodBeat.o(122206);
          return;
        }
        localObject1.getClass().getCanonicalName();
        if (((Activity)localObject1).isDestroyed())
        {
          AppMethodBeat.o(122206);
          continue;
        }
        localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
      }
      finally {}
      ccs localccs;
      if (localccs != null) {
        b(localObject2, localccs, false);
      }
      AppMethodBeat.o(122206);
    }
  }
  
  private static void a(Object paramObject, ccr paramccr, ccs paramccs, boolean paramBoolean)
  {
    AppMethodBeat.i(122213);
    paramccs = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.fO(paramccs.sessionId, paramObject.getClass().getSimpleName());
    if (paramccs == null)
    {
      AppMethodBeat.o(122213);
      return;
    }
    bju localbju = (bju)paramccs.get(0);
    b.a(paramObject, paramccr, localbju, true, paramBoolean);
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localbju, ((Integer)paramccs.get(1)).intValue());
    AppMethodBeat.o(122213);
  }
  
  private static void a(Object paramObject, cwe paramcwe, ccs paramccs, boolean paramBoolean)
  {
    AppMethodBeat.i(122212);
    paramObject.getClass().getSimpleName();
    paramcwe = paramcwe.FGL.iterator();
    while (paramcwe.hasNext())
    {
      ccr localccr = (ccr)paramcwe.next();
      if (localccr != null) {
        a(paramObject, localccr, paramccs, paramBoolean);
      }
    }
    AppMethodBeat.o(122212);
  }
  
  /* Error */
  private static void aj(Activity paramActivity)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 143
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 146	java/lang/Object:hashCode	()I
    //   12: istore_1
    //   13: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:qql	Ljava/util/Map;
    //   16: iload_1
    //   17: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: invokeinterface 150 2 0
    //   25: ifne +48 -> 73
    //   28: new 43	java/lang/ref/WeakReference
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 153	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   36: astore_0
    //   37: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:qql	Ljava/util/Map;
    //   40: iload_1
    //   41: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aload_0
    //   45: invokeinterface 157 3 0
    //   50: pop
    //   51: invokestatic 163	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:ciO	()Lcom/tencent/mm/plugin/expt/hellhound/core/a/a/c;
    //   54: sipush 402
    //   57: iload_1
    //   58: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 167	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:l	(ILjava/lang/Object;)V
    //   64: ldc 143
    //   66: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: ldc 2
    //   71: monitorexit
    //   72: return
    //   73: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:qql	Ljava/util/Map;
    //   76: iload_1
    //   77: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: invokeinterface 41 2 0
    //   85: checkcast 43	java/lang/ref/WeakReference
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +10 -> 100
    //   93: aload_2
    //   94: invokevirtual 46	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   97: ifnonnull -46 -> 51
    //   100: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:qql	Ljava/util/Map;
    //   103: iload_1
    //   104: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokeinterface 170 2 0
    //   112: pop
    //   113: new 43	java/lang/ref/WeakReference
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 153	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   121: astore_0
    //   122: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:qql	Ljava/util/Map;
    //   125: iload_1
    //   126: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aload_0
    //   130: invokeinterface 157 3 0
    //   135: pop
    //   136: goto -85 -> 51
    //   139: astore_0
    //   140: ldc 2
    //   142: monitorexit
    //   143: aload_0
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramActivity	Activity
    //   12	114	1	i	int
    //   88	6	2	localWeakReference	WeakReference
    // Exception table:
    //   from	to	target	type
    //   3	51	139	finally
    //   51	69	139	finally
    //   73	89	139	finally
    //   93	100	139	finally
    //   100	136	139	finally
  }
  
  /* Error */
  private static void ak(Activity paramActivity)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 172
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 146	java/lang/Object:hashCode	()I
    //   12: istore_1
    //   13: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:qql	Ljava/util/Map;
    //   16: iload_1
    //   17: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: invokeinterface 150 2 0
    //   25: ifne +48 -> 73
    //   28: new 43	java/lang/ref/WeakReference
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 153	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   36: astore_0
    //   37: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:qql	Ljava/util/Map;
    //   40: iload_1
    //   41: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aload_0
    //   45: invokeinterface 157 3 0
    //   50: pop
    //   51: invokestatic 163	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:ciO	()Lcom/tencent/mm/plugin/expt/hellhound/core/a/a/c;
    //   54: sipush 403
    //   57: iload_1
    //   58: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 167	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:l	(ILjava/lang/Object;)V
    //   64: ldc 172
    //   66: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: ldc 2
    //   71: monitorexit
    //   72: return
    //   73: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:qql	Ljava/util/Map;
    //   76: iload_1
    //   77: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: invokeinterface 41 2 0
    //   85: checkcast 43	java/lang/ref/WeakReference
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +10 -> 100
    //   93: aload_2
    //   94: invokevirtual 46	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   97: ifnonnull -46 -> 51
    //   100: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:qql	Ljava/util/Map;
    //   103: iload_1
    //   104: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokeinterface 170 2 0
    //   112: pop
    //   113: new 43	java/lang/ref/WeakReference
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 153	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   121: astore_0
    //   122: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:qql	Ljava/util/Map;
    //   125: iload_1
    //   126: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aload_0
    //   130: invokeinterface 157 3 0
    //   135: pop
    //   136: goto -85 -> 51
    //   139: astore_0
    //   140: ldc 2
    //   142: monitorexit
    //   143: aload_0
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramActivity	Activity
    //   12	114	1	i	int
    //   88	6	2	localWeakReference	WeakReference
    // Exception table:
    //   from	to	target	type
    //   3	51	139	finally
    //   51	69	139	finally
    //   73	89	139	finally
    //   93	100	139	finally
    //   100	136	139	finally
  }
  
  public static void b(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(122208);
    if (paramFragment == null)
    {
      AppMethodBeat.o(122208);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122208);
      return;
      ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
      if (localccs != null) {
        b(paramFragment, localccs, true);
      }
      AppMethodBeat.o(122208);
      return;
      localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
      if (localccs != null) {
        b(paramFragment, localccs, false);
      }
    }
  }
  
  private static void b(Object paramObject, ccs paramccs, boolean paramBoolean)
  {
    AppMethodBeat.i(122211);
    e.ckH();
    Object localObject = e.ckI();
    if ((localObject == null) || (((cwd)localObject).fxO))
    {
      AppMethodBeat.o(122211);
      return;
    }
    localObject = ((cwd)localObject).hkS.iterator();
    while (((Iterator)localObject).hasNext())
    {
      cwe localcwe = (cwe)((Iterator)localObject).next();
      if (localcwe != null) {
        a(paramObject, localcwe, paramccs, paramBoolean);
      }
    }
    AppMethodBeat.o(122211);
  }
  
  public static void f(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(122202);
    if (paramActivity == null)
    {
      AppMethodBeat.o(122202);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122202);
      return;
      aj(paramActivity);
      AppMethodBeat.o(122202);
      return;
      ak(paramActivity);
    }
  }
  
  public static void fP(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(122201);
        if (qql.isEmpty())
        {
          AppMethodBeat.o(122201);
          return;
        }
        boolean bool = TextUtils.isEmpty(paramString2);
        if (bool) {
          break label92;
        }
      }
      finally
      {
        try
        {
          qql.remove(Integer.valueOf(paramString2));
          AppMethodBeat.o(122201);
        }
        catch (NumberFormatException paramString1)
        {
          ac.printErrStackTrace("HABBYGE-MALI.HellSessionUBAParamsCatcher", paramString1, "HellSessionUBAParamsCatcher, onDestroy: %s", new Object[] { paramString1.getMessage() });
          AppMethodBeat.o(122201);
        }
        paramString1 = finally;
      }
      continue;
      label92:
      paramString2 = new ArrayList();
      Iterator localIterator = qql.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry != null)
        {
          Object localObject = (Activity)((WeakReference)localEntry.getValue()).get();
          if (localObject == null)
          {
            paramString2.add(localEntry.getKey());
          }
          else
          {
            localObject = localObject.getClass().getCanonicalName();
            if ((localObject != null) && (((String)localObject).equals(paramString1))) {
              paramString2.add(localEntry.getKey());
            }
          }
        }
      }
      if (!paramString2.isEmpty())
      {
        paramString1 = paramString2.iterator();
        while (paramString1.hasNext())
        {
          int i = ((Integer)paramString1.next()).intValue();
          qql.remove(Integer.valueOf(i));
        }
      }
      AppMethodBeat.o(122201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.c
 * JD-Core Version:    0.7.0.1
 */