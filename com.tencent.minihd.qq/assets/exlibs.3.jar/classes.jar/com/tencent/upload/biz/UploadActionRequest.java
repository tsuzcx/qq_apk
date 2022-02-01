package com.tencent.upload.biz;

import com.tencent.upload.network.action.IActionRequest;
import java.io.File;

public class UploadActionRequest
  implements IActionRequest
{
  private final int mActionId;
  private final int mCommandId;
  private final byte[] mData;
  private final File mFile;
  private final int mFileOffset;
  private final int mFileSendCount;
  private final boolean mPartFileMode;
  private final int mRequestId;
  
  public UploadActionRequest(byte[] paramArrayOfByte, File paramFile, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mData = paramArrayOfByte;
    this.mFile = paramFile;
    this.mPartFileMode = paramBoolean;
    this.mFileOffset = paramInt1;
    this.mFileSendCount = paramInt2;
    this.mActionId = paramInt3;
    this.mCommandId = paramInt4;
    this.mRequestId = paramInt5;
  }
  
  public byte[] encode()
  {
    return this.mData;
  }
  
  public int getActionSequence()
  {
    return this.mActionId;
  }
  
  public int getCommandId()
  {
    return this.mCommandId;
  }
  
  public File getFile()
  {
    return this.mFile;
  }
  
  public int getFileOffset()
  {
    return this.mFileOffset;
  }
  
  public int getFileSendLenght()
  {
    return this.mFileSendCount;
  }
  
  public int getRequestSequence()
  {
    return this.mRequestId;
  }
  
  public boolean isPartFileMode()
  {
    return this.mPartFileMode;
  }
  
  public String toString()
  {
    return "UploadActionRequest [mPartFileMode=" + this.mPartFileMode + ", mFileOffset=" + this.mFileOffset + ", mFileSendCount=" + this.mFileSendCount + ", mActionId=" + this.mActionId + ", mCommandId=" + this.mCommandId + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.biz.UploadActionRequest
 * JD-Core Version:    0.7.0.1
 */