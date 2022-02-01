package com.tencent.midas.pay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.pay.api.APAndroidPayAPI;
import com.pay.api.IAPNetCallBack;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APNetRequest;
import com.pay.data.report.APPluginReportParams;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasNetRequest;
import com.tencent.midas.comm.APBeanUtil;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginParams;
import com.tencent.midas.plugin.APPluginProxyActivity;
import java.lang.reflect.Method;
import midas.x.g0;
import midas.x.ue;
import midas.x.vd;
import midas.x.wd;
import midas.x.z5;
import org.json.JSONObject;

public class APMidasDistribute
{
  public static String CLS_MPH = "com.tencent.midas.control.APMidasPayHelper";
  public static String CLS_REQ_DIFF = "Midas";
  public static final String DISTRIBUTE_RECEIVER = "distribute_receiver";
  public static final String DISTRIBUTE_TYPE = "distribute_type";
  public static final String DISTRIBUTE_TYPE_ABILITY_ACTIVITY = "midas_ability_activity";
  public static String MED_MPH_ONERR = "onNetError";
  public static String MED_MPH_ONFINISH = "onNetFinish";
  public static String MED_MPH_ONSTOP = "onNetStop";
  public static String PKG_REQ = "com.pay.api.request.";
  public static final String TAG = "APMidasDistribute";
  
