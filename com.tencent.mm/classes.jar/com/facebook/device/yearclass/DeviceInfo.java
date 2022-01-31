package com.facebook.device.yearclass;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class DeviceInfo
{
  private static final FileFilter CPU_FILTER;
  public static final int DEVICEINFO_UNKNOWN = -1;
  
  static
  {
    AppMethodBeat.i(114634);
    CPU_FILTER = new FileFilter()
    {
      public final boolean accept(File paramAnonymousFile)
      {
        AppMethodBeat.i(114625);
        paramAnonymousFile = paramAnonymousFile.getName();
        if (paramAnonymousFile.startsWith("cpu"))
        {
          int i = 3;
          while (i < paramAnonymousFile.length())
          {
            if (!Character.isDigit(paramAnonymousFile.charAt(i)))
            {
              AppMethodBeat.o(114625);
              return false;
            }
            i += 1;
          }
          AppMethodBeat.o(114625);
          return true;
        }
        AppMethodBeat.o(114625);
        return false;
      }
    };
    AppMethodBeat.o(114634);
  }
  
  private static int extractValue(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(114633);
    while ((paramInt < paramArrayOfByte.length) && (paramArrayOfByte[paramInt] != 10))
    {
      if (Character.isDigit(paramArrayOfByte[paramInt]))
      {
        int i = paramInt + 1;
        while ((i < paramArrayOfByte.length) && (Character.isDigit(paramArrayOfByte[i]))) {
          i += 1;
        }
        paramInt = bo.apV(new String(paramArrayOfByte, 0, paramInt, i - paramInt));
        AppMethodBeat.o(114633);
        return paramInt;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(114633);
    return -1;
  }
  
  /* Error */
  public static int getCPUMaxFreqKHz()
  {
    // Byte code:
    //   0: ldc 57
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_0
    //   6: istore_2
    //   7: iconst_m1
    //   8: istore_0
    //   9: iload_2
    //   10: invokestatic 60	com/facebook/device/yearclass/DeviceInfo:getNumberOfCPUCores	()I
    //   13: if_icmpge +177 -> 190
    //   16: new 62	java/io/File
    //   19: dup
    //   20: new 64	java/lang/StringBuilder
    //   23: dup
    //   24: ldc 66
    //   26: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: iload_2
    //   30: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc 75
    //   35: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_3
    //   45: iload_0
    //   46: istore_1
    //   47: aload_3
    //   48: invokevirtual 87	java/io/File:exists	()Z
    //   51: ifeq +199 -> 250
    //   54: iload_0
    //   55: istore_1
    //   56: aload_3
    //   57: invokevirtual 90	java/io/File:canRead	()Z
    //   60: ifeq +190 -> 250
    //   63: sipush 128
    //   66: newarray byte
    //   68: astore 4
    //   70: new 92	java/io/FileInputStream
    //   73: dup
    //   74: aload_3
    //   75: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: astore_3
    //   79: aload_3
    //   80: aload 4
    //   82: invokevirtual 99	java/io/FileInputStream:read	([B)I
    //   85: pop
    //   86: iconst_0
    //   87: istore_1
    //   88: aload 4
    //   90: iload_1
    //   91: baload
    //   92: invokestatic 39	java/lang/Character:isDigit	(I)Z
    //   95: ifeq +17 -> 112
    //   98: iload_1
    //   99: sipush 128
    //   102: if_icmpge +10 -> 112
    //   105: iload_1
    //   106: iconst_1
    //   107: iadd
    //   108: istore_1
    //   109: goto -21 -> 88
    //   112: new 41	java/lang/String
    //   115: dup
    //   116: aload 4
    //   118: iconst_0
    //   119: iload_1
    //   120: invokespecial 102	java/lang/String:<init>	([BII)V
    //   123: invokestatic 50	com/tencent/mm/sdk/platformtools/bo:apV	(Ljava/lang/String;)I
    //   126: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: astore 4
    //   131: iload_0
    //   132: istore_1
    //   133: aload 4
    //   135: invokevirtual 111	java/lang/Integer:intValue	()I
    //   138: iload_0
    //   139: if_icmple +9 -> 148
    //   142: aload 4
    //   144: invokevirtual 111	java/lang/Integer:intValue	()I
    //   147: istore_1
    //   148: aload_3
    //   149: invokevirtual 114	java/io/FileInputStream:close	()V
    //   152: goto +98 -> 250
    //   155: astore 4
    //   157: aload_3
    //   158: invokevirtual 114	java/io/FileInputStream:close	()V
    //   161: iload_0
    //   162: istore_1
    //   163: goto +87 -> 250
    //   166: astore_3
    //   167: iconst_m1
    //   168: istore_1
    //   169: ldc 57
    //   171: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: iload_1
    //   175: ireturn
    //   176: astore 4
    //   178: aload_3
    //   179: invokevirtual 114	java/io/FileInputStream:close	()V
    //   182: ldc 57
    //   184: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload 4
    //   189: athrow
    //   190: iload_0
    //   191: istore_1
    //   192: iload_0
    //   193: iconst_m1
    //   194: if_icmpne -25 -> 169
    //   197: new 92	java/io/FileInputStream
    //   200: dup
    //   201: ldc 116
    //   203: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   206: astore_3
    //   207: ldc 119
    //   209: aload_3
    //   210: invokestatic 123	com/facebook/device/yearclass/DeviceInfo:parseFileForValue	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   213: istore_1
    //   214: iload_1
    //   215: sipush 1000
    //   218: imul
    //   219: istore_2
    //   220: iload_0
    //   221: istore_1
    //   222: iload_2
    //   223: iload_0
    //   224: if_icmple +5 -> 229
    //   227: iload_2
    //   228: istore_1
    //   229: aload_3
    //   230: invokevirtual 114	java/io/FileInputStream:close	()V
    //   233: goto -64 -> 169
    //   236: astore 4
    //   238: aload_3
    //   239: invokevirtual 114	java/io/FileInputStream:close	()V
    //   242: ldc 57
    //   244: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aload 4
    //   249: athrow
    //   250: iload_2
    //   251: iconst_1
    //   252: iadd
    //   253: istore_2
    //   254: iload_1
    //   255: istore_0
    //   256: goto -247 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   8	248	0	i	int
    //   46	209	1	j	int
    //   6	248	2	k	int
    //   44	114	3	localObject1	Object
    //   166	13	3	localIOException	IOException
    //   206	33	3	localFileInputStream	FileInputStream
    //   68	75	4	localObject2	Object
    //   155	1	4	localNumberFormatException	NumberFormatException
    //   176	12	4	localObject3	Object
    //   236	12	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   79	86	155	java/lang/NumberFormatException
    //   88	98	155	java/lang/NumberFormatException
    //   112	131	155	java/lang/NumberFormatException
    //   133	148	155	java/lang/NumberFormatException
    //   9	45	166	java/io/IOException
    //   47	54	166	java/io/IOException
    //   56	79	166	java/io/IOException
    //   148	152	166	java/io/IOException
    //   157	161	166	java/io/IOException
    //   178	190	166	java/io/IOException
    //   197	207	166	java/io/IOException
    //   229	233	166	java/io/IOException
    //   238	250	166	java/io/IOException
    //   79	86	176	finally
    //   88	98	176	finally
    //   112	131	176	finally
    //   133	148	176	finally
    //   207	214	236	finally
  }
  
  private static int getCoresFromCPUFileList()
  {
    AppMethodBeat.i(114629);
    int i = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
    AppMethodBeat.o(114629);
    return i;
  }
  
  /* Error */
  private static int getCoresFromFileInfo(String paramString)
  {
    // Byte code:
    //   0: ldc 133
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: new 92	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   15: astore_0
    //   16: new 135	java/io/BufferedReader
    //   19: dup
    //   20: new 137	java/io/InputStreamReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 140	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   28: invokespecial 143	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_2
    //   32: aload_2
    //   33: invokevirtual 146	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore_3
    //   37: aload_2
    //   38: invokevirtual 147	java/io/BufferedReader:close	()V
    //   41: aload_3
    //   42: invokestatic 150	com/facebook/device/yearclass/DeviceInfo:getCoresFromFileString	(Ljava/lang/String;)I
    //   45: istore_1
    //   46: aload_0
    //   47: invokevirtual 153	java/io/InputStream:close	()V
    //   50: ldc 133
    //   52: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iload_1
    //   56: ireturn
    //   57: astore_0
    //   58: aload_2
    //   59: astore_0
    //   60: aload_0
    //   61: ifnull +7 -> 68
    //   64: aload_0
    //   65: invokevirtual 153	java/io/InputStream:close	()V
    //   68: ldc 133
    //   70: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iconst_m1
    //   74: ireturn
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 153	java/io/InputStream:close	()V
    //   86: ldc 133
    //   88: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: athrow
    //   93: astore_0
    //   94: goto -44 -> 50
    //   97: astore_0
    //   98: goto -30 -> 68
    //   101: astore_2
    //   102: goto -16 -> 86
    //   105: astore_2
    //   106: aload_0
    //   107: astore_3
    //   108: aload_2
    //   109: astore_0
    //   110: aload_3
    //   111: astore_2
    //   112: goto -34 -> 78
    //   115: astore_2
    //   116: goto -56 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramString	String
    //   45	11	1	i	int
    //   6	77	2	localBufferedReader	java.io.BufferedReader
    //   101	1	2	localIOException1	IOException
    //   105	4	2	localObject1	Object
    //   111	1	2	localObject2	Object
    //   115	1	2	localIOException2	IOException
    //   36	75	3	str	String
    // Exception table:
    //   from	to	target	type
    //   7	16	57	java/io/IOException
    //   7	16	75	finally
    //   46	50	93	java/io/IOException
    //   64	68	97	java/io/IOException
    //   82	86	101	java/io/IOException
    //   16	46	105	finally
    //   16	46	115	java/io/IOException
  }
  
  static int getCoresFromFileString(String paramString)
  {
    AppMethodBeat.i(114628);
    if ((paramString == null) || (!paramString.matches("0-[\\d]+$")))
    {
      AppMethodBeat.o(114628);
      return -1;
    }
    int i = Integer.valueOf(paramString.substring(2)).intValue();
    AppMethodBeat.o(114628);
    return i + 1;
  }
  
  public static int getNumberOfCPUCores()
  {
    AppMethodBeat.i(114626);
    if (Build.VERSION.SDK_INT <= 10)
    {
      AppMethodBeat.o(114626);
      return 1;
    }
    try
    {
      i = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
      int j = i;
      if (i == -1) {
        j = getCoresFromFileInfo("/sys/devices/system/cpu/present");
      }
      i = j;
      if (j == -1) {
        i = getCoresFromCPUFileList();
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    AppMethodBeat.o(114626);
    return i;
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  public static long getTotalMemory(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 177	android/os/Build$VERSION:SDK_INT	I
    //   8: bipush 16
    //   10: if_icmplt +39 -> 49
    //   13: new 193	android/app/ActivityManager$MemoryInfo
    //   16: dup
    //   17: invokespecial 194	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   20: astore 4
    //   22: aload_0
    //   23: ldc 196
    //   25: invokevirtual 202	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   28: checkcast 204	android/app/ActivityManager
    //   31: aload 4
    //   33: invokevirtual 208	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   36: aload 4
    //   38: getfield 212	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   41: lstore_2
    //   42: ldc 191
    //   44: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: lload_2
    //   48: lreturn
    //   49: new 92	java/io/FileInputStream
    //   52: dup
    //   53: ldc 214
    //   55: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   58: astore_0
    //   59: ldc 216
    //   61: aload_0
    //   62: invokestatic 123	com/facebook/device/yearclass/DeviceInfo:parseFileForValue	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   65: istore_1
    //   66: iload_1
    //   67: i2l
    //   68: ldc2_w 217
    //   71: lmul
    //   72: lstore_2
    //   73: aload_0
    //   74: invokevirtual 114	java/io/FileInputStream:close	()V
    //   77: ldc 191
    //   79: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: lload_2
    //   83: lreturn
    //   84: astore 4
    //   86: aload_0
    //   87: invokevirtual 114	java/io/FileInputStream:close	()V
    //   90: ldc 191
    //   92: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload 4
    //   97: athrow
    //   98: astore_0
    //   99: ldc2_w 219
    //   102: lstore_2
    //   103: goto -26 -> 77
    //   106: astore_0
    //   107: goto -30 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramContext	android.content.Context
    //   65	2	1	i	int
    //   41	62	2	l	long
    //   20	17	4	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   84	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   59	66	84	finally
    //   49	59	98	java/io/IOException
    //   86	98	98	java/io/IOException
    //   73	77	106	java/io/IOException
  }
  
  private static int parseFileForValue(String paramString, FileInputStream paramFileInputStream)
  {
    AppMethodBeat.i(114632);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int m;
      int i;
      try
      {
        m = paramFileInputStream.read(arrayOfByte);
        j = 0;
      }
      catch (NumberFormatException paramString)
      {
        int n;
        AppMethodBeat.o(114632);
        return -1;
      }
      catch (IOException paramString)
      {
        continue;
      }
      int k = i;
      if (j < m)
      {
        n = j - i;
        k = i;
        if (arrayOfByte[j] == paramString.charAt(n))
        {
          if (n == paramString.length() - 1)
          {
            i = extractValue(arrayOfByte, j);
            AppMethodBeat.o(114632);
            return i;
          }
          j += 1;
          continue;
        }
      }
      int j = k + 1;
      if (j < m) {
        if (arrayOfByte[j] != 10)
        {
          k = j;
          if (j != 0) {}
        }
        else
        {
          i = j;
          if (arrayOfByte[j] == 10) {
            i = j + 1;
          }
          j = i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.device.yearclass.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */