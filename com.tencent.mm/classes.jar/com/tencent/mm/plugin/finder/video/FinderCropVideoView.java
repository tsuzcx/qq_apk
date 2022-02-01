package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.findersdk.f.a;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderCropVideoView;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "isFullScreen", "", "videoRootHeight", "", "getVideoRootHeight", "()I", "setVideoRootHeight", "(I)V", "videoRootWidth", "getVideoRootWidth", "setVideoRootWidth", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoDurationMs", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "initView", "", "isFullScreenEnjoy", "isPreviewing", "layoutId", "onMediaInfoAndMatrixPrepared", "onRelease", "prepareToPlay", "rawSeekTo", "time", "", "afterSeekPlay", "seekTo", "seconds", "afterPlay", "mode", "setFinderVideoPlayTrace", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "setFullScreenEnjoy", "isFull", "setIsShouldPlayResume", "shouldPlayResume", "setPreview", "isPreview", "setRootMatrix", "matrix", "Landroid/graphics/Matrix;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "videoPlayLifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "plugin-finder_release"})
public final class FinderCropVideoView
  extends FinderVideoView
  implements s
{
  private boolean AJP;
  private int AJQ;
  private int AJR;
  private CropLayout AtZ;
  
  public FinderCropVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FinderCropVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(ac paramac, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(276644);
    p.k(paramac, "video");
    p.k(paramFeedData, "feedData");
    b(paramac, paramBoolean, paramFeedData);
    AppMethodBeat.o(276644);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(276663);
    paramBoolean = a(paramDouble, paramBoolean);
    AppMethodBeat.o(276663);
    return paramBoolean;
  }
  
  public final boolean egw()
  {
    return false;
  }
  
  public final boolean egx()
  {
    AppMethodBeat.i(276654);
    boolean bool = get_isPreviewing();
    AppMethodBeat.o(276654);
    return bool;
  }
  
  public final int egy()
  {
    return b.g.fake_finder_crop_video_view;
  }
  
  public final void egz()
  {
    AppMethodBeat.i(168002);
    if (!this.AJP)
    {
      Object localObject1 = this.AtZ;
      if (localObject1 == null) {
        p.bGy("cropLayout");
      }
      ((CropLayout)localObject1).reset();
      Object localObject2 = getVideoMatrix();
      if (localObject2 != null)
      {
        if (((blk)localObject2).SWx.size() == 9)
        {
          localObject1 = new Matrix();
          localObject2 = ((blk)localObject2).SWx;
          p.j(localObject2, "it.value");
          ((Matrix)localObject1).setValues(j.r((Collection)localObject2));
          setRootMatrix((Matrix)localObject1);
        }
        AppMethodBeat.o(168002);
        return;
      }
    }
    AppMethodBeat.o(168002);
  }
  
  public final long getCurrentPlayMs()
  {
    AppMethodBeat.i(276659);
    long l = getCurrPosMs();
    AppMethodBeat.o(276659);
    return l;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(276658);
    int i = getCurrPosSec();
    AppMethodBeat.o(276658);
    return i;
  }
  
  public final boolean getIsNeverStart()
  {
    AppMethodBeat.i(276645);
    boolean bool = ehB();
    AppMethodBeat.o(276645);
    return bool;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    AppMethodBeat.i(276649);
    boolean bool = ehA();
    AppMethodBeat.o(276649);
    return bool;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(276662);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(276662);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(276660);
    Object localObject = getMediaInfo();
    if (localObject != null)
    {
      localObject = ((t)localObject).xqx;
      if (localObject != null)
      {
        localObject = ((ac)localObject).dJw();
        if (localObject != null)
        {
          localObject = ((csg)localObject).zBo;
          if (localObject != null)
          {
            if (getVideoDurationSec() > (((css)localObject).endTime - ((css)localObject).fod) / 1000)
            {
              i = (((css)localObject).endTime - ((css)localObject).fod) / 1000;
              AppMethodBeat.o(276660);
              return i;
            }
            i = getVideoDurationSec();
            AppMethodBeat.o(276660);
            return i;
          }
        }
      }
    }
    int i = getVideoDurationSec();
    AppMethodBeat.o(276660);
    return i;
  }
  
  public final long getVideoDurationMs()
  {
    AppMethodBeat.i(276661);
    Object localObject = getMediaInfo();
    if (localObject != null)
    {
      localObject = ((t)localObject).xqx;
      if (localObject != null)
      {
        localObject = ((ac)localObject).dJw();
        if (localObject != null)
        {
          localObject = ((csg)localObject).zBo;
          if (localObject != null)
          {
            if (getVideoDurationSec() > (((css)localObject).endTime - ((css)localObject).fod) / 1000)
            {
              l = ((css)localObject).endTime - ((css)localObject).fod;
              AppMethodBeat.o(276661);
              return l;
            }
            l = getVideoDurationSec();
            AppMethodBeat.o(276661);
            return l * 1000L;
          }
        }
      }
    }
    long l = getVideoDurationSec();
    AppMethodBeat.o(276661);
    return l * 1000L;
  }
  
  public final t getVideoMediaInfo()
  {
    AppMethodBeat.i(276647);
    t localt = getMediaInfo();
    AppMethodBeat.o(276647);
    return localt;
  }
  
  public final int getVideoRootHeight()
  {
    return this.AJR;
  }
  
  public final int getVideoRootWidth()
  {
    return this.AJQ;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    AppMethodBeat.i(276656);
    boolean bool = ehz();
    AppMethodBeat.o(276656);
    return bool;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(168001);
    super.initView();
    Object localObject = findViewById(b.f.finder_crop_layout);
    p.j(localObject, "findViewById(R.id.finder_crop_layout)");
    this.AtZ = ((CropLayout)localObject);
    localObject = this.AtZ;
    if (localObject == null) {
      p.bGy("cropLayout");
    }
    ((CropLayout)localObject).setEnableTouch(false);
    localObject = this.AtZ;
    if (localObject == null) {
      p.bGy("cropLayout");
    }
    ((CropLayout)localObject).setEnableScale(false);
    localObject = this.AtZ;
    if (localObject == null) {
      p.bGy("cropLayout");
    }
    ((CropLayout)localObject).setEnableFling(false);
    localObject = this.AtZ;
    if (localObject == null) {
      p.bGy("cropLayout");
    }
    ((CropLayout)localObject).setEnableOverScroll(false);
    AppMethodBeat.o(168001);
  }
  
  public final void onRelease() {}
  
  public final void setFinderVideoPlayTrace(a parama) {}
  
  public final void setFullScreenEnjoy(boolean paramBoolean)
  {
    this.AJP = paramBoolean;
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(276650);
    setShouldPlayResume(paramBoolean);
    AppMethodBeat.o(276650);
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(276653);
    set_isPreviewing(paramBoolean);
    AppMethodBeat.o(276653);
  }
  
  public final void setRootMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(168003);
    p.k(paramMatrix, "matrix");
    if (getMediaInfo() == null)
    {
      AppMethodBeat.o(168003);
      return;
    }
    Object localObject1 = d.CeY;
    localObject1 = getMediaInfo();
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = d.aFG(((t)localObject1).path);
    paramMatrix = new Matrix(paramMatrix);
    CropLayout localCropLayout = this.AtZ;
    if (localCropLayout == null) {
      p.bGy("cropLayout");
    }
    Object localObject2 = this.pDK;
    p.j(localObject2, "videoRoot");
    localObject2 = (View)localObject2;
    int i;
    if (this.AJQ > 0)
    {
      i = this.AJQ;
      if (this.AJR <= 0) {
        break label172;
      }
    }
    label172:
    for (int j = this.AJR;; j = ((com.tencent.mm.plugin.sight.base.b)localObject1).height)
    {
      localCropLayout.a((View)localObject2, i, j, new Matrix(), CropLayout.e.Ylv, (kotlin.g.a.b)new a(paramMatrix));
      AppMethodBeat.o(168003);
      return;
      i = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
      break;
    }
  }
  
  public final void setVideoMuteListener(u paramu)
  {
    AppMethodBeat.i(276641);
    p.k(paramu, "onMuteListener");
    setMuteListener(paramu);
    AppMethodBeat.o(276641);
  }
  
  public final void setVideoPlayLifecycle(z paramz)
  {
    AppMethodBeat.i(276642);
    p.k(paramz, "videoPlayLifecycle");
    setLifecycle(paramz);
    AppMethodBeat.o(276642);
  }
  
  public final void setVideoRootHeight(int paramInt)
  {
    this.AJR = paramInt;
  }
  
  public final void setVideoRootWidth(int paramInt)
  {
    this.AJQ = paramInt;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(276652);
    setViewFocused(paramBoolean);
    AppMethodBeat.o(276652);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Matrix, Boolean>
  {
    a(Matrix paramMatrix)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderCropVideoView
 * JD-Core Version:    0.7.0.1
 */