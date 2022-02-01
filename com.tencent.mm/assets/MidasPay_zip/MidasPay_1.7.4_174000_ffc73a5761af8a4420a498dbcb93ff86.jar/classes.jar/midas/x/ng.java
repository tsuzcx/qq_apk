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

public class ng
{
  private static int a;
  private static int b;
  
  public static boolean a(Context paramContext)
  {
    if (em.b().i())
    {
      APLog.d("QRCodePay-Manager", "IsSaveTypeMonth no need to use qr code pay!");
      return false;
    }
    APLog.d("QRCodePay-Manager", "Save type is not month!");
    if (!e(paramContext))
    {
      APLog.d("QRCodePay-Manager", "Not running on tv, no need to use qr code pay!");
      return false;
    }
    APLog.d("QRCodePay-Manager", "Is running on tv!");
    if (fv.f())
    {
      APLog.d("QRCodePay-Manager", "is assign pay channel, no need to use qr code pay!");
      return false;
    }
    paramContext = em.b().h();
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
    if (em.b().c())
    {
      APLog.d("QRCodePay-Manager", "Is subscribe and empty service name, no need to use qr code pay!");
      return false;
    }
    if (em.b().j())
    {
      APLog.d("QRCodePay-Manager", "Save value more than zero, use qr code pay!");
      return true;
    }
    APLog.d("QRCodePay-Manager", "Save value not more than zero, no need to qr code pay!");
    return false;
  }
  
  public static void b(Context paramContext)
  {
    int i = em.b().g();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Launch QRCode pay, save type = ");
    ((StringBuilder)localObject).append(i);
    APLog.d("QRCodePay-Manager", ((StringBuilder)localObject).toString());
    switch (i)
    {
    case 2: 
    case 3: 
    default: 
      paramContext = new StringBuilder();
      paramContext.append("Launch QRCode pay, save type error = ");
      paramContext.append(i);
      APLog.e("QRCodePay-Manager", paramContext.toString());
      APUICommonMethod.b();
      fv.a(-1, "系统繁忙，请稍后再试！");
      return;
    case 4: 
      APLog.e("QRCodePay-Manager", "Not support month request now!");
      APUICommonMethod.b();
      fv.a(-1, "系统繁忙，请稍后再试！");
      return;
    case 1: 
      if (em.b().k())
      {
        localObject = em.b().m();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Launch QRCode pay, go goods server! token url = ");
        localStringBuilder.append((String)localObject);
        APLog.d("QRCodePay-Manager", localStringBuilder.toString());
        b(paramContext, (String)localObject);
        return;
      }
      APLog.d("QRCodePay-Manager", "Launch QRCode pay, go goods sdk");
      c(paramContext);
      return;
    }
    APLog.d("QRCodePay-Manager", "Launch QRCode pay, go get token");
    d(paramContext);
  }
  
  private static void b(Context paramContext, String paramString)
  {
    APUICommonMethod.b(paramContext, null);
    paramContext = new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        APLog.d("QRCodePay-Manager", "Get qr code on success");
        APUICommonMethod.g();
        if (paramAnonymouslh.T() == 0)
        {
          int i = em.b().g();
          Object localObject = gc.a();
          if ((i == 5) && (((gc)localObject).f() == gc.a.a) && (!em.b().n().a.saveValue.equals("1")))
          {
            APLog.e("QRCodePay-Manager", "QRCode get qr code ans err!");
            APUICommonMethod.b();
            fv.a(-1, "月卡特殊汇率购买数量必须是1");
            return;
          }
          localObject = new ResultReceiver(new Handler(Looper.getMainLooper()))
          {
            protected void onReceiveResult(int paramAnonymous2Int, Bundle paramAnonymous2Bundle)
            {
              super.onReceiveResult(paramAnonymous2Int, paramAnonymous2Bundle);
              APLog.d("QRCodePay-Manager", "onReceiveResult");
              fy.a().d(APTools.h());
              ng.b(ng.1.this.a);
            }
          };
          Intent localIntent = new Intent();
          localIntent.setClass(this.a, APQRCodeActivity.class);
          paramAnonymouslh = (ei)paramAnonymouslh;
          localIntent.putExtra("qrcode", paramAnonymouslh.a());
          localIntent.putExtra("tokenValidTime", paramAnonymouslh.a);
          localIntent.putExtra("Receiver", (Parcelable)localObject);
          this.a.startActivity(localIntent);
          return;
        }
        APLog.w("QRCodePay-Manager", "QRCode get qr code onSuccess ret !=0 !");
        APUICommonMethod.b();
        fv.a(-1, paramAnonymouslh.U());
      }
      
