package com.tencent.mm.live.core.core;

import android.content.Context;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.view.LivePreviewView;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/IMMLiveCore;", "", "enterRoom", "", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "exitRoom", "finishLastLive", "floatMode", "", "context", "Landroid/content/Context;", "getLiveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "isInLinkMic", "", "normalMode", "refreshCamera", "release", "setLiveStatusCallback", "setup", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "startPreview", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "startPush", "stopPreview", "stopPush", "switchCamera", "updateLiveMiniState", "state", "", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "plugin-core_release"})
public abstract interface a
{
  public abstract int a(d paramd);
  
  public abstract int a(LivePreviewView paramLivePreviewView);
  
  public abstract void a(b paramb);
  
  public abstract void aTU(String paramString);
  
  public abstract void an(float paramFloat1, float paramFloat2);
  
  public abstract void b(b paramb);
  
  public abstract void c(b paramb);
  
  public abstract int clG();
  
  public abstract int clI();
  
  public abstract int clf();
  
  public abstract void clg();
  
  public abstract void clo();
  
  public abstract e clu();
  
  public abstract int eE(Context paramContext);
  
  public abstract void release();
  
  public abstract void switchCamera();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a
 * JD-Core Version:    0.7.0.1
 */