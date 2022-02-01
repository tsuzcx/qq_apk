package com.tencent.mobileqq.activity.widget.qqmusic.utils;

import com.tencent.mobileqq.activity.widget.qqmusic.business.player.Util4AudioStream;
import java.util.ArrayList;

public class SonginfoUtil
{
  public static com.tencent.mobileqq.music.SongInfo a(com.tencent.mobileqq.activity.widget.qqmusic.data.SongInfo paramSongInfo, int paramInt)
  {
    if (paramSongInfo == null) {
      return null;
    }
    String str = Util4AudioStream.a(paramSongInfo, paramSongInfo.a(true), 96);
    com.tencent.mobileqq.music.SongInfo localSongInfo = new com.tencent.mobileqq.music.SongInfo();
    localSongInfo.jdField_a_of_type_Long = paramSongInfo.b();
    localSongInfo.g = paramSongInfo.a();
    localSongInfo.jdField_a_of_type_JavaLangString = str;
    localSongInfo.jdField_b_of_type_Long = paramSongInfo.a();
    localSongInfo.jdField_b_of_type_JavaLangString = paramSongInfo.b();
    localSongInfo.f = paramSongInfo.c();
    localSongInfo.jdField_b_of_type_Int = paramInt;
    localSongInfo.jdField_a_of_type_Int = paramSongInfo.b();
    XmlStringBuilder localXmlStringBuilder = new XmlStringBuilder();
    if (paramSongInfo.a())
    {
      str = paramSongInfo.b() + "";
      localXmlStringBuilder.a("gl", str);
      localXmlStringBuilder.a("info1", paramSongInfo.e());
      if ("未知歌手".equals(paramSongInfo.f())) {
        break label226;
      }
      str = paramSongInfo.f();
      label159:
      localXmlStringBuilder.a("info2", str);
      localXmlStringBuilder.a("info3", paramSongInfo.g());
      localXmlStringBuilder.a("info4", "");
      localSongInfo.h = localXmlStringBuilder.toString();
      if (!paramSongInfo.k()) {
        break label232;
      }
    }
    label226:
    label232:
    for (paramInt = 1;; paramInt = 0)
    {
      localSongInfo.c = paramInt;
      localSongInfo.i = paramSongInfo.d();
      return localSongInfo;
      str = "-1";
      break;
      str = "";
      break label159;
    }
  }
  
  public static com.tencent.mobileqq.music.SongInfo[] a(ArrayList paramArrayList)
  {
    return a(paramArrayList, 0);
  }
  
  public static com.tencent.mobileqq.music.SongInfo[] a(ArrayList paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    int j = paramArrayList.size();
    com.tencent.mobileqq.music.SongInfo[] arrayOfSongInfo = new com.tencent.mobileqq.music.SongInfo[j];
    int i = 0;
    while (i < j)
    {
      arrayOfSongInfo[i] = a((com.tencent.mobileqq.activity.widget.qqmusic.data.SongInfo)paramArrayList.get(i), paramInt);
      i += 1;
    }
    return arrayOfSongInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.SonginfoUtil
 * JD-Core Version:    0.7.0.1
 */