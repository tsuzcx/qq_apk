package cooperation.qzone;

import android.content.Context;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class QZoneHttpUtil
{
  private static final int a = 20000;
  private static final int b = 45000;
  
  private static String a(String paramString)
  {
    String str = paramString.trim().replace(" ", "");
    int i = str.indexOf('#');
    paramString = str;
    if (i > 0) {
      paramString = str.substring(0, i);
    }
    return paramString;
  }
  
  public static HttpResponse a(Context paramContext, String paramString, HttpEntity paramHttpEntity)
  {
    return a(paramContext, paramString, paramHttpEntity, null);
  }
  
  public static HttpResponse a(Context paramContext, String paramString, HttpEntity paramHttpEntity, QZoneHttpUtil.RequestOptions paramRequestOptions)
  {
    return a(false).execute(a(paramContext, paramString, paramHttpEntity, paramRequestOptions));
  }
  
  public static HttpClient a(boolean paramBoolean)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled((HttpParams)localObject2, false);
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 20000);
    HttpConnectionParams.setTcpNoDelay((HttpParams)localObject2, true);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 45000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)localObject2, 8192);
    HttpProtocolParams.setVersion((HttpParams)localObject2, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent((HttpParams)localObject2, "android-qzone");
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      label98:
      if (paramBoolean) {}
      for (localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);; localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1))
      {
        localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
        ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      break label98;
    }
  }
  
  public static HttpPost a(Context paramContext, String paramString, HttpEntity paramHttpEntity, QZoneHttpUtil.RequestOptions paramRequestOptions)
  {
    Object localObject = a(paramString);
    paramString = b((String)localObject);
    localObject = new HttpPost((String)localObject);
    ((HttpPost)localObject).addHeader("Host", paramString);
    ((HttpPost)localObject).addHeader("x-online-host", paramString);
    if ((paramHttpEntity instanceof ByteArrayEntity)) {
      ((HttpPost)localObject).addHeader("Content-Type", "application/octet-stream");
    }
    ((HttpPost)localObject).setEntity(paramHttpEntity);
    a(paramContext, (HttpRequest)localObject, paramRequestOptions);
    return localObject;
  }
  
  private static void a(Context paramContext, HttpRequest paramHttpRequest, QZoneHttpUtil.RequestOptions paramRequestOptions)
  {
    boolean bool1;
    if (paramRequestOptions != null)
    {
      bool1 = paramRequestOptions.c;
      if (paramRequestOptions == null) {
        break label78;
      }
    }
    label78:
    for (boolean bool2 = paramRequestOptions.d;; bool2 = false)
    {
      if ((bool1) && (QZoneNetworkUtil.a(paramContext)))
      {
        paramContext = QZoneNetworkUtil.a(paramContext, bool2);
        if (paramContext != null)
        {
          paramContext = new HttpHost(paramContext.jdField_a_of_type_JavaLangString, paramContext.jdField_a_of_type_Int);
          paramHttpRequest.getParams().setParameter("http.route.default-proxy", paramContext);
        }
      }
      return;
      bool1 = true;
      break;
    }
  }
  
  private static String b(String paramString)
  {
    return new URL(paramString).getAuthority();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneHttpUtil
 * JD-Core Version:    0.7.0.1
 */