import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopPhotoFileView;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class jab
  extends BizTroopObserver
{
  jab(jaa paramjaa) {}
  
  protected void a(Object paramObject)
  {
    paramObject = (TroopFileStatusInfo)paramObject;
    if (QLog.isDevelopLevel()) {
      QLog.d(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewTroopPhotoFileView.a, 4, String.format("update file info: status:%d fileName:%s errorCode:%d", new Object[] { Integer.valueOf(paramObject.b), paramObject.e, Integer.valueOf(paramObject.jdField_c_of_type_Int) }));
    }
    if ((paramObject.jdField_c_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewTroopPhotoFileView.a(paramObject.d, paramObject.jdField_c_of_type_JavaLangString);
    }
    if ((paramObject.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewTroopPhotoFileView.b != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewTroopPhotoFileView.b.equals(paramObject.a.toString()))) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jab
 * JD-Core Version:    0.7.0.1
 */