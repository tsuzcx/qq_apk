package com.tencent.open.agent;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;

public class AgentActivity
  extends Activity
{
  protected static final String b = "AgentActivity";
  protected Handler a;
  protected String a;
  protected boolean a;
  
  public AgentActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject = str;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString1, 64).signatures;
      localObject = str;
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localObject = str;
      localMessageDigest.update(paramContext[0].toByteArray());
      localObject = str;
      paramContext = HexUtil.a(localMessageDigest.digest());
      if (paramContext == null) {
        return "";
      }
      localObject = str;
      paramContext = paramContext.toLowerCase();
      localObject = str;
      if (QLog.isColorLevel())
      {
        localObject = str;
        QLog.d("AgentActivity", 2, "-->getAppSignatureMD5, sign: " + paramContext);
      }
      localObject = str;
      localMessageDigest.reset();
      localObject = str;
      localMessageDigest.update((paramString1 + "_" + paramContext + "_" + paramString2 + "").getBytes());
      localObject = str;
      paramContext = HexUtil.a(localMessageDigest.digest());
      localObject = paramContext;
      localMessageDigest.reset();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return localObject;
  }
  
  protected void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", "传入参数有误!");
    localIntent.putExtra("key_error_detail", "");
    localIntent.putExtra("key_response", "");
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onActivityResult, action: " + this.jdField_a_of_type_JavaLangString + " | requestCode: " + paramInt1 + " | resultCode: " + paramInt2 + " | data: " + paramIntent);
    }
    super.setResult(paramInt2, paramIntent);
    super.finish();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((super.getIntent() == null) || (paramBundle != null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AgentActivity", 2, "-->onCreate, intent: " + super.getIntent() + " | savedInstanceState: " + paramBundle);
      }
    }
    for (;;)
    {
      try
      {
        OpenSdkStatic.a().a(1, "LOGIN_CHECK_AGENT", null, null, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity getIntent is null");
        return;
      }
      catch (Exception paramBundle) {}
      Object localObject = "";
      try
      {
        paramBundle = super.getIntent().getStringExtra("key_action");
        localObject = paramBundle;
      }
      catch (Exception paramBundle)
      {
        continue;
      }
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      LogUtility.c("AgentActivity", "action = " + (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AgentActivity", 2, "-->onCreate, action: " + (String)localObject);
      }
      try
      {
        localBundle = super.getIntent().getBundleExtra("key_params");
        if (localBundle == null)
        {
          a(-5);
          if (!"action_login".equals(localObject)) {
            continue;
          }
          try
          {
            OpenSdkStatic.a().a(1, "LOGIN_CHECK_AGENT", null, null, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity bundle is null");
            return;
          }
          catch (Exception paramBundle) {}
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AgentActivity", 2, "-->onCreate, super.getIntent().getBundleExtra(Constants.KEY_PARAMS) has exception.");
        }
        Bundle localBundle = null;
        continue;
        String str2 = localBundle.getString("client_id");
        if ("action_login".equals(localObject))
        {
          paramBundle = new Intent(this, AuthorityActivity.class);
          paramBundle.putExtra("key_action", (String)localObject);
          String str3 = super.getCallingPackage();
          if (!TextUtils.isEmpty(str3))
          {
            localObject = System.currentTimeMillis() / 1000L + "";
            str3 = a(this, str3, (String)localObject);
            localBundle.putString("sign", str3);
            localBundle.putString("time", (String)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("AgentActivity", 2, "-->onCreate, sign: " + str3);
            }
          }
        }
        try
        {
          OpenSdkStatic.a().a(0, "LOGIN_CHECK_AGENT", null, str2, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
          if (paramBundle != null)
          {
            paramBundle.putExtra("key_params", localBundle);
            try
            {
              super.startActivityForResult(paramBundle, 0);
              return;
            }
            catch (ActivityNotFoundException paramBundle)
            {
              paramBundle.printStackTrace();
              a(-6);
              super.finish();
              return;
            }
            try
            {
              OpenSdkStatic.a().a(1, "LOGIN_CHECK_AGENT", null, str2, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity callFromPackageName is null");
            }
            catch (Exception localException1) {}
            continue;
            if ("action_pay".equals(localException1))
            {
              paramBundle = new Intent(this, AuthorityActivity.class);
              paramBundle.putExtra("key_action", localException1);
            }
            else if (("action_quick_login".equals(localException1)) || ("action_ptlogin_login".equals(localException1)))
            {
              str2 = super.getCallingPackage();
              paramBundle = new Intent(this, QuickLoginAuthorityActivity.class);
              paramBundle.putExtra("key_action", localException1);
              localBundle.putString("packagename", str2);
            }
            else
            {
              String str1;
              if (("action_invite".equals(localException1)) || ("action_gift".equals(localException1)) || ("action_ask".equals(localException1)) || ("action_reactive".equals(localException1)))
              {
                paramBundle = new Intent(this, SocialFriendChooser.class);
                if (paramBundle != null)
                {
                  paramBundle.putExtra("key_action", localException1);
                  str1 = localBundle.getString("hopenid");
                  localBundle.putString("encrytoken", OpensdkPreference.a(this, "openid_encrytoken").getString(str1, ""));
                }
              }
              else if ("action_story".equals(str1))
              {
                paramBundle = new Intent(this, SendStoryActivity.class);
              }
              else if ("action_brag".equals(str1))
              {
                paramBundle = new Intent(this, BragActivity.class);
              }
              else if ("action_challenge".equals(str1))
              {
                paramBundle = new Intent(this, ChallengeActivity.class);
              }
              else
              {
                a(-5);
                return;
              }
            }
          }
        }
        catch (Exception localException2) {}
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onDestroy, action: " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean) {
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity
 * JD-Core Version:    0.7.0.1
 */