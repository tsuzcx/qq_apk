import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import java.util.ArrayList;
import java.util.List;

class ipl
  implements FMDialogUtil.FMDialogInterface
{
  ipl(ipk paramipk, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    this.jdField_a_of_type_Ipk.a.a.a().ad();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 0) {
      QfileBaseRecentFileTabView.n(this.jdField_a_of_type_Ipk.a).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    }
    DataLineHandler localDataLineHandler;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 6) {
        break;
      }
      localDataLineHandler = (DataLineHandler)QfileBaseRecentFileTabView.o(this.jdField_a_of_type_Ipk.a).a(8);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq));
    } while (localDataLineHandler.a(localArrayList));
    FMToastUtil.a(2131362552);
    return;
    QfileBaseRecentFileTabView.p(this.jdField_a_of_type_Ipk.a).a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ipl
 * JD-Core Version:    0.7.0.1
 */