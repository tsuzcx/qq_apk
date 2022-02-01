package com.c.a;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  private static final FileFilter CPU_FILTER;
  
  static
  {
    AppMethodBeat.i(206976);
    CPU_FILTER = new FileFilter()
    {
      public final boolean accept(File paramAnonymousFile)
      {
        AppMethodBeat.i(206929);
        paramAnonymousFile = paramAnonymousFile.getName();
        if (paramAnonymousFile.startsWith("cpu"))
        {
          int i = 3;
          while (i < paramAnonymousFile.length())
          {
            if (!Character.isDigit(paramAnonymousFile.charAt(i)))
            {
              AppMethodBeat.o(206929);
              return false;
            }
            i += 1;
          }
          AppMethodBeat.o(206929);
          return true;
        }
        AppMethodBeat.o(206929);
        return false;
      }
    };
    AppMethodBeat.o(206976);
  }
  
  /* Error */
  public static int Pb()
  {
    // Byte code:
    //   0: ldc 33
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_0
    //   6: istore_2
    //   7: iconst_m1
    //   8: istore_0
    //   9: iload_2
    //   10: invokestatic 36	com/c/a/a:getNumberOfCPUCores	()I
    //   13: if_icmpge +176 -> 189
    //   16: new 38	java/io/File
    //   19: dup
    //   20: new 40	java/lang/StringBuilder
    //   23: dup
    //   24: ldc 42
    //   26: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: iload_2
    //   30: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc 51
    //   35: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_3
    //   45: iload_0
    //   46: istore_1
    //   47: aload_3
    //   48: invokevirtual 63	java/io/File:exists	()Z
    //   51: ifeq +194 -> 245
    //   54: iload_0
    //   55: istore_1
    //   56: aload_3
    //   57: invokevirtual 66	java/io/File:canRead	()Z
    //   60: ifeq +185 -> 245
    //   63: sipush 128
    //   66: newarray byte
    //   68: astore 4
    //   70: aload_3
    //   71: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   74: invokestatic 75	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   77: astore_3
    //   78: aload_3
    //   79: aload 4
    //   81: invokevirtual 81	java/io/InputStream:read	([B)I
    //   84: pop
    //   85: iconst_0
    //   86: istore_1
    //   87: aload 4
    //   89: iload_1
    //   90: baload
    //   91: invokestatic 87	java/lang/Character:isDigit	(I)Z
    //   94: ifeq +17 -> 111
    //   97: iload_1
    //   98: sipush 128
    //   101: if_icmpge +10 -> 111
    //   104: iload_1
    //   105: iconst_1
    //   106: iadd
    //   107: istore_1
    //   108: goto -21 -> 87
    //   111: new 89	java/lang/String
    //   114: dup
    //   115: aload 4
    //   117: iconst_0
    //   118: iload_1
    //   119: invokespecial 92	java/lang/String:<init>	([BII)V
    //   122: invokestatic 98	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   125: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: astore 4
    //   130: iload_0
    //   131: istore_1
    //   132: aload 4
    //   134: invokevirtual 107	java/lang/Integer:intValue	()I
    //   137: iload_0
    //   138: if_icmple +9 -> 147
    //   141: aload 4
    //   143: invokevirtual 107	java/lang/Integer:intValue	()I
    //   146: istore_1
    //   147: aload_3
    //   148: invokevirtual 110	java/io/InputStream:close	()V
    //   151: goto +94 -> 245
    //   154: astore 4
    //   156: aload_3
    //   157: invokevirtual 110	java/io/InputStream:close	()V
    //   160: iload_0
    //   161: istore_1
    //   162: goto +83 -> 245
    //   165: astore_3
    //   166: iconst_m1
    //   167: istore_1
    //   168: ldc 33
    //   170: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: iload_1
    //   174: ireturn
    //   175: astore 4
    //   177: aload_3
    //   178: invokevirtual 110	java/io/InputStream:close	()V
    //   181: ldc 33
    //   183: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload 4
    //   188: athrow
    //   189: iload_0
    //   190: istore_1
    //   191: iload_0
    //   192: iconst_m1
    //   193: if_icmpne -25 -> 168
    //   196: ldc 112
    //   198: invokestatic 75	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   201: astore_3
    //   202: ldc 114
    //   204: aload_3
    //   205: invokestatic 118	com/c/a/a:b	(Ljava/lang/String;Ljava/io/InputStream;)I
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
    //   225: invokevirtual 110	java/io/InputStream:close	()V
    //   228: goto -60 -> 168
    //   231: astore 4
    //   233: aload_3
    //   234: invokevirtual 110	java/io/InputStream:close	()V
    //   237: ldc 33
    //   239: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  /* Error */
  public static long aG(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 121
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 127	android/os/Build$VERSION:SDK_INT	I
    //   8: bipush 16
    //   10: if_icmplt +39 -> 49
    //   13: new 129	android/app/ActivityManager$MemoryInfo
    //   16: dup
    //   17: invokespecial 130	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   20: astore 4
    //   22: aload_0
    //   23: ldc 132
    //   25: invokevirtual 138	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   28: checkcast 140	android/app/ActivityManager
    //   31: aload 4
    //   33: invokevirtual 144	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   36: aload 4
    //   38: getfield 148	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   41: lstore_2
    //   42: ldc 121
    //   44: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: lload_2
    //   48: lreturn
    //   49: ldc 150
    //   51: invokestatic 75	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore_0
    //   55: ldc 152
    //   57: aload_0
    //   58: invokestatic 118	com/c/a/a:b	(Ljava/lang/String;Ljava/io/InputStream;)I
    //   61: istore_1
    //   62: iload_1
    //   63: i2l
    //   64: ldc2_w 153
    //   67: lmul
    //   68: lstore_2
    //   69: aload_0
    //   70: invokevirtual 110	java/io/InputStream:close	()V
    //   73: ldc 121
    //   75: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: lload_2
    //   79: lreturn
    //   80: astore 4
    //   82: aload_0
    //   83: invokevirtual 110	java/io/InputStream:close	()V
    //   86: ldc 121
    //   88: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload 4
    //   93: athrow
    //   94: astore_0
    //   95: ldc2_w 155
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
  
  private static int b(String paramString, InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(206972);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int m;
      int i;
      try
      {
        m = paramInputStream.read(arrayOfByte);
      }
      catch (NumberFormatException paramString)
      {
        int n;
        AppMethodBeat.o(206972);
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
            if ((j < 1024) && (arrayOfByte[j] != 10))
            {
              if (Character.isDigit(arrayOfByte[j]))
              {
                i = j + 1;
                if ((i < 1024) && (Character.isDigit(arrayOfByte[i])))
                {
                  i += 1;
                  continue;
                }
                i = Util.safeParseInt(new String(arrayOfByte, 0, j, i - j));
                AppMethodBeat.o(206972);
                return i;
              }
              j += 1;
              continue;
            }
            AppMethodBeat.o(206972);
            return -1;
          }
          j += 1;
          continue;
        }
      }
      j = k + 1;
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
  
  /* Error */
  private static int cm(String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: ldc 169
    //   4: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: aload_0
    //   14: invokestatic 75	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_0
    //   18: aload_0
    //   19: astore 4
    //   21: aload_0
    //   22: astore 5
    //   24: new 171	java/io/BufferedReader
    //   27: dup
    //   28: new 173	java/io/InputStreamReader
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 176	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   36: invokespecial 179	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore 6
    //   41: aload_0
    //   42: astore 4
    //   44: aload_0
    //   45: astore 5
    //   47: aload 6
    //   49: invokevirtual 182	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 7
    //   54: aload_0
    //   55: astore 4
    //   57: aload_0
    //   58: astore 5
    //   60: aload 6
    //   62: invokevirtual 183	java/io/BufferedReader:close	()V
    //   65: iload_2
    //   66: istore_1
    //   67: aload 7
    //   69: ifnull +23 -> 92
    //   72: aload_0
    //   73: astore 4
    //   75: aload_0
    //   76: astore 5
    //   78: aload 7
    //   80: ldc 185
    //   82: invokevirtual 189	java/lang/String:matches	(Ljava/lang/String;)Z
    //   85: istore_3
    //   86: iload_3
    //   87: ifne +20 -> 107
    //   90: iload_2
    //   91: istore_1
    //   92: aload_0
    //   93: ifnull +7 -> 100
    //   96: aload_0
    //   97: invokevirtual 110	java/io/InputStream:close	()V
    //   100: ldc 169
    //   102: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: iload_1
    //   106: ireturn
    //   107: aload_0
    //   108: astore 4
    //   110: aload_0
    //   111: astore 5
    //   113: aload 7
    //   115: iconst_2
    //   116: invokevirtual 193	java/lang/String:substring	(I)Ljava/lang/String;
    //   119: iconst_0
    //   120: invokestatic 197	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   123: istore_1
    //   124: iload_1
    //   125: iconst_1
    //   126: iadd
    //   127: istore_1
    //   128: goto -36 -> 92
    //   131: astore_0
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 110	java/io/InputStream:close	()V
    //   142: ldc 169
    //   144: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_m1
    //   148: ireturn
    //   149: astore_0
    //   150: aload 5
    //   152: ifnull +8 -> 160
    //   155: aload 5
    //   157: invokevirtual 110	java/io/InputStream:close	()V
    //   160: ldc 169
    //   162: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload_0
    //   166: athrow
    //   167: astore_0
    //   168: goto -68 -> 100
    //   171: astore_0
    //   172: goto -30 -> 142
    //   175: astore 4
    //   177: goto -17 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramString	String
    //   66	62	1	i	int
    //   1	90	2	j	int
    //   85	2	3	bool	boolean
    //   11	127	4	str1	String
    //   175	1	4	localIOException	IOException
    //   8	148	5	str2	String
    //   39	22	6	localBufferedReader	java.io.BufferedReader
    //   52	62	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   13	18	131	java/io/IOException
    //   24	41	131	java/io/IOException
    //   47	54	131	java/io/IOException
    //   60	65	131	java/io/IOException
    //   78	86	131	java/io/IOException
    //   113	124	131	java/io/IOException
    //   13	18	149	finally
    //   24	41	149	finally
    //   47	54	149	finally
    //   60	65	149	finally
    //   78	86	149	finally
    //   113	124	149	finally
    //   96	100	167	java/io/IOException
    //   137	142	171	java/io/IOException
    //   155	160	175	java/io/IOException
  }
  
  public static int getNumberOfCPUCores()
  {
    AppMethodBeat.i(206936);
    if (Build.VERSION.SDK_INT <= 10)
    {
      AppMethodBeat.o(206936);
      return 1;
    }
    try
    {
      i = cm("/sys/devices/system/cpu/possible");
      int j = i;
      if (i == -1) {
        j = cm("/sys/devices/system/cpu/present");
      }
      i = j;
      if (j == -1) {
        i = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
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
    AppMethodBeat.o(206936);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.c.a.a
 * JD-Core Version:    0.7.0.1
 */