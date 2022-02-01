import android.view.View;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class jpp
  implements ActionSheet.OnButtonClickListener
{
  public jpp(QCallDetailActivity paramQCallDetailActivity, boolean paramBoolean1, boolean paramBoolean2, int paramInt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).a(2131365730, 1);
        return;
      }
      for (;;)
      {
        long l;
        try
        {
          l = Long.parseLong(QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity));
          if (!this.jdField_a_of_type_Boolean) {
            break label167;
          }
          paramView = QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity);
          if (this.b) {
            break label162;
          }
          paramView.a(l, bool);
          if (!this.b) {
            break label240;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8004E6F", "0X8004E6F", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, 1, "无效的号码", 0).b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getTitleBarHeight());
        }
        break;
        label162:
        bool = false;
        continue;
        label167:
        paramView = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app.getManager(15);
        if (paramView != null)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(l));
          if (this.b) {
            paramView.b(this.jdField_a_of_type_Int, localArrayList);
          } else {
            paramView.a(this.jdField_a_of_type_Int, localArrayList);
          }
        }
      }
      label240:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8004E6E", "0X8004E6E", 0, 0, "", "", "", "");
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8004FA9", "0X8004FA9", 0, 0, "", "", "", "");
      ReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, 410, "", QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity), this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jpp
 * JD-Core Version:    0.7.0.1
 */