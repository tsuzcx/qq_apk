package com.tencent.mobileqq.app.message;

import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;

public class DiscMessageManager
  extends BaseMessageManagerForTroopAndDisc
{
  public DiscMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (this.a.a().equals(paramString1)) {
      return this.a.a().getResources().getString(2131367561);
    }
    FriendManager localFriendManager = (FriendManager)this.a.getManager(8);
    if (localFriendManager != null) {
      return localFriendManager.c(paramString2, paramString1);
    }
    return ContactUtils.a(this.a, paramString1, 0);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    Object localObject = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    RecentUser localRecentUser = ((RecentUserProxy)localObject).a(str, paramMessageRecord.istroop);
    localObject = localRecentUser;
    if (localMap.containsKey(MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type))) {
      localObject = (RecentUser)localMap.get(MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type));
    }
    if (!MsgProxyUtils.g(paramMessageRecord.msgtype))
    {
      ((RecentUser)localObject).uin = str;
      ((RecentUser)localObject).type = i;
      if (l > ((RecentUser)localObject).lastmsgtime)
      {
        ((RecentUser)localObject).lastmsgtime = l;
        localMap.put(MsgProxyUtils.a(str, i), localObject);
      }
    }
    super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageManager
 * JD-Core Version:    0.7.0.1
 */