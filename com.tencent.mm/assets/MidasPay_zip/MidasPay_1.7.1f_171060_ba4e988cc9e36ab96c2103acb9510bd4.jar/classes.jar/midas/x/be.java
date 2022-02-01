package midas.x;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.mid.local.LocalMid;
import com.tencent.midas.comm.APLog;

public class be
{
  private static final String b = "be";
  private static volatile be c;
  public Context a;
  private bj d;
  private kl e = new kl()
  {
    public void a(jw paramAnonymousjw)
    {
      APLog.i(be.b(), "SyncOrder finish");
      int i = paramAnonymousjw.R();
      if (i != 0)
      {
        if (i != 1018)
        {
          if ((i != 1094) && (i != 1099)) {
            if (i != 1126)
            {
              paramAnonymousjw = paramAnonymousjw.S();
              Toast.makeText(be.this.a, paramAnonymousjw, 0).show();
              if (be.a(be.this) != null) {
                be.a(be.this).a(-1, "订单异常，请重试");
              }
            }
            else
            {
              paramAnonymousjw = paramAnonymousjw.S();
              if (paramAnonymousjw.equals("1126-917-0"))
              {
                if (be.a(be.this) != null) {
                  be.a(be.this).a(7, paramAnonymousjw);
                }
              }
              else if (be.a(be.this) != null) {
                be.a(be.this).a(8, paramAnonymousjw);
              }
            }
          }
        }
        else if (be.a(be.this) != null) {
          be.a(be.this).a(6, "用户登录状态失效，请重新登录");
        }
      }
      else
      {
        if (be.a(be.this) != null) {
          be.a(be.this).a(0, "推送成功");
        }
        APLog.i(be.b(), "SyncOrder success");
      }
    }
    
    public void b(jw paramAnonymousjw)
    {
      paramAnonymousjw = paramAnonymousjw.S();
      Toast.makeText(be.this.a, paramAnonymousjw, 1).show();
      if (be.a(be.this) != null) {
        be.a(be.this).a(-1, "推送异常");
      }
      APLog.i(be.b(), "SyncOrder error");
    }
    
    public void c(jw paramAnonymousjw)
    {
      APLog.i(be.b(), "SyncOrder stop");
      if (be.a(be.this) != null) {
        be.a(be.this).a(2, "支付取消");
      }
    }
  };
  
  public static be a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new be();
        }
      }
      finally {}
    }
    return c;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, kl paramkl)
  {
    bs.a().a(paramString1, paramString2, paramString3, paramkl);
  }
  
  private void b(Context paramContext, String paramString1, String paramString2, String paramString3, bj parambj)
  {
    a(paramString1, paramString2, paramString3, this.e);
  }
  
  private void c()
  {
    String str2 = APTools.e("MidasDeviceId");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = APTools.h();
      APTools.b("MidasDeviceId", str1);
    }
    APLog.i("MidasDeviceId", str1);
    fp.a().j(str1);
  }
  
  private void d()
  {
    String str1 = ed.b().n().a.openId;
    String str2 = ed.b().f();
    Context localContext = a().a;
    bs.a().b(localContext, str1, str2, "1.7.1f");
    c();
    fp.a().k(APTools.e(c.a));
    fp.a().l(APTools.d(c.a));
    fp.a().m(APTools.c());
  }
  
  public void a(Context paramContext, String paramString)
  {
    a().a = paramContext.getApplicationContext();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, bj parambj)
  {
    fp.a().d(paramString2);
    this.d = parambj;
    String str1 = ed.b().e();
    String str2 = ed.b().f();
    Context localContext = a.a().d;
    if (bs.a().a(localContext, str1, str2, "1.7.1f"))
    {
      b(paramContext, paramString1, paramString2, paramString3, parambj);
      return;
    }
    a(paramString1, paramString2, paramString3, this.e);
  }
  
  public void a(APBaseRequest paramAPBaseRequest)
  {
    int i = fy.a(a().a);
    APAppDataInterface.singleton().b(i);
    APAppDataInterface.singleton().e("1.3.9e");
    try
    {
      String str = LocalMid.getInstance(a().a).getLocalMid();
      APAppDataInterface.singleton().c(str);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    fp.b();
    d();
    paramAPBaseRequest = new ec(paramAPBaseRequest);
    ed.b().a(paramAPBaseRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.be
 * JD-Core Version:    0.7.0.1
 */