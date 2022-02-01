package com.tencent.mobileqq.data;

import java.io.Serializable;

public class QQDoyen
  implements Serializable
{
  public static final int MOBILEQQ_DAREN_SHOWDAYS = 30;
  public int becomeDoyenNeedDays;
  public int gapDateEndDay;
  public int gapDateEndMonth;
  public int gapDateEndYear;
  public int gapDateStartDay;
  public int gapDateStartMonth;
  public int gapDateStartYear;
  public int gapDays;
  public boolean isDoyen;
  public int nextDays;
  public int nextLevelDateDay;
  public int nextLevelDateMonth;
  public int nextLevelDateYear;
  public int nextUserPer;
  public int nowUserPer;
  public int sequenceDays;
  public long uin;
  
  public boolean equals(QQDoyen paramQQDoyen)
  {
    if (this.uin != paramQQDoyen.uin) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (this.isDoyen != paramQQDoyen.isDoyen);
        if (!this.isDoyen) {
          break;
        }
      } while (this.sequenceDays != paramQQDoyen.sequenceDays);
      return true;
    } while (this.becomeDoyenNeedDays != paramQQDoyen.becomeDoyenNeedDays);
    return true;
  }
  
  public String getEndData()
  {
    Object localObject = "" + this.gapDateEndYear;
    StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
    if (Integer.bitCount(this.gapDateEndMonth) == 1)
    {
      localObject = "0" + this.gapDateEndMonth;
      localObject = localObject;
      localStringBuilder = new StringBuilder().append((String)localObject);
      if (Integer.bitCount(this.gapDateEndDay) != 1) {
        break label144;
      }
    }
    label144:
    for (localObject = "0" + this.gapDateEndDay;; localObject = Integer.valueOf(this.gapDateEndDay))
    {
      return localObject;
      localObject = Integer.valueOf(this.gapDateEndMonth);
      break;
    }
  }
  
  public String getStartData()
  {
    Object localObject = "" + this.gapDateStartYear;
    StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
    if (Integer.bitCount(this.gapDateStartMonth) == 1)
    {
      localObject = "0" + this.gapDateStartMonth;
      localObject = localObject;
      localStringBuilder = new StringBuilder().append((String)localObject);
      if (Integer.bitCount(this.gapDateStartDay) != 1) {
        break label144;
      }
    }
    label144:
    for (localObject = "0" + this.gapDateStartDay;; localObject = Integer.valueOf(this.gapDateStartDay))
    {
      return localObject;
      localObject = Integer.valueOf(this.gapDateStartMonth);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQDoyen
 * JD-Core Version:    0.7.0.1
 */