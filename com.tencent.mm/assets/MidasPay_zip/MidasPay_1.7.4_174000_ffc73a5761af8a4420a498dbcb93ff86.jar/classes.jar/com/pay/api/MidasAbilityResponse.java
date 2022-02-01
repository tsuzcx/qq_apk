package com.pay.api;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.pay.api.ability.MidasBaseAbility;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.util.Stack;

public class MidasAbilityResponse
{
  public static final int CANCEL = 1;
  public static final int ERROR_CGI = -2;
  public static final int ERROR_LIB = -3;
  public static final int ERROR_SDK = -1;
  public static final String PREFIX = "midas_callback_ability_";
  public static final int SUCCESS = 0;
  private static Stack<ResultReceiver> a = new Stack();
  
  private static Bundle a(MidasBaseAbility paramMidasBaseAbility, int paramInt, String paramString, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("midas_callback_ability_postBack", paramMidasBaseAbility.postBack);
    localBundle.putInt("midas_callback_ability_code", paramInt);
    localBundle.putString("midas_callback_ability_msg", paramString);
    localBundle.putBundle("midas_callback_ability_data", paramBundle);
    return localBundle;
  }
  
  private static ResultReceiver a()
  {
    if (a == null) {
      a = new Stack();
    }
    if (a.empty()) {
      return null;
    }
    return (ResultReceiver)a.pop();
  }
  
  public static void onCancel(MidasBaseAbility paramMidasBaseAbility, int paramInt, Bundle paramBundle)
  {
    paramMidasBaseAbility = a(paramMidasBaseAbility, paramInt, "", paramBundle);
    paramBundle = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCancel() receiver=");
    ((StringBuilder)localObject).append(paramBundle);
    ((StringBuilder)localObject).append(", backBundle=");
    ((StringBuilder)localObject).append(paramMidasBaseAbility.toString());
    APLog.i("MidasAbilityResponse", ((StringBuilder)localObject).toString());
    localObject = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiver=");
    localStringBuilder.append(paramBundle);
    ((APDataReportManager)localObject).insertData("sdk.ability.callback.cancel", 0, localStringBuilder.toString(), APAppDataInterface.singleton().l(), paramMidasBaseAbility.toString());
    if (paramBundle != null)
    {
      paramBundle.send(1, paramMidasBaseAbility);
      return;
    }
    APLog.w("MidasAbilityResponse", "onCancel() resultReceiver == Null");
  }
  
  public static void onFailureCGI(MidasBaseAbility paramMidasBaseAbility, int paramInt, String paramString, Bundle paramBundle)
  {
    paramMidasBaseAbility = a(paramMidasBaseAbility, paramInt, paramString, paramBundle);
    paramString = a();
    paramBundle = new StringBuilder();
    paramBundle.append("onFailureCGI() receiver=");
    paramBundle.append(paramString);
    paramBundle.append(", backBundle=");
    paramBundle.append(paramMidasBaseAbility.toString());
    APLog.i("MidasAbilityResponse", paramBundle.toString());
    paramBundle = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiver=");
    localStringBuilder.append(paramString);
    paramBundle.insertData("sdk.ability.callback.fail_cgi", 0, localStringBuilder.toString(), APAppDataInterface.singleton().l(), paramMidasBaseAbility.toString());
    if (paramString != null)
    {
      paramString.send(-2, paramMidasBaseAbility);
      return;
    }
    APLog.w("MidasAbilityResponse", "onFailureCGI() resultReceiver == Null");
  }
  
  public static void onFailureLIB(MidasBaseAbility paramMidasBaseAbility, int paramInt, String paramString, Bundle paramBundle)
  {
    paramMidasBaseAbility = a(paramMidasBaseAbility, paramInt, paramString, paramBundle);
    paramString = a();
    paramBundle = new StringBuilder();
    paramBundle.append("onFailureLIB() receiver=");
    paramBundle.append(paramString);
    paramBundle.append(", backBundle=");
    paramBundle.append(paramMidasBaseAbility.toString());
    APLog.i("MidasAbilityResponse", paramBundle.toString());
    paramBundle = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiver=");
    localStringBuilder.append(paramString);
    paramBundle.insertData("sdk.ability.callback.fail_lib", 0, localStringBuilder.toString(), APAppDataInterface.singleton().l(), paramMidasBaseAbility.toString());
    if (paramString != null)
    {
      paramString.send(-3, paramMidasBaseAbility);
      return;
    }
    APLog.w("MidasAbilityResponse", "onFailureLIB() resultReceiver == Null");
  }
  
  public static void onFailureSDK(MidasBaseAbility paramMidasBaseAbility, int paramInt, String paramString, Bundle paramBundle)
  {
    paramMidasBaseAbility = a(paramMidasBaseAbility, paramInt, paramString, paramBundle);
    paramString = a();
    paramBundle = new StringBuilder();
    paramBundle.append("onFailureSDK() receiver=");
    paramBundle.append(paramString);
    paramBundle.append(", backBundle=");
    paramBundle.append(paramMidasBaseAbility.toString());
    APLog.i("MidasAbilityResponse", paramBundle.toString());
    paramBundle = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiver=");
    localStringBuilder.append(paramString);
    paramBundle.insertData("sdk.ability.callback.fail_sdk", 0, localStringBuilder.toString(), APAppDataInterface.singleton().l(), paramMidasBaseAbility.toString());
    if (paramString != null)
    {
      paramString.send(-1, paramMidasBaseAbility);
      return;
    }
    APLog.w("MidasAbilityResponse", "onFailureSDK() resultReceiver == Null");
  }
  
  public static void onSuccess(MidasBaseAbility paramMidasBaseAbility, int paramInt, Bundle paramBundle)
  {
    paramMidasBaseAbility = a(paramMidasBaseAbility, paramInt, "", paramBundle);
    paramBundle = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSuccess() receiver=");
    ((StringBuilder)localObject).append(paramBundle);
    ((StringBuilder)localObject).append(", backBundle=");
    ((StringBuilder)localObject).append(paramMidasBaseAbility.toString());
    APLog.i("MidasAbilityResponse", ((StringBuilder)localObject).toString());
    localObject = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiver=");
    localStringBuilder.append(paramBundle);
    ((APDataReportManager)localObject).insertData("sdk.ability.callback.succ", 0, localStringBuilder.toString(), APAppDataInterface.singleton().l(), paramMidasBaseAbility.toString());
    if (paramBundle != null)
    {
      paramBundle.send(0, paramMidasBaseAbility);
      return;
    }
    APLog.w("MidasAbilityResponse", "onSuccess() resultReceiver == Null");
  }
  
  public static void push(ResultReceiver paramResultReceiver)
  {
    if (a == null) {
      a = new Stack();
    }
    a.push(paramResultReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.api.MidasAbilityResponse
 * JD-Core Version:    0.7.0.1
 */