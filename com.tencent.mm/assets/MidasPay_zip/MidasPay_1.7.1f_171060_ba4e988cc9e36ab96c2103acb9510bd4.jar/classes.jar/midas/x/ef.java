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

public class ef
  extends ee
  implements kl
{
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    APLog.i("APBuyGame", "buyInfo");
    bs.a().a(this);
  }
  
  public void a(jw paramjw)
  {
    g(paramjw);
  }
  
  public void b(jw paramjw)
  {
    f(paramjw);
  }
  
  public void c(jw paramjw) {}
  
  protected void d(jw paramjw)
  {
    if (!(ed.b().n().a instanceof APGameRequest))
    {
      fm.a(12, "访问太频繁了");
      APUICommonMethod.b();
      return;
    }
    aq.a().d(true);
    APHFChannel.f();
    Object localObject1 = new Intent();
    Object localObject2 = (cx)paramjw;
    APHFChannel.c(((cx)localObject2).e());
    if (a()) {
      return;
    }
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!APTools.k(this.e.saveValue))
      {
        fm.a(3, this.d.getString(2131230773));
        return;
      }
      if ((!this.e.isCanChange) && (fp.a().ae() <= 0)) {}
    }
    try
    {
      i = Integer.parseInt(this.e.saveValue);
    }
    catch (Exception paramjw)
    {
      int i;
      label139:
      Bundle localBundle;
      String str;
      break label139;
    }
    i = 0;
    if ((i != 0) && (i > fp.a().ae()))
    {
      fm.a(3, this.d.getString(2131230774));
      return;
    }
    fp.a().b("AndroidPay");
    localObject1 = ed.b().n().e.j;
    paramjw = (jw)localObject1;
    if (!au.a()) {
      if (!"bank".equals(localObject1))
      {
        paramjw = (jw)localObject1;
        if (!"cft".equals(localObject1)) {}
      }
      else
      {
        ed.b().n().e.j = "";
        paramjw = "";
      }
    }
    localBundle = new Bundle();
    if ((!TextUtils.isEmpty(paramjw)) && (("qdqb".equals(paramjw)) || ("qbqd".equals(paramjw))))
    {
      i = ((cx)localObject2).c();
      localObject1 = ((cx)localObject2).d();
      str = ((cx)localObject2).a();
      localObject2 = ((cx)localObject2).b();
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
    localObject1 = paramjw;
    if (TextUtils.isEmpty(paramjw)) {
      localObject1 = "channelList";
    }
    es.a().a(this.d, (String)localObject1, localBundle);
    return;
    APUICommonMethod.g();
    fp.a().b("APPayGameInputNumActivity");
    ((Intent)localObject1).setClass(this.d, APPayStoreActivity.class);
    break label443;
    APUICommonMethod.g();
    fp.a().b("APPayGameListNumActivity");
    ((Intent)localObject1).setClass(this.d, APPayStoreActivity.class);
    label443:
    this.d.startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ef
 * JD-Core Version:    0.7.0.1
 */