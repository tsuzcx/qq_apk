package com.tencent.mobileqq.dating;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class DatingManager$3
  extends LinkedHashMap
{
  private static final int a = 50;
  private static final long serialVersionUID = 3550610065979495878L;
  
  DatingManager$3(DatingManager paramDatingManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > 50;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingManager.3
 * JD-Core Version:    0.7.0.1
 */