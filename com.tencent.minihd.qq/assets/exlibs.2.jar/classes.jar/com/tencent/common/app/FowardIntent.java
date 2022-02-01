package com.tencent.common.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QzoneWrapperActivity;
import com.tencent.mobileqq.activity.SettingMe;
import com.tencent.mobileqq.activity.SplashActivity;

public class FowardIntent
  extends Intent
{
  public FowardIntent(Context paramContext, Class paramClass1, Class paramClass2)
  {
    super(paramContext, SplashActivity.class);
    if (paramClass2 == null) {
      throw new IllegalStateException("target can't be null!");
    }
    putExtra("target_activity", paramClass2);
    putExtra("tab_index", a(paramClass1));
  }
  
  private int a(Class paramClass)
  {
    int j = 1;
    int i = j;
    if (paramClass != null)
    {
      paramClass = paramClass.getName();
      if (!paramClass.equals(SettingMe.class.getName())) {
        break label29;
      }
      i = 0;
    }
    label29:
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramClass.equals(Conversation.class.getName()));
      if (paramClass.equals(Call.class.getName())) {
        return 2;
      }
      if (paramClass.equals(Contacts.class.getName())) {
        return 3;
      }
      i = j;
    } while (!paramClass.equals(QzoneWrapperActivity.class.getName()));
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.common.app.FowardIntent
 * JD-Core Version:    0.7.0.1
 */