package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;

public class PicTypeTroopBar
  extends PicTypeNormal
{
  private static final int o = 90;
  private static final int p = 85;
  
  PicTypeTroopBar(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a()
  {
    int i = 85;
    if (this.a.g == 2)
    {
      i = 100;
      return i;
    }
    switch (this.a.h)
    {
    case 4: 
    case 2: 
    case 3: 
    default: 
      return 85;
    }
    return 90;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeTroopBar
 * JD-Core Version:    0.7.0.1
 */