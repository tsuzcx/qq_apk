package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemActivateFriendsData
  extends RecentUserBaseData
{
  private static final String i = "ActivateFriends.Recent";
  
  public RecentItemActivateFriendsData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label171:
    for (;;)
    {
      return;
      QQMessageFacade.Message localMessage = null;
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
      if (localQQMessageFacade != null) {
        localMessage = localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      }
      if (localMessage != null)
      {
        this.jdField_a_of_type_Long = localMessage.time;
        paramQQAppInterface = paramQQAppInterface.a();
        if (paramQQAppInterface != null)
        {
          this.B = paramQQAppInterface.a(localMessage.frienduin, localMessage.istroop);
          this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
        }
      }
      for (this.jdField_b_of_type_JavaLangCharSequence = localMessage.getMessageText();; this.jdField_b_of_type_JavaLangCharSequence = "")
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label171;
        }
        this.jdField_a_of_type_JavaLangString = paramContext.getString(2131369423);
        return;
        this.B = 0;
        break;
        this.B = 0;
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.e("ActivateFriends.Recent", 2, "RecentActivateFriends update, last msg is null");
        }
        this.jdField_b_of_type_JavaLangString = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemActivateFriendsData
 * JD-Core Version:    0.7.0.1
 */