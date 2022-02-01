package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GetJoinedHotChatListMessageStep
  extends AsyncStep
{
  private static final String c = "GetJoinedHotChatListMessage";
  
  protected int a()
  {
    if (HotChatManager.a(this.a.a))
    {
      Object localObject2 = ((HotChatManager)this.a.a.getManager(58)).a();
      if (QLog.isColorLevel())
      {
        Iterator localIterator = ((List)localObject2).iterator();
        HotChatInfo localHotChatInfo;
        for (localObject1 = ""; localIterator.hasNext(); localObject1 = (String)localObject1 + " " + localHotChatInfo.troopUin) {
          localHotChatInfo = (HotChatInfo)localIterator.next();
        }
        QLog.d("GetJoinedHotChatListMessage", 2, "troopUin:" + (String)localObject1);
      }
      Object localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HotChatInfo)((Iterator)localObject1).next();
        this.a.a.a().a(((HotChatInfo)localObject2).troopUin);
      }
    }
    return 7;
  }
  
  public void a() {}
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListMessageStep
 * JD-Core Version:    0.7.0.1
 */