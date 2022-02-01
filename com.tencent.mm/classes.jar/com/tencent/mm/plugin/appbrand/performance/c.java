package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  private static long hfJ;
  private static final List<a> tDL;
  
  static
  {
    AppMethodBeat.i(139903);
    tDL = Collections.synchronizedList(new LinkedList());
    AppMethodBeat.o(139903);
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
    locala.kDf = paramString2;
    locala.tDM = paramString4;
    locala.start = paramLong1;
    locala.axI = paramLong2;
    if (paramString5 != null) {}
    for (paramString1 = URLEncoder.encode(paramString5);; paramString1 = "")
    {
      locala.tgs = paramString1;
      if (tDL.size() < 10000) {
        tDL.add(locala);
      }
      AppMethodBeat.o(139900);
      return;
    }
  }
  
  static boolean afn(String paramString)
  {
    AppMethodBeat.i(139901);
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (tDL)
    {
      if (tDL.size() == 0)
      {
        AppMethodBeat.o(139901);
        return true;
      }
      Log.d("MicroMsg.AppBrandPerformanceTracer", "dumpTrace events size: %d", new Object[] { Integer.valueOf(tDL.size()) });
      Iterator localIterator = tDL.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala.appId.equals(paramString)) && (locala.start >= hfJ)) {
          localStringBuilder.append(locala.toString()).append("\n");
        }
      }
    }
    tDL.clear();
    boolean bool = eZ(paramString, localStringBuilder.toString());
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
  private static final boolean eZ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 180
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 185	com/tencent/mm/compatible/util/e:aPU	()Z
    //   10: ifne +17 -> 27
    //   13: ldc 119
    //   15: ldc 187
    //   17: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: ldc 180
    //   22: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_0
    //   26: ireturn
    //   27: aconst_null
    //   28: astore 5
    //   30: aconst_null
    //   31: astore 4
    //   33: aload 5
    //   35: astore_3
    //   36: new 193	com/tencent/mm/vfs/u
    //   39: dup
    //   40: new 116	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   47: invokestatic 199	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   50: invokevirtual 204	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 206
    //   58: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 209	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   67: astore 6
    //   69: aload 5
    //   71: astore_3
    //   72: aload 6
    //   74: invokevirtual 212	com/tencent/mm/vfs/u:jKS	()Z
    //   77: ifne +12 -> 89
    //   80: aload 5
    //   82: astore_3
    //   83: aload 6
    //   85: invokevirtual 215	com/tencent/mm/vfs/u:jKY	()Z
    //   88: pop
    //   89: aload 5
    //   91: astore_3
    //   92: new 217	com/tencent/mm/vfs/ac
    //   95: dup
    //   96: new 193	com/tencent/mm/vfs/u
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
    //   114: getstatic 151	com/tencent/mm/plugin/appbrand/performance/c:hfJ	J
    //   117: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: invokestatic 62	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokespecial 227	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   127: iconst_1
    //   128: invokespecial 230	com/tencent/mm/vfs/ac:<init>	(Lcom/tencent/mm/vfs/u;Z)V
    //   131: astore_0
    //   132: aload_0
    //   133: aload_1
    //   134: invokevirtual 233	com/tencent/mm/vfs/ac:write	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: invokevirtual 236	com/tencent/mm/vfs/ac:close	()V
    //   141: ldc 180
    //   143: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iload_2
    //   147: ireturn
    //   148: astore_1
    //   149: aload 4
    //   151: astore_0
    //   152: aload_0
    //   153: astore_3
    //   154: ldc 119
    //   156: ldc 238
    //   158: aload_1
    //   159: invokestatic 241	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   162: invokevirtual 244	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_0
    //   169: ifnull +54 -> 223
    //   172: aload_0
    //   173: invokevirtual 236	com/tencent/mm/vfs/ac:close	()V
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
    //   193: invokevirtual 236	com/tencent/mm/vfs/ac:close	()V
    //   196: ldc 180
    //   198: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   67	34	6	localu	com.tencent.mm.vfs.u
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
  
  public static void jR(long paramLong)
  {
    hfJ = paramLong;
  }
  
  public static final class a
  {
    String appId;
    long axI;
    String kDf;
    String name;
    long start;
    String tDM;
    String tgs;
    
    public final String toString()
    {
      AppMethodBeat.i(139896);
      String str = this.name + "," + this.kDf + "," + this.tDM + "," + (this.start - c.cGI()) + "," + (this.axI - c.cGI()) + "," + this.tgs;
      AppMethodBeat.o(139896);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.c
 * JD-Core Version:    0.7.0.1
 */