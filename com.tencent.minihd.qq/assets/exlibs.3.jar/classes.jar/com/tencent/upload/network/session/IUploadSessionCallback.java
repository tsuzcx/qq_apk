package com.tencent.upload.network.session;

import com.tencent.upload.network.action.ActionResponse;
import com.tencent.upload.network.action.IActionRequest;

public abstract interface IUploadSessionCallback
{
  public abstract void onClose(IUploadSession paramIUploadSession);
  
  public abstract void onError(IUploadSession paramIUploadSession, int paramInt, String paramString);
  
  public abstract void onFailToOpen(IUploadSession paramIUploadSession, int paramInt, boolean paramBoolean);
  
  public abstract void onOpen(IUploadSession paramIUploadSession);
  
  public abstract void onReceive(IUploadSession paramIUploadSession, ActionResponse paramActionResponse);
  
  public abstract void onReceiveTimeout(IUploadSession paramIUploadSession, IActionRequest paramIActionRequest);
  
  public abstract void onSend(IUploadSession paramIUploadSession, IActionRequest paramIActionRequest);
  
  public static final class DetectionState
  {
    public static final int DETECTED = 2;
    public static final int DETECTING = 1;
    public static final int NO_DETECTION = 0;
    
    public static final String print(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "unknown";
      case 0: 
        return "noDetection";
      case 1: 
        return "detecting";
      }
      return "detected";
    }
  }
  
  public static final class FailureCode
  {
    public static final int CONNECTION_FAILED = 0;
    public static final int HANDSHAKE_FAILED = 1;
    public static final int TIMEOUT_FAILED = 3;
    public static final int UNPACKET_FAILED = 2;
    
    public static final String print(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "unknown";
      case 0: 
        return "connectionFailed";
      case 1: 
        return "handshakeFailed";
      }
      return "unpacketFailed";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.session.IUploadSessionCallback
 * JD-Core Version:    0.7.0.1
 */