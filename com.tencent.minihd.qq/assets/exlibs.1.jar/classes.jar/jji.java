import android.os.Message;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class jji
  extends TransProcessorHandler
{
  public jji(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
    case 1003: 
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload success. photo_id = " + NearbyPeoplePhotoUploadProcessor.aP);
        }
      } while (NearbyProfileEditPanel.a(this.a) == null);
      NearbyProfileEditPanel.a(this.a).a = NearbyPeoplePhotoUploadProcessor.aP;
      NearbyProfileEditPanel.b(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload fail.");
    }
    NearbyProfileEditPanel.a(this.a).a();
    QQToast.a(NearbyProfileEditPanel.a(this.a), "上传失败", 0).b(NearbyProfileEditPanel.a(this.a).getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jji
 * JD-Core Version:    0.7.0.1
 */