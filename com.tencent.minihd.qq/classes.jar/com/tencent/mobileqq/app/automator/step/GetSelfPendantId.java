package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetSelfPendantId
  extends AsyncStep
{
  private String a()
  {
    if ((this.a.a.getAccount() != null) && (this.a.a.isLogin())) {
      return this.a.a.getAccount();
    }
    return "0";
  }
  
  protected int a()
  {
    ((FriendListHandler)this.a.a.a(1)).a(new String[] { a() }, new int[] { 27025, 20059, 27032, 27041 });
    ((FriendsManagerImp)this.a.a.getManager(8)).a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfPendantId
 * JD-Core Version:    0.7.0.1
 */