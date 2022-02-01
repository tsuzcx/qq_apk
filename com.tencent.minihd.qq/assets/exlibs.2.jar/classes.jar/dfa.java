import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class dfa
  extends TroopObserver
{
  public dfa(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(int paramInt, byte paramByte)
  {
    if (paramInt == 1)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 1, 2131366995, 1).b(this.a.getTitleBarHeight());
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (1 == paramInt) {}
    switch (paramByte)
    {
    default: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 1, 2131366995, 1).b(this.a.getTitleBarHeight());
      return;
    case 0: 
    case 1: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 2, 2131366994, 1).b(this.a.getTitleBarHeight());
      paramString = this.a.getIntent().getStringExtra("param_return_addr");
      if (paramString != null) {
        try
        {
          paramString = Class.forName(paramString);
          Intent localIntent = new Intent();
          localIntent.setComponent(new ComponentName("com.tencent.minihd.qq", paramString.getName()));
          localIntent.setFlags(67108864);
          this.a.startActivity(localIntent);
          return;
        }
        catch (ClassNotFoundException paramString)
        {
          paramString.printStackTrace();
          this.a.setResult(-1);
          this.a.finish();
          return;
        }
      }
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    QQToast.a(this.a, 1, 2131366967, 1).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    if ((this.a.b == null) || (!this.a.b.equals(paramString))) {}
    do
    {
      return;
      if (paramBoolean)
      {
        AddFriendVerifyActivity localAddFriendVerifyActivity = this.a;
        if (paramInt2 == 1) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localAddFriendVerifyActivity.c = paramBoolean;
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setChecked(this.a.c);
          if (!this.a.c) {
            break;
          }
          ReportController.b(this.a.app, "P_CliOper", "Grp_join", "", "write", "exp_open", 0, 0, paramString, "", "", "");
          return;
        }
        ReportController.b(this.a.app, "P_CliOper", "Grp_join", "", "write", "exp_close", 0, 0, paramString, "", "", "");
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AddFriendVerifyActivity", 2, "onGetExtShowTroopStatus failed");
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((this.a.b == null) || (!this.a.b.equals(paramString))) {
      return;
    }
    if (!paramBoolean)
    {
      QQToast.a(this.a, this.a.getString(2131363977), 0).b(this.a.getTitleBarHeight());
      AddFriendVerifyActivity.a(this.a);
    }
    paramString = this.a;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramString.d = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dfa
 * JD-Core Version:    0.7.0.1
 */