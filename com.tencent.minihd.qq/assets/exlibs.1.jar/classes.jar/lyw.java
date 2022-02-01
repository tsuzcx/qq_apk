import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class lyw
  implements Runnable
{
  public lyw(DatalineRemoteManager paramDatalineRemoteManager, FileManagerEntity paramFileManagerEntity, ForwardFileInfo paramForwardFileInfo) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a.getApplication().getApplicationContext(), FileBrowserActivity.class);
    localIntent.addFlags(268435456);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId));
      localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
    }
    localIntent.putExtra("fileinfo", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo);
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a.getApplication().getApplicationContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lyw
 * JD-Core Version:    0.7.0.1
 */