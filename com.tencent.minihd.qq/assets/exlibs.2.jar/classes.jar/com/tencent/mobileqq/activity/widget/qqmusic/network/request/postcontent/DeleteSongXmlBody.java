package com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent;

import android.content.Context;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.business.radio.SingleSongRadioBehaviorReport;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.XmlStringBuilder;
import com.tencent.mobileqq.music.SongInfo;

public class DeleteSongXmlBody
{
  public static String a(Context paramContext, String paramString1, SongInfo paramSongInfo, long paramLong, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramSongInfo == null) {
      return "";
    }
    XmlStringBuilder localXmlStringBuilder = new XmlStringBuilder();
    localXmlStringBuilder.a("wtid", "1");
    localXmlStringBuilder.a("a2", QQMusicHelper.b());
    localXmlStringBuilder.a("songid", paramSongInfo.jdField_a_of_type_Long + "");
    localXmlStringBuilder.a("time", paramLong + "");
    localXmlStringBuilder.a("oper", paramInt1 + "");
    localXmlStringBuilder.a("callback", paramString2);
    localXmlStringBuilder.a("source", paramInt2 + "");
    localXmlStringBuilder.a("rec_reason", "");
    localXmlStringBuilder.a("original_id", paramSongInfo.jdField_a_of_type_Long + "");
    localXmlStringBuilder.a("original_type", paramSongInfo.jdField_a_of_type_Int + "");
    localXmlStringBuilder.a("biz", SingleSongRadioBehaviorReport.q + "");
    if (paramString1 != null) {
      localXmlStringBuilder.a(paramString1);
    }
    return XmlProtocolConfig.a(paramContext, localXmlStringBuilder.toString(), "320");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.DeleteSongXmlBody
 * JD-Core Version:    0.7.0.1
 */