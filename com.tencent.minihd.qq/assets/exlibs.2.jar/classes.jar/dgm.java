import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class dgm
  implements CompoundButton.OnCheckedChangeListener
{
  public dgm(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.c(this.a).setContentDescription(this.a.getString(2131296773));
    SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131366260), "qqsetting_auto_receive_magic_face_key", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dgm
 * JD-Core Version:    0.7.0.1
 */