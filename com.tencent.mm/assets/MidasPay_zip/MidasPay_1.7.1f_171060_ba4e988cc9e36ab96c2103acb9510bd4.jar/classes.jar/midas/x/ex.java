package midas.x;

import android.app.Activity;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;

public class ex
  implements kl
{
  private Activity a;
  private c.b b = new c.b();
  private c.a c;
  
  public ex(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString1);
      if (paramString1.contains("?")) {
        localStringBuilder.append("&offerId=");
      } else {
        localStringBuilder.append("?offerId=");
      }
      localStringBuilder.append(ed.b().n().a.offerId);
      localStringBuilder.append("&friends_pay_msg=");
      localStringBuilder.append(paramString2);
      paramString1 = APAppDataInterface.singleton().e();
      if ((paramString1.equals("test")) || (paramString1.equals("dev"))) {
        localStringBuilder.append("&sandbox=1");
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void d(jw paramjw)
  {
    ci localci = (ci)paramjw;
    int i = localci.R();
    if (i != 0)
    {
      if (i != 1018)
      {
        if ((i != 1094) && (i != 1099))
        {
          APUICommonMethod.g();
          paramjw = paramjw.S();
          if (!a.a().i.equals("2")) {
            APUICommonMethod.a(this.a, paramjw);
          }
          this.c.a(1, "");
          return;
        }
        APUICommonMethod.g();
        return;
      }
      if (a.a().i.equals("1"))
      {
        APUICommonMethod.g();
        return;
      }
      this.c.a(3, "登陆态失效，请重新登录");
      return;
    }
    paramjw = localci.a();
    ed.b().n().e.m = paramjw;
    this.b.b = APTools.n(this.a);
    if (TextUtils.isEmpty(this.b.e)) {
      this.b.e = localci.e();
    }
    APLog.i("APDaifu targetUrl", this.b.e);
    this.b.e = a(this.b.e, localci.d());
    if (a.a().j())
    {
      this.b.a = localci.b();
      APLog.i("APDaifu appid", this.b.a);
      if (a.a().i.equals("1"))
      {
        APUICommonMethod.g();
        if (!new c(this.a).c(this.b, new c.a()
        {
          public void a(int paramAnonymousInt, String paramAnonymousString)
          {
            if (paramAnonymousInt == 0) {
              return;
            }
            if (paramAnonymousInt == 1)
            {
              APUICommonMethod.a(ex.a(ex.this), "系统错误，请重试");
              return;
            }
            APUICommonMethod.a(ex.a(ex.this), "系统错误，请重试");
          }
        }))
        {
          APLog.e("APDaifu", "分享失败");
          APUICommonMethod.a(this.a, "系统错误，请重试");
        }
      }
      else
      {
        this.c.a(0, this.b.e);
      }
    }
    else
    {
      this.b.a = localci.c();
      APLog.i("APDaifu appid", this.b.a);
      if (a.a().i.equals("1"))
      {
        APUICommonMethod.g();
        new c(this.a).b(this.b, new c.a()
        {
          public void a(int paramAnonymousInt, String paramAnonymousString)
          {
            APUICommonMethod.g();
            APUICommonMethod.b();
            if (paramAnonymousInt == 0)
            {
              ex.b(ex.this).a(0, "");
              return;
            }
            if (paramAnonymousInt == 1)
            {
              ex.b(ex.this).a(1, "");
              return;
            }
            ex.b(ex.this).a(2, "");
          }
        });
        return;
      }
      this.c.a(0, this.b.e);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, c.a parama)
  {
    this.b.c = paramString1;
    this.b.e = paramString2;
    this.b.d = paramString3;
    this.b.f = paramString4;
    this.c = parama;
    paramString1 = ed.b().n().e;
    paramString2 = new StringBuilder();
    paramString2.append(paramInt);
    paramString2.append("");
    paramString1.g = paramString2.toString();
    APUICommonMethod.b(this.a, "找啊,找啊,找朋友....");
    bs.a().c(this);
  }
  
  public void a(c.a parama)
  {
    this.c = parama;
    bs.a().c(this);
  }
  
  public void a(jw paramjw)
  {
    if ((paramjw instanceof ci)) {
      d(paramjw);
    }
  }
  
  public void b(jw paramjw)
  {
    APUICommonMethod.g();
    this.c.a(1, "");
  }
  
  public void c(jw paramjw)
  {
    APUICommonMethod.g();
    this.c.a(2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ex
 * JD-Core Version:    0.7.0.1
 */