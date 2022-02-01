import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile.ActionBarTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;

public class iwr
  implements View.OnClickListener
{
  public iwr(ActionBarTroopFile paramActionBarTroopFile) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a()))
    {
      FMToastUtil.a(2131362551);
      return;
    }
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), "P_CliOper", "Grp_files", "", "in_mid", "Clk_download", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin + "", "", "", "");
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iwr
 * JD-Core Version:    0.7.0.1
 */