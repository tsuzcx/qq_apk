import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile.ActionBarTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;

public class iwu
  implements View.OnClickListener
{
  public iwu(ActionBarTroopFile paramActionBarTroopFile) {}
  
  public void onClick(View paramView)
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if (localTroopFileStatusInfo.d == null) {}
    do
    {
      do
      {
        return;
        if (NetworkUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a()) == 0)
        {
          TroopFileError.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getString(2131363364));
          return;
        }
        TroopFileError.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), FileManagerUtil.d(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString) + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getString(2131362432), true);
        TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin).a(localTroopFileStatusInfo.d, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.b, localTroopFileStatusInfo.jdField_e_of_type_Int);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.e();
        paramView = paramView.getTag();
      } while (!(paramView instanceof HorizontalListViewAdapter.HlistViewHolder));
      paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView;
    } while (!paramView.a.isShowing());
    paramView.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iwu
 * JD-Core Version:    0.7.0.1
 */