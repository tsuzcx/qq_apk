package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.plugin.finder.live.fluent.h;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.findersdk.f.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "", "animate", "Landroid/view/ViewPropertyAnimator;", "getAlpha", "", "getBitmap", "Landroid/graphics/Bitmap;", "getContextTag", "", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getFinderFluentSwitchParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "feedId", "getHeight", "getIsNeverStart", "", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getPlayer", "getTag", "id", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "getWidth", "isEnableFluentSwitchExit", "isFullScreenEnjoy", "isPlaying", "isPreviewing", "onRelease", "", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "prepareforReuse", "removeVideoFooterView", "seekTo", "timestamp", "", "afterSeekPlay", "mode", "setAlpha", "alpha", "setContextTag", "tag", "setFinderVideoPlayTrace", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "setFullScreenEnjoy", "isFull", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setKeepScreenOn", "keepScreenOn", "setLivePlayer", "txPlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setTag", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "startOrPlay", "offset", "(Ljava/lang/Integer;)Z", "stop", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface t
{
  public abstract void a(b paramb, long paramLong);
  
  public abstract void a(x paramx, boolean paramBoolean, FeedData paramFeedData);
  
  public abstract boolean a(double paramDouble, boolean paramBoolean, int paramInt);
  
  public abstract boolean b(double paramDouble, boolean paramBoolean);
  
  public abstract boolean bNU();
  
  public abstract boolean boa();
  
  public abstract boolean eLI();
  
  public abstract int eLK();
  
  public abstract void eLL();
  
  public abstract void eLM();
  
  public abstract boolean eLN();
  
  public abstract float getAlpha();
  
  public abstract Bitmap getBitmap();
  
  public abstract int getContextTag();
  
  public abstract long getCurrentPlayMs();
  
  public abstract int getCurrentPlaySecond();
  
  public abstract int getHeight();
  
  public abstract boolean getIsNeverStart();
  
  public abstract boolean getIsShouldPlayResume();
  
  public abstract ViewParent getParentView();
  
  public abstract Object getPlayer();
  
  public abstract Object getTag(int paramInt);
  
  public abstract int getVideoDuration();
  
  public abstract long getVideoDurationMs();
  
  public abstract String getVideoMediaId();
  
  public abstract v getVideoMediaInfo();
  
  public abstract View getVideoView();
  
  public abstract boolean getVideoViewFocused();
  
  public abstract int getWidth();
  
  public abstract boolean isPlaying();
  
  public abstract void onRelease();
  
  public abstract void onUIDestroy();
  
  public abstract boolean pause();
  
  public abstract h pu(long paramLong);
  
  public abstract boolean r(Integer paramInteger);
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setContextTag(int paramInt);
  
  public abstract void setFinderVideoPlayTrace(a parama);
  
  public abstract void setFullScreenEnjoy(boolean paramBoolean);
  
  public abstract void setIMMVideoViewCallback(i.b paramb);
  
  public abstract void setIOnlineVideoProxy(f paramf);
  
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
  
  public abstract void setVideoMuteListener(w paramw);
  
  public abstract void setVideoPlayLifecycle(ab paramab);
  
  public abstract void setVideoViewFocused(boolean paramBoolean);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.t
 * JD-Core Version:    0.7.0.1
 */