import com.tencent.mobileqq.profile.upload.task.VipBaseUploadTask;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;

public class jni
  implements IUploadTaskCallback
{
  public jni(VipBaseUploadTask paramVipBaseUploadTask) {}
  
  public void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    this.a.n = 1002;
    this.a.i = paramInt;
    this.a.h = paramString;
    this.a.a(1002, new Object[0]);
  }
  
  public void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2) {}
  
  public void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (this.a.n != paramInt)
    {
      this.a.n = paramInt;
      this.a.a(this.a.n, new Object[0]);
    }
  }
  
  public void onUploadSucceed(AbstractUploadTask paramAbstractUploadTask, Object paramObject)
  {
    this.a.n = 1001;
    this.a.a = paramObject;
    this.a.a(1001, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jni
 * JD-Core Version:    0.7.0.1
 */