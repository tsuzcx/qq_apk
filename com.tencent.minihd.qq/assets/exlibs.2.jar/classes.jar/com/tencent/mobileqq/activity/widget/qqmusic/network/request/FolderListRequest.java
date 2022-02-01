package com.tencent.mobileqq.activity.widget.qqmusic.network.request;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicCGIConfig;
import com.tencent.mobileqq.activity.widget.qqmusic.data.BaseInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderListInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.FolderXmlBody;
import org.json.JSONObject;

public class FolderListRequest
  extends BaseCgiRequest
{
  int h;
  int i;
  int j;
  
  public FolderListRequest(int paramInt1, int paramInt2, int paramInt3)
  {
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
  }
  
  protected BaseInfo a(byte[] paramArrayOfByte)
  {
    FolderListInfo localFolderListInfo = new FolderListInfo();
    localFolderListInfo.a(new JSONObject(new String(paramArrayOfByte)));
    return localFolderListInfo;
  }
  
  protected void a()
  {
    this.b = QQMusicCGIConfig.e();
    this.a = true;
  }
  
  public void b()
  {
    String str = FolderXmlBody.a(BaseApplicationImpl.a(), null, this.h, this.i, this.j);
    if (str != null) {
      a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.FolderListRequest
 * JD-Core Version:    0.7.0.1
 */