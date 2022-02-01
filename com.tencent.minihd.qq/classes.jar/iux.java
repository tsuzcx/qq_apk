import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.WeiYunClassificationType;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.data.WyCategoryInfo;
import java.util.Iterator;
import java.util.List;

public class iux
  implements IWyFileSystem.IWyCallback
{
  public iux(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunTypeList onSucceed, num[" + paramList.size() + "]");
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WyCategoryInfo localWyCategoryInfo = (WyCategoryInfo)paramList.next();
      WeiYunClassificationType localWeiYunClassificationType = new WeiYunClassificationType();
      localWeiYunClassificationType.jdField_a_of_type_JavaLangString = localWyCategoryInfo.categoryId;
      localWeiYunClassificationType.b = localWyCategoryInfo.name;
      localWeiYunClassificationType.jdField_a_of_type_Long = localWyCategoryInfo.timestamp;
      localWeiYunClassificationType.jdField_a_of_type_Int = localWyCategoryInfo.totalNum;
      this.a.jdField_a_of_type_JavaUtilList.add(localWeiYunClassificationType);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 30, this.a.jdField_a_of_type_JavaUtilList);
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunTypeList onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 30, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     iux
 * JD-Core Version:    0.7.0.1
 */