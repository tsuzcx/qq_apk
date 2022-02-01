package midas.x;

import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public class kb
{
  private OkHttpClient.Builder a = new OkHttpClient.Builder();
  private OkHttpClient b;
  
  private kb()
  {
    this.a.connectTimeout(15L, TimeUnit.SECONDS);
    this.a.readTimeout(15L, TimeUnit.SECONDS);
    this.a.writeTimeout(15L, TimeUnit.SECONDS);
    this.a.pingInterval(15L, TimeUnit.SECONDS);
    this.b = this.a.build();
  }
  
  public static kb a()
  {
    return a.a();
  }
  
  public jz a(String paramString)
  {
    return new jz(a().b, HttpUrl.parse(paramString).newBuilder());
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
  
  public void c()
  {
    if (this.b != null) {
      this.b.dispatcher().cancelAll();
    }
  }
  
  static class a
  {
    private static kb a = new kb(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.kb
 * JD-Core Version:    0.7.0.1
 */