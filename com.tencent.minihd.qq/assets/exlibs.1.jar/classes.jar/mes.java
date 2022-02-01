import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public final class mes
  implements IWyFileSystem.IWyCallback
{
  public void a(Boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Weiyun.AlbumBackup", 2, "succeed to report album status, redPoint = " + paramBoolean);
    }
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Weiyun.AlbumBackup", 2, "fail to report album status, errorCode = " + paramWyErrorStatus.errorCode + ", errorMsg = " + paramWyErrorStatus.errorMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mes
 * JD-Core Version:    0.7.0.1
 */