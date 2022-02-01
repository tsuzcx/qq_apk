import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.widget.ActionSheet;

public final class iwz
  implements View.OnClickListener
{
  public iwz(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, int paramInt, Activity paramActivity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject1).b = "file_forward";
    ((FileManagerReporter.fileAssistantReportData)localObject1).jdField_a_of_type_Int = 71;
    ((FileManagerReporter.fileAssistantReportData)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    ((FileManagerReporter.fileAssistantReportData)localObject1).c = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    ((FileManagerReporter.fileAssistantReportData)localObject1).d = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject1);
    Object localObject2 = ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    ((ForwardFileInfo)localObject2).b(this.jdField_a_of_type_Int);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("forward_type", 0);
    ((Bundle)localObject1).putParcelable("fileinfo", (Parcelable)localObject2);
    ((Bundle)localObject1).putBoolean("not_forward", true);
    localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    ((Intent)localObject2).putExtra("destroy_last_activity", true);
    ((Intent)localObject2).putExtra("forward_type", 0);
    ((Intent)localObject2).putExtra("forward_filepath", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
    ((Intent)localObject2).putExtra("forward_text", "已选择" + FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) + "。");
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 6) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 7))
    {
      ((Intent)localObject2).putExtra("isFromShare", true);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) {
        ((Intent)localObject2).putExtra("forward_type", 1);
      }
    }
    ((Intent)localObject2).putExtra("display_like_dialog", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject2, 103);
    if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
    {
      paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
      if (paramView.a.isShowing()) {
        paramView.a.dismiss();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iwz
 * JD-Core Version:    0.7.0.1
 */