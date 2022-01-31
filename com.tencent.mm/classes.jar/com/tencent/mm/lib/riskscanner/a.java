package com.tencent.mm.lib.riskscanner;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a
{
  private static ThreadLocal<Long> dOJ = new ThreadLocal();
  
  public static void EM()
  {
    y.i("MicroMsg.RiskScannerReportService", "Report scan triggering.");
    f.nEG.a(590L, 0L, 1L, true);
    dOJ.set(Long.valueOf(bk.UZ()));
  }
  
  /* Error */
  public static void c(java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 20
    //   2: ldc 62
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: invokevirtual 66	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   14: aastore
    //   15: invokestatic 69	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: getstatic 16	com/tencent/mm/lib/riskscanner/a:dOJ	Ljava/lang/ThreadLocal;
    //   21: invokevirtual 72	java/lang/ThreadLocal:remove	()V
    //   24: getstatic 34	com/tencent/mm/plugin/report/f:nEG	Lcom/tencent/mm/plugin/report/f;
    //   27: ldc2_w 35
    //   30: ldc2_w 73
    //   33: lconst_1
    //   34: iconst_1
    //   35: invokevirtual 40	com/tencent/mm/plugin/report/f:a	(JJJZ)V
    //   38: new 76	java/io/StringWriter
    //   41: dup
    //   42: invokespecial 77	java/io/StringWriter:<init>	()V
    //   45: astore_1
    //   46: new 79	java/io/PrintWriter
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 82	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   54: astore_2
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 86	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   60: aload_2
    //   61: invokevirtual 89	java/io/PrintWriter:flush	()V
    //   64: aload_1
    //   65: invokevirtual 92	java/io/StringWriter:toString	()Ljava/lang/String;
    //   68: ldc 94
    //   70: ldc 96
    //   72: invokevirtual 102	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   75: astore_0
    //   76: getstatic 34	com/tencent/mm/plugin/report/f:nEG	Lcom/tencent/mm/plugin/report/f;
    //   79: sipush 14177
    //   82: new 104	java/lang/StringBuilder
    //   85: dup
    //   86: ldc 106
    //   88: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_0
    //   92: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: iconst_0
    //   99: iconst_1
    //   100: invokevirtual 117	com/tencent/mm/plugin/report/f:a	(ILjava/lang/String;ZZ)V
    //   103: aload_1
    //   104: invokevirtual 120	java/io/StringWriter:close	()V
    //   107: aload_2
    //   108: invokevirtual 121	java/io/PrintWriter:close	()V
    //   111: return
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 120	java/io/StringWriter:close	()V
    //   125: aload_0
    //   126: ifnull -15 -> 111
    //   129: aload_0
    //   130: invokevirtual 121	java/io/PrintWriter:close	()V
    //   133: return
    //   134: astore_0
    //   135: return
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 120	java/io/StringWriter:close	()V
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 121	java/io/PrintWriter:close	()V
    //   157: aload_0
    //   158: athrow
    //   159: astore_0
    //   160: goto -53 -> 107
    //   163: astore_0
    //   164: return
    //   165: astore_1
    //   166: goto -41 -> 125
    //   169: astore_2
    //   170: goto -21 -> 149
    //   173: astore_1
    //   174: goto -17 -> 157
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_1
    //   181: astore_2
    //   182: aload_3
    //   183: astore_1
    //   184: goto -43 -> 141
    //   187: astore_0
    //   188: aload_2
    //   189: astore_3
    //   190: aload_1
    //   191: astore_2
    //   192: aload_3
    //   193: astore_1
    //   194: goto -53 -> 141
    //   197: astore_0
    //   198: aconst_null
    //   199: astore_0
    //   200: goto -83 -> 117
    //   203: astore_0
    //   204: aload_2
    //   205: astore_0
    //   206: goto -89 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramThrowable	java.lang.Throwable
    //   45	109	1	localStringWriter	java.io.StringWriter
    //   165	1	1	localThrowable1	java.lang.Throwable
    //   173	8	1	localThrowable2	java.lang.Throwable
    //   183	11	1	localObject1	Object
    //   54	92	2	localPrintWriter	java.io.PrintWriter
    //   169	1	2	localThrowable3	java.lang.Throwable
    //   181	24	2	localObject2	Object
    //   179	14	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   38	46	112	java/lang/Throwable
    //   129	133	134	java/lang/Throwable
    //   38	46	136	finally
    //   103	107	159	java/lang/Throwable
    //   107	111	163	java/lang/Throwable
    //   121	125	165	java/lang/Throwable
    //   145	149	169	java/lang/Throwable
    //   153	157	173	java/lang/Throwable
    //   46	55	177	finally
    //   55	103	187	finally
    //   46	55	197	java/lang/Throwable
    //   55	103	203	java/lang/Throwable
  }
  
  public static void hD(int paramInt)
  {
    y.i("MicroMsg.RiskScannerReportService", "Report scan result, %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      f.nEG.a(590L, 3L, 1L, true);
      return;
    case 0: 
      Long localLong = (Long)dOJ.get();
      if (localLong != null)
      {
        long l = bk.UZ() - localLong.longValue();
        y.i("MicroMsg.RiskScannerReportService", "Scan cost: %d ms", new Object[] { Long.valueOf(l) });
        f.nEG.d(590, 5, 1, (int)l, true);
        return;
      }
      f.nEG.a(590L, 1L, 1L, true);
      return;
    }
    f.nEG.a(590L, 2L, 1L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.a
 * JD-Core Version:    0.7.0.1
 */