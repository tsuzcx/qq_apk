import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class gyv
  implements ActionSheet.OnButtonClickListener
{
  public gyv(ShortVideoPlayActivity paramShortVideoPlayActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      ThreadManager.a().post(ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity));
      if (ShortVideoPlayActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity) == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
        ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, true);
        return;
      }
      if (ShortVideoPlayActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity) == 3000)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
        ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, true);
        return;
      }
      if (ShortVideoPlayActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity) == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
        ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, true);
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
      ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, true);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity)), "video/*");
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.startActivity(paramView);
    if (ShortVideoPlayActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity) == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, true);
      return;
    }
    if (ShortVideoPlayActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity) == 3000)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, true);
      return;
    }
    if (ShortVideoPlayActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity) == 1)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, true);
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
    ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gyv
 * JD-Core Version:    0.7.0.1
 */