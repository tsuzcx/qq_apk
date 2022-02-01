import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;

public final class ixd
  implements View.OnClickListener
{
  public ixd(BaseActivity paramBaseActivity, FileManagerEntity paramFileManagerEntity, DataLineHandler paramDataLineHandler, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ForwardHandlerActivity.class);
    localIntent.putExtra("send_data_line", true);
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131365999));
    localBundle.putInt("forward_type", 0);
    localBundle.putBoolean("not_forward", true);
    localBundle.putInt("dataline_forward_type", 100);
    localBundle.putString("dataline_forward_path", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
    localBundle.putBoolean("isBack2Root", true);
    localBundle.putParcelable("fileinfo", ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
    localIntent.putExtras(localBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a, "CliOper", "", "", "0X8004B10", "0X8004B10", 0, 0, "", "", "", "");
    if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
    {
      paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
      if (paramView.a.isShowing()) {
        paramView.a.dismiss();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ixd
 * JD-Core Version:    0.7.0.1
 */