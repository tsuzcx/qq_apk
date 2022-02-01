import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.activity.AbsPublishIphoneTitleBarActivity;
import com.tencent.mobileqq.troop.data.MusicInfo;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;

public class kcb
  extends BroadcastReceiver
{
  public kcb(AbsPublishIphoneTitleBarActivity paramAbsPublishIphoneTitleBarActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("kTribeSelectMusic"))) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "onReceive:" + paramContext);
      }
    } while (TextUtils.isEmpty(paramContext));
    this.a.a = new MusicInfo(paramContext);
    this.a.a(1, this.a.a);
    TroopBarUtils.a(this.a.ad, this.a.ae, "choose_music", this.a.af, this.a.ac, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kcb
 * JD-Core Version:    0.7.0.1
 */