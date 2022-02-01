package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ChatBackgroundAuthHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class ChatBackgroundAuth
  extends AsyncStep
{
  protected int a()
  {
    SharedPreferences localSharedPreferences = this.a.a.a().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("lastChabgAuthTime", 0L);
    if (System.currentTimeMillis() - l > 86400000L)
    {
      List localList = ((ChatBackgroundManager)this.a.a.getManager(61)).a();
      if ((localList != null) && (localList.size() > 0)) {
        ((ChatBackgroundAuthHandler)this.a.a.a(56)).a(localList);
      }
      localSharedPreferences.edit().putLong("lastChabgAuthTime", System.currentTimeMillis()).commit();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth
 * JD-Core Version:    0.7.0.1
 */