package com.tencent.mobileqq.transfile;

import android.view.animation.AnimationUtils;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;

public class HttpDownloader
  extends AbsDownloader
{
  private static final int jdField_a_of_type_Int = 4096;
  private static DefaultHttpClient jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient;
  
  static
  {
    a = a();
  }
  
  private static DefaultHttpClient a()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
      localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      localSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, 443));
      return new DefaultHttpClient(new ThreadSafeClientConnManager(new BasicHttpParams(), localSchemeRegistry), null);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("URLDrawable_", 2, "createHttpClient():Can't support https on this devices.", localException);
        }
      }
    }
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  private void a(InputStream paramInputStream, long paramLong, OutputStream paramOutputStream, URLDrawableHandler paramURLDrawableHandler)
  {
    paramInputStream = new BufferedInputStream(paramInputStream, 4096);
    try
    {
      byte[] arrayOfByte = new byte[4096];
      long l1 = 0L;
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
        long l2 = l1 + i;
        l1 = l2;
        if (AnimationUtils.currentAnimationTimeMillis() - 0L > 100L)
        {
          paramURLDrawableHandler.publishProgress((int)((float)l2 / (float)paramLong * 9500.0F));
          l1 = l2;
        }
      }
    }
    finally
    {
      paramInputStream.close();
    }
  }
  
  /* Error */
  public java.io.File a(OutputStream paramOutputStream, com.tencent.image.DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 129	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   4: astore 7
    //   6: new 131	org/apache/http/client/methods/HttpGet
    //   9: dup
    //   10: aload 7
    //   12: invokevirtual 137	java/net/URL:toURI	()Ljava/net/URI;
    //   15: invokespecial 140	org/apache/http/client/methods/HttpGet:<init>	(Ljava/net/URI;)V
    //   18: astore 6
    //   20: aload_2
    //   21: getfield 144	com/tencent/image/DownloadParams:cookies	Lorg/apache/http/client/CookieStore;
    //   24: ifnull +139 -> 163
    //   27: getstatic 15	com/tencent/mobileqq/transfile/HttpDownloader:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   30: invokevirtual 148	org/apache/http/impl/client/DefaultHttpClient:getCookieSpecs	()Lorg/apache/http/cookie/CookieSpecRegistry;
    //   33: ldc 150
    //   35: invokevirtual 156	org/apache/http/cookie/CookieSpecRegistry:getCookieSpec	(Ljava/lang/String;)Lorg/apache/http/cookie/CookieSpec;
    //   38: aload_2
    //   39: getfield 144	com/tencent/image/DownloadParams:cookies	Lorg/apache/http/client/CookieStore;
    //   42: invokeinterface 162 1 0
    //   47: invokeinterface 168 2 0
    //   52: invokeinterface 174 1 0
    //   57: astore 7
    //   59: aload 7
    //   61: invokeinterface 179 1 0
    //   66: ifeq +97 -> 163
    //   69: aload 6
    //   71: aload 7
    //   73: invokeinterface 183 1 0
    //   78: checkcast 185	org/apache/http/Header
    //   81: invokevirtual 189	org/apache/http/client/methods/HttpGet:addHeader	(Lorg/apache/http/Header;)V
    //   84: goto -25 -> 59
    //   87: astore_1
    //   88: new 191	java/lang/IllegalArgumentException
    //   91: dup
    //   92: new 193	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   99: ldc 196
    //   101: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_2
    //   105: getfield 129	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   108: invokevirtual 204	java/net/URL:toString	()Ljava/lang/String;
    //   111: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokespecial 208	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   120: athrow
    //   121: astore 6
    //   123: new 131	org/apache/http/client/methods/HttpGet
    //   126: dup
    //   127: new 210	java/net/URI
    //   130: dup
    //   131: aload 7
    //   133: invokevirtual 213	java/net/URL:getProtocol	()Ljava/lang/String;
    //   136: aload 7
    //   138: invokevirtual 216	java/net/URL:getHost	()Ljava/lang/String;
    //   141: aload 7
    //   143: invokevirtual 219	java/net/URL:getPath	()Ljava/lang/String;
    //   146: aload 7
    //   148: invokevirtual 222	java/net/URL:getQuery	()Ljava/lang/String;
    //   151: aconst_null
    //   152: invokespecial 225	java/net/URI:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   155: invokespecial 140	org/apache/http/client/methods/HttpGet:<init>	(Ljava/net/URI;)V
    //   158: astore 6
    //   160: goto -140 -> 20
    //   163: aload_2
    //   164: getfield 229	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   167: ifnull +51 -> 218
    //   170: aload_2
    //   171: getfield 229	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   174: arraylength
    //   175: ifle +43 -> 218
    //   178: aload_2
    //   179: getfield 229	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   182: astore 7
    //   184: aload 7
    //   186: arraylength
    //   187: istore 5
    //   189: iconst_0
    //   190: istore 4
    //   192: iload 4
    //   194: iload 5
    //   196: if_icmpge +22 -> 218
    //   199: aload 6
    //   201: aload 7
    //   203: iload 4
    //   205: aaload
    //   206: invokevirtual 189	org/apache/http/client/methods/HttpGet:addHeader	(Lorg/apache/http/Header;)V
    //   209: iload 4
    //   211: iconst_1
    //   212: iadd
    //   213: istore 4
    //   215: goto -23 -> 192
    //   218: aload_3
    //   219: invokeinterface 232 1 0
    //   224: getstatic 15	com/tencent/mobileqq/transfile/HttpDownloader:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   227: aload 6
    //   229: invokevirtual 236	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   232: astore 7
    //   234: aload 7
    //   236: invokeinterface 242 1 0
    //   241: invokeinterface 248 1 0
    //   246: istore 4
    //   248: iload 4
    //   250: sipush 200
    //   253: if_icmpeq +76 -> 329
    //   256: aload_3
    //   257: iload 4
    //   259: invokeinterface 251 2 0
    //   264: new 253	java/io/IOException
    //   267: dup
    //   268: new 193	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   275: aload_2
    //   276: getfield 129	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   279: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   282: ldc_w 258
    //   285: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload 4
    //   290: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc_w 263
    //   296: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 7
    //   301: invokeinterface 242 1 0
    //   306: invokeinterface 266 1 0
    //   311: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokespecial 267	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   320: athrow
    //   321: astore_1
    //   322: aload 6
    //   324: invokevirtual 270	org/apache/http/client/methods/HttpGet:abort	()V
    //   327: aload_1
    //   328: athrow
    //   329: aload 7
    //   331: invokeinterface 274 1 0
    //   336: astore 7
    //   338: aload_3
    //   339: aload 7
    //   341: invokeinterface 279 1 0
    //   346: invokeinterface 283 3 0
    //   351: aload_0
    //   352: aload 7
    //   354: invokeinterface 287 1 0
    //   359: aload 7
    //   361: invokeinterface 279 1 0
    //   366: aload_1
    //   367: aload_3
    //   368: invokespecial 289	com/tencent/mobileqq/transfile/HttpDownloader:a	(Ljava/io/InputStream;JLjava/io/OutputStream;Lcom/tencent/image/URLDrawableHandler;)V
    //   371: aload 6
    //   373: invokevirtual 270	org/apache/http/client/methods/HttpGet:abort	()V
    //   376: aconst_null
    //   377: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	this	HttpDownloader
    //   0	378	1	paramOutputStream	OutputStream
    //   0	378	2	paramDownloadParams	com.tencent.image.DownloadParams
    //   0	378	3	paramURLDrawableHandler	URLDrawableHandler
    //   190	99	4	i	int
    //   187	10	5	j	int
    //   18	52	6	localHttpGet1	org.apache.http.client.methods.HttpGet
    //   121	1	6	localURISyntaxException	java.net.URISyntaxException
    //   158	214	6	localHttpGet2	org.apache.http.client.methods.HttpGet
    //   4	356	7	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   0	6	87	java/net/URISyntaxException
    //   20	59	87	java/net/URISyntaxException
    //   59	84	87	java/net/URISyntaxException
    //   123	160	87	java/net/URISyntaxException
    //   163	189	87	java/net/URISyntaxException
    //   199	209	87	java/net/URISyntaxException
    //   322	329	87	java/net/URISyntaxException
    //   371	376	87	java/net/URISyntaxException
    //   6	20	121	java/net/URISyntaxException
    //   218	248	321	finally
    //   256	321	321	finally
    //   329	371	321	finally
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpDownloader
 * JD-Core Version:    0.7.0.1
 */