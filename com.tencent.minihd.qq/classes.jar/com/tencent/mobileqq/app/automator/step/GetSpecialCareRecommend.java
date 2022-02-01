package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetSpecialCareRecommend
  extends AsyncStep
{
  protected int a()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.a.a(1);
    if (localFriendListHandler != null)
    {
      localFriendListHandler.a(0, 10, null, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("SpecialCare", 2, "start to get specialcare recommend friend...");
      }
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSpecialCareRecommend
 * JD-Core Version:    0.7.0.1
 */