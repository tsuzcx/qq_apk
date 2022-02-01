package com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent;

import android.content.Context;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.XmlStringBuilder;
import com.tencent.mobileqq.music.SongInfo;

public class FavSongXmlBody
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 5;
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      MLog.b("writeFolderSong", "default type:" + paramInt);
    case 2: 
    case 6: 
    case 8: 
      return 0;
    case 4: 
      return 1;
    }
    return 5;
  }
  
  public static String a(Context paramContext, String paramString, SongInfo paramSongInfo, long paramLong, boolean paramBoolean)
  {
    if (paramSongInfo == null) {
      return "";
    }
    XmlStringBuilder localXmlStringBuilder1 = new XmlStringBuilder();
    localXmlStringBuilder1.a("auth", QQMusicHelper.a());
    localXmlStringBuilder1.a("wtid", "1");
    localXmlStringBuilder1.a("a2", QQMusicHelper.b());
    XmlStringBuilder localXmlStringBuilder2 = new XmlStringBuilder();
    localXmlStringBuilder2.a("gt", paramLong + "");
    localXmlStringBuilder2.a("gl", paramSongInfo.jdField_a_of_type_Long + "");
    localXmlStringBuilder2.a("foldertimetag", System.currentTimeMillis() / 1000L + "");
    localXmlStringBuilder2.a("info1", a(paramSongInfo.jdField_a_of_type_Int) + "");
    localXmlStringBuilder2.a("info2", paramSongInfo.b, true);
    String str;
    if (paramSongInfo.g == null)
    {
      str = "";
      localXmlStringBuilder2.a("info3", str, true);
      localXmlStringBuilder2.a("info4", "");
      localXmlStringBuilder2.a("info5", paramSongInfo.f, true);
      localXmlStringBuilder1.a("item", localXmlStringBuilder2.toString());
      if (paramString != null) {
        localXmlStringBuilder1.a(paramString);
      }
      if (!paramBoolean) {
        break label298;
      }
    }
    label298:
    for (int i = 231;; i = 232)
    {
      return XmlProtocolConfig.a(paramContext, localXmlStringBuilder1.toString(), i + "");
      str = paramSongInfo.g;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.FavSongXmlBody
 * JD-Core Version:    0.7.0.1
 */