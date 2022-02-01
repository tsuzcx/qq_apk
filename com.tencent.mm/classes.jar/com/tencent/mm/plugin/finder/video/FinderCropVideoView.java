package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import d.a.j;
import d.g.a.b;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderCropVideoView;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getCurrentPlaySecond", "", "getIsNeverStart", "", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "initView", "", "isPreviewing", "layoutId", "onMediaInfoAndMatrixPrepared", "onRelease", "prepareToPlay", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIsShouldPlayResume", "shouldPlayResume", "setPreview", "isPreview", "setRootMatrix", "matrix", "Landroid/graphics/Matrix;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "videoPlayLifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "plugin-finder_release"})
public final class FinderCropVideoView
  extends FinderVideoView
  implements o
{
  private CropLayout sQu;
  
  public FinderCropVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FinderCropVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(m paramm, boolean paramBoolean, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(205215);
    d.g.b.p.h(paramm, "video");
    d.g.b.p.h(paramFinderItem, "finderItem");
    d.g.b.p.h(paramm, "video");
    d.g.b.p.h(paramFinderItem, "finderItem");
    if (paramBoolean)
    {
      Object localObject2 = paramm.srx.url;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str = paramm.aeM();
      localObject2 = paramm.srx.stz;
      if (localObject2 != null) {}
      for (localObject2 = ((bwj)localObject2).Hjo;; localObject2 = null)
      {
        this.tbp = ((atk)localObject2);
        super.a("", (String)localObject1, str, null, paramm, paramFinderItem);
        AppMethodBeat.o(205215);
        return;
      }
    }
    super.a(paramm.getUrl(), paramm.getPath(), paramm.aeM(), paramm.srx, paramm, paramFinderItem);
    AppMethodBeat.o(205215);
  }
  
  public final boolean cOA()
  {
    return false;
  }
  
  public final boolean cOB()
  {
    AppMethodBeat.i(205220);
    boolean bool = get_isPreviewing();
    AppMethodBeat.o(205220);
    return bool;
  }
  
  public final int cOC()
  {
    return 2131493937;
  }
  
  public final void cOD()
  {
    AppMethodBeat.i(168002);
    Object localObject1 = this.sQu;
    if (localObject1 == null) {
      d.g.b.p.bdF("cropLayout");
    }
    ((CropLayout)localObject1).reset();
    Object localObject2 = getVideoMatrix();
    if (localObject2 != null)
    {
      if (((atk)localObject2).GKl.size() == 9)
      {
        localObject1 = new Matrix();
        localObject2 = ((atk)localObject2).GKl;
        d.g.b.p.g(localObject2, "it.value");
        ((Matrix)localObject1).setValues(j.q((Collection)localObject2));
        setRootMatrix((Matrix)localObject1);
      }
      AppMethodBeat.o(168002);
      return;
    }
    AppMethodBeat.o(168002);
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(205221);
    int i = getCurrPosSec();
    AppMethodBeat.o(205221);
    return i;
  }
  
  public final boolean getIsNeverStart()
  {
    return this.sZO;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.sZn;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(205223);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(205223);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(205222);
    int i = getVideoDurationSec();
    AppMethodBeat.o(205222);
    return i;
  }
  
  public final p getVideoMediaInfo()
  {
    AppMethodBeat.i(205216);
    p localp = getMediaInfo();
    AppMethodBeat.o(205216);
    return localp;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.sZm;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(168001);
    super.initView();
    Object localObject = findViewById(2131299987);
    d.g.b.p.g(localObject, "findViewById(R.id.finder_crop_layout)");
    this.sQu = ((CropLayout)localObject);
    localObject = this.sQu;
    if (localObject == null) {
      d.g.b.p.bdF("cropLayout");
    }
    ((CropLayout)localObject).setEnableTouch(false);
    localObject = this.sQu;
    if (localObject == null) {
      d.g.b.p.bdF("cropLayout");
    }
    ((CropLayout)localObject).setEnableScale(false);
    localObject = this.sQu;
    if (localObject == null) {
      d.g.b.p.bdF("cropLayout");
    }
    ((CropLayout)localObject).setEnableFling(false);
    localObject = this.sQu;
    if (localObject == null) {
      d.g.b.p.bdF("cropLayout");
    }
    ((CropLayout)localObject).setEnableOverScroll(false);
    AppMethodBeat.o(168001);
  }
  
  public final void onRelease() {}
  
  public final void setFinderVideoCore(i parami)
  {
    AppMethodBeat.i(205212);
    setVideoCore(parami);
    AppMethodBeat.o(205212);
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(205217);
    setShouldPlayResume(paramBoolean);
    AppMethodBeat.o(205217);
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(205219);
    set_isPreviewing(paramBoolean);
    AppMethodBeat.o(205219);
  }
  
  public final void setRootMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(168003);
    d.g.b.p.h(paramMatrix, "matrix");
    if (getMediaInfo() == null)
    {
      AppMethodBeat.o(168003);
      return;
    }
    Object localObject = c.ubl;
    localObject = getMediaInfo();
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    localObject = c.ajS(((p)localObject).path);
    paramMatrix = new Matrix(paramMatrix);
    CropLayout localCropLayout = this.sQu;
    if (localCropLayout == null) {
      d.g.b.p.bdF("cropLayout");
    }
    RelativeLayout localRelativeLayout = this.lxA;
    d.g.b.p.g(localRelativeLayout, "videoRoot");
    localCropLayout.a((View)localRelativeLayout, ((a)localObject).width, ((a)localObject).height, new Matrix(), CropLayout.e.LrL, (b)new FinderCropVideoView.a(paramMatrix));
    AppMethodBeat.o(168003);
  }
  
  public final void setVideoMuteListener(q paramq)
  {
    AppMethodBeat.i(205213);
    d.g.b.p.h(paramq, "onMuteListener");
    setMuteListener(paramq);
    AppMethodBeat.o(205213);
  }
  
  public final void setVideoPlayLifecycle(u paramu)
  {
    AppMethodBeat.i(205214);
    d.g.b.p.h(paramu, "videoPlayLifecycle");
    setLifecycle(paramu);
    AppMethodBeat.o(205214);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(205218);
    setViewFocused(paramBoolean);
    AppMethodBeat.o(205218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderCropVideoView
 * JD-Core Version:    0.7.0.1
 */