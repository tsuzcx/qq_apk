package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class RecentEmotionData
  extends Entity
{
  public static final int TYPE_CUSTOM_EMO = 3;
  public static final int TYPE_EMOJI_EMO = 4;
  public static final int TYPE_MARKET_FACE = 5;
  public static final int TYPE_SYS_EMO = 0;
  public int emoId;
  public int emoIndex;
  public String emoPath;
  public int type;
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecentEmotionData
 * JD-Core Version:    0.7.0.1
 */