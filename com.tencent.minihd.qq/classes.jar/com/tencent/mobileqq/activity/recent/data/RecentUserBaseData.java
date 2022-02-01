package com.tencent.mobileqq.activity.recent.data;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.data.RecentUser;

public abstract class RecentUserBaseData
  extends RecentBaseData
{
  protected static final String g = "%s,%d,%s,%s";
  protected static final String h = "%s,%s,%s";
  public RecentUser a;
  
  public RecentUserBaseData(RecentUser paramRecentUser)
  {
    if (paramRecentUser == null) {
      throw new NullPointerException("RecentUser is null");
    }
    this.a = paramRecentUser;
    switch (this.a.type)
    {
    default: 
      return;
    case 0: 
    case 8: 
    case 1000: 
    case 1004: 
    case 1006: 
    case 1021: 
      this.G |= 0x1000;
      return;
    }
    this.G |= 0x2000;
  }
  
  public int a()
  {
    return this.a.type;
  }
  
  public long a()
  {
    return this.a.lastmsgtime;
  }
  
  public RecentUser a()
  {
    return this.a;
  }
  
  public String a()
  {
    return this.a.uin;
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.a = paramRecentUser;
  }
  
  public final boolean a()
  {
    return (this.A == 1) || (this.A == 4);
  }
  
  public long b()
  {
    return this.a.lastmsgdrafttime;
  }
  
  public int c()
  {
    return this.a.msgType;
  }
  
  public String c()
  {
    return this.a.troopUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentUserBaseData
 * JD-Core Version:    0.7.0.1
 */