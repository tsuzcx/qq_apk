import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.newfriend.TroopSystemMessage;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class gjh
  extends MessageObserver
{
  public gjh(NotificationView paramNotificationView) {}
  
  protected void a(String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      paramString = NotificationView.a(this.a).getResources().getString(2131365893);
      QQToast.a(NotificationView.a(this.a), 1, paramString, 0).b(this.a.a());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l1 = GroupSystemMsgController.a().b();
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      long l2;
      try
      {
        l2 = Long.parseLong(paramString1);
        l1 = l2;
        if (paramBoolean) {
          break label169;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        paramString1 = NotificationView.a(this.a).getResources().getString(2131366997);
        if (TextUtils.isEmpty(paramString3)) {
          break label482;
        }
        QQToast.a(NotificationView.a(this.a), 1, paramString3, 0).b(this.a.a());
        SystemMsgUtils.a(GroupSystemMsgController.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4);
        paramString1 = GroupSystemMsgController.a().a(Long.valueOf(l1));
        if ((paramString1 != null) && (paramString1.msg_type.get() == 2)) {
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1012);
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      continue;
      label169:
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      paramString1 = NotificationView.a(this.a).getResources().getString(2131365784);
      if (paramInt1 == 1) {
        paramString1 = NotificationView.a(this.a).getResources().getString(2131365783);
      }
      for (;;)
      {
        QQToast.a(NotificationView.a(this.a), 2, paramString1, 0).b(this.a.a());
        l2 = GroupSystemMsgController.a().a();
        SystemMsgUtils.a(GroupSystemMsgController.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
        paramString1 = GroupSystemMsgController.a().a(Long.valueOf(l1));
        if (paramString1 != null)
        {
          paramInt2 = paramString1.msg.group_inviter_role.get();
          if (((paramInt2 == 2) || (paramInt2 == 3)) && (paramInt1 == 1))
          {
            paramString2 = "" + paramString1.msg.group_code.get();
            paramString3 = paramString1.msg.group_name.get();
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString2, paramString3);
          }
        }
        if (l2 != 0L) {}
        try
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ak, 0, l2, paramString1.toByteArray());
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1012);
          return;
          if (paramInt1 == 2) {
            paramString1 = NotificationView.a(this.a).getResources().getString(2131365782);
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i("NotificationView", 2, "onSendSystemMsgActionFin Exception!");
            }
          }
        }
      }
      label482:
      paramString3 = paramString1;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "onGetSystemMsgFin.bengin");
    }
    if (((Activity)NotificationView.a(this.a)).isFinishing()) {
      return;
    }
    if (paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i("NotificationView", 2, "onGetSystemMsgFin.success");
      }
    }
    for (;;)
    {
      try
      {
        NotificationView.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ak, 0));
        if (NotificationView.a(this.a) == null) {
          break;
        }
        NotificationView.a(this.a).a(NotificationView.a(this.a));
        NotificationView.a(this.a).a = GroupSystemMsgController.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        NotificationView.a(this.a).notifyDataSetChanged();
        if (this.a.b)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c();
          ((NewFriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a(new TroopSystemMessage(0));
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.ap, 9000, 0 - GroupSystemMsgController.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          GroupSystemMsgController.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
          NotificationView.a(this.a, false);
          this.a.k();
          NotificationView.a(this.a);
          return;
        }
        NotificationView.a(this.a, true);
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      if ((paramBoolean2) && (NotificationView.a(this.a)))
      {
        String str = NotificationView.a(this.a).getResources().getString(2131365894);
        QQToast.a(NotificationView.a(this.a), 1, str, 0).b(this.a.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gjh
 * JD-Core Version:    0.7.0.1
 */