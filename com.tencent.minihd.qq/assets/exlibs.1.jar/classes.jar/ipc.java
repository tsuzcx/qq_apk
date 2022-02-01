import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ipc
  implements Runnable
{
  public ipc(QfileLocalFilePicTabView paramQfileLocalFilePicTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.a();
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.a.containsKey(localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.a.put(localObject, new ArrayList());
    }
    localObject = (List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.a.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.a());
    if (((List)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo) == true) {
      return;
    }
    int j = FileManagerUtil.a((List)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.b());
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ((List)localObject).add(i, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ipc
 * JD-Core Version:    0.7.0.1
 */