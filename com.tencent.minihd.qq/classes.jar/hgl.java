import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class hgl
  extends BroadcastReceiver
{
  private hgl(BaseActivity paramBaseActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool;
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) {
      if ((this.a.mStopFlag == 0) && (this.a.mCanLock) && (this.a.app != null) && (GesturePWDUtils.getGesturePWDState(this.a.getActivity(), this.a.app.a()) == 2) && (GesturePWDUtils.getGesturePWDMode(this.a.getActivity(), this.a.app.a()) == 21) && (!(this.a.getActivity() instanceof GesturePWDUnlockActivity)) && (!(this.a.getActivity() instanceof LoginActivity)) && (!GesturePWDUtils.getGestureLocking(this.a.getActivity())))
      {
        this.a.startUnlockActivity();
        BaseActivity.isUnLockSuccess = false;
        if (QLog.isDevelopLevel()) {
          QLog.d("qqBaseActivity", 4, "onReceive broadcastreceiver.action=" + paramIntent.getAction());
        }
        if (BaseActivity.access$200() != null)
        {
          bool = SettingCloneUtil.readValue(this.a, null, this.a.getString(2131366269), "qqsetting_screenshot_key", false);
          if (bool) {
            this.a.turnOffShake();
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("qqBaseActivity", 4, "onReceive broadcastreceiver.action=" + paramIntent.getAction() + "| screenshot = " + bool);
          }
        }
      }
    }
    do
    {
      do
      {
        return;
        this.a.receiveScreenOff();
        break;
      } while ((!paramIntent.getAction().equals("android.intent.action.SCREEN_ON")) || (BaseActivity.access$200() != null));
      bool = SettingCloneUtil.readValue(this.a, null, this.a.getString(2131366269), "qqsetting_screenshot_key", false);
      if (bool) {
        this.a.turnOnShake();
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("qqBaseActivity", 4, "onReceive broadcastreceiver.action=" + paramIntent.getAction() + "| screenshot = " + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hgl
 * JD-Core Version:    0.7.0.1
 */