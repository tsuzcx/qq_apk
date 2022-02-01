import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.widget.WidgetContainer;
import com.tencent.mobileqq.app.QzoneMsgObserver;
import com.tencent.mobileqq.data.QQDoyen;
import com.tencent.mobileqq.data.UserSettings;
import com.tencent.mobileqq.helpers.UserSettingsHelper;
import com.tencent.qphone.base.util.QLog;

public class hcb
  extends QzoneMsgObserver
{
  public hcb(WidgetContainer paramWidgetContainer) {}
  
  public void a(boolean paramBoolean, QQDoyen paramQQDoyen)
  {
    if (QLog.isColorLevel()) {
      QLog.d(WidgetContainer.a(this.a), 2, "isSuccess:" + paramBoolean);
    }
    if (WidgetContainer.a(this.a) == null) {}
    do
    {
      return;
      localUserSettings = UserSettingsHelper.a(this.a.a.app);
      if (localUserSettings == null) {
        break;
      }
    } while ((localUserSettings.mQQDoyen == null) || (paramQQDoyen.equals(localUserSettings.mQQDoyen)));
    WidgetContainer.a(this.a, localUserSettings, paramQQDoyen);
    return;
    UserSettings localUserSettings = new UserSettings();
    WidgetContainer.a(this.a, localUserSettings, paramQQDoyen);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcb
 * JD-Core Version:    0.7.0.1
 */