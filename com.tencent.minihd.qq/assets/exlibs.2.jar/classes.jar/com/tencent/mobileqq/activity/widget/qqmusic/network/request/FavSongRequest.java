package com.tencent.mobileqq.activity.widget.qqmusic.network.request;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicCGIConfig;
import com.tencent.mobileqq.activity.widget.qqmusic.data.BaseInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.FavSongXmlBody;
import com.tencent.mobileqq.music.SongInfo;

public class FavSongRequest
  extends BaseCgiRequest
{
  private SongInfo a;
  private long b;
  private boolean c;
  
  public FavSongRequest(SongInfo paramSongInfo, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    this.jdField_b_of_type_Long = paramLong;
    this.c = paramBoolean;
  }
  
  protected BaseInfo a(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  protected void a()
  {
    this.jdField_b_of_type_JavaLangString = QQMusicCGIConfig.h();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    String str = FavSongXmlBody.a(BaseApplicationImpl.a(), null, this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo, this.jdField_b_of_type_Long, this.c);
    if (str != null) {
      a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.FavSongRequest
 * JD-Core Version:    0.7.0.1
 */