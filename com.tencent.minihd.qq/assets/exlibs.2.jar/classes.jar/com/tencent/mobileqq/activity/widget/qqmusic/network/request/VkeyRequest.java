package com.tencent.mobileqq.activity.widget.qqmusic.network.request;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.VkeyResponse;
import com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicCGIConfig;
import com.tencent.mobileqq.activity.widget.qqmusic.data.BaseInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.VkeyXmlBody;

public class VkeyRequest
  extends BaseCgiRequest
{
  protected BaseInfo a(byte[] paramArrayOfByte)
  {
    VkeyResponse localVkeyResponse = new VkeyResponse();
    localVkeyResponse.a(paramArrayOfByte);
    return localVkeyResponse;
  }
  
  protected void a()
  {
    this.b = QQMusicCGIConfig.b();
    this.a = true;
  }
  
  public void b()
  {
    String str = VkeyXmlBody.a(BaseApplicationImpl.a(), null);
    if (str != null) {
      a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.VkeyRequest
 * JD-Core Version:    0.7.0.1
 */