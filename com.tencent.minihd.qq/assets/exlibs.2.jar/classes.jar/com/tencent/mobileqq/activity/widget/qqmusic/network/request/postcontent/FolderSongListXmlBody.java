package com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent;

import android.content.Context;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.XmlStringBuilder;

public class FolderSongListXmlBody
{
  public static String a(Context paramContext, String paramString, FolderInfo paramFolderInfo)
  {
    if (paramFolderInfo == null) {
      return "";
    }
    XmlStringBuilder localXmlStringBuilder = new XmlStringBuilder();
    localXmlStringBuilder.a("opType", "2");
    localXmlStringBuilder.a("orderFromTo", "0");
    localXmlStringBuilder.a("qryUin", "0");
    localXmlStringBuilder.a("qryDissID", paramFolderInfo.b() + "");
    localXmlStringBuilder.a("hostUin", paramFolderInfo.c() + "");
    localXmlStringBuilder.a("dirID", paramFolderInfo.a() + "");
    localXmlStringBuilder.a("ctx", "1");
    if (paramString != null) {
      localXmlStringBuilder.a(paramString);
    }
    return XmlProtocolConfig.a(paramContext, localXmlStringBuilder.toString(), "287");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.FolderSongListXmlBody
 * JD-Core Version:    0.7.0.1
 */