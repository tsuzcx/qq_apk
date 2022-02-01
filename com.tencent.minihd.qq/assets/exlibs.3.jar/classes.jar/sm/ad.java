package sm;

import android.os.Bundle;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ad
{
  protected HttpParams a = null;
  protected a b = null;
  private boolean c = false;
  private String d = null;
  private int e = 0;
  
  protected HttpClient a()
  {
    if (this.a == null) {
      this.a = new BasicHttpParams();
    }
    HttpConnectionParams.setConnectionTimeout(this.a, 10000);
    HttpConnectionParams.setSoTimeout(this.a, 20000);
    HttpConnectionParams.setSocketBufferSize(this.a, 4096);
    HttpClientParams.setRedirecting(this.a, true);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(this.a);
    if (this.c)
    {
      HttpHost localHttpHost = new HttpHost(this.d, this.e);
      localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
    }
    return localDefaultHttpClient;
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    if (this.b != null)
    {
      if (paramInt != 1) {
        break label23;
      }
      this.b.b(paramBundle);
    }
    label23:
    while (paramInt != 2) {
      return;
    }
    this.b.a(paramBundle);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.d = paramString;
    this.e = paramInt;
  }
  
  public void a(a parama)
  {
    this.b = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(Bundle paramBundle);
    
    public abstract void b(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     sm.ad
 * JD-Core Version:    0.7.0.1
 */