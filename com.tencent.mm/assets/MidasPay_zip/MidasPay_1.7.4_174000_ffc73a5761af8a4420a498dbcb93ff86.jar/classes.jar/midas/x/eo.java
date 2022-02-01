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

public class eo
  extends en
  implements lw
{
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    APLog.i("APBuyGame", "buyInfo");
    by.a().a(this);
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
    if (!(em.b().n().a instanceof APGameRequest))
    {
      fv.a(12, "访问太频繁了");
      APUICommonMethod.b();
      return;
    }
    aq.a().d(true);
    APHFChannel.f();
    Object localObject1 = new Intent();
    Object localObject2 = (dd)paramlh;
    APHFChannel.b(((dd)localObject2).e());
    if (a()) {
      return;
    }
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!APTools.k(this.e.saveValue))
      {
        fv.a(3, this.d.getString(2131230774));
        return;
      }
      if ((!this.e.isCanChange) && (fy.a().ae() <= 0)) {}
    }
    try
    {
      i = Integer.parseInt(this.e.saveValue);
    }
    catch (Exception paramlh)
    {
      int i;
      label139:
      Bundle localBundle;
      String str;
      break label139;
    }
    i = 0;
    if ((i != 0) && (i > fy.a().ae()))
    {
      fv.a(3, this.d.getString(2131230775));
      return;
    }
    fy.a().b("AndroidPay");
    localObject1 = em.b().n().e.j;
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
    localBundle = new Bundle();
    if ((!TextUtils.isEmpty(paramlh)) && (("qdqb".equals(paramlh)) || ("qbqd".equals(paramlh))))
    {
      i = ((dd)localObject2).c();
      localObject1 = ((dd)localObject2).d();
      str = ((dd)localObject2).a();
      localObject2 = ((dd)localObject2).b();
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
    APUICommonMethod.g();
    fy.a().b("APPayGameInputNumActivity");
    ((Intent)localObject1).setClass(this.d, APPayStoreActivity.class);
    break label443;
    APUICommonMethod.g();
    fy.a().b("APPayGameListNumActivity");
    ((Intent)localObject1).setClass(this.d, APPayStoreActivity.class);
    label443:
    this.d.startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.eo
 * JD-Core Version:    0.7.0.1
 */