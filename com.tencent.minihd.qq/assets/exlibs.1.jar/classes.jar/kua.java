import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.QLog;

public final class kua
  extends MessageObserver
{
  public kua(QQAppInterface paramQQAppInterface, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    int i = 1;
    if (paramStatictisInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramStatictisInfo.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramStatictisInfo.b);
      localStringBuilder.append("retryCount: " + paramStatictisInfo.c);
      localStringBuilder.append("detailErrorReason: " + paramStatictisInfo.d);
      localStringBuilder.append("timeoutReason: " + paramStatictisInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      if (paramBoolean)
      {
        paramStatictisInfo = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(74);
        if (paramStatictisInfo != null) {
          if (this.jdField_a_of_type_Int != 1) {
            break label287;
          }
        }
      }
    }
    for (;;)
    {
      paramStatictisInfo.a(false, -1, -1, i, this.jdField_a_of_type_JavaLangString);
      return;
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
      break;
      label287:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kua
 * JD-Core Version:    0.7.0.1
 */