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
  private String a = APNetRequest.NET_REQ_QQ;
  private APNetRequest b = null;
  private IAPNetCallBack c = null;
  
  private void d()
  {
    new ex((Activity)a.a().c.get()).a(new c.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        if (paramAnonymousInt == 0)
        {
          if (a.a().b != null) {
            a.a().b.MidasNetFinish(a.a().h, paramAnonymousString);
          }
        }
        else if (paramAnonymousInt == 3)
        {
          if (a.a().b != null) {
            a.a().b.MidasNetError(a.a().h, 1018, paramAnonymousString);
          }
        }
        else if (a.a().b != null) {
          a.a().b.MidasNetError(a.a().h, paramAnonymousInt, paramAnonymousString);
        }
      }
    });
  }
  
  private void e()
  {
    if (this.a.equals(APNetRequest.NET_REQ_QQ))
    {
      f();
      return;
    }
    if (this.a.equals(APNetRequest.NET_REQ_FRIENDSPAY))
    {
      d();
      return;
    }
    if (this.a.equals("initreport")) {
      b();
    }
  }
  
  private void f()
  {
    da localda = new da(this.b.openId, this.b.openKey, this.b.sessionId, this.b.sessionType, this.b.pf, this.b.pfKey);
    cz localcz = new cz(this.b.reqType, new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        paramAnonymousjw = (cz)paramAnonymousjw;
        b.a(b.this).MidasNetFinish(paramAnonymousjw.a, paramAnonymousjw.a());
      }
      
      public void b(jw paramAnonymousjw)
      {
        b.a(b.this).MidasNetError(((cz)paramAnonymousjw).a, paramAnonymousjw.R(), paramAnonymousjw.T());
      }
      
      public void c(jw paramAnonymousjw)
      {
        b.a(b.this).MidasNetStop(((cz)paramAnonymousjw).a);
      }
    });
    bs.a().a(localda, localcz);
  }
  
  public void a()
  {
    this.a = "initreport";
    e();
  }
  
  public void a(IAPNetCallBack paramIAPNetCallBack)
  {
    this.a = APNetRequest.NET_REQ_FRIENDSPAY;
    this.c = paramIAPNetCallBack;
    e();
  }
  
  public void a(APNetRequest paramAPNetRequest, IAPNetCallBack paramIAPNetCallBack)
  {
    this.a = APNetRequest.NET_REQ_QQ;
    this.b = paramAPNetRequest;
    this.c = paramIAPNetCallBack;
    e();
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(ed.b().n().a.offerId)) {
      return;
    }
    cu localcu = new cu();
    ct localct = new ct(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        b.this.c();
      }
      
      public void b(jw paramAnonymousjw) {}
      
      public void c(jw paramAnonymousjw) {}
    });
    bs.a().a(localcu, localct);
  }
  
  public void c()
  {
    APLog.i("APGetNetInfo", "updateSDK enter");
    ArrayList localArrayList = aq.a().b();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSDK list size:");
      localStringBuilder.append(localArrayList.size());
      APLog.i("APGetNetInfo", localStringBuilder.toString());
      if ((aq.a().e()) || (aq.a().d()) || (APAppDataInterface.singleton().i() == 1000))
      {
        APDataReportManager.getInstance().a("sdk.update.advise.wifi.enter", "totalnumber");
        new av(a.a().d).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.b
 * JD-Core Version:    0.7.0.1
 */