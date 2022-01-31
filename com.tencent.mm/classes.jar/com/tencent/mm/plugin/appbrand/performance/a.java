package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a
{
  private static long bvZ;
  private static List<a.a> gWl = Collections.synchronizedList(new LinkedList());
  
  public static void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    a(paramString1, "Native", paramString2, paramLong1, paramLong2, null);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, double paramDouble)
  {
    long l = System.currentTimeMillis();
    a(paramString1, paramString2, paramString3, "C", l, l, String.format("{ \"%s\": %f }", new Object[] { paramString3, Double.valueOf(paramDouble) }));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    a(paramString1, paramString2, paramString3, "X", paramLong1, paramLong2, paramString4);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5)
  {
    a.a locala = new a.a();
    locala.appId = paramString1;
    locala.name = paramString3;
    locala.category = paramString2;
    locala.gWm = paramString4;
    locala.start = paramLong1;
    locala.gWn = paramLong2;
    if (paramString5 != null) {}
    for (paramString1 = q.encode(paramString5);; paramString1 = "")
    {
      locala.gWo = paramString1;
      if (gWl.size() < 10000) {
        gWl.add(locala);
      }
      return;
    }
  }
  
  /* Error */
  private static final boolean bY(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 119	com/tencent/mm/compatible/util/f:zF	()Z
    //   5: ifne +12 -> 17
    //   8: ldc 121
    //   10: ldc 123
    //   12: invokestatic 129	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: iconst_0
    //   16: ireturn
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 4
    //   23: aload 5
    //   25: astore_3
    //   26: new 131	java/io/File
    //   29: dup
    //   30: new 133	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   37: invokestatic 140	com/tencent/mm/compatible/util/h:getExternalStorageDirectory	()Ljava/io/File;
    //   40: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 150
    //   48: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore 6
    //   59: aload 5
    //   61: astore_3
    //   62: aload 6
    //   64: invokevirtual 159	java/io/File:exists	()Z
    //   67: ifne +12 -> 79
    //   70: aload 5
    //   72: astore_3
    //   73: aload 6
    //   75: invokevirtual 162	java/io/File:mkdirs	()Z
    //   78: pop
    //   79: aload 5
    //   81: astore_3
    //   82: new 164	java/io/FileWriter
    //   85: dup
    //   86: new 131	java/io/File
    //   89: dup
    //   90: aload 6
    //   92: ldc 166
    //   94: iconst_2
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_0
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: getstatic 109	com/tencent/mm/plugin/appbrand/performance/a:bvZ	J
    //   107: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   110: aastore
    //   111: invokestatic 60	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   114: invokespecial 174	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   117: iconst_1
    //   118: invokespecial 177	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   121: astore_0
    //   122: aload_0
    //   123: aload_1
    //   124: invokevirtual 180	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   127: aload_0
    //   128: invokevirtual 183	java/io/FileWriter:close	()V
    //   131: iload_2
    //   132: ireturn
    //   133: astore_1
    //   134: aload 4
    //   136: astore_0
    //   137: aload_0
    //   138: astore_3
    //   139: ldc 121
    //   141: new 133	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 185
    //   147: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload_1
    //   151: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 129	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_0
    //   161: ifnull +49 -> 210
    //   164: aload_0
    //   165: invokevirtual 183	java/io/FileWriter:close	()V
    //   168: iconst_0
    //   169: istore_2
    //   170: goto -39 -> 131
    //   173: astore_0
    //   174: iconst_0
    //   175: istore_2
    //   176: goto -45 -> 131
    //   179: astore_0
    //   180: aload_3
    //   181: ifnull +7 -> 188
    //   184: aload_3
    //   185: invokevirtual 183	java/io/FileWriter:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: astore_0
    //   191: goto -60 -> 131
    //   194: astore_1
    //   195: goto -7 -> 188
    //   198: astore_1
    //   199: aload_0
    //   200: astore_3
    //   201: aload_1
    //   202: astore_0
    //   203: goto -23 -> 180
    //   206: astore_1
    //   207: goto -70 -> 137
    //   210: iconst_0
    //   211: istore_2
    //   212: goto -81 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramString1	String
    //   0	215	1	paramString2	String
    //   1	211	2	bool	boolean
    //   25	176	3	localObject1	Object
    //   21	114	4	localObject2	Object
    //   18	62	5	localObject3	Object
    //   57	34	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   26	59	133	java/lang/Exception
    //   62	70	133	java/lang/Exception
    //   73	79	133	java/lang/Exception
    //   82	122	133	java/lang/Exception
    //   164	168	173	java/lang/Exception
    //   26	59	179	finally
    //   62	70	179	finally
    //   73	79	179	finally
    //   82	122	179	finally
    //   139	160	179	finally
    //   127	131	190	java/lang/Exception
    //   184	188	194	java/lang/Exception
    //   122	127	198	finally
    //   122	127	206	java/lang/Exception
  }
  
  public static void cE(long paramLong)
  {
    bvZ = paramLong;
  }
  
  public static final boolean vV(String paramString)
  {
    if (!AppBrandPerformanceManager.vS(paramString)) {
      return false;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    synchronized (gWl)
    {
      y.d("MicroMsg.AppBrandPerformanceTracer", "dumpTrace events size: %d", new Object[] { Integer.valueOf(gWl.size()) });
      Iterator localIterator = gWl.iterator();
      while (localIterator.hasNext())
      {
        a.a locala = (a.a)localIterator.next();
        if ((locala.appId.equals(paramString)) && (locala.start >= bvZ)) {
          localStringBuffer.append(locala.toString()).append("\n");
        }
      }
    }
    gWl.clear();
    return bY(paramString, localStringBuffer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.a
 * JD-Core Version:    0.7.0.1
 */