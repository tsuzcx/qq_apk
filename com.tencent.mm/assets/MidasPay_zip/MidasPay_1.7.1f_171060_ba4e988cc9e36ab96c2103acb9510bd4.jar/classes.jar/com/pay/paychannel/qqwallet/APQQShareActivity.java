package com.pay.paychannel.qqwallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.MidasAbilityResponse;
import com.pay.api.ability.MidasActivityAbility;
import com.pay.api.ability.MidasActivityAbility.QQMiniProgramShare;
import com.pay.api.ability.MidasActivityAbility.QQWebShare;
import com.pay.api.ability.MidasBaseAbility;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

public class APQQShareActivity
  extends APActivity
{
  public static String a = "unknown";
  private Tencent b;
  private MidasBaseAbility c;
  private IUiListener d = new IUiListener()
  {
    public void onCancel()
    {
      APLog.d("APQQShareActivity", "on cancel");
      MidasAbilityResponse.onCancel(APQQShareActivity.a(APQQShareActivity.this), 1, new Bundle());
    }
    
    public void onComplete(Object paramAnonymousObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("on complete: ");
      localStringBuilder.append(paramAnonymousObject);
      APLog.d("APQQShareActivity", localStringBuilder.toString());
      if (paramAnonymousObject == null)
      {
        MidasAbilityResponse.onFailureLIB(APQQShareActivity.a(APQQShareActivity.this), -1, "IUiListener.onComplete() rsp is Null", new Bundle());
        return;
      }
      paramAnonymousObject = (JSONObject)paramAnonymousObject;
      if (paramAnonymousObject.length() == 0)
      {
        MidasAbilityResponse.onFailureLIB(APQQShareActivity.a(APQQShareActivity.this), -1, "IUiListener.onComplete() rsp.length is 0", new Bundle());
        return;
      }
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onComplete() jsonResponse=");
        localStringBuilder.append(paramAnonymousObject.toString());
        APLog.d("APQQShareActivity", localStringBuilder.toString());
        MidasAbilityResponse.onSuccess(APQQShareActivity.a(APQQShareActivity.this), 0, new Bundle());
        return;
      }
      catch (Exception paramAnonymousObject)
      {
        paramAnonymousObject.printStackTrace();
        MidasAbilityResponse.onFailureLIB(APQQShareActivity.a(APQQShareActivity.this), -1, "IUiListener.onComplete() Bad Rsp", new Bundle());
      }
    }
    
    public void onError(UiError paramAnonymousUiError)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("on error: ");
      ((StringBuilder)localObject).append(paramAnonymousUiError);
      APLog.d("APQQShareActivity", ((StringBuilder)localObject).toString());
      localObject = new Bundle();
      ((Bundle)localObject).putInt("errorCode", paramAnonymousUiError.errorCode);
      ((Bundle)localObject).putString("errorMessage", paramAnonymousUiError.errorMessage);
      ((Bundle)localObject).putString("errorDetail", paramAnonymousUiError.errorDetail);
      MidasAbilityResponse.onFailureLIB(APQQShareActivity.a(APQQShareActivity.this), paramAnonymousUiError.errorCode, paramAnonymousUiError.errorDetail, (Bundle)localObject);
    }
  };
  
  private void a(Activity paramActivity, MidasActivityAbility.QQMiniProgramShare paramQQMiniProgramShare, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new Bundle();
    paramString1.putInt("req_type", 7);
    paramString1.putString("targetUrl", paramString2);
    paramString1.putString("imageUrl", paramQQMiniProgramShare.imageUrl);
    paramString1.putString("mini_program_appid", paramString3);
    paramString1.putString("mini_program_path", paramString4);
    if (!TextUtils.isEmpty(paramQQMiniProgramShare.title)) {
      paramString1.putString("title", paramQQMiniProgramShare.title);
    }
    if (!TextUtils.isEmpty(paramQQMiniProgramShare.summary)) {
      paramString1.putString("summary", paramQQMiniProgramShare.summary);
    }
    if (!TextUtils.isEmpty(paramQQMiniProgramShare.miniProgramType)) {
      paramString1.putString("mini_program_type", paramQQMiniProgramShare.miniProgramType);
    }
    paramQQMiniProgramShare = new StringBuilder();
    paramQQMiniProgramShare.append("miniProgramBundle = ");
    paramQQMiniProgramShare.append(paramString1);
    APLog.d("APQQShareActivity", paramQQMiniProgramShare.toString());
    this.b.shareToQQ(paramActivity, paramString1, this.d);
  }
  
  private void a(Activity paramActivity, MidasActivityAbility.QQWebShare paramQQWebShare, String paramString1, String paramString2)
  {
    paramString1 = new Bundle();
    int i = 1;
    paramString1.putInt("req_type", 1);
    paramString1.putString("title", paramQQWebShare.title);
    paramString1.putString("targetUrl", paramString2);
    if (!TextUtils.isEmpty(paramQQWebShare.summary)) {
      paramString1.putString("summary", paramQQWebShare.summary);
    }
    if (!TextUtils.isEmpty(paramQQWebShare.imageUrl)) {
      paramString1.putString("imageUrl", paramQQWebShare.imageUrl);
    }
    if (!TextUtils.isEmpty(paramQQWebShare.appName)) {
      paramString1.putString("appName", paramQQWebShare.appName);
    }
    if (paramQQWebShare.hideQzone) {
      i = 2;
    }
    paramString1.putInt("cflag", i);
    if (!TextUtils.isEmpty(paramQQWebShare.arkJson)) {
      paramString1.putString("share_to_qq_ark_info", paramQQWebShare.arkJson);
    }
    paramQQWebShare = new StringBuilder();
    paramQQWebShare.append("share bundle: ");
    paramQQWebShare.append(paramString1.toString());
    APLog.i("APQQShareActivity", paramQQWebShare.toString());
    this.b.shareToQQ(paramActivity, paramString1, this.d);
  }
  
  public static void a(Context paramContext, String paramString, MidasActivityAbility paramMidasActivityAbility, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, APQQShareActivity.class);
    localIntent.putExtra("from_static", "from_static");
    localIntent.putExtra("key_appid", paramString);
    localIntent.putExtra("key_params", paramBundle);
    localIntent.putExtra("key_request", paramMidasActivityAbility.toBundle());
    paramContext.startActivity(localIntent);
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra("key_appid");
    if (this.mActivity != null) {
      this.b = Tencent.createInstance((String)localObject1, this.mActivity.getApplicationContext());
    } else {
      this.b = Tencent.createInstance((String)localObject1, getApplicationContext());
    }
    localObject1 = paramIntent.getBundleExtra("key_params");
    Object localObject2 = paramIntent.getBundleExtra("key_request");
    paramIntent = new MidasActivityAbility();
    paramIntent.fromBundle((Bundle)localObject2);
    localObject2 = ((Bundle)localObject1).getString("orderId");
    String str1 = ((Bundle)localObject1).getString("shareUrl");
    String str2 = ((Bundle)localObject1).getString("qqMiniUrl");
    String str3 = ((Bundle)localObject1).getString("qqMiniPath");
    localObject1 = ((Bundle)localObject1).getString("qqMiniId");
    this.c = paramIntent;
    if ((paramIntent.shareInfo instanceof MidasActivityAbility.QQWebShare))
    {
      a(this, (MidasActivityAbility.QQWebShare)paramIntent.shareInfo, (String)localObject2, str1);
      return;
    }
    if ((paramIntent.shareInfo instanceof MidasActivityAbility.QQMiniProgramShare))
    {
      a(this, (MidasActivityAbility.QQMiniProgramShare)paramIntent.shareInfo, (String)localObject2, str2, (String)localObject1, str3);
      return;
    }
    APLog.w("APQQShareActivity", "toShareDistribute() unknown shareInfo");
    MidasAbilityResponse.onFailureSDK(this.c, -4, "Unknown shareInfo", new Bundle());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult() requestCode=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", resultCode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", data=");
    localStringBuilder.append(paramIntent);
    APLog.d("APQQShareActivity", localStringBuilder.toString());
    if ((paramInt1 == 10103) || (paramInt1 == 10104)) {}
    try
    {
      try
      {
        Tencent.onActivityResultData(paramInt1, paramInt2, paramIntent, this.d);
      }
      catch (Exception paramIntent)
      {
        APLog.e("APQQShareActivity", paramIntent.getMessage());
        paramIntent.printStackTrace();
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      label116:
      break label116;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("OpenSDK version: ");
    localStringBuilder.append(a);
    localStringBuilder.append(" didn't find onActivityResultData(), try handleResultData()");
    APLog.e("APQQShareActivity", localStringBuilder.toString());
    try
    {
      try
      {
        Tencent.handleResultData(paramIntent, this.d);
      }
      catch (Exception paramIntent)
      {
        APLog.e("APQQShareActivity", paramIntent.getMessage());
        paramIntent.printStackTrace();
      }
    }
    catch (NoSuchMethodError paramIntent)
    {
      label190:
      break label190;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("OpenSDK version: ");
    paramIntent.append(a);
    paramIntent.append(" didn't find handleResultData()");
    APLog.e("APQQShareActivity", paramIntent.toString());
    finish();
    APUICommonMethod.b(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreate savedInstanceState:");
    ((StringBuilder)localObject).append(paramBundle);
    APLog.i("APQQShareActivity", ((StringBuilder)localObject).toString());
    if (paramBundle != null)
    {
      finish();
      APUICommonMethod.b(this);
      return;
    }
    paramBundle = getIntent();
    localObject = paramBundle.getExtras().getString("from_static");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate() keyVerify=");
    localStringBuilder.append((String)localObject);
    APLog.i("APQQShareActivity", localStringBuilder.toString());
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
    APLog.e("APQQShareActivity", "launch way fail");
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.qqwallet.APQQShareActivity
 * JD-Core Version:    0.7.0.1
 */