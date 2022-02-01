package com.tencent.upload.uinterface.protocol;

import com.tencent.upload.uinterface.IUploadTaskType;

public class VideoUploadTaskType
  implements IUploadTaskType
{
  public int getProtocolFileType()
  {
    return 1;
  }
  
  public int getProtocolUploadType()
  {
    return 1;
  }
  
  public int getServerCategory()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.protocol.VideoUploadTaskType
 * JD-Core Version:    0.7.0.1
 */