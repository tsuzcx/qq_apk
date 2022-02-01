package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payCenter.APPayStoreActivity;

public class eq
  extends en
  implements lw
{
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    paramContext = (APMonthRequest)paramAPBaseRequest;
    by.a().b(paramContext.serviceCode, this);
  }
  
  public void a(lh paramlh)
  {
    g(paramlh);
  }
  
  public void b(lh paramlh)
  {
    f(paramlh);
  }
  
  public void c(lh paramlh) {}
  
  protected void d(lh paramlh)
  {
    if ((!(em.b().n().a instanceof APMonthRequest)) && (!(em.b().n().a instanceof APSubscribeRequest)))
    {
      fv.a(12, "访问太频繁了");
      APUICommonMethod.b();
      return;
    }
    aq.a().d(true);
    APHFChannel.f();
    Object localObject2 = (dh)paramlh;
    APHFChannel.b(((dh)localObject2).e());
    if (a()) {
      return;
    }
    gc.a().f();
    paramlh = new Intent();
    if (((ew)em.b().n().b).l == 3)
    {
      ((ew)em.b().n().b).e = gc.a().c();
      if (i.a(gc.a().d()) <= 0)
      {
        APUICommonMethod.g();
        APUICommonMethod.a(this.d, "该业务暂时不支持升级");
        fv.a(3, "该业务暂时不支持升级");
        return;
      }
    }
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!this.e.isCanChange)
      {
        int i;
        if (((ew)em.b().n().b).l == 3)
        {
          ((ew)em.b().n().b).e = gc.a().c();
          i = i.a(gc.a().d());
          if (i.a(this.e.saveValue) > i)
          {
            APUICommonMethod.g();
            APUICommonMethod.a(this.d, "升级数量不能超过开通数量");
            fv.a(3, "升级数量不能超过开通数量");
            return;
          }
        }
        fy.a().b("AndroidPay");
        Object localObject1 = em.b().n().e.j;
        paramlh = (lh)localObject1;
        if (!au.a()) {
          if (!"bank".equals(localObject1))
          {
            paramlh = (lh)localObject1;
            if (!"cft".equals(localObject1)) {}
          }
          else
          {
            em.b().n().e.j = "";
            paramlh = "";
          }
        }
        Bundle localBundle = new Bundle();
        if ((!TextUtils.isEmpty(paramlh)) && (("qdqb".equals(paramlh)) || ("qbqd".equals(paramlh))))
        {
          i = ((dh)localObject2).c();
          localObject1 = ((dh)localObject2).d();
          String str = ((dh)localObject2).a();
          localObject2 = ((dh)localObject2).b();
          if (((String)localObject2).length() > 0)
          {
            if (((String)localObject1).equals("1")) {
              localBundle.putBoolean("smsMbOnly", true);
            } else {
              localBundle.putBoolean("smsMbOnly", false);
            }
            localBundle.putInt("smsRemain", i);
            localBundle.putString("mbUrl", str);
            localBundle.putString("mbSmsInfo", (String)localObject2);
            localBundle.putString("mbType", "smsMb");
          }
        }
        APUICommonMethod.g();
        localObject1 = paramlh;
        if (TextUtils.isEmpty(paramlh)) {
          localObject1 = "channelList";
        }
        fb.a().a(this.d, (String)localObject1, localBundle);
        return;
      }
      APUICommonMethod.g();
      fy.a().b("APPayGameInputNumActivity");
      paramlh.setClass(this.d, APPayStoreActivity.class);
      this.d.startActivity(paramlh);
      return;
    }
    APUICommonMethod.g();
    fy.a().b("APPayGameListNumActivity");
    paramlh.setClass(this.d, APPayStoreActivity.class);
    this.d.startActivity(paramlh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.eq
 * JD-Core Version:    0.7.0.1
 */