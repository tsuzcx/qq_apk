import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.qphone.base.util.QLog;

public class eyv
  implements Runnable
{
  public eyv(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    do
    {
      boolean bool1;
      boolean bool2;
      String str1;
      String str2;
      do
      {
        return;
        bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("visibility", false);
        localObject = this.jdField_a_of_type_AndroidOsBundle.getString("enableVersion");
        bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("checked", false);
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("openDevLockText");
        str2 = this.jdField_a_of_type_AndroidOsBundle.getString("openDevLockHelpText");
        RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, this.jdField_a_of_type_AndroidOsBundle.getString("openDevLockHelpURL"));
      } while ((!bool1) || (TextUtils.isEmpty(str1)) || (RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, "5.9.3", (String)localObject) < 0));
      if (QLog.isColorLevel()) {
        QLog.d("RegisterVerifyCodeActivity", 2, "update ui.");
      }
      if ((bool2) && (RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity) != null)) {
        RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setChecked(bool2);
      }
      Object localObject = SpannableString.valueOf(str1);
      if (!TextUtils.isEmpty(str2))
      {
        eyw localeyw = new eyw(this, str1);
        int i = str1.indexOf(str2);
        ((SpannableString)localObject).setSpan(localeyw, i, str2.length() + i, 33);
      }
      RegisterVerifyCodeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setText((CharSequence)localObject);
      RegisterVerifyCodeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setMovementMethod(LinkMovementMethod.getInstance());
    } while (RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity) == null);
    RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eyv
 * JD-Core Version:    0.7.0.1
 */