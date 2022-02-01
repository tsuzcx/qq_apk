package com.tencent.mm.plugin.expt.hellhound.ext.session.d;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.e;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.ezj;
import com.tencent.mm.protocal.protobuf.ezk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private static final Map<Integer, WeakReference<Activity>> zKP;
  
  static
  {
    AppMethodBeat.i(122214);
    zKP = new HashMap();
    AppMethodBeat.o(122214);
  }
  
  public static void LW(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(122204);
        Object localObject1 = (WeakReference)zKP.get(Integer.valueOf(paramInt));
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
        localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
      }
      finally {}
      eah localeah;
      if (localeah != null) {
        b(localObject2, localeah, true);
      }
      AppMethodBeat.o(122204);
    }
  }
  
  public static void LX(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(122206);
        Object localObject1 = (WeakReference)zKP.get(Integer.valueOf(paramInt));
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
        localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
      }
      finally {}
      eah localeah;
      if (localeah != null) {
        b(localObject2, localeah, false);
      }
      AppMethodBeat.o(122206);
    }
  }
  
  private static void a(Object paramObject, eag parameag, eah parameah, boolean paramBoolean)
  {
    AppMethodBeat.i(122213);
    parameah = com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.hs(parameah.sessionId, paramObject.getClass().getSimpleName());
    if (parameah == null)
    {
      AppMethodBeat.o(122213);
      return;
    }
    czu localczu = (czu)parameah.get(0);
    b.a(paramObject, parameag, localczu, true, paramBoolean);
    com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(localczu, ((Integer)parameah.get(1)).intValue());
    AppMethodBeat.o(122213);
  }
  
  private static void a(Object paramObject, ezk paramezk, eah parameah, boolean paramBoolean)
  {
    AppMethodBeat.i(122212);
    paramezk = paramezk.YVe.iterator();
    while (paramezk.hasNext())
    {
      eag localeag = (eag)paramezk.next();
      if (localeag != null) {
        a(paramObject, localeag, parameah, paramBoolean);
      }
    }
    AppMethodBeat.o(122212);
  }
  
  /* Error */
  private static void aq(Activity paramActivity)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 140
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 143	java/lang/Object:hashCode	()I
    //   12: istore_1
    //   13: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
    //   16: iload_1
    //   17: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: invokeinterface 147 2 0
    //   25: ifne +48 -> 73
    //   28: new 43	java/lang/ref/WeakReference
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 150	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   36: astore_0
    //   37: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
    //   40: iload_1
    //   41: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aload_0
    //   45: invokeinterface 154 3 0
    //   50: pop
    //   51: invokestatic 160	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:dJd	()Lcom/tencent/mm/plugin/expt/hellhound/core/a/a/c;
    //   54: sipush 402
    //   57: iload_1
    //   58: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 164	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:I	(ILjava/lang/Object;)V
    //   64: ldc 140
    //   66: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: ldc 2
    //   71: monitorexit
    //   72: return
    //   73: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
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
    //   100: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
    //   103: iload_1
    //   104: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokeinterface 167 2 0
    //   112: pop
    //   113: new 43	java/lang/ref/WeakReference
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 150	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   121: astore_0
    //   122: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
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
  private static void ar(Activity paramActivity)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 169
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 143	java/lang/Object:hashCode	()I
    //   12: istore_1
    //   13: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
    //   16: iload_1
    //   17: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: invokeinterface 147 2 0
    //   25: ifne +48 -> 73
    //   28: new 43	java/lang/ref/WeakReference
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 150	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   36: astore_0
    //   37: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
    //   40: iload_1
    //   41: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aload_0
    //   45: invokeinterface 154 3 0
    //   50: pop
    //   51: invokestatic 160	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:dJd	()Lcom/tencent/mm/plugin/expt/hellhound/core/a/a/c;
    //   54: sipush 403
    //   57: iload_1
    //   58: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 164	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:I	(ILjava/lang/Object;)V
    //   64: ldc 169
    //   66: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: ldc 2
    //   71: monitorexit
    //   72: return
    //   73: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
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
    //   100: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
    //   103: iload_1
    //   104: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokeinterface 167 2 0
    //   112: pop
    //   113: new 43	java/lang/ref/WeakReference
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 150	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   121: astore_0
    //   122: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
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
    AppMethodBeat.i(300207);
    if (paramFragment == null)
    {
      AppMethodBeat.o(300207);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300207);
      return;
      eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
      if (localeah != null) {
        b(paramFragment, localeah, true);
      }
      AppMethodBeat.o(300207);
      return;
      localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
      if (localeah != null) {
        b(paramFragment, localeah, false);
      }
    }
  }
  
  private static void b(Object paramObject, eah parameah, boolean paramBoolean)
  {
    AppMethodBeat.i(122211);
    e.dLP();
    Object localObject = e.dLQ();
    if ((localObject == null) || (((ezj)localObject).lKI))
    {
      AppMethodBeat.o(122211);
      return;
    }
    localObject = ((ezj)localObject).nUC.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ezk localezk = (ezk)((Iterator)localObject).next();
      if (localezk != null) {
        a(paramObject, localezk, parameah, paramBoolean);
      }
    }
    AppMethodBeat.o(122211);
  }
  
  /* Error */
  public static void en(java.lang.String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 198
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
    //   11: invokeinterface 201 1 0
    //   16: ifeq +12 -> 28
    //   19: ldc 198
    //   21: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: iload_1
    //   29: ifle +58 -> 87
    //   32: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
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
    //   76: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: ldc 198
    //   81: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: goto -60 -> 24
    //   87: new 216	java/util/ArrayList
    //   90: dup
    //   91: invokespecial 217	java/util/ArrayList:<init>	()V
    //   94: astore_2
    //   95: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
    //   98: invokeinterface 221 1 0
    //   103: invokeinterface 224 1 0
    //   108: astore_3
    //   109: aload_3
    //   110: invokeinterface 130 1 0
    //   115: ifeq +103 -> 218
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
    //   154: ifnonnull +23 -> 177
    //   157: aload_2
    //   158: aload 4
    //   160: invokeinterface 232 1 0
    //   165: checkcast 31	java/lang/Integer
    //   168: invokeinterface 237 2 0
    //   173: pop
    //   174: goto -65 -> 109
    //   177: aload 5
    //   179: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   182: invokevirtual 240	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   185: astore 5
    //   187: aload 5
    //   189: ifnull -80 -> 109
    //   192: aload 5
    //   194: aload_0
    //   195: invokevirtual 245	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   198: ifeq -89 -> 109
    //   201: aload_2
    //   202: aload 4
    //   204: invokeinterface 232 1 0
    //   209: checkcast 31	java/lang/Integer
    //   212: invokeinterface 237 2 0
    //   217: pop
    //   218: aload_2
    //   219: invokeinterface 246 1 0
    //   224: ifne +48 -> 272
    //   227: aload_2
    //   228: invokeinterface 247 1 0
    //   233: astore_0
    //   234: aload_0
    //   235: invokeinterface 130 1 0
    //   240: ifeq +32 -> 272
    //   243: aload_0
    //   244: invokeinterface 133 1 0
    //   249: checkcast 31	java/lang/Integer
    //   252: invokevirtual 108	java/lang/Integer:intValue	()I
    //   255: istore_1
    //   256: getstatic 23	com/tencent/mm/plugin/expt/hellhound/ext/session/d/c:zKP	Ljava/util/Map;
    //   259: iload_1
    //   260: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   263: invokeinterface 167 2 0
    //   268: pop
    //   269: goto -35 -> 234
    //   272: ldc 198
    //   274: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: goto -253 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramString	java.lang.String
    //   0	280	1	paramInt	int
    //   94	134	2	localArrayList	java.util.ArrayList
    //   108	11	3	localIterator	Iterator
    //   127	76	4	localEntry	java.util.Map.Entry
    //   150	43	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	24	53	finally
    //   32	45	53	finally
    //   45	50	53	finally
    //   60	84	53	finally
    //   87	109	53	finally
    //   109	129	53	finally
    //   134	152	53	finally
    //   157	174	53	finally
    //   177	187	53	finally
    //   192	218	53	finally
    //   218	234	53	finally
    //   234	269	53	finally
    //   272	277	53	finally
    //   32	45	59	java/lang/NumberFormatException
  }
  
  public static void g(Activity paramActivity, int paramInt)
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
      aq(paramActivity);
      AppMethodBeat.o(122202);
      return;
      ar(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.d.c
 * JD-Core Version:    0.7.0.1
 */