package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.pluginsdk.ResourceIdMapper;

public class QQResourceIdMapper
  extends ResourceIdMapper
{
  public int getHostResourceId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 2130968627;
    case 1: 
      return 2130968628;
    case 2: 
      return 2130968746;
    case 7: 
      return 2130968748;
    case 3: 
      return 2130968593;
    case 6: 
      return 2130968591;
    case 5: 
      return 2130968589;
    case 4: 
      return 2130968594;
    }
    return 2131558748;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQResourceIdMapper
 * JD-Core Version:    0.7.0.1
 */