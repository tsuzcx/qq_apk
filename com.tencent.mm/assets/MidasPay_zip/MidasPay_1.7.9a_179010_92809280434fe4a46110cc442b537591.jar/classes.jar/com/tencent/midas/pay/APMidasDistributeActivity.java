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
import com.pay.paychannel.unionpay.APUnionPayChannel;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.comm.APBeanUtil;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.c6;
import midas.x.d5;
import midas.x.e5;
import midas.x.fc;
import midas.x.g0;
import midas.x.h5;
import midas.x.i5;
import midas.x.k6;
import midas.x.o;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.q3;
import midas.x.vd;
import midas.x.z1;
import midas.x.z5;

public class APMidasDistributeActivity
  extends APPluginActivity
  implements IAPPayCallBack
{
  public static String b = "com.tencent.midas.control.APMidasPayHelper";
  public static String c = "midasLoginExpire";
  public static String d = "midasCallBack";
  public static String e = "com.pay.api.request.";
  public static String f = "com.pay.api.ability.";
  public static String g = "Midas";
  public static h5 h = new c();
  public ResultReceiver a = null;
  
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
      localStringBuilder.append(f);
      localStringBuilder.append((String)localObject);
      localObject = (MidasBaseAbility)vd.a(localStringBuilder.toString());
      ((MidasBaseAbility)localObject).fromBundle(paramBundle);
      APAndroidPayAPI.launchAbility(paramContext, (MidasBaseAbility)localObject, paramResultReceiver);
      return;
    }
    finally
    {
      paramContext.printStackTrace();
      MidasAbilityResponse.push(paramResultReceiver);
      paramContext = new MidasActivityAbility();
      paramContext.fromBundle(paramBundle);
      MidasAbilityResponse.onFailureSDK(paramContext, -6, "创建Ability对象失败", new Bundle());
    }
  }
  
  /* Error */
  public void MidasPayCallBack(APPayResponse paramAPPayResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/tencent/midas/pay/APMidasDistributeActivity:a	Landroid/os/ResultReceiver;
    //   4: ifnull +11 -> 15
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 130	com/tencent/midas/pay/APMidasDistributeActivity:a	(Lcom/pay/api/APPayResponse;)V
    //   12: goto +50 -> 62
    //   15: new 132	com/tencent/midas/api/APMidasResponse
    //   18: dup
    //   19: invokespecial 133	com/tencent/midas/api/APMidasResponse:<init>	()V
    //   22: astore_2
    //   23: aload_1
    //   24: aload_2
    //   25: invokestatic 139	com/tencent/midas/comm/APBeanUtil:copyProperties	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   28: goto +8 -> 36
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 105	java/lang/Throwable:printStackTrace	()V
    //   36: getstatic 141	com/tencent/midas/pay/APMidasDistributeActivity:b	Ljava/lang/String;
    //   39: getstatic 143	com/tencent/midas/pay/APMidasDistributeActivity:d	Ljava/lang/String;
    //   42: iconst_1
    //   43: anewarray 145	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_2
    //   49: aastore
    //   50: invokestatic 148	midas/x/vd:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: goto +8 -> 62
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 105	java/lang/Throwable:printStackTrace	()V
    //   62: aload_0
    //   63: invokevirtual 151	com/tencent/midas/plugin/APPluginActivity:finish	()V
    //   66: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	APMidasDistributeActivity
    //   0	67	1	paramAPPayResponse	APPayResponse
    //   22	27	2	localAPMidasResponse	com.tencent.midas.api.APMidasResponse
    // Exception table:
    //   from	to	target	type
    //   23	28	31	finally
    //   36	54	57	finally
  }
  
  /* Error */
  public void MidasPayNeedLogin()
  {
    // Byte code:
    //   0: ldc 154
    //   2: ldc 155
    //   4: invokestatic 158	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 52	com/tencent/midas/pay/APMidasDistributeActivity:a	Landroid/os/ResultReceiver;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: invokevirtual 160	com/tencent/midas/pay/APMidasDistributeActivity:c	()V
    //   18: goto +22 -> 40
    //   21: getstatic 141	com/tencent/midas/pay/APMidasDistributeActivity:b	Ljava/lang/String;
    //   24: getstatic 162	com/tencent/midas/pay/APMidasDistributeActivity:c	Ljava/lang/String;
    //   27: aconst_null
    //   28: invokestatic 148	midas/x/vd:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   31: pop
    //   32: goto +8 -> 40
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 105	java/lang/Throwable:printStackTrace	()V
    //   40: aload_0
    //   41: invokevirtual 151	com/tencent/midas/plugin/APPluginActivity:finish	()V
    //   44: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	APMidasDistributeActivity
    //   35	2	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	32	35	finally
  }
  
  public final void a()
  {
    try
    {
      new Handler().postDelayed(new e(null), 200L);
    }
    catch (Exception localException)
    {
      APLog.i("paycallback report", localException.toString());
    }
    finish();
    APUICommonMethod.f();
    z1.d().a();
    APUICommonMethod.b();
    APUICommonMethod.h();
    k6.b().a();
    APLog.d("APMidasDistributeActivity", "abilityRelease() end");
  }
  
  public void a(APPayResponse paramAPPayResponse)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("APMidasDistributeActivity updateRemotReceiver =");
    ((StringBuilder)localObject).append(this.a);
    APLog.e("Midas", ((StringBuilder)localObject).toString());
    if (this.a != null)
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
      this.a.send(0, (Bundle)localObject);
    }
  }
  
  public void b()
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
      this.a = ((ResultReceiver)getIntent().getExtras().get("remoteReceiver"));
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
    ((StringBuilder)localObject1).append(this.a);
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
    ((StringBuilder)localObject3).append(e);
    ((StringBuilder)localObject3).append(((String)localObject2).replace(g, ""));
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
        APPluginReportParams.getInstance().a(APTools.j());
      } else {
        APPluginReportParams.getInstance().a((String)localObject3);
      }
      if (((Long)localObject4).longValue() != 0L)
      {
        APPluginReportParams.getInstance().a(((Long)localObject4).longValue());
        int k = (int)(System.currentTimeMillis() - ((Long)localObject4).longValue());
        APPluginReportParams.getInstance().c(k);
      }
      if (i != 0) {
        g0.a(i);
      }
      APPluginReportParams.getInstance().a(j);
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
    }
    try
    {
      localObject2 = (APBaseRequest)vd.a((String)localObject2);
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
  
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("APMidasDistributeActivity updateRemotReceiver =");
    ((StringBuilder)localObject).append(this.a);
    APLog.e("Midas", ((StringBuilder)localObject).toString());
    if (this.a != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("type", "needlogin");
      this.a.send(0, (Bundle)localObject);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    e5.h();
    i5 locali5 = e5.a("wechat_quickpass");
    if ((locali5 != null) && ((locali5 instanceof APUnionPayChannel))) {
      ((APUnionPayChannel)locali5).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate savedInstanceState=");
    localStringBuilder.append(paramBundle);
    APLog.i("APMidasDistributeActivity", localStringBuilder.toString());
    super.onCreate(paramBundle);
    setRequestedOrientation(getResources().getConfiguration().orientation);
    getWindow().getDecorView().postDelayed(new a(), 3000L);
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
      a(this, getIntent().getExtras(), new b(new Handler(), paramBundle));
      return;
    }
    b();
  }
  
  public void onResume()
  {
    APLog.e("APMidasDistributeActivity", "onResume()--------------");
    if ((z5.d()) && (!o.m().i()))
    {
      final String str = p4.p().e().f.e;
      if (((!c6.s0().x()) && ("wechat".equals(str))) || ((!c6.s0().w()) && ("qqwallet".equals(str))))
      {
        APLog.d("APMidasDistributeActivity", "APNetworkManager.getInstance().queryPayResult() begin...");
        APUICommonMethod.a(this, "查询支付结果...", false);
        z1.d().j(new d(str));
        c6.s0().g(true);
        c6.s0().f(true);
      }
    }
    if (c6.s0().p0())
    {
      c6.s0().v(false);
      z5.a(-1, "签约状态未知！");
    }
    super.onResume();
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      APMidasDistributeActivity.this.getWindow().getDecorView().setOnTouchListener(new a());
    }
    
    public class a
      implements View.OnTouchListener
    {
      public a() {}
      
      public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
      {
        APLog.i("APMidasDistributeActivity", "onCreate onTouch()");
        APUICommonMethod.f();
        z5.a(2, "");
        return true;
      }
    }
  }
  
  public class b
    extends ResultReceiver
  {
    public b(Handler paramHandler, ResultReceiver paramResultReceiver)
    {
      super();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate.onReceiveResult() resultCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", resultData=");
      localStringBuilder.append(paramBundle);
      APLog.i("APMidasDistributeActivity", localStringBuilder.toString());
      paramBundle.send(paramInt, paramBundle);
      APMidasDistributeActivity.a(APMidasDistributeActivity.this);
    }
  }
  
  public static final class c
    implements h5
  {
    public void a() {}
    
    public void a(int paramInt) {}
    
    public void a(int paramInt, String paramString1, String paramString2) {}
  }
  
  public class d
    implements fc
  {
    public d(String paramString) {}
    
    public void a(ob paramob)
    {
      APLog.d("APMidasDistributeActivity", "APNetworkManager.getInstance().queryPayResult() onSuccess");
      APUICommonMethod.b();
      e5.h();
      i5 locali5 = e5.a(str);
      paramob = (q3)paramob;
      if ((paramob.d() == 0) && (paramob.g() == 1))
      {
        locali5.a(null);
        return;
      }
      locali5.b(APMidasDistributeActivity.this, APMidasDistributeActivity.d());
    }
    
    public void b(ob paramob)
    {
      APLog.d("APMidasDistributeActivity", "APNetworkManager.getInstance().queryPayResult() onFailure");
      APUICommonMethod.b();
      e5.h();
      e5.a(str).b(APMidasDistributeActivity.this, APMidasDistributeActivity.d());
    }
    
    public void c(ob paramob)
    {
      APLog.d("APMidasDistributeActivity", "APNetworkManager.getInstance().queryPayResult() onStop");
      APUICommonMethod.b();
      e5.h();
      e5.a(str).b(APMidasDistributeActivity.this, APMidasDistributeActivity.d());
    }
  }
  
  public static class e
    implements Runnable
  {
    public void run()
    {
      z1.d().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.tencent.midas.pay.APMidasDistributeActivity
 * JD-Core Version:    0.7.0.1
 */