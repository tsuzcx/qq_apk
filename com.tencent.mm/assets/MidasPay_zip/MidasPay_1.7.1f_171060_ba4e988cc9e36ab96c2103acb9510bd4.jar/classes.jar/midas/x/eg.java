package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payCenter.APPayStoreActivity;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.tencent.midas.comm.APLog;

public class eg
  extends ee
  implements kl
{
  private void a(final Context paramContext, APGoodsRequest paramAPGoodsRequest)
  {
    if (paramAPGoodsRequest.tokenType == 1)
    {
      bs.a().a(paramAPGoodsRequest.goodsTokenUrl, this);
      return;
    }
    if ((paramAPGoodsRequest.tokenType == 2) || (paramAPGoodsRequest.tokenType == 3)) {
      bs.a().b(new kl()
      {
        public void a(jw paramAnonymousjw)
        {
          int i = paramAnonymousjw.R();
          if (paramAnonymousjw.R() == 0)
          {
            paramAnonymousjw = ((cn)paramAnonymousjw).a();
            bs.a().a(paramAnonymousjw, eg.this);
            return;
          }
          if (i == 1018)
          {
            APUICommonMethod.g();
            a.a("登录过期，请重新登录", paramContext);
            return;
          }
          if (i == 20101)
          {
            fp.a().b(true);
            APLog.w("APGooldsInfo", "toH5Pay");
            paramAnonymousjw = new Intent();
            if (hs.b(paramContext)) {
              paramAnonymousjw.setClass(paramContext, APX5WebJSBridgeActivity.class);
            } else {
              paramAnonymousjw.setClass(paramContext, APWebJSBridgeActivity.class);
            }
            Bundle localBundle = new Bundle();
            localBundle.putString("pageName", hj.A);
            paramAnonymousjw.putExtras(localBundle);
            paramContext.startActivity(paramAnonymousjw);
            return;
          }
          APUICommonMethod.g();
          paramAnonymousjw = paramAnonymousjw.S();
          APUICommonMethod.a(paramContext, paramAnonymousjw);
          APUICommonMethod.b();
          fm.a(i, paramAnonymousjw);
        }
        
        public void b(jw paramAnonymousjw)
        {
          APUICommonMethod.g();
          APUICommonMethod.a(paramContext, paramAnonymousjw.S());
          APUICommonMethod.b();
          fm.a(-1, paramAnonymousjw.S());
        }
        
        public void c(jw paramAnonymousjw)
        {
          APUICommonMethod.g();
          APUICommonMethod.b();
          fm.a(2, "");
        }
      });
    }
  }
  
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    APLog.i("APGoodsInfo", "buyInfo");
    a(paramContext, (APGoodsRequest)paramAPBaseRequest);
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
    if (!(ed.b().n().a instanceof APGoodsRequest))
    {
      fm.a(12, "访问太频繁了");
      APUICommonMethod.b();
      return;
    }
    if (a.a().a(this.e)) {
      ed.b().n().a.isCanChange = false;
    }
    aq.a().d(true);
    APHFChannel.f();
    Object localObject2 = (cv)paramjw;
    APHFChannel.c(((cv)localObject2).e());
    if (a()) {
      return;
    }
    paramjw = new Intent();
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!this.e.isCanChange)
      {
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
          int i = ((cv)localObject2).c();
          localObject1 = ((cv)localObject2).d();
          String str = ((cv)localObject2).a();
          localObject2 = ((cv)localObject2).b();
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
    }
    else
    {
      APUICommonMethod.g();
      fp.a().b("APPayGameListNumActivity");
      paramjw.setClass(this.d, APPayStoreActivity.class);
    }
    this.d.startActivity(paramjw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.eg
 * JD-Core Version:    0.7.0.1
 */