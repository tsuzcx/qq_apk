package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$EmptyControlBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/progressbar/VideoPlayerSeekBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IControlBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addOnVisibilityChangedListener", "", "onVisibilityChangedListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnControlbarVisibilityChangedListener;", "enterFullScreen", "flowShow", "getLayoutId", "hide", "hideCenterPlayBtnIfNeed", "init", "isAutoHide", "", "isControlProgressShowing", "isDanmakuBtnOpen", "isFullScreenState", "isShow", "onDestroy", "onFullScreenChange", "quitFullScreen", "resetAutoHideTimer", "seek", "position", "seekForPoint", "setAutoHide", "autoHide", "setBtnCloseListener", "listener", "Landroid/view/View$OnClickListener;", "setDanmakuBtnIcon", "setDanmakuBtnOnClickListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnDanmakuBtnOnClickListener;", "setDanmakuBtnOpen", "setExitFullScreenBtnOnClickListener", "setFullScreenBtn", "setFullScreenBtnOnClickListener", "setFullScreenTitleBar", "setIsPlay", "isPlay", "setMuteBtnOnClickListener", "setMuteBtnState", "isMute", "setOnPlayButtonClickListener", "setOnUpdateProgressLenListener", "onUpdateProgressLenListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnControlbarProgressChangedListener;", "setPlayBtn", "setPlayBtnInCenterPosition", "playBtnInCenterPosition", "setPlayBtnState", "setRootLayout", "setShowControlProgress", "showControlProgress", "setShowDanmakuBtn", "show", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setStatePorter", "porter", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "setTimeTextSize", "setTitle", "title", "", "setVideoTotalTime", "seconds", "setVisibility", "visibility", "showCenterPlayBtnIfNeed", "showControlProgressInternal", "stopCacheUpdate", "toggleDanmakuBtn", "toggleShow", "triggerCacheUpdate", "updateLayoutMargins", "updateMiddleBar", "updateProgress", "progressLen", "totalLen", "updateVideoStatus", "plugin-brandservice_release"})
public final class MPVideoPreviewMgr$EmptyControlBar
  extends VideoPlayerSeekBar
  implements e.a, e.b
{
  public MPVideoPreviewMgr$EmptyControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(195908);
    AppMethodBeat.o(195908);
  }
  
  public MPVideoPreviewMgr$EmptyControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(195909);
    AppMethodBeat.o(195909);
  }
  
  public MPVideoPreviewMgr$EmptyControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195910);
    AppMethodBeat.o(195910);
  }
  
  public final void KD() {}
  
  public final void a(e.f paramf)
  {
    AppMethodBeat.i(195907);
    p.h(paramf, "onVisibilityChangedListener");
    AppMethodBeat.o(195907);
  }
  
  public final void bGL() {}
  
  public final void bIZ() {}
  
  public final void bJA() {}
  
  public final void bJB() {}
  
  public final void bJC() {}
  
  public final boolean bJD()
  {
    return false;
  }
  
  public final boolean bJt()
  {
    return false;
  }
  
  public final void bJu() {}
  
  public final void bJv() {}
  
  public final boolean bJw()
  {
    return false;
  }
  
  public final boolean bJx()
  {
    return false;
  }
  
  public final boolean bJy()
  {
    return true;
  }
  
  public final void bJz() {}
  
  public final void bKO() {}
  
  public final int getLayoutId()
  {
    return 2131493305;
  }
  
  public final void hP(boolean paramBoolean) {}
  
  public final void hide() {}
  
  public final void init() {}
  
  public final void onDestroy() {}
  
  public final void seek(int paramInt) {}
  
  public final void setAutoHide(boolean paramBoolean) {}
  
  public final void setBtnCloseListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(195899);
    p.h(paramOnClickListener, "listener");
    AppMethodBeat.o(195899);
  }
  
  public final void setDanmakuBtnOnClickListener(e.g paramg)
  {
    AppMethodBeat.i(195905);
    p.h(paramg, "listener");
    AppMethodBeat.o(195905);
  }
  
  public final void setDanmakuBtnOpen(boolean paramBoolean) {}
  
  public final void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(195901);
    p.h(paramOnClickListener, "listener");
    AppMethodBeat.o(195901);
  }
  
  public final void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(195904);
    p.h(paramOnClickListener, "listener");
    AppMethodBeat.o(195904);
  }
  
  public final void setIsPlay(boolean paramBoolean) {}
  
  public final void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(195900);
    p.h(paramOnClickListener, "listener");
    AppMethodBeat.o(195900);
  }
  
  public final void setMuteBtnState(boolean paramBoolean) {}
  
  public final void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(195902);
    p.h(paramOnClickListener, "listener");
    AppMethodBeat.o(195902);
  }
  
  public final void setOnUpdateProgressLenListener(e.e parame)
  {
    AppMethodBeat.i(195906);
    p.h(parame, "onUpdateProgressLenListener");
    AppMethodBeat.o(195906);
  }
  
  public final void setPlayBtnInCenterPosition(boolean paramBoolean) {}
  
  public final void setShowControlProgress(boolean paramBoolean) {}
  
  public final void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public final void setShowFullScreenBtn(boolean paramBoolean) {}
  
  public final void setShowMuteBtn(boolean paramBoolean) {}
  
  public final void setShowPlayBtn(boolean paramBoolean) {}
  
  public final void setShowProgress(boolean paramBoolean) {}
  
  public final void setStatePorter(e.i parami)
  {
    AppMethodBeat.i(195898);
    p.h(parami, "porter");
    AppMethodBeat.o(195898);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(195903);
    p.h(paramString, "title");
    AppMethodBeat.o(195903);
  }
  
  public final void setVideoTotalTime(int paramInt) {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.EmptyControlBar
 * JD-Core Version:    0.7.0.1
 */