package com.tencent.mm.ck;

import android.os.Debug;
import android.os.Environment;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.r;
import com.tencent.mm.performance.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String FFb;
  
  static
  {
    AppMethodBeat.i(145591);
    FFb = Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/memory/";
    AppMethodBeat.o(145591);
  }
  
  private static boolean aG(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(145584);
    if (!eOI())
    {
      AppMethodBeat.o(145584);
      return false;
    }
    Object localObject = new e(FFb);
    e[] arrayOfe = ((e)localObject).fhW();
    if (arrayOfe.length == 0)
    {
      AppMethodBeat.o(145584);
      return true;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    long l1 = new Date().getTime();
    boolean bool1 = true;
    int j = arrayOfe.length;
    int i = 0;
    e locale;
    String str;
    if (i < j)
    {
      locale = arrayOfe[i];
      str = locale.getName();
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
          locale.delete();
          bool2 = bool1;
        }
        catch (ParseException localParseException)
        {
          ad.e("MicroMsg.MemoryDumpManager", "hprofFileCheck parse date fail %s", new Object[] { str });
          locale.delete();
          boolean bool2 = bool1;
          continue;
          long l2 = localParseException.getTime();
          if (l2 < l1) {
            continue;
          }
          locale.delete();
          bool2 = bool1;
          continue;
          l2 = (l1 - l2) / 86400000L;
          if (l2 < 3L) {
            continue;
          }
          locale.delete();
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
        locale.delete();
        bool2 = bool1;
      }
    }
    localObject = ((e)localObject).fhW();
    if (localObject.length > 5)
    {
      if (paramBoolean2) {
        Toast.makeText(aj.getContext(), "dump fail, hprof file size exceed", 0).show();
      }
      ad.w("MicroMsg.MemoryDumpManager", "hprofFileCheck hprofFileDir.length() too large " + localObject.length);
      AppMethodBeat.o(145584);
      return false;
    }
    AppMethodBeat.o(145584);
    return bool1;
  }
  
  public static String aH(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(145585);
    if (!aG(paramBoolean1, paramBoolean2))
    {
      AppMethodBeat.o(145585);
      return null;
    }
    long l = System.currentTimeMillis();
    String str = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(FFb).append(str).append(".hprof");
    localObject = ((StringBuffer)localObject).toString();
    if (!ab(new e((String)localObject).fhT()))
    {
      ad.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", new Object[] { localObject });
      AppMethodBeat.o(145585);
      return null;
    }
    try
    {
      eOJ();
      Debug.dumpHprofData((String)localObject);
      if (paramBoolean2) {
        Toast.makeText(aj.getContext(), (String)localObject + " hprof file has saved ", 0).show();
      }
      ad.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", new Object[] { str, Long.valueOf(bt.vM(l)) });
      AppMethodBeat.o(145585);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
      AppMethodBeat.o(145585);
    }
    return null;
  }
  
  public static String aJP(String paramString)
  {
    AppMethodBeat.i(145586);
    if (!eOI())
    {
      AppMethodBeat.o(145586);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(FFb).append(paramString).append(".hprof");
    localObject = ((StringBuffer)localObject).toString();
    if (!ab(new e((String)localObject).fhT()))
    {
      ad.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", new Object[] { localObject });
      AppMethodBeat.o(145586);
      return null;
    }
    try
    {
      eOJ();
      Debug.dumpHprofData((String)localObject);
      Toast.makeText(aj.getContext(), (String)localObject + " hprof file has saved ", 0).show();
      ad.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", new Object[] { paramString, Long.valueOf(bt.vM(l)) });
      paramString = new e((String)localObject);
      if (!paramString.exists())
      {
        ad.e("MicroMsg.MemoryDumpManager", "Hprof dump file is not exist");
        AppMethodBeat.o(145586);
        return null;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
      AppMethodBeat.o(145586);
      return null;
    }
    paramString = r.a(paramString, true, null);
    if (paramString == null)
    {
      ad.e("MicroMsg.MemoryDumpManager", "zip hprof file fail");
      AppMethodBeat.o(145586);
      return null;
    }
    AppMethodBeat.o(145586);
    return paramString;
  }
  
  private static boolean ab(e parame)
  {
    AppMethodBeat.i(170137);
    if (parame.exists())
    {
      AppMethodBeat.o(170137);
      return true;
    }
    if (!parame.mkdirs())
    {
      boolean bool = parame.exists();
      AppMethodBeat.o(170137);
      return bool;
    }
    AppMethodBeat.o(170137);
    return true;
  }
  
  private static boolean eOI()
  {
    AppMethodBeat.i(145583);
    if (!c.XG())
    {
      ad.i("MicroMsg.MemoryDumpManager", "Hprof sdcard is invalid");
      AppMethodBeat.o(145583);
      return false;
    }
    e locale = new e(FFb);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(145583);
    return true;
  }
  
  public static void eOJ()
  {
    AppMethodBeat.i(145588);
    Runtime.getRuntime().gc();
    System.runFinalization();
    AppMethodBeat.o(145588);
  }
  
  /* Error */
  public static void eOK()
  {
    // Byte code:
    //   0: ldc 250
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 256	android/os/Build$VERSION:SDK_INT	I
    //   8: bipush 14
    //   10: if_icmplt +18 -> 28
    //   13: invokestatic 262	com/tencent/mm/performance/a/a:aFM	()Lcom/tencent/mm/performance/a/a;
    //   16: iconst_1
    //   17: iconst_0
    //   18: invokevirtual 266	com/tencent/mm/performance/a/a:l	(ZI)Lcom/tencent/mm/performance/a/a$a;
    //   21: pop
    //   22: ldc 250
    //   24: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: new 17	java/lang/StringBuilder
    //   31: dup
    //   32: ldc_w 268
    //   35: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: invokestatic 274	android/os/Process:myPid	()I
    //   41: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore_0
    //   48: invokestatic 238	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   51: aload_0
    //   52: invokevirtual 278	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   55: astore 4
    //   57: new 280	java/io/InputStreamReader
    //   60: dup
    //   61: aload 4
    //   63: invokevirtual 286	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   66: invokespecial 289	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   69: astore_0
    //   70: new 291	java/io/LineNumberReader
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 294	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   78: astore_3
    //   79: aload_3
    //   80: astore_2
    //   81: aload_0
    //   82: astore_1
    //   83: aload_3
    //   84: invokevirtual 297	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   87: astore 5
    //   89: aload 5
    //   91: ifnull +52 -> 143
    //   94: aload_3
    //   95: astore_2
    //   96: aload_0
    //   97: astore_1
    //   98: ldc 99
    //   100: aload 5
    //   102: invokestatic 231	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: goto -26 -> 79
    //   108: astore_1
    //   109: aload_3
    //   110: astore_2
    //   111: aload_0
    //   112: astore_1
    //   113: ldc 99
    //   115: ldc_w 299
    //   118: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_3
    //   122: ifnull +7 -> 129
    //   125: aload_3
    //   126: invokevirtual 302	java/io/LineNumberReader:close	()V
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 303	java/io/InputStreamReader:close	()V
    //   137: ldc 250
    //   139: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: return
    //   143: aload_3
    //   144: astore_2
    //   145: aload_0
    //   146: astore_1
    //   147: aload 4
    //   149: invokevirtual 306	java/lang/Process:waitFor	()I
    //   152: pop
    //   153: aload_3
    //   154: astore_2
    //   155: aload_0
    //   156: astore_1
    //   157: aload 4
    //   159: invokevirtual 309	java/lang/Process:destroy	()V
    //   162: aload_3
    //   163: invokevirtual 302	java/io/LineNumberReader:close	()V
    //   166: aload_0
    //   167: invokevirtual 303	java/io/InputStreamReader:close	()V
    //   170: ldc 250
    //   172: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: return
    //   176: astore_0
    //   177: ldc 250
    //   179: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: astore_0
    //   184: ldc 250
    //   186: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: return
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_0
    //   195: aload_3
    //   196: astore_2
    //   197: aload_0
    //   198: astore_1
    //   199: ldc 99
    //   201: ldc_w 311
    //   204: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_3
    //   208: ifnull +7 -> 215
    //   211: aload_3
    //   212: invokevirtual 302	java/io/LineNumberReader:close	()V
    //   215: aload_0
    //   216: ifnull +7 -> 223
    //   219: aload_0
    //   220: invokevirtual 303	java/io/InputStreamReader:close	()V
    //   223: ldc 250
    //   225: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    //   229: astore_0
    //   230: ldc 250
    //   232: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    //   236: astore_1
    //   237: aconst_null
    //   238: astore_2
    //   239: aconst_null
    //   240: astore_0
    //   241: aload_2
    //   242: ifnull +7 -> 249
    //   245: aload_2
    //   246: invokevirtual 302	java/io/LineNumberReader:close	()V
    //   249: aload_0
    //   250: ifnull +7 -> 257
    //   253: aload_0
    //   254: invokevirtual 303	java/io/InputStreamReader:close	()V
    //   257: ldc 250
    //   259: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: aload_1
    //   263: athrow
    //   264: astore_0
    //   265: goto -8 -> 257
    //   268: astore_1
    //   269: aconst_null
    //   270: astore_2
    //   271: goto -30 -> 241
    //   274: astore_3
    //   275: aload_1
    //   276: astore_0
    //   277: aload_3
    //   278: astore_1
    //   279: goto -38 -> 241
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_3
    //   285: goto -90 -> 195
    //   288: astore_1
    //   289: goto -94 -> 195
    //   292: astore_0
    //   293: aconst_null
    //   294: astore_3
    //   295: aconst_null
    //   296: astore_0
    //   297: goto -188 -> 109
    //   300: astore_1
    //   301: aconst_null
    //   302: astore_3
    //   303: goto -194 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	120	0	localObject1	Object
    //   176	1	0	localIOException1	java.io.IOException
    //   183	1	0	localIOException2	java.io.IOException
    //   190	1	0	localInterruptedException1	java.lang.InterruptedException
    //   194	26	0	localObject2	Object
    //   229	1	0	localIOException3	java.io.IOException
    //   240	14	0	localObject3	Object
    //   264	1	0	localIOException4	java.io.IOException
    //   276	1	0	localObject4	Object
    //   292	1	0	localIOException5	java.io.IOException
    //   296	1	0	localObject5	Object
    //   82	16	1	localObject6	Object
    //   108	1	1	localIOException6	java.io.IOException
    //   112	87	1	localObject7	Object
    //   236	27	1	localObject8	Object
    //   268	8	1	localObject9	Object
    //   278	1	1	localObject10	Object
    //   282	1	1	localInterruptedException2	java.lang.InterruptedException
    //   288	1	1	localInterruptedException3	java.lang.InterruptedException
    //   300	1	1	localIOException7	java.io.IOException
    //   80	191	2	localLineNumberReader1	java.io.LineNumberReader
    //   78	134	3	localLineNumberReader2	java.io.LineNumberReader
    //   274	4	3	localObject11	Object
    //   284	19	3	localObject12	Object
    //   55	103	4	localProcess	java.lang.Process
    //   87	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   83	89	108	java/io/IOException
    //   98	105	108	java/io/IOException
    //   147	153	108	java/io/IOException
    //   157	162	108	java/io/IOException
    //   162	170	176	java/io/IOException
    //   125	129	183	java/io/IOException
    //   133	137	183	java/io/IOException
    //   48	70	190	java/lang/InterruptedException
    //   211	215	229	java/io/IOException
    //   219	223	229	java/io/IOException
    //   48	70	236	finally
    //   245	249	264	java/io/IOException
    //   253	257	264	java/io/IOException
    //   70	79	268	finally
    //   83	89	274	finally
    //   98	105	274	finally
    //   113	121	274	finally
    //   147	153	274	finally
    //   157	162	274	finally
    //   199	207	274	finally
    //   70	79	282	java/lang/InterruptedException
    //   83	89	288	java/lang/InterruptedException
    //   98	105	288	java/lang/InterruptedException
    //   147	153	288	java/lang/InterruptedException
    //   157	162	288	java/lang/InterruptedException
    //   48	70	292	java/io/IOException
    //   70	79	300	java/io/IOException
  }
  
  public static void eOL()
  {
    AppMethodBeat.i(200804);
    a.aFM().l(true, 0);
    AppMethodBeat.o(200804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ck.b
 * JD-Core Version:    0.7.0.1
 */