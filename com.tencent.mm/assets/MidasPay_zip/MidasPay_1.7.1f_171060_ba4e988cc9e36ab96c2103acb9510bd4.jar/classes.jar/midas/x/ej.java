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

public class ej
  extends ee
  implements kl
{
  private boolean b()
  {
    Object localObject = fs.a().e();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!((String)localObject).equals(""))
      {
        String[] arrayOfString1 = hc.a().c();
        String[] arrayOfString3 = hc.a().d();
        String[] arrayOfString2 = hc.a().e();
        int i = 0;
        while (i < arrayOfString3.length)
        {
          if (arrayOfString3[i].equals(localObject))
          {
            localObject = (en)ed.b().n().b;
            ((en)localObject).e = String.valueOf(APTools.g(arrayOfString1[i]));
            ((en)localObject).b = arrayOfString2[i];
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
    aq.a().d(true);
    Object localObject2 = (db)paramjw;
    APHFChannel.c(((db)localObject2).e());
    if (a()) {
      return;
    }
    APHFChannel.f();
    paramjw = new Intent();
    if ((fs.a().f() == fs.a.a) && (!TextUtils.isEmpty(ed.b().n().e.g)))
    {
      if (!b())
      {
        a(this.d.getString(2131230777));
        return;
      }
      if (ed.b().n().a.isCanChange)
      {
        a(this.d.getString(2131230762));
        return;
      }
      if ((!ed.b().n().a.isCanChange) && (ed.b().n().e.g != null) && (!ed.b().n().e.g.equals("1")))
      {
        a(this.d.getString(2131230766));
        return;
      }
    }
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
 * Qualified Name:     midas.x.ej
 * JD-Core Version:    0.7.0.1
 */