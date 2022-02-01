import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.qphone.base.util.QLog;

public class eum
  extends NightModeLogic.NightModeCallback
{
  public eum(QQSettingMe paramQQSettingMe) {}
  
  public void a(Bundle paramBundle)
  {
    this.a.k();
  }
  
  public void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("start_status");
    if (i == 1) {
      this.a.k();
    }
    do
    {
      return;
      if (i == 2)
      {
        this.a.k();
        return;
      }
    } while (i != 3);
    if ((this.a.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {}
    for (;;)
    {
      i = paramBundle.getInt("percent");
      paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131369091);
      paramBundle = paramBundle + "  " + String.valueOf(i) + "%";
      this.a.c.setText(paramBundle);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QQSettingRedesign", 4, "NIGHTMODE_ACTION_DOWNLOADING: " + i);
      return;
      Drawable localDrawable = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130840565);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eum
 * JD-Core Version:    0.7.0.1
 */