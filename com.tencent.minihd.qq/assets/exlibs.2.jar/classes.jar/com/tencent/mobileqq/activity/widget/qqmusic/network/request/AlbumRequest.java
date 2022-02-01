package com.tencent.mobileqq.activity.widget.qqmusic.network.request;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicCGIConfig;
import com.tencent.mobileqq.activity.widget.qqmusic.data.AlbumInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.data.BaseInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.AlbumXmlBody;
import com.tencent.mobileqq.music.SongInfo;

public class AlbumRequest
  extends BaseCgiRequest
{
  private SongInfo a;
  
  public AlbumRequest(SongInfo paramSongInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
  }
  
  protected BaseInfo a(byte[] paramArrayOfByte)
  {
    AlbumInfo localAlbumInfo = new AlbumInfo();
    localAlbumInfo.a(new String(paramArrayOfByte));
    return localAlbumInfo;
  }
  
  protected void a()
  {
    this.b = QQMusicCGIConfig.g();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    String str = AlbumXmlBody.a(BaseApplicationImpl.a(), null, this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
    if (str != null) {
      a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.AlbumRequest
 * JD-Core Version:    0.7.0.1
 */