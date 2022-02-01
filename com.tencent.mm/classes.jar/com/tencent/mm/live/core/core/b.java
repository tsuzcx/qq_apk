package com.tencent.mm.live.core.core;

import android.content.Context;
import com.tencent.mm.live.core.b.a;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.view.LivePreviewView;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/IMMLiveCore;", "", "enterRoom", "", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "exitRoom", "fillMiniView", "miniView", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "floatMode", "", "context", "Landroid/content/Context;", "forceMoveTask", "", "dontFinish", "generateType", "opType", "getLiveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "isInLinkMic", "justRemoveMiniWindow", "liveScene", "normalMode", "onCloseLive", "liveId", "", "refreshCamera", "release", "removeMiniWindow", "setLiveStatusCallback", "setup", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "startPreview", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "startPush", "stopPreview", "stopPush", "switchCamera", "updateBeautyConfig", "updateFilterConfig", "updateLiveMiniState", "state", "Lcom/tencent/mm/live/core/mini/LiveMiniState;", "updateMirrorMode", "mirrorMode", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "updateRemoteOutputSurface", "userId", "", "updateSdkParam", "updateVisitoreRenderMode", "renderMode", "plugin-core_release"})
public abstract interface b
{
  public abstract void A(float paramFloat1, float paramFloat2);
  
  public abstract int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2);
  
  public abstract int a(f paramf);
  
  public abstract int a(LivePreviewView paramLivePreviewView, a parama, com.tencent.mm.live.core.b.b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(AbsLiveMiniView paramAbsLiveMiniView);
  
  public abstract int aBS();
  
  public abstract void aBT();
  
  public abstract void aBU();
  
  public abstract g aBV();
  
  public abstract void aBW();
  
  public abstract int aBX();
  
  public abstract int aBY();
  
  public abstract void b(c paramc);
  
  public abstract void c(c paramc);
  
  public abstract void switchCamera();
  
  @l(hxD={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b
 * JD-Core Version:    0.7.0.1
 */