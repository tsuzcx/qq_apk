package com.tencent.live2.jsplugin.player;

import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.impl.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class V2TXLivePlayerJSConfig
{
  public static int sAudioRoute = 0;
  public int audioRoute = 0;
  public boolean enableDebugView;
  public boolean enableRecvSEIMessage;
  public V2TXLiveDef.V2TXLiveFillMode fillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill;
  public boolean isAutoPlay;
  public boolean isCanAutoPlay = true;
  public boolean isMuteAudio;
  public boolean isMuteVideo;
  public float maxCache = 3.0F;
  public float minCache = 1.0F;
  public int mode = 1;
  public V2TXLiveDef.V2TXLiveRotation renderRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
  public String url = "";
  public int volumeNotifyIntervals;
  
  public V2TXLivePlayerJSConfig() {}
  
  public V2TXLivePlayerJSConfig(V2TXLivePlayerJSConfig paramV2TXLivePlayerJSConfig)
  {
    this.url = paramV2TXLivePlayerJSConfig.url;
    this.mode = paramV2TXLivePlayerJSConfig.mode;
    this.isAutoPlay = paramV2TXLivePlayerJSConfig.isAutoPlay;
    this.isCanAutoPlay = paramV2TXLivePlayerJSConfig.isCanAutoPlay;
    this.isMuteAudio = paramV2TXLivePlayerJSConfig.isMuteAudio;
    this.isMuteVideo = paramV2TXLivePlayerJSConfig.isMuteVideo;
    this.enableDebugView = paramV2TXLivePlayerJSConfig.enableDebugView;
    this.enableRecvSEIMessage = paramV2TXLivePlayerJSConfig.enableRecvSEIMessage;
    this.minCache = paramV2TXLivePlayerJSConfig.minCache;
    this.maxCache = paramV2TXLivePlayerJSConfig.maxCache;
    this.volumeNotifyIntervals = paramV2TXLivePlayerJSConfig.volumeNotifyIntervals;
    this.audioRoute = paramV2TXLivePlayerJSConfig.audioRoute;
    this.fillMode = paramV2TXLivePlayerJSConfig.fillMode;
    this.renderRotation = paramV2TXLivePlayerJSConfig.renderRotation;
  }
  
  public String diffConfig(V2TXLivePlayerJSConfig paramV2TXLivePlayerJSConfig)
  {
    AppMethodBeat.i(211362);
    StringBuilder localStringBuilder1 = new StringBuilder();
    if ((this.url != null) && (!this.url.equals(paramV2TXLivePlayerJSConfig.url))) {
      localStringBuilder1.append("[url:").append(b.b(this.url)).append("]");
    }
    if (this.mode != paramV2TXLivePlayerJSConfig.mode) {
      localStringBuilder1.append("[mode:").append(this.mode).append("]");
    }
    if (this.isCanAutoPlay != paramV2TXLivePlayerJSConfig.isCanAutoPlay) {
      localStringBuilder1.append("[isCanAutoPlay:").append(this.isCanAutoPlay).append("]");
    }
    if (this.isAutoPlay != paramV2TXLivePlayerJSConfig.isAutoPlay) {
      localStringBuilder1.append("[isAutoPlay:").append(this.isAutoPlay).append("]");
    }
    if (this.isMuteVideo != paramV2TXLivePlayerJSConfig.isMuteVideo) {
      localStringBuilder1.append("[isMuteVideo:").append(this.isMuteVideo).append("]");
    }
    if (this.isMuteAudio != paramV2TXLivePlayerJSConfig.isMuteAudio) {
      localStringBuilder1.append("[isMuteAudio:").append(this.isMuteAudio).append("]");
    }
    if (this.enableRecvSEIMessage != paramV2TXLivePlayerJSConfig.enableRecvSEIMessage) {
      localStringBuilder1.append("[enableRecvSEIMessage:").append(this.enableRecvSEIMessage).append("]");
    }
    if (this.minCache != paramV2TXLivePlayerJSConfig.minCache) {
      localStringBuilder1.append("[minCache:").append(this.minCache).append("]");
    }
    if (this.maxCache != paramV2TXLivePlayerJSConfig.maxCache) {
      localStringBuilder1.append("[macCache:").append(this.maxCache).append("]");
    }
    StringBuilder localStringBuilder2;
    if (this.audioRoute != paramV2TXLivePlayerJSConfig.audioRoute)
    {
      localStringBuilder2 = localStringBuilder1.append("[audioRoute:");
      if (this.audioRoute != 0) {
        break label441;
      }
    }
    label441:
    for (String str = "speaker";; str = "ear")
    {
      localStringBuilder2.append(str).append("]");
      if (this.volumeNotifyIntervals != paramV2TXLivePlayerJSConfig.volumeNotifyIntervals) {
        localStringBuilder1.append("[volumeNotifyIntervals:").append(this.volumeNotifyIntervals).append("]");
      }
      if (this.fillMode != paramV2TXLivePlayerJSConfig.fillMode) {
        localStringBuilder1.append("[fillMode:").append(this.fillMode).append("]");
      }
      if (this.renderRotation != paramV2TXLivePlayerJSConfig.renderRotation) {
        localStringBuilder1.append("[renderRotation:").append(this.renderRotation).append("]");
      }
      paramV2TXLivePlayerJSConfig = localStringBuilder1.toString();
      AppMethodBeat.o(211362);
      return paramV2TXLivePlayerJSConfig;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(211377);
    StringBuilder localStringBuilder = new StringBuilder("[url:").append(b.b(this.url)).append("][mode:").append(this.mode).append("][isAutoPlay:").append(this.isAutoPlay).append("][isCanAutoPlay:").append(this.isCanAutoPlay).append("][isMuteVideo:").append(this.isMuteVideo).append("][isMuteAudio:").append(this.isMuteAudio).append("][enableDebugView:").append(this.enableDebugView).append("][enableRecvSEIMessage:").append(this.enableRecvSEIMessage).append("][minCache:").append(this.minCache).append("][maxCache:").append(this.maxCache).append("][volumeNotifyIntervals:").append(this.volumeNotifyIntervals).append("][audioRoute:");
    if (this.audioRoute == 0) {}
    for (String str = "speaker";; str = "ear")
    {
      str = str + "][fillMode:" + this.fillMode + "][renderRotation:" + this.renderRotation + ']';
      AppMethodBeat.o(211377);
      return str;
    }
  }
  
  public void updateFromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(211369);
    if (paramBundle.containsKey("playUrl")) {
      this.url = paramBundle.getString("playUrl", "");
    }
    if (paramBundle.containsKey("mode")) {
      this.mode = paramBundle.getInt("mode");
    }
    if (paramBundle.containsKey("autoplay")) {
      this.isAutoPlay = paramBundle.getBoolean("autoplay");
    }
    if (paramBundle.containsKey("canStartPlay")) {
      this.isCanAutoPlay = paramBundle.getBoolean("canStartPlay");
    }
    if (paramBundle.containsKey("muteVideo")) {
      this.isMuteVideo = paramBundle.getBoolean("muteVideo");
    }
    if (paramBundle.containsKey("muteAudio")) {
      this.isMuteAudio = paramBundle.getBoolean("muteAudio");
    }
    if (paramBundle.containsKey("muted")) {
      this.isMuteAudio = paramBundle.getBoolean("muted");
    }
    String str;
    label208:
    int i;
    if (paramBundle.containsKey("orientation"))
    {
      str = paramBundle.getString("orientation", "");
      if (str.equalsIgnoreCase("horizontal")) {
        this.renderRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation270;
      }
    }
    else
    {
      if (paramBundle.containsKey("objectFit"))
      {
        str = paramBundle.getString("objectFit", "");
        if (!str.equalsIgnoreCase("fillCrop")) {
          break label375;
        }
        this.fillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill;
      }
      if (paramBundle.containsKey("minCache")) {
        this.minCache = paramBundle.getFloat("minCache");
      }
      if (paramBundle.containsKey("maxCache")) {
        this.maxCache = paramBundle.getFloat("maxCache");
      }
      if (paramBundle.containsKey("enableRecvMessage")) {
        this.enableRecvSEIMessage = paramBundle.getBoolean("enableRecvMessage");
      }
      if (paramBundle.containsKey("needAudioVolume"))
      {
        if (!paramBundle.getBoolean("needAudioVolume")) {
          break label394;
        }
        i = 300;
        label287:
        this.volumeNotifyIntervals = i;
      }
      if (paramBundle.containsKey("debug")) {
        this.enableDebugView = paramBundle.getBoolean("debug");
      }
      if (paramBundle.containsKey("soundMode"))
      {
        paramBundle = paramBundle.getString("soundMode", "");
        if (!paramBundle.equalsIgnoreCase("speaker")) {
          break label399;
        }
        this.audioRoute = 0;
      }
    }
    for (;;)
    {
      sAudioRoute = this.audioRoute;
      AppMethodBeat.o(211369);
      return;
      if (!str.equalsIgnoreCase("vertical")) {
        break;
      }
      this.renderRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
      break;
      label375:
      if (!str.equalsIgnoreCase("contain")) {
        break label208;
      }
      this.fillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFit;
      break label208;
      label394:
      i = 0;
      break label287;
      label399:
      if (paramBundle.equalsIgnoreCase("ear")) {
        this.audioRoute = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.jsplugin.player.V2TXLivePlayerJSConfig
 * JD-Core Version:    0.7.0.1
 */