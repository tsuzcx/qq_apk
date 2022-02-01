package com.tencent.maas.model;

public class MJChannelEventConfig
{
  private final String eventName;
  private final String finderNickName;
  
  public MJChannelEventConfig(String paramString1, String paramString2)
  {
    this.eventName = paramString1;
    this.finderNickName = paramString2;
  }
  
  public String getEventName()
  {
    return this.eventName;
  }
  
  public String getFinderNickName()
  {
    return this.finderNickName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.model.MJChannelEventConfig
 * JD-Core Version:    0.7.0.1
 */