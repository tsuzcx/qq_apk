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

public class ep
  extends en
  implements lw
{
  private void a(final Context paramContext, APGoodsRequest paramAPGoodsRequest)
  {
    if (paramAPGoodsRequest.tokenType == 1)
    {
      by.a().a(paramAPGoodsRequest.goodsTokenUrl, this);
      return;
    }
    if ((paramAPGoodsRequest.tokenType == 2) || (paramAPGoodsRequest.tokenType == 3)) {
      by.a().b(new lw()
      {
        public void a(lh paramAnonymouslh)
        {
          int i = paramAnonymouslh.T();
          if (paramAnonymouslh.T() == 0)
          {
            paramAnonymouslh = ((ct)paramAnonymouslh).a();
            by.a().a(paramAnonymouslh, ep.this);
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
            fy.a().b(true);
            APLog.w("APGooldsInfo", "toH5Pay");
            paramAnonymouslh = new Intent();
            if (id.b(paramContext)) {
              paramAnonymouslh.setClass(paramContext, APX5WebJSBridgeActivity.class);
            } else {
              paramAnonymouslh.setClass(paramContext, APWebJSBridgeActivity.class);
            }
            Bundle localBundle = new Bundle();
            localBundle.putString("pageName", hu.A);
            paramAnonymouslh.putExtras(localBundle);
            paramContext.startActivity(paramAnonymouslh);
            return;
          }
          APUICommonMethod.g();
          paramAnonymouslh = paramAnonymouslh.U();
          APUICommonMethod.a(paramContext, paramAnonymouslh);
          APUICommonMethod.b();
          fv.a(i, paramAnonymouslh);
        }
        
        public void b(lh paramAnonymouslh)
        {
          APUICommonMethod.g();
          APUICommonMethod.a(paramContext, paramAnonymouslh.U());
          APUICommonMethod.b();
          fv.a(-1, paramAnonymouslh.U());
        }
        
        public void c(lh paramAnonymouslh)
        {
          APUICommonMethod.g();
          APUICommonMethod.b();
          fv.a(2, "");
        }
      });
    }
  }
  
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    APLog.i("APGoodsInfo", "buyInfo");
    a(paramContext, (APGoodsRequest)paramAPBaseRequest);
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
    if (!(em.b().n().a instanceof APGoodsRequest))
    {
      fv.a(12, "访问太频繁了");
      APUICommonMethod.b();
      return;
    }
    if (a.a().a(this.e)) {
      em.b().n().a.isCanChange = false;
    }
    aq.a().d(true);
    APHFChannel.f();
    Object localObject2 = (db)paramlh;
    APHFChannel.b(((db)localObject2).e());
    if (a()) {
      return;
    }
    paramlh = new Intent();
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!this.e.isCanChange)
      {
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
          int i = ((db)localObject2).c();
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
    }
    else
    {
      APUICommonMethod.g();
      fy.a().b("APPayGameListNumActivity");
      paramlh.setClass(this.d, APPayStoreActivity.class);
    }
    this.d.startActivity(paramlh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ep
 * JD-Core Version:    0.7.0.1
 */