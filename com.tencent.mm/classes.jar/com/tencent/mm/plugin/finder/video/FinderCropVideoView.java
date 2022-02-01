package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderCropVideoView;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getCurrentPlayMs", "", "getCurrentPlaySecond", "", "getIsNeverStart", "", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoDurationMs", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "initView", "", "isPreviewing", "layoutId", "onMediaInfoAndMatrixPrepared", "onRelease", "prepareToPlay", "rawSeekTo", "time", "", "afterSeekPlay", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIsShouldPlayResume", "shouldPlayResume", "setPreview", "isPreview", "setRootMatrix", "matrix", "Landroid/graphics/Matrix;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "videoPlayLifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "plugin-finder_release"})
public final class FinderCropVideoView
  extends FinderVideoView
  implements r
{
  private CropLayout vNh;
  
  public FinderCropVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FinderCropVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.s params, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(253866);
    p.h(params, "video");
    p.h(paramFeedData, "feedData");
    b(params, paramBoolean, paramFeedData);
    AppMethodBeat.o(253866);
  }
  
  public final boolean dEN()
  {
    return false;
  }
  
  public final boolean dEO()
  {
    AppMethodBeat.i(253871);
    boolean bool = get_isPreviewing();
    AppMethodBeat.o(253871);
    return bool;
  }
  
  public final int dEP()
  {
    return 2131494105;
  }
  
  public final void dEQ()
  {
    AppMethodBeat.i(168002);
    Object localObject1 = this.vNh;
    if (localObject1 == null) {
      p.btv("cropLayout");
    }
    ((CropLayout)localObject1).reset();
    Object localObject2 = getVideoMatrix();
    if (localObject2 != null)
    {
      if (((bej)localObject2).LOe.size() == 9)
      {
        localObject1 = new Matrix();
        localObject2 = ((bej)localObject2).LOe;
        p.g(localObject2, "it.value");
        ((Matrix)localObject1).setValues(j.t((Collection)localObject2));
        setRootMatrix((Matrix)localObject1);
      }
      AppMethodBeat.o(168002);
      return;
    }
    AppMethodBeat.o(168002);
  }
  
  public final long getCurrentPlayMs()
  {
    AppMethodBeat.i(253873);
    long l = getCurrPosMs();
    AppMethodBeat.o(253873);
    return l;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(253872);
    int i = getCurrPosSec();
    AppMethodBeat.o(253872);
    return i;
  }
  
  public final boolean getIsNeverStart()
  {
    return this.wcC;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.wcB;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(253876);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(253876);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(253874);
    Object localObject = getMediaInfo();
    if (localObject != null)
    {
      localObject = ((s)localObject).tHN;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.loader.s)localObject).uIw;
        if (localObject != null)
        {
          localObject = ((cjl)localObject).uOR;
          if (localObject != null)
          {
            if (getVideoDurationSec() > (((cjx)localObject).iqg - ((cjx)localObject).dvv) / 1000)
            {
              i = (((cjx)localObject).iqg - ((cjx)localObject).dvv) / 1000;
              AppMethodBeat.o(253874);
              return i;
            }
            i = getVideoDurationSec();
            AppMethodBeat.o(253874);
            return i;
          }
        }
      }
    }
    int i = getVideoDurationSec();
    AppMethodBeat.o(253874);
    return i;
  }
  
  public final long getVideoDurationMs()
  {
    AppMethodBeat.i(253875);
    Object localObject = getMediaInfo();
    if (localObject != null)
    {
      localObject = ((s)localObject).tHN;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.loader.s)localObject).uIw;
        if (localObject != null)
        {
          localObject = ((cjl)localObject).uOR;
          if (localObject != null)
          {
            if (getVideoDurationSec() > (((cjx)localObject).iqg - ((cjx)localObject).dvv) / 1000)
            {
              l = ((cjx)localObject).iqg - ((cjx)localObject).dvv;
              AppMethodBeat.o(253875);
              return l;
            }
            l = getVideoDurationSec();
            AppMethodBeat.o(253875);
            return l * 1000L;
          }
        }
      }
    }
    long l = getVideoDurationSec();
    AppMethodBeat.o(253875);
    return l * 1000L;
  }
  
  public final s getVideoMediaInfo()
  {
    AppMethodBeat.i(253867);
    s locals = getMediaInfo();
    AppMethodBeat.o(253867);
    return locals;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.wcA;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(168001);
    super.initView();
    Object localObject = findViewById(2131300800);
    p.g(localObject, "findViewById(R.id.finder_crop_layout)");
    this.vNh = ((CropLayout)localObject);
    localObject = this.vNh;
    if (localObject == null) {
      p.btv("cropLayout");
    }
    ((CropLayout)localObject).setEnableTouch(false);
    localObject = this.vNh;
    if (localObject == null) {
      p.btv("cropLayout");
    }
    ((CropLayout)localObject).setEnableScale(false);
    localObject = this.vNh;
    if (localObject == null) {
      p.btv("cropLayout");
    }
    ((CropLayout)localObject).setEnableFling(false);
    localObject = this.vNh;
    if (localObject == null) {
      p.btv("cropLayout");
    }
    ((CropLayout)localObject).setEnableOverScroll(false);
    AppMethodBeat.o(168001);
  }
  
  public final void onRelease() {}
  
  public final void setFinderVideoCore(k paramk)
  {
    AppMethodBeat.i(253863);
    setVideoCore(paramk);
    AppMethodBeat.o(253863);
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(253868);
    setShouldPlayResume(paramBoolean);
    AppMethodBeat.o(253868);
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(253870);
    set_isPreviewing(paramBoolean);
    AppMethodBeat.o(253870);
  }
  
  public final void setRootMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(168003);
    p.h(paramMatrix, "matrix");
    if (getMediaInfo() == null)
    {
      AppMethodBeat.o(168003);
      return;
    }
    Object localObject = c.xsz;
    localObject = getMediaInfo();
    if (localObject == null) {
      p.hyc();
    }
    localObject = c.awl(((s)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(168003);
      return;
    }
    paramMatrix = new Matrix(paramMatrix);
    CropLayout localCropLayout = this.vNh;
    if (localCropLayout == null) {
      p.btv("cropLayout");
    }
    RelativeLayout localRelativeLayout = this.mEy;
    p.g(localRelativeLayout, "videoRoot");
    localCropLayout.a((View)localRelativeLayout, ((a)localObject).width, ((a)localObject).height, new Matrix(), CropLayout.e.QMD, (b)new a(paramMatrix));
    AppMethodBeat.o(168003);
  }
  
  public final void setVideoMuteListener(t paramt)
  {
    AppMethodBeat.i(253864);
    p.h(paramt, "onMuteListener");
    setMuteListener(paramt);
    AppMethodBeat.o(253864);
  }
  
  public final void setVideoPlayLifecycle(y paramy)
  {
    AppMethodBeat.i(253865);
    p.h(paramy, "videoPlayLifecycle");
    setLifecycle(paramy);
    AppMethodBeat.o(253865);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(253869);
    setViewFocused(paramBoolean);
    AppMethodBeat.o(253869);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class a
    extends q
    implements b<Matrix, Boolean>
  {
    a(Matrix paramMatrix)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderCropVideoView
 * JD-Core Version:    0.7.0.1
 */