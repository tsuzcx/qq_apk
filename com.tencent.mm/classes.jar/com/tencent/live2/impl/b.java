package com.tencent.live2.impl;

import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMixInputType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMixStream;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveStatusChangeReason;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTexture;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCMixUser;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import java.util.ArrayList;
import java.util.Iterator;

public class b
{
  public static int a(V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    int j = 0;
    AppMethodBeat.i(214720);
    if (paramV2TXLiveBufferType == null)
    {
      AppMethodBeat.o(214720);
      return 0;
    }
    int i = j;
    switch (1.d[paramV2TXLiveBufferType.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      AppMethodBeat.o(214720);
      return i;
      i = 3;
      continue;
      i = 2;
      continue;
      i = 1;
    }
  }
  
  public static int a(V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    int j = 0;
    AppMethodBeat.i(214710);
    if (paramV2TXLiveFillMode == null)
    {
      AppMethodBeat.o(214710);
      return 0;
    }
    int i = j;
    switch (1.b[paramV2TXLiveFillMode.ordinal()])
    {
    }
    for (i = j;; i = 1)
    {
      AppMethodBeat.o(214710);
      return i;
    }
  }
  
  public static int a(V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat)
  {
    int j = 0;
    AppMethodBeat.i(214718);
    if (paramV2TXLivePixelFormat == null)
    {
      AppMethodBeat.o(214718);
      return 0;
    }
    int i = j;
    switch (1.c[paramV2TXLivePixelFormat.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      AppMethodBeat.o(214718);
      return i;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public static int a(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    int j = 0;
    AppMethodBeat.i(214709);
    if (paramV2TXLiveRotation == null)
    {
      AppMethodBeat.o(214709);
      return 0;
    }
    int i = j;
    switch (1.a[paramV2TXLiveRotation.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      AppMethodBeat.o(214709);
      return i;
      i = 270;
      continue;
      i = 180;
      continue;
      i = 90;
    }
  }
  
  public static int a(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution)
  {
    int j = 1;
    AppMethodBeat.i(214723);
    int i = j;
    switch (1.f[paramV2TXLiveVideoResolution.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      AppMethodBeat.o(214723);
      return i;
      i = 19;
      continue;
      i = 18;
      continue;
      i = 17;
      continue;
      i = 11;
      continue;
      i = 12;
      continue;
      i = 13;
      continue;
      i = 7;
      continue;
      i = 8;
      continue;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 30;
    }
  }
  
  public static V2TXLiveDef.V2TXLiveMode a(String paramString)
  {
    AppMethodBeat.i(214708);
    if ((paramString.startsWith("trtc://")) || (paramString.startsWith("room://cloud.tencent.com/rtc")) || (paramString.startsWith("room://rtc.tencent.com")))
    {
      TXCLog.i("V2TXLiveUtils", "parseLiveMode: rtc.");
      paramString = V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
      AppMethodBeat.o(214708);
      return paramString;
    }
    TXCLog.i("V2TXLiveUtils", "parseLiveMode: rtmp.");
    paramString = V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP;
    AppMethodBeat.o(214708);
    return paramString;
  }
  
  public static V2TXLiveDef.V2TXLiveVideoFrame a(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(214717);
    if (paramTRTCVideoFrame == null)
    {
      AppMethodBeat.o(214717);
      return null;
    }
    V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
    switch (paramTRTCVideoFrame.pixelFormat)
    {
    default: 
      switch (paramTRTCVideoFrame.bufferType)
      {
      }
      break;
    }
    for (;;)
    {
      localV2TXLiveVideoFrame.width = paramTRTCVideoFrame.width;
      localV2TXLiveVideoFrame.height = paramTRTCVideoFrame.height;
      localV2TXLiveVideoFrame.rotation = paramTRTCVideoFrame.rotation;
      localV2TXLiveVideoFrame.data = paramTRTCVideoFrame.data;
      localV2TXLiveVideoFrame.buffer = paramTRTCVideoFrame.buffer;
      if (paramTRTCVideoFrame.texture != null)
      {
        localV2TXLiveVideoFrame.texture = new V2TXLiveDef.V2TXLiveTexture();
        localV2TXLiveVideoFrame.texture.eglContext10 = paramTRTCVideoFrame.texture.eglContext10;
        localV2TXLiveVideoFrame.texture.eglContext14 = paramTRTCVideoFrame.texture.eglContext14;
        localV2TXLiveVideoFrame.texture.textureId = paramTRTCVideoFrame.texture.textureId;
      }
      AppMethodBeat.o(214717);
      return localV2TXLiveVideoFrame;
      localV2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatUnknown;
      break;
      localV2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
      break;
      localV2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
      break;
      localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeUnknown;
      continue;
      localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
      continue;
      localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
      continue;
      localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer;
    }
  }
  
  public static b a(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    AppMethodBeat.i(214724);
    b localb = new b(544, 960);
    switch (1.f[paramV2TXLiveVideoResolution.ordinal()])
    {
    default: 
      paramV2TXLiveVideoResolution = localb;
    }
    for (;;)
    {
      AppMethodBeat.o(214724);
      return paramV2TXLiveVideoResolution;
      paramV2TXLiveVideoResolution = new b(160, 160);
      continue;
      paramV2TXLiveVideoResolution = new b(270, 270);
      continue;
      paramV2TXLiveVideoResolution = new b(480, 480);
      continue;
      if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait)
      {
        paramV2TXLiveVideoResolution = new b(240, 320);
      }
      else
      {
        paramV2TXLiveVideoResolution = new b(320, 240);
        continue;
        if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait)
        {
          paramV2TXLiveVideoResolution = new b(368, 480);
        }
        else
        {
          paramV2TXLiveVideoResolution = new b(480, 368);
          continue;
          if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait)
          {
            paramV2TXLiveVideoResolution = new b(480, 640);
          }
          else
          {
            paramV2TXLiveVideoResolution = new b(640, 480);
            continue;
            if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait)
            {
              paramV2TXLiveVideoResolution = new b(192, 320);
            }
            else
            {
              paramV2TXLiveVideoResolution = new b(320, 192);
              continue;
              if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait)
              {
                paramV2TXLiveVideoResolution = new b(272, 480);
              }
              else
              {
                paramV2TXLiveVideoResolution = new b(480, 272);
                continue;
                if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait)
                {
                  paramV2TXLiveVideoResolution = new b(368, 640);
                }
                else
                {
                  paramV2TXLiveVideoResolution = new b(640, 368);
                  continue;
                  if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait)
                  {
                    paramV2TXLiveVideoResolution = new b(544, 960);
                  }
                  else
                  {
                    paramV2TXLiveVideoResolution = new b(960, 544);
                    continue;
                    if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait)
                    {
                      paramV2TXLiveVideoResolution = new b(720, 1280);
                    }
                    else
                    {
                      paramV2TXLiveVideoResolution = new b(1280, 720);
                      continue;
                      if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait) {
                        paramV2TXLiveVideoResolution = new b(1088, 1920);
                      } else {
                        paramV2TXLiveVideoResolution = new b(1920, 1088);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static TRTCCloudDef.TRTCTranscodingConfig a(V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    AppMethodBeat.i(214722);
    if (paramV2TXLiveTranscodingConfig == null)
    {
      AppMethodBeat.o(214722);
      return null;
    }
    TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
    localTRTCTranscodingConfig.videoWidth = paramV2TXLiveTranscodingConfig.videoWidth;
    localTRTCTranscodingConfig.videoHeight = paramV2TXLiveTranscodingConfig.videoHeight;
    localTRTCTranscodingConfig.videoBitrate = paramV2TXLiveTranscodingConfig.videoBitrate;
    localTRTCTranscodingConfig.videoFramerate = paramV2TXLiveTranscodingConfig.videoFramerate;
    localTRTCTranscodingConfig.videoGOP = paramV2TXLiveTranscodingConfig.videoGOP;
    localTRTCTranscodingConfig.backgroundColor = paramV2TXLiveTranscodingConfig.backgroundColor;
    localTRTCTranscodingConfig.backgroundImage = paramV2TXLiveTranscodingConfig.backgroundImage;
    localTRTCTranscodingConfig.audioSampleRate = paramV2TXLiveTranscodingConfig.audioSampleRate;
    localTRTCTranscodingConfig.audioBitrate = paramV2TXLiveTranscodingConfig.audioBitrate;
    localTRTCTranscodingConfig.audioChannels = paramV2TXLiveTranscodingConfig.audioChannels;
    localTRTCTranscodingConfig.streamId = paramV2TXLiveTranscodingConfig.outputStreamId;
    if (paramV2TXLiveTranscodingConfig.mixStreams != null)
    {
      localTRTCTranscodingConfig.mixUsers = new ArrayList();
      paramV2TXLiveTranscodingConfig = paramV2TXLiveTranscodingConfig.mixStreams.iterator();
      while (paramV2TXLiveTranscodingConfig.hasNext())
      {
        V2TXLiveDef.V2TXLiveMixStream localV2TXLiveMixStream = (V2TXLiveDef.V2TXLiveMixStream)paramV2TXLiveTranscodingConfig.next();
        if (localV2TXLiveMixStream != null)
        {
          TRTCCloudDef.TRTCMixUser localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
          localTRTCMixUser.userId = localV2TXLiveMixStream.userId;
          localTRTCMixUser.roomId = localV2TXLiveMixStream.streamId;
          localTRTCMixUser.x = localV2TXLiveMixStream.x;
          localTRTCMixUser.y = localV2TXLiveMixStream.y;
          localTRTCMixUser.width = localV2TXLiveMixStream.width;
          localTRTCMixUser.height = localV2TXLiveMixStream.height;
          localTRTCMixUser.zOrder = localV2TXLiveMixStream.zOrder;
          if (localV2TXLiveMixStream.inputType != null) {
            switch (1.e[localV2TXLiveMixStream.inputType.ordinal()])
            {
            default: 
              localTRTCMixUser.inputType = 1;
            }
          }
          for (;;)
          {
            localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser);
            break;
            localTRTCMixUser.inputType = 1;
            continue;
            localTRTCMixUser.inputType = 2;
            continue;
            localTRTCMixUser.inputType = 3;
          }
        }
      }
    }
    AppMethodBeat.o(214722);
    return localTRTCTranscodingConfig;
  }
  
  public static TRTCCloudDef.TRTCVideoFrame a(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame)
  {
    AppMethodBeat.i(214715);
    if (paramV2TXLiveVideoFrame == null)
    {
      AppMethodBeat.o(214715);
      return null;
    }
    TRTCCloudDef.TRTCVideoFrame localTRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
    switch (1.c[paramV2TXLiveVideoFrame.pixelFormat.ordinal()])
    {
    default: 
      switch (1.d[paramV2TXLiveVideoFrame.bufferType.ordinal()])
      {
      }
      break;
    }
    for (;;)
    {
      if (paramV2TXLiveVideoFrame.texture != null)
      {
        localTRTCVideoFrame.texture = new TRTCCloudDef.TRTCTexture();
        localTRTCVideoFrame.texture.eglContext10 = paramV2TXLiveVideoFrame.texture.eglContext10;
        localTRTCVideoFrame.texture.eglContext14 = paramV2TXLiveVideoFrame.texture.eglContext14;
        localTRTCVideoFrame.texture.textureId = paramV2TXLiveVideoFrame.texture.textureId;
      }
      localTRTCVideoFrame.data = paramV2TXLiveVideoFrame.data;
      localTRTCVideoFrame.buffer = paramV2TXLiveVideoFrame.buffer;
      localTRTCVideoFrame.width = paramV2TXLiveVideoFrame.width;
      localTRTCVideoFrame.height = paramV2TXLiveVideoFrame.height;
      localTRTCVideoFrame.rotation = paramV2TXLiveVideoFrame.rotation;
      AppMethodBeat.o(214715);
      return localTRTCVideoFrame;
      localTRTCVideoFrame.pixelFormat = 0;
      break;
      localTRTCVideoFrame.pixelFormat = 1;
      break;
      localTRTCVideoFrame.pixelFormat = 2;
      break;
      localTRTCVideoFrame.bufferType = 0;
      continue;
      localTRTCVideoFrame.bufferType = 3;
      continue;
      localTRTCVideoFrame.bufferType = 2;
      continue;
      localTRTCVideoFrame.bufferType = 1;
    }
  }
  
  public static void a(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(214716);
    switch (1.c[paramV2TXLiveVideoFrame.pixelFormat.ordinal()])
    {
    default: 
      switch (1.d[paramV2TXLiveVideoFrame.bufferType.ordinal()])
      {
      }
      break;
    }
    for (;;)
    {
      if ((paramV2TXLiveVideoFrame.texture != null) && (paramTRTCVideoFrame.texture != null))
      {
        paramTRTCVideoFrame.texture.eglContext10 = paramV2TXLiveVideoFrame.texture.eglContext10;
        paramTRTCVideoFrame.texture.eglContext14 = paramV2TXLiveVideoFrame.texture.eglContext14;
        paramTRTCVideoFrame.texture.textureId = paramV2TXLiveVideoFrame.texture.textureId;
      }
      paramTRTCVideoFrame.data = paramV2TXLiveVideoFrame.data;
      paramTRTCVideoFrame.buffer = paramV2TXLiveVideoFrame.buffer;
      paramTRTCVideoFrame.width = paramV2TXLiveVideoFrame.width;
      paramTRTCVideoFrame.height = paramV2TXLiveVideoFrame.height;
      paramTRTCVideoFrame.rotation = paramV2TXLiveVideoFrame.rotation;
      AppMethodBeat.o(214716);
      return;
      paramTRTCVideoFrame.pixelFormat = 0;
      break;
      paramTRTCVideoFrame.pixelFormat = 1;
      break;
      paramTRTCVideoFrame.pixelFormat = 2;
      break;
      paramTRTCVideoFrame.bufferType = 0;
      continue;
      paramTRTCVideoFrame.bufferType = 3;
      continue;
      paramTRTCVideoFrame.bufferType = 2;
      continue;
      paramTRTCVideoFrame.bufferType = 1;
    }
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 12: 
    case 13: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    default: 
      return true;
    }
    return false;
  }
  
  public static boolean a(V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus1, V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus2, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason)
  {
    AppMethodBeat.i(214729);
    boolean bool2 = false;
    boolean bool1;
    switch (1.g[paramV2TXLivePlayStatus1.ordinal()])
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (!bool1) {
        TXCLog.e("V2TXLiveUtils", "play state invalid.[current:" + paramV2TXLivePlayStatus1 + "][next:" + paramV2TXLivePlayStatus2 + "][reason:" + paramV2TXLiveStatusChangeReason + "]");
      }
      AppMethodBeat.o(214729);
      return bool1;
      if ((paramV2TXLivePlayStatus2 != V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading) || (paramV2TXLiveStatusChangeReason != V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin))
      {
        bool1 = bool2;
        if (paramV2TXLivePlayStatus2 != V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped) {
          continue;
        }
        if (paramV2TXLiveStatusChangeReason != V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped)
        {
          bool1 = bool2;
          if (paramV2TXLiveStatusChangeReason != V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped) {
            continue;
          }
        }
        bool1 = true;
        continue;
        if ((paramV2TXLivePlayStatus2 != V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying) || (paramV2TXLiveStatusChangeReason != V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingEnd))
        {
          bool1 = bool2;
          if (paramV2TXLivePlayStatus2 != V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped) {
            continue;
          }
          if (paramV2TXLiveStatusChangeReason != V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped)
          {
            bool1 = bool2;
            if (paramV2TXLiveStatusChangeReason != V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped) {
              continue;
            }
          }
          bool1 = true;
          continue;
          bool1 = bool2;
          if (paramV2TXLivePlayStatus2 != V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying) {
            continue;
          }
          if (paramV2TXLiveStatusChangeReason != V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted)
          {
            bool1 = bool2;
            if (paramV2TXLiveStatusChangeReason != V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStarted) {
              continue;
            }
          }
        }
      }
      bool1 = true;
    }
  }
  
  public static int b(V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    int j = 0;
    AppMethodBeat.i(214713);
    if (paramV2TXLiveFillMode == null)
    {
      AppMethodBeat.o(214713);
      return 0;
    }
    int i = j;
    switch (1.b[paramV2TXLiveFillMode.ordinal()])
    {
    }
    for (i = j;; i = 1)
    {
      AppMethodBeat.o(214713);
      return i;
    }
  }
  
  public static int b(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    int j = 0;
    AppMethodBeat.i(214712);
    if (paramV2TXLiveRotation == null)
    {
      AppMethodBeat.o(214712);
      return 0;
    }
    int i = j;
    switch (1.a[paramV2TXLiveRotation.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      AppMethodBeat.o(214712);
      return i;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public static a b(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution)
  {
    int j = 350;
    AppMethodBeat.i(214725);
    int i = 1500;
    switch (1.f[paramV2TXLiveVideoResolution.ordinal()])
    {
    default: 
      j = 800;
    }
    for (;;)
    {
      paramV2TXLiveVideoResolution = new a(j, i);
      AppMethodBeat.o(214725);
      return paramV2TXLiveVideoResolution;
      i = 150;
      j = 100;
      continue;
      i = 300;
      j = 200;
      continue;
      i = 525;
      continue;
      i = 375;
      j = 250;
      continue;
      i = 600;
      j = 400;
      continue;
      i = 900;
      j = 600;
      continue;
      i = 400;
      j = 250;
      continue;
      i = 550;
      continue;
      i = 900;
      j = 500;
      continue;
      i = 1500;
      j = 800;
      continue;
      i = 1800;
      j = 1000;
      continue;
      i = 3000;
      j = 2500;
    }
  }
  
  public static String b(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(214726);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(214726);
      return paramString;
    }
    label148:
    label161:
    label175:
    for (;;)
    {
      try
      {
        String[] arrayOfString = new String[3];
        arrayOfString[0] = "roomsig";
        arrayOfString[1] = "privatemapkey";
        arrayOfString[2] = "usersig";
        String str1 = paramString;
        if (i >= 3) {
          break label161;
        }
        str1 = paramString;
        int j;
        int k;
        TXCLog.e("V2TXLiveUtils", "remove url sensitive info failed.", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          if (!paramString.contains(arrayOfString[i])) {
            break label175;
          }
          j = paramString.indexOf(arrayOfString[i]);
          str1 = paramString;
          if (j == -1) {
            break label175;
          }
          k = paramString.indexOf("&", j);
          if (k == -1) {
            str1 = paramString.substring(0, j);
          } else {
            str1 = paramString.substring(0, j) + paramString.substring(k);
          }
        }
        catch (Exception localException2)
        {
          String str2;
          break label148;
          i += 1;
          paramString = localException2;
        }
        localException1 = localException1;
      }
      str2 = paramString;
      AppMethodBeat.o(214726);
      return str2;
    }
  }
  
  public static class a
  {
    public int a;
    public int b;
    
    public a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
  
  public static class b
  {
    public int a;
    public int b;
    
    public b(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.b
 * JD-Core Version:    0.7.0.1
 */