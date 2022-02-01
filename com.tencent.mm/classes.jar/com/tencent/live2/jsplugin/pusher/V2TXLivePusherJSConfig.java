package com.tencent.live2.jsplugin.pusher;

import android.os.Bundle;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceReverbType;
import com.tencent.liteav.device.TXDeviceManager.TXSystemVolumeType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveAudioQuality;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMirrorType;
import com.tencent.live2.impl.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class V2TXLivePusherJSConfig
{
  private static final TXAudioEffectManager.TXVoiceReverbType[] REVERB_TYPES = { TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
  public int aspect = 2;
  public V2TXLiveDef.V2TXLiveAudioQuality audioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
  public String backgroundImagePath = "";
  public int beautyLevel = 5;
  public int beautyStyle = 0;
  public boolean enableAGC = false;
  public boolean enableANS = false;
  public boolean enableAutoFocus = true;
  public boolean enableBGMEventCallback = false;
  public boolean enableCamera = true;
  public boolean enableDebugView = false;
  public boolean enableEarMonitor = false;
  public boolean enableMicrophone = true;
  public boolean enableRemoteMirror = false;
  public boolean enableZoom = false;
  public String filterImagePath;
  public int height = 640;
  public boolean isAutoPush = false;
  public boolean isFrontCamera = true;
  public boolean isMuteAudio = false;
  public boolean isVerticalOrientation = true;
  public int maxBitrate = 0;
  public int minBitrate = 0;
  public V2TXLiveDef.V2TXLiveMirrorType mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeAuto;
  public int mode = 1;
  public TXAudioEffectManager.TXVoiceReverbType reverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
  public String url = "";
  public int volumeNotifyIntervals = 0;
  public TXDeviceManager.TXSystemVolumeType volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
  public String watermarkImagePath = "";
  public float watermarkLeft = 0.0F;
  public float watermarkTop = 0.0F;
  public float watermarkWidth = 0.1F;
  public int whitenessLevel = 3;
  public int width = 368;
  
  public V2TXLivePusherJSConfig() {}
  
  public V2TXLivePusherJSConfig(V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig)
  {
    this.url = paramV2TXLivePusherJSConfig.url;
    this.mode = paramV2TXLivePusherJSConfig.mode;
    this.isAutoPush = paramV2TXLivePusherJSConfig.isAutoPush;
    this.enableBGMEventCallback = paramV2TXLivePusherJSConfig.enableBGMEventCallback;
    this.enableDebugView = paramV2TXLivePusherJSConfig.enableDebugView;
    this.enableCamera = paramV2TXLivePusherJSConfig.enableCamera;
    this.isFrontCamera = paramV2TXLivePusherJSConfig.isFrontCamera;
    this.enableAutoFocus = paramV2TXLivePusherJSConfig.enableAutoFocus;
    this.isVerticalOrientation = paramV2TXLivePusherJSConfig.isVerticalOrientation;
    this.enableZoom = paramV2TXLivePusherJSConfig.enableZoom;
    this.enableRemoteMirror = paramV2TXLivePusherJSConfig.enableRemoteMirror;
    this.aspect = paramV2TXLivePusherJSConfig.aspect;
    this.width = paramV2TXLivePusherJSConfig.width;
    this.height = paramV2TXLivePusherJSConfig.height;
    this.minBitrate = paramV2TXLivePusherJSConfig.minBitrate;
    this.maxBitrate = paramV2TXLivePusherJSConfig.maxBitrate;
    this.mirrorType = paramV2TXLivePusherJSConfig.mirrorType;
    this.enableMicrophone = paramV2TXLivePusherJSConfig.enableMicrophone;
    this.isMuteAudio = paramV2TXLivePusherJSConfig.isMuteAudio;
    this.enableAGC = paramV2TXLivePusherJSConfig.enableAGC;
    this.enableANS = paramV2TXLivePusherJSConfig.enableANS;
    this.enableEarMonitor = paramV2TXLivePusherJSConfig.enableEarMonitor;
    this.volumeNotifyIntervals = paramV2TXLivePusherJSConfig.volumeNotifyIntervals;
    this.volumeType = paramV2TXLivePusherJSConfig.volumeType;
    this.reverbType = paramV2TXLivePusherJSConfig.reverbType;
    this.audioQuality = paramV2TXLivePusherJSConfig.audioQuality;
    this.beautyStyle = paramV2TXLivePusherJSConfig.beautyStyle;
    this.beautyLevel = paramV2TXLivePusherJSConfig.beautyLevel;
    this.whitenessLevel = paramV2TXLivePusherJSConfig.whitenessLevel;
    this.filterImagePath = paramV2TXLivePusherJSConfig.filterImagePath;
    this.watermarkImagePath = paramV2TXLivePusherJSConfig.watermarkImagePath;
    this.watermarkTop = paramV2TXLivePusherJSConfig.watermarkTop;
    this.watermarkLeft = paramV2TXLivePusherJSConfig.watermarkLeft;
    this.watermarkWidth = paramV2TXLivePusherJSConfig.watermarkWidth;
    this.backgroundImagePath = paramV2TXLivePusherJSConfig.backgroundImagePath;
  }
  
  public String diffConfig(V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig)
  {
    AppMethodBeat.i(215349);
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.url != paramV2TXLivePusherJSConfig.url) {
      localStringBuilder.append("[url:" + b.b(this.url) + "]");
    }
    if (this.mode != paramV2TXLivePusherJSConfig.mode) {
      localStringBuilder.append("[mode:" + this.mode + "]");
    }
    if (this.enableCamera != paramV2TXLivePusherJSConfig.enableCamera) {
      localStringBuilder.append("[enableCamera:" + this.enableCamera + "]");
    }
    if (this.isFrontCamera != paramV2TXLivePusherJSConfig.isFrontCamera) {
      localStringBuilder.append("[isFrontCamera:" + this.isFrontCamera + "]");
    }
    if (this.isVerticalOrientation != paramV2TXLivePusherJSConfig.isVerticalOrientation) {
      localStringBuilder.append("[isVerticalOrientation:" + this.isVerticalOrientation + "]");
    }
    if (this.aspect != paramV2TXLivePusherJSConfig.aspect) {
      localStringBuilder.append("[aspect:" + this.aspect + "]");
    }
    if (this.width != paramV2TXLivePusherJSConfig.width) {
      localStringBuilder.append("[width:" + this.width + "]");
    }
    if (this.height != paramV2TXLivePusherJSConfig.height) {
      localStringBuilder.append("[height:" + this.height + "]");
    }
    if (this.minBitrate != paramV2TXLivePusherJSConfig.minBitrate) {
      localStringBuilder.append("[minBitrate:" + this.minBitrate + "]");
    }
    if (this.maxBitrate != paramV2TXLivePusherJSConfig.maxBitrate) {
      localStringBuilder.append("[maxBitrate:" + this.maxBitrate + "]");
    }
    if (this.enableMicrophone != paramV2TXLivePusherJSConfig.enableMicrophone) {
      localStringBuilder.append("[enableMicrophone:" + this.enableMicrophone + "]");
    }
    if (this.isMuteAudio != paramV2TXLivePusherJSConfig.isMuteAudio) {
      localStringBuilder.append("[isMuteAudio:" + this.isMuteAudio + "]");
    }
    if (this.enableAGC != paramV2TXLivePusherJSConfig.enableAGC) {
      localStringBuilder.append("[enableAGC:" + this.enableAGC + "]");
    }
    if (this.enableANS != paramV2TXLivePusherJSConfig.enableANS) {
      localStringBuilder.append("[enableANS:" + this.enableANS + "]");
    }
    if (this.enableEarMonitor != this.enableEarMonitor) {
      localStringBuilder.append("[enableEarMonitor:" + this.enableEarMonitor + "]");
    }
    if (this.volumeType != paramV2TXLivePusherJSConfig.volumeType) {
      localStringBuilder.append("[volumeType:" + this.volumeType + "]");
    }
    if (this.audioQuality != paramV2TXLivePusherJSConfig.audioQuality) {
      localStringBuilder.append("[audioQuality:" + this.audioQuality + "]");
    }
    paramV2TXLivePusherJSConfig = localStringBuilder.toString();
    AppMethodBeat.o(215349);
    return paramV2TXLivePusherJSConfig;
  }
  
  public String toString()
  {
    AppMethodBeat.i(215351);
    String str = "[url:" + b.b(this.url) + "][mode:" + this.mode + "][isAutoPush:" + this.isAutoPush + "][enableCamera:" + this.enableCamera + "][isVerticalOrientation:" + this.isVerticalOrientation + "][aspect:" + this.aspect + "][width:" + this.width + "][height:" + this.height + "][minBitrate:" + this.minBitrate + "][maxBitrate:" + this.maxBitrate + "][enableMicrophone:" + this.enableMicrophone + "][isMuteAudio:" + this.isMuteAudio + "][enableAGC:" + this.enableAGC + "][enableANS:" + this.enableANS + "][enableEarMonitor:" + this.enableEarMonitor + "][volumeType:" + this.volumeType + "][audioQuality:" + this.audioQuality + ']';
    AppMethodBeat.o(215351);
    return str;
  }
  
  public void updateFromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(215348);
    if (paramBundle.containsKey("pushUrl")) {
      this.url = paramBundle.getString("pushUrl", "");
    }
    if (paramBundle.containsKey("mode")) {
      this.mode = paramBundle.getInt("mode");
    }
    if (paramBundle.containsKey("autopush")) {
      this.isAutoPush = paramBundle.getBoolean("autopush");
    }
    if (paramBundle.containsKey("needBGMEvent")) {
      this.enableBGMEventCallback = paramBundle.getBoolean("needBGMEvent");
    }
    if (paramBundle.containsKey("debug")) {
      this.enableDebugView = paramBundle.getBoolean("debug");
    }
    if (paramBundle.containsKey("enableCamera")) {
      this.enableCamera = paramBundle.getBoolean("enableCamera");
    }
    boolean bool;
    label191:
    label226:
    String str;
    label452:
    int i;
    if (paramBundle.containsKey("devicePosition"))
    {
      if (!"back".equals(paramBundle.getString("devicePosition", "")))
      {
        bool = true;
        this.isFrontCamera = bool;
      }
    }
    else
    {
      if (paramBundle.containsKey("focusMode"))
      {
        if (paramBundle.getInt("focusMode") != 0) {
          break label1067;
        }
        bool = true;
        this.enableAutoFocus = bool;
      }
      if (paramBundle.containsKey("orientation"))
      {
        if ("horizontal".equals(paramBundle.getString("orientation", ""))) {
          break label1072;
        }
        bool = true;
        this.isVerticalOrientation = bool;
      }
      if (paramBundle.containsKey("zoom")) {
        this.enableZoom = paramBundle.getBoolean("zoom");
      }
      if (paramBundle.containsKey("mirror")) {
        this.enableRemoteMirror = paramBundle.getBoolean("mirror");
      }
      if (paramBundle.containsKey("remoteMirror")) {
        this.enableRemoteMirror = paramBundle.getBoolean("remoteMirror");
      }
      if (paramBundle.containsKey("aspect")) {
        this.aspect = paramBundle.getInt("aspect");
      }
      if (paramBundle.containsKey("videoWidth")) {
        this.width = paramBundle.getInt("videoWidth");
      }
      if (paramBundle.containsKey("videoHeight")) {
        this.height = paramBundle.getInt("videoHeight");
      }
      if (paramBundle.containsKey("minBitrate")) {
        this.minBitrate = paramBundle.getInt("minBitrate");
      }
      if (paramBundle.containsKey("maxBitrate")) {
        this.maxBitrate = paramBundle.getInt("maxBitrate");
      }
      if (paramBundle.containsKey("localMirror")) {
        str = paramBundle.getString("localMirror", "");
      }
      switch (str.hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        default: 
          label454:
          this.mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeAuto;
          label483:
          if (paramBundle.containsKey("muted")) {
            this.isMuteAudio = paramBundle.getBoolean("muted");
          }
          if (paramBundle.containsKey("enableMic")) {
            this.enableMicrophone = paramBundle.getBoolean("enableMic");
          }
          if (paramBundle.containsKey("audioQuality")) {
            str = paramBundle.getString("audioQuality", "");
          }
          switch (str.hashCode())
          {
          default: 
            label568:
            i = -1;
            switch (i)
            {
            default: 
              label570:
              this.audioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
              label595:
              if (paramBundle.containsKey("enableAGC")) {
                this.enableAGC = paramBundle.getBoolean("enableAGC");
              }
              if (paramBundle.containsKey("enableANS")) {
                this.enableANS = paramBundle.getBoolean("enableANS");
              }
              if (paramBundle.containsKey("enableEarMonitor")) {
                this.enableEarMonitor = paramBundle.getBoolean("enableEarMonitor");
              }
              if (paramBundle.containsKey("audioVolumeType")) {
                str = paramBundle.getString("audioVolumeType", "");
              }
              switch (str.hashCode())
              {
              default: 
                label712:
                i = -1;
                switch (i)
                {
                default: 
                  label714:
                  this.volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
                  label743:
                  if (paramBundle.containsKey("audioReverbType"))
                  {
                    i = paramBundle.getInt("audioReverbType");
                    if ((i >= 0) && (i < REVERB_TYPES.length)) {
                      this.reverbType = REVERB_TYPES[i];
                    }
                  }
                  if (paramBundle.containsKey("needAudioVolume"))
                  {
                    if (paramBundle.getBoolean("needAudioVolume"))
                    {
                      i = 300;
                      label806:
                      this.volumeNotifyIntervals = i;
                    }
                  }
                  else if (paramBundle.containsKey("beautyStyle"))
                  {
                    str = paramBundle.getString("beautyStyle", "");
                    switch (str.hashCode())
                    {
                    default: 
                      label856:
                      i = -1;
                      label858:
                      switch (i)
                      {
                      }
                      break;
                    }
                  }
                  break;
                }
                break;
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
    for (this.beautyStyle = 0;; this.beautyStyle = 1)
    {
      if (paramBundle.containsKey("beauty")) {
        this.beautyLevel = paramBundle.getInt("beauty");
      }
      if (paramBundle.containsKey("whiteness")) {
        this.whitenessLevel = paramBundle.getInt("whiteness");
      }
      if (paramBundle.containsKey("filterImage")) {
        this.filterImagePath = paramBundle.getString("filterImage", "");
      }
      if (paramBundle.containsKey("watermarkImage")) {
        this.watermarkImagePath = paramBundle.getString("watermarkImage", "");
      }
      if (paramBundle.containsKey("watermarkLeft")) {
        this.watermarkLeft = paramBundle.getFloat("watermarkLeft");
      }
      if (paramBundle.containsKey("watermarkTop")) {
        this.watermarkTop = paramBundle.getFloat("watermarkTop");
      }
      if (paramBundle.containsKey("watermarkWidth")) {
        this.watermarkWidth = paramBundle.getFloat("watermarkWidth");
      }
      if (paramBundle.containsKey("backgroundImage")) {
        this.backgroundImagePath = paramBundle.getString("backgroundImage", "");
      }
      AppMethodBeat.o(215348);
      return;
      bool = false;
      break;
      label1067:
      bool = false;
      break label191;
      label1072:
      bool = false;
      break label226;
      if (!str.equals("enable")) {
        break label452;
      }
      i = 0;
      break label454;
      if (!str.equals("disable")) {
        break label452;
      }
      i = 1;
      break label454;
      this.mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeEnable;
      break label483;
      this.mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeDisable;
      break label483;
      if (!str.equals("low")) {
        break label568;
      }
      i = 0;
      break label570;
      this.audioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualitySpeech;
      break label595;
      if (!str.equals("voicecall")) {
        break label712;
      }
      i = 0;
      break label714;
      if (!str.equals("media")) {
        break label712;
      }
      i = 1;
      break label714;
      this.volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP;
      break label743;
      this.volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia;
      break label743;
      i = 0;
      break label806;
      if (!str.equals("nature")) {
        break label856;
      }
      i = 0;
      break label858;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSConfig
 * JD-Core Version:    0.7.0.1
 */