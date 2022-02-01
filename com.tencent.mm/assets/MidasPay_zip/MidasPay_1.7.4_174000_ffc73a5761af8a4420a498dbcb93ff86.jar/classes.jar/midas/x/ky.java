package midas.x;

import android.os.Looper;
import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public class ky
{
  private AtomicBoolean a = new AtomicBoolean(false);
  private kt b;
  private HashMap<String, String> c = new HashMap();
  public long d = 0L;
  public long e = 0L;
  public long f = 0L;
  public long g = -1L;
  public long h = -1L;
  public int i = 0;
  public boolean j = false;
  public int k = -1;
  public String l = "POST";
  public km m;
  public int n = 0;
  public int o = 0;
  HttpURLConnection p;
  private HashMap<String, String> q = new HashMap();
  private HostnameVerifier r;
  private SSLSocketFactory s;
  
  public void a(int paramInt1, int paramInt2, ky paramky, kz paramkz) {}
  
  public final void a(HostnameVerifier paramHostnameVerifier)
  {
    if (paramHostnameVerifier != null) {
      this.r = paramHostnameVerifier;
    }
  }
  
  public void a(SSLSocketFactory paramSSLSocketFactory)
  {
    if (paramSSLSocketFactory != null)
    {
      ks.b("HTTP-REQUEST", "Set custom SSLSocketFactory!");
      this.s = paramSSLSocketFactory;
      return;
    }
    ks.a("HTTP-REQUEST", "Try to set a null SSLSocketFactory");
  }
  
  public void a(kt paramkt)
  {
    if (paramkt == null) {
      return;
    }
    this.b = paramkt;
  }
  
  public void a(kz paramkz) {}
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (!this.q.containsKey(paramString)) {
      return "";
    }
    return (String)this.q.get(paramString);
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString2 != null)) {
      this.c.put(paramString1, paramString2);
    }
  }
  
  public void c(String paramString)
  {
    if (this.b != null) {
      this.b.a = paramString;
    }
  }
  
  public final boolean c(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (paramString2 == null) {
      return false;
    }
    paramString1 = (String)this.c.get(paramString1);
    bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (paramString2.equals(paramString1)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d(String paramString)
  {
    if (this.b != null) {
      this.b.b = paramString;
    }
  }
  
  public final void d(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (paramString2 == null) {
      return;
    }
    String str = (String)this.c.get(paramString1);
    if (str == null) {
      return;
    }
    if (paramString2.equals(str)) {
      this.c.remove(paramString1);
    }
  }
  
  public final void e(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      this.q.put(paramString1, paramString2);
      return;
    }
    ks.a("HTTP-REQUEST", "Adding Http parameter with empty key!");
  }
  
  public void f()
  {
    this.g = -1L;
    this.h = -1L;
  }
  
  public final void g()
  {
    this.r = null;
  }
  
  public final void h()
  {
    this.s = null;
  }
  
  public HostnameVerifier i()
  {
    return this.r;
  }
  
  public SSLSocketFactory j()
  {
    return this.s;
  }
  
  public String k()
  {
    if (this.q.size() <= 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Iterator localIterator = this.q.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
      localStringBuilder.append("&");
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  public HashMap<String, String> l()
  {
    return this.c;
  }
  
  public HashMap<String, String> m()
  {
    return this.q;
  }
  
  public boolean n()
  {
    return (this.b != null) && (this.b.c());
  }
  
  boolean o()
  {
    return "POST".equals(this.l);
  }
  
  public boolean p()
  {
    return (this.b != null) && (this.b.b());
  }
  
  boolean q()
  {
    return "GET".equals(this.l);
  }
  
  public boolean r()
  {
    return this.q.size() > 0;
  }
  
  public String s()
  {
    if (this.b == null) {
      return "";
    }
    String str = this.b.a();
    if ((q()) && (r()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("?");
      localStringBuilder.append(k());
      return localStringBuilder.toString();
    }
    return str;
  }
  
  public String t()
  {
    if (this.b != null) {
      return this.b.a;
    }
    return "";
  }
  
  public String u()
  {
    if (this.b != null) {
      return this.b.c;
    }
    return "";
  }
  
  public void v() {}
  
  public void w()
  {
    this.a.set(true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request stop = ");
    localStringBuilder.append(this);
    ks.b("HTTP-REQUEST", localStringBuilder.toString());
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          if (ky.this.p != null)
          {
            ky.this.p.disconnect();
            ks.b("HTTP-REQUEST", "Request stop, disconnect connection!");
            return;
          }
          ks.b("HTTP-REQUEST", "Request stop, no connection!");
        }
      }).start();
      return;
    }
    if (this.p != null)
    {
      this.p.disconnect();
      ks.b("HTTP-REQUEST", "Request stop, disconnect connection!");
      return;
    }
    ks.b("HTTP-REQUEST", "Request stop, no connection!");
  }
  
  public boolean x()
  {
    return this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ky
 * JD-Core Version:    0.7.0.1
 */