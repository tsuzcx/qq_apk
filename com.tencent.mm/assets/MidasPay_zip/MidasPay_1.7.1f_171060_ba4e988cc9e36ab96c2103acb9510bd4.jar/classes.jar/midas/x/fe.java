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

public class fe
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
      if (fe.a(fe.this) != null) {
        fe.a(fe.this).send(i, paramAnonymousMessage);
      }
      try
      {
        fe.b(fe.this).b(fe.this.a);
      }
      catch (Exception paramAnonymousMessage)
      {
        paramAnonymousMessage.printStackTrace();
      }
      return true;
    }
  });
  private Context c;
  private lu d;
  private ResultReceiver e;
  
  public fe(Context paramContext, String paramString)
  {
    this.c = paramContext;
    try
    {
      this.d = lu.a(paramContext, paramString);
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
      APDataReportManager.getInstance().insertData("sdk.qqwallet.sign.show", ed.b().n().a.saveType, ed.b().n().e.m, "", null);
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
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSuccess", false);
    localBundle.putInt("retCode", -11);
    localBundle.putString("retMsg", "uninstall qq");
    try
    {
      boolean bool = this.d.a();
      APLog.i("APQQWalletSDK", "toQQPay public APQQWalletSDK");
      if (!bool)
      {
        APUICommonMethod.a(this.c, "抱歉，QQ未安装或版本太低");
        if (paramResultReceiver != null) {
          paramResultReceiver.send(-11, localBundle);
        }
        return;
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
        paramResultReceiver.send(-11, localBundle);
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
          paramResultReceiver.send(-11, localBundle);
        }
        paramResultReceiver = new StringBuilder();
        paramResultReceiver.append(" toQQPay addObserver e:");
        paramResultReceiver.append(paramBundle.toString());
        APLog.w("APQQWalletSDK", paramResultReceiver.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.fe
 * JD-Core Version:    0.7.0.1
 */