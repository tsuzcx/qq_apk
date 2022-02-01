package midas.x;

import android.app.Activity;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;

public class j5
  implements fc
{
  public Activity a;
  public c.c b = new c.c();
  public c.b c;
  
  public j5(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString1);
      if (paramString1.contains("?")) {
        localStringBuilder.append("&offerId=");
      } else {
        localStringBuilder.append("?offerId=");
      }
      localStringBuilder.append(p4.p().e().b.offerId);
      localStringBuilder.append("&friends_pay_msg=");
      localStringBuilder.append(paramString2);
      paramString1 = APAppDataInterface.singleton().h();
      if ((paramString1.equals("test")) || (paramString1.equals("dev"))) {
        localStringBuilder.append("&sandbox=1");
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, c.b paramb)
  {
    c.c localc = this.b;
    localc.c = paramString1;
    localc.e = paramString2;
    localc.d = paramString3;
    localc.f = paramString4;
    this.c = paramb;
    paramString1 = p4.p().e().f;
    paramString2 = new StringBuilder();
    paramString2.append(paramInt);
    paramString2.append("");
    paramString1.f = paramString2.toString();
    APUICommonMethod.b(this.a, "找啊,找啊,找朋友....");
    z1.d().d(this);
  }
  
  public void a(c.b paramb)
  {
    this.c = paramb;
    z1.d().d(this);
  }
  
  public void a(ob paramob)
  {
    if ((paramob instanceof p2)) {
      d(paramob);
    }
  }
  
  public void b(ob paramob)
  {
    APUICommonMethod.b();
    this.c.a(1, "");
  }
  
  public void c(ob paramob)
  {
    APUICommonMethod.b();
    this.c.a(2, "");
  }
  
  public final void d(ob paramob)
  {
    p2 localp2 = (p2)paramob;
    int i = localp2.d();
    if (i != 0)
    {
      if (i != 1018)
      {
        if ((i != 1094) && (i != 1099))
        {
          APUICommonMethod.b();
          paramob = paramob.f();
          if (!a.r().m.equals("2")) {
            APUICommonMethod.a(this.a, paramob);
          }
          this.c.a(1, "");
          return;
        }
        APUICommonMethod.b();
        return;
      }
      if (a.r().m.equals("1"))
      {
        APUICommonMethod.b();
        return;
      }
      this.c.a(3, "登陆态失效，请重新登录");
      return;
    }
    paramob = localp2.k();
    p4.p().e().f.l = paramob;
    this.b.b = APTools.j(this.a);
    if (TextUtils.isEmpty(this.b.e)) {
      this.b.e = localp2.h();
    }
    APLog.i("APDaifu targetUrl", this.b.e);
    paramob = localp2.i();
    if (TextUtils.isEmpty(paramob))
    {
      paramob = this.b;
      paramob.e = a(paramob.e, localp2.g());
    }
    else
    {
      this.b.e = paramob;
    }
    if (a.r().e())
    {
      this.b.a = localp2.l();
      APLog.i("APDaifu appid", this.b.a);
      if (a.r().m.equals("1"))
      {
        APUICommonMethod.b();
        if (!new c(this.a).c(this.b, new a()))
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
      this.b.a = localp2.j();
      APLog.i("APDaifu appid", this.b.a);
      if (a.r().m.equals("1"))
      {
        APUICommonMethod.b();
        new c(this.a).b(this.b, new b());
        return;
      }
      this.c.a(0, this.b.e);
    }
  }
  
  public class a
    implements c.b
  {
    public a() {}
    
    public void a(int paramInt, String paramString)
    {
      if (paramInt == 0) {
        return;
      }
      if (paramInt == 1)
      {
        APUICommonMethod.a(j5.a(j5.this), "系统错误，请重试");
        return;
      }
      APUICommonMethod.a(j5.a(j5.this), "系统错误，请重试");
    }
  }
  
  public class b
    implements c.b
  {
    public b() {}
    
    public void a(int paramInt, String paramString)
    {
      APUICommonMethod.b();
      APUICommonMethod.f();
      if (paramInt == 0)
      {
        j5.b(j5.this).a(0, "");
        return;
      }
      if (paramInt == 1)
      {
        j5.b(j5.this).a(1, "");
        return;
      }
      j5.b(j5.this).a(2, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.j5
 * JD-Core Version:    0.7.0.1
 */