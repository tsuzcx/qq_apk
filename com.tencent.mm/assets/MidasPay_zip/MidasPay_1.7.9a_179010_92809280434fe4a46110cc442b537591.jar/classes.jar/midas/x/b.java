package midas.x;

import android.app.Activity;
import android.text.TextUtils;
import com.pay.api.IAPNetCallBack;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APNetRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class b
{
  public String a = APNetRequest.NET_REQ_QQ;
  public APNetRequest b = null;
  public IAPNetCallBack c = null;
  
  public final void a()
  {
    Object localObject = this.b;
    localObject = new h3(((APBaseRequest)localObject).openId, ((APBaseRequest)localObject).openKey, ((APBaseRequest)localObject).sessionId, ((APBaseRequest)localObject).sessionType, ((APBaseRequest)localObject).pf, ((APBaseRequest)localObject).pfKey);
    g3 localg3 = new g3(this.b.reqType, new b());
    z1.d().a((qb)localObject, localg3);
  }
  
  public void a(IAPNetCallBack paramIAPNetCallBack)
  {
    this.a = APNetRequest.NET_REQ_FRIENDSPAY;
    this.c = paramIAPNetCallBack;
    b();
  }
  
  public void a(APNetRequest paramAPNetRequest, IAPNetCallBack paramIAPNetCallBack)
  {
    this.a = APNetRequest.NET_REQ_QQ;
    this.b = paramAPNetRequest;
    this.c = paramIAPNetCallBack;
    b();
  }
  
  public final void b()
  {
    if (this.a.equals(APNetRequest.NET_REQ_QQ))
    {
      a();
      return;
    }
    if (this.a.equals(APNetRequest.NET_REQ_FRIENDSPAY))
    {
      c();
      return;
    }
    if (this.a.equals("initreport")) {
      e();
    }
  }
  
  public final void c()
  {
    new j5((Activity)a.r().c.get()).a(new a());
  }
  
  public void d()
  {
    this.a = "initreport";
    b();
  }
  
  public void e()
  {
    if (TextUtils.isEmpty(p4.p().e().b.offerId)) {
      return;
    }
    b3 localb3 = new b3();
    a3 locala3 = new a3(new c());
    z1.d().a(localb3, locala3);
  }
  
  public void f()
  {
    APLog.i("APGetNetInfo", "updateSDK enter");
    ArrayList localArrayList = r0.p().b();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSDK list size:");
      localStringBuilder.append(localArrayList.size());
      APLog.i("APGetNetInfo", localStringBuilder.toString());
      if ((r0.p().o()) || (r0.p().i()) || (APAppDataInterface.singleton().s() == 1000))
      {
        APDataReportManager.getInstance().a("sdk.update.advise.wifi.enter", "totalnumber");
        new w0(a.r().d).e();
      }
    }
  }
  
  public class a
    implements c.b
  {
    public a() {}
    
    public void a(int paramInt, String paramString)
    {
      if (paramInt == 0)
      {
        if (a.r().b != null) {
          a.r().b.MidasNetFinish(a.r().l, paramString);
        }
      }
      else if (paramInt == 3)
      {
        if (a.r().b != null) {
          a.r().b.MidasNetError(a.r().l, 1018, paramString);
        }
      }
      else if (a.r().b != null) {
        a.r().b.MidasNetError(a.r().l, paramInt, paramString);
      }
    }
  }
  
  public class b
    implements fc
  {
    public b() {}
    
    public void a(ob paramob)
    {
      paramob = (g3)paramob;
      b.a(b.this).MidasNetFinish(paramob.i, paramob.g());
    }
    
    public void b(ob paramob)
    {
      b.a(b.this).MidasNetError(((g3)paramob).i, paramob.d(), paramob.c());
    }
    
    public void c(ob paramob)
    {
      b.a(b.this).MidasNetStop(((g3)paramob).i);
    }
  }
  
  public class c
    implements fc
  {
    public c() {}
    
    public void a(ob paramob)
    {
      b.this.f();
    }
    
    public void b(ob paramob) {}
    
    public void c(ob paramob) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.b
 * JD-Core Version:    0.7.0.1
 */