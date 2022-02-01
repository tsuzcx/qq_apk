package com.tencent.mm.plugin.finder.video;

import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "", "animate", "Landroid/view/ViewPropertyAnimator;", "getAlpha", "", "getCurrentPlaySecond", "", "getHeight", "getIsNeverStart", "", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getTag", "id", "getVideoDuration", "getVideoMediaId", "", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "getWidth", "isPlaying", "isPreviewing", "onRelease", "", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "removeVideoFooterView", "seekTo", "timestamp", "", "afterSeekPlay", "setAlpha", "alpha", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setKeepScreenOn", "keepScreenOn", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setTag", "tag", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "startOrPlay", "stop", "plugin-finder_release"})
public abstract interface o
{
  public abstract void a(com.tencent.mm.plugin.finder.loader.l paraml, boolean paramBoolean, FinderItem paramFinderItem);
  
  public abstract ViewPropertyAnimator animate();
  
  public abstract boolean c(double paramDouble, boolean paramBoolean);
  
  public abstract boolean cBe();
  
  public abstract boolean cDM();
  
  public abstract int cDN();
  
  public abstract void cDR();
  
  public abstract boolean cDz();
  
  public abstract float getAlpha();
  
  public abstract int getCurrentPlaySecond();
  
  public abstract int getHeight();
  
  public abstract boolean getIsNeverStart();
  
  public abstract boolean getIsShouldPlayResume();
  
  public abstract ViewParent getParentView();
  
  public abstract Object getTag(int paramInt);
  
  public abstract int getVideoDuration();
  
  public abstract String getVideoMediaId();
  
  public abstract p getVideoMediaInfo();
  
  public abstract View getVideoView();
  
  public abstract boolean getVideoViewFocused();
  
  public abstract int getWidth();
  
  public abstract boolean isPlaying();
  
  public abstract void onRelease();
  
  public abstract void onUIDestroy();
  
  public abstract boolean pause();
  
  public abstract boolean play();
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setIMMVideoViewCallback(h.b paramb);
  
  public abstract void setIOnlineVideoProxy(b paramb);
  
  public abstract void setInterceptDetach(boolean paramBoolean);
  
  public abstract void setIsShouldPlayResume(boolean paramBoolean);
  
  public abstract void setIsShowBasicControls(boolean paramBoolean);
  
  public abstract void setKeepScreenOn(boolean paramBoolean);
  
  public abstract void setLoop(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setPreview(boolean paramBoolean);
  
  public abstract void setScaleType(h.e parame);
  
  public abstract void setTag(int paramInt, Object paramObject);
  
  public abstract void setTag(Object paramObject);
  
  public abstract void setVideoMuteListener(q paramq);
  
  public abstract void setVideoPlayLifecycle(u paramu);
  
  public abstract void setVideoViewFocused(boolean paramBoolean);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.o
 * JD-Core Version:    0.7.0.1
 */