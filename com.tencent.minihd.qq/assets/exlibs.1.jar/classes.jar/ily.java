import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class ily
  implements FMDialogUtil.FMDialogInterface
{
  ily(ilv paramilv, WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo);
    QfileBaseCloudFileTabView.k(this.jdField_a_of_type_Ilv.a).a().b(localFileManagerEntity);
    QfileBaseCloudFileTabView.l(this.jdField_a_of_type_Ilv.a).a().a(localFileManagerEntity);
    this.jdField_a_of_type_Ilv.a.a(localFileManagerEntity);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ily
 * JD-Core Version:    0.7.0.1
 */