      public void b(lh paramAnonymouslh)
      {
        APLog.e("QRCodePay-Manager", "Get qr code on fail");
        APUICommonMethod.g();
        APLog.e("QRCodePay-Manager", "QRCode get qr code failure!");
        APUICommonMethod.b();
        fv.a(-1, "系统繁忙，请稍后再试！");
      }
      
      public void c(lh paramAnonymouslh)
      {
        APLog.e("QRCodePay-Manager", "Get qr code on stop");
        APUICommonMethod.g();
        APLog.e("QRCodePay-Manager", "QRCode get qr code stop!");
        APUICommonMethod.b();
        fv.a(-1, "系统繁忙，请稍后再试！");
      }
    };
    by.a().d(paramContext, paramString);
  }
  
  private static void c(Context paramContext)
  {
    APUICommonMethod.b(paramContext, null);
    paramContext = new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        APUICommonMethod.b(this.a, null);
        if (paramAnonymouslh.T() == 0)
        {
          ng.a(this.a, ((ct)paramAnonymouslh).a());
          return;
        }
        APLog.e("QRCodePay-Manager", "QRCode pay goods token onSuccess ret !=0 !");
        APUICommonMethod.b();
        fv.a(-1, paramAnonymouslh.U());
      }
      
      public void b(lh paramAnonymouslh)
      {
        APUICommonMethod.g();
        APLog.e("QRCodePay-Manager", "QRCode pay goods token failure!");
        APUICommonMethod.b();
        fv.a(-1, "系统繁忙，请稍后再试！");
      }
      
      public void c(lh paramAnonymouslh)
      {
        APUICommonMethod.g();
        APLog.e("QRCodePay-Manager", "QRCode pay goods token stop!");
        APUICommonMethod.b();
        fv.a(-1, "系统繁忙，请稍后再试！");
      }
    };
    by.a().b(paramContext);
  }
  
  private static void d(Context paramContext)
  {
    APUICommonMethod.b(paramContext, null);
    paramContext = new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        APUICommonMethod.b(this.a, null);
        if (paramAnonymouslh.T() == 0)
        {
          ng.a(this.a, ((co)paramAnonymouslh).a());
          return;
        }
        APUICommonMethod.b();
        fv.a(-1, paramAnonymouslh.U());
      }
      
      public void b(lh paramAnonymouslh)
      {
        APUICommonMethod.g();
        APLog.e("QRCodePay-Manager", "QRCode pay get token failure!");
        APUICommonMethod.b();
        fv.a(-1, "系统繁忙，请稍后再试！");
      }
      
      public void c(lh paramAnonymouslh)
      {
        APUICommonMethod.g();
        APLog.e("QRCodePay-Manager", "QRCode pay get token stop!");
        APUICommonMethod.b();
        fv.a(-1, "系统繁忙，请稍后再试！");
      }
    };
    by.a().c(paramContext);
  }
  
  private static boolean e(Context paramContext)
  {
    if (a == 0) {
      try
      {
        if (f(paramContext))
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
  
  private static boolean f(Context paramContext)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ng
 * JD-Core Version:    0.7.0.1
 */