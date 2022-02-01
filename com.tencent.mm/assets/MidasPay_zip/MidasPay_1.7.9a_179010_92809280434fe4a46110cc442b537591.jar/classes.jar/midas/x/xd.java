package midas.x;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.qrcode.APQRCodeActivity;
import java.io.File;

public class xd
{
  public static int a;
  public static int b;
  
  public static void a(Context paramContext)
  {
    APUICommonMethod.b(paramContext, null);
    paramContext = new b(paramContext);
    z1.d().f(paramContext);
  }
  
  public static void b(Context paramContext)
  {
    APUICommonMethod.b(paramContext, null);
    paramContext = new c(paramContext);
    z1.d().d(paramContext);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    APUICommonMethod.b(paramContext, null);
    paramContext = new a(paramContext);
    z1.d().b(paramContext, paramString);
  }
  
  public static boolean c(Context paramContext)
  {
    if (b == 0)
    {
      paramContext = paramContext.getFilesDir().getAbsolutePath();
      if ((!paramContext.matches("^\\/data\\/user\\/\\d+\\/com\\.tencent\\.gamestick\\/app_vroot.*")) && (!paramContext.matches("^\\/data\\/data\\/com\\.tencent\\.gamestick\\/app_vroot.*"))) {
        b = 2;
      } else {
        b = 1;
      }
    }
    return b == 1;
  }
  
  public static boolean d(Context paramContext)
  {
    if (a == 0) {
      try
      {
        if (c(paramContext))
        {
          if (new File("/data/data/com.tencent.gamestick/files/gs_qr.dat").exists()) {
            a = 1;
          } else {
            a = 2;
          }
        }
        else {
          a = 2;
        }
      }
      catch (Exception localException)
      {
        a = 2;
        localException.printStackTrace();
      }
    }
    if (a == 1) {
      return true;
    }
    if (((UiModeManager)paramContext.getSystemService("uimode")).getCurrentModeType() == 4)
    {
      APLog.d("QRCodePay-Manager", "isRunningOnTV() is on general TV");
      return true;
    }
    return false;
  }
  
