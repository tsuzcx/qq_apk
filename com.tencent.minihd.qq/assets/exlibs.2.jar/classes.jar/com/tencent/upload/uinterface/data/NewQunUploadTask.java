package com.tencent.upload.uinterface.data;

import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.protocol.NewQunUploadTaskType;

public class NewQunUploadTask
  extends ImageUploadTask
{
  public byte[] a2_key = null;
  public String appid = "";
  public String userid = "";
  
  public NewQunUploadTask(String paramString)
  {
    super(false, paramString);
  }
  
  public IUploadTaskType getUploadTaskType()
  {
    return new NewQunUploadTaskType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.NewQunUploadTask
 * JD-Core Version:    0.7.0.1
 */