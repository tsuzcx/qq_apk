package com.tencent.mm.ci;

import android.os.Debug;
import android.os.Environment;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String Jmc;
  
  static
  {
    AppMethodBeat.i(145591);
    Jmc = Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/memory/";
    AppMethodBeat.o(145591);
  }
  
  private static boolean aQ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(145584);
    if (!fyv())
    {
      AppMethodBeat.o(145584);
      return false;
    }
    Object localObject = new k(Jmc);
    k[] arrayOfk = ((k)localObject).fTj();
    if (arrayOfk.length == 0)
    {
      AppMethodBeat.o(145584);
      return true;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    long l1 = new Date().getTime();
    boolean bool1 = true;
    int j = arrayOfk.length;
    int i = 0;
    k localk;
    String str;
    if (i < j)
    {
      localk = arrayOfk[i];
      str = localk.getName();
      int k = str.indexOf(".hprof");
      if (k > 0) {
        str = str.substring(0, k);
      }
      for (;;)
      {
        try
        {
          Date localDate = localSimpleDateFormat.parse(str);
          if (localDate != null) {
            continue;
          }
          localk.delete();
          bool2 = bool1;
        }
        catch (ParseException localParseException)
        {
          ae.e("MicroMsg.MemoryDumpManager", "hprofFileCheck parse date fail %s", new Object[] { str });
          localk.delete();
          boolean bool2 = bool1;
          continue;
          long l2 = localParseException.getTime();
          if (l2 < l1) {
            continue;
          }
          localk.delete();
          bool2 = bool1;
          continue;
          l2 = (l1 - l2) / 86400000L;
          if (l2 < 3L) {
            continue;
          }
          localk.delete();
          bool2 = bool1;
          continue;
          bool2 = bool1;
          if (!paramBoolean1) {
            continue;
          }
          bool2 = bool1;
          if (l2 >= 1L) {
            continue;
          }
          bool2 = false;
          continue;
        }
        i += 1;
        bool1 = bool2;
        break;
        localk.delete();
        bool2 = bool1;
      }
    }
    localObject = ((k)localObject).fTj();
    if (localObject.length > 5)
    {
      if (paramBoolean2) {
        Toast.makeText(ak.getContext(), "dump fail, hprof file size exceed", 0).show();
      }
      ae.w("MicroMsg.MemoryDumpManager", "hprofFileCheck hprofFileDir.length() too large " + localObject.length);
      AppMethodBeat.o(145584);
      return false;
    }
    AppMethodBeat.o(145584);
    return bool1;
  }
  
  public static String aR(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(145585);
    if (!aQ(paramBoolean1, paramBoolean2))
    {
      AppMethodBeat.o(145585);
      return null;
    }
    long l = System.currentTimeMillis();
    String str = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(Jmc).append(str).append(".hprof");
    localObject = ((StringBuffer)localObject).toString();
    if (!ac(new k((String)localObject).fTg()))
    {
      ae.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", new Object[] { localObject });
      AppMethodBeat.o(145585);
      return null;
    }
    try
    {
      fyw();
      Debug.dumpHprofData((String)localObject);
      if (paramBoolean2) {
        Toast.makeText(ak.getContext(), (String)localObject + " hprof file has saved ", 0).show();
      }
      ae.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", new Object[] { str, Long.valueOf(bu.DD(l)) });
      AppMethodBeat.o(145585);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
      AppMethodBeat.o(145585);
    }
    return null;
  }
  
  public static String aWF(String paramString)
  {
    AppMethodBeat.i(145586);
    if (!fyv())
    {
      AppMethodBeat.o(145586);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(Jmc).append(paramString).append(".hprof");
    localObject = ((StringBuffer)localObject).toString();
    if (!ac(new k((String)localObject).fTg()))
    {
      ae.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", new Object[] { localObject });
      AppMethodBeat.o(145586);
      return null;
    }
    try
    {
      fyw();
      Debug.dumpHprofData((String)localObject);
      Toast.makeText(ak.getContext(), (String)localObject + " hprof file has saved ", 0).show();
      ae.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", new Object[] { paramString, Long.valueOf(bu.DD(l)) });
      paramString = new k((String)localObject);
      if (!paramString.exists())
      {
        ae.e("MicroMsg.MemoryDumpManager", "Hprof dump file is not exist");
        AppMethodBeat.o(145586);
        return null;
      }
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
      AppMethodBeat.o(145586);
      return null;
    }
    paramString = r.a(paramString, true, null);
    if (paramString == null)
    {
      ae.e("MicroMsg.MemoryDumpManager", "zip hprof file fail");
      AppMethodBeat.o(145586);
      return null;
    }
    AppMethodBeat.o(145586);
    return paramString;
  }
  
  private static boolean ac(k paramk)
  {
    AppMethodBeat.i(170137);
    if (paramk.exists())
    {
      AppMethodBeat.o(170137);
      return true;
    }
    if (!paramk.mkdirs())
    {
      boolean bool = paramk.exists();
      AppMethodBeat.o(170137);
      return bool;
    }
    AppMethodBeat.o(170137);
    return true;
  }
  
  private static boolean fyv()
  {
    AppMethodBeat.i(145583);
    if (!c.abo())
    {
      ae.i("MicroMsg.MemoryDumpManager", "Hprof sdcard is invalid");
      AppMethodBeat.o(145583);
      return false;
    }
    k localk = new k(Jmc);
    if (!localk.exists()) {
      localk.mkdirs();
    }
    AppMethodBeat.o(145583);
    return true;
  }
  
  public static void fyw()
  {
    AppMethodBeat.i(145588);
    Runtime.getRuntime().gc();
    System.runFinalization();
    AppMethodBeat.o(145588);
  }
  
  /* Error */
  public static void fyx()
  {
    // Byte code:
    //   0: ldc 250
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 256	android/os/Build$VERSION:SDK_INT	I
    //   8: bipush 14
    //   10: if_icmplt +17 -> 27
    //   13: getstatic 262	com/tencent/mm/performance/a/a:iMQ	Lcom/tencent/mm/performance/a/a$a;
    //   16: invokeinterface 267 1 0
    //   21: ldc 250
    //   23: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: new 17	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 269
    //   34: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: invokestatic 275	android/os/Process:myPid	()I
    //   40: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore_0
    //   47: invokestatic 238	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   50: aload_0
    //   51: invokevirtual 279	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   54: astore 4
    //   56: new 281	java/io/InputStreamReader
    //   59: dup
    //   60: aload 4
    //   62: invokevirtual 287	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   65: invokespecial 290	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: astore_0
    //   69: new 292	java/io/LineNumberReader
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 295	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   77: astore_3
    //   78: aload_3
    //   79: astore_2
    //   80: aload_0
    //   81: astore_1
    //   82: aload_3
    //   83: invokevirtual 298	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   86: astore 5
    //   88: aload 5
    //   90: ifnull +52 -> 142
    //   93: aload_3
    //   94: astore_2
    //   95: aload_0
    //   96: astore_1
    //   97: ldc 99
    //   99: aload 5
    //   101: invokestatic 231	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: goto -26 -> 78
    //   107: astore_1
    //   108: aload_3
    //   109: astore_2
    //   110: aload_0
    //   111: astore_1
    //   112: ldc 99
    //   114: ldc_w 300
    //   117: invokestatic 201	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_3
    //   121: ifnull +7 -> 128
    //   124: aload_3
    //   125: invokevirtual 303	java/io/LineNumberReader:close	()V
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 304	java/io/InputStreamReader:close	()V
    //   136: ldc 250
    //   138: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: return
    //   142: aload_3
    //   143: astore_2
    //   144: aload_0
    //   145: astore_1
    //   146: aload 4
    //   148: invokevirtual 307	java/lang/Process:waitFor	()I
    //   151: pop
    //   152: aload_3
    //   153: astore_2
    //   154: aload_0
    //   155: astore_1
    //   156: aload 4
    //   158: invokevirtual 310	java/lang/Process:destroy	()V
    //   161: aload_3
    //   162: invokevirtual 303	java/io/LineNumberReader:close	()V
    //   165: aload_0
    //   166: invokevirtual 304	java/io/InputStreamReader:close	()V
    //   169: ldc 250
    //   171: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: return
    //   175: astore_0
    //   176: ldc 250
    //   178: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: return
    //   182: astore_0
    //   183: ldc 250
    //   185: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: return
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_3
    //   192: aconst_null
    //   193: astore_0
    //   194: aload_3
    //   195: astore_2
    //   196: aload_0
    //   197: astore_1
    //   198: ldc 99
    //   200: ldc_w 312
    //   203: invokestatic 201	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 303	java/io/LineNumberReader:close	()V
    //   214: aload_0
    //   215: ifnull +7 -> 222
    //   218: aload_0
    //   219: invokevirtual 304	java/io/InputStreamReader:close	()V
    //   222: ldc 250
    //   224: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: return
    //   228: astore_0
    //   229: ldc 250
    //   231: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: return
    //   235: astore_1
    //   236: aconst_null
    //   237: astore_2
    //   238: aconst_null
    //   239: astore_0
    //   240: aload_2
    //   241: ifnull +7 -> 248
    //   244: aload_2
    //   245: invokevirtual 303	java/io/LineNumberReader:close	()V
    //   248: aload_0
    //   249: ifnull +7 -> 256
    //   252: aload_0
    //   253: invokevirtual 304	java/io/InputStreamReader:close	()V
    //   256: ldc 250
    //   258: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload_1
    //   262: athrow
    //   263: astore_0
    //   264: goto -8 -> 256
    //   267: astore_1
    //   268: aconst_null
    //   269: astore_2
    //   270: goto -30 -> 240
    //   273: astore_3
    //   274: aload_1
    //   275: astore_0
    //   276: aload_3
    //   277: astore_1
    //   278: goto -38 -> 240
    //   281: astore_1
    //   282: aconst_null
    //   283: astore_3
    //   284: goto -90 -> 194
    //   287: astore_1
    //   288: goto -94 -> 194
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_3
    //   294: aconst_null
    //   295: astore_0
    //   296: goto -188 -> 108
    //   299: astore_1
    //   300: aconst_null
    //   301: astore_3
    //   302: goto -194 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   46	120	0	localObject1	Object
    //   175	1	0	localIOException1	java.io.IOException
    //   182	1	0	localIOException2	java.io.IOException
    //   189	1	0	localInterruptedException1	java.lang.InterruptedException
    //   193	26	0	localObject2	Object
    //   228	1	0	localIOException3	java.io.IOException
    //   239	14	0	localObject3	Object
    //   263	1	0	localIOException4	java.io.IOException
    //   275	1	0	localObject4	Object
    //   291	1	0	localIOException5	java.io.IOException
    //   295	1	0	localObject5	Object
    //   81	16	1	localObject6	Object
    //   107	1	1	localIOException6	java.io.IOException
    //   111	87	1	localObject7	Object
    //   235	27	1	localObject8	Object
    //   267	8	1	localObject9	Object
    //   277	1	1	localObject10	Object
    //   281	1	1	localInterruptedException2	java.lang.InterruptedException
    //   287	1	1	localInterruptedException3	java.lang.InterruptedException
    //   299	1	1	localIOException7	java.io.IOException
    //   79	191	2	localLineNumberReader1	java.io.LineNumberReader
    //   77	134	3	localLineNumberReader2	java.io.LineNumberReader
    //   273	4	3	localObject11	Object
    //   283	19	3	localObject12	Object
    //   54	103	4	localProcess	java.lang.Process
    //   86	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   82	88	107	java/io/IOException
    //   97	104	107	java/io/IOException
    //   146	152	107	java/io/IOException
    //   156	161	107	java/io/IOException
    //   161	169	175	java/io/IOException
    //   124	128	182	java/io/IOException
    //   132	136	182	java/io/IOException
    //   47	69	189	java/lang/InterruptedException
    //   210	214	228	java/io/IOException
    //   218	222	228	java/io/IOException
    //   47	69	235	finally
    //   244	248	263	java/io/IOException
    //   252	256	263	java/io/IOException
    //   69	78	267	finally
    //   82	88	273	finally
    //   97	104	273	finally
    //   112	120	273	finally
    //   146	152	273	finally
    //   156	161	273	finally
    //   198	206	273	finally
    //   69	78	281	java/lang/InterruptedException
    //   82	88	287	java/lang/InterruptedException
    //   97	104	287	java/lang/InterruptedException
    //   146	152	287	java/lang/InterruptedException
    //   156	161	287	java/lang/InterruptedException
    //   47	69	291	java/io/IOException
    //   69	78	299	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ci.b
 * JD-Core Version:    0.7.0.1
 */