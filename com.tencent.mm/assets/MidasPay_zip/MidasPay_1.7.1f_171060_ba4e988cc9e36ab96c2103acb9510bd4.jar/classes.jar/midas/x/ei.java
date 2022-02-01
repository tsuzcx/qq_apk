package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payCenter.APPayStoreActivity;
import com.tencent.midas.comm.APLog;

public class ei
  extends ee
  implements kl
{
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    APLog.i("APQBInfo", "buyInfo");
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
    ed.b().n().b.b = "Q币";
    aq.a().d(true);
    Object localObject = new Intent();
    APHFChannel.c(((cx)paramjw).e());
    if (a()) {
      return;
    }
    APHFChannel.f();
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!this.e.isCanChange)
      {
        fp.a().b("AndroidPay");
        localObject = ed.b().n().e.j;
        paramjw = (jw)localObject;
        if (!au.a()) {
          if (!"bank".equals(localObject))
          {
            paramjw = (jw)localObject;
            if (!"cft".equals(localObject)) {}
          }
          else
          {
            ed.b().n().e.j = "";
            paramjw = "";
          }
        }
        Bundle localBundle = new Bundle();
        APUICommonMethod.g();
        localObject = paramjw;
        if (TextUtils.isEmpty(paramjw)) {
          localObject = "channelList";
        }
        es.a().a(this.d, (String)localObject, localBundle);
        return;
      }
      APUICommonMethod.g();
      fp.a().b("APPayGameInputNumActivity");
      ((Intent)localObject).setClass(this.d, APPayStoreActivity.class);
    }
    else
    {
      APUICommonMethod.g();
      fp.a().b("APPayGameListNumActivity");
      ((Intent)localObject).setClass(this.d, APPayStoreActivity.class);
    }
    this.d.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ei
 * JD-Core Version:    0.7.0.1
 */