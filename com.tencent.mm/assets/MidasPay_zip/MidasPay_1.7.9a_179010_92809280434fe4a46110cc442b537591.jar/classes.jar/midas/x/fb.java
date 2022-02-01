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

public class fb
{
  public long a;
  public long b = 0L;
  public long c = 0L;
  public long d = -1L;
  public long e = -1L;
  public int f = 0;
  public boolean g = false;
  public int h = -1;
  public AtomicBoolean i = new AtomicBoolean(false);
  public za j;
  public String k = "POST";
  public sa l;
  public HashMap<String, String> m = new HashMap();
  public HashMap<String, String> n = new HashMap();
  public int o = 0;
  public int p = 0;
  public HostnameVerifier q;
  public SSLSocketFactory r;
  public HttpURLConnection s;
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (!this.n.containsKey(paramString)) {
      return "";
    }
    return (String)this.n.get(paramString);
  }
  
  public final void a()
  {
    this.q = null;
  }
  
  public void a(int paramInt1, int paramInt2, fb paramfb, gb paramgb) {}
  
  public final void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString2 != null)) {
      this.m.put(paramString1, paramString2);
    }
  }
  
  public final void a(HostnameVerifier paramHostnameVerifier)
  {
    if (paramHostnameVerifier != null) {
      this.q = paramHostnameVerifier;
    }
  }
  
  public void a(SSLSocketFactory paramSSLSocketFactory)
  {
    if (paramSSLSocketFactory != null)
    {
      ya.a("HTTP-REQUEST", "Set custom SSLSocketFactory!");
      this.r = paramSSLSocketFactory;
      return;
    }
    ya.b("HTTP-REQUEST", "Try to set a null SSLSocketFactory");
  }
  
  public void a(gb paramgb) {}
  
  public void a(za paramza)
  {
    if (paramza == null) {
      return;
    }
    this.j = paramza;
  }
  
  public final void b()
  {
    this.r = null;
  }
  
  public void b(String paramString)
  {
    za localza = this.j;
    if (localza != null) {
      localza.a = paramString;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      this.n.put(paramString1, paramString2);
      return;
    }
    ya.b("HTTP-REQUEST", "Adding Http parameter with empty key!");
  }
  
  public String c()
  {
    if (this.n.size() <= 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Iterator localIterator = this.n.entrySet().iterator();
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
  
  public void c(String paramString)
  {
    za localza = this.j;
    if (localza != null) {
      localza.b = paramString;
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
    paramString1 = (String)this.m.get(paramString1);
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
  
  public HostnameVerifier d()
  {
    return this.q;
  }
  
  public final void d(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (paramString2 == null) {
      return;
    }
    String str = (String)this.m.get(paramString1);
    if (str == null) {
      return;
    }
    if (paramString2.equals(str)) {
      this.m.remove(paramString1);
    }
  }
  
  public SSLSocketFactory e()
  {
    return this.r;
  }
  
  public String f()
  {
    Object localObject = this.j;
    if (localObject == null) {
      return "";
    }
    String str = ((za)localObject).a();
    localObject = str;
    if (l())
    {
      localObject = str;
      if (k())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("?");
        ((StringBuilder)localObject).append(c());
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public String g()
  {
    za localza = this.j;
    if (localza != null) {
      return localza.a;
    }
    return "";
  }
  
  public HashMap<String, String> h()
  {
    return this.m;
  }
  
  public HashMap<String, String> i()
  {
    return this.n;
  }
  
  public String j()
  {
    za localza = this.j;
    if (localza != null) {
      return localza.c;
    }
    return "";
  }
  
  public boolean k()
  {
    return this.n.size() > 0;
  }
  
  public boolean l()
  {
    return "GET".equals(this.k);
  }
  
  public boolean m()
  {
    za localza = this.j;
    return (localza != null) && (localza.c());
  }
  
  public boolean n()
  {
    return "POST".equals(this.k);
  }
  
  public boolean o()
  {
    za localza = this.j;
    return (localza != null) && (localza.b());
  }
  
  public boolean p()
  {
    return this.i.get();
  }
  
  public void q() {}
  
  public void r()
  {
    this.d = -1L;
    this.e = -1L;
  }
  
  public void s()
  {
    this.i.set(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Request stop = ");
    ((StringBuilder)localObject).append(this);
    ya.a("HTTP-REQUEST", ((StringBuilder)localObject).toString());
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      new Thread(new a()).start();
      return;
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((HttpURLConnection)localObject).disconnect();
      ya.a("HTTP-REQUEST", "Request stop, disconnect connection!");
      return;
    }
    ya.a("HTTP-REQUEST", "Request stop, no connection!");
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      HttpURLConnection localHttpURLConnection = fb.this.s;
      if (localHttpURLConnection != null)
      {
        localHttpURLConnection.disconnect();
        ya.a("HTTP-REQUEST", "Request stop, disconnect connection!");
        return;
      }
      ya.a("HTTP-REQUEST", "Request stop, no connection!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.fb
 * JD-Core Version:    0.7.0.1
 */