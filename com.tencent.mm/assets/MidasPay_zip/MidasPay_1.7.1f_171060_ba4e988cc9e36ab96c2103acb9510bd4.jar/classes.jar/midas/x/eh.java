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

public class eh
  extends ee
  implements kl
{
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    paramContext = (APMonthRequest)paramAPBaseRequest;
    bs.a().b(paramContext.serviceCode, this);
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
    if ((!(ed.b().n().a instanceof APMonthRequest)) && (!(ed.b().n().a instanceof APSubscribeRequest)))
    {
      fm.a(12, "访问太频繁了");
      APUICommonMethod.b();
      return;
    }
    aq.a().d(true);
    APHFChannel.f();
    Object localObject2 = (db)paramjw;
    APHFChannel.c(((db)localObject2).e());
    if (a()) {
      return;
    }
    fs.a().f();
    paramjw = new Intent();
    if (((en)ed.b().n().b).l == 3)
    {
      ((en)ed.b().n().b).e = fs.a().c();
      if (i.a(fs.a().d()) <= 0)
      {
        APUICommonMethod.g();
        APUICommonMethod.a(this.d, "该业务暂时不支持升级");
        fm.a(3, "该业务暂时不支持升级");
        return;
      }
    }
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!this.e.isCanChange)
      {
        int i;
        if (((en)ed.b().n().b).l == 3)
        {
          ((en)ed.b().n().b).e = fs.a().c();
          i = i.a(fs.a().d());
          if (i.a(this.e.saveValue) > i)
          {
            APUICommonMethod.g();
            APUICommonMethod.a(this.d, "升级数量不能超过开通数量");
            fm.a(3, "升级数量不能超过开通数量");
            return;
          }
        }
        fp.a().b("AndroidPay");
        Object localObject1 = ed.b().n().e.j;
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
        Bundle localBundle = new Bundle();
        if ((!TextUtils.isEmpty(paramjw)) && (("qdqb".equals(paramjw)) || ("qbqd".equals(paramjw))))
        {
          i = ((db)localObject2).c();
          localObject1 = ((db)localObject2).d();
          String str = ((db)localObject2).a();
          localObject2 = ((db)localObject2).b();
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
      }
      APUICommonMethod.g();
      fp.a().b("APPayGameInputNumActivity");
      paramjw.setClass(this.d, APPayStoreActivity.class);
      this.d.startActivity(paramjw);
      return;
    }
    APUICommonMethod.g();
    fp.a().b("APPayGameListNumActivity");
    paramjw.setClass(this.d, APPayStoreActivity.class);
    this.d.startActivity(paramjw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.eh
 * JD-Core Version:    0.7.0.1
 */