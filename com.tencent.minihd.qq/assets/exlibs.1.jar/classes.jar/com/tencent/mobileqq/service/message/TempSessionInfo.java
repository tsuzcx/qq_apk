package com.tencent.mobileqq.service.message;

public class TempSessionInfo
{
  public static final int a = -1;
  public static final long a = -1L;
  public int b;
  public long b;
  public int c;
  public long c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("----dump tempSession info----");
    localStringBuilder.append("friendType:").append(this.jdField_b_of_type_Int).append(" groupCode:").append(this.jdField_b_of_type_Long).append(" groupUin:").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.TempSessionInfo
 * JD-Core Version:    0.7.0.1
 */