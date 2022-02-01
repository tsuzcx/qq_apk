package com.tencent.mm.live.core.core.trtc.a;

import android.os.Bundle;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCStatistics;

public abstract interface d
{
  public abstract void a(TRTCCloudDef.TRTCQuality paramTRTCQuality);
  
  public abstract void onConnectOtherRoom(String paramString1, int paramInt, String paramString2);
  
  public abstract void onDisConnectOtherRoom(int paramInt, String paramString);
  
  public abstract void onEnterRoom(long paramLong);
  
  public abstract void onError(int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void onExitRoom(int paramInt);
  
  public abstract void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onRemoteUserLeaveRoom(String paramString, int paramInt);
  
  public abstract void onStatistics(TRTCStatistics paramTRTCStatistics);
  
  public abstract void onUserAudioAvailable(String paramString, boolean paramBoolean);
  
  public abstract void onUserSubStreamAvailable(String paramString, boolean paramBoolean);
  
  public abstract void onUserVideoAvailable(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.d
 * JD-Core Version:    0.7.0.1
 */