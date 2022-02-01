package com.tencent.liteav.basic.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class c
{
  public static long a(File paramFile)
  {
    AppMethodBeat.i(222121);
    long l = a(paramFile, 5);
    AppMethodBeat.o(222121);
    return l;
  }
  
  public static long a(File paramFile, int paramInt)
  {
    long l1 = 0L;
    AppMethodBeat.i(222122);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(222122);
      return 0L;
    }
    long l2 = l1;
    for (;;)
    {
      int i;
      try
      {
        paramFile = paramFile.listFiles();
        l2 = l1;
        int j = paramFile.length;
        i = 0;
        l2 = l1;
        if (i < j)
        {
          File localFile = paramFile[i];
          l2 = l1;
          if (localFile.isDirectory())
          {
            l2 = l1;
            l1 += a(localFile, paramInt - 1);
          }
          else
          {
            l2 = l1;
            long l3 = localFile.length();
            l1 += l3;
          }
        }
      }
      catch (Exception paramFile)
      {
        TXCLog.i("FileUtil", "getFolderSize exception " + paramFile.toString());
        AppMethodBeat.o(222122);
        return l2;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 65
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 71	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   9: astore_0
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 77	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   15: astore_0
    //   16: new 79	java/io/FileOutputStream
    //   19: dup
    //   20: aload_2
    //   21: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: astore_3
    //   27: aload_0
    //   28: astore_2
    //   29: aload_0
    //   30: aload_1
    //   31: invokestatic 83	com/tencent/liteav/basic/util/c:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   34: aload_0
    //   35: invokestatic 86	com/tencent/liteav/basic/util/c:a	(Ljava/io/Closeable;)V
    //   38: aload_1
    //   39: invokevirtual 92	java/io/OutputStream:flush	()V
    //   42: aload_1
    //   43: invokevirtual 95	java/io/OutputStream:close	()V
    //   46: ldc 65
    //   48: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: return
    //   52: astore_0
    //   53: ldc 65
    //   55: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: astore 4
    //   61: aconst_null
    //   62: astore_1
    //   63: aconst_null
    //   64: astore_0
    //   65: aload_1
    //   66: astore_3
    //   67: aload_0
    //   68: astore_2
    //   69: ldc 39
    //   71: ldc 97
    //   73: aload 4
    //   75: invokestatic 101	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: aload_0
    //   79: invokestatic 86	com/tencent/liteav/basic/util/c:a	(Ljava/io/Closeable;)V
    //   82: aload_1
    //   83: ifnull +52 -> 135
    //   86: aload_1
    //   87: invokevirtual 92	java/io/OutputStream:flush	()V
    //   90: aload_1
    //   91: invokevirtual 95	java/io/OutputStream:close	()V
    //   94: ldc 65
    //   96: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: astore_0
    //   101: ldc 65
    //   103: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_0
    //   112: aload_0
    //   113: invokestatic 86	com/tencent/liteav/basic/util/c:a	(Ljava/io/Closeable;)V
    //   116: aload_3
    //   117: ifnull +11 -> 128
    //   120: aload_3
    //   121: invokevirtual 92	java/io/OutputStream:flush	()V
    //   124: aload_3
    //   125: invokevirtual 95	java/io/OutputStream:close	()V
    //   128: ldc 65
    //   130: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_1
    //   134: athrow
    //   135: ldc 65
    //   137: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: astore_0
    //   142: goto -14 -> 128
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_3
    //   148: goto -36 -> 112
    //   151: astore_1
    //   152: aload_2
    //   153: astore_0
    //   154: goto -42 -> 112
    //   157: astore 4
    //   159: aconst_null
    //   160: astore_1
    //   161: goto -96 -> 65
    //   164: astore 4
    //   166: goto -101 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramContext	Context
    //   0	169	1	paramString1	String
    //   0	169	2	paramString2	String
    //   26	122	3	str	String
    //   59	15	4	localIOException1	IOException
    //   157	1	4	localIOException2	IOException
    //   164	1	4	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   38	46	52	java/io/IOException
    //   10	16	59	java/io/IOException
    //   86	94	100	java/io/IOException
    //   10	16	107	finally
    //   120	128	141	java/io/IOException
    //   16	25	145	finally
    //   29	34	151	finally
    //   69	78	151	finally
    //   16	25	157	java/io/IOException
    //   29	34	164	java/io/IOException
  }
  
  public static void a(Closeable paramCloseable)
  {
    AppMethodBeat.i(14719);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(14719);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(14719);
    }
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(222124);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(222124);
  }
  
  /* Error */
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 14716
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 79	java/io/FileOutputStream
    //   9: dup
    //   10: new 25	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: astore_0
    //   22: new 122	java/io/BufferedOutputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 125	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore 5
    //   32: aload_0
    //   33: astore_3
    //   34: aload 5
    //   36: astore_2
    //   37: aload 5
    //   39: aload_1
    //   40: invokevirtual 128	java/io/BufferedOutputStream:write	([B)V
    //   43: aload 5
    //   45: invokevirtual 129	java/io/BufferedOutputStream:close	()V
    //   48: aload_0
    //   49: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   52: sipush 14716
    //   55: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: astore_0
    //   60: sipush 14716
    //   63: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: return
    //   67: astore_1
    //   68: aconst_null
    //   69: astore 4
    //   71: aconst_null
    //   72: astore_0
    //   73: aload 4
    //   75: astore_3
    //   76: aload_0
    //   77: astore_2
    //   78: ldc 39
    //   80: ldc 132
    //   82: aload_1
    //   83: invokestatic 101	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 129	java/io/BufferedOutputStream:close	()V
    //   94: aload 4
    //   96: ifnull +8 -> 104
    //   99: aload 4
    //   101: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   104: sipush 14716
    //   107: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: return
    //   111: astore_0
    //   112: sipush 14716
    //   115: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: return
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: ifnull +7 -> 132
    //   128: aload_2
    //   129: invokevirtual 129	java/io/BufferedOutputStream:close	()V
    //   132: aload_0
    //   133: ifnull +7 -> 140
    //   136: aload_0
    //   137: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   140: sipush 14716
    //   143: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_1
    //   147: athrow
    //   148: astore_0
    //   149: goto -9 -> 140
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_2
    //   155: goto -31 -> 124
    //   158: astore_1
    //   159: aload_3
    //   160: astore_0
    //   161: goto -37 -> 124
    //   164: astore_1
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_0
    //   168: astore 4
    //   170: aload_2
    //   171: astore_0
    //   172: goto -99 -> 73
    //   175: astore_1
    //   176: aload_0
    //   177: astore 4
    //   179: aload 5
    //   181: astore_0
    //   182: goto -109 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString	String
    //   0	185	1	paramArrayOfByte	byte[]
    //   36	135	2	localObject1	Object
    //   33	127	3	localObject2	Object
    //   69	109	4	str	String
    //   30	150	5	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   43	52	59	java/lang/Exception
    //   6	22	67	java/lang/Exception
    //   90	94	111	java/lang/Exception
    //   99	104	111	java/lang/Exception
    //   6	22	119	finally
    //   128	132	148	java/lang/Exception
    //   136	140	148	java/lang/Exception
    //   22	32	152	finally
    //   37	43	158	finally
    //   78	86	158	finally
    //   22	32	164	java/lang/Exception
    //   37	43	175	java/lang/Exception
  }
  
  public static boolean a(long paramLong)
  {
    AppMethodBeat.i(14713);
    AppMethodBeat.o(14713);
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(14711);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(14711);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnectedOrConnecting()))
    {
      AppMethodBeat.o(14711);
      return true;
    }
    AppMethodBeat.o(14711);
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(14717);
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.list("");
      int i = 0;
      while (i < paramContext.length)
      {
        if (paramContext[i].equals(paramString.trim()))
        {
          TXCLog.i("isAssetFileExists", paramString + " exist");
          AppMethodBeat.o(14717);
          return true;
        }
        i += 1;
      }
      TXCLog.i("isAssetFileExists", paramString + " not exist");
    }
    catch (IOException paramContext)
    {
      TXCLog.i("isAssetFileExists", paramString + " not exist");
      AppMethodBeat.o(14717);
      return false;
    }
    AppMethodBeat.o(14717);
    return false;
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(14714);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(14714);
      return false;
    }
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      AppMethodBeat.o(14714);
      return true;
    }
    AppMethodBeat.o(14714);
    return false;
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: sipush 14718
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual 71	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: aload_1
    //   15: invokevirtual 77	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_0
    //   19: aload_0
    //   20: astore_2
    //   21: aload_0
    //   22: astore_3
    //   23: aload_0
    //   24: invokevirtual 194	java/io/InputStream:available	()I
    //   27: newarray byte
    //   29: astore_1
    //   30: aload_0
    //   31: astore_2
    //   32: aload_0
    //   33: astore_3
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual 111	java/io/InputStream:read	([B)I
    //   39: ifgt +20 -> 59
    //   42: aload_0
    //   43: ifnull +7 -> 50
    //   46: aload_0
    //   47: invokevirtual 195	java/io/InputStream:close	()V
    //   50: sipush 14718
    //   53: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: ldc 154
    //   58: areturn
    //   59: aload_0
    //   60: astore_2
    //   61: aload_0
    //   62: astore_3
    //   63: aload_0
    //   64: invokevirtual 195	java/io/InputStream:close	()V
    //   67: aload_0
    //   68: astore_2
    //   69: aload_0
    //   70: astore_3
    //   71: new 160	java/lang/String
    //   74: dup
    //   75: aload_1
    //   76: ldc 197
    //   78: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   81: astore_1
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 195	java/io/InputStream:close	()V
    //   90: sipush 14718
    //   93: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: areturn
    //   98: astore_0
    //   99: aload_2
    //   100: astore_3
    //   101: ldc 39
    //   103: ldc 202
    //   105: aload_0
    //   106: invokestatic 101	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload_2
    //   110: ifnull +7 -> 117
    //   113: aload_2
    //   114: invokevirtual 195	java/io/InputStream:close	()V
    //   117: sipush 14718
    //   120: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: ldc 154
    //   125: areturn
    //   126: astore_0
    //   127: aload_3
    //   128: ifnull +7 -> 135
    //   131: aload_3
    //   132: invokevirtual 195	java/io/InputStream:close	()V
    //   135: sipush 14718
    //   138: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: athrow
    //   143: astore_0
    //   144: goto -94 -> 50
    //   147: astore_0
    //   148: goto -58 -> 90
    //   151: astore_0
    //   152: goto -35 -> 117
    //   155: astore_1
    //   156: goto -21 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramContext	Context
    //   0	159	1	paramString	String
    //   9	105	2	localContext	Context
    //   7	125	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	19	98	java/io/IOException
    //   23	30	98	java/io/IOException
    //   34	42	98	java/io/IOException
    //   63	67	98	java/io/IOException
    //   71	82	98	java/io/IOException
    //   10	19	126	finally
    //   23	30	126	finally
    //   34	42	126	finally
    //   63	67	126	finally
    //   71	82	126	finally
    //   101	109	126	finally
    //   46	50	143	java/io/IOException
    //   86	90	147	java/io/IOException
    //   113	117	151	java/io/IOException
    //   131	135	155	java/io/IOException
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: sipush 14715
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 25	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 41	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 154
    //   21: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_0
    //   26: invokevirtual 188	java/io/File:isFile	()Z
    //   29: ifne +11 -> 40
    //   32: sipush 14715
    //   35: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aconst_null
    //   39: areturn
    //   40: new 205	java/io/BufferedReader
    //   43: dup
    //   44: new 207	java/io/InputStreamReader
    //   47: dup
    //   48: new 209	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: invokespecial 213	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   59: invokespecial 216	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_1
    //   63: aload_1
    //   64: astore_0
    //   65: aload_1
    //   66: invokevirtual 219	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +57 -> 128
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: aload_3
    //   78: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: goto -19 -> 63
    //   85: astore_2
    //   86: aload_1
    //   87: astore_0
    //   88: new 221	java/lang/RuntimeException
    //   91: dup
    //   92: ldc 223
    //   94: aload_2
    //   95: invokespecial 226	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: astore_2
    //   99: aload_1
    //   100: astore_0
    //   101: sipush 14715
    //   104: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: astore_0
    //   109: aload_2
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 227	java/io/BufferedReader:close	()V
    //   120: sipush 14715
    //   123: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: aload_1
    //   129: astore_0
    //   130: aload_1
    //   131: invokevirtual 227	java/io/BufferedReader:close	()V
    //   134: aload_1
    //   135: astore_0
    //   136: aload_2
    //   137: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore_2
    //   141: aload_1
    //   142: invokevirtual 227	java/io/BufferedReader:close	()V
    //   145: sipush 14715
    //   148: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_2
    //   152: areturn
    //   153: astore_0
    //   154: new 221	java/lang/RuntimeException
    //   157: dup
    //   158: ldc 223
    //   160: aload_0
    //   161: invokespecial 226	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: astore_0
    //   165: sipush 14715
    //   168: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_0
    //   172: athrow
    //   173: astore_0
    //   174: new 221	java/lang/RuntimeException
    //   177: dup
    //   178: ldc 223
    //   180: aload_0
    //   181: invokespecial 226	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: astore_0
    //   185: sipush 14715
    //   188: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_0
    //   192: athrow
    //   193: astore_1
    //   194: aconst_null
    //   195: astore_0
    //   196: goto -84 -> 112
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_1
    //   202: goto -116 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramString	String
    //   62	46	1	localBufferedReader	java.io.BufferedReader
    //   111	31	1	localObject1	Object
    //   193	1	1	localObject2	Object
    //   201	1	1	localObject3	Object
    //   24	53	2	localStringBuilder	java.lang.StringBuilder
    //   85	10	2	localIOException1	IOException
    //   98	54	2	localObject4	Object
    //   199	1	2	localIOException2	IOException
    //   69	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   65	70	85	java/io/IOException
    //   76	82	85	java/io/IOException
    //   130	134	85	java/io/IOException
    //   136	141	85	java/io/IOException
    //   65	70	111	finally
    //   76	82	111	finally
    //   88	99	111	finally
    //   101	107	111	finally
    //   109	111	111	finally
    //   130	134	111	finally
    //   136	141	111	finally
    //   141	145	153	java/io/IOException
    //   116	120	173	java/io/IOException
    //   40	63	193	finally
    //   40	63	199	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.util.c
 * JD-Core Version:    0.7.0.1
 */