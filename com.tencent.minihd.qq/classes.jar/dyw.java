import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qqfav.QfavUtil;

public class dyw
  implements DialogInterface.OnClickListener
{
  public dyw(ForwardOperations paramForwardOperations) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    paramInt = this.a.c();
    String str;
    if (paramInt == 0)
    {
      paramDialogInterface = this.a.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("mobileQQ", 0);
      str = "favorites_first_share_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      bool = paramDialogInterface.getBoolean(str, true);
      if (!bool) {
        QfavUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, 2131364731, 2);
      }
    }
    for (;;)
    {
      if (!bool) {
        ForwardOperations.a(this.a.jdField_a_of_type_AndroidAppActivity, true, "addToQQFavorites", this.a.jdField_a_of_type_Long);
      }
      return;
      paramDialogInterface.edit().putBoolean(str, false).commit();
      paramDialogInterface = this.a.jdField_a_of_type_AndroidAppActivity.getString(2131364734);
      str = this.a.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      StringBuilder localStringBuilder = new StringBuilder().append(paramDialogInterface);
      paramDialogInterface = str;
      if (TextUtils.isEmpty(str)) {
        paramDialogInterface = this.a.jdField_a_of_type_AndroidAppActivity.getString(2131364735);
      }
      paramDialogInterface = paramDialogInterface;
      paramDialogInterface = DialogUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, 230, this.a.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364657), this.a.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364732), paramDialogInterface, this.a.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364660), new dyx(this), new dyy(this));
      paramDialogInterface.setOnDismissListener(new dyz(this));
      if (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())
      {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(null);
        paramDialogInterface.show();
        continue;
        if (2 == paramInt) {
          QfavUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, 2131364696, 1);
        } else if (3 == paramInt) {
          QfavUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, 2131364733, 1);
        } else {
          QfavUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, 2131364730, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dyw
 * JD-Core Version:    0.7.0.1
 */