package com.tencent.live2;

import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.rtmp.ui.TXCloudVideoView;

public abstract class V2TXLivePlayer
{
  public abstract int enableCustomRendering(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType);
  
  public abstract int enableVolumeEvaluation(int paramInt);
  
  public abstract int isPlaying();
  
  public abstract int pauseAudio();
  
  public abstract int pauseVideo();
  
  public abstract int resumeAudio();
  
  public abstract int resumeVideo();
  
  public abstract int setCacheParams(float paramFloat1, float paramFloat2);
  
  public abstract void setObserver(V2TXLivePlayerObserver paramV2TXLivePlayerObserver);
  
  public abstract int setPlayoutVolume(int paramInt);
  
  public abstract int setProperty(String paramString, Object paramObject);
  
  public abstract int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode);
  
  public abstract int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation);
  
  public abstract int setRenderView(SurfaceView paramSurfaceView);
  
  public abstract int setRenderView(TextureView paramTextureView);
  
  public abstract int setRenderView(TXCloudVideoView paramTXCloudVideoView);
  
  public abstract void showDebugView(boolean paramBoolean);
  
  public abstract int snapshot();
  
  public abstract int startPlay(String paramString);
  
  public abstract int stopPlay();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.V2TXLivePlayer
 * JD-Core Version:    0.7.0.1
 */