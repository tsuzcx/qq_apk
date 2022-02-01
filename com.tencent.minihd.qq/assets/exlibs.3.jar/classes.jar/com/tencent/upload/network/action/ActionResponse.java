package com.tencent.upload.network.action;

import FileUpload.SvcResponsePacket;
import android.util.Log;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.protocol.utils.ProtocolUtil;

public final class ActionResponse
{
  private int mActionSequence;
  private int mRequestSequence;
  private SvcResponsePacket mResponsePacket;
  
  public boolean decodeHead(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      this.mResponsePacket = ((SvcResponsePacket)ProtocolUtil.unpack(SvcResponsePacket.class.getSimpleName(), paramArrayOfByte));
      paramArrayOfByte = (byte[])localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramArrayOfByte = Log.getStackTraceString(localException);
        UploadLog.w(ActionResponse.class.getSimpleName(), localException);
      }
      paramArrayOfByte = ProtocolUtil.fromProtocolSequence(this.mResponsePacket.seq);
      this.mActionSequence = paramArrayOfByte[0];
      this.mRequestSequence = paramArrayOfByte[1];
    }
    if (this.mResponsePacket == null)
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = "ImageUploadAction() unpack mResponsePacket=null. " + this.mResponsePacket;
      }
      UploadLog.e(ActionResponse.class.getSimpleName(), (String)localObject);
      this.mResponsePacket = new SvcResponsePacket();
      this.mResponsePacket.iRetCode = -8;
      this.mResponsePacket.sResultDes = ((String)localObject);
      return false;
    }
    return true;
  }
  
  public int getActionSequence()
  {
    return this.mActionSequence;
  }
  
  public SvcResponsePacket getReponsePacket()
  {
    return this.mResponsePacket;
  }
  
  public int getRequestSequence()
  {
    return this.mRequestSequence;
  }
  
  public boolean isSuccessfulFinish()
  {
    if (this.mResponsePacket == null) {}
    while ((this.mResponsePacket.iRetCode != 0) || (this.mResponsePacket.iCmdID != 1)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.action.ActionResponse
 * JD-Core Version:    0.7.0.1
 */