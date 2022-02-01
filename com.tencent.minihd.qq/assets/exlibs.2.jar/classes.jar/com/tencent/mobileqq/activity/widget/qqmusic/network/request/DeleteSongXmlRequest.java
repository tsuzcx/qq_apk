package com.tencent.mobileqq.activity.widget.qqmusic.network.request;

import com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicCGIConfig;
import com.tencent.mobileqq.activity.widget.qqmusic.data.BaseInfo;

public class DeleteSongXmlRequest
  extends BaseCgiRequest
{
  protected BaseInfo a(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  protected void a()
  {
    this.b = QQMusicCGIConfig.i();
    this.a = true;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.DeleteSongXmlRequest
 * JD-Core Version:    0.7.0.1
 */