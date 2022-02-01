import android.database.Cursor;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.ChatHistoryForC2C.ChatHistoryAdapter;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class dob
  implements Handler.Callback
{
  public dob(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    switch (paramMessage.what)
    {
    case 4: 
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 26: 
    case 27: 
    default: 
    case 12: 
    case 13: 
    case 21: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 7: 
    case 8: 
    case 11: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 24: 
    case 25: 
    case 22: 
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              ChatHistoryForC2C.a(this.a);
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText((String)paramMessage.obj);
              this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
              VipUtils.a(this.a.app, "vip", "0X8004F9B", "0X8004F9B", 0, 0, new String[] { ChatHistoryForC2C.b(this.a) });
            } while (!QLog.isColorLevel());
            QLog.i("ChatHistoryForC2C", 2, "T : 0X8004F9B , userIdentity" + ChatHistoryForC2C.b(this.a));
            return true;
            this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
            ChatHistoryForC2C.a(this.a, null);
            return true;
            ChatHistoryForC2C.b(this.a);
            return true;
            ChatHistoryForC2C.a(this.a, 0);
            ((MessageRoamManager)this.a.app.getManager(86)).g();
            return true;
            ChatHistoryForC2C.a(this.a);
            if (paramMessage.arg1 == -1) {
              this.a.i();
            }
            while (ChatHistoryForC2C.b(this.a) < 1)
            {
              ((MessageRoamManager)this.a.app.getManager(86)).g();
              return true;
              this.a.a(2130838254, this.a.getString(2131366495));
            }
            ChatHistoryForC2C.c(this.a);
            return true;
            ChatHistoryForC2C.a(this.a, 0);
            ((MessageRoamManager)this.a.app.getManager(86)).g();
            return true;
            ChatHistoryForC2C.a(this.a);
            this.a.a();
            return true;
            this.a.r();
            this.a.a(2130838242, this.a.getString(2131367016));
            this.a.setResult(-1);
            this.a.finish();
            return true;
            this.a.r();
            ((MessageRoamManager)this.a.app.getManager(86)).q();
            this.a.setResult(-1);
            this.a.finish();
            return true;
          } while (paramMessage.obj == null);
          localObject1 = this.a;
          localObject2 = this.a.app.a();
          if (((Boolean)paramMessage.obj).booleanValue() == true) {}
          for (i = 2131366382;; i = 2131366383)
          {
            ((ChatHistoryForC2C)localObject1).b(((BaseApplication)localObject2).getString(i));
            return true;
          }
          if (paramMessage.arg1 == -1) {
            this.a.i();
          }
          for (;;)
          {
            ChatHistoryForC2C.c(this.a);
            return true;
            this.a.a(2130838254, this.a.getString(2131366495));
          }
          ChatHistoryForC2C.c(this.a);
          return true;
          ((MessageRoamManager)this.a.app.getManager(86)).i();
          return true;
          paramMessage = (MessageRoamManager)this.a.app.getManager(86);
          if (((paramMessage.c()) && (paramMessage.a() == 2)) || ((paramMessage.b()) && (paramMessage.a() == 1)))
          {
            ChatHistoryForC2C.a(this.a);
            this.a.a(2130838254, this.a.getString(2131366497));
            return true;
          }
        } while (paramMessage.a() == 3);
        paramMessage.m();
        return true;
        Object localObject1 = (MessageRoamManager)this.a.app.getManager(86);
        Object localObject2 = (Cursor)paramMessage.obj;
        if (((Cursor)localObject2).getCount() == 0)
        {
          if (((!((MessageRoamManager)localObject1).c()) || (((MessageRoamManager)localObject1).a() != 2)) && ((!((MessageRoamManager)localObject1).b()) || (((MessageRoamManager)localObject1).a() != 1))) {
            break label967;
          }
          this.a.a(2130838254, this.a.getString(2131366497));
        }
        while (((MessageRoamManager)localObject1).a() == 3)
        {
          ((MessageRoamManager)localObject1).n();
          ChatHistoryForC2C.a(this.a);
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter != null)
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.getCursor() != null) {
              this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.getCursor().deactivate();
            }
            this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.changeCursor((Cursor)localObject2);
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter == null) {
            break;
          }
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter;
          if (paramMessage.arg1 != -1) {
            i = paramMessage.arg1;
          }
          ((ChatHistoryForC2C.ChatHistoryAdapter)localObject1).a = i;
          ChatHistoryForC2C.a(this.a).setSelection(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.a);
          return true;
        }
        ((MessageRoamManager)localObject1).m();
        return true;
        ChatHistoryForC2C.a(this.a, false);
        return true;
        ((MessageRoamManager)this.a.app.getManager(86)).j();
        return true;
        paramMessage = (MessageRoamManager)this.a.app.getManager(86);
        if (paramMessage.a())
        {
          paramMessage.j();
          paramMessage.b();
          return true;
        }
        paramMessage.i();
        return true;
        paramMessage = this.a.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        if (ChatHistoryForC2C.a(this.a, paramMessage)) {
          this.a.a(2130838254, this.a.getString(2131366497));
        }
        ChatHistoryForC2C.a(this.a);
        return true;
        this.a.j();
        paramMessage = (MessageRoamManager)this.a.app.getManager(86);
      } while (paramMessage.e() != true);
      paramMessage.j();
      return true;
    case 23: 
      this.a.i();
      return true;
    case 28: 
      label967:
      this.a.d();
      return true;
    }
    this.a.setResult(-1);
    this.a.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dob
 * JD-Core Version:    0.7.0.1
 */