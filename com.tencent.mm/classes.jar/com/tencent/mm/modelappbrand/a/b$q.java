package com.tencent.mm.modelappbrand.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.a.d;

public final class b$q
{
  private final String lzB;
  public final String lzC;
  
  private b$q(String paramString)
  {
    AppMethodBeat.i(229568);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(229568);
      throw paramString;
    }
    this.lzB = paramString;
    this.lzC = b.Td(paramString);
    AppMethodBeat.o(229568);
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, Map<String, String> paramMap)
  {
    AppMethodBeat.i(229573);
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        Log.i("Luggage.AppBrandSimpleImageLoader", "setHeaders, header: %s: %s", new Object[] { localEntry.getKey(), localEntry.getValue() });
        paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    AppMethodBeat.o(229573);
  }
  
  public final String toString()
  {
    return this.lzB;
  }
  
  /* Error */
  final InputStream w(final Map<String, String> paramMap)
  {
    // Byte code:
    //   0: ldc 113
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 77
    //   7: new 115	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 117
    //   13: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 38	com/tencent/mm/modelappbrand/a/b$q:lzB	Ljava/lang/String;
    //   20: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 38	com/tencent/mm/modelappbrand/a/b$q:lzB	Ljava/lang/String;
    //   33: ldc 128
    //   35: invokevirtual 132	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   38: ifne +15 -> 53
    //   41: aload_0
    //   42: getfield 38	com/tencent/mm/modelappbrand/a/b$q:lzB	Ljava/lang/String;
    //   45: ldc 134
    //   47: invokevirtual 132	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifeq +45 -> 95
    //   53: aload_0
    //   54: getfield 38	com/tencent/mm/modelappbrand/a/b$q:lzB	Ljava/lang/String;
    //   57: invokestatic 140	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   60: astore_1
    //   61: ldc 113
    //   63: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: areturn
    //   68: astore_1
    //   69: ldc 77
    //   71: aload_1
    //   72: ldc 142
    //   74: iconst_1
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: getfield 38	com/tencent/mm/modelappbrand/a/b$q:lzB	Ljava/lang/String;
    //   84: aastore
    //   85: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: ldc 113
    //   90: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: athrow
    //   95: new 148	java/net/URL
    //   98: dup
    //   99: aload_0
    //   100: getfield 38	com/tencent/mm/modelappbrand/a/b$q:lzB	Ljava/lang/String;
    //   103: invokespecial 149	java/net/URL:<init>	(Ljava/lang/String;)V
    //   106: invokevirtual 153	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   109: checkcast 94	java/net/HttpURLConnection
    //   112: astore_3
    //   113: aload_3
    //   114: aload_1
    //   115: invokestatic 155	com/tencent/mm/modelappbrand/a/b$q:a	(Ljava/net/HttpURLConnection;Ljava/util/Map;)V
    //   118: invokestatic 158	com/tencent/mm/modelappbrand/a/b:bhm	()Z
    //   121: ifeq +34 -> 155
    //   124: aload_3
    //   125: instanceof 160
    //   128: ifeq +27 -> 155
    //   131: getstatic 166	com/tencent/mm/plugin/appbrand/s/b/a:qkj	Lcom/tencent/mm/plugin/appbrand/s/b/a;
    //   134: astore_2
    //   135: ldc 77
    //   137: ldc 168
    //   139: aload_3
    //   140: checkcast 160	javax/net/ssl/HttpsURLConnection
    //   143: invokestatic 172	com/tencent/mm/plugin/appbrand/s/b/a:b	(Ljavax/net/ssl/HttpsURLConnection;)Z
    //   146: invokestatic 176	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   149: invokevirtual 179	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   152: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_3
    //   156: invokevirtual 183	java/net/HttpURLConnection:getResponseCode	()I
    //   159: sipush 301
    //   162: if_icmpeq +15 -> 177
    //   165: aload_3
    //   166: astore_2
    //   167: aload_3
    //   168: invokevirtual 183	java/net/HttpURLConnection:getResponseCode	()I
    //   171: sipush 302
    //   174: if_icmpne +173 -> 347
    //   177: ldc 77
    //   179: ldc 185
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: getfield 38	com/tencent/mm/modelappbrand/a/b$q:lzB	Ljava/lang/String;
    //   191: aastore
    //   192: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload_3
    //   196: ldc 187
    //   198: invokevirtual 190	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   201: astore_2
    //   202: aload_3
    //   203: invokevirtual 194	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   206: invokevirtual 199	java/io/InputStream:close	()V
    //   209: aload_3
    //   210: invokevirtual 202	java/net/HttpURLConnection:disconnect	()V
    //   213: aload_2
    //   214: invokestatic 207	android/webkit/URLUtil:isAboutUrl	(Ljava/lang/String;)Z
    //   217: ifne +10 -> 227
    //   220: aload_2
    //   221: invokestatic 210	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   224: ifne +55 -> 279
    //   227: new 212	java/net/MalformedURLException
    //   230: dup
    //   231: ldc 214
    //   233: iconst_2
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_0
    //   240: getfield 38	com/tencent/mm/modelappbrand/a/b$q:lzB	Ljava/lang/String;
    //   243: aastore
    //   244: dup
    //   245: iconst_1
    //   246: aload_2
    //   247: aastore
    //   248: invokestatic 218	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   251: invokespecial 219	java/net/MalformedURLException:<init>	(Ljava/lang/String;)V
    //   254: astore_1
    //   255: ldc 113
    //   257: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload_1
    //   261: athrow
    //   262: astore_1
    //   263: new 221	java/io/IOException
    //   266: dup
    //   267: aload_1
    //   268: invokespecial 224	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   271: astore_1
    //   272: ldc 113
    //   274: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: aload_1
    //   278: athrow
    //   279: new 148	java/net/URL
    //   282: dup
    //   283: aload_2
    //   284: invokespecial 149	java/net/URL:<init>	(Ljava/lang/String;)V
    //   287: invokevirtual 153	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   290: checkcast 94	java/net/HttpURLConnection
    //   293: astore_3
    //   294: aload_3
    //   295: iconst_0
    //   296: invokevirtual 228	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   299: aload_3
    //   300: aload_1
    //   301: invokestatic 155	com/tencent/mm/modelappbrand/a/b$q:a	(Ljava/net/HttpURLConnection;Ljava/util/Map;)V
    //   304: aload_3
    //   305: astore_2
    //   306: invokestatic 158	com/tencent/mm/modelappbrand/a/b:bhm	()Z
    //   309: ifeq +38 -> 347
    //   312: aload_3
    //   313: astore_2
    //   314: aload_3
    //   315: instanceof 160
    //   318: ifeq +29 -> 347
    //   321: getstatic 166	com/tencent/mm/plugin/appbrand/s/b/a:qkj	Lcom/tencent/mm/plugin/appbrand/s/b/a;
    //   324: astore_1
    //   325: ldc 77
    //   327: ldc 168
    //   329: aload_3
    //   330: checkcast 160	javax/net/ssl/HttpsURLConnection
    //   333: invokestatic 172	com/tencent/mm/plugin/appbrand/s/b/a:b	(Ljavax/net/ssl/HttpsURLConnection;)Z
    //   336: invokestatic 176	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   339: invokevirtual 179	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   342: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_3
    //   346: astore_2
    //   347: new 230	com/tencent/mm/plugin/appbrand/ac/i
    //   350: dup
    //   351: aload_2
    //   352: invokespecial 233	com/tencent/mm/plugin/appbrand/ac/i:<init>	(Ljava/lang/Object;)V
    //   355: astore_1
    //   356: new 9	com/tencent/mm/modelappbrand/a/b$q$1
    //   359: dup
    //   360: aload_0
    //   361: aload_2
    //   362: invokevirtual 194	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   365: aload_1
    //   366: invokespecial 236	com/tencent/mm/modelappbrand/a/b$q$1:<init>	(Lcom/tencent/mm/modelappbrand/a/b$q;Ljava/io/InputStream;Lcom/tencent/mm/plugin/appbrand/ac/i;)V
    //   369: astore_1
    //   370: ldc 77
    //   372: ldc 238
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload_0
    //   381: getfield 38	com/tencent/mm/modelappbrand/a/b$q:lzB	Ljava/lang/String;
    //   384: aastore
    //   385: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: ldc 113
    //   390: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   393: aload_1
    //   394: areturn
    //   395: astore_1
    //   396: new 221	java/io/IOException
    //   399: dup
    //   400: aload_1
    //   401: invokespecial 224	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   404: astore_1
    //   405: ldc 113
    //   407: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: aload_1
    //   411: athrow
    //   412: astore_3
    //   413: goto -200 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	q
    //   0	416	1	paramMap	Map<String, String>
    //   134	228	2	localObject	Object
    //   112	234	3	localHttpURLConnection	HttpURLConnection
    //   412	1	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   53	61	68	java/io/FileNotFoundException
    //   155	165	262	java/lang/ArrayIndexOutOfBoundsException
    //   167	177	262	java/lang/ArrayIndexOutOfBoundsException
    //   177	202	262	java/lang/ArrayIndexOutOfBoundsException
    //   202	213	262	java/lang/ArrayIndexOutOfBoundsException
    //   213	227	262	java/lang/ArrayIndexOutOfBoundsException
    //   227	262	262	java/lang/ArrayIndexOutOfBoundsException
    //   279	304	262	java/lang/ArrayIndexOutOfBoundsException
    //   306	312	262	java/lang/ArrayIndexOutOfBoundsException
    //   314	345	262	java/lang/ArrayIndexOutOfBoundsException
    //   347	388	262	java/lang/ArrayIndexOutOfBoundsException
    //   155	165	395	java/lang/Exception
    //   167	177	395	java/lang/Exception
    //   177	202	395	java/lang/Exception
    //   202	213	395	java/lang/Exception
    //   213	227	395	java/lang/Exception
    //   227	262	395	java/lang/Exception
    //   279	304	395	java/lang/Exception
    //   306	312	395	java/lang/Exception
    //   314	345	395	java/lang/Exception
    //   347	388	395	java/lang/Exception
    //   202	213	412	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.q
 * JD-Core Version:    0.7.0.1
 */