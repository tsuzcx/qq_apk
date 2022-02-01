package com.tencent.mobileqq.activity.widget.qqmusic.network.request;

import com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicCGIConfig;
import com.tencent.mobileqq.activity.widget.qqmusic.data.BaseInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.data.RadioSongListInfo;
import org.json.JSONObject;

public class RadioListRequest
  extends BaseCgiRequest
{
  protected BaseInfo a(byte[] paramArrayOfByte)
  {
    RadioSongListInfo localRadioSongListInfo = new RadioSongListInfo();
    localRadioSongListInfo.a(new JSONObject(new String(paramArrayOfByte)));
    return localRadioSongListInfo;
  }
  
  protected void a()
  {
    this.b = QQMusicCGIConfig.c();
    this.a = true;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.RadioListRequest
 * JD-Core Version:    0.7.0.1
 */