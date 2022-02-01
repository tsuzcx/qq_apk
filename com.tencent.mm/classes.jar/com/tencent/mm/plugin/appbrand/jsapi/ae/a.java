package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;

public final class a
{
  public static String[] a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(205469);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      if ((paramArrayOfString1[i] != null) && (paramArrayOfString2[i] != null) && (!paramArrayOfString1[i].equals(paramArrayOfString2[i]))) {
        localArrayList.add(paramArrayOfString1[i]);
      }
      i += 1;
    }
    paramArrayOfString1 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(205469);
    return paramArrayOfString1;
  }
  
  private static String ajp(String paramString)
  {
    AppMethodBeat.i(205471);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(205471);
      return "";
    }
    paramString = ajr(ajq(paramString));
    AppMethodBeat.o(205471);
    return paramString;
  }
  
  private static String ajq(String paramString)
  {
    AppMethodBeat.i(205472);
    paramString = paramString.substring(paramString.indexOf("base64,") + 7).trim();
    AppMethodBeat.o(205472);
    return paramString;
  }
  
  /* Error */
  private static String ajr(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 79
    //   4: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: iconst_0
    //   9: invokestatic 85	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +8 -> 22
    //   17: aload_1
    //   18: arraylength
    //   19: ifne +29 -> 48
    //   22: ldc 79
    //   24: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 53
    //   29: areturn
    //   30: astore_1
    //   31: ldc 53
    //   33: aload_1
    //   34: ldc 87
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aconst_null
    //   44: astore_1
    //   45: goto -32 -> 13
    //   48: new 95	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 97
    //   54: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   60: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: ldc 112
    //   65: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: invokevirtual 118	java/lang/String:hashCode	()I
    //   72: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_0
    //   79: new 126	com/tencent/mm/vfs/q
    //   82: dup
    //   83: invokestatic 132	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   86: invokevirtual 138	android/content/Context:getCacheDir	()Ljava/io/File;
    //   89: aload_0
    //   90: invokespecial 141	com/tencent/mm/vfs/q:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokestatic 147	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   98: astore_0
    //   99: aload_0
    //   100: astore_2
    //   101: aload_0
    //   102: aload_1
    //   103: invokevirtual 153	java/io/OutputStream:write	([B)V
    //   106: aload_0
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 156	java/io/OutputStream:close	()V
    //   114: aload_3
    //   115: invokevirtual 159	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   118: astore_0
    //   119: ldc 79
    //   121: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_0
    //   125: areturn
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_0
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 156	java/io/OutputStream:close	()V
    //   137: ldc 79
    //   139: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: ldc 53
    //   144: areturn
    //   145: astore_0
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 156	java/io/OutputStream:close	()V
    //   154: ldc 79
    //   156: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_0
    //   160: athrow
    //   161: astore_0
    //   162: goto -48 -> 114
    //   165: astore_0
    //   166: goto -29 -> 137
    //   169: astore_1
    //   170: goto -16 -> 154
    //   173: astore_1
    //   174: goto -45 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString	String
    //   12	6	1	arrayOfByte1	byte[]
    //   30	4	1	localException1	Exception
    //   44	59	1	arrayOfByte2	byte[]
    //   169	1	1	localIOException	java.io.IOException
    //   173	1	1	localException2	Exception
    //   1	150	2	str	String
    //   93	22	3	localq	com.tencent.mm.vfs.q
    // Exception table:
    //   from	to	target	type
    //   7	13	30	java/lang/Exception
    //   94	99	126	java/lang/Exception
    //   94	99	145	finally
    //   101	106	145	finally
    //   110	114	161	java/io/IOException
    //   133	137	165	java/io/IOException
    //   150	154	169	java/io/IOException
    //   101	106	173	java/lang/Exception
  }
  
  public static String[] p(String[] paramArrayOfString)
  {
    AppMethodBeat.i(205467);
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      if ((paramArrayOfString[i] != null) && (paramArrayOfString[i].startsWith("data:image/"))) {
        arrayOfString[i] = ajp(paramArrayOfString[i]);
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfString[i] = paramArrayOfString[i];
      }
    }
    AppMethodBeat.o(205467);
    return arrayOfString;
  }
  
  public static void q(String[] paramArrayOfString)
  {
    AppMethodBeat.i(205470);
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfString.length) {}
      try
      {
        u.deleteFile(paramArrayOfString[i]);
        label20:
        i += 1;
        continue;
        AppMethodBeat.o(205470);
        return;
      }
      catch (Exception localException)
      {
        break label20;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.a
 * JD-Core Version:    0.7.0.1
 */