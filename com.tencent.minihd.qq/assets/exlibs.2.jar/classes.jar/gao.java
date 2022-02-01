import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class gao
  implements DownCallBack
{
  WeakReference a;
  
  public gao(MultiForwardChatPie paramMultiForwardChatPie)
  {
    this.a = new WeakReference(paramMultiForwardChatPie);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if (this.a == null) {}
    MultiForwardChatPie localMultiForwardChatPie;
    do
    {
      do
      {
        do
        {
          return;
          localMultiForwardChatPie = (MultiForwardChatPie)this.a.get();
          if ((paramDownResult.jdField_a_of_type_Int != 0) || (paramDownResult.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localMultiForwardChatPie == null);
        localObject = new HashMap();
        MessageRecord localMessageRecord = localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMultiForwardChatPie.f);
        paramDownResult = localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramDownResult.jdField_a_of_type_ArrayOfByte, (HashMap)localObject, localMessageRecord);
      } while ((paramDownResult == null) || (paramDownResult.size() <= 0));
      MultiMsgManager.a().a((HashMap)localObject, localMultiForwardChatPie.f, localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      Object localObject = new ArrayList();
      paramDownResult = paramDownResult.iterator();
      while (paramDownResult.hasNext()) {
        ((List)localObject).add((ChatMessage)paramDownResult.next());
      }
      localMultiForwardChatPie.b = ((List)localObject);
      paramDownResult = ChatActivityUtils.a(localMultiForwardChatPie.b, localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramDownResult = ChatActivityUtils.a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramDownResult);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - MultiForwardChatPie.a(localMultiForwardChatPie)));
      }
      MultiMsgManager.a().a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMultiForwardChatPie.b, true);
      localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new gap(this, localMultiForwardChatPie, paramDownResult));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localMultiForwardChatPie == null);
    MultiMsgManager.a().a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, false);
    localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new gaq(this, localMultiForwardChatPie));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gao
 * JD-Core Version:    0.7.0.1
 */