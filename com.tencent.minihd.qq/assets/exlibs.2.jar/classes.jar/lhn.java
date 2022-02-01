import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class lhn
  implements Runnable
{
  public lhn(MyAppApi.QQDownloadListener paramQQDownloadListener, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    int i;
    DownloadManager localDownloadManager;
    DownloadInfo localDownloadInfo;
    if (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
    {
      LogUtility.a("State_Log", "OpenSDK OnDownloadTaskStateChanged state=" + this.jdField_a_of_type_Int + " errorCode=" + this.b + " param SNGAppId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
      i = DownloadManager.a(this.jdField_a_of_type_Int);
      LogUtility.c("State_Log", "OnDownloadTaskStateChanged--localState = " + i + "state = " + this.jdField_a_of_type_Int + "errorCode = " + this.b);
      localDownloadManager = DownloadManager.a();
      localDownloadInfo = localDownloadManager.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
      if ((localDownloadInfo != null) || (this.jdField_a_of_type_Int == 6)) {
        break label383;
      }
      localDownloadInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$QQDownloadListener.a.a(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, null);
      localDownloadManager.e(localDownloadInfo);
      localDownloadManager.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
    }
    while (localDownloadInfo != null)
    {
      LogUtility.c("State_Log", "OnDownloadTaskStateChanged notifyListener localState=" + i + " dlInfo=" + localDownloadInfo.toString());
      localDownloadManager.a(i, localDownloadInfo, this.b, this.jdField_a_of_type_JavaLangString);
      return;
      LogUtility.a("State_Log", "OpenSDK OnDownloadTaskStateChanged state=" + this.jdField_a_of_type_Int + " errorCode=" + this.b + " param== null");
      return;
      label383:
      if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$QQDownloadListener.a.a != null) && ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$QQDownloadListener.a.e())) {
        try
        {
          TMAssistantCallYYBTaskInfo localTMAssistantCallYYBTaskInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$QQDownloadListener.a.a.getDownloadTaskState(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct);
          if (localTMAssistantCallYYBTaskInfo != null)
          {
            long l1 = localTMAssistantCallYYBTaskInfo.mReceiveDataLen;
            long l2 = localTMAssistantCallYYBTaskInfo.mTotalDataLen;
            int j = (int)((float)l1 * 100.0F / (float)l2);
            localDownloadInfo.k = j;
            LogUtility.a("MyAppApi", "OnDownloadTaskStateChanged info progress = " + j);
          }
        }
        catch (Exception localException)
        {
          LogUtility.c("MyAppApi", "getDownloadTaskState>>>", localException);
        }
      }
    }
    LogUtility.c("MyAppApi", "OnDownloadTaskStateChanged notifyListener error dlInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lhn
 * JD-Core Version:    0.7.0.1
 */