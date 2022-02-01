package com.tencent.tmassistantsdk;

public class TMAssistantCallYYBParamStruct
{
  public String SNGAppId = "";
  public String actionFlag = "0";
  public String channelId = "";
  public String taskApkId = "";
  public String taskAppId = "";
  public String taskPackageName = "";
  public int taskVersion = 0;
  public String uin = "";
  public String uinType = "";
  public String via = "";
  
  public TMAssistantCallYYBParamStruct() {}
  
  public TMAssistantCallYYBParamStruct(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.SNGAppId = paramString1;
    this.taskAppId = paramString2;
    this.taskApkId = paramString3;
    this.taskVersion = paramInt;
    this.via = paramString4;
    this.taskPackageName = paramString5;
    this.uin = paramString6;
    this.uinType = paramString7;
    this.channelId = paramString8;
    this.actionFlag = paramString9;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SNGAppId = " + this.SNGAppId).append(",taskAppId = " + this.taskAppId).append(",taskApkId = " + this.taskApkId).append(",taskVersion = " + this.taskVersion).append(",via = " + this.via).append(",taskPackageName = " + this.taskPackageName).append(",uin = " + this.uin).append(",uinType = " + this.uinType).append(",channelId = " + this.channelId).append(",actionFlag = " + this.actionFlag);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct
 * JD-Core Version:    0.7.0.1
 */