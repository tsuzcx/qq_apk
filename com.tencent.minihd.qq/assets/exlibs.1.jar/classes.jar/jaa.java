import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopPhotoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import java.util.UUID;

public class jaa
  implements PhotoFileViewBase.IControllProxyInterface
{
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public IFileViewerAdapter a;
  
  public jaa(TroopPhotoFileView paramTroopPhotoFileView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private BizTroopObserver a()
  {
    return new jab(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
  
  public void a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    FileManagerEntity localFileManagerEntity;
    Object localObject;
    if ((!TextUtils.isEmpty(paramIFileViewerAdapter.a())) && (FileManagerUtil.a(paramIFileViewerAdapter.a()) == 0) && (TextUtils.isEmpty(paramIFileViewerAdapter.b())))
    {
      localFileManagerEntity = paramIFileViewerAdapter.a();
      localObject = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localFileManagerEntity.strTroopFileID, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
      if (((TroopFileStatusInfo)localObject).c != null) {
        break label147;
      }
      localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin);
      if (localFileManagerEntity.strTroopFileID != null) {
        break label129;
      }
      ((TroopFileTransferManager)localObject).a(localFileManagerEntity.strTroopFilePath, paramIFileViewerAdapter.a(), localFileManagerEntity.busId, 640);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = paramIFileViewerAdapter;
      return;
      label129:
      ((TroopFileTransferManager)localObject).a(UUID.fromString(localFileManagerEntity.strTroopFileID), 640);
    }
    label147:
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewTroopPhotoFileView.a(((TroopFileStatusInfo)localObject).d, ((TroopFileStatusInfo)localObject).c);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jaa
 * JD-Core Version:    0.7.0.1
 */