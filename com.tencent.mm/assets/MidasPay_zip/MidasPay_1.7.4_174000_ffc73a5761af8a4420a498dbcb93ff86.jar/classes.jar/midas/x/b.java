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
    new fg((Activity)a.a().c.get()).a(new c.a()
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
    dg localdg = new dg(this.b.openId, this.b.openKey, this.b.sessionId, this.b.sessionType, this.b.pf, this.b.pfKey);
    df localdf = new df(this.b.reqType, new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        paramAnonymouslh = (df)paramAnonymouslh;
        b.a(b.this).MidasNetFinish(paramAnonymouslh.a, paramAnonymouslh.a());
      }
      
      public void b(lh paramAnonymouslh)
      {
        b.a(b.this).MidasNetError(((df)paramAnonymouslh).a, paramAnonymouslh.T(), paramAnonymouslh.V());
      }
      
      public void c(lh paramAnonymouslh)
      {
        b.a(b.this).MidasNetStop(((df)paramAnonymouslh).a);
      }
    });
    by.a().a(localdg, localdf);
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
    if (TextUtils.isEmpty(em.b().n().a.offerId)) {
      return;
    }
    da localda = new da();
    cz localcz = new cz(new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        b.this.c();
      }
      
      public void b(lh paramAnonymouslh) {}
      
      public void c(lh paramAnonymouslh) {}
    });
    by.a().a(localda, localcz);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.b
 * JD-Core Version:    0.7.0.1
 */