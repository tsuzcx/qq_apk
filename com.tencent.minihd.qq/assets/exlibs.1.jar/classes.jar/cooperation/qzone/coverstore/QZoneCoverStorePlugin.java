package cooperation.qzone.coverstore;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import cooperation.qzone.QzonePluginProxyActivity;
import mbo;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneCoverStorePlugin
  extends WebViewPlugin
{
  private static int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity";
  private static final String jdField_b_of_type_JavaLangString = "CoverStore";
  private static final String jdField_c_of_type_JavaLangString = "QzCover";
  private static final String jdField_d_of_type_JavaLangString = "goToPhotoWall";
  private static final String e = "goToUserDefine";
  private static final String f = "setCover";
  private static final String g = "setWidgetEnable";
  private static final String h = "setWidget";
  private static final String i = "openYellowDiamond";
  private static final String j = "showStoreButton";
  private static final String k = "getWidgetEnable";
  private static final String l = "leftButtonClick";
  private int jdField_b_of_type_Int;
  private int jdField_c_of_type_Int;
  private int jdField_d_of_type_Int;
  
  static
  {
    a = 74000;
  }
  
  public QZoneCoverStorePlugin()
  {
    this.b = 1;
    this.c = 0;
    this.d = 4;
    a = WebViewPluginEngine.a(this) * 1000 + 10000;
  }
  
  private int a(String paramString)
  {
    try
    {
      int m = new JSONObject(paramString).getInt("widgetId");
      return m;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private String a()
  {
    switch (this.d)
    {
    case 4: 
    default: 
      return "jhan-cover1";
    case 1: 
      return "jhan-cover1";
    case 5: 
      return "jhan-cover1b";
    case 2: 
      return "jhan-cover2";
    case 6: 
      return "jhan-cover2b";
    case 3: 
      return "jhan-ziliaocover";
    }
    return "jhan-ziliaocoverb";
  }
  
  private String a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.getString("type");
      try
      {
        String str = localJSONObject.getString("from");
        if ((str.equals("qzone")) || (str.equals("userhome"))) {}
        for (this.c = 0;; this.c = 1)
        {
          this.d = Integer.parseInt(localJSONObject.getString("page"));
          return paramString;
        }
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1) {}
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        paramString = "";
      }
    }
    return paramString;
  }
  
  private void a()
  {
    String str = this.mRuntime.a().getAccount();
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity");
    localIntent.putExtra("cover_uin", Long.parseLong(str));
    localIntent.putExtra("set_source", this.c);
    QzonePluginProxyActivity.a(this.mRuntime.a(), str, localIntent, a + 1);
  }
  
  private void a(String paramString)
  {
    if ("MobileAlbum".equals(paramString))
    {
      paramString = this.mRuntime.a().getAccount();
      localIntent = new Intent();
      QzonePluginProxyActivity.a(localIntent, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
      localIntent.putExtra("open_what", 0);
      localIntent.putExtra("cover_uin", Long.parseLong(paramString));
      localIntent.putExtra("set_source", this.c);
      QzonePluginProxyActivity.a(this.mRuntime.a(), paramString, localIntent, a + 2);
    }
    while (!"QzoneAlbum".equals(paramString)) {
      return;
    }
    paramString = this.mRuntime.a().getAccount();
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
    localIntent.putExtra("open_what", 1);
    localIntent.putExtra("cover_uin", Long.parseLong(paramString));
    localIntent.putExtra("set_source", this.c);
    QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), localIntent, a + 3);
  }
  
  private boolean a(String paramString)
  {
    try
    {
      boolean bool = new JSONObject(paramString).getBoolean("enable");
      return bool;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("from");
      if ((str.equals("qzone")) || (str.equals("userhome"))) {}
      for (this.c = 0;; this.c = 1)
      {
        this.d = Integer.parseInt(paramString.getString("page"));
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"QzCover".equals(paramString2)) {
      return false;
    }
    if (paramString3.equals("goToPhotoWall"))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        b(paramVarArgs[0]);
      }
      a();
      return true;
    }
    if (paramString3.equals("showStoreButton"))
    {
      paramJsBridgeListener = (TextView)this.mRuntime.a().findViewById(2131297360);
      if (paramJsBridgeListener != null)
      {
        paramJsBridgeListener.setVisibility(0);
        paramJsBridgeListener.setTextColor(-1);
        paramJsBridgeListener.setText("背景商城");
        paramJsBridgeListener.setOnClickListener(new mbo(this));
      }
    }
    do
    {
      for (;;)
      {
        return false;
        if (paramString3.equals("goToUserDefine"))
        {
          a(a(paramVarArgs[0]));
          return true;
        }
        if (paramString3.equals("setWidgetEnable"))
        {
          boolean bool = a(paramVarArgs[0]);
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 3);
          paramJsBridgeListener.putExtra("widgetEnable", bool);
          QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, a + 6);
        }
        else if (paramString3.equals("setWidget"))
        {
          int m = a(paramVarArgs[0]);
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 2);
          paramJsBridgeListener.putExtra("widgetId", m);
          QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, a + 5);
        }
        else
        {
          if (!paramString3.equals("openYellowDiamond")) {
            break;
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            b(paramVarArgs[0]);
          }
          paramJsBridgeListener = this.mRuntime.a().getAccount();
          paramString1 = new Intent();
          paramString2 = this.mRuntime.a().getResources().getString(2131365400);
          QzonePluginProxyActivity.a(paramString1, "com.qzone.vip.QZoneOpenVIPActivity");
          paramString1.putExtra("aid", a());
          paramString1.putExtra("key_open_qzone_vip_success_tip", paramString2);
          paramString1.putExtra("key_need_show_dialog", false);
          QzonePluginProxyActivity.a(this.mRuntime.a(), paramJsBridgeListener, paramString1, a + 4);
        }
      }
      if (paramString3.equals("setCover"))
      {
        if ((paramVarArgs != null) && (!TextUtils.isEmpty(paramVarArgs[0])))
        {
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 4);
          paramJsBridgeListener.putExtra("cover", paramVarArgs[0]);
          QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, a + 7);
        }
        return true;
      }
      if (paramString3.equals("getWidgetEnable"))
      {
        paramString1 = "Widget_" + this.mRuntime.a().a();
        paramJsBridgeListener.a(Boolean.valueOf(this.mRuntime.a().getSharedPreferences(paramString1, 4).getBoolean("WidgetShow", true)));
        return true;
      }
    } while (!paramString3.equals("leftButtonClick"));
    ((TextView)this.mRuntime.a().findViewById(2131297357)).performClick();
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramInt == -1) {
      switch (paramByte)
      {
      }
    }
    do
    {
      return;
      this.mRuntime.a().setResult(1000, paramIntent);
      this.mRuntime.a().finish();
      return;
      this.mRuntime.a().setResult(1000, paramIntent);
      this.mRuntime.a().finish();
      return;
      this.mRuntime.a().setResult(1000, paramIntent);
      this.mRuntime.a().finish();
      return;
      this.mRuntime.a().setResult(1000, paramIntent);
      this.mRuntime.a().finish();
      return;
      this.mRuntime.a().setResult(1000, paramIntent);
      this.mRuntime.a().finish();
      return;
    } while (paramInt != -1);
    this.mRuntime.a().c("window.QzCoverJSInterface.onReceive({type:\"YellowInfo\",data:{vipType:\"normalVip\"}});");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.coverstore.QZoneCoverStorePlugin
 * JD-Core Version:    0.7.0.1
 */