package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.live.fluent.h;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.findersdk.f.a;
import com.tencent.mm.plugin.gallery.b.g;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderCropVideoView;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contextTag", "", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "isFullScreen", "", "videoRootHeight", "getVideoRootHeight", "()I", "setVideoRootHeight", "(I)V", "videoRootWidth", "getVideoRootWidth", "setVideoRootWidth", "getContextTag", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getFinderFluentSwitchParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "feedId", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getPlayer", "", "getVideoDuration", "getVideoDurationMs", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "initView", "", "isEnableFluentSwitchExit", "isFullScreenEnjoy", "isPreviewing", "layoutId", "onMediaInfoAndMatrixPrepared", "onRelease", "prepareToPlay", "prepareforReuse", "rawSeekTo", "time", "", "afterSeekPlay", "seekTo", "seconds", "afterPlay", "mode", "setContextTag", "tag", "setFinderVideoPlayTrace", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "setFullScreenEnjoy", "isFull", "setIsShouldPlayResume", "shouldPlayResume", "setLivePlayer", "txPlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "setPreview", "isPreview", "setRootMatrix", "matrix", "Landroid/graphics/Matrix;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "videoPlayLifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "startOrPlay", "offset", "(Ljava/lang/Integer;)Z", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderCropVideoView
  extends FinderVideoView
  implements t
{
  private CropLayout FTl;
  private boolean Flq;
  private int GmB;
  private int GmC;
  private int contextTag = -1;
  
  public FinderCropVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FinderCropVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(com.tencent.mm.live.core.core.c.b paramb, long paramLong)
  {
    AppMethodBeat.i(334999);
    s.u(paramb, "txPlayer");
    AppMethodBeat.o(334999);
  }
  
  public final void a(x paramx, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(334938);
    s.u(paramx, "video");
    s.u(paramFeedData, "feedData");
    b(paramx, paramBoolean, paramFeedData);
    AppMethodBeat.o(334938);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(335091);
    paramBoolean = b(paramDouble, paramBoolean);
    AppMethodBeat.o(335091);
    return paramBoolean;
  }
  
  public final boolean boa()
  {
    AppMethodBeat.i(334982);
    boolean bool = get_isPreviewing();
    AppMethodBeat.o(334982);
    return bool;
  }
  
  public final boolean eLI()
  {
    return false;
  }
  
  public final void eLL() {}
  
  public final boolean eLN()
  {
    return false;
  }
  
  public final int edi()
  {
    return e.f.fake_finder_crop_video_view;
  }
  
  public final void fiw()
  {
    AppMethodBeat.i(168002);
    if (!this.Flq)
    {
      Object localObject2 = this.FTl;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("cropLayout");
        localObject1 = null;
      }
      ((CropLayout)localObject1).reset();
      localObject2 = getVideoMatrix();
      if ((localObject2 != null) && (((byz)localObject2).aaib.size() == 9))
      {
        localObject1 = new Matrix();
        localObject2 = ((byz)localObject2).aaib;
        s.s(localObject2, "it.value");
        ((Matrix)localObject1).setValues(p.H((Collection)localObject2));
        setRootMatrix((Matrix)localObject1);
      }
    }
    AppMethodBeat.o(168002);
  }
  
  public final int getContextTag()
  {
    return this.contextTag;
  }
  
  public final long getCurrentPlayMs()
  {
    AppMethodBeat.i(335021);
    long l = getCurrPosMs();
    AppMethodBeat.o(335021);
    return l;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(335015);
    int i = getCurrPosSec();
    AppMethodBeat.o(335015);
    return i;
  }
  
  public final boolean getIsNeverStart()
  {
    AppMethodBeat.i(334944);
    boolean bool = fjF();
    AppMethodBeat.o(334944);
    return bool;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    AppMethodBeat.i(334965);
    boolean bool = fjE();
    AppMethodBeat.o(334965);
    return bool;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(335038);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(335038);
    return localViewParent;
  }
  
  public final Object getPlayer()
  {
    return this;
  }
  
  public final int getVideoDuration()
  {
    Object localObject2 = null;
    AppMethodBeat.i(335026);
    Object localObject1 = getMediaInfo();
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    while (localObject1 == null)
    {
      i = getVideoDurationSec();
      AppMethodBeat.o(335026);
      return i;
      Object localObject3 = ((v)localObject1).ANK;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((x)localObject3).eCF();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((dji)localObject3).EDC;
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            if (getVideoDurationSec() > (((dju)localObject3).endTime - ((dju)localObject3).startTime) / 1000) {}
            for (i = (((dju)localObject3).endTime - ((dju)localObject3).startTime) / 1000;; i = getVideoDurationSec())
            {
              localObject1 = Integer.valueOf(i);
              break;
            }
          }
        }
      }
    }
    int i = ((Integer)localObject1).intValue();
    AppMethodBeat.o(335026);
    return i;
  }
  
  public final long getVideoDurationMs()
  {
    Object localObject2 = null;
    AppMethodBeat.i(335033);
    Object localObject1 = getMediaInfo();
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    while (localObject1 == null)
    {
      l = getVideoDurationSec();
      AppMethodBeat.o(335033);
      return l * 1000L;
      Object localObject3 = ((v)localObject1).ANK;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((x)localObject3).eCF();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((dji)localObject3).EDC;
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            if (getVideoDurationSec() > (((dju)localObject3).endTime - ((dju)localObject3).startTime) / 1000) {}
            for (l = ((dju)localObject3).endTime - ((dju)localObject3).startTime;; l = getVideoDurationSec() * 1000L)
            {
              localObject1 = Long.valueOf(l);
              break;
            }
          }
        }
      }
    }
    long l = ((Long)localObject1).longValue();
    AppMethodBeat.o(335033);
    return l;
  }
  
  public final v getVideoMediaInfo()
  {
    AppMethodBeat.i(334951);
    v localv = getMediaInfo();
    AppMethodBeat.o(334951);
    return localv;
  }
  
  public final int getVideoRootHeight()
  {
    return this.GmC;
  }
  
  public final int getVideoRootWidth()
  {
    return this.GmB;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    AppMethodBeat.i(334993);
    boolean bool = fjD();
    AppMethodBeat.o(334993);
    return bool;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168001);
    super.initView();
    Object localObject1 = findViewById(e.e.finder_crop_layout);
    s.s(localObject1, "findViewById(R.id.finder_crop_layout)");
    this.FTl = ((CropLayout)localObject1);
    CropLayout localCropLayout = this.FTl;
    localObject1 = localCropLayout;
    if (localCropLayout == null)
    {
      s.bIx("cropLayout");
      localObject1 = null;
    }
    ((CropLayout)localObject1).setEnableTouch(false);
    localCropLayout = this.FTl;
    localObject1 = localCropLayout;
    if (localCropLayout == null)
    {
      s.bIx("cropLayout");
      localObject1 = null;
    }
    ((CropLayout)localObject1).setEnableScale(false);
    localCropLayout = this.FTl;
    localObject1 = localCropLayout;
    if (localCropLayout == null)
    {
      s.bIx("cropLayout");
      localObject1 = null;
    }
    ((CropLayout)localObject1).setEnableFling(false);
    localObject1 = this.FTl;
    if (localObject1 == null)
    {
      s.bIx("cropLayout");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((CropLayout)localObject1).setEnableOverScroll(false);
      AppMethodBeat.o(168001);
      return;
    }
  }
  
  public final void onRelease() {}
  
  public final h pu(long paramLong)
  {
    return null;
  }
  
  public final boolean r(Integer paramInteger)
  {
    AppMethodBeat.i(334987);
    boolean bool = super.fjG();
    AppMethodBeat.o(334987);
    return bool;
  }
  
  public final void setContextTag(int paramInt)
  {
    this.contextTag = paramInt;
  }
  
  public final void setFinderVideoPlayTrace(a parama) {}
  
  public final void setFullScreenEnjoy(boolean paramBoolean)
  {
    this.Flq = paramBoolean;
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(334968);
    setShouldPlayResume(paramBoolean);
    AppMethodBeat.o(334968);
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(334978);
    set_isPreviewing(paramBoolean);
    AppMethodBeat.o(334978);
  }
  
  public final void setRootMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(168003);
    s.u(paramMatrix, "matrix");
    if (getMediaInfo() == null)
    {
      AppMethodBeat.o(168003);
      return;
    }
    Object localObject = g.HRf;
    localObject = getMediaInfo();
    s.checkNotNull(localObject);
    com.tencent.mm.plugin.sight.base.b localb = g.aBH(((v)localObject).path);
    Matrix localMatrix = new Matrix(paramMatrix);
    localObject = this.FTl;
    paramMatrix = (Matrix)localObject;
    if (localObject == null)
    {
      s.bIx("cropLayout");
      paramMatrix = null;
    }
    localObject = this.sIW;
    s.s(localObject, "videoRoot");
    localObject = (View)localObject;
    int i;
    if (this.GmB > 0)
    {
      i = this.GmB;
      if (this.GmC <= 0) {
        break label175;
      }
    }
    label175:
    for (int j = this.GmC;; j = localb.height)
    {
      paramMatrix.a((View)localObject, i, j, new Matrix(), CropLayout.e.agdt, (kotlin.g.a.b)new FinderCropVideoView.a(localMatrix));
      AppMethodBeat.o(168003);
      return;
      i = localb.width;
      break;
    }
  }
  
  public final void setVideoMuteListener(w paramw)
  {
    AppMethodBeat.i(334910);
    s.u(paramw, "onMuteListener");
    setMuteListener(paramw);
    AppMethodBeat.o(334910);
  }
  
  public final void setVideoPlayLifecycle(ab paramab)
  {
    AppMethodBeat.i(334931);
    s.u(paramab, "videoPlayLifecycle");
    setLifecycle(paramab);
    AppMethodBeat.o(334931);
  }
  
  public final void setVideoRootHeight(int paramInt)
  {
    this.GmC = paramInt;
  }
  
  public final void setVideoRootWidth(int paramInt)
  {
    this.GmB = paramInt;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(334974);
    setViewFocused(paramBoolean);
    AppMethodBeat.o(334974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderCropVideoView
 * JD-Core Version:    0.7.0.1
 */