package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dck;
import com.tencent.mm.protocal.protobuf.dcl;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private static final Map<Integer, WeakReference<Activity>> rhr;
  
  static
  {
    AppMethodBeat.i(122214);
    rhr = new HashMap();
    AppMethodBeat.o(122214);
  }
  
  public static void DA(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(122204);
        Object localObject1 = (WeakReference)rhr.get(Integer.valueOf(paramInt));
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
        if (((Activity)localObject1).isDestroyed())
        {
          AppMethodBeat.o(122204);
          continue;
        }
        localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
      }
      finally {}
      cie localcie;
      if (localcie != null) {
        b(localObject2, localcie, true);
      }
      AppMethodBeat.o(122204);
    }
  }
  
  public static void DB(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(122206);
        Object localObject1 = (WeakReference)rhr.get(Integer.valueOf(paramInt));
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
        if (((Activity)localObject1).isDestroyed())
        {
          AppMethodBeat.o(122206);
          continue;
        }
        localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
      }
      finally {}
      cie localcie;
      if (localcie != null) {
        b(localObject2, localcie, false);
      }
      AppMethodBeat.o(122206);
    }
  }
  
  private static void a(Object paramObject, cid paramcid, cie paramcie, boolean paramBoolean)
  {
    AppMethodBeat.i(122213);
    paramcie = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.gc(paramcie.sessionId, paramObject.getClass().getSimpleName());
    if (paramcie == null)
    {
      AppMethodBeat.o(122213);
      return;
    }
    bou localbou = (bou)paramcie.get(0);
    b.a(paramObject, paramcid, localbou, true, paramBoolean);
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localbou, ((Integer)paramcie.get(1)).intValue());
    AppMethodBeat.o(122213);
  }
  
  private static void a(Object paramObject, dcl paramdcl, cie paramcie, boolean paramBoolean)
  {
    AppMethodBeat.i(122212);
    paramdcl = paramdcl.GbV.iterator();
    while (paramdcl.hasNext())
    {
      cid localcid = (cid)paramdcl.next();
      if (localcid != null) {
        a(paramObject, localcid, paramcie, paramBoolean);
      }
    }
    AppMethodBeat.o(122212);
  }
  
  /* Error */
  private static void ak(Activity paramActivity)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 140
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 143	java/lang/Object:hashCode	()I
    //   12: istore_1
    //   13: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   16: iload_1
    //   17: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: invokeinterface 147 2 0
    //   25: ifne +48 -> 73
    //   28: new 43	java/lang/ref/WeakReference
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 150	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   36: astore_0
    //   37: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   40: iload_1
    //   41: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aload_0
    //   45: invokeinterface 154 3 0
    //   50: pop
    //   51: invokestatic 160	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:cpq	()Lcom/tencent/mm/plugin/expt/hellhound/core/a/a/c;
    //   54: sipush 402
    //   57: iload_1
    //   58: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 164	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:l	(ILjava/lang/Object;)V
    //   64: ldc 140
    //   66: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: ldc 2
    //   71: monitorexit
    //   72: return
    //   73: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
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
    //   100: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   103: iload_1
    //   104: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokeinterface 167 2 0
    //   112: pop
    //   113: new 43	java/lang/ref/WeakReference
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 150	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   121: astore_0
    //   122: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   125: iload_1
    //   126: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aload_0
    //   130: invokeinterface 154 3 0
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
  private static void al(Activity paramActivity)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 169
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 143	java/lang/Object:hashCode	()I
    //   12: istore_1
    //   13: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   16: iload_1
    //   17: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: invokeinterface 147 2 0
    //   25: ifne +48 -> 73
    //   28: new 43	java/lang/ref/WeakReference
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 150	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   36: astore_0
    //   37: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   40: iload_1
    //   41: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aload_0
    //   45: invokeinterface 154 3 0
    //   50: pop
    //   51: invokestatic 160	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:cpq	()Lcom/tencent/mm/plugin/expt/hellhound/core/a/a/c;
    //   54: sipush 403
    //   57: iload_1
    //   58: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 164	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:l	(ILjava/lang/Object;)V
    //   64: ldc 169
    //   66: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: ldc 2
    //   71: monitorexit
    //   72: return
    //   73: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
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
    //   100: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   103: iload_1
    //   104: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokeinterface 167 2 0
    //   112: pop
    //   113: new 43	java/lang/ref/WeakReference
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 150	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   121: astore_0
    //   122: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   125: iload_1
    //   126: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aload_0
    //   130: invokeinterface 154 3 0
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
      cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
      if (localcie != null) {
        b(paramFragment, localcie, true);
      }
      AppMethodBeat.o(122208);
      return;
      localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
      if (localcie != null) {
        b(paramFragment, localcie, false);
      }
    }
  }
  
  private static void b(Object paramObject, cie paramcie, boolean paramBoolean)
  {
    AppMethodBeat.i(122211);
    e.cry();
    Object localObject = e.crz();
    if ((localObject == null) || (((dck)localObject).fTh))
    {
      AppMethodBeat.o(122211);
      return;
    }
    localObject = ((dck)localObject).hFT.iterator();
    while (((Iterator)localObject).hasNext())
    {
      dcl localdcl = (dcl)((Iterator)localObject).next();
      if (localdcl != null) {
        a(paramObject, localdcl, paramcie, paramBoolean);
      }
    }
    AppMethodBeat.o(122211);
  }
  
  /* Error */
  public static void dj(java.lang.String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 198
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   11: invokeinterface 201 1 0
    //   16: ifeq +12 -> 28
    //   19: ldc 198
    //   21: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: iload_1
    //   29: ifle +58 -> 87
    //   32: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   35: iload_1
    //   36: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: invokeinterface 167 2 0
    //   44: pop
    //   45: ldc 198
    //   47: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: goto -26 -> 24
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    //   59: astore_0
    //   60: ldc 203
    //   62: aload_0
    //   63: ldc 205
    //   65: iconst_1
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_0
    //   72: invokevirtual 208	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   75: aastore
    //   76: invokestatic 214	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: ldc 198
    //   81: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: goto -60 -> 24
    //   87: new 216	java/util/ArrayList
    //   90: dup
    //   91: invokespecial 217	java/util/ArrayList:<init>	()V
    //   94: astore_2
    //   95: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   98: invokeinterface 221 1 0
    //   103: invokeinterface 224 1 0
    //   108: astore_3
    //   109: aload_3
    //   110: invokeinterface 130 1 0
    //   115: ifeq +97 -> 212
    //   118: aload_3
    //   119: invokeinterface 133 1 0
    //   124: checkcast 226	java/util/Map$Entry
    //   127: astore 4
    //   129: aload 4
    //   131: ifnull -22 -> 109
    //   134: aload 4
    //   136: invokeinterface 229 1 0
    //   141: checkcast 43	java/lang/ref/WeakReference
    //   144: invokevirtual 46	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   147: checkcast 48	android/app/Activity
    //   150: astore 5
    //   152: aload 5
    //   154: ifnonnull +20 -> 174
    //   157: aload_2
    //   158: aload 4
    //   160: invokeinterface 232 1 0
    //   165: invokeinterface 237 2 0
    //   170: pop
    //   171: goto -62 -> 109
    //   174: aload 5
    //   176: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   179: invokevirtual 240	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   182: astore 5
    //   184: aload 5
    //   186: ifnull -77 -> 109
    //   189: aload 5
    //   191: aload_0
    //   192: invokevirtual 245	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: ifeq -86 -> 109
    //   198: aload_2
    //   199: aload 4
    //   201: invokeinterface 232 1 0
    //   206: invokeinterface 237 2 0
    //   211: pop
    //   212: aload_2
    //   213: invokeinterface 246 1 0
    //   218: ifne +48 -> 266
    //   221: aload_2
    //   222: invokeinterface 247 1 0
    //   227: astore_0
    //   228: aload_0
    //   229: invokeinterface 130 1 0
    //   234: ifeq +32 -> 266
    //   237: aload_0
    //   238: invokeinterface 133 1 0
    //   243: checkcast 31	java/lang/Integer
    //   246: invokevirtual 108	java/lang/Integer:intValue	()I
    //   249: istore_1
    //   250: getstatic 23	com/tencent/mm/plugin/expt/hellhound/a/f/e/c:rhr	Ljava/util/Map;
    //   253: iload_1
    //   254: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: invokeinterface 167 2 0
    //   262: pop
    //   263: goto -35 -> 228
    //   266: ldc 198
    //   268: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: goto -247 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramString	java.lang.String
    //   0	274	1	paramInt	int
    //   94	128	2	localArrayList	java.util.ArrayList
    //   108	11	3	localIterator	Iterator
    //   127	73	4	localEntry	java.util.Map.Entry
    //   150	40	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	24	53	finally
    //   32	45	53	finally
    //   45	50	53	finally
    //   60	84	53	finally
    //   87	109	53	finally
    //   109	129	53	finally
    //   134	152	53	finally
    //   157	171	53	finally
    //   174	184	53	finally
    //   189	212	53	finally
    //   212	228	53	finally
    //   228	263	53	finally
    //   266	271	53	finally
    //   32	45	59	java/lang/NumberFormatException
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
      ak(paramActivity);
      AppMethodBeat.o(122202);
      return;
      al(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.c
 * JD-Core Version:    0.7.0.1
 */