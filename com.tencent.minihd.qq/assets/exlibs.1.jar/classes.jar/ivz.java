import android.os.Environment;
import android.os.StatFs;
import android.widget.ProgressBar;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class ivz
  extends DeviceFileObserver
{
  public ivz(BaseActionBarDataLineFile paramBaseActionBarDataLineFile) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramSession.uSessionID != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.f();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = paramFloat;
    BaseActionBarDataLineFile.d(this.a);
    BaseActionBarDataLineFile.f(this.a).setProgress((int)(100.0F * paramFloat));
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramSession.uSessionID != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {}
    do
    {
      do
      {
        return;
        this.a.e();
        if (paramBoolean)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath = paramSession.strFilePathSrc;
          this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.a.b();
      } while (paramSession.bSend);
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        FMToastUtil.a(2131362082);
        return;
      }
    } while (new StatFs(AppConstants.aE).getAvailableBlocks() > 1);
    FMToastUtil.a(2131362081);
  }
  
  public void b(Session paramSession)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramSession.uSessionID != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.f();
    BaseActionBarDataLineFile.d(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    BaseActionBarDataLineFile.e(this.a).setProgress(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ivz
 * JD-Core Version:    0.7.0.1
 */