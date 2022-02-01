import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.UiCallBack;

public abstract interface jlu
{
  public abstract MessageRecord a(PicFowardInfo paramPicFowardInfo);
  
  public abstract MessageRecord a(PicUploadInfo paramPicUploadInfo);
  
  public abstract void a(CompressInfo paramCompressInfo);
  
  public abstract void a(PicReq paramPicReq);
  
  public abstract void a(PicUploadInfo paramPicUploadInfo);
  
  public abstract void a(UiCallBack paramUiCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jlu
 * JD-Core Version:    0.7.0.1
 */