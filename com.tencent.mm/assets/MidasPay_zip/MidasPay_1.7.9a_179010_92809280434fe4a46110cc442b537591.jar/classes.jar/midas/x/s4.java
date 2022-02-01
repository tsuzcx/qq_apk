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

public class s4
  extends q4
  implements fc
{
  public final void a(final Context paramContext, APGoodsRequest paramAPGoodsRequest)
  {
    int i = paramAPGoodsRequest.tokenType;
    if (i == 1)
    {
      z1.d().d(paramAPGoodsRequest.goodsTokenUrl, this);
      return;
    }
    if ((i == 2) || (i == 3)) {
      z1.d().f(new a(paramContext));
    }
  }
  
  public void a(ob paramob)
  {
    g(paramob);
  }
  
  public void b(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    APLog.i("APGoodsInfo", "buyInfo");
    a(paramContext, (APGoodsRequest)paramAPBaseRequest);
  }
  
  public void b(ob paramob)
  {
    f(paramob);
  }
  
  public void c(ob paramob) {}
  
  public void e(ob paramob)
  {
    if (!(p4.p().e().b instanceof APGoodsRequest))
    {
      z5.a(12, "访问太频繁了");
      APUICommonMethod.f();
      return;
    }
    if (a.r().e(this.e)) {
      p4.p().e().b.isCanChange = false;
    }
    r0.p().e(true);
    APHFChannel.j();
    Object localObject2 = (c3)paramob;
    APHFChannel.c(((c3)localObject2).l());
    if (d()) {
      return;
    }
    paramob = new Intent();
    if (!TextUtils.isEmpty(this.e.saveValue))
    {
      if (!this.e.isCanChange)
      {
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
          int i = ((d2)localObject2).j();
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
    }
    else
    {
      APUICommonMethod.b();
      c6.s0().A("APPayGameListNumActivity");
      paramob.setClass(this.d, APPayStoreActivity.class);
    }
    this.d.startActivity(paramob);
  }
  
  public class a
    implements fc
  {
    public a(Context paramContext) {}
    
    public void a(ob paramob)
    {
      int i = paramob.d();
      if (paramob.d() == 0)
      {
        paramob = ((u2)paramob).g();
        z1.d().d(paramob, s4.this);
        return;
      }
      if (i == 1018)
      {
        APUICommonMethod.b();
        a.a("登录过期，请重新登录", paramContext);
        return;
      }
      if (i == 20101)
      {
        c6.s0().c(true);
        APLog.w("APGooldsInfo", "toH5Pay");
        paramob = new Intent();
        if (h8.d(paramContext)) {
          paramob.setClass(paramContext, APX5WebJSBridgeActivity.class);
        } else {
          paramob.setClass(paramContext, APWebJSBridgeActivity.class);
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("pageName", y7.x);
        paramob.putExtras(localBundle);
        paramContext.startActivity(paramob);
        return;
      }
      APUICommonMethod.b();
      paramob = paramob.f();
      APUICommonMethod.a(paramContext, paramob);
      APUICommonMethod.f();
      z5.a(i, paramob);
    }
    
    public void b(ob paramob)
    {
      APUICommonMethod.b();
      APUICommonMethod.a(paramContext, paramob.f());
      APUICommonMethod.f();
      z5.a(-1, paramob.f());
    }
    
    public void c(ob paramob)
    {
      APUICommonMethod.b();
      APUICommonMethod.f();
      z5.a(2, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.s4
 * JD-Core Version:    0.7.0.1
 */