  public static void e(Context paramContext)
  {
    int i = p4.p().g();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Launch QRCode pay, save type = ");
    ((StringBuilder)localObject).append(i);
    APLog.d("QRCodePay-Manager", ((StringBuilder)localObject).toString());
    if (i != 0) {
      if (i != 1)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            paramContext = new StringBuilder();
            paramContext.append("Launch QRCode pay, save type error = ");
            paramContext.append(i);
            APLog.e("QRCodePay-Manager", paramContext.toString());
            APUICommonMethod.f();
            z5.a(-1, "系统繁忙，请稍后再试！");
          }
        }
        else
        {
          APLog.e("QRCodePay-Manager", "Not support month request now!");
          APUICommonMethod.f();
          z5.a(-1, "系统繁忙，请稍后再试！");
        }
      }
      else
      {
        if (p4.p().j())
        {
          localObject = p4.p().b();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Launch QRCode pay, go goods server! token url = ");
          localStringBuilder.append((String)localObject);
          APLog.d("QRCodePay-Manager", localStringBuilder.toString());
          b(paramContext, (String)localObject);
          return;
        }
        APLog.d("QRCodePay-Manager", "Launch QRCode pay, go goods sdk");
        a(paramContext);
        return;
      }
    }
    APLog.d("QRCodePay-Manager", "Launch QRCode pay, go get token");
    b(paramContext);
  }
  
  public static boolean f(Context paramContext)
  {
    if (p4.p().k())
    {
      APLog.d("QRCodePay-Manager", "IsSaveTypeMonth no need to use qr code pay!");
      return false;
    }
    APLog.d("QRCodePay-Manager", "Save type is not month!");
    if (!d(paramContext))
    {
      APLog.d("QRCodePay-Manager", "Not running on tv, no need to use qr code pay!");
      return false;
    }
    APLog.d("QRCodePay-Manager", "Is running on tv!");
    if (z5.d())
    {
      APLog.d("QRCodePay-Manager", "is assign pay channel, no need to use qr code pay!");
      return false;
    }
    paramContext = p4.p().f();
    if (!TextUtils.isEmpty(paramContext))
    {
      APLog.d("QRCodePay-Manager", "Reserve not empty!");
      if (paramContext.contains("wechattype="))
      {
        APLog.d("QRCodePay-Manager", "Reserve contains wechattype, no need to use qr code pay!");
        return false;
      }
      if (paramContext.contains("hfPointConvert="))
      {
        APLog.d("QRCodePay-Manager", "Reserve contains hfPointConvert, no need to use qr code pay!");
        return false;
      }
      if (paramContext.contains("provide_uin="))
      {
        APLog.d("QRCodePay-Manager", "Reserve contains provide_uin, no need to use qr code pay!");
        return false;
      }
      if (paramContext.contains("provide_uin="))
      {
        APLog.d("QRCodePay-Manager", "Reserve contains provide_uin, no need to use qr code pay!");
        return false;
      }
    }
    else
    {
      APLog.d("QRCodePay-Manager", "Reserve empty!");
    }
    if (p4.p().m())
    {
      APLog.d("QRCodePay-Manager", "Is subscribe and empty service name, no need to use qr code pay!");
      return false;
    }
    if (p4.p().l())
    {
      APLog.d("QRCodePay-Manager", "Save value more than zero, use qr code pay!");
      return true;
    }
    APLog.d("QRCodePay-Manager", "Save value not more than zero, no need to qr code pay!");
    return false;
  }
  
  public static final class a
    implements fc
  {
    public a(Context paramContext) {}
    
    public void a(ob paramob)
    {
      APLog.d("QRCodePay-Manager", "Get qr code on success");
      APUICommonMethod.b();
      if (paramob.d() == 0)
      {
        int i = p4.p().g();
        Object localObject = g6.k();
        if ((i == 5) && (((g6)localObject).e() == g6.a.a) && (!p4.p().e().b.saveValue.equals("1")))
        {
          APLog.e("QRCodePay-Manager", "QRCode get qr code ans err!");
          APUICommonMethod.f();
          z5.a(-1, "月卡特殊汇率购买数量必须是1");
          return;
        }
        localObject = new a(new Handler(Looper.getMainLooper()));
        Intent localIntent = new Intent();
        localIntent.setClass(this.a, APQRCodeActivity.class);
        paramob = (l4)paramob;
        localIntent.putExtra("qrcode", paramob.g());
        localIntent.putExtra("tokenValidTime", paramob.h);
        localIntent.putExtra("Receiver", (Parcelable)localObject);
        this.a.startActivity(localIntent);
        return;
      }
      APLog.w("QRCodePay-Manager", "QRCode get qr code onSuccess ret !=0 !");
      APUICommonMethod.f();
      z5.a(-1, paramob.f());
    }
    
    public void b(ob paramob)
    {
      APLog.e("QRCodePay-Manager", "Get qr code on fail");
      APUICommonMethod.b();
      APLog.e("QRCodePay-Manager", "QRCode get qr code failure!");
      APUICommonMethod.f();
      z5.a(-1, "系统繁忙，请稍后再试！");
    }
    
    public void c(ob paramob)
    {
      APLog.e("QRCodePay-Manager", "Get qr code on stop");
      APUICommonMethod.b();
      APLog.e("QRCodePay-Manager", "QRCode get qr code stop!");
      APUICommonMethod.f();
      z5.a(-1, "系统繁忙，请稍后再试！");
    }
    
    public class a
      extends ResultReceiver
    {
      public a(Handler paramHandler)
      {
        super();
      }
      
      public void onReceiveResult(int paramInt, Bundle paramBundle)
      {
        super.onReceiveResult(paramInt, paramBundle);
        APLog.d("QRCodePay-Manager", "onReceiveResult");
        c6.s0().I(APTools.j());
        xd.e(xd.a.this.a);
      }
    }
  }
  
  public static final class b
    implements fc
  {
    public b(Context paramContext) {}
    
    public void a(ob paramob)
    {
      APUICommonMethod.b(this.a, null);
      if (paramob.d() == 0)
      {
        xd.a(this.a, ((u2)paramob).g());
        return;
      }
      APLog.e("QRCodePay-Manager", "QRCode pay goods token onSuccess ret !=0 !");
      APUICommonMethod.f();
      z5.a(-1, paramob.f());
    }
    
    public void b(ob paramob)
    {
      APUICommonMethod.b();
      APLog.e("QRCodePay-Manager", "QRCode pay goods token failure!");
      APUICommonMethod.f();
      z5.a(-1, "系统繁忙，请稍后再试！");
    }
    
    public void c(ob paramob)
    {
      APUICommonMethod.b();
      APLog.e("QRCodePay-Manager", "QRCode pay goods token stop!");
      APUICommonMethod.f();
      z5.a(-1, "系统繁忙，请稍后再试！");
    }
  }
  
  public static final class c
    implements fc
  {
    public c(Context paramContext) {}
    
    public void a(ob paramob)
    {
      APUICommonMethod.b(this.a, null);
      if (paramob.d() == 0)
      {
        xd.a(this.a, ((p2)paramob).k());
        return;
      }
      APUICommonMethod.f();
      z5.a(-1, paramob.f());
    }
    
    public void b(ob paramob)
    {
      APUICommonMethod.b();
      APLog.e("QRCodePay-Manager", "QRCode pay get token failure!");
      APUICommonMethod.f();
      z5.a(-1, "系统繁忙，请稍后再试！");
    }
    
    public void c(ob paramob)
    {
      APUICommonMethod.b();
      APLog.e("QRCodePay-Manager", "QRCode pay get token stop!");
      APUICommonMethod.f();
      z5.a(-1, "系统繁忙，请稍后再试！");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.xd
 * JD-Core Version:    0.7.0.1
 */