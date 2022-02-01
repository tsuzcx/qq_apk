package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import java.util.ArrayList;
import java.util.Iterator;

public class GetSelfInfo
  extends AsyncStep
{
  protected int a()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.a.a(1);
    if (this.a.a.e)
    {
      localObject = (SubAccountManager)this.a.a.getManager(59);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((SubAccountManager)localObject).a();; localObject = null)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.a.a.e = false;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localFriendListHandler.b((String)((Iterator)localObject).next());
        }
      }
      localObject = (CardHandler)this.a.a.a(2);
      if (localObject != null) {
        ((CardHandler)localObject).d();
      }
      ((ConfigHandler)this.a.a.a(4)).c();
      this.a.a.b(this.a.a.getAccount());
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfInfo
 * JD-Core Version:    0.7.0.1
 */