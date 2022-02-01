import android.widget.RelativeLayout;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class gaz
  implements CustomMenuBar.OnMenuItemClickListener
{
  public gaz(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    PublicAccountChatPie.a(this.a, new QQProgressDialog(PublicAccountChatPie.d(this.a).getContext(), this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight()));
    if ("DO_FOLLOW".equals(paramString))
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "Pb_account_lifeservice", "", "0X8004EF5", "0X8004EF5", 0, 0, "", "", "", "");
      PublicAccountChatPie.a(this.a, 2131363614);
      PublicAccountChatPie.d(this.a);
    }
    while (!"DO_NOT_FOLLOW".equals(paramString)) {
      return;
    }
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "Pb_account_lifeservice", "", "0X8004EF7", "0X8004EF7", 0, 0, "", "", "", "");
    PublicAccountChatPie.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gaz
 * JD-Core Version:    0.7.0.1
 */