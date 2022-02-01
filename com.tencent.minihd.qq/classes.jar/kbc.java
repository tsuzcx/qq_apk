import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

public class kbc
  implements UpCallBack
{
  public kbc(TransFileController paramTransFileController, QQAppInterface paramQQAppInterface) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    boolean bool2 = true;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append(" onSend result is null ? ");
      if (paramSendResult != null) {
        break label69;
      }
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(" result is: ");
      if (paramSendResult != null) {
        break label74;
      }
    }
    label69:
    label74:
    for (int i = -99;; i = paramSendResult.a)
    {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      if (paramSendResult != null) {
        break label82;
      }
      return;
      bool1 = false;
      break;
    }
    label82:
    if (paramSendResult.a == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramSendResult = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (paramSendResult == null) {
        break;
      }
      paramSendResult.a(bool1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      return;
    }
    ProfileCardUtil.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     kbc
 * JD-Core Version:    0.7.0.1
 */