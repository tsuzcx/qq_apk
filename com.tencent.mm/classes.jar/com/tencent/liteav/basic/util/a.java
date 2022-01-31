package com.tencent.liteav.basic.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public class a
{
  @TargetApi(18)
  public static long a(StatFs paramStatFs)
  {
    AppMethodBeat.i(66031);
    if (Build.VERSION.SDK_INT >= 18) {}
    for (long l = paramStatFs.getAvailableBytes();; l = paramStatFs.getAvailableBlocks() * paramStatFs.getBlockSize())
    {
      AppMethodBeat.o(66031);
      return l;
    }
  }
  
  /* Error */
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 46	java/io/FileOutputStream
    //   8: dup
    //   9: new 48	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   20: astore_0
    //   21: new 57	java/io/BufferedOutputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 60	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: astore_2
    //   30: aload_2
    //   31: aload_1
    //   32: invokevirtual 64	java/io/BufferedOutputStream:write	([B)V
    //   35: aload_2
    //   36: invokevirtual 68	java/io/BufferedOutputStream:close	()V
    //   39: aload_0
    //   40: invokevirtual 69	java/io/FileOutputStream:close	()V
    //   43: ldc 44
    //   45: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: return
    //   49: astore_0
    //   50: ldc 44
    //   52: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: astore_0
    //   57: aconst_null
    //   58: astore_1
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +7 -> 69
    //   65: aload_0
    //   66: invokevirtual 68	java/io/BufferedOutputStream:close	()V
    //   69: aload_1
    //   70: ifnull +7 -> 77
    //   73: aload_1
    //   74: invokevirtual 69	java/io/FileOutputStream:close	()V
    //   77: ldc 44
    //   79: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: return
    //   83: astore_0
    //   84: ldc 44
    //   86: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: return
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 68	java/io/BufferedOutputStream:close	()V
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 69	java/io/FileOutputStream:close	()V
    //   111: ldc 44
    //   113: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_0
    //   117: athrow
    //   118: astore_1
    //   119: goto -8 -> 111
    //   122: astore_1
    //   123: aload_0
    //   124: astore_2
    //   125: aconst_null
    //   126: astore_3
    //   127: aload_1
    //   128: astore_0
    //   129: aload_2
    //   130: astore_1
    //   131: aload_3
    //   132: astore_2
    //   133: goto -38 -> 95
    //   136: astore_1
    //   137: aload_0
    //   138: astore_3
    //   139: aload_1
    //   140: astore_0
    //   141: aload_3
    //   142: astore_1
    //   143: goto -48 -> 95
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_2
    //   149: aload_0
    //   150: astore_1
    //   151: aload_2
    //   152: astore_0
    //   153: goto -92 -> 61
    //   156: astore_1
    //   157: aload_0
    //   158: astore_1
    //   159: aload_2
    //   160: astore_0
    //   161: goto -100 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   0	164	1	paramArrayOfByte	byte[]
    //   29	131	2	localObject	Object
    //   126	16	3	str	String
    // Exception table:
    //   from	to	target	type
    //   35	43	49	java/lang/Exception
    //   5	21	56	java/lang/Exception
    //   65	69	83	java/lang/Exception
    //   73	77	83	java/lang/Exception
    //   5	21	90	finally
    //   99	103	118	java/lang/Exception
    //   107	111	118	java/lang/Exception
    //   21	30	122	finally
    //   30	35	136	finally
    //   21	30	146	java/lang/Exception
    //   30	35	156	java/lang/Exception
  }
  
  public static boolean a(long paramLong)
  {
    AppMethodBeat.i(66032);
    if (a(new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath())) > paramLong)
    {
      AppMethodBeat.o(66032);
      return true;
    }
    AppMethodBeat.o(66032);
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(66030);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(66030);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnectedOrConnecting()))
    {
      AppMethodBeat.o(66030);
      return true;
    }
    AppMethodBeat.o(66030);
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(66036);
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
          AppMethodBeat.o(66036);
          return true;
        }
        i += 1;
      }
      TXCLog.i("isAssetFileExists", paramString + " not exist");
    }
    catch (IOException paramContext)
    {
      TXCLog.i("isAssetFileExists", paramString + " not exist");
      AppMethodBeat.o(66036);
      return false;
    }
    AppMethodBeat.o(66036);
    return false;
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(66033);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66033);
      return false;
    }
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      AppMethodBeat.o(66033);
      return true;
    }
    AppMethodBeat.o(66033);
    return false;
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 170
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: invokevirtual 114	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   11: aload_1
    //   12: invokevirtual 174	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 179	java/io/InputStream:available	()I
    //   20: newarray byte
    //   22: astore_1
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 183	java/io/InputStream:read	([B)I
    //   28: ifgt +19 -> 47
    //   31: aload_0
    //   32: ifnull +7 -> 39
    //   35: aload_0
    //   36: invokevirtual 184	java/io/InputStream:close	()V
    //   39: ldc 170
    //   41: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: ldc 116
    //   46: areturn
    //   47: aload_0
    //   48: invokevirtual 184	java/io/InputStream:close	()V
    //   51: new 124	java/lang/String
    //   54: dup
    //   55: aload_1
    //   56: ldc 186
    //   58: invokespecial 189	java/lang/String:<init>	([BLjava/lang/String;)V
    //   61: astore_1
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 184	java/io/InputStream:close	()V
    //   70: ldc 170
    //   72: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: areturn
    //   77: astore_0
    //   78: aload_2
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 184	java/io/InputStream:close	()V
    //   88: ldc 170
    //   90: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: ldc 116
    //   95: areturn
    //   96: astore_0
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 184	java/io/InputStream:close	()V
    //   107: ldc 170
    //   109: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: goto -76 -> 39
    //   118: astore_0
    //   119: goto -49 -> 70
    //   122: astore_0
    //   123: goto -35 -> 88
    //   126: astore_1
    //   127: goto -20 -> 107
    //   130: astore_1
    //   131: aload_0
    //   132: astore_2
    //   133: aload_1
    //   134: astore_0
    //   135: aload_2
    //   136: astore_1
    //   137: goto -38 -> 99
    //   140: astore_1
    //   141: goto -61 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContext	Context
    //   0	144	1	paramString	String
    //   6	130	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   7	16	77	java/io/IOException
    //   7	16	96	finally
    //   35	39	114	java/io/IOException
    //   66	70	118	java/io/IOException
    //   84	88	122	java/io/IOException
    //   103	107	126	java/io/IOException
    //   16	31	130	finally
    //   47	62	130	finally
    //   16	31	140	java/io/IOException
    //   47	62	140	java/io/IOException
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 48	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 135	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 116
    //   20: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_0
    //   25: invokevirtual 167	java/io/File:isFile	()Z
    //   28: ifne +10 -> 38
    //   31: ldc 191
    //   33: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aconst_null
    //   37: areturn
    //   38: new 194	java/io/BufferedReader
    //   41: dup
    //   42: new 196	java/io/InputStreamReader
    //   45: dup
    //   46: new 198	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 199	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 202	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: invokespecial 205	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: invokevirtual 208	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore_3
    //   68: aload_3
    //   69: ifnull +55 -> 124
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: aload_3
    //   76: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: goto -19 -> 61
    //   83: astore_2
    //   84: aload_1
    //   85: astore_0
    //   86: new 210	java/lang/RuntimeException
    //   89: dup
    //   90: ldc 212
    //   92: aload_2
    //   93: invokespecial 215	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: astore_2
    //   97: aload_1
    //   98: astore_0
    //   99: ldc 191
    //   101: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_1
    //   105: astore_0
    //   106: aload_2
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 216	java/io/BufferedReader:close	()V
    //   117: ldc 191
    //   119: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_1
    //   123: athrow
    //   124: aload_1
    //   125: astore_0
    //   126: aload_1
    //   127: invokevirtual 216	java/io/BufferedReader:close	()V
    //   130: aload_1
    //   131: astore_0
    //   132: aload_2
    //   133: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore_2
    //   137: aload_1
    //   138: invokevirtual 216	java/io/BufferedReader:close	()V
    //   141: ldc 191
    //   143: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_2
    //   147: areturn
    //   148: astore_0
    //   149: new 210	java/lang/RuntimeException
    //   152: dup
    //   153: ldc 212
    //   155: aload_0
    //   156: invokespecial 215	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   159: astore_0
    //   160: ldc 191
    //   162: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload_0
    //   166: athrow
    //   167: astore_0
    //   168: new 210	java/lang/RuntimeException
    //   171: dup
    //   172: ldc 212
    //   174: aload_0
    //   175: invokespecial 215	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   178: astore_0
    //   179: ldc 191
    //   181: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
 * Qualified Name:     com.tencent.liteav.basic.util.a
 * JD-Core Version:    0.7.0.1
 */