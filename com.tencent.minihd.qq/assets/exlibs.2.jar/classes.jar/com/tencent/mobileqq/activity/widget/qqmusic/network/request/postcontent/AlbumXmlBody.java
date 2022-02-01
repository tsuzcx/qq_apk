package com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent;

import android.content.Context;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.XmlStringBuilder;
import com.tencent.mobileqq.music.SongInfo;

public class AlbumXmlBody
{
  public static String a(Context paramContext, String paramString, SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      return "";
    }
    XmlStringBuilder localXmlStringBuilder = new XmlStringBuilder();
    localXmlStringBuilder.a("pt", "0");
    localXmlStringBuilder.a("ps", "0");
    localXmlStringBuilder.a("item", paramSongInfo.h);
    if (paramString != null) {
      localXmlStringBuilder.a(paramString);
    }
    return XmlProtocolConfig.a(paramContext, localXmlStringBuilder.toString(), "226");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.AlbumXmlBody
 * JD-Core Version:    0.7.0.1
 */