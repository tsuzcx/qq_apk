package com.tencent.mm.lib.riskscanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class a
{
  private static ThreadLocal<Long> gmr;
  
  static
  {
    AppMethodBeat.i(138298);
    gmr = new ThreadLocal();
    AppMethodBeat.o(138298);
  }
  
  public static void aig()
  {
    AppMethodBeat.i(138295);
    ac.i("MicroMsg.RiskScannerReportService", "Report scan triggering.");
    e.wTc.idkeyStat(590L, 0L, 1L, true);
    gmr.set(Long.valueOf(bs.Gn()));
    AppMethodBeat.o(138295);
  }
  
  /* Error */
  public static void f(java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 71
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 31
    //   7: ldc 73
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: invokevirtual 77	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   19: aastore
    //   20: invokestatic 80	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: getstatic 23	com/tencent/mm/lib/riskscanner/a:gmr	Ljava/lang/ThreadLocal;
    //   26: invokevirtual 83	java/lang/ThreadLocal:remove	()V
    //   29: getstatic 44	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   32: ldc2_w 45
    //   35: ldc2_w 84
    //   38: lconst_1
    //   39: iconst_1
    //   40: invokevirtual 50	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
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
    //   81: getstatic 44	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   84: sipush 14177
    //   87: ldc 115
    //   89: aload_0
    //   90: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   93: invokevirtual 122	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   96: iconst_0
    //   97: iconst_1
    //   98: invokevirtual 126	com/tencent/mm/plugin/report/e:a	(ILjava/lang/String;ZZ)V
    //   101: aload_1
    //   102: invokevirtual 129	java/io/StringWriter:close	()V
    //   105: aload_2
    //   106: invokevirtual 130	java/io/PrintWriter:close	()V
    //   109: ldc 71
    //   111: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore_0
    //   116: ldc 71
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
    //   136: ifnull +48 -> 184
    //   139: aload_0
    //   140: invokevirtual 130	java/io/PrintWriter:close	()V
    //   143: ldc 71
    //   145: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: return
    //   149: astore_0
    //   150: ldc 71
    //   152: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: return
    //   156: astore_0
    //   157: aconst_null
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 129	java/io/StringWriter:close	()V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 130	java/io/PrintWriter:close	()V
    //   177: ldc 71
    //   179: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_0
    //   183: athrow
    //   184: ldc 71
    //   186: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: return
    //   190: astore_0
    //   191: goto -86 -> 105
    //   194: astore_1
    //   195: goto -60 -> 135
    //   198: astore_2
    //   199: goto -30 -> 169
    //   202: astore_1
    //   203: goto -26 -> 177
    //   206: astore_0
    //   207: aconst_null
    //   208: astore_3
    //   209: aload_1
    //   210: astore_2
    //   211: aload_3
    //   212: astore_1
    //   213: goto -52 -> 161
    //   216: astore_0
    //   217: aload_2
    //   218: astore_3
    //   219: aload_1
    //   220: astore_2
    //   221: aload_3
    //   222: astore_1
    //   223: goto -62 -> 161
    //   226: astore_0
    //   227: aconst_null
    //   228: astore_0
    //   229: goto -102 -> 127
    //   232: astore_0
    //   233: aload_2
    //   234: astore_0
    //   235: goto -108 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramThrowable	java.lang.Throwable
    //   50	124	1	localStringWriter	java.io.StringWriter
    //   194	1	1	localThrowable1	java.lang.Throwable
    //   202	8	1	localThrowable2	java.lang.Throwable
    //   212	11	1	localObject1	Object
    //   59	107	2	localPrintWriter	java.io.PrintWriter
    //   198	1	2	localThrowable3	java.lang.Throwable
    //   210	24	2	localObject2	Object
    //   208	14	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   105	109	115	java/lang/Throwable
    //   43	51	122	java/lang/Throwable
    //   139	143	149	java/lang/Throwable
    //   43	51	156	finally
    //   101	105	190	java/lang/Throwable
    //   131	135	194	java/lang/Throwable
    //   165	169	198	java/lang/Throwable
    //   173	177	202	java/lang/Throwable
    //   51	60	206	finally
    //   60	101	216	finally
    //   51	60	226	java/lang/Throwable
    //   60	101	232	java/lang/Throwable
  }
  
  public static void mx(int paramInt)
  {
    AppMethodBeat.i(138297);
    ac.i("MicroMsg.RiskScannerReportService", "Report scan result, %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      e.wTc.idkeyStat(590L, 3L, 1L, true);
      AppMethodBeat.o(138297);
      return;
    case 0: 
      Long localLong = (Long)gmr.get();
      if (localLong != null)
      {
        long l = bs.Gn() - localLong.longValue();
        ac.i("MicroMsg.RiskScannerReportService", "Scan cost: %d ms", new Object[] { Long.valueOf(l) });
        e.wTc.c(590, 5, 1, (int)l, true);
        AppMethodBeat.o(138297);
        return;
      }
      e.wTc.idkeyStat(590L, 1L, 1L, true);
      AppMethodBeat.o(138297);
      return;
    }
    e.wTc.idkeyStat(590L, 2L, 1L, true);
    AppMethodBeat.o(138297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.a
 * JD-Core Version:    0.7.0.1
 */