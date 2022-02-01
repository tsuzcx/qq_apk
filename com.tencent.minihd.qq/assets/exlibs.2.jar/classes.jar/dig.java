import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class dig
  extends BroadcastReceiver
{
  public dig(BaseChatPie paramBaseChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "readconfirm network change");
      }
      paramContext = ((ConnectivityManager)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isAvailable()) && (BaseChatPie.a(this.a))) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(16711689);
      }
    }
    do
    {
      do
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(16711689);
        do
        {
          return;
        } while (!"android.intent.action.PHONE_STATE".equals(paramContext));
        paramContext = (TelephonyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("phone");
        if (paramContext.getCallState() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivity", 2, "receive action_phone_state_changed|call_state_ringing");
          }
          this.a.e(2);
        }
      } while (paramContext.getCallState() != 1);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "receive action_phone_state_changed|call_state_ringing");
      }
      paramContext = MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (!paramContext.b());
    paramContext.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dig
 * JD-Core Version:    0.7.0.1
 */