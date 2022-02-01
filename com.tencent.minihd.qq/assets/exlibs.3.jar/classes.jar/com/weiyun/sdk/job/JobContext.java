package com.weiyun.sdk.job;

public class JobContext
{
  private long mCurSize = 0L;
  private String mFileId = null;
  private String mFileName = null;
  private String mFileNote = null;
  private final long mId;
  private long mModifyTime = 0L;
  private String mParentDirKey = null;
  private String mParentParentDirKey = null;
  private long mTotalSize = 0L;
  private final long mUin;
  
  public JobContext(long paramLong)
  {
    this.mUin = paramLong;
    this.mId = 0L;
  }
  
  public JobContext(long paramLong1, long paramLong2)
  {
    this.mUin = paramLong1;
    this.mId = paramLong2;
  }
  
  public long getCurSize()
  {
    return this.mCurSize;
  }
  
  public String getFileId()
  {
    return this.mFileId;
  }
  
  public String getFileName()
  {
    return this.mFileName;
  }
  
  public String getFileNote()
  {
    return this.mFileNote;
  }
  
  public long getId()
  {
    return this.mId;
  }
  
  public long getModifyTime()
  {
    return this.mModifyTime;
  }
  
  public String getParentDirKey()
  {
    return this.mParentDirKey;
  }
  
  public String getParentParentDirKey()
  {
    return this.mParentParentDirKey;
  }
  
  public long getTotalSize()
  {
    return this.mTotalSize;
  }
  
  public long getUin()
  {
    return this.mUin;
  }
  
  public void setCurSize(long paramLong)
  {
    this.mCurSize = paramLong;
  }
  
  public void setFileId(String paramString)
  {
    this.mFileId = paramString;
  }
  
  public void setFileName(String paramString)
  {
    this.mFileName = paramString;
  }
  
  public void setFileNote(String paramString)
  {
    this.mFileNote = paramString;
  }
  
  public void setModifyTime(long paramLong)
  {
    this.mModifyTime = paramLong;
  }
  
  public void setParentDirKey(String paramString)
  {
    this.mParentDirKey = paramString;
  }
  
  public void setParentParentDirKey(String paramString)
  {
    this.mParentParentDirKey = paramString;
  }
  
  public void setTotalSize(long paramLong)
  {
    this.mTotalSize = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.JobContext
 * JD-Core Version:    0.7.0.1
 */