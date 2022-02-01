package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "", "animate", "Landroid/view/ViewPropertyAnimator;", "getAlpha", "", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPlayMs", "", "getCurrentPlaySecond", "", "getHeight", "getIsNeverStart", "", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getTag", "id", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "getWidth", "isPlaying", "isPreviewing", "onRelease", "", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "removeVideoFooterView", "seekTo", "timestamp", "", "afterSeekPlay", "setAlpha", "alpha", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setKeepScreenOn", "keepScreenOn", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setTag", "tag", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "startOrPlay", "stop", "plugin-finder_release"})
public abstract interface r
{
  public abstract void a(com.tencent.mm.plugin.finder.loader.s params, boolean paramBoolean, FeedData paramFeedData);
  
  public abstract ViewPropertyAnimator animate();
  
  public abstract boolean c(double paramDouble, boolean paramBoolean);
  
  public abstract boolean dEN();
  
  public abstract boolean dEO();
  
  public abstract boolean dFj();
  
  public abstract int dFk();
  
  public abstract void dFl();
  
  public abstract float getAlpha();
  
  public abstract Bitmap getBitmap();
  
  public abstract long getCurrentPlayMs();
  
  public abstract int getCurrentPlaySecond();
  
  public abstract int getHeight();
  
  public abstract boolean getIsNeverStart();
  
  public abstract boolean getIsShouldPlayResume();
  
  public abstract ViewParent getParentView();
  
  public abstract Object getTag(int paramInt);
  
  public abstract int getVideoDuration();
  
  public abstract long getVideoDurationMs();
  
  public abstract String getVideoMediaId();
  
  public abstract s getVideoMediaInfo();
  
  public abstract View getVideoView();
  
  public abstract boolean getVideoViewFocused();
  
  public abstract int getWidth();
  
  public abstract boolean isPlaying();
  
  public abstract void onRelease();
  
  public abstract void onUIDestroy();
  
  public abstract boolean pause();
  
  public abstract boolean play();
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setFinderVideoCore(k paramk);
  
  public abstract void setIMMVideoViewCallback(i.b paramb);
  
  public abstract void setIOnlineVideoProxy(b paramb);
  
  public abstract void setInterceptDetach(boolean paramBoolean);
  
  public abstract void setIsShouldPlayResume(boolean paramBoolean);
  
  public abstract void setIsShowBasicControls(boolean paramBoolean);
  
  public abstract void setKeepScreenOn(boolean paramBoolean);
  
  public abstract void setLoop(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setPreview(boolean paramBoolean);
  
  public abstract void setScaleType(i.e parame);
  
  public abstract void setTag(int paramInt, Object paramObject);
  
  public abstract void setTag(Object paramObject);
  
  public abstract void setVideoMuteListener(t paramt);
  
  public abstract void setVideoPlayLifecycle(y paramy);
  
  public abstract void setVideoViewFocused(boolean paramBoolean);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.r
 * JD-Core Version:    0.7.0.1
 */