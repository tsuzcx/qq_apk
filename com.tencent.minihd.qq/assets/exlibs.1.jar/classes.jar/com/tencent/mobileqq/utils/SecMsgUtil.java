package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Random;

public final class SecMsgUtil
{
  public static int a = 0;
  private static final String a = "SecMsgUtil";
  
  public static long a()
  {
    long l2 = (int)NetConnInfoCenter.getServerTime();
    long l1 = l2;
    if (l2 == 0L) {
      l1 = (int)(System.currentTimeMillis() / 1000L);
    }
    l2 = Math.abs(new Random().nextInt());
    int i = a;
    a = i + 1;
    return (l1 << 32 | l2 << 16 | i) & 0xFFFFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SecMsgUtil
 * JD-Core Version:    0.7.0.1
 */