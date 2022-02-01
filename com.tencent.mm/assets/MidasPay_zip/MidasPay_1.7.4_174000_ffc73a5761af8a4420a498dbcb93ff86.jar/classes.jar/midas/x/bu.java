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

public class bu
{
  private static String b = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk0mgJIYskKsV909vz9/i\rms2C+3tOt03j8zm1cY7okk02qqoSXNCgzeFgSPgUXPwXGZpgw+Sdpz6WBO4EapKk\rDTStTII1iee1LKJmkotUn/G44lQsaEcKfd9HIZzhcboBEhhAMGi+sro50gnozrtd\rpQscRK6JeDD1w0+NmtqojZaAd5NZMw3pjKaPWskNoks8cvj3e+ly7S5ejcN8QoL7\rX6AV0+cY3txhkLMaB07Z8Ks+P9+rDyIxaCGDkem3u2/RdjIy4yA8sMNITOQ6PQC1\rMTUjYykNp7x8guBuy2LEXsA4ZUfVsHcPK5p2bqv17asA6hHNGO0JKxDLWBuOlDD9\ruQIDAQAB\r";
  private String a;
  private ConcurrentHashMap<String, a> c = new ConcurrentHashMap();
  
  private bu()
  {
    jo localjo = jl.a();
    localjo.a(new jo.a()
    {
      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        APLog.i(paramAnonymousString1, paramAnonymousString2);
      }
      
      public void b(String paramAnonymousString1, String paramAnonymousString2)
      {
        APLog.d(paramAnonymousString1, paramAnonymousString2);
      }
      
      public void c(String paramAnonymousString1, String paramAnonymousString2)
      {
        APLog.w(paramAnonymousString1, paramAnonymousString2);
      }
      
      public void d(String paramAnonymousString1, String paramAnonymousString2)
      {
        APLog.e(paramAnonymousString1, paramAnonymousString2);
      }
    });
    localjo.a(Long.valueOf(15L), TimeUnit.SECONDS);
    localjo.a(new jo.b() {});
    localjo.a(b);
  }
  
  public static bu a()
  {
    return b.a();
  }
  
  public a a(String paramString)
  {
    return (a)this.c.remove(paramString);
  }
  
  public a a(String paramString, a parama)
  {
    return (a)this.c.put(paramString, parama);
  }
  
  public void a(String paramString, jo.c paramc)
  {
    this.a = paramString;
    APDataReportManager.getInstance().insertData("sdk.cloudgame.push.connect", 0, em.b().n().e.l, null, null);
    if (paramc != null) {
      jl.a().a(paramc);
    }
    paramc = em.b().n();
    jm localjm = new jm();
    String str = c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://");
    localStringBuilder.append(str);
    localjm.a = localStringBuilder.toString();
    localjm.b = "/cgi-bin/msg/access/gateway-list";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://");
    localStringBuilder.append(str);
    localjm.c = localStringBuilder.toString();
    localjm.d = "/cgi-bin/msg/access/client-register";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("wss://");
    localStringBuilder.append(str);
    localjm.e = localStringBuilder.toString();
    localjm.f = "/cgi-bin/msg/ws";
    localjm.g = em.b().f();
    localjm.h = paramc.a.openId;
    localjm.i = paramc.a.openKey;
    localjm.j = paramc.a.sessionId;
    localjm.k = paramc.a.sessionType;
    localjm.l = paramc.a.pf;
    localjm.m = paramc.a.pfKey;
    localjm.n = fv.c();
    localjm.o = "midas";
    localjm.p = paramString;
    jl.a(new Handler(Looper.getMainLooper()), localjm, new jk()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClose() code = ");
        ((StringBuilder)localObject).append(paramAnonymousInt);
        ((StringBuilder)localObject).append(", reason = ");
        ((StringBuilder)localObject).append(paramAnonymousString);
        APLog.d("MidasPushManager", ((StringBuilder)localObject).toString());
        APDataReportManager.getInstance().insertData("sdk.cloudgame.push.close", 0, em.b().n().e.l, null, null);
        localObject = bu.a(bu.this).entrySet().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bu.a)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramAnonymousInt, paramAnonymousString);
        }
      }
      
      public void a(int paramAnonymousInt, jp paramAnonymousjp) {}
      
      public void a(jn paramAnonymousjn)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onFailure() response = ");
        ((StringBuilder)localObject).append(paramAnonymousjn);
        APLog.d("MidasPushManager", ((StringBuilder)localObject).toString());
        localObject = APDataReportManager.getInstance();
        String str = em.b().n().e.l;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("err=");
        localStringBuilder.append(paramAnonymousjn);
        ((APDataReportManager)localObject).insertData("sdk.cloudgame.push.error", 0, str, null, localStringBuilder.toString());
        localObject = bu.a(bu.this).entrySet().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bu.a)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramAnonymousjn);
        }
      }
      
      public void a(jr paramAnonymousjr)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onMessage() wsText = ");
        ((StringBuilder)localObject).append(paramAnonymousjr);
        APLog.d("MidasPushManager", ((StringBuilder)localObject).toString());
        if (String.valueOf(paramAnonymousjr.j).length() == "1590051462".length()) {
          paramAnonymousjr.j *= 1000L;
        }
        if (System.currentTimeMillis() - paramAnonymousjr.j > 15000L)
        {
          APLog.w("MidasPushManager", "onMessage() timeout, return");
          return;
        }
        paramAnonymousjr = br.a(paramAnonymousjr);
        localObject = bu.a(bu.this).entrySet().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bu.a)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramAnonymousjr);
        }
      }
      
      public void b(int paramAnonymousInt, String paramAnonymousString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onOpen() code = ");
        ((StringBuilder)localObject).append(paramAnonymousInt);
        ((StringBuilder)localObject).append(", message = ");
        ((StringBuilder)localObject).append(paramAnonymousString);
        APLog.d("MidasPushManager", ((StringBuilder)localObject).toString());
        APDataReportManager.getInstance().insertData("sdk.cloudgame.push.open", 0, em.b().n().e.l, null, null);
        localObject = bu.a(bu.this).entrySet().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bu.a)((Map.Entry)((Iterator)localObject).next()).getValue()).b(paramAnonymousInt, paramAnonymousString);
        }
      }
    });
  }
  
  public void a(br parambr)
  {
    if ((parambr != null) && (parambr.c != null))
    {
      jl.a(parambr.e(), parambr.d, parambr.e, parambr.f);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send() data error : apwsText = ");
    localStringBuilder.append(parambr);
    APLog.w("MidasPushManager", localStringBuilder.toString());
  }
  
  public int b()
  {
    return this.c.size();
  }
  
  public String c()
  {
    String str = APAppDataInterface.singleton().e();
    if (str.equals("custom"))
    {
      if (APAppDataInterface.singleton().k().equals("dev")) {
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
  
  public void d()
  {
    a(this.a, null);
  }
  
  public void e()
  {
    jl.b();
    APDataReportManager.getInstance().insertData("sdk.cloudgame.push.dismiss", 0, em.b().n().e.l, null, null);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString);
    
    public abstract void a(br parambr);
    
    public abstract void a(jn paramjn);
    
    public abstract void b(int paramInt, String paramString);
  }
  
  static class b
  {
    private static bu a = new bu(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.bu
 * JD-Core Version:    0.7.0.1
 */