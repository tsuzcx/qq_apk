import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.OpenTroopChatLogic;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class gct
  extends MessageObserver
{
  private OpenTroopChatLogic jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic = null;
  
  public gct(TroopChatPie paramTroopChatPie) {}
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {}
    while (paramInt1 != 1) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
    case 2: 
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131365770, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.v();
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131365769, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPie", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPie", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler != null) && ((paramSendMessageHandler instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction))) {
        MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1, paramLong2, false);
      }
    }
    if (paramInt1 == 1)
    {
      if (!((FriendManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).f(paramString1)) {
        break label433;
      }
      if (paramInt2 != 108) {
        break label349;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic = new OpenTroopChatLogic(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      paramString1 = (ChatMessage)TroopChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getItem(TroopChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getCount() - 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic.a(paramString1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic.a();
      }
    }
    label433:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(196608);
      return;
      label349:
      if (paramInt2 == 102)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.v();
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), 2131365771, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
      else if (paramString2.length() > 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString2, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        continue;
        switch (paramInt2)
        {
        default: 
          break;
        case 1: 
        case 2: 
        case 101: 
        case 102: 
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131365770, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          break;
        case 3: 
        case 103: 
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131365769, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          break;
        case 130: 
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131364054);
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          break;
        case 131: 
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131364055);
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    MultiMsgManager.a().b("send struct msg  ");
    MultiMsgManager.a().c();
    MultiMsgManager.a().a("all cost time ");
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.j = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(131072);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopChatPie", 2, "onGetSystemMsgFin.success");
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ak, 0);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() - 1 >= 0) {
          localObject1 = (MessageRecord)localList.get(localList.size() - 1);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForSystemMsg))) {
        break label100;
      }
    }
    label100:
    long l;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          localObject1 = ((MessageForSystemMsg)localObject1).getSystemMsg();
        } while ((((structmsg.StructMsg)localObject1).msg_type.get() != 2) || (((structmsg.StructMsg)localObject1).msg.get() == null));
        i = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
      } while ((i != 3) && (i != 15));
      l = ((structmsg.StructMsg)localObject1).msg.group_code.get();
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase("" + l)));
    TroopChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.F();
    }
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gct
 * JD-Core Version:    0.7.0.1
 */