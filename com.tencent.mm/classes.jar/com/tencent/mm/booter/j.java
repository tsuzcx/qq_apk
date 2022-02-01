package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
import java.util.ArrayList;
import java.util.Arrays;

public final class j
{
  private static long fmB = -1L;
  private static final int[] fmC = { 20, 30, 40 };
  private static final int[] fmD = { 21, 31, 41 };
  private static final int[] fmE = { 22, 32, 42 };
  private static final int[] fmF = { 23, 33, 43 };
  private static final int[] fmG = { 24, 34, 44 };
  private static final int[] fmH = { 25, 35, 45 };
  private static final int[] fmI = { 26, 36, 46 };
  private static final int[] fmJ = { 27, 37, 47 };
  private static final int[] fmK = { 28, 38, 48 };
  private static final int[] fmL = { 29, 39, 49 };
  private static final int[] fmM = { 100, 110, 120 };
  private static final int[] fmN = { 101, 111, 121 };
  private static final int[] fmO = { 102, 112, 122 };
  private static final int[] fmP = { 103, 113, 123 };
  private static final int[] fmQ = { 104, 114, 124 };
  private static final int[] fmR = { 105, 115, 125 };
  private static final int[] fmS = { 106, 116, 126 };
  private static final int[] fmT = { 107, 117, 127 };
  private static final int[] fmU = { 108, 118, 128 };
  private static final int[] fmV = { 109, 119, 129 };
  
  /* Error */
  private static int UB()
  {
    // Byte code:
    //   0: sipush 19887
    //   3: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 86	java/io/BufferedReader
    //   9: dup
    //   10: new 88	java/io/InputStreamReader
    //   13: dup
    //   14: ldc 90
    //   16: invokestatic 96	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: ldc 98
    //   21: invokespecial 102	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   24: invokespecial 105	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +122 -> 158
    //   39: aload_2
    //   40: astore_1
    //   41: aload_3
    //   42: invokestatic 115	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   45: ifne -17 -> 28
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: invokestatic 115	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   54: ifeq +31 -> 85
    //   57: ldc 117
    //   59: astore_3
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: ldc 119
    //   65: invokevirtual 125	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   68: istore_0
    //   69: iload_0
    //   70: ifeq +52 -> 122
    //   73: aload_2
    //   74: invokestatic 129	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   77: sipush 19887
    //   80: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_0
    //   84: ireturn
    //   85: aload_2
    //   86: astore_1
    //   87: aload_3
    //   88: ldc 134
    //   90: ldc 117
    //   92: invokevirtual 138	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   95: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   98: ldc 143
    //   100: ldc 117
    //   102: invokevirtual 138	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   105: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   108: ldc 145
    //   110: ldc 117
    //   112: invokevirtual 138	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   115: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   118: astore_3
    //   119: goto -59 -> 60
    //   122: aload_2
    //   123: astore_1
    //   124: aload_3
    //   125: ldc 147
    //   127: invokevirtual 125	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   130: ifne +16 -> 146
    //   133: aload_2
    //   134: astore_1
    //   135: aload_3
    //   136: ldc 149
    //   138: invokevirtual 125	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   141: istore_0
    //   142: iload_0
    //   143: ifeq -115 -> 28
    //   146: aload_2
    //   147: invokestatic 129	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   150: sipush 19887
    //   153: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: aload_2
    //   159: invokestatic 129	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   162: sipush 19887
    //   165: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iconst_2
    //   169: ireturn
    //   170: astore_3
    //   171: aconst_null
    //   172: astore_2
    //   173: aload_2
    //   174: astore_1
    //   175: ldc 151
    //   177: aload_3
    //   178: ldc 153
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 159	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: aload_2
    //   188: invokestatic 129	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   191: sipush 19887
    //   194: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: iconst_m1
    //   198: ireturn
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_1
    //   203: invokestatic 129	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   206: sipush 19887
    //   209: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_2
    //   213: athrow
    //   214: astore_2
    //   215: goto -13 -> 202
    //   218: astore_3
    //   219: goto -46 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   68	75	0	bool	boolean
    //   29	174	1	localBufferedReader1	java.io.BufferedReader
    //   27	161	2	localBufferedReader2	java.io.BufferedReader
    //   199	14	2	localObject1	Object
    //   214	1	2	localObject2	Object
    //   34	102	3	str	String
    //   170	8	3	localThrowable1	java.lang.Throwable
    //   218	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   6	28	170	java/lang/Throwable
    //   6	28	199	finally
    //   30	35	214	finally
    //   41	48	214	finally
    //   50	57	214	finally
    //   62	69	214	finally
    //   87	119	214	finally
    //   124	133	214	finally
    //   135	142	214	finally
    //   175	187	214	finally
    //   30	35	218	java/lang/Throwable
    //   41	48	218	java/lang/Throwable
    //   50	57	218	java/lang/Throwable
    //   62	69	218	java/lang/Throwable
    //   87	119	218	java/lang/Throwable
    //   124	133	218	java/lang/Throwable
    //   135	142	218	java/lang/Throwable
  }
  
