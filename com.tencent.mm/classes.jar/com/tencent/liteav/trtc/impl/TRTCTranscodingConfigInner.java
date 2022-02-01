package com.tencent.liteav.trtc.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCMixUser;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import java.util.ArrayList;
import java.util.Iterator;

public class TRTCTranscodingConfigInner
  extends TRTCCloudDef.TRTCTranscodingConfig
{
  public String backgroundURL;
  public String mixExtraInfo;
  
  public TRTCTranscodingConfigInner()
  {
    this.backgroundURL = "";
    this.mixExtraInfo = "";
  }
  
  public TRTCTranscodingConfigInner(TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig)
  {
    AppMethodBeat.i(222390);
    this.appId = paramTRTCTranscodingConfig.appId;
    this.bizId = paramTRTCTranscodingConfig.bizId;
    this.mode = paramTRTCTranscodingConfig.mode;
    this.videoWidth = paramTRTCTranscodingConfig.videoWidth;
    this.videoHeight = paramTRTCTranscodingConfig.videoHeight;
    this.videoBitrate = paramTRTCTranscodingConfig.videoBitrate;
    this.videoFramerate = paramTRTCTranscodingConfig.videoFramerate;
    this.videoGOP = paramTRTCTranscodingConfig.videoGOP;
    this.backgroundColor = paramTRTCTranscodingConfig.backgroundColor;
    this.backgroundImage = paramTRTCTranscodingConfig.backgroundImage;
    this.audioSampleRate = paramTRTCTranscodingConfig.audioSampleRate;
    this.audioBitrate = paramTRTCTranscodingConfig.audioBitrate;
    this.audioChannels = paramTRTCTranscodingConfig.audioChannels;
    this.streamId = paramTRTCTranscodingConfig.streamId;
    this.backgroundURL = "";
    this.mixExtraInfo = "";
    this.mixUsers = new ArrayList();
    if (paramTRTCTranscodingConfig.mixUsers != null)
    {
      paramTRTCTranscodingConfig = paramTRTCTranscodingConfig.mixUsers.iterator();
      while (paramTRTCTranscodingConfig.hasNext())
      {
        TRTCCloudDef.TRTCMixUser localTRTCMixUser = (TRTCCloudDef.TRTCMixUser)paramTRTCTranscodingConfig.next();
        if (localTRTCMixUser != null) {
          this.mixUsers.add(new TRTCMixUserInner(localTRTCMixUser));
        }
      }
    }
    AppMethodBeat.o(222390);
  }
  
  public String toString()
  {
    AppMethodBeat.i(222391);
    String str = "backgroundURL=" + this.backgroundURL + ", mixExtraInfo=" + this.mixExtraInfo + ", " + super.toString();
    AppMethodBeat.o(222391);
    return str;
  }
  
  public static class TRTCMixUserInner
    extends TRTCCloudDef.TRTCMixUser
  {
    public String streamId = "";
    
    public TRTCMixUserInner() {}
    
    public TRTCMixUserInner(TRTCCloudDef.TRTCMixUser paramTRTCMixUser)
    {
      super();
    }
    
    public TRTCMixUserInner(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public String toString()
    {
      AppMethodBeat.i(222397);
      String str = super.toString() + ", streamId=" + this.streamId;
      AppMethodBeat.o(222397);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCTranscodingConfigInner
 * JD-Core Version:    0.7.0.1
 */