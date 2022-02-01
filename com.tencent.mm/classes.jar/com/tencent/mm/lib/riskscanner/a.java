package com.tencent.mm.lib.riskscanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class a
{
  private static ThreadLocal<Long> mHZ;
  
  static
  {
    AppMethodBeat.i(138298);
    mHZ = new ThreadLocal();
    AppMethodBeat.o(138298);
  }
  
  public static void bca()
  {
    AppMethodBeat.i(138295);
    Log.i("MicroMsg.RiskScannerReportService", "Report scan triggering.");
    f.Ozc.idkeyStat(590L, 0L, 1L, true);
    mHZ.set(Long.valueOf(Util.currentTicks()));
    AppMethodBeat.o(138295);
  }
  
  /* Error */
  public static void p(java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 69
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 31
    //   7: ldc 71
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: invokevirtual 77	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   19: aastore
    //   20: invokestatic 80	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: getstatic 23	com/tencent/mm/lib/riskscanner/a:mHZ	Ljava/lang/ThreadLocal;
    //   26: invokevirtual 83	java/lang/ThreadLocal:remove	()V
    //   29: getstatic 44	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   32: ldc2_w 45
    //   35: ldc2_w 84
    //   38: lconst_1
    //   39: iconst_1
    //   40: invokevirtual 50	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   43: new 87	java/io/StringWriter
    //   46: dup
    //   47: invokespecial 88	java/io/StringWriter:<init>	()V
    //   50: astore_1
    //   51: new 90	java/io/PrintWriter
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 93	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   59: astore_2
    //   60: aload_0
    //   61: aload_2
    //   62: invokevirtual 97	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   65: aload_2
    //   66: invokevirtual 100	java/io/PrintWriter:flush	()V
    //   69: aload_1
    //   70: invokevirtual 103	java/io/StringWriter:toString	()Ljava/lang/String;
    //   73: ldc 105
    //   75: ldc 107
    //   77: invokevirtual 113	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   80: astore_0
    //   81: getstatic 44	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   84: sipush 14177
    //   87: ldc 115
    //   89: aload_0
    //   90: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   93: invokevirtual 122	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   96: iconst_0
    //   97: iconst_1
    //   98: invokevirtual 126	com/tencent/mm/plugin/report/f:b	(ILjava/lang/String;ZZ)V
    //   101: aload_1
    //   102: invokevirtual 129	java/io/StringWriter:close	()V
    //   105: aload_2
    //   106: invokevirtual 130	java/io/PrintWriter:close	()V
    //   109: ldc 69
    //   111: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore_0
    //   116: ldc 69
    //   118: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 129	java/io/StringWriter:close	()V
    //   135: aload_0
    //   136: ifnull +20 -> 156
    //   139: aload_0
    //   140: invokevirtual 130	java/io/PrintWriter:close	()V
    //   143: ldc 69
    //   145: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: return
    //   149: astore_0
    //   150: ldc 69
    //   152: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: return
    //   156: ldc 69
    //   158: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: return
    //   162: astore_0
    //   163: goto -58 -> 105
    //   166: astore_1
    //   167: goto -32 -> 135
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_0
    //   173: goto -46 -> 127
    //   176: astore_0
    //   177: aload_2
    //   178: astore_0
    //   179: goto -52 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramThrowable	java.lang.Throwable
    //   50	82	1	localStringWriter	java.io.StringWriter
    //   166	1	1	localObject	Object
    //   59	119	2	localPrintWriter	java.io.PrintWriter
    // Exception table:
    //   from	to	target	type
    //   105	109	115	finally
    //   43	51	122	finally
    //   139	143	149	finally
    //   101	105	162	finally
    //   131	135	166	finally
    //   51	60	170	finally
    //   60	101	176	finally
  }
  
  public static void sK(int paramInt)
  {
    AppMethodBeat.i(138297);
    Log.i("MicroMsg.RiskScannerReportService", "Report scan result, %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      f.Ozc.idkeyStat(590L, 3L, 1L, true);
      AppMethodBeat.o(138297);
      return;
    case 0: 
      Long localLong = (Long)mHZ.get();
      if (localLong != null)
      {
        long l = Util.currentTicks() - localLong.longValue();
        Log.i("MicroMsg.RiskScannerReportService", "Scan cost: %d ms", new Object[] { Long.valueOf(l) });
        f.Ozc.c(590, 5, 1, (int)l, true);
        AppMethodBeat.o(138297);
        return;
      }
      f.Ozc.idkeyStat(590L, 1L, 1L, true);
      AppMethodBeat.o(138297);
      return;
    }
    f.Ozc.idkeyStat(590L, 2L, 1L, true);
    AppMethodBeat.o(138297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.a
 * JD-Core Version:    0.7.0.1
 */