  private static boolean e(ArrayList<IDKey> paramArrayList)
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
    paramArrayList = e.wTc;
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
      paramArrayList.f(18459, new Object[] { Integer.valueOf(i2), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(n) });
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
    if (d.la(21))
    {
      AppMethodBeat.o(19889);
      return;
    }
    if (fmB < 0L) {
      fmB = ai.getContext().getSharedPreferences("eabi_report", 0).getLong("last_report", -1L);
    }
    int i;
    ArrayList localArrayList;
    label160:
    boolean bool1;
    label226:
    String str;
    label289:
    label337:
    int[] arrayOfInt;
    if ((fmB < 0L) || (System.currentTimeMillis() - fmB > 86400000L))
    {
      if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) {
        break label660;
      }
      i = 1;
      ac.i("MicroMsg.PostTaskReportEABISupport", "current device support eabi: %s, %s", new Object[] { Arrays.toString(Build.SUPPORTED_32_BIT_ABIS), Arrays.toString(Build.SUPPORTED_64_BIT_ABIS) });
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(661, 3, 1));
      if (i == 0) {
        break label665;
      }
      localArrayList.add(new IDKey(661, 4, 1));
      bool1 = e(localArrayList);
      if (!bool1) {
        break label686;
      }
      localArrayList.add(new IDKey(661, 64, 1));
      if (Build.VERSION.SDK_INT - 21 < 10) {
        localArrayList.add(new IDKey(661, Build.VERSION.SDK_INT - 21 + 90, 1));
      }
      ac.i("MicroMsg.PostTaskReportEABISupport", "supportArm64_v8a : %s", new Object[] { Boolean.valueOf(bool1) });
      localArrayList.add(new IDKey(661, 50, 1));
      if (!h.gMM) {
        break label745;
      }
      localArrayList.add(new IDKey(661, 52, 1));
      boolean bool2 = "arm64-v8a".equalsIgnoreCase(Build.CPU_ABI);
      if (((!h.gMM) || (!bool2)) && ((h.gMM) || (bool2))) {
        break label767;
      }
      localArrayList.add(new IDKey(661, 53, 1));
      ac.i("MicroMsg.PostTaskReportEABISupport", "IS_ARM64: %s, isRuntime64 : %s", new Object[] { Boolean.valueOf(h.gMM), Boolean.valueOf(bool2) });
      i = UB();
      ac.i("MicroMsg.PostTaskReportEABISupport", "supportArm64FromCpuInfo : %s", new Object[] { Integer.valueOf(i) });
      if (i != -1) {
        break label789;
      }
      localArrayList.add(new IDKey(661, 63, 1));
      label412:
      if (((!bool1) || (i != 1)) && ((bool1) || (i != 0))) {
        break label869;
      }
      localArrayList.add(new IDKey(661, 66, 1));
      label448:
      str = Build.BRAND.toLowerCase();
      if ((!str.contains("xiaomi")) && (!str.contains("redmi"))) {
        break label930;
      }
      arrayOfInt = fmG;
      label482:
      localArrayList.add(new IDKey(661, arrayOfInt[0], 1));
      if (!bool1) {
        break label1098;
      }
      localArrayList.add(new IDKey(661, arrayOfInt[1], 1));
      label526:
      bool1 = h.gMM;
      str = Build.BRAND.toLowerCase();
      if ((!str.contains("xiaomi")) && (!str.contains("redmi"))) {
        break label1121;
      }
      arrayOfInt = fmQ;
      label564:
      localArrayList.add(new IDKey(661, arrayOfInt[0], 1));
      if (!bool1) {
        break label1296;
      }
      localArrayList.add(new IDKey(661, arrayOfInt[2], 1));
    }
    for (;;)
    {
      e.wTc.b(localArrayList, false);
      fmB = System.currentTimeMillis();
      ai.getContext().getSharedPreferences("eabi_report", 0).edit().putLong("last_report", fmB).commit();
      AppMethodBeat.o(19889);
      return;
      label660:
      i = 0;
      break;
      label665:
      localArrayList.add(new IDKey(661, 5, 1));
      break label160;
      label686:
      localArrayList.add(new IDKey(661, 65, 1));
      if (Build.VERSION.SDK_INT - 21 >= 10) {
        break label226;
      }
      localArrayList.add(new IDKey(661, Build.VERSION.SDK_INT - 21 + 80, 1));
      break label226;
      label745:
      localArrayList.add(new IDKey(661, 51, 1));
      break label289;
      label767:
      localArrayList.add(new IDKey(661, 54, 1));
      break label337;
      label789:
      if (i == 0)
      {
        localArrayList.add(new IDKey(661, 61, 1));
        break label412;
      }
      if (i == 1)
      {
        localArrayList.add(new IDKey(661, 60, 1));
        break label412;
      }
      if (i != 2) {
        break label412;
      }
      localArrayList.add(new IDKey(661, 62, 1));
      break label412;
      label869:
      if (((bool1) && (i == 0)) || ((!bool1) && (i == 1)))
      {
        localArrayList.add(new IDKey(661, 67, 1));
        break label448;
      }
      localArrayList.add(new IDKey(661, 68, 1));
      break label448;
      label930:
      if (str.contains("huawei"))
      {
        arrayOfInt = fmC;
        break label482;
      }
      if (str.contains("honor"))
      {
        arrayOfInt = fmD;
        break label482;
      }
      if (str.contains("vivo"))
      {
        arrayOfInt = fmE;
        break label482;
      }
      if (str.contains("oppo"))
      {
        arrayOfInt = fmF;
        break label482;
      }
      if (str.contains("samsung"))
      {
        arrayOfInt = fmH;
        break label482;
      }
      if (str.contains("meizu"))
      {
        arrayOfInt = fmI;
        break label482;
      }
      if (str.contains("gionee"))
      {
        arrayOfInt = fmJ;
        break label482;
      }
      if (str.contains("oneplus"))
      {
        arrayOfInt = fmK;
        break label482;
      }
      arrayOfInt = fmL;
      ac.i("MicroMsg.PostTaskReportEABISupport", "factoryKeys : %s", new Object[] { str });
      break label482;
      label1098:
      localArrayList.add(new IDKey(661, arrayOfInt[2], 1));
      break label526;
      label1121:
      if (str.contains("huawei"))
      {
        arrayOfInt = fmM;
        break label564;
      }
      if (str.contains("honor"))
      {
        arrayOfInt = fmN;
        break label564;
      }
      if (str.contains("vivo"))
      {
        arrayOfInt = fmO;
        break label564;
      }
      if (str.contains("oppo"))
      {
        arrayOfInt = fmP;
        break label564;
      }
      if (str.contains("samsung"))
      {
        arrayOfInt = fmR;
        break label564;
      }
      if (str.contains("meizu"))
      {
        arrayOfInt = fmS;
        break label564;
      }
      if (str.contains("gionee"))
      {
        arrayOfInt = fmT;
        break label564;
      }
      if (str.contains("oneplus"))
      {
        arrayOfInt = fmU;
        break label564;
      }
      arrayOfInt = fmV;
      ac.i("MicroMsg.PostTaskReportEABISupport", "wechatKeys : %s %s", new Object[] { str, Boolean.valueOf(bool1) });
      break label564;
      label1296:
      localArrayList.add(new IDKey(661, arrayOfInt[1], 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.j
 * JD-Core Version:    0.7.0.1
 */