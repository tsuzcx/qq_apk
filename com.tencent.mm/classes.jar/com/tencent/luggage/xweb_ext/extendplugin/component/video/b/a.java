package com.tencent.luggage.xweb_ext.extendplugin.component.video.b;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "", "onVideoEnded", "", "onVideoPause", "onVideoPlay", "onVideoProgress", "percent", "", "onVideoTimeUpdate", "currentPosition", "duration", "onVideoWaiting", "onXWebCastingInterrupt", "onXWebCastingUserSelect", "state", "", "onXWebDLNACastingStateChange", "isSuccess", "setInvokeContext", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "data", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract void auL();
  
  public abstract void cZ(boolean paramBoolean);
  
  public abstract void da(boolean paramBoolean);
  
  public abstract void dh(int paramInt1, int paramInt2);
  
  public abstract void fT(String paramString);
  
  public abstract void m(com.tencent.luggage.xweb_ext.extendplugin.a parama);
  
  public abstract void mJ(int paramInt);
  
  public abstract void onVideoEnded();
  
  public abstract void onVideoPause();
  
  public abstract void onVideoPlay();
  
  public abstract void onVideoWaiting();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
 * JD-Core Version:    0.7.0.1
 */