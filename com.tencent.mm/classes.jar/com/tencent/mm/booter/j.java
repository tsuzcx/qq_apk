package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.u;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;

public final class j
{
  private static long lsa = -1L;
  private static final int[] lsb = { 20, 30, 40 };
  private static final int[] lsc = { 21, 31, 41 };
  private static final int[] lsd = { 22, 32, 42 };
  private static final int[] lse = { 23, 33, 43 };
  private static final int[] lsg = { 24, 34, 44 };
  private static final int[] lsh = { 25, 35, 45 };
  private static final int[] lsi = { 26, 36, 46 };
  private static final int[] lsj = { 27, 37, 47 };
  private static final int[] lsk = { 28, 38, 48 };
  private static final int[] lsl = { 29, 39, 49 };
  private static final int[] lsm = { 100, 110, 120 };
  private static final int[] lsn = { 101, 111, 121 };
  private static final int[] lso = { 102, 112, 122 };
  private static final int[] lsp = { 103, 113, 123 };
  private static final int[] lsq = { 104, 114, 124 };
  private static final int[] lsr = { 105, 115, 125 };
  private static final int[] lss = { 106, 116, 126 };
  private static final int[] lst = { 107, 117, 127 };
  private static final int[] lsu = { 108, 118, 128 };
  private static final int[] lsv = { 109, 119, 129 };
  private static final int[] lsw = { 160, 170, 180 };
  private static final int[] lsx = { 200, 210, 220 };
  
  /* Error */
  private static int aKH()
  {
    // Byte code:
    //   0: sipush 19887
    //   3: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 90	java/io/BufferedReader
    //   9: dup
    //   10: new 92	java/io/InputStreamReader
    //   13: dup
    //   14: ldc 94
    //   16: invokestatic 100	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: ldc 102
    //   21: invokespecial 106	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   24: invokespecial 109	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +110 -> 144
    //   37: aload_1
    //   38: invokestatic 119	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   41: ifne -13 -> 28
    //   44: aload_1
    //   45: invokestatic 119	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   48: ifeq +29 -> 77
    //   51: ldc 121
    //   53: astore_1
    //   54: aload_1
    //   55: ldc 123
    //   57: invokevirtual 129	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   60: istore_0
    //   61: iload_0
    //   62: ifeq +50 -> 112
    //   65: aload_3
    //   66: invokestatic 133	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   69: sipush 19887
    //   72: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: iconst_0
    //   76: ireturn
    //   77: aload_1
    //   78: ldc 138
    //   80: ldc 121
    //   82: invokevirtual 142	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: invokevirtual 145	java/lang/String:trim	()Ljava/lang/String;
    //   88: ldc 147
    //   90: ldc 121
    //   92: invokevirtual 142	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   95: invokevirtual 145	java/lang/String:trim	()Ljava/lang/String;
    //   98: ldc 149
    //   100: ldc 121
    //   102: invokevirtual 142	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   105: invokevirtual 145	java/lang/String:trim	()Ljava/lang/String;
    //   108: astore_1
    //   109: goto -55 -> 54
    //   112: aload_1
    //   113: ldc 151
    //   115: invokevirtual 129	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   118: ifne +14 -> 132
    //   121: aload_1
    //   122: ldc 153
    //   124: invokevirtual 129	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   127: istore_0
    //   128: iload_0
    //   129: ifeq -101 -> 28
    //   132: aload_3
    //   133: invokestatic 133	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   136: sipush 19887
    //   139: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: iconst_1
    //   143: ireturn
    //   144: aload_3
    //   145: invokestatic 133	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   148: sipush 19887
    //   151: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iconst_2
    //   155: ireturn
    //   156: astore_2
    //   157: aconst_null
    //   158: astore_1
    //   159: ldc 155
    //   161: aload_2
    //   162: ldc 157
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload_1
    //   172: invokestatic 133	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   175: sipush 19887
    //   178: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: iconst_m1
    //   182: ireturn
    //   183: astore_2
    //   184: aload_1
    //   185: invokestatic 133	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   188: sipush 19887
    //   191: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_2
    //   195: athrow
    //   196: astore_2
    //   197: aload_3
    //   198: astore_1
    //   199: goto -40 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   60	69	0	bool	boolean
    //   32	167	1	localObject1	Object
    //   156	6	2	localThrowable	java.lang.Throwable
    //   183	12	2	localObject2	Object
    //   196	1	2	localObject3	Object
    //   27	171	3	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   6	28	156	finally
    //   159	171	183	finally
    //   28	33	196	finally
    //   37	51	196	finally
    //   54	61	196	finally
    //   77	109	196	finally
    //   112	128	196	finally
  }
  
