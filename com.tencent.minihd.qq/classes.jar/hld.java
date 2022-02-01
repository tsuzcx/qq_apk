import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MQPIntChkHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class hld
  implements Runnable
{
  public hld(MQPIntChkHandler paramMQPIntChkHandler, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, String paramString3, String paramString4, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    try
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(BaseActivity.sTopActivity, 230, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      if (localQQCustomDialog == null)
      {
        if (!QLog.isDevelopLevel()) {
          return;
        }
        QLog.d("IntChk", 4, "create toast failed.");
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("IntChk", 4, "create toast succeed.");
      }
      localQQCustomDialog.setNegativeButton(this.c, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      localQQCustomDialog.setPositiveButton(this.d, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      localQQCustomDialog.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.show();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    MQPIntChkHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMQPIntChkHandler, true);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hld
 * JD-Core Version:    0.7.0.1
 */