import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.qphone.base.util.QLog;

public class iyu
  implements OfflineVideoFileViewBase.IControllProxyInterface
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  
  public iyu(OfflineVideoFileView paramOfflineVideoFileView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new iyv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public void c()
  {
    if (1 == OfflineVideoFileView.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileView).d())
    {
      FileManagerEntity localFileManagerEntity = OfflineVideoFileView.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileView).a();
      if (localFileManagerEntity == null) {
        break label47;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity, 5);
    }
    label47:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("OfflineVideoFileView", 2, "initVarView get entity return null, so can not download video thumb");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyu
 * JD-Core Version:    0.7.0.1
 */