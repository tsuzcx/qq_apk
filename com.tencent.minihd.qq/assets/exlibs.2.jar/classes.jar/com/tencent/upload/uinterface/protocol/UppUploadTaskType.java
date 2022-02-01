package com.tencent.upload.uinterface.protocol;

import com.tencent.upload.uinterface.IUploadTaskType;

public class UppUploadTaskType
  implements IUploadTaskType
{
  public int getProtocolFileType()
  {
    return 0;
  }
  
  public int getProtocolUploadType()
  {
    return 4;
  }
  
  public int getServerCategory()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.protocol.UppUploadTaskType
 * JD-Core Version:    0.7.0.1
 */