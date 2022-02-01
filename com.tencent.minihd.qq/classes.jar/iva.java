import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.PreviewAdderss;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public class iva
  implements IWyFileSystem.IWyCallback
{
  public iva(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(IWyFileSystem.PreviewAdderss paramPreviewAdderss)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "get weiyun file PreviewAddress onSucceed");
    }
    String str2 = HexUtil.a(paramPreviewAdderss.downloadKey);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.a.a.a().a(true, 278, new Object[] { Integer.valueOf(0), "", str1, paramPreviewAdderss.cookie, paramPreviewAdderss.downloadIp, paramPreviewAdderss.downloadHost, Integer.valueOf(paramPreviewAdderss.downloadPort) });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "get weiyun file PreviewAddress onFailed,errCode[" + paramWyErrorStatus.errorCode + "],errMsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.a.a.a().a(false, 278, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, "", "", "", "", Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     iva
 * JD-Core Version:    0.7.0.1
 */