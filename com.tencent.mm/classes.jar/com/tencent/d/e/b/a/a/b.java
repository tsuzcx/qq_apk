package com.tencent.d.e.b.a.a;

import android.content.Context;
import android.os.Build;
import com.tencent.d.e.b.a.a.a.e;
import com.tencent.d.e.b.a.a.a.f;
import com.tencent.d.e.b.a.a.a.g;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class b
{
  private static Map<String, a> Mlf;
  private static final c[] Mlg;
  private static final boolean[] Mlh;
  private static String Mli;
  
  static
  {
    AppMethodBeat.i(138431);
    Mlf = new ConcurrentHashMap();
    Mlg = new c[] { null };
    Mlh = new boolean[] { false };
    Mlf.put("FF5E66B", new a(new g()));
    Mlf.put("C1AAFC7", new a(new com.tencent.d.e.b.a.a.a.c()));
    Mlf.put("E389A21", new a(new com.tencent.d.e.b.a.a.a.d()));
    Mlf.put("750379B", new a(new com.tencent.d.e.b.a.a.a.d()));
    Mlf.put("C892BA2", new a(new e()));
    Mlf.put("C1F2239", new a(new com.tencent.d.e.b.a.a.a.a()));
    Mlf.put("B09207F", new a(new f()));
    Mli = "";
    try
    {
      Mli = com.tencent.d.e.b.a.a.b.b.cQ(com.tencent.d.e.b.a.a.b.a.cP(Build.MANUFACTURER.toLowerCase().getBytes())).substring(0, 7);
      AppMethodBeat.o(138431);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(138431);
    }
  }
  
  private static void fYB()
  {
    synchronized (Mlh)
    {
      Mlh[0] = false;
      return;
    }
  }
  
  private static boolean isInitializing()
  {
    synchronized (Mlh)
    {
      int i = Mlh[0];
      return i;
    }
  }
  
  /* Error */
  public static c kZ(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 136
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   17: iconst_0
    //   18: aaload
    //   19: ifnull +70 -> 89
    //   22: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   25: iconst_0
    //   26: aaload
    //   27: getfield 140	com/tencent/d/e/b/a/a/c:errorCode	I
    //   30: bipush 244
    //   32: if_icmpeq +57 -> 89
    //   35: ldc 142
    //   37: ldc 144
    //   39: iconst_2
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   48: iconst_0
    //   49: aaload
    //   50: getfield 140	com/tencent/d/e/b/a/a/c:errorCode	I
    //   53: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   62: iconst_0
    //   63: aaload
    //   64: getfield 153	com/tencent/d/e/b/a/a/c:zmV	Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 158	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   74: iconst_0
    //   75: aaload
    //   76: astore_0
    //   77: aload_1
    //   78: monitorexit
    //   79: ldc 136
    //   81: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_0
    //   88: areturn
    //   89: aload_1
    //   90: monitorexit
    //   91: invokestatic 160	com/tencent/d/e/b/a/a/b:isInitializing	()Z
    //   94: ifeq +68 -> 162
    //   97: ldc 142
    //   99: ldc 162
    //   101: invokestatic 166	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   107: astore_1
    //   108: aload_1
    //   109: monitorenter
    //   110: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   113: iconst_0
    //   114: bipush 244
    //   116: invokestatic 170	com/tencent/d/e/b/a/a/c:ahp	(I)Lcom/tencent/d/e/b/a/a/c;
    //   119: aastore
    //   120: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   123: iconst_0
    //   124: aaload
    //   125: astore_0
    //   126: aload_1
    //   127: monitorexit
    //   128: ldc 136
    //   130: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: goto -49 -> 84
    //   136: astore_0
    //   137: ldc 2
    //   139: monitorexit
    //   140: aload_0
    //   141: athrow
    //   142: astore_0
    //   143: aload_1
    //   144: monitorexit
    //   145: ldc 136
    //   147: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_0
    //   151: athrow
    //   152: astore_0
    //   153: aload_1
    //   154: monitorexit
    //   155: ldc 136
    //   157: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_0
    //   161: athrow
    //   162: getstatic 38	com/tencent/d/e/b/a/a/b:Mlf	Ljava/util/Map;
    //   165: getstatic 89	com/tencent/d/e/b/a/a/b:Mli	Ljava/lang/String;
    //   168: invokeinterface 174 2 0
    //   173: checkcast 10	com/tencent/d/e/b/a/a/b$a
    //   176: astore_1
    //   177: aload_1
    //   178: ifnull +113 -> 291
    //   181: aload_1
    //   182: getfield 177	com/tencent/d/e/b/a/a/b$a:hiJ	I
    //   185: iconst_5
    //   186: if_icmpgt +56 -> 242
    //   189: aload_1
    //   190: aload_1
    //   191: getfield 177	com/tencent/d/e/b/a/a/b$a:hiJ	I
    //   194: iconst_1
    //   195: iadd
    //   196: putfield 177	com/tencent/d/e/b/a/a/b$a:hiJ	I
    //   199: ldc 142
    //   201: ldc 179
    //   203: invokestatic 166	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_0
    //   207: invokestatic 183	com/tencent/d/e/b/a/a/b:la	(Landroid/content/Context;)V
    //   210: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   213: astore_1
    //   214: aload_1
    //   215: monitorenter
    //   216: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   219: iconst_0
    //   220: bipush 244
    //   222: invokestatic 170	com/tencent/d/e/b/a/a/c:ahp	(I)Lcom/tencent/d/e/b/a/a/c;
    //   225: aastore
    //   226: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   229: iconst_0
    //   230: aaload
    //   231: astore_0
    //   232: aload_1
    //   233: monitorexit
    //   234: ldc 136
    //   236: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: goto -155 -> 84
    //   242: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   245: astore_1
    //   246: aload_1
    //   247: monitorenter
    //   248: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   251: iconst_0
    //   252: bipush 243
    //   254: invokestatic 170	com/tencent/d/e/b/a/a/c:ahp	(I)Lcom/tencent/d/e/b/a/a/c;
    //   257: aastore
    //   258: ldc 142
    //   260: ldc 185
    //   262: invokestatic 166	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   268: iconst_0
    //   269: aaload
    //   270: astore_0
    //   271: aload_1
    //   272: monitorexit
    //   273: ldc 136
    //   275: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: goto -194 -> 84
    //   281: astore_0
    //   282: aload_1
    //   283: monitorexit
    //   284: ldc 136
    //   286: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_0
    //   290: athrow
    //   291: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   294: astore_1
    //   295: aload_1
    //   296: monitorenter
    //   297: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   300: iconst_0
    //   301: bipush 246
    //   303: invokestatic 170	com/tencent/d/e/b/a/a/c:ahp	(I)Lcom/tencent/d/e/b/a/a/c;
    //   306: aastore
    //   307: ldc 142
    //   309: ldc 187
    //   311: invokestatic 166	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   317: iconst_0
    //   318: aaload
    //   319: astore_0
    //   320: aload_1
    //   321: monitorexit
    //   322: ldc 136
    //   324: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: goto -243 -> 84
    //   330: astore_0
    //   331: aload_1
    //   332: monitorexit
    //   333: ldc 136
    //   335: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_0
    //   339: athrow
    //   340: astore_0
    //   341: aload_1
    //   342: monitorexit
    //   343: ldc 136
    //   345: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: aload_0
    //   349: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	14	136	finally
    //   79	84	136	finally
    //   91	110	136	finally
    //   128	133	136	finally
    //   145	152	136	finally
    //   155	162	136	finally
    //   162	177	136	finally
    //   181	216	136	finally
    //   234	239	136	finally
    //   242	248	136	finally
    //   273	278	136	finally
    //   284	291	136	finally
    //   291	297	136	finally
    //   322	327	136	finally
    //   333	340	136	finally
    //   343	350	136	finally
    //   14	79	142	finally
    //   89	91	142	finally
    //   143	145	142	finally
    //   110	128	152	finally
    //   153	155	152	finally
    //   248	273	281	finally
    //   282	284	281	finally
    //   297	322	330	finally
    //   331	333	330	finally
    //   216	234	340	finally
    //   341	343	340	finally
  }
  
  /* Error */
  public static void la(Context arg0)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 188
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 142
    //   10: ldc 190
    //   12: invokestatic 192	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: invokestatic 160	com/tencent/d/e/b/a/a/b:isInitializing	()Z
    //   18: ifeq +29 -> 47
    //   21: ldc 142
    //   23: ldc 194
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: invokestatic 200	com/tencent/mm/sdk/platformtools/bu:fpN	()Lcom/tencent/mm/sdk/platformtools/au;
    //   34: aastore
    //   35: invokestatic 202	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: ldc 188
    //   40: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: getstatic 44	com/tencent/d/e/b/a/a/b:Mlh	[Z
    //   50: astore_1
    //   51: aload_1
    //   52: monitorenter
    //   53: getstatic 44	com/tencent/d/e/b/a/a/b:Mlh	[Z
    //   56: iconst_0
    //   57: iconst_1
    //   58: bastore
    //   59: aload_1
    //   60: monitorexit
    //   61: getstatic 38	com/tencent/d/e/b/a/a/b:Mlf	Ljava/util/Map;
    //   64: getstatic 89	com/tencent/d/e/b/a/a/b:Mli	Ljava/lang/String;
    //   67: invokeinterface 174 2 0
    //   72: checkcast 10	com/tencent/d/e/b/a/a/b$a
    //   75: astore_1
    //   76: aload_1
    //   77: ifnonnull +65 -> 142
    //   80: ldc 142
    //   82: ldc 204
    //   84: invokestatic 207	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   90: astore_0
    //   91: aload_0
    //   92: monitorenter
    //   93: getstatic 42	com/tencent/d/e/b/a/a/b:Mlg	[Lcom/tencent/d/e/b/a/a/c;
    //   96: iconst_0
    //   97: bipush 246
    //   99: invokestatic 170	com/tencent/d/e/b/a/a/c:ahp	(I)Lcom/tencent/d/e/b/a/a/c;
    //   102: aastore
    //   103: aload_0
    //   104: monitorexit
    //   105: invokestatic 129	com/tencent/d/e/b/a/a/b:fYB	()V
    //   108: ldc 188
    //   110: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: goto -70 -> 43
    //   116: astore_0
    //   117: ldc 2
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aload_1
    //   124: monitorexit
    //   125: ldc 188
    //   127: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_0
    //   131: athrow
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: ldc 188
    //   137: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_1
    //   141: athrow
    //   142: getstatic 213	com/tencent/e/h:MqF	Lcom/tencent/e/i;
    //   145: new 6	com/tencent/d/e/b/a/a/b$1
    //   148: dup
    //   149: aload_1
    //   150: aload_0
    //   151: invokespecial 216	com/tencent/d/e/b/a/a/b$1:<init>	(Lcom/tencent/d/e/b/a/a/b$a;Landroid/content/Context;)V
    //   154: ldc 218
    //   156: invokeinterface 224 3 0
    //   161: pop
    //   162: ldc 188
    //   164: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: goto -124 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   132	18	1	locala	a
    // Exception table:
    //   from	to	target	type
    //   3	43	116	finally
    //   47	53	116	finally
    //   61	76	116	finally
    //   80	93	116	finally
    //   105	113	116	finally
    //   125	132	116	finally
    //   135	142	116	finally
    //   142	167	116	finally
    //   53	61	122	finally
    //   123	125	122	finally
    //   93	105	132	finally
    //   133	135	132	finally
  }
  
  static final class a
  {
    a Mll;
    int hiJ = 0;
    
    public a(a parama)
    {
      this.Mll = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */