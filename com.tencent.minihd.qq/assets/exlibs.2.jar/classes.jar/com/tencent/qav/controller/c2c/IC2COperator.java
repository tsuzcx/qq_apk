package com.tencent.qav.controller.c2c;

import com.tencent.av.opengl.ui.GLVideoView;
import com.tencent.qav.QavDef.VideoFrame;

public abstract interface IC2COperator
{
  public abstract void acceptCall(String paramString, boolean paramBoolean);
  
  public abstract void closeCall(String paramString, int paramInt);
  
  public abstract void enableCustomVideoCapture(boolean paramBoolean);
  
  public abstract void enableLocalAudio(boolean paramBoolean);
  
  public abstract void enableLocalVideo(boolean paramBoolean);
  
  public abstract void enableRemoteAudio(boolean paramBoolean);
  
  public abstract int getAudioRoute();
  
  public abstract int getFrameRenderEndFunctionPtr();
  
  public abstract boolean isLocalAudioEnable();
  
  public abstract boolean isRemoteAudioEnable();
  
  public abstract void rejectCall(String paramString, int paramInt);
  
  public abstract void sendCustomVideoData(QavDef.VideoFrame paramVideoFrame);
  
  public abstract void setAudioRoute(int paramInt);
  
  public abstract void setBeautyLevel(int paramInt);
  
  public abstract void startCall(String paramString, boolean paramBoolean);
  
  public abstract void startLocalPreview(boolean paramBoolean, GLVideoView paramGLVideoView);
  
  public abstract void startRemotePreview(String paramString, GLVideoView paramGLVideoView);
  
  public abstract void stopLocalPreview();
  
  public abstract void stopRemotePreview(String paramString);
  
  public abstract void switchCamera();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.qav.controller.c2c.IC2COperator
 * JD-Core Version:    0.7.0.1
 */