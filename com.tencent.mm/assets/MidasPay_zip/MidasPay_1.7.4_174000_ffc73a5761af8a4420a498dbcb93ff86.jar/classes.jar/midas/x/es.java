package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payCenter.APPayStoreActivity;

public class es
  extends en
  implements lw
{
  private boolean b()
  {
    Object localObject = gc.a().e();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!((String)localObject).equals(""))
      {
        String[] arrayOfString1 = hn.a().c();
        String[] arrayOfString3 = hn.a().d();
        String[] arrayOfString2 = hn.a().e();
        int i = 0;
        while (i < arrayOfString3.length)
        {
          if (arrayOfString3[i].equals(localObject))
          {
            localObject = (ew)em.b().n().b;
            ((ew)localObject).e = String.valueOf(APTools.g(arrayOfString1[i]));
            ((ew)localObject).b = arrayOfString2[i];
            return true;
          }
          i += 1;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    paramContext = (APSubscribeRequest)paramAPBaseRequest;
    by.a().b(paramContext.serviceCode, this);
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
    aq.a().d(true);
    Object localObject2 = (dh)paramlh;
    APHFChannel.b(((dh)localObject2).e());
    if (a()) {
      return;
    }
    APHFChannel.f();
    paramlh = new Intent();
    if ((gc.a().f() == gc.a.a) && (!TextUtils.isEmpty(em.b().n().e.g)))
    {
      if (!b())
      {
        a(this.d.getString(2131230778));
        return;
      }
      if (em.b().n().a.isCanChange)
      {
        a(this.d.getString(2131230763));
        return;
      }
      if ((!em.b().n().a.isCanChange) && (em.b().n().e.g != null) && (!em.b().n().e.g.equals("1")))
      {
        a(this.d.getString(2131230767));
        return;
      }
    }
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
          int i = ((dh)localObject2).c();
          localObject1 = ((dh)localObject2).d();
          String str = ((dh)localObject2).a();
          localObject2 = ((dh)localObject2).b();
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
      this.d.startActivity(paramlh);
      return;
    }
    APUICommonMethod.g();
    fy.a().b("APPayGameListNumActivity");
    paramlh.setClass(this.d, APPayStoreActivity.class);
    this.d.startActivity(paramlh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.es
 * JD-Core Version:    0.7.0.1
 */