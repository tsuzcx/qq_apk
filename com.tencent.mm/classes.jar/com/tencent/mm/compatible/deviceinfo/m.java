package com.tencent.mm.compatible.deviceinfo;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ab;
import java.io.BufferedReader;

public final class m
{
  static int lVx = 0;
  static String lVy = null;
  
  public static int aOK()
  {
    int m = 15;
    AppMethodBeat.i(155662);
    int i;
    int j;
    int k;
    if (n.aOR())
    {
      i = 7;
      j = i;
      if (af.lXX.lVA)
      {
        j = i;
        if (af.lXX.lVC == 0)
        {
          Log.d("MicroMsg.CpuChecker", "disable armv6 by server ");
          j = i & 0xFFFFFFFD;
        }
      }
      k = j;
      if (af.lXX.lVA)
      {
        k = j;
        if (af.lXX.lVB == 0)
        {
          Log.d("MicroMsg.CpuChecker", "disable armv7 by server ");
          k = j & 0xFFFFFFFB;
        }
      }
      i = n.getNumCores();
      if (i <= 16) {
        break label188;
      }
      j = 15;
      label98:
      i = Util.getInt(aOL(), 0) / 1000;
      if (j < 8) {
        break label199;
      }
      i *= 4;
    }
    label138:
    label188:
    label199:
    label239:
    label242:
    for (;;)
    {
      label120:
      int n = i / 100;
      if (n > 200)
      {
        i = 200;
        if ((i > 5) || (j < 4)) {
          break label239;
        }
        i = m;
      }
      for (;;)
      {
        i = (k + (j << 4) << 8) + i;
        lVx = i;
        AppMethodBeat.o(155662);
        return i;
        if (n.aOS())
        {
          i = 3;
          break;
        }
        i = 1;
        break;
        j = i;
        if (i > 0) {
          break label98;
        }
        j = 1;
        break label98;
        if (j >= 4)
        {
          i *= 2;
          break label120;
        }
        if (j <= 1) {
          break label242;
        }
        i = i * 3 >> 1;
        break label120;
        i = n;
        if (n >= 5) {
          break label138;
        }
        i = 5;
        break label138;
      }
    }
  }
  
