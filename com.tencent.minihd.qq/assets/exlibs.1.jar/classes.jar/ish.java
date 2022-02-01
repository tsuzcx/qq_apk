import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileUploader;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ish
  extends FileTransferObserver
{
  public ish(OfflineSendWorker paramOfflineSendWorker) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    QLog.i("OfflineFileUploader<FileAssistant>", 1, "nSessionId[" + paramLong2 + "] SendCC [" + paramBoolean + "], retCode[" + paramLong1 + "]");
    if (!paramBoolean)
    {
      QLog.i("OfflineFileUploader<FileAssistant>", 1, "Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !");
      OfflineSendWorker.a(this.a, 1005);
      OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, 5, null);
      paramInt = 90460;
      if (-100001L == paramLong1) {
        paramInt = 9043;
      }
      OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, paramInt, "sendCCFaild");
      OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, paramInt, "sendCCFaild");
      return;
    }
    if (58L == paramLong1)
    {
      QLog.i("OfflineFileUploader<FileAssistant>", 1, "Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      OfflineSendWorker.a(this.a, 1005);
      OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, 5, null);
      OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, 58, "ServerMasking");
      OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, 58, "ServerMasking");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (OfflineSendWorker.a(this.a) != null)
    {
      localObject1 = localObject2;
      if (OfflineSendWorker.a(this.a).a() > 0) {
        localObject1 = "ChanedUrlCount[" + OfflineSendWorker.a(this.a).a() + "]";
      }
    }
    if (OfflineSendWorker.a(this.a) != null)
    {
      FileManagerUtil.a(OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a).nSessionId, "actFileUp", OfflineSendWorker.a(this.a) - OfflineSendWorker.b(this.a), OfflineSendWorker.a(this.a).a(), OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).Uuid, OfflineSendWorker.a(this.a).strFileMd5, 1L, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).b(), (String)localObject1);
      FileManagerUtil.a(OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a).nSessionId, "actFileUpDetail", OfflineSendWorker.a(this.a) - OfflineSendWorker.b(this.a), OfflineSendWorker.a(this.a).a(), OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).Uuid, OfflineSendWorker.a(this.a).strFileMd5, 1L, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).b(), (String)localObject1);
      return;
    }
    FileManagerUtil.a(OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a).nSessionId, "actFileUp", OfflineSendWorker.a(this.a) - OfflineSendWorker.b(this.a), null, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).Uuid, OfflineSendWorker.a(this.a).strFileMd5, 1L, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).fileSize, 0, (String)localObject1);
    FileManagerUtil.a(OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a).nSessionId, "actFileUpDetail", OfflineSendWorker.a(this.a) - OfflineSendWorker.b(this.a), null, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).Uuid, OfflineSendWorker.a(this.a).strFileMd5, 1L, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).fileSize, 0, (String)localObject1);
  }
  
  protected void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    if (!paramBoolean)
    {
      QLog.i("OfflineFileUploader<FileAssistant>", 1, "Id[" + OfflineSendWorker.a(this.a).nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      OfflineSendWorker.a(this.a, 1005);
      OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      int i = 9045;
      if (-100001 == paramFileUploadInfo.jdField_a_of_type_Int) {
        i = 9043;
      }
      OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, i, "setSuccFaild");
      OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, i, "setSuccFaild");
      return;
    }
    QLog.i("OfflineFileUploader<FileAssistant>", 1, "Id[" + OfflineSendWorker.a(this.a).nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a));
  }
  
  protected void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo, List paramList)
  {
    if (this.a.a()) {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileUploader<FileAssistant>", 2, "Id[" + OfflineSendWorker.a(this.a).nSessionId + "]onUpdateSendOfflineFile: but this work has stop");
      }
    }
    label907:
    label1332:
    do
    {
      return;
      int i;
      if (!paramBoolean)
      {
        QLog.i("OfflineFileUploader<FileAssistant>", 1, "Id[" + OfflineSendWorker.a(this.a).nSessionId + "]wk,onUpdateSendOfflineFile-->failed");
        OfflineSendWorker.a(this.a, 1005);
        OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
        i = 9045;
        if (-100001 == paramFileUploadInfo.jdField_a_of_type_Int) {
          i = 9043;
        }
        paramStatictisInfo = "server retError";
        if (paramFileUploadInfo.jdField_a_of_type_JavaLangString != null) {
          paramStatictisInfo = paramFileUploadInfo.jdField_a_of_type_JavaLangString;
        }
        OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, i, paramStatictisInfo);
        OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, i, paramStatictisInfo);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileUploader<FileAssistant>", 2, "Id[" + OfflineSendWorker.a(this.a).nSessionId + "]wk,handleSendOfflineFileResp");
      }
      if ((paramFileUploadInfo.jdField_b_of_type_JavaLangString == null) || (paramFileUploadInfo.jdField_b_of_type_JavaLangString.length() == 0))
      {
        OfflineSendWorker.a(this.a, 1005);
        OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
        QLog.w("OfflineFileUploader<FileAssistant>", 1, "Id[" + String.valueOf(OfflineSendWorker.a(this.a).nSessionId) + "]ResultCodeNoServerAddr ip = 0");
        i = paramFileUploadInfo.jdField_a_of_type_Int;
        paramStatictisInfo = paramFileUploadInfo.jdField_a_of_type_JavaLangString;
        if (paramFileUploadInfo.jdField_a_of_type_Int == 0)
        {
          i = 9048;
          paramStatictisInfo = "onUpSend ip url error";
        }
        OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, i, paramStatictisInfo);
        OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, i, paramStatictisInfo);
        return;
      }
      QLog.i("OfflineFileUploader<FileAssistant>", 1, "nSessionID[" + String.valueOf(OfflineSendWorker.a(this.a).nSessionId) + "],retCode[" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int) + "]");
      if ((paramFileUploadInfo.jdField_a_of_type_JavaLangString != null) && (paramFileUploadInfo.jdField_a_of_type_JavaLangString.length() > 0))
      {
        QLog.e("OfflineFileUploader<FileAssistant>", 1, "id[" + String.valueOf(OfflineSendWorker.a(this.a).nSessionId) + "] will show taost, retCode[" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int) + "], retMsg:" + paramFileUploadInfo.jdField_a_of_type_JavaLangString);
        OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 4, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      }
      if ((paramFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (paramFileUploadInfo.jdField_a_of_type_ArrayOfByte.length > 0)) {
        OfflineSendWorker.a(this.a).Uuid = new String(paramFileUploadInfo.jdField_a_of_type_ArrayOfByte);
      }
      while ((paramFileUploadInfo.jdField_a_of_type_Boolean) && (paramFileUploadInfo.c <= 104857600L))
      {
        OfflineSendWorker.b(this.a);
        return;
        QLog.e("OfflineFileUploader<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
      }
      OfflineSendWorker.a(this.a).status = 0;
      OfflineSendWorker.a(this.a).a().c(OfflineSendWorker.a(this.a));
      OfflineSendWorker.a(this.a).status = 2;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "已收到CS包,准备开始上传任务,nSessionID[" + String.valueOf(OfflineSendWorker.a(this.a).nSessionId) + "]");
      }
      if (paramList == null)
      {
        paramStatictisInfo = new ArrayList();
        paramStatictisInfo.add(paramFileUploadInfo.jdField_b_of_type_JavaLangString + ":" + paramFileUploadInfo.jdField_a_of_type_Short);
        paramList = HexUtil.bytes2HexStr(paramFileUploadInfo.jdField_b_of_type_ArrayOfByte);
        if (1 != paramFileUploadInfo.jdField_d_of_type_Int) {
          break label1332;
        }
        paramList = "/?ver=2&ukey=" + paramList + "&filekey=" + OfflineSendWorker.a(this.a) + "&filesize=" + OfflineSendWorker.a(this.a).fileSize;
        OfflineSendWorker.a(this.a).strServerPath = ("http://" + (String)paramStatictisInfo.get(0) + paramList);
        OfflineSendWorker.a(this.a, FileUploader.a(OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerType, 0, OfflineSendWorker.a(this.a).strFilePath, paramStatictisInfo, paramList));
      }
      for (;;)
      {
        if (OfflineSendWorker.a(this.a) == null) {
          break label1539;
        }
        OfflineSendWorker.b(this.a, false);
        OfflineSendWorker.a(this.a).a(this.a);
        if (OfflineSendWorker.a(this.a).a(0L)) {
          break;
        }
        OfflineSendWorker.a(this.a, 1005);
        OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, 0, "");
        OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, 9045, "sendFile error");
        OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, 9045, "sendFile error");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("OfflineFileUploader<FileAssistant>", 2, "nSessionID[" + OfflineSendWorker.a(this.a).nSessionId + "],sendFile return false");
        return;
        paramList.add(0, paramFileUploadInfo.jdField_b_of_type_JavaLangString + ":" + paramFileUploadInfo.jdField_a_of_type_Short);
        paramStatictisInfo = paramList;
        break label907;
        if (2 == paramFileUploadInfo.jdField_d_of_type_Int)
        {
          OfflineSendWorker.a(this.a).strServerPath = ("http://" + (String)paramStatictisInfo.get(0) + "/ftn_handler");
          OfflineSendWorker.a(this.a).bombData = paramList.getBytes();
          if (paramFileUploadInfo.jdField_d_of_type_ArrayOfByte != null)
          {
            OfflineSendWorker.a(this.a).strFileSHA = FileHttpUtils.a(paramFileUploadInfo.jdField_d_of_type_ArrayOfByte);
            OfflineSendWorker.a(this.a, true);
          }
          OfflineSendWorker.a(this.a, FileUploader.a(OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerType, 0, OfflineSendWorker.a(this.a).strFilePath, paramList, OfflineSendWorker.a(this.a).strFileSHA, paramStatictisInfo, "/ftn_handler"));
        }
        else
        {
          QLog.w("OfflineFileUploader<FileAssistant>", 1, "onUpdateSendOfflineFile httpsvrApiVer[" + paramFileUploadInfo.jdField_d_of_type_Int + "] not recognized");
        }
      }
      OfflineSendWorker.a(this.a, 1005);
      OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, 9045, "upload param error");
      OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, 9045, "upload param error");
    } while (!QLog.isColorLevel());
    label1539:
    QLog.e("OfflineFileUploader<FileAssistant>", 2, "nSessionID[" + OfflineSendWorker.a(this.a).nSessionId + "],retCode[" + paramFileUploadInfo.jdField_a_of_type_Int + "]");
  }
  
  protected void b(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo, List paramList)
  {
    if (this.a.a()) {}
    while (paramFileUploadInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    if ((paramFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (paramFileUploadInfo.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      OfflineSendWorker.a(this.a).Uuid = new String(paramFileUploadInfo.jdField_a_of_type_ArrayOfByte);
      this.a.c();
      OfflineSendWorker.b(this.a);
      return;
    }
    QLog.e("OfflineFileUploader<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ish
 * JD-Core Version:    0.7.0.1
 */