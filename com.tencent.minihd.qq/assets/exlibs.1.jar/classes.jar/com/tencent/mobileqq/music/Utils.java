package com.tencent.mobileqq.music;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;

public class Utils
{
  public static String[] a = { "MI PAD", "samsung SM-N7508V", "samsung SM-N9002", "samsung SM-N9005", "samsung SM-N9006", "samsung SM-N9008", "samsung SM-N9009", "samsung SM-N9009V", "samsung SM-G3858", "samsung SM-G7108V", "samsung SM-G7108U", "samsung SM-G9008V", "samsung GT-I9308I", "samsung GT-I9508V", "samsung SM-G3588V", "samsung SM-T2558", "HTC T528w", "Xiaomi MI 3", "HTC 802t" };
  
  public static boolean a()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "isPhoneInWhiteList ： phone = " + str + ", result=" + bool1);
        }
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.music.Utils
 * JD-Core Version:    0.7.0.1
 */