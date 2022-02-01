import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.CallBack;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

public class dpe
  implements QvipSpecialSoundManager.CallBack
{
  public dpe(ChatSettingActivity paramChatSettingActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        String str = this.a.a.a(QvipSpecialCareManager.a(ChatSettingActivity.a(this.a), this.a.app));
        ChatSettingActivity.a(this.a).setRightText(str);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        ChatSettingActivity.b(this.a);
      }
      if (QLog.isColorLevel()) {
        QLog.i(ChatSettingActivity.b(this.a), 2, "loadSpecialSoundConfig fail.");
      }
      ChatSettingActivity.a(this.a).setRightText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpe
 * JD-Core Version:    0.7.0.1
 */