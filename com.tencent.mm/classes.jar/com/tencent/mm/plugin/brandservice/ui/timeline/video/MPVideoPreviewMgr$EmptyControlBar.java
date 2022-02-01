package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$EmptyControlBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/progressbar/VideoPlayerSeekBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IControlBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addOnVisibilityChangedListener", "", "onVisibilityChangedListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnControlbarVisibilityChangedListener;", "enterFullScreen", "flowShow", "getLayoutId", "hide", "hideCenterPlayBtnIfNeed", "init", "isAutoHide", "", "isControlProgressShowing", "isDanmakuBtnOpen", "isFullScreenState", "isShow", "onDestroy", "onFullScreenChange", "quitFullScreen", "resetAutoHideTimer", "seek", "position", "seekForPoint", "setAutoHide", "autoHide", "setBtnCloseListener", "listener", "Landroid/view/View$OnClickListener;", "setDanmakuBtnIcon", "setDanmakuBtnOnClickListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnDanmakuBtnOnClickListener;", "setDanmakuBtnOpen", "setExitFullScreenBtnOnClickListener", "setFullScreenBtn", "setFullScreenBtnOnClickListener", "setFullScreenTitleBar", "setIsPlay", "isPlay", "setMuteBtnOnClickListener", "setMuteBtnState", "isMute", "setOnPlayButtonClickListener", "setOnUpdateProgressLenListener", "onUpdateProgressLenListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnControlbarProgressChangedListener;", "setPlayBtn", "setPlayBtnInCenterPosition", "playBtnInCenterPosition", "setPlayBtnState", "setRootLayout", "setShowControlProgress", "showControlProgress", "setShowDanmakuBtn", "show", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setStatePorter", "porter", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "setTimeTextSize", "setTitle", "title", "", "setVideoTotalTime", "seconds", "setVisibility", "visibility", "showCenterPlayBtnIfNeed", "showControlProgressInternal", "stopCacheUpdate", "toggleDanmakuBtn", "toggleShow", "triggerCacheUpdate", "updateLayoutMargins", "updateMiddleBar", "updateProgress", "progressLen", "totalLen", "updateVideoStatus", "plugin-brandservice_release"})
public final class MPVideoPreviewMgr$EmptyControlBar
  extends VideoPlayerSeekBar
  implements d.a, d.b
{
  public MPVideoPreviewMgr$EmptyControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(264043);
    AppMethodBeat.o(264043);
  }
  
  public MPVideoPreviewMgr$EmptyControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(264044);
    AppMethodBeat.o(264044);
  }
  
  public MPVideoPreviewMgr$EmptyControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(264045);
    AppMethodBeat.o(264045);
  }
  
  public final void Nq() {}
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.d.f paramf)
  {
    AppMethodBeat.i(264042);
    p.k(paramf, "onVisibilityChangedListener");
    AppMethodBeat.o(264042);
  }
  
  public final void bSs() {}
  
  public final void bUI() {}
  
  public final boolean bVa()
  {
    return false;
  }
  
  public final void bVb() {}
  
  public final void bVc() {}
  
  public final boolean bVd()
  {
    return false;
  }
  
  public final boolean bVe()
  {
    return false;
  }
  
  public final boolean bVf()
  {
    return true;
  }
  
  public final void bVg() {}
  
  public final void bVh() {}
  
  public final void bVi() {}
  
  public final void bVj() {}
  
  public final boolean bVk()
  {
    return false;
  }
  
  public final void bWO() {}
  
  public final int getLayoutId()
  {
    return com.tencent.mm.plugin.brandservice.d.f.sub;
  }
  
  public final void hide() {}
  
  public final void iF(boolean paramBoolean) {}
  
  public final void init() {}
  
  public final void onDestroy() {}
  
  public final void seek(int paramInt) {}
  
  public final void setAutoHide(boolean paramBoolean) {}
  
  public final void setBtnCloseListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(264026);
    p.k(paramOnClickListener, "listener");
    AppMethodBeat.o(264026);
  }
  
  public final void setDanmakuBtnOnClickListener(d.g paramg)
  {
    AppMethodBeat.i(264038);
    p.k(paramg, "listener");
    AppMethodBeat.o(264038);
  }
  
  public final void setDanmakuBtnOpen(boolean paramBoolean) {}
  
  public final void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(264028);
    p.k(paramOnClickListener, "listener");
    AppMethodBeat.o(264028);
  }
  
  public final void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(264037);
    p.k(paramOnClickListener, "listener");
    AppMethodBeat.o(264037);
  }
  
  public final void setIsPlay(boolean paramBoolean) {}
  
  public final void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(264027);
    p.k(paramOnClickListener, "listener");
    AppMethodBeat.o(264027);
  }
  
  public final void setMuteBtnState(boolean paramBoolean) {}
  
  public final void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(264029);
    p.k(paramOnClickListener, "listener");
    AppMethodBeat.o(264029);
  }
  
  public final void setOnUpdateProgressLenListener(d.e parame)
  {
    AppMethodBeat.i(264041);
    p.k(parame, "onUpdateProgressLenListener");
    AppMethodBeat.o(264041);
  }
  
  public final void setPlayBtnInCenterPosition(boolean paramBoolean) {}
  
  public final void setShowControlProgress(boolean paramBoolean) {}
  
  public final void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public final void setShowFullScreenBtn(boolean paramBoolean) {}
  
  public final void setShowMuteBtn(boolean paramBoolean) {}
  
  public final void setShowPlayBtn(boolean paramBoolean) {}
  
  public final void setShowProgress(boolean paramBoolean) {}
  
  public final void setStatePorter(d.i parami)
  {
    AppMethodBeat.i(264024);
    p.k(parami, "porter");
    AppMethodBeat.o(264024);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(264031);
    p.k(paramString, "title");
    AppMethodBeat.o(264031);
  }
  
  public final void setVideoTotalTime(int paramInt) {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.EmptyControlBar
 * JD-Core Version:    0.7.0.1
 */