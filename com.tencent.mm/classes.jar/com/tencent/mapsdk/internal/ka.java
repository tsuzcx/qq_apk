package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.Stack;

public final class ka
{
  public static final int a = 1024;
  public static final int b = 1048576;
  public static final int c = 1073741824;
  public static File d;
  private static final String e = "FileUtil";
  private static final kw f;
  
  static
  {
    AppMethodBeat.i(225308);
    f = new kw();
    AppMethodBeat.o(225308);
  }
  
  public static long a(File paramFile, FileFilter paramFileFilter)
  {
    long l2 = 0L;
    AppMethodBeat.i(225254);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(225254);
      return 0L;
    }
    long l1 = l2;
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles(paramFileFilter);
      l1 = l2;
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        for (;;)
        {
          l1 = l2;
          if (i >= j) {
            break;
          }
          l2 += a(arrayOfFile[i], paramFileFilter);
          i += 1;
        }
      }
    }
    if ((paramFileFilter == null) || (paramFileFilter.accept(paramFile)))
    {
      l1 = paramFile.length();
      paramFileFilter = new File(paramFile.getAbsolutePath() + System.currentTimeMillis());
      paramFile.renameTo(paramFileFilter);
      paramFileFilter.delete();
    }
    AppMethodBeat.o(225254);
    return l1;
  }
  
  public static File a(File paramFile, String paramString)
  {
    AppMethodBeat.i(224991);
    if ((paramFile == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(224991);
      return null;
    }
    paramFile = new File(paramFile, paramString);
    paramFile.mkdirs();
    AppMethodBeat.o(224991);
    return paramFile;
  }
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(225265);
    if (paramContext == null)
    {
      AppMethodBeat.o(225265);
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageName();
      if ((paramContext == null) || (paramContext.length() == 0))
      {
        AppMethodBeat.o(225265);
        return "";
      }
      if (paramContext.length() > 255)
      {
        paramContext = paramContext.substring(0, 254);
        AppMethodBeat.o(225265);
        return paramContext;
      }
      AppMethodBeat.o(225265);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(225265);
    }
    return "";
  }
  
  /* Error */
  public static String a(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 138
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: invokevirtual 48	java/io/File:exists	()Z
    //   15: ifeq +8 -> 23
    //   18: iload_1
    //   19: iconst_m1
    //   20: if_icmpne +10 -> 30
    //   23: ldc 138
    //   25: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: new 140	java/io/BufferedReader
    //   33: dup
    //   34: new 142	java/io/FileReader
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 145	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   42: invokespecial 148	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_0
    //   46: iconst_0
    //   47: istore_2
    //   48: aload_0
    //   49: invokevirtual 151	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull +26 -> 80
    //   57: iload_2
    //   58: iload_1
    //   59: if_icmpne +14 -> 73
    //   62: aload_0
    //   63: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   66: ldc 138
    //   68: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_3
    //   72: areturn
    //   73: iload_2
    //   74: iconst_1
    //   75: iadd
    //   76: istore_2
    //   77: goto -29 -> 48
    //   80: aload_0
    //   81: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   84: ldc 138
    //   86: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_0
    //   95: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   98: goto -14 -> 84
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   108: goto -24 -> 84
    //   111: astore_0
    //   112: aload_3
    //   113: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   116: ldc 138
    //   118: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: athrow
    //   123: astore 4
    //   125: aload_0
    //   126: astore_3
    //   127: aload 4
    //   129: astore_0
    //   130: goto -18 -> 112
    //   133: astore_3
    //   134: goto -30 -> 104
    //   137: astore_3
    //   138: goto -44 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramFile	File
    //   0	141	1	paramInt	int
    //   47	30	2	i	int
    //   1	126	3	localObject1	Object
    //   133	1	3	localIOException	IOException
    //   137	1	3	localFileNotFoundException	java.io.FileNotFoundException
    //   123	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	46	91	java/io/FileNotFoundException
    //   30	46	101	java/io/IOException
    //   30	46	111	finally
    //   48	53	123	finally
    //   48	53	133	java/io/IOException
    //   48	53	137	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void a(File paramFile, int paramInt, String paramString)
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: invokevirtual 48	java/io/File:exists	()Z
    //   13: ifeq +8 -> 21
    //   16: iload_1
    //   17: iconst_m1
    //   18: if_icmpne +9 -> 27
    //   21: ldc 158
    //   23: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: new 160	java/io/RandomAccessFile
    //   30: dup
    //   31: aload_0
    //   32: ldc 162
    //   34: invokespecial 163	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore 8
    //   39: aload_0
    //   40: invokestatic 166	com/tencent/mapsdk/internal/ka:e	(Ljava/io/File;)Ljava/io/File;
    //   43: astore_0
    //   44: new 160	java/io/RandomAccessFile
    //   47: dup
    //   48: aload_0
    //   49: ldc 162
    //   51: invokespecial 163	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore 9
    //   56: iconst_0
    //   57: istore_3
    //   58: lconst_0
    //   59: lstore 4
    //   61: aload 8
    //   63: invokevirtual 167	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   66: astore 10
    //   68: aload 10
    //   70: ifnull +78 -> 148
    //   73: iload_3
    //   74: iload_1
    //   75: if_icmpne +21 -> 96
    //   78: aload 8
    //   80: invokevirtual 170	java/io/RandomAccessFile:getFilePointer	()J
    //   83: ldc 172
    //   85: invokevirtual 176	java/lang/String:getBytes	()[B
    //   88: arraylength
    //   89: i2l
    //   90: lsub
    //   91: lstore 6
    //   93: goto +277 -> 370
    //   96: lload 4
    //   98: lstore 6
    //   100: iload_3
    //   101: iload_1
    //   102: if_icmple +268 -> 370
    //   105: aload 9
    //   107: aload 10
    //   109: ldc 178
    //   111: invokevirtual 181	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   114: invokevirtual 185	java/io/RandomAccessFile:write	([B)V
    //   117: lload 4
    //   119: lstore 6
    //   121: goto +249 -> 370
    //   124: astore_2
    //   125: aload 9
    //   127: astore_2
    //   128: aload 8
    //   130: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   133: aload_2
    //   134: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   137: aload_0
    //   138: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   141: pop
    //   142: ldc 158
    //   144: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: return
    //   148: aload 8
    //   150: lload 4
    //   152: invokevirtual 191	java/io/RandomAccessFile:seek	(J)V
    //   155: aload 8
    //   157: new 69	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   164: aload_2
    //   165: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc 172
    //   170: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokevirtual 176	java/lang/String:getBytes	()[B
    //   179: invokevirtual 185	java/io/RandomAccessFile:write	([B)V
    //   182: aload 9
    //   184: lconst_0
    //   185: invokevirtual 191	java/io/RandomAccessFile:seek	(J)V
    //   188: aload 9
    //   190: invokevirtual 167	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   193: astore_2
    //   194: aload_2
    //   195: ifnull +41 -> 236
    //   198: aload 8
    //   200: aload_2
    //   201: ldc 178
    //   203: invokevirtual 181	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   206: invokevirtual 185	java/io/RandomAccessFile:write	([B)V
    //   209: goto -21 -> 188
    //   212: astore_2
    //   213: aload 9
    //   215: astore_2
    //   216: aload 8
    //   218: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   221: aload_2
    //   222: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   225: aload_0
    //   226: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   229: pop
    //   230: ldc 158
    //   232: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    //   236: aload 8
    //   238: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   241: aload 9
    //   243: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   246: aload_0
    //   247: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   250: pop
    //   251: ldc 158
    //   253: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: return
    //   257: astore_2
    //   258: aconst_null
    //   259: astore 10
    //   261: aconst_null
    //   262: astore_0
    //   263: aconst_null
    //   264: astore 8
    //   266: aload 8
    //   268: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   271: aload_0
    //   272: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   275: aload 10
    //   277: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   280: pop
    //   281: ldc 158
    //   283: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: aload_2
    //   287: athrow
    //   288: astore_2
    //   289: aconst_null
    //   290: astore 10
    //   292: aconst_null
    //   293: astore_0
    //   294: goto -28 -> 266
    //   297: astore_2
    //   298: aconst_null
    //   299: astore 9
    //   301: aload_0
    //   302: astore 10
    //   304: aload 9
    //   306: astore_0
    //   307: goto -41 -> 266
    //   310: astore_2
    //   311: aload_0
    //   312: astore 10
    //   314: aload 9
    //   316: astore_0
    //   317: goto -51 -> 266
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_0
    //   323: aconst_null
    //   324: astore_2
    //   325: aconst_null
    //   326: astore 8
    //   328: goto -112 -> 216
    //   331: astore_0
    //   332: aconst_null
    //   333: astore_0
    //   334: aconst_null
    //   335: astore_2
    //   336: goto -120 -> 216
    //   339: astore_2
    //   340: aconst_null
    //   341: astore_2
    //   342: goto -126 -> 216
    //   345: astore_0
    //   346: aconst_null
    //   347: astore_0
    //   348: aconst_null
    //   349: astore_2
    //   350: aconst_null
    //   351: astore 8
    //   353: goto -225 -> 128
    //   356: astore_0
    //   357: aconst_null
    //   358: astore_0
    //   359: aconst_null
    //   360: astore_2
    //   361: goto -233 -> 128
    //   364: astore_2
    //   365: aconst_null
    //   366: astore_2
    //   367: goto -239 -> 128
    //   370: iload_3
    //   371: iconst_1
    //   372: iadd
    //   373: istore_3
    //   374: lload 6
    //   376: lstore 4
    //   378: goto -317 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	paramFile	File
    //   0	381	1	paramInt	int
    //   0	381	2	paramString	String
    //   57	317	3	i	int
    //   59	318	4	l1	long
    //   91	284	6	l2	long
    //   37	315	8	localRandomAccessFile1	java.io.RandomAccessFile
    //   54	261	9	localRandomAccessFile2	java.io.RandomAccessFile
    //   66	247	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   61	68	124	java/io/FileNotFoundException
    //   78	93	124	java/io/FileNotFoundException
    //   105	117	124	java/io/FileNotFoundException
    //   148	188	124	java/io/FileNotFoundException
    //   188	194	124	java/io/FileNotFoundException
    //   198	209	124	java/io/FileNotFoundException
    //   61	68	212	java/io/IOException
    //   78	93	212	java/io/IOException
    //   105	117	212	java/io/IOException
    //   148	188	212	java/io/IOException
    //   188	194	212	java/io/IOException
    //   198	209	212	java/io/IOException
    //   27	39	257	finally
    //   39	44	288	finally
    //   44	56	297	finally
    //   61	68	310	finally
    //   78	93	310	finally
    //   105	117	310	finally
    //   148	188	310	finally
    //   188	194	310	finally
    //   198	209	310	finally
    //   27	39	320	java/io/IOException
    //   39	44	331	java/io/IOException
    //   44	56	339	java/io/IOException
    //   27	39	345	java/io/FileNotFoundException
    //   39	44	356	java/io/FileNotFoundException
    //   44	56	364	java/io/FileNotFoundException
  }
  
  public static boolean a(File paramFile)
  {
    AppMethodBeat.i(225033);
    if (paramFile == null)
    {
      AppMethodBeat.o(225033);
      return false;
    }
    if (paramFile.exists())
    {
      AppMethodBeat.o(225033);
      return true;
    }
    File localFile = paramFile.getParentFile();
    if (localFile == null)
    {
      AppMethodBeat.o(225033);
      return false;
    }
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      AppMethodBeat.o(225033);
      return false;
    }
    try
    {
      boolean bool = paramFile.createNewFile();
      AppMethodBeat.o(225033);
      return bool;
    }
    catch (IOException paramFile)
    {
      AppMethodBeat.o(225033);
    }
    return false;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(225206);
    if ((paramFile1 == null) || (!paramFile1.exists()))
    {
      AppMethodBeat.o(225206);
      return false;
    }
    b(paramFile2);
    boolean bool = paramFile1.renameTo(paramFile2);
    AppMethodBeat.o(225206);
    return bool;
  }
  
  /* Error */
  public static boolean a(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 203
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ifnull +7 -> 15
    //   11: aload_1
    //   12: ifnonnull +10 -> 22
    //   15: ldc 203
    //   17: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokestatic 205	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;)Z
    //   26: ifne +10 -> 36
    //   29: ldc 203
    //   31: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: iconst_0
    //   35: ireturn
    //   36: aconst_null
    //   37: astore 5
    //   39: aconst_null
    //   40: astore 4
    //   42: new 207	java/io/FileOutputStream
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   50: astore_0
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 209	java/io/FileOutputStream:write	([B)V
    //   56: iconst_1
    //   57: istore_2
    //   58: aload_0
    //   59: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   62: ldc 203
    //   64: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: iload_2
    //   68: ireturn
    //   69: astore_0
    //   70: aconst_null
    //   71: astore_0
    //   72: iload_3
    //   73: istore_2
    //   74: aload_0
    //   75: ifnull -13 -> 62
    //   78: aload_0
    //   79: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   82: iload_3
    //   83: istore_2
    //   84: goto -22 -> 62
    //   87: astore_0
    //   88: iload_3
    //   89: istore_2
    //   90: goto -28 -> 62
    //   93: astore_0
    //   94: aload 4
    //   96: astore_0
    //   97: iload_3
    //   98: istore_2
    //   99: aload_0
    //   100: ifnull -38 -> 62
    //   103: aload_0
    //   104: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   107: iload_3
    //   108: istore_2
    //   109: goto -47 -> 62
    //   112: astore_0
    //   113: iload_3
    //   114: istore_2
    //   115: goto -53 -> 62
    //   118: astore_0
    //   119: aload 5
    //   121: astore_1
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   130: ldc 203
    //   132: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_0
    //   136: athrow
    //   137: astore_0
    //   138: goto -76 -> 62
    //   141: astore_1
    //   142: goto -12 -> 130
    //   145: astore 4
    //   147: aload_0
    //   148: astore_1
    //   149: aload 4
    //   151: astore_0
    //   152: goto -30 -> 122
    //   155: astore_1
    //   156: goto -59 -> 97
    //   159: astore_1
    //   160: goto -88 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramFile	File
    //   0	163	1	paramArrayOfByte	byte[]
    //   57	58	2	bool1	boolean
    //   1	113	3	bool2	boolean
    //   40	55	4	localObject1	Object
    //   145	5	4	localObject2	Object
    //   37	83	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   42	51	69	java/io/FileNotFoundException
    //   78	82	87	java/io/IOException
    //   42	51	93	java/io/IOException
    //   103	107	112	java/io/IOException
    //   42	51	118	finally
    //   58	62	137	java/io/IOException
    //   126	130	141	java/io/IOException
    //   51	56	145	finally
    //   51	56	155	java/io/IOException
    //   51	56	159	java/io/FileNotFoundException
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(225021);
    boolean bool = a(new File(paramString));
    AppMethodBeat.o(225021);
    return bool;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(225234);
    paramString1 = new File(paramString1);
    File localFile = new File(paramString2);
    if (localFile.exists()) {
      f(localFile);
    }
    boolean bool = paramString1.renameTo(new File(paramString2));
    AppMethodBeat.o(225234);
    return bool;
  }
  
  public static File b(File paramFile, String paramString)
  {
    AppMethodBeat.i(225009);
    if ((paramFile == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(225009);
      return null;
    }
    int i = paramString.lastIndexOf(File.separator);
    File localFile = paramFile;
    String str = paramString;
    if (i != -1)
    {
      str = paramString.substring(i + 1);
      localFile = new File(paramFile, paramString.substring(0, i));
    }
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      if (Log.isLoggable("FileUtil", 6)) {
        new StringBuilder("create file failed with mkdirs failed:").append(localFile.getAbsolutePath());
      }
      AppMethodBeat.o(225009);
      return null;
    }
    paramFile = new File(localFile, str);
    try
    {
      if ((!paramFile.exists()) && (!paramFile.createNewFile()) && (Log.isLoggable("FileUtil", 6))) {
        new StringBuilder("create file failed:").append(paramFile.getAbsolutePath());
      }
      AppMethodBeat.o(225009);
      return paramFile;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.isLoggable("FileUtil", 6);
      }
    }
  }
  
  public static String b(String paramString)
  {
    AppMethodBeat.i(225227);
    if (paramString == null)
    {
      AppMethodBeat.o(225227);
      return "";
    }
    String str = paramString.trim();
    paramString = str;
    if (str.contains("../")) {}
    for (paramString = str.replaceAll("\\.\\./", "");; paramString = paramString.substring(1))
    {
      str = paramString;
      if (!paramString.startsWith(File.separator)) {
        break;
      }
    }
    while (str.endsWith(File.separator)) {
      str = str.substring(0, str.length() - 1);
    }
    AppMethodBeat.o(225227);
    return str;
  }
  
  /* Error */
  public static void b(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 265
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 48	java/io/File:exists	()Z
    //   10: ifeq +8 -> 18
    //   13: iload_1
    //   14: iconst_m1
    //   15: if_icmpne +10 -> 25
    //   18: ldc_w 265
    //   21: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: new 160	java/io/RandomAccessFile
    //   28: dup
    //   29: aload_0
    //   30: ldc 162
    //   32: invokespecial 163	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore 5
    //   37: aload_0
    //   38: invokestatic 166	com/tencent/mapsdk/internal/ka:e	(Ljava/io/File;)Ljava/io/File;
    //   41: astore 4
    //   43: new 160	java/io/RandomAccessFile
    //   46: dup
    //   47: aload 4
    //   49: ldc 162
    //   51: invokespecial 163	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore 6
    //   56: iconst_0
    //   57: istore_3
    //   58: iconst_0
    //   59: istore_2
    //   60: aload 5
    //   62: invokevirtual 167	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   65: astore 7
    //   67: aload 7
    //   69: ifnull +42 -> 111
    //   72: iload_3
    //   73: iload_1
    //   74: if_icmpeq +32 -> 106
    //   77: aload 6
    //   79: aload 7
    //   81: ldc 178
    //   83: invokevirtual 181	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   86: invokevirtual 185	java/io/RandomAccessFile:write	([B)V
    //   89: aload 6
    //   91: ldc 172
    //   93: invokevirtual 176	java/lang/String:getBytes	()[B
    //   96: invokevirtual 185	java/io/RandomAccessFile:write	([B)V
    //   99: iload_3
    //   100: iconst_1
    //   101: iadd
    //   102: istore_3
    //   103: goto -43 -> 60
    //   106: iconst_1
    //   107: istore_2
    //   108: goto -9 -> 99
    //   111: aload 5
    //   113: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   116: aload 6
    //   118: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   121: iload_2
    //   122: ifeq +22 -> 144
    //   125: aload_0
    //   126: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   129: pop
    //   130: aload 4
    //   132: aload_0
    //   133: invokestatic 267	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;Ljava/io/File;)Z
    //   136: pop
    //   137: ldc_w 265
    //   140: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: return
    //   144: aload 4
    //   146: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   149: pop
    //   150: ldc_w 265
    //   153: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: return
    //   157: astore 4
    //   159: iconst_0
    //   160: istore_2
    //   161: aconst_null
    //   162: astore 7
    //   164: aconst_null
    //   165: astore 4
    //   167: aconst_null
    //   168: astore 5
    //   170: aload 5
    //   172: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   175: aload 4
    //   177: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   180: iload_2
    //   181: ifeq +22 -> 203
    //   184: aload_0
    //   185: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   188: pop
    //   189: aload 7
    //   191: aload_0
    //   192: invokestatic 267	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;Ljava/io/File;)Z
    //   195: pop
    //   196: ldc_w 265
    //   199: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: return
    //   203: aload 7
    //   205: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   208: pop
    //   209: ldc_w 265
    //   212: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: return
    //   216: astore 4
    //   218: iconst_0
    //   219: istore_2
    //   220: aconst_null
    //   221: astore 7
    //   223: aconst_null
    //   224: astore 4
    //   226: aconst_null
    //   227: astore 5
    //   229: aload 5
    //   231: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   234: aload 4
    //   236: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   239: iload_2
    //   240: ifeq +22 -> 262
    //   243: aload_0
    //   244: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   247: pop
    //   248: aload 7
    //   250: aload_0
    //   251: invokestatic 267	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;Ljava/io/File;)Z
    //   254: pop
    //   255: ldc_w 265
    //   258: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: return
    //   262: aload 7
    //   264: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   267: pop
    //   268: ldc_w 265
    //   271: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: return
    //   275: astore 5
    //   277: iconst_0
    //   278: istore_1
    //   279: aconst_null
    //   280: astore 7
    //   282: aconst_null
    //   283: astore 4
    //   285: aconst_null
    //   286: astore 6
    //   288: aload 6
    //   290: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   293: aload 4
    //   295: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   298: iload_1
    //   299: ifeq +24 -> 323
    //   302: aload_0
    //   303: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   306: pop
    //   307: aload 7
    //   309: aload_0
    //   310: invokestatic 267	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;Ljava/io/File;)Z
    //   313: pop
    //   314: ldc_w 265
    //   317: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload 5
    //   322: athrow
    //   323: aload 7
    //   325: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   328: pop
    //   329: goto -15 -> 314
    //   332: astore 8
    //   334: iconst_0
    //   335: istore_1
    //   336: aconst_null
    //   337: astore 7
    //   339: aconst_null
    //   340: astore 4
    //   342: aload 5
    //   344: astore 6
    //   346: aload 8
    //   348: astore 5
    //   350: goto -62 -> 288
    //   353: astore 8
    //   355: iconst_0
    //   356: istore_1
    //   357: aconst_null
    //   358: astore 6
    //   360: aload 4
    //   362: astore 7
    //   364: aload 6
    //   366: astore 4
    //   368: aload 5
    //   370: astore 6
    //   372: aload 8
    //   374: astore 5
    //   376: goto -88 -> 288
    //   379: astore 8
    //   381: iload_2
    //   382: istore_1
    //   383: aload 4
    //   385: astore 7
    //   387: aload 6
    //   389: astore 4
    //   391: aload 5
    //   393: astore 6
    //   395: aload 8
    //   397: astore 5
    //   399: goto -111 -> 288
    //   402: astore 4
    //   404: iconst_0
    //   405: istore_2
    //   406: aconst_null
    //   407: astore 7
    //   409: aconst_null
    //   410: astore 4
    //   412: goto -183 -> 229
    //   415: astore 6
    //   417: iconst_0
    //   418: istore_2
    //   419: aconst_null
    //   420: astore 6
    //   422: aload 4
    //   424: astore 7
    //   426: aload 6
    //   428: astore 4
    //   430: goto -201 -> 229
    //   433: astore 7
    //   435: aload 4
    //   437: astore 7
    //   439: aload 6
    //   441: astore 4
    //   443: goto -214 -> 229
    //   446: astore 4
    //   448: iconst_0
    //   449: istore_2
    //   450: aconst_null
    //   451: astore 7
    //   453: aconst_null
    //   454: astore 4
    //   456: goto -286 -> 170
    //   459: astore 6
    //   461: iconst_0
    //   462: istore_2
    //   463: aconst_null
    //   464: astore 6
    //   466: aload 4
    //   468: astore 7
    //   470: aload 6
    //   472: astore 4
    //   474: goto -304 -> 170
    //   477: astore 7
    //   479: aload 4
    //   481: astore 7
    //   483: aload 6
    //   485: astore 4
    //   487: goto -317 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	paramFile	File
    //   0	490	1	paramInt	int
    //   59	404	2	i	int
    //   57	46	3	j	int
    //   41	104	4	localFile	File
    //   157	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   165	11	4	localCloseable	java.io.Closeable
    //   216	1	4	localIOException1	IOException
    //   224	166	4	localObject1	Object
    //   402	1	4	localIOException2	IOException
    //   410	32	4	localObject2	Object
    //   446	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   454	32	4	localObject3	Object
    //   35	195	5	localRandomAccessFile	java.io.RandomAccessFile
    //   275	68	5	localObject4	Object
    //   348	50	5	localObject5	Object
    //   54	340	6	localObject6	Object
    //   415	1	6	localIOException3	IOException
    //   420	20	6	localObject7	Object
    //   459	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   464	20	6	localObject8	Object
    //   65	360	7	localObject9	Object
    //   433	1	7	localIOException4	IOException
    //   437	32	7	localObject10	Object
    //   477	1	7	localFileNotFoundException4	java.io.FileNotFoundException
    //   481	1	7	localObject11	Object
    //   332	15	8	localObject12	Object
    //   353	20	8	localObject13	Object
    //   379	17	8	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   25	37	157	java/io/FileNotFoundException
    //   25	37	216	java/io/IOException
    //   25	37	275	finally
    //   37	43	332	finally
    //   43	56	353	finally
    //   60	67	379	finally
    //   77	99	379	finally
    //   37	43	402	java/io/IOException
    //   43	56	415	java/io/IOException
    //   60	67	433	java/io/IOException
    //   77	99	433	java/io/IOException
    //   37	43	446	java/io/FileNotFoundException
    //   43	56	459	java/io/FileNotFoundException
    //   60	67	477	java/io/FileNotFoundException
    //   77	99	477	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void b(File paramFile, int paramInt, String paramString)
  {
    // Byte code:
    //   0: ldc_w 268
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +22 -> 29
    //   10: aload_0
    //   11: invokevirtual 48	java/io/File:exists	()Z
    //   14: ifeq +15 -> 29
    //   17: iload_1
    //   18: iconst_m1
    //   19: if_icmpeq +10 -> 29
    //   22: aload_2
    //   23: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +10 -> 36
    //   29: ldc_w 268
    //   32: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: new 160	java/io/RandomAccessFile
    //   39: dup
    //   40: aload_0
    //   41: ldc 162
    //   43: invokespecial 163	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore 6
    //   48: aload_0
    //   49: invokestatic 166	com/tencent/mapsdk/internal/ka:e	(Ljava/io/File;)Ljava/io/File;
    //   52: astore 5
    //   54: new 160	java/io/RandomAccessFile
    //   57: dup
    //   58: aload 5
    //   60: ldc 162
    //   62: invokespecial 163	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: astore 7
    //   67: iconst_0
    //   68: istore 4
    //   70: iconst_0
    //   71: istore_3
    //   72: aload 6
    //   74: invokevirtual 167	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   77: astore 8
    //   79: aload 8
    //   81: ifnull +66 -> 147
    //   84: iload 4
    //   86: iload_1
    //   87: if_icmpeq +28 -> 115
    //   90: aload 7
    //   92: aload 8
    //   94: ldc 178
    //   96: invokevirtual 181	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   99: invokevirtual 185	java/io/RandomAccessFile:write	([B)V
    //   102: aload 7
    //   104: ldc 172
    //   106: invokevirtual 176	java/lang/String:getBytes	()[B
    //   109: invokevirtual 185	java/io/RandomAccessFile:write	([B)V
    //   112: goto +347 -> 459
    //   115: aload 7
    //   117: new 69	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   124: aload_2
    //   125: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 172
    //   130: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokevirtual 176	java/lang/String:getBytes	()[B
    //   139: invokevirtual 185	java/io/RandomAccessFile:write	([B)V
    //   142: iconst_1
    //   143: istore_3
    //   144: goto +315 -> 459
    //   147: aload 6
    //   149: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   152: aload 7
    //   154: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   157: iload_3
    //   158: ifeq +22 -> 180
    //   161: aload_0
    //   162: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   165: pop
    //   166: aload 5
    //   168: aload_0
    //   169: invokestatic 267	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;Ljava/io/File;)Z
    //   172: pop
    //   173: ldc_w 268
    //   176: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: return
    //   180: aload 5
    //   182: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   185: pop
    //   186: ldc_w 268
    //   189: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: return
    //   193: astore_2
    //   194: iconst_0
    //   195: istore_3
    //   196: aconst_null
    //   197: astore 5
    //   199: aconst_null
    //   200: astore_2
    //   201: aconst_null
    //   202: astore 6
    //   204: aload 6
    //   206: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   209: aload_2
    //   210: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   213: iload_3
    //   214: ifeq +22 -> 236
    //   217: aload_0
    //   218: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   221: pop
    //   222: aload 5
    //   224: aload_0
    //   225: invokestatic 267	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;Ljava/io/File;)Z
    //   228: pop
    //   229: ldc_w 268
    //   232: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    //   236: aload 5
    //   238: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   241: pop
    //   242: ldc_w 268
    //   245: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: return
    //   249: astore_2
    //   250: iconst_0
    //   251: istore_3
    //   252: aconst_null
    //   253: astore 5
    //   255: aconst_null
    //   256: astore_2
    //   257: aconst_null
    //   258: astore 6
    //   260: aload 6
    //   262: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   265: aload_2
    //   266: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   269: iload_3
    //   270: ifeq +22 -> 292
    //   273: aload_0
    //   274: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   277: pop
    //   278: aload 5
    //   280: aload_0
    //   281: invokestatic 267	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;Ljava/io/File;)Z
    //   284: pop
    //   285: ldc_w 268
    //   288: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: return
    //   292: aload 5
    //   294: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   297: pop
    //   298: ldc_w 268
    //   301: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: return
    //   305: astore 5
    //   307: iconst_0
    //   308: istore_1
    //   309: aconst_null
    //   310: astore 8
    //   312: aconst_null
    //   313: astore_2
    //   314: aconst_null
    //   315: astore 6
    //   317: aload 6
    //   319: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   322: aload_2
    //   323: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   326: iload_1
    //   327: ifeq +24 -> 351
    //   330: aload_0
    //   331: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   334: pop
    //   335: aload 8
    //   337: aload_0
    //   338: invokestatic 267	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;Ljava/io/File;)Z
    //   341: pop
    //   342: ldc_w 268
    //   345: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: aload 5
    //   350: athrow
    //   351: aload 8
    //   353: invokestatic 187	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;)Z
    //   356: pop
    //   357: goto -15 -> 342
    //   360: astore 5
    //   362: iconst_0
    //   363: istore_1
    //   364: aconst_null
    //   365: astore 8
    //   367: aconst_null
    //   368: astore_2
    //   369: goto -52 -> 317
    //   372: astore 7
    //   374: iconst_0
    //   375: istore_1
    //   376: aconst_null
    //   377: astore_2
    //   378: aload 5
    //   380: astore 8
    //   382: aload 7
    //   384: astore 5
    //   386: goto -69 -> 317
    //   389: astore 9
    //   391: iload_3
    //   392: istore_1
    //   393: aload 5
    //   395: astore 8
    //   397: aload 7
    //   399: astore_2
    //   400: aload 9
    //   402: astore 5
    //   404: goto -87 -> 317
    //   407: astore_2
    //   408: iconst_0
    //   409: istore_3
    //   410: aconst_null
    //   411: astore 5
    //   413: aconst_null
    //   414: astore_2
    //   415: goto -155 -> 260
    //   418: astore_2
    //   419: iconst_0
    //   420: istore_3
    //   421: aconst_null
    //   422: astore_2
    //   423: goto -163 -> 260
    //   426: astore_2
    //   427: aload 7
    //   429: astore_2
    //   430: goto -170 -> 260
    //   433: astore_2
    //   434: iconst_0
    //   435: istore_3
    //   436: aconst_null
    //   437: astore 5
    //   439: aconst_null
    //   440: astore_2
    //   441: goto -237 -> 204
    //   444: astore_2
    //   445: iconst_0
    //   446: istore_3
    //   447: aconst_null
    //   448: astore_2
    //   449: goto -245 -> 204
    //   452: astore_2
    //   453: aload 7
    //   455: astore_2
    //   456: goto -252 -> 204
    //   459: iload 4
    //   461: iconst_1
    //   462: iadd
    //   463: istore 4
    //   465: goto -393 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	paramFile	File
    //   0	468	1	paramInt	int
    //   0	468	2	paramString	String
    //   71	376	3	i	int
    //   68	396	4	j	int
    //   52	241	5	localFile	File
    //   305	44	5	localObject1	Object
    //   360	19	5	localObject2	Object
    //   384	54	5	localObject3	Object
    //   46	272	6	localRandomAccessFile1	java.io.RandomAccessFile
    //   65	88	7	localRandomAccessFile2	java.io.RandomAccessFile
    //   372	82	7	localObject4	Object
    //   77	319	8	localObject5	Object
    //   389	12	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	48	193	java/io/FileNotFoundException
    //   36	48	249	java/io/IOException
    //   36	48	305	finally
    //   48	54	360	finally
    //   54	67	372	finally
    //   72	79	389	finally
    //   90	112	389	finally
    //   115	142	389	finally
    //   48	54	407	java/io/IOException
    //   54	67	418	java/io/IOException
    //   72	79	426	java/io/IOException
    //   90	112	426	java/io/IOException
    //   115	142	426	java/io/IOException
    //   48	54	433	java/io/FileNotFoundException
    //   54	67	444	java/io/FileNotFoundException
    //   72	79	452	java/io/FileNotFoundException
    //   90	112	452	java/io/FileNotFoundException
    //   115	142	452	java/io/FileNotFoundException
  }
  
  public static void b(File paramFile1, File paramFile2)
  {
    int i = 0;
    AppMethodBeat.i(225279);
    if (!paramFile2.exists()) {
      a(paramFile2.getParentFile(), paramFile2.getName());
    }
    if (paramFile1.isDirectory())
    {
      File[] arrayOfFile = paramFile1.listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        while (i < j)
        {
          b(arrayOfFile[i], new File(paramFile2, paramFile1.getName()));
          i += 1;
        }
      }
      AppMethodBeat.o(225279);
      return;
    }
    paramFile2 = new File(paramFile2, paramFile1.getName());
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        Files.copy(paramFile1.toPath(), paramFile2.toPath(), new CopyOption[0]);
        AppMethodBeat.o(225279);
        return;
      }
      catch (IOException paramFile1)
      {
        AppMethodBeat.o(225279);
        return;
      }
    }
    a(paramFile2, c(paramFile1));
    AppMethodBeat.o(225279);
  }
  
  /* Error */
  public static void b(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 304
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +12 -> 19
    //   10: aload_1
    //   11: ifnull +8 -> 19
    //   14: aload_1
    //   15: arraylength
    //   16: ifne +10 -> 26
    //   19: ldc_w 304
    //   22: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: return
    //   26: aload_0
    //   27: invokevirtual 48	java/io/File:exists	()Z
    //   30: ifne +8 -> 38
    //   33: aload_0
    //   34: invokestatic 205	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;)Z
    //   37: pop
    //   38: new 160	java/io/RandomAccessFile
    //   41: dup
    //   42: aload_0
    //   43: ldc 162
    //   45: invokespecial 163	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore_0
    //   49: aload_0
    //   50: aload_0
    //   51: invokevirtual 305	java/io/RandomAccessFile:length	()J
    //   54: invokevirtual 191	java/io/RandomAccessFile:seek	(J)V
    //   57: aload_0
    //   58: aload_1
    //   59: invokevirtual 185	java/io/RandomAccessFile:write	([B)V
    //   62: aload_0
    //   63: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   66: ldc_w 304
    //   69: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   80: ldc_w 304
    //   83: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: return
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   94: ldc_w 304
    //   97: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: return
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   108: ldc_w 304
    //   111: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_0
    //   115: athrow
    //   116: astore_1
    //   117: aload_0
    //   118: astore_2
    //   119: aload_1
    //   120: astore_0
    //   121: aload_2
    //   122: astore_1
    //   123: goto -19 -> 104
    //   126: astore_1
    //   127: goto -37 -> 90
    //   130: astore_1
    //   131: goto -55 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramFile	File
    //   0	134	1	paramArrayOfByte	byte[]
    //   118	4	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   38	49	73	java/io/FileNotFoundException
    //   38	49	87	java/io/IOException
    //   38	49	101	finally
    //   49	62	116	finally
    //   49	62	126	java/io/IOException
    //   49	62	130	java/io/FileNotFoundException
  }
  
  public static boolean b(File paramFile)
  {
    boolean bool2 = false;
    AppMethodBeat.i(225058);
    boolean bool1 = bool2;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.exists())
      {
        Stack localStack = new Stack();
        localStack.push(paramFile);
        bool1 = false;
        while (!localStack.isEmpty())
        {
          paramFile = (File)localStack.peek();
          if (paramFile.isFile())
          {
            bool1 = paramFile.delete();
            localStack.pop();
          }
          else if (paramFile.isDirectory())
          {
            File[] arrayOfFile = paramFile.listFiles();
            if ((arrayOfFile == null) || (arrayOfFile.length == 0))
            {
              bool1 = paramFile.delete();
              localStack.pop();
            }
            else
            {
              int j = arrayOfFile.length;
              int i = 0;
              while (i < j)
              {
                localStack.push(arrayOfFile[i]);
                i += 1;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(225058);
    return bool1;
  }
  
  private static File[] b(File paramFile, FileFilter paramFileFilter)
  {
    AppMethodBeat.i(225300);
    File[] arrayOfFile = new File[0];
    if (paramFile == null)
    {
      AppMethodBeat.o(225300);
      return arrayOfFile;
    }
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles(paramFileFilter);
      AppMethodBeat.o(225300);
      return paramFile;
    }
    AppMethodBeat.o(225300);
    return arrayOfFile;
  }
  
  /* Error */
  public static void c(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 328
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +10 -> 24
    //   17: ldc_w 328
    //   20: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: aload_0
    //   25: invokevirtual 48	java/io/File:exists	()Z
    //   28: ifne +8 -> 36
    //   31: aload_0
    //   32: invokestatic 205	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;)Z
    //   35: pop
    //   36: new 160	java/io/RandomAccessFile
    //   39: dup
    //   40: aload_0
    //   41: ldc 162
    //   43: invokespecial 163	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore_0
    //   47: aload_0
    //   48: aload_0
    //   49: invokevirtual 305	java/io/RandomAccessFile:length	()J
    //   52: invokevirtual 191	java/io/RandomAccessFile:seek	(J)V
    //   55: aload_0
    //   56: new 69	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   63: aload_1
    //   64: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 172
    //   69: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 176	java/lang/String:getBytes	()[B
    //   78: invokevirtual 185	java/io/RandomAccessFile:write	([B)V
    //   81: aload_0
    //   82: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   85: ldc_w 328
    //   88: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: return
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_0
    //   96: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   99: ldc_w 328
    //   102: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: return
    //   106: astore_0
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_0
    //   110: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   113: ldc_w 328
    //   116: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   127: ldc_w 328
    //   130: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_0
    //   134: athrow
    //   135: astore_1
    //   136: aload_0
    //   137: astore_2
    //   138: aload_1
    //   139: astore_0
    //   140: aload_2
    //   141: astore_1
    //   142: goto -19 -> 123
    //   145: astore_1
    //   146: goto -37 -> 109
    //   149: astore_1
    //   150: goto -55 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramFile	File
    //   0	153	1	paramString	String
    //   137	4	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   36	47	92	java/io/FileNotFoundException
    //   36	47	106	java/io/IOException
    //   36	47	120	finally
    //   47	81	135	finally
    //   47	81	145	java/io/IOException
    //   47	81	149	java/io/FileNotFoundException
  }
  
  /* Error */
  public static byte[] c(File paramFile)
  {
    // Byte code:
    //   0: ldc_w 329
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 48	java/io/File:exists	()Z
    //   14: ifne +11 -> 25
    //   17: ldc_w 329
    //   20: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: new 331	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_0
    //   34: new 334	java/io/ByteArrayOutputStream
    //   37: dup
    //   38: invokespecial 335	java/io/ByteArrayOutputStream:<init>	()V
    //   41: astore_2
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore_3
    //   48: aload_0
    //   49: aload_3
    //   50: invokevirtual 339	java/io/FileInputStream:read	([B)I
    //   53: istore_1
    //   54: iload_1
    //   55: iconst_m1
    //   56: if_icmpeq +42 -> 98
    //   59: aload_2
    //   60: aload_3
    //   61: iconst_0
    //   62: iload_1
    //   63: invokevirtual 342	java/io/ByteArrayOutputStream:write	([BII)V
    //   66: goto -18 -> 48
    //   69: astore_3
    //   70: aload_2
    //   71: ifnull +11 -> 82
    //   74: aload_2
    //   75: invokevirtual 345	java/io/ByteArrayOutputStream:flush	()V
    //   78: aload_2
    //   79: invokevirtual 346	java/io/ByteArrayOutputStream:close	()V
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 347	java/io/FileInputStream:close	()V
    //   90: ldc_w 329
    //   93: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aconst_null
    //   97: areturn
    //   98: aload_2
    //   99: invokevirtual 350	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   102: astore_3
    //   103: aload_2
    //   104: invokevirtual 345	java/io/ByteArrayOutputStream:flush	()V
    //   107: aload_2
    //   108: invokevirtual 346	java/io/ByteArrayOutputStream:close	()V
    //   111: aload_0
    //   112: invokevirtual 347	java/io/FileInputStream:close	()V
    //   115: ldc_w 329
    //   118: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_3
    //   122: areturn
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_0
    //   128: aload_2
    //   129: ifnull +11 -> 140
    //   132: aload_2
    //   133: invokevirtual 345	java/io/ByteArrayOutputStream:flush	()V
    //   136: aload_2
    //   137: invokevirtual 346	java/io/ByteArrayOutputStream:close	()V
    //   140: aload_0
    //   141: ifnull -51 -> 90
    //   144: aload_0
    //   145: invokevirtual 347	java/io/FileInputStream:close	()V
    //   148: goto -58 -> 90
    //   151: astore_0
    //   152: goto -62 -> 90
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_3
    //   160: aload_2
    //   161: ifnull +11 -> 172
    //   164: aload_2
    //   165: invokevirtual 345	java/io/ByteArrayOutputStream:flush	()V
    //   168: aload_2
    //   169: invokevirtual 346	java/io/ByteArrayOutputStream:close	()V
    //   172: aload_3
    //   173: ifnull +7 -> 180
    //   176: aload_3
    //   177: invokevirtual 347	java/io/FileInputStream:close	()V
    //   180: ldc_w 329
    //   183: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_0
    //   187: athrow
    //   188: astore_0
    //   189: goto -74 -> 115
    //   192: astore_0
    //   193: goto -103 -> 90
    //   196: astore_2
    //   197: goto -17 -> 180
    //   200: astore_2
    //   201: goto -29 -> 172
    //   204: astore_2
    //   205: aconst_null
    //   206: astore 4
    //   208: aload_0
    //   209: astore_3
    //   210: aload_2
    //   211: astore_0
    //   212: aload 4
    //   214: astore_2
    //   215: goto -55 -> 160
    //   218: astore 4
    //   220: aload_0
    //   221: astore_3
    //   222: aload 4
    //   224: astore_0
    //   225: goto -65 -> 160
    //   228: astore_2
    //   229: goto -89 -> 140
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_2
    //   235: goto -107 -> 128
    //   238: astore_3
    //   239: goto -111 -> 128
    //   242: astore_2
    //   243: goto -161 -> 82
    //   246: astore_0
    //   247: aconst_null
    //   248: astore_2
    //   249: aconst_null
    //   250: astore_0
    //   251: goto -181 -> 70
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_2
    //   257: goto -187 -> 70
    //   260: astore_2
    //   261: goto -150 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramFile	File
    //   53	10	1	i	int
    //   41	128	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   196	1	2	localIOException1	IOException
    //   200	1	2	localIOException2	IOException
    //   204	7	2	localObject1	Object
    //   214	1	2	localObject2	Object
    //   228	1	2	localIOException3	IOException
    //   232	1	2	localIOException4	IOException
    //   234	1	2	localObject3	Object
    //   242	1	2	localIOException5	IOException
    //   248	1	2	localObject4	Object
    //   254	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   256	1	2	localObject5	Object
    //   260	1	2	localIOException6	IOException
    //   47	14	3	arrayOfByte	byte[]
    //   69	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   102	120	3	localObject6	Object
    //   238	1	3	localIOException7	IOException
    //   206	7	4	localObject7	Object
    //   218	5	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   42	48	69	java/io/FileNotFoundException
    //   48	54	69	java/io/FileNotFoundException
    //   59	66	69	java/io/FileNotFoundException
    //   98	103	69	java/io/FileNotFoundException
    //   25	34	123	java/io/IOException
    //   144	148	151	java/io/IOException
    //   25	34	155	finally
    //   111	115	188	java/io/IOException
    //   86	90	192	java/io/IOException
    //   176	180	196	java/io/IOException
    //   164	172	200	java/io/IOException
    //   34	42	204	finally
    //   42	48	218	finally
    //   48	54	218	finally
    //   59	66	218	finally
    //   98	103	218	finally
    //   132	140	228	java/io/IOException
    //   34	42	232	java/io/IOException
    //   42	48	238	java/io/IOException
    //   48	54	238	java/io/IOException
    //   59	66	238	java/io/IOException
    //   98	103	238	java/io/IOException
    //   74	82	242	java/io/IOException
    //   25	34	246	java/io/FileNotFoundException
    //   34	42	254	java/io/FileNotFoundException
    //   103	111	260	java/io/IOException
  }
  
  /* Error */
  public static int d(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 352
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 48	java/io/File:exists	()Z
    //   14: ifne +11 -> 25
    //   17: ldc_w 352
    //   20: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_m1
    //   24: ireturn
    //   25: aconst_null
    //   26: astore 5
    //   28: aconst_null
    //   29: astore 4
    //   31: new 140	java/io/BufferedReader
    //   34: dup
    //   35: new 142	java/io/FileReader
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 145	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   43: invokespecial 148	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore_0
    //   47: iconst_0
    //   48: istore_2
    //   49: aload_0
    //   50: invokevirtual 151	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +33 -> 90
    //   60: aload 4
    //   62: aload_1
    //   63: invokevirtual 260	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   66: istore_3
    //   67: iload_3
    //   68: ifeq +15 -> 83
    //   71: aload_0
    //   72: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   75: ldc_w 352
    //   78: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iload_2
    //   82: ireturn
    //   83: iload_2
    //   84: iconst_1
    //   85: iadd
    //   86: istore_2
    //   87: goto -38 -> 49
    //   90: aload_0
    //   91: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   94: ldc_w 352
    //   97: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: iconst_m1
    //   101: ireturn
    //   102: astore_0
    //   103: aload 4
    //   105: astore_0
    //   106: aload_0
    //   107: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   110: goto -16 -> 94
    //   113: astore_0
    //   114: aload 5
    //   116: astore_0
    //   117: aload_0
    //   118: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   121: goto -27 -> 94
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_0
    //   128: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   131: ldc_w 352
    //   134: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: goto -13 -> 127
    //   143: astore_1
    //   144: goto -27 -> 117
    //   147: astore_1
    //   148: goto -42 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramFile	File
    //   0	151	1	paramString	String
    //   48	39	2	i	int
    //   66	2	3	bool	boolean
    //   29	75	4	str	String
    //   26	89	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   31	47	102	java/io/FileNotFoundException
    //   31	47	113	java/io/IOException
    //   31	47	124	finally
    //   49	55	139	finally
    //   60	67	139	finally
    //   49	55	143	java/io/IOException
    //   60	67	143	java/io/IOException
    //   49	55	147	java/io/FileNotFoundException
    //   60	67	147	java/io/FileNotFoundException
  }
  
  /* Error */
  public static java.util.List<String> d(File paramFile)
  {
    // Byte code:
    //   0: ldc_w 354
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 48	java/io/File:exists	()Z
    //   14: ifne +11 -> 25
    //   17: ldc_w 354
    //   20: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: new 140	java/io/BufferedReader
    //   28: dup
    //   29: new 142	java/io/FileReader
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 145	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   37: invokespecial 148	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_0
    //   41: new 356	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 357	java/util/ArrayList:<init>	()V
    //   48: astore_1
    //   49: aload_0
    //   50: invokevirtual 151	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +27 -> 82
    //   58: aload_1
    //   59: aload_2
    //   60: invokeinterface 363 2 0
    //   65: pop
    //   66: goto -17 -> 49
    //   69: astore_1
    //   70: aload_0
    //   71: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   74: ldc_w 354
    //   77: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aconst_null
    //   81: areturn
    //   82: aload_0
    //   83: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   86: ldc_w 354
    //   89: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: areturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_0
    //   97: aload_0
    //   98: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   101: goto -27 -> 74
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_0
    //   107: aload_0
    //   108: invokestatic 156	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   111: ldc_w 354
    //   114: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: goto -13 -> 107
    //   123: astore_1
    //   124: goto -27 -> 97
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_0
    //   130: goto -60 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramFile	File
    //   48	11	1	localArrayList	java.util.ArrayList
    //   69	24	1	localFileNotFoundException	java.io.FileNotFoundException
    //   104	14	1	localObject1	Object
    //   119	1	1	localObject2	Object
    //   123	1	1	localIOException	IOException
    //   53	7	2	str	String
    // Exception table:
    //   from	to	target	type
    //   41	49	69	java/io/FileNotFoundException
    //   49	54	69	java/io/FileNotFoundException
    //   58	66	69	java/io/FileNotFoundException
    //   25	41	94	java/io/IOException
    //   25	41	104	finally
    //   41	49	119	finally
    //   49	54	119	finally
    //   58	66	119	finally
    //   41	49	123	java/io/IOException
    //   49	54	123	java/io/IOException
    //   58	66	123	java/io/IOException
    //   25	41	127	java/io/FileNotFoundException
  }
  
  public static File e(File paramFile)
  {
    AppMethodBeat.i(225165);
    if (paramFile != null)
    {
      paramFile = b(paramFile.getParentFile(), f.a(new StringBuilder().append(System.currentTimeMillis()).toString()) + ".tmp");
      AppMethodBeat.o(225165);
      return paramFile;
    }
    AppMethodBeat.o(225165);
    return null;
  }
  
  public static File[] e(File paramFile, String paramString)
  {
    AppMethodBeat.i(225288);
    paramString = new ka.1(paramString);
    if ((paramFile != null) && (paramFile.isDirectory()))
    {
      paramFile = paramFile.listFiles(paramString);
      AppMethodBeat.o(225288);
      return paramFile;
    }
    AppMethodBeat.o(225288);
    return new File[0];
  }
  
  public static long f(File paramFile)
  {
    AppMethodBeat.i(225245);
    long l = a(paramFile, null);
    AppMethodBeat.o(225245);
    return l;
  }
  
  private static File g(File paramFile)
  {
    AppMethodBeat.i(224979);
    paramFile = a(paramFile.getParentFile(), paramFile.getName());
    AppMethodBeat.o(224979);
    return paramFile;
  }
  
  private static boolean h(File paramFile)
  {
    AppMethodBeat.i(225045);
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()))
    {
      boolean bool = paramFile.delete();
      AppMethodBeat.o(225045);
      return bool;
    }
    AppMethodBeat.o(225045);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ka
 * JD-Core Version:    0.7.0.1
 */