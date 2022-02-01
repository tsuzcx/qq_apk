import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class dip
  implements Runnable
{
  public dip(BaseChatPie paramBaseChatPie, QQMessageFacade.Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXPanelContainer.getResources().getConfiguration().orientation == 2) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin)) || ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin != null) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_Boolean)) {
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView == null)
    {
      BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, new View(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
      BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setId(2131296330);
      BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427889));
      new RelativeLayout.LayoutParams(-1, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setId(2131296329);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131492870));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427593));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131428004));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setPadding((int)(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Float * 10.0F), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.getPaddingTop(), (int)(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Float * 10.0F), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.getPaddingBottom());
      localObject = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131493126));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.addView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
    label453:
    label506:
    StringBuilder localStringBuilder;
    if ((ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype != -2016) {
        break label699;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg.split("\\|");
      if ((localObject == null) || (localObject.length <= 0)) {
        break label692;
      }
      localObject = localObject[0].trim();
      localStringBuilder = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName == null) {
        break label757;
      }
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname"));
      localStringBuilder.append("-");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName);
      label561:
      localStringBuilder.append(":");
      if (!(localObject instanceof QQText)) {
        break label999;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setText(((QQText)localObject).a(localStringBuilder.toString(), true, new int[] { 1, 16 }));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.requestLayout();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_AndroidContentIntent);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.getHandler();
        if (localObject == null) {
          break;
        }
        ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_JavaLangRunnable);
        ((Handler)localObject).postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_JavaLangRunnable, 10000L);
        return;
        BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setVisibility(8);
        break label453;
        label692:
        localObject = "";
        break label506;
        label699:
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == -2011)
        {
          localObject = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgData);
          if (localObject != null)
          {
            localObject = ((AbsStructMsg)localObject).mMsgBrief;
            break label506;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg;
          break label506;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.getMessageText();
        break label506;
        label757:
        String str3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
        if ((str3 == null) || (str3.length() == 0))
        {
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          break label561;
        }
        String str1;
        if (7000 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop)
        {
          String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("subAccountLatestNick");
          if (str2 != null)
          {
            str1 = str2;
            if (str2.length() != 0) {}
          }
          else
          {
            str1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin;
          }
          localStringBuilder.append(str3);
          localStringBuilder.append("-");
          localStringBuilder.append(str1);
          break label561;
        }
        if (1010 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop)
        {
          str1 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin, true);
          localStringBuilder.append(str3);
          localStringBuilder.append("-");
          localStringBuilder.append(str1);
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype != -1024) {
            break label561;
          }
          localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131369787), new Object[] { str1 });
          break label561;
        }
        localStringBuilder.append(str3);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ChatActivity", 2, localException.toString());
        continue;
      }
      label999:
      localStringBuilder.append(localException);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dip
 * JD-Core Version:    0.7.0.1
 */