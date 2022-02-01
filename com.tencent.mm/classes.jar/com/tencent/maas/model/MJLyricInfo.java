package com.tencent.maas.model;

import com.tencent.maas.model.time.MJTime;

public class MJLyricInfo
{
  private String content;
  private MJTime endTime;
  private MJTime startTime;
  private String subContent;
  
  public MJLyricInfo(MJTime paramMJTime1, MJTime paramMJTime2, String paramString1, String paramString2)
  {
    this.startTime = paramMJTime1;
    this.endTime = paramMJTime2;
    this.content = paramString1;
    this.subContent = paramString2;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public MJTime getEndTime()
  {
    return this.endTime;
  }
  
  public MJTime getStartTime()
  {
    return this.startTime;
  }
  
  public String getSubContent()
  {
    return this.subContent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.maas.model.MJLyricInfo
 * JD-Core Version:    0.7.0.1
 */