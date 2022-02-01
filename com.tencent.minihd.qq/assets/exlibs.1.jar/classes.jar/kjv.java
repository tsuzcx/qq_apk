import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.OnUploadVideoListener;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.mobileqq.troop.data.TroopBarUploadTaskManager;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;

public class kjv
  implements TroopBarShortVideoUploadUtil.OnUploadVideoListener
{
  public kjv(TroopBarUploadTaskManager paramTroopBarUploadTaskManager, TroopBarUploadItemEntity paramTroopBarUploadItemEntity, QQAppInterface paramQQAppInterface) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager.a(0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mPid, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mCid);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager.b();
    TroopBarUploadTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId, 1.0F, 5);
    TroopBarUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mOpType, "video_upload", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mBid, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mFromFlag, "0", TroopBarUploadTaskManager.a());
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId + ": onUploadSuccess------");
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager.a(1, null, null);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager.b();
    float f = TroopBarUploadTaskManager.a(paramLong, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mSize);
    TroopBarUploadTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId, f, 4);
    TroopBarUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mOpType, "video_upload", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mBid, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mFromFlag, "1", TroopBarUploadTaskManager.a());
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId + ": onUploadFail------");
    }
  }
  
  public void b()
  {
    TroopBarUploadTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mProgress, 2);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId + ": onUploadStart------");
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager.b();
    TroopBarUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mOpType, "video_upload", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mBid, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mFromFlag, "2", TroopBarUploadTaskManager.a());
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId + ": onUploadStop------");
    }
  }
  
  public void c(long paramLong)
  {
    float f = TroopBarUploadTaskManager.a(paramLong, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mSize);
    TroopBarUploadTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId, f, 2);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId + ": onUploadProcess offset = " + paramLong + ", size = " + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mSize + ", progress = " + f);
    }
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId);
    float f = TroopBarUploadTaskManager.a(paramLong, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mSize);
    TroopBarUploadTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId, f, 6);
    TroopBarUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mOpType, "video_upload", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mBid, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mFromFlag, "1", TroopBarUploadTaskManager.a());
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity.mId + ": onUploadNetDisabled------");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kjv
 * JD-Core Version:    0.7.0.1
 */