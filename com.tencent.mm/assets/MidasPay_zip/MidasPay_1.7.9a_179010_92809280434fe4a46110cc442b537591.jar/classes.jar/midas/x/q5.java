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

public class q5
{
  public static boolean e = false;
  public Context a;
  public wd b;
  public ResultReceiver c;
  public Handler d = new Handler(new a());
  
  public q5(Context paramContext, String paramString)
  {
    this.a = paramContext;
    try
    {
      this.b = wd.a(paramContext, paramString);
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
      APDataReportManager.getInstance().insertData("sdk.qqwallet.sign.show", p4.p().e().b.saveType, p4.p().e().f.l, "", null);
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
    e = paramBoolean;
  }
  
  public static boolean a()
  {
    return e;
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
    this.c = paramResultReceiver;
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("isSuccess", false);
    localBundle1.putInt("retCode", -11);
    localBundle1.putString("retMsg", "uninstall qq");
    try
    {
      boolean bool = this.b.a();
      APLog.i("APQQWalletSDK", "toQQPay public APQQWalletSDK");
      if (!bool)
      {
        bool = r1.g();
        if (bool)
        {
          if (paramResultReceiver == null) {
            return;
          }
          Bundle localBundle2 = new Bundle();
          localBundle2.putString("resultMsg", "抱歉，QQ未安装或版本太低");
          paramResultReceiver.send(-11, localBundle2);
          return;
        }
        APUICommonMethod.a(this.a, "抱歉，QQ未安装或版本太低");
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
        this.b.a(paramBundle);
        this.b.a(this.d);
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
  
  public class a
    implements Handler.Callback
  {
    public a() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      APLog.i("APQQWalletSDK", "handleMessage");
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("retCode");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage retCode = ");
      localStringBuilder.append(i);
      APLog.i("APQQWalletSDK", localStringBuilder.toString());
      if (q5.a(q5.this) != null) {
        q5.a(q5.this).send(i, paramMessage);
      }
      try
      {
        q5.b(q5.this).b(q5.this.d);
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.q5
 * JD-Core Version:    0.7.0.1
 */