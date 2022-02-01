import android.view.View;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.DatingComment;
import com.tencent.mobileqq.dating.DatingDetailActivity;
import com.tencent.mobileqq.dating.DatingStranger;
import com.tencent.mobileqq.dating.DetailModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.XListView;

public class icz
  implements ActionSheet.OnButtonClickListener
{
  public icz(DetailModel paramDetailModel, ActionSheet paramActionSheet, int paramInt, DatingComment paramDatingComment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new ida(this), 100L);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment != null) && ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_Int & 0x2) == 0))
        {
          ReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, 406, this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId, "0", this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app.a(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger.a), this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004F12 ");
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment == null) || ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_Int & 0x1) != 1));
      DetailModel.a(this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel, this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.dating.detail", 2, "detailmodel on item clicked comment is null.");
    return;
    DetailModel.a(this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel, this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     icz
 * JD-Core Version:    0.7.0.1
 */