package com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent;

import android.content.Context;
import com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicConfig;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;

public class SessionXmlBody
{
  public static String a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<mt>");
    localStringBuffer.append(QQMusicConfig.a());
    localStringBuffer.append("</mt>");
    localStringBuffer.append("<encii>");
    localStringBuffer.append(MusicUtil.f(paramContext));
    localStringBuffer.append("</encii>");
    localStringBuffer.append("<mac>");
    localStringBuffer.append(MusicUtil.g(paramContext));
    localStringBuffer.append("</mac>");
    localStringBuffer.append("<imsi>");
    localStringBuffer.append(MusicUtil.c(paramContext));
    localStringBuffer.append("</imsi>");
    localStringBuffer.append("<caller>");
    localStringBuffer.append(1);
    localStringBuffer.append("</caller>");
    localStringBuffer.append("<origid>");
    localStringBuffer.append(MusicUtil.b());
    localStringBuffer.append("</origid>");
    if (paramString != null) {
      localStringBuffer.append(paramString);
    }
    return XmlProtocolConfig.a(paramContext, localStringBuffer.toString(), "100");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.SessionXmlBody
 * JD-Core Version:    0.7.0.1
 */