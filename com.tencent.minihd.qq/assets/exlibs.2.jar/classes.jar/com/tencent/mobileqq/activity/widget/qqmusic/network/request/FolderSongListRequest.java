package com.tencent.mobileqq.activity.widget.qqmusic.network.request;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicCGIConfig;
import com.tencent.mobileqq.activity.widget.qqmusic.data.BaseInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderSongListInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.FolderSongListXmlBody;
import org.json.JSONObject;

public class FolderSongListRequest
  extends BaseCgiRequest
{
  private FolderInfo a;
  
  public FolderSongListRequest(FolderInfo paramFolderInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo = paramFolderInfo;
  }
  
  protected BaseInfo a(byte[] paramArrayOfByte)
  {
    FolderSongListInfo localFolderSongListInfo = new FolderSongListInfo();
    localFolderSongListInfo.a(new JSONObject(new String(paramArrayOfByte)));
    return localFolderSongListInfo;
  }
  
  protected void a()
  {
    this.b = QQMusicCGIConfig.f();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    String str = FolderSongListXmlBody.a(BaseApplicationImpl.a(), null, this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo);
    if (str != null) {
      a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.FolderSongListRequest
 * JD-Core Version:    0.7.0.1
 */