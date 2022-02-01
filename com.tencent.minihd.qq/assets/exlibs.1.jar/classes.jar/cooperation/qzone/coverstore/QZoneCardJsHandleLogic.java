package cooperation.qzone.coverstore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneCardJsHandleLogic
{
  public static final String a = QZoneCardJsHandleLogic.class.getSimpleName() + QZonePersonalizePlugin.a;
  public static final String b = "QZoneCardLogic";
  public static final String c = "key_personalize_prefix";
  public static final String d = "key_personalize_prefix_18";
  
  public static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    String str8 = "";
    String str6 = "";
    String str7 = "";
    long l2 = 0L;
    String str4 = "";
    j = 0;
    String str5 = "";
    String str3 = str5;
    i = j;
    String str2 = str4;
    long l1 = l2;
    Object localObject2 = str7;
    String str1 = str6;
    Object localObject1 = str8;
    if (paramVarArgs != null)
    {
      str3 = str5;
      i = j;
      str2 = str4;
      l1 = l2;
      localObject2 = str7;
      str1 = str6;
      localObject1 = str8;
      if (paramVarArgs.length > 0)
      {
        str3 = str5;
        str2 = str4;
        l1 = l2;
        localObject2 = str7;
        str1 = str6;
        localObject1 = str8;
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
      str3 = str5;
      str2 = str4;
      l1 = l2;
      localObject2 = str7;
      str1 = str6;
      localObject1 = str8;
      str8 = localJSONObject.getString("result");
      str3 = str5;
      str2 = str4;
      l1 = l2;
      localObject2 = str7;
      str1 = str6;
      localObject1 = str8;
      paramVarArgs = localJSONObject.getString("sPicUrl");
      str3 = str5;
      str2 = str4;
      l1 = l2;
      localObject2 = paramVarArgs;
      str1 = str6;
      localObject1 = str8;
      str6 = localJSONObject.getString("sSkinId");
      str3 = str5;
      str2 = str4;
      l1 = l2;
      localObject2 = paramVarArgs;
      str1 = str6;
      localObject1 = str8;
      str5 = localJSONObject.getString("strTraceInfo");
      str3 = str5;
      str2 = str4;
      l1 = l2;
      localObject2 = paramVarArgs;
      str1 = str6;
      localObject1 = str8;
      str4 = localJSONObject.getString("title");
      str3 = str5;
      str2 = str4;
      l1 = l2;
      localObject2 = paramVarArgs;
      str1 = str6;
      localObject1 = str8;
      l2 = localJSONObject.getLong("uiSettleTime");
      str3 = str5;
      str2 = str4;
      l1 = l2;
      localObject2 = paramVarArgs;
      str1 = str6;
      localObject1 = str8;
      i = localJSONObject.getInt("vip_property");
      localObject1 = str8;
      str1 = str6;
      localObject2 = paramVarArgs;
      l1 = l2;
      str2 = str4;
      str3 = str5;
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        i = j;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneCardLogic." + a, 4, "handleSetSkinFinish result:" + (String)localObject1 + "js give cardurl is: " + (String)localObject2 + "\t cardid:" + str1);
    }
    if (((String)localObject1).equals("success"))
    {
      paramVarArgs = new Intent("action_personalize_js2qzone");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("sSkinId", str1);
      ((Bundle)localObject1).putLong("lUin", 0L);
      ((Bundle)localObject1).putString("sPicUrl", (String)localObject2);
      ((Bundle)localObject1).putLong("lTime", l1);
      ((Bundle)localObject1).putString("desc", "");
      ((Bundle)localObject1).putString("title", str2);
      ((Bundle)localObject1).putInt("vip_property", i);
      ((Bundle)localObject1).putString("strTraceInfo", str3);
      ((Bundle)localObject1).putString("cmd", "setcardfinish");
      paramVarArgs.putExtras((Bundle)localObject1);
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneCardLogic." + a, 4, "handleSetSkinFinish broadcast actionString: " + paramVarArgs.getAction() + "to qzone process");
      }
      BaseApplication.getContext().sendBroadcast(paramVarArgs);
      LocalMultiProcConfig.a("key_personalize_prefix_18", 0, Long.valueOf(paramPluginRuntime.a().a()).longValue());
      paramVarArgs = new Intent();
      QzonePluginProxyActivity.a(paramVarArgs, "com.qzone.personalize.QZoneCardApplyPreviewActivity");
      QzonePluginProxyActivity.a(paramPluginRuntime.a(), paramPluginRuntime.a().getAccount(), paramVarArgs, -1);
    }
  }
  
  public static void b(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    str2 = "";
    String str1 = "";
    Object localObject1 = str1;
    localObject2 = str2;
    if (paramVarArgs != null)
    {
      localObject1 = str1;
      localObject2 = str2;
      if (paramVarArgs.length > 0) {
        localObject1 = str1;
      }
    }
    try
    {
      localObject2 = new JSONObject(paramVarArgs[0]);
      localObject1 = str1;
      paramVarArgs = ((JSONObject)localObject2).getString("cardid");
      localObject1 = paramVarArgs;
      localObject2 = ((JSONObject)localObject2).getString("cardurl");
      localObject1 = paramVarArgs;
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        localObject2 = str2;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneCardLogic." + a, 4, "handleSetCardMethod cardurl is: " + (String)localObject2 + "\t cardid:" + (String)localObject1);
    }
    paramVarArgs = new Intent();
    QzonePluginProxyActivity.a(paramVarArgs, "com.qzone.personalize.QZoneCardApplyPreviewActivity");
    QzonePluginProxyActivity.a(paramPluginRuntime.a(), paramPluginRuntime.a().getAccount(), paramVarArgs, -1);
  }
  
  public static void c(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    str2 = "";
    String str1 = "";
    paramPluginRuntime = str1;
    localObject = str2;
    if (paramVarArgs != null)
    {
      paramPluginRuntime = str1;
      localObject = str2;
      if (paramVarArgs.length > 0) {
        paramPluginRuntime = str1;
      }
    }
    try
    {
      localObject = new JSONObject(paramVarArgs[0]);
      paramPluginRuntime = str1;
      paramVarArgs = ((JSONObject)localObject).getString("cardid");
      paramPluginRuntime = paramVarArgs;
      localObject = ((JSONObject)localObject).getString("cardurl");
      paramPluginRuntime = paramVarArgs;
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        localObject = str2;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneCardLogic." + a, 4, "handleDownCardMethod js give download cardurl is: " + (String)localObject + "\t cardid:" + paramPluginRuntime);
    }
    paramPluginRuntime = new Intent("action_personalize_js2qzone");
    paramVarArgs = new Bundle();
    paramVarArgs.putString("cmd", "downloadcard");
    paramVarArgs.putString("cardDownloadUrl", (String)localObject);
    paramPluginRuntime.putExtras(paramVarArgs);
    BaseApplication.getContext().sendBroadcast(paramPluginRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.coverstore.QZoneCardJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */