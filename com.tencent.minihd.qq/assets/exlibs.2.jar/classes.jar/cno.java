import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import mqq.app.AppActivity;

class cno
  implements DialogInterface.OnClickListener
{
  cno(cnm paramcnm, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_JavaLangString.toLowerCase();
    if (paramDialogInterface.startsWith("www.")) {
      paramDialogInterface = "http://" + this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Cnm.jdField_a_of_type_MqqAppAppActivity, QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", paramDialogInterface);
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("injectrecommend", false);
      this.jdField_a_of_type_Cnm.jdField_a_of_type_MqqAppAppActivity.startActivity(localIntent);
      if (this.jdField_a_of_type_Cnm.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Cnm.jdField_a_of_type_MqqAppAppActivity.finish();
      }
      return;
      if (paramDialogInterface.startsWith("https:")) {
        paramDialogInterface = "https" + this.jdField_a_of_type_JavaLangString.substring(5);
      } else if (paramDialogInterface.startsWith("http:")) {
        paramDialogInterface = "http" + this.jdField_a_of_type_JavaLangString.substring(4);
      } else {
        paramDialogInterface = this.jdField_a_of_type_JavaLangString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cno
 * JD-Core Version:    0.7.0.1
 */