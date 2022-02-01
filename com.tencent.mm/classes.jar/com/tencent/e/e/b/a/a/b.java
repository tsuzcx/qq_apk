package com.tencent.e.e.b.a.a;

import android.content.Context;
import android.os.Build;
import com.tencent.e.e.b.a.a.a.d;
import com.tencent.e.e.b.a.a.a.e;
import com.tencent.e.e.b.a.a.a.f;
import com.tencent.e.e.b.a.a.a.g;
import com.tencent.e.e.b.a.a.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static Map<String, a> ahuS;
  private static final c[] ahuT;
  private static final boolean[] ahuU;
  private static String ahuV;
  
  static
  {
    AppMethodBeat.i(138431);
    ahuS = new ConcurrentHashMap();
    ahuT = new c[] { null };
    ahuU = new boolean[] { false };
    ahuS.put("FF5E66B", new a(new i()));
    ahuS.put("C1AAFC7", new a(new com.tencent.e.e.b.a.a.a.c()));
    ahuS.put("E389A21", new a(new d()));
    ahuS.put("750379B", new a(new d()));
    ahuS.put("C892BA2", new a(new f()));
    ahuS.put("C1F2239", new a(new com.tencent.e.e.b.a.a.a.a()));
    ahuS.put("B09207F", new a(new com.tencent.e.e.b.a.a.a.h()));
    ahuS.put("43780D5", new a(new com.tencent.e.e.b.a.a.a.h()));
    ahuS.put("22C4185", new a(new e()));
    ahuS.put("FE54627", new a(new g()));
    ahuV = "";
    try
    {
      ahuV = com.tencent.e.e.b.a.a.b.b.du(com.tencent.e.e.b.a.a.b.a.dt(Build.MANUFACTURER.toLowerCase().getBytes())).substring(0, 7);
      return;
    }
    finally
    {
      AppMethodBeat.o(138431);
    }
  }
  
  private static void jXw()
  {
    synchronized (ahuU)
    {
      ahuU[0] = false;
      return;
    }
  }
  
  private static boolean jXx()
  {
    synchronized (ahuU)
    {
      int i = ahuU[0];
      return i;
    }
  }
  
  /* Error */
  public static c nY(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 146
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   17: iconst_0
    //   18: aaload
    //   19: ifnull +70 -> 89
    //   22: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   25: iconst_0
    //   26: aaload
    //   27: getfield 150	com/tencent/e/e/b/a/a/c:errorCode	I
    //   30: bipush 244
    //   32: if_icmpeq +57 -> 89
    //   35: ldc 152
    //   37: ldc 154
    //   39: iconst_2
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   48: iconst_0
    //   49: aaload
    //   50: getfield 150	com/tencent/e/e/b/a/a/c:errorCode	I
    //   53: invokestatic 160	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   62: iconst_0
    //   63: aaload
    //   64: getfield 163	com/tencent/e/e/b/a/a/c:PNk	Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   74: iconst_0
    //   75: aaload
    //   76: astore_0
    //   77: aload_1
    //   78: monitorexit
    //   79: ldc 146
    //   81: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_0
    //   88: areturn
    //   89: aload_1
    //   90: monitorexit
    //   91: invokestatic 170	com/tencent/e/e/b/a/a/b:jXx	()Z
    //   94: ifeq +68 -> 162
    //   97: ldc 152
    //   99: ldc 172
    //   101: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   107: astore_1
    //   108: aload_1
    //   109: monitorenter
    //   110: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   113: iconst_0
    //   114: bipush 244
    //   116: invokestatic 180	com/tencent/e/e/b/a/a/c:aHa	(I)Lcom/tencent/e/e/b/a/a/c;
    //   119: aastore
    //   120: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   123: iconst_0
    //   124: aaload
    //   125: astore_0
    //   126: aload_1
    //   127: monitorexit
    //   128: ldc 146
    //   130: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: goto -49 -> 84
    //   136: astore_0
    //   137: ldc 2
    //   139: monitorexit
    //   140: aload_0
    //   141: athrow
    //   142: astore_0
    //   143: aload_1
    //   144: monitorexit
    //   145: ldc 146
    //   147: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_0
    //   151: athrow
    //   152: astore_0
    //   153: aload_1
    //   154: monitorexit
    //   155: ldc 146
    //   157: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_0
    //   161: athrow
    //   162: getstatic 36	com/tencent/e/e/b/a/a/b:ahuS	Ljava/util/Map;
    //   165: getstatic 99	com/tencent/e/e/b/a/a/b:ahuV	Ljava/lang/String;
    //   168: invokeinterface 184 2 0
    //   173: checkcast 10	com/tencent/e/e/b/a/a/b$a
    //   176: astore_1
    //   177: aload_1
    //   178: ifnull +113 -> 291
    //   181: aload_1
    //   182: getfield 187	com/tencent/e/e/b/a/a/b$a:nrQ	I
    //   185: iconst_5
    //   186: if_icmpgt +56 -> 242
    //   189: aload_1
    //   190: aload_1
    //   191: getfield 187	com/tencent/e/e/b/a/a/b$a:nrQ	I
    //   194: iconst_1
    //   195: iadd
    //   196: putfield 187	com/tencent/e/e/b/a/a/b$a:nrQ	I
    //   199: ldc 152
    //   201: ldc 189
    //   203: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_0
    //   207: invokestatic 193	com/tencent/e/e/b/a/a/b:nZ	(Landroid/content/Context;)V
    //   210: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   213: astore_1
    //   214: aload_1
    //   215: monitorenter
    //   216: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   219: iconst_0
    //   220: bipush 244
    //   222: invokestatic 180	com/tencent/e/e/b/a/a/c:aHa	(I)Lcom/tencent/e/e/b/a/a/c;
    //   225: aastore
    //   226: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   229: iconst_0
    //   230: aaload
    //   231: astore_0
    //   232: aload_1
    //   233: monitorexit
    //   234: ldc 146
    //   236: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: goto -155 -> 84
    //   242: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   245: astore_1
    //   246: aload_1
    //   247: monitorenter
    //   248: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   251: iconst_0
    //   252: bipush 243
    //   254: invokestatic 180	com/tencent/e/e/b/a/a/c:aHa	(I)Lcom/tencent/e/e/b/a/a/c;
    //   257: aastore
    //   258: ldc 152
    //   260: ldc 195
    //   262: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   268: iconst_0
    //   269: aaload
    //   270: astore_0
    //   271: aload_1
    //   272: monitorexit
    //   273: ldc 146
    //   275: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: goto -194 -> 84
    //   281: astore_0
    //   282: aload_1
    //   283: monitorexit
    //   284: ldc 146
    //   286: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_0
    //   290: athrow
    //   291: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   294: astore_1
    //   295: aload_1
    //   296: monitorenter
    //   297: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   300: iconst_0
    //   301: bipush 246
    //   303: invokestatic 180	com/tencent/e/e/b/a/a/c:aHa	(I)Lcom/tencent/e/e/b/a/a/c;
    //   306: aastore
    //   307: ldc 152
    //   309: ldc 197
    //   311: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   317: iconst_0
    //   318: aaload
    //   319: astore_0
    //   320: aload_1
    //   321: monitorexit
    //   322: ldc 146
    //   324: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: goto -243 -> 84
    //   330: astore_0
    //   331: aload_1
    //   332: monitorexit
    //   333: ldc 146
    //   335: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_0
    //   339: athrow
    //   340: astore_0
    //   341: aload_1
    //   342: monitorexit
    //   343: ldc 146
    //   345: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: aload_0
    //   349: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	14	136	finally
    //   79	84	136	finally
    //   89	110	136	finally
    //   128	133	136	finally
    //   143	152	136	finally
    //   153	162	136	finally
    //   162	177	136	finally
    //   181	216	136	finally
    //   234	239	136	finally
    //   242	248	136	finally
    //   273	278	136	finally
    //   282	291	136	finally
    //   291	297	136	finally
    //   322	327	136	finally
    //   331	340	136	finally
    //   341	350	136	finally
    //   14	79	142	finally
    //   110	128	152	finally
    //   248	273	281	finally
    //   297	322	330	finally
    //   216	234	340	finally
  }
  
  /* Error */
  public static void nZ(Context arg0)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 198
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 152
    //   10: ldc 200
    //   12: invokestatic 202	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: invokestatic 170	com/tencent/e/e/b/a/a/b:jXx	()Z
    //   18: ifeq +29 -> 47
    //   21: ldc 152
    //   23: ldc 204
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: invokestatic 210	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   34: aastore
    //   35: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: ldc 198
    //   40: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: getstatic 42	com/tencent/e/e/b/a/a/b:ahuU	[Z
    //   50: astore_1
    //   51: aload_1
    //   52: monitorenter
    //   53: getstatic 42	com/tencent/e/e/b/a/a/b:ahuU	[Z
    //   56: iconst_0
    //   57: iconst_1
    //   58: bastore
    //   59: aload_1
    //   60: monitorexit
    //   61: getstatic 36	com/tencent/e/e/b/a/a/b:ahuS	Ljava/util/Map;
    //   64: getstatic 99	com/tencent/e/e/b/a/a/b:ahuV	Ljava/lang/String;
    //   67: invokeinterface 184 2 0
    //   72: checkcast 10	com/tencent/e/e/b/a/a/b$a
    //   75: astore_1
    //   76: aload_1
    //   77: ifnonnull +65 -> 142
    //   80: ldc 152
    //   82: ldc 214
    //   84: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   90: astore_0
    //   91: aload_0
    //   92: monitorenter
    //   93: getstatic 40	com/tencent/e/e/b/a/a/b:ahuT	[Lcom/tencent/e/e/b/a/a/c;
    //   96: iconst_0
    //   97: bipush 246
    //   99: invokestatic 180	com/tencent/e/e/b/a/a/c:aHa	(I)Lcom/tencent/e/e/b/a/a/c;
    //   102: aastore
    //   103: aload_0
    //   104: monitorexit
    //   105: invokestatic 139	com/tencent/e/e/b/a/a/b:jXw	()V
    //   108: ldc 198
    //   110: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: goto -70 -> 43
    //   116: astore_0
    //   117: ldc 2
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aload_1
    //   124: monitorexit
    //   125: ldc 198
    //   127: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_0
    //   131: athrow
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: ldc 198
    //   137: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_1
    //   141: athrow
    //   142: getstatic 223	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   145: new 6	com/tencent/e/e/b/a/a/b$1
    //   148: dup
    //   149: aload_1
    //   150: aload_0
    //   151: invokespecial 226	com/tencent/e/e/b/a/a/b$1:<init>	(Lcom/tencent/e/e/b/a/a/b$a;Landroid/content/Context;)V
    //   154: ldc 228
    //   156: invokeinterface 234 3 0
    //   161: pop
    //   162: ldc 198
    //   164: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   123	132	116	finally
    //   133	142	116	finally
    //   142	167	116	finally
    //   53	61	122	finally
    //   93	105	132	finally
  }
  
  static final class a
  {
    a ahuY;
    int nrQ = 0;
    
    public a(a parama)
    {
      this.ahuY = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.e.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */