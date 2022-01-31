package com.tencent.mm.chatroom.c;

import java.util.Calendar;

public final class a
{
  public long bIt;
  private Calendar calendar;
  public int day;
  public long dmJ;
  public int month;
  public int year;
  
  public a()
  {
    setTime(System.currentTimeMillis());
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.year = paramInt1;
    this.month = paramInt2;
    this.day = paramInt3;
  }
  
  public a(long paramLong)
  {
    this.dmJ = paramLong;
    setTime(paramLong);
  }
  
  private void setTime(long paramLong)
  {
    this.dmJ = paramLong;
    if (this.calendar == null) {
      this.calendar = Calendar.getInstance();
    }
    this.calendar.setTimeInMillis(paramLong);
    this.month = this.calendar.get(2);
    this.year = this.calendar.get(1);
    this.day = this.calendar.get(5);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (paramObject.day == this.day)
      {
        bool1 = bool2;
        if (paramObject.month == this.month)
        {
          bool1 = bool2;
          if (paramObject.year == this.year) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ year: ");
    localStringBuilder.append(this.year);
    localStringBuilder.append(", month: ");
    localStringBuilder.append(this.month);
    localStringBuilder.append(", day: ");
    localStringBuilder.append(this.day);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.a
 * JD-Core Version:    0.7.0.1
 */