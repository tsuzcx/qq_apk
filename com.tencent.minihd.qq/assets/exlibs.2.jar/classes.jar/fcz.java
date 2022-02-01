import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.qphone.base.util.QLog;

public class fcz
  implements View.OnClickListener
{
  public fcz(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onAddAccountClick.onClick:add account");
    }
    paramView = (SubAccountManager)this.a.app.getManager(59);
    if (paramView != null) {}
    for (int i = paramView.a();; i = 0)
    {
      if (i < 2)
      {
        paramView = new Intent(this.a, SubLoginActivity.class);
        paramView.putExtra("fromWhere", this.a.a);
        this.a.startActivity(paramView);
        return;
      }
      SubAccountControll.a(this.a.app, this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fcz
 * JD-Core Version:    0.7.0.1
 */