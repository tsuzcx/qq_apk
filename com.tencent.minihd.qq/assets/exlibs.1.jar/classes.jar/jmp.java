import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.util.URLUtil;

public class jmp
  extends BroadcastReceiver
{
  public jmp(ProfileCardWebviewPlugin paramProfileCardWebviewPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = this.a.mRuntime.a();
    } while ((paramContext == null) || (paramContext.isFinishing()));
    if ((paramContext instanceof QQBrowserActivity))
    {
      paramIntent = ((QQBrowserActivity)paramContext).M;
      if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.contains("entryId"))) {
        break label205;
      }
    }
    label205:
    for (this.a.a = URLUtil.a(URLUtil.a(paramIntent), "entryId", 2);; this.a.a = 2)
    {
      paramContext.finish();
      paramContext = new Intent(this.a.mRuntime.a(), FriendProfileCardActivity.class);
      paramIntent = new ProfileActivity.AllInOne(this.a.mRuntime.a().a(), 0);
      if (this.a.a == 0) {
        paramContext.setFlags(67108864);
      }
      paramContext.putExtra("AllInOne", paramIntent);
      this.a.mRuntime.a().startActivity(paramContext);
      paramContext = new Intent();
      paramContext.putExtra("closeSpecialLogic", true);
      this.a.mRuntime.a().setResult(-1, paramContext);
      this.a.mRuntime.a().finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jmp
 * JD-Core Version:    0.7.0.1
 */