package cooperation.qzone.famous;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneFamousUserHomePlugin
  extends WebViewPlugin
{
  public static String a = "QZFamousUserHome";
  public static String b = "usermoodlist";
  public static String c = "userbloglist";
  public static String d = "usermessagelist";
  public static String e = "useralbum";
  public static String f = "userhome";
  public static String g = "famous";
  public static String h = "key_uin";
  public static String i = "key_nickname";
  
  private void a(String... paramVarArgs)
  {
    try
    {
      long l = new JSONObject(paramVarArgs[0]).getLong("uin");
      paramVarArgs = new Intent();
      QzonePluginProxyActivity.a(paramVarArgs, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
      paramVarArgs.putExtra("qqid", l);
      paramVarArgs.putExtra("refer", g);
      QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramVarArgs, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneFamousUserHomePlugin", 4, "QZoneFamousUserHomePlugin openUserHome exception: " + paramVarArgs.toString());
      }
      paramVarArgs.printStackTrace();
    }
  }
  
  private void b(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      long l = paramVarArgs.getLong("uin");
      paramVarArgs = paramVarArgs.getString("nick");
      Intent localIntent = new Intent();
      QzonePluginProxyActivity.a(localIntent, "com.qzone.homepage.ui.activity.QzoneMoodListActivity");
      localIntent.putExtra(h, l);
      if (!TextUtils.isEmpty(paramVarArgs)) {
        localIntent.putExtra(i, paramVarArgs);
      }
      localIntent.putExtra("refer", g);
      QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), localIntent, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  private void c(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      long l = paramVarArgs.getLong("uin");
      paramVarArgs = paramVarArgs.getString("nick");
      Intent localIntent = new Intent();
      QzonePluginProxyActivity.a(localIntent, "com.qzone.homepage.ui.activity.QZoneBlogListActivity");
      localIntent.putExtra(h, l);
      if (!TextUtils.isEmpty(paramVarArgs)) {
        localIntent.putExtra(i, paramVarArgs);
      }
      localIntent.putExtra("refer", g);
      QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), localIntent, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  private void d(String... paramVarArgs)
  {
    try
    {
      long l = new JSONObject(paramVarArgs[0]).getLong("uin");
      paramVarArgs = new Intent();
      QzonePluginProxyActivity.a(paramVarArgs, "com.qzone.homepage.ui.activity.QzoneMsgbListActivity");
      paramVarArgs.putExtra(h, l);
      paramVarArgs.putExtra("refer", g);
      QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramVarArgs, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  private void e(String... paramVarArgs)
  {
    try
    {
      long l = new JSONObject(paramVarArgs[0]).getLong("uin");
      paramVarArgs = new Intent();
      QzonePluginProxyActivity.a(paramVarArgs, "com.qzone.album.ui.activity.QZonePersonalAlbumActivity");
      paramVarArgs.putExtra("key_left_tab_title", this.mRuntime.a().getString(2131365482));
      paramVarArgs.putExtra("key_right_tab_title", this.mRuntime.a().getString(2131365484));
      paramVarArgs.putExtra("key_album_owner_uin", l);
      paramVarArgs.putExtra("key_selected_tab", 0);
      paramVarArgs.putExtra("refer", g);
      QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramVarArgs, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!a.equals(paramString2)) {}
    do
    {
      return false;
      if (paramString3.equals(b))
      {
        if (paramVarArgs != null) {
          b(paramVarArgs);
        }
        return true;
      }
      if (paramString3.equals(c))
      {
        if (paramVarArgs != null) {
          c(paramVarArgs);
        }
        return true;
      }
      if (paramString3.equals(d))
      {
        if (paramVarArgs != null) {
          d(paramVarArgs);
        }
        return true;
      }
      if (paramString3.equals(e))
      {
        if (paramVarArgs != null) {
          e(paramVarArgs);
        }
        return true;
      }
    } while (!paramString3.equals(f));
    if (paramVarArgs != null) {
      a(paramVarArgs);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.famous.QZoneFamousUserHomePlugin
 * JD-Core Version:    0.7.0.1
 */