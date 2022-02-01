import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile.ActionBarTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import java.util.UUID;

public class iwv
  implements View.OnClickListener
{
  public iwv(ActionBarTroopFile paramActionBarTroopFile) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject1).b = "file_forward";
    ((FileManagerReporter.fileAssistantReportData)localObject1).a = 9;
    FileManagerReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(), (FileManagerReporter.fileAssistantReportData)localObject1);
    if (NetworkUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a()) == 0)
    {
      TroopFileError.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getString(2131363364));
      return;
    }
    Object localObject2 = new FileManagerEntity();
    ((FileManagerEntity)localObject2).copyFrom(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    ((FileManagerEntity)localObject2).nSessionId = FileManagerUtil.a().longValue();
    ((FileManagerEntity)localObject2).status = 2;
    localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    if (localObject1 != null) {
      ((QQAppInterface)localObject1).a().d((FileManagerEntity)localObject2);
    }
    localObject1 = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), (FileManagerEntity)localObject2);
    Object localObject3 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject3).b(((FileManagerEntity)localObject2).nSessionId);
    ((ForwardFileInfo)localObject3).b(10006);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).strFilePath)) {
      ((ForwardFileInfo)localObject3).a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString);
    }
    ((ForwardFileInfo)localObject3).d(((TroopFileStatusInfo)localObject1).e);
    ((ForwardFileInfo)localObject3).d(((TroopFileStatusInfo)localObject1).b);
    ((ForwardFileInfo)localObject3).a(((FileManagerEntity)localObject2).TroopUin);
    if (((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID != null) {
      ((ForwardFileInfo)localObject3).e(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID.toString());
    }
    ((ForwardFileInfo)localObject3).d(4);
    ((ForwardFileInfo)localObject3).a(2);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("forward_type", 0);
    ((Bundle)localObject2).putParcelable("fileinfo", (Parcelable)localObject3);
    ((Bundle)localObject2).putBoolean("not_forward", true);
    localObject3 = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), ForwardRecentActivity.class);
    ((Intent)localObject3).putExtras((Bundle)localObject2);
    ((Intent)localObject3).putExtra("forward_text", ((TroopFileStatusInfo)localObject1).e);
    ((Intent)localObject3).putExtra("forward_from_troop_file", true);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().startActivityForResult((Intent)localObject3, 103);
    paramView = paramView.getTag();
    if ((paramView instanceof HorizontalListViewAdapter.HlistViewHolder))
    {
      paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView;
      if (paramView.a.isShowing()) {
        paramView.a.dismiss();
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iwv
 * JD-Core Version:    0.7.0.1
 */