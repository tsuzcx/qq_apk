package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class c
{
  private static long fcc;
  private static final List<a> qyQ;
  
  static
  {
    AppMethodBeat.i(139903);
    qyQ = Collections.synchronizedList(new LinkedList());
    AppMethodBeat.o(139903);
  }
  
  public static void HC(long paramLong)
  {
    fcc = paramLong;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, double paramDouble)
  {
    AppMethodBeat.i(139899);
    long l = System.currentTimeMillis();
    a(paramString1, paramString2, paramString3, "C", l, l, String.format("{\"%s\":%f}", new Object[] { paramString3, Double.valueOf(paramDouble) }));
    AppMethodBeat.o(139899);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(139898);
    a(paramString1, paramString2, paramString3, "X", paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(139898);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5)
  {
    AppMethodBeat.i(139900);
    a locala = new a();
    locala.appId = paramString1;
    locala.name = paramString3;
    locala.idV = paramString2;
    locala.qyR = paramString4;
    locala.start = paramLong1;
    locala.aYz = paramLong2;
    if (paramString5 != null) {}
    for (paramString1 = URLEncoder.encode(paramString5);; paramString1 = "")
    {
      locala.qbr = paramString1;
      if (qyQ.size() < 10000) {
        qyQ.add(locala);
      }
      AppMethodBeat.o(139900);
      return;
    }
  }
  
  static boolean amf(String paramString)
  {
    AppMethodBeat.i(139901);
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (qyQ)
    {
      if (qyQ.size() == 0)
      {
        AppMethodBeat.o(139901);
        return true;
      }
      Log.d("MicroMsg.AppBrandPerformanceTracer", "dumpTrace events size: %d", new Object[] { Integer.valueOf(qyQ.size()) });
      Iterator localIterator = qyQ.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala.appId.equals(paramString)) && (locala.start >= fcc)) {
          localStringBuilder.append(locala.toString()).append("\n");
        }
      }
    }
    qyQ.clear();
    boolean bool = eI(paramString, localStringBuilder.toString());
    AppMethodBeat.o(139901);
    return bool;
  }
  
  public static void b(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139897);
    a(paramString1, "Native", paramString2, paramLong1, paramLong2, null);
    AppMethodBeat.o(139897);
  }
  
  /* Error */
  private static final boolean eI(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 185
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 190	com/tencent/mm/compatible/util/e:avA	()Z
    //   10: ifne +17 -> 27
    //   13: ldc 126
    //   15: ldc 192
    //   17: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: ldc 185
    //   22: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_0
    //   26: ireturn
    //   27: aconst_null
    //   28: astore 5
    //   30: aconst_null
    //   31: astore 4
    //   33: aload 5
    //   35: astore_3
    //   36: new 198	com/tencent/mm/vfs/q
    //   39: dup
    //   40: new 123	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   47: invokestatic 204	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   50: invokevirtual 209	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 211
    //   58: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 214	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   67: astore 6
    //   69: aload 5
    //   71: astore_3
    //   72: aload 6
    //   74: invokevirtual 217	com/tencent/mm/vfs/q:ifE	()Z
    //   77: ifne +12 -> 89
    //   80: aload 5
    //   82: astore_3
    //   83: aload 6
    //   85: invokevirtual 220	com/tencent/mm/vfs/q:ifL	()Z
    //   88: pop
    //   89: aload 5
    //   91: astore_3
    //   92: new 222	com/tencent/mm/vfs/y
    //   95: dup
    //   96: new 198	com/tencent/mm/vfs/q
    //   99: dup
    //   100: aload 6
    //   102: ldc 224
    //   104: iconst_2
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: aload_0
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: getstatic 45	com/tencent/mm/plugin/appbrand/performance/c:fcc	J
    //   117: invokestatic 229	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: invokestatic 69	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokespecial 232	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   127: iconst_1
    //   128: invokespecial 235	com/tencent/mm/vfs/y:<init>	(Lcom/tencent/mm/vfs/q;Z)V
    //   131: astore_0
    //   132: aload_0
    //   133: aload_1
    //   134: invokevirtual 238	com/tencent/mm/vfs/y:write	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: invokevirtual 241	com/tencent/mm/vfs/y:close	()V
    //   141: ldc 185
    //   143: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iload_2
    //   147: ireturn
    //   148: astore_1
    //   149: aload 4
    //   151: astore_0
    //   152: aload_0
    //   153: astore_3
    //   154: ldc 126
    //   156: ldc 243
    //   158: aload_1
    //   159: invokestatic 246	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   162: invokevirtual 249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_0
    //   169: ifnull +54 -> 223
    //   172: aload_0
    //   173: invokevirtual 241	com/tencent/mm/vfs/y:close	()V
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
    //   193: invokevirtual 241	com/tencent/mm/vfs/y:close	()V
    //   196: ldc 185
    //   198: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   67	34	6	localq	com.tencent.mm.vfs.q
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
  
  public static final class a
  {
    long aYz;
    String appId;
    String idV;
    String name;
    String qbr;
    String qyR;
    long start;
    
    public final String toString()
    {
      AppMethodBeat.i(139896);
      String str = this.name + "," + this.idV + "," + this.qyR + "," + (this.start - c.cfW()) + "," + (this.aYz - c.cfW()) + "," + this.qbr;
      AppMethodBeat.o(139896);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.c
 * JD-Core Version:    0.7.0.1
 */