package com.tencent.mm.live.core.core;

import android.content.Context;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.view.LivePreviewView;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/IMMLiveCore;", "", "enterRoom", "", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "exitRoom", "finishLastLive", "floatMode", "", "context", "Landroid/content/Context;", "getLiveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "isInLinkMic", "", "normalMode", "refreshCamera", "release", "removeMiniWindow", "setLiveStatusCallback", "setup", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "startPreview", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "startPush", "stopPreview", "stopPush", "switchCamera", "updateLiveMiniState", "state", "", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "plugin-core_release"})
public abstract interface a
{
  public abstract int a(d paramd);
  
  public abstract int a(LivePreviewView paramLivePreviewView);
  
  public abstract void a(b paramb);
  
  public abstract int aiq();
  
  public abstract void air();
  
  public abstract void ais();
  
  public abstract e ait();
  
  public abstract void aiu();
  
  public abstract void aiv();
  
  public abstract int aiw();
  
  public abstract int aix();
  
  public abstract void b(b paramb);
  
  public abstract void c(b paramb);
  
  public abstract int cs(Context paramContext);
  
  public abstract void switchCamera();
  
  public abstract void uv(String paramString);
  
  public abstract void w(float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a
 * JD-Core Version:    0.7.0.1
 */