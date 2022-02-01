package com.tencent.mobileqq.activity.widget.qqmusic.network.request;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicCGIConfig;
import com.tencent.mobileqq.activity.widget.qqmusic.data.BaseInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.data.Session;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.SessionXmlBody;

public class SessionRequest
  extends BaseCgiRequest
{
  protected BaseInfo a(byte[] paramArrayOfByte)
  {
    return Session.a(new String(paramArrayOfByte));
  }
  
  protected void a()
  {
    this.b = QQMusicCGIConfig.a();
    this.a = true;
  }
  
  public void b()
  {
    String str = SessionXmlBody.a(BaseApplicationImpl.a(), null);
    if (str != null) {
      a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.SessionRequest
 * JD-Core Version:    0.7.0.1
 */