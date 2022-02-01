import android.content.Intent;
import android.os.Process;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class gtl
  implements Runnable
{
  public gtl(SendPhotoActivity paramSendPhotoActivity)
  {
    paramSendPhotoActivity.a(2131368524);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "SendPhoto, current pid=" + Process.myPid());
    }
    Intent localIntent = this.a.getIntent();
    if (localIntent.hasExtra("presend_handler")) {
      if (QLog.isColorLevel()) {
        QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "presendPic ,sendPhotoTask return directly!");
      }
    }
    for (;;)
    {
      return;
      SendPhotoActivity.a(this.a, System.currentTimeMillis());
      SendPhotoActivity.a(this.a, new ArrayList());
      Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if ((localObject == null) || ("".equals(localObject)))
        {
          Logger.b(this, "handlePhoto", "path invalid,path:" + (String)localObject);
          SendPhotoActivity.a(this.a).decrementAndGet();
        }
        else
        {
          localIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", (String)localObject);
          PicReq localPicReq = PicBusiManager.a(2, SendPhotoActivity.b(this.a));
          PicUploadInfo localPicUploadInfo = PicBusiManager.a(SendPhotoActivity.b(this.a), localIntent);
          if (!localPicReq.a(localPicUploadInfo))
          {
            Logger.b(this, "handlePhoto", "failed to bind the UpInfo to the sendReq");
            SendPhotoActivity.a(this.a).decrementAndGet();
          }
          else
          {
            SendPhotoActivity.a(this.a).add(localPicReq);
            if (SendPhotoActivity.a(this.a))
            {
              localObject = PicBusiManager.a(1, SendPhotoActivity.b(this.a));
              ((PicReq)localObject).a(localPicReq.jdField_a_of_type_JavaLangString);
              if (((PicReq)localObject).a(PicBusiManager.a(SendPhotoActivity.b(this.a), localIntent)))
              {
                ((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack = new gtj(this.a, localPicUploadInfo, localPicReq);
                PicBusiManager.a((PicReq)localObject, this.a.app);
              }
              else
              {
                SendPhotoActivity.a(this.a, localPicReq);
              }
            }
            else
            {
              localPicUploadInfo.g = ((String)localObject);
              this.a.b.add(localObject);
              SendPhotoActivity.a(this.a, localPicReq);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gtl
 * JD-Core Version:    0.7.0.1
 */