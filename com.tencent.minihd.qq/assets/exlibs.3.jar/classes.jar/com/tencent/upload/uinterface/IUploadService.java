package com.tencent.upload.uinterface;

import android.content.Context;
import com.tencent.upload.biz.UploadServiceImpl;

public abstract interface IUploadService
{
  public static final String DOMAIN_PARSER_THREAD_NAME = "domainParser";
  public static final String UPLOAD_CORE_THREAD_NAME = "uploadCore";
  public static final String UPLOAD_HANDLE_THREAD_NAME = "uploadHandle";
  
  public abstract boolean cancel(AbstractUploadTask paramAbstractUploadTask);
  
  public abstract boolean clearCacheWhenIdle(Context paramContext);
  
  public abstract boolean commit(AbstractUploadTask paramAbstractUploadTask);
  
  public abstract void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport);
  
  public abstract boolean isInitialized();
  
  public abstract void pauseAllTask();
  
  public abstract void prepare(IUploadTaskType paramIUploadTaskType);
  
  public abstract void setBackgroundMode(boolean paramBoolean);
  
  public abstract void setTestServer(int paramInt);
  
  public abstract boolean upload(AbstractUploadTask paramAbstractUploadTask);
  
  public static abstract interface IUploadServiceContext
  {
    public abstract boolean compressUploadTask(AbstractUploadTask paramAbstractUploadTask, IUploadConfig.UploadImageSize paramUploadImageSize, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void uploadAction(IUploadAction paramIUploadAction);
  }
  
  public static final class UploadServiceCreator
  {
    public static final IUploadService getInstance()
    {
      return UploadServiceImpl.getInstance();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.IUploadService
 * JD-Core Version:    0.7.0.1
 */