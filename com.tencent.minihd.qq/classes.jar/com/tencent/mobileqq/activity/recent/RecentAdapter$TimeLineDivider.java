package com.tencent.mobileqq.activity.recent;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RecentAdapter$TimeLineDivider
{
  public String a;
  
  public RecentAdapter$TimeLineDivider(RecentAdapter paramRecentAdapter, String paramString, long paramLong)
  {
    if (paramString.length() > 5)
    {
      paramRecentAdapter = Calendar.getInstance();
      paramRecentAdapter.setTimeInMillis(paramLong);
      if ((paramString.startsWith("上午")) || (paramString.startsWith("下午")))
      {
        this.jdField_a_of_type_JavaLangString = String.format("%02d:%02d", new Object[] { Integer.valueOf(paramRecentAdapter.get(11)), Integer.valueOf(paramRecentAdapter.get(12)) });
        return;
      }
      this.jdField_a_of_type_JavaLangString = new SimpleDateFormat("MM-dd").format(paramRecentAdapter.getTime());
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.TimeLineDivider
 * JD-Core Version:    0.7.0.1
 */