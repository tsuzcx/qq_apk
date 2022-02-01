package com.tencent.live2.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.h;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayerStatistics;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveStatusChangeReason;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTexture;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXLivePlayVideoRenderListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePlayer.ITXVideoRawDataListener;
import com.tencent.rtmp.TXLivePlayer.TXLiteAVTexture;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Locale;

public class a
  extends V2TXLivePlayer
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, ITXLivePlayListener, TXLivePlayer.ITXAudioRawDataListener, TXLivePlayer.ITXAudioVolumeEvaluationListener, TXLivePlayer.ITXLivePlayVideoRenderListener, TXLivePlayer.ITXVideoRawDataListener
{
  private Context a;
  private V2TXLivePlayer b;
  private TXLivePlayer c;
  private TXLivePlayConfig d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private V2TXLiveDef.V2TXLivePlayerStatistics i;
  private V2TXLiveDef.V2TXLivePlayStatus j;
  private V2TXLiveDef.V2TXLivePlayStatus k;
  private boolean l;
  private V2TXLivePlayerObserver m;
  private boolean n;
  private TXCloudVideoView o;
  private TextureView p;
  private SurfaceView q;
  private int r;
  
  public a(V2TXLivePlayer paramV2TXLivePlayer, Context paramContext)
  {
    AppMethodBeat.i(214582);
    this.j = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
    this.k = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
    this.r = -1;
    this.a = paramContext.getApplicationContext();
    this.b = paramV2TXLivePlayer;
    this.i = new V2TXLiveDef.V2TXLivePlayerStatistics();
    this.c = new TXLivePlayer(this.a);
    this.c.setPlayListener(this);
    this.d = new TXLivePlayConfig();
    this.d.setConnectRetryInterval(3);
    this.d.setConnectRetryCount(3);
    this.c.setConfig(this.d);
    this.c.enableHardwareDecode(true);
    this.c.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(214582);
  }
  
  public static int a(String paramString)
  {
    AppMethodBeat.i(214651);
    if ((paramString.startsWith("rtmp://")) || (paramString.startsWith("room://")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(214651);
      return 0;
    }
    AppMethodBeat.o(214651);
    return -2;
  }
  
  private void a()
  {
    AppMethodBeat.i(214629);
    c("stopPlayInner: ");
    this.e = false;
    this.f = false;
    this.h = false;
    this.g = false;
    this.i = new V2TXLiveDef.V2TXLivePlayerStatistics();
    c();
    this.c.stopPlay(true);
    AppMethodBeat.o(214629);
  }
  
  private void a(V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason)
  {
    AppMethodBeat.i(214630);
    if (!b.a(this.j, paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason))
    {
      AppMethodBeat.o(214630);
      return;
    }
    this.j = paramV2TXLivePlayStatus;
    if (this.m != null) {
      this.m.onAudioPlayStatusUpdate(this.b, this.j, paramV2TXLiveStatusChangeReason, new Bundle());
    }
    AppMethodBeat.o(214630);
  }
  
  private int b(String paramString)
  {
    AppMethodBeat.i(214634);
    if (this.r != -1)
    {
      c("force set url type:" + this.r);
      int i1 = this.r;
      AppMethodBeat.o(214634);
      return i1;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(214634);
      return 1;
    }
    if (paramString.startsWith("rtmp"))
    {
      AppMethodBeat.o(214634);
      return 0;
    }
    AppMethodBeat.o(214634);
    return 1;
  }
  
  private void b()
  {
    AppMethodBeat.i(214636);
    TXCloudVideoView localTXCloudVideoView = this.o;
    Object localObject1 = this.p;
    Object localObject2 = this.q;
    if (localTXCloudVideoView != null)
    {
      c("bindRenderView: cloud view.");
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
      this.c.setPlayerView(localTXCloudVideoView);
      AppMethodBeat.o(214636);
      return;
    }
    if (localObject1 != null)
    {
      c("bindRenderView: texture view.");
      this.c.setPlayerView(null);
      localObject2 = ((TextureView)localObject1).getSurfaceTexture();
      ((TextureView)localObject1).setSurfaceTextureListener(this);
      if (localObject2 != null)
      {
        c("bindRenderView: surface texture is valid, set into player.");
        localObject2 = new Surface((SurfaceTexture)localObject2);
        this.c.setSurface((Surface)localObject2);
        this.c.setSurfaceSize(((TextureView)localObject1).getWidth(), ((TextureView)localObject1).getHeight());
      }
      AppMethodBeat.o(214636);
      return;
    }
    if (localObject2 != null)
    {
      c("bindRenderView: surface view.");
      this.c.setPlayerView(null);
      ((SurfaceView)localObject2).getHolder().addCallback(this);
      localObject1 = ((SurfaceView)localObject2).getHolder().getSurface();
      if (((Surface)localObject1).isValid())
      {
        c("bindRenderView: surface is valid, set into player.");
        this.c.setSurface((Surface)localObject1);
        this.c.setSurfaceSize(((SurfaceView)localObject2).getWidth(), ((SurfaceView)localObject2).getHeight());
      }
      AppMethodBeat.o(214636);
      return;
    }
    d("bindRender: all view is null, bind fail.");
    AppMethodBeat.o(214636);
  }
  
  private void b(V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason)
  {
    AppMethodBeat.i(214632);
    if (!b.a(this.k, paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason))
    {
      AppMethodBeat.o(214632);
      return;
    }
    this.k = paramV2TXLivePlayStatus;
    if (this.m != null) {
      this.m.onVideoPlayStatusUpdate(this.b, this.j, paramV2TXLiveStatusChangeReason, new Bundle());
    }
    AppMethodBeat.o(214632);
  }
  
  private void c()
  {
    AppMethodBeat.i(214637);
    Object localObject = this.p;
    if (localObject != null)
    {
      c("unbindRenderView: unbind texture view.");
      ((TextureView)localObject).setSurfaceTextureListener(null);
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
    }
    localObject = this.q;
    if (localObject != null)
    {
      c("unbindRenderView: unbind surface view.");
      ((SurfaceView)localObject).getHolder().removeCallback(this);
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
    }
    AppMethodBeat.o(214637);
  }
  
  private void c(String paramString)
  {
    AppMethodBeat.i(214647);
    TXCLog.i("V2-TXRTMPPlayerImpl", "v2_api_rtmp_player(" + this + ") " + paramString);
    AppMethodBeat.o(214647);
  }
  
  private void d(String paramString)
  {
    AppMethodBeat.i(214648);
    TXCLog.e("V2-TXRTMPPlayerImpl", "v2_api_rtmp_player(" + this + ") " + paramString);
    AppMethodBeat.o(214648);
  }
  
  private void e(String paramString)
  {
    AppMethodBeat.i(214649);
    TXCLog.w("V2-TXRTMPPlayerImpl", "v2_api_rtmp_player(" + this + ") " + paramString);
    AppMethodBeat.o(214649);
  }
  
  public int enableCustomRendering(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    AppMethodBeat.i(214611);
    c("setVideoFrameObserver: enable-" + paramBoolean + " format-" + paramV2TXLivePixelFormat + " type-" + paramV2TXLiveBufferType);
    if ((paramV2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420) && (paramV2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray))
    {
      c("setVideoFrameObserver: use I420 array render.");
      this.c.setVideoRenderListener(null, null);
      paramV2TXLiveBufferType = this.c;
      if (paramBoolean) {}
      for (paramV2TXLivePixelFormat = this;; paramV2TXLivePixelFormat = null)
      {
        paramV2TXLiveBufferType.setVideoRawDataListener(paramV2TXLivePixelFormat);
        AppMethodBeat.o(214611);
        return 0;
      }
    }
    if ((paramV2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D) && (paramV2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture))
    {
      c("setVideoFrameObserver: use texture render.");
      this.c.setVideoRawDataListener(null);
      paramV2TXLiveBufferType = this.c;
      if (paramBoolean) {}
      for (paramV2TXLivePixelFormat = this;; paramV2TXLivePixelFormat = null)
      {
        paramV2TXLiveBufferType.setVideoRenderListener(paramV2TXLivePixelFormat, null);
        AppMethodBeat.o(214611);
        return 0;
      }
    }
    this.c.setVideoRawDataListener(null);
    this.c.setVideoRenderListener(null, null);
    d("setVideoFrameObserver: format or type isn't support. force clean observer. format-" + paramV2TXLivePixelFormat + " type-" + paramV2TXLiveBufferType);
    AppMethodBeat.o(214611);
    return -4;
  }
  
  public int enableVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(214610);
    int i1 = paramInt;
    if (paramInt < 0)
    {
      e("enableVolumeEvaluation: invalid params.");
      i1 = 0;
    }
    this.c.enableAudioVolumeEvaluation(i1);
    AppMethodBeat.o(214610);
    return 0;
  }
  
  public int isPlaying()
  {
    if (this.g) {
      return 1;
    }
    return 0;
  }
  
  public void onAudioInfoChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(214621);
    c("onAudioInfoChanged: sampleRate-" + paramInt1 + " channels-" + paramInt2 + " bits-" + paramInt3);
    AppMethodBeat.o(214621);
  }
  
  public void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(214622);
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = this.m;
    if (localV2TXLivePlayerObserver != null) {
      localV2TXLivePlayerObserver.onPlayoutVolumeUpdate(this.b, paramInt);
    }
    AppMethodBeat.o(214622);
  }
  
  public void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(214628);
    try
    {
      localObject = h.a();
      if ((localObject != null) && (localObject.length == 2))
      {
        this.i.appCpu = (localObject[0] / 10);
        this.i.systemCpu = (localObject[1] / 10);
      }
      this.i.width = paramBundle.getInt("VIDEO_WIDTH");
      this.i.height = paramBundle.getInt("VIDEO_HEIGHT");
      this.i.fps = paramBundle.getInt("VIDEO_FPS");
      this.i.videoBitrate = paramBundle.getInt("VIDEO_BITRATE");
      this.i.audioBitrate = paramBundle.getInt("AUDIO_BITRATE");
    }
    catch (Exception localException)
    {
      Object localObject;
      label116:
      break label116;
    }
    localObject = this.m;
    if (localObject != null) {
      ((V2TXLivePlayerObserver)localObject).onStatisticsUpdate(this.b, this.i);
    }
    if ((localObject != null) && ((localObject instanceof com.tencent.live2.impl.a.a))) {
      ((com.tencent.live2.impl.a.a)localObject).onPlayNetStatus(paramBundle);
    }
    AppMethodBeat.o(214628);
  }
  
  public void onPcmDataAvailable(byte[] paramArrayOfByte, long paramLong) {}
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(214625);
    c("onPlayEvent event:" + paramInt + " param:" + paramBundle);
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = this.m;
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        if ((localV2TXLivePlayerObserver != null) && ((localV2TXLivePlayerObserver instanceof com.tencent.live2.impl.a.a))) {
          ((com.tencent.live2.impl.a.a)localV2TXLivePlayerObserver).onPlayEvent(paramInt, paramBundle);
        }
        AppMethodBeat.o(214625);
        return;
        if (this.h)
        {
          c("onPlayEvent: loading finish.");
          this.h = false;
          if (this.f) {
            a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingEnd);
          }
          if (this.e)
          {
            b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingEnd);
            continue;
            d("onPlayEvent: stop play because of disconnect.");
            a();
            a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
            b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
            continue;
            if (!this.h)
            {
              c("onPlayEvent: loading start.");
              this.h = true;
              if (this.f) {
                a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
              }
              if (this.e)
              {
                b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
                continue;
                if (!this.f)
                {
                  c("onPlayEvent: onRecvFirstAudioFrame.");
                  this.f = true;
                  a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
                  continue;
                  if (!this.e)
                  {
                    c("onPlayEvent: onRecvFirstVideoFrame.");
                    this.e = true;
                    b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
                  }
                }
              }
            }
          }
        }
      }
    } while (localV2TXLivePlayerObserver == null);
    V2TXLivePlayer localV2TXLivePlayer = this.b;
    if (paramBundle == null) {}
    for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
    {
      localV2TXLivePlayerObserver.onWarning(localV2TXLivePlayer, 2105, "player video block happen.", localBundle);
      break;
    }
  }
  
  public void onRenderVideoFrame(TXLivePlayer.TXLiteAVTexture paramTXLiteAVTexture)
  {
    AppMethodBeat.i(214616);
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = this.m;
    V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame;
    if ((localV2TXLivePlayerObserver != null) && (paramTXLiteAVTexture != null))
    {
      localV2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
      localV2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
      localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
      localV2TXLiveVideoFrame.width = paramTXLiteAVTexture.width;
      localV2TXLiveVideoFrame.height = paramTXLiteAVTexture.height;
      localV2TXLiveVideoFrame.rotation = 0;
      localV2TXLiveVideoFrame.texture = new V2TXLiveDef.V2TXLiveTexture();
      localV2TXLiveVideoFrame.texture.textureId = paramTXLiteAVTexture.textureId;
      if (!(paramTXLiteAVTexture.eglContext instanceof javax.microedition.khronos.egl.EGLContext)) {
        break label124;
      }
      localV2TXLiveVideoFrame.texture.eglContext10 = ((javax.microedition.khronos.egl.EGLContext)paramTXLiteAVTexture.eglContext);
    }
    for (;;)
    {
      localV2TXLivePlayerObserver.onRenderVideoFrame(this.b, localV2TXLiveVideoFrame);
      AppMethodBeat.o(214616);
      return;
      label124:
      if ((Build.VERSION.SDK_INT >= 17) && ((paramTXLiteAVTexture.eglContext instanceof android.opengl.EGLContext))) {
        localV2TXLiveVideoFrame.texture.eglContext14 = ((android.opengl.EGLContext)paramTXLiteAVTexture.eglContext);
      }
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214642);
    c("TextureView: available width-" + paramInt1 + " height-" + paramInt2);
    if (paramSurfaceTexture != null) {
      this.c.setSurface(new Surface(paramSurfaceTexture));
    }
    this.c.setSurfaceSize(paramInt1, paramInt2);
    AppMethodBeat.o(214642);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(214645);
    c("TextureView: destroyed.");
    this.c.setSurface(null);
    AppMethodBeat.o(214645);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214644);
    c("TextureView: size changed width-" + paramInt1 + " height-" + paramInt2);
    this.c.setSurfaceSize(paramInt1, paramInt2);
    AppMethodBeat.o(214644);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void onVideoRawDataAvailable(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(214618);
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = this.m;
    if (localV2TXLivePlayerObserver != null)
    {
      V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
      localV2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
      localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
      localV2TXLiveVideoFrame.data = paramArrayOfByte;
      localV2TXLiveVideoFrame.width = paramInt1;
      localV2TXLiveVideoFrame.height = paramInt2;
      localV2TXLiveVideoFrame.rotation = 0;
      localV2TXLivePlayerObserver.onRenderVideoFrame(this.b, localV2TXLiveVideoFrame);
    }
    AppMethodBeat.o(214618);
  }
  
  public int pauseAudio()
  {
    AppMethodBeat.i(214601);
    this.l = true;
    this.c.setMute(true);
    a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
    AppMethodBeat.o(214601);
    return 0;
  }
  
  public int pauseVideo()
  {
    AppMethodBeat.i(214605);
    if (this.o != null) {
      this.c.setPlayerView(null);
    }
    for (;;)
    {
      if (this.e)
      {
        b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
        if (this.h) {
          b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
        }
      }
      AppMethodBeat.o(214605);
      return 0;
      if ((this.q != null) || (this.p != null)) {
        this.c.setSurface(null);
      }
    }
  }
  
  public int resumeAudio()
  {
    AppMethodBeat.i(214603);
    this.l = false;
    this.c.setMute(false);
    if (this.f)
    {
      a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
      if (this.h) {
        a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
      }
    }
    AppMethodBeat.o(214603);
    return 0;
  }
  
  public int resumeVideo()
  {
    AppMethodBeat.i(214607);
    if (this.o != null) {
      this.c.setPlayerView(this.o);
    }
    for (;;)
    {
      b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
      AppMethodBeat.o(214607);
      return 0;
      Object localObject;
      if (this.p != null)
      {
        localObject = this.p.getSurfaceTexture();
        if (localObject != null) {
          this.c.setSurface(new Surface((SurfaceTexture)localObject));
        }
      }
      else if (this.q != null)
      {
        localObject = this.q.getHolder().getSurface();
        if (((Surface)localObject).isValid()) {
          this.c.setSurface((Surface)localObject);
        }
      }
    }
  }
  
  public int setCacheParams(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(214609);
    if (paramFloat1 > paramFloat2) {
      e("force fix error params. min:" + paramFloat2 + " max:" + paramFloat1);
    }
    for (;;)
    {
      this.d.setCacheTime(paramFloat1);
      this.d.setMaxAutoAdjustCacheTime(paramFloat1);
      this.d.setMinAutoAdjustCacheTime(paramFloat2);
      TXLivePlayConfig localTXLivePlayConfig = this.d;
      if (paramFloat2 != paramFloat1) {}
      for (boolean bool = true;; bool = false)
      {
        localTXLivePlayConfig.setAutoAdjustCacheTime(bool);
        AppMethodBeat.o(214609);
        return 0;
      }
      float f1 = paramFloat1;
      paramFloat1 = paramFloat2;
      paramFloat2 = f1;
    }
  }
  
  public void setObserver(V2TXLivePlayerObserver paramV2TXLivePlayerObserver)
  {
    this.m = paramV2TXLivePlayerObserver;
  }
  
  public int setPlayoutVolume(int paramInt)
  {
    AppMethodBeat.i(214608);
    this.c.setVolume(paramInt);
    AppMethodBeat.o(214608);
    return 0;
  }
  
  public int setProperty(String paramString, Object paramObject)
  {
    AppMethodBeat.i(214586);
    int i1 = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i1)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(214586);
      return 0;
      if (!paramString.equals("setSurface")) {
        break;
      }
      i1 = 0;
      break;
      if (!paramString.equals("setSurfaceSize")) {
        break;
      }
      i1 = 1;
      break;
      if (!paramString.equals("enableRecvSEIMessage")) {
        break;
      }
      i1 = 2;
      break;
      if (!paramString.equals("setPlayURLType")) {
        break;
      }
      i1 = 3;
      break;
      if (paramObject == null)
      {
        this.c.setSurface(null);
      }
      else if ((paramObject instanceof Surface))
      {
        this.c.setSurface((Surface)paramObject);
        continue;
        if ((paramObject != null) && ((paramObject instanceof a.a)))
        {
          paramString = (a.a)paramObject;
          this.c.setSurfaceSize(paramString.a, paramString.b);
          continue;
          if ((paramObject != null) && ((paramObject instanceof Boolean)))
          {
            this.d.setEnableMessage(((Boolean)paramObject).booleanValue());
            this.c.setConfig(this.d);
            continue;
            if ((paramObject != null) && ((paramObject instanceof Integer))) {
              this.r = ((Integer)paramObject).intValue();
            }
          }
        }
      }
    }
  }
  
  public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    AppMethodBeat.i(214597);
    V2TXLiveDef.V2TXLiveFillMode localV2TXLiveFillMode = paramV2TXLiveFillMode;
    if (paramV2TXLiveFillMode == null)
    {
      e("setRenderFillMode: param is null, fix it.");
      localV2TXLiveFillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill;
    }
    this.c.setRenderMode(b.a(localV2TXLiveFillMode));
    AppMethodBeat.o(214597);
    return 0;
  }
  
  public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    AppMethodBeat.i(214595);
    V2TXLiveDef.V2TXLiveRotation localV2TXLiveRotation = paramV2TXLiveRotation;
    if (paramV2TXLiveRotation == null)
    {
      e("setRenderRotation: param is null, fix it.");
      localV2TXLiveRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
    }
    this.c.setRenderRotation(b.a(localV2TXLiveRotation));
    AppMethodBeat.o(214595);
    return 0;
  }
  
  public int setRenderView(SurfaceView paramSurfaceView)
  {
    AppMethodBeat.i(214594);
    c();
    this.q = paramSurfaceView;
    b();
    AppMethodBeat.o(214594);
    return 0;
  }
  
  public int setRenderView(TextureView paramTextureView)
  {
    AppMethodBeat.i(214592);
    c();
    this.p = paramTextureView;
    b();
    AppMethodBeat.o(214592);
    return 0;
  }
  
  public int setRenderView(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(214590);
    c();
    if (paramTXCloudVideoView != null) {
      paramTXCloudVideoView.showLog(this.n);
    }
    this.o = paramTXCloudVideoView;
    b();
    AppMethodBeat.o(214590);
    return 0;
  }
  
  public void showDebugView(boolean paramBoolean)
  {
    AppMethodBeat.i(214613);
    this.n = paramBoolean;
    if (this.o != null) {
      this.o.showLog(paramBoolean);
    }
    AppMethodBeat.o(214613);
  }
  
  public int snapshot()
  {
    AppMethodBeat.i(214612);
    this.c.snapshot(new TXLivePlayer.ITXSnapshotListener()
    {
      public void onSnapshot(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(214422);
        V2TXLivePlayerObserver localV2TXLivePlayerObserver = a.a(a.this);
        if (localV2TXLivePlayerObserver != null) {
          localV2TXLivePlayerObserver.onSnapshotComplete(a.b(a.this), paramAnonymousBitmap);
        }
        AppMethodBeat.o(214422);
      }
    });
    AppMethodBeat.o(214612);
    return 0;
  }
  
  public int startPlay(String paramString)
  {
    AppMethodBeat.i(214599);
    int i1 = b(paramString);
    c("startPlay: url-" + paramString + " type-" + i1);
    c();
    b();
    this.e = false;
    this.f = false;
    this.j = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
    this.k = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
    this.h = false;
    this.g = true;
    this.c.setConfig(this.d);
    this.c.callExperimentalAPI(String.format(Locale.ENGLISH, "{\"api\":\"setInterfaceType\", \"params\": {\"type\":%d}}", new Object[] { Integer.valueOf(1) }));
    i1 = this.c.startPlay(paramString, i1);
    this.c.setMute(this.l);
    if (i1 != 0)
    {
      d("startPlay: play fail, force stop.");
      a();
    }
    AppMethodBeat.o(214599);
    return 0;
  }
  
  public int stopPlay()
  {
    AppMethodBeat.i(214600);
    c("stopPlay:");
    if (!this.g)
    {
      e("stopPlay: player have been stop.");
      AppMethodBeat.o(214600);
      return 0;
    }
    a();
    a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
    b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
    AppMethodBeat.o(214600);
    return 0;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(214640);
    c("SurfaceView: onSizeChanged.");
    this.c.setSurfaceSize(paramInt2, paramInt3);
    AppMethodBeat.o(214640);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(214639);
    c("SurfaceView: onCreate.");
    this.c.setSurface(paramSurfaceHolder.getSurface());
    AppMethodBeat.o(214639);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(214641);
    c("SurfaceView: onDestroyed.");
    this.c.setSurface(null);
    AppMethodBeat.o(214641);
  }
  
  public String toString()
  {
    AppMethodBeat.i(214650);
    String str = "@" + Integer.toHexString(hashCode());
    AppMethodBeat.o(214650);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.a.a
 * JD-Core Version:    0.7.0.1
 */