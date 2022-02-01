package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class RecentItemVoteData
  extends RecentUserBaseData
{
  public long b;
  
  public RecentItemVoteData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void a(String paramString, long paramLong)
  {
    this.a = paramString;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemVoteData
 * JD-Core Version:    0.7.0.1
 */