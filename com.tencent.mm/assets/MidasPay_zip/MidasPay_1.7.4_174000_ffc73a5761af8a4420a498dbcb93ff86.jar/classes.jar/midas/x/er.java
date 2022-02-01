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

public class er
  extends en
  implements lw
{
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    APLog.i("APQBInfo", "buyInfo");
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
    em.b().n().b.b = "Q币";
    aq.a().d(true);
    Object localObject = new Intent();
    APHFChannel.b(((dd)paramlh).e());
    if (a()) {
      return;
    }
    APHFChannel.f();
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!this.e.isCanChange)
      {
        fy.a().b("AndroidPay");
        localObject = em.b().n().e.j;
        paramlh = (lh)localObject;
        if (!au.a()) {
          if (!"bank".equals(localObject))
          {
            paramlh = (lh)localObject;
            if (!"cft".equals(localObject)) {}
          }
          else
          {
            em.b().n().e.j = "";
            paramlh = "";
          }
        }
        Bundle localBundle = new Bundle();
        APUICommonMethod.g();
        localObject = paramlh;
        if (TextUtils.isEmpty(paramlh)) {
          localObject = "channelList";
        }
        fb.a().a(this.d, (String)localObject, localBundle);
        return;
      }
      APUICommonMethod.g();
      fy.a().b("APPayGameInputNumActivity");
      ((Intent)localObject).setClass(this.d, APPayStoreActivity.class);
    }
    else
    {
      APUICommonMethod.g();
      fy.a().b("APPayGameListNumActivity");
      ((Intent)localObject).setClass(this.d, APPayStoreActivity.class);
    }
    this.d.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.er
 * JD-Core Version:    0.7.0.1
 */