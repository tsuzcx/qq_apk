import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class gzz
  extends Handler
{
  public gzz(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 8193: 
    case 8194: 
      do
      {
        do
        {
          do
          {
            return;
            if (QQSpecialFriendSettingActivity.a(this.a) == null)
            {
              QQSpecialFriendSettingActivity.a(this.a, new QQProgressDialog(this.a, this.a.getTitleBarHeight()));
              if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String))) {
                QQSpecialFriendSettingActivity.a(this.a).a((String)paramMessage.obj);
              }
            }
          } while ((this.a.isFinishing()) || (QQSpecialFriendSettingActivity.a(this.a).isShowing()));
          try
          {
            QQSpecialFriendSettingActivity.a(this.a).show();
            return;
          }
          catch (Exception paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.e("QQSpecialFriendSettingActivity", 2, "QQProgressDialog show exception.", paramMessage);
        return;
      } while ((QQSpecialFriendSettingActivity.a(this.a) == null) || (!QQSpecialFriendSettingActivity.a(this.a).isShowing()));
      QQSpecialFriendSettingActivity.a(this.a).dismiss();
      QQSpecialFriendSettingActivity.a(this.a, null);
      return;
    }
    QQToast.a(this.a, paramMessage.arg1, paramMessage.arg2, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gzz
 * JD-Core Version:    0.7.0.1
 */