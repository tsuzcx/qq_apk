package com.tencent.mobileqq.activity.photo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class MimeHelper
{
  public static final String a = "image";
  public static final String b = "image/jpeg";
  public static final String c = "image/gif";
  public static final String d = "image/bmp";
  public static final String e = "image/png";
  public static final String f = "jpg";
  public static final String g = "jpeg";
  public static final String h = "gif";
  public static final String i = "bmp";
  public static final String j = "bitmap";
  public static final String k = "png";
  public static final String l = "video";
  public static final String m = "video/mp4";
  public static final String n = "mobileqq";
  private static final String o = "MimeHelper";
  
  public static boolean a(String paramString)
  {
    if (("jpg".equals(paramString)) || ("gif".equals(paramString)) || ("png".equals(paramString)) || ("jpeg".equals(paramString))) {}
    while ((paramString.lastIndexOf("bmp") != -1) || (paramString.lastIndexOf("bitmap") != -1)) {
      return true;
    }
    return false;
  }
  
  public static String[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = paramString.split("/");
      if (arrayOfString.length == 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("MimeHelper", 2, "Mimetype error:" + paramString);
    return null;
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MimeHelper
 * JD-Core Version:    0.7.0.1
 */