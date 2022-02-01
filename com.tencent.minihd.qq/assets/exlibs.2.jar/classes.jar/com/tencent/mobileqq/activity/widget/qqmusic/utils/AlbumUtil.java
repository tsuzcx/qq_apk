package com.tencent.mobileqq.activity.widget.qqmusic.utils;

import com.tencent.mobileqq.music.SongInfo;

public class AlbumUtil
{
  private static String a(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, long paramLong3, String paramString4)
  {
    StringBuffer localStringBuffer = new StringBuffer("k_");
    localStringBuffer.append("" + paramLong1);
    localStringBuffer.append("_");
    localStringBuffer.append("" + paramLong2);
    localStringBuffer.append("_");
    localStringBuffer.append("" + paramLong3);
    localStringBuffer.append("_");
    if (paramString1 != null) {
      localStringBuffer.append(paramString1);
    }
    localStringBuffer.append("_");
    if (paramString2 != null) {
      localStringBuffer.append(paramString2);
    }
    localStringBuffer.append("_");
    if (paramString3 != null) {
      localStringBuffer.append(paramString3);
    }
    localStringBuffer.append("_");
    if (paramString4 != null) {
      localStringBuffer.append(paramString4);
    }
    return localStringBuffer.toString();
  }
  
  public static String a(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      return "";
    }
    return a(paramSongInfo.a, paramSongInfo.jdField_b_of_type_JavaLangString, paramSongInfo.g, paramSongInfo.f, paramSongInfo.c, paramSongInfo.jdField_b_of_type_Long, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.AlbumUtil
 * JD-Core Version:    0.7.0.1
 */