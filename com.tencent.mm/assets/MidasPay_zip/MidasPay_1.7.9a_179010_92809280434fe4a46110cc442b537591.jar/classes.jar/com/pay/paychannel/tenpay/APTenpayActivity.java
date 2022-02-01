package com.pay.paychannel.tenpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import com.tencent.midas.plugin.APPluginParams;
import com.tencent.midas.plugin.APPluginProxyActivity;
import java.lang.reflect.Field;

public class APTenpayActivity
  extends APActivity
{
  public int d = 0;
  public ResultReceiver e;
  
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
        APLog.i("APTenpayActivity", ((StringBuilder)localObject1).toString());
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
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, byte[] paramArrayOfByte, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, int paramInt3)
  {
    APLog.i("APTenpayActivity", "openTenpay");
    paramContext = new Intent();
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("skey", paramString2);
    paramContext.putExtra("skeyType", paramString3);
    paramContext.putExtra("tokenId", paramString4);
    paramContext.putExtra("payType", paramInt1);
    paramContext.putExtra("landMountText", paramString5);
    paramContext.putExtra("saveNum", paramString6);
    paramContext.putExtra("amountMark", paramString7);
    paramContext.putExtra("price", paramString8);
    paramContext.putExtra("vipResId", paramInt2);
    paramContext.putExtra("disPrice", paramString9);
    paramContext.putExtra("disCount", paramString10);
    paramContext.putExtra("type", paramInt3);
    paramContext.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", true);
    paramString1 = new APPluginParams(0);
    paramString1.mPluginName = "MidasCFT";
    paramString1.mConponentName = "com.tencent.midas.tenpay.APMidasTenpayActivity";
    paramString1.mProxyActivityClass = g();
    paramString1.mIntent = paramContext;
    paramString1.mRequestCode = 3000;
    paramString1.mTimeOut = 10000;
    paramString1.mProgressTips = null;
    paramString1.mIntent.setClass(this.mActivity, paramString1.mProxyActivityClass);
    paramContext = new StringBuilder();
    paramContext.append("mProxyActivity:");
    paramContext.append(this.mProxyActivity);
    APLog.i("APTenpayActivity", paramContext.toString());
    paramContext = new StringBuilder();
    paramContext.append("mActivity:");
    paramContext.append(this.mActivity);
    APLog.i("APTenpayActivity", paramContext.toString());
    paramContext = new StringBuilder();
    paramContext.append("this:");
    paramContext.append(this);
    APLog.i("APTenpayActivity", paramContext.toString());
    APPluginProxyActivity.openActivityForResult(this.mActivity, paramString1.mPluginName, paramString1.mApkFilePath, paramString1.mConponentName, paramString1.mIntent, paramString1.mRequestCode);
    APUICommonMethod.a("tenpay_before_jump");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult requestCode:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" resultCode:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("callBack:");
    localStringBuilder.append(this.e);
    APLog.i("APTenpayActivity", localStringBuilder.toString());
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3000)
    {
      try
      {
        if (this.e != null) {
          this.e.send(paramInt2, paramIntent.getExtras());
        }
      }
      catch (Exception paramIntent)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult error:");
        localStringBuilder.append(paramIntent.toString());
        APLog.i("APTenpayActivity", localStringBuilder.toString());
      }
      finish();
      APUICommonMethod.a(this);
      if (paramInt2 == 1) {
        APUICommonMethod.d();
      }
      f();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onCreate savedInstanceState:");
    ((StringBuilder)localObject1).append(paramBundle);
    APLog.i("APTenpayActivity", ((StringBuilder)localObject1).toString());
    if (paramBundle != null)
    {
      finish();
      APUICommonMethod.a(this);
      return;
    }
    APLog.i("APTenpayActivity", "onCreate");
    paramBundle = getIntent().getExtras();
    paramBundle.getInt("channel");
    this.d = paramBundle.getInt("payType");
    localObject1 = paramBundle.getString("saveNum");
    paramBundle.getString("count");
    String str1 = paramBundle.getString("uin");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("APTenpayActivity onCreate uin:");
    ((StringBuilder)localObject2).append(str1);
    APLog.i("APTenpayActivity", ((StringBuilder)localObject2).toString());
    localObject2 = paramBundle.getString("skey");
    String str2 = paramBundle.getString("skeyType");
    String str3 = paramBundle.getString("tokenId");
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("APTenpayActivity onCreate tokenId:");
    ((StringBuilder)localObject3).append(str3);
    APLog.i("APTenpayActivity", ((StringBuilder)localObject3).toString());
    localObject3 = paramBundle.getString("landMountText");
    String str4 = paramBundle.getString("amountMark");
    String str5 = paramBundle.getString("price");
    int i = paramBundle.getInt("vipResId");
    String str6 = paramBundle.getString("disPrice");
    String str7 = paramBundle.getString("disCount");
    int j = paramBundle.getInt("type");
    this.e = ((ResultReceiver)paramBundle.getParcelable("tenpayCallback"));
    if (!TextUtils.isEmpty(str3))
    {
      APLog.i("APTenpayActivity", "onCreate to openTenpay");
      a(this, str1, (String)localObject2, str2, str3, this.d, null, (String)localObject3, (String)localObject1, str4, str5, i, str6, str7, j);
    }
  }
  
  public void onDestroy()
  {
    APLog.i("APTenpayActivity", "onDestroy ");
    this.e = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.tenpay.APTenpayActivity
 * JD-Core Version:    0.7.0.1
 */