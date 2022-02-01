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
import com.tencent.midas.plugin.APPluginActivity;
import com.tencent.midas.plugin.APPluginParams;
import com.tencent.midas.plugin.APPluginProxyActivity;
import java.lang.reflect.Field;
import midas.x.d5;
import midas.x.o4;
import midas.x.p4;
import midas.x.v5;

public class APPluginContainerActivity
  extends APActivity
{
  public static v5 d;
  public static Bundle e;
  public static String f;
  public static String g;
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, v5 paramv5)
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
    e = paramBundle;
    d = paramv5;
    f = paramString1;
    g = paramString2;
    paramString1 = new Intent(paramContext, APPluginContainerActivity.class);
    e.putString("KEY_VERIFY", "from_static");
    paramString1.putExtras(e);
    paramContext.startActivity(paramString1);
    return true;
  }
  
  public static Class<?> g()
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
  
  public final void a(Intent paramIntent)
  {
    this.c = p4.p().e();
    this.a = this.c.b.saveType;
    boolean bool = paramIntent.getBooleanExtra("isExpress", false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isExpress=");
    ((StringBuilder)localObject).append(bool);
    localObject = ((StringBuilder)localObject).toString();
    APDataReportManager.getInstance().insertData("sdk.hf.operatorbase.launchui", this.a, this.c.f.l, (String)localObject, null);
    paramIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", true);
    localObject = new APPluginParams(0);
    ((APPluginParams)localObject).mPluginName = f;
    ((APPluginParams)localObject).mConponentName = g;
    ((APPluginParams)localObject).mProxyActivityClass = g();
    ((APPluginParams)localObject).mIntent = paramIntent;
    ((APPluginParams)localObject).mRequestCode = 3000;
    ((APPluginParams)localObject).mTimeOut = 10000;
    ((APPluginParams)localObject).mProgressTips = null;
    ((APPluginParams)localObject).mIntent.setClass(this, ((APPluginParams)localObject).mProxyActivityClass);
    APPluginProxyActivity.openActivityForResult(this, ((APPluginParams)localObject).mPluginName, ((APPluginParams)localObject).mApkFilePath, ((APPluginParams)localObject).mConponentName, ((APPluginParams)localObject).mIntent, ((APPluginParams)localObject).mRequestCode);
  }
  
  public final void f()
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    e = null;
    finish();
    APUICommonMethod.a(this);
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
    d.a(paramInt2, localIntent.getExtras());
    d = null;
    f();
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
      APUICommonMethod.a(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APPluginContainerActivity
 * JD-Core Version:    0.7.0.1
 */