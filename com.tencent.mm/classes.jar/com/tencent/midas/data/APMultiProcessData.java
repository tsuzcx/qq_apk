package com.tencent.midas.data;

public class APMultiProcessData
{
  private String guid = "";
  private int intervalTime = 0;
  private long payInterfaceTime = 0L;
  
  public String getGuid()
  {
    return this.guid;
  }
  
  public int getIntervalTime()
  {
    return this.intervalTime;
  }
  
  public long getPayInterfaceTime()
  {
    return this.payInterfaceTime;
  }
  
  public void setGuid(String paramString)
  {
    this.guid = paramString;
  }
  
  public void setIntervalTime(int paramInt)
  {
    this.intervalTime = paramInt;
  }
  
  public void setPayInterfaceTime(long paramLong)
  {
    this.payInterfaceTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.data.APMultiProcessData
 * JD-Core Version:    0.7.0.1
 */