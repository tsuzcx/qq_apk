package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.DownloadPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class le
{
  public final Map<String, a> a;
  public ExecutorService b;
  ExecutorService c;
  final Set<ld> d;
  private lc e;
  
  public le()
  {
    AppMethodBeat.i(222683);
    this.a = new Hashtable();
    this.d = new CopyOnWriteArraySet();
    AppMethodBeat.o(222683);
  }
  
  private void a(ExecutorService paramExecutorService)
  {
    this.b = paramExecutorService;
  }
  
  private void b()
  {
    try
    {
      AppMethodBeat.i(222691);
      this.e = null;
      if (this.b != null)
      {
        this.b.shutdownNow();
        this.b = null;
      }
      if (this.c != null)
      {
        this.c.shutdownNow();
        this.c = null;
      }
      this.d.clear();
      AppMethodBeat.o(222691);
      return;
    }
    finally {}
  }
  
  /* Error */
  private void b(String paramString, lc paramlc, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 150
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_3
    //   9: invokestatic 59	com/tencent/map/lib/models/DownloadPriority:get	(I)Lcom/tencent/map/lib/models/DownloadPriority;
    //   12: getstatic 63	com/tencent/map/lib/models/DownloadPriority:NONE	Lcom/tencent/map/lib/models/DownloadPriority;
    //   15: if_acmpeq +13 -> 28
    //   18: invokestatic 69	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   21: iload_3
    //   22: invokestatic 73	com/tencent/map/lib/models/DownloadPriority:getThreadPriority	(I)I
    //   25: invokevirtual 76	java/lang/Thread:setPriority	(I)V
    //   28: aload_0
    //   29: getfield 39	com/tencent/mapsdk/internal/le:a	Ljava/util/Map;
    //   32: aload_1
    //   33: invokeinterface 81 2 0
    //   38: checkcast 12	com/tencent/mapsdk/internal/le$a
    //   41: astore 5
    //   43: aload 5
    //   45: ifnonnull +22 -> 67
    //   48: aload_0
    //   49: aload_1
    //   50: aconst_null
    //   51: getstatic 86	com/tencent/mapsdk/internal/lf:e	Lcom/tencent/mapsdk/internal/lf;
    //   54: invokevirtual 89	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
    //   57: aload_2
    //   58: invokevirtual 93	com/tencent/mapsdk/internal/lc:b	()V
    //   61: ldc 150
    //   63: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: return
    //   67: aload 5
    //   69: invokevirtual 96	com/tencent/mapsdk/internal/le$a:a	()Z
    //   72: ifeq +22 -> 94
    //   75: aload_0
    //   76: aload_1
    //   77: aconst_null
    //   78: getstatic 98	com/tencent/mapsdk/internal/lf:c	Lcom/tencent/mapsdk/internal/lf;
    //   81: invokevirtual 89	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
    //   84: aload_2
    //   85: invokevirtual 93	com/tencent/mapsdk/internal/lc:b	()V
    //   88: ldc 150
    //   90: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: aload_2
    //   95: aload_1
    //   96: invokevirtual 101	com/tencent/mapsdk/internal/lc:e	(Ljava/lang/String;)Ljava/io/InputStream;
    //   99: astore 6
    //   101: aload_0
    //   102: aload_1
    //   103: aconst_null
    //   104: aload 5
    //   106: getfield 103	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
    //   109: invokevirtual 89	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
    //   112: aload 5
    //   114: invokevirtual 104	com/tencent/mapsdk/internal/le$a:b	()V
    //   117: aload 5
    //   119: getfield 103	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
    //   122: astore 7
    //   124: aload 6
    //   126: ifnull +160 -> 286
    //   129: ldc 105
    //   131: newarray byte
    //   133: astore 4
    //   135: aload 4
    //   137: arraylength
    //   138: ifeq +116 -> 254
    //   141: aload 6
    //   143: invokestatic 110	com/tencent/mapsdk/internal/kb:a	(Ljava/io/InputStream;)[B
    //   146: astore 4
    //   148: aload 4
    //   150: ifnull +39 -> 189
    //   153: aload_0
    //   154: aload_1
    //   155: aload 4
    //   157: aload 7
    //   159: invokevirtual 89	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
    //   162: aload 5
    //   164: invokevirtual 96	com/tencent/mapsdk/internal/le$a:a	()Z
    //   167: ifeq -32 -> 135
    //   170: aload_0
    //   171: aload_1
    //   172: aconst_null
    //   173: getstatic 98	com/tencent/mapsdk/internal/lf:c	Lcom/tencent/mapsdk/internal/lf;
    //   176: invokevirtual 89	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
    //   179: aload_2
    //   180: invokevirtual 93	com/tencent/mapsdk/internal/lc:b	()V
    //   183: ldc 150
    //   185: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: return
    //   189: new 112	java/lang/IllegalStateException
    //   192: dup
    //   193: ldc 114
    //   195: invokespecial 117	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   198: astore 4
    //   200: ldc 150
    //   202: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload 4
    //   207: athrow
    //   208: astore 4
    //   210: aload 5
    //   212: astore 4
    //   214: aload 4
    //   216: ifnull +8 -> 224
    //   219: aload 4
    //   221: invokevirtual 120	com/tencent/mapsdk/internal/le$a:f	()V
    //   224: aload 4
    //   226: ifnull +129 -> 355
    //   229: aload 4
    //   231: getfield 103	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
    //   234: astore 4
    //   236: aload_0
    //   237: aload_1
    //   238: aconst_null
    //   239: aload 4
    //   241: invokevirtual 89	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
    //   244: aload_2
    //   245: invokevirtual 93	com/tencent/mapsdk/internal/lc:b	()V
    //   248: ldc 150
    //   250: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: return
    //   254: aload 6
    //   256: invokestatic 123	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   259: aload 5
    //   261: invokevirtual 96	com/tencent/mapsdk/internal/le$a:a	()Z
    //   264: ifeq +64 -> 328
    //   267: aload_0
    //   268: aload_1
    //   269: aconst_null
    //   270: getstatic 98	com/tencent/mapsdk/internal/lf:c	Lcom/tencent/mapsdk/internal/lf;
    //   273: invokevirtual 89	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
    //   276: aload_2
    //   277: invokevirtual 93	com/tencent/mapsdk/internal/lc:b	()V
    //   280: ldc 150
    //   282: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: return
    //   286: aload_2
    //   287: aload_1
    //   288: invokevirtual 126	com/tencent/mapsdk/internal/lc:f	(Ljava/lang/String;)[B
    //   291: astore 6
    //   293: aload 6
    //   295: ifnull +76 -> 371
    //   298: aload 6
    //   300: arraylength
    //   301: ifne +70 -> 371
    //   304: aload_0
    //   305: aload_1
    //   306: aload 4
    //   308: aload 7
    //   310: invokevirtual 89	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
    //   313: goto -54 -> 259
    //   316: astore_1
    //   317: aload_2
    //   318: invokevirtual 93	com/tencent/mapsdk/internal/lc:b	()V
    //   321: ldc 150
    //   323: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_1
    //   327: athrow
    //   328: aload 5
    //   330: invokevirtual 128	com/tencent/mapsdk/internal/le$a:e	()V
    //   333: aload_0
    //   334: aload_1
    //   335: aload 4
    //   337: aload 5
    //   339: getfield 103	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
    //   342: invokevirtual 89	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
    //   345: aload_2
    //   346: invokevirtual 93	com/tencent/mapsdk/internal/lc:b	()V
    //   349: ldc 150
    //   351: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: return
    //   355: getstatic 86	com/tencent/mapsdk/internal/lf:e	Lcom/tencent/mapsdk/internal/lf;
    //   358: astore 4
    //   360: goto -124 -> 236
    //   363: astore 4
    //   365: aconst_null
    //   366: astore 4
    //   368: goto -154 -> 214
    //   371: aload 6
    //   373: astore 4
    //   375: goto -71 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	this	le
    //   0	378	1	paramString	String
    //   0	378	2	paramlc	lc
    //   0	378	3	paramInt	int
    //   1	205	4	localObject1	Object
    //   208	1	4	localException1	Exception
    //   212	147	4	localObject2	Object
    //   363	1	4	localException2	Exception
    //   366	8	4	localObject3	Object
    //   41	297	5	locala	a
    //   99	273	6	localObject4	Object
    //   122	187	7	locallf	lf
    // Exception table:
    //   from	to	target	type
    //   48	57	208	java/lang/Exception
    //   67	84	208	java/lang/Exception
    //   94	124	208	java/lang/Exception
    //   129	135	208	java/lang/Exception
    //   135	148	208	java/lang/Exception
    //   153	162	208	java/lang/Exception
    //   162	179	208	java/lang/Exception
    //   189	208	208	java/lang/Exception
    //   254	259	208	java/lang/Exception
    //   259	276	208	java/lang/Exception
    //   286	293	208	java/lang/Exception
    //   298	304	208	java/lang/Exception
    //   304	313	208	java/lang/Exception
    //   328	345	208	java/lang/Exception
    //   8	28	316	finally
    //   28	43	316	finally
    //   48	57	316	finally
    //   67	84	316	finally
    //   94	124	316	finally
    //   129	135	316	finally
    //   135	148	316	finally
    //   153	162	316	finally
    //   162	179	316	finally
    //   189	208	316	finally
    //   219	224	316	finally
    //   229	236	316	finally
    //   236	244	316	finally
    //   254	259	316	finally
    //   259	276	316	finally
    //   286	293	316	finally
    //   298	304	316	finally
    //   304	313	316	finally
    //   328	345	316	finally
    //   355	360	316	finally
    //   8	28	363	java/lang/Exception
    //   28	43	363	java/lang/Exception
  }
  
  private Runnable c(String paramString)
  {
    AppMethodBeat.i(222713);
    paramString = (a)this.a.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.a;
      AppMethodBeat.o(222713);
      return paramString;
    }
    AppMethodBeat.o(222713);
    return null;
  }
  
  public final void a()
  {
    try
    {
      AppMethodBeat.i(222753);
      b();
      AppMethodBeat.o(222753);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(ld paramld)
  {
    AppMethodBeat.i(222740);
    if (paramld != null)
    {
      this.d.remove(paramld);
      this.d.add(paramld);
    }
    AppMethodBeat.o(222740);
  }
  
  public final void a(String paramString)
  {
    try
    {
      AppMethodBeat.i(222778);
      paramString = (a)this.a.remove(paramString);
      if (paramString != null) {
        paramString.d();
      }
      AppMethodBeat.o(222778);
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, lc paramlc)
  {
    try
    {
      AppMethodBeat.i(222760);
      a(paramString, paramlc, DownloadPriority.NONE.getValue());
      AppMethodBeat.o(222760);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(final String paramString, final lc paramlc, final int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(222768);
        if (paramlc != null) {
          continue;
        }
        AppMethodBeat.o(222768);
      }
      finally
      {
        try
        {
          if (!hb.a(this.b))
          {
            a locala = new a((byte)0);
            this.a.put(paramString, locala);
            locala.a = new Runnable()
            {
              /* Error */
              public final void run()
              {
                // Byte code:
                //   0: aconst_null
                //   1: astore_2
                //   2: ldc 36
                //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
                //   7: aload_0
                //   8: getfield 22	com/tencent/mapsdk/internal/le$1:d	Lcom/tencent/mapsdk/internal/le;
                //   11: astore 6
                //   13: aload_0
                //   14: getfield 24	com/tencent/mapsdk/internal/le$1:a	Ljava/lang/String;
                //   17: astore 7
                //   19: aload_0
                //   20: getfield 26	com/tencent/mapsdk/internal/le$1:b	Lcom/tencent/mapsdk/internal/lc;
                //   23: astore 5
                //   25: aload_0
                //   26: getfield 28	com/tencent/mapsdk/internal/le$1:c	I
                //   29: istore_1
                //   30: iload_1
                //   31: invokestatic 48	com/tencent/map/lib/models/DownloadPriority:get	(I)Lcom/tencent/map/lib/models/DownloadPriority;
                //   34: getstatic 52	com/tencent/map/lib/models/DownloadPriority:NONE	Lcom/tencent/map/lib/models/DownloadPriority;
                //   37: if_acmpeq +13 -> 50
                //   40: invokestatic 58	java/lang/Thread:currentThread	()Ljava/lang/Thread;
                //   43: iload_1
                //   44: invokestatic 62	com/tencent/map/lib/models/DownloadPriority:getThreadPriority	(I)I
                //   47: invokevirtual 65	java/lang/Thread:setPriority	(I)V
                //   50: aload 6
                //   52: getfield 68	com/tencent/mapsdk/internal/le:a	Ljava/util/Map;
                //   55: aload 7
                //   57: invokeinterface 73 2 0
                //   62: checkcast 75	com/tencent/mapsdk/internal/le$a
                //   65: astore_3
                //   66: aload_3
                //   67: ifnonnull +25 -> 92
                //   70: aload 6
                //   72: aload 7
                //   74: aconst_null
                //   75: getstatic 81	com/tencent/mapsdk/internal/lf:e	Lcom/tencent/mapsdk/internal/lf;
                //   78: invokevirtual 84	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
                //   81: aload 5
                //   83: invokevirtual 88	com/tencent/mapsdk/internal/lc:b	()V
                //   86: ldc 36
                //   88: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   91: return
                //   92: aload_3
                //   93: invokevirtual 94	com/tencent/mapsdk/internal/le$a:a	()Z
                //   96: ifeq +25 -> 121
                //   99: aload 6
                //   101: aload 7
                //   103: aconst_null
                //   104: getstatic 96	com/tencent/mapsdk/internal/lf:c	Lcom/tencent/mapsdk/internal/lf;
                //   107: invokevirtual 84	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
                //   110: aload 5
                //   112: invokevirtual 88	com/tencent/mapsdk/internal/lc:b	()V
                //   115: ldc 36
                //   117: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   120: return
                //   121: aload 5
                //   123: aload 7
                //   125: invokevirtual 99	com/tencent/mapsdk/internal/lc:e	(Ljava/lang/String;)Ljava/io/InputStream;
                //   128: astore 4
                //   130: aload 6
                //   132: aload 7
                //   134: aconst_null
                //   135: aload_3
                //   136: getfield 101	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
                //   139: invokevirtual 84	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
                //   142: aload_3
                //   143: invokevirtual 102	com/tencent/mapsdk/internal/le$a:b	()V
                //   146: aload_3
                //   147: getfield 101	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
                //   150: astore 8
                //   152: aload 4
                //   154: ifnull +153 -> 307
                //   157: ldc 103
                //   159: newarray byte
                //   161: astore_2
                //   162: aload_2
                //   163: arraylength
                //   164: ifeq +109 -> 273
                //   167: aload 4
                //   169: invokestatic 108	com/tencent/mapsdk/internal/kb:a	(Ljava/io/InputStream;)[B
                //   172: astore_2
                //   173: aload_2
                //   174: ifnull +42 -> 216
                //   177: aload 6
                //   179: aload 7
                //   181: aload_2
                //   182: aload 8
                //   184: invokevirtual 84	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
                //   187: aload_3
                //   188: invokevirtual 94	com/tencent/mapsdk/internal/le$a:a	()Z
                //   191: ifeq -29 -> 162
                //   194: aload 6
                //   196: aload 7
                //   198: aconst_null
                //   199: getstatic 96	com/tencent/mapsdk/internal/lf:c	Lcom/tencent/mapsdk/internal/lf;
                //   202: invokevirtual 84	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
                //   205: aload 5
                //   207: invokevirtual 88	com/tencent/mapsdk/internal/lc:b	()V
                //   210: ldc 36
                //   212: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   215: return
                //   216: new 110	java/lang/IllegalStateException
                //   219: dup
                //   220: ldc 112
                //   222: invokespecial 115	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
                //   225: astore_2
                //   226: ldc 36
                //   228: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   231: aload_2
                //   232: athrow
                //   233: astore_2
                //   234: aload_3
                //   235: astore_2
                //   236: aload_2
                //   237: ifnull +7 -> 244
                //   240: aload_2
                //   241: invokevirtual 118	com/tencent/mapsdk/internal/le$a:f	()V
                //   244: aload_2
                //   245: ifnull +135 -> 380
                //   248: aload_2
                //   249: getfield 101	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
                //   252: astore_2
                //   253: aload 6
                //   255: aload 7
                //   257: aconst_null
                //   258: aload_2
                //   259: invokevirtual 84	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
                //   262: aload 5
                //   264: invokevirtual 88	com/tencent/mapsdk/internal/lc:b	()V
                //   267: ldc 36
                //   269: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   272: return
                //   273: aload 4
                //   275: invokestatic 121	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
                //   278: aload_3
                //   279: invokevirtual 94	com/tencent/mapsdk/internal/le$a:a	()Z
                //   282: ifeq +71 -> 353
                //   285: aload 6
                //   287: aload 7
                //   289: aconst_null
                //   290: getstatic 96	com/tencent/mapsdk/internal/lf:c	Lcom/tencent/mapsdk/internal/lf;
                //   293: invokevirtual 84	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
                //   296: aload 5
                //   298: invokevirtual 88	com/tencent/mapsdk/internal/lc:b	()V
                //   301: ldc 36
                //   303: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   306: return
                //   307: aload 5
                //   309: aload 7
                //   311: invokevirtual 124	com/tencent/mapsdk/internal/lc:f	(Ljava/lang/String;)[B
                //   314: astore 4
                //   316: aload 4
                //   318: ifnull +75 -> 393
                //   321: aload 4
                //   323: arraylength
                //   324: ifne +69 -> 393
                //   327: aload 6
                //   329: aload 7
                //   331: aload_2
                //   332: aload 8
                //   334: invokevirtual 84	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
                //   337: goto -59 -> 278
                //   340: astore_2
                //   341: aload 5
                //   343: invokevirtual 88	com/tencent/mapsdk/internal/lc:b	()V
                //   346: ldc 36
                //   348: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   351: aload_2
                //   352: athrow
                //   353: aload_3
                //   354: invokevirtual 126	com/tencent/mapsdk/internal/le$a:e	()V
                //   357: aload 6
                //   359: aload 7
                //   361: aload_2
                //   362: aload_3
                //   363: getfield 101	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
                //   366: invokevirtual 84	com/tencent/mapsdk/internal/le:a	(Ljava/lang/String;[BLcom/tencent/mapsdk/internal/lf;)V
                //   369: aload 5
                //   371: invokevirtual 88	com/tencent/mapsdk/internal/lc:b	()V
                //   374: ldc 36
                //   376: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   379: return
                //   380: getstatic 81	com/tencent/mapsdk/internal/lf:e	Lcom/tencent/mapsdk/internal/lf;
                //   383: astore_2
                //   384: goto -131 -> 253
                //   387: astore_2
                //   388: aconst_null
                //   389: astore_2
                //   390: goto -154 -> 236
                //   393: aload 4
                //   395: astore_2
                //   396: goto -69 -> 327
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	399	0	this	1
                //   29	15	1	i	int
                //   1	231	2	localObject1	Object
                //   233	1	2	localException1	Exception
                //   235	97	2	localObject2	Object
                //   340	22	2	arrayOfByte	byte[]
                //   383	1	2	locallf1	lf
                //   387	1	2	localException2	Exception
                //   389	7	2	localObject3	Object
                //   65	298	3	locala	le.a
                //   128	266	4	localObject4	Object
                //   23	347	5	locallc	lc
                //   11	347	6	localle	le
                //   17	343	7	str	String
                //   150	183	8	locallf2	lf
                // Exception table:
                //   from	to	target	type
                //   70	81	233	java/lang/Exception
                //   92	110	233	java/lang/Exception
                //   121	152	233	java/lang/Exception
                //   157	162	233	java/lang/Exception
                //   162	173	233	java/lang/Exception
                //   177	187	233	java/lang/Exception
                //   187	205	233	java/lang/Exception
                //   216	233	233	java/lang/Exception
                //   273	278	233	java/lang/Exception
                //   278	296	233	java/lang/Exception
                //   307	316	233	java/lang/Exception
                //   321	327	233	java/lang/Exception
                //   327	337	233	java/lang/Exception
                //   353	369	233	java/lang/Exception
                //   30	50	340	finally
                //   50	66	340	finally
                //   70	81	340	finally
                //   92	110	340	finally
                //   121	152	340	finally
                //   157	162	340	finally
                //   162	173	340	finally
                //   177	187	340	finally
                //   187	205	340	finally
                //   216	233	340	finally
                //   240	244	340	finally
                //   248	253	340	finally
                //   253	262	340	finally
                //   273	278	340	finally
                //   278	296	340	finally
                //   307	316	340	finally
                //   321	327	340	finally
                //   327	337	340	finally
                //   353	369	340	finally
                //   380	384	340	finally
                //   30	50	387	java/lang/Exception
                //   50	66	387	java/lang/Exception
              }
            };
            locala.c = paramlc;
            locala.a(this.b);
          }
          AppMethodBeat.o(222768);
        }
        catch (IllegalMonitorStateException paramString)
        {
          AppMethodBeat.o(222768);
        }
        paramString = finally;
      }
      return;
      if ((this.b == null) || (hb.a(this.b))) {
        this.b = hb.c();
      }
    }
  }
  
  final void a(final String paramString, final byte[] paramArrayOfByte, final lf paramlf)
  {
    AppMethodBeat.i(222793);
    if ((this.d.isEmpty()) || (paramlf == null))
    {
      AppMethodBeat.o(222793);
      return;
    }
    if ((this.c == null) || (hb.a(this.c))) {
      this.c = hb.b();
    }
    if (!this.c.isShutdown()) {
      this.c.execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224916);
          for (;;)
          {
            ld localld;
            try
            {
              Iterator localIterator = le.this.d.iterator();
              if (!localIterator.hasNext()) {
                break label257;
              }
              localld = (ld)localIterator.next();
              if (!le.this.c.isShutdown())
              {
                boolean bool = le.this.c.isTerminated();
                if (!bool) {}
              }
              else
              {
                AppMethodBeat.o(224916);
                return;
              }
              localld.a(paramlf);
              switch (le.3.a[paramlf.ordinal()])
              {
              case 1: 
                localld.a(paramString);
                break;
              case 2: 
                localld.b(paramString);
              }
            }
            catch (Exception localException)
            {
              AppMethodBeat.o(224916);
              return;
            }
            localld.a(paramString, paramArrayOfByte);
            continue;
            if (paramArrayOfByte == null) {
              localld.d(paramString);
            }
            localld.a(paramString, paramArrayOfByte);
            continue;
            if (paramArrayOfByte == null) {
              localld.d(paramString);
            }
            localld.a(paramString, paramArrayOfByte);
            localld.c(paramString);
            continue;
            label257:
            AppMethodBeat.o(224916);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(222793);
  }
  
  public final void b(ld paramld)
  {
    AppMethodBeat.i(222747);
    this.d.remove(paramld);
    AppMethodBeat.o(222747);
  }
  
  public final void b(String paramString)
  {
    try
    {
      AppMethodBeat.i(222786);
      paramString = (a)this.a.remove(paramString);
      if (paramString != null) {
        paramString.c();
      }
      AppMethodBeat.o(222786);
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    public Runnable a;
    Future b;
    lc c;
    lf d;
    
    public final void a(ExecutorService paramExecutorService)
    {
      try
      {
        AppMethodBeat.i(223385);
        if ((this.d == null) && (this.a != null) && (paramExecutorService != null) && (!hb.a(paramExecutorService)))
        {
          this.d = lf.a;
          this.b = paramExecutorService.submit(this.a);
        }
        AppMethodBeat.o(223385);
        return;
      }
      finally {}
    }
    
    public final boolean a()
    {
      return this.d == lf.c;
    }
    
    public final void b()
    {
      try
      {
        if (this.d == lf.a) {
          this.d = lf.b;
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    public final void c()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 59
      //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 31	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
      //   11: ifnonnull +11 -> 22
      //   14: ldc 59
      //   16: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: aload_0
      //   23: getfield 50	com/tencent/mapsdk/internal/le$a:b	Ljava/util/concurrent/Future;
      //   26: ifnull +14 -> 40
      //   29: aload_0
      //   30: getfield 50	com/tencent/mapsdk/internal/le$a:b	Ljava/util/concurrent/Future;
      //   33: iconst_1
      //   34: invokeinterface 65 2 0
      //   39: pop
      //   40: aload_0
      //   41: getfield 67	com/tencent/mapsdk/internal/le$a:c	Lcom/tencent/mapsdk/internal/lc;
      //   44: ifnull +10 -> 54
      //   47: aload_0
      //   48: getfield 67	com/tencent/mapsdk/internal/le$a:c	Lcom/tencent/mapsdk/internal/lc;
      //   51: invokevirtual 71	com/tencent/mapsdk/internal/lc:a	()V
      //   54: aload_0
      //   55: getstatic 56	com/tencent/mapsdk/internal/lf:c	Lcom/tencent/mapsdk/internal/lf;
      //   58: putfield 31	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
      //   61: ldc 59
      //   63: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: goto -47 -> 19
      //   69: astore_1
      //   70: aload_0
      //   71: monitorexit
      //   72: aload_1
      //   73: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	a
      //   69	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	69	finally
      //   22	40	69	finally
      //   40	54	69	finally
      //   54	66	69	finally
    }
    
    /* Error */
    public final void d()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 72
      //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 31	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
      //   11: ifnull +13 -> 24
      //   14: aload_0
      //   15: getfield 31	com/tencent/mapsdk/internal/le$a:d	Lcom/tencent/mapsdk/internal/lf;
      //   18: getstatic 58	com/tencent/mapsdk/internal/lf:b	Lcom/tencent/mapsdk/internal/lf;
      //   21: if_acmpne +11 -> 32
      //   24: ldc 72
      //   26: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   29: aload_0
      //   30: monitorexit
      //   31: return
      //   32: aload_0
      //   33: invokevirtual 74	com/tencent/mapsdk/internal/le$a:c	()V
      //   36: ldc 72
      //   38: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   41: goto -12 -> 29
      //   44: astore_1
      //   45: aload_0
      //   46: monitorexit
      //   47: aload_1
      //   48: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	49	0	this	a
      //   44	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	24	44	finally
      //   24	29	44	finally
      //   32	41	44	finally
    }
    
    public final void e()
    {
      try
      {
        if ((this.d == lf.b) || (this.d == lf.d)) {
          this.d = lf.d;
        }
        return;
      }
      finally {}
    }
    
    public final void f()
    {
      try
      {
        if ((this.d != lf.d) && (this.d != lf.c)) {
          this.d = lf.e;
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(223445);
      Object localObject = new StringBuffer("RequestBody{");
      ((StringBuffer)localObject).append("runnable=").append(this.a);
      ((StringBuffer)localObject).append(", requestFuture=").append(this.b);
      ((StringBuffer)localObject).append(", executor=").append(this.c);
      ((StringBuffer)localObject).append(", status=").append(this.d);
      ((StringBuffer)localObject).append('}');
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(223445);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.le
 * JD-Core Version:    0.7.0.1
 */