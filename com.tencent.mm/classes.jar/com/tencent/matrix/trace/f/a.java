package com.tencent.matrix.trace.f;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.d.b;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public final class a
{
  private static final FileFilter asd = new FileFilter()
  {
    public final boolean accept(File paramAnonymousFile)
    {
      return Pattern.matches("cpu[0-9]", paramAnonymousFile.getName());
    }
  };
  private static a bsF = null;
  
  /* Error */
  private static long W(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmplt +34 -> 39
    //   8: new 35	android/app/ActivityManager$MemoryInfo
    //   11: dup
    //   12: invokespecial 36	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   15: astore 7
    //   17: aload_0
    //   18: ldc 38
    //   20: invokevirtual 44	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 46	android/app/ActivityManager
    //   26: aload 7
    //   28: invokevirtual 50	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   31: aload 7
    //   33: getfield 54	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   36: lstore_3
    //   37: lload_3
    //   38: lreturn
    //   39: lconst_0
    //   40: lstore_3
    //   41: new 56	java/io/BufferedReader
    //   44: dup
    //   45: new 58	java/io/FileReader
    //   48: dup
    //   49: ldc 60
    //   51: invokespecial 63	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 66	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore 7
    //   59: aload 7
    //   61: astore_0
    //   62: aload 7
    //   64: invokevirtual 70	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore 8
    //   69: lload_3
    //   70: lstore 5
    //   72: aload 8
    //   74: ifnull +93 -> 167
    //   77: aload 7
    //   79: astore_0
    //   80: aload 8
    //   82: ldc 72
    //   84: invokevirtual 78	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   87: astore 9
    //   89: aload 7
    //   91: astore_0
    //   92: aload 9
    //   94: arraylength
    //   95: istore_2
    //   96: iconst_0
    //   97: istore_1
    //   98: iload_1
    //   99: iload_2
    //   100: if_icmpge +48 -> 148
    //   103: aload 9
    //   105: iload_1
    //   106: aaload
    //   107: astore 10
    //   109: aload 7
    //   111: astore_0
    //   112: aload 8
    //   114: new 80	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   121: aload 10
    //   123: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 87
    //   128: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: iconst_0
    //   135: anewarray 4	java/lang/Object
    //   138: invokestatic 96	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: iload_1
    //   142: iconst_1
    //   143: iadd
    //   144: istore_1
    //   145: goto -47 -> 98
    //   148: aload 7
    //   150: astore_0
    //   151: aload 9
    //   153: iconst_1
    //   154: aaload
    //   155: invokestatic 102	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   158: istore_1
    //   159: iload_1
    //   160: i2l
    //   161: ldc2_w 103
    //   164: lmul
    //   165: lstore 5
    //   167: aload 7
    //   169: invokevirtual 107	java/io/BufferedReader:close	()V
    //   172: lload 5
    //   174: lreturn
    //   175: astore_0
    //   176: ldc 109
    //   178: ldc 111
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload_0
    //   187: invokevirtual 112	java/lang/Exception:toString	()Ljava/lang/String;
    //   190: aastore
    //   191: invokestatic 96	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: lload 5
    //   196: lreturn
    //   197: astore 8
    //   199: aconst_null
    //   200: astore 7
    //   202: aload 7
    //   204: astore_0
    //   205: ldc 109
    //   207: ldc 114
    //   209: iconst_1
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload 8
    //   217: invokevirtual 112	java/lang/Exception:toString	()Ljava/lang/String;
    //   220: aastore
    //   221: invokestatic 96	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: aload 7
    //   226: ifnull -189 -> 37
    //   229: aload 7
    //   231: invokevirtual 107	java/io/BufferedReader:close	()V
    //   234: lconst_0
    //   235: lreturn
    //   236: astore_0
    //   237: ldc 109
    //   239: ldc 111
    //   241: iconst_1
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload_0
    //   248: invokevirtual 112	java/lang/Exception:toString	()Ljava/lang/String;
    //   251: aastore
    //   252: invokestatic 96	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: lconst_0
    //   256: lreturn
    //   257: astore 7
    //   259: aconst_null
    //   260: astore_0
    //   261: aload_0
    //   262: ifnull +7 -> 269
    //   265: aload_0
    //   266: invokevirtual 107	java/io/BufferedReader:close	()V
    //   269: aload 7
    //   271: athrow
    //   272: astore_0
    //   273: ldc 109
    //   275: ldc 111
    //   277: iconst_1
    //   278: anewarray 4	java/lang/Object
    //   281: dup
    //   282: iconst_0
    //   283: aload_0
    //   284: invokevirtual 112	java/lang/Exception:toString	()Ljava/lang/String;
    //   287: aastore
    //   288: invokestatic 96	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: goto -22 -> 269
    //   294: astore 7
    //   296: goto -35 -> 261
    //   299: astore 8
    //   301: goto -99 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramContext	Context
    //   97	63	1	i	int
    //   95	6	2	j	int
    //   36	34	3	l1	long
    //   70	125	5	l2	long
    //   15	215	7	localObject1	Object
    //   257	13	7	localObject2	Object
    //   294	1	7	localObject3	Object
    //   67	46	8	str1	String
    //   197	19	8	localException1	Exception
    //   299	1	8	localException2	Exception
    //   87	65	9	arrayOfString	String[]
    //   107	15	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   167	172	175	java/lang/Exception
    //   41	59	197	java/lang/Exception
    //   229	234	236	java/lang/Exception
    //   41	59	257	finally
    //   265	269	272	java/lang/Exception
    //   62	69	294	finally
    //   80	89	294	finally
    //   92	96	294	finally
    //   112	141	294	finally
    //   151	159	294	finally
    //   205	224	294	finally
    //   62	69	299	java/lang/Exception
    //   80	89	299	java/lang/Exception
    //   92	96	299	java/lang/Exception
    //   112	141	299	java/lang/Exception
    //   151	159	299	java/lang/Exception
  }
  
  public static a aj(Context paramContext)
  {
    if (bsF != null) {
      return bsF;
    }
    long l = W(paramContext);
    int i = rs();
    b.i("Matrix.DeviceUtil", "[getLevel] totalMemory:%s coresNum:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
    if (l >= 4294967296L) {
      bsF = a.bsG;
    }
    for (;;)
    {
      return bsF;
      if (l >= 3221225472L) {
        bsF = a.bsH;
      } else if (l >= 2147483648L)
      {
        if (i >= 4) {
          bsF = a.bsH;
        } else if (i >= 2) {
          bsF = a.bsI;
        } else if (i > 0) {
          bsF = a.bsJ;
        }
      }
      else if (l >= 1073741824L)
      {
        if (i >= 4) {
          bsF = a.bsI;
        } else if (i >= 2) {
          bsF = a.bsJ;
        } else if (i > 0) {
          bsF = a.bsJ;
        }
      }
      else if ((0L <= l) && (l < 1073741824L)) {
        bsF = a.bsK;
      } else {
        bsF = a.bsL;
      }
    }
  }
  
  /* Error */
  private static int bz(String paramString)
  {
    // Byte code:
    //   0: new 164	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: astore_0
    //   11: new 56	java/io/BufferedReader
    //   14: dup
    //   15: new 167	java/io/InputStreamReader
    //   18: dup
    //   19: aload_3
    //   20: ldc 169
    //   22: invokespecial 172	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   25: invokespecial 66	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore 4
    //   30: aload_3
    //   31: astore_0
    //   32: aload 4
    //   34: invokevirtual 70	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_3
    //   40: astore_0
    //   41: aload 4
    //   43: invokevirtual 107	java/io/BufferedReader:close	()V
    //   46: aload 5
    //   48: ifnull +17 -> 65
    //   51: aload_3
    //   52: astore_0
    //   53: aload 5
    //   55: ldc 174
    //   57: invokevirtual 178	java/lang/String:matches	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifne +31 -> 93
    //   65: aload_3
    //   66: invokevirtual 181	java/io/InputStream:close	()V
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_0
    //   72: ldc 109
    //   74: ldc 183
    //   76: iconst_1
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_0
    //   83: invokevirtual 184	java/io/IOException:toString	()Ljava/lang/String;
    //   86: aastore
    //   87: invokestatic 96	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: goto -21 -> 69
    //   93: aload_3
    //   94: astore_0
    //   95: aload 5
    //   97: iconst_2
    //   98: invokevirtual 188	java/lang/String:substring	(I)Ljava/lang/String;
    //   101: invokestatic 102	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   104: istore_1
    //   105: iload_1
    //   106: iconst_1
    //   107: iadd
    //   108: istore_1
    //   109: aload_3
    //   110: invokevirtual 181	java/io/InputStream:close	()V
    //   113: iload_1
    //   114: ireturn
    //   115: astore_0
    //   116: ldc 109
    //   118: ldc 183
    //   120: iconst_1
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_0
    //   127: invokevirtual 184	java/io/IOException:toString	()Ljava/lang/String;
    //   130: aastore
    //   131: invokestatic 96	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: iload_1
    //   135: ireturn
    //   136: astore 4
    //   138: aconst_null
    //   139: astore_3
    //   140: aload_3
    //   141: astore_0
    //   142: ldc 109
    //   144: ldc 183
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload 4
    //   154: invokevirtual 184	java/io/IOException:toString	()Ljava/lang/String;
    //   157: aastore
    //   158: invokestatic 96	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 181	java/io/InputStream:close	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_0
    //   172: ldc 109
    //   174: ldc 183
    //   176: iconst_1
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_0
    //   183: invokevirtual 184	java/io/IOException:toString	()Ljava/lang/String;
    //   186: aastore
    //   187: invokestatic 96	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: goto -21 -> 169
    //   193: astore_3
    //   194: aconst_null
    //   195: astore_0
    //   196: aload_0
    //   197: ifnull +7 -> 204
    //   200: aload_0
    //   201: invokevirtual 181	java/io/InputStream:close	()V
    //   204: aload_3
    //   205: athrow
    //   206: astore_0
    //   207: ldc 109
    //   209: ldc 183
    //   211: iconst_1
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload_0
    //   218: invokevirtual 184	java/io/IOException:toString	()Ljava/lang/String;
    //   221: aastore
    //   222: invokestatic 96	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: goto -21 -> 204
    //   228: astore_3
    //   229: goto -33 -> 196
    //   232: astore 4
    //   234: goto -94 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramString	String
    //   104	31	1	i	int
    //   60	2	2	bool	boolean
    //   8	158	3	localFileInputStream	java.io.FileInputStream
    //   193	12	3	localObject1	Object
    //   228	1	3	localObject2	Object
    //   28	14	4	localBufferedReader	java.io.BufferedReader
    //   136	17	4	localIOException1	java.io.IOException
    //   232	1	4	localIOException2	java.io.IOException
    //   37	59	5	str	String
    // Exception table:
    //   from	to	target	type
    //   65	69	71	java/io/IOException
    //   109	113	115	java/io/IOException
    //   0	9	136	java/io/IOException
    //   165	169	171	java/io/IOException
    //   0	9	193	finally
    //   200	204	206	java/io/IOException
    //   11	30	228	finally
    //   32	39	228	finally
    //   41	46	228	finally
    //   53	61	228	finally
    //   95	105	228	finally
    //   142	161	228	finally
    //   11	30	232	java/io/IOException
    //   32	39	232	java/io/IOException
    //   41	46	232	java/io/IOException
    //   53	61	232	java/io/IOException
    //   95	105	232	java/io/IOException
  }
  
  private static int rs()
  {
    int j = 0;
    if (Build.VERSION.SDK_INT <= 10) {
      return 1;
    }
    int i;
    try
    {
      int k = bz("/sys/devices/system/cpu/possible");
      i = k;
      if (k == 0) {
        i = bz("/sys/devices/system/cpu/present");
      }
      if (i == 0)
      {
        File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(asd);
        if (arrayOfFile == null) {
          i = j;
        } else {
          i = arrayOfFile.length;
        }
      }
    }
    catch (Exception localException)
    {
      i = j;
    }
    j = i;
    if (i == 0) {
      j = 1;
    }
    return j;
  }
  
  public static enum a
  {
    public int value;
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.f.a
 * JD-Core Version:    0.7.0.1
 */