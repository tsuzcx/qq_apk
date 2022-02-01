package midas.x;

import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public class ha
{
  public OkHttpClient.Builder a = new OkHttpClient.Builder();
  public OkHttpClient b;
  
  public ha()
  {
    this.a.connectTimeout(15L, TimeUnit.SECONDS);
    this.a.readTimeout(15L, TimeUnit.SECONDS);
    this.a.writeTimeout(15L, TimeUnit.SECONDS);
    this.a.pingInterval(15L, TimeUnit.SECONDS);
    this.b = this.a.build();
  }
  
  public static ha c()
  {
    return b.a();
  }
  
  public fa a(String paramString)
  {
    return new fa(c().b, HttpUrl.parse(paramString).newBuilder());
  }
  
  public void a()
  {
    OkHttpClient localOkHttpClient = this.b;
    if (localOkHttpClient != null) {
      localOkHttpClient.dispatcher().cancelAll();
    }
  }
  
  public void a(Long paramLong, TimeUnit paramTimeUnit)
  {
    this.a.pingInterval(paramLong.longValue(), paramTimeUnit);
    this.b = this.a.build();
  }
  
  public OkHttpClient b()
  {
    return this.b;
  }
  
  public static class b
  {
    public static ha a = new ha(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ha
 * JD-Core Version:    0.7.0.1
 */