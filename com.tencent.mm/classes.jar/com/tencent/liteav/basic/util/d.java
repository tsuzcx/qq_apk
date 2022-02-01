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

public class d
{
  public static long a(File paramFile)
  {
    AppMethodBeat.i(230106);
    long l = a(paramFile, 5);
    AppMethodBeat.o(230106);
    return l;
  }
  
  public static long a(File paramFile, int paramInt)
  {
    long l1 = 0L;
    AppMethodBeat.i(230114);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(230114);
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
        AppMethodBeat.o(230114);
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
    //   31: invokestatic 83	com/tencent/liteav/basic/util/d:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   34: aload_0
    //   35: invokestatic 86	com/tencent/liteav/basic/util/d:a	(Ljava/io/Closeable;)V
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
    //   79: invokestatic 86	com/tencent/liteav/basic/util/d:a	(Ljava/io/Closeable;)V
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
    //   113: invokestatic 86	com/tencent/liteav/basic/util/d:a	(Ljava/io/Closeable;)V
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
    AppMethodBeat.i(230201);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(230201);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(230201);
    }
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(230136);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(230136);
  }
  
  /* Error */
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 118
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 79	java/io/FileOutputStream
    //   8: dup
    //   9: new 25	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 122	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   20: astore_0
    //   21: new 124	java/io/BufferedOutputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 127	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: astore 5
    //   31: aload_0
    //   32: astore_3
    //   33: aload 5
    //   35: astore_2
    //   36: aload 5
    //   38: aload_1
    //   39: invokevirtual 130	java/io/BufferedOutputStream:write	([B)V
    //   42: aload 5
    //   44: invokevirtual 131	java/io/BufferedOutputStream:close	()V
    //   47: aload_0
    //   48: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   51: ldc 118
    //   53: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: return
    //   57: astore_0
    //   58: ldc 118
    //   60: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: return
    //   64: astore_1
    //   65: aconst_null
    //   66: astore 4
    //   68: aconst_null
    //   69: astore_0
    //   70: aload 4
    //   72: astore_3
    //   73: aload_0
    //   74: astore_2
    //   75: ldc 39
    //   77: ldc 134
    //   79: aload_1
    //   80: invokestatic 101	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 131	java/io/BufferedOutputStream:close	()V
    //   91: aload 4
    //   93: ifnull +8 -> 101
    //   96: aload 4
    //   98: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   101: ldc 118
    //   103: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: astore_0
    //   108: ldc 118
    //   110: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_2
    //   119: aload_2
    //   120: ifnull +7 -> 127
    //   123: aload_2
    //   124: invokevirtual 131	java/io/BufferedOutputStream:close	()V
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   135: ldc 118
    //   137: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_1
    //   141: athrow
    //   142: astore_0
    //   143: goto -8 -> 135
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_2
    //   149: goto -30 -> 119
    //   152: astore_1
    //   153: aload_3
    //   154: astore_0
    //   155: goto -36 -> 119
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_0
    //   162: astore 4
    //   164: aload_2
    //   165: astore_0
    //   166: goto -96 -> 70
    //   169: astore_1
    //   170: aload_0
    //   171: astore 4
    //   173: aload 5
    //   175: astore_0
    //   176: goto -106 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramString	String
    //   0	179	1	paramArrayOfByte	byte[]
    //   35	130	2	localObject1	Object
    //   32	122	3	localObject2	Object
    //   66	106	4	str	String
    //   29	145	5	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   42	51	57	java/lang/Exception
    //   5	21	64	java/lang/Exception
    //   87	91	107	java/lang/Exception
    //   96	101	107	java/lang/Exception
    //   5	21	114	finally
    //   123	127	142	java/lang/Exception
    //   131	135	142	java/lang/Exception
    //   21	31	146	finally
    //   36	42	152	finally
    //   75	83	152	finally
    //   21	31	158	java/lang/Exception
    //   36	42	169	java/lang/Exception
  }
  
  public static boolean a(long paramLong)
  {
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(14746);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(14746);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnectedOrConnecting()))
    {
      AppMethodBeat.o(14746);
      return true;
    }
    AppMethodBeat.o(14746);
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(230179);
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
          AppMethodBeat.o(230179);
          return true;
        }
        i += 1;
      }
      TXCLog.i("isAssetFileExists", paramString + " not exist");
    }
    catch (IOException paramContext)
    {
      TXCLog.i("isAssetFileExists", paramString + " not exist");
      AppMethodBeat.o(230179);
      return false;
    }
    AppMethodBeat.o(230179);
    return false;
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(14759);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(14759);
      return false;
    }
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      AppMethodBeat.o(14759);
      return true;
    }
    AppMethodBeat.o(14759);
    return false;
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 194
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_0
    //   10: invokevirtual 71	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_1
    //   14: invokevirtual 77	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_0
    //   18: aload_0
    //   19: astore_2
    //   20: aload_0
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 198	java/io/InputStream:available	()I
    //   26: newarray byte
    //   28: astore_1
    //   29: aload_0
    //   30: astore_2
    //   31: aload_0
    //   32: astore_3
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 112	java/io/InputStream:read	([B)I
    //   38: ifgt +19 -> 57
    //   41: aload_0
    //   42: ifnull +7 -> 49
    //   45: aload_0
    //   46: invokevirtual 199	java/io/InputStream:close	()V
    //   49: ldc 194
    //   51: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: ldc 157
    //   56: areturn
    //   57: aload_0
    //   58: astore_2
    //   59: aload_0
    //   60: astore_3
    //   61: aload_0
    //   62: invokevirtual 199	java/io/InputStream:close	()V
    //   65: aload_0
    //   66: astore_2
    //   67: aload_0
    //   68: astore_3
    //   69: new 163	java/lang/String
    //   72: dup
    //   73: aload_1
    //   74: ldc 201
    //   76: invokespecial 204	java/lang/String:<init>	([BLjava/lang/String;)V
    //   79: astore_1
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 199	java/io/InputStream:close	()V
    //   88: ldc 194
    //   90: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: areturn
    //   95: astore_0
    //   96: aload_2
    //   97: astore_3
    //   98: ldc 39
    //   100: ldc 206
    //   102: aload_0
    //   103: invokestatic 101	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 199	java/io/InputStream:close	()V
    //   114: ldc 194
    //   116: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: ldc 157
    //   121: areturn
    //   122: astore_0
    //   123: aload_3
    //   124: ifnull +7 -> 131
    //   127: aload_3
    //   128: invokevirtual 199	java/io/InputStream:close	()V
    //   131: ldc 194
    //   133: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_0
    //   137: athrow
    //   138: astore_0
    //   139: goto -90 -> 49
    //   142: astore_0
    //   143: goto -55 -> 88
    //   146: astore_0
    //   147: goto -33 -> 114
    //   150: astore_1
    //   151: goto -20 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramContext	Context
    //   0	154	1	paramString	String
    //   8	103	2	localContext	Context
    //   6	122	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	95	java/io/IOException
    //   22	29	95	java/io/IOException
    //   33	41	95	java/io/IOException
    //   61	65	95	java/io/IOException
    //   69	80	95	java/io/IOException
    //   9	18	122	finally
    //   22	29	122	finally
    //   33	41	122	finally
    //   61	65	122	finally
    //   69	80	122	finally
    //   98	106	122	finally
    //   45	49	138	java/io/IOException
    //   84	88	142	java/io/IOException
    //   110	114	146	java/io/IOException
    //   127	131	150	java/io/IOException
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: ldc 208
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 25	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 41	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 157
    //   20: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_0
    //   25: invokevirtual 191	java/io/File:isFile	()Z
    //   28: ifne +10 -> 38
    //   31: ldc 208
    //   33: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aconst_null
    //   37: areturn
    //   38: new 210	java/io/BufferedReader
    //   41: dup
    //   42: new 212	java/io/InputStreamReader
    //   45: dup
    //   46: new 214	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 215	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 218	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: invokespecial 221	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: invokevirtual 224	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore_3
    //   68: aload_3
    //   69: ifnull +55 -> 124
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: aload_3
    //   76: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: goto -19 -> 61
    //   83: astore_2
    //   84: aload_1
    //   85: astore_0
    //   86: new 226	java/lang/RuntimeException
    //   89: dup
    //   90: ldc 228
    //   92: aload_2
    //   93: invokespecial 231	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: astore_2
    //   97: aload_1
    //   98: astore_0
    //   99: ldc 208
    //   101: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_1
    //   105: astore_0
    //   106: aload_2
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 232	java/io/BufferedReader:close	()V
    //   117: ldc 208
    //   119: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_1
    //   123: athrow
    //   124: aload_1
    //   125: astore_0
    //   126: aload_1
    //   127: invokevirtual 232	java/io/BufferedReader:close	()V
    //   130: aload_1
    //   131: astore_0
    //   132: aload_2
    //   133: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore_2
    //   137: aload_1
    //   138: invokevirtual 232	java/io/BufferedReader:close	()V
    //   141: ldc 208
    //   143: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_2
    //   147: areturn
    //   148: astore_0
    //   149: new 226	java/lang/RuntimeException
    //   152: dup
    //   153: ldc 228
    //   155: aload_0
    //   156: invokespecial 231	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   159: astore_0
    //   160: ldc 208
    //   162: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload_0
    //   166: athrow
    //   167: astore_0
    //   168: new 226	java/lang/RuntimeException
    //   171: dup
    //   172: ldc 228
    //   174: aload_0
    //   175: invokespecial 231	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   178: astore_0
    //   179: ldc 208
    //   181: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_0
    //   185: athrow
    //   186: astore_1
    //   187: aconst_null
    //   188: astore_0
    //   189: goto -80 -> 109
    //   192: astore_2
    //   193: aconst_null
    //   194: astore_1
    //   195: goto -111 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramString	String
    //   60	45	1	localBufferedReader	java.io.BufferedReader
    //   108	30	1	localObject1	Object
    //   186	1	1	localObject2	Object
    //   194	1	1	localObject3	Object
    //   23	52	2	localStringBuilder	java.lang.StringBuilder
    //   83	10	2	localIOException1	IOException
    //   96	51	2	localObject4	Object
    //   192	1	2	localIOException2	IOException
    //   67	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   63	68	83	java/io/IOException
    //   74	80	83	java/io/IOException
    //   126	130	83	java/io/IOException
    //   132	137	83	java/io/IOException
    //   63	68	108	finally
    //   74	80	108	finally
    //   86	97	108	finally
    //   99	104	108	finally
    //   106	108	108	finally
    //   126	130	108	finally
    //   132	137	108	finally
    //   137	141	148	java/io/IOException
    //   113	117	167	java/io/IOException
    //   38	61	186	finally
    //   38	61	192	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.util.d
 * JD-Core Version:    0.7.0.1
 */