  private static boolean j(ArrayList<IDKey> paramArrayList)
  {
    int i4 = 1;
    AppMethodBeat.i(19888);
    int n = 0;
    int i = 0;
    int j = 0;
    int m = 0;
    int k = 0;
    String str;
    int i3;
    if (n < Build.SUPPORTED_32_BIT_ABIS.length)
    {
      str = Build.SUPPORTED_32_BIT_ABIS[n];
      if ("armeabi".equalsIgnoreCase(str))
      {
        i3 = 1;
        i2 = m;
        i1 = j;
      }
      for (;;)
      {
        n += 1;
        j = i1;
        m = i2;
        k = i3;
        break;
        if ("armeabi-v7a".equalsIgnoreCase(str))
        {
          i2 = 1;
          i1 = j;
          i3 = k;
        }
        else if ("x86".equalsIgnoreCase(str))
        {
          i1 = 1;
          i2 = m;
          i3 = k;
        }
        else
        {
          i1 = j;
          i2 = m;
          i3 = k;
          if ("mips".equalsIgnoreCase(str))
          {
            i = 1;
            i1 = j;
            i2 = m;
            i3 = k;
          }
        }
      }
    }
    int i2 = 0;
    n = 0;
    int i1 = 0;
    boolean bool1 = false;
    if (i2 < Build.SUPPORTED_64_BIT_ABIS.length)
    {
      str = Build.SUPPORTED_64_BIT_ABIS[i2];
      boolean bool2;
      if ("arm64-v8a".equalsIgnoreCase(str))
      {
        bool2 = true;
        i3 = i1;
      }
      for (;;)
      {
        i2 += 1;
        i1 = i3;
        bool1 = bool2;
        break;
        if ("x86_64".equalsIgnoreCase(str))
        {
          i3 = 1;
          bool2 = bool1;
        }
        else
        {
          i3 = i1;
          bool2 = bool1;
          if ("mips64".equalsIgnoreCase(str))
          {
            n = 1;
            i3 = i1;
            bool2 = bool1;
          }
        }
      }
    }
    if (k != 0) {
      paramArrayList.add(new IDKey(661, 10, 1));
    }
    if (m != 0) {
      paramArrayList.add(new IDKey(661, 11, 1));
    }
    if (bool1) {
      paramArrayList.add(new IDKey(661, 12, 1));
    }
    if (j != 0) {
      paramArrayList.add(new IDKey(661, 13, 1));
    }
    if (i1 != 0) {
      paramArrayList.add(new IDKey(661, 14, 1));
    }
    if (i != 0) {
      paramArrayList.add(new IDKey(661, 15, 1));
    }
    if (n != 0) {
      paramArrayList.add(new IDKey(661, 16, 1));
    }
    paramArrayList = f.Ozc;
    if (bool1)
    {
      i2 = 1;
      if (m == 0) {
        break label566;
      }
      m = 1;
      label450:
      if (k == 0) {
        break label572;
      }
      k = 1;
      label456:
      if (j == 0) {
        break label577;
      }
      j = 1;
      label462:
      if (i1 == 0) {
        break label582;
      }
      i1 = 1;
      label470:
      if (i == 0) {
        break label588;
      }
      i = 1;
      label476:
      if (n == 0) {
        break label593;
      }
    }
    label566:
    label572:
    label577:
    label582:
    label588:
    label593:
    for (n = i4;; n = 0)
    {
      paramArrayList.b(18459, new Object[] { Integer.valueOf(i2), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(n) });
      AppMethodBeat.o(19888);
      return bool1;
      i2 = 0;
      break;
      m = 0;
      break label450;
      k = 0;
      break label456;
      j = 0;
      break label462;
      i1 = 0;
      break label470;
      i = 0;
      break label476;
    }
  }
  