  public static String aOL()
  {
    AppMethodBeat.i(155663);
    for (;;)
    {
      try
      {
        localBufferedReader = new BufferedReader(new ab("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
        try
        {
          Object localObject1 = localBufferedReader.readLine();
          if (localObject1 == null)
          {
            localObject1 = new NullPointerException("null was returned while reading cpuinfo_max_freq.");
            AppMethodBeat.o(155663);
            throw ((Throwable)localObject1);
          }
        }
        finally {}
      }
      finally
      {
        String str;
        BufferedReader localBufferedReader = null;
      }
      try
      {
        Log.printErrStackTrace("MicroMsg.CpuChecker", localThrowable, "unexpected exception occurred.", new Object[0]);
        return "0";
      }
      finally
      {
        Util.qualityClose(localBufferedReader);
        AppMethodBeat.o(155663);
      }
    }
    str = localThrowable.trim();
    Util.qualityClose(localBufferedReader);
    AppMethodBeat.o(155663);
    return str;
  }
  
  public static int[] aOM()
  {
    AppMethodBeat.i(240867);
    int[] arrayOfInt = new int[n.getNumCores()];
    int i = 0;
    for (;;)
    {
      String str;
      if (i < arrayOfInt.length)
      {
        arrayOfInt[i] = 0;
        str = gy("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
        if (TextUtils.isEmpty(str)) {}
      }
      try
      {
        arrayOfInt[i] = (Integer.parseInt(str) / 1000);
        label66:
        i += 1;
        continue;
        AppMethodBeat.o(240867);
        return arrayOfInt;
      }
      catch (Exception localException)
      {
        break label66;
      }
    }
  }
  
  /* Error */
  public static String aON()
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 82	java/io/BufferedReader
    //   8: dup
    //   9: new 84	com/tencent/mm/vfs/ab
    //   12: dup
    //   13: ldc 160
    //   15: invokespecial 90	com/tencent/mm/vfs/ab:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 93	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokevirtual 96	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnonnull +53 -> 83
    //   33: aload_1
    //   34: astore_0
    //   35: new 98	java/lang/NullPointerException
    //   38: dup
    //   39: ldc 162
    //   41: invokespecial 101	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: aload_1
    //   46: astore_0
    //   47: ldc 158
    //   49: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: athrow
    //   56: astore_2
    //   57: aload_1
    //   58: astore_0
    //   59: ldc 47
    //   61: aload_2
    //   62: ldc 103
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_1
    //   72: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   75: ldc 158
    //   77: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: ldc 113
    //   82: areturn
    //   83: aload_1
    //   84: astore_0
    //   85: aload_2
    //   86: invokevirtual 118	java/lang/String:trim	()Ljava/lang/String;
    //   89: astore_2
    //   90: aload_1
    //   91: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   94: ldc 158
    //   96: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_2
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   108: ldc 158
    //   110: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: goto -12 -> 104
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -65 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	82	0	localBufferedReader1	BufferedReader
    //   21	70	1	localBufferedReader2	BufferedReader
    //   101	13	1	localObject1	Object
    //   115	1	1	localObject2	Object
    //   121	1	1	localObject3	Object
    //   28	27	2	localObject4	Object
    //   56	30	2	localException1	Exception
    //   89	11	2	str	String
    //   119	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	29	56	java/lang/Exception
    //   35	45	56	java/lang/Exception
    //   47	52	56	java/lang/Exception
    //   54	56	56	java/lang/Exception
    //   85	90	56	java/lang/Exception
    //   5	22	101	finally
    //   24	29	115	finally
    //   35	45	115	finally
    //   47	52	115	finally
    //   54	56	115	finally
    //   59	71	115	finally
    //   85	90	115	finally
    //   5	22	119	java/lang/Exception
  }
  
  /* Error */
  private static String gy(String paramString)
  {
    // Byte code:
    //   0: ldc 163
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 163
    //   14: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: new 165	java/io/RandomAccessFile
    //   22: dup
    //   23: aload_0
    //   24: ldc 167
    //   26: invokespecial 169	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 170	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   34: astore_1
    //   35: aload_0
    //   36: invokevirtual 173	java/io/RandomAccessFile:close	()V
    //   39: ldc 163
    //   41: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_1
    //   45: areturn
    //   46: astore_0
    //   47: ldc 47
    //   49: ldc 175
    //   51: aload_0
    //   52: invokestatic 179	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   55: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: goto -22 -> 39
    //   64: astore_0
    //   65: aconst_null
    //   66: astore_0
    //   67: ldc 47
    //   69: ldc 186
    //   71: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: ifnull +7 -> 82
    //   78: aload_0
    //   79: invokevirtual 173	java/io/RandomAccessFile:close	()V
    //   82: ldc 163
    //   84: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_0
    //   90: ldc 47
    //   92: ldc 175
    //   94: aload_0
    //   95: invokestatic 179	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   98: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: goto -22 -> 82
    //   107: astore_1
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 173	java/io/RandomAccessFile:close	()V
    //   116: ldc 163
    //   118: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_1
    //   122: athrow
    //   123: astore_0
    //   124: ldc 47
    //   126: ldc 175
    //   128: aload_0
    //   129: invokestatic 179	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   132: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   135: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: goto -22 -> 116
    //   141: astore_1
    //   142: goto -75 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString	String
    //   34	11	1	str	String
    //   107	15	1	localObject1	Object
    //   141	1	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	39	46	java/lang/Exception
    //   19	30	64	finally
    //   78	82	89	java/lang/Exception
    //   67	74	107	finally
    //   112	116	123	java/lang/Exception
    //   30	35	141	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.m
 * JD-Core Version:    0.7.0.1
 */