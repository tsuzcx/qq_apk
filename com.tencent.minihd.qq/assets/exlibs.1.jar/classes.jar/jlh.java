import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.net.URLEncoder;

public class jlh
  implements DialogInterface.OnClickListener
{
  public jlh(PhoneNumLoginImpl paramPhoneNumLoginImpl, String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      paramDialogInterface = new StringBuilder("https://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw");
      paramDialogInterface.append("?");
      paramDialogInterface.append("uin=");
      paramDialogInterface.append(this.jdField_a_of_type_JavaLangString);
      paramDialogInterface.append("&plat=1");
      paramDialogInterface.append("&app=1");
      paramDialogInterface.append("&version=5.9.3.3468");
      paramDialogInterface.append("&device=" + URLEncoder.encode(Build.DEVICE));
      paramDialogInterface.append("&system=" + Build.VERSION.RELEASE);
      paramDialogInterface.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      paramDialogInterface = paramDialogInterface.toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("url", paramDialogInterface);
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramDialogInterface, 32768L, localIntent, false, -1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Mobile_signup", "Setiing_pw_tips", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jlh
 * JD-Core Version:    0.7.0.1
 */