package com.pay.ui.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.plugin.APPluginParams;
import com.tencent.midas.plugin.APPluginProxyActivity;
import java.lang.reflect.Field;
import midas.x.el;
import midas.x.em;
import midas.x.fa;
import midas.x.fr;

public class APPluginContainerActivity
  extends APActivity
{
  private static fr a;
  private static Bundle b;
  private static String c;
  private static String d;
  
  private static Class<?> a()
  {
    try
    {
      localObject1 = Class.forName("com.tencent.midas.proxyactivity.APMidasPayProxyActivity");
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      try
      {
        Object localObject2 = Class.forName("com.wsj.pay.proxyactivity.APWSJPayProxyActivity");
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getProxyClass proxy:");
        ((StringBuilder)localObject1).append(localObject2);
        APLog.i("APHFMobileMiguGame", ((StringBuilder)localObject1).toString());
        return localObject2;
        localClassNotFoundException1 = localClassNotFoundException1;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        for (;;)
        {
          ClassNotFoundException localClassNotFoundException3 = localClassNotFoundException1;
        }
      }
    }
    localObject1 = null;
    localObject2 = localObject1;
    if (localObject1 != null) {}
  }
  
  private void a(Intent paramIntent)
  {
    this.p = em.b().n();
    this.f = this.p.a.saveType;
    boolean bool = paramIntent.getBooleanExtra("isExpress", false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isExpress=");
    ((StringBuilder)localObject).append(bool);
    localObject = ((StringBuilder)localObject).toString();
    APDataReportManager.getInstance().insertData("sdk.hf.operatorbase.launchui", this.f, this.p.e.m, (String)localObject, null);
    paramIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", true);
    localObject = new APPluginParams(0);
    ((APPluginParams)localObject).mPluginName = c;
    ((APPluginParams)localObject).mConponentName = d;
    ((APPluginParams)localObject).mProxyActivityClass = a();
    ((APPluginParams)localObject).mIntent = paramIntent;
    ((APPluginParams)localObject).mRequestCode = 3000;
    ((APPluginParams)localObject).mTimeOut = 10000;
    ((APPluginParams)localObject).mProgressTips = null;
    ((APPluginParams)localObject).mIntent.setClass(this, ((APPluginParams)localObject).mProxyActivityClass);
    APPluginProxyActivity.openActivityForResult(this, ((APPluginParams)localObject).mPluginName, ((APPluginParams)localObject).mApkFilePath, ((APPluginParams)localObject).mConponentName, ((APPluginParams)localObject).mIntent, ((APPluginParams)localObject).mRequestCode);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, fr paramfr)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchUI(): pluginFileName=");
    localStringBuilder.append(paramString1);
    APLog.i("APPluginContainerActivity", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchUI(): pluginClassName=");
    localStringBuilder.append(paramString2);
    APLog.i("APPluginContainerActivity", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchUI(): params=");
    localStringBuilder.append(paramBundle);
    APLog.i("APPluginContainerActivity", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchUI(): context=");
    localStringBuilder.append(paramContext);
    APLog.i("APPluginContainerActivity", localStringBuilder.toString());
    b = paramBundle;
    a = paramfr;
    c = paramString1;
    d = paramString2;
    paramString1 = new Intent(paramContext, APPluginContainerActivity.class);
    b.putString("KEY_VERIFY", "from_static");
    paramString1.putExtras(b);
    paramContext.startActivity(paramString1);
    return true;
  }
  
  private void b()
  {
    try
    {
      Field localField = Class.forName("com.tencent.midas.plugin.APPluginProxyActivity").getDeclaredField("gPluginName");
      localField.setAccessible(true);
      localField.set("gPluginName", "MidasPay");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("e4:");
      localStringBuilder.append(localClassNotFoundException.toString());
      APLog.w("APTenpayActivity", localStringBuilder.toString());
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("e3:");
      localStringBuilder.append(localIllegalAccessException.toString());
      APLog.w("APTenpayActivity", localStringBuilder.toString());
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("e2:");
      localStringBuilder.append(localIllegalArgumentException.toString());
      APLog.w("APTenpayActivity", localStringBuilder.toString());
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("e1:");
      localStringBuilder.append(localNoSuchFieldException.toString());
      APLog.w("APTenpayActivity", localStringBuilder.toString());
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    b = null;
    finish();
    APUICommonMethod.b(this);
    Intent localIntent = paramIntent;
    if (paramIntent == null)
    {
      localIntent = new Intent();
      paramInt2 = -100;
      localIntent.putExtra("message", "获取付费信息失败，请稍候重试!");
      try
      {
        APPluginReportManager.getInstance().dataReport(APPluginDataInterface.singleton().getLaunchInterface());
      }
      catch (Exception paramIntent)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult() e = ");
        localStringBuilder.append(paramIntent.toString());
        APLog.e("APPluginContainerActivity", localStringBuilder.toString());
      }
    }
    a.a(paramInt2, localIntent.getExtras());
    a = null;
    b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreate savedInstanceState:");
    ((StringBuilder)localObject).append(paramBundle);
    APLog.i("APHFContainerActivity", ((StringBuilder)localObject).toString());
    if (paramBundle != null)
    {
      finish();
      APUICommonMethod.b(this);
      return;
    }
    paramBundle = getIntent();
    localObject = paramBundle.getExtras().getString("KEY_VERIFY");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate() keyVerify=");
    localStringBuilder.append((String)localObject);
    APLog.i("APPluginContainerActivity", localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ("from_static".equals(localObject))) {
      try
      {
        a(paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    APLog.e("APHFContainerActivity", "launch way fail");
    finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APPluginContainerActivity
 * JD-Core Version:    0.7.0.1
 */