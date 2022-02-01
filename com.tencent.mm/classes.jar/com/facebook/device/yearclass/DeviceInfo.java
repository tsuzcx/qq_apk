package com.facebook.device.yearclass;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;

public class DeviceInfo
{
  private static final FileFilter CPU_FILTER;
  public static final int DEVICEINFO_UNKNOWN = -1;
  
  static
  {
    AppMethodBeat.i(133647);
    CPU_FILTER = new FileFilter()
    {
      public final boolean accept(File paramAnonymousFile)
      {
        AppMethodBeat.i(133638);
        paramAnonymousFile = paramAnonymousFile.getName();
        if (paramAnonymousFile.startsWith("cpu"))
        {
          int i = 3;
          while (i < paramAnonymousFile.length())
          {
            if (!Character.isDigit(paramAnonymousFile.charAt(i)))
            {
              AppMethodBeat.o(133638);
              return false;
            }
            i += 1;
          }
          AppMethodBeat.o(133638);
          return true;
        }
        AppMethodBeat.o(133638);
        return false;
      }
    };
    AppMethodBeat.o(133647);
  }
  
  private static int extractValue(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(133646);
    while ((paramInt < paramArrayOfByte.length) && (paramArrayOfByte[paramInt] != 10))
    {
      if (Character.isDigit(paramArrayOfByte[paramInt]))
      {
        int i = paramInt + 1;
        while ((i < paramArrayOfByte.length) && (Character.isDigit(paramArrayOfByte[i]))) {
          i += 1;
        }
        paramInt = bu.aSB(new String(paramArrayOfByte, 0, paramInt, i - paramInt));
        AppMethodBeat.o(133646);
        return paramInt;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(133646);
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
    //   13: if_icmpge +176 -> 189
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
    //   51: ifeq +194 -> 245
    //   54: iload_0
    //   55: istore_1
    //   56: aload_3
    //   57: invokevirtual 90	java/io/File:canRead	()Z
    //   60: ifeq +185 -> 245
    //   63: sipush 128
    //   66: newarray byte
    //   68: astore 4
    //   70: aload_3
    //   71: invokevirtual 93	java/io/File:getPath	()Ljava/lang/String;
    //   74: invokestatic 99	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   77: astore_3
    //   78: aload_3
    //   79: aload 4
    //   81: invokevirtual 105	java/io/InputStream:read	([B)I
    //   84: pop
    //   85: iconst_0
    //   86: istore_1
    //   87: aload 4
    //   89: iload_1
    //   90: baload
    //   91: invokestatic 39	java/lang/Character:isDigit	(I)Z
    //   94: ifeq +17 -> 111
    //   97: iload_1
    //   98: sipush 128
    //   101: if_icmpge +10 -> 111
    //   104: iload_1
    //   105: iconst_1
    //   106: iadd
    //   107: istore_1
    //   108: goto -21 -> 87
    //   111: new 41	java/lang/String
    //   114: dup
    //   115: aload 4
    //   117: iconst_0
    //   118: iload_1
    //   119: invokespecial 108	java/lang/String:<init>	([BII)V
    //   122: invokestatic 50	com/tencent/mm/sdk/platformtools/bu:aSB	(Ljava/lang/String;)I
    //   125: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: astore 4
    //   130: iload_0
    //   131: istore_1
    //   132: aload 4
    //   134: invokevirtual 117	java/lang/Integer:intValue	()I
    //   137: iload_0
    //   138: if_icmple +9 -> 147
    //   141: aload 4
    //   143: invokevirtual 117	java/lang/Integer:intValue	()I
    //   146: istore_1
    //   147: aload_3
    //   148: invokevirtual 120	java/io/InputStream:close	()V
    //   151: goto +94 -> 245
    //   154: astore 4
    //   156: aload_3
    //   157: invokevirtual 120	java/io/InputStream:close	()V
    //   160: iload_0
    //   161: istore_1
    //   162: goto +83 -> 245
    //   165: astore_3
    //   166: iconst_m1
    //   167: istore_1
    //   168: ldc 57
    //   170: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: iload_1
    //   174: ireturn
    //   175: astore 4
    //   177: aload_3
    //   178: invokevirtual 120	java/io/InputStream:close	()V
    //   181: ldc 57
    //   183: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload 4
    //   188: athrow
    //   189: iload_0
    //   190: istore_1
    //   191: iload_0
    //   192: iconst_m1
    //   193: if_icmpne -25 -> 168
    //   196: ldc 122
    //   198: invokestatic 99	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   201: astore_3
    //   202: ldc 124
    //   204: aload_3
    //   205: invokestatic 128	com/facebook/device/yearclass/DeviceInfo:parseFileForValue	(Ljava/lang/String;Ljava/io/InputStream;)I
    //   208: istore_1
    //   209: iload_1
    //   210: sipush 1000
    //   213: imul
    //   214: istore_2
    //   215: iload_0
    //   216: istore_1
    //   217: iload_2
    //   218: iload_0
    //   219: if_icmple +5 -> 224
    //   222: iload_2
    //   223: istore_1
    //   224: aload_3
    //   225: invokevirtual 120	java/io/InputStream:close	()V
    //   228: goto -60 -> 168
    //   231: astore 4
    //   233: aload_3
    //   234: invokevirtual 120	java/io/InputStream:close	()V
    //   237: ldc 57
    //   239: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload 4
    //   244: athrow
    //   245: iload_2
    //   246: iconst_1
    //   247: iadd
    //   248: istore_2
    //   249: iload_1
    //   250: istore_0
    //   251: goto -242 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   8	243	0	i	int
    //   46	204	1	j	int
    //   6	243	2	k	int
    //   44	113	3	localObject1	Object
    //   165	13	3	localIOException	IOException
    //   201	33	3	localInputStream	InputStream
    //   68	74	4	localObject2	Object
    //   154	1	4	localNumberFormatException	NumberFormatException
    //   175	12	4	localObject3	Object
    //   231	12	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   78	85	154	java/lang/NumberFormatException
    //   87	97	154	java/lang/NumberFormatException
    //   111	130	154	java/lang/NumberFormatException
    //   132	147	154	java/lang/NumberFormatException
    //   9	45	165	java/io/IOException
    //   47	54	165	java/io/IOException
    //   56	78	165	java/io/IOException
    //   147	151	165	java/io/IOException
    //   156	160	165	java/io/IOException
    //   177	189	165	java/io/IOException
    //   196	202	165	java/io/IOException
    //   224	228	165	java/io/IOException
    //   233	245	165	java/io/IOException
    //   78	85	175	finally
    //   87	97	175	finally
    //   111	130	175	finally
    //   132	147	175	finally
    //   202	209	231	finally
  }
  
  private static int getCoresFromCPUFileList()
  {
    AppMethodBeat.i(133642);
    int i = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
    AppMethodBeat.o(133642);
    return i;
  }
  
  /* Error */
  private static int getCoresFromFileInfo(String paramString)
  {
    // Byte code:
    //   0: ldc 138
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: invokestatic 99	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_0
    //   12: new 140	java/io/BufferedReader
    //   15: dup
    //   16: new 142	java/io/InputStreamReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 145	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: invokespecial 148	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 151	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload_2
    //   34: invokevirtual 152	java/io/BufferedReader:close	()V
    //   37: aload_3
    //   38: invokestatic 155	com/facebook/device/yearclass/DeviceInfo:getCoresFromFileString	(Ljava/lang/String;)I
    //   41: istore_1
    //   42: aload_0
    //   43: ifnull +7 -> 50
    //   46: aload_0
    //   47: invokevirtual 120	java/io/InputStream:close	()V
    //   50: ldc 138
    //   52: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iload_1
    //   56: ireturn
    //   57: astore_0
    //   58: aload_2
    //   59: astore_0
    //   60: aload_0
    //   61: ifnull +7 -> 68
    //   64: aload_0
    //   65: invokevirtual 120	java/io/InputStream:close	()V
    //   68: ldc 138
    //   70: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iconst_m1
    //   74: ireturn
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 120	java/io/InputStream:close	()V
    //   86: ldc 138
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
    //   41	15	1	i	int
    //   6	77	2	localBufferedReader	java.io.BufferedReader
    //   101	1	2	localIOException1	IOException
    //   105	4	2	localObject1	Object
    //   111	1	2	localObject2	Object
    //   115	1	2	localIOException2	IOException
    //   32	79	3	str	String
    // Exception table:
    //   from	to	target	type
    //   7	12	57	java/io/IOException
    //   7	12	75	finally
    //   46	50	93	java/io/IOException
    //   64	68	97	java/io/IOException
    //   82	86	101	java/io/IOException
    //   12	42	105	finally
    //   12	42	115	java/io/IOException
  }
  
  static int getCoresFromFileString(String paramString)
  {
    AppMethodBeat.i(133641);
    if ((paramString == null) || (!paramString.matches("0-[\\d]+$")))
    {
      AppMethodBeat.o(133641);
      return -1;
    }
    int i = bu.getInt(paramString.substring(2), 0);
    AppMethodBeat.o(133641);
    return i + 1;
  }
  
  public static int getNumberOfCPUCores()
  {
    AppMethodBeat.i(133639);
    if (Build.VERSION.SDK_INT <= 10)
    {
      AppMethodBeat.o(133639);
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
    AppMethodBeat.o(133639);
    return i;
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  public static long getTotalMemory(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 194
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 180	android/os/Build$VERSION:SDK_INT	I
    //   8: bipush 16
    //   10: if_icmplt +39 -> 49
    //   13: new 196	android/app/ActivityManager$MemoryInfo
    //   16: dup
    //   17: invokespecial 197	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   20: astore 4
    //   22: aload_0
    //   23: ldc 199
    //   25: invokevirtual 205	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   28: checkcast 207	android/app/ActivityManager
    //   31: aload 4
    //   33: invokevirtual 211	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   36: aload 4
    //   38: getfield 215	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   41: lstore_2
    //   42: ldc 194
    //   44: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: lload_2
    //   48: lreturn
    //   49: ldc 217
    //   51: invokestatic 99	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore_0
    //   55: ldc 219
    //   57: aload_0
    //   58: invokestatic 128	com/facebook/device/yearclass/DeviceInfo:parseFileForValue	(Ljava/lang/String;Ljava/io/InputStream;)I
    //   61: istore_1
    //   62: iload_1
    //   63: i2l
    //   64: ldc2_w 220
    //   67: lmul
    //   68: lstore_2
    //   69: aload_0
    //   70: invokevirtual 120	java/io/InputStream:close	()V
    //   73: ldc 194
    //   75: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: lload_2
    //   79: lreturn
    //   80: astore 4
    //   82: aload_0
    //   83: invokevirtual 120	java/io/InputStream:close	()V
    //   86: ldc 194
    //   88: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload 4
    //   93: athrow
    //   94: astore_0
    //   95: ldc2_w 222
    //   98: lstore_2
    //   99: goto -26 -> 73
    //   102: astore_0
    //   103: goto -30 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramContext	android.content.Context
    //   61	2	1	i	int
    //   41	58	2	l	long
    //   20	17	4	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   80	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	62	80	finally
    //   49	55	94	java/io/IOException
    //   82	94	94	java/io/IOException
    //   69	73	102	java/io/IOException
  }
  
  private static int parseFileForValue(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(177010);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int m;
      int i;
      try
      {
        m = paramInputStream.read(arrayOfByte);
        j = 0;
      }
      catch (NumberFormatException paramString)
      {
        int n;
        AppMethodBeat.o(177010);
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
            AppMethodBeat.o(177010);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.device.yearclass.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */