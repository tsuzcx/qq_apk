package com.rookery.asyncHttpClient;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Pair;
import bxv;
import bxw;
import bxx;
import bxz;
import byb;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class AsyncHttpClient
{
  private static final int jdField_a_of_type_Int = 6;
  private static final String jdField_a_of_type_JavaLangString = "Accept-Encoding";
  private static final int jdField_b_of_type_Int = 10000;
  private static final String jdField_b_of_type_JavaLangString = "gzip";
  private static final int jdField_c_of_type_Int = 3;
  private static String jdField_c_of_type_JavaLangString;
  private static final int d = 8192;
  private static int e = 6;
  private static int f = 10000;
  private final Map jdField_a_of_type_JavaUtilMap;
  private ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  private final DefaultHttpClient jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient;
  private final HttpContext jdField_a_of_type_OrgApacheHttpProtocolHttpContext;
  private final Map jdField_b_of_type_JavaUtilMap;
  
  static
  {
    c = "UTF-8";
  }
  
  public AsyncHttpClient()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, f);
    try
    {
      ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(e));
      ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 6);
      try
      {
        label40:
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, f);
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, f);
        HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        label73:
        Object localObject1 = new SchemeRegistry();
        ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (Build.VERSION.SDK_INT < 11) {}
        for (;;)
        {
          try
          {
            Object localObject2 = KeyStore.getInstance(KeyStore.getDefaultType());
            ((KeyStore)localObject2).load(null, null);
            localObject2 = new AsyncHttpClient.CustomSSLSocketFactory((KeyStore)localObject2);
            ((SSLSocketFactory)localObject2).setHostnameVerifier(new bxv(this));
            ((SchemeRegistry)localObject1).register(new Scheme("https", (SocketFactory)localObject2, 443));
            localObject1 = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject1);
            this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext = new SyncBasicHttpContext(new BasicHttpContext());
            this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = new DefaultHttpClient((ClientConnectionManager)localObject1, localBasicHttpParams);
            this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.addRequestInterceptor(new bxw(this));
            this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.addResponseInterceptor(new bxx(this));
            this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.setHttpRequestRetryHandler(new byb(3));
            this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = ((ThreadPoolExecutor)Executors.newCachedThreadPool());
            this.jdField_a_of_type_JavaUtilMap = new WeakHashMap();
            this.b = new HashMap();
            return;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Translator", 2, "accept all ssl factory error" + localException);
            }
            ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            continue;
          }
          ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
      }
      catch (NoSuchMethodError localNoSuchMethodError1)
      {
        break label73;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError2)
    {
      break label40;
    }
  }
  
  public static String a(String paramString, List paramList)
  {
    Object localObject = paramString;
    if (paramList != null)
    {
      localObject = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Pair localPair = (Pair)paramList.next();
        ((List)localObject).add(new BasicNameValuePair((String)localPair.first, (String)localPair.second));
      }
      paramList = URLEncodedUtils.format((List)localObject, c);
      if (paramString.indexOf("?") == -1) {
        localObject = paramString + "?" + paramList;
      }
    }
    else
    {
      return localObject;
    }
    return paramString + "&" + paramList;
  }
  
  public void a(Context paramContext, String paramString, Header[] paramArrayOfHeader, List paramList, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    paramString = new HttpGet(a(paramString, paramList));
    if (paramArrayOfHeader != null) {
      paramString.setHeaders(paramArrayOfHeader);
    }
    a(this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext, paramString, null, paramAsyncHttpResponseHandler, paramContext);
  }
  
  public void a(Context paramContext, String paramString1, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString2, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    paramString1 = new HttpPost(paramString1);
    if ((paramHttpEntity != null) && (paramString1 != null)) {
      paramString1.setEntity(paramHttpEntity);
    }
    if ((paramArrayOfHeader != null) && (paramString1 != null)) {
      paramString1.setHeaders(paramArrayOfHeader);
    }
    a(this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext, paramString1, paramString2, paramAsyncHttpResponseHandler, paramContext);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(paramContext);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Future localFuture = (Future)((WeakReference)((Iterator)localObject).next()).get();
        if (localFuture != null)
        {
          localFuture.cancel(paramBoolean);
          if (QLog.isColorLevel()) {
            QLog.e("Translator", 2, "[cancel] cancel task" + localFuture.toString());
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilMap.remove(paramContext);
  }
  
  protected void a(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, AsyncHttpResponseHandler paramAsyncHttpResponseHandler, Context paramContext)
  {
    if (paramString != null) {
      paramHttpUriRequest.addHeader("Content-Type", paramString);
    }
    paramHttpUriRequest = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new bxz(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramAsyncHttpResponseHandler));
    if (paramContext != null)
    {
      paramHttpContext = (List)this.jdField_a_of_type_JavaUtilMap.get(paramContext);
      paramDefaultHttpClient = paramHttpContext;
      if (paramHttpContext == null)
      {
        paramDefaultHttpClient = new LinkedList();
        this.jdField_a_of_type_JavaUtilMap.put(paramContext, paramDefaultHttpClient);
      }
      paramDefaultHttpClient.add(new WeakReference(paramHttpUriRequest));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.rookery.asyncHttpClient.AsyncHttpClient
 * JD-Core Version:    0.7.0.1
 */