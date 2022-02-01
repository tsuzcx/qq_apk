package com.tencent.mm.plugin.appbrand.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;

public final class ah
{
  /* Error */
  public static String a(com.tencent.mm.plugin.appbrand.w paramw, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: ldc 11
    //   8: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_2
    //   12: invokestatic 23	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   15: astore 4
    //   17: new 25	java/io/BufferedInputStream
    //   20: dup
    //   21: invokestatic 31	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   24: invokevirtual 37	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   27: aload 4
    //   29: invokevirtual 43	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   32: invokespecial 47	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore 8
    //   37: aload 6
    //   39: astore_3
    //   40: aload 7
    //   42: astore_2
    //   43: aload 4
    //   45: invokevirtual 51	android/net/Uri:getPath	()Ljava/lang/String;
    //   48: invokestatic 57	org/apache/commons/b/c:bKZ	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 5
    //   53: aload 5
    //   55: astore 4
    //   57: aload 6
    //   59: astore_3
    //   60: aload 7
    //   62: astore_2
    //   63: aload 5
    //   65: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifeq +7 -> 75
    //   71: ldc 65
    //   73: astore 4
    //   75: aload 4
    //   77: astore 5
    //   79: aload 6
    //   81: astore_3
    //   82: aload 7
    //   84: astore_2
    //   85: aload 4
    //   87: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne +41 -> 131
    //   93: aload 4
    //   95: astore 5
    //   97: aload 6
    //   99: astore_3
    //   100: aload 7
    //   102: astore_2
    //   103: aload 4
    //   105: ldc 67
    //   107: invokevirtual 73	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   110: ifne +21 -> 131
    //   113: aload 6
    //   115: astore_3
    //   116: aload 7
    //   118: astore_2
    //   119: ldc 67
    //   121: aload 4
    //   123: invokestatic 77	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   126: invokevirtual 80	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore 5
    //   131: aload 6
    //   133: astore_3
    //   134: aload 7
    //   136: astore_2
    //   137: new 82	com/tencent/mm/vfs/u
    //   140: dup
    //   141: aload_1
    //   142: new 84	java/lang/StringBuilder
    //   145: dup
    //   146: ldc 86
    //   148: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   154: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   157: aload 5
    //   159: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokespecial 108	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: invokevirtual 112	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   171: invokestatic 118	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   174: astore 4
    //   176: aload 6
    //   178: astore_3
    //   179: aload 7
    //   181: astore_2
    //   182: new 82	com/tencent/mm/vfs/u
    //   185: dup
    //   186: aload 4
    //   188: invokespecial 119	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   191: astore_1
    //   192: aload 6
    //   194: astore_3
    //   195: aload 7
    //   197: astore_2
    //   198: aload_1
    //   199: invokevirtual 122	com/tencent/mm/vfs/u:jKO	()Ljava/lang/String;
    //   202: invokestatic 127	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   205: pop
    //   206: aload 6
    //   208: astore_3
    //   209: aload 7
    //   211: astore_2
    //   212: aload_1
    //   213: invokestatic 131	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   216: astore_1
    //   217: aload_1
    //   218: astore_3
    //   219: aload_1
    //   220: astore_2
    //   221: aload 8
    //   223: aload_1
    //   224: invokestatic 137	com/tencent/mm/b/e:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   227: pop2
    //   228: aload_1
    //   229: astore_3
    //   230: aload_1
    //   231: astore_2
    //   232: new 139	com/tencent/mm/plugin/appbrand/af/k
    //   235: dup
    //   236: invokespecial 142	com/tencent/mm/plugin/appbrand/af/k:<init>	()V
    //   239: astore 6
    //   241: aload_1
    //   242: astore_3
    //   243: aload_1
    //   244: astore_2
    //   245: aload_0
    //   246: invokevirtual 148	com/tencent/mm/plugin/appbrand/w:asx	()Lcom/tencent/mm/plugin/appbrand/jsapi/file/ax;
    //   249: new 82	com/tencent/mm/vfs/u
    //   252: dup
    //   253: aload 4
    //   255: invokespecial 119	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   258: aload 5
    //   260: iconst_1
    //   261: aload 6
    //   263: invokevirtual 153	com/tencent/mm/plugin/appbrand/jsapi/file/ax:a	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;ZLcom/tencent/mm/plugin/appbrand/af/k;)Lcom/tencent/mm/plugin/appbrand/appstorage/r;
    //   266: pop
    //   267: aload_1
    //   268: astore_3
    //   269: aload_1
    //   270: astore_2
    //   271: aload 6
    //   273: getfield 157	com/tencent/mm/plugin/appbrand/af/k:value	Ljava/lang/Object;
    //   276: checkcast 69	java/lang/String
    //   279: astore_0
    //   280: aload 8
    //   282: invokestatic 163	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   285: aload_1
    //   286: invokestatic 163	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   289: ldc 11
    //   291: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aload_0
    //   295: areturn
    //   296: astore_0
    //   297: ldc 168
    //   299: aload_0
    //   300: ldc 65
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: ldc 11
    //   311: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: ldc 65
    //   316: areturn
    //   317: astore_0
    //   318: aload 6
    //   320: astore_3
    //   321: aload 7
    //   323: astore_2
    //   324: ldc 168
    //   326: aload_0
    //   327: ldc 65
    //   329: iconst_0
    //   330: anewarray 4	java/lang/Object
    //   333: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: aload 8
    //   338: invokestatic 163	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   341: aconst_null
    //   342: invokestatic 163	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   345: ldc 11
    //   347: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: ldc 65
    //   352: areturn
    //   353: astore_0
    //   354: aload_3
    //   355: astore_2
    //   356: ldc 168
    //   358: aload_0
    //   359: ldc 65
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: aload 8
    //   370: invokestatic 163	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   373: aload_3
    //   374: invokestatic 163	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   377: ldc 11
    //   379: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: ldc 65
    //   384: areturn
    //   385: astore_0
    //   386: aload 8
    //   388: invokestatic 163	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   391: aload_2
    //   392: invokestatic 163	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   395: ldc 11
    //   397: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: aload_0
    //   401: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	paramw	com.tencent.mm.plugin.appbrand.w
    //   0	402	1	paramString1	String
    //   0	402	2	paramString2	String
    //   39	335	3	localObject1	Object
    //   15	239	4	localObject2	Object
    //   51	208	5	localObject3	Object
    //   4	315	6	localk	com.tencent.mm.plugin.appbrand.af.k
    //   1	321	7	localObject4	Object
    //   35	352	8	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   17	37	296	java/lang/Exception
    //   212	217	317	java/io/FileNotFoundException
    //   43	53	353	java/lang/Exception
    //   63	71	353	java/lang/Exception
    //   85	93	353	java/lang/Exception
    //   103	113	353	java/lang/Exception
    //   119	131	353	java/lang/Exception
    //   137	176	353	java/lang/Exception
    //   182	192	353	java/lang/Exception
    //   198	206	353	java/lang/Exception
    //   212	217	353	java/lang/Exception
    //   221	228	353	java/lang/Exception
    //   232	241	353	java/lang/Exception
    //   245	267	353	java/lang/Exception
    //   271	280	353	java/lang/Exception
    //   324	336	353	java/lang/Exception
    //   43	53	385	finally
    //   63	71	385	finally
    //   85	93	385	finally
    //   103	113	385	finally
    //   119	131	385	finally
    //   137	176	385	finally
    //   182	192	385	finally
    //   198	206	385	finally
    //   212	217	385	finally
    //   221	228	385	finally
    //   232	241	385	finally
    //   245	267	385	finally
    //   271	280	385	finally
    //   324	336	385	finally
    //   356	368	385	finally
  }
  
  public static boolean agH(String paramString)
  {
    AppMethodBeat.i(49317);
    if ((paramString != null) && (paramString.startsWith("content://")))
    {
      AppMethodBeat.o(49317);
      return true;
    }
    AppMethodBeat.o(49317);
    return false;
  }
  
  public static String l(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(317343);
    if (!TextUtils.isEmpty(paramAppBrandInitConfigWC.qYh))
    {
      paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.qYh;
      AppMethodBeat.o(317343);
      return paramAppBrandInitConfigWC;
    }
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.eoV.qYH;
    AppMethodBeat.o(317343);
    return paramAppBrandInitConfigWC;
  }
  
  public static boolean m(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(317348);
    if (!TextUtils.isEmpty(paramAppBrandInitConfigWC.qYh))
    {
      AppMethodBeat.o(317348);
      return true;
    }
    AppMethodBeat.o(317348);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ah
 * JD-Core Version:    0.7.0.1
 */