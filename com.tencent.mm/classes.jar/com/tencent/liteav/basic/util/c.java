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

public class c
{
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
  
  /* Error */
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 14716
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 29	java/io/FileOutputStream
    //   9: dup
    //   10: new 31	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 38	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: astore_0
    //   22: new 40	java/io/BufferedOutputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 43	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore_2
    //   31: aload_2
    //   32: aload_1
    //   33: invokevirtual 47	java/io/BufferedOutputStream:write	([B)V
    //   36: aload_2
    //   37: invokevirtual 48	java/io/BufferedOutputStream:close	()V
    //   40: aload_0
    //   41: invokevirtual 49	java/io/FileOutputStream:close	()V
    //   44: sipush 14716
    //   47: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: return
    //   51: astore_0
    //   52: sipush 14716
    //   55: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 48	java/io/BufferedOutputStream:close	()V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 49	java/io/FileOutputStream:close	()V
    //   80: sipush 14716
    //   83: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: return
    //   87: astore_0
    //   88: sipush 14716
    //   91: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_2
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 48	java/io/BufferedOutputStream:close	()V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 49	java/io/FileOutputStream:close	()V
    //   116: sipush 14716
    //   119: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_0
    //   123: athrow
    //   124: astore_1
    //   125: goto -9 -> 116
    //   128: astore_1
    //   129: aload_0
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_3
    //   133: aload_1
    //   134: astore_0
    //   135: aload_2
    //   136: astore_1
    //   137: aload_3
    //   138: astore_2
    //   139: goto -39 -> 100
    //   142: astore_1
    //   143: aload_0
    //   144: astore_3
    //   145: aload_1
    //   146: astore_0
    //   147: aload_3
    //   148: astore_1
    //   149: goto -49 -> 100
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_2
    //   155: aload_0
    //   156: astore_1
    //   157: aload_2
    //   158: astore_0
    //   159: goto -95 -> 64
    //   162: astore_1
    //   163: aload_0
    //   164: astore_1
    //   165: aload_2
    //   166: astore_0
    //   167: goto -103 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramString	String
    //   0	170	1	paramArrayOfByte	byte[]
    //   30	136	2	localObject	Object
    //   132	16	3	str	String
    // Exception table:
    //   from	to	target	type
    //   36	44	51	java/lang/Exception
    //   6	22	59	java/lang/Exception
    //   68	72	87	java/lang/Exception
    //   76	80	87	java/lang/Exception
    //   6	22	95	finally
    //   104	108	124	java/lang/Exception
    //   112	116	124	java/lang/Exception
    //   22	31	128	finally
    //   31	36	142	finally
    //   22	31	152	java/lang/Exception
    //   31	36	162	java/lang/Exception
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
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 76	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: aload_1
    //   13: invokevirtual 135	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore_0
    //   17: aload_0
    //   18: invokevirtual 141	java/io/InputStream:available	()I
    //   21: newarray byte
    //   23: astore_1
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 145	java/io/InputStream:read	([B)I
    //   29: ifgt +20 -> 49
    //   32: aload_0
    //   33: ifnull +7 -> 40
    //   36: aload_0
    //   37: invokevirtual 146	java/io/InputStream:close	()V
    //   40: sipush 14718
    //   43: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: ldc 78
    //   48: areturn
    //   49: aload_0
    //   50: invokevirtual 146	java/io/InputStream:close	()V
    //   53: new 86	java/lang/String
    //   56: dup
    //   57: aload_1
    //   58: ldc 148
    //   60: invokespecial 151	java/lang/String:<init>	([BLjava/lang/String;)V
    //   63: astore_1
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 146	java/io/InputStream:close	()V
    //   72: sipush 14718
    //   75: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_1
    //   79: areturn
    //   80: astore_0
    //   81: aload_2
    //   82: astore_0
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 146	java/io/InputStream:close	()V
    //   91: sipush 14718
    //   94: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: ldc 78
    //   99: areturn
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 146	java/io/InputStream:close	()V
    //   111: sipush 14718
    //   114: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: athrow
    //   119: astore_0
    //   120: goto -80 -> 40
    //   123: astore_0
    //   124: goto -52 -> 72
    //   127: astore_0
    //   128: goto -37 -> 91
    //   131: astore_1
    //   132: goto -21 -> 111
    //   135: astore_1
    //   136: aload_0
    //   137: astore_2
    //   138: aload_1
    //   139: astore_0
    //   140: aload_2
    //   141: astore_1
    //   142: goto -39 -> 103
    //   145: astore_1
    //   146: goto -63 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramContext	Context
    //   0	149	1	paramString	String
    //   7	134	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   8	17	80	java/io/IOException
    //   8	17	100	finally
    //   36	40	119	java/io/IOException
    //   68	72	123	java/io/IOException
    //   87	91	127	java/io/IOException
    //   107	111	131	java/io/IOException
    //   17	32	135	finally
    //   49	64	135	finally
    //   17	32	145	java/io/IOException
    //   49	64	145	java/io/IOException
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: sipush 14715
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 31	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 98	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 78
    //   21: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_0
    //   26: invokevirtual 129	java/io/File:isFile	()Z
    //   29: ifne +11 -> 40
    //   32: sipush 14715
    //   35: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aconst_null
    //   39: areturn
    //   40: new 155	java/io/BufferedReader
    //   43: dup
    //   44: new 157	java/io/InputStreamReader
    //   47: dup
    //   48: new 159	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: invokespecial 163	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   59: invokespecial 166	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_1
    //   63: aload_1
    //   64: astore_0
    //   65: aload_1
    //   66: invokevirtual 169	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +57 -> 128
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: aload_3
    //   78: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: goto -19 -> 63
    //   85: astore_2
    //   86: aload_1
    //   87: astore_0
    //   88: new 171	java/lang/RuntimeException
    //   91: dup
    //   92: ldc 173
    //   94: aload_2
    //   95: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: astore_2
    //   99: aload_1
    //   100: astore_0
    //   101: sipush 14715
    //   104: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: astore_0
    //   109: aload_2
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 177	java/io/BufferedReader:close	()V
    //   120: sipush 14715
    //   123: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: aload_1
    //   129: astore_0
    //   130: aload_1
    //   131: invokevirtual 177	java/io/BufferedReader:close	()V
    //   134: aload_1
    //   135: astore_0
    //   136: aload_2
    //   137: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore_2
    //   141: aload_1
    //   142: invokevirtual 177	java/io/BufferedReader:close	()V
    //   145: sipush 14715
    //   148: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_2
    //   152: areturn
    //   153: astore_0
    //   154: new 171	java/lang/RuntimeException
    //   157: dup
    //   158: ldc 173
    //   160: aload_0
    //   161: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: astore_0
    //   165: sipush 14715
    //   168: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_0
    //   172: athrow
    //   173: astore_0
    //   174: new 171	java/lang/RuntimeException
    //   177: dup
    //   178: ldc 173
    //   180: aload_0
    //   181: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: astore_0
    //   185: sipush 14715
    //   188: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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