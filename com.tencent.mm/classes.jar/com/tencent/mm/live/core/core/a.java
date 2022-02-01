package com.tencent.mm.live.core.core;

import android.content.Context;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.view.LivePreviewView;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/IMMLiveCore;", "", "enterRoom", "", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "exitRoom", "finishLastLive", "floatMode", "", "context", "Landroid/content/Context;", "getLiveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "isInLinkMic", "", "normalMode", "refreshCamera", "release", "removeMiniWindow", "setLiveStatusCallback", "setup", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "startPreview", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "startPush", "stopPreview", "stopPush", "switchCamera", "updateLiveMiniState", "state", "", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "plugin-core_release"})
public abstract interface a
{
  public abstract int a(d paramd);
  
  public abstract int a(LivePreviewView paramLivePreviewView);
  
  public abstract void a(b paramb);
  
  public abstract int alc();
  
  public abstract void ald();
  
  public abstract void ale();
  
  public abstract e alf();
  
  public abstract void alg();
  
  public abstract void alh();
  
  public abstract int ali();
  
  public abstract int alj();
  
  public abstract void b(b paramb);
  
  public abstract void c(b paramb);
  
  public abstract int cp(Context paramContext);
  
  public abstract void switchCamera();
  
  public abstract void xl(String paramString);
  
  public abstract void y(float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a
 * JD-Core Version:    0.7.0.1
 */