  public static void run()
  {
    AppMethodBeat.i(19889);
    if (lsa < 0L) {
      lsa = MMApplicationContext.getContext().getSharedPreferences("eabi_report", 0).getLong("last_report", -1L);
    }
    boolean bool1;
    Object localObject;
    int i;
    ArrayList localArrayList;
    label204:
    label373:
    String str;
    if ((lsa < 0L) || (System.currentTimeMillis() - lsa > 86400000L))
    {
      bool1 = u.aPw();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new IDKey(1726, 0, 1));
      if (bool1) {
        ((ArrayList)localObject).add(new IDKey(1726, 1, 1));
      }
      f.Ozc.b((ArrayList)localObject, false);
      if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) {
        break label813;
      }
      i = 1;
      Log.i("MicroMsg.PostTaskReportEABISupport", "current device support eabi: %s, %s", new Object[] { Arrays.toString(Build.SUPPORTED_32_BIT_ABIS), Arrays.toString(Build.SUPPORTED_64_BIT_ABIS) });
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(661, 3, 1));
      if (i == 0) {
        break label818;
      }
      localArrayList.add(new IDKey(661, 4, 1));
      bool1 = j(localArrayList);
      if (!bool1) {
        break label839;
      }
      localArrayList.add(new IDKey(661, 64, 1));
      if (Build.VERSION.SDK_INT - 21 < 10) {
        localArrayList.add(new IDKey(661, Build.VERSION.SDK_INT - 21 + 90, 1));
      }
      label270:
      Log.i("MicroMsg.PostTaskReportEABISupport", "supportArm64_v8a : %s", new Object[] { Boolean.valueOf(bool1) });
      localArrayList.add(new IDKey(661, 50, 1));
      localArrayList.add(new IDKey(661, 240, 1));
      if (!BuildInfo.IS_ARM64) {
        break label898;
      }
      localArrayList.add(new IDKey(661, 52, 1));
      localArrayList.add(new IDKey(661, 242, 1));
      boolean bool2 = "arm64-v8a".equalsIgnoreCase(Build.CPU_ABI);
      if (((!BuildInfo.IS_ARM64) || (!bool2)) && ((BuildInfo.IS_ARM64) || (bool2))) {
        break label940;
      }
      localArrayList.add(new IDKey(661, 53, 1));
      label421:
      Log.i("MicroMsg.PostTaskReportEABISupport", "IS_ARM64: %s, isRuntime64 : %s", new Object[] { Boolean.valueOf(BuildInfo.IS_ARM64), Boolean.valueOf(bool2) });
      i = aKH();
      Log.i("MicroMsg.PostTaskReportEABISupport", "supportArm64FromCpuInfo : %s", new Object[] { Integer.valueOf(i) });
      if (i != -1) {
        break label962;
      }
      localArrayList.add(new IDKey(661, 63, 1));
      label496:
      if (((!bool1) || (i != 1)) && ((bool1) || (i != 0))) {
        break label1042;
      }
      localArrayList.add(new IDKey(661, 66, 1));
      label532:
      str = Build.BRAND.toLowerCase();
      if ((!str.contains("xiaomi")) && (!str.contains("redmi"))) {
        break label1103;
      }
      localObject = lsg;
      label566:
      localArrayList.add(new IDKey(661, localObject[0], 1));
      if (!bool1) {
        break label1271;
      }
      localArrayList.add(new IDKey(661, localObject[1], 1));
      label610:
      bool1 = BuildInfo.IS_ARM64;
      str = Build.BRAND.toLowerCase();
      if ((!str.contains("xiaomi")) && (!str.contains("redmi"))) {
        break label1294;
      }
      localObject = lsq;
      label648:
      localArrayList.add(new IDKey(661, localObject[0], 1));
      if (!bool1) {
        break label1469;
      }
      localArrayList.add(new IDKey(661, localObject[2], 1));
      label692:
      bool1 = BuildInfo.IS_ARM64;
      i = Build.VERSION.SDK_INT - 21;
      if (i >= 10) {
        break label1519;
      }
      localArrayList.add(new IDKey(661, lsw[0] + i, 1));
      if (!bool1) {
        break label1492;
      }
      localArrayList.add(new IDKey(661, i + lsw[2], 1));
    }
    for (;;)
    {
      f.Ozc.b(localArrayList, false);
      lsa = System.currentTimeMillis();
      MMApplicationContext.getContext().getSharedPreferences("eabi_report", 0).edit().putLong("last_report", lsa).commit();
      AppMethodBeat.o(19889);
      return;
      label813:
      i = 0;
      break;
      label818:
      localArrayList.add(new IDKey(661, 5, 1));
      break label204;
      label839:
      localArrayList.add(new IDKey(661, 65, 1));
      if (Build.VERSION.SDK_INT - 21 >= 10) {
        break label270;
      }
      localArrayList.add(new IDKey(661, Build.VERSION.SDK_INT - 21 + 80, 1));
      break label270;
      label898:
      localArrayList.add(new IDKey(661, 51, 1));
      localArrayList.add(new IDKey(661, 241, 1));
      break label373;
      label940:
      localArrayList.add(new IDKey(661, 54, 1));
      break label421;
      label962:
      if (i == 0)
      {
        localArrayList.add(new IDKey(661, 61, 1));
        break label496;
      }
      if (i == 1)
      {
        localArrayList.add(new IDKey(661, 60, 1));
        break label496;
      }
      if (i != 2) {
        break label496;
      }
      localArrayList.add(new IDKey(661, 62, 1));
      break label496;
      label1042:
      if (((bool1) && (i == 0)) || ((!bool1) && (i == 1)))
      {
        localArrayList.add(new IDKey(661, 67, 1));
        break label532;
      }
      localArrayList.add(new IDKey(661, 68, 1));
      break label532;
      label1103:
      if (str.contains("huawei"))
      {
        localObject = lsb;
        break label566;
      }
      if (str.contains("honor"))
      {
        localObject = lsc;
        break label566;
      }
      if (str.contains("vivo"))
      {
        localObject = lsd;
        break label566;
      }
      if (str.contains("oppo"))
      {
        localObject = lse;
        break label566;
      }
      if (str.contains("samsung"))
      {
        localObject = lsh;
        break label566;
      }
      if (str.contains("meizu"))
      {
        localObject = lsi;
        break label566;
      }
      if (str.contains("gionee"))
      {
        localObject = lsj;
        break label566;
      }
      if (str.contains("oneplus"))
      {
        localObject = lsk;
        break label566;
      }
      localObject = lsl;
      Log.i("MicroMsg.PostTaskReportEABISupport", "factoryKeys : %s", new Object[] { str });
      break label566;
      label1271:
      localArrayList.add(new IDKey(661, localObject[2], 1));
      break label610;
      label1294:
      if (str.contains("huawei"))
      {
        localObject = lsm;
        break label648;
      }
      if (str.contains("honor"))
      {
        localObject = lsn;
        break label648;
      }
      if (str.contains("vivo"))
      {
        localObject = lso;
        break label648;
      }
      if (str.contains("oppo"))
      {
        localObject = lsp;
        break label648;
      }
      if (str.contains("samsung"))
      {
        localObject = lsr;
        break label648;
      }
      if (str.contains("meizu"))
      {
        localObject = lss;
        break label648;
      }
      if (str.contains("gionee"))
      {
        localObject = lst;
        break label648;
      }
      if (str.contains("oneplus"))
      {
        localObject = lsu;
        break label648;
      }
      localObject = lsv;
      Log.i("MicroMsg.PostTaskReportEABISupport", "wechatKeys : %s %s", new Object[] { str, Boolean.valueOf(bool1) });
      break label648;
      label1469:
      localArrayList.add(new IDKey(661, localObject[1], 1));
      break label692;
      label1492:
      localArrayList.add(new IDKey(661, i + lsw[1], 1));
      continue;
      label1519:
      if ((i >= 10) && (i < 20))
      {
        i -= 10;
        localArrayList.add(new IDKey(661, lsx[0] + i, 1));
        if (bool1) {
          localArrayList.add(new IDKey(661, i + lsx[2], 1));
        } else {
          localArrayList.add(new IDKey(661, i + lsx[1], 1));
        }
      }
      else
      {
        Log.w("MicroMsg.PostTaskReportEABISupport", "Api level is too high, %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.j
 * JD-Core Version:    0.7.0.1
 */