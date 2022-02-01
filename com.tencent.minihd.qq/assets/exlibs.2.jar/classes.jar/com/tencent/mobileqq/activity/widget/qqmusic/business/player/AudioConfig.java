package com.tencent.mobileqq.activity.widget.qqmusic.business.player;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.Session;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;

public class AudioConfig
{
  private static final String a = "AudioConfig";
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        Object localObject = SessionManager.a().a();
        if ((paramString.indexOf("http://") == -1) && (localObject != null))
        {
          localObject = ((Session)localObject).a() + "/" + paramString;
          return localObject;
        }
      }
      catch (Exception localException)
      {
        MLog.d("AudioConfig", localException.getMessage());
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.player.AudioConfig
 * JD-Core Version:    0.7.0.1
 */