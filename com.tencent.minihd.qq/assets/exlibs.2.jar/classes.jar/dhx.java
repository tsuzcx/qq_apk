import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AutoReplySettingActivity;

public class dhx
  implements CompoundButton.OnCheckedChangeListener
{
  public dhx(AutoReplySettingActivity paramAutoReplySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.a.b != null)
    {
      this.a.b.edit().putBoolean(this.a.getString(2131366264) + this.a.jdField_a_of_type_JavaLangString, paramBoolean).commit();
      if (paramBoolean)
      {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        AutoReplySettingActivity.a(this.a).setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    AutoReplySettingActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dhx
 * JD-Core Version:    0.7.0.1
 */