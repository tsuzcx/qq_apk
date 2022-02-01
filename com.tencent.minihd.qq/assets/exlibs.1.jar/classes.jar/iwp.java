import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile.ActionBarTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class iwp
  extends BizTroopObserver
{
  public iwp(ActionBarTroopFile paramActionBarTroopFile) {}
  
  protected void a(Object paramObject)
  {
    paramObject = (TroopFileStatusInfo)paramObject;
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin != paramObject.jdField_a_of_type_Long) {
      if (QLog.isDevelopLevel()) {
        QLog.d("troopFileActionbar", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(this.a.b))
      {
        TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
          this.a.b = localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString();
        }
      }
    } while ((paramObject.jdField_a_of_type_JavaUtilUUID == null) || (this.a.b == null) || (!this.a.b.equals(paramObject.jdField_a_of_type_JavaUtilUUID.toString())));
    this.a.a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iwp
 * JD-Core Version:    0.7.0.1
 */