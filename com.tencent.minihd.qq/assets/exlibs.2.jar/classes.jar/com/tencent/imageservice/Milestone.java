package com.tencent.imageservice;

public class Milestone
{
  private int mMilestone = 0;
  
  public void disable(int paramInt)
  {
    this.mMilestone &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void disableAll(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      disable(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public void enable(int paramInt)
  {
    this.mMilestone |= paramInt;
  }
  
  public void enableAll(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      enable(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public String getMilestoneString()
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    int i = 31;
    if (i < 0) {
      return localStringBuilder.toString();
    }
    if (isEnabled(1 << i)) {}
    for (String str = "1";; str = "0")
    {
      localStringBuilder.append(str);
      i -= 1;
      break;
    }
  }
  
  public int getMilestoneValue()
  {
    return this.mMilestone;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return (this.mMilestone & paramInt) == paramInt;
  }
  
  public void reset()
  {
    this.mMilestone = 0;
  }
  
  public void toggle(int paramInt)
  {
    this.mMilestone ^= paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.imageservice.Milestone
 * JD-Core Version:    0.7.0.1
 */