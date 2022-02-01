import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.utils.QQUtils;

public class dox
  implements Runnable
{
  public dox(ChatSettingActivity paramChatSettingActivity) {}
  
  public void run()
  {
    QQUtils.a(this.a.app, ChatSettingActivity.a(this.a), ChatSettingActivity.f(this.a), this.a.getTitleBarHeight(), this.a.a, 500, "0", ChatSettingActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dox
 * JD-Core Version:    0.7.0.1
 */