  public static String buildCallBackInfo(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      APLog.e("h5 callBack", paramString1);
      if (localJSONObject.get("__callback_id") != null)
      {
        boolean bool = isWSJ();
        if (bool)
        {
          paramString1 = new StringBuilder();
          paramString1.append("javascript:void(window.WSJPayJSBridge && window.WSJPayJSBridge._handleMsgFromWSJPay({'__msg_type':'callback','__callback_id':'");
          paramString1.append(localJSONObject.getString("__callback_id"));
          paramString1.append("','params':");
          paramString1.append(paramString2);
          paramString1.append("}))");
          paramString1 = paramString1.toString();
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append("javascript:void(window.MidasJSBridge && window.MidasJSBridge._handleMsgFromMidas({'__msg_type':'callback','__callback_id':'");
          paramString1.append(localJSONObject.getString("__callback_id"));
          paramString1.append("','params':");
          paramString1.append(paramString2);
          paramString1.append("}))");
          paramString1 = paramString1.toString();
        }
        return paramString1;
      }
    }
    finally
    {
      paramString2 = new StringBuilder();
      paramString2.append("buildCallBackInfo error:");
      paramString2.append(paramString1.toString());
      APLog.w("APMidasDistribute", paramString2.toString());
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static void callbackFromMidasPay(Activity paramActivity, Intent paramIntent)
  {
    APUICommonMethod.f();
    int i = -1;
    try
    {
      int j = paramIntent.getIntExtra("EXTRA_CALLBACK_RESULT_CODE", -1);
      i = j;
      paramActivity = paramIntent.getStringExtra("EXTRA_CALLBACK_RESULT_MSG");
      i = j;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      paramActivity = "Unexpected error!";
    }
    z5.a(i, paramActivity);
  }
  
  public static Class<?> getProxyClass()
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
        APLog.i("APMidasDistribute", ((StringBuilder)localObject1).toString());
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
  
  public static void golbalInit(Activity paramActivity, Intent paramIntent)
  {
    APLog.i("Faip===", "golbalInit Distribute");
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("golbalInit intent:");
      ((StringBuilder)localObject1).append(paramIntent);
      APLog.i("APMidasDistribute", ((StringBuilder)localObject1).toString());
      Object localObject7 = null;
      localObject1 = null;
      Object localObject5 = null;
      Object localObject3 = localObject7;
      Object localObject2;
      try
      {
        APMidasBaseRequest localAPMidasBaseRequest = (APMidasBaseRequest)paramIntent.getSerializableExtra("req");
        localObject3 = localObject7;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject3 = localObject7;
        localStringBuilder.append("golbalInit midasRequest:");
        localObject3 = localObject7;
        localStringBuilder.append(localAPMidasBaseRequest);
        localObject3 = localObject7;
        APLog.i("APMidasDistribute", localStringBuilder.toString());
        if (localAPMidasBaseRequest != null)
        {
          localObject3 = localObject7;
          localObject1 = localAPMidasBaseRequest.getClass().getSimpleName();
          localObject3 = localObject7;
          localStringBuilder = new StringBuilder();
          localObject3 = localObject7;
          localStringBuilder.append(PKG_REQ);
          localObject3 = localObject7;
          localStringBuilder.append(((String)localObject1).replace(CLS_REQ_DIFF, ""));
          localObject3 = localObject7;
          localObject1 = localStringBuilder.toString();
          try
          {
            localObject1 = (APBaseRequest)vd.a((String)localObject1);
            try
            {
              APBeanUtil.copyProperties(localAPMidasBaseRequest, localObject1);
            }
            catch (Exception localException4) {}
            localObject4 = localObject1;
          }
          catch (Exception localException2)
          {
            localObject1 = localException4;
            localObject6 = localException2;
          }
          APLog.w("golbalInit 1", ((Exception)localObject6).toString());
        }
      }
      catch (Exception localException1)
      {
        APLog.i("golbalInit midasRequest", localException1.toString());
        localObject2 = localObject4;
      }
      Object localObject6 = paramIntent.getStringExtra("env");
      Object localObject4 = localObject6;
      if (TextUtils.isEmpty((CharSequence)localObject6)) {
        localObject4 = "release";
      }
      APAndroidPayAPI.setEnv((String)localObject4);
      localObject4 = paramIntent.getStringExtra("version");
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("version = ");
      ((StringBuilder)localObject6).append((String)localObject4);
      APLog.i("APMidasDistributeActivity", ((StringBuilder)localObject6).toString());
      boolean bool = paramIntent.getBooleanExtra("logEnable", false);
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("logEnable = ");
      ((StringBuilder)localObject6).append(bool);
      APLog.i("APMidasDistributeActivity", ((StringBuilder)localObject6).toString());
      APAndroidPayAPI.setLogEnable(bool);
      APAndroidPayAPI.setMidasPluginVersion((String)localObject4);
      try
      {
        localObject4 = paramIntent.getStringExtra("launchInterfaceName");
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          setAPKLaunchInterfaceName((String)localObject4);
        }
      }
      catch (Exception localException3)
      {
        APLog.w("getStringExtra interfaceName", localException3.toString());
      }
      APAndroidPayAPI.globalInit(paramActivity, localObject2, (ResultReceiver)paramIntent.getParcelableExtra("receiver"));
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      APLog.w("golbalInit 2", paramActivity.toString());
    }
  }
  
  public static void handleQQWalletIntent(Activity paramActivity, Intent paramIntent)
  {
    APLog.d("APMidasDistribute", "handleQQWalletIntent get called!");
    try
    {
      if (wd.a(paramActivity) != null)
      {
        wd.a(paramActivity).a(paramIntent);
        return;
      }
      APLog.e("APMidasDistribute", "handleQQWalletIntent helper is null!");
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      paramIntent = new StringBuilder();
      paramIntent.append("handle qq wallet intent got exception = ");
      paramIntent.append(paramActivity.toString());
      APLog.e("APMidasDistribute", paramIntent.toString());
    }
  }
  
  public static void handleWXIntent(Activity paramActivity, Intent paramIntent)
  {
    APLog.d("APMidasDistribute", "handleWXIntent get called!");
    try
    {
      ue.a(paramActivity).a(paramIntent);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      paramIntent = new StringBuilder();
      paramIntent.append("handle wx intent got exception = ");
      paramIntent.append(paramActivity.toString());
      APLog.e("APMidasDistribute", paramIntent.toString());
    }
  }
  
  public static boolean isWSJ()
  {
    try
    {
      Class.forName("com.tencent.midas.control.APMidasPayHelper").getDeclaredField("wsjIdentify");
      return true;
    }
    catch (ClassNotFoundException|NoSuchFieldException localClassNotFoundException) {}
    return false;
  }
  
  public static Object openMidasCall(String paramString, Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openMidasCall method | ");
    localStringBuilder.append(paramString);
    APLog.d("APMidasDistribute", localStringBuilder.toString());
    try
    {
      paramString = vd.a(APAndroidPayAPI.class, paramString, paramArrayOfObject);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Object openMidasCall2(String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    APLog.d("APMidasDistribute", "openMidasCall2 enter");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openMidasCall2 method | ");
    localStringBuilder.append(paramString);
    APLog.d("APMidasDistribute", localStringBuilder.toString());
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("openMidasCall2 param | ");
      localStringBuilder.append(paramArrayOfObject[i]);
      APLog.d("APMidasDistribute", localStringBuilder.toString());
      i += 1;
    }
    try
    {
      paramString = vd.a(APAndroidPayAPI.class, paramString, paramArrayOfObject, paramArrayOfClass);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("error:");
      paramArrayOfObject.append(paramString.toString());
      APLog.w("APMidasDistribute", paramArrayOfObject.toString());
    }
    return null;
  }
  
  public static void openMidasH5Pay(Activity paramActivity, final Intent paramIntent)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("openMidasH5Pay activity:");
    ((StringBuilder)localObject1).append(paramActivity);
    ((StringBuilder)localObject1).append(" intent:");
    ((StringBuilder)localObject1).append(paramIntent);
    APLog.i("APMidasDistribute", ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = paramIntent.getStringExtra("launchInterfaceName");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        setAPKLaunchInterfaceName((String)localObject1);
      }
    }
    catch (Exception localException1)
    {
      label66:
      String str;
      Object localObject2;
      break label66;
    }
    if ((paramIntent != null) && (paramIntent.hasExtra("message")))
    {
      localObject1 = paramIntent.getStringExtra("message");
      if (isWSJ()) {
        localObject1 = ((String)localObject1).substring(APMidasH5DistributeActivity.T.length(), ((String)localObject1).length());
      } else {
        localObject1 = ((String)localObject1).substring(APMidasH5DistributeActivity.S.length(), ((String)localObject1).length());
      }
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject1);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        str = null;
      }
      if (str == null) {
        localObject2 = "";
      } else {
        localObject2 = str.optString("func");
      }
      if ("launchWXMiniProgram".equals(localObject2))
      {
        str = str.optString("params");
        try
        {
          paramIntent = (ResultReceiver)paramIntent.getExtras().get("remoteReceiver");
        }
        catch (Exception paramIntent)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get remoteReceiver err:");
          ((StringBuilder)localObject2).append(paramIntent.toString());
          APLog.w("APMidasH5DistributeActivity", ((StringBuilder)localObject2).toString());
          paramIntent = null;
        }
        openMidasCall2("launchWXMiniProgram", new Object[] { paramActivity, str, new a(new Handler(), (String)localObject1, paramIntent) }, new Class[] { Context.class, String.class, ResultReceiver.class });
        paramActivity = new StringBuilder();
        paramActivity.append("openMidasH5Pay() launchWXMiniProgram h5MessageFinal= ");
        paramActivity.append((String)localObject1);
        APLog.d("APMidasDistribute", paramActivity.toString());
        return;
      }
    }
    localObject1 = new APPluginParams(0);
    ((APPluginParams)localObject1).mPluginName = "MidasPay";
    ((APPluginParams)localObject1).mConponentName = "com.tencent.midas.pay.APMidasH5DistributeActivity";
    ((APPluginParams)localObject1).mProxyActivityClass = getProxyClass();
    ((APPluginParams)localObject1).mIntent = paramIntent;
    ((APPluginParams)localObject1).mRequestCode = -1;
    ((APPluginParams)localObject1).mTimeOut = 10000;
    ((APPluginParams)localObject1).mProgressTips = null;
    ((APPluginParams)localObject1).mIntent.setClass(paramActivity, ((APPluginParams)localObject1).mProxyActivityClass);
    APPluginProxyActivity.openActivityForResult(paramActivity, ((APPluginParams)localObject1).mPluginName, ((APPluginParams)localObject1).mApkFilePath, ((APPluginParams)localObject1).mConponentName, ((APPluginParams)localObject1).mIntent, ((APPluginParams)localObject1).mRequestCode);
  }
  
  public static void openMidasInfo(Activity paramActivity, Intent paramIntent)
  {
    Object localObject2 = paramIntent.getStringExtra("env");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("openMidasInfo env = ");
    ((StringBuilder)localObject1).append((String)localObject2);
    APLog.i("APMidasDistributeActivity", ((StringBuilder)localObject1).toString());
    Object localObject3 = paramIntent.getStringExtra("version");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("openMidasInfo midasplugin sdk version = ");
    ((StringBuilder)localObject1).append((String)localObject3);
    APLog.i("APMidasDistributeActivity", ((StringBuilder)localObject1).toString());
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "release";
    }
    APAndroidPayAPI.setEnv((String)localObject1);
    APAndroidPayAPI.setMidasPluginVersion((String)localObject3);
    try
    {
      localObject1 = paramIntent.getStringExtra("launchInterfaceName");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        setAPKLaunchInterfaceName((String)localObject1);
      }
      try
      {
        label135:
        localObject1 = paramIntent.getStringExtra("launchPayGUID");
        localObject2 = Long.valueOf(paramIntent.getLongExtra("launchPayTime", 0L));
        int i = paramIntent.getIntExtra("launchPayDataid", 0);
        int j = paramIntent.getIntExtra("launchIntervalTime", 0);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("launchPayGUID");
        ((StringBuilder)localObject3).append((String)localObject1);
        APLog.i("openMidasPay showFirstPageInsertDB=======", ((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("launchPayTime");
        ((StringBuilder)localObject3).append(localObject2);
        APLog.i("openMidasPay showFirstPageInsertDB=======", ((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("launchPayDataid");
        ((StringBuilder)localObject3).append(i);
        APLog.i("openMidasPay showFirstPageInsertDB=======", ((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("launchIntervalTime");
        ((StringBuilder)localObject3).append((String)localObject1);
        APLog.i("openMidasPay showFirstPageInsertDB=======", ((StringBuilder)localObject3).toString());
        APPluginReportParams.getInstance().a((String)localObject1);
        if (((Long)localObject2).longValue() != 0L)
        {
          APPluginReportParams.getInstance().a(((Long)localObject2).longValue());
          int k = (int)(System.currentTimeMillis() - ((Long)localObject2).longValue());
          APPluginReportParams.getInstance().c(k);
        }
        if (i != 0) {
          g0.a(i);
        }
        APPluginReportParams.getInstance().a(j);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      APMidasBaseRequest localAPMidasBaseRequest = (APMidasBaseRequest)paramIntent.getSerializableExtra("req");
      localObject2 = localAPMidasBaseRequest.getClass().getSimpleName();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(PKG_REQ);
      ((StringBuilder)localObject3).append(((String)localObject2).replace(CLS_REQ_DIFF, ""));
      localObject2 = ((StringBuilder)localObject3).toString();
      try
      {
        localObject2 = (APBaseRequest)vd.a((String)localObject2);
        APBeanUtil.copyProperties(localAPMidasBaseRequest, localObject2);
        APLog.i("APMidasDistributeActivity", ((APBaseRequest)localObject2).toString());
        APAndroidPayAPI.launchInfo(paramActivity, paramIntent.getStringExtra("reqType"), (APBaseRequest)localObject2, new c());
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    catch (Exception localException2)
    {
      break label135;
    }
  }
  
  public static void openMidasNet(Activity paramActivity, Intent paramIntent)
  {
    Object localObject3 = paramIntent.getStringExtra("env");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("env = ");
    ((StringBuilder)localObject1).append((String)localObject3);
    APLog.i("APMidasDistributeActivity", ((StringBuilder)localObject1).toString());
    Object localObject4 = paramIntent.getStringExtra("version");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("midasplugin sdk version = ");
    ((StringBuilder)localObject1).append((String)localObject4);
    APLog.i("APMidasDistributeActivity", ((StringBuilder)localObject1).toString());
    localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject1 = "release";
    }
    APAndroidPayAPI.setEnv((String)localObject1);
    APAndroidPayAPI.setMidasPluginVersion((String)localObject4);
    try
    {
      localObject1 = paramIntent.getStringExtra("launchInterfaceName");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        setAPKLaunchInterfaceName((String)localObject1);
      }
      try
      {
        label135:
        localObject1 = paramIntent.getStringExtra("launchPayGUID");
        localObject3 = Long.valueOf(paramIntent.getLongExtra("launchPayTime", 0L));
        int i = paramIntent.getIntExtra("launchPayDataid", 0);
        int j = paramIntent.getIntExtra("launchIntervalTime", 0);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("launchPayGUID");
        ((StringBuilder)localObject4).append((String)localObject1);
        APLog.i("openMidasPay showFirstPageInsertDB=======", ((StringBuilder)localObject4).toString());
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("launchPayTime");
        ((StringBuilder)localObject4).append(localObject3);
        APLog.i("openMidasPay showFirstPageInsertDB=======", ((StringBuilder)localObject4).toString());
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("launchPayDataid");
        ((StringBuilder)localObject4).append(i);
        APLog.i("openMidasPay showFirstPageInsertDB=======", ((StringBuilder)localObject4).toString());
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("launchIntervalTime");
        ((StringBuilder)localObject4).append((String)localObject1);
        APLog.i("openMidasPay showFirstPageInsertDB=======", ((StringBuilder)localObject4).toString());
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          APPluginReportParams.getInstance().a(APTools.j());
        } else {
          APPluginReportParams.getInstance().a((String)localObject1);
        }
        if (((Long)localObject3).longValue() != 0L)
        {
          APPluginReportParams.getInstance().a(((Long)localObject3).longValue());
          int k = (int)(System.currentTimeMillis() - ((Long)localObject3).longValue());
          APPluginReportParams.getInstance().c(k);
        }
        if (i != 0) {
          g0.a(i);
        }
        APPluginReportParams.getInstance().a(j);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      paramIntent = (APMidasNetRequest)paramIntent.getSerializableExtra("req");
      Object localObject2 = paramIntent.getClass().getSimpleName();
      try
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(PKG_REQ);
        ((StringBuilder)localObject3).append(((String)localObject2).replace(CLS_REQ_DIFF, ""));
        localObject2 = (APNetRequest)vd.a(((StringBuilder)localObject3).toString());
        APBeanUtil.copyProperties(paramIntent, localObject2);
        APLog.i("APMidasDistributeActivity", ((APNetRequest)localObject2).toString());
        APAndroidPayAPI.launchNet(paramActivity, (APNetRequest)localObject2, new b());
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    catch (Exception localException2)
    {
      break label135;
    }
  }
  
  public static void openMidasPay(Activity paramActivity, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openMidasPay activity:");
    ((StringBuilder)localObject).append(paramActivity);
    ((StringBuilder)localObject).append(" intent:");
    ((StringBuilder)localObject).append(paramIntent);
    APLog.i("APMidasDistribute", ((StringBuilder)localObject).toString());
    try
    {
      localObject = paramIntent.getStringExtra("launchInterfaceName");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setAPKLaunchInterfaceName((String)localObject);
      }
      label63:
      localObject = new APPluginParams(0);
      ((APPluginParams)localObject).mPluginName = "MidasPay";
      ((APPluginParams)localObject).mConponentName = "com.tencent.midas.pay.APMidasDistributeActivity";
      ((APPluginParams)localObject).mProxyActivityClass = getProxyClass();
      ((APPluginParams)localObject).mIntent = paramIntent;
      ((APPluginParams)localObject).mRequestCode = -1;
      ((APPluginParams)localObject).mTimeOut = 10000;
      ((APPluginParams)localObject).mProgressTips = null;
      ((APPluginParams)localObject).mIntent.setClass(paramActivity, ((APPluginParams)localObject).mProxyActivityClass);
      APPluginProxyActivity.openActivityForResult(paramActivity, ((APPluginParams)localObject).mPluginName, ((APPluginParams)localObject).mApkFilePath, ((APPluginParams)localObject).mConponentName, ((APPluginParams)localObject).mIntent, ((APPluginParams)localObject).mRequestCode);
      return;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
  
  public static void openMidasWeb(Activity paramActivity, Intent paramIntent)
  {
    try
    {
      Object localObject = paramIntent.getStringExtra("launchInterfaceName");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setAPKLaunchInterfaceName((String)localObject);
      }
      label18:
      localObject = new APPluginParams(0);
      ((APPluginParams)localObject).mPluginName = "MidasPay";
      ((APPluginParams)localObject).mConponentName = "com.tencent.midas.pay.APMidasDistributeActivity";
      ((APPluginParams)localObject).mProxyActivityClass = getProxyClass();
      ((APPluginParams)localObject).mIntent = paramIntent;
      ((APPluginParams)localObject).mRequestCode = -1;
      ((APPluginParams)localObject).mTimeOut = 10000;
      ((APPluginParams)localObject).mProgressTips = null;
      ((APPluginParams)localObject).mIntent.setClass(paramActivity, ((APPluginParams)localObject).mProxyActivityClass);
      APPluginProxyActivity.openActivityForResult(paramActivity, ((APPluginParams)localObject).mPluginName, ((APPluginParams)localObject).mApkFilePath, ((APPluginParams)localObject).mConponentName, ((APPluginParams)localObject).mIntent, ((APPluginParams)localObject).mRequestCode);
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  public static void receiveMidas(Context paramContext, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("distribute_type", "midas_ability_activity");
    localIntent.putExtra("distribute_receiver", paramResultReceiver);
    paramBundle = new APPluginParams(0);
    paramBundle.mPluginName = "MidasPay";
    paramBundle.mConponentName = "com.tencent.midas.pay.APMidasDistributeActivity";
    paramBundle.mProxyActivityClass = getProxyClass();
    paramBundle.mIntent = localIntent;
    paramBundle.mRequestCode = -1;
    paramBundle.mTimeOut = 10000;
    paramBundle.mProgressTips = null;
    paramBundle.mIntent.setClass(paramContext, paramBundle.mProxyActivityClass);
    APPluginProxyActivity.openActivityForResult((Activity)paramContext, paramBundle.mPluginName, paramBundle.mApkFilePath, paramBundle.mConponentName, paramBundle.mIntent, paramBundle.mRequestCode);
  }
  
  public static void setAPKLaunchInterfaceName(String paramString)
  {
    try
    {
      Object localObject4 = Class.forName("com.pay.data.report.APPluginReportParams");
      if (localObject4 != null)
      {
        Object localObject3 = null;
        Object localObject1;
        try
        {
          Method localMethod = ((Class)localObject4).getDeclaredMethod("getInstance", new Class[0]);
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
          localNoSuchMethodException1.printStackTrace();
          localObject1 = null;
        }
        Object localObject2;
        try
        {
          localObject1 = localObject1.invoke(null, new Object[0]);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          localObject2 = null;
        }
        try
        {
          localObject4 = ((Class)localObject4).getMethod("setLaunchInterface", new Class[] { String.class });
          localObject3 = localObject4;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localNoSuchMethodException2.printStackTrace();
        }
        try
        {
          localObject3.invoke(localObject2, new Object[] { paramString });
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void setLongConnection(Activity paramActivity, Intent paramIntent)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setLongConnection intent:");
      ((StringBuilder)localObject1).append(paramIntent);
      APLog.i("APMidasDistribute", ((StringBuilder)localObject1).toString());
      Object localObject2 = paramIntent.getStringExtra("env");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "release";
      }
      APAndroidPayAPI.setEnv((String)localObject1);
      localObject1 = paramIntent.getStringExtra("version");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("version = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      APLog.i("APMidasDistributeActivity", ((StringBuilder)localObject2).toString());
      boolean bool = paramIntent.getBooleanExtra("logEnable", false);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("logEnable = ");
      ((StringBuilder)localObject2).append(bool);
      APLog.i("APMidasDistributeActivity", ((StringBuilder)localObject2).toString());
      APAndroidPayAPI.setLogEnable(bool);
      APAndroidPayAPI.setMidasPluginVersion((String)localObject1);
      try
      {
        localObject1 = paramIntent.getStringExtra("launchInterfaceName");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          setAPKLaunchInterfaceName((String)localObject1);
        }
      }
      catch (Exception localException)
      {
        APLog.w("getStringExtra interfaceName", localException.toString());
      }
      APAndroidPayAPI.setLongConnection(paramActivity, paramIntent.getBooleanExtra("openLongConnection", true));
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      APLog.w("golbalInit 2", paramActivity.toString());
    }
  }
  
  public static final class a
    extends ResultReceiver
  {
    public a(Handler paramHandler, String paramString, ResultReceiver paramResultReceiver)
    {
      super();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = APTools.a(paramBundle);
      paramBundle = APMidasDistribute.buildCallBackInfo(this.a, paramBundle.toString());
      if (paramIntent != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("type", "h5callback");
        localBundle.putString("callbackinfo", paramBundle);
        paramIntent.send(0, localBundle);
        return;
      }
      try
      {
        vd.a(APMidasDistribute.CLS_MPH, "midasH5CallBack", new Object[] { paramBundle });
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public static final class b
    implements IAPNetCallBack
  {
    public void MidasNetError(String paramString1, int paramInt, String paramString2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(":");
      localStringBuilder.append(paramString2);
      APLog.d("APMidasDistribute", localStringBuilder.toString());
      try
      {
        vd.a(APMidasDistribute.CLS_MPH, APMidasDistribute.MED_MPH_ONERR, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    
    public void MidasNetFinish(String paramString1, String paramString2)
    {
      APLog.d("APMidasDistribute", paramString2);
      try
      {
        vd.a(APMidasDistribute.CLS_MPH, APMidasDistribute.MED_MPH_ONFINISH, new Object[] { paramString1, paramString2 });
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    
    public void MidasNetStop(String paramString)
    {
      APLog.d("APMidasDistribute", "MidasMPStop");
      try
      {
        vd.a(APMidasDistribute.CLS_MPH, APMidasDistribute.MED_MPH_ONSTOP, new Object[] { paramString });
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static final class c
    implements IAPNetCallBack
  {
    public void MidasNetError(String paramString1, int paramInt, String paramString2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(":");
      localStringBuilder.append(paramString2);
      APLog.d("APMidasDistribute", localStringBuilder.toString());
      try
      {
        vd.a(APMidasDistribute.CLS_MPH, APMidasDistribute.MED_MPH_ONERR, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    
    public void MidasNetFinish(String paramString1, String paramString2)
    {
      APLog.d("APMidasDistribute", paramString2);
      try
      {
        vd.a(APMidasDistribute.CLS_MPH, APMidasDistribute.MED_MPH_ONFINISH, new Object[] { paramString1, paramString2 });
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    
    public void MidasNetStop(String paramString)
    {
      APLog.d("APMidasDistribute", "MidasMPStop");
      try
      {
        vd.a(APMidasDistribute.CLS_MPH, APMidasDistribute.MED_MPH_ONSTOP, new Object[] { paramString });
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.tencent.midas.pay.APMidasDistribute
 * JD-Core Version:    0.7.0.1
 */