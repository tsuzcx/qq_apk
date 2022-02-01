import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger.GetSubAccountUnreadResponse;
import com.tencent.mobileqq.servlet.QzoneSubAccountUnreadServlet.GetSubAccountUnreadListener;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class htl
  implements QzoneSubAccountUnreadServlet.GetSubAccountUnreadListener
{
  public htl(SubAccountMessageProcessor paramSubAccountMessageProcessor) {}
  
  public void a(QZoneFeedCountPackeger.GetSubAccountUnreadResponse paramGetSubAccountUnreadResponse)
  {
    if (paramGetSubAccountUnreadResponse == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SUB_ACCOUNT", 2, "getSubAccountQZoneMsg():faile");
      }
      return;
    }
    SubAccountManager localSubAccountManager = (SubAccountManager)this.a.a.getManager(59);
    String str = Long.toString(paramGetSubAccountUnreadResponse.c);
    Object localObject = null;
    if (localSubAccountManager != null) {
      localObject = localSubAccountManager.a(str);
    }
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    localSubAccountBackProtocData.jdField_c_of_type_JavaLangString = str;
    if (paramGetSubAccountUnreadResponse.jdField_a_of_type_Long == 0L) {
      if ((localObject == null) || (((List)localObject).size() <= 0) || (localSubAccountManager == null)) {
        break label626;
      }
    }
    label626:
    for (int i = localSubAccountManager.a(str, "2005060620050606");; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getSubAccountQZoneMsg():no new message");
      }
      if (i == 0) {
        break;
      }
      this.a.a.a().b(str, 7000, i);
      this.a.a.a().a(new String[] { AppConstants.W, str });
      localSubAccountBackProtocData.jdField_c_of_type_Boolean = true;
      localSubAccountBackProtocData.p = 0;
      this.a.a.a().a(8003, true, localSubAccountBackProtocData);
      return;
      SubAccountMessage localSubAccountMessage = new SubAccountMessage();
      localSubAccountMessage.isread = false;
      localSubAccountMessage.msg = paramGetSubAccountUnreadResponse.jdField_a_of_type_JavaLangString;
      localSubAccountMessage.unreadNum = ((int)paramGetSubAccountUnreadResponse.jdField_a_of_type_Long);
      localSubAccountMessage.msgtype = -1000;
      localSubAccountMessage.selfuin = this.a.a.getAccount();
      localSubAccountMessage.sendername = "空间动态";
      localSubAccountMessage.senderuin = "2005060620050606";
      localSubAccountMessage.frienduin = "2005060620050606";
      localSubAccountMessage.subUin = str;
      localSubAccountMessage.time = paramGetSubAccountUnreadResponse.b;
      localSubAccountMessage.needNotify = false;
      long l = 0L;
      if (localSubAccountManager != null) {
        l = localSubAccountManager.b(str);
      }
      if (localSubAccountMessage.time < l)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("SUB_ACCOUNT", 2, "getSubAccountQZoneMsg():this message has been cleaned");
        return;
      }
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        do
        {
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramGetSubAccountUnreadResponse = (SubAccountMessage)((Iterator)localObject).next();
          } while (paramGetSubAccountUnreadResponse == null);
          str = paramGetSubAccountUnreadResponse.senderuin;
        } while ((str == null) || (!str.equalsIgnoreCase("2005060620050606")));
      }
      for (;;)
      {
        if ((paramGetSubAccountUnreadResponse != null) && (paramGetSubAccountUnreadResponse.time == localSubAccountMessage.time))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SUB_ACCOUNT", 2, "getSubAccountQZoneMsg():this message has already get");
          return;
        }
        if (localSubAccountManager != null) {
          localSubAccountManager.a(localSubAccountMessage);
        }
        int j = this.a.a.a().a(localSubAccountMessage.subUin, 7000);
        if (localSubAccountManager != null) {}
        for (i = localSubAccountManager.d(localSubAccountMessage.subUin);; i = 0)
        {
          i -= j;
          if (i != 0)
          {
            this.a.a.a().b(localSubAccountMessage.subUin, 7000, i);
            this.a.a.a().a(new String[] { AppConstants.W, localSubAccountMessage.subUin });
            localSubAccountBackProtocData.jdField_c_of_type_Boolean = true;
            localSubAccountBackProtocData.p = 0;
            this.a.a.a().a(8003, true, localSubAccountBackProtocData);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SUB_ACCOUNT", 2, "getSubAccountQZoneMsg():success");
          return;
        }
        paramGetSubAccountUnreadResponse = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     htl
 * JD-Core Version:    0.7.0.1
 */