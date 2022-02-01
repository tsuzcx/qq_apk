import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;

public class dgk
  implements CompoundButton.OnCheckedChangeListener
{
  public dgk(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.a(this.a).setContentDescription("空间动态浏览无图模式");
    paramCompoundButton = new Intent("com.tencent.qq.syncNoPhotoSetting");
    this.a.app.a().sendBroadcast(paramCompoundButton);
    LocalMultiProcConfig.a(this.a.getString(2131366828), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dgk
 * JD-Core Version:    0.7.0.1
 */