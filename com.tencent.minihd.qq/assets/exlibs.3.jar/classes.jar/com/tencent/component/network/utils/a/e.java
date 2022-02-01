package com.tencent.component.network.utils.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.module.base.b;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.NetworkUtils.NetworkProxy;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class e
{
  private static final e.a a = new e.a();
  
  public static String a(String paramString)
  {
    if (paramString != null) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
      i = paramString.indexOf("&rf=");
      if (i >= 0) {
        break;
      }
      return "";
    }
    int j = paramString.indexOf("&", "&rf=".length() + i);
    if (j > "&rf=".length() + i) {
      return paramString.substring("&rf=".length() + i, j);
    }
    return paramString.substring("&rf=".length() + i);
  }
  
  public static HttpResponse a(Context paramContext, String paramString, HttpEntity paramHttpEntity)
  {
    return a(paramContext, paramString, paramHttpEntity, null);
  }
  
  public static HttpResponse a(Context paramContext, String paramString, HttpEntity paramHttpEntity, e.b paramb)
  {
    return a().execute(a(paramContext, paramString, paramHttpEntity, paramb));
  }
  
  public static HttpClient a()
  {
    return a(null);
  }
  
  public static HttpClient a(e.a parama)
  {
    Object localObject = parama;
    if (parama == null) {
      localObject = a;
    }
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, ((e.a)localObject).c);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, ((e.a)localObject).e);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, com.tencent.component.network.module.base.a.d());
    parama = new SchemeRegistry();
    try
    {
      parama.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      parama.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      if (((e.a)localObject).jdField_a_of_type_Boolean)
      {
        g localg = new g(parama, ((e.a)localObject).jdField_a_of_type_Long, ((e.a)localObject).jdField_a_of_type_JavaUtilConcurrentTimeUnit);
        if (((e.a)localObject).b > 0) {
          localg.b(((e.a)localObject).b);
        }
        parama = localg;
        if (((e.a)localObject).jdField_a_of_type_Int > 0)
        {
          localg.a(((e.a)localObject).jdField_a_of_type_Int);
          parama = localg;
        }
        ConnManagerParams.setTimeout(localBasicHttpParams, ((e.a)localObject).d);
        localObject = new com.tencent.component.network.utils.a.a.a(parama, localBasicHttpParams);
        ((DefaultHttpClient)localObject).setRoutePlanner(new DefaultHttpRoutePlanner(parama.getSchemeRegistry()));
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.d("downloader", "", localThrowable);
        continue;
        parama = new SingleClientConnManager(localBasicHttpParams, parama);
      }
    }
  }
  
  public static HttpGet a(Context paramContext, String paramString1, String paramString2, String paramString3, e.b paramb)
  {
    String str = a(paramString1);
    paramString3 = new HttpGet(b(paramString3));
    paramString3.addHeader("x-online-host", paramString2);
    paramString3.addHeader("Host", paramString2);
    paramString2 = com.tencent.component.network.module.base.a.e();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString3.addHeader("Q-UA", paramString2);
    }
    if (!TextUtils.isEmpty(str)) {
      paramString3.addHeader("Referer", str);
    }
    for (;;)
    {
      a(paramContext, paramString3, paramb);
      return paramString3;
      paramString3.addHeader("Referer", paramString1);
    }
  }
  
  public static HttpGet a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, e.b paramb)
  {
    paramString1 = new HttpGet(b(paramString3));
    paramString1.addHeader("x-online-host", paramString2);
    paramString1.addHeader("Host", paramString2);
    paramString2 = com.tencent.component.network.module.base.a.e();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.addHeader("Q-UA", paramString2);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramString1.addHeader("Referer", paramString4);
    }
    a(paramContext, paramString1, paramb);
    return paramString1;
  }
  
  public static HttpPost a(Context paramContext, String paramString, HttpEntity paramHttpEntity, e.b paramb)
  {
    Object localObject = b(paramString);
    paramString = c((String)localObject);
    localObject = new HttpPost((String)localObject);
    ((HttpPost)localObject).addHeader("Host", paramString);
    ((HttpPost)localObject).addHeader("x-online-host", paramString);
    paramString = com.tencent.component.network.module.base.a.e();
    if (!TextUtils.isEmpty(paramString)) {
      ((HttpPost)localObject).addHeader("Q-UA", paramString);
    }
    if ((paramHttpEntity instanceof ByteArrayEntity)) {
      ((HttpPost)localObject).addHeader("Content-Type", "application/octet-stream");
    }
    ((HttpPost)localObject).setEntity(paramHttpEntity);
    a(paramContext, (HttpRequest)localObject, paramb);
    return localObject;
  }
  
  public static HttpContext a()
  {
    return new BasicHttpContext();
  }
  
  private static void a(Context paramContext, HttpRequest paramHttpRequest, e.b paramb)
  {
    if ((paramb != null) && (paramb.jdField_a_of_type_OrgApacheHttpHttpHost != null) && (NetworkUtils.c(paramContext))) {
      paramHttpRequest.getParams().setParameter("http.route.default-proxy", paramb.jdField_a_of_type_OrgApacheHttpHttpHost);
    }
    label170:
    label174:
    for (;;)
    {
      return;
      boolean bool1;
      if (paramb != null)
      {
        bool1 = paramb.jdField_a_of_type_Boolean;
        label47:
        if (paramb == null) {
          break label170;
        }
      }
      for (boolean bool2 = paramb.b;; bool2 = false)
      {
        if ((!bool1) || (!NetworkUtils.c(paramContext))) {
          break label174;
        }
        paramContext = NetworkUtils.a(paramContext, bool2);
        if (paramContext == null) {
          break;
        }
        paramb = new HttpHost(paramContext.jdField_a_of_type_JavaLangString, paramContext.jdField_a_of_type_Int);
        paramHttpRequest.getParams().setParameter("http.route.default-proxy", paramb);
        if (!b.a()) {
          break;
        }
        b.a("downloader", "use proxy[host:" + paramContext.jdField_a_of_type_JavaLangString + ",port:" + paramContext.jdField_a_of_type_Int + "]");
        return;
        bool1 = true;
        break label47;
      }
    }
  }
  
  public static void a(HttpRequest paramHttpRequest, boolean paramBoolean)
  {
    if (paramHttpRequest != null) {
      if (!paramBoolean) {
        break label23;
      }
    }
    label23:
    for (String str = "Keep-Alive";; str = "Close")
    {
      paramHttpRequest.setHeader("Connection", str);
      return;
    }
  }
  
  public static boolean a(HttpRequest paramHttpRequest)
  {
    if (paramHttpRequest != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
      paramHttpRequest = paramHttpRequest.getParams().getParameter("http.route.default-proxy");
      if ((paramHttpRequest == null) || (!(paramHttpRequest instanceof HttpHost))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private static String b(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
      String str = paramString.trim().replace(" ", "");
      int i = str.indexOf('#');
      paramString = str;
      if (i > 0) {
        paramString = str.substring(0, i);
      }
      return paramString;
    }
  }
  
  private static String c(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
      return new URL(paramString).getAuthority();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.e
 * JD-Core Version:    0.7.0.1
 */