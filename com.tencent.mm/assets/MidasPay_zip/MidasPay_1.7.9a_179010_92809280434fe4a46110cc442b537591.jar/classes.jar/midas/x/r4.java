package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGameRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payCenter.APPayStoreActivity;
import com.tencent.midas.comm.APLog;

public class r4
  extends q4
  implements fc
{
  public void a(ob paramob)
  {
    g(paramob);
  }
  
  public void b(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    APLog.i("APBuyGame", "buyInfo");
    z1.d().h(this);
  }
  
  public void b(ob paramob)
  {
    f(paramob);
  }
  
  public void c(ob paramob) {}
  
  public void e(ob paramob)
  {
    if (!(p4.p().e().b instanceof APGameRequest))
    {
      z5.a(12, "访问太频繁了");
      APUICommonMethod.f();
      return;
    }
    r0.p().e(true);
    APHFChannel.j();
    Object localObject1 = new Intent();
    Object localObject2 = (e3)paramob;
    APHFChannel.c(((e3)localObject2).l());
    if (d()) {
      return;
    }
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!APTools.f(this.e.saveValue))
      {
        z5.a(3, this.d.getString(2131230774));
        return;
      }
      if ((!this.e.isCanChange) && (c6.s0().n() <= 0)) {}
    }
    try
    {
      i = Integer.parseInt(this.e.saveValue);
    }
    catch (Exception paramob)
    {
      int i;
      label139:
      Bundle localBundle;
      String str;
      break label139;
    }
    i = 0;
    if ((i != 0) && (i > c6.s0().n()))
    {
      z5.a(3, this.d.getString(2131230775));
      return;
    }
    c6.s0().A("AndroidPay");
    localObject1 = p4.p().e().f.i;
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
    localBundle = new Bundle();
    if ((!TextUtils.isEmpty(paramob)) && (("qdqb".equals(paramob)) || ("qbqd".equals(paramob))))
    {
      i = ((d2)localObject2).j();
      localObject1 = ((d2)localObject2).i();
      str = ((d2)localObject2).g();
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
    APUICommonMethod.b();
    c6.s0().A("APPayGameInputNumActivity");
    ((Intent)localObject1).setClass(this.d, APPayStoreActivity.class);
    break label443;
    APUICommonMethod.b();
    c6.s0().A("APPayGameListNumActivity");
    ((Intent)localObject1).setClass(this.d, APPayStoreActivity.class);
    label443:
    this.d.startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.r4
 * JD-Core Version:    0.7.0.1
 */