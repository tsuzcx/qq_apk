package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class t
{
  private static final com.tencent.mm.network.i hgA;
  private static final g[] hgx;
  private static final byte[] hgy;
  private static final Map<Integer, b> hgz;
  
  static
  {
    AppMethodBeat.i(239326);
    hgx = new g[] { null };
    hgy = new byte[0];
    hgz = new HashMap();
    hgA = new i.a()
    {
      public final void dq(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(239042);
        if (paramAnonymousInt2 < 0)
        {
          Log.e("MicroMsg.IpxxUploadHelper", "Bad percent: %s, observerId: %s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
          synchronized (t.aCv())
          {
            t.b localb = (t.b)t.aCw().remove(Integer.valueOf(paramAnonymousInt1));
            if (localb != null) {
              t.b(localb.hgD, localb.path);
            }
            AppMethodBeat.o(239042);
            return;
          }
        }
        int i = paramAnonymousInt2;
        if (paramAnonymousInt2 > 100)
        {
          Log.w("MicroMsg.IpxxUploadHelper", "Bad percent: %s, observerId: %s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
          i = 100;
        }
        arrayOfByte = t.aCv();
        if (i == 100)
        {
          paramAnonymousInt2 = 1;
          if (paramAnonymousInt2 == 0) {
            break label205;
          }
        }
        for (;;)
        {
          try
          {
            ??? = (t.b)t.aCw().remove(Integer.valueOf(paramAnonymousInt1));
            if (??? != null) {
              t.a(((t.b)???).hgD, ((t.b)???).path, i);
            }
            return;
          }
          finally
          {
            label205:
            AppMethodBeat.o(239042);
          }
          paramAnonymousInt2 = 0;
          break;
          ??? = (t.b)t.aCw().get(Integer.valueOf(paramAnonymousInt1));
        }
      }
    };
    AppMethodBeat.o(239326);
  }
  
  private static void a(a parama, final String paramString)
  {
    AppMethodBeat.i(239312);
    if (parama == null)
    {
      AppMethodBeat.o(239312);
      return;
    }
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239048);
        t.this.onError(paramString);
        AppMethodBeat.o(239048);
      }
    });
    AppMethodBeat.o(239312);
  }
  
  static void a(g paramg)
  {
    AppMethodBeat.i(239293);
    synchronized (hgx)
    {
      paramg.a(hgA);
      hgx[0] = paramg;
      AppMethodBeat.o(239293);
      return;
    }
  }
  
  /* Error */
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, a parama)
  {
    // Byte code:
    //   0: ldc 81
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 85	com/tencent/mm/app/t:aCu	()Lcom/tencent/mm/network/g;
    //   8: astore 8
    //   10: aload 8
    //   12: ifnonnull +22 -> 34
    //   15: ldc 87
    //   17: ldc 89
    //   19: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload 4
    //   24: aload_0
    //   25: invokestatic 97	com/tencent/mm/app/t:a	(Lcom/tencent/mm/app/t$a;Ljava/lang/String;)V
    //   28: ldc 81
    //   30: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: getstatic 40	com/tencent/mm/app/t:hgy	[B
    //   37: astore 7
    //   39: aload 7
    //   41: monitorenter
    //   42: iload_2
    //   43: i2l
    //   44: lstore 5
    //   46: aload 8
    //   48: aload_0
    //   49: iload_1
    //   50: lload 5
    //   52: aconst_null
    //   53: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   56: aload_3
    //   57: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokeinterface 106 7 0
    //   65: istore_1
    //   66: iload_1
    //   67: iflt +38 -> 105
    //   70: new 15	com/tencent/mm/app/t$b
    //   73: dup
    //   74: iload_1
    //   75: aload_0
    //   76: aload 4
    //   78: invokespecial 109	com/tencent/mm/app/t$b:<init>	(ILjava/lang/String;Lcom/tencent/mm/app/t$a;)V
    //   81: astore_3
    //   82: getstatic 47	com/tencent/mm/app/t:hgz	Ljava/util/Map;
    //   85: iload_1
    //   86: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aload_3
    //   90: invokeinterface 121 3 0
    //   95: pop
    //   96: aload 7
    //   98: monitorexit
    //   99: ldc 81
    //   101: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: return
    //   105: ldc 87
    //   107: ldc 123
    //   109: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload 4
    //   114: aload_0
    //   115: invokestatic 97	com/tencent/mm/app/t:a	(Lcom/tencent/mm/app/t$a;Ljava/lang/String;)V
    //   118: goto -22 -> 96
    //   121: astore_3
    //   122: ldc 87
    //   124: aload_3
    //   125: ldc 125
    //   127: iconst_0
    //   128: anewarray 4	java/lang/Object
    //   131: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: getstatic 47	com/tencent/mm/app/t:hgz	Ljava/util/Map;
    //   137: iload_1
    //   138: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: invokeinterface 133 2 0
    //   146: pop
    //   147: aload 4
    //   149: aload_0
    //   150: invokestatic 97	com/tencent/mm/app/t:a	(Lcom/tencent/mm/app/t$a;Ljava/lang/String;)V
    //   153: goto -57 -> 96
    //   156: astore_0
    //   157: aload 7
    //   159: monitorexit
    //   160: ldc 81
    //   162: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload_0
    //   166: athrow
    //   167: astore_3
    //   168: iconst_m1
    //   169: istore_1
    //   170: goto -48 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramString1	String
    //   0	173	1	paramInt1	int
    //   0	173	2	paramInt2	int
    //   0	173	3	paramString2	String
    //   0	173	4	parama	a
    //   44	7	5	l	long
    //   37	121	7	arrayOfByte	byte[]
    //   8	39	8	localg	g
    // Exception table:
    //   from	to	target	type
    //   70	96	121	finally
    //   105	118	121	finally
    //   96	99	156	finally
    //   122	153	156	finally
    //   46	66	167	finally
  }
  
  /* Error */
  public static void a(int[] paramArrayOfInt, boolean paramBoolean, long paramLong, a parama)
  {
    // Byte code:
    //   0: ldc 135
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 85	com/tencent/mm/app/t:aCu	()Lcom/tencent/mm/network/g;
    //   8: astore 7
    //   10: aload 7
    //   12: ifnonnull +22 -> 34
    //   15: ldc 87
    //   17: ldc 89
    //   19: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload 4
    //   24: aconst_null
    //   25: invokestatic 97	com/tencent/mm/app/t:a	(Lcom/tencent/mm/app/t$a;Ljava/lang/String;)V
    //   28: ldc 135
    //   30: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: getstatic 40	com/tencent/mm/app/t:hgy	[B
    //   37: astore 6
    //   39: aload 6
    //   41: monitorenter
    //   42: aload 7
    //   44: aload_0
    //   45: iload_1
    //   46: lload_2
    //   47: aconst_null
    //   48: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokeinterface 138 6 0
    //   56: istore 5
    //   58: iload 5
    //   60: iflt +40 -> 100
    //   63: new 15	com/tencent/mm/app/t$b
    //   66: dup
    //   67: iload 5
    //   69: aconst_null
    //   70: aload 4
    //   72: invokespecial 109	com/tencent/mm/app/t$b:<init>	(ILjava/lang/String;Lcom/tencent/mm/app/t$a;)V
    //   75: astore_0
    //   76: getstatic 47	com/tencent/mm/app/t:hgz	Ljava/util/Map;
    //   79: iload 5
    //   81: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aload_0
    //   85: invokeinterface 121 3 0
    //   90: pop
    //   91: aload 6
    //   93: monitorexit
    //   94: ldc 135
    //   96: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: ldc 87
    //   102: ldc 140
    //   104: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload 4
    //   109: aconst_null
    //   110: invokestatic 97	com/tencent/mm/app/t:a	(Lcom/tencent/mm/app/t$a;Ljava/lang/String;)V
    //   113: goto -22 -> 91
    //   116: astore_0
    //   117: ldc 87
    //   119: aload_0
    //   120: ldc 125
    //   122: iconst_0
    //   123: anewarray 4	java/lang/Object
    //   126: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: getstatic 47	com/tencent/mm/app/t:hgz	Ljava/util/Map;
    //   132: iload 5
    //   134: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: invokeinterface 133 2 0
    //   142: pop
    //   143: aload 4
    //   145: aconst_null
    //   146: invokestatic 97	com/tencent/mm/app/t:a	(Lcom/tencent/mm/app/t$a;Ljava/lang/String;)V
    //   149: goto -58 -> 91
    //   152: astore_0
    //   153: aload 6
    //   155: monitorexit
    //   156: ldc 135
    //   158: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_0
    //   162: athrow
    //   163: astore_0
    //   164: iconst_m1
    //   165: istore 5
    //   167: goto -50 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramArrayOfInt	int[]
    //   0	170	1	paramBoolean	boolean
    //   0	170	2	paramLong	long
    //   0	170	4	parama	a
    //   56	110	5	i	int
    //   37	117	6	arrayOfByte	byte[]
    //   8	35	7	localg	g
    // Exception table:
    //   from	to	target	type
    //   63	91	116	finally
    //   100	113	116	finally
    //   91	94	152	finally
    //   117	149	152	finally
    //   42	58	163	finally
  }
  
  private static g aCu()
  {
    synchronized (hgx)
    {
      g localg = hgx[0];
      return localg;
    }
  }
  
  public static void dp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239309);
    Date localDate = new Date();
    localDate.setTime(Util.nowMilliSecond() - 86400000L * paramInt1);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    a(b.bmB() + "crash_" + localSimpleDateFormat.format(localDate) + ".txt", 20001, paramInt2, null, null);
    AppMethodBeat.o(239309);
  }
  
  public static abstract interface a
  {
    public abstract void V(String paramString, int paramInt);
    
    public abstract void onError(String paramString);
  }
  
  static final class b
  {
    final int hgC;
    final t.a hgD;
    final String path;
    
    b(int paramInt, String paramString, t.a parama)
    {
      this.hgC = paramInt;
      this.path = paramString;
      this.hgD = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.t
 * JD-Core Version:    0.7.0.1
 */