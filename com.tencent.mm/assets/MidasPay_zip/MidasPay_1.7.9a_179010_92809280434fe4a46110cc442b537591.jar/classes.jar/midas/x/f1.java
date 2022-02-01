package midas.x;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class f1
{
  public static final String d = "f1";
  public static volatile f1 e;
  public Context a;
  public k1 b;
  public fc c = new a();
  
  public static f1 d()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new f1();
        }
      }
      finally {}
    }
    return e;
  }
  
  public final void a()
  {
    String str1 = p4.p().e().b.openId;
    String str2 = p4.p().c();
    Context localContext = d().a;
    z1.d().a(localContext, str1, str2, "1.7.9a");
    b();
    c6.s0().F(APTools.l(e.a));
    c6.s0().E(APTools.f(e.a));
    c6.s0().G(APTools.g());
  }
  
  public void a(Context paramContext, String paramString)
  {
    d().a = paramContext.getApplicationContext();
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, k1 paramk1)
  {
    a(paramString1, paramString2, paramString3, this.c);
  }
  
  public void a(APBaseRequest paramAPBaseRequest)
  {
    int i = m6.a(d().a);
    APAppDataInterface.singleton().b(i);
    APAppDataInterface.singleton().j("1.3.9e");
    c6.r0();
    a();
    paramAPBaseRequest = new o4(paramAPBaseRequest);
    p4.p().a(paramAPBaseRequest);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, fc paramfc)
  {
    z1.d().b(paramString1, paramString2, paramString3, paramfc);
  }
  
  public final void b()
  {
    String str2 = APTools.k("MidasDeviceId");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = APTools.j();
      APTools.d("MidasDeviceId", str1);
    }
    APLog.i("MidasDeviceId", str1);
    c6.s0().H(str1);
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3, k1 paramk1)
  {
    c6.s0().I(paramString2);
    this.b = paramk1;
    String str1 = p4.p().d();
    String str2 = p4.p().c();
    Context localContext = a.r().d;
    if (z1.d().b(localContext, str1, str2, "1.7.9a"))
    {
      a(paramContext, paramString1, paramString2, paramString3, paramk1);
      return;
    }
    a(paramString1, paramString2, paramString3, this.c);
  }
  
  public class a
    implements fc
  {
    public a() {}
    
    public void a(ob paramob)
    {
      APLog.i(f1.c(), "SyncOrder finish");
      int i = paramob.d();
      if (i != 0)
      {
        if (i != 1018)
        {
          if ((i != 1094) && (i != 1099)) {
            if (i != 1126)
            {
              paramob = paramob.f();
              Toast.makeText(f1.this.a, paramob, 0).show();
              if (f1.a(f1.this) != null) {
                f1.a(f1.this).a(-1, "订单异常，请重试");
              }
            }
            else
            {
              paramob = paramob.f();
              if (paramob.equals("1126-917-0"))
              {
                if (f1.a(f1.this) != null) {
                  f1.a(f1.this).a(7, paramob);
                }
              }
              else if (f1.a(f1.this) != null) {
                f1.a(f1.this).a(8, paramob);
              }
            }
          }
        }
        else if (f1.a(f1.this) != null) {
          f1.a(f1.this).a(6, "用户登录状态失效，请重新登录");
        }
      }
      else
      {
        if (f1.a(f1.this) != null) {
          f1.a(f1.this).a(0, "推送成功");
        }
        APLog.i(f1.c(), "SyncOrder success");
      }
    }
    
    public void b(ob paramob)
    {
      paramob = paramob.f();
      Toast.makeText(f1.this.a, paramob, 1).show();
      if (f1.a(f1.this) != null) {
        f1.a(f1.this).a(-1, "推送异常");
      }
      APLog.i(f1.c(), "SyncOrder error");
    }
    
    public void c(ob paramob)
    {
      APLog.i(f1.c(), "SyncOrder stop");
      if (f1.a(f1.this) != null) {
        f1.a(f1.this).a(2, "支付取消");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.f1
 * JD-Core Version:    0.7.0.1
 */