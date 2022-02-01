package com.tencent.mobileqq.activity.widget.qqmusic.data;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.parser.SessionResponse;

public class Session
  extends BaseInfo
{
  private String a;
  private String b;
  private String c;
  private String d;
  
  public static Session a(String paramString)
  {
    Session localSession = new Session();
    if (TextUtils.isEmpty(paramString)) {
      return localSession;
    }
    SessionResponse localSessionResponse = new SessionResponse();
    localSessionResponse.a(paramString);
    localSession.b(localSessionResponse.o());
    localSession.a(localSessionResponse.n());
    localSession.d(localSessionResponse.q());
    localSession.e(localSessionResponse.g());
    return localSession;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public void c(String paramString)
  {
    MusicPreferences.a().a(paramString);
  }
  
  public String d()
  {
    String str2 = MusicPreferences.a().a();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() > 10) {}
    }
    else
    {
      str1 = MusicUtil.a(BaseApplicationImpl.a());
      MusicPreferences.a().a(str1);
    }
    return str1;
  }
  
  public void d(String paramString)
  {
    this.c = paramString;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public void e(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.data.Session
 * JD-Core Version:    0.7.0.1
 */