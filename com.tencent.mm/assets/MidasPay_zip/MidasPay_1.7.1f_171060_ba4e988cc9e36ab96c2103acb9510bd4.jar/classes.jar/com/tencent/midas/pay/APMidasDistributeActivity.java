package com.tencent.midas.pay;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import com.pay.api.APAndroidPayAPI;
import com.pay.api.APPayResponse;
import com.pay.api.IAPPayCallBack;
import com.pay.api.MidasAbilityResponse;
import com.pay.api.ability.MidasActivityAbility;
import com.pay.api.ability.MidasBaseAbility;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APPluginReportParams;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.comm.APBeanUtil;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.af;
import midas.x.bs;
import midas.x.fm;
import midas.x.fw;
import midas.x.lt;

public class APMidasDistributeActivity
  extends APPluginActivity
  implements IAPPayCallBack
{
  public static String a = "com.tencent.midas.control.APMidasPayHelper";
  public static String b = "midasLoginExpire";
  public static String c = "midasCallBack";
  public static String d = "com.pay.api.request.";
  public static String e = "com.pay.api.ability.";
  public static String f = "Midas";
  public ResultReceiver g = null;
  
  public static void a(Context paramContext, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    Object localObject = paramBundle.getString("__midas_ability_baseReq__ClassSimpleName");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiveMidas() classSimpleName=");
    localStringBuilder.append((String)localObject);
    APLog.d("APMidasDistributeActivity", localStringBuilder.toString());
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(e);
      localStringBuilder.append((String)localObject);
      localObject = (MidasBaseAbility)lt.b(localStringBuilder.toString());
      ((MidasBaseAbility)localObject).fromBundle(paramBundle);
      APAndroidPayAPI.launchAbility(paramContext, (MidasBaseAbility)localObject, paramResultReceiver);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      MidasAbilityResponse.push(paramResultReceiver);
      paramContext = new MidasActivityAbility();
      paramContext.fromBundle(paramBundle);
      MidasAbilityResponse.onFailureSDK(paramContext, -6, "创建Ability对象失败", new Bundle());
    }
  }
  
  private void c()
  {
    try
    {
      new Handler().postDelayed(new a(null), 200L);
    }
    catch (Exception localException)
    {
      APLog.i("paycallback report", localException.toString());
    }
    finish();
    APUICommonMethod.b();
    bs.a().b();
    APUICommonMethod.g();
    APUICommonMethod.e();
    fw.a().b();
    APLog.d("APMidasDistributeActivity", "abilityRelease() end");
  }
  
  public void MidasPayCallBack(APPayResponse paramAPPayResponse)
  {
    if (this.g != null)
    {
      a(paramAPPayResponse);
    }
    else
    {
      APMidasResponse localAPMidasResponse = new APMidasResponse();
      try
      {
        APBeanUtil.copyProperties(paramAPPayResponse, localAPMidasResponse);
      }
      catch (Throwable paramAPPayResponse)
      {
        paramAPPayResponse.printStackTrace();
      }
      try
      {
        lt.a(a, c, new Object[] { localAPMidasResponse });
      }
      catch (Throwable paramAPPayResponse)
      {
        paramAPPayResponse.printStackTrace();
      }
    }
    finish();
  }
  
  public void MidasPayNeedLogin()
  {
    APLog.i("star callback", "MidasPayNeedLogin");
    if (this.g != null) {
      b();
    } else {
      try
      {
        lt.a(a, b, null);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    finish();
  }
  
  public void a()
  {
    Object localObject2 = getIntent().getStringExtra("env");
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("env = ");
    localStringBuilder1.append((String)localObject2);
    APLog.i("APMidasDistributeActivity", localStringBuilder1.toString());
    Object localObject3 = getIntent().getStringExtra("version");
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("version = ");
    localStringBuilder1.append((String)localObject3);
    APLog.i("APMidasDistributeActivity", localStringBuilder1.toString());
    int i = getIntent().getIntExtra("screenType", -1);
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("screenType = ");
    localStringBuilder1.append(i);
    APLog.i("APMidasDistributeActivity", localStringBuilder1.toString());
    boolean bool = getIntent().getBooleanExtra("logEnable", false);
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("logEnable = ");
    localStringBuilder1.append(bool);
    APLog.i("APMidasDistributeActivity", localStringBuilder1.toString());
    Object localObject4;
    try
    {
      this.g = ((ResultReceiver)getIntent().getExtras().get("remoteReceiver"));
    }
    catch (Exception localException1)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("get remoteReceiver err:");
      ((StringBuilder)localObject4).append(localException1.toString());
      APLog.i("APMidasDistributeActivity", ((StringBuilder)localObject4).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("get remoteReceiver :");
    ((StringBuilder)localObject1).append(this.g);
    APLog.i("APMidasDistributeActivity", ((StringBuilder)localObject1).toString());
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "release";
    }
    APAndroidPayAPI.setEnv((String)localObject1);
    APAndroidPayAPI.setLogEnable(bool);
    APAndroidPayAPI.setMidasPluginVersion((String)localObject3);
    if ((i == 0) || (i == 1)) {
      APAndroidPayAPI.setScreenType(Integer.valueOf(i));
    }
    setRequestedOrientation(i);
    localObject1 = (APMidasBaseRequest)getIntent().getSerializableExtra("req");
    localObject2 = localObject1.getClass().getSimpleName();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(d);
    ((StringBuilder)localObject3).append(((String)localObject2).replace(f, ""));
    localObject2 = ((StringBuilder)localObject3).toString();
    try
    {
      localObject3 = getIntent().getStringExtra("launchPayGUID");
      localObject4 = Long.valueOf(getIntent().getLongExtra("launchPayTime", 0L));
      i = getIntent().getIntExtra("launchPayDataid", 0);
      int j = getIntent().getIntExtra("launchIntervalTime", 0);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("launchPayGUID");
      localStringBuilder2.append((String)localObject3);
      APLog.i("paramsDistribute showFirstPageInsertDB=======", localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("launchPayTime");
      localStringBuilder2.append(localObject4);
      APLog.i("paramsDistribute showFirstPageInsertDB=======", localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("launchPayDataid");
      localStringBuilder2.append(i);
      APLog.i("paramsDistribute showFirstPageInsertDB=======", localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("launchIntervalTime");
      localStringBuilder2.append((String)localObject3);
      APLog.i("paramsDistribute showFirstPageInsertDB=======", localStringBuilder2.toString());
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        APPluginReportParams.getInstance().a(APTools.h());
      } else {
        APPluginReportParams.getInstance().a((String)localObject3);
      }
      if (((Long)localObject4).longValue() != 0L)
      {
        APPluginReportParams.getInstance().a(((Long)localObject4).longValue());
        int k = (int)(System.currentTimeMillis() - ((Long)localObject4).longValue());
        APPluginReportParams.getInstance().a(k);
      }
      if (i != 0) {
        af.a(i);
      }
      APPluginReportParams.getInstance().c(j);
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
    }
    try
    {
      localObject2 = (APBaseRequest)lt.b((String)localObject2);
      APBeanUtil.copyProperties(localObject1, localObject2);
      APLog.i("APMidasDistributeActivity", ((APBaseRequest)localObject2).toString());
      if ("openMidasWeb".equals(getIntent().getStringExtra("method")))
      {
        APAndroidPayAPI.launchWeb(this, (APBaseRequest)localObject2, this);
        return;
      }
      APAndroidPayAPI.launchPay(this, (APBaseRequest)localObject2, this);
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
  
  public void a(APPayResponse paramAPPayResponse)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("APMidasDistributeActivity updateRemotReceiver =");
    ((StringBuilder)localObject).append(this.g);
    APLog.e("Midas", ((StringBuilder)localObject).toString());
    if (this.g != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("type", "callback");
      ((Bundle)localObject).putInt("resultCode", paramAPPayResponse.resultCode);
      ((Bundle)localObject).putInt("resultInerCode", paramAPPayResponse.resultInerCode);
      ((Bundle)localObject).putInt("realSaveNum", paramAPPayResponse.realSaveNum);
      ((Bundle)localObject).putInt("payChannel", paramAPPayResponse.payChannel);
      ((Bundle)localObject).putInt("payState", paramAPPayResponse.payState);
      ((Bundle)localObject).putInt("provideState", paramAPPayResponse.provideState);
      ((Bundle)localObject).putString("resultMsg", paramAPPayResponse.resultMsg);
      ((Bundle)localObject).putString("extendInfo", paramAPPayResponse.extendInfo);
      ((Bundle)localObject).putString("payReserve1", paramAPPayResponse.payReserve1);
      ((Bundle)localObject).putString("payReserve2", paramAPPayResponse.payReserve2);
      ((Bundle)localObject).putString("payReserve3", paramAPPayResponse.payReserve3);
      paramAPPayResponse = paramAPPayResponse.getReceipt();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APMidasDistributeActivity updateRemotReceiver purchase =");
      localStringBuilder.append(paramAPPayResponse);
      APLog.i("Midas", localStringBuilder.toString());
      if (paramAPPayResponse != null)
      {
        ((Bundle)localObject).putString("purchaseJson", paramAPPayResponse.mOriginalJson);
        ((Bundle)localObject).putString("purchaseSign", paramAPPayResponse.mSignature);
        ((Bundle)localObject).putString("purchaseSku", paramAPPayResponse.mSku);
      }
      this.g.send(0, (Bundle)localObject);
    }
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("APMidasDistributeActivity updateRemotReceiver =");
    ((StringBuilder)localObject).append(this.g);
    APLog.e("Midas", ((StringBuilder)localObject).toString());
    if (this.g != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("type", "needlogin");
      this.g.send(0, (Bundle)localObject);
    }
  }
  
  protected void onCreate(final Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate savedInstanceState=");
    localStringBuilder.append(paramBundle);
    APLog.i("APMidasDistributeActivity", localStringBuilder.toString());
    super.onCreate(paramBundle);
    setRequestedOrientation(getResources().getConfiguration().orientation);
    getWindow().getDecorView().postDelayed(new Runnable()
    {
      public void run()
      {
        APMidasDistributeActivity.this.getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            APLog.i("APMidasDistributeActivity", "onCreate onTouch()");
            APUICommonMethod.b();
            fm.a(2, "");
            return true;
          }
        });
      }
    }, 3000L);
    if (paramBundle != null)
    {
      finish();
      return;
    }
    APUICommonMethod.pushActivity(this);
    paramBundle = getIntent().getStringExtra("distribute_type");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DISTRIBUTE_TYPE = ");
    localStringBuilder.append(paramBundle);
    APLog.d("APMidasDistributeActivity", localStringBuilder.toString());
    if ("midas_ability_activity".equals(paramBundle))
    {
      paramBundle = (ResultReceiver)getIntent().getParcelableExtra("distribute_receiver");
      a(this, getIntent().getExtras(), new ResultReceiver(new Handler())
      {
        protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onCreate.onReceiveResult() resultCode=");
          localStringBuilder.append(paramAnonymousInt);
          localStringBuilder.append(", resultData=");
          localStringBuilder.append(paramAnonymousBundle);
          APLog.i("APMidasDistributeActivity", localStringBuilder.toString());
          paramBundle.send(paramAnonymousInt, paramAnonymousBundle);
          APMidasDistributeActivity.a(APMidasDistributeActivity.this);
        }
      });
      return;
    }
    a();
  }
  
  protected void onResume()
  {
    APLog.e("APMidasDistributeActivity", "onResume");
    super.onResume();
  }
  
  static class a
    implements Runnable
  {
    public void run()
    {
      bs.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.tencent.midas.pay.APMidasDistributeActivity
 * JD-Core Version:    0.7.0.1
 */