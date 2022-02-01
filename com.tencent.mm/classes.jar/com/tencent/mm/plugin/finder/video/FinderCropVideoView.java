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
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import d.a.j;
import d.g.a.b;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderCropVideoView;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getCurrentPlaySecond", "", "getIsNeverStart", "", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "initView", "", "isPreviewing", "layoutId", "onMediaInfoAndMatrixPrepared", "onRelease", "prepareToPlay", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIsShouldPlayResume", "shouldPlayResume", "setPreview", "isPreview", "setRootMatrix", "matrix", "Landroid/graphics/Matrix;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "videoPlayLifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "plugin-finder_release"})
public final class FinderCropVideoView
  extends FinderVideoView
  implements o
{
  private CropLayout sFv;
  
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
    AppMethodBeat.i(204591);
    d.g.b.p.h(paramm, "video");
    d.g.b.p.h(paramFinderItem, "finderItem");
    d.g.b.p.h(paramm, "video");
    d.g.b.p.h(paramFinderItem, "finderItem");
    if (paramBoolean)
    {
      String str1 = paramm.siC.url;
      d.g.b.p.g(str1, "video.mediaObj.url");
      String str2 = paramm.aeA();
      Object localObject = paramm.siC.skC;
      if (localObject != null) {}
      for (localObject = ((bvp)localObject).GPM;; localObject = null)
      {
        this.sQe = ((asu)localObject);
        super.a("", str1, str2, null, paramm, paramFinderItem);
        AppMethodBeat.o(204591);
        return;
      }
    }
    super.a(paramm.getUrl(), paramm.getPath(), paramm.aeA(), paramm.siC, paramm, paramFinderItem);
    AppMethodBeat.o(204591);
  }
  
  public final boolean cLS()
  {
    return false;
  }
  
  public final boolean cLT()
  {
    AppMethodBeat.i(204596);
    boolean bool = get_isPreviewing();
    AppMethodBeat.o(204596);
    return bool;
  }
  
  public final int cLU()
  {
    return 2131493937;
  }
  
  public final void cLV()
  {
    AppMethodBeat.i(168002);
    Object localObject1 = this.sFv;
    if (localObject1 == null) {
      d.g.b.p.bcb("cropLayout");
    }
    ((CropLayout)localObject1).reset();
    Object localObject2 = getVideoMatrix();
    if (localObject2 != null)
    {
      if (((asu)localObject2).GqN.size() == 9)
      {
        localObject1 = new Matrix();
        localObject2 = ((asu)localObject2).GqN;
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
    AppMethodBeat.i(204597);
    int i = getCurrPosSec();
    AppMethodBeat.o(204597);
    return i;
  }
  
  public final boolean getIsNeverStart()
  {
    return this.sOD;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.sOc;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(204599);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(204599);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(204598);
    int i = getVideoDurationSec();
    AppMethodBeat.o(204598);
    return i;
  }
  
  public final p getVideoMediaInfo()
  {
    AppMethodBeat.i(204592);
    p localp = getMediaInfo();
    AppMethodBeat.o(204592);
    return localp;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.sOb;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(168001);
    super.initView();
    Object localObject = findViewById(2131299987);
    d.g.b.p.g(localObject, "findViewById(R.id.finder_crop_layout)");
    this.sFv = ((CropLayout)localObject);
    localObject = this.sFv;
    if (localObject == null) {
      d.g.b.p.bcb("cropLayout");
    }
    ((CropLayout)localObject).setEnableTouch(false);
    localObject = this.sFv;
    if (localObject == null) {
      d.g.b.p.bcb("cropLayout");
    }
    ((CropLayout)localObject).setEnableScale(false);
    localObject = this.sFv;
    if (localObject == null) {
      d.g.b.p.bcb("cropLayout");
    }
    ((CropLayout)localObject).setEnableFling(false);
    localObject = this.sFv;
    if (localObject == null) {
      d.g.b.p.bcb("cropLayout");
    }
    ((CropLayout)localObject).setEnableOverScroll(false);
    AppMethodBeat.o(168001);
  }
  
  public final void onRelease() {}
  
  public final void setFinderVideoCore(i parami)
  {
    AppMethodBeat.i(204588);
    setVideoCore(parami);
    AppMethodBeat.o(204588);
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(204593);
    setShouldPlayResume(paramBoolean);
    AppMethodBeat.o(204593);
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(204595);
    set_isPreviewing(paramBoolean);
    AppMethodBeat.o(204595);
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
    Object localObject = c.tQu;
    localObject = getMediaInfo();
    if (localObject == null) {
      d.g.b.p.gfZ();
    }
    localObject = c.aiV(((p)localObject).path);
    paramMatrix = new Matrix(paramMatrix);
    CropLayout localCropLayout = this.sFv;
    if (localCropLayout == null) {
      d.g.b.p.bcb("cropLayout");
    }
    RelativeLayout localRelativeLayout = this.ltb;
    d.g.b.p.g(localRelativeLayout, "videoRoot");
    localCropLayout.a((View)localRelativeLayout, ((a)localObject).width, ((a)localObject).height, new Matrix(), CropLayout.e.KVn, (b)new a(paramMatrix));
    AppMethodBeat.o(168003);
  }
  
  public final void setVideoMuteListener(q paramq)
  {
    AppMethodBeat.i(204589);
    d.g.b.p.h(paramq, "onMuteListener");
    setMuteListener(paramq);
    AppMethodBeat.o(204589);
  }
  
  public final void setVideoPlayLifecycle(u paramu)
  {
    AppMethodBeat.i(204590);
    d.g.b.p.h(paramu, "videoPlayLifecycle");
    setLifecycle(paramu);
    AppMethodBeat.o(204590);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(204594);
    setViewFocused(paramBoolean);
    AppMethodBeat.o(204594);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class a
    extends d.g.b.q
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