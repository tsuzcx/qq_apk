package com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent;

import android.content.Context;
import com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.Session;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager;

public class VkeyXmlBody
{
  public static String a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Session localSession = SessionManager.a().a();
    if ((localSession != null) && (localSession.d() != null))
    {
      localStringBuffer.append("<guid>");
      localStringBuffer.append(localSession.d());
      localStringBuffer.append("</guid>");
    }
    try
    {
      localStringBuffer.append("<nettype>");
      localStringBuffer.append(Integer.toString(ApnManager.a()));
      localStringBuffer.append("</nettype>");
      localStringBuffer.append("<platform>");
      localStringBuffer.append("android");
      localStringBuffer.append("</platform>");
      localStringBuffer.append("<musicname>");
      localStringBuffer.append("M8000047jzQv0sV4pz.mp3");
      localStringBuffer.append("</musicname>");
      if (paramString != null) {
        localStringBuffer.append(paramString);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    return XmlProtocolConfig.a(paramContext, localStringBuffer.toString(), "352");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.VkeyXmlBody
 * JD-Core Version:    0.7.0.1
 */