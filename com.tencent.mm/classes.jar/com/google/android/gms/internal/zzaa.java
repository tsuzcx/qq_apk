package com.google.android.gms.internal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class zzaa
  implements zzz
{
  private final zzaa.zza zzaE;
  private final SSLSocketFactory zzaF;
  
  public zzaa()
  {
    this(null);
  }
  
  public zzaa(zzaa.zza paramzza)
  {
    this(paramzza, null);
  }
  
  public zzaa(zzaa.zza paramzza, SSLSocketFactory paramSSLSocketFactory)
  {
    this.zzaE = paramzza;
    this.zzaF = paramSSLSocketFactory;
  }
  
  private HttpURLConnection zza(URL paramURL, zzl<?> paramzzl)
  {
    HttpURLConnection localHttpURLConnection = zza(paramURL);
    int i = paramzzl.zzp();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    if (("https".equals(paramURL.getProtocol())) && (this.zzaF != null)) {
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(this.zzaF);
    }
    return localHttpURLConnection;
  }
  
  private static HttpEntity zza(HttpURLConnection paramHttpURLConnection)
  {
    BasicHttpEntity localBasicHttpEntity = new BasicHttpEntity();
    try
    {
      InputStream localInputStream1 = paramHttpURLConnection.getInputStream();
      localBasicHttpEntity.setContent(localInputStream1);
      localBasicHttpEntity.setContentLength(paramHttpURLConnection.getContentLength());
      localBasicHttpEntity.setContentEncoding(paramHttpURLConnection.getContentEncoding());
      localBasicHttpEntity.setContentType(paramHttpURLConnection.getContentType());
      return localBasicHttpEntity;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        InputStream localInputStream2 = paramHttpURLConnection.getErrorStream();
      }
    }
  }
  
  static void zza(HttpURLConnection paramHttpURLConnection, zzl<?> paramzzl)
  {
    switch (paramzzl.getMethod())
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case -1: 
      byte[] arrayOfByte = paramzzl.zzj();
      if (arrayOfByte != null)
      {
        paramHttpURLConnection.setDoOutput(true);
        paramHttpURLConnection.setRequestMethod("POST");
        paramHttpURLConnection.addRequestProperty("Content-Type", paramzzl.zzi());
        paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
        paramHttpURLConnection.write(arrayOfByte);
        paramHttpURLConnection.close();
      }
      return;
    case 0: 
      paramHttpURLConnection.setRequestMethod("GET");
      return;
    case 3: 
      paramHttpURLConnection.setRequestMethod("DELETE");
      return;
    case 1: 
      paramHttpURLConnection.setRequestMethod("POST");
      zzb(paramHttpURLConnection, paramzzl);
      return;
    case 2: 
      paramHttpURLConnection.setRequestMethod("PUT");
      zzb(paramHttpURLConnection, paramzzl);
      return;
    case 4: 
      paramHttpURLConnection.setRequestMethod("HEAD");
      return;
    case 5: 
      paramHttpURLConnection.setRequestMethod("OPTIONS");
      return;
    case 6: 
      paramHttpURLConnection.setRequestMethod("TRACE");
      return;
    }
    paramHttpURLConnection.setRequestMethod("PATCH");
    zzb(paramHttpURLConnection, paramzzl);
  }
  
  private static boolean zza(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 4) && ((100 > paramInt2) || (paramInt2 >= 200)) && (paramInt2 != 204) && (paramInt2 != 304);
  }
  
  private static void zzb(HttpURLConnection paramHttpURLConnection, zzl<?> paramzzl)
  {
    byte[] arrayOfByte = paramzzl.zzm();
    if (arrayOfByte != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.addRequestProperty("Content-Type", paramzzl.zzl());
      paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
      paramHttpURLConnection.write(arrayOfByte);
      paramHttpURLConnection.close();
    }
  }
  
  protected HttpURLConnection zza(URL paramURL)
  {
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    return paramURL;
  }
  
  public HttpResponse zza(zzl<?> paramzzl, Map<String, String> paramMap)
  {
    Object localObject1 = paramzzl.getUrl();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramzzl.getHeaders());
    localHashMap.putAll(paramMap);
    if (this.zzaE != null)
    {
      localObject2 = this.zzaE.zzh((String)localObject1);
      paramMap = (Map<String, String>)localObject2;
      if (localObject2 == null) {
        throw new IOException("URL blocked by rewriter: " + (String)localObject1);
      }
    }
    else
    {
      paramMap = (Map<String, String>)localObject1;
    }
    paramMap = zza(new URL(paramMap), paramzzl);
    localObject1 = localHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramMap.addRequestProperty((String)localObject2, (String)localHashMap.get(localObject2));
    }
    zza(paramMap, paramzzl);
    localObject1 = new ProtocolVersion("HTTP", 1, 1);
    if (paramMap.getResponseCode() == -1) {
      throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }
    Object localObject2 = new BasicStatusLine((ProtocolVersion)localObject1, paramMap.getResponseCode(), paramMap.getResponseMessage());
    localObject1 = new BasicHttpResponse((StatusLine)localObject2);
    if (zza(paramzzl.getMethod(), ((StatusLine)localObject2).getStatusCode())) {
      ((BasicHttpResponse)localObject1).setEntity(zza(paramMap));
    }
    paramzzl = paramMap.getHeaderFields().entrySet().iterator();
    while (paramzzl.hasNext())
    {
      paramMap = (Map.Entry)paramzzl.next();
      if (paramMap.getKey() != null) {
        ((BasicHttpResponse)localObject1).addHeader(new BasicHeader((String)paramMap.getKey(), (String)((List)paramMap.getValue()).get(0)));
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzaa
 * JD-Core Version:    0.7.0.1
 */