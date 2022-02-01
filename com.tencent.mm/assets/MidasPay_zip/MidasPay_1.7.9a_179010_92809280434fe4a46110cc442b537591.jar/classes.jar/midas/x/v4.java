package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payCenter.APPayStoreActivity;

public class v4
  extends q4
  implements fc
{
  public void a(ob paramob)
  {
    g(paramob);
  }
  
  public void b(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    paramContext = (APSubscribeRequest)paramAPBaseRequest;
    z1.d().e(paramContext.serviceCode, this);
  }
  
  public void b(ob paramob)
  {
    f(paramob);
  }
  
  public void c(ob paramob) {}
  
  public void e(ob paramob)
  {
    r0.p().e(true);
    Object localObject2 = (i3)paramob;
    APHFChannel.c(((i3)localObject2).l());
    if (d()) {
      return;
    }
    APHFChannel.j();
    paramob = new Intent();
    if ((g6.k().e() == g6.a.a) && (!TextUtils.isEmpty(p4.p().e().f.f)))
    {
      if (!e())
      {
        a(this.d.getString(2131230778));
        return;
      }
      if (p4.p().e().b.isCanChange)
      {
        a(this.d.getString(2131230763));
        return;
      }
      if ((!p4.p().e().b.isCanChange) && (p4.p().e().f.f != null) && (!p4.p().e().f.f.equals("1")))
      {
        a(this.d.getString(2131230767));
        return;
      }
    }
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
      this.d.startActivity(paramob);
      return;
    }
    APUICommonMethod.b();
    c6.s0().A("APPayGameListNumActivity");
    paramob.setClass(this.d, APPayStoreActivity.class);
    this.d.startActivity(paramob);
  }
  
  public final boolean e()
  {
    Object localObject = g6.k().f();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!((String)localObject).equals(""))
      {
        String[] arrayOfString1 = r7.e().a();
        String[] arrayOfString3 = r7.e().d();
        String[] arrayOfString2 = r7.e().b();
        int i = 0;
        while (i < arrayOfString3.length)
        {
          if (arrayOfString3[i].equals(localObject))
          {
            localObject = (z4)p4.p().e().c;
            ((w4)localObject).c = String.valueOf(APTools.p(arrayOfString1[i]));
            ((w4)localObject).b = arrayOfString2[i];
            return true;
          }
          i += 1;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.v4
 * JD-Core Version:    0.7.0.1
 */