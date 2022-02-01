package com.tencent.mm.modelappbrand.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.a.e;

public final class b$p
{
  private final String hOr;
  public final String hOs;
  
  private b$p(String paramString)
  {
    AppMethodBeat.i(200121);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(200121);
      throw paramString;
    }
    this.hOr = paramString;
    this.hOs = b.Da(paramString);
    AppMethodBeat.o(200121);
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, Map<String, String> paramMap)
  {
    AppMethodBeat.i(200123);
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        ae.i("Luggage.AppBrandSimpleImageLoader", "setHeaders, header: %s: %s", new Object[] { localEntry.getKey(), localEntry.getValue() });
        paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    AppMethodBeat.o(200123);
  }
  
  /* Error */
  final InputStream B(final Map<String, String> paramMap)
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hOr	Ljava/lang/String;
    //   9: ldc 113
    //   11: invokevirtual 117	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14: ifne +15 -> 29
    //   17: aload_0
    //   18: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hOr	Ljava/lang/String;
    //   21: ldc 119
    //   23: invokevirtual 117	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   26: ifeq +45 -> 71
    //   29: aload_0
    //   30: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hOr	Ljava/lang/String;
    //   33: invokestatic 125	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore_1
    //   37: ldc 111
    //   39: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_1
    //   43: areturn
    //   44: astore_1
    //   45: ldc 77
    //   47: aload_1
    //   48: ldc 127
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hOr	Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 131	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: ldc 111
    //   66: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_1
    //   70: athrow
    //   71: new 133	java/net/URL
    //   74: dup
    //   75: aload_0
    //   76: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hOr	Ljava/lang/String;
    //   79: invokespecial 134	java/net/URL:<init>	(Ljava/lang/String;)V
    //   82: invokevirtual 138	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   85: checkcast 94	java/net/HttpURLConnection
    //   88: astore_3
    //   89: aload_3
    //   90: aload_1
    //   91: invokestatic 140	com/tencent/mm/modelappbrand/a/b$p:a	(Ljava/net/HttpURLConnection;Ljava/util/Map;)V
    //   94: aload_3
    //   95: invokevirtual 144	java/net/HttpURLConnection:getResponseCode	()I
    //   98: sipush 301
    //   101: if_icmpeq +15 -> 116
    //   104: aload_3
    //   105: astore_2
    //   106: aload_3
    //   107: invokevirtual 144	java/net/HttpURLConnection:getResponseCode	()I
    //   110: sipush 302
    //   113: if_icmpne +112 -> 225
    //   116: aload_3
    //   117: ldc 146
    //   119: invokevirtual 149	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_2
    //   123: aload_3
    //   124: invokevirtual 153	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   127: invokevirtual 158	java/io/InputStream:close	()V
    //   130: aload_3
    //   131: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   134: aload_2
    //   135: invokestatic 166	android/webkit/URLUtil:isAboutUrl	(Ljava/lang/String;)Z
    //   138: ifne +10 -> 148
    //   141: aload_2
    //   142: invokestatic 169	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   145: ifne +55 -> 200
    //   148: new 171	java/net/MalformedURLException
    //   151: dup
    //   152: ldc 173
    //   154: iconst_2
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_0
    //   161: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hOr	Ljava/lang/String;
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload_2
    //   168: aastore
    //   169: invokestatic 177	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   172: invokespecial 178	java/net/MalformedURLException:<init>	(Ljava/lang/String;)V
    //   175: astore_1
    //   176: ldc 111
    //   178: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: new 180	java/io/IOException
    //   187: dup
    //   188: aload_1
    //   189: invokespecial 183	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   192: astore_1
    //   193: ldc 111
    //   195: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload_1
    //   199: athrow
    //   200: new 133	java/net/URL
    //   203: dup
    //   204: aload_2
    //   205: invokespecial 134	java/net/URL:<init>	(Ljava/lang/String;)V
    //   208: invokevirtual 138	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   211: checkcast 94	java/net/HttpURLConnection
    //   214: astore_2
    //   215: aload_2
    //   216: iconst_0
    //   217: invokevirtual 187	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   220: aload_2
    //   221: aload_1
    //   222: invokestatic 140	com/tencent/mm/modelappbrand/a/b$p:a	(Ljava/net/HttpURLConnection;Ljava/util/Map;)V
    //   225: new 189	com/tencent/mm/plugin/appbrand/y/i
    //   228: dup
    //   229: aload_2
    //   230: invokespecial 192	com/tencent/mm/plugin/appbrand/y/i:<init>	(Ljava/lang/Object;)V
    //   233: astore_1
    //   234: new 9	com/tencent/mm/modelappbrand/a/b$p$1
    //   237: dup
    //   238: aload_0
    //   239: aload_2
    //   240: invokevirtual 153	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   243: aload_1
    //   244: invokespecial 195	com/tencent/mm/modelappbrand/a/b$p$1:<init>	(Lcom/tencent/mm/modelappbrand/a/b$p;Ljava/io/InputStream;Lcom/tencent/mm/plugin/appbrand/y/i;)V
    //   247: astore_1
    //   248: ldc 111
    //   250: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aload_1
    //   254: areturn
    //   255: astore_1
    //   256: new 180	java/io/IOException
    //   259: dup
    //   260: aload_1
    //   261: invokespecial 183	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   264: astore_1
    //   265: ldc 111
    //   267: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload_1
    //   271: athrow
    //   272: astore_3
    //   273: goto -139 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	p
    //   0	276	1	paramMap	Map<String, String>
    //   105	135	2	localObject	Object
    //   88	43	3	localHttpURLConnection	HttpURLConnection
    //   272	1	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   29	37	44	java/io/FileNotFoundException
    //   94	104	183	java/lang/ArrayIndexOutOfBoundsException
    //   106	116	183	java/lang/ArrayIndexOutOfBoundsException
    //   116	123	183	java/lang/ArrayIndexOutOfBoundsException
    //   123	134	183	java/lang/ArrayIndexOutOfBoundsException
    //   134	148	183	java/lang/ArrayIndexOutOfBoundsException
    //   148	183	183	java/lang/ArrayIndexOutOfBoundsException
    //   200	225	183	java/lang/ArrayIndexOutOfBoundsException
    //   225	248	183	java/lang/ArrayIndexOutOfBoundsException
    //   94	104	255	java/lang/Exception
    //   106	116	255	java/lang/Exception
    //   116	123	255	java/lang/Exception
    //   123	134	255	java/lang/Exception
    //   134	148	255	java/lang/Exception
    //   148	183	255	java/lang/Exception
    //   200	225	255	java/lang/Exception
    //   225	248	255	java/lang/Exception
    //   123	134	272	java/lang/Throwable
  }
  
  public final String toString()
  {
    return this.hOr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.p
 * JD-Core Version:    0.7.0.1
 */