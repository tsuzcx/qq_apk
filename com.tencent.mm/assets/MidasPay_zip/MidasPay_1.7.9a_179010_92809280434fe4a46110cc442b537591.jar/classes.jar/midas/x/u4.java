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

public class u4
  extends q4
  implements fc
{
  public void a(ob paramob)
  {
    g(paramob);
  }
  
  public void b(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    APLog.i("APQBInfo", "buyInfo");
    z1.d().h(this);
  }
  
  public void b(ob paramob)
  {
    f(paramob);
  }
  
  public void c(ob paramob) {}
  
  public void e(ob paramob)
  {
    p4.p().e().c.b = "Q币";
    r0.p().e(true);
    Object localObject = new Intent();
    APHFChannel.c(((e3)paramob).l());
    if (d()) {
      return;
    }
    APHFChannel.j();
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!this.e.isCanChange)
      {
        c6.s0().A("AndroidPay");
        localObject = p4.p().e().f.i;
        paramob = (ob)localObject;
        if (!v0.g()) {
          if (!"bank".equals(localObject))
          {
            paramob = (ob)localObject;
            if (!"cft".equals(localObject)) {}
          }
          else
          {
            p4.p().e().f.i = "";
            paramob = "";
          }
        }
        Bundle localBundle = new Bundle();
        APUICommonMethod.b();
        localObject = paramob;
        if (TextUtils.isEmpty(paramob)) {
          localObject = "channelList";
        }
        e5.h().a(this.d, (String)localObject, localBundle);
        return;
      }
      APUICommonMethod.b();
      c6.s0().A("APPayGameInputNumActivity");
      ((Intent)localObject).setClass(this.d, APPayStoreActivity.class);
    }
    else
    {
      APUICommonMethod.b();
      c6.s0().A("APPayGameListNumActivity");
      ((Intent)localObject).setClass(this.d, APPayStoreActivity.class);
    }
    this.d.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.u4
 * JD-Core Version:    0.7.0.1
 */