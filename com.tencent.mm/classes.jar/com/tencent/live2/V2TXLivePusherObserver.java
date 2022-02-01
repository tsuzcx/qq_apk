package com.tencent.live2;

import android.graphics.Bitmap;
import android.os.Bundle;

public abstract class V2TXLivePusherObserver
{
  public void onCaptureFirstAudioFrame() {}
  
  public void onCaptureFirstVideoFrame() {}
  
  public void onError(int paramInt, String paramString, Bundle paramBundle) {}
  
  public void onGLContextCreated() {}
  
  public void onGLContextDestroyed() {}
  
  public void onMicrophoneVolumeUpdate(int paramInt) {}
  
  public int onProcessVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame1, V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame2)
  {
    return 0;
  }
  
  public void onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus paramV2TXLivePushStatus, String paramString, Bundle paramBundle) {}
  
  public void onSetMixTranscodingConfig(int paramInt, String paramString) {}
  
  public void onSnapshotComplete(Bitmap paramBitmap) {}
  
  public void onStatisticsUpdate(V2TXLiveDef.V2TXLivePusherStatistics paramV2TXLivePusherStatistics) {}
  
  public void onWarning(int paramInt, String paramString, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.V2TXLivePusherObserver
 * JD-Core Version:    0.7.0.1
 */