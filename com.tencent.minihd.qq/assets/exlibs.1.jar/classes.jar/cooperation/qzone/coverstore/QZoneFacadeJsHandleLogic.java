package cooperation.qzone.coverstore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneFacadeJsHandleLogic
{
  public static final String a = QZoneFacadeJsHandleLogic.class.getSimpleName();
  public static final String b = "key_personalize_prefix";
  public static final String c = "key_personalize_prefix_19";
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleOpenVipFinish");
    }
    Intent localIntent = new Intent("action_facade_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "openVip");
    localIntent.putExtras(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "actionString: " + localIntent.getAction());
    }
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
  
  public static void a(WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleSetFacadeFinish");
    }
    LocalMultiProcConfig.a("key_personalize_prefix_19", 0, Long.valueOf(paramPluginRuntime.a().a()).longValue());
    Intent localIntent = new Intent("action_facade_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "setAvatar");
    localIntent.putExtras(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "actionString: " + localIntent.getAction());
    }
    BaseApplication.getContext().sendBroadcast(localIntent);
    paramPluginRuntime.a().finish();
  }
  
  public static void a(String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleDownloadFacadeFinish");
    }
    String str1 = "";
    Object localObject3 = "";
    str2 = "";
    localObject4 = str2;
    Object localObject2 = localObject3;
    Object localObject1 = str1;
    if (paramVarArgs != null)
    {
      localObject4 = str2;
      localObject2 = localObject3;
      localObject1 = str1;
      if (paramVarArgs.length > 0)
      {
        localObject2 = localObject3;
        localObject1 = str1;
      }
    }
    try
    {
      localObject4 = new JSONObject(paramVarArgs[0]);
      localObject2 = localObject3;
      localObject1 = str1;
      paramVarArgs = ((JSONObject)localObject4).getString("avatarID");
      localObject2 = localObject3;
      localObject1 = paramVarArgs;
      localObject3 = ((JSONObject)localObject4).getString("avatarUrl");
      localObject2 = localObject3;
      localObject1 = paramVarArgs;
      localObject4 = ((JSONObject)localObject4).getString("type");
      localObject1 = paramVarArgs;
      localObject2 = localObject3;
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        localObject4 = str2;
      }
    }
    if (!TextUtils.isEmpty(localObject2))
    {
      paramVarArgs = new Intent("action_facade_js2qzone");
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("avatarId", (String)localObject1);
      ((Bundle)localObject3).putString("avatarUrl", localObject2);
      ((Bundle)localObject3).putString("type", (String)localObject4);
      ((Bundle)localObject3).putString("cmd", "downloadAvatar");
      paramVarArgs.putExtras((Bundle)localObject3);
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "actionString: " + paramVarArgs.getAction());
      }
      BaseApplication.getContext().sendBroadcast(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.coverstore.QZoneFacadeJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */