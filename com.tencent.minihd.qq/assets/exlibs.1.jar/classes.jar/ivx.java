import android.widget.ProgressBar;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class ivx
  extends DataLineObserver
{
  public ivx(BaseActionBarDataLineFile paramBaseActionBarDataLineFile) {}
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.f();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = paramFloat;
    BaseActionBarDataLineFile.d(this.a);
    BaseActionBarDataLineFile.d(this.a).setProgress((int)(100.0F * paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong1 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin != 0L) {
        break;
      }
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().b(paramLong1);
    } while (paramString.isSendFromLocal());
    paramString.fileMsgStatus = 0L;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().c(paramString.msgId);
    this.a.f();
    BaseActionBarDataLineFile.d(this.a);
    BaseActionBarDataLineFile.b(this.a).setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
  }
  
  protected void a(String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.e();
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath = paramString;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
      {
        paramString = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().b(paramLong);
        if ((paramString != null) && (paramString.strMoloKey != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = FileManagerUtil.a(paramString.path);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
      return;
    }
    this.a.b();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong1 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.f();
    BaseActionBarDataLineFile.d(this.a);
    BaseActionBarDataLineFile.c(this.a).setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {}
    do
    {
      return;
      this.a.e();
      if (!paramBoolean) {
        break;
      }
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
    return;
    this.a.b();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ivx
 * JD-Core Version:    0.7.0.1
 */