package com.tencent.mobileqq.data;

public class MessageForFile
  extends ChatMessage
{
  private static final String TAG = MessageForFile.class.getSimpleName();
  public String fileName;
  public String filePath;
  public long fileSize;
  public String fileSizeString;
  public String fileType;
  public int status;
  public String[] tempMsg;
  public String url;
  public String urlAtServer;
  
  public void doParse()
  {
    if ((this.msg != null) && (this.msg.length() > 0) && (this.msg.charAt(0) == '\026'))
    {
      this.tempMsg = this.msg.split("\\|");
      return;
    }
    this.tempMsg = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFile
 * JD-Core Version:    0.7.0.1
 */