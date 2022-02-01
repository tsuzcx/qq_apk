package com.tencent.luggage.xweb_ext.extendplugin.component.video.b;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "", "onVideoEnded", "", "onVideoPause", "onVideoPlay", "onVideoProgress", "percent", "", "onVideoTimeUpdate", "currentPosition", "duration", "onVideoWaiting", "onXWebCastingInterrupt", "onXWebCastingUserSelect", "state", "", "onXWebDLNACastingStateChange", "isSuccess", "setInvokeContext", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "data", "", "luggage-xweb-ext_release"})
public abstract interface a
{
  public abstract void Ui();
  
  public abstract void cs(int paramInt1, int paramInt2);
  
  public abstract void ct(boolean paramBoolean);
  
  public abstract void cu(boolean paramBoolean);
  
  public abstract void ew(String paramString);
  
  public abstract void jh(int paramInt);
  
  public abstract void m(com.tencent.luggage.xweb_ext.extendplugin.a parama);
  
  public abstract void onVideoEnded();
  
  public abstract void onVideoPause();
  
  public abstract void onVideoPlay();
  
  public abstract void onVideoWaiting();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
 * JD-Core Version:    0.7.0.1
 */