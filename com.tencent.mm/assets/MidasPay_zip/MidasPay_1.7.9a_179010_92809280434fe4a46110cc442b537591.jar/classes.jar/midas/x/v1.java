package midas.x;

import android.os.Handler;
import android.os.Looper;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class v1
{
  public static String d = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk0mgJIYskKsV909vz9/i\rms2C+3tOt03j8zm1cY7okk02qqoSXNCgzeFgSPgUXPwXGZpgw+Sdpz6WBO4EapKk\rDTStTII1iee1LKJmkotUn/G44lQsaEcKfd9HIZzhcboBEhhAMGi+sro50gnozrtd\rpQscRK6JeDD1w0+NmtqojZaAd5NZMw3pjKaPWskNoks8cvj3e+ly7S5ejcN8QoL7\rX6AV0+cY3txhkLMaB07Z8Ks+P9+rDyIxaCGDkem3u2/RdjIy4yA8sMNITOQ6PQC1\rMTUjYykNp7x8guBuy2LEXsA4ZUfVsHcPK5p2bqv17asA6hHNGO0JKxDLWBuOlDD9\ruQIDAQAB\r";
  public String a;
  public APBaseRequest b;
  public ConcurrentHashMap<String, d> c = new ConcurrentHashMap();
  
  public v1()
  {
    u9 localu9 = r9.b();
    localu9.a(new a());
    localu9.a(Long.valueOf(15L), TimeUnit.SECONDS);
    localu9.a(new b());
    localu9.a(d);
  }
  
  public static v1 e()
  {
    return e.a();
  }
  
  public d a(String paramString)
  {
    return (d)this.c.remove(paramString);
  }
  
  public d a(String paramString, d paramd)
  {
    return (d)this.c.put(paramString, paramd);
  }
  
  public void a() {}
  
  public void a(String paramString, u9.d paramd, APBaseRequest paramAPBaseRequest)
  {
    Object localObject = this.a;
    if ((localObject == null) || (((String)localObject).equals(paramString)))
    {
      localObject = this.b;
      if ((localObject == null) || (((APBaseRequest)localObject).offerId.equals(paramAPBaseRequest.offerId))) {}
    }
    else
    {
      r9.a();
    }
    this.a = paramString;
    this.b = paramAPBaseRequest;
    if (paramd != null) {
      r9.b().a(paramd);
    }
    paramd = new s9();
    localObject = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://");
    localStringBuilder.append((String)localObject);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://");
    localStringBuilder.append((String)localObject);
    paramd.a = localStringBuilder.toString();
    paramd.b = "/cgi-bin/msg/access/client-register";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("wss://");
    localStringBuilder.append((String)localObject);
    paramd.c = localStringBuilder.toString();
    paramd.d = "/cgi-bin/msg/ws";
    paramd.e = paramAPBaseRequest.offerId;
    paramd.f = paramAPBaseRequest.openId;
    paramd.g = paramAPBaseRequest.openKey;
    paramd.h = paramAPBaseRequest.sessionId;
    paramd.i = paramAPBaseRequest.sessionType;
    paramd.j = paramAPBaseRequest.pf;
    paramd.k = paramAPBaseRequest.pfKey;
    paramd.l = z5.c();
    paramd.m = "midas";
    paramd.n = paramString;
    r9.a(new Handler(Looper.getMainLooper()), paramd, new c());
  }
  
  public void a(s1 params1)
  {
    if ((params1 != null) && (params1.c != null))
    {
      r9.a(params1.e(), params1.d, params1.e, params1.f);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send() data error : apwsText = ");
    localStringBuilder.append(params1);
    APLog.w("MidasPushManager", localStringBuilder.toString());
  }
  
  public String b()
  {
    String str = APAppDataInterface.singleton().h();
    if (str.equals("custom"))
    {
      if (APAppDataInterface.singleton().f().equals("dev")) {
        return "sandbox.msg.midas.qq.com";
      }
      return "msg.midas.qq.com";
    }
    if (str.equals("dev")) {
      return "dev.msg.midas.qq.com";
    }
    if (str.equals("test")) {
      return "sandbox.msg.midas.qq.com";
    }
    if (str.equals("release")) {
      return "msg.midas.qq.com";
    }
    if (str.equals("testing")) {
      return "testing.api.unipay.qq.com";
    }
    return "msg.midas.qq.com";
  }
  
  public int c()
  {
    return this.c.size();
  }
  
  public void d()
  {
    a(this.a, null, this.b);
  }
  
  public class a
    implements u9.b
  {
    public a() {}
    
    public void a(String paramString1, String paramString2)
    {
      APLog.w(paramString1, paramString2);
    }
    
    public void b(String paramString1, String paramString2)
    {
      APLog.d(paramString1, paramString2);
    }
    
    public void c(String paramString1, String paramString2)
    {
      APLog.i(paramString1, paramString2);
    }
    
    public void d(String paramString1, String paramString2)
    {
      APLog.e(paramString1, paramString2);
    }
  }
  
  public class b
    implements u9.c
  {
    public b() {}
  }
  
  public class c
    implements q9
  {
    public c() {}
    
    public void a(int paramInt, String paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClose() code = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", reason = ");
      ((StringBuilder)localObject).append(paramString);
      APLog.d("MidasPushManager", ((StringBuilder)localObject).toString());
      APDataReportManager.getInstance().insertData("sdk.cloudgame.push.close", 0, p4.p().e().f.k, null, null);
      localObject = v1.a(v1.this).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((v1.d)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramInt, paramString);
      }
    }
    
    public void a(int paramInt, v9 paramv9) {}
    
    public void a(t9 paramt9)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFailure() response = ");
      ((StringBuilder)localObject).append(paramt9);
      APLog.d("MidasPushManager", ((StringBuilder)localObject).toString());
      localObject = APDataReportManager.getInstance();
      String str = p4.p().e().f.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("err=");
      localStringBuilder.append(paramt9);
      ((APDataReportManager)localObject).insertData("sdk.cloudgame.push.error", 0, str, null, localStringBuilder.toString());
      localObject = v1.a(v1.this).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((v1.d)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramt9);
      }
    }
    
    public void a(x9 paramx9)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMessage() wsText = ");
      ((StringBuilder)localObject).append(paramx9);
      APLog.d("MidasPushManager", ((StringBuilder)localObject).toString());
      if (String.valueOf(paramx9.j).length() == 10) {
        paramx9.j *= 1000L;
      }
      if (System.currentTimeMillis() - paramx9.j > 15000L)
      {
        APLog.w("MidasPushManager", "onMessage() timeout, return");
        return;
      }
      paramx9 = s1.a(paramx9);
      localObject = v1.a(v1.this).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((v1.d)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramx9);
      }
    }
    
    public void b(int paramInt, String paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onOpen() code = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", message = ");
      ((StringBuilder)localObject).append(paramString);
      APLog.d("MidasPushManager", ((StringBuilder)localObject).toString());
      APDataReportManager.getInstance().insertData("sdk.cloudgame.push.open", 0, p4.p().e().f.k, null, null);
      localObject = v1.a(v1.this).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((v1.d)((Map.Entry)((Iterator)localObject).next()).getValue()).b(paramInt, paramString);
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, String paramString);
    
    public abstract void a(s1 params1);
    
    public abstract void a(t9 paramt9);
    
    public abstract void b(int paramInt, String paramString);
  }
  
  public static class e
  {
    public static v1 a = new v1(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.v1
 * JD-Core Version:    0.7.0.1
 */