package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class c
{
  private static long bXE;
  private static final List<c.a> iAR;
  
  static
  {
    AppMethodBeat.i(114389);
    iAR = Collections.synchronizedList(new LinkedList());
    AppMethodBeat.o(114389);
  }
  
  static boolean Ex(String paramString)
  {
    AppMethodBeat.i(114387);
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (iAR)
    {
      if (iAR.size() == 0)
      {
        AppMethodBeat.o(114387);
        return true;
      }
      ab.d("MicroMsg.AppBrandPerformanceTracer", "dumpTrace events size: %d", new Object[] { Integer.valueOf(iAR.size()) });
      Iterator localIterator = iAR.iterator();
      while (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        if ((locala.appId.equals(paramString)) && (locala.start >= bXE)) {
          localStringBuilder.append(locala.toString()).append("\n");
        }
      }
    }
    iAR.clear();
    boolean bool = cJ(paramString, localStringBuilder.toString());
    AppMethodBeat.o(114387);
    return bool;
  }
  
  public static void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(114383);
    a(paramString1, "Native", paramString2, paramLong1, paramLong2, null);
    AppMethodBeat.o(114383);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, double paramDouble)
  {
    AppMethodBeat.i(114385);
    long l = System.currentTimeMillis();
    a(paramString1, paramString2, paramString3, "C", l, l, String.format("{\"%s\":%f}", new Object[] { paramString3, Double.valueOf(paramDouble) }));
    AppMethodBeat.o(114385);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(114384);
    a(paramString1, paramString2, paramString3, "X", paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(114384);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5)
  {
    AppMethodBeat.i(114386);
    c.a locala = new c.a();
    locala.appId = paramString1;
    locala.name = paramString3;
    locala.category = paramString2;
    locala.iAS = paramString4;
    locala.start = paramLong1;
    locala.aID = paramLong2;
    if (paramString5 != null) {}
    for (paramString1 = URLEncoder.encode(paramString5);; paramString1 = "")
    {
      locala.iAT = paramString1;
      if (iAR.size() < 10000) {
        iAR.add(locala);
      }
      AppMethodBeat.o(114386);
      return;
    }
  }
  
  /* Error */
  private static final boolean cJ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 182
    //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 187	com/tencent/mm/compatible/util/f:Mi	()Z
    //   10: ifne +17 -> 27
    //   13: ldc 54
    //   15: ldc 189
    //   17: invokestatic 193	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: ldc 182
    //   22: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_0
    //   26: ireturn
    //   27: aconst_null
    //   28: astore 5
    //   30: aconst_null
    //   31: astore 4
    //   33: aload 5
    //   35: astore_3
    //   36: new 195	java/io/File
    //   39: dup
    //   40: new 45	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   47: invokestatic 201	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   50: invokevirtual 204	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 206
    //   58: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 209	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 6
    //   69: aload 5
    //   71: astore_3
    //   72: aload 6
    //   74: invokevirtual 212	java/io/File:exists	()Z
    //   77: ifne +12 -> 89
    //   80: aload 5
    //   82: astore_3
    //   83: aload 6
    //   85: invokevirtual 215	java/io/File:mkdirs	()Z
    //   88: pop
    //   89: aload 5
    //   91: astore_3
    //   92: new 217	java/io/FileWriter
    //   95: dup
    //   96: new 195	java/io/File
    //   99: dup
    //   100: aload 6
    //   102: ldc 219
    //   104: iconst_2
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: aload_0
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: getstatic 97	com/tencent/mm/plugin/appbrand/performance/c:bXE	J
    //   117: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: invokestatic 144	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokespecial 227	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   127: iconst_1
    //   128: invokespecial 230	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   131: astore_0
    //   132: aload_0
    //   133: aload_1
    //   134: invokevirtual 233	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: invokevirtual 236	java/io/FileWriter:close	()V
    //   141: ldc 182
    //   143: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iload_2
    //   147: ireturn
    //   148: astore_1
    //   149: aload 4
    //   151: astore_0
    //   152: aload_0
    //   153: astore_3
    //   154: ldc 54
    //   156: ldc 238
    //   158: aload_1
    //   159: invokestatic 241	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   162: invokevirtual 244	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokestatic 193	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_0
    //   169: ifnull +54 -> 223
    //   172: aload_0
    //   173: invokevirtual 236	java/io/FileWriter:close	()V
    //   176: iconst_0
    //   177: istore_2
    //   178: goto -37 -> 141
    //   181: astore_0
    //   182: iconst_0
    //   183: istore_2
    //   184: goto -43 -> 141
    //   187: astore_0
    //   188: aload_3
    //   189: ifnull +7 -> 196
    //   192: aload_3
    //   193: invokevirtual 236	java/io/FileWriter:close	()V
    //   196: ldc 182
    //   198: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload_0
    //   202: athrow
    //   203: astore_0
    //   204: goto -63 -> 141
    //   207: astore_1
    //   208: goto -12 -> 196
    //   211: astore_1
    //   212: aload_0
    //   213: astore_3
    //   214: aload_1
    //   215: astore_0
    //   216: goto -28 -> 188
    //   219: astore_1
    //   220: goto -68 -> 152
    //   223: iconst_0
    //   224: istore_2
    //   225: goto -84 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramString1	String
    //   0	228	1	paramString2	String
    //   1	224	2	bool	boolean
    //   35	179	3	localObject1	Object
    //   31	119	4	localObject2	Object
    //   28	62	5	localObject3	Object
    //   67	34	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   36	69	148	java/lang/Exception
    //   72	80	148	java/lang/Exception
    //   83	89	148	java/lang/Exception
    //   92	132	148	java/lang/Exception
    //   172	176	181	java/lang/Exception
    //   36	69	187	finally
    //   72	80	187	finally
    //   83	89	187	finally
    //   92	132	187	finally
    //   154	168	187	finally
    //   137	141	203	java/lang/Exception
    //   192	196	207	java/lang/Exception
    //   132	137	211	finally
    //   132	137	219	java/lang/Exception
  }
  
  public static void hE(long paramLong)
  {
    bXE = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.c
 * JD-Core Version:    0.7.0.1
 */