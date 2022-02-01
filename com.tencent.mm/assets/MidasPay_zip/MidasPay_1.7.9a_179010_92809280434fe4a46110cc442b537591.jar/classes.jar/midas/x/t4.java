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

public class t4
  extends q4
  implements fc
{
  public void a(ob paramob)
  {
    g(paramob);
  }
  
  public void b(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    paramContext = (APMonthRequest)paramAPBaseRequest;
    z1.d().e(paramContext.serviceCode, this);
  }
  
  public void b(ob paramob)
  {
    f(paramob);
  }
  
  public void c(ob paramob) {}
  
  public void e(ob paramob)
  {
    if ((!(p4.p().e().b instanceof APMonthRequest)) && (!(p4.p().e().b instanceof APSubscribeRequest)))
    {
      z5.a(12, "访问太频繁了");
      APUICommonMethod.f();
      return;
    }
    r0.p().e(true);
    APHFChannel.j();
    Object localObject2 = (i3)paramob;
    APHFChannel.c(((i3)localObject2).l());
    if (d()) {
      return;
    }
    g6.k().e();
    paramob = new Intent();
    if (((z4)p4.p().e().c).l == 3)
    {
      ((z4)p4.p().e().c).c = g6.k().h();
      if (i.b(g6.k().g()) <= 0)
      {
        APUICommonMethod.b();
        APUICommonMethod.a(this.d, "该业务暂时不支持升级");
        z5.a(3, "该业务暂时不支持升级");
        return;
      }
    }
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!this.e.isCanChange)
      {
        int i;
        if (((z4)p4.p().e().c).l == 3)
        {
          ((z4)p4.p().e().c).c = g6.k().h();
          i = i.b(g6.k().g());
          if (i.b(this.e.saveValue) > i)
          {
            APUICommonMethod.b();
            APUICommonMethod.a(this.d, "升级数量不能超过开通数量");
            z5.a(3, "升级数量不能超过开通数量");
            return;
          }
        }
        c6.s0().A("AndroidPay");
        Object localObject1 = p4.p().e().f.i;
        paramob = (ob)localObject1;
        if (!v0.g()) {
          if (!"bank".equals(localObject1))
          {
            paramob = (ob)localObject1;
            if (!"cft".equals(localObject1)) {}
          }
          else
          {
            p4.p().e().f.i = "";
            paramob = "";
          }
        }
        Bundle localBundle = new Bundle();
        if ((!TextUtils.isEmpty(paramob)) && (("qdqb".equals(paramob)) || ("qbqd".equals(paramob))))
        {
          i = ((d2)localObject2).j();
          localObject1 = ((d2)localObject2).i();
          String str = ((d2)localObject2).g();
          localObject2 = ((d2)localObject2).h();
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
        APUICommonMethod.b();
        localObject1 = paramob;
        if (TextUtils.isEmpty(paramob)) {
          localObject1 = "channelList";
        }
        e5.h().a(this.d, (String)localObject1, localBundle);
        return;
      }
      APUICommonMethod.b();
      c6.s0().A("APPayGameInputNumActivity");
      paramob.setClass(this.d, APPayStoreActivity.class);
      this.d.startActivity(paramob);
      return;
    }
    APUICommonMethod.b();
    c6.s0().A("APPayGameListNumActivity");
    paramob.setClass(this.d, APPayStoreActivity.class);
    this.d.startActivity(paramob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.t4
 * JD-Core Version:    0.7.0.1
 */