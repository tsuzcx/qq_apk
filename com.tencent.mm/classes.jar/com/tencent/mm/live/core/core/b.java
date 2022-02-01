package com.tencent.mm.live.core.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.TextureView;
import android.view.View;
import com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver;
import com.tencent.mm.live.core.b.a;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.view.LivePreviewView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/IMMLiveCore;", "", "applyLiveMiniState", "", "applyState", "", "callLiveExperimentalAPI", "jsStr", "", "enableAudioVolumeEvaluation", "interval", "enableCustomAudioCapture", "enable", "", "enableMicExternalAudioFrame", "enablePublish", "enablePlayout", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "exitRoom", "fillMiniView", "miniView", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "floatMode", "context", "Landroid/content/Context;", "forceMoveTask", "dontFinish", "generateType", "opType", "muteVideoImage", "Landroid/graphics/Bitmap;", "getAudioCaptureVolume", "getBgMusicId", "()Ljava/lang/Integer;", "getLiveConfigInfo", "Lcom/tencent/mm/live/core/core/model/LiveConfig;", "getLiveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "getPreviewBitmap", "width", "height", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bitmap", "getScene", "getScreenShareFloatLocation", "Landroid/graphics/Point;", "getScreenShareShot", "isInLinkMic", "justRemoveMiniWindow", "markScreenShareFloatLocation", "x", "y", "mixExternalAudioFrame", "audioBuffer", "", "sampleRate", "channel", "timestamp", "", "muteLocalAudio", "mute", "muteLocalVideo", "muteMicVolume", "normalMode", "onCloseLive", "liveId", "pauseBgMusic", "pauseLive", "playBgMusic", "id", "path", "publish", "loopCount", "listener", "Lcom/tencent/liteav/audio/TXAudioEffectManager$TXMusicPlayObserver;", "refreshCamera", "release", "releaseLiveMiniState", "releaseState", "removeMiniWindow", "resetMixtureParams", "restoreCamera", "resumeBgMusic", "resumeLive", "sendCustomAudioData", "sendCustomVideoData", "eglContext", "Landroid/opengl/EGLContext;", "texId", "setAudioCaptureVolume", "volume", "setLiveMiniState", "newState", "setLiveStatusCallback", "setMusicVolume", "level", "setScene", "scene", "setVoiceCaptureVolume", "setup", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "startLocalAudio", "startPreview", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "startPush", "stopBgMusic", "stopPreview", "stopPush", "switchAudioMode", "muteImage", "switchCamera", "switchScreenShareMode", "screenShareMode", "cameraView", "Landroid/view/TextureView;", "screenShareView", "Landroid/view/View;", "switchVideoMode", "updateBeautyConfig", "updateFilterConfig", "updateMirrorMode", "mirrorMode", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "updateMuteVideoImage", "fps", "updatePreview", "updateRemoteOutputSurface", "userId", "updateSdkParam", "updateVisitoreRenderMode", "renderMode", "plugin-core_release"})
public abstract interface b
{
  public abstract void C(float paramFloat1, float paramFloat2);
  
  public abstract int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap);
  
  public abstract int a(g paramg);
  
  public abstract int a(LivePreviewView paramLivePreviewView, a parama, com.tencent.mm.live.core.b.b paramb);
  
  public abstract void a(int paramInt, String paramString, TXAudioEffectManager.TXMusicPlayObserver paramTXMusicPlayObserver);
  
  public abstract void a(c paramc);
  
  public abstract void a(AbsLiveMiniView paramAbsLiveMiniView);
  
  public abstract void a(boolean paramBoolean, TextureView paramTextureView, View paramView);
  
  public abstract h aJA();
  
  public abstract void aJB();
  
  public abstract int aJC();
  
  public abstract int aJx();
  
  public abstract void aJy();
  
  public abstract void aJz();
  
  public abstract void b(c paramc);
  
  public abstract void c(c paramc);
  
  public abstract int stopPush();
  
  public abstract void switchCamera();
  
  public abstract void y(Bitmap paramBitmap);
  
  @l(iBK={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b
 * JD-Core Version:    0.7.0.1
 */