import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.mobileqq.widget.PadQQCheckBox;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;

public class eii
  implements Runnable
{
  public eii(LoginActivity paramLoginActivity, String paramString, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.getAppRuntime().stopPCActivePolling("deleteAccount");
    for (;;)
    {
      try
      {
        ((AccountManager)this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.getAppRuntime().getManager(0)).deleteAccount(this.jdField_a_of_type_JavaLangString, null);
        HistoryChatMsgSearchKeyUtil.a(this.jdField_a_of_type_JavaLangString);
        if (LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity).a())
        {
          new MessageRecordManagerImpl().a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.b(this.jdField_a_of_type_JavaLangString);
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity;
        if (Build.VERSION.SDK_INT <= 10) {
          continue;
        }
        i = 4;
        localObject1 = ((LoginActivity)localObject1).getSharedPreferences("Last_Login", i);
        if ((localObject1 != null) && (((SharedPreferences)localObject1).contains("uin")) && (((SharedPreferences)localObject1).getString("uin", "").equals(this.jdField_a_of_type_JavaLangString)))
        {
          ((SharedPreferences)localObject1).edit().remove("uin").commit();
          if (QLog.isColorLevel()) {
            QLog.d("login", 2, "delete Last_Login");
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
      }
      finally
      {
        if (0 == 0) {
          continue;
        }
        throw new NullPointerException();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.runOnUiThread(new eij(this));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eii
 * JD-Core Version:    0.7.0.1
 */