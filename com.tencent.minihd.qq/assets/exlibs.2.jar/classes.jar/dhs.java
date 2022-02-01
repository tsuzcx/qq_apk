import android.widget.Button;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.ClearableEditText;

public class dhs
  implements Runnable
{
  public dhs(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = Utils.c(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity) != null))
    {
      AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity).setText(str);
      AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dhs
 * JD-Core Version:    0.7.0.1
 */