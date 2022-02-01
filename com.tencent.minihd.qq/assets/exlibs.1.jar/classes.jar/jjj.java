import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class jjj
  implements Runnable
{
  public jjj(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void run()
  {
    NearbyProfileEditPanel.a(this.a, (NearbyPeopleProfileActivity.PicInfo)NearbyProfileEditPanel.a(this.a).poll());
    if (NearbyProfileEditPanel.a(this.a) == null) {
      return;
    }
    CompressInfo localCompressInfo = new CompressInfo(NearbyProfileEditPanel.a(this.a).a, 0);
    localCompressInfo.f = 0;
    CompressOperator.a(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..uploadPhoto(), img_path = " + localCompressInfo.e);
    }
    if (!StringUtil.b(localCompressInfo.e))
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.a = true;
      localTransferRequest.h = localCompressInfo.e;
      localTransferRequest.b = 8;
      NearbyProfileEditPanel.a(this.a).app.a().a(localTransferRequest);
      return;
    }
    NearbyProfileEditPanel.a(this.a).runOnUiThread(new jjk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jjj
 * JD-Core Version:    0.7.0.1
 */