package com.tencent.mobileqq.highway.config;

import java.io.Serializable;

public class HwNetSegConf
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 3334652520215468712L;
  public long curConnNum;
  public long netType;
  public long segNum;
  public long segSize;
  
  public HwNetSegConf(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.netType = paramLong1;
    this.segSize = paramLong2;
    this.segNum = paramLong3;
    this.curConnNum = paramLong4;
  }
  
  public HwNetSegConf clone()
    throws CloneNotSupportedException
  {
    return (HwNetSegConf)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.HwNetSegConf
 * JD-Core Version:    0.7.0.1
 */