package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ResultReceiver;
import android.util.Base64;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;

public class fn
{
  private static boolean b = false;
  public Handler a = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      APLog.i("APQQWalletSDK", "handleMessage");
      paramAnonymousMessage = paramAnonymousMessage.getData();
      int i = paramAnonymousMessage.getInt("retCode");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage retCode = ");
      localStringBuilder.append(i);
      APLog.i("APQQWalletSDK", localStringBuilder.toString());
      if (fn.a(fn.this) != null) {
        fn.a(fn.this).send(i, paramAnonymousMessage);
      }
      try
      {
        fn.b(fn.this).b(fn.this.a);
      }
      catch (Exception paramAnonymousMessage)
      {
        paramAnonymousMessage.printStackTrace();
      }
      return true;
    }
  });
  private Context c;
  private nf d;
  private ResultReceiver e;
  
  public fn(Context paramContext, String paramString)
  {
    this.c = paramContext;
    try
    {
      this.d = nf.a(paramContext, paramString);
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramString = new StringBuilder();
      paramString.append(" registerApp e:");
      paramString.append(paramContext.toString());
      APLog.w("APQQWalletSDK", paramString.toString());
    }
    APLog.i("APQQWalletSDK", "public APQQWalletSDK");
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    try
    {
      paramString = new String(Base64.encode(paramString.getBytes(), 2));
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://forward/url?src_type=web&style=default&=1&version=1&url_prefix=");
    localStringBuilder.append(paramString);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(localStringBuilder.toString()));
    try
    {
      APDataReportManager.getInstance().insertData("sdk.qqwallet.sign.show", em.b().n().a.saveType, em.b().n().e.m, "", null);
      paramActivity.startActivity(paramString);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean a()
  {
    return b;
  }
  
  public static boolean a(Context paramContext)
  {
    return APTools.b(paramContext, "com.tencent.mobileqq");
  }
  
  public static boolean b()
  {
    try
    {
      Class.forName("com.tencent.mobileqq.openpay.api.OpenApiFactory");
      APLog.w("APQQWalletSDK", " is support QQWallet");
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" is not support QQWallet e:");
      localStringBuilder.append(localException.toString());
      APLog.w("APQQWalletSDK", localStringBuilder.toString());
    }
    return false;
  }
  
  public void a(Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    this.e = paramResultReceiver;
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("isSuccess", false);
    localBundle1.putInt("retCode", -11);
    localBundle1.putString("retMsg", "uninstall qq");
    try
    {
      boolean bool = this.d.a();
      APLog.i("APQQWalletSDK", "toQQPay public APQQWalletSDK");
      if (!bool)
      {
        if (bq.d())
        {
          if (paramResultReceiver == null) {
            return;
          }
          Bundle localBundle2 = new Bundle();
          localBundle2.putString("resultMsg", "抱歉，QQ未安装或版本太低");
          paramResultReceiver.send(-11, localBundle2);
          return;
        }
        APUICommonMethod.a(this.c, "抱歉，QQ未安装或版本太低");
        if (paramResultReceiver != null) {
          paramResultReceiver.send(-11, localBundle1);
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" toQQPay isQQPaySupport e:");
      localStringBuilder.append(localException.toString());
      APLog.w("APQQWalletSDK", localStringBuilder.toString());
      if (paramResultReceiver != null)
      {
        paramResultReceiver.send(-11, localBundle1);
        return;
      }
      localException.printStackTrace();
      APLog.i("APQQWalletSDK", " toQQPay");
      try
      {
        this.d.a(paramBundle);
        this.d.a(this.a);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        if (paramResultReceiver != null) {
          paramResultReceiver.send(-11, localBundle1);
        }
        paramResultReceiver = new StringBuilder();
        paramResultReceiver.append(" toQQPay addObserver e:");
        paramResultReceiver.append(paramBundle.toString());
        APLog.w("APQQWalletSDK", paramResultReceiver.toString());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.fn
 * JD-Core Version:    0.7.0.1
 */