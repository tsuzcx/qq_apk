import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqwifi.QQWiFiHelper;
import cooperation.qqwifi.QQWifiServlet;

public class dgq
  implements CompoundButton.OnCheckedChangeListener
{
  public dgq(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = BaseApplication.getContext();
    int i;
    String str;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      paramCompoundButton = paramCompoundButton.getSharedPreferences("mobileQQ", i).edit();
      str = this.a.app.a();
      if (!paramBoolean) {
        break label121;
      }
      paramCompoundButton.putInt("bar_switch_operation" + str, 1);
    }
    for (;;)
    {
      paramCompoundButton.commit();
      paramCompoundButton = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
      paramCompoundButton.putExtra("barswitch", true);
      this.a.sendBroadcast(paramCompoundButton);
      QQWifiServlet.a(this.a.app, paramBoolean);
      return;
      i = 0;
      break;
      label121:
      paramCompoundButton.putInt("bar_switch_operation" + str, -1);
      ((NotificationManager)this.a.getSystemService("notification")).cancel(QQWiFiHelper.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dgq
 * JD-Core Version:    0.7.0.1
 */