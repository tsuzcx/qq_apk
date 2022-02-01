import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class eod
  extends CardObserver
{
  public eod(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  protected void onGetPCActiveState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      Message localMessage = NotifyPushSettingActivity.a(this.a).obtainMessage();
      localMessage.what = 10000;
      localMessage.obj = Boolean.valueOf(paramBoolean2);
      NotifyPushSettingActivity.a(this.a).sendMessage(localMessage);
      QLog.i("CardObserver_onGetPCActiveState", 1, "Succeeded to Get PC Active State with Msg");
      return;
    }
    QLog.i("CardObserver_onGetPCActiveState", 1, "Failed to Get PC Active State with Msg");
  }
  
  protected void onSetPCActiveState(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.a, this.a.a, null, "qqsetting_pcactive_key", paramBoolean2);
      QLog.i("CardObserver_onSetPCActiveState", 1, "Set the PC Active State " + paramBoolean1);
      return;
    }
    Message localMessage = NotifyPushSettingActivity.a(this.a).obtainMessage();
    localMessage.what = 10001;
    localMessage.obj = paramString2;
    NotifyPushSettingActivity.a(this.a).sendMessage(localMessage);
    QQToast.a(this.a, paramString1, 0).b(5);
    QLog.i("SetPCActiveState_Failure", 1, "Failed to set PC Active State " + paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eod
 * JD-Core Version:    0.7.0.1
 */