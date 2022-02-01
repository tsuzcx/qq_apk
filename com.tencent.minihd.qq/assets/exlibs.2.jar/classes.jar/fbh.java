import android.provider.Settings.System;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity.SoundStyle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class fbh
  implements View.OnClickListener
{
  public fbh(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a(SoundAndVibrateActivity.SoundStyle.system);
    SettingCloneUtil.writeValueForInt(this.a, this.a.app.a(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.a);
    if (this.a.a().booleanValue())
    {
      paramView = Settings.System.DEFAULT_NOTIFICATION_URI;
      this.a.b();
      this.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fbh
 * JD-Core Version:    0.7.0.1
 */