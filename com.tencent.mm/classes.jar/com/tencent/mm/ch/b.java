package com.tencent.mm.ch;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String uFQ = Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/memory/";
  
  private static boolean O(File paramFile)
  {
    if (paramFile.exists()) {}
    while (paramFile.mkdirs()) {
      return true;
    }
    return paramFile.exists();
  }
  
  private static boolean V(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1;
    if (!checkSdcard()) {
      bool1 = false;
    }
    Object localObject;
    do
    {
      return bool1;
      localObject = new File(uFQ);
      File[] arrayOfFile = ((File)localObject).listFiles();
      if (arrayOfFile.length == 0) {
        return true;
      }
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
      long l1 = new Date().getTime();
      bool1 = true;
      int j = arrayOfFile.length;
      int i = 0;
      File localFile;
      String str;
      if (i < j)
      {
        localFile = arrayOfFile[i];
        str = localFile.getName();
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
            localFile.delete();
            bool2 = bool1;
          }
          catch (ParseException localParseException)
          {
            y.e("MicroMsg.MemoryDumpManager", "hprofFileCheck parse date fail %s", new Object[] { str });
            localFile.delete();
            boolean bool2 = bool1;
            continue;
            long l2 = localParseException.getTime();
            if (l2 < l1) {
              continue;
            }
            localFile.delete();
            bool2 = bool1;
            continue;
            l2 = (l1 - l2) / 86400000L;
            if (l2 < 3L) {
              continue;
            }
            localFile.delete();
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
          localFile.delete();
          bool2 = bool1;
        }
      }
      localObject = ((File)localObject).listFiles();
    } while (localObject.length <= 5);
    if (paramBoolean2) {
      Toast.makeText(ae.getContext(), "dump fail, hprof file size exceed", 0).show();
    }
    y.w("MicroMsg.MemoryDumpManager", "hprofFileCheck hprofFileDir.length() too large " + localObject.length);
    return false;
  }
  
  public static String W(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!V(paramBoolean1, paramBoolean2)) {
      return null;
    }
    long l = System.currentTimeMillis();
    String str = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(uFQ).append(str).append(".hprof");
    localObject = ((StringBuffer)localObject).toString();
    if (!O(new File((String)localObject).getParentFile()))
    {
      y.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", new Object[] { localObject });
      return null;
    }
    try
    {
      cxx();
      Debug.dumpHprofData((String)localObject);
      if (paramBoolean2) {
        Toast.makeText(ae.getContext(), (String)localObject + " hprof file has saved ", 0).show();
      }
      y.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", new Object[] { str, Long.valueOf(bk.co(l)) });
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
    }
    return null;
  }
  
  public static String acS(String paramString)
  {
    if (!checkSdcard()) {
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(uFQ).append(paramString).append(".hprof");
    localObject = ((StringBuffer)localObject).toString();
    if (!O(new File((String)localObject).getParentFile()))
    {
      y.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", new Object[] { localObject });
      return null;
    }
    try
    {
      cxx();
      Debug.dumpHprofData((String)localObject);
      Toast.makeText(ae.getContext(), (String)localObject + " hprof file has saved ", 0).show();
      y.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", new Object[] { paramString, Long.valueOf(bk.co(l)) });
      paramString = new File((String)localObject);
      if (!paramString.exists())
      {
        y.e("MicroMsg.MemoryDumpManager", "Hprof dump file is not exist");
        return null;
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
      return null;
    }
    paramString = p.b(paramString, true, null);
    if (paramString == null)
    {
      y.e("MicroMsg.MemoryDumpManager", "zip hprof file fail");
      return null;
    }
    return paramString;
  }
  
  private static boolean checkSdcard()
  {
    if (!c.zF())
    {
      y.i("MicroMsg.MemoryDumpManager", "Hprof sdcard is invalid");
      return false;
    }
    File localFile = new File(uFQ);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return true;
  }
  
  public static void cxx()
  {
    Runtime.getRuntime().gc();
    System.runFinalization();
  }
  
  /* Error */
  public static void cxy()
  {
    // Byte code:
    //   0: getstatic 239	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 14
    //   5: if_icmplt +7 -> 12
    //   8: invokestatic 242	com/tencent/mm/ch/b:cxz	()V
    //   11: return
    //   12: new 10	java/lang/StringBuilder
    //   15: dup
    //   16: ldc 244
    //   18: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: invokestatic 250	android/os/Process:myPid	()I
    //   24: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore_0
    //   31: invokestatic 222	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   34: aload_0
    //   35: invokevirtual 254	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   38: astore 4
    //   40: new 256	java/io/InputStreamReader
    //   43: dup
    //   44: aload 4
    //   46: invokevirtual 262	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   49: invokespecial 265	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   52: astore_0
    //   53: new 267	java/io/LineNumberReader
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 270	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   61: astore_3
    //   62: aload_3
    //   63: astore_2
    //   64: aload_0
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 273	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   70: astore 5
    //   72: aload 5
    //   74: ifnull +49 -> 123
    //   77: aload_3
    //   78: astore_2
    //   79: aload_0
    //   80: astore_1
    //   81: ldc 96
    //   83: aload 5
    //   85: invokestatic 216	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -26 -> 62
    //   91: astore_1
    //   92: aload_3
    //   93: astore_2
    //   94: aload_0
    //   95: astore_1
    //   96: ldc 96
    //   98: ldc_w 275
    //   101: invokestatic 195	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_3
    //   105: ifnull +7 -> 112
    //   108: aload_3
    //   109: invokevirtual 278	java/io/LineNumberReader:close	()V
    //   112: aload_0
    //   113: ifnull -102 -> 11
    //   116: aload_0
    //   117: invokevirtual 279	java/io/InputStreamReader:close	()V
    //   120: return
    //   121: astore_0
    //   122: return
    //   123: aload_3
    //   124: astore_2
    //   125: aload_0
    //   126: astore_1
    //   127: aload 4
    //   129: invokevirtual 282	java/lang/Process:waitFor	()I
    //   132: pop
    //   133: aload_3
    //   134: astore_2
    //   135: aload_0
    //   136: astore_1
    //   137: aload 4
    //   139: invokevirtual 285	java/lang/Process:destroy	()V
    //   142: aload_3
    //   143: invokevirtual 278	java/io/LineNumberReader:close	()V
    //   146: aload_0
    //   147: invokevirtual 279	java/io/InputStreamReader:close	()V
    //   150: return
    //   151: astore_0
    //   152: return
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_3
    //   159: astore_2
    //   160: aload_0
    //   161: astore_1
    //   162: ldc 96
    //   164: ldc_w 287
    //   167: invokestatic 195	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload_3
    //   171: ifnull +7 -> 178
    //   174: aload_3
    //   175: invokevirtual 278	java/io/LineNumberReader:close	()V
    //   178: aload_0
    //   179: ifnull -168 -> 11
    //   182: aload_0
    //   183: invokevirtual 279	java/io/InputStreamReader:close	()V
    //   186: return
    //   187: astore_0
    //   188: return
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_0
    //   194: aload_2
    //   195: ifnull +7 -> 202
    //   198: aload_2
    //   199: invokevirtual 278	java/io/LineNumberReader:close	()V
    //   202: aload_0
    //   203: ifnull +7 -> 210
    //   206: aload_0
    //   207: invokevirtual 279	java/io/InputStreamReader:close	()V
    //   210: aload_1
    //   211: athrow
    //   212: astore_0
    //   213: goto -3 -> 210
    //   216: astore_1
    //   217: aconst_null
    //   218: astore_2
    //   219: goto -25 -> 194
    //   222: astore_3
    //   223: aload_1
    //   224: astore_0
    //   225: aload_3
    //   226: astore_1
    //   227: goto -33 -> 194
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_3
    //   233: goto -75 -> 158
    //   236: astore_1
    //   237: goto -79 -> 158
    //   240: astore_0
    //   241: aconst_null
    //   242: astore_3
    //   243: aconst_null
    //   244: astore_0
    //   245: goto -153 -> 92
    //   248: astore_1
    //   249: aconst_null
    //   250: astore_3
    //   251: goto -159 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   30	87	0	localObject1	Object
    //   121	26	0	localIOException1	java.io.IOException
    //   151	1	0	localIOException2	java.io.IOException
    //   153	1	0	localInterruptedException1	java.lang.InterruptedException
    //   157	26	0	localObject2	Object
    //   187	1	0	localIOException3	java.io.IOException
    //   193	14	0	localObject3	Object
    //   212	1	0	localIOException4	java.io.IOException
    //   224	1	0	localObject4	Object
    //   240	1	0	localIOException5	java.io.IOException
    //   244	1	0	localObject5	Object
    //   65	16	1	localObject6	Object
    //   91	1	1	localIOException6	java.io.IOException
    //   95	67	1	localObject7	Object
    //   189	22	1	localObject8	Object
    //   216	8	1	localObject9	Object
    //   226	1	1	localObject10	Object
    //   230	1	1	localInterruptedException2	java.lang.InterruptedException
    //   236	1	1	localInterruptedException3	java.lang.InterruptedException
    //   248	1	1	localIOException7	java.io.IOException
    //   63	156	2	localLineNumberReader1	java.io.LineNumberReader
    //   61	114	3	localLineNumberReader2	java.io.LineNumberReader
    //   222	4	3	localObject11	Object
    //   232	19	3	localObject12	Object
    //   38	100	4	localProcess	java.lang.Process
    //   70	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   66	72	91	java/io/IOException
    //   81	88	91	java/io/IOException
    //   127	133	91	java/io/IOException
    //   137	142	91	java/io/IOException
    //   108	112	121	java/io/IOException
    //   116	120	121	java/io/IOException
    //   142	150	151	java/io/IOException
    //   31	53	153	java/lang/InterruptedException
    //   174	178	187	java/io/IOException
    //   182	186	187	java/io/IOException
    //   31	53	189	finally
    //   198	202	212	java/io/IOException
    //   206	210	212	java/io/IOException
    //   53	62	216	finally
    //   66	72	222	finally
    //   81	88	222	finally
    //   96	104	222	finally
    //   127	133	222	finally
    //   137	142	222	finally
    //   162	170	222	finally
    //   53	62	230	java/lang/InterruptedException
    //   66	72	236	java/lang/InterruptedException
    //   81	88	236	java/lang/InterruptedException
    //   127	133	236	java/lang/InterruptedException
    //   137	142	236	java/lang/InterruptedException
    //   31	53	240	java/io/IOException
    //   53	62	248	java/io/IOException
  }
  
  public static void cxz()
  {
    Object localObject1 = (ActivityManager)ae.getContext().getSystemService("activity");
    y.i("MicroMsg.MemoryDumpManager", " wechat heap info ");
    y.i("MicroMsg.MemoryDumpManager", " Runtime.totalMemory " + Runtime.getRuntime().totalMemory());
    y.i("MicroMsg.MemoryDumpManager", " Runtime.freeMemory " + Runtime.getRuntime().freeMemory());
    y.i("MicroMsg.MemoryDumpManager", " Runtime.maxMemory " + Runtime.getRuntime().maxMemory());
    y.i("MicroMsg.MemoryDumpManager", " Debug.nativeHeapSize " + Debug.getNativeHeapSize());
    y.i("MicroMsg.MemoryDumpManager", " Debug.nativeHeapAllocatedSize " + Debug.getNativeHeapAllocatedSize());
    localObject1 = ((ActivityManager)localObject1).getProcessMemoryInfo(new int[] { Process.myPid() });
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      y.i("MicroMsg.MemoryDumpManager", " wechat memory info");
      y.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalPrivateDirty(): " + localObject2.getTotalPrivateDirty() + "\n");
      y.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalPss(): " + localObject2.getTotalPss() + "\n");
      y.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalSharedDirty(): " + localObject2.getTotalSharedDirty() + "\n");
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ch.b
 * JD-Core Version:    0.7.0.1
 */