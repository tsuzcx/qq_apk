import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;

public class dvk
  implements CompoundButton.OnCheckedChangeListener
{
  public dvk(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, DiscussionInfo paramDiscussionInfo) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramCompoundButton = DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
      return;
    }
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.hasCollect))
    {
      DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).e(Long.valueOf(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity)).longValue());
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app;
      if (!paramBoolean) {
        break label149;
      }
    }
    label149:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, paramCompoundButton, "", "", "");
      return;
      if ((paramBoolean) || (!this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.hasCollect)) {
        break;
      }
      DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).f(Long.valueOf(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity)).longValue());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dvk
 * JD-Core Version:    0.7.0.1
 */